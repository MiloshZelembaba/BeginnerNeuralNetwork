import java.util.ArrayList;

/**
 * Created by miloshzelembaba on 2017-12-17.
 */
public class Neuron {
    private ArrayList<Edge> edges = new ArrayList<>();
    private InputFunction inputFunction;
    private ActivationFunction activationFunction;
    private ArrayList<Double> valuesFromNeurons = new ArrayList<>();
    private Double value = null;
    private double delta;
    private double learningRate = 1;
    public boolean input = false;

    public Neuron(ActivationFunction a, InputFunction i){
        inputFunction = i;
        activationFunction = a;
    }

    public Neuron(ActivationFunction a, InputFunction i, boolean in){
        inputFunction = i;
        activationFunction = a;
        input = in;
    }

    public Neuron(){}

    public double getValue(){
        return value;
    }

    public double getDelta(){
        return delta;
    }

    public void calculateDeltaOutputNode(double outputDelta){
        delta = activationFunction.derivativeProcess(inputFunction.aggregate(valuesFromNeurons));
        delta *= outputDelta;

    }

    public void calculateDeltaHiddenNode(){
        delta = activationFunction.derivativeProcess(inputFunction.aggregate(valuesFromNeurons));

        double sum = 0;
        for (Edge e: edges){
            sum += e.getWeight() * e.getToNeuron().getDelta();
        }

        delta *= sum;

    }

    public void updateWeights(){
        for (Edge e: edges){
            e.updateWeight(learningRate, e.getToNeuron().getDelta(), value);
        }
    }

    /**
     * TEMPORARY, NEED A BETTER WAY OF DOING THIS
     */
    public void clearConnectingNeurons(){
        for (Edge e: edges){
            Neuron to = e.getToNeuron();
            to.clearValuesFromNeurons();
        }
    }
    public void clearValuesFromNeurons(){ // Used above
        valuesFromNeurons.clear();
    }

    public void addResult(double d){
        valuesFromNeurons.add(d);
    }

    public void setValue(double d){
        value = d;
    }

    public void fire() {
        if (!input) { // for regular neurons (input neurons already have their values defined)
            value = activationFunction.process(inputFunction.aggregate(valuesFromNeurons));
        }

        for (Edge e: edges){
            e.getToNeuron().addResult(value * e.getWeight());
        }
    }

    public void addEdge(Edge e){
        edges.add(e);
    }
}
