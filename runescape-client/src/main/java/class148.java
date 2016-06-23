import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class148 extends RuntimeException {
   @ObfuscatedName("l")
   Throwable field2220;
   @ObfuscatedName("u")
   public static String field2221;
   @ObfuscatedName("f")
   static Applet field2222;
   @ObfuscatedName("b")
   String field2223;
   @ObfuscatedName("ah")
   static boolean field2224;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1786909325
   )
   static int field2228;

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "6"
   )
   static final void method3156(int var0, int var1) {
      int var2 = class32.field758.method4043("Choose Option");

      int var3;
      for(var3 = 0; var3 < client.field429; ++var3) {
         class224 var7 = class32.field758;
         String var5;
         if(client.field435[var3].length() > 0) {
            var5 = client.field459[var3] + " " + client.field435[var3];
         } else {
            var5 = client.field459[var3];
         }

         int var6 = var7.method4043(var5);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = 22 + client.field429 * 15;
      int var4 = var0 - var2 / 2;
      if(var2 + var4 > class30.field708) {
         var4 = class30.field708 - var2;
      }

      if(var4 < 0) {
         var4 = 0;
      }

      int var8 = var1;
      if(var1 + var3 > class153.field2274) {
         var8 = class153.field2274 - var3;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      client.field310 = true;
      class37.field881 = var4;
      class19.field284 = var8;
      class39.field931 = var2;
      class33.field774 = client.field429 * 15 + 22;
   }
}
