import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 2143008653
   )
   static int field843;
   @ObfuscatedName("gs")
   @ObfuscatedGetter(
      intValue = 852964421
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("m")
   @Export("name")
   String name;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1358378245
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -411951877
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("x")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1406522037
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1605978015
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 515353659
   )
   int field831;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1444504367
   )
   int field839;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -298905793
   )
   int field840;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -131457099
   )
   int field846;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1338968151
   )
   int field841;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1533192227
   )
   int field838;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Len;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1200588905
   )
   int field845;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -261551067
   )
   int field836;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -775702345
   )
   int field847;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1762635753
   )
   int field848;
   @ObfuscatedName("g")
   boolean field849;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -896228855
   )
   @Export("team")
   int team;
   @ObfuscatedName("o")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 160989811
   )
   int field852;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1109812629
   )
   int field853;
   @ObfuscatedName("f")
   boolean field854;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 638140851
   )
   int field855;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -632007735
   )
   int field858;

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
      this.field840 = 0;
      this.field849 = false;
      this.team = 0;
      this.hidden = false;
      this.field854 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "-494290405"
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
               int var8 = class250.getItemDefinition(var4[var5] - 512).field3588;
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

      super.field1149 = var1.readUnsignedShort();
      if(super.field1149 == 65535) {
         super.field1149 = -1;
      }

      super.field1150 = super.field1149;
      super.field1151 = var1.readUnsignedShort();
      if(super.field1151 == 65535) {
         super.field1151 = -1;
      }

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

      this.name = var1.readString();
      if(this == class48.localPlayer) {
         class153.field2136 = this.name;
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

      this.composition.method4110(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "51"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class94.getNpcDefinition(this.composition.transformedNpcId).field3625:1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Len;",
      garbageValue = "-1864051962"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?ItemLayer.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field849 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?ItemLayer.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method4114(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2616();
            super.field1161 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field849 && super.graphic != -1 && super.field1181 != -1) {
               var4 = class285.getSpotAnimType(super.graphic).method4520(super.field1181);
               if(var4 != null) {
                  var4.method2643(0, -super.field1184, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field849 && this.model != null) {
               if(Client.gameCycle >= this.field840) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field839 && Client.gameCycle < this.field840) {
                  var4 = this.model;
                  var4.method2643(this.field846 - super.x, this.field841 - this.field831, this.field838 - super.y);
                  if(super.orientation == 512) {
                     var4.method2677();
                     var4.method2677();
                     var4.method2677();
                  } else if(super.orientation == 1024) {
                     var4.method2677();
                     var4.method2677();
                  } else if(super.orientation == 1536) {
                     var4.method2677();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2677();
                  } else if(super.orientation == 1024) {
                     var4.method2677();
                     var4.method2677();
                  } else if(super.orientation == 1536) {
                     var4.method2677();
                     var4.method2677();
                     var4.method2677();
                  }

                  var4.method2643(super.x - this.field846, this.field831 - this.field841, super.y - this.field838);
               }
            }

            var3.field1860 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1830723155"
   )
   final void method1190(int var1, int var2, byte var3) {
      if(super.animation != -1 && ItemLayer.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1202 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.getSize();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var10 = this.getSize();
                  Client.field960.field2214 = var1;
                  Client.field960.field2215 = var2;
                  Client.field960.field2217 = 1;
                  Client.field960.field2216 = 1;
                  class72 var11 = Client.field960;
                  int var12 = class12.method76(var5, var6, var10, var11, Client.collisionMaps[this.field852], true, Client.field1129, Client.field1086);
                  if(var12 >= 1) {
                     for(int var13 = 0; var13 < var12 - 1; ++var13) {
                        var4.method1193(Client.field1129[var13], Client.field1086[var13], (byte)2);
                     }
                  }
               }
            }

            this.method1193(var1, var2, var3);
         } else {
            this.method1191(var1, var2);
         }
      } else {
         this.method1191(var1, var2);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "255"
   )
   void method1191(int var1, int var2) {
      super.queueSize = 0;
      super.field1186 = 0;
      super.field1157 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1176362940"
   )
   final void method1193(int var1, int var2, byte var3) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "762696752"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-10568"
   )
   static void method1208() {
      if(Client.spellSelected) {
         Widget var0 = class189.method3613(class11.field267, Client.field1005);
         if(var0 != null && var0.field2818 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.field791 = var0.field2818;
            class111.method2177(var1);
         }

         Client.spellSelected = false;
         WorldMapData.method394(var0);
      }
   }
}
