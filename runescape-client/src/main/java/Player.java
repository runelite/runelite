import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("v")
   @Export("model")
   Model model;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1559075545
   )
   @Export("skullIcon")
   int skullIcon = -1;
   @ObfuscatedName("iy")
   static Widget field241;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -997536029
   )
   @Export("overheadIcon")
   int overheadIcon = -1;
   @ObfuscatedName("u")
   @Export("name")
   String name;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1012964385
   )
   int field244;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 650872321
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("y")
   boolean field246;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1789349091
   )
   int field247;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -425246955
   )
   int field248;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1829083225
   )
   int field249;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1405427633
   )
   int field250;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 597887903
   )
   int field251;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 294852483
   )
   int field252;
   @ObfuscatedName("eu")
   static SpritePixels[] field253;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 757475627
   )
   int field254;
   @ObfuscatedName("x")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1838860719
   )
   int field256;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 657684931
   )
   int field257;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1484907429
   )
   int field258;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1796382821
   )
   @Export("team")
   int team;
   @ObfuscatedName("s")
   boolean field260;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 176823247
   )
   int field261;
   @ObfuscatedName("o")
   boolean field263;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 532159427
   )
   int field264;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 857461323
   )
   int field265;
   @ObfuscatedName("c")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 450647329
   )
   @Export("totalLevel")
   int totalLevel;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "609735721"
   )
   final void method214(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.readUnsignedByte();
      this.skullIcon = var1.readByte();
      this.overheadIcon = var1.readByte();
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
            if(var7 == 0 && var4[0] == '\uffff') {
               var3 = var1.readUnsignedShort();
               break;
            }

            if(var4[var7] >= 512) {
               int var8 = class88.getItemDefinition(var4[var7] - 512).team;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var5 = 0; var5 < 5; ++var5) {
         var6 = var1.readUnsignedByte();
         if(var6 < 0 || var6 >= class227.field3229[var5].length) {
            var6 = 0;
         }

         var9[var5] = var6;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field605 = var1.readUnsignedShort();
      if(super.field605 == '\uffff') {
         super.field605 = -1;
      }

      super.field626 = super.field605;
      super.field607 = var1.readUnsignedShort();
      if(super.field607 == '\uffff') {
         super.field607 = -1;
      }

      super.field608 = var1.readUnsignedShort();
      if(super.field608 == '\uffff') {
         super.field608 = -1;
      }

      super.field639 = var1.readUnsignedShort();
      if(super.field639 == '\uffff') {
         super.field639 = -1;
      }

      super.field614 = var1.readUnsignedShort();
      if(super.field614 == '\uffff') {
         super.field614 = -1;
      }

      super.field622 = var1.readUnsignedShort();
      if(super.field622 == '\uffff') {
         super.field622 = -1;
      }

      this.name = var1.method2965();
      if(this == class148.localPlayer) {
         class157.field2106 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field248 = var1.readUnsignedShort();
      this.field260 = var1.readUnsignedByte() == 1;
      if(Client.field416 == 0 && Client.field352 >= 2) {
         this.field260 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3119(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "187949745"
   )
   int method215() {
      return null != this.composition && this.composition.field2151 != -1?Actor.getNpcDefinition(this.composition.field2151).field3007:1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "25"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?CombatInfo2.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field246 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:CombatInfo2.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3152(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1532();
            super.field649 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field246 && super.graphic != -1 && super.field634 != -1) {
               var4 = class185.method3389(super.graphic).method3446(super.field634);
               if(var4 != null) {
                  var4.method1550(0, -super.field640, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field246 && null != this.model) {
               if(Client.gameCycle >= this.field249) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field249) {
                  var4 = this.model;
                  var4.method1550(this.field250 - super.x, this.field251 - this.field247, this.field252 - super.y);
                  if(super.field650 == 512) {
                     var4.method1525();
                     var4.method1525();
                     var4.method1525();
                  } else if(super.field650 == 1024) {
                     var4.method1525();
                     var4.method1525();
                  } else if(super.field650 == 1536) {
                     var4.method1525();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field650 == 512) {
                     var4.method1525();
                  } else if(super.field650 == 1024) {
                     var4.method1525();
                     var4.method1525();
                  } else if(super.field650 == 1536) {
                     var4.method1525();
                     var4.method1525();
                     var4.method1525();
                  }

                  var4.method1550(super.x - this.field250, this.field247 - this.field251, super.y - this.field252);
               }
            }

            var3.field1381 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1591857589"
   )
   final void method217(int var1, int var2, byte var3) {
      if(super.animation != -1 && CombatInfo2.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field627 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class13.method170(this, var1, var2, (byte)2);
            }

            this.method219(var1, var2, var3);
         } else {
            this.method218(var1, var2);
         }
      } else {
         this.method218(var1, var2);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "105"
   )
   void method218(int var1, int var2) {
      super.field653 = 0;
      super.field658 = 0;
      super.field657 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method215();
      super.x = 64 * var3 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + 64 * var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1836459184"
   )
   final void method219(int var1, int var2, byte var3) {
      if(super.field653 < 9) {
         ++super.field653;
      }

      for(int var4 = super.field653; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field656[var4] = super.field656[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field656[0] = var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1734693659"
   )
   final boolean vmethod718() {
      return null != this.composition;
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field248 = 0;
      this.totalLevel = 0;
      this.field249 = 0;
      this.field246 = false;
      this.team = 0;
      this.field260 = false;
      this.field263 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "600116740"
   )
   public static boolean method238(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
