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

@ObfuscatedName("bp")
public final class class75 extends class77 implements ImageProducer, ImageObserver {
   @ObfuscatedName("e")
   ColorModel field1346;
   @ObfuscatedName("w")
   ImageConsumer field1350;

   @ObfuscatedName("e")
   final void vmethod1885(int var1, int var2, Component var3) {
      super.field1366 = var1;
      super.field1362 = var2;
      super.field1361 = new int[1 + var2 * var1];
      this.field1346 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1360 = var3.createImage(this);
      this.method1613();
      var3.prepareImage(super.field1360, this);
      this.method1613();
      var3.prepareImage(super.field1360, this);
      this.method1613();
      var3.prepareImage(super.field1360, this);
      this.method1674();
   }

   @ObfuscatedName("w")
   public final void vmethod1886(Graphics var1, int var2, int var3) {
      this.method1613();
      var1.drawImage(super.field1360, var2, var3, this);
   }

   @ObfuscatedName("f")
   public final void vmethod1897(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1614(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1360, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field1350 == var1;
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field1350 == var1) {
         this.field1350 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   @ObfuscatedName("s")
   synchronized void method1613() {
      if(this.field1350 != null) {
         this.field1350.setPixels(0, 0, super.field1366, super.field1362, this.field1346, super.field1361, 0, super.field1366);
         this.field1350.imageComplete(2);
      }
   }

   @ObfuscatedName("p")
   synchronized void method1614(int var1, int var2, int var3, int var4) {
      if(null != this.field1350) {
         this.field1350.setPixels(var1, var2, var3, var4, this.field1346, super.field1361, var2 * super.field1366 + var1, super.field1366);
         this.field1350.imageComplete(2);
      }
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1350 = var1;
      var1.setDimensions(super.field1366, super.field1362);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1346);
      var1.setHints(14);
   }

   @ObfuscatedName("e")
   public static int method1637(int var0) {
      var0 = (var0 >>> 1 & 1431655765) + (var0 & 1431655765);
      var0 = (var0 & 858993459) + (var0 >>> 2 & 858993459);
      var0 = (var0 >>> 4) + var0 & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("dx")
   static int method1642(class173 var0) {
      class201 var1 = (class201)client.field480.method3788((long)var0.field2816 + ((long)var0.field2794 << 32));
      return null != var1?var1.field3101:var0.field2827;
   }
}
