import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class189 {
   @ObfuscatedName("b")
   public static final String[][] field2528;
   @ObfuscatedName("s")
   public static final String[] field2526;
   @ObfuscatedName("r")
   public static Calendar field2530;
   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   static class298 field2529;

   static {
      field2528 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2526 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2530 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
