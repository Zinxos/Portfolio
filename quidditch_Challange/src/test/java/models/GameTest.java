package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game turnament;

    @BeforeEach
    public void beforeTest(){
        turnament = new Game(new Team("GRYFFINDOR", "Oliver", "Harry",
                new String[] {"Angelina", "Ginny", "Katie"}),new Team("SLYTHERIN", "Vincent",  "Draco",
                new String[] {"Bridget", "Harper", "Malcolm"}));
    }

    @Test
    public void getPlaceholderTest(){
        assertEquals("chaser", turnament.getPlaceholder("<chaser> starts with the quaffle, speeds off towards the goal posts, and scores! 10 points!"));
    }

    @Test
    public void replacePlaceholderTest(){
        assertEquals("Katie gets the next pass", turnament.replacePlaceholder("<chaser> gets the next pass","chaser","Katie"));
    }

    @Test
    public void quaffleScoreTest(){
        turnament.quaffleScore(turnament.getTeam("GRYFFINDOR"));
        turnament.quaffleScore(turnament.getTeam("GRYFFINDOR"));
        assertEquals(20,turnament.getScore(turnament.getTeam("GRYFFINDOR")));
    }
    @Test
    public void catchSnitchTest(){
        turnament.catchSnitch(turnament.getTeam("GRYFFINDOR"));
        assertEquals(150,turnament.getScore(turnament.getTeam("GRYFFINDOR")));
    }

}