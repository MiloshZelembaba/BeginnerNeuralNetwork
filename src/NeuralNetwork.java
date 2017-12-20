import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by miloshzelembaba on 2017-12-17.
 */
public class NeuralNetwork {
    private int numLayers;
    private ActivationFunction activationFunction;
    private InputFunction inputFunction;
    private NNInputSpec inputSpec;
    private ArrayList<Integer> nodesPerLayer;

    private ArrayList<Neuron> inputLayer;
    private ArrayList<ArrayList<Neuron>> layers; // unnecessary but it makes things easy for now, i'll see where it takes me


    public void init(){
        inputLayer = new ArrayList<>();
        /* create the input layer and store them for reference */
        for (int i=0; i<inputSpec.getInputSize(); i++){
            inputLayer.add(new Neuron(activationFunction,inputFunction));
        }
        layers = new ArrayList<>();
        layers.add(inputLayer);

        ArrayList<Neuron> currentLayer = inputLayer;
        for (int layerSize: nodesPerLayer){
            ArrayList<Neuron> newLayer = new ArrayList<>();

            for (int i=0; i<layerSize; i++){
                newLayer.add(new Neuron(activationFunction,inputFunction));
            }

            for (Neuron from: currentLayer){
                for (Neuron to: newLayer){
                    double weight = 0.5; // TODO: set the weights somehow
                    Edge e = new Edge(from,to,weight);
                    from.addEdge(e);
                }
            }

            currentLayer = newLayer;
            layers.add(currentLayer);
        }

    }


    public void train(NNInput input, NNOutput output){
        //TODO: get the training function implemented
    }

    public ArrayList<Neuron> process(NNInput input){
        ArrayList<Double> inputValues = input.getValues();
        for (int i=0; i<inputLayer.size(); i++){
            inputLayer.get(i).setValue(inputValues.get(i));
        }

        for (ArrayList<Neuron> layer: layers){
            for (Neuron n: layer){
                n.fire();
            }
        }

        return layers.get(layers.size()-1);

    }


    public void setLayerSizes(ArrayList<Integer> l){
        nodesPerLayer = l;
        numLayers = l.size();
    }

    public void setActivationFunction(int s){
        if (s == ActivationFunctionStrings.THRESHHOLD){
            activationFunction = new ThresholdFunction();
        }

    }

    public void setNeuronInputFunction(int s){
        if (s == NeuronInputFunctionStrings.SIMPLE){
            inputFunction = new SimpleInputFunction();
        }
    }

    public void setInput(NNInputSpec n){
        inputSpec = n;
    }
}
