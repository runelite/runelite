import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -865313811
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -388046383
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("y")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1460757203
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1234754141
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 627618785
   )
   int field839;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -688453609
   )
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2079418339
   )
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 917019135
   )
   int field830;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -899568867
   )
   int field837;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -794681169
   )
   int field835;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 528891349
   )
   int field832;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -992088323
   )
   int field838;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -394221893
   )
   int field846;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1032969479
   )
   int field834;
   @ObfuscatedName("c")
   @Export("isLowDetail")
   boolean isLowDetail;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1144565217
   )
   @Export("team")
   int team;
   @ObfuscatedName("l")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1624691521
   )
   int field844;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1606636339
   )
   int field845;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   class303 field849;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lkj;"
   )
   class303 field848;
   @ObfuscatedName("ak")
   boolean field840;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 2064833235
   )
   int field826;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -647296851
   )
   int field850;

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
      this.field849 = class303.field3844;
      this.field848 = class303.field3844;
      this.field840 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1665755301"
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
               int var8 = class251.getItemDefinition(var4[var5] - 512).int1;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class236.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == 65535) {
         super.idlePoseAnimation = -1;
      }

      super.field1145 = var1.readUnsignedShort();
      if(super.field1145 == 65535) {
         super.field1145 = -1;
      }

      super.field1148 = super.field1145;
      super.field1163 = var1.readUnsignedShort();
      if(super.field1163 == 65535) {
         super.field1163 = -1;
      }

      super.field1139 = var1.readUnsignedShort();
      if(super.field1139 == 65535) {
         super.field1139 = -1;
      }

      super.field1149 = var1.readUnsignedShort();
      if(super.field1149 == 65535) {
         super.field1149 = -1;
      }

      super.field1147 = var1.readUnsignedShort();
      if(super.field1147 == 65535) {
         super.field1147 = -1;
      }

      super.field1151 = var1.readUnsignedShort();
      if(super.field1151 == 65535) {
         super.field1151 = -1;
      }

      this.name = new Name(var1.readString(), class21.loginType);
      this.method1141();
      this.method1144();
      if(this == TotalQuantityComparator.localPlayer) {
         RunException.field2172 = this.name.getName();
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

      this.composition.method4512(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1892506601"
   )
   @Export("isFriend")
   boolean isFriend() {
      if(this.field849 == class303.field3844) {
         this.method1168();
      }

      return this.field849 == class303.field3842;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1829028521"
   )
   void method1141() {
      this.field849 = class303.field3844;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1057157613"
   )
   void method1168() {
      this.field849 = ContextMenuRow.friendManager.method1717(this.name)?class303.field3842:class303.field3843;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "22373"
   )
   @Export("isClanMember")
   boolean isClanMember() {
      if(this.field848 == class303.field3844) {
         this.method1145();
      }

      return this.field848 == class303.field3842;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-994021167"
   )
   void method1144() {
      this.field848 = class303.field3844;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1107733755"
   )
   void method1145() {
      this.field848 = WidgetNode.clanMemberManager != null && WidgetNode.clanMemberManager.isMember(this.name)?class303.field3842:class303.field3843;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-495932704"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class255.getNpcDefinition(this.composition.transformedNpcId).field3709:1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lel;",
      garbageValue = "2099798459"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class270.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.isLowDetail && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?class270.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.isLowDetail && super.graphic != -1 && super.field1177 != -1) {
               var4 = class55.getSpotAnimType(super.graphic).getModel(super.field1177);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1157, 0);
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
                  var4.offsetBy(this.field830 - super.x, this.field837 - this.field839, this.field835 - super.y);
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

                  var4.offsetBy(super.x - this.field830, this.field839 - this.field837, super.y - this.field835);
               }
            }

            var3.field1859 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1438073828"
   )
   final void method1148(int var1, int var2, byte var3) {
      if(super.animation != -1 && class270.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1142 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class189.method3543(this, var1, var2, (byte)2);
            }

            this.method1160(var1, var2, var3);
         } else {
            this.method1149(var1, var2);
         }
      } else {
         this.method1149(var1, var2);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1994333622"
   )
   void method1149(int var1, int var2) {
      super.queueSize = 0;
      super.field1198 = 0;
      super.field1197 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "902095222"
   )
   final void method1160(int var1, int var2, byte var3) {
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "123425433"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1480988318"
   )
   static boolean method1142() {
      return Client.field997 || KeyFocusListener.keyPressed[81];
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(Liw;B)Liw;",
      garbageValue = "1"
   )
   static Widget method1146(Widget var0) {
      Widget var2 = var0;
      int var3 = class28.method226(class85.getWidgetConfig(var0));
      Widget var1;
      if(var3 == 0) {
         var1 = null;
      } else {
         int var4 = 0;

         while(true) {
            if(var4 >= var3) {
               var1 = var2;
               break;
            }

            var2 = class5.getWidget(var2.parentId);
            if(var2 == null) {
               var1 = null;
               break;
            }

            ++var4;
         }
      }

      Widget var5 = var1;
      if(var1 == null) {
         var5 = var0.dragParent;
      }

      return var5;
   }
}
