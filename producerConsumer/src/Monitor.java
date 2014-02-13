import java.util.LinkedList;


public class Monitor {

	public static void main(String[] args){
		LinkedList list = new LinkedList();
		Consumer consumer = new Consumer(list);
		Producer producer = new Producer(list);
		producer.start();
		consumer.start();
	}
}
