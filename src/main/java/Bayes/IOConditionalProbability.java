package Bayes;

import java.util.ArrayList;

public class IOConditionalProbability {

    Task[] result;

    public IOConditionalProbability(Task[] result) {
        this.result = result;
    }

    public IOConditionalProbability() {
    }

    public void inputTask(Task task) {
        //conditional probability for EF node
        ConditionalProbability EFCon1 = new ConditionalProbability(1, task.name + ".EF1", "D1", task.name + ".ES1");
        ConditionalProbability EFCon2 = new ConditionalProbability(0.7, task.name + ".EF1", "D1", task.name + ".ES2");
        ConditionalProbability EFCon3 = new ConditionalProbability(0.3, task.name + ".EF1", "D2", task.name + ".ES1");
        ConditionalProbability EFCon4 = new ConditionalProbability(0, task.name + ".EF1", "D2", task.name + ".ES2");
        ConditionalProbability EFCon5 = new ConditionalProbability(0, task.name + ".EF2", "D1", task.name + ".ES1");
        ConditionalProbability EFCon6 = new ConditionalProbability(0.3, task.name + ".EF2", "D1", task.name + ".ES2");
        ConditionalProbability EFCon7 = new ConditionalProbability(0.7, task.name + ".EF2", "D2", task.name + ".ES1");
        ConditionalProbability EFCon8 = new ConditionalProbability(1, task.name + ".EF2", "D2", task.name + ".ES2");
        task.earlyFinish.getListConditional().add(EFCon1);
        task.earlyFinish.getListConditional().add(EFCon2);
        task.earlyFinish.getListConditional().add(EFCon3);
        task.earlyFinish.getListConditional().add(EFCon4);
        task.earlyFinish.getListConditional().add(EFCon5);
        task.earlyFinish.getListConditional().add(EFCon6);
        task.earlyFinish.getListConditional().add(EFCon7);
        task.earlyFinish.getListConditional().add(EFCon8);
        //conditional probability for ES node        
        if (task.earlyStart.parents.size() > 0) {
            ArrayList<String> result = new ArrayList<String>();
            ArrayList<Double> luuXacSuat = new ArrayList<Double>();
            int n = task.earlyStart.parents.size()+1;
            index("", n, result);
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
                int[] indexs = new int[n];
                for (int j = 0; j < n; j++) {
                    indexs[j] = result.get(i).charAt(j) - 48;
                }

                String str = "P(" + task.name + ".ES" + indexs[n - 1] + "/";
                String[] cha = new String[n - 1];
                for (int j = 0; j < n - 2; j++) {
                    str += task.earlyStart.parents.get(j).getName() + indexs[j] + ",";
                    cha[j] = task.earlyStart.parents.get(j).getName() + indexs[j];
                }
                str += task.earlyStart.parents.get(n - 2).getName() + indexs[n - 2] + ")=";
                System.out.println(str);
                 double giatri=0;
                 //khởi tạo giá trị xác suất có đkiện, ở vị trí i chẵn là những xác suất 1 : nên cần tìm số lần xuất hiện 1 ở đkiện
                 // vị trí lẻ i%2 == 1 : xác suất 2 : tìm số lần xuất hiện 2 ở đkiện 
                 if(i % 2 == 0)
                 {
                     giatri = timeappear1(indexs)/(n-1);
                     luuXacSuat.add(i,giatri);
                 }else{
                     giatri = timeappear2(indexs)/(n-1);
                     luuXacSuat.add(i,giatri);
                 }
                cha[n - 2] = task.earlyStart.parents.get(n - 2).getName() + indexs[n - 2];
                ConditionalProbability pro = new ConditionalProbability(giatri, task.name + ".ES" + indexs[n - 1], cha);
                System.out.println("conditional probability : " + pro.print());
                task.earlyStart.getListConditional().add(pro);
            }
             
        }
    }
    //index off nodes, 1 : nodes event occurred . 2 : nodes event not occurred
    public void index(String str, int len, ArrayList<String> result) {
        if (str.length() < len) {
            for (int i = 1; i <= 2; i++) {
                index(str + String.valueOf(i), len, result);
            }
        } else {
            result.add(new String(str));
        }
    }

    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<String>();
        IOConditionalProbability demo = new IOConditionalProbability();
        int n = 3;
//        demo.index("", n, result);
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
            int[] indexs = new int[n];
            for (int j = 0; j < n; j++) {
                indexs[j] = result.get(i).charAt(j) - 48;
            }
            String[] parent = {"A", "B", "C"};
            String str = "P(D" + indexs[n - 1] + "/";
            for (int j = 0; j < n - 2; j++) {
                str += parent[j] + indexs[j] + ",";
            }
            str += parent[n - 2] + indexs[n - 2] + ")=";
            System.out.println(str);
        }

    }

    public void inputListTask() {
        for (int i = 0; i < result.length; i++) {
            inputTask(result[i]);
        }
    }
    
    private double timeappear1(int a[])
    {
        double count = 0.0;
        for(int i= 0  ; i < a.length - 1 ; i ++)
        {
            if(a[i]==1) count ++;
        }
        return count;
    }
    private double timeappear2(int a[])
    {
        double count = 0.0;
        for(int i= 0 ; i < a.length - 1 ; i ++)
        {
            if(a[i]==2) count ++;
        }
        return count;
    }

}
