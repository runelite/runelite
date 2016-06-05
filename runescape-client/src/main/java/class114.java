import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class114 {
   @ObfuscatedName("p")
   static int[] field1974;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)Z",
      garbageValue = "-2016288174"
   )
   static boolean method2406(class122 var0, int var1) {
      int var2 = var0.method2713(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2713(1) != 0) {
            method2406(var0, var1);
         }

         var3 = var0.method2713(6);
         var4 = var0.method2713(6);
         boolean var12 = var0.method2713(1) == 1;
         if(var12) {
            class32.field749[++class32.field748 - 1] = var1;
         }

         if(null != client.field405[var1]) {
            throw new RuntimeException();
         } else {
            class2 var6 = client.field405[var1] = new class2();
            var6.field58 = var1;
            if(null != class32.field736[var1]) {
               var6.method12(class32.field736[var1]);
            }

            var6.field831 = class32.field747[var1];
            var6.field828 = class32.field740[var1];
            var7 = class32.field756[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field859[0] = class32.field739[var1];
            var6.field57 = (byte)var8;
            var6.method29(var3 + (var9 << 6) - class89.field1565, var4 + (var10 << 6) - client.field358);
            var6.field48 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2713(2);
         var4 = class32.field756[var1];
         class32.field756[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method2713(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class32.field756[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class32.field756[var1] = (var8 << 14) + (var7 << 28) + var9;
            return false;
         } else {
            var3 = var0.method2713(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class32.field756[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class32.field756[var1] = (var8 << 28) + (var9 << 14) + var10;
            return false;
         }
      }
   }
}
