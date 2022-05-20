package algos.leetcode.other;

public class NumberOfIsland {

//    static char [][] grid = { {'1','1','1','1','0'},
//            {'1','1','0','1','0'},
//            {'1','1','0','0','0'},
//            {'0','0','0','0','0'}
//};

//    static char [][] grid = { {'1','1','0','0','0'},
//            {'1','1','0','0','0'},
//            {'0','0','1','0','0'},
//            {'0','0','0','1','1'}
//    };

    static char [][] grid = { {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
    };




    public static void main(String []s){
        printaArrr(grid);
       int nos = countIsLand();

        System.out.println(" max island  >>>> "+nos );
        System.out.println("NOw updated array " );
        printaArrr(grid);
    }


    public static int countIsLand(  ){

        int maxNoIsland = 0;

        for( int i =0 ; i < grid.length ; i++){
            char []row = grid[i];
            System.out.println( );
            for( int j =0 ; j < row.length ; j++){

                boolean isIslandCounterFound = false;

                if(grid[i][j] == '1'){

                    if(i-1>=0 && grid[i-1][j] != '0'){
                        grid[i][j] = grid[i-1][j];
                        isIslandCounterFound = true;
                    }
                    if(j-1>=0 && grid[i][j-1] != '0'){
                        grid[i][j] = grid[i][j-1];
                        isIslandCounterFound = true;
                    }

                    if(!isIslandCounterFound){
                        ++maxNoIsland;
                        grid[i][j]= (char) (maxNoIsland +'0');
                    }

                }
            }

        }
        return maxNoIsland;

    }

    public static void printaArrr(char [][] grid  ){
        for( int i =0 ; i < grid.length ; i++){
            char []row = grid[i];
            System.out.println( );
            for( int j =0 ; j < row.length ; j++){
                System.out.print( grid[i][j]);
            }

        }
    }


}
