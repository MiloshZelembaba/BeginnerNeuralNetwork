import java.util.ArrayList;
import java.util.Arrays;

/**
    * Created by miloshzelembaba on 2017-12-22.
*/
public class XOR_NN {
    public static void main(String[] args){
        NeuralNetConstructor neuralNetConstructor = new NeuralNetConstructor();


        NeuralNetwork nn = null;
        try {
            nn = neuralNetConstructor.setActivationFunction(new Sigmoid())
                    .setLayerSizes(new ArrayList<>(Arrays.asList(2,2,1)))
                    .setNeuronInputFunction(new SimpleInputFunction())
                    .setInputSpec(new SimpleNNInputSpec(3))
                    .construct();
        } catch (Exception e) {
            System.out.println(e);
        }

        NNInput in1 = new SimpleNNInput(new ArrayList<>(Arrays.asList(1.0,1.0,1.0)));
        ArrayList<Double> out1 = new ArrayList<>(Arrays.asList(1.0));
        NNInput in2 = new SimpleNNInput(new ArrayList<>(Arrays.asList(1.0, 0.0,1.0)));
        ArrayList<Double> out2 = new ArrayList<>(Arrays.asList(0.0));
        NNInput in3 = new SimpleNNInput(new ArrayList<>(Arrays.asList(0.0, 1.0,1.0)));
        ArrayList<Double> out3 = new ArrayList<>(Arrays.asList(0.0));
        NNInput in4 = new SimpleNNInput(new ArrayList<>(Arrays.asList(0.0, 0.0,1.0)));
        ArrayList<Double> out4 = new ArrayList<>(Arrays.asList(1.0));

        for (int i=0; i<100; i++){
            nn.train(in1,out1);
            nn.train(in2,out2);
            nn.train(in3,out3);
            nn.train(in4,out4);
        }


        ArrayList<Double> output = nn.process(in1).getOutput();
        System.out.print("1,1 = ");
        for (double d : output) {
            System.out.println(d);
        }

        output = nn.process(in2).getOutput();
        System.out.print("1,0 = ");
        for (double d : output) {
            System.out.println(d);
        }

        output = nn.process(in3).getOutput();
        System.out.print("0,1 = ");
        for (double d : output) {
            System.out.println(d);
        }

        output = nn.process(in4).getOutput();
        System.out.print("0,0 = ");
        for (double d : output) {
            System.out.println(d);
        }
    }



}

