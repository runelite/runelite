import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public final class class207 {
   @ObfuscatedName("e")
   public static class182 field3089;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-2067761124"
   )
   static final int method3763(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class84.field1454[var2 * 1024 / var3] >> 1;
      return (var1 * var4 >> 16) + (var0 * (65536 - var4) >> 16);
   }
}
