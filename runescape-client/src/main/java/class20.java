import java.applet.Applet;
import java.lang.management.GarbageCollectorMXBean;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("s")
public class class20 extends Node {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 620413611
   )
   int field569;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1424209265
   )
   int field570;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2104531423
   )
   int field571;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 462952009
   )
   int field572;
   @ObfuscatedName("dx")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("pc")
   static GarbageCollectorMXBean field575;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "2119970126"
   )
   static boolean method558(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class141.field2205.startsWith("win")) {
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
            Applet var7 = class141.field2204;
            Object[] var5 = new Object[]{(new URL(class141.field2204.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return var3 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class141.field2204.getAppletContext().showDocument(new URL(class141.field2204.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class135.method2889(class141.field2204, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class141.field2204.getAppletContext().showDocument(new URL(class141.field2204.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-825133977"
   )
   void method559(int var1, int var2, int var3, int var4) {
      this.field569 = var1;
      this.field570 = var2;
      this.field571 = var3;
      this.field572 = var4;
   }

   class20(int var1, int var2, int var3, int var4) {
      this.field569 = var1;
      this.field570 = var2;
      this.field571 = var3;
      this.field572 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1965937846"
   )
   public static final boolean method562(String var0, String var1, String var2, String var3) {
      return null != var0 && null != var2?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "1623918735"
   )
   static final void method563(Actor var0, int var1) {
      class85.method1926(var0.x, var0.y, var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-26"
   )
   public static void method564() {
      if(null != class174.field2781) {
         class174.field2781.method3039();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)LSpritePixels;",
      garbageValue = "920336380"
   )
   public static SpritePixels method565(class170 var0, int var1, int var2) {
      if(!class126.method2817(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.field1481 = class79.field1460;
         var4.field1482 = class79.field1456;
         var4.field1479 = class79.field1462[0];
         var4.field1480 = class79.field1458[0];
         var4.width = class59.field1268[0];
         var4.height = class79.field1461[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = class8.field139[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = class132.field2126[var6[var7] & 255];
         }

         class35.method747();
         return var4;
      }
   }
}
