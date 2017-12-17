/**
 * Created by miloshzelembaba on 2017-12-17.
 */
public abstract class NeuronInputFunctionStrings {
    public static int SIMPLE = 1;
    private static final int MAX = 1; // always update this with the max

    public static boolean contains(int s){
        return s > 0 && s <= MAX;

    }
}
