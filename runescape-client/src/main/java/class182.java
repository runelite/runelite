import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
public class class182 {
   @ObfuscatedName("c")
   public static final String[] field2451;
   @ObfuscatedName("i")
   public static final String[][] field2452;
   @ObfuscatedName("rs")
   @ObfuscatedGetter(
      intValue = -403569393
   )
   static int field2453;
   @ObfuscatedName("e")
   public static Calendar field2455;

   static {
      field2452 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2451 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2455 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
