import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("j")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -593456087
   )
   int field270;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1538326501
   )
   @Export("skullIcon")
   int skullIcon = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1391574509
   )
   @Export("overheadIcon")
   int overheadIcon = -1;
   @ObfuscatedName("h")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1938636629
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -166119017
   )
   int field276;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 952652723
   )
   int field277;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1496331017
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 175131147
   )
   int field279;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2064898247
   )
   int field280;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1193475255
   )
   int field281;
   @ObfuscatedName("x")
   @Export("name")
   String name;
   @ObfuscatedName("s")
   @Export("model")
   Model model;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1597068421
   )
   int field284;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1869405657
   )
   int field285;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1887860941
   )
   int field286;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2039515509
   )
   int field287;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -867101213
   )
   int field288;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1674140649
   )
   @Export("team")
   int team;
   @ObfuscatedName("z")
   boolean field290;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -21320905
   )
   int field291;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -820261813
   )
   int field292;
   @ObfuscatedName("a")
   boolean field293;
   @ObfuscatedName("b")
   boolean field294;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1236968079
   )
   int field295;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "883879032"
   )
   final void method244(Buffer var1) {
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
               int var8 = class154.getItemDefinition(var4[var5] - 512).field2995;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class6.field62[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field684 = var1.readUnsignedShort();
      if(super.field684 == '\uffff') {
         super.field684 = -1;
      }

      super.field632 = super.field684;
      super.field667 = var1.readUnsignedShort();
      if(super.field667 == '\uffff') {
         super.field667 = -1;
      }

      super.field634 = var1.readUnsignedShort();
      if(super.field634 == '\uffff') {
         super.field634 = -1;
      }

      super.field635 = var1.readUnsignedShort();
      if(super.field635 == '\uffff') {
         super.field635 = -1;
      }

      super.field668 = var1.readUnsignedShort();
      if(super.field668 == '\uffff') {
         super.field668 = -1;
      }

      super.field651 = var1.readUnsignedShort();
      if(super.field651 == '\uffff') {
         super.field651 = -1;
      }

      this.name = var1.readString();
      if(class22.localPlayer == this) {
         class101.field1662 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field281 = var1.readUnsignedShort();
      this.field290 = var1.readUnsignedByte() == 1;
      if(Client.field381 == 0 && Client.field480 >= 2) {
         this.field290 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3183(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1852261872"
   )
   int method245() {
      return null != this.composition && this.composition.field2164 != -1?VertexNormal.getNpcDefinition(this.composition.field2164).field3008:1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-10054"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class168.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field294 || super.idlePoseAnimation == super.poseAnimation && var1 != null?null:class168.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3166(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method1617();
            super.field654 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field294 && super.graphic != -1 && super.field662 != -1) {
               var4 = Widget.method3245(super.graphic).method3474(super.field662);
               if(null != var4) {
                  var4.method1630(0, -super.field666, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field294 && null != this.model) {
               if(Client.gameCycle >= this.field292) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field292) {
                  var4 = this.model;
                  var4.method1630(this.field280 - super.x, this.field279 - this.field277, this.field288 - super.y);
                  if(super.field676 == 512) {
                     var4.method1647();
                     var4.method1647();
                     var4.method1647();
                  } else if(super.field676 == 1024) {
                     var4.method1647();
                     var4.method1647();
                  } else if(super.field676 == 1536) {
                     var4.method1647();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field676 == 512) {
                     var4.method1647();
                  } else if(super.field676 == 1024) {
                     var4.method1647();
                     var4.method1647();
                  } else if(super.field676 == 1536) {
                     var4.method1647();
                     var4.method1647();
                     var4.method1647();
                  }

                  var4.method1630(super.x - this.field280, this.field277 - this.field279, super.y - this.field288);
               }
            }

            var3.field1390 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-7"
   )
   final void method247(int var1, int var2, byte var3) {
      if(super.animation != -1 && class168.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field653 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.method245();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var10 = this.method245();
                  Client.field592.field1859 = var1;
                  Client.field592.field1858 = var2;
                  Client.field592.field1860 = 1;
                  Client.field592.field1861 = 1;
                  class22 var11 = Client.field592;
                  int var12 = WallObject.method1950(var5, var6, var10, var11, Client.collisionMaps[this.field291], true, Client.field593, Client.field594);
                  if(var12 >= 1) {
                     for(int var13 = 0; var13 < var12 - 1; ++var13) {
                        var4.method249(Client.field593[var13], Client.field594[var13], (byte)2);
                     }
                  }
               }
            }

            this.method249(var1, var2, var3);
         } else {
            this.method248(var1, var2);
         }
      } else {
         this.method248(var1, var2);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1494868647"
   )
   void method248(int var1, int var2) {
      super.field679 = 0;
      super.field636 = 0;
      super.field683 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method245();
      super.x = 128 * super.pathX[0] + var3 * 64;
      super.y = 128 * super.pathY[0] + 64 * var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "1492704265"
   )
   final void method249(int var1, int var2, byte var3) {
      if(super.field679 < 9) {
         ++super.field679;
      }

      for(int var4 = super.field679; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field682[var4] = super.field682[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field682[0] = var3;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-107"
   )
   final boolean vmethod782() {
      return this.composition != null;
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field281 = 0;
      this.totalLevel = 0;
      this.field292 = 0;
      this.field294 = false;
      this.team = 0;
      this.field290 = false;
      this.field293 = false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1180068655"
   )
   static int method261(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class26.field624:class32.field754;
      if(var0 == 1600) {
         class32.field756[++class32.field752 - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class32.field756[++class32.field752 - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class32.field756[++class32.field752 - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class32.field756[++class32.field752 - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class32.field756[++class32.field752 - 1] = var3.field2240;
         return 1;
      } else if(var0 == 1606) {
         class32.field756[++class32.field752 - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class32.field756[++class32.field752 - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class32.field756[++class32.field752 - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class32.field756[++class32.field752 - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class32.field756[++class32.field752 - 1] = var3.field2218;
         return 1;
      } else if(var0 == 1611) {
         class32.field756[++class32.field752 - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class32.field756[++class32.field752 - 1] = var3.field2212;
         return 1;
      } else if(var0 == 1613) {
         class32.field756[++class32.field752 - 1] = var3.field2194.vmethod4085();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2113634462"
   )
   static final void method263(int var0) {
      class13.method198();

      for(class31 var1 = (class31)class31.field741.method2448(); var1 != null; var1 = (class31)class31.field741.method2445()) {
         if(var1.field745 != null) {
            var1.method690();
         }
      }

      int var4 = class108.method2103(var0).field2769;
      if(var4 != 0) {
         int var2 = class165.widgetSettings[var0];
         if(var4 == 1) {
            if(var2 == 1) {
               class84.method1717(0.9D);
               ((TextureProvider)class84.field1458).method1497(0.9D);
            }

            if(var2 == 2) {
               class84.method1717(0.8D);
               ((TextureProvider)class84.field1458).method1497(0.8D);
            }

            if(var2 == 3) {
               class84.method1717(0.7D);
               ((TextureProvider)class84.field1458).method1497(0.7D);
            }

            if(var2 == 4) {
               class84.method1717(0.6D);
               ((TextureProvider)class84.field1458).method1497(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var4 == 3) {
            short var5 = 0;
            if(var2 == 0) {
               var5 = 255;
            }

            if(var2 == 1) {
               var5 = 192;
            }

            if(var2 == 2) {
               var5 = 128;
            }

            if(var2 == 3) {
               var5 = 64;
            }

            if(var2 == 4) {
               var5 = 0;
            }

            if(Client.field550 != var5) {
               if(Client.field550 == 0 && Client.field445 != -1) {
                  class40.method821(class3.field39, Client.field445, 0, var5, false);
                  Client.field552 = false;
               } else if(var5 == 0) {
                  class138.field1919.method2536();
                  class138.field1920 = 1;
                  class138.field1916 = null;
                  Client.field552 = false;
               } else {
                  XGrandExchangeOffer.method63(var5);
               }

               Client.field550 = var5;
            }
         }

         if(var4 == 4) {
            if(var2 == 0) {
               Client.field553 = 127;
            }

            if(var2 == 1) {
               Client.field553 = 96;
            }

            if(var2 == 2) {
               Client.field553 = 64;
            }

            if(var2 == 3) {
               Client.field553 = 32;
            }

            if(var2 == 4) {
               Client.field553 = 0;
            }
         }

         if(var4 == 5) {
            Client.field388 = var2;
         }

         if(var4 == 6) {
            Client.field475 = var2;
         }

         if(var4 == 9) {
            Client.field476 = var2;
         }

         if(var4 == 10) {
            if(var2 == 0) {
               Client.field554 = 127;
            }

            if(var2 == 1) {
               Client.field554 = 96;
            }

            if(var2 == 2) {
               Client.field554 = 64;
            }

            if(var2 == 3) {
               Client.field554 = 32;
            }

            if(var2 == 4) {
               Client.field554 = 0;
            }
         }

         if(var4 == 17) {
            Client.field481 = var2 & '\uffff';
         }

         class40[] var3;
         if(var4 == 18) {
            var3 = new class40[]{class40.field839, class40.field837, class40.field835, class40.field836};
            Client.field336 = (class40)class5.method77(var3, var2);
            if(null == Client.field336) {
               Client.field336 = class40.field839;
            }
         }

         if(var4 == 19) {
            if(var2 == -1) {
               Client.field407 = -1;
            } else {
               Client.field407 = var2 & 2047;
            }
         }

         if(var4 == 22) {
            var3 = new class40[]{class40.field839, class40.field837, class40.field835, class40.field836};
            Client.field337 = (class40)class5.method77(var3, var2);
            if(null == Client.field337) {
               Client.field337 = class40.field839;
            }
         }

      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-1405903156"
   )
   static final void method268(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field679 == 0) {
         var0.field683 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = class168.getAnimation(var0.animation);
            if(var0.field636 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field683;
               return;
            }

            if(var0.field636 <= 0 && var1.priority == 0) {
               ++var0.field683;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field672 * 64 + 128 * var0.pathX[var0.field679 - 1];
         int var4 = var0.field672 * 64 + 128 * var0.pathY[var0.field679 - 1];
         if(var10 < var3) {
            if(var2 < var4) {
               var0.field676 = 1280;
            } else if(var2 > var4) {
               var0.field676 = 1792;
            } else {
               var0.field676 = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.field676 = 768;
            } else if(var2 > var4) {
               var0.field676 = 256;
            } else {
               var0.field676 = 512;
            }
         } else if(var2 < var4) {
            var0.field676 = 1024;
         } else if(var2 > var4) {
            var0.field676 = 0;
         }

         byte var5 = var0.field682[var0.field679 - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field676 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field634;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field667;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field668;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field635;
            }

            if(var7 == -1) {
               var7 = var0.field667;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.field676 != var0.angle && var0.interacting == -1 && var0.field678 != 0) {
                  var8 = 2;
               }

               if(var0.field679 > 2) {
                  var8 = 6;
               }

               if(var0.field679 > 3) {
                  var8 = 8;
               }

               if(var0.field683 > 0 && var0.field679 > 1) {
                  var8 = 8;
                  --var0.field683;
               }
            } else {
               if(var0.field679 > 1) {
                  var8 = 6;
               }

               if(var0.field679 > 2) {
                  var8 = 8;
               }

               if(var0.field683 > 0 && var0.field679 > 1) {
                  var8 = 8;
                  --var0.field683;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field667 == var0.poseAnimation && var0.field651 != -1) {
               var0.poseAnimation = var0.field651;
            }

            if(var10 != var3 || var2 != var4) {
               if(var10 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var10 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var0.x == var3 && var4 == var0.y) {
               --var0.field679;
               if(var0.field636 > 0) {
                  --var0.field636;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field679;
            if(var0.field636 > 0) {
               --var0.field636;
            }

         }
      }
   }

   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1543015369"
   )
   static String method269(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass18;II)V",
      garbageValue = "1638804800"
   )
   static void method271(class18 var0, int var1) {
      Object[] var2 = var0.field232;
      int var3 = ((Integer)var2[0]).intValue();
      Script var4 = class152.method2813(var3);
      if(null != var4) {
         class32.field752 = 0;
         class9.scriptStringStackSize = 0;
         int var5 = -1;
         int[] var6 = var4.instructions;
         int[] var7 = var4.intOperands;
         byte var8 = -1;
         class32.scriptStackCount = 0;

         int var11;
         try {
            class32.field748 = new int[var4.localIntCount];
            int var9 = 0;
            class227.field3247 = new String[var4.localStringCount];
            int var10 = 0;

            int var12;
            String var19;
            for(var11 = 1; var11 < var2.length; ++var11) {
               if(var2[var11] instanceof Integer) {
                  var12 = ((Integer)var2[var11]).intValue();
                  if(var12 == -2147483647) {
                     var12 = var0.field222;
                  }

                  if(var12 == -2147483646) {
                     var12 = var0.field225;
                  }

                  if(var12 == -2147483645) {
                     var12 = var0.field223 != null?var0.field223.id:-1;
                  }

                  if(var12 == -2147483644) {
                     var12 = var0.field226;
                  }

                  if(var12 == -2147483643) {
                     var12 = null != var0.field223?var0.field223.index:-1;
                  }

                  if(var12 == -2147483642) {
                     var12 = var0.field227 != null?var0.field227.id:-1;
                  }

                  if(var12 == -2147483641) {
                     var12 = null != var0.field227?var0.field227.index:-1;
                  }

                  if(var12 == -2147483640) {
                     var12 = var0.field230;
                  }

                  if(var12 == -2147483639) {
                     var12 = var0.field229;
                  }

                  class32.field748[var9++] = var12;
               } else if(var2[var11] instanceof String) {
                  var19 = (String)var2[var11];
                  if(var19.equals("event_opbase")) {
                     var19 = var0.field224;
                  }

                  class227.field3247[var10++] = var19;
               }
            }

            var11 = 0;
            class32.field759 = var0.field231;

            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          while(true) {
                                             while(true) {
                                                while(true) {
                                                   while(true) {
                                                      while(true) {
                                                         while(true) {
                                                            while(true) {
                                                               while(true) {
                                                                  while(true) {
                                                                     while(true) {
                                                                        while(true) {
                                                                           while(true) {
                                                                              while(true) {
                                                                                 while(true) {
                                                                                    while(true) {
                                                                                       label279:
                                                                                       while(true) {
                                                                                          ++var11;
                                                                                          if(var11 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var5;
                                                                                          int var27 = var6[var5];
                                                                                          int var13;
                                                                                          if(var27 < 100) {
                                                                                             if(var27 != 0) {
                                                                                                if(var27 != 1) {
                                                                                                   if(var27 != 2) {
                                                                                                      if(var27 != 3) {
                                                                                                         if(var27 != 6) {
                                                                                                            if(var27 != 7) {
                                                                                                               if(var27 != 8) {
                                                                                                                  if(var27 != 9) {
                                                                                                                     if(var27 != 10) {
                                                                                                                        if(var27 != 21) {
                                                                                                                           if(var27 != 25) {
                                                                                                                              int var16;
                                                                                                                              if(var27 != 27) {
                                                                                                                                 if(var27 != 31) {
                                                                                                                                    if(var27 != 32) {
                                                                                                                                       if(var27 != 33) {
                                                                                                                                          if(var27 != 34) {
                                                                                                                                             if(var27 != 35) {
                                                                                                                                                if(var27 != 36) {
                                                                                                                                                   if(var27 != 37) {
                                                                                                                                                      if(var27 != 38) {
                                                                                                                                                         if(var27 != 39) {
                                                                                                                                                            if(var27 != 40) {
                                                                                                                                                               if(var27 != 42) {
                                                                                                                                                                  if(var27 != 43) {
                                                                                                                                                                     if(var27 == 44) {
                                                                                                                                                                        var12 = var7[var5] >> 16;
                                                                                                                                                                        var13 = var7[var5] & '\uffff';
                                                                                                                                                                        int var23 = class32.field756[--class32.field752];
                                                                                                                                                                        if(var23 >= 0 && var23 <= 5000) {
                                                                                                                                                                           class32.field751[var12] = var23;
                                                                                                                                                                           byte var29 = -1;
                                                                                                                                                                           if(var13 == 105) {
                                                                                                                                                                              var29 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var16 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var16 >= var23) {
                                                                                                                                                                                 continue label279;
                                                                                                                                                                              }

                                                                                                                                                                              class32.field750[var12][var16] = var29;
                                                                                                                                                                              ++var16;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var27 == 45) {
                                                                                                                                                                        var12 = var7[var5];
                                                                                                                                                                        var13 = class32.field756[--class32.field752];
                                                                                                                                                                        if(var13 < 0 || var13 >= class32.field751[var12]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class32.field756[++class32.field752 - 1] = class32.field750[var12][var13];
                                                                                                                                                                     } else if(var27 == 46) {
                                                                                                                                                                        var12 = var7[var5];
                                                                                                                                                                        class32.field752 -= 2;
                                                                                                                                                                        var13 = class32.field756[class32.field752];
                                                                                                                                                                        if(var13 < 0 || var13 >= class32.field751[var12]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class32.field750[var12][var13] = class32.field756[class32.field752 + 1];
                                                                                                                                                                     } else if(var27 == 47) {
                                                                                                                                                                        var19 = class7.chatMessages.method919(var7[var5]);
                                                                                                                                                                        if(null == var19) {
                                                                                                                                                                           var19 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var19;
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var27 != 48) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        class7.chatMessages.method918(var7[var5], class32.scriptStringStack[--class9.scriptStringStackSize]);
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class7.chatMessages.method916(var7[var5], class32.field756[--class32.field752]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class32.field756[++class32.field752 - 1] = class7.chatMessages.method917(var7[var5]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var12 = var7[var5];
                                                                                                                                                               Script var32 = class152.method2813(var12);
                                                                                                                                                               int[] var28 = new int[var32.localIntCount];
                                                                                                                                                               String[] var21 = new String[var32.localStringCount];

                                                                                                                                                               for(var16 = 0; var16 < var32.intStackCount; ++var16) {
                                                                                                                                                                  var28[var16] = class32.field756[class32.field752 - var32.intStackCount + var16];
                                                                                                                                                               }

                                                                                                                                                               for(var16 = 0; var16 < var32.stringStackCount; ++var16) {
                                                                                                                                                                  var21[var16] = class32.scriptStringStack[var16 + (class9.scriptStringStackSize - var32.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class32.field752 -= var32.intStackCount;
                                                                                                                                                               class9.scriptStringStackSize -= var32.stringStackCount;
                                                                                                                                                               ScriptState var22 = new ScriptState();
                                                                                                                                                               var22.field134 = var4;
                                                                                                                                                               var22.field137 = var5;
                                                                                                                                                               var22.field133 = class32.field748;
                                                                                                                                                               var22.field136 = class227.field3247;
                                                                                                                                                               class32.scriptStack[++class32.scriptStackCount - 1] = var22;
                                                                                                                                                               var4 = var32;
                                                                                                                                                               var6 = var32.instructions;
                                                                                                                                                               var7 = var32.intOperands;
                                                                                                                                                               var5 = -1;
                                                                                                                                                               class32.field748 = var28;
                                                                                                                                                               class227.field3247 = var21;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class9.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class32.field752;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var12 = var7[var5];
                                                                                                                                                      class9.scriptStringStackSize -= var12;
                                                                                                                                                      String var20 = Ignore.method217(class32.scriptStringStack, class9.scriptStringStackSize, var12);
                                                                                                                                                      class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var20;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class227.field3247[var7[var5]] = class32.scriptStringStack[--class9.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class32.scriptStringStack[++class9.scriptStringStackSize - 1] = class227.field3247[var7[var5]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class32.field748[var7[var5]] = class32.field756[--class32.field752];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class32.field756[++class32.field752 - 1] = class32.field748[var7[var5]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class32.field752 -= 2;
                                                                                                                                       if(class32.field756[class32.field752] >= class32.field756[class32.field752 + 1]) {
                                                                                                                                          var5 += var7[var5];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class32.field752 -= 2;
                                                                                                                                    if(class32.field756[class32.field752] <= class32.field756[1 + class32.field752]) {
                                                                                                                                       var5 += var7[var5];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var12 = var7[var5];
                                                                                                                                 var13 = class32.field756[--class32.field752];
                                                                                                                                 Varbit var14 = class167.method3195(var12);
                                                                                                                                 int var15 = var14.leastSignificantBit;
                                                                                                                                 var16 = var14.configId;
                                                                                                                                 int var17 = var14.mostSignificantBit;
                                                                                                                                 int var18 = class165.field2156[var17 - var16];
                                                                                                                                 if(var13 < 0 || var13 > var18) {
                                                                                                                                    var13 = 0;
                                                                                                                                 }

                                                                                                                                 var18 <<= var16;
                                                                                                                                 class165.widgetSettings[var15] = class165.widgetSettings[var15] & ~var18 | var13 << var16 & var18;
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var12 = var7[var5];
                                                                                                                              class32.field756[++class32.field752 - 1] = class88.method1937(var12);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class32.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var31 = class32.scriptStack[--class32.scriptStackCount];
                                                                                                                           var4 = var31.field134;
                                                                                                                           var6 = var4.instructions;
                                                                                                                           var7 = var4.intOperands;
                                                                                                                           var5 = var31.field137;
                                                                                                                           class32.field748 = var31.field133;
                                                                                                                           class227.field3247 = var31.field136;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class32.field752 -= 2;
                                                                                                                        if(class32.field756[class32.field752] > class32.field756[class32.field752 + 1]) {
                                                                                                                           var5 += var7[var5];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class32.field752 -= 2;
                                                                                                                     if(class32.field756[class32.field752] < class32.field756[class32.field752 + 1]) {
                                                                                                                        var5 += var7[var5];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class32.field752 -= 2;
                                                                                                                  if(class32.field756[class32.field752] == class32.field756[class32.field752 + 1]) {
                                                                                                                     var5 += var7[var5];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class32.field752 -= 2;
                                                                                                               if(class32.field756[class32.field752 + 1] != class32.field756[class32.field752]) {
                                                                                                                  var5 += var7[var5];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var5 += var7[var5];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var4.stringOperands[var5];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var12 = var7[var5];
                                                                                                      class165.widgetSettings[var12] = class32.field756[--class32.field752];
                                                                                                      method263(var12);
                                                                                                   }
                                                                                                } else {
                                                                                                   var12 = var7[var5];
                                                                                                   class32.field756[++class32.field752 - 1] = class165.widgetSettings[var12];
                                                                                                }
                                                                                             } else {
                                                                                                class32.field756[++class32.field752 - 1] = var7[var5];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var30;
                                                                                             if(var4.intOperands[var5] == 1) {
                                                                                                var30 = true;
                                                                                             } else {
                                                                                                var30 = false;
                                                                                             }

                                                                                             var13 = MessageNode.method229(var27, var4, var30);
                                                                                             switch(var13) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
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
                     }
                  }
               }
            }
         } catch (Exception var26) {
            StringBuilder var25 = new StringBuilder(30);
            var25.append("").append(var4.hash).append(" ");

            for(var11 = class32.scriptStackCount - 1; var11 >= 0; --var11) {
               var25.append("").append(class32.scriptStack[var11].field134.hash).append(" ");
            }

            var25.append("").append(var8);
            class31.method703(var25.toString(), var26);
         }
      }
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-610870476"
   )
   static final boolean method272(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1126442165"
   )
   static void method274(String var0) {
      class178.field2666 = var0;

      try {
         String var1 = Client.field308.getParameter(class214.field3172.field3170);
         String var2 = Client.field308.getParameter(class214.field3173.field3170);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class150.method2800(class99.method2005() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class100.method2008(Client.field308, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }
}
