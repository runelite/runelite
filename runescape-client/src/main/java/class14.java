import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
public class class14 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -2048771753
   )
   int field213 = -1;
   @ObfuscatedName("r")
   int[] field214;
   @ObfuscatedName("e")
   String[] field215;
   @ObfuscatedName("hc")
   @ObfuscatedGetter(
      intValue = 170834075
   )
   @Export("menuY")
   static int field218;
   @ObfuscatedName("l")
   class23 field219;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "120"
   )
   static int method177(int var0, int var1) {
      class15 var2 = (class15)class15.field225.method3936((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.field224.length; ++var4) {
            if(var1 == var2.field221[var4]) {
               var3 += var2.field224[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "1279667812"
   )
   static boolean method178(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class141.field2193.startsWith("win")) {
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
            Object var3 = class135.method2991(class141.field2195, var2, new Object[]{(new URL(class141.field2195.getCodeBase(), var0)).toString()});
            return null != var3;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class141.field2195.getAppletContext().showDocument(new URL(class141.field2195.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class135.method2990(class141.field2195, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class141.field2195.getAppletContext().showDocument(new URL(class141.field2195.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1588396508"
   )
   public static boolean method179(int var0) {
      if(class176.field2797[var0]) {
         return true;
      } else if(!class176.field2798.method3421(var0)) {
         return false;
      } else {
         int var1 = class176.field2798.method3405(var0);
         if(var1 == 0) {
            class176.field2797[var0] = true;
            return true;
         } else {
            if(class176.field2836[var0] == null) {
               class176.field2836[var0] = new class176[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == class176.field2836[var0][var2]) {
                  byte[] var3 = class176.field2798.method3411(var0, var2);
                  if(null != var3) {
                     class176.field2836[var0][var2] = new class176();
                     class176.field2836[var0][var2].field2807 = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class176.field2836[var0][var2].method3549(new class122(var3));
                     } else {
                        class176.field2836[var0][var2].method3548(new class122(var3));
                     }
                  }
               }
            }

            class176.field2797[var0] = true;
            return true;
         }
      }
   }
}
