import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class18 {
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 896208055
   )
   protected static int field276;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1558660621
   )
   int field277;
   @ObfuscatedName("g")
   DataInputStream field278;
   @ObfuscatedName("e")
   class149 field279;
   @ObfuscatedName("dj")
   @ObfuscatedGetter(
      intValue = 1599784193
   )
   static int field280;
   @ObfuscatedName("u")
   byte[] field281;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 412620985
   )
   int field282;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -3517925721758172065L
   )
   long field283;
   @ObfuscatedName("i")
   byte[] field284 = new byte[4];
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = -443425099
   )
   static int field285;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1167172353
   )
   int field286;

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass178;B)V",
      garbageValue = "-34"
   )
   static final void method197(int var0, int var1, int var2, int var3, SpritePixels var4, class178 var5) {
      if(null != var4) {
         int var6 = Client.mapScale + Client.mapAngle & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class94.field1623[var6];
            int var9 = class94.field1642[var6];
            var8 = var8 * 256 / (256 + Client.mapScaleDelta);
            var9 = 256 * var9 / (256 + Client.mapScaleDelta);
            int var10 = var9 * var2 + var8 * var3 >> 16;
            int var11 = var3 * var9 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method1760(var5.field2948 / 2 + var10 - var4.field1453 / 2, var5.field2947 / 2 - var11 - var4.field1459 / 2, var0, var1, var5.field2948, var5.field2947, var5.field2951, var5.field2946);
            } else {
               var4.method1810(var5.field2948 / 2 + var0 + var10 - var4.field1453 / 2, var5.field2947 / 2 + var1 - var11 - var4.field1459 / 2);
            }

         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "2059323703"
   )
   byte[] method198() throws IOException {
      if(class34.method738() > this.field283) {
         throw new IOException();
      } else {
         if(this.field286 == 0) {
            if(this.field279.field2265 == 2) {
               throw new IOException();
            }

            if(this.field279.field2265 == 1) {
               this.field278 = (DataInputStream)this.field279.field2270;
               this.field286 = 1;
            }
         }

         int var1;
         if(this.field286 == 1) {
            var1 = this.field278.available();
            if(var1 > 0) {
               if(var1 + this.field277 > 4) {
                  var1 = 4 - this.field277;
               }

               this.field277 += this.field278.read(this.field284, this.field277, var1);
               if(this.field277 == 4) {
                  int var2 = (new Buffer(this.field284)).method2549();
                  this.field281 = new byte[var2];
                  this.field286 = 2;
               }
            }
         }

         if(this.field286 == 2) {
            var1 = this.field278.available();
            if(var1 > 0) {
               if(this.field282 + var1 > this.field281.length) {
                  var1 = this.field281.length - this.field282;
               }

               this.field282 += this.field278.read(this.field281, this.field282, var1);
               if(this.field281.length == this.field282) {
                  return this.field281;
               }
            }
         }

         return null;
      }
   }

   class18(class139 var1, URL var2) {
      this.field279 = var1.method2922(var2);
      this.field286 = 0;
      this.field283 = class34.method738() + 30000L;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-656647176"
   )
   static void method200(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method3812((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method3813(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[1 + var1];

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

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-431377158"
   )
   static final void method201(int var0, int var1) {
      if(class125.field2065 != var0 || field280 != var1) {
         class125.field2065 = var0;
         field280 = var1;
         class117.setGameState(25);
         class165.method3226("Loading - please wait.", true);
         int var2 = class193.baseX;
         int var3 = DecorativeObject.baseY;
         class193.baseX = (var0 - 6) * 8;
         DecorativeObject.baseY = (var1 - 6) * 8;
         int var4 = class193.baseX - var2;
         int var5 = DecorativeObject.baseY - var3;
         var2 = class193.baseX;
         var3 = DecorativeObject.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(null != var7) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= var4 * 128;
               var7.y -= 128 * var5;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(null != var20) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= var4 * 128;
               var20.y -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var17 = var19; var18 != var17; var17 += var21) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var4 + var17;
               int var15 = var13 + var5;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var17][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var17][var13] = null;
                  }
               }
            }
         }

         for(class16 var12 = (class16)Client.field571.method3845(); null != var12; var12 = (class16)Client.field571.method3847()) {
            var12.field243 -= var4;
            var12.field260 -= var5;
            if(var12.field243 < 0 || var12.field260 < 0 || var12.field243 >= 104 || var12.field260 >= 104) {
               var12.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field542 = 0;
         Client.field548 = false;
         Client.field472 = -1;
         Client.field436.method3863();
         Client.projectiles.method3863();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2419();
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Lclass48;",
      garbageValue = "28"
   )
   public static class48 method203(int var0) {
      class48 var1 = (class48)class48.field1067.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class48.field1071.method3292(4, var0);
         var1 = new class48();
         if(null != var2) {
            var1.method984(new Buffer(var2), var0);
         }

         var1.method983();
         class48.field1067.put(var1, (long)var0);
         return var1;
      }
   }
}
