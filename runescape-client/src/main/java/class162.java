import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fu")
public class class162 {
   @ObfuscatedName("i")
   static final String[] field2164 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("u")
   static Calendar field2165;
   @ObfuscatedName("p")
   static int[][][] field2166;
   @ObfuscatedName("f")
   static final String[][] field2168 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("kk")
   static Widget[] field2170;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2165 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   class162() throws Throwable {
      throw new Error();
   }
}
