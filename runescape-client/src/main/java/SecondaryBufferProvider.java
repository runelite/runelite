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

@ObfuscatedName("hv")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("f")
   ColorModel field3215;
   @ObfuscatedName("o")
   ImageConsumer field3216;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "885241862"
   )
   synchronized void method4100() {
      if(this.field3216 != null) {
         this.field3216.setPixels(0, 0, super.width, super.height, this.field3215, super.pixels, 0, super.width);
         this.field3216.imageComplete(2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "6166627"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method4106(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field3216 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field3215);
      var1.setHints(14);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "106"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method4100();
      var1.drawImage(super.image, var2, var3, this);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-15"
   )
   final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[var1 * var2 + 1];
      this.field3215 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method4100();
      var3.prepareImage(super.image, this);
      this.method4100();
      var3.prepareImage(super.image, this);
      this.method4100();
      var3.prepareImage(super.image, this);
      this.method4072();
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field3216 == var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-803297748"
   )
   synchronized void method4106(int var1, int var2, int var3, int var4) {
      if(null != this.field3216) {
         this.field3216.setPixels(var1, var2, var3, var4, this.field3215, super.pixels, var2 * super.width + var1, super.width);
         this.field3216.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field3216 == var1) {
         this.field3216 = null;
      }

   }
}
