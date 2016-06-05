import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dz")
public class class111 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1434962567
   )
   public static int field1957;
   @ObfuscatedName("i")
   public static final String[] field1958 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("g")
   public static Calendar field1963;
   @ObfuscatedName("t")
   public static final String[][] field1965 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "0"
   )
   public static Object method2388(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class125.field2047) {
            try {
               class118 var2 = new class118();
               var2.vmethod2754(var0);
               return var2;
            } catch (Throwable var3) {
               class125.field2047 = true;
            }
         }

         return var0;
      }
   }

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field1963 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "756027787"
   )
   public static boolean method2389(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "87"
   )
   static final int method2390(int var0, int var1) {
      int var2 = class124.method2748('넵' + var0, var1 + 91923, 4) - 128 + (class124.method2748(10294 + var0, var1 + '鎽', 2) - 128 >> 1) + (class124.method2748(var0, var1, 1) - 128 >> 2);
      var2 = 35 + (int)((double)var2 * 0.3D);
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass122;IS)V",
      garbageValue = "5016"
   )
   static final void method2391(class122 var0, int var1) {
      int var2 = var0.field2000;
      class32.field748 = 0;
      class85.method1864(var0);

      for(int var3 = 0; var3 < class32.field748; ++var3) {
         int var4 = class32.field749[var3];
         class2 var5 = client.field405[var4];
         int var6 = var0.method2494();
         if((var6 & 32) != 0) {
            var6 += var0.method2494() << 8;
         }

         class82.method1840(var0, var4, var5, var6);
      }

      if(var1 != var0.field2000 - var2) {
         throw new RuntimeException(var0.field2000 - var2 + " " + var1);
      }
   }
}
