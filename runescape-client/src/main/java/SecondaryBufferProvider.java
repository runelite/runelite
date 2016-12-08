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

@ObfuscatedName("hd")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("o")
   ColorModel field3200;
   @ObfuscatedName("v")
   ImageConsumer field3201;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-855827731"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method4009();
      var1.drawImage(super.image, var2, var3, this);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-1"
   )
   public final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[1 + var1 * var2];
      this.field3200 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method4009();
      var3.prepareImage(super.image, this);
      this.method4009();
      var3.prepareImage(super.image, this);
      this.method4009();
      var3.prepareImage(super.image, this);
      this.method3985();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-96"
   )
   synchronized void method4009() {
      if(null != this.field3201) {
         this.field3201.setPixels(0, 0, super.width, super.height, this.field3200, super.pixels, 0, super.width);
         this.field3201.imageComplete(2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "958654020"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method4016(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field3201 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field3200);
      var1.setHints(14);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field3201;
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "44"
   )
   synchronized void method4016(int var1, int var2, int var3, int var4) {
      if(this.field3201 != null) {
         this.field3201.setPixels(var1, var2, var3, var4, this.field3200, super.pixels, var1 + var2 * super.width, super.width);
         this.field3201.imageComplete(2);
      }
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field3201) {
         this.field3201 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }
}
