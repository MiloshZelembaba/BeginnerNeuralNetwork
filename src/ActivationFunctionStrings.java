/**
 * Created by miloshzelembaba on 2017-12-17.
 */
public abstract class ActivationFunctionStrings {
    public static int THRESHHOLD = 1;
    public static int SIGMOID = 2;
    public static int HYPERBOLIC_TANGET = 3;
    public static int ReLU = 4;
    private static final int MAX = 4; // always update this with the max

    public static boolean contains(int s){
        return s > 0 && s <= MAX;

    }
}
