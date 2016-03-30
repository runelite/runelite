import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class187 extends class208 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -219976661
   )
   int field3015;
   @ObfuscatedName("t")
   class181 field3016;
   @ObfuscatedName("p")
   class62 field3017;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -392823739
   )
   int field3018;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -387724003
   )
   int field3019;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -857390713
   )
   int field3020;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1063129443
   )
   int field3021;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1673823423
   )
   int field3022;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2058884329
   )
   int field3024;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1640273935
   )
   int field3025;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1038257581
   )
   int field3026;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1417310259
   )
   int field3027;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -742564383
   )
   int field3028;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -402467981
   )
   int field3030;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -835384363
   )
   int field3031;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1604455559
   )
   int field3032;
   @ObfuscatedName("o")
   class64 field3033;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1595635501
   )
   int field3034;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 309096451
   )
   int field3036;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -218327467
   )
   int field3037;
   @ObfuscatedName("w")
   class185 field3038;

   @ObfuscatedName("w")
   void method3756() {
      this.field3016 = null;
      this.field3017 = null;
      this.field3038 = null;
      this.field3033 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILclass86;[Lclass108;S)V",
      garbageValue = "-8673"
   )
   static final void method3760(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class86 var8, class108[] var9) {
      class119 var10 = new class119(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2571();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2571();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.method2506();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < 8 + var5 && var15 >= var6 && var15 < var6 + 8) {
               class40 var21 = class22.method592(var11);
               int var22 = var2 + class143.method3010(var16 & 7, var15 & 7, var7, var21.field979, var21.field942, var20);
               int var25 = var16 & 7;
               int var26 = var15 & 7;
               int var28 = var21.field979;
               int var29 = var21.field942;
               int var30;
               if(1 == (var20 & 1)) {
                  var30 = var28;
                  var28 = var29;
                  var29 = var30;
               }

               int var27 = var7 & 3;
               int var24;
               if(0 == var27) {
                  var24 = var26;
               } else if(var27 == 1) {
                  var24 = 7 - var25 - (var28 - 1);
               } else if(2 == var27) {
                  var24 = 7 - var26 - (var29 - 1);
               } else {
                  var24 = var25;
               }

               var30 = var24 + var3;
               if(var22 > 0 && var30 > 0 && var22 < 103 && var30 < 103) {
                  int var31 = var1;
                  if(2 == (class5.field109[1][var22][var30] & 2)) {
                     var31 = var1 - 1;
                  }

                  class108 var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  class122.method2778(var1, var22, var30, var11, var7 + var20 & 3, var19, var8, var32);
               }
            }
         }
      }
   }
}
