import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("p")
   Component field672;

   public final void paint(Graphics var1) {
      this.field672.paint(var1);
   }

   public final void update(Graphics var1) {
      this.field672.update(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Lclass178;II)Lclass178;",
      garbageValue = "1130124460"
   )
   public static RSEnum method735(RSEnum[] var0, int var1) {
      RSEnum[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         RSEnum var4 = var2[var3];
         if(var1 == var4.ordinal()) {
            return var4;
         }
      }

      return null;
   }

   RSCanvas(Component var1) {
      this.field672 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BB)LSpritePixels;",
      garbageValue = "-2"
   )
   public static final SpritePixels method740(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var3 * var2];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         return new SpritePixels(var4, var2, var3);
      } catch (IOException var7) {
         ;
      } catch (InterruptedException var8) {
         ;
      }

      return new SpritePixels(0, 0);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1781613829"
   )
   static String method741(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LGameEngine;S)V",
      garbageValue = "2048"
   )
   static void method742(GameEngine var0) {
      if(class59.field736 == 1 || !class221.field2845 && class59.field736 == 4) {
         int var1 = class92.field1414 + 280;
         if(class59.field737 >= var1 && class59.field737 <= var1 + 14 && class59.field732 >= 4 && class59.field732 <= 18) {
            class202.method3563(0, 0);
            return;
         }

         if(class59.field737 >= var1 + 15 && class59.field737 <= var1 + 80 && class59.field732 >= 4 && class59.field732 <= 18) {
            class202.method3563(0, 1);
            return;
         }

         int var2 = class92.field1414 + 390;
         if(class59.field737 >= var2 && class59.field737 <= var2 + 14 && class59.field732 >= 4 && class59.field732 <= 18) {
            class202.method3563(1, 0);
            return;
         }

         if(class59.field737 >= var2 + 15 && class59.field737 <= var2 + 80 && class59.field732 >= 4 && class59.field732 <= 18) {
            class202.method3563(1, 1);
            return;
         }

         int var3 = class92.field1414 + 500;
         if(class59.field737 >= var3 && class59.field737 <= var3 + 14 && class59.field732 >= 4 && class59.field732 <= 18) {
            class202.method3563(2, 0);
            return;
         }

         if(class59.field737 >= var3 + 15 && class59.field737 <= var3 + 80 && class59.field732 >= 4 && class59.field732 <= 18) {
            class202.method3563(2, 1);
            return;
         }

         int var4 = class92.field1414 + 610;
         if(class59.field737 >= var4 && class59.field737 <= var4 + 14 && class59.field732 >= 4 && class59.field732 <= 18) {
            class202.method3563(3, 0);
            return;
         }

         if(class59.field737 >= var4 + 15 && class59.field737 <= var4 + 80 && class59.field732 >= 4 && class59.field732 <= 18) {
            class202.method3563(3, 1);
            return;
         }

         if(class59.field737 >= class92.field1414 + 708 && class59.field732 >= 4 && class59.field737 <= class92.field1414 + 708 + 50 && class59.field732 <= 20) {
            class92.worldSelectShown = false;
            class37.field519.method4949(class92.field1414, 0);
            class92.field1419.method4949(class92.field1414 + 382, 0);
            class92.field1416.method4923(class92.field1414 + 382 - class92.field1416.originalWidth / 2, 18);
            return;
         }

         if(class92.field1445 != -1) {
            World var5 = World.worldList[class92.field1445];
            class2.method6(var5);
            class92.worldSelectShown = false;
            class37.field519.method4949(class92.field1414, 0);
            class92.field1419.method4949(class92.field1414 + 382, 0);
            class92.field1416.method4923(class92.field1414 + 382 - class92.field1416.originalWidth / 2, 18);
            return;
         }
      }

   }
}
