import java.util.Comparator;
import java.util.PriorityQueue;

class StackPriorityQueue {

    PriorityQueue<StackElement> queue = new PriorityQueue<>(10, new Comparator<StackElement>() {
        @Override
        public int compare(StackElement o1, StackElement o2) {
            return o2.key - o1.key;
        }
    });

    int order = 1;

    public void push(int val){
        StackElement element = new StackElement(order++,val);
        queue.add(element);
    }

    public Integer pop(){
        if(queue.isEmpty()){
            System.out.println("Stack Underflow");
            return null;
        }
        return queue.poll().value;
    }
}

class StackElement {
    int key;
    int value;

    public StackElement(int key, int value) {
        this.key = key;
        this.value = value;
    }

}
public class Main {

   public static void main(String args[]){
        StackPriorityQueue q = new StackPriorityQueue();
        q.push(5);
        q.push(10);
        q.push(1);
        q.push(3);
        q.push(50);
        q.push(500);
        q.push(60);
        q.push(30);
        q.push(40);
        q.push(23);
        q.push(34);

        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}