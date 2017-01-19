import java.awt.Canvas;
import java.awt.Color;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class140 extends Node {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -743065503
   )
   int field1964;
   @ObfuscatedName("c")
   class142 field1965;
   @ObfuscatedName("z")
   class66 field1966;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -563323509
   )
   int field1967;
   @ObfuscatedName("f")
   class55 field1968;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 911575851
   )
   int field1969;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1359182849
   )
   int field1970;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2087607375
   )
   int field1971;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1727675065
   )
   int field1972;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -537509243
   )
   int field1973;
   @ObfuscatedName("h")
   class137 field1974;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -323443279
   )
   int field1975;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2054632871
   )
   int field1976;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -847008023
   )
   int field1977;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -124739307
   )
   int field1978;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 556969381
   )
   int field1979;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 667267197
   )
   int field1980;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1148589857
   )
   int field1981;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 141820745
   )
   int field1982;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1866637405
   )
   int field1984;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1660403845
   )
   int field1985;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1745410756"
   )
   void method2546() {
      this.field1965 = null;
      this.field1968 = null;
      this.field1974 = null;
      this.field1966 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass184;IIIBZB)V",
      garbageValue = "-85"
   )
   static void method2547(class184 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class181 var8 = (class181)class185.field2750.method2274(var6);
      if(null == var8) {
         var8 = (class181)class185.field2752.method2274(var6);
         if(var8 == null) {
            var8 = (class181)class185.field2765.method2274(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method2361();
                  class185.field2750.method2282(var8, var6);
                  --class185.field2747;
                  ++class185.field2751;
               }

            } else {
               if(!var5) {
                  var8 = (class181)class185.field2757.method2274(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class181();
               var8.field2706 = var0;
               var8.field2707 = var3;
               var8.field2708 = var4;
               if(var5) {
                  class185.field2750.method2282(var8, var6);
                  ++class185.field2751;
               } else {
                  class185.field2754.method2226(var8);
                  class185.field2765.method2282(var8, var6);
                  ++class185.field2747;
               }

            }
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "602605002"
   )
   static boolean method2551(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class114.field1791.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class100.method1894(class114.field1795, var2, new Object[]{(new URL(class114.field1795.getCodeBase(), var0)).toString()});
            return null != var3;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class114.field1795.getAppletContext().showDocument(new URL(class114.field1795.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class100.method1893(class114.field1795, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class114.field1795.getAppletContext().showDocument(new URL(class114.field1795.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1241024899"
   )
   static void method2552() {
      Canvas var0 = class25.canvas;
      var0.removeKeyListener(class105.keyboard);
      var0.removeFocusListener(class105.keyboard);
      class105.field1712 = -1;
      CombatInfoListHolder.method694(class25.canvas);
      if(class184.field2746 != null) {
         class184.field2746.vmethod2036(class25.canvas);
      }

      class227.field3230.method2051();
      class25.canvas.setBackground(Color.black);
      class183.method3267(class25.canvas);
      class139.method2544(class25.canvas);
      if(class184.field2746 != null) {
         class184.field2746.vmethod2041(class25.canvas);
      }

      if(Client.widgetRoot != -1) {
         Item.method770(false);
      }

      GameEngine.field1770 = true;
   }
}
