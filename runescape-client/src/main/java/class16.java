import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("s")
public class class16 extends class131 {
   @ObfuscatedName("m")
   short field162;
   @ObfuscatedName("d")
   String field163;
   @ObfuscatedName("er")
   static SpritePixels[] field167;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 876683149
   )
   int field168 = (int)(class202.method3838() / 1000L);
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = 227828305
   )
   public static int field169;
   @ObfuscatedName("de")
   @ObfuscatedGetter(
      intValue = 2105556273
   )
   @Export("baseX")
   static int baseX;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "-45"
   )
   static boolean method197(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class114.field1794.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var14 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var14.indexOf(var0.charAt(var4)) == -1) {
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
            Applet var7 = class114.field1793;
            Object[] var5 = new Object[]{(new URL(class114.field1793.getCodeBase(), var0)).toString()};
            Object var13 = JSObject.getWindow(var7).call(var2, var5);
            return null != var13;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class114.field1793.getAppletContext().showDocument(new URL(class114.field1793.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class114.field1793;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var12) {
            ;
         }

         try {
            class114.field1793.getAppletContext().showDocument(new URL(class114.field1793.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "1728255672"
   )
   static final boolean method198(Widget var0) {
      if(var0.field2181 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2181.length; ++var1) {
            int var2 = Widget.method2893(var0, var1);
            int var3 = var0.field2183[var1];
            if(var0.field2181[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2181[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2181[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }

   class16(String var1, int var2) {
      this.field163 = var1;
      this.field162 = (short)var2;
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1714463579"
   )
   static final void method199(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field488; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field491[var4] = true;
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "-34867529"
   )
   static void method200(Sequence var0, int var1, int var2, int var3) {
      if(Client.field527 < 50 && Client.field526 != 0) {
         if(var0.field3056 != null && var1 < var0.field3056.length) {
            int var4 = var0.field3056[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field528[Client.field527] = var5;
               Client.field529[Client.field527] = var6;
               Client.field431[Client.field527] = 0;
               Client.field532[Client.field527] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field299[Client.field527] = (var9 << 8) + (var8 << 16) + var7;
               ++Client.field527;
            }
         }
      }
   }
}
