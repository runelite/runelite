import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
public class class204 {
   @ObfuscatedName("g")
   public static final String[][] field2628;
   @ObfuscatedName("e")
   public static final String[] field2623;
   @ObfuscatedName("b")
   public static Calendar field2624;

   static {
      field2628 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2623 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2624 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
