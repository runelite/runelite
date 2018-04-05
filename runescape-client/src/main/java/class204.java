import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gg")
public class class204 {
   @ObfuscatedName("o")
   public static final String[][] field2621;
   @ObfuscatedName("k")
   public static final String[] field2619;
   @ObfuscatedName("t")
   public static Calendar field2620;

   static {
      field2621 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2619 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2620 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
