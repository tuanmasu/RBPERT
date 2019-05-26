package Bayes;

import java.util.ArrayList;


//class xac suat co dk 
public class ConditionalProbability {
    private String fieldName;
    private ArrayList<String> parentsField = new ArrayList<String>();
    private double value;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public ArrayList<String> getParentsField() {
        return parentsField;
    }

    public void setParentsField(ArrayList<String> parentsField) {
        this.parentsField = parentsField;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public ConditionalProbability(double value,String fieldName, String...  parentsField) {
        this.fieldName = fieldName;
        this.value = value;
        for (String t : parentsField) {
            this.parentsField.add(t);
            
        }
            
        
    }
    public String print(){
        String str =parentsField.get(0);
        for(int i =1; i < parentsField.size(); i++){
            str += ","+parentsField.get(i);
        }
        return "P("+fieldName+"|"+str+") ="+value;
    }
    
}
