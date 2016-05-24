package net.roddy.rps.assets;

/**
 * A Rock-Paper-Scissors-Etc player.
 *
 * @author Roddy <roddyofthefrozenpeas@gmail.com>
 * @since 5/24/2016
 **/
public class Player {

  /**
   * The player's move (throw.)
   **/
	private String myMove;

  /**
   * Sets the player's move.
   * @param myMove the player's move
   **/
	public void setMove(String myMove) {
		this.myMove = myMove;
	}

  /**
   * Returns the player's move. If the player's move has not yet been set, this
   * method will return null.
   * @return the player's move.
   **/
	public String getMove() {
		return myMove;
	}
}