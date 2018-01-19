import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class193 {
   @ObfuscatedName("n")
   static final String[][] field2568;
   @ObfuscatedName("v")
   static final String[] field2569;
   @ObfuscatedName("y")
   static Calendar field2567;

   static {
      field2568 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2569 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2567 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfa;B)V",
      garbageValue = "-30"
   )
   public static void method3653(Huffman var0) {
      class276.huffman = var0;
   }
}
