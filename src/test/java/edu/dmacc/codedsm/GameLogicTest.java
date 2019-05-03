package edu.dmacc.codedsm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameLogicTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void isVictoriousHasScoreOf10000() {
        StubGameRunner stubGameRunner = new StubGameRunner() {
            @Override
            public boolean isVictorious() {
                return true;
            }
        };
        GameLogic gameLogic = new GameLogic(stubGameRunner); //new gamelogic
        GameResult gameResult = gameLogic.runGame("Tammy");  //call the method that you want to test
        assertEquals(10000, gameResult.getScore().intValue()); //assert what you are testing score
    }

    @Test
    public void buildResult() {

    }

    @Test
    public void isDefeatedHasScoreOf100() {
        StubGameRunner stubGameRunner = new StubGameRunner() {
            @Override
            public boolean isDefeated() {
                return true;
            }
        };
        GameLogic gameLogic = new GameLogic(stubGameRunner);
        GameResult gameResult = gameLogic.runGame("Paige");
        assertEquals(100, gameResult.getScore().intValue());
    }

    @Test
    public void playerName() {
        StubGameRunner stubGameRunner = new StubGameRunner() {
            @Override
            public boolean isDefeated() {
                return true;
            }
        };
        GameLogic gameLogic = new GameLogic(stubGameRunner);
        GameResult gameResult = gameLogic.runGame("Kelly");
        assertEquals("Kelly", gameResult.getPlayer());
    }

    private class StubGameRunner implements GameRunner {   //had to create since we did not have class that implements

        public boolean isVictorious() {
            return false;
        }

        public boolean isDefeated() {
            return false;
        }
    }
}