import java.util.LinkedList;


public class Producer extends Thread{

	private LinkedList list;
	
	public Producer(LinkedList list){
		this.list=list;
	}
	public void run(){
		synchronized(list){
			int i=0;
			while(true){
				if(list.size()==10){
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				i=i+1;
				list.add(i);
				System.out.println("product " + i);
				//若消费者在休眠，唤醒消费者
				list.notify();
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
