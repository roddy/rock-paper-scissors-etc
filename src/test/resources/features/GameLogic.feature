Feature: Game Logic

  Scenario Outline: Two throws of the same type are a tie
    When the players throw <throw> and <throw>
    Then the result should be <throw> ties <throw>
    Scenarios:
      | throw    | 
      | rock     |
      | paper    | 
      | scissors | 
      | lizard   | 
      | spock    | 

  Scenario Outline: Validate game logic
    When the players throw <throw 1> and <throw 2>
    Then the result should be <throw 1> <verb> <throw 2>
    Scenarios:
      | throw 1  | verb       | throw 2  |
      | scissors | cut        | paper    |
      | paper    | covers     | rock     |
      | rock     | crushes    | lizard   |
      | lizard   | poisons    | spock    |
      | spock    | smashes    | scissors |
      | scissors | decapitate | lizard   |
      | lizard   | eats       | paper    |
      | paper    | disproves  | spock    |
      | spock    | vaporizes  | rock     |
      | rock     | crushes    | scissors |

   Scenario Outline: Validate game logic - reverse order
    When the players throw <throw 2> and <throw 1>
    Then the result should be <throw 1> <verb> <throw 2>
    Scenarios:
      | throw 1  | verb       | throw 2  |
      | scissors | cut        | paper    |
      | paper    | covers     | rock     |
      | rock     | crushes    | lizard   |
      | lizard   | poisons    | spock    |
      | spock    | smashes    | scissors |
      | scissors | decapitate | lizard   |
      | lizard   | eats       | paper    |
      | paper    | disproves  | spock    |
      | spock    | vaporizes  | rock     |
      | rock     | crushes    | scissors |
 