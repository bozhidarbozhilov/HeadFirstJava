package simplestartup;

public class SimpleStartupTestDrive {
    public static void main(String[] args) {
//        SimpleStartup dot = new SimpleStartup();
//
//        int[] locations = {2, 3, 4};
//        dot.setLocationCells(locations);
//
//        int userGuess = 2;
//        String result  = dot.checkYourself(userGuess);
//        String testResult = "failed";
//        if(result.equals("hit")){
//            testResult = "passed";
//        }
//        System.out.println(testResult);
        for(int i=0; i<4;i++){
            for (int j = 4;j>2;j--){
                System.out.println(i + " "+j);
            }
            if(i==1){
                i++;
            }
        }
    }
}

