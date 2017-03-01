import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class168 {
   @ObfuscatedName("m")
   static ModIcon field2191;
   @ObfuscatedName("x")
   static class182 field2192;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 208697891
   )
   static int field2193;

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "2111032217"
   )
   static final String method3274(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class37.method813(16711680):(var2 < -6?class37.method813(16723968):(var2 < -3?class37.method813(16740352):(var2 < 0?class37.method813(16756736):(var2 > 9?class37.method813('\uff00'):(var2 > 6?class37.method813(4259584):(var2 > 3?class37.method813(8453888):(var2 > 0?class37.method813(12648192):class37.method813(16776960))))))));
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)[LModIcon;",
      garbageValue = "437499331"
   )
   static ModIcon[] method3278() {
      ModIcon[] var0 = new ModIcon[class225.field3233];

      for(int var1 = 0; var1 < class225.field3233; ++var1) {
         ModIcon var2 = var0[var1] = new ModIcon();
         var2.width = class225.field3234;
         var2.originalHeight = class0.field2;
         var2.offsetX = class225.field3236[var1];
         var2.offsetY = class145.field2013[var1];
         var2.originalWidth = class186.field2775[var1];
         var2.height = class225.field3235[var1];
         var2.palette = class225.field3237;
         var2.pixels = Ignore.field211[var1];
      }

      WallObject.method1986();
      return var0;
   }

   class168() throws Throwable {
      throw new Error();
   }
}
