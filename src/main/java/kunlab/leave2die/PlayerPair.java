package kunlab.leave2die;

import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerPair {
    UUID player1;
    UUID player2;

    public PlayerPair(UUID player1, UUID player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
}
