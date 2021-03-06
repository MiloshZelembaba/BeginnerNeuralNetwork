/**
 * Created by miloshzelembaba on 2017-12-17.
 */
public class ReLU extends ActivationFunction {

    public double process(double input){
        return Math.max(0,input);
    }

    public double derivativeProcess(double input){
        if (input <= 0){
            return 0;
        }

        return 1;
    }
}
