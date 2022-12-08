package models;

import java.util.HashMap;

import static models.Team.*;

public class Game {

    private static int gameCount;
    private static final int QUAFFLE_POINTS = 10;
    private static final int SNITCH_POINTS = 150;
    private HashMap<Team,Integer> scoreboard;

    public Game (Team teamHome, Team teamAway){
        this.scoreboard = new HashMap<>();
        this.scoreboard.put(new Team(teamHome),0);
        this.scoreboard.put(new Team(teamAway),0);
        gameCount++;
    }

    public Integer getScore(Team team){
        return this.scoreboard.get(team);
    }

    public void setScore(Integer score,Team team){
        if(score<=0){
            throw new IllegalArgumentException("score cannot be less or equal 0");
        }
        if(team==null){
            throw new IllegalArgumentException("team cannot be null");
        }
        this.scoreboard.put(team,score);
    }

    public Team getTeam(String teamName){
        return scoreboard.keySet().stream().filter((key)-> key.getHouse().equals(teamName)).findFirst().orElse(null);
    }
    public String getPlaceholder(String play){
       return play.substring(play.indexOf("<")+1,play.indexOf(">"));
    }
    public String replacePlaceholder(String play,String placeholder,String value){
       return play.replace("<"+placeholder+">",value);
    }
    public void quaffleScore(Team team){
        setScore(QUAFFLE_POINTS+getScore(team),team);
    }
    public void catchSnitch(Team team){
        setScore(SNITCH_POINTS+getScore(team),team);
    }
    public Team getRandomTeam(){
        Object[] teams = scoreboard.keySet().toArray();
        return (Team) teams[randomNumber(teams.length)];
    }
    public String simulate(String play){
        String placeholder = getPlaceholder(play);
        Team team = getRandomTeam();
        String value = null;
        if(placeholder.equals(Team.getPositionChaser())){
            quaffleScore(team);
             value = team.getChasers()[randomNumber(team.getChasers().length)];
        } else if (placeholder.equals(Team.getPositionSeeker())) {
            catchSnitch(team);
             value = team.getSeeker();
        } else if (placeholder.equals(Team.getPositionKeeper())) {
             value = team.getKeeper();
        }else{
            return null;
        }
        return replacePlaceholder(play,placeholder,value);
    }


    public int randomNumber(int range){
        return (int) ((Math.random() * (range)));
    }



}
