import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -580700601
   )
   @Export("port2")
   static int port2;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1238828691
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1705973831
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("b")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1258248549
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2144457953
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 739325609
   )
   int field822;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -139299249
   )
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2033407449
   )
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -904811849
   )
   int field825;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1265472909
   )
   int field826;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1012216169
   )
   int field840;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lek;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1969079053
   )
   int field815;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1530484491
   )
   int field814;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1786746667
   )
   int field829;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 220304551
   )
   int field841;
   @ObfuscatedName("s")
   @Export("isLowDetail")
   boolean isLowDetail;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1720522907
   )
   @Export("team")
   int team;
   @ObfuscatedName("f")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -274895639
   )
   int field836;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1994478149
   )
   int field837;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   class303 field838;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   class303 field839;
   @ObfuscatedName("ay")
   boolean field820;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1651802215
   )
   int field821;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1906112519
   )
   int field831;

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
      this.field838 = class303.field3850;
      this.field839 = class303.field3850;
      this.field820 = false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "1862628927"
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
               int var8 = class81.getItemDefinition(var4[var5] - 512).int1;
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

      super.field1143 = var1.readUnsignedShort();
      if(super.field1143 == 65535) {
         super.field1143 = -1;
      }

      super.field1164 = super.field1143;
      super.field1145 = var1.readUnsignedShort();
      if(super.field1145 == 65535) {
         super.field1145 = -1;
      }

      super.field1158 = var1.readUnsignedShort();
      if(super.field1158 == 65535) {
         super.field1158 = -1;
      }

      super.field1147 = var1.readUnsignedShort();
      if(super.field1147 == 65535) {
         super.field1147 = -1;
      }

      super.field1148 = var1.readUnsignedShort();
      if(super.field1148 == 65535) {
         super.field1148 = -1;
      }

      super.field1194 = var1.readUnsignedShort();
      if(super.field1194 == 65535) {
         super.field1194 = -1;
      }

      this.name = new Name(var1.readString(), KeyFocusListener.loginType);
      this.method1203();
      this.method1206();
      if(this == WorldMapData.localPlayer) {
         class61.field699 = this.name.getName();
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

      this.composition.method4424(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1610375993"
   )
   @Export("isFriend")
   boolean isFriend() {
      if(this.field838 == class303.field3850) {
         this.method1204();
      }

      return this.field838 == class303.field3846;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "9"
   )
   void method1203() {
      this.field838 = class303.field3850;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-314651087"
   )
   void method1204() {
      this.field838 = WallObject.friendManager.method1734(this.name)?class303.field3846:class303.field3847;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1158077343"
   )
   @Export("isClanMember")
   boolean isClanMember() {
      if(this.field839 == class303.field3850) {
         this.method1207();
      }

      return this.field839 == class303.field3846;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "484327989"
   )
   void method1206() {
      this.field839 = class303.field3850;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "98"
   )
   void method1207() {
      this.field839 = KeyFocusListener.clanMemberManager != null && KeyFocusListener.clanMemberManager.isMember(this.name)?class303.field3846:class303.field3847;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "72"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class233.getNpcDefinition(this.composition.transformedNpcId).field3710:1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lek;",
      garbageValue = "22"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class158.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.isLowDetail || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:class158.getAnimation(super.poseAnimation);
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.isLowDetail && super.graphic != -1 && super.field1175 != -1) {
               var4 = MapLabel.getSpotAnimType(super.graphic).getModel(super.field1175);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1178, 0);
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
                  var4.offsetBy(this.field825 - super.x, this.field826 - this.field822, this.field840 - super.y);
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

                  var4.offsetBy(super.x - this.field825, this.field822 - this.field826, super.y - this.field840);
               }
            }

            var3.field1849 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "219846127"
   )
   final void method1210(int var1, int var2, byte var3) {
      if(super.animation != -1 && class158.getAnimation(super.animation).priority == 1) {
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
                  int var8 = class152.method3132(var5, var6, this.getSize(), GZipDecompressor.method3476(var1, var2), Client.collisionMaps[this.field836], true, Client.field1118, Client.field1119);
                  if(var8 >= 1) {
                     for(int var9 = 0; var9 < var8 - 1; ++var9) {
                        var4.method1212(Client.field1118[var9], Client.field1119[var9], (byte)2);
                     }
                  }
               }
            }

            this.method1212(var1, var2, var3);
         } else {
            this.method1214(var1, var2);
         }
      } else {
         this.method1214(var1, var2);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1287990295"
   )
   void method1214(int var1, int var2) {
      super.queueSize = 0;
      super.field1196 = 0;
      super.field1195 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1286056699"
   )
   final void method1212(int var1, int var2, byte var3) {
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1675922393"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1452913573"
   )
   static final void method1218(boolean var0) {
      if(var0) {
         Client.field887 = class90.field1350?class158.field2123:class158.field2125;
      } else {
         Client.field887 = MapIcon.preferences.preferences.containsKey(Integer.valueOf(class292.method5197(class90.username)))?class158.field2126:class158.field2124;
      }

   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2144360968"
   )
   static final void method1223() {
      class231.flush(false);
      Client.field901 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class204.field2601.length; ++var1) {
         if(class66.landMapFileIds[var1] != -1 && class204.field2601[var1] == null) {
            class204.field2601[var1] = VertexNormal.indexMaps.getConfigData(class66.landMapFileIds[var1], 0);
            if(class204.field2601[var1] == null) {
               var0 = false;
               ++Client.field901;
            }
         }

         if(GraphicsObject.landRegionFileIds[var1] != -1 && class81.field1253[var1] == null) {
            class81.field1253[var1] = VertexNormal.indexMaps.getConfigDataKeys(GraphicsObject.landRegionFileIds[var1], 0, BuildType.xteaKeys[var1]);
            if(class81.field1253[var1] == null) {
               var0 = false;
               ++Client.field901;
            }
         }
      }

      if(!var0) {
         Client.field905 = 1;
      } else {
         Client.field934 = 0;
         var0 = true;

         int var3;
         int var4;
         Buffer var8;
         int var9;
         int var10;
         int var11;
         int var13;
         int var14;
         int var15;
         int var16;
         int var17;
         int var18;
         for(var1 = 0; var1 < class204.field2601.length; ++var1) {
            byte[] var2 = class81.field1253[var1];
            if(var2 != null) {
               var3 = (IndexDataBase.mapRegions[var1] >> 8) * 64 - class38.baseX;
               var4 = (IndexDataBase.mapRegions[var1] & 255) * 64 - PlayerComposition.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               boolean var7 = true;
               var8 = new Buffer(var2);
               var9 = -1;

               label1329:
               while(true) {
                  var10 = var8.getUSmart();
                  if(var10 == 0) {
                     var0 &= var7;
                     break;
                  }

                  var9 += var10;
                  var11 = 0;
                  boolean var12 = false;

                  while(true) {
                     while(!var12) {
                        var13 = var8.getUSmart();
                        if(var13 == 0) {
                           continue label1329;
                        }

                        var11 += var13 - 1;
                        var14 = var11 & 63;
                        var15 = var11 >> 6 & 63;
                        var16 = var8.readUnsignedByte() >> 2;
                        var17 = var3 + var15;
                        var18 = var4 + var14;
                        if(var17 > 0 && var18 > 0 && var17 < 103 && var18 < 103) {
                           ObjectComposition var19 = Spotanim.getObjectDefinition(var9);
                           if(var16 != 22 || !Client.lowMemory || var19.int1 != 0 || var19.clipType == 1 || var19.obstructsGround) {
                              if(!var19.method4992()) {
                                 ++Client.field934;
                                 var7 = false;
                              }

                              var12 = true;
                           }
                        }
                     }

                     var13 = var8.getUSmart();
                     if(var13 == 0) {
                        break;
                     }

                     var8.readUnsignedByte();
                  }
               }
            }
         }

         if(!var0) {
            Client.field905 = 2;
         } else {
            if(Client.field905 != 0) {
               class21.method166("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            MapIcon.method588();
            class38.region.reset();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].reset();
            }

            int var44;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var44 = 0; var44 < 104; ++var44) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class62.tileSettings[var1][var44][var3] = 0;
                  }
               }
            }

            MapIcon.method588();
            class62.field705 = 99;
            class62.field711 = new byte[4][104][104];
            class62.field707 = new byte[4][104][104];
            class62.field708 = new byte[4][104][104];
            FrameMap.field1952 = new byte[4][104][104];
            class62.field709 = new int[4][105][105];
            class62.field704 = new byte[4][105][105];
            class62.field714 = new int[105][105];
            BoundingBox.field239 = new int[104];
            class36.field475 = new int[104];
            class22.field319 = new int[104];
            class199.field2584 = new int[104];
            class36.field476 = new int[104];
            var1 = class204.field2601.length;

            for(class80 var59 = (class80)class80.field1240.getFront(); var59 != null; var59 = (class80)class80.field1240.getNext()) {
               if(var59.field1244 != null) {
                  FontName.field3884.method2087(var59.field1244);
                  var59.field1244 = null;
               }

               if(var59.field1238 != null) {
                  FontName.field3884.method2087(var59.field1238);
                  var59.field1238 = null;
               }
            }

            class80.field1240.clear();
            class231.flush(true);
            int var5;
            int var6;
            int var20;
            int var21;
            int var54;
            int var62;
            int var64;
            if(!Client.isDynamicRegion) {
               byte[] var45;
               for(var44 = 0; var44 < var1; ++var44) {
                  var3 = (IndexDataBase.mapRegions[var44] >> 8) * 64 - class38.baseX;
                  var4 = (IndexDataBase.mapRegions[var44] & 255) * 64 - PlayerComposition.baseY;
                  var45 = class204.field2601[var44];
                  if(var45 != null) {
                     MapIcon.method588();
                     var6 = class49.field581 * 8 - 48;
                     var62 = PacketNode.field2476 * 8 - 48;
                     CollisionData[] var63 = Client.collisionMaps;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var3 + var10 > 0 && var3 + var10 < 103 && var4 + var11 > 0 && var11 + var4 < 103) {
                                 var63[var9].flags[var10 + var3][var4 + var11] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var46 = new Buffer(var45);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var64 = 0; var64 < 64; ++var64) {
                              class80.loadTerrain(var46, var10, var11 + var3, var64 + var4, var6, var62, 0);
                           }
                        }
                     }
                  }
               }

               for(var44 = 0; var44 < var1; ++var44) {
                  var3 = (IndexDataBase.mapRegions[var44] >> 8) * 64 - class38.baseX;
                  var4 = (IndexDataBase.mapRegions[var44] & 255) * 64 - PlayerComposition.baseY;
                  var45 = class204.field2601[var44];
                  if(var45 == null && PacketNode.field2476 < 800) {
                     MapIcon.method588();
                     WorldMapData.method317(var3, var4, 64, 64);
                  }
               }

               class231.flush(true);

               for(var44 = 0; var44 < var1; ++var44) {
                  byte[] var48 = class81.field1253[var44];
                  if(var48 != null) {
                     var4 = (IndexDataBase.mapRegions[var44] >> 8) * 64 - class38.baseX;
                     var5 = (IndexDataBase.mapRegions[var44] & 255) * 64 - PlayerComposition.baseY;
                     MapIcon.method588();
                     Region var49 = class38.region;
                     CollisionData[] var50 = Client.collisionMaps;
                     var8 = new Buffer(var48);
                     var9 = -1;

                     while(true) {
                        var10 = var8.getUSmart();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var64 = var8.getUSmart();
                           if(var64 == 0) {
                              break;
                           }

                           var11 += var64 - 1;
                           var13 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var8.readUnsignedByte();
                           var17 = var16 >> 2;
                           var18 = var16 & 3;
                           var54 = var4 + var14;
                           var20 = var13 + var5;
                           if(var54 > 0 && var20 > 0 && var54 < 103 && var20 < 103) {
                              var21 = var15;
                              if((class62.tileSettings[1][var54][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var55 = null;
                              if(var21 >= 0) {
                                 var55 = var50[var21];
                              }

                              ScriptState.addObject(var15, var54, var20, var9, var18, var17, var49, var55);
                           }
                        }
                     }
                  }
               }
            }

            int var22;
            int var23;
            int var24;
            int var25;
            int var26;
            int var27;
            int var28;
            int var29;
            int var31;
            int var32;
            int var33;
            int var47;
            if(Client.isDynamicRegion) {
               for(var44 = 0; var44 < 4; ++var44) {
                  MapIcon.method588();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var61 = false;
                        var6 = Client.instanceTemplateChunks[var44][var3][var4];
                        if(var6 != -1) {
                           var62 = var6 >> 24 & 3;
                           var47 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var64 = 0; var64 < IndexDataBase.mapRegions.length; ++var64) {
                              if(IndexDataBase.mapRegions[var64] == var11 && class204.field2601[var64] != null) {
                                 BoundingBox2D.method31(class204.field2601[var64], var44, var3 * 8, var4 * 8, var62, (var9 & 7) * 8, (var10 & 7) * 8, var47, Client.collisionMaps);
                                 var61 = true;
                                 break;
                              }
                           }
                        }

                        if(!var61) {
                           Projectile.method1968(var44, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var44 = 0; var44 < 13; ++var44) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.instanceTemplateChunks[0][var44][var3];
                     if(var4 == -1) {
                        WorldMapData.method317(var44 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class231.flush(true);

               for(var44 = 0; var44 < 4; ++var44) {
                  MapIcon.method588();

                  for(var3 = 0; var3 < 13; ++var3) {
                     label1149:
                     for(var4 = 0; var4 < 13; ++var4) {
                        var5 = Client.instanceTemplateChunks[var44][var3][var4];
                        if(var5 != -1) {
                           var6 = var5 >> 24 & 3;
                           var62 = var5 >> 1 & 3;
                           var47 = var5 >> 14 & 1023;
                           var9 = var5 >> 3 & 2047;
                           var10 = (var47 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < IndexDataBase.mapRegions.length; ++var11) {
                              if(IndexDataBase.mapRegions[var11] == var10 && class81.field1253[var11] != null) {
                                 byte[] var51 = class81.field1253[var11];
                                 var13 = var3 * 8;
                                 var14 = var4 * 8;
                                 var15 = (var47 & 7) * 8;
                                 var16 = (var9 & 7) * 8;
                                 Region var52 = class38.region;
                                 CollisionData[] var53 = Client.collisionMaps;
                                 Buffer var65 = new Buffer(var51);
                                 var20 = -1;

                                 while(true) {
                                    var21 = var65.getUSmart();
                                    if(var21 == 0) {
                                       continue label1149;
                                    }

                                    var20 += var21;
                                    var22 = 0;

                                    while(true) {
                                       var23 = var65.getUSmart();
                                       if(var23 == 0) {
                                          break;
                                       }

                                       var22 += var23 - 1;
                                       var24 = var22 & 63;
                                       var25 = var22 >> 6 & 63;
                                       var26 = var22 >> 12;
                                       var27 = var65.readUnsignedByte();
                                       var28 = var27 >> 2;
                                       var29 = var27 & 3;
                                       if(var6 == var26 && var25 >= var15 && var25 < var15 + 8 && var24 >= var16 && var24 < var16 + 8) {
                                          ObjectComposition var30 = Spotanim.getObjectDefinition(var20);
                                          var31 = var13 + class55.method858(var25 & 7, var24 & 7, var62, var30.width, var30.length, var29);
                                          var32 = var14 + KeyFocusListener.method830(var25 & 7, var24 & 7, var62, var30.width, var30.length, var29);
                                          if(var31 > 0 && var32 > 0 && var31 < 103 && var32 < 103) {
                                             var33 = var44;
                                             if((class62.tileSettings[1][var31][var32] & 2) == 2) {
                                                var33 = var44 - 1;
                                             }

                                             CollisionData var34 = null;
                                             if(var33 >= 0) {
                                                var34 = var53[var33];
                                             }

                                             ScriptState.addObject(var44, var31, var32, var20, var29 + var62 & 3, var28, var52, var34);
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class231.flush(true);
            MapIcon.method588();
            Region var60 = class38.region;
            CollisionData[] var71 = Client.collisionMaps;

            for(var4 = 0; var4 < 4; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  for(var6 = 0; var6 < 104; ++var6) {
                     if((class62.tileSettings[var4][var5][var6] & 1) == 1) {
                        var62 = var4;
                        if((class62.tileSettings[1][var5][var6] & 2) == 2) {
                           var62 = var4 - 1;
                        }

                        if(var62 >= 0) {
                           var71[var62].method3387(var5, var6);
                        }
                     }
                  }
               }
            }

            class62.field719 += (int)(Math.random() * 5.0D) - 2;
            if(class62.field719 < -8) {
               class62.field719 = -8;
            }

            if(class62.field719 > 8) {
               class62.field719 = 8;
            }

            class62.field720 += (int)(Math.random() * 5.0D) - 2;
            if(class62.field720 < -16) {
               class62.field720 = -16;
            }

            if(class62.field720 > 16) {
               class62.field720 = 16;
            }

            for(var4 = 0; var4 < 4; ++var4) {
               byte[][] var68 = class62.field704[var4];
               var11 = (int)Math.sqrt(5100.0D);
               var64 = var11 * 768 >> 8;

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     var15 = class62.tileHeights[var4][var14 + 1][var13] - class62.tileHeights[var4][var14 - 1][var13];
                     var16 = class62.tileHeights[var4][var14][var13 + 1] - class62.tileHeights[var4][var14][var13 - 1];
                     var17 = (int)Math.sqrt((double)(var16 * var16 + var15 * var15 + 65536));
                     var18 = (var15 << 8) / var17;
                     var54 = 65536 / var17;
                     var20 = (var16 << 8) / var17;
                     var21 = (var20 * -50 + var18 * -50 + var54 * -10) / var64 + 96;
                     var22 = (var68[var14][var13 + 1] >> 3) + (var68[var14 - 1][var13] >> 2) + (var68[var14][var13 - 1] >> 2) + (var68[var14 + 1][var13] >> 3) + (var68[var14][var13] >> 1);
                     class62.field714[var14][var13] = var21 - var22;
                  }
               }

               for(var13 = 0; var13 < 104; ++var13) {
                  BoundingBox.field239[var13] = 0;
                  class36.field475[var13] = 0;
                  class22.field319[var13] = 0;
                  class199.field2584[var13] = 0;
                  class36.field476[var13] = 0;
               }

               for(var13 = -5; var13 < 109; ++var13) {
                  for(var14 = 0; var14 < 104; ++var14) {
                     var15 = var13 + 5;
                     if(var15 >= 0 && var15 < 104) {
                        var16 = class62.field711[var4][var15][var14] & 255;
                        if(var16 > 0) {
                           FloorUnderlayDefinition var72 = BuildType.getUnderlayDefinition(var16 - 1);
                           BoundingBox.field239[var14] += var72.hue;
                           class36.field475[var14] += var72.saturation;
                           class22.field319[var14] += var72.lightness;
                           class199.field2584[var14] += var72.hueMultiplier;
                           ++class36.field476[var14];
                        }
                     }

                     var16 = var13 - 5;
                     if(var16 >= 0 && var16 < 104) {
                        var17 = class62.field711[var4][var16][var14] & 255;
                        if(var17 > 0) {
                           FloorUnderlayDefinition var73 = BuildType.getUnderlayDefinition(var17 - 1);
                           BoundingBox.field239[var14] -= var73.hue;
                           class36.field475[var14] -= var73.saturation;
                           class22.field319[var14] -= var73.lightness;
                           class199.field2584[var14] -= var73.hueMultiplier;
                           --class36.field476[var14];
                        }
                     }
                  }

                  if(var13 >= 1 && var13 < 103) {
                     var14 = 0;
                     var15 = 0;
                     var16 = 0;
                     var17 = 0;
                     var18 = 0;

                     for(var54 = -5; var54 < 109; ++var54) {
                        var20 = var54 + 5;
                        if(var20 >= 0 && var20 < 104) {
                           var14 += BoundingBox.field239[var20];
                           var15 += class36.field475[var20];
                           var16 += class22.field319[var20];
                           var17 += class199.field2584[var20];
                           var18 += class36.field476[var20];
                        }

                        var21 = var54 - 5;
                        if(var21 >= 0 && var21 < 104) {
                           var14 -= BoundingBox.field239[var21];
                           var15 -= class36.field475[var21];
                           var16 -= class22.field319[var21];
                           var17 -= class199.field2584[var21];
                           var18 -= class36.field476[var21];
                        }

                        if(var54 >= 1 && var54 < 103 && (!Client.lowMemory || (class62.tileSettings[0][var13][var54] & 2) != 0 || (class62.tileSettings[var4][var13][var54] & 16) == 0)) {
                           if(var4 < class62.field705) {
                              class62.field705 = var4;
                           }

                           var22 = class62.field711[var4][var13][var54] & 255;
                           var23 = class62.field707[var4][var13][var54] & 255;
                           if(var22 > 0 || var23 > 0) {
                              var24 = class62.tileHeights[var4][var13][var54];
                              var25 = class62.tileHeights[var4][var13 + 1][var54];
                              var26 = class62.tileHeights[var4][var13 + 1][var54 + 1];
                              var27 = class62.tileHeights[var4][var13][var54 + 1];
                              var28 = class62.field714[var13][var54];
                              var29 = class62.field714[var13 + 1][var54];
                              int var56 = class62.field714[var13 + 1][var54 + 1];
                              var31 = class62.field714[var13][var54 + 1];
                              var32 = -1;
                              var33 = -1;
                              int var35;
                              int var57;
                              if(var22 > 0) {
                                 var57 = var14 * 256 / var17;
                                 var35 = var15 / var18;
                                 int var36 = var16 / var18;
                                 var32 = VertexNormal.method2775(var57, var35, var36);
                                 var57 = var57 + class62.field719 & 255;
                                 var36 += class62.field720;
                                 if(var36 < 0) {
                                    var36 = 0;
                                 } else if(var36 > 255) {
                                    var36 = 255;
                                 }

                                 var33 = VertexNormal.method2775(var57, var35, var36);
                              }

                              if(var4 > 0) {
                                 boolean var74 = true;
                                 if(var22 == 0 && class62.field708[var4][var13][var54] != 0) {
                                    var74 = false;
                                 }

                                 if(var23 > 0 && !class183.getOverlayDefinition(var23 - 1).isHidden) {
                                    var74 = false;
                                 }

                                 if(var74 && var25 == var24 && var26 == var24 && var27 == var24) {
                                    class62.field709[var4][var13][var54] |= 2340;
                                 }
                              }

                              var57 = 0;
                              if(var33 != -1) {
                                 var57 = Graphics3D.colorPalette[FriendManager.method1792(var33, 96)];
                              }

                              if(var23 == 0) {
                                 var60.addTile(var4, var13, var54, 0, 0, -1, var24, var25, var26, var27, FriendManager.method1792(var32, var28), FriendManager.method1792(var32, var29), FriendManager.method1792(var32, var56), FriendManager.method1792(var32, var31), 0, 0, 0, 0, var57, 0);
                              } else {
                                 var35 = class62.field708[var4][var13][var54] + 1;
                                 byte var67 = FrameMap.field1952[var4][var13][var54];
                                 Overlay var37 = class183.getOverlayDefinition(var23 - 1);
                                 int var38 = var37.texture;
                                 int var39;
                                 int var40;
                                 int var41;
                                 int var42;
                                 if(var38 >= 0) {
                                    var40 = Graphics3D.textureLoader.getAverageTextureRGB(var38);
                                    var39 = -1;
                                 } else if(var37.color == 16711935) {
                                    var39 = -2;
                                    var38 = -1;
                                    var40 = -2;
                                 } else {
                                    var39 = VertexNormal.method2775(var37.hue, var37.saturation, var37.lightness);
                                    var41 = var37.hue + class62.field719 & 255;
                                    var42 = var37.lightness + class62.field720;
                                    if(var42 < 0) {
                                       var42 = 0;
                                    } else if(var42 > 255) {
                                       var42 = 255;
                                    }

                                    var40 = VertexNormal.method2775(var41, var37.saturation, var42);
                                 }

                                 var41 = 0;
                                 if(var40 != -2) {
                                    var41 = Graphics3D.colorPalette[GrandExchangeOffer.adjustHSLListness0(var40, 96)];
                                 }

                                 if(var37.otherRgbColor != -1) {
                                    var42 = var37.otherHue + class62.field719 & 255;
                                    int var43 = var37.otherLightness + class62.field720;
                                    if(var43 < 0) {
                                       var43 = 0;
                                    } else if(var43 > 255) {
                                       var43 = 255;
                                    }

                                    var40 = VertexNormal.method2775(var42, var37.otherSaturation, var43);
                                    var41 = Graphics3D.colorPalette[GrandExchangeOffer.adjustHSLListness0(var40, 96)];
                                 }

                                 var60.addTile(var4, var13, var54, var35, var67, var38, var24, var25, var26, var27, FriendManager.method1792(var32, var28), FriendManager.method1792(var32, var29), FriendManager.method1792(var32, var56), FriendManager.method1792(var32, var31), GrandExchangeOffer.adjustHSLListness0(var39, var28), GrandExchangeOffer.adjustHSLListness0(var39, var29), GrandExchangeOffer.adjustHSLListness0(var39, var56), GrandExchangeOffer.adjustHSLListness0(var39, var31), var57, var41);
                              }
                           }
                        }
                     }
                  }
               }

               for(var13 = 1; var13 < 103; ++var13) {
                  for(var14 = 1; var14 < 103; ++var14) {
                     if((class62.tileSettings[var4][var14][var13] & 8) != 0) {
                        var54 = 0;
                     } else if(var4 > 0 && (class62.tileSettings[1][var14][var13] & 2) != 0) {
                        var54 = var4 - 1;
                     } else {
                        var54 = var4;
                     }

                     var60.setPhysicalLevel(var4, var14, var13, var54);
                  }
               }

               class62.field711[var4] = null;
               class62.field707[var4] = null;
               class62.field708[var4] = null;
               FrameMap.field1952[var4] = null;
               class62.field704[var4] = null;
            }

            var60.applyLighting(-50, -10, -50);

            for(var4 = 0; var4 < 104; ++var4) {
               for(var5 = 0; var5 < 104; ++var5) {
                  if((class62.tileSettings[1][var4][var5] & 2) == 2) {
                     var60.setBridge(var4, var5);
                  }
               }
            }

            var4 = 1;
            var5 = 2;
            var6 = 4;

            for(var62 = 0; var62 < 4; ++var62) {
               if(var62 > 0) {
                  var4 <<= 3;
                  var5 <<= 3;
                  var6 <<= 3;
               }

               for(var47 = 0; var47 <= var62; ++var47) {
                  for(var9 = 0; var9 <= 104; ++var9) {
                     for(var10 = 0; var10 <= 104; ++var10) {
                        short var66;
                        if((class62.field709[var47][var10][var9] & var4) != 0) {
                           var11 = var9;
                           var64 = var9;
                           var13 = var47;

                           for(var14 = var47; var11 > 0 && (class62.field709[var47][var10][var11 - 1] & var4) != 0; --var11) {
                              ;
                           }

                           while(var64 < 104 && (class62.field709[var47][var10][var64 + 1] & var4) != 0) {
                              ++var64;
                           }

                           label877:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var64; ++var15) {
                                 if((class62.field709[var13 - 1][var10][var15] & var4) == 0) {
                                    break label877;
                                 }
                              }

                              --var13;
                           }

                           label866:
                           while(var14 < var62) {
                              for(var15 = var11; var15 <= var64; ++var15) {
                                 if((class62.field709[var14 + 1][var10][var15] & var4) == 0) {
                                    break label866;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var14 + 1 - var13) * (var64 - var11 + 1);
                           if(var15 >= 8) {
                              var66 = 240;
                              var17 = class62.tileHeights[var14][var10][var11] - var66;
                              var18 = class62.tileHeights[var13][var10][var11];
                              Region.addOcclude(var62, 1, var10 * 128, var10 * 128, var11 * 128, var64 * 128 + 128, var17, var18);

                              for(var54 = var13; var54 <= var14; ++var54) {
                                 for(var20 = var11; var20 <= var64; ++var20) {
                                    class62.field709[var54][var10][var20] &= ~var4;
                                 }
                              }
                           }
                        }

                        if((class62.field709[var47][var10][var9] & var5) != 0) {
                           var11 = var10;
                           var64 = var10;
                           var13 = var47;

                           for(var14 = var47; var11 > 0 && (class62.field709[var47][var11 - 1][var9] & var5) != 0; --var11) {
                              ;
                           }

                           while(var64 < 104 && (class62.field709[var47][var64 + 1][var9] & var5) != 0) {
                              ++var64;
                           }

                           label930:
                           while(var13 > 0) {
                              for(var15 = var11; var15 <= var64; ++var15) {
                                 if((class62.field709[var13 - 1][var15][var9] & var5) == 0) {
                                    break label930;
                                 }
                              }

                              --var13;
                           }

                           label919:
                           while(var14 < var62) {
                              for(var15 = var11; var15 <= var64; ++var15) {
                                 if((class62.field709[var14 + 1][var15][var9] & var5) == 0) {
                                    break label919;
                                 }
                              }

                              ++var14;
                           }

                           var15 = (var64 - var11 + 1) * (var14 + 1 - var13);
                           if(var15 >= 8) {
                              var66 = 240;
                              var17 = class62.tileHeights[var14][var11][var9] - var66;
                              var18 = class62.tileHeights[var13][var11][var9];
                              Region.addOcclude(var62, 2, var11 * 128, var64 * 128 + 128, var9 * 128, var9 * 128, var17, var18);

                              for(var54 = var13; var54 <= var14; ++var54) {
                                 for(var20 = var11; var20 <= var64; ++var20) {
                                    class62.field709[var54][var20][var9] &= ~var5;
                                 }
                              }
                           }
                        }

                        if((class62.field709[var47][var10][var9] & var6) != 0) {
                           var11 = var10;
                           var64 = var10;
                           var13 = var9;

                           for(var14 = var9; var13 > 0 && (class62.field709[var47][var10][var13 - 1] & var6) != 0; --var13) {
                              ;
                           }

                           while(var14 < 104 && (class62.field709[var47][var10][var14 + 1] & var6) != 0) {
                              ++var14;
                           }

                           label983:
                           while(var11 > 0) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class62.field709[var47][var11 - 1][var15] & var6) == 0) {
                                    break label983;
                                 }
                              }

                              --var11;
                           }

                           label972:
                           while(var64 < 104) {
                              for(var15 = var13; var15 <= var14; ++var15) {
                                 if((class62.field709[var47][var64 + 1][var15] & var6) == 0) {
                                    break label972;
                                 }
                              }

                              ++var64;
                           }

                           if((var14 - var13 + 1) * (var64 - var11 + 1) >= 4) {
                              var15 = class62.tileHeights[var47][var11][var13];
                              Region.addOcclude(var62, 4, var11 * 128, var64 * 128 + 128, var13 * 128, var14 * 128 + 128, var15, var15);

                              for(var16 = var11; var16 <= var64; ++var16) {
                                 for(var17 = var13; var17 <= var14; ++var17) {
                                    class62.field709[var47][var16][var17] &= ~var6;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }

            class231.flush(true);
            var4 = class62.field705;
            if(var4 > Ignore.plane) {
               var4 = Ignore.plane;
            }

            if(var4 < Ignore.plane - 1) {
               var4 = Ignore.plane - 1;
            }

            if(Client.lowMemory) {
               class38.region.setup(class62.field705);
            } else {
               class38.region.setup(0);
            }

            for(var5 = 0; var5 < 104; ++var5) {
               for(var6 = 0; var6 < 104; ++var6) {
                  GameCanvas.groundItemSpawned(var5, var6);
               }
            }

            MapIcon.method588();

            for(PendingSpawn var69 = (PendingSpawn)Client.pendingSpawns.getFront(); var69 != null; var69 = (PendingSpawn)Client.pendingSpawns.getNext()) {
               if(var69.hitpoints == -1) {
                  var69.delay = 0;
                  GZipDecompressor.method3474(var69);
               } else {
                  var69.unlink();
               }
            }

            ObjectComposition.field3597.reset();
            PacketNode var70;
            if(class249.clientInstance.method1023()) {
               var70 = class33.method382(ClientPacket.field2373, Client.field1072.field1456);
               var70.packetBuffer.putInt(1057001181);
               Client.field1072.method2073(var70);
            }

            if(!Client.isDynamicRegion) {
               var5 = (class49.field581 - 6) / 8;
               var6 = (class49.field581 + 6) / 8;
               var62 = (PacketNode.field2476 - 6) / 8;
               var47 = (PacketNode.field2476 + 6) / 8;

               for(var9 = var5 - 1; var9 <= var6 + 1; ++var9) {
                  for(var10 = var62 - 1; var10 <= var47 + 1; ++var10) {
                     if(var9 < var5 || var9 > var6 || var10 < var62 || var10 > var47) {
                        VertexNormal.indexMaps.method4588("m" + var9 + "_" + var10);
                        VertexNormal.indexMaps.method4588("l" + var9 + "_" + var10);
                     }
                  }
               }
            }

            class20.setGameState(30);
            MapIcon.method588();
            class27.method228();
            var70 = class33.method382(ClientPacket.field2396, Client.field1072.field1456);
            Client.field1072.method2073(var70);
            BoundingBox2D.method36();
         }
      }
   }
}
