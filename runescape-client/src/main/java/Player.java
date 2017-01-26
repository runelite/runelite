import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1256463213
   )
   int field238;
   @ObfuscatedName("g")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1958314245
   )
   @Export("skullIcon")
   int skullIcon = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -840102489
   )
   @Export("overheadIcon")
   int overheadIcon = -1;
   @ObfuscatedName("k")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2109794939
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1614854139
   )
   int field244;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2132669391
   )
   int field245;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1549390549
   )
   int field247;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -529102085
   )
   int field248;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = -1271737423
   )
   static int field249;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1686246645
   )
   int field250;
   @ObfuscatedName("u")
   @Export("model")
   Model model;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 334715487
   )
   int field252;
   @ObfuscatedName("ed")
   static SpritePixels[] field253;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 968451973
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 823214427
   )
   int field255;
   @ObfuscatedName("y")
   boolean field256;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -651846451
   )
   @Export("team")
   int team;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -427294581
   )
   int field258;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1681823997
   )
   int field259;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -593083599
   )
   int field260;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1762062101
   )
   int field261;
   @ObfuscatedName("b")
   boolean field262;
   @ObfuscatedName("p")
   @Export("name")
   String name;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1662120295
   )
   int field264;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 702097275
   )
   int field265;
   @ObfuscatedName("f")
   boolean field266;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-695377719"
   )
   final void method220(Buffer var1) {
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
               int var8 = class36.getItemDefinition(var4[var5] - 512).team;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= PlayerComposition.field2171[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field598 = var1.readUnsignedShort();
      if(super.field598 == '\uffff') {
         super.field598 = -1;
      }

      super.field599 = super.field598;
      super.field600 = var1.readUnsignedShort();
      if(super.field600 == '\uffff') {
         super.field600 = -1;
      }

      super.field601 = var1.readUnsignedShort();
      if(super.field601 == '\uffff') {
         super.field601 = -1;
      }

      super.field602 = var1.readUnsignedShort();
      if(super.field602 == '\uffff') {
         super.field602 = -1;
      }

      super.field603 = var1.readUnsignedShort();
      if(super.field603 == '\uffff') {
         super.field603 = -1;
      }

      super.field604 = var1.readUnsignedShort();
      if(super.field604 == '\uffff') {
         super.field604 = -1;
      }

      this.name = var1.method2846();
      if(class16.localPlayer == this) {
         class101.field1653 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field244 = var1.readUnsignedShort();
      this.field266 = var1.readUnsignedByte() == 1;
      if(Client.field424 == 0 && Client.field327 >= 2) {
         this.field266 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3156(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2079075920"
   )
   int method221() {
      return this.composition != null && this.composition.field2174 != -1?Tile.getNpcDefinition(this.composition.field2174).field2999:1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2063755858"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class146.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field256 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:class146.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3126(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method1602();
            super.field642 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field256 && super.graphic != -1 && super.field630 != -1) {
               var4 = TextureProvider.method1452(super.graphic).method3456(super.field630);
               if(null != var4) {
                  var4.method1590(0, -super.field633, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field256 && this.model != null) {
               if(Client.gameCycle >= this.field247) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field247) {
                  var4 = this.model;
                  var4.method1590(this.field248 - super.x, this.field261 - this.field238, this.field250 - super.y);
                  if(super.field643 == 512) {
                     var4.method1568();
                     var4.method1568();
                     var4.method1568();
                  } else if(super.field643 == 1024) {
                     var4.method1568();
                     var4.method1568();
                  } else if(super.field643 == 1536) {
                     var4.method1568();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field643 == 512) {
                     var4.method1568();
                  } else if(super.field643 == 1024) {
                     var4.method1568();
                     var4.method1568();
                  } else if(super.field643 == 1536) {
                     var4.method1568();
                     var4.method1568();
                     var4.method1568();
                  }

                  var4.method1590(super.x - this.field248, this.field238 - this.field261, super.y - this.field250);
               }
            }

            var3.field1380 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-22"
   )
   public static boolean method223(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1234512612"
   )
   void method224(int var1, int var2) {
      super.field646 = 0;
      super.field651 = 0;
      super.field627 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method221();
      super.x = 128 * super.pathX[0] + var3 * 64;
      super.y = 64 * var3 + 128 * super.pathY[0];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-94"
   )
   final boolean vmethod702() {
      return null != this.composition;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-36"
   )
   final void method228(int var1, int var2, byte var3) {
      if(super.field646 < 9) {
         ++super.field646;
      }

      for(int var4 = super.field646; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field649[var4] = super.field649[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field649[0] = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "970166141"
   )
   public static void method242() {
      class227.field3230 = new CombatInfoList();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1290794630"
   )
   final void method247(int var1, int var2, byte var3) {
      if(super.animation != -1 && class146.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field620 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.method221();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var9 = this.method221();
                  Client.field556.field1858 = var1;
                  Client.field556.field1856 = var2;
                  Client.field556.field1857 = 1;
                  Client.field556.field1860 = 1;
                  class22 var10 = Client.field556;
                  class22 var11 = var10;
                  CollisionData var12 = Client.collisionMaps[this.field259];
                  int[] var13 = Client.field557;
                  int[] var14 = Client.field558;
                  int var15 = 0;

                  label501:
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
                           var35 = class187.method3427(var5, var6, var10, var12);
                        } else if(var9 == 2) {
                           var17 = var5;
                           var18 = var6;
                           byte var19 = 64;
                           var20 = 64;
                           var21 = var5 - var19;
                           var22 = var6 - var20;
                           class118.field1847[var19][var20] = 99;
                           class118.field1848[var19][var20] = 0;
                           byte var23 = 0;
                           var24 = 0;
                           class118.field1849[var23] = var5;
                           var40 = var23 + 1;
                           class118.field1850[var23] = var6;
                           int[][] var25 = var12.flags;

                           boolean var36;
                           while(true) {
                              if(var24 == var40) {
                                 class149.field2039 = var17;
                                 class20.field208 = var18;
                                 var36 = false;
                                 break;
                              }

                              var17 = class118.field1849[var24];
                              var18 = class118.field1850[var24];
                              var24 = 1 + var24 & 4095;
                              var37 = var17 - var21;
                              var38 = var18 - var22;
                              var26 = var17 - var12.x;
                              var27 = var18 - var12.y;
                              if(var11.vmethod2300(2, var17, var18, var12)) {
                                 class149.field2039 = var17;
                                 class20.field208 = var18;
                                 var36 = true;
                                 break;
                              }

                              var28 = 1 + class118.field1848[var37][var38];
                              if(var37 > 0 && class118.field1847[var37 - 1][var38] == 0 && (var25[var26 - 1][var27] & 19136782) == 0 && (var25[var26 - 1][1 + var27] & 19136824) == 0) {
                                 class118.field1849[var40] = var17 - 1;
                                 class118.field1850[var40] = var18;
                                 var40 = var40 + 1 & 4095;
                                 class118.field1847[var37 - 1][var38] = 2;
                                 class118.field1848[var37 - 1][var38] = var28;
                              }

                              if(var37 < 126 && class118.field1847[1 + var37][var38] == 0 && (var25[2 + var26][var27] & 19136899) == 0 && (var25[2 + var26][var27 + 1] & 19136992) == 0) {
                                 class118.field1849[var40] = var17 + 1;
                                 class118.field1850[var40] = var18;
                                 var40 = var40 + 1 & 4095;
                                 class118.field1847[var37 + 1][var38] = 8;
                                 class118.field1848[var37 + 1][var38] = var28;
                              }

                              if(var38 > 0 && class118.field1847[var37][var38 - 1] == 0 && (var25[var26][var27 - 1] & 19136782) == 0 && (var25[1 + var26][var27 - 1] & 19136899) == 0) {
                                 class118.field1849[var40] = var17;
                                 class118.field1850[var40] = var18 - 1;
                                 var40 = var40 + 1 & 4095;
                                 class118.field1847[var37][var38 - 1] = 1;
                                 class118.field1848[var37][var38 - 1] = var28;
                              }

                              if(var38 < 126 && class118.field1847[var37][var38 + 1] == 0 && (var25[var26][var27 + 2] & 19136824) == 0 && (var25[var26 + 1][2 + var27] & 19136992) == 0) {
                                 class118.field1849[var40] = var17;
                                 class118.field1850[var40] = var18 + 1;
                                 var40 = var40 + 1 & 4095;
                                 class118.field1847[var37][1 + var38] = 4;
                                 class118.field1848[var37][1 + var38] = var28;
                              }

                              if(var37 > 0 && var38 > 0 && class118.field1847[var37 - 1][var38 - 1] == 0 && (var25[var26 - 1][var27] & 19136830) == 0 && (var25[var26 - 1][var27 - 1] & 19136782) == 0 && (var25[var26][var27 - 1] & 19136911) == 0) {
                                 class118.field1849[var40] = var17 - 1;
                                 class118.field1850[var40] = var18 - 1;
                                 var40 = var40 + 1 & 4095;
                                 class118.field1847[var37 - 1][var38 - 1] = 3;
                                 class118.field1848[var37 - 1][var38 - 1] = var28;
                              }

                              if(var37 < 126 && var38 > 0 && class118.field1847[1 + var37][var38 - 1] == 0 && (var25[var26 + 1][var27 - 1] & 19136911) == 0 && (var25[2 + var26][var27 - 1] & 19136899) == 0 && (var25[2 + var26][var27] & 19136995) == 0) {
                                 class118.field1849[var40] = 1 + var17;
                                 class118.field1850[var40] = var18 - 1;
                                 var40 = 1 + var40 & 4095;
                                 class118.field1847[var37 + 1][var38 - 1] = 9;
                                 class118.field1848[var37 + 1][var38 - 1] = var28;
                              }

                              if(var37 > 0 && var38 < 126 && class118.field1847[var37 - 1][var38 + 1] == 0 && (var25[var26 - 1][var27 + 1] & 19136830) == 0 && (var25[var26 - 1][var27 + 2] & 19136824) == 0 && (var25[var26][2 + var27] & 19137016) == 0) {
                                 class118.field1849[var40] = var17 - 1;
                                 class118.field1850[var40] = 1 + var18;
                                 var40 = 1 + var40 & 4095;
                                 class118.field1847[var37 - 1][1 + var38] = 6;
                                 class118.field1848[var37 - 1][1 + var38] = var28;
                              }

                              if(var37 < 126 && var38 < 126 && class118.field1847[var37 + 1][var38 + 1] == 0 && (var25[1 + var26][2 + var27] & 19137016) == 0 && (var25[var26 + 2][var27 + 2] & 19136992) == 0 && (var25[var26 + 2][1 + var27] & 19136995) == 0) {
                                 class118.field1849[var40] = var17 + 1;
                                 class118.field1850[var40] = 1 + var18;
                                 var40 = var40 + 1 & 4095;
                                 class118.field1847[var37 + 1][var38 + 1] = 12;
                                 class118.field1848[1 + var37][var38 + 1] = var28;
                              }
                           }

                           var35 = var36;
                        } else {
                           var35 = FileOnDisk.method1425(var5, var6, var9, var10, var12);
                        }

                        int var8;
                        label524: {
                           var16 = var5 - 64;
                           var17 = var6 - 64;
                           var18 = class149.field2039;
                           var37 = class20.field208;
                           if(!var35) {
                              var38 = Integer.MAX_VALUE;
                              var21 = Integer.MAX_VALUE;
                              byte var39 = 10;
                              var40 = var11.field1858;
                              var24 = var11.field1856;
                              int var34 = var11.field1857;
                              var26 = var11.field1860;

                              for(var27 = var40 - var39; var27 <= var40 + var39; ++var27) {
                                 for(var28 = var24 - var39; var28 <= var39 + var24; ++var28) {
                                    int var29 = var27 - var16;
                                    int var30 = var28 - var17;
                                    if(var29 >= 0 && var30 >= 0 && var29 < 128 && var30 < 128 && class118.field1848[var29][var30] < 100) {
                                       int var31 = 0;
                                       if(var27 < var40) {
                                          var31 = var40 - var27;
                                       } else if(var27 > var34 + var40 - 1) {
                                          var31 = var27 - (var40 + var34 - 1);
                                       }

                                       int var32 = 0;
                                       if(var28 < var24) {
                                          var32 = var24 - var28;
                                       } else if(var28 > var24 + var26 - 1) {
                                          var32 = var28 - (var26 + var24 - 1);
                                       }

                                       int var33 = var32 * var32 + var31 * var31;
                                       if(var33 < var38 || var33 == var38 && class118.field1848[var29][var30] < var21) {
                                          var38 = var33;
                                          var21 = class118.field1848[var29][var30];
                                          var18 = var27;
                                          var37 = var28;
                                       }
                                    }
                                 }
                              }

                              if(var38 == Integer.MAX_VALUE) {
                                 var8 = -1;
                                 break label524;
                              }
                           }

                           if(var18 == var5 && var37 == var6) {
                              var8 = 0;
                           } else {
                              var20 = 0;
                              class118.field1849[var20] = var18;
                              var38 = var20 + 1;
                              class118.field1850[var20] = var37;

                              for(var21 = var22 = class118.field1847[var18 - var16][var37 - var17]; var5 != var18 || var37 != var6; var21 = class118.field1847[var18 - var16][var37 - var17]) {
                                 if(var22 != var21) {
                                    var22 = var21;
                                    class118.field1849[var38] = var18;
                                    class118.field1850[var38++] = var37;
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
                                 var13[var40] = class118.field1849[var38];
                                 var14[var40++] = class118.field1850[var38];
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
                              break label501;
                           }

                           var4.method228(Client.field557[var16], Client.field558[var16], (byte)2);
                           ++var16;
                        }
                     }

                     for(var16 = 0; var16 < 128; ++var16) {
                        class118.field1847[var15][var16] = 0;
                        class118.field1848[var15][var16] = 99999999;
                     }

                     ++var15;
                  }
               }
            }

            this.method228(var1, var2, var3);
         } else {
            this.method224(var1, var2);
         }
      } else {
         this.method224(var1, var2);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2022514651"
   )
   static void method248() {
      Client.field289 = -1L;
      Client.field292 = -1;
      class45.field901.field210 = 0;
      class177.field2668 = true;
      Client.field293 = true;
      Client.field503 = -1L;
      method242();
      Client.field394.offset = 0;
      Client.field323.offset = 0;
      Client.packetOpcode = -1;
      Client.field328 = -1;
      Client.field400 = -1;
      Client.field330 = -1;
      Client.field326 = 0;
      Client.field295 = 0;
      Client.field331 = 0;
      Client.field407 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      class115.mouseIdleTicks = 0;
      class47.chatLineMap.clear();
      class47.field928.method2329();
      class47.field929.method2478();
      class47.field934 = 0;
      Client.field429 = 0;
      Client.field432 = false;
      Client.field370 = 0;
      Client.field362 = (int)(Math.random() * 100.0D) - 50;
      Client.field344 = (int)(Math.random() * 110.0D) - 55;
      Client.field346 = (int)(Math.random() * 80.0D) - 40;
      Client.mapScale = (int)(Math.random() * 120.0D) - 60;
      Client.mapScaleDelta = (int)(Math.random() * 30.0D) - 20;
      Client.mapAngle = (int)(Math.random() * 20.0D) - 10 & 2047;
      Client.field513 = 0;
      Client.field506 = -1;
      Client.flagX = 0;
      Client.flagY = 0;
      Client.field307 = class40.field808;
      Client.field305 = class40.field808;
      Client.field316 = 0;
      class45.field898 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         class45.field897[var0] = null;
         class45.field910[var0] = 1;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < '耀'; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field336 = -1;
      Client.projectiles.method2405();
      Client.field412.method2405();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(int var5 = 0; var5 < 104; ++var5) {
               Client.groundItemDeque[var0][var1][var5] = null;
            }
         }
      }

      Client.field410 = new Deque();
      Client.field545 = 0;
      Client.friendCount = 0;
      Client.ignoreCount = 0;

      for(var0 = 0; var0 < class187.field2770; ++var0) {
         class187 var2 = (class187)class187.field2772.get((long)var0);
         class187 var4;
         if(var2 != null) {
            var4 = var2;
         } else {
            byte[] var3 = class187.field2775.getConfigData(16, var0);
            var2 = new class187();
            if(null != var3) {
               var2.method3421(new Buffer(var3));
            }

            class187.field2772.put(var2, (long)var0);
            var4 = var2;
         }

         if(var4 != null) {
            class165.settings[var0] = 0;
            class165.widgetSettings[var0] = 0;
         }
      }

      Tile.chatMessages.method827();
      Client.field445 = -1;
      if(Client.widgetRoot != -1) {
         class103.method1972(Client.widgetRoot);
      }

      for(WidgetNode var6 = (WidgetNode)Client.componentTable.method2361(); var6 != null; var6 = (WidgetNode)Client.componentTable.method2369()) {
         class9.method117(var6, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new XHashTable(8);
      Client.field441 = null;
      Client.isMenuOpen = false;
      Client.menuOptionCount = 0;
      Client.field550.method3156((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriority[var0] = false;
      }

      XItemContainer.itemContainers = new XHashTable(32);
      Client.field385 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field482[var0] = true;
      }

      class167.method3159();
      Client.field504 = null;
      class10.clanChatCount = 0;
      Renderable.clanMembers = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new XGrandExchangeOffer();
      }

      class168.field2184 = null;
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field244 = 0;
      this.totalLevel = 0;
      this.field247 = 0;
      this.field256 = false;
      this.team = 0;
      this.field266 = false;
      this.field262 = false;
   }
}
