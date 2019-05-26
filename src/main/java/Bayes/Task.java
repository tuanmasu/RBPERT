package Bayes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Vector;

public class Task {
    // the duration the task
    public Node duration;
    //the total duration of the task
    public Node totalDuration;
    // the earliest start
    public Node earlyStart;
    // the earliest finish
    public Node earlyFinish;
    // the latest start
    public Node latestStart;
    // the latest finish
    public Node latestFinish;


    public String name;
    // the cost of the task along the critical path
    public Node criticalCost;
    //risk file name 
    public String riskFile;
    // a name for the task for printing
    public HashSet<Task> childs = new HashSet<Task>();
    public HashSet<Task> parents = new HashSet<Task>();
    public Collection<Task> dependencies;

    public Task(String name, String riskFile, Node duration, Node totalDuration, Task... dependencies) {
        this.name = name;
        this.riskFile = riskFile;
        criticalCost = new Node(name + ".BP");
        earlyFinish = new Node(name + ".EF");
        earlyStart = new Node(name + ".ES");
        latestStart = new Node(name + ".LS");
        latestFinish = new Node(name + ".LF");

        this.duration = duration;
        this.totalDuration = totalDuration;
        for (Task t : dependencies) {
            this.childs.add(t);
        }

        for (int i = 0; i < 5; i++) {
            this.earlyFinish.getValue()[i] = -1;
        }
    }

    public Task(String name, Task... childs) {
        this.name = name;
        criticalCost = new Node(name + ".BP");
        earlyFinish = new Node(name + ".EF");
        earlyStart = new Node(name + ".ES");
        latestStart = new Node(name + ".LS");
        latestFinish = new Node(name + ".LF");

        this.duration = duration;
        for (Task t : childs) {
            this.childs.add(t);
        }

        for (int i = 0; i < 5; i++) {
            this.earlyFinish.getValue()[i] = -1;
        }
    }


    public void setLatest(double[] maxCost) {

        for (int i = 0; i < 5; i++) {
            double t = criticalCost.getValue()[i];
            latestStart.getValue()[i] = maxCost[i] - t;
            latestFinish.getValue()[i] = (latestStart.getValue()[i] + duration.getValue()[i]);

        }
    }

    public ArrayList<String[]> toStringArray() {
        ArrayList<String[]> list = new ArrayList<String[]>();

        for (int i = 0; i < 5; i++) {
            double soSanh = latestStart.getValue()[i] - earlyStart.getValue()[i];
            if (soSanh < 0.0001) {
                soSanh = 0;
            }
            String criticalCond = soSanh == 0 ? "Yes" : "No";
            String[] toString = {name, earlyStart.getValue()[i] + "", earlyFinish.getValue()[i] + "", latestStart.getValue()[i] + "", latestFinish.getValue()[i] + "",
                    soSanh + "", criticalCond + ""};
            list.add(toString);
        }
        return list;
    }

    public HashSet<Task> getChilds() {
        return childs;
    }

    public void setChilds(HashSet<Task> childs) {
        this.childs = childs;
    }


    public boolean isChild(Task t) {
        // is t a direct dependency?
        if (childs.contains(t)) {
            return true;
        }
        // is t an indirect dependency
        for (Task dep : childs) {
            if (dep.isChild(t)) {
                return true;
            }
        }
        return false;
    }

    public Vector taskToVector() {
        Vector v = new Vector();
        v.add(this.name);
        Task[] ret = getChilds().toArray(new Task[0]);
        String str = "";
        for (int i = 0; i < ret.length; i++) {
            str += ret[i].name + ",";
        }
        v.add(str);
        return v;
    }

    public Collection getDependencies() {
        return this.dependencies;
    }
}