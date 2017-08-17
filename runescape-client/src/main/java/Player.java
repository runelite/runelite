import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("fp")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -134663571
   )
   static int field915;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 706812663
   )
   @Export("skullIcon")
   int skullIcon;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 220250273
   )
   @Export("overheadIcon")
   int overheadIcon;
   @ObfuscatedName("y")
   boolean field913;
   @ObfuscatedName("g")
   @Export("actions")
   String[] actions;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2147009155
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 152856531
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 320817117
   )
   @Export("team")
   int team;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1727873109
   )
   int field905;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 249163581
   )
   int field906;
   @ObfuscatedName("u")
   @Export("hidden")
   boolean hidden;
   @ObfuscatedName("n")
   boolean field903;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Leo;"
   )
   @Export("model")
   Model model;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2044174403
   )
   int field907;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 390156653
   )
   int field908;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1785441983
   )
   int field904;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1546746485
   )
   int field911;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 604639785
   )
   int field918;
   @ObfuscatedName("j")
   @Export("name")
   String name;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1895126289
   )
   int field896;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1072906727
   )
   int field901;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1196420907
   )
   int field920;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1277455755
   )
   int field919;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 892455115
   )
   int field923;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 462251911
   )
   int field921;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 429371385
   )
   int field922;

   Player() {
      this.skullIcon = -1;
      this.overheadIcon = -1;
      this.actions = new String[3];

      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.totalLevel = 0;
      this.field905 = 0;
      this.field906 = 0;
      this.field913 = false;
      this.team = 0;
      this.hidden = false;
      this.field903 = false;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Leo;",
      garbageValue = "1214595416"
   )
   @Export("getModel")
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?PendingSpawn.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field913 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?PendingSpawn.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3970(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2528();
            super.field1231 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field913 && super.graphic != -1 && super.field1256 != -1) {
               var4 = class36.getSpotAnimType(super.graphic).method4367(super.field1256);
               if(var4 != null) {
                  var4.method2538(0, -super.field1259, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field913 && this.model != null) {
               if(Client.gameCycle >= this.field906) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.field905 && Client.gameCycle < this.field906) {
                  var4 = this.model;
                  var4.method2538(this.field907 - super.x, this.field908 - this.field904, this.field911 - super.y);
                  if(super.orientation == 512) {
                     var4.method2535();
                     var4.method2535();
                     var4.method2535();
                  } else if(super.orientation == 1024) {
                     var4.method2535();
                     var4.method2535();
                  } else if(super.orientation == 1536) {
                     var4.method2535();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.orientation == 512) {
                     var4.method2535();
                  } else if(super.orientation == 1024) {
                     var4.method2535();
                     var4.method2535();
                  } else if(super.orientation == 1536) {
                     var4.method2535();
                     var4.method2535();
                     var4.method2535();
                  }

                  var4.method2538(super.x - this.field907, this.field904 - this.field908, super.y - this.field911);
               }
            }

            var3.field1990 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-555915849"
   )
   void method1190(int var1, int var2) {
      super.queueSize = 0;
      super.field1277 = 0;
      super.field1276 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.getSize();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "40261698"
   )
   @Export("getSize")
   int getSize() {
      return this.composition != null && this.composition.transformedNpcId != -1?class183.getNpcDefinition(this.composition.transformedNpcId).field3543:1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "874291225"
   )
   final void method1191(int var1, int var2, byte var3) {
      if(super.queueSize < 9) {
         ++super.queueSize;
      }

      for(int var4 = super.queueSize; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field1251[var4] = super.field1251[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field1251[0] = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1465758862"
   )
   @Export("hasConfig")
   final boolean hasConfig() {
      return this.composition != null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "867200934"
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
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = SoundTask.getItemDefinition(var4[var5] - 512).field3524;
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
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field1241 = var1.readUnsignedShort();
      if(super.field1241 == '\uffff') {
         super.field1241 = -1;
      }

      super.field1225 = super.field1241;
      super.field1226 = var1.readUnsignedShort();
      if(super.field1226 == '\uffff') {
         super.field1226 = -1;
      }

      super.field1218 = var1.readUnsignedShort();
      if(super.field1218 == '\uffff') {
         super.field1218 = -1;
      }

      super.field1228 = var1.readUnsignedShort();
      if(super.field1228 == '\uffff') {
         super.field1228 = -1;
      }

      super.field1229 = var1.readUnsignedShort();
      if(super.field1229 == '\uffff') {
         super.field1229 = -1;
      }

      super.field1222 = var1.readUnsignedShort();
      if(super.field1222 == '\uffff') {
         super.field1222 = -1;
      }

      this.name = var1.readString();
      if(this == XGrandExchangeOffer.localPlayer) {
         class153.field2216 = this.name;
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

      this.composition.method3990(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-47"
   )
   final void method1189(int var1, int var2, byte var3) {
      if(super.animation != -1 && PendingSpawn.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field1246 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class74.method1182(this, var1, var2, (byte)2);
            }

            this.method1191(var1, var2, var3);
         } else {
            this.method1190(var1, var2);
         }
      } else {
         this.method1190(var1, var2);
      }

   }
}
