import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("a")
   @Export("name")
   String name;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1669295901
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 226773847
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("z")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 959498037
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1522787423
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1016917927
   )
   int field816;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -313979289
   )
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 897531569
   )
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -329293921
   )
   int field809;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 971165739
   )
   int field830;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1200111513
   )
   int field820;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lef;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1216559807
   )
   int field823;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -453113441
   )
   int field824;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1742103697
   )
   int field825;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1305677901
   )
   int field828;
   @ObfuscatedName("m")
   @Export("isLowDetail")
   boolean isLowDetail;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -558926455
   )
   @Export("team")
   int team;
   @ObfuscatedName("b")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2074693389
   )
   int field821;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 267119691
   )
   int field810;
   @ObfuscatedName("v")
   boolean field814;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 263360251
   )
   int field833;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1728433121
   )
   int field834;

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.animationCycleStart = 0;
      this.animationCycleEnd = 0;
      this.isLowDetail = false;
      this.team = 0;
      this.hidden = false;
      this.field814 = false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgh;B)V",
      garbageValue = "13"
   )
   @Export("decodeApperance")
   final void decodeApperance(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.readUnsignedByte();
      this.skullIcon = var1.readByte();
      this.overheadIcon = var1.readByte();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.readUnsignedByte();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.readUnsignedByte();
            var4[var5] = var7 + (var6 << 8);
            if(var5 == 0 && var4[0] == 65535) {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = KitDefinition.getItemDefinition(var4[var5] - 512).int1;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= PlayerComposition.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == 65535) {
         super.idlePoseAnimation = -1;
      }

      super.field1128 = var1.readUnsignedShort();
      if(super.field1128 == 65535) {
         super.field1128 = -1;
      }

      super.field1176 = super.field1128;
      super.field1139 = var1.readUnsignedShort();
      if(super.field1139 == 65535) {
         super.field1139 = -1;
      }

      super.field1131 = var1.readUnsignedShort();
      if(super.field1131 == 65535) {
         super.field1131 = -1;
      }

      super.field1132 = var1.readUnsignedShort();
      if(super.field1132 == 65535) {
         super.field1132 = -1;
      }

      super.field1123 = var1.readUnsignedShort();
      if(super.field1123 == 65535) {
         super.field1123 = -1;
      }

      super.field1130 = var1.readUnsignedShort();
      if(super.field1130 == 65535) {
         super.field1130 = -1;
      }

      this.name = var1.readString();
      if(this == UrlRequest.localPlayer) {
         RunException.localPlayerName = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.totalLevel = var1.readUnsignedShort();
      this.hidden = var1.readUnsignedByte() == 1;
      if(Client.socketType == 0 && Client.rights >= 2) {
         this.hidden = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method4104(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1842965601"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?Client.getNpcDefinition(this.composition.transformedNpcId).field3620:1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lef;",
      garbageValue = "620909653"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?Permission.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.isLowDetail && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?Permission.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.field1136 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.isLowDetail && super.graphic != -1 && super.field1160 != -1) {
               var4 = class250.getSpotAnimType(super.graphic).getModel(super.field1160);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1163, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.isLowDetail && this.model != null) {
               if(Client.gameCycle >= this.animationCycleEnd) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.animationCycleStart && Client.gameCycle < this.animationCycleEnd) {
                  var4 = this.model;
                  var4.offsetBy(this.field809 - super.x, this.field830 - this.field816, this.field820 - super.y);
                  if(super.orientation == 512) {
                     var4.rotateY90Ccw();
                     var4.rotateY90Ccw();
                     var4.rotateY90Ccw();
                  } else if(super.orientation == 1024) {
                     var4.rotateY90Ccw();
                     var4.rotateY90Ccw();
                  } else if(super.orientation == 1536) {
                     var4.rotateY90Ccw();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.rotateY90Ccw();
                  } else if(super.orientation == 1024) {
                     var4.rotateY90Ccw();
                     var4.rotateY90Ccw();
                  } else if(super.orientation == 1536) {
                     var4.rotateY90Ccw();
                     var4.rotateY90Ccw();
                     var4.rotateY90Ccw();
                  }

                  var4.offsetBy(super.x - this.field809, this.field816 - this.field830, super.y - this.field820);
               }
            }

            var3.field1851 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-46"
   )
   final void method1085(int var1, int var2, byte var3) {
      if(super.animation != -1 && Permission.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1150 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.getSize();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var9 = this.getSize();
                  Client.field1104.field2223 = var1;
                  Client.field1104.field2224 = var2;
                  Client.field1104.field2225 = 1;
                  Client.field1104.field2227 = 1;
                  class72 var10 = Client.field1104;
                  class72 var11 = var10;
                  CollisionData var12 = Client.collisionMaps[this.field821];
                  int[] var13 = Client.field1105;
                  int[] var14 = Client.field1106;
                  int var15 = 0;

                  label548:
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
                        int var29;
                        boolean var35;
                        int var37;
                        int var38;
                        int var40;
                        if(var9 == 1) {
                           var35 = GameObjectTransformMetadata.method1542(var5, var6, var10, var12);
                        } else if(var9 == 2) {
                           var35 = class82.method1564(var5, var6, var10, var12);
                        } else {
                           var17 = var5;
                           var18 = var6;
                           byte var19 = 64;
                           var20 = 64;
                           var21 = var5 - var19;
                           var22 = var6 - var20;
                           class167.field2218[var19][var20] = 99;
                           class167.field2216[var19][var20] = 0;
                           byte var23 = 0;
                           var24 = 0;
                           class167.field2220[var23] = var5;
                           var40 = var23 + 1;
                           class167.field2221[var23] = var6;
                           int[][] var34 = var12.flags;

                           boolean var36;
                           label534:
                           while(true) {
                              label532:
                              while(true) {
                                 do {
                                    do {
                                       do {
                                          label509:
                                          do {
                                             if(var40 == var24) {
                                                class167.field2217 = var17;
                                                class167.field2215 = var18;
                                                var36 = false;
                                                break label534;
                                             }

                                             var17 = class167.field2220[var24];
                                             var18 = class167.field2221[var24];
                                             var24 = var24 + 1 & 4095;
                                             var37 = var17 - var21;
                                             var38 = var18 - var22;
                                             var26 = var17 - var12.x;
                                             var27 = var18 - var12.y;
                                             if(var11.vmethod3167(var9, var17, var18, var12)) {
                                                class167.field2217 = var17;
                                                class167.field2215 = var18;
                                                var36 = true;
                                                break label534;
                                             }

                                             var28 = class167.field2216[var37][var38] + 1;
                                             if(var37 > 0 && class167.field2218[var37 - 1][var38] == 0 && (var34[var26 - 1][var27] & 19136782) == 0 && (var34[var26 - 1][var9 + var27 - 1] & 19136824) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9 - 1) {
                                                      class167.field2220[var40] = var17 - 1;
                                                      class167.field2221[var40] = var18;
                                                      var40 = var40 + 1 & 4095;
                                                      class167.field2218[var37 - 1][var38] = 2;
                                                      class167.field2216[var37 - 1][var38] = var28;
                                                      break;
                                                   }

                                                   if((var34[var26 - 1][var27 + var29] & 19136830) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var37 < 128 - var9 && class167.field2218[var37 + 1][var38] == 0 && (var34[var26 + var9][var27] & 19136899) == 0 && (var34[var9 + var26][var9 + var27 - 1] & 19136992) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9 - 1) {
                                                      class167.field2220[var40] = var17 + 1;
                                                      class167.field2221[var40] = var18;
                                                      var40 = var40 + 1 & 4095;
                                                      class167.field2218[var37 + 1][var38] = 8;
                                                      class167.field2216[var37 + 1][var38] = var28;
                                                      break;
                                                   }

                                                   if((var34[var26 + var9][var29 + var27] & 19136995) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var38 > 0 && class167.field2218[var37][var38 - 1] == 0 && (var34[var26][var27 - 1] & 19136782) == 0 && (var34[var9 + var26 - 1][var27 - 1] & 19136899) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9 - 1) {
                                                      class167.field2220[var40] = var17;
                                                      class167.field2221[var40] = var18 - 1;
                                                      var40 = var40 + 1 & 4095;
                                                      class167.field2218[var37][var38 - 1] = 1;
                                                      class167.field2216[var37][var38 - 1] = var28;
                                                      break;
                                                   }

                                                   if((var34[var26 + var29][var27 - 1] & 19136911) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var38 < 128 - var9 && class167.field2218[var37][var38 + 1] == 0 && (var34[var26][var9 + var27] & 19136824) == 0 && (var34[var26 + var9 - 1][var27 + var9] & 19136992) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9 - 1) {
                                                      class167.field2220[var40] = var17;
                                                      class167.field2221[var40] = var18 + 1;
                                                      var40 = var40 + 1 & 4095;
                                                      class167.field2218[var37][var38 + 1] = 4;
                                                      class167.field2216[var37][var38 + 1] = var28;
                                                      break;
                                                   }

                                                   if((var34[var26 + var29][var9 + var27] & 19137016) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var37 > 0 && var38 > 0 && class167.field2218[var37 - 1][var38 - 1] == 0 && (var34[var26 - 1][var27 - 1] & 19136782) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9) {
                                                      class167.field2220[var40] = var17 - 1;
                                                      class167.field2221[var40] = var18 - 1;
                                                      var40 = var40 + 1 & 4095;
                                                      class167.field2218[var37 - 1][var38 - 1] = 3;
                                                      class167.field2216[var37 - 1][var38 - 1] = var28;
                                                      break;
                                                   }

                                                   if((var34[var26 - 1][var29 + (var27 - 1)] & 19136830) != 0 || (var34[var29 + (var26 - 1)][var27 - 1] & 19136911) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var37 < 128 - var9 && var38 > 0 && class167.field2218[var37 + 1][var38 - 1] == 0 && (var34[var9 + var26][var27 - 1] & 19136899) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9) {
                                                      class167.field2220[var40] = var17 + 1;
                                                      class167.field2221[var40] = var18 - 1;
                                                      var40 = var40 + 1 & 4095;
                                                      class167.field2218[var37 + 1][var38 - 1] = 9;
                                                      class167.field2216[var37 + 1][var38 - 1] = var28;
                                                      break;
                                                   }

                                                   if((var34[var9 + var26][var29 + (var27 - 1)] & 19136995) != 0 || (var34[var26 + var29][var27 - 1] & 19136911) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var37 > 0 && var38 < 128 - var9 && class167.field2218[var37 - 1][var38 + 1] == 0 && (var34[var26 - 1][var9 + var27] & 19136824) == 0) {
                                                for(var29 = 1; var29 < var9; ++var29) {
                                                   if((var34[var26 - 1][var29 + var27] & 19136830) != 0 || (var34[var29 + (var26 - 1)][var9 + var27] & 19137016) != 0) {
                                                      continue label509;
                                                   }
                                                }

                                                class167.field2220[var40] = var17 - 1;
                                                class167.field2221[var40] = var18 + 1;
                                                var40 = var40 + 1 & 4095;
                                                class167.field2218[var37 - 1][var38 + 1] = 6;
                                                class167.field2216[var37 - 1][var38 + 1] = var28;
                                             }
                                          } while(var37 >= 128 - var9);
                                       } while(var38 >= 128 - var9);
                                    } while(class167.field2218[var37 + 1][var38 + 1] != 0);
                                 } while((var34[var9 + var26][var27 + var9] & 19136992) != 0);

                                 for(var29 = 1; var29 < var9; ++var29) {
                                    if((var34[var26 + var29][var27 + var9] & 19137016) != 0 || (var34[var9 + var26][var27 + var29] & 19136995) != 0) {
                                       continue label532;
                                    }
                                 }

                                 class167.field2220[var40] = var17 + 1;
                                 class167.field2221[var40] = var18 + 1;
                                 var40 = var40 + 1 & 4095;
                                 class167.field2218[var37 + 1][var38 + 1] = 12;
                                 class167.field2216[var37 + 1][var38 + 1] = var28;
                              }
                           }

                           var35 = var36;
                        }

                        int var8;
                        label587: {
                           var16 = var5 - 64;
                           var17 = var6 - 64;
                           var18 = class167.field2217;
                           var37 = class167.field2215;
                           if(!var35) {
                              var38 = Integer.MAX_VALUE;
                              var21 = Integer.MAX_VALUE;
                              byte var39 = 10;
                              var40 = var11.field2223;
                              var24 = var11.field2224;
                              int var25 = var11.field2225;
                              var26 = var11.field2227;

                              for(var27 = var40 - var39; var27 <= var39 + var40; ++var27) {
                                 for(var28 = var24 - var39; var28 <= var39 + var24; ++var28) {
                                    var29 = var27 - var16;
                                    int var30 = var28 - var17;
                                    if(var29 >= 0 && var30 >= 0 && var29 < 128 && var30 < 128 && class167.field2216[var29][var30] < 100) {
                                       int var31 = 0;
                                       if(var27 < var40) {
                                          var31 = var40 - var27;
                                       } else if(var27 > var25 + var40 - 1) {
                                          var31 = var27 - (var40 + var25 - 1);
                                       }

                                       int var32 = 0;
                                       if(var28 < var24) {
                                          var32 = var24 - var28;
                                       } else if(var28 > var26 + var24 - 1) {
                                          var32 = var28 - (var26 + var24 - 1);
                                       }

                                       int var33 = var32 * var32 + var31 * var31;
                                       if(var33 < var38 || var38 == var33 && class167.field2216[var29][var30] < var21) {
                                          var38 = var33;
                                          var21 = class167.field2216[var29][var30];
                                          var18 = var27;
                                          var37 = var28;
                                       }
                                    }
                                 }
                              }

                              if(var38 == Integer.MAX_VALUE) {
                                 var8 = -1;
                                 break label587;
                              }
                           }

                           if(var5 == var18 && var6 == var37) {
                              var8 = 0;
                           } else {
                              var20 = 0;
                              class167.field2220[var20] = var18;
                              var38 = var20 + 1;
                              class167.field2221[var20] = var37;

                              for(var21 = var22 = class167.field2218[var18 - var16][var37 - var17]; var5 != var18 || var6 != var37; var21 = class167.field2218[var18 - var16][var37 - var17]) {
                                 if(var21 != var22) {
                                    var22 = var21;
                                    class167.field2220[var38] = var18;
                                    class167.field2221[var38++] = var37;
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
                                 var13[var40] = class167.field2220[var38];
                                 var14[var40++] = class167.field2221[var38];
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
                              break label548;
                           }

                           var4.method1083(Client.field1105[var16], Client.field1106[var16], (byte)2);
                           ++var16;
                        }
                     }

                     for(var16 = 0; var16 < 128; ++var16) {
                        class167.field2218[var15][var16] = 0;
                        class167.field2216[var15][var16] = 99999999;
                     }

                     ++var15;
                  }
               }
            }

            this.method1083(var1, var2, var3);
         } else {
            this.method1082(var1, var2);
         }
      } else {
         this.method1082(var1, var2);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "1109"
   )
   void method1082(int var1, int var2) {
      super.queueSize = 0;
      super.field1155 = 0;
      super.field1180 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "29"
   )
   final void method1083(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.pathTraversed[var4] = super.pathTraversed[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.pathTraversed[0] = var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "591771192"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)[Ljr;",
      garbageValue = "13"
   )
   static class268[] method1077() {
      return new class268[]{class268.field3613, class268.field3615, class268.field3614};
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1397219471"
   )
   static final int method1100(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ldy;B)V",
      garbageValue = "104"
   )
   static final void method1078(TaskDataNode var0) {
      var0.field1614 = false;
      if(var0.field1613 != null) {
         var0.field1613.int1 = 0;
      }

      for(TaskDataNode var1 = var0.vmethod4041(); var1 != null; var1 = var0.vmethod4040()) {
         method1078(var1);
      }

   }

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(IZZZB)Liu;",
      garbageValue = "1"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class157.dat2File != null) {
         var4 = new IndexFile(var0, class157.dat2File, class157.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, class56.indexStore255, var0, var1, var2, var3);
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1700563033"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[BoundingBox2D.plane][var0][var1];
      if(var2 == null) {
         class48.region.removeGroundItemPile(BoundingBox2D.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = KitDefinition.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class48.region.removeGroundItemPile(BoundingBox2D.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var5.id != var6.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class48.region.addItemPile(BoundingBox2D.plane, var0, var1, WorldMapType2.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, BoundingBox2D.plane), var5, var9, var11, var10);
         }
      }
   }
}
