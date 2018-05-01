import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
public class class237 {
   @ObfuscatedName("g")
   @Export("varpsMasks")
   public static int[] varpsMasks;
   @ObfuscatedName("e")
   @Export("serverVarps")
   public static int[] serverVarps;
   @ObfuscatedName("b")
   @Export("clientVarps")
   public static int[] clientVarps;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   static class110 field2788;

   static {
      varpsMasks = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         varpsMasks[var1] = var0 - 1;
         var0 += var0;
      }

      serverVarps = new int[2000];
      clientVarps = new int[2000];
   }
}
