import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ad")
public class class40 extends class210 {
   @ObfuscatedName("r")
   String field877;
   @ObfuscatedName("g")
   static String field878;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -344521817
   )
   int field879 = (int)(class34.method713() / 1000L);
   @ObfuscatedName("j")
   short field881;
   @ObfuscatedName("qk")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("b")
   static SpritePixels field883;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2147483647"
   )
   static int method769(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3830((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "119"
   )
   static boolean method770(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class141.field2184.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var11 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var11.indexOf(var0.charAt(var4)) == -1) {
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
            Object var10 = class135.method2898(class141.field2193, var2, new Object[]{(new URL(class141.field2193.getCodeBase(), var0)).toString()});
            return var10 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class141.field2193.getAppletContext().showDocument(new URL(class141.field2193.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class141.field2193;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var9) {
            ;
         }

         try {
            class141.field2193.getAppletContext().showDocument(new URL(class141.field2193.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   class40(String var1, int var2) {
      this.field877 = var1;
      this.field881 = (short)var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-116"
   )
   public static void method771(int var0) {
      class186.field3009 = 1;
      class186.field3010 = null;
      class156.field2330 = -1;
      class128.field2091 = -1;
      class186.field3011 = 0;
      class186.field3016 = false;
      class35.field785 = var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1673899087"
   )
   static final void method772() {
      for(int var0 = 0; var0 < Client.field319; ++var0) {
         int var1 = Client.field320[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(null != var2) {
            class0.method4(var2, var2.composition.field902);
         }
      }

   }
}
