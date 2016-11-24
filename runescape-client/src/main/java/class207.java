import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public final class class207 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LSpritePixels;",
      garbageValue = "1580214600"
   )
   public static SpritePixels method3894(class182 var0, int var1, int var2) {
      if(!KitDefinition.method3566(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.field3205 = class225.field3211;
         var4.field3203 = class225.field3216;
         var4.field3201 = class225.field3213[0];
         var4.field3202 = class225.field3214[0];
         var4.width = class225.field3215[0];
         var4.height = class225.field3219[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = class225.field3218[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = class225.field3210[var6[var7] & 255];
         }

         class189.method3507();
         return var4;
      }
   }
}
