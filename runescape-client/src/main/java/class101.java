import java.applet.Applet;
import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class101 extends RuntimeException {
   @ObfuscatedName("k")
   static Applet field1657;
   @ObfuscatedName("y")
   public static String field1658;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -582863171
   )
   static int field1659;
   @ObfuscatedName("r")
   String field1660;
   @ObfuscatedName("d")
   public static short[][] field1661;
   @ObfuscatedName("w")
   Throwable field1662;
   @ObfuscatedName("eo")
   static SpritePixels[] field1666;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "2078664886"
   )
   static final void method1939(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class60.field1083.length; ++var2) {
         class60.field1083[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class60.field1083[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class116.field1818[var5] = (class60.field1083[128 + var5] + class60.field1083[var5 + 1] + class60.field1083[var5 - 1] + class60.field1083[var5 - 128]) / 4;
            }
         }

         int[] var8 = class60.field1083;
         class60.field1083 = class116.field1818;
         class116.field1818 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + 16 + var0.offsetX;
                  int var6 = var0.offsetY + 16 + var3;
                  int var7 = (var6 << 7) + var5;
                  class60.field1083[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)V",
      garbageValue = "-2"
   )
   static final void method1940(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = 6 + var2;
      int var4 = var2 + 6;
      int var5 = class49.field961.method3868(var0, 250);
      int var6 = class49.field961.method3869(var0, 250) * 13;
      Rasterizer2D.method4004(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2, 0);
      Rasterizer2D.method3985(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      class49.field961.method3875(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      class45.method837(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6);
      if(var1) {
         try {
            Graphics var7 = class32.canvas.getGraphics();
            class13.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var13) {
            class32.canvas.repaint();
         }
      } else {
         int var12 = var3;
         int var8 = var4;
         int var9 = var5;
         int var10 = var6;

         for(int var11 = 0; var11 < Client.field288; ++var11) {
            if(Client.widgetPositionX[var11] + Client.widgetBoundsWidth[var11] > var12 && Client.widgetPositionX[var11] < var12 + var9 && Client.widgetBoundsHeight[var11] + Client.widgetPositionY[var11] > var8 && Client.widgetPositionY[var11] < var8 + var10) {
               Client.field483[var11] = true;
            }
         }
      }

   }
}
