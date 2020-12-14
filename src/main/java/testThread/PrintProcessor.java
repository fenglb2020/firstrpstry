package testThread;

import java.util.concurrent.LinkedBlockingQueue;

public class PrintProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue();
    private final RequestProcessor nextProcessor;
    public  PrintProcessor(RequestProcessor requestProcessor){
        this.nextProcessor =requestProcessor;
    }

    @Override
    public void run() {
        while (true){
            Request request = null;
            try {
                request = linkedBlockingQueue.take();
                System.out.println("print data:"+request);
                nextProcessor.processorRequest(request);
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
