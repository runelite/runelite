import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public final class class61 {
   @ObfuscatedName("d")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("k")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -214880653
   )
   static int field773;
   @ObfuscatedName("c")
   static final int[] field783;
   @ObfuscatedName("h")
   static final int[] field771;
   @ObfuscatedName("a")
   static final int[] field782;
   @ObfuscatedName("z")
   static final int[] field770;
   @ObfuscatedName("l")
   static final int[] field774;
   @ObfuscatedName("w")
   static final int[] field775;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 722215465
   )
   static int field776;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1048376959
   )
   static int field777;
   @ObfuscatedName("p")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("q")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("r")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("i")
   static int[] field769;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field773 = 99;
      field783 = new int[]{1, 2, 4, 8};
      field771 = new int[]{16, 32, 64, 128};
      field782 = new int[]{1, 0, -1, 0};
      field770 = new int[]{0, -1, 0, 1};
      field774 = new int[]{1, -1, -1, 1};
      field775 = new int[]{-1, -1, 1, 1};
      field776 = (int)(Math.random() * 17.0D) - 8;
      field777 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1542261100"
   )
   public static boolean method1122(int var0) {
      return (var0 >> 21 & 1) != 0;
   }
}
