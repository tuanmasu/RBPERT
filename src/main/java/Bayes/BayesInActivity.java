package Bayes;

import java.util.ArrayList;
public class BayesInActivity {

    public void initParents(Task task) {
        //khoi tao cac node cha me 
        ArrayList<Node> parentsEF = new ArrayList<Node>();
        parentsEF.add(task.earlyStart);
        parentsEF.add(task.totalDuration);
        task.earlyFinish.setParents(parentsEF);
        ArrayList<Node> parentsLS = new ArrayList<Node>();
        parentsLS.add(task.latestFinish);
        parentsLS.add(task.totalDuration);
        task.latestStart.setParents(parentsLS);       
        task.earlyStart.setParents(findParentsES(task));       
        task.latestFinish.setParents(findParentsLF(task));

    }

    //add node con 
    public void initDependencies(Task task) {
        for (int i = 0; i < task.earlyStart.parents.size(); i++) {
            if (task.earlyStart.parents.get(i) != null) {
                task.earlyStart.parents.get(i).addChild(task.earlyStart);
            }
        }
        for (int i = 0; i < task.earlyFinish.parents.size(); i++) {
            if (task.earlyFinish.parents.get(i) != null) {
                task.earlyFinish.parents.get(i).childs.add(task.earlyFinish);
            }
        }
        for (int i = 0; i < task.latestStart.parents.size(); i++) {
            if (task.latestStart.parents.get(i) != null) {
                task.latestStart.parents.get(i).childs.add(task.latestStart);
            }
        }
        for (int i = 0; i < task.latestFinish.parents.size(); i++) {
            if (task.latestFinish.parents.get(i) != null) {
                task.latestFinish.parents.get(i).childs.add(task.latestFinish);
            }
        }
    }
    
    //add node parent 
    public ArrayList<Node> findParentsES(Task task) {
        ArrayList<Node> list = new ArrayList<Node>();
      
        if (task.parents.size() != 0) {
            Task[] ret = task.parents.toArray(new Task[0]);
            for (int i = 0; i < ret.length; i++) {
                list.add(ret[i].earlyFinish);
            }
            
        }
        return list;
    }

    public ArrayList<Node> findParentsLF(Task task) {
        ArrayList<Node> list = new ArrayList<Node>();
        if (task.childs.size() != 0) {
            Task[] ret = task.childs.toArray(new Task[0]);
           
            for (int i = 0; i < ret.length; i++) {
                list.add(ret[i].earlyFinish);
            }          
        }
        return list;
    }

    public void initAllOfActivity(Task[] list) {
        for (int i = 0; i < list.length; i++) {
            initParents(list[i]);
            list[i].earlyStart.initProbability();
            list[i].earlyFinish.initProbability();
            list[i].latestFinish.initProbability();
            list[i].latestFinish.initProbability();
        }
        for (int i = 0; i < list.length; i++) {
            initDependencies(list[i]);
        }

    }
}
