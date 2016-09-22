import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -599783029
   )
   int field31;
   @ObfuscatedName("d")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1310155425
   )
   int field33;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1875264367
   )
   int field34 = -1;
   @ObfuscatedName("t")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("q")
   @Export("model")
   Model model;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1711540217
   )
   int field38;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1119257835
   )
   int field39;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -105651753
   )
   int field40;
   @ObfuscatedName("e")
   boolean field41;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1712253065
   )
   int field42;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -501405879
   )
   int field43;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -635740729
   )
   int field44;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -212854929
   )
   int field45;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1959380753
   )
   int field46 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 157892337
   )
   int field47;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 297425915
   )
   int field48;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1006694069
   )
   int field49;
   @ObfuscatedName("y")
   boolean field50;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -940713993
   )
   @Export("team")
   int team;
   @ObfuscatedName("a")
   @Export("name")
   String name;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -474009457
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -677863683
   )
   int field54;
   @ObfuscatedName("c")
   boolean field55;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1240326173
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1388143121
   )
   int field57;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "1096058396"
   )
   static final void method13(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class1.field20.length; ++var2) {
         class1.field20[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class1.field20[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class129.field2119[var5] = (class1.field20[var5 - 128] + class1.field20[1 + var5] + class1.field20[var5 - 1] + class1.field20[var5 + 128]) / 4;
            }
         }

         int[] var8 = class1.field20;
         class1.field20 = class129.field2119;
         class129.field2119 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = 16 + var4 + var0.offsetX;
                  int var6 = 16 + var3 + var0.offsetY;
                  int var7 = (var6 << 7) + var5;
                  class1.field20[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1451019144"
   )
   final void method14(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.method2528();
      this.field34 = var1.method2529();
      this.field46 = var1.method2529();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2528();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2528();
            var4[var5] = (var6 << 8) + var7;
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2717();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = MessageNode.getItemDefinition(var4[var5] - 512).field1223;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2528();
         if(var7 < 0 || var7 >= PlayerComposition.field2975[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.method2717();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field849 = var1.method2717();
      if(super.field849 == '\uffff') {
         super.field849 = -1;
      }

      super.field890 = super.field849;
      super.field847 = var1.method2717();
      if(super.field847 == '\uffff') {
         super.field847 = -1;
      }

      super.field887 = var1.method2717();
      if(super.field887 == '\uffff') {
         super.field887 = -1;
      }

      super.field863 = var1.method2717();
      if(super.field863 == '\uffff') {
         super.field863 = -1;
      }

      super.field850 = var1.method2717();
      if(super.field850 == '\uffff') {
         super.field850 = -1;
      }

      super.field851 = var1.method2717();
      if(super.field851 == '\uffff') {
         super.field851 = -1;
      }

      this.name = var1.method2530();
      if(WidgetNode.localPlayer == this) {
         class151.field2290 = this.name;
      }

      this.combatLevel = var1.method2528();
      this.field38 = var1.method2717();
      this.field41 = var1.method2528() == 1;
      if(Client.field281 == 0 && Client.field351 >= 2) {
         this.field41 = false;
      }

      if(null == this.composition) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3521(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "766557059"
   )
   int method15() {
      return null != this.composition && this.composition.field2978 != -1?ObjectComposition.getNpcDefinition(this.composition.field2978).field915:1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "506388399"
   )
   final boolean vmethod785() {
      return this.composition != null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-12"
   )
   final void method19(int var1, int var2, byte var3) {
      if(super.field893 < 9) {
         ++super.field893;
      }

      for(int var4 = super.field893; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field896[var4] = super.field896[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field896[0] = var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "942476835"
   )
   void method20(int var1, int var2) {
      super.field893 = 0;
      super.field898 = 0;
      super.field897 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method15();
      super.x = super.pathX[0] * 128 + 64 * var3;
      super.y = 128 * super.pathY[0] + 64 * var3;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)I",
      garbageValue = "1"
   )
   static final int method22(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class94.field1676[1024 * var2 / var3] >> 1;
      return (var1 * var4 >> 16) + (var0 * (65536 - var4) >> 16);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-417922438"
   )
   final void method29(int var1, int var2, byte var3) {
      if(super.animation != -1 && Friend.getAnimation(super.animation).field1017 == 1) {
         super.animation = -1;
      }

      super.field885 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               ChatMessages.method236(this, var1, var2, (byte)2);
            }

            this.method19(var1, var2, var3);
         } else {
            this.method20(var1, var2);
         }
      } else {
         this.method20(var1, var2);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   static final int method37(int var0, int var1) {
      int var2 = ObjectComposition.method883('넵' + var0, 91923 + var1, 4) - 128 + (ObjectComposition.method883(var0 + 10294, '鎽' + var1, 2) - 128 >> 1) + (ObjectComposition.method883(var0, var1, 1) - 128 >> 2);
      var2 = (int)(0.3D * (double)var2) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field38 = 0;
      this.totalLevel = 0;
      this.field31 = 0;
      this.field50 = false;
      this.team = 0;
      this.field41 = false;
      this.field55 = false;
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "1595779944"
   )
   static void method38(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class24.method600(var0.parentId);
      int var2;
      int var3;
      if(null == var1) {
         var2 = class159.field2374;
         var3 = class92.field1643;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      GameObject.method2225(var0, var2, var3, false);
      class18.method197(var0, var2, var3);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1853658170"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?Friend.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field50 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:Friend.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3524(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method2347();
            super.field840 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field50 && super.graphic != -1 && super.field877 != -1) {
               var4 = class49.method1029(super.graphic).method940(super.field877);
               if(null != var4) {
                  var4.method2334(0, -super.field880, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field50 && null != this.model) {
               if(Client.gameCycle >= this.field31) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field31) {
                  var4 = this.model;
                  var4.method2334(this.field42 - super.x, this.field43 - this.field39, this.field44 - super.y);
                  if(super.field891 == 512) {
                     var4.method2330();
                     var4.method2330();
                     var4.method2330();
                  } else if(super.field891 == 1024) {
                     var4.method2330();
                     var4.method2330();
                  } else if(super.field891 == 1536) {
                     var4.method2330();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field891 == 512) {
                     var4.method2330();
                  } else if(super.field891 == 1024) {
                     var4.method2330();
                     var4.method2330();
                  } else if(super.field891 == 1536) {
                     var4.method2330();
                     var4.method2330();
                     var4.method2330();
                  }

                  var4.method2334(super.x - this.field42, this.field39 - this.field43, super.y - this.field44);
               }
            }

            var3.field1908 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-1"
   )
   public static boolean method40() {
      return class186.field3016 != 0?true:class186.field3015.method3672();
   }
}
