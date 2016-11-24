import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fx")
public class class169 {
   @ObfuscatedName("m")
   public static Calendar field2343;
   @ObfuscatedName("d")
   public static final String[] field2344 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("n")
   public static final String[][] field2345 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2343 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
