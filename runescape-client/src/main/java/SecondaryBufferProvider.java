import java.applet.Applet;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("cn")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("e")
   ImageConsumer field1422;
   @ObfuscatedName("f")
   ColorModel field1427;

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-15"
   )
   public final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[1 + var1 * var2];
      this.field1427 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method1663();
      var3.prepareImage(super.image, this);
      this.method1663();
      var3.prepareImage(super.image, this);
      this.method1663();
      var3.prepareImage(super.image, this);
      this.method1730();
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1422 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1427);
      var1.setHints(14);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-549410354"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1685(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field1422) {
         this.field1422 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1247096033"
   )
   synchronized void method1663() {
      if(null != this.field1422) {
         this.field1422.setPixels(0, 0, super.width, super.height, this.field1427, super.pixels, 0, super.width);
         this.field1422.imageComplete(2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "113"
   )
   public static int method1664(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-110190948"
   )
   public static boolean method1668(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class141.field2180.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var13 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var13.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class141.field2182;
            Object[] var5 = new Object[]{(new URL(class141.field2182.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return var3 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class141.field2182.getAppletContext().showDocument(new URL(class141.field2182.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class135.method2861(class141.field2182, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class141.field2182.getAppletContext().showDocument(new URL(class141.field2182.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field1422;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1956174738"
   )
   static final boolean method1680(int var0, int var1) {
      ObjectComposition var2 = class8.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method825(var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1471816409"
   )
   synchronized void method1685(int var1, int var2, int var3, int var4) {
      if(this.field1422 != null) {
         this.field1422.setPixels(var1, var2, var3, var4, this.field1427, super.pixels, var1 + super.width * var2, super.width);
         this.field1422.imageComplete(2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Lclass23;",
      garbageValue = "-155688594"
   )
   static class23 method1691(int var0) {
      class23 var1 = (class23)class23.field609.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Client.field531.method3304(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class23();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method2538();
            var1.field597 = var3.method2535();
            var1.field602 = var3.method2535();
            var1.field599 = var3.method2535();
            var1.field607 = var3.method2535();
            var3.offset = 0;
            var3.method2540();
            var1.field594 = new int[var4];
            var1.field593 = new int[var4];
            var1.field596 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field594[var5++] = var6) {
               var6 = var3.method2535();
               if(var6 == 3) {
                  var1.field596[var5] = var3.method2541();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field593[var5] = var3.method2538();
               } else {
                  var1.field593[var5] = var3.method2656();
               }
            }

            class23.field609.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "72"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method1663();
      var1.drawImage(super.image, var2, var3, this);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-986051471"
   )
   static SpritePixels method1694() {
      SpritePixels var0 = new SpritePixels();
      var0.field1462 = class79.field1430;
      var0.field1457 = class79.field1437;
      var0.field1460 = class189.field3050[0];
      var0.field1455 = class79.field1431[0];
      var0.width = class79.field1432[0];
      var0.height = XItemContainer.field221[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = BufferProvider.field1450[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class137.field2130[var2[var3] & 255];
      }

      class14.method161();
      return var0;
   }
}
