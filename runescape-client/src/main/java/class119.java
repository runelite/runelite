import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
public abstract class class119 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 383195673
   )
   public int field1858;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1020755065
   )
   public int field1859;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1630583719
   )
   public int field1860;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 786161387
   )
   public int field1861;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IZI)Ljava/lang/String;",
      garbageValue = "220787067"
   )
   public static String method2328(int var0, boolean var1) {
      if(var1 && var0 >= 0) {
         int var3 = var0;
         String var2;
         if(var1 && var0 >= 0) {
            int var4 = 2;

            for(int var5 = var0 / 10; var5 != 0; ++var4) {
               var5 /= 10;
            }

            char[] var6 = new char[var4];
            var6[0] = 43;

            for(int var7 = var4 - 1; var7 > 0; --var7) {
               int var8 = var3;
               var3 /= 10;
               int var9 = var8 - 10 * var3;
               if(var9 >= 10) {
                  var6[var7] = (char)(87 + var9);
               } else {
                  var6[var7] = (char)(48 + var9);
               }
            }

            var2 = new String(var6);
         } else {
            var2 = Integer.toString(var0, 10);
         }

         return var2;
      } else {
         return Integer.toString(var0);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-1593579874"
   )
   protected abstract boolean vmethod2329(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "720913087"
   )
   public static boolean method2332(int var0) {
      return (var0 >> 29 & 1) != 0;
   }
}
