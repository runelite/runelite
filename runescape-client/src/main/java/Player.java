import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1918051385
   )
   int field889;
   @ObfuscatedName("u")
   boolean field890;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1115145067
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("y")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1235196161
   )
   int field894;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 360299197
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2125267409
   )
   int field896;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1106611327
   )
   int field897;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -854816313
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1406428753
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 283394689
   )
   int field900;
   @ObfuscatedName("c")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1946460325
   )
   int field902;
   @ObfuscatedName("j")
   @Export("model")
   Model model;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2098886037
   )
   int field904;
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1442141733
   )
   int field906;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1290577993
   )
   int field907;
   @ObfuscatedName("s")
   boolean field908;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 511038533
   )
   @Export("team")
   int team;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2067942215
   )
   int field910;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -260729225
   )
   int field911;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 400727543
   )
   int field912;
   @ObfuscatedName("w")
   boolean field913;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1102787243
   )
   int field914;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1043701717
   )
   int field915;
   @ObfuscatedName("ml")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("en")
   static RSSocket field917;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2030762499"
   )
   final boolean vmethod1691() {
      return this.composition != null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1602009063"
   )
   final void method1116(Buffer var1) {
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
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = Buffer.getItemDefinition(var4[var5] - 512).field3530;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= PlayerComposition.field2627[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field1248 = var1.readUnsignedShort();
      if(super.field1248 == '\uffff') {
         super.field1248 = -1;
      }

      super.field1249 = super.field1248;
      super.field1242 = var1.readUnsignedShort();
      if(super.field1242 == '\uffff') {
         super.field1242 = -1;
      }

      super.field1299 = var1.readUnsignedShort();
      if(super.field1299 == '\uffff') {
         super.field1299 = -1;
      }

      super.field1288 = var1.readUnsignedShort();
      if(super.field1288 == '\uffff') {
         super.field1288 = -1;
      }

      super.field1253 = var1.readUnsignedShort();
      if(super.field1253 == '\uffff') {
         super.field1253 = -1;
      }

      super.field1254 = var1.readUnsignedShort();
      if(super.field1254 == '\uffff') {
         super.field1254 = -1;
      }

      this.name = var1.readString();
      if(World.localPlayer == this) {
         class152.field2238 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field896 = var1.readUnsignedShort();
      this.field913 = var1.readUnsignedByte() == 1;
      if(Client.field931 == 0 && Client.field1097 >= 2) {
         this.field913 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3936(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1142403874"
   )
   final void method1119(int var1, int var2, byte var3) {
      if(super.animation != -1 && class227.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1270 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class35.method477(this, var1, var2, (byte)2);
            }

            this.method1126(var1, var2, var3);
         } else {
            this.method1120(var1, var2);
         }
      } else {
         this.method1120(var1, var2);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "972681602"
   )
   void method1120(int var1, int var2) {
      super.field1263 = 0;
      super.field1301 = 0;
      super.field1300 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method1131();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LRegion;[LCollisionData;I)V",
      garbageValue = "551340467"
   )
   static final void method1122(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class61.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class61.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method3023(var3, var4);
                  }
               }
            }
         }
      }

      class61.field772 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field772 < -8) {
         class61.field772 = -8;
      }

      if(class61.field772 > 8) {
         class61.field772 = 8;
      }

      class61.field773 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field773 < -16) {
         class61.field773 = -16;
      }

      if(class61.field773 > 16) {
         class61.field773 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = class47.field605[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class61.tileHeights[var2][var12 + 1][var11] - class61.tileHeights[var2][var12 - 1][var11];
               var14 = class61.tileHeights[var2][var12][var11 + 1] - class61.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var14 * var14 + var13 * var13 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var18 * -50 + var16 * -50 + var17 * -10) / var10 + 96;
               var20 = (var42[var12][var11] >> 1) + (var42[var12][var11 + 1] >> 3) + (var42[var12 - 1][var11] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 - 1] >> 2);
               Friend.field819[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class61.field762[var11] = 0;
            class61.field763[var11] = 0;
            class215.field2637[var11] = 0;
            class61.field764[var11] = 0;
            class61.field756[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class61.underlayIds[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = class37.method488(var14 - 1);
                     class61.field762[var12] += var43.field3337;
                     class61.field763[var12] += var43.field3341;
                     class215.field2637[var12] += var43.field3343;
                     class61.field764[var12] += var43.field3342;
                     ++class61.field756[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class61.underlayIds[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = class37.method488(var15 - 1);
                     class61.field762[var12] -= var44.field3337;
                     class61.field763[var12] -= var44.field3341;
                     class215.field2637[var12] -= var44.field3343;
                     class61.field764[var12] -= var44.field3342;
                     --class61.field756[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class61.field762[var18];
                     var13 += class61.field763[var18];
                     var14 += class215.field2637[var18];
                     var15 += class61.field764[var18];
                     var16 += class61.field756[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class61.field762[var19];
                     var13 -= class61.field763[var19];
                     var14 -= class215.field2637[var19];
                     var15 -= class61.field764[var19];
                     var16 -= class61.field756[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.field1046 || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field757) {
                        class61.field757 = var2;
                     }

                     var20 = class61.underlayIds[var2][var11][var17] & 255;
                     int var21 = class61.overlayIds[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = Friend.field819[var11][var17];
                        int var27 = Friend.field819[var11 + 1][var17];
                        int var28 = Friend.field819[var11 + 1][var17 + 1];
                        int var29 = Friend.field819[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class17.method108(var32, var33, var34);
                           var32 = class61.field772 + var32 & 255;
                           var34 += class61.field773;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class17.method108(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var46 = true;
                           if(var20 == 0 && class61.overlayPaths[var2][var11][var17] != 0) {
                              var46 = false;
                           }

                           if(var21 > 0 && !class44.method604(var21 - 1).isHidden) {
                              var46 = false;
                           }

                           if(var46 && var23 == var22 && var22 == var24 && var25 == var22) {
                              class47.field607[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = class136.colorPalette[Renderable.method2857(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.method2679(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, Renderable.method2857(var30, var26), Renderable.method2857(var30, var27), Renderable.method2857(var30, var28), Renderable.method2857(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = class61.overlayPaths[var2][var11][var17] + 1;
                           byte var47 = class13.overlayRotations[var2][var11][var17];
                           Overlay var35 = class44.method604(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = class136.field2049.vmethod2887(var36);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class17.method108(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class61.field772 & 255;
                              var40 = var35.lightness + class61.field773;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class17.method108(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = class136.colorPalette[class13.method63(var38, 96)];
                           }

                           if(var35.field3582 != -1) {
                              var40 = class61.field772 + var35.field3591 & 255;
                              int var41 = class61.field773 + var35.field3585;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class17.method108(var40, var35.field3592, var41);
                              var39 = class136.colorPalette[class13.method63(var38, 96)];
                           }

                           var0.method2679(var2, var11, var17, var33, var47, var36, var22, var23, var24, var25, Renderable.method2857(var30, var26), Renderable.method2857(var30, var27), Renderable.method2857(var30, var28), Renderable.method2857(var30, var29), class13.method63(var37, var26), class13.method63(var37, var27), class13.method63(var37, var28), class13.method63(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.method2678(var2, var12, var11, CombatInfo1.method1539(var2, var12, var11));
            }
         }

         class61.underlayIds[var2] = null;
         class61.overlayIds[var2] = null;
         class61.overlayPaths[var2] = null;
         class13.overlayRotations[var2] = null;
         class47.field605[var2] = null;
      }

      var0.method2705(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class61.tileSettings[1][var2][var3] & 2) == 2) {
               var0.method2676(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var45;
                  if((class47.field607[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class47.field607[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class47.field607[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label523:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class47.field607[var11 - 1][var8][var13] & var2) == 0) {
                              break label523;
                           }
                        }

                        --var11;
                     }

                     label512:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class47.field607[var12 + 1][var8][var13] & var2) == 0) {
                              break label512;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var8][var9] - var45;
                        var16 = class61.tileHeights[var11][var8][var9];
                        Region.method2677(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class47.field607[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class47.field607[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class47.field607[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class47.field607[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label576:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class47.field607[var11 - 1][var13][var7] & var3) == 0) {
                              break label576;
                           }
                        }

                        --var11;
                     }

                     label565:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class47.field607[var12 + 1][var13][var7] & var3) == 0) {
                              break label565;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var9][var7] - var45;
                        var16 = class61.tileHeights[var11][var9][var7];
                        Region.method2677(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class47.field607[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class47.field607[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class47.field607[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class47.field607[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label629:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class47.field607[var6][var9 - 1][var13] & var4) == 0) {
                              break label629;
                           }
                        }

                        --var9;
                     }

                     label618:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class47.field607[var6][var10 + 1][var13] & var4) == 0) {
                              break label618;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.method2677(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class47.field607[var6][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1333480971"
   )
   final void method1126(int var1, int var2, byte var3) {
      if(super.field1263 < 9) {
         ++super.field1263;
      }

      for(int var4 = super.field1263; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1257[var4] = super.field1257[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1257[0] = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-929540873"
   )
   int method1131() {
      return this.composition != null && this.composition.field2620 != -1?class220.getNpcDefinition(this.composition.field2620).field3577:1;
   }

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field896 = 0;
      this.totalLevel = 0;
      this.field902 = 0;
      this.field908 = false;
      this.team = 0;
      this.field913 = false;
      this.field890 = false;
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "-1"
   )
   static final void method1134(Actor var0) {
      if(Client.gameCycle == var0.field1289 || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field1260 + 1 > class227.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field1289 - var0.field1250;
         int var2 = Client.gameCycle - var0.field1250;
         int var3 = var0.field1284 * 128 + var0.field1268 * 64;
         int var4 = var0.field1268 * 64 + var0.field1286 * 128;
         int var5 = var0.field1285 * 128 + var0.field1268 * 64;
         int var6 = var0.field1287 * 128 + var0.field1268 * 64;
         var0.x = (var2 * var5 + var3 * (var1 - var2)) / var1;
         var0.y = (var4 * (var1 - var2) + var2 * var6) / var1;
      }

      var0.field1300 = 0;
      var0.field1259 = var0.field1290;
      var0.angle = var0.field1259;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2096882887"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class227.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field908 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?class227.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3942(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2496();
            super.field1292 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field908 && super.graphic != -1 && super.field1280 != -1) {
               var4 = CombatInfo1.method1542(super.graphic).method4341(super.field1280);
               if(var4 != null) {
                  var4.method2513(0, -super.field1302, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field908 && this.model != null) {
               if(Client.gameCycle >= this.field902) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field902) {
                  var4 = this.model;
                  var4.method2513(this.field900 - super.x, this.field894 - this.field897, this.field910 - super.y);
                  if(super.field1259 == 512) {
                     var4.method2502();
                     var4.method2502();
                     var4.method2502();
                  } else if(super.field1259 == 1024) {
                     var4.method2502();
                     var4.method2502();
                  } else if(super.field1259 == 1536) {
                     var4.method2502();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field1259 == 512) {
                     var4.method2502();
                  } else if(super.field1259 == 1024) {
                     var4.method2502();
                     var4.method2502();
                  } else if(super.field1259 == 1536) {
                     var4.method2502();
                     var4.method2502();
                     var4.method2502();
                  }

                  var4.method2513(super.x - this.field900, this.field897 - this.field894, super.y - this.field910);
               }
            }

            var3.field1987 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-17"
   )
   static int method1136(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.method1861();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2040472984"
   )
   static int method1138(int var0, int var1) {
      Overlay var2 = class44.method604(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.field3582 >= 0) {
         return var2.field3582 | -16777216;
      } else {
         int var4;
         int var5;
         if(var2.texture >= 0) {
            var4 = class136.field2049.vmethod2887(var2.texture);
            byte var11 = 96;
            int var3;
            if(var4 == -2) {
               var3 = 12345678;
            } else if(var4 == -1) {
               if(var11 < 0) {
                  var11 = 0;
               } else if(var11 > 127) {
                  var11 = 127;
               }

               var5 = 127 - var11;
               var3 = var5;
            } else {
               var5 = var11 * (var4 & 127) / 128;
               if(var5 < 2) {
                  var5 = 2;
               } else if(var5 > 126) {
                  var5 = 126;
               }

               var3 = (var4 & 'ﾀ') + var5;
            }

            return class136.colorPalette[var3] | -16777216;
         } else if(var2.color == 16711935) {
            return var1;
         } else {
            var4 = var2.hue;
            var5 = var2.saturation;
            int var6 = var2.lightness;
            if(var6 > 179) {
               var5 /= 2;
            }

            if(var6 > 192) {
               var5 /= 2;
            }

            if(var6 > 217) {
               var5 /= 2;
            }

            if(var6 > 243) {
               var5 /= 2;
            }

            int var7 = (var4 / 4 << 10) + (var5 / 32 << 7) + var6 / 2;
            byte var9 = 96;
            int var8;
            if(var7 == -2) {
               var8 = 12345678;
            } else {
               int var12;
               if(var7 == -1) {
                  if(var9 < 0) {
                     var9 = 0;
                  } else if(var9 > 127) {
                     var9 = 127;
                  }

                  var12 = 127 - var9;
                  var8 = var12;
               } else {
                  var12 = (var7 & 127) * var9 / 128;
                  if(var12 < 2) {
                     var12 = 2;
                  } else if(var12 > 126) {
                     var12 = 126;
                  }

                  var8 = (var7 & 'ﾀ') + var12;
               }
            }

            return class136.colorPalette[var8] | -16777216;
         }
      }
   }
}
