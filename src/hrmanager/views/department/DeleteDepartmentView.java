package hrmanager.views.department;

import hrmanager.views.BaseView;

/**
 * Created by Dan on 03.12.2014.
 */
public class DeleteDepartmentView extends BaseView {
    public void printDeleteDepartmentName(){
        System.out.println("Please enter department name to delete");
    }

    public void printNoSuchDepartmentWarnMsg(){
        System.out.println("There are no departments with such name.");
        printContinueMsg();
    }

    public void printOperationCompleted() {
        System.out.println("Delete operation was completed successfully.");
        printContinueMsg();
    }
}
