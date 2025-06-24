package gameserver;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            Player player = new Player.Builder()
                .setId(socket.getInetAddress().toString())
                .setName("Player_" + socket.getPort())
                .setScore(0)
                .build();

            PlayerEventManager.playerJoined(player);

            String input;
            while ((input = in.readLine()) != null) {
                Command command = new MoveCommand(player, input);
                command.execute();
            }

        } catch (IOException e) {
            System.out.println("❌ Client disconnected: " + socket.getInetAddress());
        }
    }
}