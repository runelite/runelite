import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class204 {
   @ObfuscatedName("x")
   static final char[] field3072 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("q")
   static final char[] field3073 = new char[]{'[', ']', '#'};

   class204() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IZI)LFrames;",
      garbageValue = "566936386"
   )
   public static Frames method3805(class182 var0, class182 var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method3280(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method3344(var2, var5[var6]);
         if(null == var7) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method3344(var8, 0);
            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }
}
