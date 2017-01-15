import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
public class class204 {
   @ObfuscatedName("i")
   static final char[] field3064 = new char[]{' ', ' ', '_', '-', 'à', 'á', 'â', 'ä', 'ã', 'À', 'Á', 'Â', 'Ä', 'Ã', 'è', 'é', 'ê', 'ë', 'È', 'É', 'Ê', 'Ë', 'í', 'î', 'ï', 'Í', 'Î', 'Ï', 'ò', 'ó', 'ô', 'ö', 'õ', 'Ò', 'Ó', 'Ô', 'Ö', 'Õ', 'ù', 'ú', 'û', 'ü', 'Ù', 'Ú', 'Û', 'Ü', 'ç', 'Ç', 'ÿ', 'Ÿ', 'ñ', 'Ñ', 'ß'};
   @ObfuscatedName("a")
   static final char[] field3065 = new char[]{'[', ']', '#'};

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;I)V",
      garbageValue = "-594528014"
   )
   static final void method3813(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var9;
      for(int var10 = 0; var10 < 8; ++var10) {
         for(var9 = 0; var9 < 8; ++var9) {
            if(var2 + var10 > 0 && var2 + var10 < 103 && var3 + var9 > 0 && var9 + var3 < 103) {
               var8[var1].flags[var2 + var10][var3 + var9] &= -16777217;
            }
         }
      }

      Buffer var18 = new Buffer(var0);

      for(var9 = 0; var9 < 4; ++var9) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var9 == var4 && var11 >= var5 && var11 < 8 + var5 && var12 >= var6 && var12 < var6 + 8) {
                  int var13 = var2 + class186.method3413(var11 & 7, var12 & 7, var7);
                  int var14 = var11 & 7;
                  int var15 = var12 & 7;
                  int var16 = var7 & 3;
                  int var17;
                  if(var16 == 0) {
                     var17 = var15;
                  } else if(var16 == 1) {
                     var17 = 7 - var14;
                  } else if(var16 == 2) {
                     var17 = 7 - var15;
                  } else {
                     var17 = var14;
                  }

                  FrameMap.method1665(var18, var1, var13, var17 + var3, 0, 0, var7);
               } else {
                  FrameMap.method1665(var18, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }
}
