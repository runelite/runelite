import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   static IndexData field861;
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1643162813
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 619859837
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("m")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1374409013
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1698494817
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -260287891
   )
   int field842;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 103671873
   )
   int field848;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1504026365
   )
   int field844;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1168129377
   )
   int field845;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1204372213
   )
   int field846;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1457905545
   )
   int field847;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1607885959
   )
   int field849;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1910684475
   )
   int field850;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1629569917
   )
   int field851;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 368089701
   )
   int field852;
   @ObfuscatedName("q")
   boolean field841;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -234391643
   )
   @Export("team")
   int team;
   @ObfuscatedName("i")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -895826755
   )
   int field853;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1247523135
   )
   int field857;
   @ObfuscatedName("g")
   boolean field836;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1948807437
   )
   int field859;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -651115887
   )
   int field860;

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.field848 = 0;
      this.field844 = 0;
      this.field841 = false;
      this.team = 0;
      this.hidden = false;
      this.field836 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "564557637"
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
               int var8 = WorldMapType2.getItemDefinition(var4[var5] - 512).field3601;
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

      super.field1152 = var1.readUnsignedShort();
      if(super.field1152 == 65535) {
         super.field1152 = -1;
      }

      super.field1153 = super.field1152;
      super.field1154 = var1.readUnsignedShort();
      if(super.field1154 == 65535) {
         super.field1154 = -1;
      }

      super.field1155 = var1.readUnsignedShort();
      if(super.field1155 == 65535) {
         super.field1155 = -1;
      }

      super.field1156 = var1.readUnsignedShort();
      if(super.field1156 == 65535) {
         super.field1156 = -1;
      }

      super.field1157 = var1.readUnsignedShort();
      if(super.field1157 == 65535) {
         super.field1157 = -1;
      }

      super.field1158 = var1.readUnsignedShort();
      if(super.field1158 == 65535) {
         super.field1158 = -1;
      }

      this.name = var1.readString();
      if(this == class181.localPlayer) {
         class153.field2127 = this.name;
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

      this.composition.method4125(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-418831759"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class1.getNpcDefinition(this.composition.transformedNpcId).field3619:1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Leh;",
      garbageValue = "-473112722"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class13.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field841 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class13.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4131(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2623();
            super.field1179 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field841 && super.graphic != -1 && super.field1184 != -1) {
               var4 = class227.getSpotAnimType(super.graphic).method4494(super.field1184);
               if(var4 != null) {
                  var4.method2635(0, -super.field1187, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field841 && this.model != null) {
               if(Client.gameCycle >= this.field844) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field848 && Client.gameCycle < this.field844) {
                  var4 = this.model;
                  var4.method2635(this.field845 - super.x, this.field846 - this.field842, this.field847 - super.y);
                  if(super.orientation == 512) {
                     var4.method2630();
                     var4.method2630();
                     var4.method2630();
                  } else if(super.orientation == 1024) {
                     var4.method2630();
                     var4.method2630();
                  } else if(super.orientation == 1536) {
                     var4.method2630();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2630();
                  } else if(super.orientation == 1024) {
                     var4.method2630();
                     var4.method2630();
                  } else if(super.orientation == 1536) {
                     var4.method2630();
                     var4.method2630();
                     var4.method2630();
                  }

                  var4.method2635(super.x - this.field845, this.field842 - this.field846, super.y - this.field847);
               }
            }

            var3.field1855 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-64774637"
   )
   final void method1165(int var1, int var2, byte var3) {
      if(super.animation != -1 && class13.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1174 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               AbstractByteBuffer.method3542(this, var1, var2, (byte)2);
            }

            this.method1157(var1, var2, var3);
         } else {
            this.method1156(var1, var2);
         }
      } else {
         this.method1156(var1, var2);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1338221949"
   )
   void method1156(int var1, int var2) {
      super.queueSize = 0;
      super.field1159 = 0;
      super.field1204 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "1"
   )
   final void method1157(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1203[var4] = super.field1203[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1203[0] = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "120"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)[Lie;",
      garbageValue = "-96273162"
   )
   public static class235[] method1175() {
      return new class235[]{class235.field3234, class235.field3230, class235.field3235, class235.field3233, class235.field3236, class235.field3232, class235.field3229, class235.field3231};
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1346322310"
   )
   static void method1174() {
      class94.playerIndexesCount = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class94.field1407[var0] = null;
         class94.field1410[var0] = 1;
      }

   }
}
