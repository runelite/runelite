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

@ObfuscatedName("hp")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("c")
   ImageConsumer field3198;
   @ObfuscatedName("u")
   ColorModel field3200;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "1846076808"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method4084();
      var1.drawImage(super.image, var2, var3, this);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "49"
   )
   public final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[1 + var2 * var1];
      this.field3200 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method4084();
      var3.prepareImage(super.image, this);
      this.method4084();
      var3.prepareImage(super.image, this);
      this.method4084();
      var3.prepareImage(super.image, this);
      this.method4046();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "119912113"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method4086(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field3198 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field3200);
      var1.setHints(14);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field3198 == var1) {
         this.field3198 = null;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2082684842"
   )
   synchronized void method4084() {
      if(null != this.field3198) {
         this.field3198.setPixels(0, 0, super.width, super.height, this.field3200, super.pixels, 0, super.width);
         this.field3198.imageComplete(2);
      }
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1592525210"
   )
   synchronized void method4086(int var1, int var2, int var3, int var4) {
      if(this.field3198 != null) {
         this.field3198.setPixels(var1, var2, var3, var4, this.field3200, super.pixels, var2 * super.width + var1, super.width);
         this.field3198.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field3198 == var1;
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }
}
