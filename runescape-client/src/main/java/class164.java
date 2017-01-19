import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
public class class164 extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1094745323
   )
   public final int field2164;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -488058525
   )
   public final int field2165;
   @ObfuscatedName("f")
   public final int[] field2166;
   @ObfuscatedName("bs")
   static class184 field2170;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = -2028855819
   )
   static int field2171;
   @ObfuscatedName("h")
   public final int[] field2172;

   class164(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2164 = var1;
      this.field2165 = var2;
      this.field2166 = var3;
      this.field2172 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-433660486"
   )
   public boolean method3030(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2172.length) {
         int var3 = this.field2172[var2];
         if(var1 >= var3 && var1 <= this.field2166[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)[LSpritePixels;",
      garbageValue = "-70"
   )
   static SpritePixels[] method3034() {
      SpritePixels[] var0 = new SpritePixels[class225.field3221];

      for(int var1 = 0; var1 < class225.field3221; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class225.field3218;
         var2.maxHeight = class225.field3219;
         var2.offsetX = class181.field2710[var1];
         var2.offsetY = class225.field3220[var1];
         var2.width = class119.field1865[var1];
         var2.height = class109.field1742[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class44.field888[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class225.field3217[var4[var5] & 255];
         }
      }

      class30.method648();
      return var0;
   }
}
