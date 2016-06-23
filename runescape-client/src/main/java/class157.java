import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class157 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "887441770"
   )
   static char method3188(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIIIZS)V",
      garbageValue = "5000"
   )
   static final void method3189(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = var5 * (client.field543 - client.field344) / 100 + client.field344;
      int var7 = var3 * var6 * 512 / (334 * var2);
      int var8;
      int var9;
      short var15;
      if(var7 < client.field420) {
         var15 = client.field420;
         var6 = 334 * var2 * var15 / (512 * var3);
         if(var6 > client.field547) {
            var6 = client.field547;
            var8 = 512 * var3 * var6 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class79.method1847();
               class79.method1854(var0, var1, var9, var3, -16777216);
               class79.method1854(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > client.field565) {
         var15 = client.field565;
         var6 = 334 * var15 * var2 / (512 * var3);
         if(var6 < client.field546) {
            var6 = client.field546;
            var8 = var2 * var15 * 334 / (512 * var6);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class79.method1847();
               class79.method1854(var0, var1, var2, var9, -16777216);
               class79.method1854(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= 2 * var9;
         }
      }

      var8 = var5 * (client.field444 - client.field544) / 100 + client.field544;
      client.field548 = var3 * var6 * var8 / 85504 << 1;
      if(client.field432 != var2 || client.field553 != var3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + var10 * 32 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = class91.field1597[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         class86.method1984(var14, 500, 800, var2, var3);
      }

      client.field463 = var0;
      client.field551 = var1;
      client.field432 = var2;
      client.field553 = var3;
   }
}
