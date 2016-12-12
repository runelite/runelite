import java.applet.Applet;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class39 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 563167005
   )
   static int field804;
   @ObfuscatedName("s")
   static String field805;
   @ObfuscatedName("i")
   static final BigInteger field807 = new BigInteger("10001", 16);
   @ObfuscatedName("hw")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("fg")
   @ObfuscatedGetter(
      intValue = -1771758561
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("e")
   static final BigInteger field812 = new BigInteger("bc9957dbf566f0daf67d7c8c1409fcb3a2f31f7b7f1e1cc23eb764e4887d864895221ef24941cdf1cb3a88b904f9bbbe425eb45ccf95e2bea788ab489a8323fec25a59c3e2bd9e167234ec621a53154f014771c0be1fd933f4d2ebd1720cb1276de9923139da99a3902c85b9f6585956ffb18a2f54677af6726385c7df8944b1", 16);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "-2100299503"
   )
   public static void method708(Applet var0, String var1) {
      class114.field1788 = var0;
      class114.field1784 = var1;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-215884096"
   )
   static final void method709(int var0, int var1, int var2, int var3, boolean var4) {
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

      int var6 = Client.field540 + (Client.field541 - Client.field540) * var5 / 100;
      int var7 = 512 * var6 * var3 / (var2 * 334);
      int var8;
      int var14;
      short var15;
      if(var7 < Client.field546) {
         var15 = Client.field546;
         var6 = 334 * var2 * var15 / (512 * var3);
         if(var6 > Client.field545) {
            var6 = Client.field545;
            var8 = var3 * var6 * 512 / (334 * var15);
            var14 = (var2 - var8) / 2;
            if(var4) {
               class219.method3888();
               class219.method3910(var0, var1, var14, var3, -16777216);
               class219.method3910(var0 + var2 - var14, var1, var14, var3, -16777216);
            }

            var0 += var14;
            var2 -= 2 * var14;
         }
      } else if(var7 > Client.field547) {
         var15 = Client.field547;
         var6 = 334 * var15 * var2 / (var3 * 512);
         if(var6 < Client.field392) {
            var6 = Client.field392;
            var8 = 334 * var15 * var2 / (var6 * 512);
            var14 = (var3 - var8) / 2;
            if(var4) {
               class219.method3888();
               class219.method3910(var0, var1, var2, var14, -16777216);
               class219.method3910(var0, var1 + var3 - var14, var2, var14, -16777216);
            }

            var1 += var14;
            var3 -= 2 * var14;
         }
      }

      var8 = Client.field382 + (Client.field543 - Client.field382) * var5 / 100;
      Client.scale = var3 * var6 * var8 / 85504 << 1;
      if(var2 != Client.camera2 || var3 != Client.camera3) {
         int[] var9 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 128 + 15;
            int var12 = 600 + 3 * var11;
            int var13 = class84.field1453[var11];
            var9[var10] = var12 * var13 >> 16;
         }

         Region.method1726(var9, 500, 800, var2, var3);
      }

      Client.field548 = var0;
      Client.field549 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-953907865"
   )
   static final void method710(boolean var0) {
      int var1 = Client.widgetRoot;
      int var2 = ItemLayer.field1223;
      int var3 = class112.field1755;
      if(class212.method3870(var1)) {
         class32.method654(Widget.widgets[var1], -1, var2, var3, var0);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[Lclass216;",
      garbageValue = "8"
   )
   public static class216[] method711() {
      return new class216[]{class216.field3163, class216.field3164, class216.field3165};
   }
}
