import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -666607853
   )
   int field239;
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1968881939
   )
   @Export("skullIcon")
   int skullIcon = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 569218423
   )
   @Export("overheadIcon")
   int overheadIcon = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1970964097
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("n")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("s")
   boolean field245;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1367533681
   )
   int field247;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1155528035
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2063534727
   )
   int field249;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1521879217
   )
   int field250;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1511317845
   )
   int field251;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 197699009
   )
   int field252;
   @ObfuscatedName("m")
   @Export("model")
   Model model;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 136787555
   )
   int field254;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -250112043
   )
   int field255;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -186007349
   )
   int field256;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -520133001
   )
   int field257;
   @ObfuscatedName("d")
   boolean field258;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -825353199
   )
   @Export("team")
   int team;
   @ObfuscatedName("iu")
   static class38 field260;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 310442017
   )
   int field261;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 84981923
   )
   int field262;
   @ObfuscatedName("b")
   boolean field263;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 54149979
   )
   int field264;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 2125449959
   )
   int field265;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = 356632183
   )
   static int field266;
   @ObfuscatedName("e")
   @Export("composition")
   PlayerComposition composition;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1506064996"
   )
   final void method208(Buffer var1) {
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
               int var8 = class7.getItemDefinition(var4[var5] - 512).field2991;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class217.field3169[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field656 = var1.readUnsignedShort();
      if(super.field656 == '\uffff') {
         super.field656 = -1;
      }

      super.field604 = super.field656;
      super.field622 = var1.readUnsignedShort();
      if(super.field622 == '\uffff') {
         super.field622 = -1;
      }

      super.field646 = var1.readUnsignedShort();
      if(super.field646 == '\uffff') {
         super.field646 = -1;
      }

      super.field623 = var1.readUnsignedShort();
      if(super.field623 == '\uffff') {
         super.field623 = -1;
      }

      super.field609 = var1.readUnsignedShort();
      if(super.field609 == '\uffff') {
         super.field609 = -1;
      }

      super.field600 = var1.readUnsignedShort();
      if(super.field600 == '\uffff') {
         super.field600 = -1;
      }

      this.name = var1.method2767();
      if(class39.localPlayer == this) {
         class202.field3070 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field256 = var1.readUnsignedShort();
      this.field245 = var1.readUnsignedByte() == 1;
      if(Client.field287 == 0 && Client.field358 >= 2) {
         this.field245 = false;
      }

      if(null == this.composition) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3064(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1340868778"
   )
   int method209() {
      return null != this.composition && this.composition.field2176 != -1?TextureProvider.getNpcDefinition(this.composition.field2176).field3012:1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-2030149128"
   )
   final void method213(int var1, int var2, byte var3) {
      if(super.field652 < 9) {
         ++super.field652;
      }

      for(int var4 = super.field652; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field655[var4] = super.field655[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field655[0] = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1060306260"
   )
   final boolean vmethod679() {
      return null != this.composition;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LSpritePixels;",
      garbageValue = "-818771359"
   )
   public static SpritePixels method218(class182 var0, int var1, int var2) {
      return !class178.method3196(var0, var1, var2)?null:class101.method1926();
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field256 = 0;
      this.totalLevel = 0;
      this.field249 = 0;
      this.field258 = false;
      this.team = 0;
      this.field245 = false;
      this.field263 = false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-340190886"
   )
   final void method221(int var1, int var2, byte var3) {
      if(super.animation != -1 && GameEngine.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field626 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.method209();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var10 = this.method209();
                  Client.field565.field1851 = var1;
                  Client.field565.field1855 = var2;
                  Client.field565.field1852 = 1;
                  Client.field565.field1853 = 1;
                  class22 var11 = Client.field565;
                  int var12 = class49.method865(var5, var6, var10, var11, Client.collisionMaps[this.field261], true, Client.field566, Client.field305);
                  if(var12 >= 1) {
                     for(int var13 = 0; var13 < var12 - 1; ++var13) {
                        var4.method213(Client.field566[var13], Client.field305[var13], (byte)2);
                     }
                  }
               }
            }

            this.method213(var1, var2, var3);
         } else {
            this.method235(var1, var2);
         }
      } else {
         this.method235(var1, var2);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "7"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?GameEngine.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field258 && (super.poseAnimation != super.idlePoseAnimation || null == var1)?GameEngine.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3063(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1546();
            super.field601 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field258 && super.graphic != -1 && super.field636 != -1) {
               var4 = Ignore.method193(super.graphic).method3414(super.field636);
               if(var4 != null) {
                  var4.method1554(0, -super.field639, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field258 && this.model != null) {
               if(Client.gameCycle >= this.field249) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field249) {
                  var4 = this.model;
                  var4.method1554(this.field250 - super.x, this.field251 - this.field247, this.field252 - super.y);
                  if(super.field649 == 512) {
                     var4.method1550();
                     var4.method1550();
                     var4.method1550();
                  } else if(super.field649 == 1024) {
                     var4.method1550();
                     var4.method1550();
                  } else if(super.field649 == 1536) {
                     var4.method1550();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field649 == 512) {
                     var4.method1550();
                  } else if(super.field649 == 1024) {
                     var4.method1550();
                     var4.method1550();
                  } else if(super.field649 == 1536) {
                     var4.method1550();
                     var4.method1550();
                     var4.method1550();
                  }

                  var4.method1554(super.x - this.field250, this.field247 - this.field251, super.y - this.field252);
               }
            }

            var3.field1381 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "1879673897"
   )
   static final WidgetNode method234(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field180 = var2;
      Client.componentTable.method2312(var3, (long)var0);
      class137.method2434(var1);
      Widget var4 = class191.method3433(var0);
      class94.method1890(var4);
      if(null != Client.field450) {
         class94.method1890(Client.field450);
         Client.field450 = null;
      }

      class161.method3008();
      class2.method18(Widget.widgets[var0 >> 16], var4, false);
      class176.method3185(var1);
      if(Client.widgetRoot != -1) {
         class32.method656(Client.widgetRoot, 1);
      }

      return var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "99"
   )
   void method235(int var1, int var2) {
      super.field652 = 0;
      super.field607 = 0;
      super.field603 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method209();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = 64 * var3 + super.pathY[0] * 128;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Ljava/lang/String;Ljava/lang/String;I)Lclass208;",
      garbageValue = "-1456529507"
   )
   public static class208 method236(class182 var0, class182 var1, String var2, String var3) {
      int var4 = var0.method3225(var2);
      int var5 = var0.method3226(var4, var3);
      class208 var6;
      if(!class178.method3196(var0, var4, var5)) {
         var6 = null;
      } else {
         byte[] var8 = var1.method3211(var4, var5);
         class208 var7;
         if(null == var8) {
            var7 = null;
         } else {
            class208 var9 = new class208(var8, class225.field3217, RSCanvas.field1748, class225.field3218, Item.field897, class167.field2191, class154.field2106);
            class185.method3361();
            var7 = var9;
         }

         var6 = var7;
      }

      return var6;
   }
}
