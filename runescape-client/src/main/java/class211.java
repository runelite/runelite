import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public class class211 {
   @ObfuscatedName("n")
   static final char[] field3136 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("q")
   static final char[] field3138 = new char[]{'[', ']', '#'};

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Lclass220;",
      garbageValue = "2102684924"
   )
   public static class220 method4013(int var0) {
      class220[] var1 = class109.method2068();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class220 var3 = var1[var2];
         if(var3.field3201 == var0) {
            return var3;
         }
      }

      return null;
   }

   class211() throws Throwable {
      throw new Error();
   }
}
