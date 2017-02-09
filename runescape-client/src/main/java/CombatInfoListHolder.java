import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("h")
   public static Buffer field749;
   @ObfuscatedName("o")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("r")
   @Export("combatInfo1")
   CombatInfoList combatInfo1 = new CombatInfoList();
   @ObfuscatedName("z")
   static Buffer field754;
   @ObfuscatedName("nb")
   static class57 field760;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "884884215"
   )
   boolean method726() {
      return this.combatInfo1.method2368();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo1;",
      garbageValue = "-995175364"
   )
   CombatInfo1 method727(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method2351();
      if(var2 != null && var2.field654 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2353(); null != var3 && var3.field654 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2353()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field654 + var2.field657 + this.combatInfo2.field2816 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "64"
   )
   void method729(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method2351(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method2353()) {
         ++var6;
         if(var1 == var7.field654) {
            var7.method644(var1, var2, var3, var4);
            return;
         }

         if(var7.field654 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.combatInfo1.method2348(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method2350(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method2351().unlink();
         }

      }
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "116"
   )
   static final void method731(int var0, int var1, int var2, int var3) {
      if(Client.field525 == 0 && !Client.field432) {
         class20.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < Model.field1399; ++var6) {
         var7 = Model.field1411[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && class65.region.method1737(class48.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class156.getObjectDefinition(var11);
               if(null != var12.impostorIds) {
                  var12 = var12.getImpostor();
               }

               if(null == var12) {
                  continue;
               }

               if(Client.field525 == 1) {
                  class20.addMenuEntry("Use", Client.field431 + " " + "->" + " " + class163.method3157('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.field432) {
                  if((ItemComposition.field2939 & 4) == 4) {
                     class20.addMenuEntry(Client.field435, Client.field436 + " " + "->" + " " + class163.method3157('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var18 = var12.actions;
                  if(Client.field394) {
                     var18 = XItemContainer.method170(var18);
                  }

                  if(var18 != null) {
                     for(int var14 = 4; var14 >= 0; --var14) {
                        if(var18[var14] != null) {
                           short var15 = 0;
                           if(var14 == 0) {
                              var15 = 3;
                           }

                           if(var14 == 1) {
                              var15 = 4;
                           }

                           if(var14 == 2) {
                              var15 = 5;
                           }

                           if(var14 == 3) {
                              var15 = 6;
                           }

                           if(var14 == 4) {
                              var15 = 1001;
                           }

                           class20.addMenuEntry(var18[var14], class163.method3157('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class20.addMenuEntry("Examine", class163.method3157('\uffff') + var12.name, 1002, var12.field2881 << 14, var8, var9);
               }
            }

            int var13;
            Player var16;
            NPC var19;
            int var26;
            int[] var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field2987 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.field317; ++var13) {
                     var19 = Client.cachedNPCs[Client.field554[var13]];
                     if(null != var19 && var19 != var23 && var19.composition.field2987 == 1 && var19.x == var23.x && var23.y == var19.y) {
                        class5.method73(var19.composition, Client.field554[var13], var8, var9);
                     }
                  }

                  var13 = class45.field901;
                  var28 = class45.field902;

                  for(var26 = 0; var26 < var13; ++var26) {
                     var16 = Client.cachedPlayers[var28[var26]];
                     if(null != var16 && var23.x == var16.x && var16.y == var23.y) {
                        Friend.method190(var16, var28[var26], var8, var9);
                     }
                  }
               }

               class5.method73(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(null == var24) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var13 = 0; var13 < Client.field317; ++var13) {
                     var19 = Client.cachedNPCs[Client.field554[var13]];
                     if(var19 != null && var19.composition.field2987 == 1 && var24.x == var19.x && var24.y == var19.y) {
                        class5.method73(var19.composition, Client.field554[var13], var8, var9);
                     }
                  }

                  var13 = class45.field901;
                  var28 = class45.field902;

                  for(var26 = 0; var26 < var13; ++var26) {
                     var16 = Client.cachedPlayers[var28[var26]];
                     if(null != var16 && var24 != var16 && var24.x == var16.x && var24.y == var16.y) {
                        Friend.method190(var16, var28[var26], var8, var9);
                     }
                  }
               }

               if(Client.field407 != var11) {
                  Friend.method190(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[class48.plane][var8][var9];
               if(var25 != null) {
                  for(Item var27 = (Item)var25.method2386(); var27 != null; var27 = (Item)var25.method2409()) {
                     ItemComposition var29 = PlayerComposition.getItemDefinition(var27.id);
                     if(Client.field525 == 1) {
                        class20.addMenuEntry("Use", Client.field431 + " " + "->" + " " + class163.method3157(16748608) + var29.name, 16, var27.id, var8, var9);
                     } else if(Client.field432) {
                        if((ItemComposition.field2939 & 1) == 1) {
                           class20.addMenuEntry(Client.field435, Client.field436 + " " + "->" + " " + class163.method3157(16748608) + var29.name, 17, var27.id, var8, var9);
                        }
                     } else {
                        String[] var22 = var29.groundActions;
                        if(Client.field394) {
                           var22 = XItemContainer.method170(var22);
                        }

                        for(int var21 = 4; var21 >= 0; --var21) {
                           if(var22 != null && null != var22[var21]) {
                              byte var17 = 0;
                              if(var21 == 0) {
                                 var17 = 18;
                              }

                              if(var21 == 1) {
                                 var17 = 19;
                              }

                              if(var21 == 2) {
                                 var17 = 20;
                              }

                              if(var21 == 3) {
                                 var17 = 21;
                              }

                              if(var21 == 4) {
                                 var17 = 22;
                              }

                              class20.addMenuEntry(var22[var21], class163.method3157(16748608) + var29.name, var17, var27.id, var8, var9);
                           } else if(var21 == 2) {
                              class20.addMenuEntry("Take", class163.method3157(16748608) + var29.name, 20, var27.id, var8, var9);
                           }
                        }

                        class20.addMenuEntry("Examine", class163.method3157(16748608) + var29.name, 1004, var27.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var20 = Client.cachedPlayers[Client.field407];
         Friend.method190(var20, Client.field407, var6, var7);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([Lclass165;II)Lclass165;",
      garbageValue = "-1032834818"
   )
   public static class165 method732(class165[] var0, int var1) {
      class165[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class165 var4 = var2[var3];
         if(var1 == var4.vmethod4057()) {
            return var4;
         }
      }

      return null;
   }
}
