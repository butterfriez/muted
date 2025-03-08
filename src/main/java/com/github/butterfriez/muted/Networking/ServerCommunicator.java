package com.github.butterfriez.muted.Networking;

import java.net.URI;
import java.util.UUID;

import com.mojang.authlib.exceptions.AuthenticationException;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

public class ServerCommunicator {
    private String roomString;
    private MutedClient socketClient;
    private final URI serverURI;

    public ServerCommunicator() {
        String serverId = UUID.randomUUID().toString();
        Session session = Minecraft.getMinecraft().getSession();
        String username = session.getUsername();

        try {
            this.serverURI = new URI("wss://muted-websocket-4542672775.us-central1.run.app/ws");
        } catch (java.net.URISyntaxException e) {
            throw new RuntimeException("Invalid URI provided", e);
        }

        socketClient = new MutedClient(serverURI);
        socketClient.addHeader("x-auth-username", username);
        socketClient.addHeader("x-auth-serverId", serverId);
        socketClient.addHeader("x-auth-room", "");
        try {
            Minecraft.getMinecraft().getSessionService().joinServer(session.getProfile(), session.getToken(), serverId);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }

        socketClient.connect();
    }

    public String getRoomString() {
        return roomString;
    }

    public void setRoomString(String roomString) {
        this.roomString = roomString;
        String serverId = UUID.randomUUID().toString();
        Session session = Minecraft.getMinecraft().getSession();
        String username = session.getUsername();

        this.socketClient.close();
        socketClient = new MutedClient(this.serverURI);
        socketClient.addHeader("x-auth-username", username);
        socketClient.addHeader("x-auth-serverId", serverId);
        socketClient.addHeader("x-auth-room", roomString);
        try {
            Minecraft.getMinecraft().getSessionService().joinServer(session.getProfile(), session.getToken(), serverId);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }

        socketClient.connect(); // yes im that fucking lazy
    }

    public void send(String message) {
        this.socketClient.send(message);
    }
}
