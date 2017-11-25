import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class23 {
   @ObfuscatedName("fk")
   @ObfuscatedGetter(
      intValue = -963062899
   )
   static int field339;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfy;B)V",
      garbageValue = "48"
   )
   public static void method180(Huffman var0) {
      class272.field3721 = var0;
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "780558844"
   )
   static final void method181() {
      int var0 = class181.localPlayer.x;
      int var1 = class181.localPlayer.y;
      if(class224.field2863 - var0 < -500 || class224.field2863 - var0 > 500 || class15.field283 - var1 < -500 || class15.field283 - var1 > 500) {
         class224.field2863 = var0;
         class15.field283 = var1;
      }

      if(var0 != class224.field2863) {
         class224.field2863 += (var0 - class224.field2863) / 16;
      }

      if(var1 != class15.field283) {
         class15.field283 += (var1 - class15.field283) / 16;
      }

      int var2;
      int var3;
      if(MouseInput.field705 == 4 && Client.field956) {
         var2 = MouseInput.field715 * 10625923 - Client.field942;
         Client.field1031 = var2 * 2;
         Client.field942 = var2 != -1 && var2 != 1?(MouseInput.field715 * 10625923 + Client.field942) / 2:MouseInput.field715 * 10625923;
         var3 = Client.field941 - MouseInput.field703;
         Client.field939 = var3 * 2;
         Client.field941 = var3 != -1 && var3 != 1?(Client.field941 + MouseInput.field703) / 2:MouseInput.field703;
      } else {
         if(KeyFocusListener.field606[96]) {
            Client.field939 += (-24 - Client.field939) / 2;
         } else if(KeyFocusListener.field606[97]) {
            Client.field939 += (24 - Client.field939) / 2;
         } else {
            Client.field939 /= 2;
         }

         if(KeyFocusListener.field606[98]) {
            Client.field1031 += (12 - Client.field1031) / 2;
         } else if(KeyFocusListener.field606[99]) {
            Client.field1031 += (-12 - Client.field1031) / 2;
         } else {
            Client.field1031 /= 2;
         }

         Client.field942 = MouseInput.field715 * 10625923;
         Client.field941 = MouseInput.field703;
      }

      Client.mapAngle = Client.field939 / 2 + Client.mapAngle & 2047;
      Client.field997 += Client.field1031 / 2;
      if(Client.field997 < 128) {
         Client.field997 = 128;
      }

      if(Client.field997 > 383) {
         Client.field997 = 383;
      }

      var2 = class224.field2863 >> 7;
      var3 = class15.field283 >> 7;
      int var4 = class41.getTileHeight(class224.field2863, class15.field283, class233.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = class233.plane;
               if(var8 < 3 && (class61.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class61.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = var5 * 192;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < 32768) {
         var6 = 32768;
      }

      if(var6 > Client.field946) {
         Client.field946 += (var6 - Client.field946) / 24;
      } else if(var6 < Client.field946) {
         Client.field946 += (var6 - Client.field946) / 80;
      }

   }
}
