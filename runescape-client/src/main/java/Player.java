import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 557006203
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -635290359
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("l")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1433696081
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1427448495
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 633781539
   )
   int field822;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -399769919
   )
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -396730067
   )
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1944089661
   )
   int field825;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -541393853
   )
   int field826;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 654625669
   )
   int field837;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 184464963
   )
   int field829;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1242474233
   )
   int field830;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1482594897
   )
   int field818;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -276634109
   )
   int field836;
   @ObfuscatedName("u")
   @Export("isLowDetail")
   boolean isLowDetail;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1374773581
   )
   @Export("team")
   int team;
   @ObfuscatedName("w")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1724379715
   )
   int field831;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -824978209
   )
   @Export("playerId")
   int playerId;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   class303 field838;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   class303 field815;
   @ObfuscatedName("ax")
   boolean field840;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1457946459
   )
   int field842;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1857822777
   )
   int field839;

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
      this.field838 = class303.field3856;
      this.field815 = class303.field3856;
      this.field840 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgg;B)V",
      garbageValue = "127"
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
               int var8 = NetWriter.getItemDefinition(var4[var5] - 512).team;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class229.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == 65535) {
         super.idlePoseAnimation = -1;
      }

      super.field1189 = var1.readUnsignedShort();
      if(super.field1189 == 65535) {
         super.field1189 = -1;
      }

      super.field1157 = super.field1189;
      super.field1148 = var1.readUnsignedShort();
      if(super.field1148 == 65535) {
         super.field1148 = -1;
      }

      super.field1149 = var1.readUnsignedShort();
      if(super.field1149 == 65535) {
         super.field1149 = -1;
      }

      super.field1150 = var1.readUnsignedShort();
      if(super.field1150 == 65535) {
         super.field1150 = -1;
      }

      super.field1180 = var1.readUnsignedShort();
      if(super.field1180 == 65535) {
         super.field1180 = -1;
      }

      super.field1152 = var1.readUnsignedShort();
      if(super.field1152 == 65535) {
         super.field1152 = -1;
      }

      this.name = new Name(var1.readString(), DecorativeObject.loginType);
      this.method1229();
      this.method1212();
      if(this == class265.localPlayer) {
         RunException.field2169 = this.name.getName();
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

      this.composition.method4513(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "17"
   )
   @Export("isFriend")
   boolean isFriend() {
      if(this.field838 == class303.field3856) {
         this.method1246();
      }

      return this.field838 == class303.field3858;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-379362491"
   )
   void method1229() {
      this.field838 = class303.field3856;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1541245648"
   )
   void method1246() {
      this.field838 = CacheFile.friendManager.method1794(this.name)?class303.field3858:class303.field3855;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "47"
   )
   @Export("isClanMember")
   boolean isClanMember() {
      if(this.field815 == class303.field3856) {
         this.method1213();
      }

      return this.field815 == class303.field3858;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1131135920"
   )
   void method1212() {
      this.field815 = class303.field3856;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1604896432"
   )
   void method1213() {
      this.field815 = LoginPacket.clanMemberManager != null && LoginPacket.clanMemberManager.isMember(this.name)?class303.field3858:class303.field3855;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1655721393"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?SceneTilePaint.getNpcDefinition(this.composition.transformedNpcId).size:1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lee;",
      garbageValue = "-1967116980"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?NPC.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.isLowDetail || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:NPC.getAnimation(super.poseAnimation);
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.isLowDetail && super.graphic != -1 && super.spotAnimFrame != -1) {
               var4 = WidgetNode.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1187, 0);
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
                  var4.offsetBy(this.field825 - super.x, this.field826 - this.field822, this.field837 - super.y);
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

                  var4.offsetBy(super.x - this.field825, this.field822 - this.field826, super.y - this.field837);
               }
            }

            var3.field1847 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-54"
   )
   final void method1216(int var1, int var2, byte var3) {
      if(super.animation != -1 && NPC.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1168 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.getSize();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var9 = this.getSize();
                  Client.field1122.field2275 = var1;
                  Client.field1122.field2273 = var2;
                  Client.field1122.field2276 = 1;
                  Client.field1122.field2274 = 1;
                  class71 var10 = Client.field1122;
                  class71 var11 = var10;
                  CollisionData var12 = Client.collisionMaps[this.field831];
                  int[] var13 = Client.field1123;
                  int[] var14 = Client.field1124;
                  int var15 = 0;

                  label918:
                  while(true) {
                     int var16;
                     if(var15 >= 128) {
                        int var17;
                        int var18;
                        byte var19;
                        byte var20;
                        int var21;
                        int var22;
                        byte var23;
                        int var24;
                        int[][] var25;
                        int var26;
                        int var27;
                        int var28;
                        int var29;
                        boolean var35;
                        boolean var36;
                        int var37;
                        int var38;
                        int var40;
                        if(var9 == 1) {
                           var17 = var5;
                           var18 = var6;
                           var19 = 64;
                           var20 = 64;
                           var21 = var5 - var19;
                           var22 = var6 - var20;
                           class177.field2266[var19][var20] = 99;
                           class177.field2264[var19][var20] = 0;
                           var23 = 0;
                           var24 = 0;
                           class177.field2270[var23] = var5;
                           var40 = var23 + 1;
                           class177.field2269[var23] = var6;
                           var25 = var12.flags;

                           while(true) {
                              if(var24 == var40) {
                                 class177.field2268 = var17;
                                 class177.field2271 = var18;
                                 var36 = false;
                                 break;
                              }

                              var17 = class177.field2270[var24];
                              var18 = class177.field2269[var24];
                              var24 = var24 + 1 & 4095;
                              var37 = var17 - var21;
                              var38 = var18 - var22;
                              var26 = var17 - var12.x;
                              var27 = var18 - var12.y;
                              if(var11.vmethod3496(1, var17, var18, var12)) {
                                 class177.field2268 = var17;
                                 class177.field2271 = var18;
                                 var36 = true;
                                 break;
                              }

                              var28 = class177.field2264[var37][var38] + 1;
                              if(var37 > 0 && class177.field2266[var37 - 1][var38] == 0 && (var25[var26 - 1][var27] & 19136776) == 0) {
                                 class177.field2270[var40] = var17 - 1;
                                 class177.field2269[var40] = var18;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 - 1][var38] = 2;
                                 class177.field2264[var37 - 1][var38] = var28;
                              }

                              if(var37 < 127 && class177.field2266[var37 + 1][var38] == 0 && (var25[var26 + 1][var27] & 19136896) == 0) {
                                 class177.field2270[var40] = var17 + 1;
                                 class177.field2269[var40] = var18;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 + 1][var38] = 8;
                                 class177.field2264[var37 + 1][var38] = var28;
                              }

                              if(var38 > 0 && class177.field2266[var37][var38 - 1] == 0 && (var25[var26][var27 - 1] & 19136770) == 0) {
                                 class177.field2270[var40] = var17;
                                 class177.field2269[var40] = var18 - 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37][var38 - 1] = 1;
                                 class177.field2264[var37][var38 - 1] = var28;
                              }

                              if(var38 < 127 && class177.field2266[var37][var38 + 1] == 0 && (var25[var26][var27 + 1] & 19136800) == 0) {
                                 class177.field2270[var40] = var17;
                                 class177.field2269[var40] = var18 + 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37][var38 + 1] = 4;
                                 class177.field2264[var37][var38 + 1] = var28;
                              }

                              if(var37 > 0 && var38 > 0 && class177.field2266[var37 - 1][var38 - 1] == 0 && (var25[var26 - 1][var27 - 1] & 19136782) == 0 && (var25[var26 - 1][var27] & 19136776) == 0 && (var25[var26][var27 - 1] & 19136770) == 0) {
                                 class177.field2270[var40] = var17 - 1;
                                 class177.field2269[var40] = var18 - 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 - 1][var38 - 1] = 3;
                                 class177.field2264[var37 - 1][var38 - 1] = var28;
                              }

                              if(var37 < 127 && var38 > 0 && class177.field2266[var37 + 1][var38 - 1] == 0 && (var25[var26 + 1][var27 - 1] & 19136899) == 0 && (var25[var26 + 1][var27] & 19136896) == 0 && (var25[var26][var27 - 1] & 19136770) == 0) {
                                 class177.field2270[var40] = var17 + 1;
                                 class177.field2269[var40] = var18 - 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 + 1][var38 - 1] = 9;
                                 class177.field2264[var37 + 1][var38 - 1] = var28;
                              }

                              if(var37 > 0 && var38 < 127 && class177.field2266[var37 - 1][var38 + 1] == 0 && (var25[var26 - 1][var27 + 1] & 19136824) == 0 && (var25[var26 - 1][var27] & 19136776) == 0 && (var25[var26][var27 + 1] & 19136800) == 0) {
                                 class177.field2270[var40] = var17 - 1;
                                 class177.field2269[var40] = var18 + 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 - 1][var38 + 1] = 6;
                                 class177.field2264[var37 - 1][var38 + 1] = var28;
                              }

                              if(var37 < 127 && var38 < 127 && class177.field2266[var37 + 1][var38 + 1] == 0 && (var25[var26 + 1][var27 + 1] & 19136992) == 0 && (var25[var26 + 1][var27] & 19136896) == 0 && (var25[var26][var27 + 1] & 19136800) == 0) {
                                 class177.field2270[var40] = var17 + 1;
                                 class177.field2269[var40] = var18 + 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 + 1][var38 + 1] = 12;
                                 class177.field2264[var37 + 1][var38 + 1] = var28;
                              }
                           }

                           var35 = var36;
                        } else if(var9 == 2) {
                           var17 = var5;
                           var18 = var6;
                           var19 = 64;
                           var20 = 64;
                           var21 = var5 - var19;
                           var22 = var6 - var20;
                           class177.field2266[var19][var20] = 99;
                           class177.field2264[var19][var20] = 0;
                           var23 = 0;
                           var24 = 0;
                           class177.field2270[var23] = var5;
                           var40 = var23 + 1;
                           class177.field2269[var23] = var6;
                           var25 = var12.flags;

                           while(true) {
                              if(var40 == var24) {
                                 class177.field2268 = var17;
                                 class177.field2271 = var18;
                                 var36 = false;
                                 break;
                              }

                              var17 = class177.field2270[var24];
                              var18 = class177.field2269[var24];
                              var24 = var24 + 1 & 4095;
                              var37 = var17 - var21;
                              var38 = var18 - var22;
                              var26 = var17 - var12.x;
                              var27 = var18 - var12.y;
                              if(var11.vmethod3496(2, var17, var18, var12)) {
                                 class177.field2268 = var17;
                                 class177.field2271 = var18;
                                 var36 = true;
                                 break;
                              }

                              var28 = class177.field2264[var37][var38] + 1;
                              if(var37 > 0 && class177.field2266[var37 - 1][var38] == 0 && (var25[var26 - 1][var27] & 19136782) == 0 && (var25[var26 - 1][var27 + 1] & 19136824) == 0) {
                                 class177.field2270[var40] = var17 - 1;
                                 class177.field2269[var40] = var18;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 - 1][var38] = 2;
                                 class177.field2264[var37 - 1][var38] = var28;
                              }

                              if(var37 < 126 && class177.field2266[var37 + 1][var38] == 0 && (var25[var26 + 2][var27] & 19136899) == 0 && (var25[var26 + 2][var27 + 1] & 19136992) == 0) {
                                 class177.field2270[var40] = var17 + 1;
                                 class177.field2269[var40] = var18;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 + 1][var38] = 8;
                                 class177.field2264[var37 + 1][var38] = var28;
                              }

                              if(var38 > 0 && class177.field2266[var37][var38 - 1] == 0 && (var25[var26][var27 - 1] & 19136782) == 0 && (var25[var26 + 1][var27 - 1] & 19136899) == 0) {
                                 class177.field2270[var40] = var17;
                                 class177.field2269[var40] = var18 - 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37][var38 - 1] = 1;
                                 class177.field2264[var37][var38 - 1] = var28;
                              }

                              if(var38 < 126 && class177.field2266[var37][var38 + 1] == 0 && (var25[var26][var27 + 2] & 19136824) == 0 && (var25[var26 + 1][var27 + 2] & 19136992) == 0) {
                                 class177.field2270[var40] = var17;
                                 class177.field2269[var40] = var18 + 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37][var38 + 1] = 4;
                                 class177.field2264[var37][var38 + 1] = var28;
                              }

                              if(var37 > 0 && var38 > 0 && class177.field2266[var37 - 1][var38 - 1] == 0 && (var25[var26 - 1][var27] & 19136830) == 0 && (var25[var26 - 1][var27 - 1] & 19136782) == 0 && (var25[var26][var27 - 1] & 19136911) == 0) {
                                 class177.field2270[var40] = var17 - 1;
                                 class177.field2269[var40] = var18 - 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 - 1][var38 - 1] = 3;
                                 class177.field2264[var37 - 1][var38 - 1] = var28;
                              }

                              if(var37 < 126 && var38 > 0 && class177.field2266[var37 + 1][var38 - 1] == 0 && (var25[var26 + 1][var27 - 1] & 19136911) == 0 && (var25[var26 + 2][var27 - 1] & 19136899) == 0 && (var25[var26 + 2][var27] & 19136995) == 0) {
                                 class177.field2270[var40] = var17 + 1;
                                 class177.field2269[var40] = var18 - 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 + 1][var38 - 1] = 9;
                                 class177.field2264[var37 + 1][var38 - 1] = var28;
                              }

                              if(var37 > 0 && var38 < 126 && class177.field2266[var37 - 1][var38 + 1] == 0 && (var25[var26 - 1][var27 + 1] & 19136830) == 0 && (var25[var26 - 1][var27 + 2] & 19136824) == 0 && (var25[var26][var27 + 2] & 19137016) == 0) {
                                 class177.field2270[var40] = var17 - 1;
                                 class177.field2269[var40] = var18 + 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 - 1][var38 + 1] = 6;
                                 class177.field2264[var37 - 1][var38 + 1] = var28;
                              }

                              if(var37 < 126 && var38 < 126 && class177.field2266[var37 + 1][var38 + 1] == 0 && (var25[var26 + 1][var27 + 2] & 19137016) == 0 && (var25[var26 + 2][var27 + 2] & 19136992) == 0 && (var25[var26 + 2][var27 + 1] & 19136995) == 0) {
                                 class177.field2270[var40] = var17 + 1;
                                 class177.field2269[var40] = var18 + 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 + 1][var38 + 1] = 12;
                                 class177.field2264[var37 + 1][var38 + 1] = var28;
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
                           class177.field2266[var19][var20] = 99;
                           class177.field2264[var19][var20] = 0;
                           var23 = 0;
                           var24 = 0;
                           class177.field2270[var23] = var5;
                           var40 = var23 + 1;
                           class177.field2269[var23] = var6;
                           var25 = var12.flags;

                           label888:
                           while(true) {
                              label886:
                              while(true) {
                                 do {
                                    do {
                                       do {
                                          label863:
                                          do {
                                             if(var40 == var24) {
                                                class177.field2268 = var17;
                                                class177.field2271 = var18;
                                                var36 = false;
                                                break label888;
                                             }

                                             var17 = class177.field2270[var24];
                                             var18 = class177.field2269[var24];
                                             var24 = var24 + 1 & 4095;
                                             var37 = var17 - var21;
                                             var38 = var18 - var22;
                                             var26 = var17 - var12.x;
                                             var27 = var18 - var12.y;
                                             if(var11.vmethod3496(var9, var17, var18, var12)) {
                                                class177.field2268 = var17;
                                                class177.field2271 = var18;
                                                var36 = true;
                                                break label888;
                                             }

                                             var28 = class177.field2264[var37][var38] + 1;
                                             if(var37 > 0 && class177.field2266[var37 - 1][var38] == 0 && (var25[var26 - 1][var27] & 19136782) == 0 && (var25[var26 - 1][var9 + var27 - 1] & 19136824) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9 - 1) {
                                                      class177.field2270[var40] = var17 - 1;
                                                      class177.field2269[var40] = var18;
                                                      var40 = var40 + 1 & 4095;
                                                      class177.field2266[var37 - 1][var38] = 2;
                                                      class177.field2264[var37 - 1][var38] = var28;
                                                      break;
                                                   }

                                                   if((var25[var26 - 1][var29 + var27] & 19136830) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var37 < 128 - var9 && class177.field2266[var37 + 1][var38] == 0 && (var25[var26 + var9][var27] & 19136899) == 0 && (var25[var26 + var9][var27 + var9 - 1] & 19136992) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9 - 1) {
                                                      class177.field2270[var40] = var17 + 1;
                                                      class177.field2269[var40] = var18;
                                                      var40 = var40 + 1 & 4095;
                                                      class177.field2266[var37 + 1][var38] = 8;
                                                      class177.field2264[var37 + 1][var38] = var28;
                                                      break;
                                                   }

                                                   if((var25[var9 + var26][var29 + var27] & 19136995) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var38 > 0 && class177.field2266[var37][var38 - 1] == 0 && (var25[var26][var27 - 1] & 19136782) == 0 && (var25[var26 + var9 - 1][var27 - 1] & 19136899) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9 - 1) {
                                                      class177.field2270[var40] = var17;
                                                      class177.field2269[var40] = var18 - 1;
                                                      var40 = var40 + 1 & 4095;
                                                      class177.field2266[var37][var38 - 1] = 1;
                                                      class177.field2264[var37][var38 - 1] = var28;
                                                      break;
                                                   }

                                                   if((var25[var29 + var26][var27 - 1] & 19136911) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var38 < 128 - var9 && class177.field2266[var37][var38 + 1] == 0 && (var25[var26][var27 + var9] & 19136824) == 0 && (var25[var9 + var26 - 1][var27 + var9] & 19136992) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9 - 1) {
                                                      class177.field2270[var40] = var17;
                                                      class177.field2269[var40] = var18 + 1;
                                                      var40 = var40 + 1 & 4095;
                                                      class177.field2266[var37][var38 + 1] = 4;
                                                      class177.field2264[var37][var38 + 1] = var28;
                                                      break;
                                                   }

                                                   if((var25[var29 + var26][var27 + var9] & 19137016) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var37 > 0 && var38 > 0 && class177.field2266[var37 - 1][var38 - 1] == 0 && (var25[var26 - 1][var27 - 1] & 19136782) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9) {
                                                      class177.field2270[var40] = var17 - 1;
                                                      class177.field2269[var40] = var18 - 1;
                                                      var40 = var40 + 1 & 4095;
                                                      class177.field2266[var37 - 1][var38 - 1] = 3;
                                                      class177.field2264[var37 - 1][var38 - 1] = var28;
                                                      break;
                                                   }

                                                   if((var25[var26 - 1][var29 + (var27 - 1)] & 19136830) != 0 || (var25[var29 + (var26 - 1)][var27 - 1] & 19136911) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var37 < 128 - var9 && var38 > 0 && class177.field2266[var37 + 1][var38 - 1] == 0 && (var25[var9 + var26][var27 - 1] & 19136899) == 0) {
                                                var29 = 1;

                                                while(true) {
                                                   if(var29 >= var9) {
                                                      class177.field2270[var40] = var17 + 1;
                                                      class177.field2269[var40] = var18 - 1;
                                                      var40 = var40 + 1 & 4095;
                                                      class177.field2266[var37 + 1][var38 - 1] = 9;
                                                      class177.field2264[var37 + 1][var38 - 1] = var28;
                                                      break;
                                                   }

                                                   if((var25[var9 + var26][var29 + (var27 - 1)] & 19136995) != 0 || (var25[var26 + var29][var27 - 1] & 19136911) != 0) {
                                                      break;
                                                   }

                                                   ++var29;
                                                }
                                             }

                                             if(var37 > 0 && var38 < 128 - var9 && class177.field2266[var37 - 1][var38 + 1] == 0 && (var25[var26 - 1][var9 + var27] & 19136824) == 0) {
                                                for(var29 = 1; var29 < var9; ++var29) {
                                                   if((var25[var26 - 1][var29 + var27] & 19136830) != 0 || (var25[var29 + (var26 - 1)][var9 + var27] & 19137016) != 0) {
                                                      continue label863;
                                                   }
                                                }

                                                class177.field2270[var40] = var17 - 1;
                                                class177.field2269[var40] = var18 + 1;
                                                var40 = var40 + 1 & 4095;
                                                class177.field2266[var37 - 1][var38 + 1] = 6;
                                                class177.field2264[var37 - 1][var38 + 1] = var28;
                                             }
                                          } while(var37 >= 128 - var9);
                                       } while(var38 >= 128 - var9);
                                    } while(class177.field2266[var37 + 1][var38 + 1] != 0);
                                 } while((var25[var9 + var26][var27 + var9] & 19136992) != 0);

                                 for(var29 = 1; var29 < var9; ++var29) {
                                    if((var25[var29 + var26][var27 + var9] & 19137016) != 0 || (var25[var26 + var9][var27 + var29] & 19136995) != 0) {
                                       continue label886;
                                    }
                                 }

                                 class177.field2270[var40] = var17 + 1;
                                 class177.field2269[var40] = var18 + 1;
                                 var40 = var40 + 1 & 4095;
                                 class177.field2266[var37 + 1][var38 + 1] = 12;
                                 class177.field2264[var37 + 1][var38 + 1] = var28;
                              }
                           }

                           var35 = var36;
                        }

                        int var8;
                        label961: {
                           var16 = var5 - 64;
                           var17 = var6 - 64;
                           var18 = class177.field2268;
                           var37 = class177.field2271;
                           if(!var35) {
                              var38 = Integer.MAX_VALUE;
                              var21 = Integer.MAX_VALUE;
                              byte var39 = 10;
                              var40 = var11.field2275;
                              var24 = var11.field2273;
                              int var34 = var11.field2276;
                              var26 = var11.field2274;

                              for(var27 = var40 - var39; var27 <= var39 + var40; ++var27) {
                                 for(var28 = var24 - var39; var28 <= var24 + var39; ++var28) {
                                    var29 = var27 - var16;
                                    int var30 = var28 - var17;
                                    if(var29 >= 0 && var30 >= 0 && var29 < 128 && var30 < 128 && class177.field2264[var29][var30] < 100) {
                                       int var31 = 0;
                                       if(var27 < var40) {
                                          var31 = var40 - var27;
                                       } else if(var27 > var40 + var34 - 1) {
                                          var31 = var27 - (var34 + var40 - 1);
                                       }

                                       int var32 = 0;
                                       if(var28 < var24) {
                                          var32 = var24 - var28;
                                       } else if(var28 > var26 + var24 - 1) {
                                          var32 = var28 - (var26 + var24 - 1);
                                       }

                                       int var33 = var31 * var31 + var32 * var32;
                                       if(var33 < var38 || var38 == var33 && class177.field2264[var29][var30] < var21) {
                                          var38 = var33;
                                          var21 = class177.field2264[var29][var30];
                                          var18 = var27;
                                          var37 = var28;
                                       }
                                    }
                                 }
                              }

                              if(var38 == Integer.MAX_VALUE) {
                                 var8 = -1;
                                 break label961;
                              }
                           }

                           if(var18 == var5 && var37 == var6) {
                              var8 = 0;
                           } else {
                              var20 = 0;
                              class177.field2270[var20] = var18;
                              var38 = var20 + 1;
                              class177.field2269[var20] = var37;

                              for(var21 = var22 = class177.field2266[var18 - var16][var37 - var17]; var5 != var18 || var6 != var37; var21 = class177.field2266[var18 - var16][var37 - var17]) {
                                 if(var21 != var22) {
                                    var22 = var21;
                                    class177.field2270[var38] = var18;
                                    class177.field2269[var38++] = var37;
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
                                 var13[var40] = class177.field2270[var38];
                                 var14[var40++] = class177.field2269[var38];
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
                              break label918;
                           }

                           var4.method1217(Client.field1123[var16], Client.field1124[var16], (byte)2);
                           ++var16;
                        }
                     }

                     for(var16 = 0; var16 < 128; ++var16) {
                        class177.field2266[var15][var16] = 0;
                        class177.field2264[var15][var16] = 99999999;
                     }

                     ++var15;
                  }
               }
            }

            this.method1217(var1, var2, var3);
         } else {
            this.method1250(var1, var2);
         }
      } else {
         this.method1250(var1, var2);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "113775460"
   )
   void method1250(int var1, int var2) {
      super.queueSize = 0;
      super.field1178 = 0;
      super.field1192 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-59"
   )
   final void method1217(int var1, int var2, byte var3) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "14"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;B)V",
      garbageValue = "-50"
   )
   public static void method1255(IndexDataBase var0) {
      Overlay.overlay_ref = var0;
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(Lkc;IIII)V",
      garbageValue = "-1761302427"
   )
   @Export("queueAnimationSound")
   static void queueAnimationSound(Sequence var0, int var1, int var2, int var3) {
      if(Client.queuedSoundEffectCount < 50 && Client.field1018 != 0) {
         if(var0.field3764 != null && var1 < var0.field3764.length) {
            int var4 = var0.field3764[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var5;
               Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var6;
               Client.unknownSoundValues2[Client.queuedSoundEffectCount] = 0;
               Client.audioEffects[Client.queuedSoundEffectCount] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.soundLocations[Client.queuedSoundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.queuedSoundEffectCount;
            }
         }
      }
   }
}
