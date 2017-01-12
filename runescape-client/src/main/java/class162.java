import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fv")
public class class162 {
   @ObfuscatedName("u")
   static final String[][] field2130 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("x")
   static final String[] field2131 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("i")
   static Calendar field2132;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 2057524325
   )
   public static int field2134;
   @ObfuscatedName("bn")
   static class184 field2136;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2132 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }
}
