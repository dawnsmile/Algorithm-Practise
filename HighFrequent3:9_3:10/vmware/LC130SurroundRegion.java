

class Solution{
    
    public void solve(char[][] board) {
        // find unsurrounded O
        // bfs
        if (board.length == 0) return;
        ArrayList<Pair> unsurrounded = new ArrayList<Pair>();
        int m = board.length;
        int n = board[0].length;
        for (int i=1;i<m-1;i++){
            if (board[i][0] == 'O')
                unsurrounded.add(new Pair(i,0));
            if (board[i][n-1] == 'O')
                unsurrounded.add(new Pair(i,n-1));
        }
        // if (board[0][i] == 'O')
        for (int i=1;i<n-1;i++){
            if (board[0][i] == 'O')
                unsurrounded.add(new Pair(0,i));
            if (board[m-1][i] == 'O')
                unsurrounded.add(new Pair(m-1,i));
        }
        boolean[][] visited = new boolean[m][n];
        boolean[][] mark = new boolean[m][n];
        Queue<Pair> q = new LinkedList<Pair>();        
        for (Pair p:unsurrounded){
            q.add(p);
            visited[p.i][p.j] =true;
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            mark[p.i][p.j] =true;
            
            if(p.i+1<m && !visited[p.i+1][p.j] && board[p.i+1][p.j] == 'O'){
                q.add(new Pair(p.i+1,p.j));
                visited[p.i+1][p.j] =true;
            }
            if(p.i-1>=0 && !visited[p.i-1][p.j] && board[p.i-1][p.j] == 'O'){
                q.add(new Pair(p.i-1,p.j));
                visited[p.i-1][p.j] =true;
            }
            if(p.j+1<n && !visited[p.i][p.j+1] && board[p.i][p.j+1] == 'O'){
                q.add(new Pair(p.i,p.j+1));
                visited[p.i][p.j+1] =true;
            }
            if(p.j-1>=0 && !visited[p.i][p.j-1] && board[p.i][p.j-1] == 'O'){
                q.add(new Pair(p.i,p.j-1));
                visited[p.i][p.j-1] =true;
            }
        }
        mark[0][0] = true;
        mark[0][n-1] = true;
        mark[m-1][0] = true;
        mark[m-1][n-1] = true;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                // System.out.println(i);
                // System.out.println(j);
                if (board[i][j]=='O' && !mark[i][j]){
                    board[i][j]='X';
                }
            }
        }
        // return board;
    }
    class Pair{
        int i;
        int j;
        Pair(){i=0;j=0;}
        Pair(int a,int b){
            this.i = a;
            this.j = b;
        }
    }
}
