import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public final class class61 {
   @ObfuscatedName("c")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("o")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1322371761
   )
   static int field754;
   @ObfuscatedName("l")
   static final int[] field763;
   @ObfuscatedName("q")
   static final int[] field757;
   @ObfuscatedName("f")
   static final int[] field758;
   @ObfuscatedName("j")
   static final int[] field759;
   @ObfuscatedName("n")
   static final int[] field760;
   @ObfuscatedName("z")
   static final int[] field761;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 368215453
   )
   static int field750;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -959853157
   )
   static int field753;
   @ObfuscatedName("m")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("t")
   static int[][][] field755;
   @ObfuscatedName("p")
   static int[][] field756;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field754 = 99;
      field763 = new int[]{1, 2, 4, 8};
      field757 = new int[]{16, 32, 64, 128};
      field758 = new int[]{1, 0, -1, 0};
      field759 = new int[]{0, -1, 0, 1};
      field760 = new int[]{1, -1, -1, 1};
      field761 = new int[]{-1, -1, 1, 1};
      field750 = (int)(Math.random() * 17.0D) - 8;
      field753 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljj;",
      garbageValue = "-1199902157"
   )
   static SpritePixels method1019() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class286.field3780;
      var0.maxHeight = class286.field3781;
      var0.offsetX = class286.field3782[0];
      var0.offsetY = class286.offsetsY[0];
      var0.width = class286.field3779[0];
      var0.height = class286.field3787[0];
      int var1 = var0.width * var0.height;
      byte[] var2 = class286.spritePixels[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class286.field3786[var2[var3] & 255];
      }

      class286.field3782 = null;
      class286.offsetsY = null;
      class286.field3779 = null;
      class286.field3787 = null;
      class286.field3786 = null;
      class286.spritePixels = null;
      return var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-359908698"
   )
   static final int method1020(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var2 * (var1 & 16711935) + var3 * (var0 & 16711935) & -16711936) + ((var0 & '\uff00') * var3 + (var1 & '\uff00') * var2 & 16711680) >> 8;
   }
}
