import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class22 extends class204 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1712057131
   )
   int field588;
   @ObfuscatedName("j")
   int[] field590;
   @ObfuscatedName("d")
   String[] field591;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1184751479
   )
   int field592;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -513155219
   )
   int field593;
   @ObfuscatedName("b")
   static class193 field594 = new class193(128);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1757566861
   )
   int field595;
   @ObfuscatedName("g")
   int[] field597;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-31737932"
   )
   static boolean method567(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class138.field2112.startsWith("win")) {
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
            Object var3 = class132.method2880(class138.field2122, var2, new Object[]{(new URL(class138.field2122.getCodeBase(), var0)).toString()});
            return null != var3;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class138.field2122.getAppletContext().showDocument(new URL(class138.field2122.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class132.method2879(class138.field2122, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class138.field2122.getAppletContext().showDocument(new URL(class138.field2122.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1194260095"
   )
   static void method569() {
      if(client.field442) {
         class173 var0 = class165.method3247(class3.field56, client.field443);
         if(var0 != null && var0.field2840 != null) {
            class0 var1 = new class0();
            var1.field10 = var0;
            var1.field12 = var0.field2840;
            class106.method2384(var1);
         }

         client.field442 = false;
         class4.method37(var0);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "2026579698"
   )
   @Export("addChatMessage")
   static void method571(int var0, String var1, String var2, String var3) {
      class27 var4 = (class27)class11.field166.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new class27();
         class11.field166.put(Integer.valueOf(var0), var4);
      }

      class35 var5 = var4.method639(var0, var1, var2, var3);
      class11.field169.method3809(var5, (long)var5.field769);
      class11.field164.method3858(var5);
      client.field435 = client.field359;
   }
}
