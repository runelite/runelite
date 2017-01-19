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
   @ObfuscatedName("s")
   ColorModel field3203;
   @ObfuscatedName("g")
   ImageConsumer field3204;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "1036417207"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method3938(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-2028014659"
   )
   public final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[1 + var1 * var2];
      this.field3203 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method3937();
      var3.prepareImage(super.image, this);
      this.method3937();
      var3.prepareImage(super.image, this);
      this.method3937();
      var3.prepareImage(super.image, this);
      this.method3906();
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field3204 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field3203);
      var1.setHints(14);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field3204 == var1) {
         this.field3204 = null;
      }

   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field3204 == var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1259491634"
   )
   synchronized void method3937() {
      if(this.field3204 != null) {
         this.field3204.setPixels(0, 0, super.width, super.height, this.field3203, super.pixels, 0, super.width);
         this.field3204.imageComplete(2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-5"
   )
   synchronized void method3938(int var1, int var2, int var3, int var4) {
      if(this.field3204 != null) {
         this.field3204.setPixels(var1, var2, var3, var4, this.field3203, super.pixels, var1 + var2 * super.width, super.width);
         this.field3204.imageComplete(2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIS)V",
      garbageValue = "3395"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method3937();
      var1.drawImage(super.image, var2, var3, this);
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }
}
