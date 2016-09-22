import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dc")
public class class114 {
   @ObfuscatedName("d")
   static final String[] field2032 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("v")
   static Calendar field2033;
   @ObfuscatedName("a")
   static final String[][] field2035 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2033 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
