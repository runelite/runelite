import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
public class class237 {
   @ObfuscatedName("t")
   @Export("varpsMasks")
   static int[] varpsMasks;
   @ObfuscatedName("q")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("i")
   @Export("clientVarps")
   public static int[] clientVarps;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   static SpritePixels field2773;

   static {
      varpsMasks = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         varpsMasks[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      clientVarps = new int[2000];
   }
}
