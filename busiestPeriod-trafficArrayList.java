import java.lang.reflect.Array;
import java.util.*;

class Traffic {
    int timestamp;
    int count;
    String type;

    public Traffic(int timestamp, int count, String type) {
        this.timestamp = timestamp;
        this.count = count;
        this.type = type;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "[ times=" + timestamp + ", count=" + count + ", type=" + type + "]";
    }
}
class Period {
    int start;
    int end;
    int maxvisitor;

    public Period(int start, int end, int maxvisitor) {
        this.start = start;
        this.end = end;
        this.maxvisitor = maxvisitor;
    }
}
public class Main {
    static public int[] findBusiestPeriod(ArrayList<Traffic> trafficArrayList) {
        int[] result = new int[2];
        int visitors = 0;
        Period busiestPeriod = new Period(0, 0, 0);

        // for(Traffic str: trafficArrayList){
        for (int i = 1; i < trafficArrayList.size(); i++) {
            Traffic str = (Traffic) trafficArrayList.get(i - 1);
            Traffic strNext = new Traffic(0, 0, null);
            if (trafficArrayList.get(i) != null) {
                strNext = (Traffic) trafficArrayList.get(i);
            } else {
                strNext = null;
            }
            //System.out.println(str.timestamp);
            visitors = (str.type == "enter") ? visitors + str.count : visitors - str.count;
            if (visitors > busiestPeriod.maxvisitor) {
                busiestPeriod.maxvisitor = visitors;
                busiestPeriod.start = str.timestamp;
                busiestPeriod.end = strNext.timestamp;
            } else if (visitors == busiestPeriod.maxvisitor) {
                busiestPeriod.end = strNext.timestamp;
            }
        }
        result[0] = busiestPeriod.start;
        result[1] = busiestPeriod.end;
        return result;
    }
    static public List<Integer> partitionList(int pivot, List<Integer> lst) {

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> list3 = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < lst.size();i++){
            if (lst.get(i) < pivot)
                list1.add(lst.get(i));
            else if (lst.get(i) == pivot)
                list2.add(lst.get(i));
            else
                list3.add(lst.get(i));
        }
        result.addAll(list1);
        result.addAll(list2);
        result.addAll(list3);
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Traffic> trafficArrayList = new ArrayList<Traffic>();

        trafficArrayList.add(new Traffic(1526579928, 3, "enter"));
        trafficArrayList.add(new Traffic(1526580382, 2, "exit"));
        trafficArrayList.add(new Traffic(1526579938, 6, "enter"));
        trafficArrayList.add(new Traffic(1526579943, 1, "enter"));
        trafficArrayList.add(new Traffic(1526579944, 0, "enter"));
        trafficArrayList.add(new Traffic(1526580345, 5, "exit"));
        trafficArrayList.add(new Traffic(1526580351, 3, "exit"));
        //Traffic busiestTraffic = new Traffic(0,0,null);
        int[] res = findBusiestPeriod(trafficArrayList);
        System.out.println("the intervals is ["+res[0]+" , "+res[1]+"]");        
    }
}
