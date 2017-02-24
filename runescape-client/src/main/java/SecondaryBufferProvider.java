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

@ObfuscatedName("hm")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("q")
   ColorModel field3216;
   @ObfuscatedName("n")
   ImageConsumer field3217;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-1372728796"
   )
   final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[var1 * var2 + 1];
      this.field3216 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method4127();
      var3.prepareImage(super.image, this);
      this.method4127();
      var3.prepareImage(super.image, this);
      this.method4127();
      var3.prepareImage(super.image, this);
      this.method4085();
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field3217) {
         this.field3217 = null;
      }

   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field3217 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field3216);
      var1.setHints(14);
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field3217 == var1;
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1038732632"
   )
   synchronized void method4127() {
      if(null != this.field3217) {
         this.field3217.setPixels(0, 0, super.width, super.height, this.field3216, super.pixels, 0, super.width);
         this.field3217.imageComplete(2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-593089330"
   )
   synchronized void method4128(int var1, int var2, int var3, int var4) {
      if(this.field3217 != null) {
         this.field3217.setPixels(var1, var2, var3, var4, this.field3216, super.pixels, var1 + super.width * var2, super.width);
         this.field3217.imageComplete(2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "870035480"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method4128(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-1953981379"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method4127();
      var1.drawImage(super.image, var2, var3, this);
   }
}
