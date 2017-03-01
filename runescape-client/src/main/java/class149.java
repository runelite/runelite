import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
public class class149 {
   @ObfuscatedName("a")
   public static short[] field2033;
   @ObfuscatedName("s")
   static class228 field2037;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "1429283022"
   )
   public static SpritePixels[] method2849(class182 var0, String var1, String var2) {
      int var3 = var0.method3426(var1);
      int var4 = var0.method3370(var3, var2);
      SpritePixels[] var5;
      if(!class137.method2556(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var7 = new SpritePixels[class225.field3233];

         for(int var8 = 0; var8 < class225.field3233; ++var8) {
            SpritePixels var9 = var7[var8] = new SpritePixels();
            var9.maxWidth = class225.field3234;
            var9.maxHeight = class0.field2;
            var9.offsetX = class225.field3236[var8];
            var9.offsetY = class145.field2013[var8];
            var9.width = class186.field2775[var8];
            var9.height = class225.field3235[var8];
            int var10 = var9.height * var9.width;
            byte[] var11 = Ignore.field211[var8];
            var9.image = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.image[var12] = class225.field3237[var11[var12] & 255];
            }
         }

         WallObject.method1986();
         var5 = var7;
      }

      return var5;
   }

   class149() throws Throwable {
      throw new Error();
   }
}
