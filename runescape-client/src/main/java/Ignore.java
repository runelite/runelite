import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   public static Buffer field833;
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("q")
   @Export("previousName")
   String previousName;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lbc;I)V",
      garbageValue = "-584134567"
   )
   public static void method1126(ScriptEvent var0) {
      class92.method1743(var0, 200000);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2076753706"
   )
   @Export("adjustHSLListness0")
   static final int adjustHSLListness0(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
