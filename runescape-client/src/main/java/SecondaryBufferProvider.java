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

@ObfuscatedName("hi")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("p")
   ImageConsumer field3234;
   @ObfuscatedName("d")
   ColorModel field3236;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "23"
   )
   final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[var2 * var1 + 1];
      this.field3236 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method4193();
      var3.prepareImage(super.image, this);
      this.method4193();
      var3.prepareImage(super.image, this);
      this.method4193();
      var3.prepareImage(super.image, this);
      this.method4147();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "760519699"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method4193();
      var1.drawImage(super.image, var2, var3, this);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "617664203"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method4182(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field3234 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field3236);
      var1.setHints(14);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field3234 == var1;
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field3234) {
         this.field3234 = null;
      }

   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "113"
   )
   synchronized void method4182(int var1, int var2, int var3, int var4) {
      if(this.field3234 != null) {
         this.field3234.setPixels(var1, var2, var3, var4, this.field3236, super.pixels, var2 * super.width + var1, super.width);
         this.field3234.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-754439345"
   )
   synchronized void method4193() {
      if(this.field3234 != null) {
         this.field3234.setPixels(0, 0, super.width, super.height, this.field3236, super.pixels, 0, super.width);
         this.field3234.imageComplete(2);
      }
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }
}
