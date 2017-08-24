import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "Lbo;"
   )
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2145909819
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 47353189
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("p")
   boolean field919;
   @ObfuscatedName("n")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1295175031
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1100083017
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 656741381
   )
   @Export("team")
   int team;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2145402073
   )
   int field929;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1684904715
   )
   int field921;
   @ObfuscatedName("x")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("g")
   boolean field909;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lem;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -400882121
   )
   int field911;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 809936991
   )
   int field927;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1039157913
   )
   int field908;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1207573275
   )
   int field910;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 558337393
   )
   int field913;
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1170058087
   )
   int field905;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1020186015
   )
   int field926;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1855138233
   )
   int field923;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -24994077
   )
   int field915;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1381825389
   )
   int field916;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1014496133
   )
   int field922;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 143764733
   )
   int field900;

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.field929 = 0;
      this.field921 = 0;
      this.field919 = false;
      this.team = 0;
      this.hidden = false;
      this.field909 = false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lem;",
      garbageValue = "-1455933636"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class216.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field919 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class216.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4011(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2515();
            super.field1279 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field919 && super.graphic != -1 && super.field1267 != -1) {
               var4 = class15.getSpotAnimType(super.graphic).method4339(super.field1267);
               if(var4 != null) {
                  var4.method2526(0, -super.field1270, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field919 && this.model != null) {
               if(Client.gameCycle >= this.field921) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field929 && Client.gameCycle < this.field921) {
                  var4 = this.model;
                  var4.method2526(this.field911 - super.x, this.field927 - this.field908, this.field913 - super.y);
                  if(super.orientation == 512) {
                     var4.method2509();
                     var4.method2509();
                     var4.method2509();
                  } else if(super.orientation == 1024) {
                     var4.method2509();
                     var4.method2509();
                  } else if(super.orientation == 1536) {
                     var4.method2509();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2509();
                  } else if(super.orientation == 1024) {
                     var4.method2509();
                     var4.method2509();
                  } else if(super.orientation == 1536) {
                     var4.method2509();
                     var4.method2509();
                     var4.method2509();
                  }

                  var4.method2526(super.x - this.field911, this.field908 - this.field927, super.y - this.field913);
               }
            }

            var3.field1957 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "202136555"
   )
   void method1153(int var1, int var2) {
      super.queueSize = 0;
      super.field1249 = 0;
      super.field1287 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1533325603"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class171.getNpcDefinition(this.composition.transformedNpcId).field3574:1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1092187868"
   )
   final void method1154(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1286[var4] = super.field1286[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1286[0] = var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-2067422632"
   )
   final void method1152(int var1, int var2, byte var3) {
      if(super.animation != -1 && class216.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1257 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.getSize();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var10 = this.getSize();
                  Client.field963.field2314 = var1;
                  Client.field963.field2315 = var2;
                  Client.field963.field2316 = 1;
                  Client.field963.field2317 = 1;
                  class73 var11 = Client.field963;
                  int var12 = class81.method1611(var5, var6, var10, var11, Client.collisionMaps[this.field910], true, Client.field1208, Client.field1203);
                  if(var12 >= 1) {
                     for(int var13 = 0; var13 < var12 - 1; ++var13) {
                        var4.method1154(Client.field1208[var13], Client.field1203[var13], (byte)2);
                     }
                  }
               }
            }

            this.method1154(var1, var2, var3);
         } else {
            this.method1153(var1, var2);
         }
      } else {
         this.method1153(var1, var2);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "1696594620"
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
               int var8 = class169.getItemDefinition(var4[var5] - 512).field3531;
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

      super.field1253 = var1.readUnsignedShort();
      if(super.field1253 == '\uffff') {
         super.field1253 = -1;
      }

      super.field1251 = super.field1253;
      super.field1268 = var1.readUnsignedShort();
      if(super.field1268 == '\uffff') {
         super.field1268 = -1;
      }

      super.field1238 = var1.readUnsignedShort();
      if(super.field1238 == '\uffff') {
         super.field1238 = -1;
      }

      super.field1288 = var1.readUnsignedShort();
      if(super.field1288 == '\uffff') {
         super.field1288 = -1;
      }

      super.field1230 = var1.readUnsignedShort();
      if(super.field1230 == '\uffff') {
         super.field1230 = -1;
      }

      super.field1272 = var1.readUnsignedShort();
      if(super.field1272 == '\uffff') {
         super.field1272 = -1;
      }

      this.name = var1.readString();
      if(this == localPlayer) {
         class153.field2227 = this.name;
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

      this.composition.method3994(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-13887992"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIIILel;Lfh;I)V",
      garbageValue = "806443936"
   )
   static final void method1167(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = GameObject.getObjectDefinition(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.sizeX;
         var11 = var9.sizeY;
      } else {
         var10 = var9.sizeY;
         var11 = var9.sizeX;
      }

      int var12;
      int var13;
      if(var10 + var2 <= 104) {
         var12 = (var10 >> 1) + var2;
         var13 = var2 + (var10 + 1 >> 1);
      } else {
         var12 = var2;
         var13 = var2 + 1;
      }

      int var14;
      int var15;
      if(var3 + var11 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = var3 + (var11 + 1 >> 1);
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class61.tileHeights[var1];
      int var17 = var16[var12][var15] + var16[var12][var14] + var16[var13][var14] + var16[var13][var15] >> 2;
      int var18 = (var2 << 7) + (var10 << 6);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = (var3 << 7) + var2 + (var4 << 14) + 1073741824;
      if(var9.field3454 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(var9.field3474 == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4530(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new DynamicObject(var4, 22, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         var7.groundObjectSpawned(var0, var2, var3, var17, (Renderable)var22, var20, var21);
         if(var9.interactType == 1) {
            var8.block(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4530(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method2722(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
            if(var9.interactType != 0) {
               var8.addObject(var2, var3, var10, var11, var9.field3452);
            }

         } else if(var6 == 0) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4530(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field766[var5], 0, var20, var21);
            if(var9.interactType != 0) {
               var8.addWall(var2, var3, var6, var5, var9.field3452);
            }

         } else if(var6 == 1) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method4530(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new DynamicObject(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field768[var5], 0, var20, var21);
            if(var9.interactType != 0) {
               var8.addWall(var2, var3, var6, var5, var9.field3452);
            }

         } else {
            Object var24;
            int var27;
            if(var6 == 2) {
               var27 = var5 + 1 & 3;
               Object var23;
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var23 = var9.method4530(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method4530(2, var27, var16, var18, var17, var19);
               } else {
                  var23 = new DynamicObject(var4, 2, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  var24 = new DynamicObject(var4, 2, var27, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundary(var0, var2, var3, var17, (Renderable)var23, (Renderable)var24, class61.field766[var5], class61.field766[var27], var20, var21);
               if(var9.interactType != 0) {
                  var8.addWall(var2, var3, var6, var5, var9.field3452);
               }

            } else if(var6 == 3) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4530(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundary(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field768[var5], 0, var20, var21);
               if(var9.interactType != 0) {
                  var8.addWall(var2, var3, var6, var5, var9.field3452);
               }

            } else if(var6 == 9) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4530(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method2722(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
               if(var9.interactType != 0) {
                  var8.addObject(var2, var3, var10, var11, var9.field3452);
               }

            } else if(var6 == 4) {
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var22 = var9.method4530(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class61.field766[var5], 0, 0, 0, var20, var21);
            } else {
               int var28;
               if(var6 == 5) {
                  var27 = 16;
                  var28 = var7.method2896(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = GameObject.getObjectDefinition(var28 >> 14 & 32767).field3458;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4530(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class61.field766[var5], 0, var27 * class61.field771[var5], var27 * class61.field772[var5], var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var28 = var7.method2896(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = GameObject.getObjectDefinition(var28 >> 14 & 32767).field3458 / 2;
                  }

                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4530(4, var5 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, var27 * class61.field762[var5], var27 * class61.field774[var5], var20, var21);
               } else if(var6 == 7) {
                  var28 = var5 + 2 & 3;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var22 = var9.method4530(4, var28 + 4, var16, var18, var17, var19);
                  } else {
                     var22 = new DynamicObject(var4, 4, var28 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, 256, var28, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var28 = var7.method2896(var0, var2, var3);
                  if(var28 != 0) {
                     var27 = GameObject.getObjectDefinition(var28 >> 14 & 32767).field3458 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(var9.animationId == -1 && var9.impostorIds == null) {
                     var24 = var9.method4530(4, var5 + 4, var16, var18, var17, var19);
                     var25 = var9.method4530(4, var26 + 4, var16, var18, var17, var19);
                  } else {
                     var24 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                     var25 = new DynamicObject(var4, 4, var26 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.addBoundaryDecoration(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, var27 * class61.field762[var5], var27 * class61.field774[var5], var20, var21);
               }
            }
         }
      } else {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method4530(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new DynamicObject(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         if(var22 != null) {
            var7.method2722(var0, var2, var3, var17, var10, var11, (Renderable)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.interactType != 0) {
            var8.addObject(var2, var3, var10, var11, var9.field3452);
         }

      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "47"
   )
   static final void method1160() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            class25.method210(var0);
         } else {
            var0.unlink();
         }
      }

   }
}
