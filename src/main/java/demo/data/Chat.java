package demo.data;

/**
 * Created by fransiskusandika 05/07/2022
 */
public class ChatData {

    private static String chatMessage = "Test chat " + Data.randomNum;
    private static String chatEmoji;
    private static String username;
    private static String senderChat;
    private static String receiverChat;
    private static String senderUser;
    private static String receiverUser;
    private static String test;
    private static String tests;

    public static void setChatMessage(String chatMessage) {
        ChatData.chatMessage = chatMessage;
    }

    public static String getChatMessage() {
        return chatMessage;
    }

    public static void setChatEmoji(String emoji) {
        ChatData.chatEmoji = emoji;
    }

    public static String getChatEmoji() {
        return chatEmoji;
    }

    public static void setUsername(String username) {
        ChatData.username = username;
    }

    public static String getUsername() {
        return username;
    }

    public static void setSenderChat(String senderChat) {
        ChatData.senderChat = senderChat;
    }

    public static String getSenderChat() {
        return senderChat;
    }

    public static void setReceiverChat(String receiverChat) {
        ChatData.receiverChat = receiverChat;
    }

    public static String getReceiverChat() {
        return receiverChat;
    }

    public static void setSenderUser(String senderUser) {
        ChatData.senderUser = senderUser;
    }

    public static String getSenderUser() {
        return senderUser;
    }

    public static void setReceiverUser(String receiverUser) {
        ChatData.receiverUser = receiverUser;
    }

    public static String getReceiverUser() {
        return receiverUser;
    }
}
