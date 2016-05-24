package net.roddy.rps.assets;

/**
 * Models the outcome of a Rock-Paper-Scissors-Etc game.
 * @author Roddy <mailto:roddyofthefrozenpeas@gmail.com>
 * @since 5/24/2016
 **/
public class GameOutcome {

  private String winningThrow;
  private String verb;
  private String losingThrow;

  /** 
   * Sets the winning throw or action.
   * @param winningThrow the winning throw
   **/
  public void setWinningThrow(String winningThrow) {
    this.winningThrow = winningThrow;
  }

  /**
   * Returns the winning throw, or action.
   * @return the winning throw or action
   **/
  public String getWinningThrow() {
    return winningThrow;
  }

  /**
   * Sets the losing throw or action.
   * @param losingThrow the losing throw
   **/
  public void setLosingThrow(String losingThrow) {
    this.losingThrow = losingThrow;
  }

  /**
   * Returns the losing throw, or action.
   * @return the losing throw or action
   **/
  public String getLosingThrow() {
    return losingThrow;
  }

  /**
   * Sets the verb for the "win". For example, if the winning action "crushes"
   * its opponent, the verb will be "crushes."
   * @param verb the verb to set
   **/
  public void setVerb(String verb) {
    this.verb = verb;
  }

  /**
   * Returns the associated verb for the "win". If the win has not yet been 
   * calculated, the verb will be null.
   * @return the verb
   **/
  public String getVerb() {
    return verb;
  }
}