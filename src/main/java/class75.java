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

@ObfuscatedName("bk")
public final class class75 extends class77 implements ImageProducer, ImageObserver {
   @ObfuscatedName("r")
   ImageConsumer field1371;
   @ObfuscatedName("a")
   ColorModel field1373;
   @ObfuscatedName("l")
   public static class223 field1374;

   @ObfuscatedName("a")
   final void vmethod1893(int var1, int var2, Component var3) {
      super.field1395 = var1;
      super.field1389 = var2;
      super.field1394 = new int[var1 * var2 + 1];
      this.field1373 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1392 = var3.createImage(this);
      this.method1646();
      var3.prepareImage(super.field1392, this);
      this.method1646();
      var3.prepareImage(super.field1392, this);
      this.method1646();
      var3.prepareImage(super.field1392, this);
      this.method1723();
   }

   @ObfuscatedName("r")
   public final void vmethod1900(Graphics var1, int var2, int var3) {
      this.method1646();
      var1.drawImage(super.field1392, var2, var3, this);
   }

   @ObfuscatedName("f")
   public final void vmethod1895(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1647(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1392, 0, 0, this);
      var1.setClip(var6);
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("s")
   synchronized void method1646() {
      if(this.field1371 != null) {
         this.field1371.setPixels(0, 0, super.field1395, super.field1389, this.field1373, super.field1394, 0, super.field1395);
         this.field1371.imageComplete(2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1321533811"
   )
   synchronized void method1647(int var1, int var2, int var3, int var4) {
      if(this.field1371 != null) {
         this.field1371.setPixels(var1, var2, var3, var4, this.field1373, super.field1394, var1 + super.field1395 * var2, super.field1395);
         this.field1371.imageComplete(2);
      }
   }

   @ObfuscatedName("a")
   public static class51 method1648(int var0) {
      class51 var1 = (class51)class51.field1137.method3792((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class51.field1146.method3263(10, var0);
         var1 = new class51();
         var1.field1110 = var0;
         if(null != var2) {
            var1.method1043(new class118(var2));
         }

         var1.method1070();
         if(var1.field1120 != -1) {
            var1.method1045(method1648(var1.field1120), method1648(var1.field1145));
         }

         if(var1.field1131 != -1) {
            var1.method1046(method1648(var1.field1131), method1648(var1.field1154));
         }

         if(!class51.field1109 && var1.field1128) {
            var1.field1115 = "Members object";
            var1.field1132 = false;
            var1.field1129 = null;
            var1.field1135 = null;
            var1.field1152 = 0;
         }

         class51.field1137.method3794(var1, (long)var0);
         return var1;
      }
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1371 = var1;
      var1.setDimensions(super.field1395, super.field1389);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1373);
      var1.setHints(14);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field1371 == var1;
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field1371 == var1) {
         this.field1371 = null;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "391100713"
   )
   public static void method1671(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method1671(var0, var1, var2, var5 - 1);
         method1671(var0, var1, 1 + var5, var3);
      }

   }

   @ObfuscatedName("g")
   public static class223 method1673(class166 var0, class166 var1, String var2, String var3) {
      int var4 = var0.method3278(var2);
      int var5 = var0.method3328(var4, var3);
      return class138.method2951(var0, var1, var4, var5);
   }
}
