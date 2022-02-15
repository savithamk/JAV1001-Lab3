/**
 * Name: Savitha Maiya Keshava
 * Student Number: A00241065
 * Description: This program facilitates creation of a die and rolling
 */

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Die {
    private String name;
    private int numberOfSides;
    private int currentSideUp;

    //Zero argument constructor
    public Die(){
        this.name = "d6";
        this.numberOfSides = 6;
        System.out.println("Creating a default "+name+"...");
        roll();
    }

    //One argument constructor
    public Die(int numberOfSides){
        this.name = "d" + numberOfSides;
        this.numberOfSides = numberOfSides;
        System.out.println("Creating a "+name+"...");
        roll();
    }

    //Two arguments constructor
    public Die(String name, int numberOfSides){
        this.name = numberOfSides == 10 ? "Percentile" : name;
        this.numberOfSides = numberOfSides;
        if(numberOfSides == 10) {
            System.out.println("Creating " + name + " die (a special d10)...");
        } else{
            System.out.println("Creating a "+name+"...");
        }
        roll();
    }

    //To get the name of the die
    public String getName() {
        return name;
    }

    //To set the name of the die
    public void setName(String name) {
        this.name = name;
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(name);
        if(m.find()) {
            this.numberOfSides = Integer.parseInt(m.group());
        }
    }

    //To get the number of sides of the die
    public int getNumberOfSides() {
        return numberOfSides;
    }

    //To set the number of sides of the die
    public void setNumberOfSides(int numberOfSides) {
        this.name = "d" + numberOfSides;
        this.numberOfSides = numberOfSides;
    }

    //To roll a die and get a new value
    public void roll(){
        Random rd = new Random();
        currentSideUp = rd.nextInt(this.numberOfSides+1);
    }

    //To roll a die until to get its maximum value
    public void rollToGetMaximum(){
        System.out.println("Setting the " +name +" to show "+numberOfSides+"...");
        while (currentSideUp!=numberOfSides){
            roll();
        }
        System.out.println("The side up is now "+currentSideUp+". Finally.");
    }

    public static void main(String args[]){
        Die d6 = new Die();
        Die d20 = new Die(20);
        Die percentile = new Die("percentile",10);
        System.out.println("The current  up for "+d6.name+" is: " +d6.currentSideUp);
        System.out.println("The current  up for "+d20.name+" is: " +d20.currentSideUp);
        System.out.println("The current  up for "+percentile.name+" is: " +percentile.currentSideUp);
        System.out.println("\nTesting the roll method\n");
        d6.roll();
        d20.roll();
        percentile.roll();
        System.out.println("Rolling the "+ d6.getName()+"...");
        System.out.println("The new value is "+d6.currentSideUp);
        System.out.println("Rolling the "+ d20.getName()+"...");
        System.out.println("The new value is "+d20.currentSideUp);
        System.out.println("Rolling the "+ percentile.getName()+"...");
        System.out.println("The new value is "+percentile.currentSideUp);

        d20.rollToGetMaximum();

        rollFiveDice();

    }

    //To roll 5 six-sided dice in a loop until all the dies have same side of.
    public static void rollFiveDice(){
        System.out.println("Creating 5 d6...");
        Die d1 = new Die();
        Die d2 = new Die();
        Die d3 = new Die();
        Die d4 = new Die();
        Die d5 = new Die();

        int totalRolls = 0;

        while(!(d1.currentSideUp == d2.currentSideUp && d2.currentSideUp == d3.currentSideUp && d3.currentSideUp == d4.currentSideUp && d4.currentSideUp == d5.currentSideUp)){
            d1.roll();
            d2.roll();
            d3.roll();
            d4.roll();
            d5.roll();
            totalRolls++;
        }
        System.out.println("YAHTZEE! It took "+totalRolls+" rolls");
    }
}
