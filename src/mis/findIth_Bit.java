package mis;



public class findIth_Bit {


    public static int find(int n, int i) {
        // Shift n right by i positions and check the last bit
        return (n >> i) & 1;
    }



}
