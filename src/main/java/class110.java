import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("de")
public class class110 {
   @ObfuscatedName("r")
   public static final String[] field1944 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("f")
   public static Calendar field1945;
   @ObfuscatedName("cv")
   public static char field1948;
   @ObfuscatedName("a")
   public static final String[][] field1950 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("dp")
   static int[] field1951;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field1945 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("y")
   static final void method2433() {
      class85.field1500 = false;
      client.field297 = false;
   }
}
