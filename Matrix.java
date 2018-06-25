
import java.util.*;
import java.util.Arrays;
import java.util.stream.IntStream;
public class Matrix {
   final int row;   
   final int col;
   final int [][] elements;
   
   public Matrix(){
       this(2,2,-100,100);
   }
   public Matrix(int row, int col, int min, int max){
       this.row = row;
       this.col = col;
       this.elements = IntStream.range(0,row).parallel().mapToObj(i-> new Random().ints(min,max).limit(col)
       .toArray()).toArray(int[][]::new);  
        }
   public Matrix(int[][] input) {
       this.row = input.length;
       this.col = input[1].length;
       this.elements = IntStream.range(0,row).parallel().mapToObj(i->Arrays.copyOf(input[i],input[i].length)).toArray(int[][]::new);
        }
   public Matrix add(Matrix otherMatrix){
    return new Matrix(IntStream.range(0, row).parallel().mapToObj(i -> IntStream.range(0, col).parallel().map(j -> this.elements[i][j]+otherMatrix.elements[i][j]).toArray()).toArray(int[][]::new)); 
   }
   public Matrix subtract(Matrix otherMatrix){
    return new Matrix(IntStream.range(0, row).parallel().mapToObj(i -> IntStream.range(0, col).parallel().map(j -> this.elements[i][j]-otherMatrix.elements[i][j]).toArray()).toArray(int[][]::new));   
   }
   public Matrix dotProduct(Matrix otherMatrix){
     return new Matrix(IntStream.range(0,this.row).mapToObj(x->IntStream.range(0,otherMatrix.col).map(y->IntStream.range(0,this.col).map(z->this.elements[x][z]*otherMatrix.elements[z][y]).reduce(0,(a,b)->a+b)).toArray()).toArray(int[][]::new));
   }
   public Matrix HadmardProduct(Matrix otherMatrix){
    return null;
     //return new Matrix(IntStream.range(0,this.row).mapToObj(x -> IntStream.range(0,otherMatrix.col).map(y -> this.elements[x][y]* otherMatrix.elements[x][y]).reduce(0,(a,b)-> a+b)).toArray()).toArray(int[][]::new));
   }
   public String results(int[][]input){
      return Arrays.stream(input).map(x->Arrays.stream(x).mapToObj(i-> String.format("%6d",i)).reduce("\n"+"[",(a,b)->a + b)).reduce("\n",(a,b)-> a + b+"]");
   }
   public boolean equal(Matrix A, Matrix B){
      return(A.equals(B));
   }
   @Override
   public Matrix clone() throws CloneNotSupportedException{
       super.clone();
       return null;
   }
   static boolean ofEqualDimentions(Matrix A, Matrix B){
       return(A.row==B.row&&A.col==B.col);
   }
   static boolean validDotProduct(Matrix A, Matrix B){
       return(A.col==B.row);
   }
   Matrix operation(int input,Matrix A, Matrix B, Matrix C){
       switch(input-1){
           case 0: return A.add(B);
           case 1: return A.subtract(B);
           case 2: return A.dotProduct(B);
           default: return A.HadmardProduct(B);       
       }
   }
}

