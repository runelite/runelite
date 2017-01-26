import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class149 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -62655249
   )
   public static int field2039;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -1855521335
   )
   @Export("cameraY")
   static int cameraY;

   @ObfuscatedName("x")
   public static String method2784(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(var0 % 37L == 0L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class205.field3077[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "956574052"
   )
   public static void method2785(boolean var0) {
      if(ItemComposition.isMembersWorld != var0) {
         DecorativeObject.method1914();
         ItemComposition.isMembersWorld = var0;
      }

   }

   class149() throws Throwable {
      throw new Error();
   }
}
