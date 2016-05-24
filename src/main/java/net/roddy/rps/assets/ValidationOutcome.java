package net.roddy.rps.assets;

import java.util.ArrayList;
import java.util.List;

/**
 * The results of validating a player's move.
 *
 * @author Roddy <roddyofthefrozenpeas@gmail.com>
 * @since 5/24/2016
 **/
public class ValidationOutcome {

  private boolean isValid;
  private List<String> errors;

  public ValidationOutcome() {
    this.isValid = true;
    this.errors = new ArrayList<>();
  }

  /**
   * Sets the validity boolean state.
   * @param isValid sets valid state
   **/
  public void setValid(boolean isValid) {
    this.isValid = isValid;
  }

  /**
   * Returns true if the validation was successful. If the validation was not 
   * run, the default state of this field is true.
   * @return true if valid or validation not run, false otherwise
   **/
  public boolean isValid() {
    return this.isValid;
  }

  /**
   * Add a validation message.
   * @param error the validation message to add
   **/
  public void addValidationError(String error) {
    this.errors.add(error);
  }

  /**
   * Returns all validation messages.
   * @return all validation messages
   **/
  public List<String> getValidationErrors() {
    return new ArrayList<>(errors);
  }
}