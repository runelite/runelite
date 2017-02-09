import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class169 {
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 1689563817
   )
   static int field2313;
   @ObfuscatedName("y")
   public static final String[] field2314 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("k")
   public static final String[][] field2318 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("o")
   public static Calendar field2319;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "-481432703"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2808.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field2803.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(null != var2) {
            var1.method3505(new Buffer(var2));
         }

         KitDefinition.field2808.put(var1, (long)var0);
         return var1;
      }
   }

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2319 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   class169() throws Throwable {
      throw new Error();
   }
}
