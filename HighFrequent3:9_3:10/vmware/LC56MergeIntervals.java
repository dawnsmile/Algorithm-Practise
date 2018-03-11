import java.util.Arrays;
import java.util.List;

// import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.)
        Interval[] a = intervals.toArray(new Interval[intervals.size()]);
        Arrays.sort(a,(b,c)->b.start - c.start);
        int pointer = 0;
        int modifyPointer = 0;
        while (pointer < a.length){
            if (a[pointer].start>a[modifyPointer].end){
                modifyPointer++;
                a[modifyPointer] = a[pointer];
            }else{
                if (a[pointer].end>a[modifyPointer].end)
                    a[modifyPointer].end = a[pointer].end;
                pointer++;
            }
        }
        return Arrays.asList(Arrays.copyOfRange(a, 0,modifyPointer));
    }
}