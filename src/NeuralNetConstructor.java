import java.util.ArrayList;

/**
 * Created by miloshzelembaba on 2017-12-17.
 */
public class NeuralNetConstructor {
    private NeuralNetwork nn = new NeuralNetwork();
    private NNInputSpec input; // to specify the format of the input
    private int activationFunction = 0; // activation function for each neuron (they all get the same one)
    private int neuronInputFunction = 0; // the neuron's input function (they all get the same one)
    private ArrayList<Integer> layerSizes;
    /**
     * Better have constructed everything properly orr it's throwing your ass an error
     * @return a NeuralNetwork object
     */
    public NeuralNetwork construct() throws Exception{
        if (input == null || activationFunction == 0 || neuronInputFunction == 0){
            throw new Exception("Did not properly construct Neural Network");
        }

        nn.setInput(this.input);
        nn.setLayerSizes(layerSizes);
        nn.init();

        return nn;
    }

    public NeuralNetConstructor setLayerSizes(ArrayList<Integer> list){
        this.layerSizes = list;
        return this;
    }

    public NeuralNetConstructor setInputSpec(NNInputSpec in){
        this.input = in;
        return this;
    }

    public NeuralNetConstructor setActivationFunction(int s) throws Exception{
        if (!ActivationFunctionStrings.contains(s)){
            throw new Exception("Invalid activation function type");
        }

        this.activationFunction = s;
        nn.setActivationFunction(this.activationFunction);

        return this;
    }

    public NeuralNetConstructor setActivationFunction(ActivationFunction a) throws Exception{
        nn.setActivationFunction(a);
        activationFunction = -1; // just a place holder so it doens't cause an error in construct()
        return this;
    }

    public NeuralNetConstructor setNeuronInputFunction(int s) throws Exception{
        if (!NeuronInputFunctionStrings.contains(s)){
            throw new Exception("Invalid neuron input function type");
        }
        this.neuronInputFunction = s;
        nn.setNeuronInputFunction(this.neuronInputFunction);
        return this;
    }

    public NeuralNetConstructor setNeuronInputFunction(InputFunction i) throws Exception{
        nn.setNeuronInputFunction(i);
        neuronInputFunction = -1; // just a place holder so it doens't cause an error in construct()
        return this;
    }

}
