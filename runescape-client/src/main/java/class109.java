import java.util.HashMap;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class109 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1072224594"
   )
   public static boolean method2471(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   static {
      new HashMap();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[Lclass108;I)V",
      garbageValue = "-1702367644"
   )
   static final void method2472(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class108[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var2 + var9 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var10 + var3 < 103) {
               var8[var1].field1908[var9 + var2][var3 + var10] &= -16777217;
            }
         }
      }

      class119 var28 = new class119(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < 8 + var5 && var12 >= var6 && var12 < 8 + var6) {
                  int var17 = var11 & 7;
                  int var18 = var12 & 7;
                  int var19 = var7 & 3;
                  int var16;
                  if(var19 == 0) {
                     var16 = var17;
                  } else if(var19 == 1) {
                     var16 = var18;
                  } else if(var19 == 2) {
                     var16 = 7 - var17;
                  } else {
                     var16 = 7 - var18;
                  }

                  int var22 = var16 + var2;
                  int var25 = var11 & 7;
                  int var26 = var12 & 7;
                  int var27 = var7 & 3;
                  int var24;
                  if(var27 == 0) {
                     var24 = var26;
                  } else if(var27 == 1) {
                     var24 = 7 - var25;
                  } else if(var27 == 2) {
                     var24 = 7 - var26;
                  } else {
                     var24 = var25;
                  }

                  class95.method2244(var28, var1, var22, var3 + var24, 0, 0, var7);
               } else {
                  class95.method2244(var28, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1422790079"
   )
   public static void method2473() {
      class39.field895.method3796();
      class39.field896.method3796();
   }
}
