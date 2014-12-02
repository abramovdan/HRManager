package hrmanager.views.department;

/**
 * Created by Dan on 03.12.2014.
 */
public class EditDepartmentView extends AddDepartmentView {
    public void printEditTargetDepartmentName() {
        System.out.println("Please enter department name for editing:");
    }

    public void printNoSuchDepartmentWarnMsg(){
        System.out.println("There are no departments with such name.");
        printContinueMsg();
    }
}
