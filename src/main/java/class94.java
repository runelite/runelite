import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cs")
public final class class94 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1311016345
   )
   int field1579;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1059310921
   )
   int field1580;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1552929369
   )
   int field1581;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -82127753
   )
   int field1582;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 509417485
   )
   int field1583;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -256125103
   )
   int field1584;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2061448231
   )
   int field1585;
   @ObfuscatedName("r")
   public class85 field1586;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1659822789
   )
   public int field1587 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1780364447
   )
   int field1588 = 0;
   @ObfuscatedName("a")
   public class85 field1589;

   @ObfuscatedName("e")
   static String method2184(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("s")
   static boolean method2185(String var0, int var1, String var2) {
      if(0 == var1) {
         try {
            if(!class138.field2122.startsWith("win")) {
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
            Object var3 = class132.method2837(class138.field2123, var2, new Object[]{(new URL(class138.field2123.getCodeBase(), var0)).toString()});
            return null != var3;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class138.field2123.getAppletContext().showDocument(new URL(class138.field2123.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(3 == var1) {
         try {
            class132.method2836(class138.field2123, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class138.field2123.getAppletContext().showDocument(new URL(class138.field2123.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
