import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("WallDecoration")
public final class WallDecoration {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1781638945
   )
   @Export("tileHeight")
   int tileHeight;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1411967127
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -629971645
   )
   @Export("y")
   int y;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -183359389
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -303827911
   )
   @Export("orientation2")
   int orientation2;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1927462659
   )
   @Export("xOffset")
   int xOffset;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1531207607
   )
   @Export("yOffset")
   int yOffset;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("entity1")
   public Entity entity1;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("entity2")
   public Entity entity2;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 3167575053900974839L
   )
   @Export("tag")
   public long tag;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1164153171
   )
   @Export("flags")
   int flags;

   WallDecoration() {
      this.tag = 0L;
      this.flags = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "1120739015"
   )
   public static int method3257(byte[] var0, int var1) {
      int var3 = -1;

      for(int var4 = 0; var4 < var1; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.__gr_q[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-881894911"
   )
   public static int method3256(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}
