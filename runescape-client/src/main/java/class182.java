import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
public class class182 {
   @ObfuscatedName("c")
   static final String[][] field2409;
   @ObfuscatedName("o")
   static final String[] field2408;
   @ObfuscatedName("i")
   static Calendar field2410;
   @ObfuscatedName("ad")
   protected static String field2412;

   static {
      field2409 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
      field2408 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2410 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-757130348"
   )
   public static boolean method3387() {
      ClassInfo var0 = (ClassInfo)class280.field3739.method3513();
      return var0 != null;
   }
}
