import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class54 {
   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-31293"
   )
   static boolean method815(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-1073597126"
   )
   public static int method816(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }
}
