import java.util.*;
class NQueen {
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> ans = solve(n);

        if(ans.size()==0){
            System.out.println("-1");
        }
        else{
            for(int i=0;i<ans.size();i++){
                System.out.print("[");
                for(int j=0;j<ans.get(i).size();j++){
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.print("]");
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> solve(int n) {
        boolean board[][] = new boolean[n][n];
        boolean col [] = new boolean[n];
        boolean nd [] = new boolean[2*n-1];
        boolean rd [] = new boolean[2*n-1];
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        function(board,0,col,nd,rd,res);

        return res;
        
    }

    private static void function(boolean[][] board, int r, boolean[] col, boolean[] nd, boolean[] rd,ArrayList<ArrayList<Integer>> res) {
                if(r==board.length){
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int i=0;i<board.length;i++){
                        for(int j=0;j<board[0].length;j++){
                            if(board[i][j]==true){
                                list.add(j+1);
                                break;
                            }
                        }
                    }
                    res.add(list);
                    return;
                }
                for(int c=0;c<board[0].length;c++){
                    if(col[c]==false && nd[r+c]==false && rd[r-c+board.length-1]==false){
                        board[r][c]=true;
                        col[c]=true;
                        nd[r+c]=true;
                        rd[r-c+board.length-1]=true;
                        
                        function(board,r+1,col,nd,rd,res);
                        
                        board[r][c]=false;
                        col[c]=false;
                        nd[r+c]=false;
                        rd[r-c+board.length-1]=false;
                        
                        
                    }
                }
    }
}