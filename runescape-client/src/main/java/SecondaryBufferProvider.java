import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("aw")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("r")
   ImageConsumer field1415;
   @ObfuscatedName("x")
   ColorModel field1416;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "2139920746"
   )
   public static void method1639(class170 var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method3359(var1);
      int var6 = var0.method3305(var5, var2);
      Buffer.method2775(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-1906122185"
   )
   public final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[1 + var2 * var1];
      this.field1416 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method1665();
      var3.prepareImage(super.image, this);
      this.method1665();
      var3.prepareImage(super.image, this);
      this.method1665();
      var3.prepareImage(super.image, this);
      this.method1711();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "610132572"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method1665();
      var1.drawImage(super.image, var2, var3, this);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "2029268660"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1645(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1415 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1416);
      var1.setHints(14);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field1415) {
         this.field1415 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1938244518"
   )
   synchronized void method1645(int var1, int var2, int var3, int var4) {
      if(null != this.field1415) {
         this.field1415.setPixels(var1, var2, var3, var4, this.field1416, super.pixels, var1 + super.width * var2, super.width);
         this.field1415.imageComplete(2);
      }
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field1415;
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
   )
   synchronized void method1665() {
      if(null != this.field1415) {
         this.field1415.setPixels(0, 0, super.width, super.height, this.field1416, super.pixels, 0, super.width);
         this.field1415.imageComplete(2);
      }
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1466877383"
   )
   static void method1667(int var0) {
      class59.field1242 = new class32();
      class59.field1242.field715 = Client.menuActionParams0[var0];
      class59.field1242.field713 = Client.menuActionParams1[var0];
      class59.field1242.field714 = Client.menuTypes[var0];
      class59.field1242.field717 = Client.menuIdentifiers[var0];
      class59.field1242.field716 = Client.menuOptions[var0];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "281518621"
   )
   public static void method1671(String[] var0, short[] var1) {
      class50.method1026(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)I",
      garbageValue = "-55"
   )
   public static int method1672(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var1 * var5;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
