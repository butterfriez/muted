package com.github.butterfriez.muted.Networking;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

import java.net.URI;
import java.util.Objects;

public class MutedClient extends WebSocketClient {
    public MutedClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Connected to server");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("Received: " + message);
        JSONObject parsedMessage = new JSONObject(message);
        JSONObject messageData = new JSONObject(parsedMessage.getString("data"));
        String room = parsedMessage.getString("room");
        room = Objects.equals(room, "") ? "All" : room;
        ChatComponentText chatComponent = new ChatComponentText( messageData.getString("username") + "§8:§f " + messageData.getString("message") + "§8[§b" + room + "§8]:§f ");

        Minecraft.getMinecraft().thePlayer.addChatMessage(chatComponent);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("Close: " + code + " " + reason + " " + remote);
    }

    @Override
    public void onError(Exception ex) {
        System.out.println("Error: " + ex.getMessage());
    }

    @Override
    public void send(String text) {
        super.send(text);
    }
}
