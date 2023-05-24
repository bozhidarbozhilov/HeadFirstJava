package jugacademi.datastructures;

import java.util.stream.Collectors;

public class DataStructures {
    public static void main(String[] args){
        DataStructures dt = new DataStructures();
        int[] numbers = {2,3,4};
        System.out.println(dt.findSum(numbers,10).length);
    }
    public java.util.List<Integer> removeNegatives(java.util.List<Integer> numbers){
        return numbers.stream().filter(e->e>=0).collect(java.util.stream.Collectors.toList());
    }

    public int[] findSum(int[] numbers, int n){
        int[] result = new int[2];
        boolean sumFound = false;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(numbers[i] + numbers[j] == n){
                    result[0] = numbers[i];
                    result[1] = numbers[j];
                    sumFound = true;
                    break;
                }
            }
            if(sumFound){
                break;
            }
        }
        if(!sumFound){
            return new int[0];
        }
        return result;
    }
}
