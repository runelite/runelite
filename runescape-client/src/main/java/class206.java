import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class206 {
   @ObfuscatedName("k")
   static char[] field3076 = new char[64];
   @ObfuscatedName("y")
   static char[] field3077;
   @ObfuscatedName("r")
   public static class182 field3079;
   @ObfuscatedName("o")
   static int[] field3083;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1495251841
   )
   static int field3084;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field3076[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3076[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3076[var0] = (char)(48 + var0 - 52);
      }

      field3076[62] = 43;
      field3076[63] = 47;
      field3077 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field3077[var0] = (char)(65 + var0);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field3077[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field3077[var0] = (char)(48 + var0 - 52);
      }

      field3077[62] = 42;
      field3077[63] = 45;
      field3083 = new int[128];

      for(var0 = 0; var0 < field3083.length; ++var0) {
         field3083[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field3083[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field3083[var0] = 26 + (var0 - 97);
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field3083[var0] = 52 + (var0 - 48);
      }

      int[] var2 = field3083;
      field3083[43] = 62;
      var2[42] = 62;
      int[] var1 = field3083;
      field3083[47] = 63;
      var1[45] = 63;
   }

   class206() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1223507749"
   )
   static final void method3825(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = var5 * (Client.field292 - Client.field368) / 100 + Client.field368;
      int var7 = 512 * var3 * var6 / (334 * var2);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field538) {
         var15 = Client.field538;
         var6 = 334 * var2 * var15 / (var3 * 512);
         if(var6 > Client.field412) {
            var6 = Client.field412;
            var8 = var3 * var6 * 512 / (334 * var15);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method3972();
               Rasterizer2D.method4004(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4004(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field539) {
         var15 = Client.field539;
         var6 = var2 * var15 * 334 / (512 * var3);
         if(var6 < Client.field447) {
            var6 = Client.field447;
            var8 = 334 * var2 * var15 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method3972();
               Rasterizer2D.method4004(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4004(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= 2 * var9;
         }
      }

      var8 = Client.field534 + (Client.field521 - Client.field534) * var5 / 100;
      Client.scale = var8 * var6 * var3 / 85504 << 1;
      if(Client.camera2 != var2 || var3 != Client.camera3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 128 + var10 * 32 + 15;
            int var12 = var11 * 3 + 600;
            int var13 = class84.field1428[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method1742(var14, 500, 800, var2, var3);
      }

      Client.field280 = var0;
      Client.field541 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }
}
