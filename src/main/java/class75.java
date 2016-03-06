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
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bp")
public final class class75 extends class77 implements ImageProducer, ImageObserver {
   @ObfuscatedName("j")
   ColorModel field1379;
   @ObfuscatedName("jc")
   static class172[] field1381;
   @ObfuscatedName("g")
   static int[][][] field1383;
   @ObfuscatedName("l")
   ImageConsumer field1384;
   @ObfuscatedName("qx")
   public static class77 field1385;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 1591567857
   )
   @Export("plane")
   static int field1386;
   @ObfuscatedName("hn")
   @ObfuscatedGetter(
      intValue = 572824159
   )
   static int field1387;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1635065399
   )
   public static int field1388;

   @ObfuscatedName("j")
   final void vmethod1841(int var1, int var2, Component var3) {
      super.field1400 = var1;
      super.field1401 = var2;
      super.field1402 = new int[var2 * var1 + 1];
      this.field1379 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1399 = var3.createImage(this);
      this.method1616();
      var3.prepareImage(super.field1399, this);
      this.method1616();
      var3.prepareImage(super.field1399, this);
      this.method1616();
      var3.prepareImage(super.field1399, this);
      this.method1667();
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("a")
   public final void vmethod1847(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1602(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1399, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1384 = var1;
      var1.setDimensions(super.field1400, super.field1401);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1379);
      var1.setHints(14);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field1384 == var1) {
         this.field1384 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field1384 == var1;
   }

   @ObfuscatedName("f")
   synchronized void method1602(int var1, int var2, int var3, int var4) {
      if(this.field1384 != null) {
         this.field1384.setPixels(var1, var2, var3, var4, this.field1379, super.field1402, var2 * super.field1400 + var1, super.field1400);
         this.field1384.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("l")
   public final void vmethod1842(Graphics var1, int var2, int var3) {
      this.method1616();
      var1.drawImage(super.field1399, var2, var3, this);
   }

   @ObfuscatedName("u")
   static final int method1612(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
      return var3;
   }

   @ObfuscatedName("i")
   synchronized void method1616() {
      if(this.field1384 != null) {
         this.field1384.setPixels(0, 0, super.field1400, super.field1401, this.field1379, super.field1402, 0, super.field1400);
         this.field1384.imageComplete(2);
      }
   }

   @ObfuscatedName("a")
   public static class223 method1631(class166 var0, class166 var1, int var2, int var3) {
      return !class11.method148(var0, var2, var3)?null:class5.method52(var1.method3214(var2, var3));
   }
}
