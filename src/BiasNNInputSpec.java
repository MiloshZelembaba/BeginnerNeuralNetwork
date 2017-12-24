
/**
 * Created by miloshzelembaba on 2017-12-22.
 */
public class BiasNNInputSpec extends NNInputSpec {
    int numBias = 0;

    public BiasNNInputSpec(int s, int b){
        numBias = b;
        inputSize = s;
    }

    public int getInputSize(){
        return inputSize + numBias;
    }
}
