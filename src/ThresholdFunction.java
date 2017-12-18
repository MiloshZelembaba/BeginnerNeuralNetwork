/**
 * Created by miloshzelembaba on 2017-12-17.
 */
public class ThresholdFunction extends ActivationFunction {

    public double process(double input){
        return Math.max(0,input);
    }
}
