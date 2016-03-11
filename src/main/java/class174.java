import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class174 extends class203 {
   @ObfuscatedName("a")
   public final int[] field2899;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2133330049
   )
   public final int field2900;
   @ObfuscatedName("i")
   public final int[] field2902;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1439598841
   )
   public final int field2903;

   class174(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2903 = var1;
      this.field2900 = var2;
      this.field2899 = var3;
      this.field2902 = var4;
   }

   @ObfuscatedName("j")
   public boolean method3404(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2902.length) {
         int var3 = this.field2902[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2899[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-825230774"
   )
   static final void method3407(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = client.field370 + (client.field404 - client.field370) * var5 / 100;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var14;
      if(var7 < client.field548) {
         var14 = client.field548;
         var6 = var14 * var2 * 334 / (512 * var3);
         if(var6 > client.field547) {
            var6 = client.field547;
            var8 = 512 * var6 * var3 / (334 * var14);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class79.method1769();
               class79.method1776(var0, var1, var9, var3, -16777216);
               class79.method1776(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > client.field549) {
         var14 = client.field549;
         var6 = 334 * var2 * var14 / (512 * var3);
         if(var6 < client.field462) {
            var6 = client.field462;
            var8 = 334 * var2 * var14 / (512 * var6);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class79.method1769();
               class79.method1776(var0, var1, var2, var9, -16777216);
               class79.method1776(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = var5 * (client.field545 - client.field544) / 100 + client.field544;
      client.field487 = var8 * var6 * var3 / 85504 << 1;
      if(client.field552 != var2 || var3 != client.field553) {
         int[] var15 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + 128 + var10 * 32;
            int var12 = var11 * 3 + 600;
            int var13 = class90.field1587[var11];
            var15[var10] = var12 * var13 >> 16;
         }

         class85.method1910(var15, 500, 800, var2, var3);
      }

      client.field441 = var0;
      client.field417 = var1;
      client.field552 = var2;
      client.field553 = var3;
   }
}
