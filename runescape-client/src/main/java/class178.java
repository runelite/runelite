import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public abstract class class178 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   static Track1 field2258;
   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;
   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   @Export("font_p12full")
   static Font font_p12full;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -321286983
   )
   public int field2254;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -566578481
   )
   public int field2255;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 735939299
   )
   public int field2257;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2122294051
   )
   public int field2256;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILfa;I)Z",
      garbageValue = "-2078182693"
   )
   protected abstract boolean vmethod3427(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "74"
   )
   static int method3429(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }
}
