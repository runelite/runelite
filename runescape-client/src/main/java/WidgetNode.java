import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1615161609
   )
   int field57;
   @ObfuscatedName("f")
   boolean field58 = false;
   @ObfuscatedName("bq")
   static ModIcon field59;
   @ObfuscatedName("v")
   static File field61;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -917354089
   )
   @Export("id")
   int id;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "92"
   )
   static final void method46(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = var5 * (Client.field448 - Client.field537) / 100 + Client.field537;
      int var7 = var6 * var3 * 512 / (334 * var2);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field540) {
         var15 = Client.field540;
         var6 = 334 * var2 * var15 / (512 * var3);
         if(var6 > Client.field536) {
            var6 = Client.field536;
            var8 = 512 * var3 * var6 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class82.method1833();
               class82.method1885(var0, var1, var9, var3, -16777216);
               class82.method1885(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > Client.field457) {
         var15 = Client.field457;
         var6 = var2 * var15 * 334 / (var3 * 512);
         if(var6 < Client.field538) {
            var6 = Client.field538;
            var8 = 334 * var15 * var2 / (512 * var6);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class82.method1833();
               class82.method1885(var0, var1, var2, var9, -16777216);
               class82.method1885(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field344 - Client.field512) * var5 / 100 + Client.field512;
      Client.scale = var8 * var3 * var6 / 85504 << 1;
      if(Client.camera2 != var2 || Client.camera3 != var3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 128 + 15;
            int var12 = 600 + var11 * 3;
            int var13 = class94.field1650[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method1995(var14, 500, 800, var2, var3);
      }

      Client.field474 = var0;
      Client.field543 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }
}
