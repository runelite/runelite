import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bf")
public final class class62 {
   @ObfuscatedName("d")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("q")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -78263833
   )
   static int field735;
   @ObfuscatedName("n")
   static final int[] field743;
   @ObfuscatedName("c")
   static final int[] field746;
   @ObfuscatedName("l")
   static final int[] field733;
   @ObfuscatedName("m")
   static final int[] field747;
   @ObfuscatedName("a")
   static final int[] field745;
   @ObfuscatedName("h")
   static final int[] field748;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1266950443
   )
   static int field744;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -614568471
   )
   static int field750;
   @ObfuscatedName("y")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("e")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("v")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("u")
   static int[][][] field742;
   @ObfuscatedName("t")
   static byte[][][] field739;
   @ObfuscatedName("i")
   static int[][] field740;
   @ObfuscatedName("r")
   @Export("blendedHue")
   static int[] blendedHue;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field735 = 99;
      field743 = new int[]{1, 2, 4, 8};
      field746 = new int[]{16, 32, 64, 128};
      field733 = new int[]{1, 0, -1, 0};
      field747 = new int[]{0, -1, 0, 1};
      field745 = new int[]{1, -1, -1, 1};
      field748 = new int[]{-1, -1, 1, 1};
      field744 = (int)(Math.random() * 17.0D) - 8;
      field750 = (int)(Math.random() * 33.0D) - 16;
   }
}
