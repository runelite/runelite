import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class88 {
   @ObfuscatedName("ea")
   static SpritePixels field1526;
   @ObfuscatedName("nw")
   static class57 field1527;
   @ObfuscatedName("cl")
   public static char field1529;
   @ObfuscatedName("m")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;I)V",
      garbageValue = "1668757845"
   )
   static final void method1828(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var2 + var9 > 0 && var2 + var9 < 103 && var10 + var3 > 0 && var10 + var3 < 103) {
               var8[var1].flags[var2 + var9][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var13 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < 8 + var6) {
                  GameObject.method1878(var13, var1, var2 + Friend.method174(var11 & 7, var12 & 7, var7), var3 + class38.method724(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  GameObject.method1878(var13, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1898736128"
   )
   public static String method1829(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = 42;
      }

      String var1 = new String(var3);
      return var1;
   }
}
