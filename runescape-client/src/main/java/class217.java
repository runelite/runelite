import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public final class class217 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1560969951
   )
   public static int field3186;

   class217() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "46"
   )
   static final int method3987(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class30.method651(var3, var5);
      int var8 = class30.method651(var3 + 1, var5);
      int var9 = class30.method651(var3, var5 + 1);
      int var10 = class30.method651(var3 + 1, 1 + var5);
      int var11 = class30.method649(var7, var8, var4, var2);
      int var12 = class30.method649(var9, var10, var4, var2);
      return class30.method649(var11, var12, var6, var2);
   }
}
