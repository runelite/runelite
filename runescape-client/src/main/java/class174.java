import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fd")
public class class174 {
   @ObfuscatedName("l")
   static byte[][][] field2619;
   @ObfuscatedName("p")
   static String[] field2621;
   @ObfuscatedName("d")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;

   @ObfuscatedName("i")
   public static String method3238(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            char var4;
            StringBuilder var8;
            for(var8 = new StringBuilder(var2); 0L != var0; var8.append(var4)) {
               long var5 = var0;
               var0 /= 37L;
               var4 = class205.field3069[(int)(var5 - 37L * var0)];
               if(var4 == 95) {
                  int var7 = var8.length() - 1;
                  var8.setCharAt(var7, Character.toUpperCase(var8.charAt(var7)));
                  var4 = 160;
               }
            }

            var8.reverse();
            var8.setCharAt(0, Character.toUpperCase(var8.charAt(0)));
            return var8.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1799406343"
   )
   static final String method3239(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-2104401000"
   )
   public static void method3240(String var0, Throwable var1) {
      var1.printStackTrace();
   }
}
