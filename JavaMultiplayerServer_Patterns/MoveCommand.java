package gameserver;

public class MoveCommand implements Command {
    private Player player;
    private String direction;

    public MoveCommand(Player player, String direction) {
        this.player = player;
        this.direction = direction;
    }

    public void execute() {
        System.out.println("🚶 " + player.getName() + " moves " + direction);
    }
}