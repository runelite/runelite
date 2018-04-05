import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public final class class62 {
   @ObfuscatedName("o")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("k")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 489713887
   )
   static int field747;
   @ObfuscatedName("d")
   @Export("tileUnderlayIds")
   static byte[][][] tileUnderlayIds;
   @ObfuscatedName("h")
   @Export("tileOverlayIds")
   static byte[][][] tileOverlayIds;
   @ObfuscatedName("m")
   @Export("tileOverlayPath")
   static byte[][][] tileOverlayPath;
   @ObfuscatedName("z")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("r")
   static final int[] field749;
   @ObfuscatedName("j")
   static final int[] field746;
   @ObfuscatedName("b")
   static final int[] field738;
   @ObfuscatedName("g")
   static final int[] field740;
   @ObfuscatedName("f")
   static final int[] field752;
   @ObfuscatedName("p")
   static final int[] field750;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 791014009
   )
   static int field751;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -735739629
   )
   static int field745;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field747 = 99;
      field749 = new int[]{1, 2, 4, 8};
      field746 = new int[]{16, 32, 64, 128};
      field738 = new int[]{1, 0, -1, 0};
      field740 = new int[]{0, -1, 0, 1};
      field752 = new int[]{1, -1, -1, 1};
      field750 = new int[]{-1, -1, 1, 1};
      field751 = (int)(Math.random() * 17.0D) - 8;
      field745 = (int)(Math.random() * 33.0D) - 16;
   }
}
