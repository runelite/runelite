import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kh")
public class class292 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "2098005395"
   )
   public static final void method5315(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      PendingSpawn.method1624(var7, var9, var8, var10, -49088);
   }
}
