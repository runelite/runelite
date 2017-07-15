import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public enum class27 implements RSEnum {
   @ObfuscatedName("a")
   field395(0, (byte)0),
   @ObfuscatedName("j")
   field391(3, (byte)1),
   @ObfuscatedName("n")
   field394(1, (byte)2),
   @ObfuscatedName("r")
   field393(2, (byte)3);

   @ObfuscatedName("oe")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 28494379
   )
   final int field392;
   @ObfuscatedName("e")
   final byte field396;

   class27(int var3, byte var4) {
      this.field392 = var3;
      this.field396 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1952293135"
   )
   public int rsOrdinal() {
      return this.field396;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2108941191"
   )
   static void method215(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      FileRequest var4 = (FileRequest)class238.field3260.get(var2);
      if(var4 != null) {
         class238.field3259.setHead(var4);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)[Lclass27;",
      garbageValue = "-88"
   )
   static class27[] method208() {
      return new class27[]{field395, field393, field394, field391};
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;III)LSpritePixels;",
      garbageValue = "-1859053298"
   )
   public static SpritePixels method217(IndexDataBase var0, int var1, int var2) {
      if(!IndexData.method4200(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class286.field3793;
         var4.maxHeight = class286.field3792;
         var4.offsetX = class286.field3795[0];
         var4.offsetY = class31.offsetsY[0];
         var4.width = class286.field3797[0];
         var4.height = class90.field1405[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = class177.spritePixels[0];
         var4.image = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.image[var7] = class286.field3796[var6[var7] & 255];
         }

         class18.method138();
         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILRegion;[LCollisionData;I)V",
      garbageValue = "577911489"
   )
   static final void method216(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
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
               ObjectComposition var21 = PlayerComposition.getObjectDefinition(var11);
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

               var29 = var23 + var2;
               int var30 = var3 + class169.method3108(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               if(var29 > 0 && var30 > 0 && var29 < 103 && var30 < 103) {
                  int var31 = var1;
                  if((class61.tileSettings[1][var29][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  CollisionData var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  class60.addObject(var1, var29, var30, var11, var20 + var7 & 3, var19, var8, var32);
               }
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-808506328"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
