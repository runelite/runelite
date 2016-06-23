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

@ObfuscatedName("bu")
@Implements("SecondaryBufferProvider")
public final class class75 extends class77 implements ImageProducer, ImageObserver {
   @ObfuscatedName("u")
   ImageConsumer field1389;
   @ObfuscatedName("f")
   ColorModel field1395;

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field1389;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-41"
   )
   public final void vmethod1929(int var1, int var2, Component var3) {
      super.field1402 = var1;
      super.field1404 = var2;
      super.field1406 = new int[1 + var2 * var1];
      this.field1395 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1405 = var3.createImage(this);
      this.method1682();
      var3.prepareImage(super.field1405, this);
      this.method1682();
      var3.prepareImage(super.field1405, this);
      this.method1682();
      var3.prepareImage(super.field1405, this);
      this.method1733();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-1142358962"
   )
   @Export("draw")
   public final void vmethod1939(Graphics var1, int var2, int var3) {
      this.method1682();
      var1.drawImage(super.field1405, var2, var3, this);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-1276226507"
   )
   @Export("drawSub")
   public final void vmethod1931(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1667(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1405, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1389 = var1;
      var1.setDimensions(super.field1402, super.field1404);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1395);
      var1.setHints(14);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-92"
   )
   synchronized void method1667(int var1, int var2, int var3, int var4) {
      if(null != this.field1389) {
         this.field1389.setPixels(var1, var2, var3, var4, this.field1395, super.field1406, var1 + var2 * super.field1402, super.field1402);
         this.field1389.imageComplete(2);
      }
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field1389) {
         this.field1389 = null;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1851782589"
   )
   synchronized void method1682() {
      if(null != this.field1389) {
         this.field1389.setPixels(0, 0, super.field1402, super.field1404, this.field1395, super.field1406, 0, super.field1402);
         this.field1389.imageComplete(2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass167;I)V",
      garbageValue = "65280"
   )
   public static void method1697(class167 var0) {
      class217.field3163 = var0;
      class129.field2054 = class217.field3163.method3321(16);
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "([Lclass173;Lclass173;ZI)V",
      garbageValue = "1664682832"
   )
   static void method1698(class173[] var0, class173 var1, boolean var2) {
      int var3 = var1.field2777 != 0?var1.field2777:var1.field2769;
      int var4 = var1.field2778 != 0?var1.field2778:var1.field2888;
      class183.method3633(var0, var1.field2869, var3, var4, var2);
      if(null != var1.field2767) {
         class183.method3633(var1.field2767, var1.field2869, var3, var4, var2);
      }

      class3 var5 = (class3)client.field448.method3822((long)var1.field2869);
      if(null != var5) {
         int var6 = var5.field64;
         if(class135.method2897(var6)) {
            class183.method3633(class173.field2770[var6], -1, var3, var4, var2);
         }
      }

      if(var1.field2758 == 1337) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2043680265"
   )
   static final int method1699(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZZZS)Lclass168;",
      garbageValue = "6567"
   )
   static class168 method1700(int var0, boolean var1, boolean var2, boolean var3) {
      class134 var4 = null;
      if(class149.field2237 != null) {
         var4 = new class134(var0, class149.field2237, class17.field257[var0], 1000000);
      }

      return new class168(var4, client.field566, var0, var1, var2, var3);
   }
}
