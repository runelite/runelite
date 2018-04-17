import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1089111841
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1707928357
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1476854373
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("m")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2092196691
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 992386861
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -8922499
   )
   int field842;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1198973017
   )
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1321459395
   )
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -208130841
   )
   int field845;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1476080363
   )
   int field858;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -773709705
   )
   int field843;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -189458759
   )
   int field849;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1957838521
   )
   int field850;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1942412513
   )
   int field851;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1195067477
   )
   int field852;
   @ObfuscatedName("j")
   @Export("isLowDetail")
   boolean isLowDetail;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1094800739
   )
   @Export("team")
   int team;
   @ObfuscatedName("g")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1953133113
   )
   int field856;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 727023787
   )
   @Export("playerId")
   int playerId;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   class303 field859;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   class303 field835;
   @ObfuscatedName("ab")
   boolean field860;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -427752025
   )
   int field861;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 721791895
   )
   int field837;

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
      this.field859 = class303.field3851;
      this.field835 = class303.field3851;
      this.field860 = false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "438364212"
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
               int var8 = class47.getItemDefinition(var4[var5] - 512).team;
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

      super.field1163 = var1.readUnsignedShort();
      if(super.field1163 == 65535) {
         super.field1163 = -1;
      }

      super.field1164 = super.field1163;
      super.field1165 = var1.readUnsignedShort();
      if(super.field1165 == 65535) {
         super.field1165 = -1;
      }

      super.field1209 = var1.readUnsignedShort();
      if(super.field1209 == 65535) {
         super.field1209 = -1;
      }

      super.field1167 = var1.readUnsignedShort();
      if(super.field1167 == 65535) {
         super.field1167 = -1;
      }

      super.field1177 = var1.readUnsignedShort();
      if(super.field1177 == 65535) {
         super.field1177 = -1;
      }

      super.field1169 = var1.readUnsignedShort();
      if(super.field1169 == 65535) {
         super.field1169 = -1;
      }

      this.name = new Name(var1.readString(), GZipDecompressor.loginType);
      this.method1188();
      this.method1191();
      if(this == SoundTaskDataProvider.localPlayer) {
         RunException.field2194 = this.name.getName();
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

      this.composition.method4396(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1140422871"
   )
   @Export("isFriend")
   boolean isFriend() {
      if(this.field859 == class303.field3851) {
         this.method1189();
      }

      return this.field859 == class303.field3850;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "42"
   )
   void method1188() {
      this.field859 = class303.field3851;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-362752571"
   )
   void method1189() {
      this.field859 = WorldMapRectangle.friendManager.method1776(this.name)?class303.field3850:class303.field3849;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   @Export("isClanMember")
   boolean isClanMember() {
      if(this.field835 == class303.field3851) {
         this.method1206();
      }

      return this.field835 == class303.field3850;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1078606170"
   )
   void method1191() {
      this.field835 = class303.field3851;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method1206() {
      this.field835 = GameEngine.clanMemberManager != null && GameEngine.clanMemberManager.isMember(this.name)?class303.field3850:class303.field3849;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "303410106"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class234.getNpcDefinition(this.composition.transformedNpcId).size:1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lei;",
      garbageValue = "1329079562"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?CombatInfo1.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.isLowDetail || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:CombatInfo1.getAnimation(super.poseAnimation);
         Model var3 = this.composition.getModel(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.logicalHeight = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.isLowDetail && super.graphic != -1 && super.spotAnimFrame != -1) {
               var4 = class86.getSpotAnimType(super.graphic).getModel(super.spotAnimFrame);
               if(var4 != null) {
                  var4.offsetBy(0, -super.field1198, 0);
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
                  var4.offsetBy(this.field845 - super.x, this.field858 - this.field842, this.field843 - super.y);
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

                  var4.offsetBy(super.x - this.field845, this.field842 - this.field858, super.y - this.field843);
               }
            }

            var3.field1874 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1215017913"
   )
   final void method1195(int var1, int var2, byte var3) {
      if(super.animation != -1 && CombatInfo1.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1185 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               BaseVarType.method9(this, var1, var2, (byte)2);
            }

            this.method1186(var1, var2, var3);
         } else {
            this.method1196(var1, var2);
         }
      } else {
         this.method1196(var1, var2);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1607372126"
   )
   void method1196(int var1, int var2) {
      super.queueSize = 0;
      super.field1216 = 0;
      super.field1158 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1393166690"
   )
   final void method1186(int var1, int var2, byte var3) {
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1204510929"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljf;Ljf;B)Z",
      garbageValue = "0"
   )
   public static boolean method1232(IndexDataBase var0, IndexDataBase var1) {
      Area.field3461 = var1;
      if(!var0.method4624()) {
         return false;
      } else {
         class155.field2162 = var0.fileCount(35);
         Area.mapAreaType = new Area[class155.field2162];

         for(int var2 = 0; var2 < class155.field2162; ++var2) {
            byte[] var3 = var0.getConfigData(35, var2);
            if(var3 != null) {
               Area.mapAreaType[var2] = new Area(var2);
               Area.mapAreaType[var2].method4757(new Buffer(var3));
               Area.mapAreaType[var2].method4744();
            }
         }

         return true;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljf;Ljf;ZII)V",
      garbageValue = "1897469647"
   )
   static void method1230(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class90.field1387) {
         if(var3 == 4) {
            class90.loginIndex = 4;
         }

      } else {
         class90.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.takeRecordByNames("title.jpg", "");
         class321.field3938 = class185.method3448(var4);
         class90.field1381 = class321.field3938.method5847();
         if((Client.flags & 536870912) != 0) {
            class33.logoSprite = FriendManager.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class33.logoSprite = FriendManager.getSprite(var1, "logo", "");
         }

         IndexStoreActionHandler.field3398 = FriendManager.getSprite(var1, "titlebox", "");
         class90.field1388 = FriendManager.getSprite(var1, "titlebutton", "");
         class90.runeSprites = WorldMapManager.getIndexedSprites(var1, "runes", "");
         class57.titlemuteSprite = WorldMapManager.getIndexedSprites(var1, "title_mute", "");
         class90.field1363 = FriendManager.getSprite(var1, "options_radio_buttons,0", "");
         Frames.field2074 = FriendManager.getSprite(var1, "options_radio_buttons,4", "");
         class90.field1393 = FriendManager.getSprite(var1, "options_radio_buttons,2", "");
         class246.field2979 = FriendManager.getSprite(var1, "options_radio_buttons,6", "");
         NPC.field1318 = class90.field1363.width;
         class203.field2616 = class90.field1363.height;
         class21.field347 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            class21.field347[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class21.field347[var5 + 64] = var5 * 1024 + 16711680;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class21.field347[var5 + 128] = var5 * 4 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class21.field347[var5 + 192] = 16777215;
         }

         ScriptState.field762 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            ScriptState.field762[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ScriptState.field762[var5 + 64] = var5 * 4 + 65280;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ScriptState.field762[var5 + 128] = var5 * 262144 + 65535;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            ScriptState.field762[var5 + 192] = 16777215;
         }

         GrandExchangeEvent.field298 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            GrandExchangeEvent.field298[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            GrandExchangeEvent.field298[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            GrandExchangeEvent.field298[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            GrandExchangeEvent.field298[var5 + 192] = 16777215;
         }

         class21.field344 = new int[256];
         MouseRecorder.field819 = new int['耀'];
         GrandExchangeEvents.field287 = new int['耀'];
         class44.method663((IndexedSprite)null);
         Huffman.field2513 = new int['耀'];
         AbstractSoundSystem.field1585 = new int['耀'];
         if(var2) {
            class90.username = "";
            class90.password = "";
         }

         Size.field369 = 0;
         class37.field501 = "";
         class90.field1385 = true;
         class90.worldSelectShown = false;
         if(!Client.preferences.muted) {
            IndexData var8 = PacketBuffer.indexTrack1;
            int var6 = var8.getFile("scape main");
            int var7 = var8.getChild(var6, "");
            class163.method3213(2, var8, var6, var7, 255, false);
         } else {
            class229.field2687 = 1;
            class185.field2511 = null;
            VertexNormal.field1931 = -1;
            GrandExchangeEvents.field284 = -1;
            class86.field1330 = 0;
            class229.field2692 = false;
            class2.field11 = 2;
         }

         GraphicsObject.sendConInfo(false);
         class90.field1387 = true;
         class90.field1359 = (MapLabel.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1359 + 202;
         WorldComparator.field279 = class90.loginWindowX + 180;
         class321.field3938.method5856(class90.field1359, 0);
         class90.field1381.method5856(class90.field1359 + 382, 0);
         class33.logoSprite.method5825(class90.field1359 + 382 - class33.logoSprite.width / 2, 18);
      }
   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "640267046"
   )
   static final void method1231(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         Client.preferences.hideRoofs = !Client.preferences.hideRoofs;
         MouseInput.method1062();
         if(Client.preferences.hideRoofs) {
            class57.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            class57.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if(var0.equalsIgnoreCase("renderself")) {
         Client.field988 = !Client.field988;
      }

      if(var0.equalsIgnoreCase("mouseovertext")) {
         Client.field1017 = !Client.field1017;
      }

      if(Client.rights >= 2) {
         if(var0.equalsIgnoreCase("aabb")) {
            if(!class7.drawBoundingBoxes3D) {
               class7.drawBoundingBoxes3D = true;
               class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ALWAYS;
            } else if(BoundingBox3DDrawMode.ALWAYS == class7.boundingBox3DDrawMode) {
               class7.drawBoundingBoxes3D = true;
               class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
            } else {
               class7.drawBoundingBoxes3D = false;
            }
         }

         if(var0.equalsIgnoreCase("showcoord")) {
            Preferences.renderOverview.field4016 = !Preferences.renderOverview.field4016;
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            if(Client.field915 > 0) {
               VarPlayerType.method4736();
            } else {
               Client.field918.method5211();
               class64.setGameState(40);
               FaceNormal.field2069 = Client.field957.getSocket();
               Client.field957.method2043();
            }
         }

         if(var0.equalsIgnoreCase("cs")) {
            class57.sendGameMessage(99, "", "" + Client.field917);
         }

         if(var0.equalsIgnoreCase("errortest") && Client.socketType == 2) {
            throw new RuntimeException();
         }
      }

      PacketNode var1 = WorldMapRectangle.method280(ClientPacket.field2415, Client.field957.field1484);
      var1.packetBuffer.putByte(var0.length() + 1);
      var1.packetBuffer.putString(var0);
      Client.field957.method2052(var1);
   }
}
