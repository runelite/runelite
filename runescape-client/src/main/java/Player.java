import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 237490663
   )
   int field30;
   @ObfuscatedName("e")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2100125889
   )
   int field32;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1704709645
   )
   int field33 = -1;
   @ObfuscatedName("b")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 262504317
   )
   int field36;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -376553255
   )
   int field37;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1118190077
   )
   int field38;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1165969067
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1695462531
   )
   int field40;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 197003767
   )
   int field41;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1584340405
   )
   int field42;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1768536405
   )
   int field43;
   @ObfuscatedName("x")
   @Export("model")
   Model model;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1047385511
   )
   int field45;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1669911085
   )
   int field46;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -501258231
   )
   int field47;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 495439381
   )
   int field48;
   @ObfuscatedName("r")
   boolean field49;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1377833547
   )
   @Export("team")
   int team;
   @ObfuscatedName("z")
   boolean field52;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -936967005
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("s")
   boolean field54;
   @ObfuscatedName("f")
   @Export("name")
   String name;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 929059467
   )
   int field56 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1251621263
   )
   int field57;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2122790706"
   )
   final void method18(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.method2656();
      this.field56 = var1.method2534();
      this.field33 = var1.method2534();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var9 = 0; var9 < 12; ++var9) {
         var6 = var1.method2656();
         if(var6 == 0) {
            var4[var9] = 0;
         } else {
            var7 = var1.method2656();
            var4[var9] = var7 + (var6 << 8);
            if(var9 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2535();
               break;
            }

            if(var4[var9] >= 512) {
               int var8 = class45.getItemDefinition(var4[var9] - 512).field1193;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var5 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2656();
         if(var7 < 0 || var7 >= class134.field2120[var6].length) {
            var7 = 0;
         }

         var5[var6] = var7;
      }

      super.idlePoseAnimation = var1.method2535();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field847 = var1.method2535();
      if(super.field847 == '\uffff') {
         super.field847 = -1;
      }

      super.field823 = super.field847;
      super.field824 = var1.method2535();
      if(super.field824 == '\uffff') {
         super.field824 = -1;
      }

      super.field825 = var1.method2535();
      if(super.field825 == '\uffff') {
         super.field825 = -1;
      }

      super.field826 = var1.method2535();
      if(super.field826 == '\uffff') {
         super.field826 = -1;
      }

      super.field827 = var1.method2535();
      if(super.field827 == '\uffff') {
         super.field827 = -1;
      }

      super.field828 = var1.method2535();
      if(super.field828 == '\uffff') {
         super.field828 = -1;
      }

      this.name = var1.method2541();
      if(this == class34.localPlayer) {
         class127.field2089 = this.name;
      }

      this.combatLevel = var1.method2656();
      this.field37 = var1.method2535();
      this.field52 = var1.method2656() == 1;
      if(Client.field343 == 0 && Client.field446 >= 2) {
         this.field52 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3571(var4, var5, var2 == 1, var3);
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "([LWidget;IB)V",
      garbageValue = "48"
   )
   static final void method20(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3 && var1 == var3.parentId && (!var3.field2787 || !class178.method3504(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.field2787 && class178.method3504(var3) && class113.field1973 != var3) {
                  continue;
               }

               method20(var0, var3.id);
               if(null != var3.children) {
                  method20(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3849((long)var3.id);
               if(var4 != null) {
                  var5 = var4.id;
                  if(class171.method3404(var5)) {
                     method20(Widget.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2835 != -1 || var3.field2836 != -1) {
                  boolean var7 = class33.method717(var3);
                  if(var7) {
                     var5 = var3.field2836;
                  } else {
                     var5 = var3.field2835;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class62.getAnimation(var5);

                     for(var3.field2911 += Client.field358; var3.field2911 > var6.field994[var3.field2910]; MessageNode.method750(var3)) {
                        var3.field2911 -= var6.field994[var3.field2910];
                        ++var3.field2910;
                        if(var3.field2910 >= var6.field992.length) {
                           var3.field2910 -= var6.field996;
                           if(var3.field2910 < 0 || var3.field2910 >= var6.field992.length) {
                              var3.field2910 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2887 != 0 && !var3.field2787) {
                  int var8 = var3.field2887 >> 16;
                  var5 = var3.field2887 << 16 >> 16;
                  var8 *= Client.field358;
                  var5 *= Client.field358;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  MessageNode.method750(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "119"
   )
   final void method21(int var1, int var2, byte var3) {
      if(super.animation != -1 && class62.getAnimation(super.animation).field997 == 1) {
         super.animation = -1;
      }

      super.field844 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class8.method106(this, var1, var2, (byte)2);
            }

            this.method23(var1, var2, var3);
         } else {
            this.method22(var1, var2);
         }
      } else {
         this.method22(var1, var2);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "429803559"
   )
   void method22(int var1, int var2) {
      super.field867 = 0;
      super.field875 = 0;
      super.field872 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method40();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = 128 * super.pathY[0] + var3 * 64;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "834317888"
   )
   final void method23(int var1, int var2, byte var3) {
      if(super.field867 < 9) {
         ++super.field867;
      }

      for(int var4 = super.field867; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field857[var4] = super.field857[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field857[0] = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1315988205"
   )
   final boolean vmethod787() {
      return this.composition != null;
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field37 = 0;
      this.totalLevel = 0;
      this.field40 = 0;
      this.field49 = false;
      this.team = 0;
      this.field52 = false;
      this.field54 = false;
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZS)V",
      garbageValue = "128"
   )
   static final void method33(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1 && var2 != -1 && Widget.validInterfaces[var2]) {
         Widget.field2780.method3296(var2);
         if(Widget.widgets[var2] != null) {
            boolean var4 = true;

            for(int var5 = 0; var5 < Widget.widgets[var2].length; ++var5) {
               if(null != Widget.widgets[var2][var5]) {
                  if(Widget.widgets[var2][var5].type != 2) {
                     Widget.widgets[var2][var5] = null;
                  } else {
                     var4 = false;
                  }
               }
            }

            if(var4) {
               Widget.widgets[var2] = null;
            }

            Widget.validInterfaces[var2] = false;
         }
      }

      for(class204 var6 = (class204)Client.widgetFlags.method3852(); null != var6; var6 = (class204)Client.widgetFlags.method3857()) {
         if((long)var2 == (var6.hash >> 48 & 65535L)) {
            var6.unlink();
         }
      }

      Widget var7 = class153.method3170(var3);
      if(var7 != null) {
         MessageNode.method750(var7);
      }

      Friend.method188();
      if(Client.widgetRoot != -1) {
         class13.method152(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "1529739926"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "3"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class62.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field49 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:class62.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3545(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method2377();
            super.field839 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field49 && super.graphic != -1 && super.field835 != -1) {
               var4 = GameEngine.method3084(super.graphic).method921(super.field835);
               if(var4 != null) {
                  var4.method2337(0, -super.field860, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field49 && this.model != null) {
               if(Client.gameCycle >= this.field40) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field40) {
                  var4 = this.model;
                  var4.method2337(this.field42 - super.x, this.field32 - this.field38, this.field43 - super.y);
                  if(super.field873 == 512) {
                     var4.method2328();
                     var4.method2328();
                     var4.method2328();
                  } else if(super.field873 == 1024) {
                     var4.method2328();
                     var4.method2328();
                  } else if(super.field873 == 1536) {
                     var4.method2328();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field873 == 512) {
                     var4.method2328();
                  } else if(super.field873 == 1024) {
                     var4.method2328();
                     var4.method2328();
                  } else if(super.field873 == 1536) {
                     var4.method2328();
                     var4.method2328();
                     var4.method2328();
                  }

                  var4.method2337(super.x - this.field42, this.field38 - this.field32, super.y - this.field43);
               }
            }

            var3.field1915 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-10"
   )
   static void method39(int var0, int var1, int var2) {
      if(Client.field519 != 0 && var1 != 0 && Client.field363 < 50) {
         Client.field522[Client.field363] = var0;
         Client.field523[Client.field363] = var1;
         Client.field524[Client.field363] = var2;
         Client.field313[Client.field363] = null;
         Client.field525[Client.field363] = 0;
         ++Client.field363;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-47"
   )
   int method40() {
      return null != this.composition && this.composition.field2964 != -1?World.getNpcDefinition(this.composition.field2964).field894:1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZS)[B",
      garbageValue = "18331"
   )
   public static byte[] method43(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class43.method877(var3):var3;
      } else if(var0 instanceof class128) {
         class128 var2 = (class128)var0;
         return var2.vmethod2809();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)LWidget;",
      garbageValue = "48"
   )
   public static Widget method44(int var0, int var1) {
      Widget var2 = class153.method3170(var0);
      return var1 == -1?var2:(null != var2 && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }
}
