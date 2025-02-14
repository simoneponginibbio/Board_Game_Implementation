package it.polimi.ingsw.model.character.impl;

import it.polimi.ingsw.model.*;
import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

public class Character3Test extends TestCase {
    @Test
    public void useTest() throws IllegalMoveException {
        Player player1 = new Player("test1", TowerColor.WHITE, Wizard.BLUE);
        Player player2 = new Player("test2", TowerColor.BLACK, Wizard.GREEN);
        Team team1 = new Team(List.of(player1), TowerColor.WHITE);
        Team team2 = new Team(List.of(player2), TowerColor.BLACK);
        Match match = new Match(List.of(team1, team2), List.of(player1, player2), true);
        player1.addCoin();
        player1.addCoin();
        Character3 character = new Character3();

        Exception e = assertThrows(IllegalMoveException.class, () -> character.use(match, player1.getName(), 13));
        Assertions.assertEquals("Island must be between 1 and " + match.getIslands().size(), e.getMessage());

        int posMotherNature = match.getPosMotherNature();
        character.use(match, player1.getName(), 0);
        Assertions.assertEquals(match.getPosMotherNature(), posMotherNature);
    }
}
