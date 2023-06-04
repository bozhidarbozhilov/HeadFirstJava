package jugacademi.api;

import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws IOException {

    }

    public String getArticle(String title) {
        java.lang.StringBuffer result= new java.lang.StringBuffer();
        try{
            java.net.URL url = new java.net.URL("https://en.wikipedia.org/api/rest_v1/page/html/" + title);
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if(responseCode==java.net.HttpURLConnection.HTTP_OK){
                java.io.BufferedReader res = new java.io.BufferedReader(
                        new java.io.InputStreamReader(connection.getInputStream())
                );
                String line;
                while((line = res.readLine())!= null){
                    result.append(line);
                }
                res.close();
            }
        }catch (java.io.IOException ex){
            ex.printStackTrace();
        }
        return result.toString();
    }

    public long matrixSum(){
        java.util.Scanner scanner = new java.util.Scanner(java.lang.System.in);
        long result=0l;
        String line;
        for (int i = 0; i < 4; i++) {
            line = scanner.nextLine();
            long lineSum = java.util.Arrays.stream(line.split("\\s")).mapToLong(Long::parseLong).sum();
            result += lineSum;
        }
        return result;
    }

    public java.util.function.Function<Integer, java.math.BigInteger> degree(int n){
        return x-> java.math.BigInteger.valueOf(x).pow(n);
    }

    public static java.util.stream.IntStream numbers(java.util.List<String> items){
        return items.stream().filter(str -> str.matches("\\\\-?[0-9]+")).mapToInt(Integer::parseInt);
    }

    public static java.util.stream.Stream<FibNumber> fib(){
        return Stream.iterate(new FibNumber(BigInteger.ZERO, BigInteger.ONE),
                p -> new FibNumber(p.current, p.current.add(p.previous)));
    }
    static class FibNumber {
        public FibNumber(java.math.BigInteger previous, java.math.BigInteger current) {
            this.previous = previous;
            this.current = current;
        }
        private java.math.BigInteger previous;
        private java.math.BigInteger current;
        public java.math.BigInteger getPrevious() {
            return previous;
        }
        public java.math.BigInteger getCurrent() {
            return current;
        }
    }

}
