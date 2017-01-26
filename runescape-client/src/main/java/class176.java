import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public final class class176 {
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = -1720036571
   )
   static int field2653;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILRegion;[LCollisionData;I)V",
      garbageValue = "1257615317"
   )
   static final void method3243(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2979();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2979();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var4 == var17 && var16 >= var5 && var16 < 8 + var5 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = class217.getObjectDefinition(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.sizeX;
               int var28 = var21.sizeY;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var2 + var23;
               int var32 = var16 & 7;
               int var33 = var15 & 7;
               int var35 = var21.sizeX;
               int var36 = var21.sizeY;
               int var37;
               if((var20 & 1) == 1) {
                  var37 = var35;
                  var35 = var36;
                  var36 = var37;
               }

               int var34 = var7 & 3;
               int var31;
               if(var34 == 0) {
                  var31 = var33;
               } else if(var34 == 1) {
                  var31 = 7 - var32 - (var35 - 1);
               } else if(var34 == 2) {
                  var31 = 7 - var33 - (var36 - 1);
               } else {
                  var31 = var32;
               }

               var37 = var3 + var31;
               if(var29 > 0 && var37 > 0 && var29 < 103 && var37 < 103) {
                  int var38 = var1;
                  if((class10.tileSettings[1][var29][var37] & 2) == 2) {
                     var38 = var1 - 1;
                  }

                  CollisionData var39 = null;
                  if(var38 >= 0) {
                     var39 = var9[var38];
                  }

                  class9.method118(var1, var29, var37, var11, var7 + var20 & 3, var19, var8, var39);
               }
            }
         }
      }
   }

   class176() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass184;IIIBZI)V",
      garbageValue = "1729368473"
   )
   static void method3244(class184 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      class181 var8 = (class181)class185.field2743.method2374(var6);
      if(var8 == null) {
         var8 = (class181)class185.field2761.method2374(var6);
         if(var8 == null) {
            var8 = (class181)class185.field2741.method2374(var6);
            if(null != var8) {
               if(var5) {
                  var8.method2440();
                  class185.field2743.method2364(var8, var6);
                  --class185.field2750;
                  ++class185.field2745;
               }

            } else {
               if(!var5) {
                  var8 = (class181)class185.field2762.method2374(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class181();
               var8.field2699 = var0;
               var8.field2696 = var3;
               var8.field2697 = var4;
               if(var5) {
                  class185.field2743.method2364(var8, var6);
                  ++class185.field2745;
               } else {
                  class185.field2748.method2304(var8);
                  class185.field2741.method2364(var8, var6);
                  ++class185.field2750;
               }

            }
         }
      }
   }
}
