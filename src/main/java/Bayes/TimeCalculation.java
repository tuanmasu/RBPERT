package Bayes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class TimeCalculation {

    public   double[] maxCost = new double[5];
    public  String format = "%1$-10s %2$-5s %3$-5s %4$-5s %5$-5s %6$-5s %7$-10s\n";
    public Set<Task> tasks;
    BayesCalculation bayesCalculation;

    public TimeCalculation(Set<Task> tasks) {
        this.tasks = tasks;

    }

    public TimeCalculation() {
    }

    public static void main(String[] args) {
        TimeCalculation c = new TimeCalculation();
        c.run1();
    }

    public void run1() {
        System.out.println("**************Thay đổi thới gian*************");
        HashSet<Task> allTasks = new HashSet<Task>();
        
        InitialDurationNodes DA = new InitialDurationNodes();
        String riskA = "./probability" + rand(1, 7) + ".bin";
        DA.innitTotalDuration(5,6,7,riskA);
        Node durationA = DA.getEstimatedDuration();
        Node totalDurationA = DA.getTotalDuration();
        InitialDurationNodes DB = new InitialDurationNodes();
        String riskB = "./probability" + rand(1, 7) + ".bin";
        DB.innitTotalDuration(5, 7, 8.5,riskB);
        Node durationB = DB.getEstimatedDuration();
        Node totalDurationB = DB.getTotalDuration();
        InitialDurationNodes DC = new InitialDurationNodes();
        String riskC = "./probability" + rand(1, 7) + ".bin";
        DC.innitTotalDuration(6, 8, 8.5,riskC);
        Node durationC = DC.getEstimatedDuration();
        Node totalDurationC = DC.getTotalDuration();
        InitialDurationNodes DD = new InitialDurationNodes();
        String riskD = "./probability" + rand(1, 7) + ".bin";
        DD.innitTotalDuration(2,4,6,riskD);
        Node durationD = DD.getEstimatedDuration();
        Node totalDurationD = DD.getTotalDuration();
        Task D = new Task("D", riskD, durationD, totalDurationD);
        Task C = new Task("C", riskC, durationC, totalDurationC, D);
        Task B = new Task("B", riskB, durationB, totalDurationB, D);
        Task A = new Task("A", riskA, durationA, totalDurationA, B);
        allTasks.add(A);
        allTasks.add(B);
        allTasks.add(C);
        allTasks.add(D);
        TimeCalculation cri = new TimeCalculation(allTasks);
        cri.findParents(cri.tasks);        
        Task[] result = cri.timeCalculate(cri.tasks);
        BayesInActivity bay = new BayesInActivity();
        //tao bayesian trong tung hoat dong
        bay.initAllOfActivity(result);
        IOConditionalProbability IO = new IOConditionalProbability(result);
        IO.inputListTask();
        BayesCalculation bay1 = new BayesCalculation(result);
        bay1.calculateTask();
        cri.print(result);
        
        
    }
    
    public void run(){
        //CriticalPath cri = new CriticalPath(allTasks);
        findParents(this.tasks);        
        Task[] result = timeCalculate(this.tasks);
        print(result);
        BayesInActivity bay = new BayesInActivity();
        bay.initAllOfActivity(result);
        IOConditionalProbability IO = new IOConditionalProbability(result);
        IO.inputListTask();
        BayesCalculation bay1 = new BayesCalculation(result);
        bay1.calculateTask();
        
    }
    public ArrayList<Task> lastTask(Set<Task> allTasks){
        ArrayList<Task> timTaskCuoi = new ArrayList<Task>();
        Task[] result = allTasks.toArray(new Task[0]);
        double maxtime = 0 ;
        for(int i =0; i < result.length; i++){
            if(result[i].getChilds().size() ==0){
                if(result[i].earlyFinish.getValue()[2] > maxtime){
                    maxtime = result[i].earlyFinish.getValue()[2];
                    timTaskCuoi.clear();
                    timTaskCuoi.add(result[i]);
                }
            }
        }
        return timTaskCuoi;
    }
    public ArrayList<ArrayList<Double>> duLieu(Task task){
        ArrayList<ArrayList<Double>> duLieu = new ArrayList<ArrayList<Double>>();
        for(int i =0; i <5; i++){
            ArrayList<Double> arr = new ArrayList<Double>();
            arr.add(task.earlyFinish.getValue()[i]);
            arr.add(task.earlyFinish.getProbability().get(i)[0].getValue()*100);
            duLieu.add(arr);
        }
        return duLieu;
    }
     public ArrayList<ArrayList<Double>> duLieuDuration(Task task){
        ArrayList<ArrayList<Double>> duLieu = new ArrayList<ArrayList<Double>>();
        for(int i =0; i <5; i++){
            ArrayList<Double> arr = new ArrayList<Double>();
            arr.add(task.duration.getValue()[i]);
            arr.add(task.duration.getProbability().get(i)[0].getValue());
            duLieu.add(arr);
        }
        return duLieu;
    }
     
    public ArrayList<ArrayList<Double>> duLieuTotalDuration(Task task){
        ArrayList<ArrayList<Double>> duLieu = new ArrayList<ArrayList<Double>>();
        for(int i =0; i <5; i++){
            ArrayList<Double> arr = new ArrayList<Double>();
            arr.add(task.totalDuration.getValue()[i]);
            arr.add(task.totalDuration.getProbability().get(i)[0].getValue());
            duLieu.add(arr);
        }
        return duLieu;
    }
     
     public ArrayList<ArrayList<Double>> duLieuEF(Task task){
        ArrayList<ArrayList<Double>> duLieu = new ArrayList<ArrayList<Double>>();
        for(int i =0; i <5; i++){
            ArrayList<Double> arr = new ArrayList<Double>();
            arr.add(task.earlyFinish.getValue()[i]);
            arr.add(task.earlyFinish.getProbability().get(i)[0].getValue());
            duLieu.add(arr);
        }
        return duLieu;
    }
      public ArrayList<ArrayList<Double>> duLieuES(Task task){
        ArrayList<ArrayList<Double>> duLieu = new ArrayList<ArrayList<Double>>();
        for(int i =0; i <5; i++){
            ArrayList<Double> arr = new ArrayList<Double>();
            arr.add(task.earlyStart.getValue()[i]);
            arr.add(task.earlyStart.getProbability().get(i)[0].getValue());
            duLieu.add(arr);
        }
        return duLieu;
    }

    public Task[] timeCalculate(Set<Task> tasks) {
        // tasks whose critical cost has been calculated
        HashSet<Task> completed = new HashSet<Task>();
        // tasks whose critical cost needs to be calculated
        HashSet<Task> remaining = new HashSet<Task>(tasks);
        while (!remaining.isEmpty()) {
            boolean progress = false;
            for (Iterator<Task> it = remaining.iterator(); it.hasNext();) {
                Task task = it.next();
                if (completed.containsAll(task.childs)) {                   
                    for (int i = 0; i < 5; i++) {
                        double critical = 0;
                        for (Task t : task.childs) {

                            if (t.criticalCost.getValue()[i] > critical) {
                                critical = new MathLibrary().round(t.criticalCost.getValue()[i],3);
                            }
                        }
                        task.criticalCost.getValue()[i] = (critical + new MathLibrary().round(task.duration.getValue()[i],3));
                    }
                    // set task as calculated an remove
                    completed.add(task);
                    it.remove();
                    // note we are making progress
                    progress = true;
                }
            }
            // If we haven't made any progress then a cycle must exist in
            // the graph and we wont be able to calculate the critical path
            if (!progress) {
                throw new RuntimeException("Cyclic dependency, algorithm stopped!");
            }
        }
        // get the cost
        maxCost(tasks);
        HashSet<Task> startNodes = startNodes(tasks);
        calculateESEF(startNodes);
        for(Task i : completed){
            System.out.println("\n completed : "  + i.name);
        }
        // get the tasks
        Task[] ret = completed.toArray(new Task[0]);
        // create a priority list
        Arrays.sort(ret, new Comparator<Task>() {

            @Override
            public int compare(Task o1, Task o2) {
                int task1 = (int) o1.earlyStart.getValue()[2];
                int task2 = (int) o2.earlyStart.getValue()[2];
                if (task1 == task2) return 0;
                else if (task1 > task2) return 1;
                else return -1;
            }
        });

        return ret;
    }

    public void calculateESEF(Set<Task> startNodes) {
        
            for (Task startNode : startNodes) {
            for (int i = 0; i < 5; i++) {
                startNode.earlyStart.getValue()[i] = 0;
                startNode.earlyFinish.getValue()[i] = new MathLibrary().round(startNode.duration.getValue()[i],3);
            }
            setESEF(startNode);
        }
    }

    public void setESEF(Task initial) {
        System.out.println(initial.name);
        for (Task t : initial.childs) {
            for (int i = 0; i < 5; i++) {
            double completionTime = initial.earlyFinish.getValue()[i];
                if (completionTime >= t.earlyStart.getValue()[i]) {
                    t.earlyStart.getValue()[i] = new MathLibrary().round(completionTime,3);
                    t.earlyFinish.getValue()[i] = new MathLibrary().round(completionTime + t.duration.getValue()[i],3);
                }
                
                }
        setESEF(t);
                
        }
    }

    public ArrayList<Task> findParents(Set<Task> tasks) {
        ArrayList<Task> listTask = new ArrayList<Task>();
        for (Task t : tasks) {
            for (Task t1 : t.childs) {
                t1.parents.add(t);
            }
            listTask.add(t);
        }
        return listTask;
    }

    public HashSet<Task> startNodes(Set<Task> tasks) {
        HashSet<Task> remaining = new HashSet<Task>(tasks);
        for (Task t : tasks) {
            for (Task td : t.childs) {
                remaining.remove(td);
            }
        }

        System.out.print("start nodes: ");
        for (Task t : remaining) {
            System.out.print(t.name + " ");
        }
        return remaining;
    }

    public void maxCost(Set<Task> tasks) {
       
        for (int i = 0; i < 5; i++) {
            double max = -1;
            for (Task t : tasks) {
                if (t.criticalCost.getValue()[i] > max) {
                    max = new MathLibrary().round(t.criticalCost.getValue()[i],3);
                }
            }
            maxCost[i]= max;

            for (Task t : tasks) {
                t.setLatest(maxCost);
            }
        }

    }
    int i = 0;

    public void print(Task[] tasks) {

        for (int i = 0; i < 5; i++) {
            System.out.format(format, "Task", "ES", "EF", "LS", "LF", "Slack", "Critical");
            for (Task t : tasks) {
                System.out.format(format, (Object[]) t.toStringArray().get(i));
            }
        }
    }

        private int rand(int min, int max) {
        try {
            Random rn = new Random();
            int range = max - min + 1;
            int randomNum = min + rn.nextInt(range);
            return randomNum;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
// A wrapper class to hold the tasks during the calculation

