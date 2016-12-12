import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class8 {
   @ObfuscatedName("ma")
   @Export("clanMembers")
   static XClanMember[] clanMembers;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "26"
   )
   static final int method96(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = TextureProvider.method1437(var3, var5);
      int var8 = TextureProvider.method1437(var3 + 1, var5);
      int var9 = TextureProvider.method1437(var3, 1 + var5);
      int var10 = TextureProvider.method1437(1 + var3, 1 + var5);
      int var11 = class207.method3763(var7, var8, var4, var2);
      int var12 = class207.method3763(var9, var10, var4, var2);
      return class207.method3763(var11, var12, var6, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1434388251"
   )
   static final int method97(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }
}
