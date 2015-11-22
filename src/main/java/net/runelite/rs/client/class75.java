package net.runelite.rs.client;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bb")
public final class class75 extends class77 implements ImageProducer, ImageObserver {
   @ObfuscatedName("j")
   ColorModel field1358;
   @ObfuscatedName("m")
   ImageConsumer field1359;
   @ObfuscatedName("bt")
   static class167 field1364;

   @ObfuscatedName("m")
   public final void vmethod1895(Graphics var1, int var2, int var3) {
      this.method1662();
      var1.drawImage(super.field1382, var2, var3, this);
   }

   @ObfuscatedName("f")
   public final void vmethod1897(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1633(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1382, 0, 0, this);
      var1.setClip(var6);
   }

   @ObfuscatedName("j")
   public final void vmethod1896(int var1, int var2, Component var3) {
      super.field1381 = var1;
      super.field1380 = var2;
      super.field1387 = new int[1 + var2 * var1];
      this.field1358 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1382 = var3.createImage(this);
      this.method1662();
      var3.prepareImage(super.field1382, this);
      this.method1662();
      var3.prepareImage(super.field1382, this);
      this.method1662();
      var3.prepareImage(super.field1382, this);
      this.method1713();
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field1359;
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field1359 == var1) {
         this.field1359 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("u")
   synchronized void method1633(int var1, int var2, int var3, int var4) {
      if(null != this.field1359) {
         this.field1359.setPixels(var1, var2, var3, var4, this.field1358, super.field1387, var2 * super.field1381 + var1, super.field1381);
         this.field1359.imageComplete(2);
      }
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1359 = var1;
      var1.setDimensions(super.field1381, super.field1380);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1358);
      var1.setHints(14);
   }

   @ObfuscatedName("t")
   static class78 method1651() {
      class78 var0 = new class78();
      var0.field1388 = class76.field1367;
      var0.field1399 = class76.field1368;
      var0.field1391 = class76.field1366[0];
      var0.field1392 = class76.field1370[0];
      var0.field1389 = class76.field1371[0];
      var0.field1390 = class76.field1373[0];
      int var1 = var0.field1389 * var0.field1390;
      byte[] var2 = class17.field236[0];
      var0.field1394 = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.field1394[var3] = class76.field1369[var2[var3] & 255];
      }

      class135.method2935();
      return var0;
   }

   @ObfuscatedName("l")
   synchronized void method1662() {
      if(this.field1359 != null) {
         this.field1359.setPixels(0, 0, super.field1381, super.field1380, this.field1358, super.field1387, 0, super.field1381);
         this.field1359.imageComplete(2);
      }
   }

   @ObfuscatedName("f")
   public static class226 method1666(String var0, String var1, boolean var2) {
      File var3 = new File(class148.field2226, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class226 var10 = new class226(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class20.field562 == 33) {
         var4 = "_rc";
      } else if(34 == class20.field562) {
         var4 = "_wip";
      }

      File var5 = new File(class0.field14, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class226 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class226(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class226(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }
}
