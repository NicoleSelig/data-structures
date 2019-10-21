import java.util.Scanner;

public class FloydsAlgorithm {
    static int [][] pathMatrix;
    static int numberOfVertices;
    static int [][] matrix;
    public static final int INFINITY = 999;

    /**Function that implements floyd's algorithm
     * Finds the shortest path between 2 vertices
     * O(n^3) runtime
     * @param matrix
     */
    public static int[][] Floyd(int[][] matrix) {
        for (int k = 0; k < numberOfVertices; k++) {
            for (int i = 0; i < numberOfVertices; i++) {
                for(int j = 0; j < numberOfVertices; j++ ){
                    //keeps track of shortest distance with dynammic programming
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        pathMatrix[i][j] = k;
                    }
                    //or not to keep track
                    //matrix[i][j], matrix[i][k] + matrix[k][j];
                }

            }
        } return matrix;
    }

    /**Function that prints out the matrix
     * @param matrix
     */
    public static void printMatrix (int [][] matrix){

        System.out.print("\n\t");
        for (int j = 0; j < numberOfVertices; j++) {
            System.out.print(j +"\t");
        }
        System.out.println();
        for (int j = 0; j < 35; j++){
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < numberOfVertices; i++){
            System.out.print(i + "|\t");
            for (int j =0; j < numberOfVertices; j++){
                System.out.print(matrix[i][j]);
                System.out.print("\t");
            }
            System.out.println("\n");
        }
        System.out.println("\n");

    }

    /**function that gets the weighted graph from user input and creates a matrix
     * @return matrix
     */
    public static int[][] getMatrix() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices for the graph: ");
        numberOfVertices= scan.nextInt();
        System.out.println("Enter the Weighted Matrix for the graph: ");
        matrix = new int[numberOfVertices][numberOfVertices];
        for(int i = 0; i < numberOfVertices; i++){
            for (int j = 0; j < numberOfVertices; j++){
                matrix[i][j] = scan.nextInt();
                if (i==j){
                    matrix[i][j] = 0;
                    continue;
                }
                if (matrix[i][j] == 0){
                    matrix[i][j] = INFINITY;
                }
            }
        }
        return matrix;
    }

    public static void main (String[] args){
        getMatrix();
        pathMatrix = new int [numberOfVertices][numberOfVertices];
        System.out.println("Original Matrix: ");
        System.out.println("(999=infinity)");
        printMatrix(matrix);
        System.out.println("Shortest Path Matrix (Transitive Closure): ");
        printMatrix(Floyd(matrix));
        /*path matrix keeps track of intermediate nodes
		(what nodes does the shortest path pass through)*/
        System.out.println("Path Matrix (intermediate nodes): ");
        printMatrix(pathMatrix);

    }


}
