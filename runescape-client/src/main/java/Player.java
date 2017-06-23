import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("pd")
   static class109 field862;
   @ObfuscatedName("m")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1269672311
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1257462771
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("z")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 582321563
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -478192473
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1330434535
   )
   int field870;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 803625905
   )
   int field871;
   @ObfuscatedName("p")
   @Export("name")
   String name;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2053944719
   )
   int field873;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -60455963
   )
   int field874;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2131896159
   )
   int field875;
   @ObfuscatedName("g")
   @Export("model")
   Model model;
   @ObfuscatedName("y")
   boolean field877;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 238186907
   )
   int field878;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 313144473
   )
   int field879;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1195752101
   )
   int field880;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1610133239
   )
   @Export("team")
   int team;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1864536571
   )
   int field882;
   @ObfuscatedName("d")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -172286643
   )
   int field884;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -190004837
   )
   int field885;
   @ObfuscatedName("l")
   boolean field886;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -906224169
   )
   int field887;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1952900627
   )
   int field888;
   @ObfuscatedName("in")
   @ObfuscatedGetter(
      intValue = -1753571745
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -189625525
   )
   int field890;

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "-2023035977"
   )
   static final void method1069(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = var5 * (Client.field1147 - Client.field988) / 100 + Client.field988;
      int var7 = var3 * var6 * 512 / (var2 * 334);
      int var8;
      int var9;
      short var10;
      if(var7 < Client.field1164) {
         var10 = Client.field1164;
         var6 = var10 * var2 * 334 / (var3 * 512);
         if(var6 > Client.field1163) {
            var6 = Client.field1163;
            var8 = var3 * var6 * 512 / (var10 * 334);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4880();
               Rasterizer2D.method4826(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4826(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > Client.field1165) {
         var10 = Client.field1165;
         var6 = var10 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field1162) {
            var6 = Client.field1162;
            var8 = var10 * var2 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4880();
               Rasterizer2D.method4826(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4826(var0, var3 + var1 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = var5 * (Client.field904 - Client.field1160) / 100 + Client.field1160;
      Client.scale = var3 * var8 * var6 / 85504 << 1;
      if(var2 != Client.viewportHeight || var3 != Client.viewportWidth) {
         int[] var11 = new int[9];

         for(int var12 = 0; var12 < 9; ++var12) {
            int var13 = var12 * 32 + 128 + 15;
            int var14 = var13 * 3 + 600;
            int var15 = class136.SINE[var13];
            var11[var12] = var15 * var14 >> 16;
         }

         Region.method2738(var11, 500, 800, var2, var3);
      }

      Client.field1166 = var0;
      Client.field1167 = var1;
      Client.viewportHeight = var2;
      Client.viewportWidth = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-2066149273"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?GameEngine.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field886 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:GameEngine.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3845(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2397();
            super.field1258 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field886 && super.graphic != -1 && super.field1221 != -1) {
               var4 = Area.method4176(super.graphic).method4213(super.field1221);
               if(var4 != null) {
                  var4.method2408(0, -super.field1239, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field886 && this.model != null) {
               if(Client.gameCycle >= this.field882) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field871 && Client.gameCycle < this.field882) {
                  var4 = this.model;
                  var4.method2408(this.field873 - super.x, this.field874 - this.field879, this.field875 - super.y);
                  if(super.orientation == 512) {
                     var4.method2427();
                     var4.method2427();
                     var4.method2427();
                  } else if(super.orientation == 1024) {
                     var4.method2427();
                     var4.method2427();
                  } else if(super.orientation == 1536) {
                     var4.method2427();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2427();
                  } else if(super.orientation == 1024) {
                     var4.method2427();
                     var4.method2427();
                  } else if(super.orientation == 1536) {
                     var4.method2427();
                     var4.method2427();
                     var4.method2427();
                  }

                  var4.method2408(super.x - this.field873, this.field879 - this.field874, super.y - this.field875);
               }
            }

            var3.field1949 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIBS)V",
      garbageValue = "-3405"
   )
   final void method1071(int var1, int var2, byte var3) {
      if(super.animation != -1 && GameEngine.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1236 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class31.method277(this, var1, var2, (byte)2);
            }

            this.method1073(var1, var2, var3);
         } else {
            this.method1083(var1, var2);
         }
      } else {
         this.method1083(var1, var2);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "695514916"
   )
   int method1072() {
      return this.composition != null && this.composition.transformedNpcId != -1?class158.getNpcDefinition(this.composition.transformedNpcId).field3559:1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1874101740"
   )
   final void method1073(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1265[var4] = super.field1265[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1265[0] = var3;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "2239"
   )
   final boolean vmethod1593() {
      return this.composition != null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2105682062"
   )
   void method1083(int var1, int var2) {
      super.queueSize = 0;
      super.field1267 = 0;
      super.field1266 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method1072();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.field871 = 0;
      this.field882 = 0;
      this.field886 = false;
      this.team = 0;
      this.hidden = false;
      this.field877 = false;
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)I",
      garbageValue = "13"
   )
   static final int method1087(Widget var0, int var1) {
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
                  var10 = class223.method3959(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class224.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class211.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class222.field2851[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class211.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class20.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class222.field2850[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class223.method3959(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class224.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
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
                  var9 = class211.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class50.method728(var9);
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
                  var7 = (class20.localPlayer.x >> 7) + class19.baseX;
               }

               if(var6 == 19) {
                  var7 = (class20.localPlayer.y >> 7) + class21.baseY;
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-71615671"
   )
   final void method1091(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.readUnsignedByte();
      this.skullIcon = var1.readByte();
      this.overheadIcon = var1.readByte();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var5;
      int var6;
      for(int var7 = 0; var7 < 12; ++var7) {
         var5 = var1.readUnsignedByte();
         if(var5 == 0) {
            var4[var7] = 0;
         } else {
            var6 = var1.readUnsignedByte();
            var4[var7] = (var5 << 8) + var6;
            if(var7 == 0 && var4[0] == '\uffff') {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var7] >= 512) {
               int var8 = class224.getItemDefinition(var4[var7] - 512).field3540;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var5 = 0; var5 < 5; ++var5) {
         var6 = var1.readUnsignedByte();
         if(var6 < 0 || var6 >= class8.field249[var5].length) {
            var6 = 0;
         }

         var9[var5] = var6;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field1214 = var1.readUnsignedShort();
      if(super.field1214 == '\uffff') {
         super.field1214 = -1;
      }

      super.field1215 = super.field1214;
      super.field1216 = var1.readUnsignedShort();
      if(super.field1216 == '\uffff') {
         super.field1216 = -1;
      }

      super.field1217 = var1.readUnsignedShort();
      if(super.field1217 == '\uffff') {
         super.field1217 = -1;
      }

      super.field1218 = var1.readUnsignedShort();
      if(super.field1218 == '\uffff') {
         super.field1218 = -1;
      }

      super.field1219 = var1.readUnsignedShort();
      if(super.field1219 == '\uffff') {
         super.field1219 = -1;
      }

      super.field1220 = var1.readUnsignedShort();
      if(super.field1220 == '\uffff') {
         super.field1220 = -1;
      }

      this.name = var1.readString();
      if(class20.localPlayer == this) {
         class152.field2223 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.totalLevel = var1.readUnsignedShort();
      this.hidden = var1.readUnsignedByte() == 1;
      if(Client.field1161 == 0 && Client.rights >= 2) {
         this.hidden = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3840(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "-922492652"
   )
   static void method1092(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method1461()?1:0;
                     var12 = var8.method1461()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method1461()?1:0;
                     var12 = var8.method1461()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method1092(var0, var1, var6, var3, var4);
         method1092(var0, var6 + 1, var2, var3, var4);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-1349636675"
   )
   static boolean method1093(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lclass276;",
      garbageValue = "-60635453"
   )
   public static class276 method1095(int var0) {
      class276[] var1 = class15.method109();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class276 var3 = var1[var2];
         if(var0 == var3.field3735) {
            return var3;
         }
      }

      return null;
   }
}
