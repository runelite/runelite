import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("el")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 422473713
   )
   @Export("__el_x")
   public static int __el_x;
   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "Lln;"
   )
   @Export("__el_gm")
   static Sprite __el_gm;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2074333261
   )
   @Export("__m")
   int __m;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1376860893
   )
   @Export("__f")
   int __f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2619977
   )
   @Export("__q")
   int __q;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)Lcg;",
      garbageValue = "-1788849120"
   )
   static Script method3236(int var0, int var1, int var2) {
      int var3 = UnitPriceComparator.method125(var1, var0);
      Script var4 = WidgetGroupParent.method1175(var3, var0);
      if(var4 != null) {
         return var4;
      } else {
         var3 = PacketBuffer.method4081(var2, var0);
         var4 = WidgetGroupParent.method1175(var3, var0);
         return var4 != null?var4:null;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-1495992318"
   )
   static boolean method3237(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class50.__af_f.startsWith("win")) {
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
            Applet var7 = class50.__af_m;
            Object[] var5 = new Object[]{(new URL(class50.__af_m.getCodeBase(), var0)).toString()};
            Object var3 = JSObject.getWindow(var7).call(var2, var5);
            return var3 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class50.__af_m.getAppletContext().showDocument(new URL(class50.__af_m.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class46.method851(class50.__af_m, "loggedout");
         } catch (Throwable var12) {
            ;
         }

         try {
            class50.__af_m.getAppletContext().showDocument(new URL(class50.__af_m.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
