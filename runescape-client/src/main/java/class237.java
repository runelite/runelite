import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public class class237 {
   @ObfuscatedName("o")
   @Export("varpsMasks")
   static int[] varpsMasks;
   @ObfuscatedName("k")
   @Export("serverVarps")
   public static int[] serverVarps;
   @ObfuscatedName("t")
   @Export("clientVarps")
   public static int[] clientVarps;
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "[Lll;"
   )
   @Export("slArrowSprites")
   static IndexedSprite[] slArrowSprites;

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
