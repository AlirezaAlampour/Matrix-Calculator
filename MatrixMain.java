
import java.util.*;
public class MatrixMain {
    public static void main(String[] args) {    
        Matrix A = getMatrix("first Matrix");
        Matrix B = getMatrix("second Matrix");
        Matrix C = doOperation(A,B);
        System.out.print(A.results(A.elements));
        System.out.print("\n"+B.results(B.elements));
        System.out.print("\n"+C.results(C.elements));
        boolean jh = A.equal(A,B);
        System.out.print("\n"+jh);
    }
    static Matrix getMatrix(String MatrixName){
        int row;
        int col;
        int a;
	int b;
	Scanner input = new Scanner(System.in);
	System.out.println("\n"+"Please input the Rows and Columns of" + MatrixName);	
	row = input.nextInt();
        col = input.nextInt();
        System.out.println("\n"+"Please input the Lower and Upper bound of" + MatrixName);
	a = input.nextInt();
        b = input.nextInt();
        return (new Matrix(row,col,a,b));
    }
    static Matrix doOperation(Matrix A, Matrix B){
        boolean notValid = true;
        do{
            Scanner input = new Scanner(System.in);
            System.out.println("'\n'Please make a selection.'\n'1)Additon'\n'2)Subtraction'\n'3)DotProduct'\n'4)Hadammor Product'\n'>");   
            int choice = input.nextInt();
            switch(choice-1){
                case 0:
                    if(Matrix.ofEqualDimentions(A,B)){
                        notValid = !Matrix.ofEqualDimentions(A,B);
                        return A.add(B);
                    }
                    else{
                        System.out.print("Please check your Matrix enteries!");
                        A = getMatrix("first Matrix");
                        B = getMatrix("second Matrix");
                    }
                case 1:
                    if(Matrix.ofEqualDimentions(A, B)){
                        notValid = !Matrix.ofEqualDimentions(A,B);
                        return A.subtract(B);
                    }
                    else{
                        System.out.print("Please check your Matrix entries!");
                        A = getMatrix("first Matrix");
                        B = getMatrix("second Matrix");
                    }
                case 2:
                    if(Matrix.validDotProduct(A, B)){
                        notValid = !Matrix.validDotProduct(A,B);
                        return A.dotProduct(B);
                    }
                    else{
                        System.out.print("Please check your Matrix entries!");
                        A = getMatrix("first Matrix");
                        B = getMatrix("second Matrix");
                    }
                case 3:
                    if(Matrix.ofEqualDimentions(A, B)){
                        notValid = !Matrix.ofEqualDimentions(A,B);
                        return A.HadmardProduct(B);
                    }
                    else{
                        System.out.print("Please check your Matrix entries!");
                        A = getMatrix("first Matrix");
                        B = getMatrix("second Matrix");
                    }
                default:
                    System.out.print("\n"+"Please Make a valid selection!");
            }
           }
        while(notValid);
        return new Matrix();
        
    }
	}
/*if(choice==1||choice==2||choice==4){
                if(Matrix.ofEqualDimentions(A,B)){
                    switch(choice){
                        case 1: return A.add(B);
                        case 2: return A.subtract(B);
                        case 4: return A.HadmardProduct(B);
                    }
                }
                notValid = !Matrix.ofEqualDimentions(A,B);
		}
            else if(choice==3){
                A.dotProduct(B);    
                notValid = !Matrix.validDotProduct(A,B);
                 }
                 else{
                    A = getMatrix("first Matrix");
                    B = getMatrix("second Matrix");          	
                 }*/