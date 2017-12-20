import java.util.ArrayList;

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
            inputLayer.add(new Neuron(activationFunction,inputFunction, true));
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
                    double weight = 1; // TODO: set the weights somehow
                    Edge e = new Edge(from,to,weight);
                    from.addEdge(e);
                }
            }

            currentLayer = newLayer;
            layers.add(currentLayer);
        }

    }


    public void train(NNInput input, ArrayList<Double> expectedOutput){
        ArrayList<Double> actualOutput = process(input).getOutput();

        /* output layer calculation is different than the rest */
        ArrayList<Neuron> outputLayer = layers.get(layers.size()-1);
        for (int i=0; i<outputLayer.size(); i++){
            Neuron n = outputLayer.get(i);
            n.calculateDeltaOutputNode(calculateError(expectedOutput.get(i), actualOutput.get(i)));
        }

        /* all the hidden layers */
        for (int i=layers.size()-2; i>0; i--){
            for (Neuron n: layers.get(i)){
                n.calculateDeltaHiddenNode();
                n.updateWeights();
            }
        }

        /* the input layer weight updates */
        for (Neuron n: layers.get(0)){
            n.updateWeights();
        }
    }

    private double calculateError(double y, double h){
        return y - h;
    }

    public NNOutput process(NNInput input){
        ArrayList<Double> inputValues = input.getValues();
        for (int i=0; i<inputLayer.size(); i++){
            inputLayer.get(i).setValue(inputValues.get(i));
        }

        for (ArrayList<Neuron> layer: layers){
            /* need a better way of doing this, whats goin on is that
            it's erasing all of the input from any previous runs on an input
             */
            Neuron tmp = layer.get(0);
            tmp.clearConnectingNeurons();

            for (Neuron n: layer){
                n.fire();
            }
        }

        return new SimpleNNOutput(layers.get(layers.size()-1));

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
