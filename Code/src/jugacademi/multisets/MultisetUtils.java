package jugacademi.multisets;

import java.util.stream.Collectors;

public class MultisetUtils {

    public static int min(Multiset<Integer> mset){
        return mset.stream().mapToInt(Integer::intValue).min().orElse(0);
    }
    public static int minWeighted(Multiset<Integer> mset){

        return mset.stream().mapToInt(el->el*mset.count(el)).min().orElse(0);
    }
    public static int sum(Multiset<Integer> mset){
        return mset.stream().mapToInt(Integer::intValue).sum();
    }
    public static int sumWeighted(Multiset<Integer> mset){
        return mset.stream().mapToInt(el->el*mset.count(el)).sum();
    }
    public static java.util.List<Integer> toList(Multiset<Integer> mset){
        java.util.List<Integer> result = new java.util.ArrayList<>();
        mset.stream().forEach(el -> {
                int count = mset.count(el);
                for (int i = 0; i < count; i++) {
                    result.add(el);
                }
        });
        return result.stream().sorted().collect(java.util.stream.Collectors.toList());
    }
}
