import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ha")
public class class225 {
   @ObfuscatedName("w")
   @Export("varpsMasks")
   static int[] varpsMasks;
   @ObfuscatedName("m")
   @Export("serverVarps")
   public static int[] serverVarps;
   @ObfuscatedName("q")
   @Export("clientVarps")
   public static int[] clientVarps;

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
