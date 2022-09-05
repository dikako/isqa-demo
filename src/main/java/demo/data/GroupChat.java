package demo.data;

public class GroupChat {

    private static String invitationLink;
    private static String resetInvitationLink;
    private static String groupChatName;
    private static String groupChatMessage = "Test chat " + Data.randomNum;
    private static String groupChatEmoji;
    private static String groupChatDescription;
    private static int numberOfSuggestion;

    public static void setInvitationLink(String invitationLink) {
        GroupChat.invitationLink = invitationLink;
    }

    public static String getInvitationLink() {
        return invitationLink;
    }

    public static void setResetInvitationLink(String resetInvitationLink) {
        GroupChat.resetInvitationLink = resetInvitationLink;
    }

    public static String getResetInvitationLink() {
        return resetInvitationLink;
    }

    public static void setGroupChatName(String groupChatName) {
        GroupChat.groupChatName = groupChatName;
    }

    public static String getGroupChatName() {
        return groupChatName;
    }

    public static void setGroupChatMessage(String currentMessage) {
        GroupChat.groupChatMessage = currentMessage;
    }

    public static String getGroupChatMessage() {
        return groupChatMessage;
    }

    public static void setGroupChatEmoji(String emoji) {
        GroupChat.groupChatEmoji = emoji;
    }

    public static String getGroupChatEmoji() {
        return groupChatEmoji;
    }

    public static void setGroupChatDescription(String groupChatDescription) {
        GroupChat.groupChatDescription = groupChatDescription;
    }

    public static String getGroupChatDescription() {
        return groupChatDescription;
    }

    public static void setNumberOfSuggestion(int numberOfSuggestion) {
        GroupChat.numberOfSuggestion = numberOfSuggestion;
    }

    public static int getNumberOfSuggestion() {
        return numberOfSuggestion;
    }
}
