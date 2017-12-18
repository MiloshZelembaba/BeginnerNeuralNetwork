import java.util.ArrayList;

/**
 * Created by miloshzelembaba on 2017-12-17.
 */
public class SimpleNNInput extends NNInput {
    ArrayList<Double> values = new ArrayList<>();

    public SimpleNNInput(ArrayList<Double> l){
        values = l;
    }

    public ArrayList<Double> getValues(){
        return values;
    }
}
