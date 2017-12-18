import java.util.ArrayList;

/**
 * Created by miloshzelembaba on 2017-12-17.
 */
public class SimpleInputFunction extends InputFunction {

    public double aggregate(ArrayList<Double> list){
        double sum = 0;
        for (double d: list){
            sum += d;
        }

        return sum/list.size();
    }
}
