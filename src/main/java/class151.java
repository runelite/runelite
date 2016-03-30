import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class151 {
   @ObfuscatedName("y")
   public static class167 field2279;

   @ObfuscatedName("e")
   static void method3171(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      class172 var4 = (class172)class171.field2738.method3806(var2);
      if(null != var4) {
         class171.field2741.method3907(var4);
      }
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIIIIIB)V",
      garbageValue = "-127"
   )
   static final void method3172(class173 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(client.field297) {
         client.field377 = 32;
      } else {
         client.field377 = 0;
      }

      client.field297 = false;
      int var7;
      if(class140.field2184 == 1 || !class39.field922 && class140.field2184 == 4) {
         if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 && var6 < 16 + var2) {
            var0.field2882 -= 4;
            class134.method2877(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var2 + var3 - 16 && var6 < var2 + var3) {
            var0.field2882 += 4;
            class134.method2877(var0);
         } else if(var5 >= var1 - client.field377 && var5 < 16 + var1 + client.field377 && var6 >= var2 + 16 && var6 < var2 + var3 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.field2882 = (var4 - var3) * var8 / var9;
            class134.method2877(var0);
            client.field297 = true;
         }
      }

      if(client.field492 != 0) {
         var7 = var0.field2767;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < 16 + var1 && var6 <= var3 + var2) {
            var0.field2882 += client.field492 * 45;
            class134.method2877(var0);
         }
      }

   }
}
