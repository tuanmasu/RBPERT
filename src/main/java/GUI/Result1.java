package GUI;

import Bayes.CriticalPath;
import Bayes.Task;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Result1 extends JPanel {

    public Result1( ArrayList<Task> timTaskCuoi1) {
        CriticalPath cri2 = new CriticalPath();
        Task task1 = null;
        Task task2 = null;
        Task task3 = null;
        this.setLayout(null);
        for (int i = 0; i < timTaskCuoi1.size(); i++) {
            task1 = timTaskCuoi1.get(i);
            if (task1 != null) {
                if (timTaskCuoi1.size() <= 3) {
                    DoThi doThi = new DoThi(cri2.duLieu(task1), "Đồ thị  thứ" + (i + 1)+":"+task1.name, timTaskCuoi1.size());
                    doThi.setSize(400, 400);
                    doThi.setLocation(i * 410, 0);
                    this.add(doThi);
                } else {
                    if (i < 4) {
                        DoThi doThi = new DoThi(cri2.duLieu(task1), "Đồ thị  thứ" + (i + 1)+":"+task1.name, timTaskCuoi1.size());
                        doThi.setSize(300, 300);
                        doThi.setLocation(i * 310, 0);
                        this.add(doThi);
                    } else {
                        DoThi doThi = new DoThi(cri2.duLieu(task1), "Đồ thị  thứ" + (i + 1)+":"+task1.name, timTaskCuoi1.size());
                        doThi.setSize(300, 300);
                        doThi.setLocation((i-4) * 310, 310);
                        this.add(doThi);
                    }

                    System.out.println(" vao day");
                }
            }
        }
    }
}
