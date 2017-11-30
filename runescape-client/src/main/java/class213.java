import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
public class class213 {
   @ObfuscatedName("a")
   byte[] field2614;
   @ObfuscatedName("w")
   byte[] field2610;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 6143367
   )
   int field2609;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -156392627
   )
   int field2612;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -494717281
   )
   int field2613;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1028034391
   )
   int field2615;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -793445357
   )
   int field2619;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1592980809
   )
   int field2616;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 236030711
   )
   int field2617;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "406644911"
   )
   public static void method3833(String[] var0, short[] var1) {
      KeyFocusListener.method751(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILeh;[Lfp;I)V",
      garbageValue = "1630541534"
   )
   static final void method3832(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.getUSmart();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.getUSmart();
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
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = CacheFile.getObjectDefinition(var11);
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
               int var30 = var3 + FrameMap.method2687(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               if(var29 > 0 && var30 > 0 && var29 < 103 && var30 < 103) {
                  int var31 = var1;
                  if((class61.tileSettings[1][var29][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  CollisionData var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  FriendLoginUpdate.addObject(var1, var29, var30, var11, var20 + var7 & 3, var19, var8, var32);
               }
            }
         }
      }
   }
}
