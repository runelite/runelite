import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lja;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -341921313
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1372244859
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("w")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1310419625
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 786473363
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -464427597
   )
   int field813;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1380321181
   )
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2093681697
   )
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1511148897
   )
   int field816;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1814466273
   )
   int field817;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 35837039
   )
   int field807;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Les;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1609049439
   )
   int field820;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2094853143
   )
   int field821;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1460823647
   )
   int field815;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 151776825
   )
   int field812;
   @ObfuscatedName("p")
   @Export("isLowDetail")
   boolean isLowDetail;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -40662737
   )
   @Export("team")
   int team;
   @ObfuscatedName("n")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -294427735
   )
   int field827;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -877664069
   )
   int field822;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   class278 field829;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljy;"
   )
   class278 field830;
   @ObfuscatedName("ad")
   boolean field831;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 447676553
   )
   int field832;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 285064083
   )
   int field833;

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
      this.field829 = class278.field3716;
      this.field830 = class278.field3716;
      this.field831 = false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "75"
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
               int var8 = ItemContainer.getItemDefinition(var4[var5] - 512).int1;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= BoundingBox.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == 65535) {
         super.idlePoseAnimation = -1;
      }

      super.field1120 = var1.readUnsignedShort();
      if(super.field1120 == 65535) {
         super.field1120 = -1;
      }

      super.field1121 = super.field1120;
      super.field1156 = var1.readUnsignedShort();
      if(super.field1156 == 65535) {
         super.field1156 = -1;
      }

      super.field1123 = var1.readUnsignedShort();
      if(super.field1123 == 65535) {
         super.field1123 = -1;
      }

      super.field1124 = var1.readUnsignedShort();
      if(super.field1124 == 65535) {
         super.field1124 = -1;
      }

      super.field1125 = var1.readUnsignedShort();
      if(super.field1125 == 65535) {
         super.field1125 = -1;
      }

      super.field1126 = var1.readUnsignedShort();
      if(super.field1126 == 65535) {
         super.field1126 = -1;
      }

      this.name = new Name(var1.readString(), class226.loginType);
      this.method1124();
      this.method1153();
      if(this == GroundObject.localPlayer) {
         RunException.field2117 = this.name.getName();
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

      this.composition.method4378(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "2047"
   )
   @Export("isFriend")
   boolean isFriend() {
      if(this.field829 == class278.field3716) {
         this.method1146();
      }

      return this.field829 == class278.field3718;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1528777982"
   )
   void method1124() {
      this.field829 = class278.field3716;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-798579495"
   )
   void method1146() {
      this.field829 = class35.friendManager.field1211.isMember(this.name)?class278.field3718:class278.field3717;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "23"
   )
   @Export("isClanMember")
   boolean isClanMember() {
      if(this.field830 == class278.field3716) {
         this.method1128();
      }

      return this.field830 == class278.field3718;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1941227959"
   )
   void method1153() {
      this.field830 = class278.field3716;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-498541905"
   )
   void method1128() {
      this.field830 = class22.clanMemberManager != null && class22.clanMemberManager.isMember(this.name)?class278.field3718:class278.field3717;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1287224311"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?Spotanim.getNpcDefinition(this.composition.transformedNpcId).field3633:1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Les;",
      garbageValue = "-25440425"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?FileRequest.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.isLowDetail || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:FileRequest.getAnimation(super.poseAnimation);
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.isLowDetail && super.graphic != -1 && super.field1152 != -1) {
               var4 = CollisionData.getSpotAnimType(super.graphic).getModel(super.field1152);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1168, 0);
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
                  var4.offsetBy(this.field816 - super.x, this.field817 - this.field813, this.field807 - super.y);
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

                  var4.offsetBy(super.x - this.field816, this.field813 - this.field817, super.y - this.field807);
               }
            }

            var3.field1869 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1935457567"
   )
   final void method1131(int var1, int var2, byte var3) {
      if(super.animation != -1 && FileRequest.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1142 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.getSize();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var8 = FaceNormal.method3116(var5, var6, this.getSize(), Spotanim.method4732(var1, var2), Client.collisionMaps[this.field827], true, Client.field1095, Client.field1096);
                  if(var8 >= 1) {
                     for(int var9 = 0; var9 < var8 - 1; ++var9) {
                        var4.method1133(Client.field1095[var9], Client.field1096[var9], (byte)2);
                     }
                  }
               }
            }

            this.method1133(var1, var2, var3);
         } else {
            this.method1125(var1, var2);
         }
      } else {
         this.method1125(var1, var2);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1112841944"
   )
   void method1125(int var1, int var2) {
      super.queueSize = 0;
      super.field1161 = 0;
      super.field1172 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-812736799"
   )
   final void method1133(int var1, int var2, byte var3) {
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "3"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIILec;Lfb;I)V",
      garbageValue = "-1683583476"
   )
   @Export("addObject")
   static final void addObject(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.lowMemory || (class62.tileSettings[0][var1][var2] & 2) != 0 || (class62.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class62.field736) {
            class62.field736 = var0;
         }

         ObjectComposition var8 = class219.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.width;
            var10 = var8.length;
         } else {
            var9 = var8.length;
            var10 = var8.width;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class62.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var12][var13] + var15[var11][var13] + var15[var11][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = (var3 << 14) + (var2 << 7) + var1 + 1073741824;
         if(var8.int1 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.supportItems == 1) {
            var20 += 256;
         }

         int var22;
         int var23;
         if(var8.method4928()) {
            class79 var21 = new class79();
            var21.field1221 = var0;
            var21.field1222 = var1 * 128;
            var21.field1235 = var2 * 128;
            var22 = var8.width;
            var23 = var8.length;
            if(var4 == 1 || var4 == 3) {
               var22 = var8.length;
               var23 = var8.width;
            }

            var21.field1224 = (var22 + var1) * 128;
            var21.field1225 = (var23 + var2) * 128;
            var21.field1227 = var8.ambientSoundId;
            var21.field1226 = var8.int4 * 128;
            var21.field1229 = var8.int5;
            var21.field1230 = var8.int6;
            var21.field1228 = var8.field3565;
            if(var8.impostorIds != null) {
               var21.field1234 = var8;
               var21.method1760();
            }

            class79.field1233.addFront(var21);
            if(var21.field1228 != null) {
               var21.field1232 = var21.field1229 + (int)(Math.random() * (double)(var21.field1230 - var21.field1229));
            }
         }

         Object var30;
         if(var5 == 22) {
            if(!Client.lowMemory || var8.int1 != 0 || var8.clipType == 1 || var8.obstructsGround) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(22, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var30, var19, var20);
               if(var8.clipType == 1 && var7 != null) {
                  var7.method3352(var1, var2);
               }

            }
         } else if(var5 != 10 && var5 != 11) {
            if(var5 >= 12) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.method2914(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
               if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class21.field331[var0][var1][var2] |= 2340;
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
               }

            } else if(var5 == 0) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(0, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class62.field729[var4], 0, var19, var20);
               if(var4 == 0) {
                  if(var8.clipped) {
                     class160.field2156[var0][var1][var2] = 50;
                     class160.field2156[var0][var1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class21.field331[var0][var1][var2] |= 585;
                  }
               } else if(var4 == 1) {
                  if(var8.clipped) {
                     class160.field2156[var0][var1][var2 + 1] = 50;
                     class160.field2156[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class21.field331[var0][var1][var2 + 1] |= 1170;
                  }
               } else if(var4 == 2) {
                  if(var8.clipped) {
                     class160.field2156[var0][var1 + 1][var2] = 50;
                     class160.field2156[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if(var8.modelClipped) {
                     class21.field331[var0][var1 + 1][var2] |= 585;
                  }
               } else if(var4 == 3) {
                  if(var8.clipped) {
                     class160.field2156[var0][var1][var2] = 50;
                     class160.field2156[var0][var1 + 1][var2] = 50;
                  }

                  if(var8.modelClipped) {
                     class21.field331[var0][var1][var2] |= 1170;
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.method3380(var1, var2, var5, var4, var8.blocksProjectile);
               }

               if(var8.decorDisplacement != 16) {
                  var6.method2919(var0, var1, var2, var8.decorDisplacement);
               }

            } else if(var5 == 1) {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var30 = var8.getModel(1, var4, var15, var17, var16, var18);
               } else {
                  var30 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class62.field728[var4], 0, var19, var20);
               if(var8.clipped) {
                  if(var4 == 0) {
                     class160.field2156[var0][var1][var2 + 1] = 50;
                  } else if(var4 == 1) {
                     class160.field2156[var0][var1 + 1][var2 + 1] = 50;
                  } else if(var4 == 2) {
                     class160.field2156[var0][var1 + 1][var2] = 50;
                  } else if(var4 == 3) {
                     class160.field2156[var0][var1][var2] = 50;
                  }
               }

               if(var8.clipType != 0 && var7 != null) {
                  var7.method3380(var1, var2, var5, var4, var8.blocksProjectile);
               }

            } else {
               int var26;
               Object var28;
               if(var5 == 2) {
                  var26 = var4 + 1 & 3;
                  Object var27;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var27 = var8.getModel(2, var4 + 4, var15, var17, var16, var18);
                     var28 = var8.getModel(2, var26, var15, var17, var16, var18);
                  } else {
                     var27 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var28 = new DynamicObject(var3, 2, var26, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var27, (Renderable)var28, class62.field729[var4], class62.field729[var26], var19, var20);
                  if(var8.modelClipped) {
                     if(var4 == 0) {
                        class21.field331[var0][var1][var2] |= 585;
                        class21.field331[var0][var1][1 + var2] |= 1170;
                     } else if(var4 == 1) {
                        class21.field331[var0][var1][1 + var2] |= 1170;
                        class21.field331[var0][var1 + 1][var2] |= 585;
                     } else if(var4 == 2) {
                        class21.field331[var0][var1 + 1][var2] |= 585;
                        class21.field331[var0][var1][var2] |= 1170;
                     } else if(var4 == 3) {
                        class21.field331[var0][var1][var2] |= 1170;
                        class21.field331[var0][var1][var2] |= 585;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3380(var1, var2, var5, var4, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method2919(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 3) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(3, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundary(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class62.field728[var4], 0, var19, var20);
                  if(var8.clipped) {
                     if(var4 == 0) {
                        class160.field2156[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class160.field2156[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        class160.field2156[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        class160.field2156[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.clipType != 0 && var7 != null) {
                     var7.method3380(var1, var2, var5, var4, var8.blocksProjectile);
                  }

               } else if(var5 == 9) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(var5, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method2914(var0, var1, var2, var16, 1, 1, (Renderable)var30, 0, var19, var20);
                  if(var8.clipType != 0 && var7 != null) {
                     var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
                  }

                  if(var8.decorDisplacement != 16) {
                     var6.method2919(var0, var1, var2, var8.decorDisplacement);
                  }

               } else if(var5 == 4) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, class62.field729[var4], 0, 0, 0, var19, var20);
               } else if(var5 == 5) {
                  var26 = 16;
                  var22 = var6.method2930(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = class219.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class62.field729[var4], 0, var26 * class62.field731[var4], var26 * class62.field732[var4], var19, var20);
               } else if(var5 == 6) {
                  var26 = 8;
                  var22 = var6.method2930(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = class219.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
                  }

                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var26 * class62.field738[var4], var26 * class62.field733[var4], var19, var20);
               } else if(var5 == 7) {
                  var22 = var4 + 2 & 3;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var30 = var8.getModel(4, var22 + 4, var15, var17, var16, var18);
                  } else {
                     var30 = new DynamicObject(var3, 4, var22 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var30, (Renderable)null, 256, var22, 0, 0, var19, var20);
               } else if(var5 == 8) {
                  var26 = 8;
                  var22 = var6.method2930(var0, var1, var2);
                  if(var22 != 0) {
                     var26 = class219.getObjectDefinition(var22 >> 14 & 32767).decorDisplacement / 2;
                  }

                  int var25 = var4 + 2 & 3;
                  Object var29;
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var28 = var8.getModel(4, var4 + 4, var15, var17, var16, var18);
                     var29 = var8.getModel(4, var25 + 4, var15, var17, var16, var18);
                  } else {
                     var28 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     var29 = new DynamicObject(var3, 4, var25 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.addBoundaryDecoration(var0, var1, var2, var16, (Renderable)var28, (Renderable)var29, 256, var4, var26 * class62.field738[var4], var26 * class62.field733[var4], var19, var20);
               }
            }
         } else {
            if(var8.animationId == -1 && var8.impostorIds == null) {
               var30 = var8.getModel(10, var4, var15, var17, var16, var18);
            } else {
               var30 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
            }

            if(var30 != null && var6.method2914(var0, var1, var2, var16, var9, var10, (Renderable)var30, var5 == 11?256:0, var19, var20) && var8.clipped) {
               var22 = 15;
               if(var30 instanceof Model) {
                  var22 = ((Model)var30).method2721() / 4;
                  if(var22 > 30) {
                     var22 = 30;
                  }
               }

               for(var23 = 0; var23 <= var9; ++var23) {
                  for(int var24 = 0; var24 <= var10; ++var24) {
                     if(var22 > class160.field2156[var0][var23 + var1][var24 + var2]) {
                        class160.field2156[var0][var23 + var1][var24 + var2] = (byte)var22;
                     }
                  }
               }
            }

            if(var8.clipType != 0 && var7 != null) {
               var7.addObject(var1, var2, var9, var10, var8.blocksProjectile);
            }

         }
      }
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(IZZZB)Lij;",
      garbageValue = "-50"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class157.dat2File != null) {
         var4 = new IndexFile(var0, class157.dat2File, class1.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, Tile.indexStore255, var0, var1, var2, var3);
   }
}
