import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -147915823
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1364433173
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("h")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 24696511
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 165227513
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 302571869
   )
   int field797;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 407958659
   )
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 442905125
   )
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -88772893
   )
   int field798;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -535016895
   )
   int field792;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 4878299
   )
   int field793;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lee;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 15293571
   )
   int field781;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1816233017
   )
   int field796;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 506730563
   )
   int field784;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1897086251
   )
   int field795;
   @ObfuscatedName("w")
   @Export("isLowDetail")
   boolean isLowDetail;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1656009725
   )
   @Export("team")
   int team;
   @ObfuscatedName("z")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1790326527
   )
   int field802;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1795947495
   )
   int field808;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   class289 field804;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   class289 field805;
   @ObfuscatedName("av")
   boolean field806;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1422540561
   )
   int field807;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1651054051
   )
   int field791;

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
      this.field804 = class289.field3723;
      this.field805 = class289.field3723;
      this.field806 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgn;B)V",
      garbageValue = "-87"
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
               int var8 = ContextMenuRow.getItemDefinition(var4[var5] - 512).int1;
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

      super.field1100 = var1.readUnsignedShort();
      if(super.field1100 == 65535) {
         super.field1100 = -1;
      }

      super.field1101 = super.field1100;
      super.field1102 = var1.readUnsignedShort();
      if(super.field1102 == 65535) {
         super.field1102 = -1;
      }

      super.field1099 = var1.readUnsignedShort();
      if(super.field1099 == 65535) {
         super.field1099 = -1;
      }

      super.field1130 = var1.readUnsignedShort();
      if(super.field1130 == 65535) {
         super.field1130 = -1;
      }

      super.field1105 = var1.readUnsignedShort();
      if(super.field1105 == 65535) {
         super.field1105 = -1;
      }

      super.field1106 = var1.readUnsignedShort();
      if(super.field1106 == 65535) {
         super.field1106 = -1;
      }

      this.name = new Name(var1.readString(), class234.loginType);
      this.method1214();
      this.method1186();
      if(this == OwnWorldComparator.localPlayer) {
         RunException.field2144 = this.name.getName();
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

      this.composition.method4392(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1963867303"
   )
   @Export("isFriend")
   boolean isFriend() {
      if(this.field804 == class289.field3723) {
         this.method1196();
      }

      return this.field804 == class289.field3722;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-27258"
   )
   void method1214() {
      this.field804 = class289.field3723;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1414216431"
   )
   void method1196() {
      this.field804 = ContextMenuRow.friendManager.field1194.isMember(this.name)?class289.field3722:class289.field3726;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1671749994"
   )
   @Export("isClanMember")
   boolean isClanMember() {
      if(this.field805 == class289.field3723) {
         this.method1218();
      }

      return this.field805 == class289.field3722;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1925926002"
   )
   void method1186() {
      this.field805 = class289.field3723;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "587072454"
   )
   void method1218() {
      this.field805 = class2.clanMemberManager != null && class2.clanMemberManager.isMember(this.name)?class289.field3722:class289.field3726;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1425832895"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?Tile.getNpcDefinition(this.composition.transformedNpcId).field3661:1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lee;",
      garbageValue = "582025400"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?Occluder.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.isLowDetail && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?Occluder.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.isLowDetail && super.graphic != -1 && super.field1104 != -1) {
               var4 = IndexFile.getSpotAnimType(super.graphic).getModel(super.field1104);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1135, 0);
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
                  var4.offsetBy(this.field798 - super.x, this.field792 - this.field797, this.field793 - super.y);
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

                  var4.offsetBy(super.x - this.field798, this.field797 - this.field792, super.y - this.field793);
               }
            }

            var3.field1827 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1249999883"
   )
   final void method1190(int var1, int var2, byte var3) {
      if(super.animation != -1 && Occluder.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1122 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class65.method1123(this, var1, var2, (byte)2);
            }

            this.method1192(var1, var2, var3);
         } else {
            this.method1191(var1, var2);
         }
      } else {
         this.method1191(var1, var2);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1925687907"
   )
   void method1191(int var1, int var2) {
      super.queueSize = 0;
      super.field1153 = 0;
      super.field1128 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-2012900661"
   )
   final void method1192(int var1, int var2, byte var3) {
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "51"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)[Llc;",
      garbageValue = "-2113421021"
   )
   public static class312[] method1210() {
      return new class312[]{class312.field3855, class312.field3856, class312.field3854};
   }
}
