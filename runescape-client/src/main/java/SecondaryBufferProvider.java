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

@ObfuscatedName("ho")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("k")
   ImageConsumer field3199;
   @ObfuscatedName("p")
   ColorModel field3201;

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field3199;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "-82"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method4127();
      var1.drawImage(super.image, var2, var3, this);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-1403873771"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method4103(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field3199 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field3201);
      var1.setHints(14);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field3199) {
         this.field3199 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-1463526776"
   )
   public final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[1 + var1 * var2];
      this.field3201 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method4127();
      var3.prepareImage(super.image, this);
      this.method4127();
      var3.prepareImage(super.image, this);
      this.method4127();
      var3.prepareImage(super.image, this);
      this.method4062();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "74"
   )
   synchronized void method4103(int var1, int var2, int var3, int var4) {
      if(this.field3199 != null) {
         this.field3199.setPixels(var1, var2, var3, var4, this.field3201, super.pixels, super.width * var2 + var1, super.width);
         this.field3199.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "888366308"
   )
   synchronized void method4127() {
      if(null != this.field3199) {
         this.field3199.setPixels(0, 0, super.width, super.height, this.field3201, super.pixels, 0, super.width);
         this.field3199.imageComplete(2);
      }
   }
}
