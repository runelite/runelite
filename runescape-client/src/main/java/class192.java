import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
public class class192 {
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1204327601
   )
   static int field2551;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILec;[Lfb;I)V",
      garbageValue = "-74238219"
   )
   static final void method3867(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
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
               ObjectComposition var21 = class219.getObjectDefinition(var11);
               int var22 = var2 + class111.method2349(var16 & 7, var15 & 7, var7, var21.width, var21.length, var20);
               int var25 = var16 & 7;
               int var26 = var15 & 7;
               int var28 = var21.width;
               int var29 = var21.length;
               int var30;
               if((var20 & 1) == 1) {
                  var30 = var28;
                  var28 = var29;
                  var29 = var30;
               }

               int var27 = var7 & 3;
               int var24;
               if(var27 == 0) {
                  var24 = var26;
               } else if(var27 == 1) {
                  var24 = 7 - var25 - (var28 - 1);
               } else if(var27 == 2) {
                  var24 = 7 - var26 - (var29 - 1);
               } else {
                  var24 = var25;
               }

               var30 = var24 + var3;
               if(var22 > 0 && var30 > 0 && var22 < 103 && var30 < 103) {
                  int var31 = var1;
                  if((class62.tileSettings[1][var22][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  CollisionData var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  Player.addObject(var1, var22, var30, var11, var20 + var7 & 3, var19, var8, var32);
               }
            }
         }
      }
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2115262865"
   )
   static final void method3868(String var0) {
      if(!var0.equals("")) {
         PacketNode var1 = Script.method2025(ClientPacket.field2334, Client.field937.field1454);
         var1.packetBuffer.putByte(FrameMap.getLength(var0));
         var1.packetBuffer.putString(var0);
         Client.field937.method2044(var1);
      }
   }
}
