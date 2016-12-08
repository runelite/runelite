import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public class class118 {
   @ObfuscatedName("c")
   public static int[] field1853 = new int[4096];
   @ObfuscatedName("pe")
   static class230 field1854;
   @ObfuscatedName("b")
   public static int[][] field1855 = new int[128][128];
   @ObfuscatedName("g")
   public static int[][] field1856 = new int[128][128];
   @ObfuscatedName("u")
   public static int[] field1859 = new int[4096];
   @ObfuscatedName("w")
   public static Buffer field1862;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -974714991
   )
   public static int field1863;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo2;",
      garbageValue = "-486724407"
   )
   public static CombatInfo2 method2231(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field2830.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field2838.method3203(33, var0);
         var1 = new CombatInfo2();
         if(null != var2) {
            var1.method3437(new Buffer(var2));
         }

         CombatInfo2.field2830.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "-747555203"
   )
   static final void method2232(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(var0.field3023 != null) {
            var0 = var0.method3643();
         }

         if(var0 != null) {
            if(var0.field2993) {
               if(!var0.field3028 || var1 == Client.field452) {
                  String var4 = var0.name;
                  int var8;
                  if(var0.combatLevel != 0) {
                     int var7 = var0.combatLevel;
                     var8 = class5.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var10;
                     if(var9 < -9) {
                        var10 = class16.method182(16711680);
                     } else if(var9 < -6) {
                        var10 = class16.method182(16723968);
                     } else if(var9 < -3) {
                        var10 = class16.method182(16740352);
                     } else if(var9 < 0) {
                        var10 = class16.method182(16756736);
                     } else if(var9 > 9) {
                        var10 = class16.method182('\uff00');
                     } else if(var9 > 6) {
                        var10 = class16.method182(4259584);
                     } else if(var9 > 3) {
                        var10 = class16.method182(8453888);
                     } else if(var9 > 0) {
                        var10 = class16.method182(12648192);
                     } else {
                        var10 = class16.method182(16776960);
                     }

                     var4 = var4 + var10 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(Client.field437 == 1) {
                     class48.addMenuEntry("Use", Client.field438 + " " + "->" + " " + class16.method182(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field439) {
                     if((class116.field1837 & 2) == 2) {
                        class48.addMenuEntry(Client.field562, Client.field443 + " " + "->" + " " + class16.method182(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.actions;
                     if(Client.field434) {
                        var5 = class38.method726(var5);
                     }

                     int var6;
                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var11 = 0;
                              if(var6 == 0) {
                                 var11 = 9;
                              }

                              if(var6 == 1) {
                                 var11 = 10;
                              }

                              if(var6 == 2) {
                                 var11 = 11;
                              }

                              if(var6 == 3) {
                                 var11 = 12;
                              }

                              if(var6 == 4) {
                                 var11 = 13;
                              }

                              class48.addMenuEntry(var5[var6], class16.method182(16776960) + var4, var11, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && var5[var6].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(Client.field315 != class40.field824) {
                                 if(class40.field818 == Client.field315 || Client.field315 == class40.field821 && var0.combatLevel > class5.localPlayer.combatLevel) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var6 == 0) {
                                    var8 = var12 + 9;
                                 }

                                 if(var6 == 1) {
                                    var8 = 10 + var12;
                                 }

                                 if(var6 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = 12 + var12;
                                 }

                                 if(var6 == 4) {
                                    var8 = 13 + var12;
                                 }

                                 class48.addMenuEntry(var5[var6], class16.method182(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class48.addMenuEntry("Examine", class16.method182(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(LActor;S)V",
      garbageValue = "-3253"
   )
   static final void method2233(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field656 == 0) {
         var0.field662 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var10 = class31.getAnimation(var0.animation);
            if(var0.field663 > 0 && var10.precedenceAnimating == 0) {
               ++var0.field662;
               return;
            }

            if(var0.field663 <= 0 && var10.priority == 0) {
               ++var0.field662;
               return;
            }
         }

         int var1 = var0.x;
         int var2 = var0.y;
         int var3 = 128 * var0.pathX[var0.field656 - 1] + var0.field612 * 64;
         int var4 = 128 * var0.pathY[var0.field656 - 1] + var0.field612 * 64;
         if(var1 < var3) {
            if(var2 < var4) {
               var0.field655 = 1280;
            } else if(var2 > var4) {
               var0.field655 = 1792;
            } else {
               var0.field655 = 1536;
            }
         } else if(var1 > var3) {
            if(var2 < var4) {
               var0.field655 = 768;
            } else if(var2 > var4) {
               var0.field655 = 256;
            } else {
               var0.field655 = 512;
            }
         } else if(var2 < var4) {
            var0.field655 = 1024;
         } else if(var2 > var4) {
            var0.field655 = 0;
         }

         byte var5 = var0.field661[var0.field656 - 1];
         if(var3 - var1 <= 256 && var3 - var1 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field655 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field640;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field624;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field648;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field615;
            }

            if(var7 == -1) {
               var7 = var0.field624;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.angle != var0.field655 && var0.interacting == -1 && var0.field657 != 0) {
                  var8 = 2;
               }

               if(var0.field656 > 2) {
                  var8 = 6;
               }

               if(var0.field656 > 3) {
                  var8 = 8;
               }

               if(var0.field662 > 0 && var0.field656 > 1) {
                  var8 = 8;
                  --var0.field662;
               }
            } else {
               if(var0.field656 > 1) {
                  var8 = 6;
               }

               if(var0.field656 > 2) {
                  var8 = 8;
               }

               if(var0.field662 > 0 && var0.field656 > 1) {
                  var8 = 8;
                  --var0.field662;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field624 && var0.field611 != -1) {
               var0.poseAnimation = var0.field611;
            }

            if(var1 != var3 || var4 != var2) {
               if(var1 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var1 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var3 == var0.x && var0.y == var4) {
               --var0.field656;
               if(var0.field663 > 0) {
                  --var0.field663;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field656;
            if(var0.field663 > 0) {
               --var0.field663;
            }

         }
      }
   }
}
