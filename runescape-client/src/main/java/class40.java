import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class40 implements class158 {
   @ObfuscatedName("j")
   static final class40 field835 = new class40(1);
   @ObfuscatedName("d")
   static final class40 field836 = new class40(3);
   @ObfuscatedName("c")
   static final class40 field837 = new class40(2);
   @ObfuscatedName("x")
   static final class40 field839 = new class40(0);
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = 53582625
   )
   static int field842;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1315604895
   )
   final int field843;
   @ObfuscatedName("pw")
   static short[] field844;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class40(int var1) {
      this.field843 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIIZB)V",
      garbageValue = "91"
   )
   public static void method821(class182 var0, int var1, int var2, int var3, boolean var4) {
      class138.field1920 = 1;
      class138.field1916 = var0;
      class138.field1922 = var1;
      class8.field86 = var2;
      Ignore.field245 = var3;
      class138.field1923 = var4;
      XClanMember.field302 = 10000;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "127"
   )
   public int vmethod4085() {
      return this.field843;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "-43"
   )
   static final void method824(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = var5 * (Client.field568 - Client.field567) / 100 + Client.field567;
      int var7 = var6 * var3 * 512 / (334 * var2);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field573) {
         var15 = Client.field573;
         var6 = 334 * var2 * var15 / (var3 * 512);
         if(var6 > Client.field572) {
            var6 = Client.field572;
            var8 = var6 * var3 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method3997();
               Rasterizer2D.method4028(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4028(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > Client.field574) {
         var15 = Client.field574;
         var6 = 334 * var15 * var2 / (512 * var3);
         if(var6 < Client.field324) {
            var6 = Client.field324;
            var8 = var2 * var15 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method3997();
               Rasterizer2D.method4028(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4028(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field522 - Client.field569) * var5 / 100 + Client.field569;
      Client.scale = var6 * var3 * var8 / 85504 << 1;
      if(Client.camera2 != var2 || Client.camera3 != var3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + 128 + var10 * 32;
            int var12 = 600 + var11 * 3;
            int var13 = class84.field1441[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method1788(var14, 500, 800, var2, var3);
      }

      Client.field575 = var0;
      Client.field456 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)LWidget;",
      garbageValue = "-401868729"
   )
   public static Widget method826(int var0, int var1) {
      Widget var2 = World.method670(var0);
      return var1 == -1?var2:(null != var2 && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }
}
