import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by miloshzelembaba on 2017-12-19.
 */
public class Main {
    public static void main(String[] args){
        NeuralNetConstructor neuralNetConstructor = new NeuralNetConstructor();
        NeuralNetwork nn = null;
        try {
            nn = neuralNetConstructor.setActivationFunction(ActivationFunctionStrings.THRESHHOLD)
                    .setLayerSizes(new ArrayList<>(Arrays.asList(2, 2, 2 )))
                    .setNeuronInputFunction(NeuronInputFunctionStrings.SIMPLE)
                    .setInputSpec(new NNInputSpec(3))
                    .construct();
        } catch (Exception e){
            System.out.println(e);
        }

        NNInput input = new SimpleNNInput(new ArrayList<>(Arrays.asList(1.0,1.0,1.0)));

        ArrayList<Neuron> output = nn.process(input);
        for (Neuron n: output){
            System.out.println(n.getValue());
        }
    }
}
