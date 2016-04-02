import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("du")
public class class111 {
   @ObfuscatedName("e")
   public static final String[][] field1936 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("w")
   public static final String[] field1937 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("f")
   public static Calendar field1943;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field1943 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("d")
   static final byte[] method2447(byte[] var0) {
      class119 var1 = new class119(var0);
      int var2 = var1.method2523();
      int var3 = var1.method2528();
      if(var3 < 0 || 0 != class167.field2685 && var3 > class167.field2685) {
         throw new RuntimeException();
      } else if(0 == var2) {
         byte[] var6 = new byte[var3];
         var1.method2709(var6, 0, var3);
         return var6;
      } else {
         int var4 = var1.method2528();
         if(var4 >= 0 && (class167.field2685 == 0 || var4 <= class167.field2685)) {
            byte[] var5 = new byte[var4];
            if(var2 == 1) {
               class117.method2477(var5, var4, var0, 9);
            } else {
               class167.field2671.method2475(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }
}
