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
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = 120045067
   )
   static int field3215;
   @ObfuscatedName("h")
   ImageConsumer field3216;
   @ObfuscatedName("x")
   ColorModel field3218;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-975875046"
   )
   final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[1 + var2 * var1];
      this.field3218 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method4104();
      var3.prepareImage(super.image, this);
      this.method4104();
      var3.prepareImage(super.image, this);
      this.method4104();
      var3.prepareImage(super.image, this);
      this.method4084();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "-63"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method4104();
      var1.drawImage(super.image, var2, var3, this);
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field3216 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field3218);
      var1.setHints(14);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field3216;
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field3216 == var1) {
         this.field3216 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "158465451"
   )
   synchronized void method4104() {
      if(null != this.field3216) {
         this.field3216.setPixels(0, 0, super.width, super.height, this.field3218, super.pixels, 0, super.width);
         this.field3216.imageComplete(2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1648346874"
   )
   synchronized void method4105(int var1, int var2, int var3, int var4) {
      if(this.field3216 != null) {
         this.field3216.setPixels(var1, var2, var3, var4, this.field3218, super.pixels, var2 * super.width + var1, super.width);
         this.field3216.imageComplete(2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-550155191"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method4105(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }
}
