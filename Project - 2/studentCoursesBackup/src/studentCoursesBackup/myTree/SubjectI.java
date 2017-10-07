package studentCoursesBackup.myTree;

import java.util.ArrayList;

public interface SubjectI{

	public void notifyAll(ArrayList<Node> listenerNodes);
	public void addListener(Node node);
}