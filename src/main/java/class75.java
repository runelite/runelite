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
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public final class class75 extends class77 implements ImageProducer, ImageObserver {
   @ObfuscatedName("a")
   ColorModel field1381;
   @ObfuscatedName("w")
   ImageConsumer field1383;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "91"
   )
   final void vmethod1971(int var1, int var2, Component var3) {
      super.field1394 = var1;
      super.field1395 = var2;
      super.field1393 = new int[1 + var2 * var1];
      this.field1381 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1396 = var3.createImage(this);
      this.method1709();
      var3.prepareImage(super.field1396, this);
      this.method1709();
      var3.prepareImage(super.field1396, this);
      this.method1709();
      var3.prepareImage(super.field1396, this);
      this.method1782();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "0"
   )
   public final void vmethod1970(Graphics var1, int var2, int var3) {
      this.method1709();
      var1.drawImage(super.field1396, var2, var3, this);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1383 = var1;
      var1.setDimensions(super.field1394, super.field1395);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1381);
      var1.setHints(14);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field1383;
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field1383) {
         this.field1383 = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-1669287626"
   )
   public final void vmethod1972(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1733(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1396, 0, 0, this);
      var1.setClip(var6);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-9"
   )
   synchronized void method1709() {
      if(this.field1383 != null) {
         this.field1383.setPixels(0, 0, super.field1394, super.field1395, this.field1381, super.field1393, 0, super.field1394);
         this.field1383.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1756159727"
   )
   synchronized void method1733(int var1, int var2, int var3, int var4) {
      if(null != this.field1383) {
         this.field1383.setPixels(var1, var2, var3, var4, this.field1381, super.field1393, super.field1394 * var2 + var1, super.field1394);
         this.field1383.imageComplete(2);
      }
   }
}
