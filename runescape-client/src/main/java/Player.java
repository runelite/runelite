import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1752184601
   )
   int field239;
   @ObfuscatedName("l")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 923843459
   )
   @Export("skullIcon")
   int skullIcon = -1;
   @ObfuscatedName("d")
   boolean field242;
   @ObfuscatedName("h")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 919050775
   )
   int field244;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -541306031
   )
   int field245;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1547331075
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 462205133
   )
   int field247;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1844717005
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1389350391
   )
   int field249;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1839202901
   )
   int field250;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -842213987
   )
   int field251;
   @ObfuscatedName("o")
   @Export("model")
   Model model;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1178351891
   )
   int field253;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2058995213
   )
   int field254;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 408417763
   )
   int field255;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 144816417
   )
   @Export("overheadIcon")
   int overheadIcon = -1;
   @ObfuscatedName("q")
   boolean field257;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -3735709
   )
   @Export("team")
   int team;
   @ObfuscatedName("v")
   boolean field259;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1900835135
   )
   int field260;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1859515099
   )
   int field261;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1082331637
   )
   int field262;
   @ObfuscatedName("b")
   @Export("name")
   String name;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1490470199
   )
   int field264;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 1559378981
   )
   static int field265;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-8"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?XClanMember.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field257 || super.poseAnimation == super.idlePoseAnimation && null != var1?null:XClanMember.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3236(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1684();
            super.field609 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field257 && super.graphic != -1 && super.field639 != -1) {
               var4 = class160.method3154(super.graphic).method3539(super.field639);
               if(var4 != null) {
                  var4.method1624(0, -super.field642, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field257 && null != this.model) {
               if(Client.gameCycle >= this.field239) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field239) {
                  var4 = this.model;
                  var4.method1624(this.field249 - super.x, this.field247 - this.field262, this.field251 - super.y);
                  if(super.field652 == 512) {
                     var4.method1655();
                     var4.method1655();
                     var4.method1655();
                  } else if(super.field652 == 1024) {
                     var4.method1655();
                     var4.method1655();
                  } else if(super.field652 == 1536) {
                     var4.method1655();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field652 == 512) {
                     var4.method1655();
                  } else if(super.field652 == 1024) {
                     var4.method1655();
                     var4.method1655();
                  } else if(super.field652 == 1536) {
                     var4.method1655();
                     var4.method1655();
                     var4.method1655();
                  }

                  var4.method1624(super.x - this.field249, this.field262 - this.field247, super.y - this.field251);
               }
            }

            var3.field1360 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1690084804"
   )
   final void method227(Buffer var1) {
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
            var4[var5] = (var6 << 8) + var7;
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class168.getItemDefinition(var4[var5] - 512).field2976;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= Friend.field151[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field607 = var1.readUnsignedShort();
      if(super.field607 == '\uffff') {
         super.field607 = -1;
      }

      super.field608 = super.field607;
      super.field627 = var1.readUnsignedShort();
      if(super.field627 == '\uffff') {
         super.field627 = -1;
      }

      super.field624 = var1.readUnsignedShort();
      if(super.field624 == '\uffff') {
         super.field624 = -1;
      }

      super.field611 = var1.readUnsignedShort();
      if(super.field611 == '\uffff') {
         super.field611 = -1;
      }

      super.field612 = var1.readUnsignedShort();
      if(super.field612 == '\uffff') {
         super.field612 = -1;
      }

      super.field613 = var1.readUnsignedShort();
      if(super.field613 == '\uffff') {
         super.field613 = -1;
      }

      this.name = var1.readString();
      if(class9.localPlayer == this) {
         class101.field1649 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field245 = var1.readUnsignedShort();
      this.field259 = var1.readUnsignedByte() == 1;
      if(Client.field295 == 0 && Client.field370 >= 2) {
         this.field259 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3223(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "900055086"
   )
   static final void method228(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle + Client.mapScale & 2047;
         int var8 = class84.field1435[var7];
         int var9 = class84.field1432[var7];
         var8 = var8 * 256 / (256 + Client.mapScaleDelta);
         var9 = 256 * var9 / (256 + Client.mapScaleDelta);
         int var10 = var8 * var3 + var2 * var9 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class16.field171.method4266(var14 + 94 + var0 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         FrameMap.method1754(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-274573938"
   )
   final boolean vmethod795() {
      return null != this.composition;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1518488496"
   )
   void method230(int var1, int var2) {
      super.field655 = 0;
      super.field660 = 0;
      super.field601 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method246();
      super.x = 64 * var3 + 128 * super.pathX[0];
      super.y = var3 * 64 + 128 * super.pathY[0];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1984554844"
   )
   final void method238(int var1, int var2, byte var3) {
      if(super.field655 < 9) {
         ++super.field655;
      }

      for(int var4 = super.field655; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field658[var4] = super.field658[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field658[0] = var3;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-5"
   )
   static final void method245() {
      for(Projectile var0 = (Projectile)Client.projectiles.method2472(); null != var0; var0 = (Projectile)Client.projectiles.method2479()) {
         if(class156.plane == var0.floor && Client.gameCycle <= var0.field861) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(null != var1 && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method858(var1.x, var1.y, class65.method1224(var1.x, var1.y, var0.floor) - var0.field859, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = class9.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method858(var3.x, var3.y, class65.method1224(var3.x, var3.y, var0.floor) - var0.field859, Client.gameCycle);
                  }
               }

               var0.method859(Client.field477);
               Varbit.region.method1838(class156.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.field860, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2095433429"
   )
   int method246() {
      return this.composition != null && this.composition.field2163 != -1?ChatLineBuffer.getNpcDefinition(this.composition.field2163).field3012:1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "813936456"
   )
   final void method253(int var1, int var2, byte var3) {
      if(super.animation != -1 && XClanMember.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field610 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               WidgetNode.method203(this, var1, var2, (byte)2);
            }

            this.method238(var1, var2, var3);
         } else {
            this.method230(var1, var2);
         }
      } else {
         this.method230(var1, var2);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)LSpritePixels;",
      garbageValue = "16537"
   )
   static SpritePixels method254() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class225.field3228;
      var0.maxHeight = class225.field3227;
      var0.offsetX = class225.field3229[0];
      var0.offsetY = class155.field2105[0];
      var0.width = class172.field2351[0];
      var0.height = class225.field3230[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = class225.field3232[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class225.field3231[var2[var3] & 255];
      }

      class0.method13();
      return var0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "715948419"
   )
   static int method255(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2086[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field245 = 0;
      this.totalLevel = 0;
      this.field239 = 0;
      this.field257 = false;
      this.team = 0;
      this.field259 = false;
      this.field242 = false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-96"
   )
   public static boolean method256(int var0) {
      return (var0 >> 28 & 1) != 0;
   }
}
