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

    public Neuron(ActivationFunction a, InputFunction i){
        inputFunction = i;
        activationFunction = a;
    }

    public Neuron(){}

    public double getValue(){
        return value;
    }

    public void addResult(double d){
        valuesFromNeurons.add(d);
    }

    public void setValue(double d){
        value = d;
    }

    public void fire() {
        if (value == null) { // for regular neurons (input neurons already have their values defined)
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
