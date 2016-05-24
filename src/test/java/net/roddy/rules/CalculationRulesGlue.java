package net.roddy.rules;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.roddy.rps.assets.GameOutcome;
import net.roddy.rps.assets.Player;
import net.roddy.rps.utilities.DrlUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CalculationRulesGlue {
	private static final Logger logger = LoggerFactory.getLogger(CalculationRulesGlue.class);

  /**
   * The rules scope we are dealing with in this test.
   */
  private static final String SCOPE = "game";

  private GameOutcome outcome;
  private Player player1;
  private Player player2;

  @Before
  public void initializeScenario() {
    this.outcome = null;
    this.player1 = new Player();
    this.player2 = new Player();
  }

  @When("^the players throw (.*) and (.*)$")
  public void setThrows(String throw1, String throw2) {
    player1.setMove(throw1);
    player2.setMove(throw2);
  }

  @Then("^the result should be (.*) (.*) (.*)$")
  public void validateResult(String winner, String verb, String loser) throws Exception {
    fireRules();

    assertEquals(winner, outcome.getWinningThrow());
    assertEquals(verb, outcome.getVerb());
    assertEquals(loser, outcome.getLosingThrow());
  }

  /**
   * Flag indicating if the rules have been fired. If they've been previously fired, we don't want to fire them again
   * because that may invalidate our test results.
   */
  private AtomicBoolean isRulesFired = new AtomicBoolean(false);

  /**
   * Fires the rules using the spaceshipUnderTest as the input. The rules are only fired if they've not been fired
   * previously (eg we'll only fire once), so it is safe to call this method multiple times.
   * <p>
   * Once the rules are fired, we assert that the result object is actually populated as it should have been.
   *
   * @throws Exception if something goes wrong while firing the rules
   */
  public void fireRules() throws Exception {
    if(isRulesFired.compareAndSet(false, true)) {
      this.outcome = new GameOutcome();
      List<Object> ruleInputs = new ArrayList<>();
      ruleInputs.add(player1);
      ruleInputs.add(player2);
      DrlUtilities.fireRulesForScope(SCOPE, ruleInputs, "outcome", this.outcome);
    }
    assertNotNull(this.outcome);
  }

}