import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1891429867
   )
   int field247;
   @ObfuscatedName("v")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -883851697
   )
   @Export("skullIcon")
   int skullIcon = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 223422907
   )
   @Export("overheadIcon")
   int overheadIcon = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 162151291
   )
   int field251;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 667200829
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("m")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -743575815
   )
   int field254;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1179928321
   )
   int field255;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2040026037
   )
   int field256;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 550753055
   )
   int field257;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1828914631
   )
   int field258;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 697435611
   )
   int field259;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 201452837
   )
   int field260;
   @ObfuscatedName("p")
   @Export("model")
   Model model;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1825160219
   )
   int field262;
   @ObfuscatedName("o")
   @Export("name")
   String name;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1354484237
   )
   int field264;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -758348241
   )
   int field265;
   @ObfuscatedName("w")
   boolean field266;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1972911309
   )
   @Export("team")
   int team;
   @ObfuscatedName("q")
   boolean field268;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1390291957
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("rk")
   protected static boolean field270;
   @ObfuscatedName("a")
   boolean field271;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -409769807
   )
   int field272;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1058792357
   )
   int field273;
   @ObfuscatedName("ew")
   static SpritePixels[] field274;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1650735754"
   )
   final void method210(Buffer var1) {
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
               int var8 = class137.getItemDefinition(var4[var5] - 512).field2986;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class119.field1867[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field646 = var1.readUnsignedShort();
      if(super.field646 == '\uffff') {
         super.field646 = -1;
      }

      super.field610 = super.field646;
      super.field624 = var1.readUnsignedShort();
      if(super.field624 == '\uffff') {
         super.field624 = -1;
      }

      super.field640 = var1.readUnsignedShort();
      if(super.field640 == '\uffff') {
         super.field640 = -1;
      }

      super.field615 = var1.readUnsignedShort();
      if(super.field615 == '\uffff') {
         super.field615 = -1;
      }

      super.field648 = var1.readUnsignedShort();
      if(super.field648 == '\uffff') {
         super.field648 = -1;
      }

      super.field611 = var1.readUnsignedShort();
      if(super.field611 == '\uffff') {
         super.field611 = -1;
      }

      this.name = var1.method2780();
      if(class5.localPlayer == this) {
         class101.field1649 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field254 = var1.readUnsignedShort();
      this.field268 = var1.readUnsignedByte() == 1;
      if(Client.field428 == 0 && Client.field451 >= 2) {
         this.field268 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3060(var4, var9, var2 == 1, var3);
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field254 = 0;
      this.totalLevel = 0;
      this.field257 = 0;
      this.field266 = false;
      this.team = 0;
      this.field268 = false;
      this.field271 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-12"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class31.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field266 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:class31.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3067(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method1521();
            super.field634 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field266 && super.graphic != -1 && super.field642 != -1) {
               var4 = NPCComposition.method3645(super.graphic).method3387(super.field642);
               if(null != var4) {
                  var4.method1536(0, -super.field654, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field266 && null != this.model) {
               if(Client.gameCycle >= this.field257) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field257) {
                  var4 = this.model;
                  var4.method1536(this.field258 - super.x, this.field259 - this.field255, this.field260 - super.y);
                  if(super.field655 == 512) {
                     var4.method1532();
                     var4.method1532();
                     var4.method1532();
                  } else if(super.field655 == 1024) {
                     var4.method1532();
                     var4.method1532();
                  } else if(super.field655 == 1536) {
                     var4.method1532();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field655 == 512) {
                     var4.method1532();
                  } else if(super.field655 == 1024) {
                     var4.method1532();
                     var4.method1532();
                  } else if(super.field655 == 1536) {
                     var4.method1532();
                     var4.method1532();
                     var4.method1532();
                  }

                  var4.method1536(super.x - this.field258, this.field255 - this.field259, super.y - this.field260);
               }
            }

            var3.field1357 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "937098350"
   )
   final void method212(int var1, int var2, byte var3) {
      if(super.animation != -1 && class31.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field614 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.method227();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var9 = this.method227();
                  class119 var10 = CombatInfoListHolder.method678(var1, var2);
                  CollisionData var11 = Client.collisionMaps[this.field256];
                  int[] var12 = Client.field564;
                  int[] var13 = Client.field565;
                  int var14 = 0;

                  label442:
                  while(true) {
                     int var15;
                     if(var14 >= 128) {
                        int var16;
                        int var17;
                        byte var19;
                        int var20;
                        int var21;
                        int var23;
                        int var25;
                        int var26;
                        int var27;
                        boolean var34;
                        int var36;
                        int var37;
                        int var39;
                        if(var9 == 1) {
                           var16 = var5;
                           var17 = var6;
                           byte var18 = 64;
                           var19 = 64;
                           var20 = var5 - var18;
                           var21 = var6 - var19;
                           class118.field1855[var18][var19] = 99;
                           class118.field1856[var18][var19] = 0;
                           byte var22 = 0;
                           var23 = 0;
                           class118.field1853[var22] = var5;
                           var39 = var22 + 1;
                           class118.field1859[var22] = var6;
                           int[][] var24 = var11.flags;

                           boolean var35;
                           while(true) {
                              if(var39 == var23) {
                                 class118.field1863 = var16;
                                 class168.field2197 = var17;
                                 var35 = false;
                                 break;
                              }

                              var16 = class118.field1853[var23];
                              var17 = class118.field1859[var23];
                              var23 = 1 + var23 & 4095;
                              var36 = var16 - var20;
                              var37 = var17 - var21;
                              var25 = var16 - var11.x;
                              var26 = var17 - var11.y;
                              if(var10.vmethod2239(1, var16, var17, var11)) {
                                 class118.field1863 = var16;
                                 class168.field2197 = var17;
                                 var35 = true;
                                 break;
                              }

                              var27 = class118.field1856[var36][var37] + 1;
                              if(var36 > 0 && class118.field1855[var36 - 1][var37] == 0 && (var24[var25 - 1][var26] & 19136776) == 0) {
                                 class118.field1853[var39] = var16 - 1;
                                 class118.field1859[var39] = var17;
                                 var39 = 1 + var39 & 4095;
                                 class118.field1855[var36 - 1][var37] = 2;
                                 class118.field1856[var36 - 1][var37] = var27;
                              }

                              if(var36 < 127 && class118.field1855[1 + var36][var37] == 0 && (var24[var25 + 1][var26] & 19136896) == 0) {
                                 class118.field1853[var39] = 1 + var16;
                                 class118.field1859[var39] = var17;
                                 var39 = 1 + var39 & 4095;
                                 class118.field1855[var36 + 1][var37] = 8;
                                 class118.field1856[var36 + 1][var37] = var27;
                              }

                              if(var37 > 0 && class118.field1855[var36][var37 - 1] == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                                 class118.field1853[var39] = var16;
                                 class118.field1859[var39] = var17 - 1;
                                 var39 = var39 + 1 & 4095;
                                 class118.field1855[var36][var37 - 1] = 1;
                                 class118.field1856[var36][var37 - 1] = var27;
                              }

                              if(var37 < 127 && class118.field1855[var36][1 + var37] == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                                 class118.field1853[var39] = var16;
                                 class118.field1859[var39] = var17 + 1;
                                 var39 = 1 + var39 & 4095;
                                 class118.field1855[var36][1 + var37] = 4;
                                 class118.field1856[var36][var37 + 1] = var27;
                              }

                              if(var36 > 0 && var37 > 0 && class118.field1855[var36 - 1][var37 - 1] == 0 && (var24[var25 - 1][var26 - 1] & 19136782) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                                 class118.field1853[var39] = var16 - 1;
                                 class118.field1859[var39] = var17 - 1;
                                 var39 = var39 + 1 & 4095;
                                 class118.field1855[var36 - 1][var37 - 1] = 3;
                                 class118.field1856[var36 - 1][var37 - 1] = var27;
                              }

                              if(var36 < 127 && var37 > 0 && class118.field1855[1 + var36][var37 - 1] == 0 && (var24[1 + var25][var26 - 1] & 19136899) == 0 && (var24[1 + var25][var26] & 19136896) == 0 && (var24[var25][var26 - 1] & 19136770) == 0) {
                                 class118.field1853[var39] = var16 + 1;
                                 class118.field1859[var39] = var17 - 1;
                                 var39 = var39 + 1 & 4095;
                                 class118.field1855[1 + var36][var37 - 1] = 9;
                                 class118.field1856[var36 + 1][var37 - 1] = var27;
                              }

                              if(var36 > 0 && var37 < 127 && class118.field1855[var36 - 1][1 + var37] == 0 && (var24[var25 - 1][var26 + 1] & 19136824) == 0 && (var24[var25 - 1][var26] & 19136776) == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                                 class118.field1853[var39] = var16 - 1;
                                 class118.field1859[var39] = var17 + 1;
                                 var39 = var39 + 1 & 4095;
                                 class118.field1855[var36 - 1][var37 + 1] = 6;
                                 class118.field1856[var36 - 1][1 + var37] = var27;
                              }

                              if(var36 < 127 && var37 < 127 && class118.field1855[var36 + 1][1 + var37] == 0 && (var24[1 + var25][1 + var26] & 19136992) == 0 && (var24[var25 + 1][var26] & 19136896) == 0 && (var24[var25][var26 + 1] & 19136800) == 0) {
                                 class118.field1853[var39] = var16 + 1;
                                 class118.field1859[var39] = var17 + 1;
                                 var39 = 1 + var39 & 4095;
                                 class118.field1855[1 + var36][var37 + 1] = 12;
                                 class118.field1856[var36 + 1][var37 + 1] = var27;
                              }
                           }

                           var34 = var35;
                        } else if(var9 == 2) {
                           var34 = Projectile.method776(var5, var6, var10, var11);
                        } else {
                           var34 = class60.method1133(var5, var6, var9, var10, var11);
                        }

                        int var8;
                        label465: {
                           var15 = var5 - 64;
                           var16 = var6 - 64;
                           var17 = class118.field1863;
                           var36 = class168.field2197;
                           if(!var34) {
                              var37 = Integer.MAX_VALUE;
                              var20 = Integer.MAX_VALUE;
                              byte var38 = 10;
                              var39 = var10.field1871;
                              var23 = var10.field1865;
                              int var33 = var10.field1866;
                              var25 = var10.field1870;

                              for(var26 = var39 - var38; var26 <= var39 + var38; ++var26) {
                                 for(var27 = var23 - var38; var27 <= var38 + var23; ++var27) {
                                    int var28 = var26 - var15;
                                    int var29 = var27 - var16;
                                    if(var28 >= 0 && var29 >= 0 && var28 < 128 && var29 < 128 && class118.field1856[var28][var29] < 100) {
                                       int var30 = 0;
                                       if(var26 < var39) {
                                          var30 = var39 - var26;
                                       } else if(var26 > var39 + var33 - 1) {
                                          var30 = var26 - (var39 + var33 - 1);
                                       }

                                       int var31 = 0;
                                       if(var27 < var23) {
                                          var31 = var23 - var27;
                                       } else if(var27 > var23 + var25 - 1) {
                                          var31 = var27 - (var23 + var25 - 1);
                                       }

                                       int var32 = var31 * var31 + var30 * var30;
                                       if(var32 < var37 || var32 == var37 && class118.field1856[var28][var29] < var20) {
                                          var37 = var32;
                                          var20 = class118.field1856[var28][var29];
                                          var17 = var26;
                                          var36 = var27;
                                       }
                                    }
                                 }
                              }

                              if(var37 == Integer.MAX_VALUE) {
                                 var8 = -1;
                                 break label465;
                              }
                           }

                           if(var5 == var17 && var6 == var36) {
                              var8 = 0;
                           } else {
                              var19 = 0;
                              class118.field1853[var19] = var17;
                              var37 = var19 + 1;
                              class118.field1859[var19] = var36;

                              for(var20 = var21 = class118.field1855[var17 - var15][var36 - var16]; var5 != var17 || var36 != var6; var20 = class118.field1855[var17 - var15][var36 - var16]) {
                                 if(var20 != var21) {
                                    var21 = var20;
                                    class118.field1853[var37] = var17;
                                    class118.field1859[var37++] = var36;
                                 }

                                 if((var20 & 2) != 0) {
                                    ++var17;
                                 } else if((var20 & 8) != 0) {
                                    --var17;
                                 }

                                 if((var20 & 1) != 0) {
                                    ++var36;
                                 } else if((var20 & 4) != 0) {
                                    --var36;
                                 }
                              }

                              var39 = 0;

                              while(var37-- > 0) {
                                 var12[var39] = class118.field1853[var37];
                                 var13[var39++] = class118.field1859[var37];
                                 if(var39 >= var12.length) {
                                    break;
                                 }
                              }

                              var8 = var39;
                           }
                        }

                        var14 = var8;
                        if(var8 < 1) {
                           break;
                        }

                        var15 = 0;

                        while(true) {
                           if(var15 >= var14 - 1) {
                              break label442;
                           }

                           var4.method222(Client.field564[var15], Client.field565[var15], (byte)2);
                           ++var15;
                        }
                     }

                     for(var15 = 0; var15 < 128; ++var15) {
                        class118.field1855[var14][var15] = 0;
                        class118.field1856[var14][var15] = 99999999;
                     }

                     ++var14;
                  }
               }
            }

            this.method222(var1, var2, var3);
         } else {
            this.method213(var1, var2);
         }
      } else {
         this.method213(var1, var2);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1668964394"
   )
   void method213(int var1, int var2) {
      super.field656 = 0;
      super.field663 = 0;
      super.field662 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method227();
      super.x = 128 * super.pathX[0] + var3 * 64;
      super.y = 64 * var3 + 128 * super.pathY[0];
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-240648388"
   )
   final boolean vmethod702() {
      return this.composition != null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "688335790"
   )
   public static boolean method220(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1613852076"
   )
   public static int method221(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIBS)V",
      garbageValue = "-8275"
   )
   final void method222(int var1, int var2, byte var3) {
      if(super.field656 < 9) {
         ++super.field656;
      }

      for(int var4 = super.field656; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field661[var4] = super.field661[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field661[0] = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-701454758"
   )
   int method227() {
      return null != this.composition && this.composition.field2181 != -1?class30.getNpcDefinition(this.composition.field2181).field2999:1;
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "55"
   )
   static final boolean method229(Widget var0) {
      if(var0.field2320 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2320.length; ++var1) {
            int var2 = method235(var0, var1);
            int var3 = var0.field2321[var1];
            if(var0.field2320[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2320[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2320[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "1906419568"
   )
   static final void method230(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(null != var3.children) {
                  method230(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2299((long)var3.id);
               if(null != var4) {
                  XGrandExchangeOffer.method45(var4.id, var1);
               }
            }

            class18 var5;
            if(var1 == 0 && null != var3.field2314) {
               var5 = new class18();
               var5.field193 = var3;
               var5.field203 = var3.field2314;
               class13.method165(var5);
            }

            if(var1 == 1 && null != var3.field2255) {
               if(var3.index >= 0) {
                  Widget var6 = class174.method3178(var3.id);
                  if(null == var6 || null == var6.children || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new class18();
               var5.field193 = var3;
               var5.field203 = var3.field2255;
               class13.method165(var5);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "385989685"
   )
   public static void method232() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         ++class105.keyboardIdleTicks;
         class105.field1723 = class105.field1696;
         class105.field1722 = 0;
         int var1;
         if(class105.field1709 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class105.field1728[var1] = false;
            }

            class105.field1709 = class105.field1701;
         } else {
            while(class105.field1709 != class105.field1701) {
               var1 = class105.field1716[class105.field1701];
               class105.field1701 = 1 + class105.field1701 & 127;
               if(var1 < 0) {
                  class105.field1728[~var1] = false;
               } else {
                  if(!class105.field1728[var1] && class105.field1722 < class105.field1721.length - 1) {
                     class105.field1721[++class105.field1722 - 1] = var1;
                  }

                  class105.field1728[var1] = true;
               }
            }
         }

         class105.field1696 = class105.field1724;
      }
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "2043915208"
   )
   static final void method234(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3 && var1 == var3.parentId && (!var3.field2204 || !class8.method90(var3))) {
            if(var3.type == 0) {
               if(!var3.field2204 && class8.method90(var3) && class22.field245 != var3) {
                  continue;
               }

               method234(var0, var3.id);
               if(null != var3.children) {
                  method234(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.method2299((long)var3.id);
               if(var7 != null) {
                  class63.method1145(var7.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2254 != -1 || var3.field2240 != -1) {
                  boolean var4 = method229(var3);
                  if(var4) {
                     var5 = var3.field2240;
                  } else {
                     var5 = var3.field2254;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class31.getAnimation(var5);

                     for(var3.field2226 += Client.field363; var3.field2226 > var6.frameLenghts[var3.field2329]; class97.method1886(var3)) {
                        var3.field2226 -= var6.frameLenghts[var3.field2329];
                        ++var3.field2329;
                        if(var3.field2329 >= var6.frameIDs.length) {
                           var3.field2329 -= var6.frameStep;
                           if(var3.field2329 < 0 || var3.field2329 >= var6.frameIDs.length) {
                              var3.field2329 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2263 != 0 && !var3.field2204) {
                  int var8 = var3.field2263 >> 16;
                  var5 = var3.field2263 << 16 >> 16;
                  var8 *= Client.field363;
                  var5 *= Client.field363;
                  var3.rotationX = var3.rotationX + var8 & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class97.method1886(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(LWidget;IS)I",
      garbageValue = "469"
   )
   static final int method235(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class174.method3178(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class137.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == var11 + 1) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class165.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class172.field2355[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class165.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class5.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class172.field2356[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class174.method3178(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class137.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(1 + var11 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class165.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = XItemContainer.method161(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class5.localPlayer.x >> 7) + class107.baseX;
               }

               if(var6 == 19) {
                  var7 = XClanMember.baseY + (class5.localPlayer.y >> 7);
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
