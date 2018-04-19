public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start main");
        Worker workerFirst = new Worker("WORKER");



        workerFirst.enqueueTask("taskFirst", new Task() {
            @Override
            public void run(int taskNumber) throws InterruptedException {
                Thread.sleep(2000);
                System.out.println("taskFirst");
            }
        });
        workerFirst.enqueueTask("taskSecond", new Task() {
            @Override
            public void run(int taskNumber) throws InterruptedException {
                Thread.sleep(2000);
                System.out.println("taskSecond");
            }
        });
        workerFirst.start();

        System.out.println("end main");
    }
}



// worker.stop();