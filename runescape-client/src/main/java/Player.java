import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("c")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1253957049
   )
   @Export("skullIcon")
   int skullIcon = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -145390117
   )
   @Export("overheadIcon")
   int overheadIcon = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -327379025
   )
   int field239;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1966895337
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2096284081
   )
   int field241;
   @ObfuscatedName("mn")
   static byte field242;
   @ObfuscatedName("p")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 230420051
   )
   int field245;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -39314763
   )
   int field246;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 191259437
   )
   int field247;
   @ObfuscatedName("k")
   @Export("model")
   Model model;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -46242441
   )
   int field249;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1651502801
   )
   @Export("team")
   int team;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2059534963
   )
   int field251;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1733834783
   )
   int field252;
   @ObfuscatedName("x")
   boolean field253;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1879368227
   )
   int field254;
   @ObfuscatedName("m")
   boolean field255;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1862163435
   )
   int field256;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2135766511
   )
   int field257;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 75618727
   )
   int field258;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 19125835
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 800402805
   )
   int field260;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = -315136117
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1579620173
   )
   int field262;
   @ObfuscatedName("b")
   boolean field263;
   @ObfuscatedName("il")
   @ObfuscatedGetter(
      intValue = 412442551
   )
   static int field264;
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("pn")
   static GarbageCollectorMXBean field266;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1511571257"
   )
   int method226() {
      return this.composition != null && this.composition.field2182 != -1?Widget.getNpcDefinition(this.composition.field2182).field3042:1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1846730189"
   )
   final void method227(Buffer var1) {
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
               int var8 = class47.getItemDefinition(var4[var5] - 512).field2995;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class112.field1761[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field605 = var1.readUnsignedShort();
      if(super.field605 == '\uffff') {
         super.field605 = -1;
      }

      super.field606 = super.field605;
      super.field659 = var1.readUnsignedShort();
      if(super.field659 == '\uffff') {
         super.field659 = -1;
      }

      super.field608 = var1.readUnsignedShort();
      if(super.field608 == '\uffff') {
         super.field608 = -1;
      }

      super.field609 = var1.readUnsignedShort();
      if(super.field609 == '\uffff') {
         super.field609 = -1;
      }

      super.field610 = var1.readUnsignedShort();
      if(super.field610 == '\uffff') {
         super.field610 = -1;
      }

      super.field649 = var1.readUnsignedShort();
      if(super.field649 == '\uffff') {
         super.field649 = -1;
      }

      this.name = var1.readString();
      if(this == class22.localPlayer) {
         class101.field1648 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field241 = var1.readUnsignedShort();
      this.field263 = var1.readUnsignedByte() == 1;
      if(Client.field283 == 0 && Client.field517 >= 2) {
         this.field263 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3146(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-18"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?NPCComposition.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field253 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:NPCComposition.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3172(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1574();
            super.field607 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field253 && super.graphic != -1 && super.field637 != -1) {
               var4 = class190.method3462(super.graphic).method3478(super.field637);
               if(var4 != null) {
                  var4.method1584(0, -super.field622, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field253 && this.model != null) {
               if(Client.gameCycle >= this.field258) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field258) {
                  var4 = this.model;
                  var4.method1584(this.field245 - super.x, this.field239 - this.field262, this.field247 - super.y);
                  if(super.field650 == 512) {
                     var4.method1598();
                     var4.method1598();
                     var4.method1598();
                  } else if(super.field650 == 1024) {
                     var4.method1598();
                     var4.method1598();
                  } else if(super.field650 == 1536) {
                     var4.method1598();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field650 == 512) {
                     var4.method1598();
                  } else if(super.field650 == 1024) {
                     var4.method1598();
                     var4.method1598();
                  } else if(super.field650 == 1536) {
                     var4.method1598();
                     var4.method1598();
                     var4.method1598();
                  }

                  var4.method1584(super.x - this.field245, this.field262 - this.field239, super.y - this.field247);
               }
            }

            var3.field1370 = true;
            return var3;
         }
      }
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field241 = 0;
      this.totalLevel = 0;
      this.field258 = 0;
      this.field253 = false;
      this.team = 0;
      this.field263 = false;
      this.field255 = false;
   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1713015033"
   )
   static final void method230() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               if(Client.field431 != -1) {
                  if(Client.field431 == var1) {
                     Client.field431 = var1 + 1;
                  } else if(var1 + 1 == Client.field431) {
                     Client.field431 = var1;
                  }
               }

               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1589943831"
   )
   final void method231(int var1, int var2, byte var3) {
      if(super.field653 < 9) {
         ++super.field653;
      }

      for(int var4 = super.field653; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field618[var4] = super.field618[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field618[0] = var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "225621132"
   )
   final boolean vmethod737() {
      return this.composition != null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1522328529"
   )
   void method236(int var1, int var2) {
      super.field653 = 0;
      super.field658 = 0;
      super.field657 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method226();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-1333337955"
   )
   static final boolean method241(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field489 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field559.method3166(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field559.method3158(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field559.method3149(false);
         }

         if(var1 == 325) {
            Client.field559.method3149(true);
         }

         if(var1 == 326) {
            Client.egressBuffer.putOpcode(141);
            Client.field559.method3147(Client.egressBuffer);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "2101469313"
   )
   static void method250(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = NPCComposition.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field633 = 0;
            var0.actionAnimationDisable = var2;
            var0.field635 = 0;
         }

         if(var3 == 2) {
            var0.field635 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || NPCComposition.getAnimation(var1).forcedPriority >= NPCComposition.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field633 = 0;
         var0.actionAnimationDisable = var2;
         var0.field635 = 0;
         var0.field658 = var0.field653;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1539190083"
   )
   final void method252(int var1, int var2, byte var3) {
      if(super.animation != -1 && NPCComposition.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field627 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.method226();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var9 = this.method226();
                  Client.field565.field1859 = var1;
                  Client.field565.field1862 = var2;
                  Client.field565.field1856 = 1;
                  Client.field565.field1854 = 1;
                  class22 var10 = Client.field565;
                  class22 var11 = var10;
                  CollisionData var12 = Client.collisionMaps[this.field256];
                  int[] var13 = Client.field566;
                  int[] var14 = Client.field567;
                  int var15 = 0;

                  label635:
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
                           var35 = class36.method748(var5, var6, var10, var12);
                        } else if(var9 == 2) {
                           var35 = Projectile.method813(var5, var6, var10, var12);
                        } else {
                           var17 = var5;
                           var18 = var6;
                           byte var19 = 64;
                           var20 = 64;
                           var21 = var5 - var19;
                           var22 = var6 - var20;
                           class118.field1845[var19][var20] = 99;
                           class118.field1843[var19][var20] = 0;
                           byte var23 = 0;
                           var24 = 0;
                           class118.field1846[var23] = var5;
                           var40 = var23 + 1;
                           class118.field1847[var23] = var6;
                           int[][] var25 = var12.flags;

                           boolean var36;
                           label621:
                           while(true) {
                              label619:
                              while(true) {
                                 do {
                                    do {
                                       do {
                                          label596:
                                          do {
                                             if(var40 == var24) {
                                                class118.field1844 = var17;
                                                class118.field1842 = var18;
                                                var36 = false;
                                                break label621;
                                             }

                                             var17 = class118.field1846[var24];
                                             var18 = class118.field1847[var24];
                                             var24 = var24 + 1 & 4095;
                                             var37 = var17 - var21;
                                             var38 = var18 - var22;
                                             var26 = var17 - var12.x;
                                             var27 = var18 - var12.y;
                                             if(var11.vmethod2294(var9, var17, var18, var12)) {
                                                class118.field1844 = var17;
                                                class118.field1842 = var18;
                                                var36 = true;
                                                break label621;
                                             }

                                             var28 = class118.field1843[var37][var38] + 1;
                                             if(var37 > 0 && class118.field1845[var37 - 1][var38] == 0 && (var25[var26 - 1][var27] & 19136782) == 0 && (var25[var26 - 1][var27 + var9 - 1] & 19136824) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9 - 1) {
                                                      class118.field1846[var40] = var17 - 1;
                                                      class118.field1847[var40] = var18;
                                                      var40 = var40 + 1 & 4095;
                                                      class118.field1845[var37 - 1][var38] = 2;
                                                      class118.field1843[var37 - 1][var38] = var28;
                                                      break;
                                                   }

                                                   if((var25[var26 - 1][var27 + var29] & 19136830) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var37 < 128 - var9 && class118.field1845[var37 + 1][var38] == 0 && (var25[var9 + var26][var27] & 19136899) == 0 && (var25[var9 + var26][var27 + var9 - 1] & 19136992) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9 - 1) {
                                                      class118.field1846[var40] = var17 + 1;
                                                      class118.field1847[var40] = var18;
                                                      var40 = var40 + 1 & 4095;
                                                      class118.field1845[var37 + 1][var38] = 8;
                                                      class118.field1843[var37 + 1][var38] = var28;
                                                      break;
                                                   }

                                                   if((var25[var26 + var9][var29 + var27] & 19136995) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var38 > 0 && class118.field1845[var37][var38 - 1] == 0 && (var25[var26][var27 - 1] & 19136782) == 0 && (var25[var26 + var9 - 1][var27 - 1] & 19136899) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9 - 1) {
                                                      class118.field1846[var40] = var17;
                                                      class118.field1847[var40] = var18 - 1;
                                                      var40 = var40 + 1 & 4095;
                                                      class118.field1845[var37][var38 - 1] = 1;
                                                      class118.field1843[var37][var38 - 1] = var28;
                                                      break;
                                                   }

                                                   if((var25[var29 + var26][var27 - 1] & 19136911) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var38 < 128 - var9 && class118.field1845[var37][var38 + 1] == 0 && (var25[var26][var9 + var27] & 19136824) == 0 && (var25[var9 + var26 - 1][var27 + var9] & 19136992) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9 - 1) {
                                                      class118.field1846[var40] = var17;
                                                      class118.field1847[var40] = var18 + 1;
                                                      var40 = var40 + 1 & 4095;
                                                      class118.field1845[var37][var38 + 1] = 4;
                                                      class118.field1843[var37][var38 + 1] = var28;
                                                      break;
                                                   }

                                                   if((var25[var29 + var26][var27 + var9] & 19137016) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var37 > 0 && var38 > 0 && class118.field1845[var37 - 1][var38 - 1] == 0 && (var25[var26 - 1][var27 - 1] & 19136782) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9) {
                                                      class118.field1846[var40] = var17 - 1;
                                                      class118.field1847[var40] = var18 - 1;
                                                      var40 = var40 + 1 & 4095;
                                                      class118.field1845[var37 - 1][var38 - 1] = 3;
                                                      class118.field1843[var37 - 1][var38 - 1] = var28;
                                                      break;
                                                   }

                                                   if((var25[var26 - 1][var27 - 1 + var29] & 19136830) != 0 || (var25[var29 + (var26 - 1)][var27 - 1] & 19136911) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var37 < 128 - var9 && var38 > 0 && class118.field1845[var37 + 1][var38 - 1] == 0 && (var25[var26 + var9][var27 - 1] & 19136899) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9) {
                                                      class118.field1846[var40] = var17 + 1;
                                                      class118.field1847[var40] = var18 - 1;
                                                      var40 = var40 + 1 & 4095;
                                                      class118.field1845[var37 + 1][var38 - 1] = 9;
                                                      class118.field1843[var37 + 1][var38 - 1] = var28;
                                                      break;
                                                   }

                                                   if((var25[var26 + var9][var29 + (var27 - 1)] & 19136995) != 0 || (var25[var26 + var29][var27 - 1] & 19136911) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var37 > 0 && var38 < 128 - var9 && class118.field1845[var37 - 1][var38 + 1] == 0 && (var25[var26 - 1][var27 + var9] & 19136824) == 0) {
                                                for(var29 = 1; var29 < var9; ++var29) {
                                                   if((var25[var26 - 1][var27 + var29] & 19136830) != 0 || (var25[var26 - 1 + var29][var9 + var27] & 19137016) != 0) {
                                                      continue label596;
                                                   }
                                                }

                                                class118.field1846[var40] = var17 - 1;
                                                class118.field1847[var40] = var18 + 1;
                                                var40 = var40 + 1 & 4095;
                                                class118.field1845[var37 - 1][var38 + 1] = 6;
                                                class118.field1843[var37 - 1][var38 + 1] = var28;
                                             }
                                          } while(var37 >= 128 - var9);
                                       } while(var38 >= 128 - var9);
                                    } while(class118.field1845[var37 + 1][var38 + 1] != 0);
                                 } while((var25[var26 + var9][var27 + var9] & 19136992) != 0);

                                 for(var29 = 1; var29 < var9; ++var29) {
                                    if((var25[var29 + var26][var27 + var9] & 19137016) != 0 || (var25[var9 + var26][var29 + var27] & 19136995) != 0) {
                                       continue label619;
                                    }
                                 }

                                 class118.field1846[var40] = var17 + 1;
                                 class118.field1847[var40] = var18 + 1;
                                 var40 = var40 + 1 & 4095;
                                 class118.field1845[var37 + 1][var38 + 1] = 12;
                                 class118.field1843[var37 + 1][var38 + 1] = var28;
                              }
                           }

                           var35 = var36;
                        }

                        int var8;
                        label674: {
                           var16 = var5 - 64;
                           var17 = var6 - 64;
                           var18 = class118.field1844;
                           var37 = class118.field1842;
                           if(!var35) {
                              var38 = Integer.MAX_VALUE;
                              var21 = Integer.MAX_VALUE;
                              byte var39 = 10;
                              var40 = var11.field1859;
                              var24 = var11.field1862;
                              int var34 = var11.field1856;
                              var26 = var11.field1854;

                              for(var27 = var40 - var39; var27 <= var39 + var40; ++var27) {
                                 for(var28 = var24 - var39; var28 <= var24 + var39; ++var28) {
                                    var29 = var27 - var16;
                                    int var30 = var28 - var17;
                                    if(var29 >= 0 && var30 >= 0 && var29 < 128 && var30 < 128 && class118.field1843[var29][var30] < 100) {
                                       int var31 = 0;
                                       if(var27 < var40) {
                                          var31 = var40 - var27;
                                       } else if(var27 > var40 + var34 - 1) {
                                          var31 = var27 - (var40 + var34 - 1);
                                       }

                                       int var32 = 0;
                                       if(var28 < var24) {
                                          var32 = var24 - var28;
                                       } else if(var28 > var26 + var24 - 1) {
                                          var32 = var28 - (var24 + var26 - 1);
                                       }

                                       int var33 = var31 * var31 + var32 * var32;
                                       if(var33 < var38 || var33 == var38 && class118.field1843[var29][var30] < var21) {
                                          var38 = var33;
                                          var21 = class118.field1843[var29][var30];
                                          var18 = var27;
                                          var37 = var28;
                                       }
                                    }
                                 }
                              }

                              if(var38 == Integer.MAX_VALUE) {
                                 var8 = -1;
                                 break label674;
                              }
                           }

                           if(var5 == var18 && var37 == var6) {
                              var8 = 0;
                           } else {
                              var20 = 0;
                              class118.field1846[var20] = var18;
                              var38 = var20 + 1;
                              class118.field1847[var20] = var37;

                              for(var21 = var22 = class118.field1845[var18 - var16][var37 - var17]; var18 != var5 || var37 != var6; var21 = class118.field1845[var18 - var16][var37 - var17]) {
                                 if(var21 != var22) {
                                    var22 = var21;
                                    class118.field1846[var38] = var18;
                                    class118.field1847[var38++] = var37;
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
                                 var13[var40] = class118.field1846[var38];
                                 var14[var40++] = class118.field1847[var38];
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
                              break label635;
                           }

                           var4.method231(Client.field566[var16], Client.field567[var16], (byte)2);
                           ++var16;
                        }
                     }

                     for(var16 = 0; var16 < 128; ++var16) {
                        class118.field1845[var15][var16] = 0;
                        class118.field1843[var15][var16] = 99999999;
                     }

                     ++var15;
                  }
               }
            }

            this.method231(var1, var2, var3);
         } else {
            this.method236(var1, var2);
         }
      } else {
         this.method236(var1, var2);
      }

   }
}
