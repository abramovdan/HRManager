package hrmanager.views;

/**
 * Created by Dan on 30.11.2014.
 */
public abstract class BaseView {
    public void printContinueMsg(){
        System.out.println("Please press enter to continue");
    }

    public void printOperationCompleted(){
        System.out.println("Operation completed.");
        printContinueMsg();
    }
}
