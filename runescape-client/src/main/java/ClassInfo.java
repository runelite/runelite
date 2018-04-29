import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lu")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 658911629
   )
   int field3956;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1475470325
   )
   @Export("count")
   int count;
   @ObfuscatedName("b")
   @Export("type")
   int[] type;
   @ObfuscatedName("z")
   @Export("errorIdentifiers")
   int[] errorIdentifiers;
   @ObfuscatedName("n")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("l")
   int[] field3955;
   @ObfuscatedName("s")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("y")
   @Export("args")
   byte[][][] args;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljr;II)Llh;",
      garbageValue = "-384956499"
   )
   public static IndexedSprite method5782(IndexDataBase var0, int var1) {
      byte[] var3 = var0.takeRecordFlat(var1);
      boolean var2;
      if(var3 == null) {
         var2 = false;
      } else {
         WorldMapType2.decodeSprite(var3);
         var2 = true;
      }

      if(!var2) {
         return null;
      } else {
         IndexedSprite var4 = new IndexedSprite();
         var4.originalWidth = class332.indexedSpriteWidth;
         var4.originalHeight = class332.indexedSpriteHeight;
         var4.offsetX = class332.indexedSpriteOffsetXs[0];
         var4.offsetY = WorldComparator.indexedSpriteOffsetYs[0];
         var4.width = class332.indexSpriteWidths[0];
         var4.height = GrandExchangeEvents.indexedSpriteHeights[0];
         var4.palette = class332.indexedSpritePalette;
         var4.pixels = ChatPlayer.spritePixels[0];
         class332.indexedSpriteOffsetXs = null;
         WorldComparator.indexedSpriteOffsetYs = null;
         class332.indexSpriteWidths = null;
         GrandExchangeEvents.indexedSpriteHeights = null;
         class332.indexedSpritePalette = null;
         ChatPlayer.spritePixels = null;
         return var4;
      }
   }
}
