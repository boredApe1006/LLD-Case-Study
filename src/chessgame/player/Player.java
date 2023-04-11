package chessgame.player;

import chessgame.Move;

public abstract class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract Move makeMove();

    public String getName() {
        return name;
    }
}
