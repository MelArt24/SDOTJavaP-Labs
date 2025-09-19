// My Variant - 12
// C5 = 2, C7 = 5, C11 = 1

package lab1;

public class Lab1 {

    public static void main(String[] args) {
        try {
            char[][] A = {
                    {'a', 'b', 'c'},
                    {'d', 'e', 'f'},
                    {'g', 'h', 'i'}
            };

            char[][] B = {
                    {'A', 'B', 'C'},
                    {'D', 'E', 'F'},
                    {'G', 'H', 'I'}
            };

            char[][] C = addMatrices(A, B);
            System.out.println("Матриця C = A + B:");
            printMatrix(C);

            int sumOfMins = sumOfRowMinimums(C);
            System.out.println("Сума мінімальних елементів у рядках матриці C: " + sumOfMins);

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непередбачувана помилка: " + e);
        }
    }

    public static char[][] addMatrices(char[][] A, char[][] B) {
        if (A == null || B == null) {
            throw new IllegalArgumentException("Матриці не повинні бути null.");
        }
        if (A.length != B.length || A[0].length != B[0].length) {
            throw new IllegalArgumentException("Матриці повинні мати однакові розміри.");
        }

        int rows = A.length;
        int cols = A[0].length;
        char[][] C = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = (char) (A[i][j] + B[i][j]); // char -> int -> char
            }
        }
        return C;
    }

    public static int sumOfRowMinimums(char[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Матриця не повинна бути null.");
        }

        int sum = 0;
        for (char[] row : matrix) {
            char min = row[0];
            for (char element : row) {
                if (element < min) {
                    min = element;
                }
            }
            sum += min; // char -> int
        }
        return sum;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
