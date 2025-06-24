package gameserver;

public class Main {
    public static void main(String[] args) {
        PlayerEventManager.subscribe(new PlayerEventListener() {
            public void onPlayerJoined(Player p) {
                System.out.println("👋 Player joined: " + p.getName());
            }

            public void onPlayerLeft(Player p) {
                System.out.println("👋 Player left: " + p.getName());
            }
        });

        GameServer.getInstance().start();
    }
}