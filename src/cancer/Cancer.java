/*
 * Amer Stas
 * 4/1/2020
 * This prgram shows how many cancer cells in 15x15.
 */
package cancer;

/**
 *
 * @author canada
 */
public class Cancer {
    public static String grid[][];
    public static int gridSize;
    public static void main(String[] args) {
    int row,col;
    // Create 2D array size 15*15
    grid = new String[15][15];
    // Filling the Array with blanks
    for (row=0; row<15;row++){
        for (col=0;col<15;col++){
            grid[row][col]="+";
        }
    }
    // Fill random elements in the array with an negative signs
    // Do no choose an elment along the border
    //The border will always contain elemnts with postive sigins
    //(Blank Border)
   
    for (int i=0;i<70;i++){
        row = (int)(Math.random()*13+1);
        col = (int)(Math.random()*13+1);
        grid[row][col]="-";
    }
    //Print out the current grid
    displayGrid();
    
    //varaible to determine the size of the grid
    gridSize=0;
    //
    //
    //
    int gridRow=(int)(Math.random()*13+1);
    int gridCol=(int)(Math.random()*13+1);
    
    System.out.println(" The blob "+ gridRow+","+gridCol+" will be remeoved");
    floodFill(gridRow, gridCol);
    System.out.println(" The Blob had " + gridSize+" items in it");
        System.out.println("The new grid is");
    // Display out the new grid
    displayGrid();
    }
    public static void floodFill(int row, int col){
        if (grid[row][col].equals("-")){
            grid[row][col]="+";
            gridSize++;
            floodFill(row-1,col+1);
            floodFill(row-1,col);
            floodFill(row-1,col+1);
            floodFill(row,col-1);
            floodFill(row,col+1);
            floodFill(row+1,col-1);
            floodFill(row+1,col);
            floodFill(row+1,col+1);
        }
    }
    public static void displayGrid(){
        String output="               ";
        for (int row=0;row<=14;row++){
            if((row>0)&&(row<14)){
                output+=(row%13);
            }
            for (int col =0; col<=15;col++){
                output+=grid [row][col];
            }
            output+="\n";
        }
        System.out.println(output);
    }
    
}
