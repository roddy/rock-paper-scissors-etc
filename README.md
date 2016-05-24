# Rock Paper Scissors
This is a programming exercise intended to create an extensible Rock-Paper-Scissors game that has its business logic encapsulated in a [JBoss Drools](http://www.drools.org/) business rules engine.

## Instructions

This is a Maven 3 project. To compile the project, run:

````
mvn package
````

To run the unit tests:

````
mvn test
````

This project currently has no "main" method -- eg no executable. The only way to "run" the logic is via the unit tests.

## Motivation


> "Scissors cuts paper, paper covers rock, rock crushes lizard, lizard poisons Spock, Spock smashes scissors, scissors decapitate lizard, lizard eats paper, paper disproves Spock, Spock vaporizes rock. And as it always has, rock crushes scissors."
> -- Dr. Sheldon Cooper

## Project description

At the time of writing, this project is using the latest libraries for its core components. Namely:

* cucumber-java 1.2.4
* cucumber-junit 1.2.4
* drools 6.4.0.Final
* junit 4.12
