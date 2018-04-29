import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("e")
   @Export("directBufferUnavailable")
   static boolean directBufferUnavailable;
   @ObfuscatedName("b")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;

   static {
      directBufferUnavailable = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1634380486"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1499025869"
   )
   @Export("put")
   abstract void put(byte[] var1);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljr;IIB)Llv;",
      garbageValue = "-11"
   )
   public static SpritePixels method3836(IndexDataBase var0, int var1, int var2) {
      if(!class326.method5792(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class332.indexedSpriteWidth;
         var4.maxHeight = class332.indexedSpriteHeight;
         var4.offsetX = class332.indexedSpriteOffsetXs[0];
         var4.offsetY = WorldComparator.indexedSpriteOffsetYs[0];
         var4.width = class332.indexSpriteWidths[0];
         var4.height = GrandExchangeEvents.indexedSpriteHeights[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = ChatPlayer.spritePixels[0];
         var4.pixels = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.pixels[var7] = class332.indexedSpritePalette[var6[var7] & 255];
         }

         class332.indexedSpriteOffsetXs = null;
         WorldComparator.indexedSpriteOffsetYs = null;
         class332.indexSpriteWidths = null;
         GrandExchangeEvents.indexedSpriteHeights = null;
         class332.indexedSpritePalette = null;
         ChatPlayer.spritePixels = null;
         return var4;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BB)Lkh;",
      garbageValue = "0"
   )
   public static Font method3837(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         Font var1 = new Font(var0, class332.indexedSpriteOffsetXs, WorldComparator.indexedSpriteOffsetYs, class332.indexSpriteWidths, GrandExchangeEvents.indexedSpriteHeights, class332.indexedSpritePalette, ChatPlayer.spritePixels);
         class332.indexedSpriteOffsetXs = null;
         WorldComparator.indexedSpriteOffsetYs = null;
         class332.indexSpriteWidths = null;
         GrandExchangeEvents.indexedSpriteHeights = null;
         class332.indexedSpritePalette = null;
         ChatPlayer.spritePixels = null;
         return var1;
      }
   }
}
