import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("varbit_ref")
   static IndexDataBase varbit_ref;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("varbits")
   static NodeCache varbits;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 426139985
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1659131149
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1975939557
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;

   static {
      varbits = new NodeCache(64);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;B)V",
      garbageValue = "25"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "561727843"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1481069516"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      WorldComparator.indexedSpriteCount = var1.readUnsignedShort();
      GameCanvas.indexedSpriteOffsetXs = new int[WorldComparator.indexedSpriteCount];
      class332.indexedSpriteOffsetYs = new int[WorldComparator.indexedSpriteCount];
      class25.indexSpriteWidths = new int[WorldComparator.indexedSpriteCount];
      class332.indexedSpriteHeights = new int[WorldComparator.indexedSpriteCount];
      class332.spritePixels = new byte[WorldComparator.indexedSpriteCount][];
      var1.offset = var0.length - 7 - WorldComparator.indexedSpriteCount * 8;
      class332.indexedSpriteWidth = var1.readUnsignedShort();
      class81.indexedSpriteHeight = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < WorldComparator.indexedSpriteCount; ++var3) {
         GameCanvas.indexedSpriteOffsetXs[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < WorldComparator.indexedSpriteCount; ++var3) {
         class332.indexedSpriteOffsetYs[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < WorldComparator.indexedSpriteCount; ++var3) {
         class25.indexSpriteWidths[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < WorldComparator.indexedSpriteCount; ++var3) {
         class332.indexedSpriteHeights[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - WorldComparator.indexedSpriteCount * 8 - (var2 - 1) * 3;
      class332.indexedSpritePalette = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class332.indexedSpritePalette[var3] = var1.read24BitInt();
         if(class332.indexedSpritePalette[var3] == 0) {
            class332.indexedSpritePalette[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < WorldComparator.indexedSpriteCount; ++var3) {
         int var4 = class25.indexSpriteWidths[var3];
         int var5 = class332.indexedSpriteHeights[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class332.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }
}
