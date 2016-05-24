package net.roddy.rules;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target/cucumber_html/game/",
                            "json:target/json-game.json",
                            "junit:target/junit-game.xml"},
                 glue = {"net.roddy.rules" },
                 features = "src/test/resources/features/GameLogic.feature" )
public class GameLogicTest {
}