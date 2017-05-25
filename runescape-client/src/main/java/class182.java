import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gd")
public class class182 {
   @ObfuscatedName("i")
   static final String[][] field2436;
   @ObfuscatedName("u")
   static Calendar field2437;
   @ObfuscatedName("h")
   static final String[] field2438;

   static {
      field2436 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2438 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2437 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
