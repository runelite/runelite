package net.runelite.rsmv;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Hashtable;

public final class class13 implements ImageObserver, ImageProducer {
   private int[] field53;
   private int[] field54;
   private final int field55;
   private final int field56;
   private final ColorModel field57 = new DirectColorModel(32, 16711680, '\uff00', 255);
   private ImageConsumer field58;
   private final Image field59;

   public class13(int var1, int var2, Component var3) {
      class5.method2(0.8D);
      class5.method1();
      class5.method0(var1, var2);
      this.field53 = class5.field18;
      this.field55 = var1;
      this.field56 = var2;
      this.field54 = new int[var1 * var2];
      this.field59 = var3.createImage(this);
      this.method24();
      var3.prepareImage(this.field59, this);
      this.method22();
   }

   private void method22() {
      int[] var3 = this.field54;
      int var2 = this.field55;
      int var1 = this.field56;
      class14.field60 = var3;
      class14.field61 = var2;
      class14.field62 = var1;
      int var10000 = var1;
      boolean var4 = false;
      var2 = var2;
      var4 = false;
      var1 = var10000;
      if(var2 > class14.field61) {
         var2 = class14.field61;
      }

      if(var1 > class14.field62) {
         var1 = class14.field62;
      }

      class14.field64 = var2;
      class14.field63 = var1;
      class14.field65 = class14.field64 - 1;
   }

   public final void method23(int var1, int var2, Graphics var3) {
      this.method24();
      var3.drawImage(this.field59, 0, 0, this);
   }

   public final synchronized void addConsumer(ImageConsumer var1) {
      this.field58 = var1;
      var1.setDimensions(this.field55, this.field56);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field57);
      var1.setHints(14);
   }

   public final synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field58 == var1;
   }

   public final synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field58 == var1) {
         this.field58 = null;
      }

   }

   public final void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public final void requestTopDownLeftRightResend(ImageConsumer var1) {
      System.out.println("TDLR");
   }

   private synchronized void method24() {
      if(this.field58 != null) {
         this.field58.setPixels(0, 0, this.field55, this.field56, this.field57, this.field54, 0, this.field55);
         this.field58.imageComplete(2);
      }

   }

   public final boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public final void method25(Model var1, int var2, int var3, int var4, int var5, int var6) {
      this.method22();
      class5.field18 = this.field53;
      var2 = class5.field12;
      var4 = class5.field13;
      int var7 = class5.field16[var3] * var6 >> 16;
      var6 = class5.field17[var3] * var6 >> 16;
      if(var1 != null) {
         var1.method40(0, var5, 0, var3, 0, var7, var6);
         class5.field12 = var2;
         class5.field13 = var4;
      } else {
         throw new NullPointerException("You cant render a null model");
      }
   }

   public final void method26() {
      this.method22();
      int var1 = class14.field61 * class14.field62;

      for(int var2 = 0; var2 < var1; ++var2) {
         class14.field60[var2] = 0;
      }

   }
}
