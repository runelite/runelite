import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public final class class5 {
   @ObfuscatedName("d")
   static byte[][][] field81;
   @ObfuscatedName("u")
   @Export("tileSettings")
   static byte[][][] field82 = new byte[4][104][104];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1363082631
   )
   static int field83 = 99;
   @ObfuscatedName("b")
   static byte[][][] field84;
   @ObfuscatedName("k")
   static int[] field85;
   @ObfuscatedName("n")
   static byte[][][] field86;
   @ObfuscatedName("r")
   static int[] field87;
   @ObfuscatedName("o")
   static int[] field90;
   @ObfuscatedName("w")
   static final int[] field91 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("v")
   static final int[] field92 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("y")
   static final int[] field93 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("c")
   static final int[] field94 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("i")
   static final int[] field95 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 620156053
   )
   static int field96 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1815129693
   )
   static int field98 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("f")
   @Export("tileHeights")
   static int[][][] field99 = new int[4][105][105];
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 860503551
   )
   static int field101;
   @ObfuscatedName("a")
   static final int[] field102 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("s")
   static int[] field103;
   @ObfuscatedName("ev")
   static class78[] field104;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method71() {
      if(class172.field2742 != null) {
         class172.field2742.method3013();
         class172.field2742 = null;
      }

      class11.method141();
      class129.field2056.method2108();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.field350[var0].method2432();
      }

      System.gc();
      class1.method6(2);
      client.field315 = -1;
      client.field526 = false;
      class42.method938();
      class11.method156(10);
   }
}
