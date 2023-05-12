package jugacademi;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GenericMax {
    public <E> E findMax(E... input){
        java.util.List<E> max = java.util.Arrays.stream(input).sorted().collect(java.util.stream.Collectors.toList());
        return max.get(max.size()-1);
    }
}
