package mis;

public class findUniqInArr {
    public static int getUniq(int [] arr){
        int unq = 0;
        for(int n : arr){
            unq ^= n;
        }
        return unq;
    }

    public static void main(String[] args) {
        System.out.println(findUniqInArr.getUniq(new int[]{1,2,3,3,2}));
    }
}
