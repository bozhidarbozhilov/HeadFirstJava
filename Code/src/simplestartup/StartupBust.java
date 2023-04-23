package simplestartup;

import java.util.ArrayList;

public class StartupBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList<>();
    private int numOfGuesses = 0;

    public void setUpGame(){
        Startup cabista = new Startup();
        cabista.setName("Cabista");
        Startup poniez = new Startup();
        poniez.setName("Poniez");
        Startup hacqi = new Startup();
        hacqi.setName("Hacqi");
        startups.add(cabista);
        startups.add(poniez);
        startups.add(hacqi);
        System.out.println("Your goal is to sink three Startups");
        System.out.println("poniez, hacqi, cabista");
        System.out.println("Try to sink them all in the fewest number of guesses");
        for(Startup startup : startups){
            ArrayList<String> place = helper.placeStartup(3);
            startup.setLocationCells(place);
        }
    }
    public void startPlaying(){
        while(!startups.isEmpty()){
            String userInput = helper.getUserInput("Enter a guess ");
            checkUserGuess(userInput);
        }
        finishGame();
    }

    private void checkUserGuess(String userInput) {
        numOfGuesses += 1;
        String result = "miss";
        for(Startup startup:startups){
            result = startup.checkYourself(userInput);
            if(result.equals("hit")){
                break;
            }
            if(result.equals("kill")){
                startups.remove(startup);
                break;
            }

        }
        System.out.println(result);
    }
    private void finishGame(){
        System.out.println("All startups are dead! Your stock is now worthless");

        if(numOfGuesses<=18){
            System.out.println("It only took " + numOfGuesses + " guesses");
            System.out.println("You got out before your options sank");
        }else{
            System.out.println("Took you long enough. " + numOfGuesses + " guesses");
            System.out.println("Fish are dancing with your options.");
        }
    }

    public static void main(String[] args) {
        StartupBust game = new StartupBust();
        game.setUpGame();
        game.startPlaying();
    }
}
