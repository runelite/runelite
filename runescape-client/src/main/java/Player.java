import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = 846186965
   )
   static int field902;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1506314947
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 403672251
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("q")
   boolean field897;
   @ObfuscatedName("m")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1654491681
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -708301361
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -759851121
   )
   @Export("team")
   int team;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1856008003
   )
   int field904;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -752792261
   )
   int field875;
   @ObfuscatedName("j")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("b")
   boolean field898;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1062433325
   )
   int field885;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1670743257
   )
   int field886;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -646099945
   )
   int field882;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -220457913
   )
   int field896;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 232885147
   )
   int field876;
   @ObfuscatedName("c")
   @Export("name")
   String name;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -683958985
   )
   int field901;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1346119273
   )
   int field889;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1192097385
   )
   int field899;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 483180145
   )
   int field890;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -166321861
   )
   int field891;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 387174097
   )
   int field900;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 569194845
   )
   int field892;

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.field904 = 0;
      this.field875 = 0;
      this.field897 = false;
      this.team = 0;
      this.hidden = false;
      this.field898 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Leo;",
      garbageValue = "1"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class31.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field897 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?class31.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3882(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2433();
            super.field1259 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field897 && super.graphic != -1 && super.field1247 != -1) {
               var4 = class205.getSpotAnimType(super.graphic).method4231(super.field1247);
               if(var4 != null) {
                  var4.method2479(0, -super.field1250, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field897 && this.model != null) {
               if(Client.gameCycle >= this.field875) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field904 && Client.gameCycle < this.field875) {
                  var4 = this.model;
                  var4.method2479(this.field885 - super.x, this.field886 - this.field882, this.field876 - super.y);
                  if(super.orientation == 512) {
                     var4.method2439();
                     var4.method2439();
                     var4.method2439();
                  } else if(super.orientation == 1024) {
                     var4.method2439();
                     var4.method2439();
                  } else if(super.orientation == 1536) {
                     var4.method2439();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2439();
                  } else if(super.orientation == 1024) {
                     var4.method2439();
                     var4.method2439();
                  } else if(super.orientation == 1536) {
                     var4.method2439();
                     var4.method2439();
                     var4.method2439();
                  }

                  var4.method2479(super.x - this.field885, this.field882 - this.field886, super.y - this.field876);
               }
            }

            var3.field1879 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1435190538"
   )
   void method1076(int var1, int var2) {
      super.queueSize = 0;
      super.field1219 = 0;
      super.field1267 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = 64 * var3 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-398653536"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?WorldMapType3.getNpcDefinition(this.composition.transformedNpcId).field3532:1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1222562236"
   )
   final void method1086(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1266[var4] = super.field1266[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1266[0] = var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "307360793"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "1848631775"
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
               int var8 = class10.getItemDefinition(var4[var5] - 512).field3511;
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

      super.field1215 = var1.readUnsignedShort();
      if(super.field1215 == '\uffff') {
         super.field1215 = -1;
      }

      super.field1216 = super.field1215;
      super.field1217 = var1.readUnsignedShort();
      if(super.field1217 == '\uffff') {
         super.field1217 = -1;
      }

      super.field1264 = var1.readUnsignedShort();
      if(super.field1264 == '\uffff') {
         super.field1264 = -1;
      }

      super.field1244 = var1.readUnsignedShort();
      if(super.field1244 == '\uffff') {
         super.field1244 = -1;
      }

      super.field1220 = var1.readUnsignedShort();
      if(super.field1220 == '\uffff') {
         super.field1220 = -1;
      }

      super.field1221 = var1.readUnsignedShort();
      if(super.field1221 == '\uffff') {
         super.field1221 = -1;
      }

      this.name = var1.readString();
      if(this == class226.localPlayer) {
         class152.field2178 = this.name;
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

      this.composition.method3876(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1160448800"
   )
   final void method1075(int var1, int var2, byte var3) {
      if(super.animation != -1 && class31.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1237 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.getSize();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var9 = this.getSize();
                  Client.field1179.field2274 = var1;
                  Client.field1179.field2272 = var2;
                  Client.field1179.field2273 = 1;
                  Client.field1179.field2275 = 1;
                  class73 var10 = Client.field1179;
                  CollisionData var12 = Client.collisionMaps[this.field896];
                  int[] var13 = Client.field1180;
                  int[] var14 = Client.field1181;
                  int var15 = 0;

                  label240:
                  while(true) {
                     int var16;
                     if(var15 >= 128) {
                        boolean var34;
                        if(var9 == 1) {
                           var34 = class92.method1693(var5, var6, var10, var12);
                        } else if(var9 == 2) {
                           var34 = class202.method3622(var5, var6, var10, var12);
                        } else {
                           var34 = PendingSpawn.method1463(var5, var6, var9, var10, var12);
                        }

                        int var8;
                        label261: {
                           var16 = var5 - 64;
                           int var17 = var6 - 64;
                           int var18 = class162.field2266;
                           int var19 = class162.field2267;
                           int var20;
                           int var21;
                           int var23;
                           if(!var34) {
                              var20 = Integer.MAX_VALUE;
                              var21 = Integer.MAX_VALUE;
                              byte var22 = 10;
                              var23 = var10.field2274;
                              int var24 = var10.field2272;
                              int var25 = var10.field2273;
                              int var26 = var10.field2275;

                              for(int var27 = var23 - var22; var27 <= var22 + var23; ++var27) {
                                 for(int var28 = var24 - var22; var28 <= var24 + var22; ++var28) {
                                    int var29 = var27 - var16;
                                    int var30 = var28 - var17;
                                    if(var29 >= 0 && var30 >= 0 && var29 < 128 && var30 < 128 && class162.field2265[var29][var30] < 100) {
                                       int var31 = 0;
                                       if(var27 < var23) {
                                          var31 = var23 - var27;
                                       } else if(var27 > var25 + var23 - 1) {
                                          var31 = var27 - (var25 + var23 - 1);
                                       }

                                       int var32 = 0;
                                       if(var28 < var24) {
                                          var32 = var24 - var28;
                                       } else if(var28 > var24 + var26 - 1) {
                                          var32 = var28 - (var24 + var26 - 1);
                                       }

                                       int var33 = var31 * var31 + var32 * var32;
                                       if(var33 < var20 || var20 == var33 && class162.field2265[var29][var30] < var21) {
                                          var20 = var33;
                                          var21 = class162.field2265[var29][var30];
                                          var18 = var27;
                                          var19 = var28;
                                       }
                                    }
                                 }
                              }

                              if(var20 == Integer.MAX_VALUE) {
                                 var8 = -1;
                                 break label261;
                              }
                           }

                           if(var18 == var5 && var6 == var19) {
                              var8 = 0;
                           } else {
                              byte var36 = 0;
                              class162.field2268[var36] = var18;
                              var20 = var36 + 1;
                              class162.field2269[var36] = var19;

                              int var37;
                              for(var21 = var37 = class162.field2262[var18 - var16][var19 - var17]; var18 != var5 || var6 != var19; var21 = class162.field2262[var18 - var16][var19 - var17]) {
                                 if(var37 != var21) {
                                    var37 = var21;
                                    class162.field2268[var20] = var18;
                                    class162.field2269[var20++] = var19;
                                 }

                                 if((var21 & 2) != 0) {
                                    ++var18;
                                 } else if((var21 & 8) != 0) {
                                    --var18;
                                 }

                                 if((var21 & 1) != 0) {
                                    ++var19;
                                 } else if((var21 & 4) != 0) {
                                    --var19;
                                 }
                              }

                              var23 = 0;

                              while(var20-- > 0) {
                                 var13[var23] = class162.field2268[var20];
                                 var14[var23++] = class162.field2269[var20];
                                 if(var23 >= var13.length) {
                                    break;
                                 }
                              }

                              var8 = var23;
                           }
                        }

                        var15 = var8;
                        if(var8 < 1) {
                           break;
                        }

                        var16 = 0;

                        while(true) {
                           if(var16 >= var15 - 1) {
                              break label240;
                           }

                           var4.method1086(Client.field1180[var16], Client.field1181[var16], (byte)2);
                           ++var16;
                        }
                     }

                     for(var16 = 0; var16 < 128; ++var16) {
                        class162.field2262[var15][var16] = 0;
                        class162.field2265[var15][var16] = 99999999;
                     }

                     ++var15;
                  }
               }
            }

            this.method1086(var1, var2, var3);
         } else {
            this.method1076(var1, var2);
         }
      } else {
         this.method1076(var1, var2);
      }

   }

   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-106059346"
   )
   static void method1093() {
      Client.secretPacketBuffer1.offset = 0;
      Client.secretPacketBuffer2.offset = 0;
      Client.packetType = -1;
      Client.lastFrameId = -1;
      Client.secondLastFrameId = -1;
      Client.thridLastFrameId = -1;
      Client.packetLength = 0;
      Client.field962 = 0;
      Client.field1070 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field1138 = 0;
      Client.destinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      class226.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field1249 = false;
         }
      }

      XItemContainer.itemContainers = new XHashTable(32);
      class152.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1109[var0] = true;
      }

      XItemContainer.method1031();
   }
}
