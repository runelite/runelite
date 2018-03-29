import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2982(0, 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2995(1, 0),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2975(2, 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2976(3, 0),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2977(9, 2),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2989(4, 1),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2979(5, 1),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2980(6, 1),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2981(7, 1),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2986(8, 1),
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2983(12, 2),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2984(13, 2),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2974(14, 2),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2985(15, 2),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2987(16, 2),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2988(17, 2),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2997(18, 2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2990(19, 2),
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2978(20, 2),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2992(21, 2),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2991(10, 2),
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2994(11, 2),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   field2993(22, 3);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1470097667
   )
   @Export("rsOrdinal")
   public final int rsOrdinal;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   WorldMapDecorationType(int var3, int var4) {
      this.rsOrdinal = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1780726447"
   )
   public int rsOrdinal() {
      return this.rsOrdinal;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lla;",
      garbageValue = "-1542721077"
   )
   static SpritePixels method4517() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class332.indexedSpriteWidth;
      var0.maxHeight = class81.indexedSpriteHeight;
      var0.offsetX = GameCanvas.indexedSpriteOffsetXs[0];
      var0.offsetY = class332.indexedSpriteOffsetYs[0];
      var0.width = class25.indexSpriteWidths[0];
      var0.height = class332.indexedSpriteHeights[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = class332.spritePixels[0];
      var0.pixels = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.pixels[var3] = class332.indexedSpritePalette[var2[var3] & 255];
      }

      FileSystem.method4544();
      return var0;
   }
}
