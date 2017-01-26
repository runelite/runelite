import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class157 {
   @ObfuscatedName("qg")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("ba")
   static class184 field2121;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "36"
   )
   static final int method3027(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & '\uff00') * var2 + var3 * (var0 & '\uff00') & 16711680) + (var3 * (var0 & 16711935) + var2 * (var1 & 16711935) & -16711936) >> 8;
   }

   class157() throws Throwable {
      throw new Error();
   }
}
