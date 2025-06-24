package gameserver;

public interface PlayerEventListener {
    void onPlayerJoined(Player player);
    void onPlayerLeft(Player player);
}