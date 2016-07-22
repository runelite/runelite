import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class156 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1973461879
   )
   final int field2330;
   @ObfuscatedName("w")
   static final class156 field2331 = new class156("BUILDLIVE", 3);
   @ObfuscatedName("e")
   static final class156 field2332 = new class156("RC", 1);
   @ObfuscatedName("o")
   static final class156 field2333 = new class156("WIP", 2);
   @ObfuscatedName("g")
   public final String field2334;
   @ObfuscatedName("m")
   static final class156 field2335 = new class156("LIVE", 0);

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-2138596015"
   )
   static final byte[] method3200(byte[] var0) {
      class122 var1 = new class122(var0);
      int var2 = var1.method2556();
      int var3 = var1.method2577();
      if(var3 >= 0 && (class170.field2740 == 0 || var3 <= class170.field2740)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2583(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2577();
            if(var4 < 0 || class170.field2740 != 0 && var4 > class170.field2740) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class120.method2521(var5, var4, var0, var3, 9);
               } else {
                  class170.field2735.method2517(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class156(String var1, int var2) {
      this.field2334 = var1;
      this.field2330 = var2;
   }
}
