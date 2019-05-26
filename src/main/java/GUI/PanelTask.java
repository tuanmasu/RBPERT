package GUI;

import Bayes.Task;
import Bayes.TimeCalculation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

//class show mang bayesian
public class PanelTask extends JPanel {

    ArrayList<ActivityLayout> list = new ArrayList<ActivityLayout>();
    ArrayList<Task> listTask;
    Task startTask;
    ArrayList<Task> finishTask = new ArrayList<Task>();
    Point poit1;
    Point poit2;
    JButton startBtn , finishBtn;
    JPanel start,finish;
    public PanelTask(ArrayList<Task> listTask) {
        setLayout(null);
        this.listTask = listTask;
        
        for (int i = 0; i < listTask.size(); i++) {
            ArrayList<Task> listTruyen = new ArrayList<Task>();
//            System.out.println("list task :+"+listTask.get(i).name
//            +" : "+ listTask2.get(i).name +":"+listTask1.get(i));
            listTruyen.add(listTask.get(i));
            final ActivityLayout a = new ActivityLayout(listTask.get(i).name, listTruyen);

           // System.out.println("size là :" + a.getListTask().size());
            a.setLocation(i * 150, i*20);
            a.setSize(170,170);
            //System.out.println("tọa độ :" + a.getButton2().getX());
            a.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent me) {
                    a.setLocation(a.getX() + me.getX(), a.getY() + me.getY());
                    repaint();

                }

                @Override
                public void mouseMoved(MouseEvent me) {

                }
            });
            list.add(a);
        }
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
        }
        startBtn = new JButton("start");
        Point point1 = new Point(10,10);
        startBtn.setSize(100, 100);
        startBtn.setLocation(point1);
        startBtn.addActionListener(new ActionListener() {
             @Override
                    public void actionPerformed(ActionEvent ae) {
                                TimeCalculation cri = new TimeCalculation();
                                ArrayList<ArrayList<Double>> duLieu = new ArrayList<ArrayList<Double>>();
                                duLieu = cri.duLieuES(startTask);
                                JFrame fame = new JFrame();
                                DoThi doThi = new DoThi(duLieu," start");
                                fame.add(doThi);
                                fame.setSize(500, 500);
                                fame.setVisible(true);
                    }
        });
        start = new JPanel();
        start.setLocation(0,250);
        start.setBackground(Color.GRAY);
        start.setLayout(null);
        start.add(startBtn);
        start.setSize(120,120);
        finishBtn = new JButton("finish");
        Point point3 = new Point(10,10);
        finishBtn.setLocation(point3);
        finishBtn.setSize(100, 100);
        finishBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JFrame fame = new JFrame();
            Result re = new Result(finishTask);
            fame.add(re);
            fame.setVisible(true);
            fame.setSize(1500, 1000);
            }
        });
        finish = new JPanel();
        finish.setLocation(1250,250);
        finish.setBackground(Color.GRAY);
        finish.setLayout(null);
        finish.add(finishBtn);
        finish.setSize(120,120);
        this.add(start);
        this.add(finish);
       
        start.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
               start.setLocation(start.getX() + me.getX(), start.getY() + me.getY());
               repaint();
            }

            @Override
            public void mouseMoved(MouseEvent me) {      
            }
        });
       
        finish.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent me) {
               finish.setLocation(finish.getX() + me.getX(), finish.getY() + me.getY());
               repaint();
            }

            @Override
            public void mouseMoved(MouseEvent me) {
            }
        });

    }

    public ArrayList<ActivityLayout> getList() {
        return list;
    }

    public void setList(ArrayList<ActivityLayout> list) {
        this.list = list;
    }

    public ArrayList<Task> getListTask() {
        return listTask;
    }

    public void setListTask(ArrayList<Task> listTask) {
        this.listTask = listTask;
    }

    public Point getPoit1() {
        return poit1;
    }

    public void setPoit1(Point poit1) {
        this.poit1 = poit1;
    }

    public Point getPoit2() {
        return poit2;
    }

    public void setPoit2(Point poit2) {
        this.poit2 = poit2;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", 50, 50));
        for(int i=0;i<listTask.size();i++){
            Task task = listTask.get(i);
            if(task.parents.isEmpty()){
                    g.drawLine(start.getX()+50, start.getY() + 50, list.get(i).getX(), list.get(i).getY()+85);
                    g.drawLine(list.get(i).getX(), list.get(i).getY()+85, list.get(i).getX()-5, list.get(i).getY()+80);
                    g.drawLine(list.get(i).getX(), list.get(i).getY()+85, list.get(i).getX()-5, list.get(i).getY()+90);
                    startTask = task;
            }
            if(task.getChilds().size() == 0){
                    g.drawLine(list.get(i).getX() + 170, list.get(i).getY()+85, finish.getX(), finish.getY()+50);
                    g.drawLine(finish.getX(), finish.getY()+50, finish.getX()-3, finish.getY()+45);
                    g.drawLine(finish.getX(), finish.getY()+50, finish.getX()-3, finish.getY()+55);
                    if(!finishTask.contains(task)){
                        finishTask.add(task);
                    }
                    
            }
        }
        for (int i = 0; i < listTask.size(); i++) {
            if (listTask.get(i).getChilds().size() != 0) {
                // System.out.println("?/");
                Task[] li = listTask.get(i).getChilds().toArray(new Task[0]);
                // System.out.println("?/"+li[0].name);
                // System.out.println("day la :"+list.get(0).tit);
                for (int j = 0; j < li.length; j++) {
                    for (int k = 0; k < listTask.size(); k++) {
                        if (li[j].name.equals(list.get(k).tit)) {
                            //  System.out.println("vao?");

                            g.drawLine(list.get(i).getX() + 170, list.get(i).getY() + 85, list.get(k).getX(), list.get(k).getY()+85);
                            g.drawLine(list.get(k).getX(), list.get(k).getY()+ 85, list.get(k).getX()-5, list.get(k).getY()+90);
                            g.drawLine(list.get(k).getX(), list.get(k).getY()+85, list.get(k).getX()-5, list.get(k).getY()+80);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Task t1 = new Task("A");
        Task t2 = new Task("B", t1);
        Task t3 = new Task("C", t1);
        Task t4 = new Task("D", t3, t2);
        Task t5 = new Task("E", t4);
        ArrayList<Task> list = new ArrayList<Task>();
        list.add(t5);
        list.add(t4);
        list.add(t3);
        list.add(t2);
        list.add(t1);
        PanelTask pan = new PanelTask(list);
        JFrame fame = new JFrame();
        fame.setSize(1500, 1000);
        fame.add(pan);
        fame.setVisible(true);
        fame.setDefaultCloseOperation(fame.EXIT_ON_CLOSE);
    }
}
