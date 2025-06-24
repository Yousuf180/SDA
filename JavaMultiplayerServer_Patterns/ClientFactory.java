package gameserver;

import java.net.Socket;

public class ClientFactory {
    public static ClientHandler createClient(Socket socket) {
        return new ClientHandler(socket);
    }
}