package jugacademi.api;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws IOException {

        Object test = new Object() {
            void x() {
                System.out.println("x");
            }

            void defaultMethod() {
                System.out.println("y");
            }
        };
        invokeDefault(test, "z");
    }

    public static void invokeDefault(Object object, String method) {
        try {
            java.util.List<java.lang.reflect.Method> methods = java.util.Arrays.stream(object.getClass().getDeclaredMethods()).toList();
            java.lang.reflect.Method mth = methods.stream().filter(m -> m.getName().equals(method)).findAny().orElse(null);
            java.lang.reflect.Method defaultMethod = methods.stream().filter(m -> m.getName().equals("defaultMethod")).findAny().orElse(null);

            if (mth != null) {
                mth.invoke(object);
            } else if (defaultMethod != null) {
                defaultMethod.invoke(object);
            }


        } catch (java.lang.Exception e) {
        }

    }

    public static int numberOfInstanceFields(Object object) {
        java.util.List<java.lang.reflect.Field> declaredFields = java.util.Arrays.stream(object.getClass().getDeclaredFields()).toList();
        java.util.List<java.lang.reflect.Field> allFields = new java.util.ArrayList<>(declaredFields);
        java.lang.Class current = object.getClass();
        java.util.List<java.lang.Class> allClasses = new java.util.ArrayList<>();
        while (current.getSuperclass() != null) {
            allClasses.add(current.getSuperclass());
            current = current.getSuperclass();
        }
        allClasses.stream().forEach(c -> allFields.addAll(java.util.Arrays.stream(c.getDeclaredFields()).toList()));
        allFields.stream().forEach(field -> System.out.println(field.toString()));
        return (int) allFields.stream().filter(f -> !(f.toString().contains("static"))).count();

    }

    public String getArticle(String title) {
        java.lang.StringBuffer result = new java.lang.StringBuffer();
        try {
            java.net.URL url = new java.net.URL("https://en.wikipedia.org/api/rest_v1/page/html/" + title);
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == java.net.HttpURLConnection.HTTP_OK) {
                java.io.BufferedReader res = new java.io.BufferedReader(
                        new java.io.InputStreamReader(connection.getInputStream())
                );
                String line;
                while ((line = res.readLine()) != null) {
                    result.append(line);
                }
                res.close();
            }
        } catch (java.io.IOException ex) {
            ex.printStackTrace();
        }
        return result.toString();
    }

    public long matrixSum() {
        java.util.Scanner scanner = new java.util.Scanner(java.lang.System.in);
        long result = 0l;
        String line;
        for (int i = 0; i < 4; i++) {
            line = scanner.nextLine();
            long lineSum = java.util.Arrays.stream(line.split("\\s")).mapToLong(Long::parseLong).sum();
            result += lineSum;
        }
        return result;
    }

    public java.util.function.Function<Integer, java.math.BigInteger> degree(int n) {
        return x -> java.math.BigInteger.valueOf(x).pow(n);
    }

    public static java.util.stream.IntStream numbers(java.util.List<String> items) {
        return items.stream().filter(str -> str.matches("\\\\-?[0-9]+")).mapToInt(Integer::parseInt);
    }

    public static java.util.stream.Stream<FibNumber> fib() {
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
