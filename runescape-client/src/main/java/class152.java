import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class152 extends RuntimeException {
   @ObfuscatedName("m")
   public static String field2223;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1778028481
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("p")
   public static Applet field2225;
   @ObfuscatedName("z")
   Throwable field2227;
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = 1174511207
   )
   static int field2231;
   @ObfuscatedName("w")
   String field2232;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;B)[LSpritePixels;",
      garbageValue = "100"
   )
   public static SpritePixels[] method2812(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4055(var1);
      int var4 = var0.method4020(var3, var2);
      return class31.method278(var0, var3, var4);
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(LWidget;IIS)V",
      garbageValue = "255"
   )
   static void method2814(Widget var0, int var1, int var2) {
      if(var0.field2659 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2659 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2659 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2659 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2659 == 4) {
         var0.relativeX = (var1 * var0.originalX >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2660 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2660 == 1) {
         var0.relativeY = var0.originalY + (var2 - var0.height) / 2;
      } else if(var0.field2660 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2660 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2660 == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1076 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "713559858"
   )
   static final void method2815(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class77.method1438(var0, var1, Player.plane) - var2;
         var0 -= class14.cameraX;
         var3 -= class112.cameraZ;
         var1 -= class66.cameraY;
         int var4 = class136.SINE[class203.cameraPitch];
         int var5 = class136.COSINE[class203.cameraPitch];
         int var6 = class136.SINE[class13.cameraYaw];
         int var7 = class136.COSINE[class13.cameraYaw];
         int var8 = var0 * var7 + var1 * var6 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.field1011 = Client.scale * var0 / var1 + Client.viewportHeight / 2;
            Client.field1049 = var8 * Client.scale / var1 + Client.viewportWidth / 2;
         } else {
            Client.field1011 = -1;
            Client.field1049 = -1;
         }
      } else {
         Client.field1011 = -1;
         Client.field1049 = -1;
      }

   }
}
