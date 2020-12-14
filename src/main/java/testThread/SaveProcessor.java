package testThread;

import java.util.concurrent.LinkedBlockingQueue;

public class SaveProcessor extends  Thread implements RequestProcessor {
    LinkedBlockingQueue<Request>  linkedBlockingQueue = new LinkedBlockingQueue();

    @Override
    public void run() {
        while (true){
            Request request = null;
            try {
                request = linkedBlockingQueue.take();
                System.out.println("save"+request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    public void processorRequest(Request request) {
        linkedBlockingQueue.add(request);
    }
}
