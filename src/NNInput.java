import java.util.ArrayList;

/**
 * Created by miloshzelembaba on 2017-12-17.
 */
public abstract class NNInput {
    protected int inputSize;


    public int getInputSize(){
        return inputSize;
    }

    public abstract ArrayList<Double> getValues();

}
