import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public final class class60 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1128387329"
   )
   static int method998(int var0, Script var1, boolean var2) {
      if(var0 == 3300) {
         class83.intStack[++class83.intStackSize - 1] = Client.gameCycle;
         return 1;
      } else {
         int var3;
         int var4;
         if(var0 == 3301) {
            class83.intStackSize -= 2;
            var3 = class83.intStack[class83.intStackSize];
            var4 = class83.intStack[class83.intStackSize + 1];
            class83.intStack[++class83.intStackSize - 1] = class36.method482(var3, var4);
            return 1;
         } else if(var0 == 3302) {
            class83.intStackSize -= 2;
            var3 = class83.intStack[class83.intStackSize];
            var4 = class83.intStack[class83.intStackSize + 1];
            class83.intStack[++class83.intStackSize - 1] = class77.method1512(var3, var4);
            return 1;
         } else if(var0 == 3303) {
            class83.intStackSize -= 2;
            var3 = class83.intStack[class83.intStackSize];
            var4 = class83.intStack[class83.intStackSize + 1];
            class83.intStack[++class83.intStackSize - 1] = ChatLineBuffer.method1862(var3, var4);
            return 1;
         } else {
            int var5;
            if(var0 == 3304) {
               var3 = class83.intStack[--class83.intStackSize];
               int[] var9 = class83.intStack;
               var5 = ++class83.intStackSize - 1;
               class240 var7 = (class240)class240.field3277.get((long)var3);
               class240 var6;
               if(var7 != null) {
                  var6 = var7;
               } else {
                  byte[] var13 = class240.field3276.getConfigData(5, var3);
                  var7 = new class240();
                  if(var13 != null) {
                     var7.method4274(new Buffer(var13));
                  }

                  class240.field3277.put(var7, (long)var3);
                  var6 = var7;
               }

               var9[var5] = var6.field3279;
               return 1;
            } else if(var0 == 3305) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = Client.boostedSkillLevels[var3];
               return 1;
            } else if(var0 == 3306) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = Client.realSkillLevels[var3];
               return 1;
            } else if(var0 == 3307) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = Client.skillExperiences[var3];
               return 1;
            } else if(var0 == 3308) {
               var3 = FaceNormal.plane;
               var4 = (World.localPlayer.x >> 7) + class41.baseX;
               var5 = (World.localPlayer.y >> 7) + WorldMapType3.baseY;
               class83.intStack[++class83.intStackSize - 1] = (var4 << 14) + (var3 << 28) + var5;
               return 1;
            } else if(var0 == 3309) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if(var0 == 3310) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = var3 >> 28;
               return 1;
            } else if(var0 == 3311) {
               var3 = class83.intStack[--class83.intStackSize];
               class83.intStack[++class83.intStackSize - 1] = var3 & 16383;
               return 1;
            } else if(var0 == 3312) {
               class83.intStack[++class83.intStackSize - 1] = Client.isMembers?1:0;
               return 1;
            } else if(var0 == 3313) {
               class83.intStackSize -= 2;
               var3 = class83.intStack[class83.intStackSize] + '耀';
               var4 = class83.intStack[class83.intStackSize + 1];
               class83.intStack[++class83.intStackSize - 1] = class36.method482(var3, var4);
               return 1;
            } else {
               int var11;
               if(var0 != 3314) {
                  if(var0 == 3315) {
                     class83.intStackSize -= 2;
                     var3 = class83.intStack[class83.intStackSize] + '耀';
                     var4 = class83.intStack[class83.intStackSize + 1];
                     class83.intStack[++class83.intStackSize - 1] = ChatLineBuffer.method1862(var3, var4);
                     return 1;
                  } else if(var0 == 3316) {
                     if(Client.field1097 >= 2) {
                        class83.intStack[++class83.intStackSize - 1] = Client.field1097;
                     } else {
                        class83.intStack[++class83.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3317) {
                     class83.intStack[++class83.intStackSize - 1] = Client.field981;
                     return 1;
                  } else if(var0 == 3318) {
                     class83.intStack[++class83.intStackSize - 1] = Client.world;
                     return 1;
                  } else if(var0 == 3321) {
                     class83.intStack[++class83.intStackSize - 1] = Client.energy;
                     return 1;
                  } else if(var0 == 3322) {
                     class83.intStack[++class83.intStackSize - 1] = Client.weight;
                     return 1;
                  } else if(var0 == 3323) {
                     if(Client.field1099) {
                        class83.intStack[++class83.intStackSize - 1] = 1;
                     } else {
                        class83.intStack[++class83.intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if(var0 == 3324) {
                     class83.intStack[++class83.intStackSize - 1] = Client.flags;
                     return 1;
                  } else if(var0 == 3325) {
                     class83.intStackSize -= 4;
                     var3 = class83.intStack[class83.intStackSize];
                     var4 = class83.intStack[class83.intStackSize + 1];
                     var5 = class83.intStack[class83.intStackSize + 2];
                     var11 = class83.intStack[class83.intStackSize + 3];
                     var3 += var4 << 14;
                     var3 += var5 << 28;
                     var3 += var11;
                     class83.intStack[++class83.intStackSize - 1] = var3;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  class83.intStackSize -= 2;
                  var3 = class83.intStack[class83.intStackSize] + '耀';
                  var4 = class83.intStack[class83.intStackSize + 1];
                  int[] var12 = class83.intStack;
                  var11 = ++class83.intStackSize - 1;
                  XItemContainer var8 = (XItemContainer)XItemContainer.itemContainers.method3520((long)var3);
                  int var10;
                  if(var8 == null) {
                     var10 = 0;
                  } else if(var4 >= 0 && var4 < var8.stackSizes.length) {
                     var10 = var8.stackSizes[var4];
                  } else {
                     var10 = 0;
                  }

                  var12[var11] = var10;
                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "-1328021253"
   )
   static final void method1004(class66 var0) {
      if(Client.flagX == World.localPlayer.x >> 7 && Client.flagY == World.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = class96.field1507;
      int[] var2 = class96.field1508;
      int var3 = var1;
      if(class66.field827 == var0 || var0 == class66.field823) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class66.field827) {
            var5 = World.localPlayer;
            var6 = World.localPlayer.field912 << 14;
         } else if(class66.field823 == var0) {
            var5 = Client.cachedPlayers[Client.field1059];
            var6 = Client.field1059 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class66.field826 && var2[var4] == Client.field1059) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod1691() && !var5.field913) {
            var5.field908 = false;
            if((Client.field1046 && var1 > 50 || var1 > 200) && class66.field827 != var0 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field908 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field902) {
                  var5.field908 = false;
                  var5.field897 = class21.method139(var5.x, var5.y, FaceNormal.plane);
                  class1.region.method2686(FaceNormal.plane, var5.x, var5.y, var5.field897, 60, var5, var5.angle, var6, var5.field904, var5.field906, var5.field889, var5.field907);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field1034 == Client.field1033[var7][var8]) {
                        continue;
                     }

                     Client.field1033[var7][var8] = Client.field1034;
                  }

                  var5.field897 = class21.method139(var5.x, var5.y, FaceNormal.plane);
                  class1.region.method2685(FaceNormal.plane, var5.x, var5.y, var5.field897, 60, var5, var5.angle, var6, var5.field1262);
               }
            }
         }
      }

   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(LWidget;I)LWidget;",
      garbageValue = "-1073254242"
   )
   static Widget method1005(Widget var0) {
      Widget var2 = var0;
      int var4 = class210.method3903(var0);
      int var7 = var4 >> 17 & 7;
      int var5 = var7;
      Widget var1;
      if(var7 == 0) {
         var1 = null;
      } else {
         int var6 = 0;

         while(true) {
            if(var6 >= var5) {
               var1 = var2;
               break;
            }

            var2 = WorldMapType3.method199(var2.parentId);
            if(var2 == null) {
               var1 = null;
               break;
            }

            ++var6;
         }
      }

      Widget var3 = var1;
      if(var1 == null) {
         var3 = var0.dragParent;
      }

      return var3;
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-1885912807"
   )
   static String method1007(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field931 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field931 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field931 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field931 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field931 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class67.field833 != null) {
         var3 = "/p=" + class67.field833;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field1077 + "/a=" + class18.field312 + var3 + "/";
   }
}
