import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class185 {
   @ObfuscatedName("t")
   byte[] field3011;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 971554673
   )
   int field3012;
   @ObfuscatedName("i")
   byte[] field3013;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 275517637
   )
   int field3014;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1507232769
   )
   int field3015;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -462799231
   )
   int field3016;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1975333659
   )
   int field3017;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1890534211
   )
   int field3018;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1133924437
   )
   int field3019;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-1807801140"
   )
   static boolean method3673(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class138.field2155.startsWith("win")) {
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
            Object var3 = class132.method2822(class138.field2156, var2, new Object[]{(new URL(class138.field2156.getCodeBase(), var0)).toString()});
            return null != var3;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class138.field2156.getAppletContext().showDocument(new URL(class138.field2156.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class132.method2814(class138.field2156, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class138.field2156.getAppletContext().showDocument(new URL(class138.field2156.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass212;I)I",
      garbageValue = "-1607532973"
   )
   static final int method3674(class212 var0) {
      if(null == var0) {
         return 12;
      } else {
         switch(var0.field3143) {
         case 7:
            return 20;
         default:
            return 12;
         }
      }
   }
}
