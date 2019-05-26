package Bayes;

import java.util.ArrayList;

public class Node {

    private String name;
    private String taskName;
    private double[] value = new double[5];
    public ArrayList<FieldProbability[]> probability = new ArrayList<FieldProbability[]>();
    private ArrayList<ConditionalProbability> listConditional = new ArrayList<ConditionalProbability>();
    public ArrayList<Node> childs = new ArrayList<Node>();
    public ArrayList<Node> parents = new ArrayList<Node>();
    private ArrayList<String> field = new ArrayList<String>();
    private ArrayList<Double> probabilityField = new ArrayList<Double>();

    public Node(String name) {
        this.name = name;
        this.taskName = taskName;

    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void addField(String fieldName) {
        field.add(fieldName);
    }

    public ArrayList<String> getField() {
        return field;
    }

    public void setField(ArrayList<String> field) {
        this.field = field;
    }

    public ArrayList<Double> getProbabilityField() {
        return probabilityField;
    }

    public void setProbabilityField(ArrayList<Double> probabilityField) {
        this.probabilityField = probabilityField;
    }

    public void initProbability() {
       
            for (int j = 0; j < 5; j++) {
                FieldProbability[] Listprobability1 = new FieldProbability[2];
                FieldProbability p1 = new FieldProbability(0, name + "1");
                FieldProbability p2 = new FieldProbability(0, name + "2");
                Listprobability1[0] = p1;
                Listprobability1[1] = p2;
                probability.add(Listprobability1);
            }
            
        }
    

    public void addChild(Node node) {
        this.childs.add(node);
    }

    public String getName() {
        return name;
    }

    public double[] getValue() {
        return value;
    }

    public void setValue(double[] value) {
        this.value = value;
    }

   

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Node> getChilds() {
        return childs;
    }

    public void setChilds(ArrayList<Node> childs) {
        this.childs = childs;
    }

    public ArrayList<Node> getParents() {
        return parents;
    }

    public void setParents(ArrayList<Node> parents) {
        this.parents = parents;
    }

    public ArrayList<FieldProbability[]> getProbability() {
        return probability;
    }

    public void setProbability(ArrayList<FieldProbability[]> probability) {
        this.probability = probability;
    }

   

   

    public ArrayList<ConditionalProbability> getListConditional() {
        return listConditional;
    }

    public void setListConditional(ArrayList<ConditionalProbability> listConditional) {
        this.listConditional = listConditional;
    }

}
