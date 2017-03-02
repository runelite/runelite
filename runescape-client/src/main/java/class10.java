import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public final class class10 {
   @ObfuscatedName("l")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];
   @ObfuscatedName("u")
   static final int[] field88 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("t")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("c")
   static final int[] field90 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("h")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("n")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("p")
   static int[] field95;
   @ObfuscatedName("q")
   static final int[] field96 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("e")
   static final int[] field97 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("b")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("v")
   static final int[] field99 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("j")
   static final int[] field100 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1625131049
   )
   static int field101 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1195715757
   )
   static int field102 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("oo")
   @ObfuscatedGetter(
      intValue = -1268682177
   )
   static int field104;
   @ObfuscatedName("k")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -976943271
   )
   static int field109 = 99;

   class10() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-110"
   )
   public static int method163(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
