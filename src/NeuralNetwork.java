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


    public void init(){
        inputLayer = new ArrayList<>();
        /* create the input layer and store them for reference */
        for (int i=0; i<inputSpec.getInputSize(); i++){
            inputLayer.add(new Neuron());
        }

        ArrayList<Neuron> currentLayer = inputLayer;
        for (int layerSize: nodesPerLayer){
            ArrayList<Neuron> newLayer = new ArrayList<>();

            for (int i=0; i<layerSize; i++){
                newLayer.add(new Neuron(activationFunction,inputFunction));
            }

            for (Neuron from: currentLayer){
                for (Neuron to: newLayer){
                    double weight = 1; // TODO: set the weights somehow
                    Edge e = new Edge(from,to,weight);
                    from.addEdge(e);
                }
            }

            currentLayer = newLayer;
        }

    }


    public void train(NNInput input, NNOutput output){
        //TODO: get the training function implemented
    }

    public void process(NNInput input){
        Queue<Neuron> neurons = new LinkedList<>();
        ArrayList<Double> inputValues = input.getValues();
        for (int i=0; i<inputLayer.size(); i++){
            inputLayer.get(i).setValue(inputValues.get(i));
        }



        /* essentially just doing a BFS sort of iterating through the layers */
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
