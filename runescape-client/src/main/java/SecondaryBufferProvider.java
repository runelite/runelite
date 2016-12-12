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

@ObfuscatedName("hg")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("i")
   ColorModel field3199;
   @ObfuscatedName("n")
   ImageConsumer field3200;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-1084945969"
   )
   public final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[var1 * var2 + 1];
      this.field3199 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method4001();
      var3.prepareImage(super.image, this);
      this.method4001();
      var3.prepareImage(super.image, this);
      this.method4001();
      var3.prepareImage(super.image, this);
      this.method3954();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "2"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method4001();
      var1.drawImage(super.image, var2, var3, this);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "0"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method3996(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field3200 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field3199);
      var1.setHints(14);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field3200 == var1;
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "450984957"
   )
   synchronized void method3996(int var1, int var2, int var3, int var4) {
      if(null != this.field3200) {
         this.field3200.setPixels(var1, var2, var3, var4, this.field3199, super.pixels, var1 + super.width * var2, super.width);
         this.field3200.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   synchronized void method4001() {
      if(null != this.field3200) {
         this.field3200.setPixels(0, 0, super.width, super.height, this.field3199, super.pixels, 0, super.width);
         this.field3200.imageComplete(2);
      }
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field3200) {
         this.field3200 = null;
      }

   }
}
