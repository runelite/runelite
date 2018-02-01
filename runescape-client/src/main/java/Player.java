import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   @Export("headIconsPrayer")
   static SpritePixels[] headIconsPrayer;
   @ObfuscatedName("jx")
   @ObfuscatedGetter(
      intValue = 665355555
   )
   static int field794;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1709128625
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1000099375
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("a")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -671862043
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1941732073
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1167724347
   )
   int field799;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1049538583
   )
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -845555655
   )
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -737158353
   )
   int field797;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1010133355
   )
   int field791;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1254268445
   )
   int field806;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -464799005
   )
   int field801;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2014353799
   )
   int field804;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1498949835
   )
   int field803;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2061188963
   )
   int field816;
   @ObfuscatedName("k")
   @Export("isLowDetail")
   boolean isLowDetail;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 179666291
   )
   @Export("team")
   int team;
   @ObfuscatedName("u")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1513007913
   )
   int field808;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -513788545
   )
   int field809;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   class278 field810;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   class278 field811;
   @ObfuscatedName("aa")
   boolean field812;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -893689493
   )
   int field813;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 80472467
   )
   int field814;

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
      this.field810 = class278.field3690;
      this.field811 = class278.field3690;
      this.field812 = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "-1889104619"
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
               int var8 = CombatInfo1.getItemDefinition(var4[var5] - 512).int1;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class70.colorsToReplace[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == 65535) {
         super.idlePoseAnimation = -1;
      }

      super.field1106 = var1.readUnsignedShort();
      if(super.field1106 == 65535) {
         super.field1106 = -1;
      }

      super.field1149 = super.field1106;
      super.field1105 = var1.readUnsignedShort();
      if(super.field1105 == 65535) {
         super.field1105 = -1;
      }

      super.field1144 = var1.readUnsignedShort();
      if(super.field1144 == 65535) {
         super.field1144 = -1;
      }

      super.field1104 = var1.readUnsignedShort();
      if(super.field1104 == 65535) {
         super.field1104 = -1;
      }

      super.field1108 = var1.readUnsignedShort();
      if(super.field1108 == 65535) {
         super.field1108 = -1;
      }

      super.field1109 = var1.readUnsignedShort();
      if(super.field1109 == 65535) {
         super.field1109 = -1;
      }

      this.name = new Name(var1.readString(), class34.loginType);
      this.method1130();
      this.method1133();
      if(this == class36.localPlayer) {
         RunException.field2098 = this.name.getName();
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

      this.composition.method4208(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   @Export("isFriend")
   boolean isFriend() {
      if(this.field810 == class278.field3690) {
         this.method1131();
      }

      return this.field810 == class278.field3691;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1269565659"
   )
   void method1130() {
      this.field810 = class278.field3690;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1722784207"
   )
   void method1131() {
      this.field810 = ServerPacket.friendManager.field1191.isMember(this.name)?class278.field3691:class278.field3692;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "40"
   )
   @Export("isClanMember")
   boolean isClanMember() {
      if(this.field811 == class278.field3690) {
         this.method1134();
      }

      return this.field811 == class278.field3691;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-28"
   )
   void method1133() {
      this.field811 = class278.field3690;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "744553828"
   )
   void method1134() {
      this.field811 = class234.clanMemberManager != null && class234.clanMemberManager.isMember(this.name)?class278.field3691:class278.field3692;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2092726723"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class230.getNpcDefinition(this.composition.transformedNpcId).field3611:1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Len;",
      garbageValue = "-2096748380"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?CacheFile.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.isLowDetail || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:CacheFile.getAnimation(super.poseAnimation);
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.field1147 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.isLowDetail && super.graphic != -1 && super.field1135 != -1) {
               var4 = GrandExchangeEvents.getSpotAnimType(super.graphic).getModel(super.field1135);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1138, 0);
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
                  var4.offsetBy(this.field797 - super.x, this.field791 - this.field799, this.field806 - super.y);
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

                  var4.offsetBy(super.x - this.field797, this.field799 - this.field791, super.y - this.field806);
               }
            }

            var3.field1825 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIBS)V",
      garbageValue = "16384"
   )
   final void method1128(int var1, int var2, byte var3) {
      if(super.animation != -1 && CacheFile.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1125 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               NameableContainer.method5105(this, var1, var2, (byte)2);
            }

            this.method1151(var1, var2, var3);
         } else {
            this.method1138(var1, var2);
         }
      } else {
         this.method1138(var1, var2);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1502061413"
   )
   void method1138(int var1, int var2) {
      super.queueSize = 0;
      super.field1156 = 0;
      super.field1136 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-47"
   )
   final void method1151(int var1, int var2, byte var3) {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1872154705"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-1778873022"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      PacketNode var8;
      if(var2 == 1) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field871 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class35.method501(ClientPacket.field2320, Client.field867.field1439);
         var8.packetBuffer.writeShortLE(Client.field960);
         var8.packetBuffer.putShortLE(FontName.selectedItemIndex);
         var8.packetBuffer.method3430(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShortLE(var0 + WorldMapType1.baseX);
         var8.packetBuffer.putShort(class85.baseY + var1);
         var8.packetBuffer.putInt(class37.field476);
         var8.packetBuffer.writeShortLE(var3 >> 14 & 32767);
         Client.field867.method2021(var8);
      } else if(var2 == 2) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field871 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class35.method501(ClientPacket.field2361, Client.field867.field1439);
         var8.packetBuffer.writeIntLE16(Client.field963);
         var8.packetBuffer.method3430(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.method3401(class35.field464);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.putShort(class85.baseY + var1);
         var8.packetBuffer.writeIntLE16(var0 + WorldMapType1.baseX);
         Client.field867.method2021(var8);
      } else if(var2 == 3) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field871 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class35.method501(ClientPacket.field2329, Client.field867.field1439);
         var8.packetBuffer.writeIntLE16(var0 + WorldMapType1.baseX);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.putShortLE(class85.baseY + var1);
         var8.packetBuffer.method3429(KeyFocusListener.keyPressed[82]?1:0);
         Client.field867.method2021(var8);
      } else if(var2 == 4) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field871 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class35.method501(ClientPacket.field2307, Client.field867.field1439);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(class85.baseY + var1);
         var8.packetBuffer.writeIntLE16(var0 + WorldMapType1.baseX);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         Client.field867.method2021(var8);
      } else if(var2 == 5) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field871 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class35.method501(ClientPacket.field2335, Client.field867.field1439);
         var8.packetBuffer.putShortLE(var3 >> 14 & 32767);
         var8.packetBuffer.writeShortLE(class85.baseY + var1);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShortLE(var0 + WorldMapType1.baseX);
         Client.field867.method2021(var8);
      } else if(var2 == 6) {
         Client.lastLeftClickX = var6;
         Client.lastLeftClickY = var7;
         Client.cursorState = 2;
         Client.field871 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var8 = class35.method501(ClientPacket.field2303, Client.field867.field1439);
         var8.packetBuffer.putShort(var0 + WorldMapType1.baseX);
         var8.packetBuffer.putShort(var3 >> 14 & 32767);
         var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
         var8.packetBuffer.putShort(class85.baseY + var1);
         Client.field867.method2021(var8);
      } else {
         PacketNode var9;
         NPC var16;
         if(var2 == 7) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class35.method501(ClientPacket.field2282, Client.field867.field1439);
               var9.packetBuffer.writeShortLE(Client.field960);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.writeIntLE16(FontName.selectedItemIndex);
               var9.packetBuffer.putInt(class37.field476);
               var9.packetBuffer.putShortLE(var3);
               Client.field867.method2021(var9);
            }
         } else if(var2 == 8) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class35.method501(ClientPacket.field2376, Client.field867.field1439);
               var9.packetBuffer.putInt(class35.field464);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.writeShortLE(var3);
               var9.packetBuffer.putShortLE(Client.field963);
               Client.field867.method2021(var9);
            }
         } else if(var2 == 9) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class35.method501(ClientPacket.field2284, Client.field867.field1439);
               var9.packetBuffer.putShort(var3);
               var9.packetBuffer.method3430(KeyFocusListener.keyPressed[82]?1:0);
               Client.field867.method2021(var9);
            }
         } else if(var2 == 10) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class35.method501(ClientPacket.field2338, Client.field867.field1439);
               var9.packetBuffer.method3397(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.writeIntLE16(var3);
               Client.field867.method2021(var9);
            }
         } else if(var2 == 11) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class35.method501(ClientPacket.field2345, Client.field867.field1439);
               var9.packetBuffer.method3397(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.putShort(var3);
               Client.field867.method2021(var9);
            }
         } else if(var2 == 12) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class35.method501(ClientPacket.field2316, Client.field867.field1439);
               var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.putShort(var3);
               Client.field867.method2021(var9);
            }
         } else if(var2 == 13) {
            var16 = Client.cachedNPCs[var3];
            if(var16 != null) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class35.method501(ClientPacket.field2302, Client.field867.field1439);
               var9.packetBuffer.method3429(KeyFocusListener.keyPressed[82]?1:0);
               var9.packetBuffer.writeIntLE16(var3);
               Client.field867.method2021(var9);
            }
         } else {
            Player var19;
            if(var2 == 14) {
               var19 = Client.cachedPlayers[var3];
               if(var19 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field871 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = class35.method501(ClientPacket.field2353, Client.field867.field1439);
                  var9.packetBuffer.putShortLE(var3);
                  var9.packetBuffer.method3401(class37.field476);
                  var9.packetBuffer.method3429(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.putShort(Client.field960);
                  var9.packetBuffer.writeIntLE16(FontName.selectedItemIndex);
                  Client.field867.method2021(var9);
               }
            } else if(var2 == 15) {
               var19 = Client.cachedPlayers[var3];
               if(var19 != null) {
                  Client.lastLeftClickX = var6;
                  Client.lastLeftClickY = var7;
                  Client.cursorState = 2;
                  Client.field871 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var9 = class35.method501(ClientPacket.field2283, Client.field867.field1439);
                  var9.packetBuffer.writeIntLE16(Client.field963);
                  var9.packetBuffer.writeIntLE16(var3);
                  var9.packetBuffer.method3429(KeyFocusListener.keyPressed[82]?1:0);
                  var9.packetBuffer.writeIntLE(class35.field464);
                  Client.field867.method2021(var9);
               }
            } else if(var2 == 16) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class35.method501(ClientPacket.field2291, Client.field867.field1439);
               var8.packetBuffer.putShort(class85.baseY + var1);
               var8.packetBuffer.method3387(class37.field476);
               var8.packetBuffer.writeShortLE(var0 + WorldMapType1.baseX);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShortLE(var3);
               var8.packetBuffer.writeIntLE16(Client.field960);
               var8.packetBuffer.writeIntLE16(FontName.selectedItemIndex);
               Client.field867.method2021(var8);
            } else if(var2 == 17) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class35.method501(ClientPacket.field2309, Client.field867.field1439);
               var8.packetBuffer.writeIntLE(class35.field464);
               var8.packetBuffer.writeIntLE16(Client.field963);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.method3430(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.putShort(var0 + WorldMapType1.baseX);
               var8.packetBuffer.writeShortLE(class85.baseY + var1);
               Client.field867.method2021(var8);
            } else if(var2 == 18) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class35.method501(ClientPacket.field2317, Client.field867.field1439);
               var8.packetBuffer.method3430(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.writeIntLE16(class85.baseY + var1);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.putShortLE(var0 + WorldMapType1.baseX);
               Client.field867.method2021(var8);
            } else if(var2 == 19) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class35.method501(ClientPacket.field2310, Client.field867.field1439);
               var8.packetBuffer.putShortLE(var0 + WorldMapType1.baseX);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.writeIntLE16(var3);
               var8.packetBuffer.writeShortLE(class85.baseY + var1);
               Client.field867.method2021(var8);
            } else if(var2 == 20) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class35.method501(ClientPacket.field2324, Client.field867.field1439);
               var8.packetBuffer.writeShortLE(var3);
               var8.packetBuffer.writeShortLE(var0 + WorldMapType1.baseX);
               var8.packetBuffer.method3429(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.writeShortLE(class85.baseY + var1);
               Client.field867.method2021(var8);
            } else if(var2 == 21) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class35.method501(ClientPacket.field2334, Client.field867.field1439);
               var8.packetBuffer.putShort(var3);
               var8.packetBuffer.writeShortLE(class85.baseY + var1);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               var8.packetBuffer.writeIntLE16(var0 + WorldMapType1.baseX);
               Client.field867.method2021(var8);
            } else if(var2 == 22) {
               Client.lastLeftClickX = var6;
               Client.lastLeftClickY = var7;
               Client.cursorState = 2;
               Client.field871 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var8 = class35.method501(ClientPacket.field2306, Client.field867.field1439);
               var8.packetBuffer.writeIntLE16(var3);
               var8.packetBuffer.writeShortLE(class85.baseY + var1);
               var8.packetBuffer.putShortLE(var0 + WorldMapType1.baseX);
               var8.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
               Client.field867.method2021(var8);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class48.region.method2848();
               } else {
                  class48.region.method2946(MessageNode.plane, var0, var1, true);
               }
            } else {
               PacketNode var10;
               Widget var21;
               if(var2 == 24) {
                  var21 = class35.getWidget(var1);
                  boolean var13 = true;
                  if(var21.contentType > 0) {
                     var13 = TextureProvider.method2552(var21);
                  }

                  if(var13) {
                     var10 = class35.method501(ClientPacket.field2314, Client.field867.field1439);
                     var10.packetBuffer.putInt(var1);
                     Client.field867.method2021(var10);
                  }
               } else {
                  if(var2 == 25) {
                     var21 = class31.getWidgetChild(var1, var0);
                     if(var21 != null) {
                        Projectile.method1916();
                        WorldMapType3.method209(var1, var0, CollisionData.method3282(class60.getWidgetConfig(var21)), var21.itemId);
                        Client.itemSelectionState = 0;
                        Client.field1001 = class41.method589(var21);
                        if(Client.field1001 == null) {
                           Client.field1001 = "Null";
                        }

                        if(var21.hasScript) {
                           Client.field966 = var21.name + class1.getColTags(16777215);
                        } else {
                           Client.field966 = class1.getColTags(65280) + var21.spellName + class1.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     UrlRequest.method3037();
                  } else {
                     int var15;
                     Widget var18;
                     if(var2 == 28) {
                        var8 = class35.method501(ClientPacket.field2314, Client.field867.field1439);
                        var8.packetBuffer.putInt(var1);
                        Client.field867.method2021(var8);
                        var18 = class35.getWidget(var1);
                        if(var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
                           var15 = var18.dynamicValues[0][1];
                           class222.widgetSettings[var15] = 1 - class222.widgetSettings[var15];
                           WorldMapType1.method283(var15);
                        }
                     } else if(var2 == 29) {
                        var8 = class35.method501(ClientPacket.field2314, Client.field867.field1439);
                        var8.packetBuffer.putInt(var1);
                        Client.field867.method2021(var8);
                        var18 = class35.getWidget(var1);
                        if(var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
                           var15 = var18.dynamicValues[0][1];
                           if(class222.widgetSettings[var15] != var18.field2852[0]) {
                              class222.widgetSettings[var15] = var18.field2852[0];
                              WorldMapType1.method283(var15);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field971 == null) {
                           class80.method1795(var1, var0);
                           Client.field971 = class31.getWidgetChild(var1, var0);
                           class60.method1015(Client.field971);
                        }
                     } else if(var2 == 31) {
                        var8 = class35.method501(ClientPacket.field2285, Client.field867.field1439);
                        var8.packetBuffer.writeShortLE(Client.field960);
                        var8.packetBuffer.putShortLE(FontName.selectedItemIndex);
                        var8.packetBuffer.putInt(class37.field476);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.putShort(var0);
                        Client.field867.method2021(var8);
                        Client.mouseCrosshair = 0;
                        class25.field349 = class35.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 32) {
                        var8 = class35.method501(ClientPacket.field2342, Client.field867.field1439);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.putShortLE(var0);
                        var8.packetBuffer.putShort(var3);
                        var8.packetBuffer.method3401(class35.field464);
                        var8.packetBuffer.putShortLE(Client.field963);
                        Client.field867.method2021(var8);
                        Client.mouseCrosshair = 0;
                        class25.field349 = class35.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 33) {
                        var8 = class35.method501(ClientPacket.field2352, Client.field867.field1439);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.putShortLE(var0);
                        var8.packetBuffer.writeIntLE16(var3);
                        Client.field867.method2021(var8);
                        Client.mouseCrosshair = 0;
                        class25.field349 = class35.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 34) {
                        var8 = class35.method501(ClientPacket.field2354, Client.field867.field1439);
                        var8.packetBuffer.putShortLE(var3);
                        var8.packetBuffer.writeIntLE16(var0);
                        var8.packetBuffer.putInt(var1);
                        Client.field867.method2021(var8);
                        Client.mouseCrosshair = 0;
                        class25.field349 = class35.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 35) {
                        var8 = class35.method501(ClientPacket.field2287, Client.field867.field1439);
                        var8.packetBuffer.putShortLE(var3);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.writeIntLE16(var0);
                        Client.field867.method2021(var8);
                        Client.mouseCrosshair = 0;
                        class25.field349 = class35.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 36) {
                        var8 = class35.method501(ClientPacket.field2344, Client.field867.field1439);
                        var8.packetBuffer.writeIntLE16(var0);
                        var8.packetBuffer.putInt(var1);
                        var8.packetBuffer.writeShortLE(var3);
                        Client.field867.method2021(var8);
                        Client.mouseCrosshair = 0;
                        class25.field349 = class35.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else if(var2 == 37) {
                        var8 = class35.method501(ClientPacket.field2296, Client.field867.field1439);
                        var8.packetBuffer.putShortLE(var0);
                        var8.packetBuffer.writeIntLE16(var3);
                        var8.packetBuffer.writeIntLE(var1);
                        Client.field867.method2021(var8);
                        Client.mouseCrosshair = 0;
                        class25.field349 = class35.getWidget(var1);
                        Client.pressedItemIndex = var0;
                     } else {
                        if(var2 == 38) {
                           Projectile.method1916();
                           var21 = class35.getWidget(var1);
                           Client.itemSelectionState = 1;
                           FontName.selectedItemIndex = var0;
                           class37.field476 = var1;
                           Client.field960 = var3;
                           class60.method1015(var21);
                           Client.lastSelectedItemName = class1.getColTags(16748608) + CombatInfo1.getItemDefinition(var3).name + class1.getColTags(16777215);
                           if(Client.lastSelectedItemName == null) {
                              Client.lastSelectedItemName = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           var8 = class35.method501(ClientPacket.field2339, Client.field867.field1439);
                           var8.packetBuffer.writeShortLE(var3);
                           var8.packetBuffer.putInt(var1);
                           var8.packetBuffer.writeShortLE(var0);
                           Client.field867.method2021(var8);
                           Client.mouseCrosshair = 0;
                           class25.field349 = class35.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 40) {
                           var8 = class35.method501(ClientPacket.field2293, Client.field867.field1439);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.method3387(var1);
                           var8.packetBuffer.putShortLE(var3);
                           Client.field867.method2021(var8);
                           Client.mouseCrosshair = 0;
                           class25.field349 = class35.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 41) {
                           var8 = class35.method501(ClientPacket.field2300, Client.field867.field1439);
                           var8.packetBuffer.putShortLE(var0);
                           var8.packetBuffer.writeShortLE(var3);
                           var8.packetBuffer.method3387(var1);
                           Client.field867.method2021(var8);
                           Client.mouseCrosshair = 0;
                           class25.field349 = class35.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 42) {
                           var8 = class35.method501(ClientPacket.field2347, Client.field867.field1439);
                           var8.packetBuffer.writeShortLE(var3);
                           var8.packetBuffer.method3401(var1);
                           var8.packetBuffer.putShortLE(var0);
                           Client.field867.method2021(var8);
                           Client.mouseCrosshair = 0;
                           class25.field349 = class35.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 43) {
                           var8 = class35.method501(ClientPacket.field2348, Client.field867.field1439);
                           var8.packetBuffer.putShort(var0);
                           var8.packetBuffer.writeIntLE(var1);
                           var8.packetBuffer.writeIntLE16(var3);
                           Client.field867.method2021(var8);
                           Client.mouseCrosshair = 0;
                           class25.field349 = class35.getWidget(var1);
                           Client.pressedItemIndex = var0;
                        } else if(var2 == 44) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field871 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class35.method501(ClientPacket.field2363, Client.field867.field1439);
                              var9.packetBuffer.writeShortLE(var3);
                              var9.packetBuffer.method3430(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field867.method2021(var9);
                           }
                        } else if(var2 == 45) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field871 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class35.method501(ClientPacket.field2377, Client.field867.field1439);
                              var9.packetBuffer.method3430(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.writeIntLE16(var3);
                              Client.field867.method2021(var9);
                           }
                        } else if(var2 == 46) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field871 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class35.method501(ClientPacket.field2365, Client.field867.field1439);
                              var9.packetBuffer.writeShortLE(var3);
                              var9.packetBuffer.method3429(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field867.method2021(var9);
                           }
                        } else if(var2 == 47) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field871 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class35.method501(ClientPacket.field2288, Client.field867.field1439);
                              var9.packetBuffer.method3397(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field867.method2021(var9);
                           }
                        } else if(var2 == 48) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field871 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class35.method501(ClientPacket.field2313, Client.field867.field1439);
                              var9.packetBuffer.method3429(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.writeShortLE(var3);
                              Client.field867.method2021(var9);
                           }
                        } else if(var2 == 49) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field871 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class35.method501(ClientPacket.field2319, Client.field867.field1439);
                              var9.packetBuffer.writeIntLE16(var3);
                              var9.packetBuffer.method3397(KeyFocusListener.keyPressed[82]?1:0);
                              Client.field867.method2021(var9);
                           }
                        } else if(var2 == 50) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field871 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class35.method501(ClientPacket.field2332, Client.field867.field1439);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.writeIntLE16(var3);
                              Client.field867.method2021(var9);
                           }
                        } else if(var2 == 51) {
                           var19 = Client.cachedPlayers[var3];
                           if(var19 != null) {
                              Client.lastLeftClickX = var6;
                              Client.lastLeftClickY = var7;
                              Client.cursorState = 2;
                              Client.field871 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class35.method501(ClientPacket.field2331, Client.field867.field1439);
                              var9.packetBuffer.putByte(KeyFocusListener.keyPressed[82]?1:0);
                              var9.packetBuffer.putShort(var3);
                              Client.field867.method2021(var9);
                           }
                        } else {
                           label1040: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var21 = class31.getWidgetChild(var1, var0);
                                    if(var21 != null) {
                                       var9 = class35.method501(ClientPacket.field2346, Client.field867.field1439);
                                       var9.packetBuffer.writeShortLE(var21.itemId);
                                       var9.packetBuffer.putShort(var0);
                                       var9.packetBuffer.writeShortLE(Client.field964);
                                       var9.packetBuffer.putInt(var1);
                                       var9.packetBuffer.method3387(class35.field464);
                                       var9.packetBuffer.putShortLE(Client.field963);
                                       Client.field867.method2021(var9);
                                    }
                                    break label1040;
                                 }

                                 if(var2 == 1001) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field871 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var8 = class35.method501(ClientPacket.field2326, Client.field867.field1439);
                                    var8.packetBuffer.method3429(KeyFocusListener.keyPressed[82]?1:0);
                                    var8.packetBuffer.putShort(var3 >> 14 & 32767);
                                    var8.packetBuffer.writeShortLE(class85.baseY + var1);
                                    var8.packetBuffer.writeIntLE16(var0 + WorldMapType1.baseX);
                                    Client.field867.method2021(var8);
                                    break label1040;
                                 }

                                 if(var2 == 1002) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field871 = 0;
                                    var8 = class35.method501(ClientPacket.field2298, Client.field867.field1439);
                                    var8.packetBuffer.writeShortLE(var3 >> 14 & 32767);
                                    Client.field867.method2021(var8);
                                    break label1040;
                                 }

                                 if(var2 == 1003) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field871 = 0;
                                    var16 = Client.cachedNPCs[var3];
                                    if(var16 != null) {
                                       NPCComposition var22 = var16.composition;
                                       if(var22.configs != null) {
                                          var22 = var22.transform();
                                       }

                                       if(var22 != null) {
                                          var10 = class35.method501(ClientPacket.field2371, Client.field867.field1439);
                                          var10.packetBuffer.putShort(var22.id);
                                          Client.field867.method2021(var10);
                                       }
                                    }
                                    break label1040;
                                 }

                                 if(var2 == 1004) {
                                    Client.lastLeftClickX = var6;
                                    Client.lastLeftClickY = var7;
                                    Client.cursorState = 2;
                                    Client.field871 = 0;
                                    var8 = class35.method501(ClientPacket.field2295, Client.field867.field1439);
                                    var8.packetBuffer.writeIntLE16(var3);
                                    Client.field867.method2021(var8);
                                    break label1040;
                                 }

                                 if(var2 == 1005) {
                                    var21 = class35.getWidget(var1);
                                    if(var21 != null && var21.itemQuantities[var0] >= 100000) {
                                       class240.sendGameMessage(27, "", var21.itemQuantities[var0] + " x " + CombatInfo1.getItemDefinition(var3).name);
                                    } else {
                                       var9 = class35.method501(ClientPacket.field2295, Client.field867.field1439);
                                       var9.packetBuffer.writeIntLE16(var3);
                                       Client.field867.method2021(var9);
                                    }

                                    Client.mouseCrosshair = 0;
                                    class25.field349 = class35.getWidget(var1);
                                    Client.pressedItemIndex = var0;
                                    break label1040;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1009 || var2 == 1010 || var2 == 1008 || var2 == 1011 || var2 == 1012) {
                                       ScriptState.renderOverview.method5816(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label1040;
                                 }
                              }

                              var21 = class31.getWidgetChild(var1, var0);
                              if(var21 != null) {
                                 int var20 = var21.itemId;
                                 Widget var17 = class31.getWidgetChild(var1, var0);
                                 if(var17 != null) {
                                    if(var17.field2838 != null) {
                                       ScriptEvent var11 = new ScriptEvent();
                                       var11.widget = var17;
                                       var11.field750 = var3;
                                       var11.string = var5;
                                       var11.objs = var17.field2838;
                                       class87.method1851(var11);
                                    }

                                    boolean var14 = true;
                                    if(var17.contentType > 0) {
                                       var14 = TextureProvider.method2552(var17);
                                    }

                                    if(var14 && class21.method168(class60.getWidgetConfig(var17), var3 - 1)) {
                                       PacketNode var12;
                                       if(var3 == 1) {
                                          var12 = class35.method501(ClientPacket.field2328, Client.field867.field1439);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field867.method2021(var12);
                                       }

                                       if(var3 == 2) {
                                          var12 = class35.method501(ClientPacket.field2372, Client.field867.field1439);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field867.method2021(var12);
                                       }

                                       if(var3 == 3) {
                                          var12 = class35.method501(ClientPacket.field2305, Client.field867.field1439);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field867.method2021(var12);
                                       }

                                       if(var3 == 4) {
                                          var12 = class35.method501(ClientPacket.field2357, Client.field867.field1439);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field867.method2021(var12);
                                       }

                                       if(var3 == 5) {
                                          var12 = class35.method501(ClientPacket.field2373, Client.field867.field1439);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field867.method2021(var12);
                                       }

                                       if(var3 == 6) {
                                          var12 = class35.method501(ClientPacket.field2337, Client.field867.field1439);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field867.method2021(var12);
                                       }

                                       if(var3 == 7) {
                                          var12 = class35.method501(ClientPacket.field2364, Client.field867.field1439);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field867.method2021(var12);
                                       }

                                       if(var3 == 8) {
                                          var12 = class35.method501(ClientPacket.field2349, Client.field867.field1439);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field867.method2021(var12);
                                       }

                                       if(var3 == 9) {
                                          var12 = class35.method501(ClientPacket.field2368, Client.field867.field1439);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field867.method2021(var12);
                                       }

                                       if(var3 == 10) {
                                          var12 = class35.method501(ClientPacket.field2286, Client.field867.field1439);
                                          var12.packetBuffer.putInt(var1);
                                          var12.packetBuffer.putShort(var0);
                                          var12.packetBuffer.putShort(var20);
                                          Client.field867.method2021(var12);
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
      }

      if(Client.itemSelectionState != 0) {
         Client.itemSelectionState = 0;
         class60.method1015(class35.getWidget(class37.field476));
      }

      if(Client.spellSelected) {
         Projectile.method1916();
      }

      if(class25.field349 != null && Client.mouseCrosshair == 0) {
         class60.method1015(class25.field349);
      }

   }
}
