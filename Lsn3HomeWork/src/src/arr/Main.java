package arr;

public class Main {

    public static void main(String[] args) {

        String[] arr1 = new String[]{"Merry", "Frodo", "Sam"};
        String[] arr2 = new String[]{"Nif-Nif", "Naf-Naf", "Nuf-nuf"};

        Integer[] arr3 = new Integer[]{1, 2, 3, 4};
        Integer[] arr4 = new Integer[]{5, 6, 7, 8};

        Integer[] arr5 = new Integer[]{5, 6, 8};
        Integer[] arr6 = new Integer[]{5, 6, 7, 8};

        Integer[] arr7 = new Integer[]{5, 6, 7, 8};
        String[] arr8 = new String[]{"A", "B", "C"};

        Arr checkArrays = new Arr();

        System.out.println(checkArrays.compareArrays(arr1, arr2));
        System.out.println(checkArrays.compareArrays(arr3, arr4));
        System.out.println(checkArrays.compareArrays(arr5, arr6));
        System.out.println(checkArrays.compareArrays(arr7, arr8));


    }
}
