import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class181 extends CacheableNode {
   @ObfuscatedName("i")
   byte field2677;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -728157021
   )
   int field2678;
   @ObfuscatedName("u")
   class184 field2680;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([Lclass158;II)Lclass158;",
      garbageValue = "1059305473"
   )
   public static class158 method3258(class158[] var0, int var1) {
      class158[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class158 var4 = var2[var3];
         if(var1 == var4.vmethod4062()) {
            return var4;
         }
      }

      return null;
   }
}
