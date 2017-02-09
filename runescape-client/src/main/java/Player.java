import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1594483105
   )
   int field242;
   @ObfuscatedName("y")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1393241149
   )
   @Export("skullIcon")
   int skullIcon = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1527824393
   )
   @Export("overheadIcon")
   int overheadIcon = -1;
   @ObfuscatedName("j")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("a")
   @Export("model")
   Model model;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -16417397
   )
   int field248;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 695156025
   )
   int field249;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2131892555
   )
   int field250;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1159746491
   )
   int field251;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1461935661
   )
   int field252;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1801906555
   )
   int field253;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 534048957
   )
   int field254;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -947220275
   )
   int field255;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -991271649
   )
   int field256;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2009446491
   )
   @Export("team")
   int team;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 317170047
   )
   int field258;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 245621257
   )
   int field259;
   @ObfuscatedName("z")
   boolean field260;
   @ObfuscatedName("k")
   @Export("name")
   String name;
   @ObfuscatedName("b")
   boolean field262;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1538711145
   )
   int field263;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -529990323
   )
   int field264;
   @ObfuscatedName("l")
   boolean field265;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 780783815
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2056751639
   )
   @Export("totalLevel")
   int totalLevel;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1574264695"
   )
   final void method235(Buffer var1) {
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
               int var8 = PlayerComposition.getItemDefinition(var4[var5] - 512).team;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class101.field1661[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field596 = var1.readUnsignedShort();
      if(super.field596 == '\uffff') {
         super.field596 = -1;
      }

      super.field642 = super.field596;
      super.field598 = var1.readUnsignedShort();
      if(super.field598 == '\uffff') {
         super.field598 = -1;
      }

      super.field599 = var1.readUnsignedShort();
      if(super.field599 == '\uffff') {
         super.field599 = -1;
      }

      super.field600 = var1.readUnsignedShort();
      if(super.field600 == '\uffff') {
         super.field600 = -1;
      }

      super.field601 = var1.readUnsignedShort();
      if(super.field601 == '\uffff') {
         super.field601 = -1;
      }

      super.field602 = var1.readUnsignedShort();
      if(super.field602 == '\uffff') {
         super.field602 = -1;
      }

      this.name = var1.method2934();
      if(VertexNormal.localPlayer == this) {
         class101.field1658 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field248 = var1.readUnsignedShort();
      this.field262 = var1.readUnsignedByte() == 1;
      if(Client.field281 == 0 && Client.field396 >= 2) {
         this.field262 = false;
      }

      if(null == this.composition) {
         this.composition = new PlayerComposition();
      }

      this.composition.method2733(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2027830952"
   )
   int method236() {
      return this.composition != null && this.composition.field2014 != -1?class45.getNpcDefinition(this.composition.field2014).field2987:1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1593777981"
   )
   final void method240(int var1, int var2, byte var3) {
      if(super.field644 < 9) {
         ++super.field644;
      }

      for(int var4 = super.field644; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field594[var4] = super.field594[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field594[0] = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1115393607"
   )
   final boolean vmethod736() {
      return null != this.composition;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "165775542"
   )
   final void method243(int var1, int var2, byte var3) {
      if(super.animation != -1 && TextureProvider.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field635 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class49.method902(this, var1, var2, (byte)2);
            }

            this.method240(var1, var2, var3);
         } else {
            this.method250(var1, var2);
         }
      } else {
         this.method250(var1, var2);
      }

   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field248 = 0;
      this.totalLevel = 0;
      this.field251 = 0;
      this.field260 = false;
      this.team = 0;
      this.field262 = false;
      this.field265 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-23"
   )
   void method250(int var1, int var2) {
      super.field644 = 0;
      super.field645 = 0;
      super.field638 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method236();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = super.pathY[0] * 128 + 64 * var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "637530507"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?TextureProvider.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field260 && (super.poseAnimation != super.idlePoseAnimation || var1 == null)?TextureProvider.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method2739(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1568();
            super.field592 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field260 && super.graphic != -1 && super.field647 != -1) {
               var4 = XItemContainer.method187(super.graphic).method3458(super.field647);
               if(var4 != null) {
                  var4.method1578(0, -super.field631, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field260 && null != this.model) {
               if(Client.gameCycle >= this.field251) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field251) {
                  var4 = this.model;
                  var4.method1578(this.field252 - super.x, this.field255 - this.field249, this.field258 - super.y);
                  if(super.field641 == 512) {
                     var4.method1574();
                     var4.method1574();
                     var4.method1574();
                  } else if(super.field641 == 1024) {
                     var4.method1574();
                     var4.method1574();
                  } else if(super.field641 == 1536) {
                     var4.method1574();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field641 == 512) {
                     var4.method1574();
                  } else if(super.field641 == 1024) {
                     var4.method1574();
                     var4.method1574();
                  } else if(super.field641 == 1536) {
                     var4.method1574();
                     var4.method1574();
                     var4.method1574();
                  }

                  var4.method1578(super.x - this.field252, this.field249 - this.field255, super.y - this.field258);
               }
            }

            var3.field1378 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2019864231"
   )
   static void method260(int var0, int var1) {
      Client.field321.method3195(136);
      Client.field321.method2970(var0);
      Client.field321.method3094(var1);
   }
}
