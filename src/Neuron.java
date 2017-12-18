import java.util.ArrayList;

/**
 * Created by miloshzelembaba on 2017-12-17.
 */
public class Neuron {
    private ArrayList<Edge> edges = new ArrayList<>();
    private InputFunction inputFunction;
    private ActivationFunction activationFunction;

    public Neuron(ActivationFunction a, InputFunction i){
        inputFunction = i;
        activationFunction = a;
    }

    public Neuron(){}

    public void addEdge(Edge e){
        edges.add(e);
    }
}
