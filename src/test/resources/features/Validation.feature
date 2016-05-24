Feature: Validation

  Scenario Outline: Detect invalid characters in player move
    When the player throws "<move>"
    Then the throw is invalid because "Player move is not all lowercase."

    Scenarios:
      | move  |
      | ROCK  |
      | Rock  |
      | rock! |
      | 12345 |
      | !!!!! |
      | r0ck  |

  Scenario Outline: Detect illegal move
    When the player throws "<move>"
    Then the throw is invalid because "Player move is invalid: <move>"

    Scenarios:
      | move      |
      | frog      |
      | stone     |
      | notepaper |
      | knife     |
      | nuke      |
      | kirk      |
      | sarek     |

  Scenario Outline: Valid moves do not trigger validation
    When the player throws "<move>"
    Then the throw is valid

    Scenarios:
      | move     |
      | rock     |
      | paper    |
      | scissors |
      | lizard   |
      | spock    |
