package net.roddy.rules;

import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.roddy.rps.assets.ValidationOutcome;
import net.roddy.rps.assets.Player;
import net.roddy.rps.utilities.DrlUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ValidationRulesGlue {
  private static final Logger logger = LoggerFactory.getLogger(ValidationRulesGlue.class);

  /**
   * The rules scope we are dealing with in this test.
   */
  private static final String SCOPE = "validation";

  private ValidationOutcome outcome;
  private Player player;

  @Before
  public void initializeScenario() {
    this.outcome = null;
    this.player = new Player();
  }

  @When("^the player throws \"(.*)\"$")
  public void setThrows(String throw1) {
    player.setMove(throw1);
  }

  @Then("^the throw is invalid because \"(.*)\"$")
  public void validateResult(String reason) throws Exception {
    fireRules();

    assertFalse(outcome.isValid());
    List<String> errors = outcome.getValidationErrors();
    assertTrue(errors.contains(reason));
  }

  @Then("^the throw is valid$")
  public void validateResult() throws Exception {
    fireRules();

    assertTrue(outcome.isValid());
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
      this.outcome = new ValidationOutcome();
      List<Object> ruleInputs = new ArrayList<>();
      ruleInputs.add(player);
      DrlUtilities.fireRulesForScope(SCOPE, ruleInputs, "outcome", this.outcome);
    }
    assertNotNull(this.outcome);
  }

}