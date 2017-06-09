/**
 * Created by Sumanth Nagamalli on 6/8/17.
 */
public class MinCostPathFinder1 {

    public static int find(int[][] A) {
        int[][] solution = new int[A.length][A.length];

        solution[0][0] = A[0][0];
        for (int i = 1; i < A.length; i++) {
            solution[0][i] = A[0][i] + solution[0][i - 1];
        }

        for (int i = 1; i < A.length; i++) {
            solution[i][0] = A[i][0] + solution[i - 1][0];
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < A.length; j++) {
                solution[i][j] = A[i][j]
                        + Math.min(solution[i - 1][j], solution[i][j - 1]);
            }
        }
        return solution[A.length - 1][A.length - 1];
    }

    public static void main(String[] args) {

        //Test 1
        int[][] A = {   {6, 3, -5, 9},
                        {-5, 2, 4, 10},
                        {3, -2, 6, 10},
                        {6, -1, -2, 10}};


        System.out.println("Minimum Cost Path value is" + find(A));
    }
}