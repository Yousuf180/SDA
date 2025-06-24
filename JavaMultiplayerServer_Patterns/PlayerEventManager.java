package gameserver;

import java.util.ArrayList;
import java.util.List;

public class PlayerEventManager {
    private static List<PlayerEventListener> listeners = new ArrayList<>();

    public static void subscribe(PlayerEventListener listener) {
        listeners.add(listener);
    }

    public static void playerJoined(Player player) {
        for (PlayerEventListener listener : listeners) {
            listener.onPlayerJoined(player);
        }
    }

    public static void playerLeft(Player player) {
        for (PlayerEventListener listener : listeners) {
            listener.onPlayerLeft(player);
        }
    }
}