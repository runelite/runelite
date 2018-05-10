import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class142 extends class283 {
   @ObfuscatedName("ky")
   @ObfuscatedGetter(
      intValue = 946956583
   )
   static int field1911;
   @ObfuscatedName("w")
   final boolean field1909;

   public class142(boolean var1) {
      this.field1909 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkd;Lkd;I)I",
      garbageValue = "1971585662"
   )
   int method3181(ChatPlayer var1, ChatPlayer var2) {
      if(var1.world != 0) {
         if(var2.world == 0) {
            return this.field1909?-1:1;
         }
      } else if(var2.world != 0) {
         return this.field1909?1:-1;
      }

      return this.method5320(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3181((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)[Llh;",
      garbageValue = "18"
   )
   static IndexedSprite[] method3182() {
      IndexedSprite[] var0 = new IndexedSprite[class319.indexedSpriteCount];

      for(int var1 = 0; var1 < class319.indexedSpriteCount; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.originalWidth = class319.indexedSpriteWidth;
         var2.originalHeight = class275.indexedSpriteHeight;
         var2.offsetX = class319.indexedSpriteOffsetXs[var1];
         var2.offsetY = class319.indexedSpriteOffsetYs[var1];
         var2.width = class192.indexSpriteWidths[var1];
         var2.height = class319.indexedSpriteHeights[var1];
         var2.palette = class319.indexedSpritePalette;
         var2.pixels = class294.spritePixels[var1];
      }

      class319.indexedSpriteOffsetXs = null;
      class319.indexedSpriteOffsetYs = null;
      class192.indexSpriteWidths = null;
      class319.indexedSpriteHeights = null;
      class319.indexedSpritePalette = null;
      class294.spritePixels = null;
      return var0;
   }
}
