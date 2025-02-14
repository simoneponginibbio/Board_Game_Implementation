package it.polimi.ingsw.model.character.impl;

import it.polimi.ingsw.model.IllegalMoveException;
import it.polimi.ingsw.model.Match;
import it.polimi.ingsw.model.Player;
import it.polimi.ingsw.model.character.Character;
import it.polimi.ingsw.model.character.NoParametersCharacter;

public class Character8 extends Character implements NoParametersCharacter {
    public Character8() {
        super(7, 2, "During the influence calculation this turn, you count as having 2 more influence.");
    }

    /**
     * Uses the ability: "During the influence calculation this turn, you count as having 2 more influence."
     * @param match Match
     * @param playerName The username of a player
     * @throws IllegalMoveException When there aren't any players with the given name.
     * When the given player doesn't have enough coins to play the character
     */
    public void use(Match match, String playerName) throws IllegalMoveException {
        Player player = match.getPlayerFromName(playerName);

        //Checks the coins of the player
        checkCost(player);

        //Sets 2 additional moves
        player.setAdditionalInfluence(2);

        player.removeCoins(cost);
        incrementCost();

        //Updates the state of game for the view
        match.updateView();
    }
}
