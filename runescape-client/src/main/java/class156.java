import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fq")
public class class156 {
   @ObfuscatedName("j")
   static final class156 field2321 = new class156("RC", 1);
   @ObfuscatedName("ai")
   static SpritePixels[] field2322;
   @ObfuscatedName("i")
   public final String field2323;
   @ObfuscatedName("z")
   static final class156 field2324 = new class156("WIP", 2);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 542466727
   )
   public final int field2326;
   @ObfuscatedName("r")
   static final class156 field2328 = new class156("BUILDLIVE", 3);
   @ObfuscatedName("x")
   static final class156 field2329 = new class156("LIVE", 0);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -152639883
   )
   public static int field2330;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class156(String var1, int var2) {
      this.field2323 = var1;
      this.field2326 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;S)V",
      garbageValue = "512"
   )
   static final void method3194(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var10 + var3 < 103) {
               var8[var1].flags[var9 + var2][var3 + var10] &= -16777217;
            }
         }
      }

      Buffer var13 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < 8 + var5 && var12 >= var6 && var12 < 8 + var6) {
                  class16.method191(var13, var1, var2 + class114.method2484(var11 & 7, var12 & 7, var7), var3 + class38.method747(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  class16.method191(var13, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }
}
