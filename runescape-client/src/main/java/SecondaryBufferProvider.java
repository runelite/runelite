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

@ObfuscatedName("hj")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 137168287
   )
   public static int field3217;
   @ObfuscatedName("p")
   ImageConsumer field3218;
   @ObfuscatedName("x")
   ColorModel field3219;
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 1144384575
   )
   @Export("baseY")
   static int baseY;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "73630336"
   )
   public final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[1 + var2 * var1];
      this.field3219 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method4132();
      var3.prepareImage(super.image, this);
      this.method4132();
      var3.prepareImage(super.image, this);
      this.method4132();
      var3.prepareImage(super.image, this);
      this.method4098();
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field3218 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field3219);
      var1.setHints(14);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field3218) {
         this.field3218 = null;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-107"
   )
   synchronized void method4132() {
      if(this.field3218 != null) {
         this.field3218.setPixels(0, 0, super.width, super.height, this.field3219, super.pixels, 0, super.width);
         this.field3218.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field3218 == var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "1"
   )
   synchronized void method4137(int var1, int var2, int var3, int var4) {
      if(this.field3218 != null) {
         this.field3218.setPixels(var1, var2, var3, var4, this.field3219, super.pixels, var1 + var2 * super.width, super.width);
         this.field3218.imageComplete(2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "891005987"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method4137(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-656201964"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method4132();
      var1.drawImage(super.image, var2, var3, this);
   }
}
