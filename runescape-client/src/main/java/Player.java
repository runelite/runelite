import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = -344450419
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1027722121
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -625409671
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("x")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1080214623
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 179111129
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1044189151
   )
   int field828;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1100019033
   )
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -838319363
   )
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 620824569
   )
   int field831;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 462064195
   )
   int field821;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -598601075
   )
   int field833;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1305260793
   )
   int field835;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2081719689
   )
   int field826;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1424358779
   )
   int field848;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1879519297
   )
   int field838;
   @ObfuscatedName("v")
   @Export("isLowDetail")
   boolean isLowDetail;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1690504761
   )
   @Export("team")
   int team;
   @ObfuscatedName("u")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -839441355
   )
   int field842;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1260932957
   )
   int field843;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   class303 field841;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   class303 field845;
   @ObfuscatedName("ac")
   boolean field837;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 46656415
   )
   int field847;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1381277219
   )
   int field846;

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
      this.field841 = class303.field3842;
      this.field845 = class303.field3842;
      this.field837 = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-2010554176"
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
               int var8 = GameObject.getItemDefinition(var4[var5] - 512).int1;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= GameCanvas.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == 65535) {
         super.idlePoseAnimation = -1;
      }

      super.field1195 = var1.readUnsignedShort();
      if(super.field1195 == 65535) {
         super.field1195 = -1;
      }

      super.field1157 = super.field1195;
      super.field1158 = var1.readUnsignedShort();
      if(super.field1158 == 65535) {
         super.field1158 = -1;
      }

      super.field1172 = var1.readUnsignedShort();
      if(super.field1172 == 65535) {
         super.field1172 = -1;
      }

      super.field1160 = var1.readUnsignedShort();
      if(super.field1160 == 65535) {
         super.field1160 = -1;
      }

      super.field1161 = var1.readUnsignedShort();
      if(super.field1161 == 65535) {
         super.field1161 = -1;
      }

      super.field1162 = var1.readUnsignedShort();
      if(super.field1162 == 65535) {
         super.field1162 = -1;
      }

      this.name = new Name(var1.readString(), Client.loginType);
      this.method1166();
      this.method1145();
      if(this == WorldComparator.localPlayer) {
         RunException.field2176 = this.name.getName();
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

      this.composition.method4408(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2048748265"
   )
   @Export("isFriend")
   boolean isFriend() {
      if(this.field841 == class303.field3842) {
         this.method1143();
      }

      return this.field841 == class303.field3841;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2059978993"
   )
   void method1166() {
      this.field841 = class303.field3842;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "884143338"
   )
   void method1143() {
      this.field841 = RunException.friendManager.method1670(this.name)?class303.field3841:class303.field3843;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "484217974"
   )
   @Export("isClanMember")
   boolean isClanMember() {
      if(this.field845 == class303.field3842) {
         this.method1146();
      }

      return this.field845 == class303.field3841;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-114"
   )
   void method1145() {
      this.field845 = class303.field3842;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "15"
   )
   void method1146() {
      this.field845 = class33.clanMemberManager != null && class33.clanMemberManager.isMember(this.name)?class303.field3841:class303.field3843;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1344122807"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?ScriptEvent.getNpcDefinition(this.composition.transformedNpcId).field3702:1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Led;",
      garbageValue = "-83"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?ISAACCipher.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.isLowDetail || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:ISAACCipher.getAnimation(super.poseAnimation);
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.isLowDetail && super.graphic != -1 && super.spotAnimFrame != -1) {
               var4 = class249.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1191, 0);
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
                  var4.offsetBy(this.field831 - super.x, this.field821 - this.field828, this.field833 - super.y);
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

                  var4.offsetBy(super.x - this.field831, this.field828 - this.field821, super.y - this.field833);
               }
            }

            var3.field1850 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "28"
   )
   final void method1149(int var1, int var2, byte var3) {
      if(super.animation != -1 && ISAACCipher.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1165 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.getSize();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var8 = class18.method144(var5, var6, this.getSize(), WorldMapManager.method605(var1, var2), Client.collisionMaps[this.field842], true, Client.field1128, Client.field966);
                  if(var8 >= 1) {
                     for(int var9 = 0; var9 < var8 - 1; ++var9) {
                        var4.method1167(Client.field1128[var9], Client.field966[var9], (byte)2);
                     }
                  }
               }
            }

            this.method1167(var1, var2, var3);
         } else {
            this.method1159(var1, var2);
         }
      } else {
         this.method1159(var1, var2);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2048779069"
   )
   void method1159(int var1, int var2) {
      super.queueSize = 0;
      super.field1194 = 0;
      super.field1208 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-76"
   )
   final void method1167(int var1, int var2, byte var3) {
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1859897197"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "75"
   )
   @Export("worldToScreen")
   static final void worldToScreen(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class5.getTileHeight(var0, var1, class237.plane) - var2;
         var0 -= Sequence.cameraX;
         var3 -= Area.cameraZ;
         var1 -= ChatLineBuffer.cameraY;
         int var4 = Graphics3D.SINE[BoundingBox3D.cameraPitch];
         int var5 = Graphics3D.COSINE[BoundingBox3D.cameraPitch];
         int var6 = Graphics3D.SINE[ClientPacket.cameraYaw];
         int var7 = Graphics3D.COSINE[ClientPacket.cameraYaw];
         int var8 = var0 * var7 + var6 * var1 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var4 * var1 >> 16;
         var1 = var3 * var4 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.screenX = var0 * Client.scale / var1 + Client.viewportWidth / 2;
            Client.screenY = var8 * Client.scale / var1 + Client.viewportHeight / 2;
         } else {
            Client.screenX = -1;
            Client.screenY = -1;
         }

      } else {
         Client.screenX = -1;
         Client.screenY = -1;
      }
   }
}
