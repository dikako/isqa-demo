package demo.data;

/**
 * Created by fransiskusandika 05/07/2022
 */
public class Chat {

    private static String chatMessage = "Test chat " + Data.randomNum;
    private static String chatEmoji;
    private static String username;
    private static String senderChat;
    private static String receiverChat;
    private static String senderUser;
    private static String receiverUser;
    private static String test;
    private static String test1;

    public static void setChatMessage(String chatMessage) {
        Chat.chatMessage = chatMessage;
    }

    public static String getChatMessage() {
        return chatMessage;
    }

    public static void setChatEmoji(String emoji) {
        Chat.chatEmoji = emoji;
    }

    public static String getChatEmoji() {
        return chatEmoji;
    }

    public static void setUsername(String username) {
        Chat.username = username;
    }

    public static String getUsername() {
        return username;
    }

    public static void setSenderChat(String senderChat) {
        Chat.senderChat = senderChat;
    }

    public static String getSenderChat() {
        return senderChat;
    }

    public static void setReceiverChat(String receiverChat) {
        Chat.receiverChat = receiverChat;
    }

    public static String getReceiverChat() {
        return receiverChat;
    }

    public static void setSenderUser(String senderUser) {
        Chat.senderUser = senderUser;
    }

    public static String getSenderUser() {
        return senderUser;
    }

    public static void setReceiverUser(String receiverUser) {
        Chat.receiverUser = receiverUser;
    }

    public static String getReceiverUser() {
        return receiverUser;
    }
}
