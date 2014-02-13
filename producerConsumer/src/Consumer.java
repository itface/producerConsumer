import java.util.LinkedList;


public class Consumer extends Thread{

	private LinkedList list;
	
	public Consumer(LinkedList list){
		this.list=list;
	}
	public void run(){
		synchronized(list){
			int i=0;
			while(true){
				if(list.size()==0){
					try {
						list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				Object o = list.remove();
				System.out.println("consumer" + o); 
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
