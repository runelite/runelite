import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class223 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LModel;IIIII)V",
      garbageValue = "-2138684619"
   )
   public static final void method4145(Model var0, int var1, int var2, int var3, int var4) {
      class7.field232.method3634(new class10(var0, var1, var2, var3, var4));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-41"
   )
   static final int method4146(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }
}
