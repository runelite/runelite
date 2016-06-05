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

@ObfuscatedName("bc")
@Implements("SecondaryBufferProvider")
public final class class75 extends class77 implements ImageProducer, ImageObserver {
   @ObfuscatedName("eo")
   static class78[] field1379;
   @ObfuscatedName("i")
   ImageConsumer field1380;
   @ObfuscatedName("t")
   ColorModel field1384;

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field1380 == var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-789686150"
   )
   final void vmethod1838(int var1, int var2, Component var3) {
      super.field1402 = var1;
      super.field1396 = var2;
      super.field1401 = new int[1 + var1 * var2];
      this.field1384 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1395 = var3.createImage(this);
      this.method1577();
      var3.prepareImage(super.field1395, this);
      this.method1577();
      var3.prepareImage(super.field1395, this);
      this.method1577();
      var3.prepareImage(super.field1395, this);
      this.method1658();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "0"
   )
   @Export("draw")
   public final void vmethod1829(Graphics var1, int var2, int var3) {
      this.method1577();
      var1.drawImage(super.field1395, var2, var3, this);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-1610060208"
   )
   @Export("drawSub")
   public final void vmethod1830(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1570(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1395, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1380 = var1;
      var1.setDimensions(super.field1402, super.field1396);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1384);
      var1.setHints(14);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field1380 == var1) {
         this.field1380 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2141833883"
   )
   synchronized void method1570(int var1, int var2, int var3, int var4) {
      if(this.field1380 != null) {
         this.field1380.setPixels(var1, var2, var3, var4, this.field1384, super.field1401, var1 + var2 * super.field1402, super.field1402);
         this.field1380.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-41173024"
   )
   synchronized void method1577() {
      if(null != this.field1380) {
         this.field1380.setPixels(0, 0, super.field1402, super.field1396, this.field1384, super.field1401, 0, super.field1402);
         this.field1380.imageComplete(2);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "2133613490"
   )
   @Export("selectWorld")
   static void method1598(class25 var0) {
      if(var0.method579() != client.field286) {
         client.field286 = var0.method579();
         boolean var1 = var0.method579();
         if(class51.field1160 != var1) {
            class18.method178();
            class51.field1160 = var1;
         }
      }

      class161.field2670 = var0.field640;
      client.field478 = var0.field637;
      client.field283 = var0.field645;
      class110.field1939 = client.field384 == 0?'ꩊ':var0.field637 + '鱀';
      class107.field1886 = client.field384 == 0?443:'썐' + var0.field637;
      class35.field782 = class110.field1939;
   }
}
