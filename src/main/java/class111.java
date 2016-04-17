import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public class class111 {
   @ObfuscatedName("w")
   static final String[] field1950 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("a")
   static final String[][] field1952 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("d")
   static Calendar field1953;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field1953 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-276429634"
   )
   static void method2530(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         class25 var8 = class129.field2051[var6];
         class129.field2051[var6] = class129.field2051[var1];
         class129.field2051[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class20.method639(class129.field2051[var9], var8, var2, var3, var4, var5) <= 0) {
               class25 var10 = class129.field2051[var9];
               class129.field2051[var9] = class129.field2051[var7];
               class129.field2051[var7++] = var10;
            }
         }

         class129.field2051[var1] = class129.field2051[var7];
         class129.field2051[var7] = var8;
         method2530(var0, var7 - 1, var2, var3, var4, var5);
         method2530(1 + var7, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-818953870"
   )
   static final byte[] method2531(byte[] var0) {
      class119 var1 = new class119(var0);
      int var2 = var1.method2613();
      int var3 = var1.method2618();
      if(var3 >= 0 && (class167.field2659 == 0 || var3 <= class167.field2659)) {
         if(0 == var2) {
            byte[] var6 = new byte[var3];
            var1.method2740(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2618();
            if(var4 < 0 || 0 != class167.field2659 && var4 > class167.field2659) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class117.method2578(var5, var4, var0, var3, 9);
               } else {
                  class167.field2671.method2552(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }
}
