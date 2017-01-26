import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 2051527623
   )
   int field592;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -2104370561
   )
   int field594 = 0;
   @ObfuscatedName("bu")
   @Export("combatInfoList")
   CombatInfoList combatInfoList = new CombatInfoList();
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 529277659
   )
   int field596 = 1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1452464307
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1581188719
   )
   int field598 = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1873190771
   )
   int field599 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1627331003
   )
   int field600 = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1615311881
   )
   int field601 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1284197415
   )
   int field602 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 606115695
   )
   int field603 = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -2117425715
   )
   int field604 = -1;
   @ObfuscatedName("ao")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("ab")
   boolean field606;
   @ObfuscatedName("an")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -527311317
   )
   int field608 = 100;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 194338461
   )
   int field609 = 0;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -462726199
   )
   int field610;
   @ObfuscatedName("au")
   byte field611 = 0;
   @ObfuscatedName("az")
   int[] field612 = new int[4];
   @ObfuscatedName("at")
   int[] field613 = new int[4];
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 322947937
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("as")
   int[] field615 = new int[4];
   @ObfuscatedName("be")
   int[] field616 = new int[4];
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 443962135
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1794159189
   )
   int field618;
   @ObfuscatedName("br")
   boolean field619 = false;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -832243121
   )
   int field620 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1931548361
   )
   @Export("x")
   int x;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1013874697
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1834645647
   )
   int field623 = 0;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 80635031
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 652283283
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -424894183
   )
   int field626 = 0;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -1558039669
   )
   int field627 = 0;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 254792093
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("cm")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 717444123
   )
   int field630 = 0;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1764613891
   )
   int field631 = 0;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 372120857
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 263564755
   )
   int field633;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1428338929
   )
   int field634;
   @ObfuscatedName("ci")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1507005727
   )
   int field636;
   @ObfuscatedName("aj")
   boolean field637 = false;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1207254677
   )
   @Export("y")
   int y;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -639159901
   )
   int field639;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1591757467
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1271100081
   )
   int field641 = 0;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1709676711
   )
   int field642 = 200;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1583699025
   )
   int field643;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -1088642435
   )
   int field644 = 0;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1422790871
   )
   int field645 = 32;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1706506797
   )
   int field646 = 0;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -634821875
   )
   int field647;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1739495513
   )
   int field648 = 0;
   @ObfuscatedName("cc")
   byte[] field649 = new byte[10];
   @ObfuscatedName("aq")
   int[] field650 = new int[4];
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -786992331
   )
   int field651 = 0;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1576894337
   )
   int field652;

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "1834053326"
   )
   static final void method579(Player var0, int var1, int var2, int var3) {
      if(var0 != class16.localPlayer) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field244 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class159.method3065(var0.combatLevel, class16.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field244 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field429 == 1) {
               class72.addMenuEntry("Use", Client.field431 + " " + "->" + " " + Client.method568(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field432) {
               if((class3.field29 & 8) == 8) {
                  class72.addMenuEntry(Client.field406, Client.field436 + " " + "->" + " " + Client.method568(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.playerOptions[var5] != null) {
                     short var6 = 0;
                     if(Client.playerOptions[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field307 == class40.field808) {
                           continue;
                        }

                        if(Client.field307 == class40.field812 || class40.field815 == Client.field307 && var0.combatLevel > class16.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class16.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class16.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.playerOptionsPriority[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = var6 + Client.field404[var5];
                     class72.addMenuEntry(Client.playerOptions[var5], Client.method568(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = Client.method568(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-11"
   )
   final void method580() {
      this.field646 = 0;
      this.field651 = 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-94"
   )
   boolean vmethod702() {
      return false;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1171035886"
   )
   final void method584(int var1) {
      CombatInfo2 var2 = class142.method2699(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method2381(); null != var3; var3 = (CombatInfoListHolder)this.combatInfoList.method2389()) {
         if(var2 == var3.combatInfo2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-857605297"
   )
   final void method587(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = class142.method2699(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field2837;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method2381(); null != var12; var12 = (CombatInfoListHolder)this.combatInfoList.method2389()) {
         ++var11;
         if(var7.field2831 == var12.combatInfo2.field2831) {
            var12.method686(var4 + var2, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field2832 <= var7.field2832) {
            var8 = var12;
         }

         if(var12.combatInfo2.field2837 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field2837;
         }
      }

      if(null != var9 || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(null == var8) {
            this.combatInfoList.method2384(var12);
         } else {
            CombatInfoList.method2380(var12, var8);
         }

         var12.method686(var4 + var2, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "4"
   )
   final void method592(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field612[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class196 var14 = class108.method2038(var1);
         var10 = var14.field2885;
         var11 = var14.field2869;
      }

      int var12;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var12 = 0;
         if(var10 == 0) {
            var12 = this.field612[0];
         } else if(var10 == 1) {
            var12 = this.field613[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field612[var13] < var12) {
                  var9 = var13;
                  var12 = this.field612[var13];
               }
            } else if(var10 == 1 && this.field613[var13] < var12) {
               var9 = var13;
               var12 = this.field613[var13];
            }
         }

         if(var10 == 1 && var12 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field611 = 0;
         }

         for(var12 = 0; var12 < 4; ++var12) {
            byte var15 = this.field611;
            this.field611 = (byte)((1 + this.field611) % 4);
            if(this.field612[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field650[var9] = var1;
         this.field613[var9] = var2;
         this.field615[var9] = var3;
         this.field616[var9] = var4;
         this.field612[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIIIIII)V",
      garbageValue = "1111768035"
   )
   static final void method596(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if(var9 != null && (!var9.hasScript || var9.type == 0 || var9.field2276 || class36.method724(var9) != 0 || Client.field430 == var9 || var9.contentType == 1338) && var1 == var9.parentId && (!var9.hasScript || !class97.method1917(var9))) {
            int var10 = var6 + var9.relativeX;
            int var11 = var9.relativeY + var7;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            int var30;
            if(var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else if(var9.type == 9) {
               var16 = var10;
               var17 = var11;
               var30 = var10 + var9.width;
               var19 = var9.height + var11;
               if(var30 < var10) {
                  var16 = var30;
                  var30 = var10;
               }

               if(var19 < var11) {
                  var17 = var19;
                  var19 = var11;
               }

               ++var30;
               ++var19;
               var12 = var16 > var2?var16:var2;
               var13 = var17 > var3?var17:var3;
               var14 = var30 < var4?var30:var4;
               var15 = var19 < var5?var19:var5;
            } else {
               var16 = var9.width + var10;
               var17 = var11 + var9.height;
               var12 = var10 > var2?var10:var2;
               var13 = var11 > var3?var11:var3;
               var14 = var16 < var4?var16:var4;
               var15 = var17 < var5?var17:var5;
            }

            if(var9 == Client.field368) {
               Client.field448 = true;
               Client.field497 = var10;
               Client.field460 = var11;
            }

            if(!var9.hasScript || var12 < var14 && var13 < var15) {
               var16 = class115.field1805;
               var17 = class115.field1814;
               if(class115.field1813 != 0) {
                  var16 = class115.field1811;
                  var17 = class115.field1812;
               }

               if(var9.contentType == 1337) {
                  if(!Client.field385 && !Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     class107.method2036(var16, var17, var12, var13);
                  }
               } else if(var9.contentType == 1338) {
                  class137.method2486(var9, var10, var11);
               } else {
                  int var21;
                  int var22;
                  int var23;
                  boolean var37;
                  if(!Client.isMenuOpen && var16 >= var12 && var17 >= var13 && var16 < var14 && var17 < var15) {
                     var30 = var16 - var10;
                     var19 = var17 - var11;
                     if(var9.field2237 == 1) {
                        class72.addMenuEntry(var9.tooltip, "", 24, 0, 0, var9.id);
                     }

                     String var32;
                     if(var9.field2237 == 2 && !Client.field432) {
                        var32 = MessageNode.method205(var9);
                        if(null != var32) {
                           class72.addMenuEntry(var32, Client.method568('\uff00') + var9.field2313, 25, 0, -1, var9.id);
                        }
                     }

                     if(var9.field2237 == 3) {
                        class72.addMenuEntry("Close", "", 26, 0, 0, var9.id);
                     }

                     if(var9.field2237 == 4) {
                        class72.addMenuEntry(var9.tooltip, "", 28, 0, 0, var9.id);
                     }

                     if(var9.field2237 == 5) {
                        class72.addMenuEntry(var9.tooltip, "", 29, 0, 0, var9.id);
                     }

                     if(var9.field2237 == 6 && Client.field441 == null) {
                        class72.addMenuEntry(var9.tooltip, "", 30, 0, -1, var9.id);
                     }

                     int var20;
                     int var33;
                     if(var9.type == 2) {
                        var20 = 0;

                        for(var21 = 0; var21 < var9.height; ++var21) {
                           for(var22 = 0; var22 < var9.width; ++var22) {
                              var23 = (32 + var9.field2262) * var22;
                              var33 = (32 + var9.field2318) * var21;
                              if(var20 < 20) {
                                 var23 += var9.field2264[var20];
                                 var33 += var9.field2265[var20];
                              }

                              if(var30 >= var23 && var19 >= var33 && var30 < var23 + 32 && var19 < var33 + 32) {
                                 Client.field395 = var20;
                                 class39.field802 = var9;
                                 if(var9.itemIds[var20] > 0) {
                                    ItemComposition var25 = class36.getItemDefinition(var9.itemIds[var20] - 1);
                                    if(Client.field429 == 1 && class99.method1940(class36.method724(var9))) {
                                       if(var9.id != Client.field472 || Ignore.field202 != var20) {
                                          class72.addMenuEntry("Use", Client.field431 + " " + "->" + " " + Client.method568(16748608) + var25.name, 31, var25.id, var20, var9.id);
                                       }
                                    } else if(Client.field432 && class99.method1940(class36.method724(var9))) {
                                       if((class3.field29 & 16) == 16) {
                                          class72.addMenuEntry(Client.field406, Client.field436 + " " + "->" + " " + Client.method568(16748608) + var25.name, 32, var25.id, var20, var9.id);
                                       }
                                    } else {
                                       String[] var26 = var25.inventoryActions;
                                       if(Client.field502) {
                                          var26 = class159.method3042(var26);
                                       }

                                       int var27;
                                       byte var28;
                                       if(class99.method1940(class36.method724(var9))) {
                                          for(var27 = 4; var27 >= 3; --var27) {
                                             if(var26 != null && var26[var27] != null) {
                                                if(var27 == 3) {
                                                   var28 = 36;
                                                } else {
                                                   var28 = 37;
                                                }

                                                class72.addMenuEntry(var26[var27], Client.method568(16748608) + var25.name, var28, var25.id, var20, var9.id);
                                             } else if(var27 == 4) {
                                                class72.addMenuEntry("Drop", Client.method568(16748608) + var25.name, 37, var25.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       if(RSCanvas.method2080(class36.method724(var9))) {
                                          class72.addMenuEntry("Use", Client.method568(16748608) + var25.name, 38, var25.id, var20, var9.id);
                                       }

                                       if(class99.method1940(class36.method724(var9)) && null != var26) {
                                          for(var27 = 2; var27 >= 0; --var27) {
                                             if(null != var26[var27]) {
                                                var28 = 0;
                                                if(var27 == 0) {
                                                   var28 = 33;
                                                }

                                                if(var27 == 1) {
                                                   var28 = 34;
                                                }

                                                if(var27 == 2) {
                                                   var28 = 35;
                                                }

                                                class72.addMenuEntry(var26[var27], Client.method568(16748608) + var25.name, var28, var25.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       var26 = var9.field2329;
                                       if(Client.field502) {
                                          var26 = class159.method3042(var26);
                                       }

                                       if(null != var26) {
                                          for(var27 = 4; var27 >= 0; --var27) {
                                             if(null != var26[var27]) {
                                                var28 = 0;
                                                if(var27 == 0) {
                                                   var28 = 39;
                                                }

                                                if(var27 == 1) {
                                                   var28 = 40;
                                                }

                                                if(var27 == 2) {
                                                   var28 = 41;
                                                }

                                                if(var27 == 3) {
                                                   var28 = 42;
                                                }

                                                if(var27 == 4) {
                                                   var28 = 43;
                                                }

                                                class72.addMenuEntry(var26[var27], Client.method568(16748608) + var25.name, var28, var25.id, var20, var9.id);
                                             }
                                          }
                                       }

                                       class72.addMenuEntry("Examine", Client.method568(16748608) + var25.name, 1005, var25.id, var20, var9.id);
                                    }
                                 }
                              }

                              ++var20;
                           }
                        }
                     }

                     if(var9.hasScript) {
                        if(Client.field432) {
                           var21 = class36.method724(var9);
                           var37 = (var21 >> 21 & 1) != 0;
                           if(var37 && (class3.field29 & 32) == 32) {
                              class72.addMenuEntry(Client.field406, Client.field436 + " " + "->" + " " + var9.name, 58, 0, var9.index, var9.id);
                           }
                        } else {
                           for(var20 = 9; var20 >= 5; --var20) {
                              var23 = class36.method724(var9);
                              boolean var40 = (var23 >> var20 + 1 & 1) != 0;
                              String var29;
                              if(!var40 && var9.field2296 == null) {
                                 var29 = null;
                              } else if(null != var9.actions && var9.actions.length > var20 && var9.actions[var20] != null && var9.actions[var20].trim().length() != 0) {
                                 var29 = var9.actions[var20];
                              } else {
                                 var29 = null;
                              }

                              if(null != var29) {
                                 class72.addMenuEntry(var29, var9.name, 1007, 1 + var20, var9.index, var9.id);
                              }
                           }

                           var32 = MessageNode.method205(var9);
                           if(null != var32) {
                              class72.addMenuEntry(var32, var9.name, 25, 0, var9.index, var9.id);
                           }

                           for(var21 = 4; var21 >= 0; --var21) {
                              var33 = class36.method724(var9);
                              boolean var41 = (var33 >> var21 + 1 & 1) != 0;
                              String var31;
                              if(!var41 && var9.field2296 == null) {
                                 var31 = null;
                              } else if(var9.actions != null && var9.actions.length > var21 && null != var9.actions[var21] && var9.actions[var21].trim().length() != 0) {
                                 var31 = var9.actions[var21];
                              } else {
                                 var31 = null;
                              }

                              if(null != var31) {
                                 class72.addMenuEntry(var31, var9.name, 57, var21 + 1, var9.index, var9.id);
                              }
                           }

                           if(class39.method738(class36.method724(var9))) {
                              class72.addMenuEntry("Continue", "", 30, 0, var9.index, var9.id);
                           }
                        }
                     }
                  }

                  if(var9.type == 0) {
                     if(!var9.hasScript && class97.method1917(var9) && var9 != class15.field167) {
                        continue;
                     }

                     method596(var0, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     if(null != var9.children) {
                        method596(var9.children, var9.id, var12, var13, var14, var15, var10 - var9.scrollX, var11 - var9.scrollY);
                     }

                     WidgetNode var18 = (WidgetNode)Client.componentTable.method2374((long)var9.id);
                     if(var18 != null) {
                        if(var18.field175 == 0 && class115.field1805 >= var12 && class115.field1814 >= var13 && class115.field1805 < var14 && class115.field1814 < var15 && !Client.isMenuOpen && !Client.field505) {
                           for(class18 var34 = (class18)Client.field476.method2412(); var34 != null; var34 = (class18)Client.field476.method2426()) {
                              if(var34.field189) {
                                 var34.unlink();
                                 var34.field180.field2272 = false;
                              }
                           }

                           if(class176.field2653 == 0) {
                              Client.field368 = null;
                              Client.field430 = null;
                           }

                           if(!Client.isMenuOpen) {
                              Client.menuOptions[0] = "Cancel";
                              Client.menuTargets[0] = "";
                              Client.menuTypes[0] = 1006;
                              Client.menuOptionCount = 1;
                           }
                        }

                        var19 = var18.id;
                        if(class103.method1973(var19)) {
                           method596(Widget.widgets[var19], -1, var12, var13, var14, var15, var10, var11);
                        }
                     }
                  }

                  if(var9.hasScript) {
                     class18 var36;
                     if(!var9.field2194) {
                        if(var9.field2297 && class115.field1805 >= var12 && class115.field1814 >= var13 && class115.field1805 < var14 && class115.field1814 < var15) {
                           for(var36 = (class18)Client.field476.method2412(); null != var36; var36 = (class18)Client.field476.method2426()) {
                              if(var36.field189 && var36.field188 == var36.field180.field2205) {
                                 var36.unlink();
                              }
                           }
                        }
                     } else if(class115.field1805 >= var12 && class115.field1814 >= var13 && class115.field1805 < var14 && class115.field1814 < var15) {
                        for(var36 = (class18)Client.field476.method2412(); null != var36; var36 = (class18)Client.field476.method2426()) {
                           if(var36.field189) {
                              var36.unlink();
                              var36.field180.field2272 = false;
                           }
                        }

                        if(class176.field2653 == 0) {
                           Client.field368 = null;
                           Client.field430 = null;
                        }

                        if(!Client.isMenuOpen) {
                           Client.menuOptions[0] = "Cancel";
                           Client.menuTargets[0] = "";
                           Client.menuTypes[0] = 1006;
                           Client.menuOptionCount = 1;
                        }
                     }

                     boolean var43;
                     if(class115.field1805 >= var12 && class115.field1814 >= var13 && class115.field1805 < var14 && class115.field1814 < var15) {
                        var43 = true;
                     } else {
                        var43 = false;
                     }

                     boolean var38 = false;
                     if((class115.field1804 == 1 || !class48.field937 && class115.field1804 == 4) && var43) {
                        var38 = true;
                     }

                     var37 = false;
                     if((class115.field1813 == 1 || !class48.field937 && class115.field1813 == 4) && class115.field1811 >= var12 && class115.field1812 >= var13 && class115.field1811 < var14 && class115.field1812 < var15) {
                        var37 = true;
                     }

                     if(var37) {
                        class119.method2299(var9, class115.field1811 - var10, class115.field1812 - var11);
                     }

                     if(null != Client.field368 && Client.field368 != var9 && var43) {
                        var22 = class36.method724(var9);
                        boolean var39 = (var22 >> 20 & 1) != 0;
                        if(var39) {
                           Client.field454 = var9;
                        }
                     }

                     if(var9 == Client.field430) {
                        Client.field337 = true;
                        Client.field456 = var10;
                        Client.field457 = var11;
                     }

                     if(var9.field2276) {
                        class18 var42;
                        if(var43 && Client.field475 != 0 && null != var9.field2205) {
                           var42 = new class18();
                           var42.field189 = true;
                           var42.field180 = var9;
                           var42.field184 = Client.field475;
                           var42.field188 = var9.field2205;
                           Client.field476.method2407(var42);
                        }

                        if(Client.field368 != null || null != CombatInfoListHolder.field751 || Client.isMenuOpen) {
                           var37 = false;
                           var38 = false;
                           var43 = false;
                        }

                        if(!var9.field2322 && var37) {
                           var9.field2322 = true;
                           if(var9.field2295 != null) {
                              var42 = new class18();
                              var42.field189 = true;
                              var42.field180 = var9;
                              var42.field183 = class115.field1811 - var10;
                              var42.field184 = class115.field1812 - var11;
                              var42.field188 = var9.field2295;
                              Client.field476.method2407(var42);
                           }
                        }

                        if(var9.field2322 && var38 && var9.field2279 != null) {
                           var42 = new class18();
                           var42.field189 = true;
                           var42.field180 = var9;
                           var42.field183 = class115.field1805 - var10;
                           var42.field184 = class115.field1814 - var11;
                           var42.field188 = var9.field2279;
                           Client.field476.method2407(var42);
                        }

                        if(var9.field2322 && !var38) {
                           var9.field2322 = false;
                           if(null != var9.field2280) {
                              var42 = new class18();
                              var42.field189 = true;
                              var42.field180 = var9;
                              var42.field183 = class115.field1805 - var10;
                              var42.field184 = class115.field1814 - var11;
                              var42.field188 = var9.field2280;
                              Client.field478.method2407(var42);
                           }
                        }

                        if(var38 && var9.field2293 != null) {
                           var42 = new class18();
                           var42.field189 = true;
                           var42.field180 = var9;
                           var42.field183 = class115.field1805 - var10;
                           var42.field184 = class115.field1814 - var11;
                           var42.field188 = var9.field2293;
                           Client.field476.method2407(var42);
                        }

                        if(!var9.field2272 && var43) {
                           var9.field2272 = true;
                           if(var9.field2282 != null) {
                              var42 = new class18();
                              var42.field189 = true;
                              var42.field180 = var9;
                              var42.field183 = class115.field1805 - var10;
                              var42.field184 = class115.field1814 - var11;
                              var42.field188 = var9.field2282;
                              Client.field476.method2407(var42);
                           }
                        }

                        if(var9.field2272 && var43 && null != var9.field2213) {
                           var42 = new class18();
                           var42.field189 = true;
                           var42.field180 = var9;
                           var42.field183 = class115.field1805 - var10;
                           var42.field184 = class115.field1814 - var11;
                           var42.field188 = var9.field2213;
                           Client.field476.method2407(var42);
                        }

                        if(var9.field2272 && !var43) {
                           var9.field2272 = false;
                           if(var9.field2274 != null) {
                              var42 = new class18();
                              var42.field189 = true;
                              var42.field180 = var9;
                              var42.field183 = class115.field1805 - var10;
                              var42.field184 = class115.field1814 - var11;
                              var42.field188 = var9.field2274;
                              Client.field478.method2407(var42);
                           }
                        }

                        if(var9.field2219 != null) {
                           var42 = new class18();
                           var42.field180 = var9;
                           var42.field188 = var9.field2219;
                           Client.field378.method2407(var42);
                        }

                        class18 var24;
                        if(null != var9.field2248 && Client.field458 > var9.field2324) {
                           if(var9.field2304 != null && Client.field458 - var9.field2324 <= 32) {
                              label1015:
                              for(var21 = var9.field2324; var21 < Client.field458; ++var21) {
                                 var22 = Client.field428[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2304.length; ++var23) {
                                    if(var9.field2304[var23] == var22) {
                                       var24 = new class18();
                                       var24.field180 = var9;
                                       var24.field188 = var9.field2248;
                                       Client.field476.method2407(var24);
                                       break label1015;
                                    }
                                 }
                              }
                           } else {
                              var42 = new class18();
                              var42.field180 = var9;
                              var42.field188 = var9.field2248;
                              Client.field476.method2407(var42);
                           }

                           var9.field2324 = Client.field458;
                        }

                        if(var9.field2330 != null && Client.field466 > var9.field2325) {
                           if(null != var9.field2292 && Client.field466 - var9.field2325 <= 32) {
                              label991:
                              for(var21 = var9.field2325; var21 < Client.field466; ++var21) {
                                 var22 = Client.interfaceItemTriggers[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2292.length; ++var23) {
                                    if(var22 == var9.field2292[var23]) {
                                       var24 = new class18();
                                       var24.field180 = var9;
                                       var24.field188 = var9.field2330;
                                       Client.field476.method2407(var24);
                                       break label991;
                                    }
                                 }
                              }
                           } else {
                              var42 = new class18();
                              var42.field180 = var9;
                              var42.field188 = var9.field2330;
                              Client.field476.method2407(var42);
                           }

                           var9.field2325 = Client.field466;
                        }

                        if(null != var9.field2288 && Client.field468 > var9.field2244) {
                           if(null != var9.field2294 && Client.field468 - var9.field2244 <= 32) {
                              label967:
                              for(var21 = var9.field2244; var21 < Client.field468; ++var21) {
                                 var22 = Client.field467[var21 & 31];

                                 for(var23 = 0; var23 < var9.field2294.length; ++var23) {
                                    if(var9.field2294[var23] == var22) {
                                       var24 = new class18();
                                       var24.field180 = var9;
                                       var24.field188 = var9.field2288;
                                       Client.field476.method2407(var24);
                                       break label967;
                                    }
                                 }
                              }
                           } else {
                              var42 = new class18();
                              var42.field180 = var9;
                              var42.field188 = var9.field2288;
                              Client.field476.method2407(var42);
                           }

                           var9.field2244 = Client.field468;
                        }

                        if(Client.field469 > var9.field2323 && null != var9.field2298) {
                           var42 = new class18();
                           var42.field180 = var9;
                           var42.field188 = var9.field2298;
                           Client.field476.method2407(var42);
                        }

                        if(Client.field416 > var9.field2323 && null != var9.field2300) {
                           var42 = new class18();
                           var42.field180 = var9;
                           var42.field188 = var9.field2300;
                           Client.field476.method2407(var42);
                        }

                        if(Client.field471 > var9.field2323 && null != var9.field2301) {
                           var42 = new class18();
                           var42.field180 = var9;
                           var42.field188 = var9.field2301;
                           Client.field476.method2407(var42);
                        }

                        if(Client.field470 > var9.field2323 && var9.field2306 != null) {
                           var42 = new class18();
                           var42.field180 = var9;
                           var42.field188 = var9.field2306;
                           Client.field476.method2407(var42);
                        }

                        if(Client.field473 > var9.field2323 && null != var9.field2307) {
                           var42 = new class18();
                           var42.field180 = var9;
                           var42.field188 = var9.field2307;
                           Client.field476.method2407(var42);
                        }

                        if(Client.field474 > var9.field2323 && var9.field2302 != null) {
                           var42 = new class18();
                           var42.field180 = var9;
                           var42.field188 = var9.field2302;
                           Client.field476.method2407(var42);
                        }

                        var9.field2323 = Client.field462;
                        if(var9.field2290 != null) {
                           for(var21 = 0; var21 < Client.field500; ++var21) {
                              class18 var44 = new class18();
                              var44.field180 = var9;
                              var44.field195 = Client.field447[var21];
                              var44.field198 = Client.field501[var21];
                              var44.field188 = var9.field2290;
                              Client.field476.method2407(var44);
                           }
                        }
                     }
                  }

                  if(!var9.hasScript && null == Client.field368 && null == CombatInfoListHolder.field751 && !Client.isMenuOpen) {
                     if((var9.field2222 >= 0 || var9.field2223 != 0) && class115.field1805 >= var12 && class115.field1814 >= var13 && class115.field1805 < var14 && class115.field1814 < var15) {
                        if(var9.field2222 >= 0) {
                           class15.field167 = var0[var9.field2222];
                        } else {
                           class15.field167 = var9;
                        }
                     }

                     if(var9.type == 8 && class115.field1805 >= var12 && class115.field1814 >= var13 && class115.field1805 < var14 && class115.field1814 < var15) {
                        Ignore.field201 = var9;
                     }

                     if(var9.scrollHeight > var9.height) {
                        class112.method2096(var9, var9.width + var10, var11, var9.height, var9.scrollHeight, class115.field1805, class115.field1814);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1155312760"
   )
   static final void method598(int var0, int var1) {
      if(Spotanim.field2802 != var0 || var1 != class156.field2112) {
         Spotanim.field2802 = var0;
         class156.field2112 = var1;
         class212.setGameState(25);
         Tile.method1549("Loading - please wait.", true);
         int var2 = Projectile.baseX;
         int var3 = class3.baseY;
         Projectile.baseX = (var0 - 6) * 8;
         class3.baseY = (var1 - 6) * 8;
         int var4 = Projectile.baseX - var2;
         int var5 = class3.baseY - var3;
         var2 = Projectile.baseX;
         var3 = class3.baseY;

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
               var7.y -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(null != var20) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= 128 * var4;
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
         for(int var12 = var19; var18 != var12; var12 += var21) {
            for(var13 = var9; var10 != var13; var13 += var11) {
               int var14 = var4 + var12;
               int var15 = var5 + var13;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var12][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var12][var13] = null;
                  }
               }
            }
         }

         for(class25 var17 = (class25)Client.field410.method2412(); null != var17; var17 = (class25)Client.field410.method2426()) {
            var17.field560 -= var4;
            var17.field562 -= var5;
            if(var17.field560 < 0 || var17.field562 < 0 || var17.field560 >= 104 || var17.field562 >= 104) {
               var17.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field370 = 0;
         Client.field525 = false;
         Client.field506 = -1;
         Client.field412.method2405();
         Client.projectiles.method2405();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2264();
         }

      }
   }
}
