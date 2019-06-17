import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "[Lln;"
   )
   @Export("headIconHintSprites")
   static Sprite[] headIconHintSprites;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("username")
   Username username;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("appearance")
   PlayerAppearance appearance;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2021372599
   )
   @Export("headIconPk")
   int headIconPk;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -793415473
   )
   @Export("headIconPrayer")
   int headIconPrayer;
   @ObfuscatedName("u")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 984869133
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1136542281
   )
   @Export("skillLevel")
   int skillLevel;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1989338999
   )
   @Export("tileHeight")
   int tileHeight;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -351876137
   )
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -359981047
   )
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 665272587
   )
   @Export("__k")
   int __k;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1624108131
   )
   @Export("tileHeight2")
   int tileHeight2;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1771431457
   )
   @Export("__i")
   int __i;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ldu;"
   )
   @Export("model0")
   Model model0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1610462047
   )
   @Export("__z")
   int __z;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 224552403
   )
   @Export("__j")
   int __j;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 305969541
   )
   @Export("__s")
   int __s;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 892671055
   )
   @Export("__t")
   int __t;
   @ObfuscatedName("y")
   @Export("isUnanimated")
   boolean isUnanimated;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 91041167
   )
   @Export("team")
   int team;
   @ObfuscatedName("b")
   @Export("isHidden")
   boolean isHidden;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1332604413
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1486240677
   )
   @Export("index")
   int index;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("isFriendTriBool")
   TriBool isFriendTriBool;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   @Export("isInClanChat")
   TriBool isInClanChat;
   @ObfuscatedName("ag")
   @Export("__ag")
   boolean __ag;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -539678769
   )
   @Export("tileX")
   int tileX;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 702193221
   )
   @Export("tileY")
   int tileY;

   Player() {
      this.headIconPk = -1;
      this.headIconPrayer = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.skillLevel = 0;
      this.animationCycleStart = 0;
      this.animationCycleEnd = 0;
      this.isUnanimated = false;
      this.team = 0;
      this.isHidden = false;
      this.isFriendTriBool = TriBool.TriBool_unknown;
      this.isInClanChat = TriBool.TriBool_unknown;
      this.__ag = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-801926003"
   )
   @Export("read")
   final void read(Buffer var1) {
      var1.index = 0;
      int var2 = var1.readUnsignedByte();
      this.headIconPk = var1.readByte();
      this.headIconPrayer = var1.readByte();
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
            var4[var7] = var6 + (var5 << 8);
            if(var7 == 0 && var4[0] == 65535) {
               var3 = var1.__ag_302();
               break;
            }

            if(var4[var7] >= 512) {
               int var8 = Skills.getItemDefinition(var4[var7] - 512).int1;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var5 = 0; var5 < 5; ++var5) {
         var6 = var1.readUnsignedByte();
         if(var6 < 0 || var6 >= class229.__hz_l[var5].length) {
            var6 = 0;
         }

         var9[var5] = var6;
      }

      super.idleSequence = var1.__ag_302();
      if(super.idleSequence == 65535) {
         super.idleSequence = -1;
      }

      super.turnLeftSequence = var1.__ag_302();
      if(super.turnLeftSequence == 65535) {
         super.turnLeftSequence = -1;
      }

      super.turnRightSequence = super.turnLeftSequence;
      super.walkSequence = var1.__ag_302();
      if(super.walkSequence == 65535) {
         super.walkSequence = -1;
      }

      super.walkTurnSequence = var1.__ag_302();
      if(super.walkTurnSequence == 65535) {
         super.walkTurnSequence = -1;
      }

      super.walkTurnLeftSequence = var1.__ag_302();
      if(super.walkTurnLeftSequence == 65535) {
         super.walkTurnLeftSequence = -1;
      }

      super.walkTurnRightSequence = var1.__ag_302();
      if(super.walkTurnRightSequence == 65535) {
         super.walkTurnRightSequence = -1;
      }

      super.runSequence = var1.__ag_302();
      if(super.runSequence == 65535) {
         super.runSequence = -1;
      }

      this.username = new Username(var1.readStringCp1252NullTerminated(), KeyHandler.loginType);
      this.clearIsFriend();
      this.clearIsInClanChat();
      if(this == Canvas.localPlayer) {
         RunException.localPlayerName = this.username.getName();
      }

      this.combatLevel = var1.readUnsignedByte();
      this.skillLevel = var1.__ag_302();
      this.isHidden = var1.readUnsignedByte() == 1;
      if(Client.gameBuild == 0 && Client.rights >= 2) {
         this.isHidden = false;
      }

      if(this.appearance == null) {
         this.appearance = new PlayerAppearance();
      }

      this.appearance.__m_385(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "92"
   )
   @Export("isFriend")
   boolean isFriend() {
      if(this.isFriendTriBool == TriBool.TriBool_unknown) {
         this.checkIsFriend();
      }

      return this.isFriendTriBool == TriBool.TriBool_true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2059706128"
   )
   @Export("clearIsFriend")
   void clearIsFriend() {
      this.isFriendTriBool = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2126310249"
   )
   @Export("checkIsFriend")
   void checkIsFriend() {
      this.isFriendTriBool = WorldMapArea.friendSystem.__t_161(this.username)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "21"
   )
   @Export("isClanMember")
   boolean isClanMember() {
      if(this.isInClanChat == TriBool.TriBool_unknown) {
         this.updateIsInClanChat();
      }

      return this.isInClanChat == TriBool.TriBool_true;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1982407728"
   )
   @Export("clearIsInClanChat")
   void clearIsInClanChat() {
      this.isInClanChat = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "833825629"
   )
   @Export("updateIsInClanChat")
   void updateIsInClanChat() {
      this.isInClanChat = PacketWriter.clanChat != null && PacketWriter.clanChat.contains(this.username)?TriBool.TriBool_true:TriBool.TriBool_false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2025332260"
   )
   @Export("transformedSize")
   int transformedSize() {
      return this.appearance != null && this.appearance.npcTransformId != -1?ObjectDefinition.getNpcDefinition(this.appearance.npcTransformId).size:1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ldu;",
      garbageValue = "-2134947096"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.appearance == null) {
         return null;
      } else {
         SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0?WorldMapAreaData.getSequenceDefinition(super.sequence):null;
         SequenceDefinition var2 = super.movementSequence != -1 && !this.isUnanimated && (super.idleSequence != super.movementSequence || var1 == null)?WorldMapAreaData.getSequenceDefinition(super.movementSequence):null;
         Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.defaultHeight = var3.height;
            Model var4;
            Model[] var5;
            if(!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
               var4 = class50.getSpotAnimationDefinition(super.spotAnimation).getModel(super.spotAnimationFrame);
               if(var4 != null) {
                  var4.offsetBy(0, -super.heightOffset, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.isUnanimated && this.model0 != null) {
               if(Client.cycle >= this.animationCycleEnd) {
                  this.model0 = null;
               }

               if(Client.cycle >= this.animationCycleStart && Client.cycle < this.animationCycleEnd) {
                  var4 = this.model0;
                  var4.offsetBy(this.__k - super.x, this.tileHeight2 - this.tileHeight, this.__i - super.y);
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

                  var4.offsetBy(super.x - this.__k, this.tileHeight - this.tileHeight2, super.y - this.__i);
               }
            }

            var3.isSingleTile = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-2066158770"
   )
   @Export("__x_130")
   final void __x_130(int var1, int var2, byte var3) {
      if(super.sequence != -1 && WorldMapAreaData.getSequenceDefinition(super.sequence).__s == 1) {
         super.sequence = -1;
      }

      super.__bc = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               WorldMapIcon2.method316(this, var1, var2, (byte)2);
            }

            this.__a_131(var1, var2, var3);
         } else {
            this.resetPath(var1, var2);
         }
      } else {
         this.resetPath(var1, var2);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1966552419"
   )
   @Export("resetPath")
   void resetPath(int var1, int var2) {
      super.pathLength = 0;
      super.__ch = 0;
      super.__cq = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.transformedSize();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1280043751"
   )
   @Export("__a_131")
   final void __a_131(int var1, int var2, byte var3) {
      if(super.pathLength < 9) {
         ++super.pathLength;
      }

      for(int var4 = super.pathLength; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.pathTraversed[var4] = super.pathTraversed[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.pathTraversed[0] = var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "1"
   )
   @Export("isVisible")
   final boolean isVisible() {
      return this.appearance != null;
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   static void method1281() {
      if(Client.isSpellSelected) {
         Widget var0 = class204.getWidgetChild(ServerBuild.__iy_lo, Client.__client_lc);
         if(var0 != null && var0.onTargetLeave != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.args0 = var0.onTargetLeave;
            AbstractIndexCache.runScript(var1);
         }

         Client.isSpellSelected = false;
         class22.method295(var0);
      }

   }
}
