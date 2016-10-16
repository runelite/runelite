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

@ObfuscatedName("cj")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("z")
   ImageConsumer field1412;
   @ObfuscatedName("s")
   ColorModel field1413;
   @ObfuscatedName("gl")
   static Widget field1414;
   @ObfuscatedName("n")
   public static class175 field1416;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "56850214"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method1621();
      var1.drawImage(super.image, var2, var3, this);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "-5"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1622(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1412 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1413);
      var1.setHints(14);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field1412 == var1;
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-534463271"
   )
   synchronized void method1621() {
      if(null != this.field1412) {
         this.field1412.setPixels(0, 0, super.width, super.height, this.field1413, super.pixels, 0, super.width);
         this.field1412.imageComplete(2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1031328835"
   )
   synchronized void method1622(int var1, int var2, int var3, int var4) {
      if(this.field1412 != null) {
         this.field1412.setPixels(var1, var2, var3, var4, this.field1413, super.pixels, var1 + var2 * super.width, super.width);
         this.field1412.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field1412 == var1) {
         this.field1412 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;S)V",
      garbageValue = "3763"
   )
   public final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[1 + var1 * var2];
      this.field1413 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method1621();
      var3.prepareImage(super.image, this);
      this.method1621();
      var3.prepareImage(super.image, this);
      this.method1621();
      var3.prepareImage(super.image, this);
      this.method1682();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Lclass115;II)Lclass115;",
      garbageValue = "1953434078"
   )
   public static class115 method1646(class115[] var0, int var1) {
      class115[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class115 var4 = var2[var3];
         if(var1 == var4.vmethod3162()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   static void method1647() {
      Object var0 = class173.field2762;
      synchronized(class173.field2762) {
         if(class173.field2759 == 0) {
            class8.field121.method2878(new class173(), 5);
         }

         class173.field2759 = 600;
      }
   }
}
