import java.util.EventListener;

public interface WorkerListener extends EventListener {
     void onWorkerStarted();
     void onWorkerStopped();
     void onTaskStarted( int taskNumber, String taskName );
     void onTaskCompleted( int taskNumber, String taskName );
}
