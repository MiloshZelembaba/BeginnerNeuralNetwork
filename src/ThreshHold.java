/**
 * Created by miloshzelembaba on 2017-12-20.
 */
public class ThreshHold extends ActivationFunction {
    double threshhold = 1;

    public ThreshHold(double v){
        threshhold = v;
    }

    public double process(double input){
        if (input >= threshhold) {
            return 1;
        }

        return 0;
    }

    public double derivativeProcess(double input){
        return 0;
    }

}

