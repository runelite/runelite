import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public final class class5 {
   @ObfuscatedName("m")
   @Export("tileHeights")
   static int[][][] field77 = new int[4][105][105];
   @ObfuscatedName("w")
   @Export("tileSettings")
   static byte[][][] field78 = new byte[4][104][104];
   @ObfuscatedName("q")
   static final int[] field79 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("o")
   static byte[][][] field80;
   @ObfuscatedName("g")
   static byte[][][] field81;
   @ObfuscatedName("d")
   static final int[] field82 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("t")
   static final int[] field83 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("z")
   static final int[] field84 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("n")
   static final int[] field86 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -692805777
   )
   static int field87 = 99;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1960338303
   )
   static int field88 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1383236715
   )
   static int field89 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("c")
   static final int[] field90 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("da")
   @Export("region")
   static class89 field91;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Lclass115;II)Lclass115;",
      garbageValue = "-761683926"
   )
   public static class115 method77(class115[] var0, int var1) {
      class115[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class115 var4 = var2[var3];
         if(var1 == var4.vmethod3218()) {
            return var4;
         }
      }

      return null;
   }
}
