import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("r")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1481402509
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1679345499
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2039712311
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -2021271429
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("v")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("e")
   @Export("top")
   Renderable top;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 396278729
   )
   @Export("height")
   int height;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "1414610843"
   )
   public static int method2394(byte[] var0, int var1) {
      int var3 = -1;

      for(int var4 = 0; var4 < var1; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
