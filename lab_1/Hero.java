package Lab1;

public class Hero {
    private Movement movement;
    private String name;

    public Hero(){
        name = "nameless";
    }
    public Hero(Movement movement){
        this.movement = movement;
        name = "nameless";
    }
    public Hero(String name){
        this.name = name;
    }
    public Hero(Movement movement,String name){
        this.movement = movement;
        this.name = name;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }
    public Movement getMovement() {
        return movement;
    }
    public String getName() {
        return name;
    }
    public void move(){
        movement.move();
    }
}