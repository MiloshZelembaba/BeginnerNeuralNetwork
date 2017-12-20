import java.util.ArrayList;

/**
 * Created by miloshzelembaba on 2017-12-19.
 */
public class SimpleNNOutput extends NNOutput {
    ArrayList<Neuron> output;

    public SimpleNNOutput(ArrayList<Neuron> o){
        output = o;
    }


    public ArrayList<Double> getOutput(){
        ArrayList<Double> values = new ArrayList<>();

        for (Neuron n: output){
            values.add(n.getValue());
        }

        return values;
    }
}
