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
   @ObfuscatedName("h")
   ImageConsumer field3211;
   @ObfuscatedName("n")
   public static short[] field3212;
   @ObfuscatedName("b")
   ColorModel field3213;

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field3211 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field3213);
      var1.setHints(14);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "1899256578"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method4210();
      var1.drawImage(super.image, var2, var3, this);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "454515581"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method4211(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field3211 == var1) {
         this.field3211 = null;
      }

   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field3211;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "948574756"
   )
   synchronized void method4210() {
      if(this.field3211 != null) {
         this.field3211.setPixels(0, 0, super.width, super.height, this.field3213, super.pixels, 0, super.width);
         this.field3211.imageComplete(2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1988207322"
   )
   synchronized void method4211(int var1, int var2, int var3, int var4) {
      if(null != this.field3211) {
         this.field3211.setPixels(var1, var2, var3, var4, this.field3213, super.pixels, var1 + var2 * super.width, super.width);
         this.field3211.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-636025927"
   )
   final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[1 + var2 * var1];
      this.field3213 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method4210();
      var3.prepareImage(super.image, this);
      this.method4210();
      var3.prepareImage(super.image, this);
      this.method4210();
      var3.prepareImage(super.image, this);
      this.method4171();
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-80"
   )
   static final void method4240(String var0) {
      if(!var0.equals("")) {
         Client.field327.method3124(177);
         Client.field327.method3010(class25.method615(var0));
         Client.field327.method2893(var0);
      }
   }
}
