package permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerStreamPermutationsRecursive {

    public static void main(String[] args) {

        List<Integer> ornList = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12).collect(Collectors.toList());
        System.out.println(permuteAndStream(ornList, 0).count());
    }


    static Stream<List<Integer>> permuteAndStream(List<Integer> inputList, int startIndex){

        if (inputList == null)
            return Stream.of(null);

        if (startIndex == inputList.size()-1)
            return Stream.of(inputList);

        return IntStream.range(startIndex, inputList.size())
                .parallel()
                .boxed()
                .flatMap(i -> {
                    List<Integer> permutedList = new ArrayList<>(inputList);
                    permutedList.set(startIndex, inputList.get(i));
                    permutedList.set(i, inputList.get(startIndex));
                    //return permutedList;
                    return permuteAndStream(permutedList, startIndex+1);
                } )
                ;
    }


}
