import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ih")
public class class237 {
   @ObfuscatedName("c")
   @Export("varpsMasks")
   static int[] varpsMasks;
   @ObfuscatedName("i")
   @Export("serverVarps")
   public static int[] serverVarps;
   @ObfuscatedName("o")
   @Export("clientVarps")
   public static int[] clientVarps;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = 1180254661
   )
   @Export("plane")
   static int plane;

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

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "121"
   )
   static boolean method4379() {
      return (Client.playerNameMask & 8) != 0;
   }

   @ObfuscatedName("kz")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "6"
   )
   public static boolean method4377() {
      return Client.rights >= 2;
   }
}
