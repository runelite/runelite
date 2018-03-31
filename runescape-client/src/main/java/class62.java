import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public final class class62 {
   @ObfuscatedName("c")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("i")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 724759005
   )
   static int field722;
   @ObfuscatedName("j")
   @Export("tileUnderlayIds")
   static byte[][][] tileUnderlayIds;
   @ObfuscatedName("k")
   @Export("tileOverlayIds")
   static byte[][][] tileOverlayIds;
   @ObfuscatedName("x")
   @Export("tileOverlayPath")
   static byte[][][] tileOverlayPath;
   @ObfuscatedName("p")
   static byte[][][] field725;
   @ObfuscatedName("w")
   static int[][] field719;
   @ObfuscatedName("l")
   static int[][][] field721;
   @ObfuscatedName("t")
   static final int[] field727;
   @ObfuscatedName("v")
   static final int[] field731;
   @ObfuscatedName("n")
   static final int[] field730;
   @ObfuscatedName("u")
   static final int[] field726;
   @ObfuscatedName("q")
   static final int[] field723;
   @ObfuscatedName("g")
   static final int[] field732;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1852317337
   )
   static int field734;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1017419369
   )
   static int field735;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field722 = 99;
      field727 = new int[]{1, 2, 4, 8};
      field731 = new int[]{16, 32, 64, 128};
      field730 = new int[]{1, 0, -1, 0};
      field726 = new int[]{0, -1, 0, 1};
      field723 = new int[]{1, -1, -1, 1};
      field732 = new int[]{-1, -1, 1, 1};
      field734 = (int)(Math.random() * 17.0D) - 8;
      field735 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Llq;",
      garbageValue = "-32"
   )
   public static IndexedSprite method1088() {
      IndexedSprite var0 = new IndexedSprite();
      var0.originalWidth = class332.indexedSpriteWidth;
      var0.originalHeight = class81.indexedSpriteHeight;
      var0.offsetX = GameCanvas.indexedSpriteOffsetXs[0];
      var0.offsetY = class332.indexedSpriteOffsetYs[0];
      var0.width = class25.indexSpriteWidths[0];
      var0.height = class332.indexedSpriteHeights[0];
      var0.palette = class332.indexedSpritePalette;
      var0.pixels = class332.spritePixels[0];
      FileSystem.method4544();
      return var0;
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-631058441"
   )
   static final void method1086() {
      int var0 = class93.playerIndexesCount;
      int[] var1 = class93.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            WorldMapType1.method300(var3, 1);
         }
      }

   }

   @ObfuscatedName("kv")
   @ObfuscatedSignature(
      signature = "(Lib;IIII)V",
      garbageValue = "-2037169622"
   )
   static final void method1068(Widget var0, int var1, int var2, int var3) {
      class236 var4 = var0.method4475(false);
      if(var4 != null) {
         if(Client.field1087 < 3) {
            MouseRecorder.compass.method5886(var1, var2, var4.field2765, var4.field2763, 25, 25, Client.mapAngle, 256, var4.field2766, var4.field2768);
         } else {
            Rasterizer2D.method5759(var1, var2, 0, var4.field2766, var4.field2768);
         }

      }
   }
}
