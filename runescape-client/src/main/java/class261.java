import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
public class class261 {
   @ObfuscatedName("z")
   public static final class261 field3622;
   @ObfuscatedName("w")
   public static final class261 field3623;
   @ObfuscatedName("e")
   public static final class261 field3624;
   @ObfuscatedName("t")
   public static final class261 field3625;
   @ObfuscatedName("p")
   public static final class261 field3626;
   @ObfuscatedName("j")
   final String field3628;
   @ObfuscatedName("i")
   String field3629;
   @ObfuscatedName("m")
   public static final class261 field3632;

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "80"
   )
   static final void method4609(int var0, int var1, int var2, int var3) {
      if(Client.itemSelectionState == 0 && !Client.field1061) {
         class44.addMenuEntry("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class134.field2000; ++var6) {
         var7 = class134.field2002[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var7 != var5) {
            var5 = var7;
            if(var10 == 2 && class17.region.method2727(Player.plane, var8, var9, var7) >= 0) {
               ObjectComposition var12 = class29.getObjectDefinition(var11);
               if(var12.impostorIds != null) {
                  var12 = var12.getImpostor();
               }

               if(var12 == null) {
                  continue;
               }

               if(Client.itemSelectionState == 1) {
                  class44.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class15.method105('\uffff') + var12.name, 1, var7, var8, var9);
               } else if(Client.field1061) {
                  if((class232.spellTargetFlags & 4) == 4) {
                     class44.addMenuEntry(Client.field1064, Client.field1065 + " " + "->" + " " + class15.method105('\uffff') + var12.name, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.actions;
                  if(Client.field1077) {
                     var13 = class2.method7(var13);
                  }

                  if(var13 != null) {
                     for(int var14 = 4; var14 >= 0; --var14) {
                        if(var13[var14] != null) {
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

                           class44.addMenuEntry(var13[var14], class15.method105('\uffff') + var12.name, var15, var7, var8, var9);
                        }
                     }
                  }

                  class44.addMenuEntry("Examine", class15.method105('\uffff') + var12.name, 1002, var12.field3461 << 14, var8, var9);
               }
            }

            Player var16;
            int var19;
            NPC var20;
            int var27;
            int[] var28;
            if(var10 == 1) {
               NPC var23 = Client.cachedNPCs[var11];
               if(var23 == null) {
                  continue;
               }

               if(var23.composition.field3559 == 1 && (var23.x & 127) == 64 && (var23.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.field930; ++var19) {
                     var20 = Client.cachedNPCs[Client.npcIndices[var19]];
                     if(var20 != null && var20 != var23 && var20.composition.field3559 == 1 && var23.x == var20.x && var23.y == var20.y) {
                        class6.method29(var20.composition, Client.npcIndices[var19], var8, var9);
                     }
                  }

                  var19 = class96.field1487;
                  var28 = class96.field1491;

                  for(var27 = 0; var27 < var19; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var23.x == var16.x && var23.y == var16.y) {
                        class4.method12(var16, var28[var27], var8, var9);
                     }
                  }
               }

               class6.method29(var23.composition, var11, var8, var9);
            }

            if(var10 == 0) {
               Player var24 = Client.cachedPlayers[var11];
               if(var24 == null) {
                  continue;
               }

               if((var24.x & 127) == 64 && (var24.y & 127) == 64) {
                  for(var19 = 0; var19 < Client.field930; ++var19) {
                     var20 = Client.cachedNPCs[Client.npcIndices[var19]];
                     if(var20 != null && var20.composition.field3559 == 1 && var20.x == var24.x && var24.y == var20.y) {
                        class6.method29(var20.composition, Client.npcIndices[var19], var8, var9);
                     }
                  }

                  var19 = class96.field1487;
                  var28 = class96.field1491;

                  for(var27 = 0; var27 < var19; ++var27) {
                     var16 = Client.cachedPlayers[var28[var27]];
                     if(var16 != null && var16 != var24 && var24.x == var16.x && var24.y == var16.y) {
                        class4.method12(var16, var28[var27], var8, var9);
                     }
                  }
               }

               if(Client.field1035 != var11) {
                  class4.method12(var24, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               Deque var25 = Client.groundItemDeque[Player.plane][var8][var9];
               if(var25 != null) {
                  for(Item var26 = (Item)var25.method3488(); var26 != null; var26 = (Item)var25.method3490()) {
                     ItemComposition var29 = class224.getItemDefinition(var26.id);
                     if(Client.itemSelectionState == 1) {
                        class44.addMenuEntry("Use", Client.selectedItemName + " " + "->" + " " + class15.method105(16748608) + var29.name, 16, var26.id, var8, var9);
                     } else if(Client.field1061) {
                        if((class232.spellTargetFlags & 1) == 1) {
                           class44.addMenuEntry(Client.field1064, Client.field1065 + " " + "->" + " " + class15.method105(16748608) + var29.name, 17, var26.id, var8, var9);
                        }
                     } else {
                        String[] var21 = var29.groundActions;
                        if(Client.field1077) {
                           var21 = class2.method7(var21);
                        }

                        for(int var22 = 4; var22 >= 0; --var22) {
                           if(var21 != null && var21[var22] != null) {
                              byte var17 = 0;
                              if(var22 == 0) {
                                 var17 = 18;
                              }

                              if(var22 == 1) {
                                 var17 = 19;
                              }

                              if(var22 == 2) {
                                 var17 = 20;
                              }

                              if(var22 == 3) {
                                 var17 = 21;
                              }

                              if(var22 == 4) {
                                 var17 = 22;
                              }

                              class44.addMenuEntry(var21[var22], class15.method105(16748608) + var29.name, var17, var26.id, var8, var9);
                           } else if(var22 == 2) {
                              class44.addMenuEntry("Take", class15.method105(16748608) + var29.name, 20, var26.id, var8, var9);
                           }
                        }

                        class44.addMenuEntry("Examine", class15.method105(16748608) + var29.name, 1004, var26.id, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         Player var18 = Client.cachedPlayers[Client.field1035];
         class4.method12(var18, Client.field1035, var6, var7);
      }

   }

   static {
      field3626 = new class261("PLAIN11", "p11_full");
      field3632 = new class261("PLAIN12", "p12_full");
      field3624 = new class261("BOLD12", "b12_full");
      field3625 = new class261("VERDANA11", "verdana_11pt_regular");
      field3623 = new class261("VERDANA13", "verdana_13pt_regular");
      field3622 = new class261("VERDANA15", "verdana_15pt_regular");
   }

   class261(String var1, String var2) {
      this.field3628 = var1;
      this.field3629 = var2;
   }
}
