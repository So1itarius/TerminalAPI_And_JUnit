import java.util.ArrayList;
import java.util.HashMap;


class Terminal {
    static HashMap<String, Integer> productsList = new HashMap<String, Integer>();
    static HashMap<String, int[]> discountList = new HashMap<String, int[]>();
    private static ArrayList<String> basket = new ArrayList<String>();

    static void setPrice(String name, int price){
        productsList.put(name, price);
    }
    static void purchase(String name){
        basket.add(name);
    }
    static void setDiscount (String name, int count, int price ){
        int[] arr = {count,price};
        discountList.put(name, arr);
    }
    static void ClearBasket(){

        basket.clear();
    }
    static int calculate(){
        HashMap<String, Integer> wordToCount = new HashMap<>();
        int sum=0;
        int discPrice;
        int totalPrice;
        for (String word : basket) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }

        for (String key : wordToCount.keySet()) {
            int[] getDiscountValue=discountList.get(key);
            int getProductValue=productsList.get(key);

            if (getDiscountValue!=null){
            discPrice=(wordToCount.get(key)/getDiscountValue[0])*getDiscountValue[1];
            totalPrice=(wordToCount.get(key)-((wordToCount.get(key)/getDiscountValue[0])*getDiscountValue[0]))*getProductValue+discPrice;
            sum+=totalPrice;
            }
            else {
                sum+=wordToCount.get(key)*getProductValue;
            }
        }
        return sum;

    }
}

