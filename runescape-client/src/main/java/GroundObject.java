import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("do")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -1895309525
   )
   static int field1875;
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      intValue = 491070515
   )
   static int field1881;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1411182579
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -657436501
   )
   @Export("x")
   int x;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 929759303
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1938314205
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1997497265
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-23"
   )
   public static void method2498() {
      if(KeyFocusListener.keyboard != null) {
         KeyFocusListener var0 = KeyFocusListener.keyboard;
         synchronized(KeyFocusListener.keyboard) {
            KeyFocusListener.keyboard = null;
         }
      }

   }

   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "(IZZZS)Lib;",
      garbageValue = "-17958"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class156.field2250 != null) {
         var4 = new IndexFile(var0, class156.field2250, class54.field685[var0], 1000000);
      }

      return new IndexData(var4, class228.field3151, var0, var1, var2, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfn;I)V",
      garbageValue = "324717848"
   )
   static final void method2495(PacketBuffer var0) {
      int var1 = 0;
      var0.bitAccess();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class95.field1507; ++var2) {
         var3 = class95.field1511[var2];
         if((class95.field1504[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class95.field1504[var3] = (byte)(class95.field1504[var3] | 2);
            } else {
               var4 = var0.getBits(1);
               if(var4 == 0) {
                  var1 = class47.method741(var0);
                  class95.field1504[var3] = (byte)(class95.field1504[var3] | 2);
               } else {
                  class5.decodeMovement(var0, var3);
               }
            }
         }
      }

      var0.byteAccess();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.bitAccess();

         for(var2 = 0; var2 < class95.field1507; ++var2) {
            var3 = class95.field1511[var2];
            if((class95.field1504[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class95.field1504[var3] = (byte)(class95.field1504[var3] | 2);
               } else {
                  var4 = var0.getBits(1);
                  if(var4 == 0) {
                     var1 = class47.method741(var0);
                     class95.field1504[var3] = (byte)(class95.field1504[var3] | 2);
                  } else {
                     class5.decodeMovement(var0, var3);
                  }
               }
            }
         }

         var0.byteAccess();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.bitAccess();

            for(var2 = 0; var2 < class95.field1509; ++var2) {
               var3 = class95.field1515[var2];
               if((class95.field1504[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class95.field1504[var3] = (byte)(class95.field1504[var3] | 2);
                  } else {
                     var4 = var0.getBits(1);
                     if(var4 == 0) {
                        var1 = class47.method741(var0);
                        class95.field1504[var3] = (byte)(class95.field1504[var3] | 2);
                     } else if(ItemContainer.decodeRegionHash(var0, var3)) {
                        class95.field1504[var3] = (byte)(class95.field1504[var3] | 2);
                     }
                  }
               }
            }

            var0.byteAccess();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.bitAccess();

               for(var2 = 0; var2 < class95.field1509; ++var2) {
                  var3 = class95.field1515[var2];
                  if((class95.field1504[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class95.field1504[var3] = (byte)(class95.field1504[var3] | 2);
                     } else {
                        var4 = var0.getBits(1);
                        if(var4 == 0) {
                           var1 = class47.method741(var0);
                           class95.field1504[var3] = (byte)(class95.field1504[var3] | 2);
                        } else if(ItemContainer.decodeRegionHash(var0, var3)) {
                           class95.field1504[var3] = (byte)(class95.field1504[var3] | 2);
                        }
                     }
                  }
               }

               var0.byteAccess();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class95.field1507 = 0;
                  class95.field1509 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class95.field1504[var2] = (byte)(class95.field1504[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class95.field1511[++class95.field1507 - 1] = var2;
                     } else {
                        class95.field1515[++class95.field1509 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;I)V",
      garbageValue = "-678087804"
   )
   public static void method2499(IndexDataBase var0) {
      Varbit.varbit_ref = var0;
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "0"
   )
   static final void method2494(int var0, int var1, int var2, int var3, int var4) {
      int var5 = ScriptState.region.method2896(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = ScriptState.region.method2741(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = GrandExchangeOffer.field315.image;
         var11 = (103 - var2) * 2048 + var1 * 4 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = GameObject.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = class8.field242[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method4983(var1 * 4 + 48 + var15, (104 - var2 - var13.sizeY) * 4 + var16 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = ScriptState.region.method2875(var0, var1, var2);
      if(var5 != 0) {
         var6 = ScriptState.region.method2741(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = GameObject.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = class8.field242[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.sizeX * 4 - var17.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var17.height) / 2;
               var17.method4983(var12 + var1 * 4 + 48, (104 - var2 - var23.sizeY) * 4 + var18 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = GrandExchangeOffer.field315.image;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = ScriptState.region.method2762(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = GameObject.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = class8.field242[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.sizeX * 4 - var20.originalWidth) / 2;
               int var21 = (var19.sizeY * 4 - var20.height) / 2;
               var20.method4983(48 + var1 * 4 + var9, var21 + (104 - var2 - var19.sizeY) * 4 + 48);
            }
         }
      }

   }
}
