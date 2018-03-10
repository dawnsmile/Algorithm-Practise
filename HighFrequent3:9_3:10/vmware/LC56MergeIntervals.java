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
        Interval[] a = intervals.toArray(new String[0]);
        Arrays.sort(a,(a,b)->a.s - b.s);
    }
}