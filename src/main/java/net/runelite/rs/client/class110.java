import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
public class class110 {
   @ObfuscatedName("l")
   static final String[] field1956 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("a")
   static Calendar field1957;
   @ObfuscatedName("j")
   static final String[][] field1958 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("b")
   static class172 field1959;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field1957 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("j")
   public static boolean method2384(class166 var0, class166 var1, class166 var2, class183 var3) {
      class182.field2952 = var0;
      class182.field2951 = var1;
      class182.field2953 = var2;
      class182.field2954 = var3;
      return true;
   }
}
