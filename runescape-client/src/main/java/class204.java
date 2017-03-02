import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class204 {
   @ObfuscatedName("i")
   static final char[] field3082 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("t")
   static final char[] field3084 = new char[]{'[', ']', '#'};

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "2012984038"
   )
   static int method3911(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class140.method2681(class32.field729[--class101.field1648]);
      } else {
         var3 = var2?class32.field719:class185.field2760;
      }

      if(var0 == 1927) {
         if(class32.field717 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2305 == null) {
            return 0;
         } else {
            class18 var4 = new class18();
            var4.field185 = var3;
            var4.field197 = var3.field2305;
            var4.field192 = 1 + class32.field717;
            Client.field484.method2468(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   class204() throws Throwable {
      throw new Error();
   }
}
