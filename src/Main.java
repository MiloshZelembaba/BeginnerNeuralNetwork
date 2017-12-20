import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by miloshzelembaba on 2017-12-19.
 */
public class Main {
    public static void main(String[] args){
        NeuralNetConstructor neuralNetConstructor = new NeuralNetConstructor();
        NeuralNetwork nn;
        try {
            nn = neuralNetConstructor.setActivationFunction(ActivationFunctionStrings.ReLU)
                    .setLayerSizes(new ArrayList<>(Arrays.asList(2, 2, 1)))
                    .setNeuronInputFunction(NeuronInputFunctionStrings.SIMPLE)
                    .setInputSpec(new NNInputSpec(3))
                    .construct();
        } catch (Exception e){
            System.out.println(e);
        }


    }
}
