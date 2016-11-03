import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ek")
public class class154 {
   @ObfuscatedName("j")
   static class156 field2300;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IB)I",
      garbageValue = "-3"
   )
   public static int method3162(CharSequence var0, CharSequence var1, int var2) {
      int var3 = var0.length();
      int var4 = var1.length();
      int var5 = 0;
      int var6 = 0;
      byte var7 = 0;
      byte var8 = 0;

      while(var5 - var7 < var3 || var6 - var8 < var4) {
         if(var5 - var7 >= var3) {
            return -1;
         }

         if(var6 - var8 >= var4) {
            return 1;
         }

         char var9;
         if(var7 != 0) {
            var9 = (char)var7;
            boolean var14 = false;
         } else {
            var9 = var0.charAt(var5++);
         }

         char var10;
         if(var8 != 0) {
            var10 = (char)var8;
            boolean var15 = false;
         } else {
            var10 = var1.charAt(var6++);
         }

         byte var11;
         if(var9 == 198) {
            var11 = 69;
         } else if(var9 == 230) {
            var11 = 101;
         } else if(var9 == 223) {
            var11 = 115;
         } else if(var9 == 338) {
            var11 = 69;
         } else if(var9 == 339) {
            var11 = 101;
         } else {
            var11 = 0;
         }

         var7 = var11;
         byte var12;
         if(var10 == 198) {
            var12 = 69;
         } else if(var10 == 230) {
            var12 = 101;
         } else if(var10 == 223) {
            var12 = 115;
         } else if(var10 == 338) {
            var12 = 69;
         } else if(var10 == 339) {
            var12 = 101;
         } else {
            var12 = 0;
         }

         var8 = var12;
         var9 = class127.method2850(var9, var2);
         var10 = class127.method2850(var10, var2);
         if(var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
            var9 = Character.toLowerCase(var9);
            var10 = Character.toLowerCase(var10);
            if(var9 != var10) {
               return class145.method3018(var9, var2) - class145.method3018(var10, var2);
            }
         }
      }

      int var16 = Math.min(var3, var4);

      int var17;
      char var20;
      for(var17 = 0; var17 < var16; ++var17) {
         char var18 = var0.charAt(var17);
         var20 = var1.charAt(var17);
         if(var18 != var20 && Character.toUpperCase(var18) != Character.toUpperCase(var20)) {
            var18 = Character.toLowerCase(var18);
            var20 = Character.toLowerCase(var20);
            if(var20 != var18) {
               return class145.method3018(var18, var2) - class145.method3018(var20, var2);
            }
         }
      }

      var17 = var3 - var4;
      if(var17 != 0) {
         return var17;
      } else {
         for(int var19 = 0; var19 < var16; ++var19) {
            var20 = var0.charAt(var19);
            char var13 = var1.charAt(var19);
            if(var20 != var13) {
               return class145.method3018(var20, var2) - class145.method3018(var13, var2);
            }
         }

         return 0;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "1325436655"
   )
   public static boolean method3163(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class141.field2182.startsWith("win")) {
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
            Applet var7 = class141.field2188;
            Object[] var5 = new Object[]{(new URL(class141.field2188.getCodeBase(), var0)).toString()};
            Object var13 = JSObject.getWindow(var7).call(var2, var5);
            return var13 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class141.field2188.getAppletContext().showDocument(new URL(class141.field2188.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class141.field2188;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var12) {
            ;
         }

         try {
            class141.field2188.getAppletContext().showDocument(new URL(class141.field2188.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1144057"
   )
   static void method3164() {
      Canvas var0 = VertexNormal.canvas;
      var0.removeKeyListener(class140.keyboard);
      var0.removeFocusListener(class140.keyboard);
      class140.field2166 = -1;
      class48.method1002(VertexNormal.canvas);
      if(class13.field201 != null) {
         class13.field201.vmethod3132(VertexNormal.canvas);
      }

      Client.field480.method3051();
      VertexNormal.canvas.setBackground(Color.black);
      class16.method169(VertexNormal.canvas);
      Canvas var1 = VertexNormal.canvas;
      var1.addMouseListener(class143.mouse);
      var1.addMouseMotionListener(class143.mouse);
      var1.addFocusListener(class143.mouse);
      if(class13.field201 != null) {
         class13.field201.vmethod3134(VertexNormal.canvas);
      }

      if(Client.widgetRoot != -1) {
         ObjectComposition.method874(Client.widgetRoot, GroundObject.field1652, VertexNormal.field1689, false);
      }

      GameEngine.field2255 = true;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1530425599"
   )
   static String method3165(int var0) {
      return "<img=" + var0 + ">";
   }
}
