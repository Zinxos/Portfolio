package models;

import org.junit.jupiter.api.Test;

import static models.Team.*;
import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    @Test
    public void hasItNull(){
        String[] chasers = new String[] {null, "Ginny", "Katie"};
        assertTrue(hasNull(chasers));

    }
    @Test
    public void  hasItBlank(){
        String[] chasers = new String[] {"", "Ginny", "Katie"};
        assertTrue(hasBlank(chasers));
    }

}