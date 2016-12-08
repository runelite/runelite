import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class class101 extends RuntimeException {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 728067549
   )
   static int field1646;
   @ObfuscatedName("g")
   String field1647;
   @ObfuscatedName("h")
   Throwable field1648;
   @ObfuscatedName("m")
   public static String field1649;
   @ObfuscatedName("o")
   static Applet field1653;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Lclass112;",
      garbageValue = "46"
   )
   public static class112 method1908() {
      try {
         return new class106();
      } catch (Throwable var1) {
         return null;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "96"
   )
   public static void method1914() {
      try {
         if(class138.field1929 == 1) {
            int var0 = class138.field1926.method2448();
            if(var0 > 0 && class138.field1926.method2454()) {
               var0 -= WidgetNode.field186;
               if(var0 < 0) {
                  var0 = 0;
               }

               class138.field1926.method2447(var0);
               return;
            }

            class138.field1926.method2488();
            class138.field1926.method2451();
            if(class138.field1930 != null) {
               class138.field1929 = 2;
            } else {
               class138.field1929 = 0;
            }

            class60.field1083 = null;
            ChatMessages.field932 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class138.field1926.method2488();
         class138.field1929 = 0;
         class60.field1083 = null;
         ChatMessages.field932 = null;
         class138.field1930 = null;
      }

   }
}
