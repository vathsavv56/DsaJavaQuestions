package mis;

public class fibSeriesBinets {
    public static int getAtIndex(int index){
        return (int) (Math.pow((1 + Math.pow(5 , 0.5) / 2) , index) - Math.pow((1 - Math.pow(5 , 0.5) / 2) , index)) )/Math.pow(5,0.5);
    }
}
