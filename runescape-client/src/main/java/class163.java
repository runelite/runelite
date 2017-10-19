import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public abstract class class163 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1881125395
   )
   public int field2307;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 470607731
   )
   public int field2306;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1027906555
   )
   public int field2309;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 308370027
   )
   public int field2308;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIILfw;B)Z",
      garbageValue = "66"
   )
   protected abstract boolean vmethod3126(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1002047179"
   )
   static final int method3128(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
