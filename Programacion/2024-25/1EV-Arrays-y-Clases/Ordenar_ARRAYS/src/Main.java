import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] newArray = new int[originalArray.length];

        // Copiar elementos del originalArray al newArray
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);

        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("New Array: " + Arrays.toString(newArray));
    }
}
import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        // Array desordenado
        int[] numbers = {5, 3, 8, 1, 2, 7, 4, 6};

        System.out.println("Array original: " + Arrays.toString(numbers));

        // Ordenar el array
        Arrays.sort(numbers);

        System.out.println("Array ordenado: " + Arrays.toString(numbers));
    }
}




public class BubbleSortArray {
    public static void main(String[] args) {
        // Array desordenado
        int[] numbers = {5, 3, 8, 1, 2, 7, 4, 6};

        System.out.println("Array original:");
        printArray(numbers);

        // Ordenar el array usando el método de la burbuja
        bubbleSort(numbers);

        System.out.println("Array ordenado:");
        printArray(numbers);
    }

    // Método para ordenar usando el método de la burbuja
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambiar elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Método para imprimir el array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
