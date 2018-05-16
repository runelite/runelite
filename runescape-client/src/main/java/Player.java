import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkm;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -622472595
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2009567535
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("n")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 99575255
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -99521121
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1815492519
   )
   int field572;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2082665571
   )
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1895213115
   )
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -340353
   )
   int field571;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 679314851
   )
   int field562;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -29897551
   )
   int field582;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1750997421
   )
   int field568;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -278093477
   )
   int field573;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -780779311
   )
   int field577;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -373128361
   )
   int field578;
   @ObfuscatedName("u")
   @Export("isLowDetail")
   boolean isLowDetail;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1190699813
   )
   @Export("team")
   int team;
   @ObfuscatedName("z")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1704637145
   )
   int field581;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1276964475
   )
   @Export("playerId")
   int playerId;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   class289 field584;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lke;"
   )
   class289 field580;
   @ObfuscatedName("ai")
   boolean field586;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1449199021
   )
   int field585;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 259594137
   )
   int field588;

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
      this.field584 = class289.field3652;
      this.field580 = class289.field3652;
      this.field586 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "823697146"
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
               int var8 = class120.getItemDefinition(var4[var5] - 512).team;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class185.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == 65535) {
         super.idlePoseAnimation = -1;
      }

      super.field892 = var1.readUnsignedShort();
      if(super.field892 == 65535) {
         super.field892 = -1;
      }

      super.field889 = super.field892;
      super.field890 = var1.readUnsignedShort();
      if(super.field890 == 65535) {
         super.field890 = -1;
      }

      super.field891 = var1.readUnsignedShort();
      if(super.field891 == 65535) {
         super.field891 = -1;
      }

      super.field882 = var1.readUnsignedShort();
      if(super.field882 == 65535) {
         super.field882 = -1;
      }

      super.field893 = var1.readUnsignedShort();
      if(super.field893 == 65535) {
         super.field893 = -1;
      }

      super.field894 = var1.readUnsignedShort();
      if(super.field894 == 65535) {
         super.field894 = -1;
      }

      this.name = new Name(var1.readString(), WorldMapDecoration.loginType);
      this.method1158();
      this.method1166();
      if(this == MilliTimer.localPlayer) {
         RunException.field1958 = this.name.getName();
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

      this.composition.method4485(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-20377"
   )
   @Export("isFriend")
   boolean isFriend() {
      if(this.field584 == class289.field3652) {
         this.method1135();
      }

      return this.field584 == class289.field3651;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method1158() {
      this.field584 = class289.field3652;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1840993465"
   )
   void method1135() {
      this.field584 = CacheFile.friendManager.method1693(this.name)?class289.field3651:class289.field3650;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "761211200"
   )
   @Export("isClanMember")
   boolean isClanMember() {
      if(this.field580 == class289.field3652) {
         this.method1165();
      }

      return this.field580 == class289.field3651;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "31"
   )
   void method1166() {
      this.field580 = class289.field3652;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "86"
   )
   void method1165() {
      this.field580 = WorldComparator.clanMemberManager != null && WorldComparator.clanMemberManager.isMember(this.name)?class289.field3651:class289.field3650;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1863583752"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class59.getNpcDefinition(this.composition.transformedNpcId).size:1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Ldk;",
      garbageValue = "111"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class137.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.isLowDetail && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class137.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.isLowDetail && super.graphic != -1 && super.spotAnimFrame != -1) {
               var4 = ScriptState.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field924, 0);
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
                  var4.offsetBy(this.field571 - super.x, this.field562 - this.field572, this.field582 - super.y);
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

                  var4.offsetBy(super.x - this.field571, this.field572 - this.field562, super.y - this.field582);
               }
            }

            var3.field1636 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "271359947"
   )
   final void method1134(int var1, int var2, byte var3) {
      if(super.animation != -1 && class137.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field897 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               GameCanvas.method783(this, var1, var2, (byte)2);
            }

            this.method1164(var1, var2, var3);
         } else {
            this.method1173(var1, var2);
         }
      } else {
         this.method1173(var1, var2);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1091413538"
   )
   void method1173(int var1, int var2) {
      super.queueSize = 0;
      super.field942 = 0;
      super.field936 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-13"
   )
   final void method1164(int var1, int var2, byte var3) {
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1319164937"
   )
   static final void method1178(int var0, int var1) {
      if(Client.menuOptionCount >= 2 || Client.itemSelectionState != 0 || Client.spellSelected) {
         if(Client.field740) {
            int var2 = Client.menuOptionCount - 1;
            String var4;
            if(Client.itemSelectionState == 1 && Client.menuOptionCount < 2) {
               var4 = "Use" + " " + Client.lastSelectedItemName + " " + "->";
            } else if(Client.spellSelected && Client.menuOptionCount < 2) {
               var4 = Client.field750 + " " + Client.field751 + " " + "->";
            } else {
               var4 = class234.method4595(var2);
            }

            if(Client.menuOptionCount > 2) {
               var4 = var4 + class50.getColTags(16777215) + " " + '/' + " " + (Client.menuOptionCount - 2) + " more options";
            }

            WidgetNode.fontBold12.drawRandomizedMouseoverText(var4, var0 + 4, var1 + 15, 16777215, 0, Client.gameCycle / 1000);
         }
      }
   }
}
