import java.util.ArrayList;

/**
 * Created by miloshzelembaba on 2017-12-22.
 */
public class BiasNNInput extends NNInput {
    ArrayList<Double> values = new ArrayList<>();
    ArrayList<Double> bias = new ArrayList<>();

    public BiasNNInput(ArrayList<Double> l, ArrayList<Double> b){
        values = l;
        bias = b;
    }

    public ArrayList<Double> getValues(){
        ArrayList<Double> tmp = new ArrayList<>(values);
        for (Double v: bias){
            tmp.add(v);
        }
        return tmp;
    }
}
