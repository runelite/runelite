import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1349956205
   )
   @Export("world")
   int world;
   @ObfuscatedName("d")
   @Export("username")
   String username;
   @ObfuscatedName("iy")
   @ObfuscatedGetter(
      intValue = -1894127551
   )
   static int field269;
   @ObfuscatedName("q")
   @Export("rank")
   byte rank;
   @ObfuscatedName("ds")
   static int[] field272;
   @ObfuscatedName("ky")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("c")
   String field276;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "24"
   )
   static int method253(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class32.intStack[++class32.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         if(var0 == 3301) {
            class32.intStackSize -= 2;
            var3 = class32.intStack[class32.intStackSize];
            var4 = class32.intStack[class32.intStackSize + 1];
            class32.intStack[++class32.intStackSize - 1] = class198.method3599(var3, var4);
            return 1;
         } else if(var0 == 3302) {
            class32.intStackSize -= 2;
            var3 = class32.intStack[class32.intStackSize];
            var4 = class32.intStack[class32.intStackSize + 1];
            class32.intStack[++class32.intStackSize - 1] = Actor.method592(var3, var4);
            return 1;
         } else {
            int[] var5;
            int var6;
            int var7;
            XItemContainer var8;
            int var9;
            int var10;
            if(var0 == 3303) {
               class32.intStackSize -= 2;
               var3 = class32.intStack[class32.intStackSize];
               var4 = class32.intStack[class32.intStackSize + 1];
               var5 = class32.intStack;
               var6 = ++class32.intStackSize - 1;
               var8 = (XItemContainer)XItemContainer.itemContainers.method2773((long)var3);
               if(var8 == null) {
                  var7 = 0;
               } else if(var4 == -1) {
                  var7 = 0;
               } else {
                  var9 = 0;

                  for(var10 = 0; var10 < var8.stackSizes.length; ++var10) {
                     if(var8.itemIds[var10] == var4) {
                        var9 += var8.stackSizes[var10];
                     }
                  }

                  var7 = var9;
               }

               var5[var6] = var7;
               return 1;
            } else if(var0 == 3304) {
               var3 = class32.intStack[--class32.intStackSize];
               class32.intStack[++class32.intStackSize - 1] = class97.method1933(var3).field2776;
               return 1;
            } else if(var0 == 3305) {
               var3 = class32.intStack[--class32.intStackSize];
               class32.intStack[++class32.intStackSize - 1] = Client.boostedSkillLevels[var3];
               return 1;
            } else if(var0 == 3306) {
               var3 = class32.intStack[--class32.intStackSize];
               class32.intStack[++class32.intStackSize - 1] = Client.realSkillLevels[var3];
               return 1;
            } else if(var0 == 3307) {
               var3 = class32.intStack[--class32.intStackSize];
               class32.intStack[++class32.intStackSize - 1] = Client.skillExperiences[var3];
               return 1;
            } else if(var0 == 3308) {
               var3 = Client.plane;
               var4 = class108.baseX + (class22.localPlayer.x >> 7);
               int var11 = (class22.localPlayer.y >> 7) + GameEngine.baseY;
               class32.intStack[++class32.intStackSize - 1] = (var4 << 14) + (var3 << 28) + var11;
               return 1;
            } else if(var0 == 3309) {
               var3 = class32.intStack[--class32.intStackSize];
               class32.intStack[++class32.intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if(var0 == 3310) {
               var3 = class32.intStack[--class32.intStackSize];
               class32.intStack[++class32.intStackSize - 1] = var3 >> 28;
               return 1;
            } else if(var0 == 3311) {
               var3 = class32.intStack[--class32.intStackSize];
               class32.intStack[++class32.intStackSize - 1] = var3 & 16383;
               return 1;
            } else if(var0 == 3312) {
               class32.intStack[++class32.intStackSize - 1] = Client.isMembers?1:0;
               return 1;
            } else if(var0 == 3313) {
               class32.intStackSize -= 2;
               var3 = class32.intStack[class32.intStackSize] + '耀';
               var4 = class32.intStack[class32.intStackSize + 1];
               class32.intStack[++class32.intStackSize - 1] = class198.method3599(var3, var4);
               return 1;
            } else if(var0 == 3314) {
               class32.intStackSize -= 2;
               var3 = class32.intStack[class32.intStackSize] + '耀';
               var4 = class32.intStack[class32.intStackSize + 1];
               var5 = class32.intStack;
               var6 = ++class32.intStackSize - 1;
               var8 = (XItemContainer)XItemContainer.itemContainers.method2773((long)var3);
               if(var8 == null) {
                  var7 = 0;
               } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                  var7 = var8.stackSizes[var4];
               } else {
                  var7 = 0;
               }

               var5[var6] = var7;
               return 1;
            } else if(var0 != 3315) {
               if(var0 == 3316) {
                  if(Client.field517 >= 2) {
                     class32.intStack[++class32.intStackSize - 1] = Client.field517;
                  } else {
                     class32.intStack[++class32.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3317) {
                  class32.intStack[++class32.intStackSize - 1] = Client.field495;
                  return 1;
               } else if(var0 == 3318) {
                  class32.intStack[++class32.intStackSize - 1] = Client.world;
                  return 1;
               } else if(var0 == 3321) {
                  class32.intStack[++class32.intStackSize - 1] = Client.energy;
                  return 1;
               } else if(var0 == 3322) {
                  class32.intStack[++class32.intStackSize - 1] = Client.weight;
                  return 1;
               } else if(var0 == 3323) {
                  if(Client.field278) {
                     class32.intStack[++class32.intStackSize - 1] = 1;
                  } else {
                     class32.intStack[++class32.intStackSize - 1] = 0;
                  }

                  return 1;
               } else if(var0 == 3324) {
                  class32.intStack[++class32.intStackSize - 1] = Client.flags;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               class32.intStackSize -= 2;
               var3 = class32.intStack[class32.intStackSize] + '耀';
               var4 = class32.intStack[class32.intStackSize + 1];
               var5 = class32.intStack;
               var6 = ++class32.intStackSize - 1;
               var8 = (XItemContainer)XItemContainer.itemContainers.method2773((long)var3);
               if(var8 == null) {
                  var7 = 0;
               } else if(var4 == -1) {
                  var7 = 0;
               } else {
                  var9 = 0;

                  for(var10 = 0; var10 < var8.stackSizes.length; ++var10) {
                     if(var8.itemIds[var10] == var4) {
                        var9 += var8.stackSizes[var10];
                     }
                  }

                  var7 = var9;
               }

               var5[var6] = var7;
               return 1;
            }
         }
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1163289873"
   )
   static final void method254(Actor var0) {
      int var1 = var0.field638 - Client.gameCycle;
      int var2 = var0.field660 * 128 + var0.field603 * 64;
      int var3 = var0.field643 * 128 + var0.field603 * 64;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field657 = 0;
      var0.field650 = var0.field647;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "2020238358"
   )
   static int method255(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class128.method2364(class32.intStack[--class32.intStackSize]);
      } else {
         var3 = var2?class200.field2894:Script.field942;
      }

      class124.method2350(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class32.intStack[--class32.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class22.localPlayer.composition.method3170();
            return 1;
         } else {
            return 2;
         }
      } else {
         class32.intStackSize -= 2;
         int var4 = class32.intStack[class32.intStackSize];
         int var5 = class32.intStack[class32.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = class47.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2256 = var6.offsetX2d;
         var3.field2257 = var6.offsetY2d;
         var3.field2244 = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2265 = 0;
         } else if(var0 == 1212 | 1 == var6.isStackable) {
            var3.field2265 = 1;
         } else {
            var3.field2265 = 2;
         }

         if(var3.field2298 > 0) {
            var3.field2244 = var3.field2244 * 32 / var3.field2298;
         } else if(var3.originalWidth > 0) {
            var3.field2244 = var3.field2244 * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2082988307"
   )
   static final void method256(int var0, int var1, int var2, int var3) {
      Client.field428 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class45.field891;
      int[] var7 = class45.field894;

      int var8;
      for(var8 = 0; var8 < Client.field321 + var6; ++var8) {
         Object var9;
         if(var8 < var6) {
            var9 = Client.cachedPlayers[var7[var8]];
            if(Client.field472 == var7[var8]) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var9 = Client.cachedNPCs[Client.field350[var8 - var6]];
         }

         class8.method105((Actor)var9, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class8.method105(Client.cachedPlayers[Client.field472], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field428; ++var8) {
         int var18 = Client.field378[var8];
         int var10 = Client.field379[var8];
         int var11 = Client.field381[var8];
         int var12 = Client.field473[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var19 = 0; var19 < var8; ++var19) {
               if(var10 + 2 > Client.field379[var19] - Client.field473[var19] && var10 - var12 < Client.field379[var19] + 2 && var18 - var11 < Client.field381[var19] + Client.field378[var19] && var18 + var11 > Client.field378[var19] - Client.field381[var19] && Client.field379[var19] - Client.field473[var19] < var10) {
                  var10 = Client.field379[var19] - Client.field473[var19];
                  var13 = true;
               }
            }
         }

         Client.field388 = Client.field378[var8];
         Client.field389 = Client.field379[var8] = var10;
         String var14 = Client.field335[var8];
         if(Client.field447 == 0) {
            int var15 = 16776960;
            if(Client.field507[var8] < 6) {
               var15 = Client.field502[Client.field507[var8]];
            }

            if(Client.field507[var8] == 6) {
               var15 = Client.field309 % 20 < 10?16711680:16776960;
            }

            if(Client.field507[var8] == 7) {
               var15 = Client.field309 % 20 < 10?255:'\uffff';
            }

            if(Client.field507[var8] == 8) {
               var15 = Client.field309 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field507[var8] == 9) {
               var16 = 150 - Client.field384[var8];
               if(var16 < 50) {
                  var15 = var16 * 1280 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16776960 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 5 + '\uff00';
               }
            }

            if(Client.field507[var8] == 10) {
               var16 = 150 - Client.field384[var8];
               if(var16 < 50) {
                  var15 = var16 * 5 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - (var16 - 50) * 327680;
               } else if(var16 < 150) {
                  var15 = (var16 - 100) * 327680 + 255 - (var16 - 100) * 5;
               }
            }

            if(Client.field507[var8] == 11) {
               var16 = 150 - Client.field384[var8];
               if(var16 < 50) {
                  var15 = 16777215 - var16 * 327685;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - (var16 - 100) * 327680;
               }
            }

            if(Client.field503[var8] == 0) {
               TextureProvider.field1192.method3944(var14, var0 + Client.field388, Client.field389 + var1, var15, 0);
            }

            if(Client.field503[var8] == 1) {
               TextureProvider.field1192.method3919(var14, var0 + Client.field388, Client.field389 + var1, var15, 0, Client.field309);
            }

            if(Client.field503[var8] == 2) {
               TextureProvider.field1192.method3920(var14, var0 + Client.field388, Client.field389 + var1, var15, 0, Client.field309);
            }

            if(Client.field503[var8] == 3) {
               TextureProvider.field1192.method3921(var14, var0 + Client.field388, var1 + Client.field389, var15, 0, Client.field309, 150 - Client.field384[var8]);
            }

            if(Client.field503[var8] == 4) {
               var16 = (150 - Client.field384[var8]) * (TextureProvider.field1192.method3904(var14) + 100) / 150;
               Rasterizer2D.method4084(var0 + Client.field388 - 50, var1, Client.field388 + var0 + 50, var1 + var3);
               TextureProvider.field1192.method3914(var14, var0 + Client.field388 + 50 - var16, Client.field389 + var1, var15, 0);
               Rasterizer2D.method4083(var0, var1, var0 + var2, var3 + var1);
            }

            if(Client.field503[var8] == 5) {
               var16 = 150 - Client.field384[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               Rasterizer2D.method4084(var0, var1 + Client.field389 - TextureProvider.field1192.field3111 - 1, var2 + var0, Client.field389 + var1 + 5);
               TextureProvider.field1192.method3944(var14, Client.field388 + var0, Client.field389 + var1 + var17, var15, 0);
               Rasterizer2D.method4083(var0, var1, var2 + var0, var1 + var3);
            }
         } else {
            TextureProvider.field1192.method3944(var14, var0 + Client.field388, Client.field389 + var1, 16776960, 0);
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "0"
   )
   public static Object method257(byte[] var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else {
         if(var0.length > 136 && !class132.field1981) {
            try {
               class127 var2 = new class127();
               var2.vmethod2616(var0);
               return var2;
            } catch (Throwable var3) {
               class132.field1981 = true;
            }
         }

         return var0;
      }
   }
}
