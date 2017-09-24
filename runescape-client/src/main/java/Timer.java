import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static IndexedSprite[] field2267;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "19136800"
   )
   public abstract int vmethod3051(int var1, int var2);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   public abstract void vmethod3050();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "-327980123"
   )
   static int method3058(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.crc32Table[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILhp;I)I",
      garbageValue = "-645124002"
   )
   public static int method3055(int var0, class220 var1) {
      return (var0 + '鱀' << 8) + var1.field2806;
   }
}
