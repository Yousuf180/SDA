package gameserver;

import java.io.*;
import java.net.*;
import java.util.*;

public class GameServer {
    private static GameServer instance;
    private ServerSocket serverSocket;
    private static final int PORT = 5555;

    private GameServer() {}

    public static GameServer getInstance() {
        if (instance == null) {
            instance = new GameServer();
        }
        return instance;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("🟢 Server started on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler client = ClientFactory.createClient(socket);
                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}