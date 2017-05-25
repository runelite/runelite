import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public final class class61 {
   @ObfuscatedName("h")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("f")
   static final int[] field742;
   @ObfuscatedName("g")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("i")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("x")
   static int[] field745;
   @ObfuscatedName("l")
   static int[][] field746;
   @ObfuscatedName("iw")
   static Widget field747;
   @ObfuscatedName("v")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("t")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("s")
   static final int[] field750;
   @ObfuscatedName("n")
   static final int[] field751;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1701450723
   )
   static int field752;
   @ObfuscatedName("w")
   static final int[] field753;
   @ObfuscatedName("o")
   static int[][][] field754;
   @ObfuscatedName("e")
   static final int[] field755;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -400329583
   )
   static int field756;
   @ObfuscatedName("y")
   static final int[] field757;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1495410147
   )
   static int field758;
   @ObfuscatedName("ri")
   static IndexFile field759;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field752 = 99;
      field755 = new int[]{1, 2, 4, 8};
      field750 = new int[]{16, 32, 64, 128};
      field751 = new int[]{1, 0, -1, 0};
      field757 = new int[]{0, -1, 0, 1};
      field753 = new int[]{1, -1, -1, 1};
      field742 = new int[]{-1, -1, 1, 1};
      field758 = (int)(Math.random() * 17.0D) - 8;
      field756 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "1841"
   )
   public static boolean method1070(int var0) {
      return var0 == class221.field2806.field2826;
   }
}
