import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -36339825
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("h")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1269413707
   )
   int field33;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 738636723
   )
   int field34 = -1;
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1996679059
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1381418413
   )
   int field38;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -784169251
   )
   int field39;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1477055475
   )
   int field40 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -591504641
   )
   int field41;
   @ObfuscatedName("pw")
   static class8 field42;
   @ObfuscatedName("u")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1671338997
   )
   int field44;
   @ObfuscatedName("o")
   boolean field45;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2019016461
   )
   int field46;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1961713031
   )
   int field47;
   @ObfuscatedName("r")
   @Export("model")
   Model model;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 416774471
   )
   int field49;
   @ObfuscatedName("z")
   boolean field50;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1799436637
   )
   int field51;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1876867175
   )
   @Export("team")
   int team;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -673709663
   )
   int field53;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 205666209
   )
   int field54;
   @ObfuscatedName("t")
   boolean field55;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1901350307
   )
   int field56;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 383636217
   )
   int field57;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1156064809
   )
   int field59;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2078847195"
   )
   final void method15(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.method2544();
      this.field40 = var1.method2545();
      this.field34 = var1.method2545();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2544();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2544();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2546();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class92.getItemDefinition(var4[var5] - 512).field1209;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2544();
         if(var7 < 0 || var7 >= Friend.field272[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.method2546();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field862 = var1.method2546();
      if(super.field862 == '\uffff') {
         super.field862 = -1;
      }

      super.field842 = super.field862;
      super.field859 = var1.method2546();
      if(super.field859 == '\uffff') {
         super.field859 = -1;
      }

      super.field844 = var1.method2546();
      if(super.field844 == '\uffff') {
         super.field844 = -1;
      }

      super.field845 = var1.method2546();
      if(super.field845 == '\uffff') {
         super.field845 = -1;
      }

      super.field846 = var1.method2546();
      if(super.field846 == '\uffff') {
         super.field846 = -1;
      }

      super.field843 = var1.method2546();
      if(super.field843 == '\uffff') {
         super.field843 = -1;
      }

      this.name = var1.method2552();
      if(this == class138.localPlayer) {
         class112.field1956 = this.name;
      }

      this.combatLevel = var1.method2544();
      this.field38 = var1.method2546();
      this.field45 = var1.method2544() == 1;
      if(Client.field514 == 0 && Client.field465 >= 2) {
         this.field45 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3512(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-274996514"
   )
   int method16() {
      return this.composition != null && this.composition.field2971 != -1?Friend.getNpcDefinition(this.composition.field2971).field910:1;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "-1368710824"
   )
   static final void method17(Player var0, int var1, int var2, int var3) {
      if(class138.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            if(var0.field38 == 0) {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + class14.method170(var0.combatLevel, class138.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field38 + ")" + var0.actions[2];
            }

            int var5;
            if(Client.field453 == 1) {
               class132.addMenuEntry("Use", Client.field312 + " " + "->" + " " + class137.method2909(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field455) {
               if((class18.field285 & 8) == 8) {
                  class132.addMenuEntry(Client.field458, Client.field459 + " " + "->" + " " + class137.method2909(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var5 = 7; var5 >= 0; --var5) {
                  if(Client.field429[var5] != null) {
                     short var6 = 0;
                     if(Client.field429[var5].equalsIgnoreCase("Attack")) {
                        if(Client.field326 == class21.field607) {
                           continue;
                        }

                        if(class21.field601 == Client.field326 || class21.field606 == Client.field326 && var0.combatLevel > class138.localPlayer.combatLevel) {
                           var6 = 2000;
                        }

                        if(class138.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class138.localPlayer.team) {
                              var6 = 2000;
                           } else {
                              var6 = 0;
                           }
                        }
                     } else if(Client.field430[var5]) {
                        var6 = 2000;
                     }

                     boolean var7 = false;
                     int var8 = Client.field428[var5] + var6;
                     class132.addMenuEntry(Client.field429[var5], class137.method2909(16777215) + var4, var8, var1, var2, var3);
                  }
               }
            }

            for(var5 = 0; var5 < Client.menuOptionCount; ++var5) {
               if(Client.menuTypes[var5] == 23) {
                  Client.menuTargets[var5] = class137.method2909(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "595234049"
   )
   final void method18(int var1, int var2, byte var3) {
      if(super.animation != -1 && class192.getAnimation(super.animation).field1023 == 1) {
         super.animation = -1;
      }

      super.field863 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.method16();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var9 = this.method16();
                  Client.field580.field1932 = var1;
                  Client.field580.field1933 = var2;
                  Client.field580.field1934 = 1;
                  Client.field580.field1935 = 1;
                  class10 var10 = Client.field580;
                  class10 var11 = var10;
                  CollisionData var12 = Client.collisionMaps[this.field53];
                  int[] var13 = Client.field581;
                  int[] var14 = Client.field582;
                  int var15 = 0;

                  label494:
                  while(true) {
                     int var16;
                     if(var15 >= 128) {
                        int var17;
                        int var18;
                        byte var20;
                        int var21;
                        int var22;
                        int var24;
                        int var26;
                        int var27;
                        int var28;
                        boolean var35;
                        int var37;
                        int var38;
                        int var40;
                        if(var9 == 1) {
                           var35 = class50.method1033(var5, var6, var10, var12);
                        } else if(var9 == 2) {
                           var17 = var5;
                           var18 = var6;
                           byte var19 = 64;
                           var20 = 64;
                           var21 = var5 - var19;
                           var22 = var6 - var20;
                           class109.field1930[var19][var20] = 99;
                           class109.field1924[var19][var20] = 0;
                           byte var23 = 0;
                           var24 = 0;
                           class109.field1927[var23] = var5;
                           var40 = var23 + 1;
                           class109.field1928[var23] = var6;
                           int[][] var25 = var12.flags;

                           boolean var36;
                           while(true) {
                              if(var24 == var40) {
                                 class109.field1921 = var17;
                                 class109.field1923 = var18;
                                 var36 = false;
                                 break;
                              }

                              var17 = class109.field1927[var24];
                              var18 = class109.field1928[var24];
                              var24 = 1 + var24 & 4095;
                              var37 = var17 - var21;
                              var38 = var18 - var22;
                              var26 = var17 - var12.x;
                              var27 = var18 - var12.y;
                              if(var11.vmethod2413(2, var17, var18, var12)) {
                                 class109.field1921 = var17;
                                 class109.field1923 = var18;
                                 var36 = true;
                                 break;
                              }

                              var28 = 1 + class109.field1924[var37][var38];
                              if(var37 > 0 && class109.field1930[var37 - 1][var38] == 0 && (var25[var26 - 1][var27] & 19136782) == 0 && (var25[var26 - 1][var27 + 1] & 19136824) == 0) {
                                 class109.field1927[var40] = var17 - 1;
                                 class109.field1928[var40] = var18;
                                 var40 = 1 + var40 & 4095;
                                 class109.field1930[var37 - 1][var38] = 2;
                                 class109.field1924[var37 - 1][var38] = var28;
                              }

                              if(var37 < 126 && class109.field1930[1 + var37][var38] == 0 && (var25[var26 + 2][var27] & 19136899) == 0 && (var25[2 + var26][var27 + 1] & 19136992) == 0) {
                                 class109.field1927[var40] = 1 + var17;
                                 class109.field1928[var40] = var18;
                                 var40 = var40 + 1 & 4095;
                                 class109.field1930[var37 + 1][var38] = 8;
                                 class109.field1924[1 + var37][var38] = var28;
                              }

                              if(var38 > 0 && class109.field1930[var37][var38 - 1] == 0 && (var25[var26][var27 - 1] & 19136782) == 0 && (var25[var26 + 1][var27 - 1] & 19136899) == 0) {
                                 class109.field1927[var40] = var17;
                                 class109.field1928[var40] = var18 - 1;
                                 var40 = var40 + 1 & 4095;
                                 class109.field1930[var37][var38 - 1] = 1;
                                 class109.field1924[var37][var38 - 1] = var28;
                              }

                              if(var38 < 126 && class109.field1930[var37][1 + var38] == 0 && (var25[var26][var27 + 2] & 19136824) == 0 && (var25[1 + var26][var27 + 2] & 19136992) == 0) {
                                 class109.field1927[var40] = var17;
                                 class109.field1928[var40] = var18 + 1;
                                 var40 = var40 + 1 & 4095;
                                 class109.field1930[var37][var38 + 1] = 4;
                                 class109.field1924[var37][var38 + 1] = var28;
                              }

                              if(var37 > 0 && var38 > 0 && class109.field1930[var37 - 1][var38 - 1] == 0 && (var25[var26 - 1][var27] & 19136830) == 0 && (var25[var26 - 1][var27 - 1] & 19136782) == 0 && (var25[var26][var27 - 1] & 19136911) == 0) {
                                 class109.field1927[var40] = var17 - 1;
                                 class109.field1928[var40] = var18 - 1;
                                 var40 = 1 + var40 & 4095;
                                 class109.field1930[var37 - 1][var38 - 1] = 3;
                                 class109.field1924[var37 - 1][var38 - 1] = var28;
                              }

                              if(var37 < 126 && var38 > 0 && class109.field1930[var37 + 1][var38 - 1] == 0 && (var25[1 + var26][var27 - 1] & 19136911) == 0 && (var25[2 + var26][var27 - 1] & 19136899) == 0 && (var25[var26 + 2][var27] & 19136995) == 0) {
                                 class109.field1927[var40] = var17 + 1;
                                 class109.field1928[var40] = var18 - 1;
                                 var40 = 1 + var40 & 4095;
                                 class109.field1930[var37 + 1][var38 - 1] = 9;
                                 class109.field1924[var37 + 1][var38 - 1] = var28;
                              }

                              if(var37 > 0 && var38 < 126 && class109.field1930[var37 - 1][1 + var38] == 0 && (var25[var26 - 1][1 + var27] & 19136830) == 0 && (var25[var26 - 1][var27 + 2] & 19136824) == 0 && (var25[var26][var27 + 2] & 19137016) == 0) {
                                 class109.field1927[var40] = var17 - 1;
                                 class109.field1928[var40] = 1 + var18;
                                 var40 = 1 + var40 & 4095;
                                 class109.field1930[var37 - 1][var38 + 1] = 6;
                                 class109.field1924[var37 - 1][1 + var38] = var28;
                              }

                              if(var37 < 126 && var38 < 126 && class109.field1930[var37 + 1][var38 + 1] == 0 && (var25[1 + var26][2 + var27] & 19137016) == 0 && (var25[var26 + 2][2 + var27] & 19136992) == 0 && (var25[var26 + 2][var27 + 1] & 19136995) == 0) {
                                 class109.field1927[var40] = 1 + var17;
                                 class109.field1928[var40] = var18 + 1;
                                 var40 = var40 + 1 & 4095;
                                 class109.field1930[var37 + 1][1 + var38] = 12;
                                 class109.field1924[1 + var37][var38 + 1] = var28;
                              }
                           }

                           var35 = var36;
                        } else {
                           var35 = class38.method772(var5, var6, var9, var10, var12);
                        }

                        int var8;
                        label517: {
                           var16 = var5 - 64;
                           var17 = var6 - 64;
                           var18 = class109.field1921;
                           var37 = class109.field1923;
                           if(!var35) {
                              var38 = Integer.MAX_VALUE;
                              var21 = Integer.MAX_VALUE;
                              byte var39 = 10;
                              var40 = var11.field1932;
                              var24 = var11.field1933;
                              int var34 = var11.field1934;
                              var26 = var11.field1935;

                              for(var27 = var40 - var39; var27 <= var40 + var39; ++var27) {
                                 for(var28 = var24 - var39; var28 <= var39 + var24; ++var28) {
                                    int var29 = var27 - var16;
                                    int var30 = var28 - var17;
                                    if(var29 >= 0 && var30 >= 0 && var29 < 128 && var30 < 128 && class109.field1924[var29][var30] < 100) {
                                       int var31 = 0;
                                       if(var27 < var40) {
                                          var31 = var40 - var27;
                                       } else if(var27 > var34 + var40 - 1) {
                                          var31 = var27 - (var40 + var34 - 1);
                                       }

                                       int var32 = 0;
                                       if(var28 < var24) {
                                          var32 = var24 - var28;
                                       } else if(var28 > var26 + var24 - 1) {
                                          var32 = var28 - (var26 + var24 - 1);
                                       }

                                       int var33 = var31 * var31 + var32 * var32;
                                       if(var33 < var38 || var33 == var38 && class109.field1924[var29][var30] < var21) {
                                          var38 = var33;
                                          var21 = class109.field1924[var29][var30];
                                          var18 = var27;
                                          var37 = var28;
                                       }
                                    }
                                 }
                              }

                              if(var38 == Integer.MAX_VALUE) {
                                 var8 = -1;
                                 break label517;
                              }
                           }

                           if(var5 == var18 && var37 == var6) {
                              var8 = 0;
                           } else {
                              var20 = 0;
                              class109.field1927[var20] = var18;
                              var38 = var20 + 1;
                              class109.field1928[var20] = var37;

                              for(var21 = var22 = class109.field1930[var18 - var16][var37 - var17]; var5 != var18 || var37 != var6; var21 = class109.field1930[var18 - var16][var37 - var17]) {
                                 if(var21 != var22) {
                                    var22 = var21;
                                    class109.field1927[var38] = var18;
                                    class109.field1928[var38++] = var37;
                                 }

                                 if((var21 & 2) != 0) {
                                    ++var18;
                                 } else if((var21 & 8) != 0) {
                                    --var18;
                                 }

                                 if((var21 & 1) != 0) {
                                    ++var37;
                                 } else if((var21 & 4) != 0) {
                                    --var37;
                                 }
                              }

                              var40 = 0;

                              while(var38-- > 0) {
                                 var13[var40] = class109.field1927[var38];
                                 var14[var40++] = class109.field1928[var38];
                                 if(var40 >= var13.length) {
                                    break;
                                 }
                              }

                              var8 = var40;
                           }
                        }

                        var15 = var8;
                        if(var8 < 1) {
                           break;
                        }

                        var16 = 0;

                        while(true) {
                           if(var16 >= var15 - 1) {
                              break label494;
                           }

                           var4.method43(Client.field581[var16], Client.field582[var16], (byte)2);
                           ++var16;
                        }
                     }

                     for(var16 = 0; var16 < 128; ++var16) {
                        class109.field1930[var15][var16] = 0;
                        class109.field1924[var15][var16] = 99999999;
                     }

                     ++var15;
                  }
               }
            }

            this.method43(var1, var2, var3);
         } else {
            this.method19(var1, var2);
         }
      } else {
         this.method19(var1, var2);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "945516926"
   )
   void method19(int var1, int var2) {
      super.field889 = 0;
      super.field894 = 0;
      super.field893 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method16();
      super.x = 128 * super.pathX[0] + 64 * var3;
      super.y = 64 * var3 + 128 * super.pathY[0];
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-401460243"
   )
   static final void method20(int var0, int var1, int var2, int var3) {
      Client.field396 = 0;
      boolean var4 = false;
      int var5 = -1;
      int var6 = class34.field779;
      int[] var7 = class34.field786;

      int var8;
      for(var8 = 0; var8 < Client.field341 + var6; ++var8) {
         Object var18;
         if(var8 < var6) {
            var18 = Client.cachedPlayers[var7[var8]];
            if(var7[var8] == Client.field432) {
               var4 = true;
               var5 = var8;
               continue;
            }
         } else {
            var18 = Client.cachedNPCs[Client.field342[var8 - var6]];
         }

         class59.method1266((Actor)var18, var8, var0, var1, var2, var3);
      }

      if(var4) {
         class59.method1266(Client.cachedPlayers[Client.field432], var5, var0, var1, var2, var3);
      }

      for(var8 = 0; var8 < Client.field396; ++var8) {
         int var9 = Client.field467[var8];
         int var10 = Client.field399[var8];
         int var11 = Client.field401[var8];
         int var12 = Client.field400[var8];
         boolean var13 = true;

         while(var13) {
            var13 = false;

            for(int var14 = 0; var14 < var8; ++var14) {
               if(2 + var10 > Client.field399[var14] - Client.field400[var14] && var10 - var12 < Client.field399[var14] + 2 && var9 - var11 < Client.field401[var14] + Client.field467[var14] && var11 + var9 > Client.field467[var14] - Client.field401[var14] && Client.field399[var14] - Client.field400[var14] < var10) {
                  var10 = Client.field399[var14] - Client.field400[var14];
                  var13 = true;
               }
            }
         }

         Client.field445 = Client.field467[var8];
         Client.field418 = Client.field399[var8] = var10;
         String var19 = Client.field405[var8];
         if(Client.field462 == 0) {
            int var15 = 16776960;
            if(Client.field565[var8] < 6) {
               var15 = Client.field517[Client.field565[var8]];
            }

            if(Client.field565[var8] == 6) {
               var15 = Client.field407 % 20 < 10?16711680:16776960;
            }

            if(Client.field565[var8] == 7) {
               var15 = Client.field407 % 20 < 10?255:'\uffff';
            }

            if(Client.field565[var8] == 8) {
               var15 = Client.field407 % 20 < 10?'뀀':8454016;
            }

            int var16;
            if(Client.field565[var8] == 9) {
               var16 = 150 - Client.field404[var8];
               if(var16 < 50) {
                  var15 = 16711680 + 1280 * var16;
               } else if(var16 < 100) {
                  var15 = 16776960 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = '\uff00' + (var16 - 100) * 5;
               }
            }

            if(Client.field565[var8] == 10) {
               var16 = 150 - Client.field404[var8];
               if(var16 < 50) {
                  var15 = var16 * 5 + 16711680;
               } else if(var16 < 100) {
                  var15 = 16711935 - 327680 * (var16 - 50);
               } else if(var16 < 150) {
                  var15 = 255 + (var16 - 100) * 327680 - 5 * (var16 - 100);
               }
            }

            if(Client.field565[var8] == 11) {
               var16 = 150 - Client.field404[var8];
               if(var16 < 50) {
                  var15 = 16777215 - 327685 * var16;
               } else if(var16 < 100) {
                  var15 = (var16 - 50) * 327685 + '\uff00';
               } else if(var16 < 150) {
                  var15 = 16777215 - 327680 * (var16 - 100);
               }
            }

            if(Client.field376[var8] == 0) {
               MessageNode.field811.method4070(var19, Client.field445 + var0, Client.field418 + var1, var15, 0);
            }

            if(Client.field376[var8] == 1) {
               MessageNode.field811.method4072(var19, Client.field445 + var0, var1 + Client.field418, var15, 0, Client.field407);
            }

            if(Client.field376[var8] == 2) {
               MessageNode.field811.method4073(var19, var0 + Client.field445, var1 + Client.field418, var15, 0, Client.field407);
            }

            if(Client.field376[var8] == 3) {
               MessageNode.field811.method4074(var19, var0 + Client.field445, Client.field418 + var1, var15, 0, Client.field407, 150 - Client.field404[var8]);
            }

            if(Client.field376[var8] == 4) {
               var16 = (150 - Client.field404[var8]) * (MessageNode.field811.method4062(var19) + 100) / 150;
               class82.method1828(var0 + Client.field445 - 50, var1, var0 + Client.field445 + 50, var1 + var3);
               MessageNode.field811.method4124(var19, 50 + var0 + Client.field445 - var16, Client.field418 + var1, var15, 0);
               class82.method1831(var0, var1, var0 + var2, var1 + var3);
            }

            if(Client.field376[var8] == 5) {
               var16 = 150 - Client.field404[var8];
               int var17 = 0;
               if(var16 < 25) {
                  var17 = var16 - 25;
               } else if(var16 > 125) {
                  var17 = var16 - 125;
               }

               class82.method1828(var0, Client.field418 + var1 - MessageNode.field811.field3243 - 1, var2 + var0, 5 + Client.field418 + var1);
               MessageNode.field811.method4070(var19, var0 + Client.field445, var17 + Client.field418 + var1, var15, 0);
               class82.method1831(var0, var1, var2 + var0, var1 + var3);
            }
         } else {
            MessageNode.field811.method4070(var19, var0 + Client.field445, Client.field418 + var1, 16776960, 0);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-270112451"
   )
   final boolean vmethod783() {
      return this.composition != null;
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2122000426"
   )
   static final void method35(int var0) {
      if(class14.method172(var0)) {
         WallObject.method2134(Widget.widgets[var0], -1);
      }
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-2056811198"
   )
   static final void method39(Widget var0, int var1, int var2) {
      if(null == Client.field473 && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var5 = var0;
            int var6 = class38.method779(Projectile.method96(var0));
            Widget var4;
            int var7;
            if(var6 == 0) {
               var4 = null;
            } else {
               var7 = 0;

               while(true) {
                  if(var7 >= var6) {
                     var4 = var5;
                     break;
                  }

                  var5 = class173.method3412(var5.parentId);
                  if(var5 == null) {
                     var4 = null;
                     break;
                  }

                  ++var7;
               }
            }

            Widget var8 = var4;
            if(null == var4) {
               var8 = var0.parent;
            }

            if(var8 != null) {
               Client.field473 = var0;
               var5 = var0;
               var6 = class38.method779(Projectile.method96(var0));
               if(var6 == 0) {
                  var4 = null;
               } else {
                  var7 = 0;

                  while(true) {
                     if(var7 >= var6) {
                        var4 = var5;
                        break;
                     }

                     var5 = class173.method3412(var5.parentId);
                     if(var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var7;
                  }
               }

               var8 = var4;
               if(null == var4) {
                  var8 = var0.parent;
               }

               Client.field474 = var8;
               Client.field475 = var1;
               Client.field512 = var2;
               class38.field826 = 0;
               Client.field484 = false;
               if(Client.menuOptionCount > 0) {
                  class28.method633(Client.menuOptionCount - 1);
               }

               return;
            }
         }

      }
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field38 = 0;
      this.totalLevel = 0;
      this.field41 = 0;
      this.field50 = false;
      this.team = 0;
      this.field45 = false;
      this.field55 = false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1859388374"
   )
   final void method43(int var1, int var2, byte var3) {
      if(super.field889 < 9) {
         ++super.field889;
      }

      for(int var4 = super.field889; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field850[var4] = super.field850[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field850[0] = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2136526701"
   )
   public static int method45(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1050401255"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class192.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field50 || super.idlePoseAnimation == super.poseAnimation && null != var1?null:class192.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3518(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method2335();
            super.field870 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field50 && super.graphic != -1 && super.field873 != -1) {
               var4 = Sequence.method929(super.graphic).method935(super.field873);
               if(null != var4) {
                  var4.method2345(0, -super.field876, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field50 && this.model != null) {
               if(Client.gameCycle >= this.field41) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field41) {
                  var4 = this.model;
                  var4.method2345(this.field59 - super.x, this.field44 - this.field39, this.field51 - super.y);
                  if(super.field886 == 512) {
                     var4.method2341();
                     var4.method2341();
                     var4.method2341();
                  } else if(super.field886 == 1024) {
                     var4.method2341();
                     var4.method2341();
                  } else if(super.field886 == 1536) {
                     var4.method2341();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field886 == 512) {
                     var4.method2341();
                  } else if(super.field886 == 1024) {
                     var4.method2341();
                     var4.method2341();
                  } else if(super.field886 == 1536) {
                     var4.method2341();
                     var4.method2341();
                     var4.method2341();
                  }

                  var4.method2345(super.x - this.field59, this.field39 - this.field44, super.y - this.field51);
               }
            }

            var3.field1881 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "110664029"
   )
   static String method47(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class164.field2691[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[1 + var4] & 255;
            var3.append(class164.field2691[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class164.field2691[(var6 & 15) << 2 | var7 >>> 6]).append(class164.field2691[var7 & 63]);
            } else {
               var3.append(class164.field2691[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class164.field2691[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IZZZB)Lclass171;",
      garbageValue = "47"
   )
   static class171 method48(int var0, boolean var1, boolean var2, boolean var3) {
      class137 var4 = null;
      if(class152.field2286 != null) {
         var4 = new class137(var0, class152.field2286, class118.field2025[var0], 1000000);
      }

      return new class171(var4, class56.field1221, var0, var1, var2, var3);
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-890272683"
   )
   static final void method49() {
      class32.method673(Client.field473);
      ++class38.field826;
      if(Client.field585 && Client.field478) {
         int var0 = class143.field2204;
         int var1 = class143.field2206;
         var0 -= Client.field475;
         var1 -= Client.field512;
         if(var0 < Client.field479) {
            var0 = Client.field479;
         }

         if(Client.field473.width + var0 > Client.field479 + Client.field474.width) {
            var0 = Client.field479 + Client.field474.width - Client.field473.width;
         }

         if(var1 < Client.field324) {
            var1 = Client.field324;
         }

         if(Client.field473.height + var1 > Client.field324 + Client.field474.height) {
            var1 = Client.field474.height + Client.field324 - Client.field473.height;
         }

         int var2 = var0 - Client.field482;
         int var3 = var1 - Client.field447;
         int var4 = Client.field473.field2907;
         if(class38.field826 > Client.field473.field2924 && (var2 > var4 || var2 < -var4 || var3 > var4 || var3 < -var4)) {
            Client.field484 = true;
         }

         int var5 = Client.field474.itemId + (var0 - Client.field479);
         int var6 = var1 - Client.field324 + Client.field474.scrollY;
         class0 var7;
         if(Client.field473.field2891 != null && Client.field484) {
            var7 = new class0();
            var7.field13 = Client.field473;
            var7.field3 = var5;
            var7.field4 = var6;
            var7.field8 = Client.field473.field2891;
            class12.method155(var7);
         }

         if(class143.field2203 == 0) {
            if(Client.field484) {
               if(Client.field473.field2892 != null) {
                  var7 = new class0();
                  var7.field13 = Client.field473;
                  var7.field3 = var5;
                  var7.field4 = var6;
                  var7.field6 = Client.field460;
                  var7.field8 = Client.field473.field2892;
                  class12.method155(var7);
               }

               if(null != Client.field460) {
                  Widget var8 = Client.field473;
                  int var9 = class38.method779(Projectile.method96(var8));
                  Widget var11;
                  if(var9 == 0) {
                     var11 = null;
                  } else {
                     int var10 = 0;

                     while(true) {
                        if(var10 >= var9) {
                           var11 = var8;
                           break;
                        }

                        var8 = class173.method3412(var8.parentId);
                        if(null == var8) {
                           var11 = null;
                           break;
                        }

                        ++var10;
                     }
                  }

                  if(null != var11) {
                     Client.field378.method2801(201);
                     Client.field378.method2656(Client.field460.id);
                     Client.field378.method2610(Client.field473.id);
                     Client.field378.method2672(Client.field460.item);
                     Client.field378.method2577(Client.field473.item);
                     Client.field378.method2672(Client.field473.index);
                     Client.field378.method2577(Client.field460.index);
                  }
               }
            } else if((Client.field440 == 1 || TextureProvider.method2237(Client.menuOptionCount - 1)) && Client.menuOptionCount > 2) {
               ChatMessages.method235(Client.field475 + Client.field482, Client.field512 + Client.field447);
            } else if(Client.menuOptionCount > 0) {
               Frames.method2327(Client.field475 + Client.field482, Client.field447 + Client.field512);
            }

            Client.field473 = null;
         }

      } else {
         if(class38.field826 > 1) {
            Client.field473 = null;
         }

      }
   }
}
