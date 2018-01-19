import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("ej")
   @ObfuscatedGetter(
      longValue = 8778909200186975023L
   )
   static long field1945;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1205436467
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 223131607
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -48624337
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1347512629
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1886351167
   )
   @Export("texture")
   int texture;
   @ObfuscatedName("d")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 450993421
   )
   @Export("rgb")
   int rgb;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "2099683278"
   )
   public static String method2741(int var0, boolean var1) {
      if(var0 < 0) {
         return Integer.toString(var0);
      } else {
         int var3 = var0;
         String var2;
         if(var0 < 0) {
            var2 = Integer.toString(var0, 10);
         } else {
            int var4 = 2;

            for(int var5 = var0 / 10; var5 != 0; ++var4) {
               var5 /= 10;
            }

            char[] var6 = new char[var4];
            var6[0] = '+';

            for(int var7 = var4 - 1; var7 > 0; --var7) {
               int var8 = var3;
               var3 /= 10;
               int var9 = var8 - var3 * 10;
               if(var9 >= 10) {
                  var6[var7] = (char)(var9 + 87);
               } else {
                  var6[var7] = (char)(var9 + 48);
               }
            }

            var2 = new String(var6);
         }

         return var2;
      }
   }
}
