//package simplestartup;
//
//public class SimpleStartupGame {
//    public static void main(String[] args) {
//        int numOfGuesses = 0;
//        GameHelper helper = new GameHelper();
//
//        SimpleStartup theStartup = new SimpleStartup();
//        int randomInt = (int) (Math.random()*5);
//        int[] locations = {randomInt, randomInt+1, randomInt+2};
//        theStartup.setLocationCells(locations);
//        boolean isAlive = true;
//
//        while(isAlive){
//            int guess = helper.getUserInput("enter a number");
//            String result = theStartup.checkYourself(guess);
//            numOfGuesses++;
//            if(result.equals("kill")){
//                isAlive = false;
//                System.out.println("You took " + numOfGuesses + " guesses");
//            }
//        }
//
//    }
//}
