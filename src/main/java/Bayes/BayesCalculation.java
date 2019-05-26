package Bayes;

public class BayesCalculation {

    private Task[] result;

    public BayesCalculation(Task[] result) {
        this.result = result;
    }

    public BayesCalculation() {

    }

    public void calculateBayes(Node node) {
        int chay = 0;
        while (chay < 5) {
//
            // FieldProbability[] fieProbability = new FieldProbability[2];
                if (node.parents.size() == 0) {
                    node.getProbability().get(chay)[0].setValue(1);
                    node.getProbability().get(chay)[1].setValue(0);
                }else {
                    for (int i = 0; i < 2; i++) {
                        double value = 0;
                        FieldProbability probability = node.getProbability().get(chay)[i];
                        for (int j = 0; j < node.getListConditional().size(); j++) {
                            if (probability.getFieldName().equals(node.getListConditional().get(j).getFieldName())) {
                                ConditionalProbability con = node.getListConditional().get(j);
                                double value1 = con.getValue();
                                for (int k = 0; k < con.getParentsField().size(); k++) {
                                    for (int h = 0; h < node.parents.size(); h++) {
                                        for (int l = 0; l < 2; l++) {

                                            if (con.getParentsField().get(k).equals(node.parents.get(h).getProbability().get(chay)[l].getFieldName())) {
                                                value1 = value1 * node.parents.get(h).getProbability().get(chay)[l].getValue();
                                            }
                                        }
                                    }
                                }
                                value += value1;
                            }
                        }
                        //FieldProbability
                        node.probability.get(chay)[i].setValue(value);

                    }

                }
                
                chay++;
        }

    }

    public void calculateTask() {
        for (int i = 0; i < result.length; i++) {
     
            calculateBayes(result[i].earlyStart);
            calculateBayes(result[i].earlyFinish);

        }
    }
}
