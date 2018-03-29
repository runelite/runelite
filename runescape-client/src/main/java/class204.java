import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
public class class204 {
   @ObfuscatedName("c")
   public static final String[][] field2608;
   @ObfuscatedName("i")
   public static final String[] field2607;
   @ObfuscatedName("o")
   public static Calendar field2609;
   @ObfuscatedName("a")
   static int[] field2613;

   static {
      field2608 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2607 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2609 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
