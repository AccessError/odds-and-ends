package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HeapsAlgorithm {
    public static void main(String[] args) {
        List<Integer> inputList = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).collect(Collectors.toList());
        List<Integer[]> outputList = new ArrayList<>();

        int listSize = inputList.size();

        Integer[] swapRef = new Integer[listSize];
        for(int i = 0; i<listSize; i++)
            swapRef[i] = 0;

        Integer[] prevPerm = inputList.toArray(new Integer[listSize]);
        outputList.add(prevPerm);
        int totalPerm = 1;

        int refPointer = 0;
        while (refPointer < listSize){
            if(swapRef[refPointer] < refPointer){
                Integer[] newPerm = Arrays.copyOf(prevPerm, prevPerm.length);
                if(refPointer % 2 == 0)
                    swap(newPerm, 0, refPointer);
                else
                    swap(newPerm, swapRef[refPointer], refPointer);
                outputList.add(newPerm);
                totalPerm++;
                prevPerm = newPerm;
                ++swapRef[refPointer];
                refPointer = 0;
            }
            else{
                swapRef[refPointer] = 0;
                refPointer++;
            }
        }

        //outputList.stream().forEach((perm) -> System.out.println(Arrays.stream(perm).collect(Collectors.toList())));
        System.out.printf("Total Permutations :%d",totalPerm);

    }

    public static void swap(Integer[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}
