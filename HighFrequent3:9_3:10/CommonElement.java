import java.util.*;
import java.lang.*;
import java.io.*;

class CommonElement{
    public static void main(String argv[]){
        int[] a = {1,5,10,20,40,80};
        int[] b = {6,7,20,80,100};
        int[] c = {3,4,15,20,30,70,80,120};
        ArrayList<Integer> res = new ArrayList<Integer>();
        int pa = 0, pb = 0, pc = 0;
        while (pa<a.length&&pb<b.length&&pc<c.length){
            System.out.println(a[pa]);
            if (a[pa] == b[pb]&& b[pb]  == c[pc]){
                res.add(a[pa]);
                pa++;pb++;pc++;
                continue;
            }
            if (a[pa] <= b[pb]&& b[pb] <= c[pc]){
                pa++;
                continue;
            }
            if (a[pa] >= b[pb]&& b[pb] <= c[pc]){
                pb++;
                continue;
            }
            if (a[pa] >= c[pc]&& b[pb] >= c[pc]){
                pc++;
                continue;
            }
        }
        System.out.println(res);
        
    }
}