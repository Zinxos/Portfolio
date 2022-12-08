package models;

import java.util.Arrays;
import java.util.Objects;

public class Team {
    private String keeper;
    private String house;
    private String seeker;
    private String[] chasers;
    private static final String POSITION_CHASER= "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";
    public Team (String house, String keeper, String seeker, String[] chasers ){
        if(house.isBlank()|| keeper.isBlank()||seeker.isBlank())
        {
            throw new IllegalArgumentException("fields cannot be blank");
        }
        if(house == null|| keeper == null||seeker == null)
        {
            throw new IllegalArgumentException("fields cannot be null");
        }
        if(chasers.length!=3)
        {
            throw new IllegalArgumentException("chasers list should have exactly 3 positions");
        }
        if(hasNull(chasers)||hasBlank(chasers)){
            throw new IllegalArgumentException("any element of chasers cannot be blank or null");
        }
        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers =Arrays.copyOf(chasers,chasers.length);
    }
    public Team(Team source){
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = Arrays.copyOf(source.chasers,source.chasers.length);
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        checkParam(keeper);
        this.keeper = keeper;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        checkParam(house);
        this.house = house;
    }

    public String getSeeker() {
        return seeker;
    }


    public void setSeeker(String seeker) {
        checkParam(seeker);
        this.seeker = seeker;
    }

    public String[] getChasers() {
        return chasers;
    }

    public void setChasers(String[] chasers) {
        if(chasers.length!=3)
        {
            throw new IllegalArgumentException("chasers list should have exactly 3 positions");
        }
        if(hasNull(chasers)||hasBlank(chasers))
        {
            throw new IllegalArgumentException("any element of chasers cannot be blank or null");
        }
        this.chasers = chasers;
    }
    public void checkParam(String param) {
        if (param == null || param.isBlank()) {
            throw new IllegalArgumentException(param + " cannot be null or blank");
        }
    }
    public static String getPositionSeeker(){
        return POSITION_SEEKER;
    }

    public static String getPositionChaser(){
        return POSITION_CHASER;
    }

    public static String getPositionKeeper(){
        return POSITION_KEEPER;
    }
    @Override
    public int hashCode() {
        return Objects.hash(house, keeper, seeker,Arrays.toString(chasers));
    }
    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Team)){
            return false;
        }
        Team team = (Team)obj;
        return this.house.equals(team.house) &&
                this.keeper.equals(team.keeper) &&
                this.seeker.equals(team.seeker) &&
                Arrays.toString(this.chasers).equals(Arrays.toString(team.chasers));

    }
    public static boolean hasNull(String[] array){
        return Arrays.stream(array).anyMatch((player) -> player == null);
    }
    public static boolean hasBlank(String[] array){
        return Arrays.stream(array).anyMatch((player) -> player.isBlank());
    }
    @Override
    public String toString(){
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: "  + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }
}
