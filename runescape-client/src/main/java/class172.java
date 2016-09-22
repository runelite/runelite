import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class172 extends Node {
   @ObfuscatedName("d")
   public byte[] field2762;
   @ObfuscatedName("v")
   public class137 field2763;
   @ObfuscatedName("g")
   static ModIcon[] field2765;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -770273435
   )
   int field2767;
   @ObfuscatedName("r")
   public class171 field2768;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "0"
   )
   static final int method3414(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & '\uff00') * var3 + var2 * (var1 & '\uff00') & 16711680) + (var2 * (var1 & 16711935) + var3 * (var0 & 16711935) & -16711936) >> 8;
   }
}
