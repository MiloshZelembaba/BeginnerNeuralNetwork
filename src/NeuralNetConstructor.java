import java.util.ArrayList;

/**
 * Created by miloshzelembaba on 2017-12-17.
 */
public class NeuralNetConstructor {
    private int numLayers = 2;
    private NeuralNetwork nn;
    private NNInput input; // to specify the format of the input
    private int activationFunction = 0; // activation function for each neuron (they all get the same one)
    private int neuronInputFunction = 0; // the neuron's input function (they all get the same one)
    /**
     * Better have constructed everything properly orr it's throwing your ass an error
     * @return a NeuralNetwork object
     */
    public NeuralNetwork construct() throws Exception{
        if (input == null || activationFunction == 0 || neuronInputFunction == 0){
            throw new Exception("Did not properly construct Neural Network");
        }

        nn = new NeuralNetwork();
        nn.setActivationFunction(this.activationFunction);
        nn.setNeuronInputFunction(this.neuronInputFunction);
        nn.setInput(this.input);
        nn.setNumLayers(this.numLayers);
        nn.init();

        return nn;
    }

    public NeuralNetConstructor setInput(NNInput in){
        this.input = in;
        return this;
    }

    public NeuralNetConstructor setNumLayers(int n){
        this.numLayers = n;
        return this;
    }

    public NeuralNetConstructor setActivationFunction(int s) throws Exception{
        if (!ActivationFunctionStrings.contains(s)){
            throw new Exception("Invalid activation function type");
        }

        this.activationFunction = s;
        return this;
    }

    public NeuralNetConstructor setNeuronInputFunction(int s) throws Exception{
        if (!NeuronInputFunctionStrings.contains(s)){
            throw new Exception("Invalid neuron input function type");
        }
        this.neuronInputFunction = s;
        return this;
    }

}