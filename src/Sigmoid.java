/**
 * Created by miloshzelembaba on 2017-12-22.
 */
public class Sigmoid extends ActivationFunction {
    public double process(double input){
        return 1/(1+Math.exp(-1*input));
    }

    public double derivativeProcess(double input){
        return (Math.exp(input)/(Math.pow(Math.exp(input) + 1,2)));
    }
}

