package jugacademi.api;

import java.io.IOException;
import java.math.BigInteger;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) throws IOException {
        java.util.stream.Stream<FibNumber> stream = fib();
        java.util.Iterator<FibNumber> iterator = stream.iterator();
        for(int i = 0; i < 29; i++ ) {
            iterator.next();
        }
        System.out.println(iterator.next().getCurrent().intValue());
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
