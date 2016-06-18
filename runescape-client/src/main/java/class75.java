import java.awt.Component;
import java.awt.Frame;
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
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("SecondaryBufferProvider")
public final class class75 extends class77 implements ImageProducer, ImageObserver {
   @ObfuscatedName("b")
   ColorModel field1341;
   @ObfuscatedName("g")
   ImageConsumer field1342;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = 1749802333
   )
   static int field1343;
   @ObfuscatedName("qq")
   protected static Frame field1346;
   @ObfuscatedName("o")
   public static class119 field1348;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "1568651033"
   )
   public final void vmethod1878(int var1, int var2, Component var3) {
      super.field1363 = var1;
      super.field1364 = var2;
      super.field1368 = new int[1 + var1 * var2];
      this.field1341 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1362 = var3.createImage(this);
      this.method1641();
      var3.prepareImage(super.field1362, this);
      this.method1641();
      var3.prepareImage(super.field1362, this);
      this.method1641();
      var3.prepareImage(super.field1362, this);
      this.method1685();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "94"
   )
   @Export("draw")
   public final void vmethod1887(Graphics var1, int var2, int var3) {
      this.method1641();
      var1.drawImage(super.field1362, var2, var3, this);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "2144576879"
   )
   @Export("drawSub")
   public final void vmethod1879(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1639(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1362, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1342 = var1;
      var1.setDimensions(super.field1363, super.field1364);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1341);
      var1.setHints(14);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field1342;
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field1342) {
         this.field1342 = null;
      }

   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-888776924"
   )
   synchronized void method1639(int var1, int var2, int var3, int var4) {
      if(this.field1342 != null) {
         this.field1342.setPixels(var1, var2, var3, var4, this.field1341, super.field1368, var2 * super.field1363 + var1, super.field1363);
         this.field1342.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "128"
   )
   synchronized void method1641() {
      if(this.field1342 != null) {
         this.field1342.setPixels(0, 0, super.field1363, super.field1364, this.field1341, super.field1368, 0, super.field1363);
         this.field1342.imageComplete(2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;I)V",
      garbageValue = "766936436"
   )
   public static void method1656(class167 var0, class167 var1) {
      class44.field1012 = var0;
      class44.field1006 = var1;
      class44.field1010 = class44.field1012.method3276(3);
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1166234848"
   )
   static final void method1657(String var0) {
      if(var0 != null) {
         String var1 = class39.method796(var0, client.field289);
         if(null != var1) {
            for(int var2 = 0; var2 < client.field513; ++var2) {
               class7 var3 = client.field559[var2];
               String var4 = var3.field124;
               String var5 = class39.method796(var4, client.field289);
               boolean var6;
               if(null != var0 && null != var4) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --client.field513;

                  for(int var7 = var2; var7 < client.field513; ++var7) {
                     client.field559[var7] = client.field559[1 + var7];
                  }

                  client.field492 = client.field359;
                  client.field331.method2781(234);
                  client.field331.method2650(class4.method41(var0));
                  client.field331.method2505(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "290236071"
   )
   static void method1658(int var0, boolean var1, int var2, boolean var3) {
      if(null != class25.field635) {
         class90.method2088(0, class25.field635.length - 1, var0, var1, var2, var3);
      }

   }
}
