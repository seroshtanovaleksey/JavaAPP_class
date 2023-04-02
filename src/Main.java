import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

   public static String accountName = "MyAcc";
   public static int amount = 2000;
public static void main(String[] args) throws InsufficientAmountException {

   String[] samples = {"dgbvawq", "m,kl;po", "cbcbcbc", "z_qwertyuiop_z"};
   String reg = "(.).*\\1";

   Pattern p = Pattern.compile(reg);
   for (String s: samples) {
      Matcher m = p.matcher(s);
      System.out.println(m.matches());
   };

   String text = "The quick brown fox";
// Everything from index 4 onwards
   System.out.println(text.substring(4));
// Index 0 up to but not including index 3.
   System.out.println(text.substring(0, 3));

}

public static int deduct(String accountToProcess, int amtToCacheOut) throws InsufficientAmountException {
   if (!accountName.equals(accountToProcess)) {
      throw new AccessDeniedException("Provided account doesn't match the target one");
   }

   if (amount<amtToCacheOut) {
      throw new InsufficientAmountException("Not enough money to withdraw " + amtToCacheOut);
   }
   amount = amount - amtToCacheOut;
   return amount;
}


}