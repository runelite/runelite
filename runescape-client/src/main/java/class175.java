import java.util.HashMap;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class175 {
   @ObfuscatedName("ql")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   static class13 field2446;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1432798091
   )
   static int field2443;

   static {
      new HashMap();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;B)V",
      garbageValue = "1"
   )
   public static void method3248(IndexDataBase var0) {
      class251.field3376 = var0;
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1963201335"
   )
   static final void method3246(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = (Client.field1104 - Client.field1103) * var5 / 100 + Client.field1103;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field881) {
         var15 = Client.field881;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field911) {
            var6 = Client.field911;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method5151(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method5151(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1108) {
         var15 = Client.field1108;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1107) {
            var6 = Client.field1107;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method5151(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method5151(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1106 - Client.field1105) * var5 / 100 + Client.field1105;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 15 + 128;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method2816(var14, 500, 800, var2, var3);
      }

      Client.field1111 = var0;
      Client.field1109 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }
}
