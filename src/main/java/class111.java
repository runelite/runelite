import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dz")
public class class111 {
   @ObfuscatedName("j")
   static final String[][] field1935 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("m")
   static Calendar field1937;
   @ObfuscatedName("h")
   static final String[] field1939 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field1937 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
