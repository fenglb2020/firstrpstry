package testThread;

public class Demo {
    SaveProcessor saveProcessor = new SaveProcessor();
    PrintProcessor printProcessor = new PrintProcessor(saveProcessor);
    public Demo() {
        printProcessor.start();
        saveProcessor.start();

    }
    public static void main(String args []){
        new Demo().doTest(new Request());

    }
    public void doTest(Request request){
       request.setName("fenglb");
       printProcessor.processorRequest(request);

    }

}
