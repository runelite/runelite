import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eu")
public class class130 {
   @ObfuscatedName("f")
   static final class130 field2048 = new class130(2);
   @ObfuscatedName("w")
   public static final class130 field2049 = new class130(1);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2081433417
   )
   public final int field2050;
   @ObfuscatedName("e")
   static final class130 field2052 = new class130(0);

   @ObfuscatedName("e")
   public static final void method2818(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var7) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var6) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var5) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("n")
   static void method2820(class25 var0) {
      if(var0.method628() != client.field284) {
         client.field284 = var0.method628();
         boolean var1 = var0.method628();
         if(class51.field1100 != var1) {
            class51.field1086.method3760();
            class51.field1087.method3760();
            class51.field1129.method3760();
            class51.field1100 = var1;
         }
      }

      class101.field1732 = var0.field623;
      client.field279 = var0.field620;
      client.field280 = var0.field621;
      class155.field2281 = client.field282 == 0?'ꩊ':var0.field620 + '鱀';
      class113.field1947 = 0 == client.field282?443:var0.field620 + '썐';
      class51.field1103 = class155.field2281;
   }

   class130(int var1) {
      this.field2050 = var1;
   }
}
