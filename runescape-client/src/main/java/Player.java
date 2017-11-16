import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   static IndexData field840;
   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "[Lkb;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("b")
   @Export("name")
   String name;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2080168271
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1529550891
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("f")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 811274801
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -559545059
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1206624755
   )
   int field821;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1253887675
   )
   int field839;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2100783121
   )
   int field837;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -639349311
   )
   int field824;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1168687605
   )
   int field823;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1220527153
   )
   int field826;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 990191625
   )
   int field828;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2028035841
   )
   int field829;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2096209275
   )
   int field830;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1207457649
   )
   int field831;
   @ObfuscatedName("p")
   boolean field832;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1646541941
   )
   @Export("team")
   int team;
   @ObfuscatedName("l")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 196878429
   )
   int field835;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1946109595
   )
   int field834;
   @ObfuscatedName("v")
   boolean field818;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1320159827
   )
   int field838;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1441274667
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
      this.field839 = 0;
      this.field837 = 0;
      this.field832 = false;
      this.team = 0;
      this.hidden = false;
      this.field818 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "155648626"
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
               int var8 = class139.getItemDefinition(var4[var5] - 512).field3587;
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

      super.field1150 = var1.readUnsignedShort();
      if(super.field1150 == 65535) {
         super.field1150 = -1;
      }

      super.field1171 = super.field1150;
      super.field1152 = var1.readUnsignedShort();
      if(super.field1152 == 65535) {
         super.field1152 = -1;
      }

      super.field1153 = var1.readUnsignedShort();
      if(super.field1153 == 65535) {
         super.field1153 = -1;
      }

      super.field1154 = var1.readUnsignedShort();
      if(super.field1154 == 65535) {
         super.field1154 = -1;
      }

      super.field1155 = var1.readUnsignedShort();
      if(super.field1155 == 65535) {
         super.field1155 = -1;
      }

      super.field1166 = var1.readUnsignedShort();
      if(super.field1166 == 65535) {
         super.field1166 = -1;
      }

      this.name = var1.readString();
      if(this == class275.localPlayer) {
         CombatInfo2.field3421 = this.name;
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

      this.composition.method3982(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "255"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class211.getNpcDefinition(this.composition.transformedNpcId).field3606:1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lev;",
      garbageValue = "1008738898"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class90.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field832 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?class90.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3999(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2511();
            super.field1151 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field832 && super.graphic != -1 && super.field1190 != -1) {
               var4 = class245.getSpotAnimType(super.graphic).method4321(super.field1190);
               if(var4 != null) {
                  var4.method2523(0, -super.field1185, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field832 && this.model != null) {
               if(Client.gameCycle >= this.field837) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field839 && Client.gameCycle < this.field837) {
                  var4 = this.model;
                  var4.method2523(this.field824 - super.x, this.field823 - this.field821, this.field826 - super.y);
                  if(super.orientation == 512) {
                     var4.method2518();
                     var4.method2518();
                     var4.method2518();
                  } else if(super.orientation == 1024) {
                     var4.method2518();
                     var4.method2518();
                  } else if(super.orientation == 1536) {
                     var4.method2518();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2518();
                  } else if(super.orientation == 1024) {
                     var4.method2518();
                     var4.method2518();
                  } else if(super.orientation == 1536) {
                     var4.method2518();
                     var4.method2518();
                     var4.method2518();
                  }

                  var4.method2523(super.x - this.field824, this.field821 - this.field823, super.y - this.field826);
               }
            }

            var3.field1831 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "73"
   )
   final void method1071(int var1, int var2, byte var3) {
      if(super.animation != -1 && class90.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1172 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               WidgetNode.method1026(this, var1, var2, (byte)2);
            }

            this.method1069(var1, var2, var3);
         } else {
            this.method1068(var1, var2);
         }
      } else {
         this.method1068(var1, var2);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "7"
   )
   void method1068(int var1, int var2) {
      super.queueSize = 0;
      super.field1203 = 0;
      super.field1202 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-20"
   )
   final void method1069(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1189[var4] = super.field1189[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1189[0] = var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "43"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1239262179"
   )
   static final void method1091(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4639()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1148 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field920[var4][var5] == Client.field951) {
                     continue;
                  }

                  Client.field920[var4][var5] = Client.field951;
               }

               if(!var2.composition.field3611) {
                  var3 -= Integer.MIN_VALUE;
               }

               Client.region.method2699(class28.plane, var2.x, var2.y, class18.getTileHeight(var2.field1148 * 64 - 64 + var2.x, var2.field1148 * 64 - 64 + var2.y, class28.plane), var2.field1148 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1147);
            }
         }
      }

   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1914036741"
   )
   static final int method1079() {
      if(class70.preferences.hideRoofs) {
         return class28.plane;
      } else {
         int var0 = class18.getTileHeight(class45.cameraX, Client.cameraY, class28.plane);
         return var0 - class279.cameraZ < 800 && (class61.tileSettings[class28.plane][class45.cameraX >> 7][Client.cameraY >> 7] & 4) != 0?class28.plane:3;
      }
   }
}
