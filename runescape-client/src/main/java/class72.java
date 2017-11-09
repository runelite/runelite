import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class72 extends class164 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("listFetcher")
   static class149 listFetcher;
   @ObfuscatedName("be")
   static String field824;
   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   @Export("headIconsPrayer")
   static SpritePixels[] headIconsPrayer;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILfa;I)Z",
      garbageValue = "988412898"
   )
   protected boolean vmethod3175(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2214 && var3 == super.field2215;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "11"
   )
   static int method1179(int var0, int var1) {
      Overlay var2 = class82.method1733(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else {
         int var3;
         int var4;
         byte var5;
         int var7;
         if(var2.texture >= 0) {
            var4 = Graphics3D.textureLoader.getAverageTextureRGB(var2.texture);
            var5 = 96;
            if(var4 == -2) {
               var3 = 12345678;
            } else if(var4 == -1) {
               if(var5 < 0) {
                  var5 = 0;
               } else if(var5 > 127) {
                  var5 = 127;
               }

               var7 = 127 - var5;
               var3 = var7;
            } else {
               var7 = var5 * (var4 & 127) / 128;
               if(var7 < 2) {
                  var7 = 2;
               } else if(var7 > 126) {
                  var7 = 126;
               }

               var3 = var7 + (var4 & 65408);
            }

            return Graphics3D.colorPalette[var3] | -16777216;
         } else if(var2.color == 16711935) {
            return var1;
         } else {
            var3 = Preferences.method1685(var2.hue, var2.saturation, var2.lightness);
            var5 = 96;
            if(var3 == -2) {
               var4 = 12345678;
            } else if(var3 == -1) {
               if(var5 < 0) {
                  var5 = 0;
               } else if(var5 > 127) {
                  var5 = 127;
               }

               var7 = 127 - var5;
               var4 = var7;
            } else {
               var7 = var5 * (var3 & 127) / 128;
               if(var7 < 2) {
                  var7 = 2;
               } else if(var7 > 126) {
                  var7 = 126;
               }

               var4 = var7 + (var3 & 65408);
            }

            return Graphics3D.colorPalette[var4] | -16777216;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "631664454"
   )
   static void method1183() {
      if(class91.field1357 && class91.username != null && class91.username.length() > 0) {
         class91.field1350 = 1;
      } else {
         class91.field1350 = 0;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lik;III)Z",
      garbageValue = "-998346185"
   )
   static boolean method1184(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         DecorativeObject.decodeSprite(var3);
         return true;
      }
   }

   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1923610875"
   )
   static final void method1185() {
      Region.lowMemory = false;
      Client.lowMemory = false;
   }
}
