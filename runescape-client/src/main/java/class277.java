import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
public final class class277 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-522742575"
   )
   static final int method4896(int var0, int var1) {
      int var2 = class25.method168(var0 - 1, var1 - 1) + class25.method168(var0 + 1, var1 - 1) + class25.method168(var0 - 1, var1 + 1) + class25.method168(var0 + 1, var1 + 1);
      int var3 = class25.method168(var0 - 1, var1) + class25.method168(var0 + 1, var1) + class25.method168(var0, var1 - 1) + class25.method168(var0, var1 + 1);
      int var4 = class25.method168(var0, var1);
      return var4 / 4 + var3 / 8 + var2 / 16;
   }
}
