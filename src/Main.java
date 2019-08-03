import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static boolean state = true;
    private static List<BlockChain> list;
    private static BlockChain block = new BlockChain();
    private static Scanner scanner = new Scanner(System.in);
    private static String input="";
    public static void main(String[] args){
//        BlockChain blockChain = new BlockChain();
//        list = new ArrayList<>();
//
//        while (!input.equalsIgnoreCase("stop")){
//            input = enterData();
//            if (!input.equalsIgnoreCase("stop")){
//                blockChain = createBlock(input);
//                System.out.println(blockChain.toString());
//            }
//
//        }

        double strong = 6/14 * (-3/6 * log2)
    }



    public static String enterData(){
        input = scanner.nextLine();
        return input;
    }

    public static BlockChain createBlock(String input){
        if (state){
            block.setData(input);
            block.setPreviosHash("0");
            block.setCurrentHash(getHash(input));
            state = false;
        }else{
            block.setData(input);
            block.setPreviosHash(block.getCurrentHash());
            block.setCurrentHash(getHash(input));
        }
        list.add(block);
        return block;
    }



    public static String getHash(String input){
        try {

            // Static getInstance method is called with hashing SHA
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            // digest() method called
            // to calculate message digest of an input
            // and return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                System.out.println(">>>>> : " + hashtext);
                hashtext = "0" + hashtext;
            }

            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown"
                    + " for incorrect algorithm: " + e);

            return null;
        }
    }

}
