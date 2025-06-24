package gameserver;

public class Player {
    private String id;
    private String name;
    private int score;

    private Player() {}

    public String getId() { return id; }
    public String getName() { return name; }
    public int getScore() { return score; }

    public static class Builder {
        private Player player = new Player();

        public Builder setId(String id) {
            player.id = id;
            return this;
        }

        public Builder setName(String name) {
            player.name = name;
            return this;
        }

        public Builder setScore(int score) {
            player.score = score;
            return this;
        }

        public Player build() {
            return player;
        }
    }
}