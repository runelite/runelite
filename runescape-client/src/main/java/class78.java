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

@ObfuscatedName("cc")
@Implements("SecondaryBufferProvider")
public final class class78 extends class80 implements ImageProducer, ImageObserver {
   @ObfuscatedName("m")
   ColorModel field1451;
   @ObfuscatedName("w")
   ImageConsumer field1452;
   @ObfuscatedName("qp")
   @Export("bufferProvider")
   public static class80 field1454;
   @ObfuscatedName("r")
   static byte[][][] field1455;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "85277585"
   )
   @Export("draw")
   public final void vmethod1959(Graphics var1, int var2, int var3) {
      this.method1712();
      var1.drawImage(super.field1470, var2, var3, this);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "1024314280"
   )
   public static void method1693(String[] var0, short[] var1) {
      class9.method122(var0, var1, 0, var0.length - 1);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field1452) {
         this.field1452 = null;
      }

   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field1452 == var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIS)V",
      garbageValue = "10294"
   )
   @Export("drawSub")
   public final void vmethod1960(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1707(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1470, 0, 0, this);
      var1.setClip(var6);
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-60"
   )
   final void vmethod1969(int var1, int var2, Component var3) {
      super.field1468 = var1;
      super.field1469 = var2;
      super.field1467 = new int[var1 * var2 + 1];
      this.field1451 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1470 = var3.createImage(this);
      this.method1712();
      var3.prepareImage(super.field1470, this);
      this.method1712();
      var3.prepareImage(super.field1470, this);
      this.method1712();
      var3.prepareImage(super.field1470, this);
      this.method1782();
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIS)V",
      garbageValue = "128"
   )
   synchronized void method1707(int var1, int var2, int var3, int var4) {
      if(null != this.field1452) {
         this.field1452.setPixels(var1, var2, var3, var4, this.field1451, super.field1467, var1 + super.field1468 * var2, super.field1468);
         this.field1452.imageComplete(2);
      }
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-386460754"
   )
   synchronized void method1712() {
      if(this.field1452 != null) {
         this.field1452.setPixels(0, 0, super.field1468, super.field1469, this.field1451, super.field1467, 0, super.field1468);
         this.field1452.imageComplete(2);
      }
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1452 = var1;
      var1.setDimensions(super.field1468, super.field1469);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1451);
      var1.setHints(14);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1430124497"
   )
   static int method1721(int var0, int var1) {
      class15 var2 = (class15)class15.field204.method3856((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.field199.length?var2.field199[var1]:0);
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIB)V",
      garbageValue = "-65"
   )
   static void method1728(class176 var0, int var1, int var2) {
      if(var0.field2800 == 0) {
         var0.field2804 = var0.field2816;
      } else if(var0.field2800 == 1) {
         var0.field2804 = var0.field2816 + (var1 - var0.field2926) / 2;
      } else if(var0.field2800 == 2) {
         var0.field2804 = var1 - var0.field2926 - var0.field2816;
      } else if(var0.field2800 == 3) {
         var0.field2804 = var0.field2816 * var1 >> 14;
      } else if(var0.field2800 == 4) {
         var0.field2804 = (var1 - var0.field2926) / 2 + (var1 * var0.field2816 >> 14);
      } else {
         var0.field2804 = var1 - var0.field2926 - (var0.field2816 * var1 >> 14);
      }

      if(var0.field2909 == 0) {
         var0.field2809 = var0.field2805;
      } else if(var0.field2909 == 1) {
         var0.field2809 = var0.field2805 + (var2 - var0.field2877) / 2;
      } else if(var0.field2909 == 2) {
         var0.field2809 = var2 - var0.field2877 - var0.field2805;
      } else if(var0.field2909 == 3) {
         var0.field2809 = var2 * var0.field2805 >> 14;
      } else if(var0.field2909 == 4) {
         var0.field2809 = (var2 - var0.field2877) / 2 + (var0.field2805 * var2 >> 14);
      } else {
         var0.field2809 = var2 - var0.field2877 - (var0.field2805 * var2 >> 14);
      }

      if(client.field440 && var0.field2929 == 0) {
         if(var0.field2804 < 0) {
            var0.field2804 = 0;
         } else if(var0.field2804 + var0.field2926 > var1) {
            var0.field2804 = var1 - var0.field2926;
         }

         if(var0.field2809 < 0) {
            var0.field2809 = 0;
         } else if(var0.field2809 + var0.field2877 > var2) {
            var0.field2809 = var2 - var0.field2877;
         }
      }

   }
}
