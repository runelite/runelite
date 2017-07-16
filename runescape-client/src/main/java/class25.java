import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class25 {
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -933652131
   )
   static int field371;
   @ObfuscatedName("fa")
   static byte[][] field365;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1472491325
   )
   int field372;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   Coordinates field366;

   @ObfuscatedSignature(
      signature = "(ILhd;)V"
   )
   class25(int var1, Coordinates var2) {
      this.field372 = var1;
      this.field366 = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILfs;Lfv;I)Z",
      garbageValue = "238164154"
   )
   public static final boolean method173(int var0, int var1, class163 var2, CollisionData var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class162.field2304[var6][var7] = 99;
      class162.field2299[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class162.field2301[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class162.field2303[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class162.field2301[var11];
         var5 = class162.field2303[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.x;
         int var14 = var5 - var3.y;
         if(var2.vmethod3052(1, var4, var5, var3)) {
            class162.field2302 = var4;
            FaceNormal.field2134 = var5;
            return true;
         }

         int var15 = class162.field2299[var16][var17] + 1;
         if(var16 > 0 && class162.field2304[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136776) == 0) {
            class162.field2301[var18] = var4 - 1;
            class162.field2303[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2304[var16 - 1][var17] = 2;
            class162.field2299[var16 - 1][var17] = var15;
         }

         if(var16 < 127 && class162.field2304[var16 + 1][var17] == 0 && (var12[var13 + 1][var14] & 19136896) == 0) {
            class162.field2301[var18] = var4 + 1;
            class162.field2303[var18] = var5;
            var18 = var18 + 1 & 4095;
            class162.field2304[var16 + 1][var17] = 8;
            class162.field2299[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class162.field2304[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class162.field2301[var18] = var4;
            class162.field2303[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2304[var16][var17 - 1] = 1;
            class162.field2299[var16][var17 - 1] = var15;
         }

         if(var17 < 127 && class162.field2304[var16][var17 + 1] == 0 && (var12[var13][1 + var14] & 19136800) == 0) {
            class162.field2301[var18] = var4;
            class162.field2303[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2304[var16][var17 + 1] = 4;
            class162.field2299[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class162.field2304[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class162.field2301[var18] = var4 - 1;
            class162.field2303[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2304[var16 - 1][var17 - 1] = 3;
            class162.field2299[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 127 && var17 > 0 && class162.field2304[var16 + 1][var17 - 1] == 0 && (var12[1 + var13][var14 - 1] & 19136899) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 - 1] & 19136770) == 0) {
            class162.field2301[var18] = var4 + 1;
            class162.field2303[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class162.field2304[var16 + 1][var17 - 1] = 9;
            class162.field2299[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 127 && class162.field2304[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0 && (var12[var13 - 1][var14] & 19136776) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class162.field2301[var18] = var4 - 1;
            class162.field2303[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2304[var16 - 1][var17 + 1] = 6;
            class162.field2299[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 127 && var17 < 127 && class162.field2304[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 1] & 19136992) == 0 && (var12[var13 + 1][var14] & 19136896) == 0 && (var12[var13][var14 + 1] & 19136800) == 0) {
            class162.field2301[var18] = var4 + 1;
            class162.field2303[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class162.field2304[var16 + 1][var17 + 1] = 12;
            class162.field2299[var16 + 1][var17 + 1] = var15;
         }
      }

      class162.field2302 = var4;
      FaceNormal.field2134 = var5;
      return false;
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-1207735702"
   )
   static final void method175(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = (Client.field1159 - Client.field1007) * var5 / 100 + Client.field1007;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field1164) {
         var15 = Client.field1164;
         var6 = var2 * var15 * 334 / (var3 * 512);
         if(var6 > Client.field1127) {
            var6 = Client.field1127;
            var8 = var3 * var6 * 512 / (var15 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4921(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4921(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1165) {
         var15 = Client.field1165;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1162) {
            var6 = Client.field1162;
            var8 = var15 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.noClip();
               Rasterizer2D.method4921(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4921(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (Client.field1161 - Client.field1160) * var5 / 100 + Client.field1160;
      Client.scale = var8 * var3 * var6 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = var10 * 32 + 128 + 15;
            int var12 = var11 * 3 + 600;
            int var13 = Graphics3D.SINE[var11];
            var14[var10] = var12 * var13 >> 16;
         }

         Region.method2739(var14, 500, 800, var2, var3);
      }

      Client.field1166 = var0;
      Client.field1143 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILcg;ZB)I",
      garbageValue = "125"
   )
   static int method174(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class83.intStack[--WorldMapType2.intStackSize];
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.grandExchangeOffers[var3].method98();
         return 1;
      } else if(var0 == 3904) {
         var3 = class83.intStack[--WorldMapType2.intStackSize];
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class83.intStack[--WorldMapType2.intStackSize];
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class83.intStack[--WorldMapType2.intStackSize];
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class83.intStack[--WorldMapType2.intStackSize];
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class83.intStack[--WorldMapType2.intStackSize];
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class83.intStack[--WorldMapType2.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method95();
            class83.intStack[++WorldMapType2.intStackSize - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class83.intStack[--WorldMapType2.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method95();
            class83.intStack[++WorldMapType2.intStackSize - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class83.intStack[--WorldMapType2.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method95();
            class83.intStack[++WorldMapType2.intStackSize - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class83.intStack[--WorldMapType2.intStackSize];
            var12 = Client.grandExchangeOffers[var3].method95();
            class83.intStack[++WorldMapType2.intStackSize - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class83.intStack[--WorldMapType2.intStackSize] == 1;
               if(XClanMember.field904 != null) {
                  XClanMember.field904.method74(class13.field290, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class83.intStack[--WorldMapType2.intStackSize] == 1;
               if(XClanMember.field904 != null) {
                  XClanMember.field904.method74(class13.field292, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               WorldMapType2.intStackSize -= 2;
               var13 = class83.intStack[WorldMapType2.intStackSize] == 1;
               boolean var4 = class83.intStack[WorldMapType2.intStackSize + 1] == 1;
               if(XClanMember.field904 != null) {
                  XClanMember.field904.method74(new class95(var4), var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class83.intStack[--WorldMapType2.intStackSize] == 1;
               if(XClanMember.field904 != null) {
                  XClanMember.field904.method74(class13.field288, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class83.intStack[--WorldMapType2.intStackSize] == 1;
               if(XClanMember.field904 != null) {
                  XClanMember.field904.method74(class13.field291, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class83.intStack[++WorldMapType2.intStackSize - 1] = XClanMember.field904 == null?0:XClanMember.field904.field294.size();
               return 1;
            } else {
               class14 var11;
               if(var0 == 3920) {
                  var3 = class83.intStack[--WorldMapType2.intStackSize];
                  var11 = (class14)XClanMember.field904.field294.get(var3);
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var11.field301;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class83.intStack[--WorldMapType2.intStackSize];
                  var11 = (class14)XClanMember.field904.field294.get(var3);
                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var11.method79();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class83.intStack[--WorldMapType2.intStackSize];
                  var11 = (class14)XClanMember.field904.field294.get(var3);
                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var11.method83();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class83.intStack[--WorldMapType2.intStackSize];
                  var11 = (class14)XClanMember.field904.field294.get(var3);
                  long var5 = class46.currentTimeMs() - Ignore.field843 - var11.field296;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class83.scriptStringStack[++BaseVarType.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class83.intStack[--WorldMapType2.intStackSize];
                  var11 = (class14)XClanMember.field904.field294.get(var3);
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var11.field297.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class83.intStack[--WorldMapType2.intStackSize];
                  var11 = (class14)XClanMember.field904.field294.get(var3);
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var11.field297.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class83.intStack[--WorldMapType2.intStackSize];
                  var11 = (class14)XClanMember.field904.field294.get(var3);
                  class83.intStack[++WorldMapType2.intStackSize - 1] = var11.field297.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
