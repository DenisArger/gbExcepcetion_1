import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        ex1_1();
    }
	/*
	Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
	*/
  static void ex1_1(){

        try {
            int[] res = getDiffArray(new int[]{1, -2, 3, 0}, new int[] {4, 3, 1, 0, 1});
            for (int e: res) {
                System.out.printf("%d\t", e);
            }
            System.out.println();
        }
        catch (CustomArraySizeException e){
            System.out.println(e.getMessage());
            System.out.printf("Длина первого массива: %d\nДлина второго массива: %d\n",
                    e.getLength1(), e.getLength2());
        }

    }
	
	/*
	Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить пользователя.
	Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
	*/
	 static void ex1_2(){

        try {
            int[] res = getDivArray(new int[]{1, -2, 3, 1}, new int[] {4, 3, 1, 2, 1});
            for (int e: res) {
                System.out.printf("%d\t", e);
            }
            System.out.println();
        }
        catch (CustomArraySizeException e){
            System.out.println(e.getMessage());
            System.out.printf("Длина первого массива: %d\nДлина второго массива: %d\n",
                    e.getLength1(), e.getLength2());
        }

    }


static int[] getDiffArray(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null)
            throw new NullPointerException("Оба массива должны существовать.");
        if (arr1.length != arr2.length)
            throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаковым.", arr1.length, arr2.length);

        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++)
            res[i] = arr1[i] - arr2[i];
        return res;
    }


static int[] getDivArray(int[] arr1, int[] arr2){
		if (arr1 == null || arr2 == null)
            throw new NullPointerException("Оба массива должны существовать.");
        if (arr1.length != arr2.length)
            throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаковым.", arr1.length, arr2.length);

        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++){
			if(arr2[i] == 0)
				throw new ZeroDivException("Деление на ноль запрещено");
			else
				res[i] = arr1[i] / arr2[i];
		}
        return res;
    }


}

class CustomArraySizeException extends RuntimeException{

    private int length1;
    private int length2;

    public int getLength1() {
        return length1;
    }

    public int getLength2() {
        return length2;
    }

    public CustomArraySizeException(String message, int length1, int length2) {
        super(message);
        this.length1 = length1;
        this.length2 = length2;
    }
}

class NullPointerException extends RuntimeException{ 
    public NullPointerException(String message) {
        super(message);

    }
}


class ZeroDivException extends RuntimeException{ 
    public NullPointerException(String message) {
        super(message);

    }
}
