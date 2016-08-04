import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("SecondaryBufferProvider")
public final class class78 extends class80 implements ImageProducer, ImageObserver {
   @ObfuscatedName("g")
   ImageConsumer field1447;
   @ObfuscatedName("aa")
   static class171 field1448;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -1559075913
   )
   protected static int field1450;
   @ObfuscatedName("l")
   ColorModel field1451;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -158041127
   )
   static int field1452;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "42"
   )
   public final void vmethod1964(int var1, int var2, Component var3) {
      super.field1470 = var1;
      super.field1472 = var2;
      super.field1474 = new int[1 + var1 * var2];
      this.field1451 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1475 = var3.createImage(this);
      this.method1715();
      var3.prepareImage(super.field1475, this);
      this.method1715();
      var3.prepareImage(super.field1475, this);
      this.method1715();
      var3.prepareImage(super.field1475, this);
      this.method1787();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "1769215131"
   )
   @Export("draw")
   public final void vmethod1965(Graphics var1, int var2, int var3) {
      this.method1715();
      var1.drawImage(super.field1475, var2, var3, this);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "-75"
   )
   @Export("drawSub")
   public final void vmethod1963(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1716(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1475, 0, 0, this);
      var1.setClip(var6);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;B)Ljava/lang/String;",
      garbageValue = "-74"
   )
   static String method1713(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class151) {
         class151 var2 = (class151)var0;
         var1 = var2.field2285 + " | ";
         var0 = var2.field2283;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(null == var7) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, 1 + var8);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(5 + var11);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field1447 == var1;
   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "4261"
   )
   synchronized void method1715() {
      if(null != this.field1447) {
         this.field1447.setPixels(0, 0, super.field1470, super.field1472, this.field1451, super.field1474, 0, super.field1470);
         this.field1447.imageComplete(2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2020989264"
   )
   synchronized void method1716(int var1, int var2, int var3, int var4) {
      if(null != this.field1447) {
         this.field1447.setPixels(var1, var2, var3, var4, this.field1451, super.field1474, var1 + var2 * super.field1470, super.field1470);
         this.field1447.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "124"
   )
   @Export("sendGameMessage")
   static void method1721(int var0, String var1, String var2) {
      class6.method105(var0, var1, var2, (String)null);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1447 = var1;
      var1.setDimensions(super.field1470, super.field1472);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1451);
      var1.setHints(14);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass146;ZI)V",
      garbageValue = "-1044146147"
   )
   public static void method1722(class146 var0, boolean var1) {
      if(null != class174.field2790) {
         try {
            class174.field2790.method3131();
         } catch (Exception var6) {
            ;
         }

         class174.field2790 = null;
      }

      class174.field2790 = var0;
      class161.method3314(var1);
      class174.field2775.field2050 = 0;
      class174.field2780 = null;
      class159.field2368 = null;
      class174.field2782 = 0;

      while(true) {
         class175 var2 = (class175)class174.field2777.method3939();
         if(var2 == null) {
            while(true) {
               var2 = (class175)class174.field2778.method3939();
               if(null == var2) {
                  if(class174.field2773 != 0) {
                     try {
                        class122 var7 = new class122(4);
                        var7.method2783(4);
                        var7.method2783(class174.field2773);
                        var7.method2619(0);
                        class174.field2790.method3135(var7.field2051, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class174.field2790.method3131();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class174.field2787;
                        class174.field2790 = null;
                     }
                  }

                  class174.field2769 = 0;
                  class174.field2770 = class56.method1249();
                  return;
               }

               class174.field2772.method4043(var2);
               class174.field2776.method3940(var2, var2.field3175);
               ++class174.field2768;
               --class174.field2779;
            }
         }

         class174.field2771.method3940(var2, var2.field3175);
         ++class174.field2781;
         --class174.field2774;
      }
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field1447 == var1) {
         this.field1447 = null;
      }

   }
}
