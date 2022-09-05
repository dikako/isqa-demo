#!/bin/bash
: '
  Created on 21/03/2022 fransiskusandika
  '
while getopts ":ix:ej:" option; do
    # shellcheck disable=SC2220
    case "${option}" in
        i) IMPORT=true ;;
        e) EXPORT=true ;;
        x) XRAY_TAG=${OPTARG} ;;
        j) JSON_NAME=${OPTARG} ;;
    esac
done
function get_xray_token() {
    token=$(curl -s -H "Content-Type: application/json" -X POST --data "{\"client_id\": \"$XRAY_CLIENT_ID\",\"client_secret\": \"$XRAY_CLIENT_SECRET\"}" "$XRAY_URL"/authenticate| tr -d '"')
}

function export_cucumber_test() {
    curl -s -o "$1".zip -H "Content-Type: application/json" -X GET -H "Authorization: Bearer $token" "$XRAY_URL/export/cucumber?keys=$1"
    mkdir -p xray
    unzip -o "$1".zip -d src/test/resources/features/
    mv "$1".zip xray/
}

function import_execution_results() {
    curl -s -H "Content-Type: application/json" -X POST -H "Authorization: Bearer $token" --data @"build/$JSON_NAME" "$XRAY_URL"/import/execution/cucumber > /dev/null
}

if [[ $EXPORT == true ]]; then
    if [[ $JSON_NAME == "" ]]; then
        echo "You forgot to pass Cucumber Json Report name!"
        exit 1
    fi
    get_xray_token
    import_execution_results
    echo "Execution Results has been exported to Xray!"
elif [[ $IMPORT == true ]]; then
    if [[ $XRAY_TAG != "" ]]; then
        get_xray_token
        if [[ $XRAY_TAG == *","* ]]; then
            IFS=',' read -r -a array <<< "$XRAY_TAG"
            for element in "${array[@]}"
            do
                echo "$element"
                export_cucumber_tests "$element"
                echo "Cucumber tests with key $element has been imported!"
            done
        else
            echo "$XRAY_TAG"
            export_cucumber_test "$XRAY_TAG"
            echo "Cucumber tests with key $XRAY_TAG has been imported!"
        fi
    else
        echo "You forgot to pass XRAY tag!"
        exit 1
    fi
else
    echo "You forgot to pass import / export flag!"
    exit 1
fi
