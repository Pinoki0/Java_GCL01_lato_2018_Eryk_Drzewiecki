import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Worker {

   // public PriorityQueue<TaskHelp> tasks;
    public LinkedBlockingQueue<TaskHelp> taskss;
    Thread thread;
    String name;
    int taskNumber = 1;
    boolean start = false;
    boolean work = false;





    Worker(String name) {
        taskss = new LinkedBlockingQueue<TaskHelp>();
        this.name = "Worker" + name + "Thread";
    }



    public void start() {
                if(thread != null)
                    return;
                start = true;
                thread = new Thread(name){
                    @Override
                    public void run() {

                        while (true) {
                            try {
                                TaskHelp temp = taskss.take();
                                work = true;
                                temp.getTask().run(taskNumber);
                                work = false;
                                taskNumber++;

                            } catch (InterruptedException e) {
                                break;
                            }
                        }

                    }
                };

                thread.start();
            }


    void enqueueTask( String taskName, Task task ) throws InterruptedException {
        TaskHelp temp = new TaskHelp(task, name);
        taskss.put(temp);

    }

    public void stop(){
        if(thread == null) {
            return;
        }
        start = false;
        System.out.println("task stop");
        thread = null;
    }
    boolean isStarted() {
        if(start)
            return true;
        else
            return false;
    }
    boolean isWorking() {
        if (work)
            return true;
        else
            return false;
    }
}


/*public String getName() {
        return name;
    }*/