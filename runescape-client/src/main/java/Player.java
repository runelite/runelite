import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("la")
   @ObfuscatedSignature(
      signature = "[Lhg;"
   )
   static Widget[] field906;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 1115729757
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 856666731
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1966920445
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("p")
   boolean field898;
   @ObfuscatedName("k")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 921274159
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2014821629
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 22134949
   )
   @Export("team")
   int team;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -716148891
   )
   int field883;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1780569101
   )
   int field881;
   @ObfuscatedName("b")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("j")
   boolean field902;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -394451839
   )
   int field889;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1936928009
   )
   int field890;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 97470401
   )
   int field886;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -380985533
   )
   int field900;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -196907383
   )
   int field891;
   @ObfuscatedName("e")
   @Export("name")
   String name;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -501501335
   )
   int field896;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 36608337
   )
   int field888;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1746856691
   )
   int field901;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1434378129
   )
   int field903;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1259972723
   )
   int field894;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 323426395
   )
   int field879;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1158280361
   )
   int field887;

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.field883 = 0;
      this.field881 = 0;
      this.field898 = false;
      this.team = 0;
      this.hidden = false;
      this.field902 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lew;",
      garbageValue = "-2113451941"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?Ignore.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field898 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:Ignore.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3976(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2519();
            super.field1255 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field898 && super.graphic != -1 && super.field1209 != -1) {
               var4 = GameEngine.getSpotAnimType(super.graphic).method4337(super.field1209);
               if(var4 != null) {
                  var4.method2526(0, -super.field1265, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field898 && this.model != null) {
               if(Client.gameCycle >= this.field881) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field883 && Client.gameCycle < this.field881) {
                  var4 = this.model;
                  var4.method2526(this.field889 - super.x, this.field890 - this.field886, this.field891 - super.y);
                  if(super.orientation == 512) {
                     var4.method2556();
                     var4.method2556();
                     var4.method2556();
                  } else if(super.orientation == 1024) {
                     var4.method2556();
                     var4.method2556();
                  } else if(super.orientation == 1536) {
                     var4.method2556();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2556();
                  } else if(super.orientation == 1024) {
                     var4.method2556();
                     var4.method2556();
                  } else if(super.orientation == 1536) {
                     var4.method2556();
                     var4.method2556();
                     var4.method2556();
                  }

                  var4.method2526(super.x - this.field889, this.field886 - this.field890, super.y - this.field891);
               }
            }

            var3.field1938 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "119943128"
   )
   void method1168(int var1, int var2) {
      super.queueSize = 0;
      super.field1264 = 0;
      super.field1263 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class19.getNpcDefinition(this.composition.transformedNpcId).field3547:1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "2124680011"
   )
   final void method1149(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1262[var4] = super.field1262[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1262[0] = var3;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "373568623"
   )
   final void method1147(int var1, int var2, byte var3) {
      if(super.animation != -1 && Ignore.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1205 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.getSize();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var9 = this.getSize();
                  Client.field1007.field2294 = var1;
                  Client.field1007.field2293 = var2;
                  Client.field1007.field2292 = 1;
                  Client.field1007.field2295 = 1;
                  class74 var10 = Client.field1007;
                  class74 var11 = var10;
                  CollisionData var12 = Client.collisionMaps[this.field900];
                  int[] var13 = Client.field1180;
                  int[] var14 = Client.field1139;
                  int var15 = 0;

                  label771:
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
                           var35 = GameEngine.method983(var5, var6, var10, var12);
                        } else {
                           byte var19;
                           byte var23;
                           int[][] var34;
                           boolean var36;
                           if(var9 == 2) {
                              var17 = var5;
                              var18 = var6;
                              var19 = 64;
                              var20 = 64;
                              var21 = var5 - var19;
                              var22 = var6 - var20;
                              class163.field2285[var19][var20] = 99;
                              class163.field2289[var19][var20] = 0;
                              var23 = 0;
                              var24 = 0;
                              class163.field2283[var23] = var5;
                              var40 = var23 + 1;
                              class163.field2284[var23] = var6;
                              var34 = var12.flags;

                              while(true) {
                                 if(var40 == var24) {
                                    class163.field2287 = var17;
                                    class72.field858 = var18;
                                    var36 = false;
                                    break;
                                 }

                                 var17 = class163.field2283[var24];
                                 var18 = class163.field2284[var24];
                                 var24 = var24 + 1 & 4095;
                                 var37 = var17 - var21;
                                 var38 = var18 - var22;
                                 var26 = var17 - var12.x;
                                 var27 = var18 - var12.y;
                                 if(var11.vmethod3095(2, var17, var18, var12)) {
                                    class163.field2287 = var17;
                                    class72.field858 = var18;
                                    var36 = true;
                                    break;
                                 }

                                 var28 = class163.field2289[var37][var38] + 1;
                                 if(var37 > 0 && class163.field2285[var37 - 1][var38] == 0 && (var34[var26 - 1][var27] & 19136782) == 0 && (var34[var26 - 1][var27 + 1] & 19136824) == 0) {
                                    class163.field2283[var40] = var17 - 1;
                                    class163.field2284[var40] = var18;
                                    var40 = var40 + 1 & 4095;
                                    class163.field2285[var37 - 1][var38] = 2;
                                    class163.field2289[var37 - 1][var38] = var28;
                                 }

                                 if(var37 < 126 && class163.field2285[var37 + 1][var38] == 0 && (var34[var26 + 2][var27] & 19136899) == 0 && (var34[var26 + 2][var27 + 1] & 19136992) == 0) {
                                    class163.field2283[var40] = var17 + 1;
                                    class163.field2284[var40] = var18;
                                    var40 = var40 + 1 & 4095;
                                    class163.field2285[var37 + 1][var38] = 8;
                                    class163.field2289[var37 + 1][var38] = var28;
                                 }

                                 if(var38 > 0 && class163.field2285[var37][var38 - 1] == 0 && (var34[var26][var27 - 1] & 19136782) == 0 && (var34[var26 + 1][var27 - 1] & 19136899) == 0) {
                                    class163.field2283[var40] = var17;
                                    class163.field2284[var40] = var18 - 1;
                                    var40 = var40 + 1 & 4095;
                                    class163.field2285[var37][var38 - 1] = 1;
                                    class163.field2289[var37][var38 - 1] = var28;
                                 }

                                 if(var38 < 126 && 0 == class163.field2285[var37][var38 + 1] && (var34[var26][var27 + 2] & 19136824) == 0 && (var34[var26 + 1][var27 + 2] & 19136992) == 0) {
                                    class163.field2283[var40] = var17;
                                    class163.field2284[var40] = var18 + 1;
                                    var40 = var40 + 1 & 4095;
                                    class163.field2285[var37][var38 + 1] = 4;
                                    class163.field2289[var37][var38 + 1] = var28;
                                 }

                                 if(var37 > 0 && var38 > 0 && class163.field2285[var37 - 1][var38 - 1] == 0 && (var34[var26 - 1][var27] & 19136830) == 0 && (var34[var26 - 1][var27 - 1] & 19136782) == 0 && (var34[var26][var27 - 1] & 19136911) == 0) {
                                    class163.field2283[var40] = var17 - 1;
                                    class163.field2284[var40] = var18 - 1;
                                    var40 = var40 + 1 & 4095;
                                    class163.field2285[var37 - 1][var38 - 1] = 3;
                                    class163.field2289[var37 - 1][var38 - 1] = var28;
                                 }

                                 if(var37 < 126 && var38 > 0 && class163.field2285[var37 + 1][var38 - 1] == 0 && (var34[var26 + 1][var27 - 1] & 19136911) == 0 && (var34[var26 + 2][var27 - 1] & 19136899) == 0 && (var34[var26 + 2][var27] & 19136995) == 0) {
                                    class163.field2283[var40] = var17 + 1;
                                    class163.field2284[var40] = var18 - 1;
                                    var40 = var40 + 1 & 4095;
                                    class163.field2285[var37 + 1][var38 - 1] = 9;
                                    class163.field2289[var37 + 1][var38 - 1] = var28;
                                 }

                                 if(var37 > 0 && var38 < 126 && class163.field2285[var37 - 1][var38 + 1] == 0 && 0 == (var34[var26 - 1][var27 + 1] & 19136830) && (var34[var26 - 1][var27 + 2] & 19136824) == 0 && (var34[var26][var27 + 2] & 19137016) == 0) {
                                    class163.field2283[var40] = var17 - 1;
                                    class163.field2284[var40] = var18 + 1;
                                    var40 = var40 + 1 & 4095;
                                    class163.field2285[var37 - 1][var38 + 1] = 6;
                                    class163.field2289[var37 - 1][var38 + 1] = var28;
                                 }

                                 if(var37 < 126 && var38 < 126 && class163.field2285[var37 + 1][var38 + 1] == 0 && 0 == (var34[var26 + 1][var27 + 2] & 19137016) && (var34[var26 + 2][var27 + 2] & 19136992) == 0 && (var34[var26 + 2][var27 + 1] & 19136995) == 0) {
                                    class163.field2283[var40] = var17 + 1;
                                    class163.field2284[var40] = var18 + 1;
                                    var40 = var40 + 1 & 4095;
                                    class163.field2285[var37 + 1][var38 + 1] = 12;
                                    class163.field2289[var37 + 1][var38 + 1] = var28;
                                 }
                              }

                              var35 = var36;
                           } else {
                              var17 = var5;
                              var18 = var6;
                              var19 = 64;
                              var20 = 64;
                              var21 = var5 - var19;
                              var22 = var6 - var20;
                              class163.field2285[var19][var20] = 99;
                              class163.field2289[var19][var20] = 0;
                              var23 = 0;
                              var24 = 0;
                              class163.field2283[var23] = var5;
                              var40 = var23 + 1;
                              class163.field2284[var23] = var6;
                              var34 = var12.flags;

                              label749:
                              while(true) {
                                 label747:
                                 while(true) {
                                    do {
                                       do {
                                          do {
                                             label724:
                                             do {
                                                if(var40 == var24) {
                                                   class163.field2287 = var17;
                                                   class72.field858 = var18;
                                                   var36 = false;
                                                   break label749;
                                                }

                                                var17 = class163.field2283[var24];
                                                var18 = class163.field2284[var24];
                                                var24 = var24 + 1 & 4095;
                                                var37 = var17 - var21;
                                                var38 = var18 - var22;
                                                var26 = var17 - var12.x;
                                                var27 = var18 - var12.y;
                                                if(var11.vmethod3095(var9, var17, var18, var12)) {
                                                   class163.field2287 = var17;
                                                   class72.field858 = var18;
                                                   var36 = true;
                                                   break label749;
                                                }

                                                var28 = class163.field2289[var37][var38] + 1;
                                                if(var37 > 0 && class163.field2285[var37 - 1][var38] == 0 && (var34[var26 - 1][var27] & 19136782) == 0 && (var34[var26 - 1][var27 + var9 - 1] & 19136824) == 0) {
                                                   var29 = 1;

                                                   while(true) {
                                                      if(var29 >= var9 - 1) {
                                                         class163.field2283[var40] = var17 - 1;
                                                         class163.field2284[var40] = var18;
                                                         var40 = var40 + 1 & 4095;
                                                         class163.field2285[var37 - 1][var38] = 2;
                                                         class163.field2289[var37 - 1][var38] = var28;
                                                         break;
                                                      }

                                                      if((var34[var26 - 1][var27 + var29] & 19136830) != 0) {
                                                         break;
                                                      }

                                                      ++var29;
                                                   }
                                                }

                                                if(var37 < 128 - var9 && 0 == class163.field2285[var37 + 1][var38] && 0 == (var34[var9 + var26][var27] & 19136899) && 0 == (var34[var9 + var26][var27 + var9 - 1] & 19136992)) {
                                                   var29 = 1;

                                                   while(true) {
                                                      if(var29 >= var9 - 1) {
                                                         class163.field2283[var40] = var17 + 1;
                                                         class163.field2284[var40] = var18;
                                                         var40 = var40 + 1 & 4095;
                                                         class163.field2285[var37 + 1][var38] = 8;
                                                         class163.field2289[var37 + 1][var38] = var28;
                                                         break;
                                                      }

                                                      if((var34[var26 + var9][var29 + var27] & 19136995) != 0) {
                                                         break;
                                                      }

                                                      ++var29;
                                                   }
                                                }

                                                if(var38 > 0 && class163.field2285[var37][var38 - 1] == 0 && (var34[var26][var27 - 1] & 19136782) == 0 && (var34[var9 + var26 - 1][var27 - 1] & 19136899) == 0) {
                                                   var29 = 1;

                                                   while(true) {
                                                      if(var29 >= var9 - 1) {
                                                         class163.field2283[var40] = var17;
                                                         class163.field2284[var40] = var18 - 1;
                                                         var40 = var40 + 1 & 4095;
                                                         class163.field2285[var37][var38 - 1] = 1;
                                                         class163.field2289[var37][var38 - 1] = var28;
                                                         break;
                                                      }

                                                      if((var34[var26 + var29][var27 - 1] & 19136911) != 0) {
                                                         break;
                                                      }

                                                      ++var29;
                                                   }
                                                }

                                                if(var38 < 128 - var9 && class163.field2285[var37][var38 + 1] == 0 && (var34[var26][var9 + var27] & 19136824) == 0 && (var34[var9 + var26 - 1][var9 + var27] & 19136992) == 0) {
                                                   var29 = 1;

                                                   while(true) {
                                                      if(var29 >= var9 - 1) {
                                                         class163.field2283[var40] = var17;
                                                         class163.field2284[var40] = var18 + 1;
                                                         var40 = var40 + 1 & 4095;
                                                         class163.field2285[var37][var38 + 1] = 4;
                                                         class163.field2289[var37][var38 + 1] = var28;
                                                         break;
                                                      }

                                                      if(0 != (var34[var29 + var26][var27 + var9] & 19137016)) {
                                                         break;
                                                      }

                                                      ++var29;
                                                   }
                                                }

                                                if(var37 > 0 && var38 > 0 && class163.field2285[var37 - 1][var38 - 1] == 0 && (var34[var26 - 1][var27 - 1] & 19136782) == 0) {
                                                   var29 = 1;

                                                   while(true) {
                                                      if(var29 >= var9) {
                                                         class163.field2283[var40] = var17 - 1;
                                                         class163.field2284[var40] = var18 - 1;
                                                         var40 = var40 + 1 & 4095;
                                                         class163.field2285[var37 - 1][var38 - 1] = 3;
                                                         class163.field2289[var37 - 1][var38 - 1] = var28;
                                                         break;
                                                      }

                                                      if((var34[var26 - 1][var29 + (var27 - 1)] & 19136830) != 0 || (var34[var29 + (var26 - 1)][var27 - 1] & 19136911) != 0) {
                                                         break;
                                                      }

                                                      ++var29;
                                                   }
                                                }

                                                if(var37 < 128 - var9 && var38 > 0 && class163.field2285[var37 + 1][var38 - 1] == 0 && (var34[var9 + var26][var27 - 1] & 19136899) == 0) {
                                                   var29 = 1;

                                                   while(true) {
                                                      if(var29 >= var9) {
                                                         class163.field2283[var40] = var17 + 1;
                                                         class163.field2284[var40] = var18 - 1;
                                                         var40 = var40 + 1 & 4095;
                                                         class163.field2285[var37 + 1][var38 - 1] = 9;
                                                         class163.field2289[var37 + 1][var38 - 1] = var28;
                                                         break;
                                                      }

                                                      if((var34[var26 + var9][var29 + (var27 - 1)] & 19136995) != 0 || (var34[var26 + var29][var27 - 1] & 19136911) != 0) {
                                                         break;
                                                      }

                                                      ++var29;
                                                   }
                                                }

                                                if(var37 > 0 && var38 < 128 - var9 && class163.field2285[var37 - 1][var38 + 1] == 0 && (var34[var26 - 1][var9 + var27] & 19136824) == 0) {
                                                   for(var29 = 1; var29 < var9; ++var29) {
                                                      if((var34[var26 - 1][var27 + var29] & 19136830) != 0 || (var34[var29 + (var26 - 1)][var27 + var9] & 19137016) != 0) {
                                                         continue label724;
                                                      }
                                                   }

                                                   class163.field2283[var40] = var17 - 1;
                                                   class163.field2284[var40] = var18 + 1;
                                                   var40 = var40 + 1 & 4095;
                                                   class163.field2285[var37 - 1][var38 + 1] = 6;
                                                   class163.field2289[var37 - 1][var38 + 1] = var28;
                                                }
                                             } while(var37 >= 128 - var9);
                                          } while(var38 >= 128 - var9);
                                       } while(class163.field2285[var37 + 1][var38 + 1] != 0);
                                    } while((var34[var9 + var26][var27 + var9] & 19136992) != 0);

                                    for(var29 = 1; var29 < var9; ++var29) {
                                       if((var34[var26 + var29][var9 + var27] & 19137016) != 0 || 0 != (var34[var26 + var9][var27 + var29] & 19136995)) {
                                          continue label747;
                                       }
                                    }

                                    class163.field2283[var40] = var17 + 1;
                                    class163.field2284[var40] = var18 + 1;
                                    var40 = var40 + 1 & 4095;
                                    class163.field2285[var37 + 1][var38 + 1] = 12;
                                    class163.field2289[var37 + 1][var38 + 1] = var28;
                                 }
                              }

                              var35 = var36;
                           }
                        }

                        int var8;
                        label812: {
                           var16 = var5 - 64;
                           var17 = var6 - 64;
                           var18 = class163.field2287;
                           var37 = class72.field858;
                           if(!var35) {
                              var38 = Integer.MAX_VALUE;
                              var21 = Integer.MAX_VALUE;
                              byte var39 = 10;
                              var40 = var11.field2294;
                              var24 = var11.field2293;
                              int var25 = var11.field2292;
                              var26 = var11.field2295;

                              for(var27 = var40 - var39; var27 <= var39 + var40; ++var27) {
                                 for(var28 = var24 - var39; var28 <= var24 + var39; ++var28) {
                                    var29 = var27 - var16;
                                    int var30 = var28 - var17;
                                    if(var29 >= 0 && var30 >= 0 && var29 < 128 && var30 < 128 && class163.field2289[var29][var30] < 100) {
                                       int var31 = 0;
                                       if(var27 < var40) {
                                          var31 = var40 - var27;
                                       } else if(var27 > var40 + var25 - 1) {
                                          var31 = var27 - (var25 + var40 - 1);
                                       }

                                       int var32 = 0;
                                       if(var28 < var24) {
                                          var32 = var24 - var28;
                                       } else if(var28 > var24 + var26 - 1) {
                                          var32 = var28 - (var24 + var26 - 1);
                                       }

                                       int var33 = var31 * var31 + var32 * var32;
                                       if(var33 < var38 || var33 == var38 && class163.field2289[var29][var30] < var21) {
                                          var38 = var33;
                                          var21 = class163.field2289[var29][var30];
                                          var18 = var27;
                                          var37 = var28;
                                       }
                                    }
                                 }
                              }

                              if(var38 == Integer.MAX_VALUE) {
                                 var8 = -1;
                                 break label812;
                              }
                           }

                           if(var5 == var18 && var6 == var37) {
                              var8 = 0;
                           } else {
                              var20 = 0;
                              class163.field2283[var20] = var18;
                              var38 = var20 + 1;
                              class163.field2284[var20] = var37;

                              for(var21 = var22 = class163.field2285[var18 - var16][var37 - var17]; var18 != var5 || var37 != var6; var21 = class163.field2285[var18 - var16][var37 - var17]) {
                                 if(var21 != var22) {
                                    var22 = var21;
                                    class163.field2283[var38] = var18;
                                    class163.field2284[var38++] = var37;
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
                                 var13[var40] = class163.field2283[var38];
                                 var14[var40++] = class163.field2284[var38];
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
                              break label771;
                           }

                           var4.method1149(Client.field1180[var16], Client.field1139[var16], (byte)2);
                           ++var16;
                        }
                     }

                     for(var16 = 0; var16 < 128; ++var16) {
                        class163.field2285[var15][var16] = 0;
                        class163.field2289[var15][var16] = 99999999;
                     }

                     ++var15;
                  }
               }
            }

            this.method1149(var1, var2, var3);
         } else {
            this.method1168(var1, var2);
         }
      } else {
         this.method1168(var1, var2);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "1380882645"
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
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = ClassInfo.getItemDefinition(var4[var5] - 512).field3524;
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
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field1227 = var1.readUnsignedShort();
      if(super.field1227 == '\uffff') {
         super.field1227 = -1;
      }

      super.field1212 = super.field1227;
      super.field1241 = var1.readUnsignedShort();
      if(super.field1241 == '\uffff') {
         super.field1241 = -1;
      }

      super.field1214 = var1.readUnsignedShort();
      if(super.field1214 == '\uffff') {
         super.field1214 = -1;
      }

      super.field1249 = var1.readUnsignedShort();
      if(super.field1249 == '\uffff') {
         super.field1249 = -1;
      }

      super.field1211 = var1.readUnsignedShort();
      if(super.field1211 == '\uffff') {
         super.field1211 = -1;
      }

      super.field1256 = var1.readUnsignedShort();
      if(super.field1256 == '\uffff') {
         super.field1256 = -1;
      }

      this.name = var1.readString();
      if(this == class54.localPlayer) {
         class153.field2200 = this.name;
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

      this.composition.method3951(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2046618582"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "([Lhg;Lhg;ZI)V",
      garbageValue = "361206139"
   )
   static void method1171(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class23.method171(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class23.method171(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         int var6 = var5.id;
         if(class10.loadWidget(var6)) {
            class23.method171(Item.widgets[var6], -1, var3, var4, var2);
         }
      }

      if(var1.contentType == 1337) {
         ;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljk;Ljk;I)V",
      garbageValue = "-636443449"
   )
   static void method1169(Font var0, Font var1) {
      if(class54.field655 == null) {
         class54.field655 = class222.method4065(WorldMapType1.indexSprites, "sl_back", "");
      }

      if(class93.field1422 == null) {
         class93.field1422 = class10.method55(WorldMapType1.indexSprites, "sl_flags", "");
      }

      if(CombatInfo1.field1271 == null) {
         CombatInfo1.field1271 = class10.method55(WorldMapType1.indexSprites, "sl_arrows", "");
      }

      if(class97.field1504 == null) {
         class97.field1504 = class10.method55(WorldMapType1.indexSprites, "sl_stars", "");
      }

      Rasterizer2D.method4973(class93.field1424, 23, 765, 480, 0);
      Rasterizer2D.method4978(class93.field1424, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method4978(class93.field1424 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method4779("Select a world", class93.field1424 + 62, 15, 0, -1);
      if(class97.field1504 != null) {
         class97.field1504[1].method5068(class93.field1424 + 140, 1);
         var1.method4776("Members only world", class93.field1424 + 152, 10, 16777215, -1);
         class97.field1504[0].method5068(class93.field1424 + 140, 12);
         var1.method4776("Free world", class93.field1424 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(CombatInfo1.field1271 != null) {
         int var2 = class93.field1424 + 280;
         if(World.field1281[0] == 0 && World.field1291[0] == 0) {
            CombatInfo1.field1271[2].method5068(var2, 4);
         } else {
            CombatInfo1.field1271[0].method5068(var2, 4);
         }

         if(World.field1281[0] == 0 && World.field1291[0] == 1) {
            CombatInfo1.field1271[3].method5068(var2 + 15, 4);
         } else {
            CombatInfo1.field1271[1].method5068(var2 + 15, 4);
         }

         var0.method4776("World", var2 + 32, 17, 16777215, -1);
         int var3 = class93.field1424 + 390;
         if(World.field1281[0] == 1 && World.field1291[0] == 0) {
            CombatInfo1.field1271[2].method5068(var3, 4);
         } else {
            CombatInfo1.field1271[0].method5068(var3, 4);
         }

         if(World.field1281[0] == 1 && World.field1291[0] == 1) {
            CombatInfo1.field1271[3].method5068(var3 + 15, 4);
         } else {
            CombatInfo1.field1271[1].method5068(var3 + 15, 4);
         }

         var0.method4776("Players", var3 + 32, 17, 16777215, -1);
         var4 = class93.field1424 + 500;
         if(World.field1281[0] == 2 && World.field1291[0] == 0) {
            CombatInfo1.field1271[2].method5068(var4, 4);
         } else {
            CombatInfo1.field1271[0].method5068(var4, 4);
         }

         if(World.field1281[0] == 2 && World.field1291[0] == 1) {
            CombatInfo1.field1271[3].method5068(var4 + 15, 4);
         } else {
            CombatInfo1.field1271[1].method5068(var4 + 15, 4);
         }

         var0.method4776("Location", var4 + 32, 17, 16777215, -1);
         var5 = class93.field1424 + 610;
         if(World.field1281[0] == 3 && World.field1291[0] == 0) {
            CombatInfo1.field1271[2].method5068(var5, 4);
         } else {
            CombatInfo1.field1271[0].method5068(var5, 4);
         }

         if(World.field1281[0] == 3 && World.field1291[0] == 1) {
            CombatInfo1.field1271[3].method5068(var5 + 15, 4);
         } else {
            CombatInfo1.field1271[1].method5068(var5 + 15, 4);
         }

         var0.method4776("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method4973(class93.field1424 + 708, 4, 50, 16, 0);
      var1.method4779("Cancel", class93.field1424 + 708 + 25, 16, 16777215, -1);
      class93.field1449 = -1;
      if(class54.field655 != null) {
         byte var21 = 88;
         byte var22 = 19;
         var4 = 765 / (var21 + 1);
         var5 = 480 / (var22 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if(var5 * (var4 - 1) >= World.worldCount) {
               --var4;
            }

            if(var4 * (var5 - 1) >= World.worldCount) {
               --var5;
            }

            if(var4 * (var5 - 1) >= World.worldCount) {
               --var5;
            }
         } while(var5 != var6 || var7 != var4);

         var6 = (765 - var4 * var21) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var22) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var21 * var4 - var6 * (var4 - 1)) / 2;
         int var9 = (480 - var5 * var22 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class93.field1424;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.worldCount; ++var14) {
            World var15 = class51.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method1555()) {
               if(var15.method1550()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method1554()) {
               var19 = 16711680;
               if(var15.method1550()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method1552()) {
               if(var15.method1550()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method1550()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(MouseInput.field718 >= var11 && MouseInput.field719 >= var10 && MouseInput.field718 < var21 + var11 && MouseInput.field719 < var22 + var10 && var16) {
               class93.field1449 = var14;
               class54.field655[var18].method5104(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class54.field655[var18].method5098(var11, var10);
            }

            if(class93.field1422 != null) {
               class93.field1422[(var15.method1550()?8:0) + var15.location].method5068(var11 + 29, var10);
            }

            var0.method4779(Integer.toString(var15.id), var11 + 15, var22 / 2 + var10 + 5, var19, -1);
            var1.method4779(var17, var11 + 60, var22 / 2 + var10 + 5, 268435455, -1);
            var10 = var10 + var22 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 = var11 + var6 + var21;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4771(class51.worldList[class93.field1449].activity) + 6;
            int var20 = var1.verticalSpace + 8;
            Rasterizer2D.method4973(MouseInput.field718 - var14 / 2, MouseInput.field719 + 20 + 5, var14, var20, 16777120);
            Rasterizer2D.drawRectangle(MouseInput.field718 - var14 / 2, MouseInput.field719 + 20 + 5, var14, var20, 0);
            var1.method4779(class51.worldList[class93.field1449].activity, MouseInput.field718, MouseInput.field719 + var1.verticalSpace + 20 + 5 + 4, 0, -1);
         }
      }

      class19.field322.vmethod5051(0, 0);
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "100"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class84.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class56.field667 = new SpritePixels(512, 512);
         class93.loadingText = "Starting game engine...";
         class93.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage != 20) {
            if(Client.loadingStage == 30) {
               class64.indexInterfaces = class25.openCacheIndex(0, false, true, true);
               class291.indexSoundEffects = class25.openCacheIndex(1, false, true, true);
               WorldMapType1.configsIndex = class25.openCacheIndex(2, true, false, true);
               KitDefinition.field3353 = class25.openCacheIndex(3, false, true, true);
               CombatInfo1.field1272 = class25.openCacheIndex(4, false, true, true);
               class158.indexMaps = class25.openCacheIndex(5, true, true, true);
               class244.indexTrack1 = class25.openCacheIndex(6, true, true, false);
               class19.indexModels = class25.openCacheIndex(7, false, true, true);
               WorldMapType1.indexSprites = class25.openCacheIndex(8, false, true, true);
               class61.indexTextures = class25.openCacheIndex(9, false, true, true);
               Ignore.field855 = class25.openCacheIndex(10, false, true, true);
               class33.indexTrack2 = class25.openCacheIndex(11, false, true, true);
               class253.indexScripts = class25.openCacheIndex(12, false, true, true);
               WidgetNode.field824 = class25.openCacheIndex(13, true, false, true);
               class51.vorbisIndex = class25.openCacheIndex(14, false, true, false);
               class22.field342 = class25.openCacheIndex(15, false, true, true);
               class14.indexWorldMap = class25.openCacheIndex(16, false, true, false);
               class93.loadingText = "Connecting to update server";
               class93.loadingBarPercentage = 20;
               Client.loadingStage = 40;
            } else if(Client.loadingStage == 40) {
               byte var22 = 0;
               var0 = var22 + class64.indexInterfaces.percentage() * 4 / 100;
               var0 += class291.indexSoundEffects.percentage() * 4 / 100;
               var0 += WorldMapType1.configsIndex.percentage() * 2 / 100;
               var0 += KitDefinition.field3353.percentage() * 2 / 100;
               var0 += CombatInfo1.field1272.percentage() * 6 / 100;
               var0 += class158.indexMaps.percentage() * 4 / 100;
               var0 += class244.indexTrack1.percentage() * 2 / 100;
               var0 += class19.indexModels.percentage() * 58 / 100;
               var0 += WorldMapType1.indexSprites.percentage() * 2 / 100;
               var0 += class61.indexTextures.percentage() * 2 / 100;
               var0 += Ignore.field855.percentage() * 2 / 100;
               var0 += class33.indexTrack2.percentage() * 2 / 100;
               var0 += class253.indexScripts.percentage() * 2 / 100;
               var0 += WidgetNode.field824.percentage() * 2 / 100;
               var0 += class51.vorbisIndex.percentage() * 2 / 100;
               var0 += class22.field342.percentage() * 2 / 100;
               var0 += class14.indexWorldMap.percentage() * 2 / 100;
               if(var0 != 100) {
                  if(var0 != 0) {
                     class93.loadingText = "Checking for updates - " + var0 + "%";
                  }

                  class93.loadingBarPercentage = 30;
               } else {
                  class93.loadingText = "Loaded update list";
                  class93.loadingBarPercentage = 30;
                  Client.loadingStage = 45;
               }
            } else if(Client.loadingStage == 45) {
               boolean var21 = !Client.lowMemory;
               AbstractSoundSystem.sampleRate = 22050;
               class25.highMemory = var21;
               class9.priority = 2;
               class205 var26 = new class205();
               var26.method3709(9, 128);
               Actor.soundSystem0 = class182.method3438(class15.taskManager, 0, 22050);
               Actor.soundSystem0.method2038(var26);
               Ignore.method1114(class22.field342, class51.vorbisIndex, CombatInfo1.field1272, var26);
               GroundObject.soundSystem1 = class182.method3438(class15.taskManager, 1, 2048);
               class36.field513 = new class103();
               GroundObject.soundSystem1.method2038(class36.field513);
               class228.field3114 = new class117(22050, AbstractSoundSystem.sampleRate);
               class93.loadingText = "Prepared sound engine";
               class93.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               CombatInfo1.field1269 = new class263(WorldMapType1.indexSprites, WidgetNode.field824);
            } else if(Client.loadingStage == 50) {
               var0 = class262.method4751().length;
               Client.field991 = CombatInfo1.field1269.method4755(class262.method4751());
               if(Client.field991.size() < var0) {
                  class93.loadingText = "Loading fonts - " + Client.field991.size() * 100 / var0 + "%";
                  class93.loadingBarPercentage = 40;
               } else {
                  Ignore.field852 = (Font)Client.field991.get(class262.field3623);
                  class290.font_p12full = (Font)Client.field991.get(class262.field3613);
                  class28.field406 = (Font)Client.field991.get(class262.field3614);
                  MouseInput.field731 = new MachineInfo(true);
                  class93.loadingText = "Loaded fonts";
                  class93.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else if(Client.loadingStage == 60) {
               var0 = class88.method1727(Ignore.field855, WorldMapType1.indexSprites);
               var1 = class51.method770();
               if(var0 < var1) {
                  class93.loadingText = "Loading title screen - " + var0 * 100 / var1 + "%";
                  class93.loadingBarPercentage = 50;
               } else {
                  class93.loadingText = "Loaded title screen";
                  class93.loadingBarPercentage = 50;
                  WorldMapType1.setGameState(5);
                  Client.loadingStage = 70;
               }
            } else if(Client.loadingStage == 70) {
               if(!WorldMapType1.configsIndex.method4130()) {
                  class93.loadingText = "Loading config - " + WorldMapType1.configsIndex.method4214() + "%";
                  class93.loadingBarPercentage = 60;
               } else {
                  IndexData var25 = WorldMapType1.configsIndex;
                  Overlay.overlay_ref = var25;
                  class211.method3920(WorldMapType1.configsIndex);
                  class204.method3698(WorldMapType1.configsIndex, class19.indexModels);
                  IndexData var17 = WorldMapType1.configsIndex;
                  IndexData var18 = class19.indexModels;
                  boolean var20 = Client.lowMemory;
                  class271.objects_ref = var17;
                  ObjectComposition.field3461 = var18;
                  ObjectComposition.field3452 = var20;
                  FileOnDisk.method2390(WorldMapType1.configsIndex, class19.indexModels);
                  class44.method623(WorldMapType1.configsIndex);
                  IndexData var19 = WorldMapType1.configsIndex;
                  IndexData var5 = class19.indexModels;
                  boolean var6 = Client.isMembers;
                  Font var7 = Ignore.field852;
                  class83.item_ref = var19;
                  Coordinates.field2586 = var5;
                  ItemComposition.isMembersWorld = var6;
                  ItemComposition.field3480 = class83.item_ref.fileCount(10);
                  AbstractByteBuffer.field2400 = var7;
                  IndexData var8 = WorldMapType1.configsIndex;
                  IndexData var9 = class64.indexInterfaces;
                  IndexData var10 = class291.indexSoundEffects;
                  Sequence.seq_ref = var8;
                  Sequence.skel_ref = var9;
                  class18.skin_ref = var10;
                  Area.method4308(WorldMapType1.configsIndex, class19.indexModels);
                  WallObject.method2907(WorldMapType1.configsIndex);
                  WorldMapType3.method213(WorldMapType1.configsIndex);
                  BaseVarType.method8(KitDefinition.field3353, class19.indexModels, WorldMapType1.indexSprites, WidgetNode.field824);
                  class56.method817(WorldMapType1.configsIndex);
                  IndexData var11 = WorldMapType1.configsIndex;
                  Enum.field3393 = var11;
                  class92.method1747(WorldMapType1.configsIndex);
                  IndexData var12 = WorldMapType1.configsIndex;
                  class21.field338 = var12;
                  IndexData var13 = WorldMapType1.configsIndex;
                  class252.field3384 = var13;
                  class47.chatMessages = new Varcs();
                  class43.method608(WorldMapType1.configsIndex, WorldMapType1.indexSprites, WidgetNode.field824);
                  IndexData var14 = WorldMapType1.configsIndex;
                  IndexData var15 = WorldMapType1.indexSprites;
                  CombatInfo2.field3357 = var14;
                  CombatInfo2.field3355 = var15;
                  DecorativeObject.method2936(WorldMapType1.configsIndex, WorldMapType1.indexSprites);
                  class93.loadingText = "Loaded config";
                  class93.loadingBarPercentage = 60;
                  Client.loadingStage = 80;
               }
            } else if(Client.loadingStage == 80) {
               var0 = 0;
               if(class12.compass == null) {
                  class12.compass = class270.method4896(WorldMapType1.indexSprites, "compass", "");
               } else {
                  ++var0;
               }

               if(class60.mapedge == null) {
                  class60.mapedge = class270.method4896(WorldMapType1.indexSprites, "mapedge", "");
               } else {
                  ++var0;
               }

               if(class19.field321 == null) {
                  class19.field321 = class10.method55(WorldMapType1.indexSprites, "mapscene", "");
               } else {
                  ++var0;
               }

               if(class64.mapfunctions == null) {
                  class64.mapfunctions = class222.method4065(WorldMapType1.indexSprites, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(class113.hitmarks == null) {
                  class113.hitmarks = class222.method4065(WorldMapType1.indexSprites, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class252.pkIcons == null) {
                  class252.pkIcons = class222.method4065(WorldMapType1.indexSprites, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(Script.field1523 == null) {
                  Script.field1523 = class222.method4065(WorldMapType1.indexSprites, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(class182.field2421 == null) {
                  class182.field2421 = class222.method4065(WorldMapType1.indexSprites, "cross", "");
               } else {
                  ++var0;
               }

               if(class44.mapDots == null) {
                  class44.mapDots = class222.method4065(WorldMapType1.indexSprites, "mapdots", "");
               } else {
                  ++var0;
               }

               if(class27.field401 == null) {
                  class27.field401 = class10.method55(WorldMapType1.indexSprites, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(class8.field242 == null) {
                  class8.field242 = class10.method55(WorldMapType1.indexSprites, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 11) {
                  class93.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class93.loadingBarPercentage = 70;
               } else {
                  FontTypeFace.modIcons = class8.field242;
                  class60.mapedge.method5092();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;
                  class19.field321[0].method5067(var4 + var1, var2 + var4, var3 + var4);
                  class93.loadingText = "Loaded sprites";
                  class93.loadingBarPercentage = 70;
                  Client.loadingStage = 90;
               }
            } else if(Client.loadingStage == 90) {
               if(!class61.indexTextures.method4130()) {
                  class93.loadingText = "Loading textures - " + class61.indexTextures.method4214() + "%";
                  class93.loadingBarPercentage = 90;
               } else {
                  TextureProvider var24 = new TextureProvider(class61.indexTextures, WorldMapType1.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                  Graphics3D.setTextureLoader(var24);
                  Graphics3D.setBrightness(0.8D);
                  class93.loadingText = "Loaded textures";
                  class93.loadingBarPercentage = 90;
                  Client.loadingStage = 110;
               }
            } else if(Client.loadingStage == 110) {
               class153.field2205 = new class72();
               class15.taskManager.createRunnable(class153.field2205, 10);
               class93.loadingText = "Loaded input handler";
               class93.loadingBarPercentage = 94;
               Client.loadingStage = 120;
            } else if(Client.loadingStage == 120) {
               if(!Ignore.field855.method4134("huffman", "")) {
                  class93.loadingText = "Loading wordpack - " + 0 + "%";
                  class93.loadingBarPercentage = 96;
               } else {
                  Huffman var23 = new Huffman(Ignore.field855.method4143("huffman", ""));
                  class45.method655(var23);
                  class93.loadingText = "Loaded wordpack";
                  class93.loadingBarPercentage = 96;
                  Client.loadingStage = 130;
               }
            } else if(Client.loadingStage == 130) {
               if(!KitDefinition.field3353.method4130()) {
                  class93.loadingText = "Loading interfaces - " + KitDefinition.field3353.method4214() * 4 / 5 + "%";
                  class93.loadingBarPercentage = 100;
               } else if(!class253.indexScripts.method4130()) {
                  class93.loadingText = "Loading interfaces - " + (80 + class253.indexScripts.method4214() / 6) + "%";
                  class93.loadingBarPercentage = 100;
               } else if(!WidgetNode.field824.method4130()) {
                  class93.loadingText = "Loading interfaces - " + (96 + WidgetNode.field824.method4214() / 50) + "%";
                  class93.loadingBarPercentage = 100;
               } else {
                  class93.loadingText = "Loaded interfaces";
                  class93.loadingBarPercentage = 98;
                  Client.loadingStage = 140;
               }
            } else if(Client.loadingStage == 140) {
               if(!class14.indexWorldMap.method4167(class40.field542.field540)) {
                  class93.loadingText = "Loading world map - " + class14.indexWorldMap.method4137(class40.field542.field540) / 10 + "%";
               } else {
                  if(BaseVarType.renderOverview == null) {
                     BaseVarType.renderOverview = new RenderOverview();
                     BaseVarType.renderOverview.method5225(class14.indexWorldMap, class28.field406, Client.field991, class19.field321);
                  }

                  var0 = BaseVarType.renderOverview.method5226();
                  if(var0 < 100) {
                     class93.loadingText = "Loading world map - " + (10 + var0 * 9 / 10) + "%";
                  } else {
                     class93.loadingText = "Loaded world map";
                     class93.loadingBarPercentage = 100;
                     Client.loadingStage = 150;
                  }
               }
            } else if(Client.loadingStage == 150) {
               WorldMapType1.setGameState(10);
            }
         } else {
            int[] var16 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = 600 + var2 * 3;
               var4 = Graphics3D.SINE[var2];
               var16[var1] = var4 * var3 >> 16;
            }

            Region.method2846(var16, 500, 800, 512, 334);
            class93.loadingText = "Prepared visibility map";
            class93.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         }
      }
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-104"
   )
   static final String method1155(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
