import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2049152433
   )
   @Export("team")
   int team;
   @ObfuscatedName("z")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1795015859
   )
   int field27 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -47420115
   )
   int field28 = -1;
   @ObfuscatedName("s")
   @Export("name")
   String name;
   @ObfuscatedName("g")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -539165655
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1012141993
   )
   int field32;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -877001709
   )
   int field33;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 157441941
   )
   int field35;
   @ObfuscatedName("c")
   boolean field36;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1665692253
   )
   int field37;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1785183583
   )
   int field38;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 998331415
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1112492771
   )
   int field40;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1686680523
   )
   int field41;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 596628007
   )
   int field42;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1073477599
   )
   int field43;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1676938029
   )
   int field44;
   @ObfuscatedName("d")
   @Export("model")
   Model model;
   @ObfuscatedName("e")
   boolean field46;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1044776581
   )
   int field47;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1137047197
   )
   int field48;
   @ObfuscatedName("ql")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("x")
   boolean field50;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 2079394189
   )
   int field51;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1463991663
   )
   int field53;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "63"
   )
   final void method7(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.method2481();
      this.field27 = var1.method2601();
      this.field28 = var1.method2601();
      int var3 = -1;
      this.team = 0;
      int[] var4 = new int[12];

      int var6;
      int var7;
      for(int var5 = 0; var5 < 12; ++var5) {
         var6 = var1.method2481();
         if(var6 == 0) {
            var4[var5] = 0;
         } else {
            var7 = var1.method2481();
            var4[var5] = (var6 << 8) + var7;
            if(var5 == 0 && var4[0] == '\uffff') {
               var3 = var1.method2668();
               break;
            }

            if(var4[var5] >= 512) {
               int var8 = class174.getItemDefinition(var4[var5] - 512).field1187;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.method2481();
         if(var7 < 0 || var7 >= PlayerComposition.field2964[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.method2668();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field807 = var1.method2668();
      if(super.field807 == '\uffff') {
         super.field807 = -1;
      }

      super.field806 = super.field807;
      super.field813 = var1.method2668();
      if(super.field813 == '\uffff') {
         super.field813 = -1;
      }

      super.field802 = var1.method2668();
      if(super.field802 == '\uffff') {
         super.field802 = -1;
      }

      super.field808 = var1.method2668();
      if(super.field808 == '\uffff') {
         super.field808 = -1;
      }

      super.field861 = var1.method2668();
      if(super.field861 == '\uffff') {
         super.field861 = -1;
      }

      super.field812 = var1.method2668();
      if(super.field812 == '\uffff') {
         super.field812 = -1;
      }

      this.name = var1.method2503();
      if(TextureProvider.localPlayer == this) {
         class151.field2264 = this.name;
      }

      this.combatLevel = var1.method2481();
      this.field32 = var1.method2668();
      this.field50 = var1.method2481() == 1;
      if(Client.field267 == 0 && Client.field435 >= 2) {
         this.field50 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3474(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "2000"
   )
   int method9() {
      return this.composition != null && this.composition.field2963 != -1?class127.getNpcDefinition(this.composition.field2963).field902:1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass35;B)V",
      garbageValue = "-21"
   )
   static final void method10(class35 var0) {
      if(Client.flagX == TextureProvider.localPlayer.x >> 7 && Client.flagY == TextureProvider.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = class34.field743;
      int[] var2 = class34.field739;
      int var3 = var1;
      if(class35.field759 == var0 || var0 == class35.field756) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class35.field759 == var0) {
            var5 = TextureProvider.localPlayer;
            var6 = TextureProvider.localPlayer.field48 << 14;
         } else if(class35.field756 == var0) {
            var5 = Client.cachedPlayers[Client.field399];
            var6 = Client.field399 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(var0 == class35.field760 && var2[var4] == Client.field399) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod767() && !var5.field50) {
            var5.field36 = false;
            if((Client.field271 && var1 > 50 || var1 > 200) && var0 != class35.field759 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field36 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field35) {
                  var5.field36 = false;
                  var5.field33 = class79.method1656(var5.x, var5.y, class59.plane);
                  class114.region.method2075(class59.plane, var5.x, var5.y, var5.field33, 60, var5, var5.angle, var6, var5.field40, var5.field41, var5.field42, var5.field43);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field373[var7][var8] == Client.field374) {
                        continue;
                     }

                     Client.field373[var7][var8] = Client.field374;
                  }

                  var5.field33 = class79.method1656(var5.x, var5.y, class59.plane);
                  class114.region.method1926(class59.plane, var5.x, var5.y, var5.field33, 60, var5, var5.angle, var6, var5.field860);
               }
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-635360860"
   )
   final void method11(int var1, int var2, byte var3) {
      if(super.animation != -1 && class4.getAnimation(super.animation).field980 == 1) {
         super.animation = -1;
      }

      super.field850 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Friend.method190(this, var1, var2, (byte)2);
            }

            this.method13(var1, var2, var3);
         } else {
            this.method12(var1, var2);
         }
      } else {
         this.method12(var1, var2);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "235134216"
   )
   void method12(int var1, int var2) {
      super.field855 = 0;
      super.field821 = 0;
      super.field859 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method9();
      super.x = 64 * var3 + super.pathX[0] * 128;
      super.y = 64 * var3 + 128 * super.pathY[0];
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "1"
   )
   final void method13(int var1, int var2, byte var3) {
      if(super.field855 < 9) {
         ++super.field855;
      }

      for(int var4 = super.field855; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field858[var4] = super.field858[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field858[0] = var3;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "962919358"
   )
   static final void method17(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field855 == 0) {
         var0.field859 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = class4.getAnimation(var0.animation);
            if(var0.field821 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field859;
               return;
            }

            if(var0.field821 <= 0 && var1.field980 == 0) {
               ++var0.field859;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.pathX[var0.field855 - 1] * 128 + var0.field805 * 64;
         int var4 = var0.pathY[var0.field855 - 1] * 128 + var0.field805 * 64;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.field852 = 1280;
            } else if(var2 > var4) {
               var0.field852 = 1792;
            } else {
               var0.field852 = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.field852 = 768;
            } else if(var2 > var4) {
               var0.field852 = 256;
            } else {
               var0.field852 = 512;
            }
         } else if(var2 < var4) {
            var0.field852 = 1024;
         } else if(var2 > var4) {
            var0.field852 = 0;
         }

         byte var5 = var0.field858[var0.field855 - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field852 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field802;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field813;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field861;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field808;
            }

            if(var7 == -1) {
               var7 = var0.field813;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.angle != var0.field852 && var0.interacting == -1 && var0.field854 != 0) {
                  var8 = 2;
               }

               if(var0.field855 > 2) {
                  var8 = 6;
               }

               if(var0.field855 > 3) {
                  var8 = 8;
               }

               if(var0.field859 > 0 && var0.field855 > 1) {
                  var8 = 8;
                  --var0.field859;
               }
            } else {
               if(var0.field855 > 1) {
                  var8 = 6;
               }

               if(var0.field855 > 2) {
                  var8 = 8;
               }

               if(var0.field859 > 0 && var0.field855 > 1) {
                  var8 = 8;
                  --var0.field859;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.poseAnimation == var0.field813 && var0.field812 != -1) {
               var0.poseAnimation = var0.field812;
            }

            if(var3 != var10 || var4 != var2) {
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

            if(var3 == var0.x && var0.y == var4) {
               --var0.field855;
               if(var0.field821 > 0) {
                  --var0.field821;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field855;
            if(var0.field821 > 0) {
               --var0.field821;
            }

         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)I",
      garbageValue = "1589343018"
   )
   static int method22(class170 var0, class170 var1) {
      int var2 = 0;
      if(var0.method3268("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3268("logo", "")) {
         ++var2;
      }

      if(var1.method3268("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3268("titlebox", "")) {
         ++var2;
      }

      if(var1.method3268("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3268("runes", "")) {
         ++var2;
      }

      if(var1.method3268("title_mute", "")) {
         ++var2;
      }

      if(var1.method3269("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3269("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3268("sl_back", "");
      var1.method3268("sl_flags", "");
      var1.method3268("sl_arrows", "");
      var1.method3268("sl_stars", "");
      var1.method3268("sl_button", "");
      return var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-26"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class4.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || this.field36 || super.poseAnimation == super.idlePoseAnimation && null != var1?null:class4.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3497(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method2275();
            super.field851 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field36 && super.graphic != -1 && super.field811 != -1) {
               var4 = class107.method2269(super.graphic).method915(super.field811);
               if(null != var4) {
                  var4.method2280(0, -super.field839, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field36 && null != this.model) {
               if(Client.gameCycle >= this.field35) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field35) {
                  var4 = this.model;
                  var4.method2280(this.field44 - super.x, this.field37 - this.field33, this.field38 - super.y);
                  if(super.field852 == 512) {
                     var4.method2327();
                     var4.method2327();
                     var4.method2327();
                  } else if(super.field852 == 1024) {
                     var4.method2327();
                     var4.method2327();
                  } else if(super.field852 == 1536) {
                     var4.method2327();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field852 == 512) {
                     var4.method2327();
                  } else if(super.field852 == 1024) {
                     var4.method2327();
                     var4.method2327();
                  } else if(super.field852 == 1536) {
                     var4.method2327();
                     var4.method2327();
                     var4.method2327();
                  }

                  var4.method2280(super.x - this.field44, this.field33 - this.field37, super.y - this.field38);
               }
            }

            var3.field1864 = true;
            return var3;
         }
      }
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field32 = 0;
      this.totalLevel = 0;
      this.field35 = 0;
      this.field36 = false;
      this.team = 0;
      this.field50 = false;
      this.field46 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "909472363"
   )
   final boolean vmethod767() {
      return null != this.composition;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass0;II)V",
      garbageValue = "1774574048"
   )
   static void method35(class0 var0, int var1) {
      Object[] var2 = var0.field5;
      int var3 = ((Integer)var2[0]).intValue();
      class23 var4 = GroundObject.method2149(var3);
      if(var4 != null) {
         int var5 = 0;
         int var6 = 0;
         int var7 = -1;
         int[] var8 = var4.field578;
         int[] var9 = var4.field580;
         byte var10 = -1;
         class38.field790 = 0;

         int var13;
         try {
            class38.field788 = new int[var4.field581];
            int var11 = 0;
            class38.field785 = new String[var4.field577];
            int var12 = 0;

            int var14;
            String var23;
            for(var13 = 1; var13 < var2.length; ++var13) {
               if(var2[var13] instanceof Integer) {
                  var14 = ((Integer)var2[var13]).intValue();
                  if(var14 == -2147483647) {
                     var14 = var0.field10;
                  }

                  if(var14 == -2147483646) {
                     var14 = var0.field1;
                  }

                  if(var14 == -2147483645) {
                     var14 = null != var0.field2?var0.field2.id:-1;
                  }

                  if(var14 == -2147483644) {
                     var14 = var0.field6;
                  }

                  if(var14 == -2147483643) {
                     var14 = null != var0.field2?var0.field2.index:-1;
                  }

                  if(var14 == -2147483642) {
                     var14 = var0.field3 != null?var0.field3.id:-1;
                  }

                  if(var14 == -2147483641) {
                     var14 = var0.field3 != null?var0.field3.index:-1;
                  }

                  if(var14 == -2147483640) {
                     var14 = var0.field4;
                  }

                  if(var14 == -2147483639) {
                     var14 = var0.field8;
                  }

                  class38.field788[var11++] = var14;
               } else if(var2[var13] instanceof String) {
                  var23 = (String)var2[var13];
                  if(var23.equals("event_opbase")) {
                     var23 = var0.field9;
                  }

                  class38.field785[var12++] = var23;
               }
            }

            var13 = 0;
            class38.field795 = var0.field13;

            label3538:
            while(true) {
               ++var13;
               if(var13 > var1) {
                  throw new RuntimeException();
               }

               ++var7;
               int var35 = var8[var7];
               int var15;
               int[] var16;
               int var19;
               int var20;
               int var21;
               int var24;
               int var26;
               byte[] var48;
               String var79;
               byte var83;
               if(var35 < 100) {
                  if(var35 == 0) {
                     class38.field800[var5++] = var9[var7];
                     continue;
                  }

                  if(var35 == 1) {
                     var14 = var9[var7];
                     class38.field800[var5++] = class179.widgetSettings[var14];
                     continue;
                  }

                  if(var35 == 2) {
                     var14 = var9[var7];
                     --var5;
                     class179.widgetSettings[var14] = class38.field800[var5];
                     class20.method539(var14);
                     continue;
                  }

                  if(var35 == 3) {
                     class38.chatboxSegments[var6++] = var4.field582[var7];
                     continue;
                  }

                  if(var35 == 6) {
                     var7 += var9[var7];
                     continue;
                  }

                  if(var35 == 7) {
                     var5 -= 2;
                     if(class38.field800[var5 + 1] != class38.field800[var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var35 == 8) {
                     var5 -= 2;
                     if(class38.field800[var5] == class38.field800[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var35 == 9) {
                     var5 -= 2;
                     if(class38.field800[var5] < class38.field800[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var35 == 10) {
                     var5 -= 2;
                     if(class38.field800[var5] > class38.field800[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var35 == 21) {
                     if(class38.field790 == 0) {
                        return;
                     }

                     class14 var60 = class38.field791[--class38.field790];
                     var4 = var60.field198;
                     var8 = var4.field578;
                     var9 = var4.field580;
                     var7 = var60.field192;
                     class38.field788 = var60.field193;
                     class38.field785 = var60.field196;
                     continue;
                  }

                  if(var35 == 25) {
                     var14 = var9[var7];
                     class38.field800[var5++] = class173.method3381(var14);
                     continue;
                  }

                  if(var35 == 27) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class38.field800[var5];
                     class50 var58 = (class50)class50.field1063.get((long)var14);
                     class50 var75;
                     if(var58 != null) {
                        var75 = var58;
                     } else {
                        var48 = class50.field1065.method3272(14, var14);
                        var58 = new class50();
                        if(var48 != null) {
                           var58.method1000(new Buffer(var48));
                        }

                        class50.field1063.put(var58, (long)var14);
                        var75 = var58;
                     }

                     var24 = var75.field1070;
                     var19 = var75.field1066;
                     var20 = var75.field1067;
                     var21 = class179.field2949[var20 - var19];
                     if(var15 < 0 || var15 > var21) {
                        var15 = 0;
                     }

                     var21 <<= var19;
                     class179.widgetSettings[var24] = class179.widgetSettings[var24] & ~var21 | var15 << var19 & var21;
                     continue;
                  }

                  if(var35 == 31) {
                     var5 -= 2;
                     if(class38.field800[var5] <= class38.field800[var5 + 1]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var35 == 32) {
                     var5 -= 2;
                     if(class38.field800[var5] >= class38.field800[1 + var5]) {
                        var7 += var9[var7];
                     }
                     continue;
                  }

                  if(var35 == 33) {
                     class38.field800[var5++] = class38.field788[var9[var7]];
                     continue;
                  }

                  int var10001;
                  if(var35 == 34) {
                     var10001 = var9[var7];
                     --var5;
                     class38.field788[var10001] = class38.field800[var5];
                     continue;
                  }

                  if(var35 == 35) {
                     class38.chatboxSegments[var6++] = class38.field785[var9[var7]];
                     continue;
                  }

                  if(var35 == 36) {
                     var10001 = var9[var7];
                     --var6;
                     class38.field785[var10001] = class38.chatboxSegments[var6];
                     continue;
                  }

                  if(var35 == 37) {
                     var14 = var9[var7];
                     var6 -= var14;
                     var79 = class161.method3161(class38.chatboxSegments, var6, var14);
                     class38.chatboxSegments[var6++] = var79;
                     continue;
                  }

                  if(var35 == 38) {
                     --var5;
                     continue;
                  }

                  if(var35 == 39) {
                     --var6;
                     continue;
                  }

                  if(var35 == 40) {
                     var14 = var9[var7];
                     class23 var88 = GroundObject.method2149(var14);
                     var16 = new int[var88.field581];
                     String[] var57 = new String[var88.field577];

                     for(var24 = 0; var24 < var88.field579; ++var24) {
                        var16[var24] = class38.field800[var24 + (var5 - var88.field579)];
                     }

                     for(var24 = 0; var24 < var88.field584; ++var24) {
                        var57[var24] = class38.chatboxSegments[var6 - var88.field584 + var24];
                     }

                     var5 -= var88.field579;
                     var6 -= var88.field584;
                     class14 var73 = new class14();
                     var73.field198 = var4;
                     var73.field192 = var7;
                     var73.field193 = class38.field788;
                     var73.field196 = class38.field785;
                     class38.field791[++class38.field790 - 1] = var73;
                     var4 = var88;
                     var8 = var88.field578;
                     var9 = var88.field580;
                     var7 = -1;
                     class38.field788 = var16;
                     class38.field785 = var57;
                     continue;
                  }

                  if(var35 == 42) {
                     class38.field800[var5++] = class141.chatMessages.method197(var9[var7]);
                     continue;
                  }

                  if(var35 == 43) {
                     var10001 = var9[var7];
                     --var5;
                     class141.chatMessages.method196(var10001, class38.field800[var5]);
                     continue;
                  }

                  if(var35 == 44) {
                     var14 = var9[var7] >> 16;
                     var15 = var9[var7] & '\uffff';
                     --var5;
                     var26 = class38.field800[var5];
                     if(var26 >= 0 && var26 <= 5000) {
                        class38.field786[var14] = var26;
                        var83 = -1;
                        if(var15 == 105) {
                           var83 = 0;
                        }

                        var24 = 0;

                        while(true) {
                           if(var24 >= var26) {
                              continue label3538;
                           }

                           class38.field787[var14][var24] = var83;
                           ++var24;
                        }
                     }

                     throw new RuntimeException();
                  }

                  if(var35 == 45) {
                     var14 = var9[var7];
                     --var5;
                     var15 = class38.field800[var5];
                     if(var15 >= 0 && var15 < class38.field786[var14]) {
                        class38.field800[var5++] = class38.field787[var14][var15];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var35 == 46) {
                     var14 = var9[var7];
                     var5 -= 2;
                     var15 = class38.field800[var5];
                     if(var15 >= 0 && var15 < class38.field786[var14]) {
                        class38.field787[var14][var15] = class38.field800[1 + var5];
                        continue;
                     }

                     throw new RuntimeException();
                  }

                  if(var35 == 47) {
                     var23 = class141.chatMessages.method199(var9[var7]);
                     if(null == var23) {
                        var23 = "null";
                     }

                     class38.chatboxSegments[var6++] = var23;
                     continue;
                  }

                  if(var35 == 48) {
                     var10001 = var9[var7];
                     --var6;
                     class141.chatMessages.method198(var10001, class38.chatboxSegments[var6]);
                     continue;
                  }
               }

               boolean var49;
               if(var9[var7] == 1) {
                  var49 = true;
               } else {
                  var49 = false;
               }

               Widget var25;
               int var27;
               Widget var38;
               Widget var42;
               Widget var63;
               boolean var65;
               boolean var66;
               if(var35 < 1000) {
                  if(var35 == 100) {
                     var5 -= 3;
                     var15 = class38.field800[var5];
                     var26 = class38.field800[1 + var5];
                     var27 = class38.field800[2 + var5];
                     if(var26 == 0) {
                        throw new RuntimeException();
                     }

                     var42 = class92.method2078(var15);
                     if(null == var42.children) {
                        var42.children = new Widget[1 + var27];
                     }

                     if(var42.children.length <= var27) {
                        Widget[] var77 = new Widget[1 + var27];

                        for(var20 = 0; var20 < var42.children.length; ++var20) {
                           var77[var20] = var42.children[var20];
                        }

                        var42.children = var77;
                     }

                     if(var27 > 0 && var42.children[var27 - 1] == null) {
                        throw new RuntimeException("" + (var27 - 1));
                     }

                     Widget var78 = new Widget();
                     var78.type = var26;
                     var78.parentId = var78.id = var42.id;
                     var78.index = var27;
                     var78.field2797 = true;
                     var42.children[var27] = var78;
                     if(var49) {
                        class38.field792 = var78;
                     } else {
                        class114.field1986 = var78;
                     }

                     class32.method685(var42);
                     continue;
                  }

                  if(var35 == 101) {
                     var25 = var49?class38.field792:class114.field1986;
                     var63 = class92.method2078(var25.id);
                     var63.children[var25.index] = null;
                     class32.method685(var63);
                     continue;
                  }

                  if(var35 == 102) {
                     --var5;
                     var25 = class92.method2078(class38.field800[var5]);
                     var25.children = null;
                     class32.method685(var25);
                     continue;
                  }

                  if(var35 == 200) {
                     var5 -= 2;
                     var15 = class38.field800[var5];
                     var26 = class38.field800[1 + var5];
                     var38 = class163.method3174(var15, var26);
                     if(var38 != null && var26 != -1) {
                        class38.field800[var5++] = 1;
                        if(var49) {
                           class38.field792 = var38;
                        } else {
                           class114.field1986 = var38;
                        }
                        continue;
                     }

                     class38.field800[var5++] = 0;
                     continue;
                  }

                  if(var35 == 201) {
                     --var5;
                     var25 = class92.method2078(class38.field800[var5]);
                     if(var25 != null) {
                        class38.field800[var5++] = 1;
                        if(var49) {
                           class38.field792 = var25;
                        } else {
                           class114.field1986 = var25;
                        }
                     } else {
                        class38.field800[var5++] = 0;
                     }
                     continue;
                  }
               } else {
                  boolean var82;
                  if(var35 >= 1000 && var35 < 1100 || var35 >= 2000 && var35 < 2100) {
                     var15 = -1;
                     if(var35 >= 2000) {
                        var35 -= 1000;
                        --var5;
                        var15 = class38.field800[var5];
                        var63 = class92.method2078(var15);
                     } else {
                        var63 = var49?class38.field792:class114.field1986;
                     }

                     if(var35 == 1000) {
                        var5 -= 4;
                        var63.field2807 = class38.field800[var5];
                        var63.field2808 = class38.field800[var5 + 1];
                        var63.field2803 = class38.field800[2 + var5];
                        var63.field2804 = class38.field800[var5 + 3];
                        class32.method685(var63);
                        class53.method1060(var63);
                        if(var15 != -1 && var63.type == 0) {
                           Projectile.method99(Widget.widgets[var15 >> 16], var63, false);
                        }
                        continue;
                     }

                     if(var35 == 1001) {
                        var5 -= 4;
                        var63.field2805 = class38.field800[var5];
                        var63.field2791 = class38.field800[1 + var5];
                        var63.field2907 = class38.field800[2 + var5];
                        var63.field2809 = class38.field800[var5 + 3];
                        class32.method685(var63);
                        class53.method1060(var63);
                        if(var15 != -1 && var63.type == 0) {
                           Projectile.method99(Widget.widgets[var15 >> 16], var63, false);
                        }
                        continue;
                     }

                     if(var35 == 1003) {
                        --var5;
                        var82 = class38.field800[var5] == 1;
                        if(var82 != var63.isHidden) {
                           var63.isHidden = var82;
                           class32.method685(var63);
                        }
                        continue;
                     }

                     if(var35 == 1005) {
                        --var5;
                        var63.field2931 = class38.field800[var5] == 1;
                        continue;
                     }

                     if(var35 == 1006) {
                        --var5;
                        var63.field2932 = class38.field800[var5] == 1;
                        continue;
                     }
                  } else {
                     String var17;
                     if(var35 >= 1100 && var35 < 1200 || var35 >= 2100 && var35 < 2200) {
                        var26 = -1;
                        if(var35 >= 2000) {
                           var35 -= 1000;
                           --var5;
                           var26 = class38.field800[var5];
                           var25 = class92.method2078(var26);
                        } else {
                           var25 = var49?class38.field792:class114.field1986;
                        }

                        if(var35 == 1100) {
                           var5 -= 2;
                           var25.itemId = class38.field800[var5];
                           if(var25.itemId > var25.scrollWidth - var25.width) {
                              var25.itemId = var25.scrollWidth - var25.width;
                           }

                           if(var25.itemId < 0) {
                              var25.itemId = 0;
                           }

                           var25.scrollY = class38.field800[1 + var5];
                           if(var25.scrollY > var25.scrollHeight - var25.height) {
                              var25.scrollY = var25.scrollHeight - var25.height;
                           }

                           if(var25.scrollY < 0) {
                              var25.scrollY = 0;
                           }

                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1101) {
                           --var5;
                           var25.textColor = class38.field800[var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1102) {
                           --var5;
                           var25.field2827 = class38.field800[var5] == 1;
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1103) {
                           --var5;
                           var25.opacity = class38.field800[var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1104) {
                           --var5;
                           var25.field2831 = class38.field800[var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1105) {
                           --var5;
                           var25.textureId = class38.field800[var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1106) {
                           --var5;
                           var25.field2835 = class38.field800[var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1107) {
                           --var5;
                           var25.field2836 = class38.field800[var5] == 1;
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1108) {
                           var25.modelType = 1;
                           --var5;
                           var25.modelId = class38.field800[var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1109) {
                           var5 -= 6;
                           var25.field2787 = class38.field800[var5];
                           var25.field2847 = class38.field800[var5 + 1];
                           var25.rotationX = class38.field800[var5 + 2];
                           var25.rotationZ = class38.field800[3 + var5];
                           var25.rotationY = class38.field800[4 + var5];
                           var25.field2852 = class38.field800[5 + var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1110) {
                           --var5;
                           var27 = class38.field800[var5];
                           if(var25.field2845 != var27) {
                              var25.field2845 = var27;
                              var25.field2811 = 0;
                              var25.field2921 = 0;
                              class32.method685(var25);
                           }
                           continue;
                        }

                        if(var35 == 1111) {
                           --var5;
                           var25.field2855 = class38.field800[var5] == 1;
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1112) {
                           --var6;
                           var17 = class38.chatboxSegments[var6];
                           if(!var17.equals(var25.text)) {
                              var25.text = var17;
                              class32.method685(var25);
                           }
                           continue;
                        }

                        if(var35 == 1113) {
                           --var5;
                           var25.field2844 = class38.field800[var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1114) {
                           var5 -= 3;
                           var25.field2786 = class38.field800[var5];
                           var25.field2862 = class38.field800[1 + var5];
                           var25.field2886 = class38.field800[var5 + 2];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1115) {
                           --var5;
                           var25.field2879 = class38.field800[var5] == 1;
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1116) {
                           --var5;
                           var25.borderThickness = class38.field800[var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1117) {
                           --var5;
                           var25.sprite2 = class38.field800[var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1118) {
                           --var5;
                           var25.flippedVertically = class38.field800[var5] == 1;
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1119) {
                           --var5;
                           var25.flippedHorizontally = class38.field800[var5] == 1;
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1120) {
                           var5 -= 2;
                           var25.scrollWidth = class38.field800[var5];
                           var25.scrollHeight = class38.field800[var5 + 1];
                           class32.method685(var25);
                           if(var26 != -1 && var25.type == 0) {
                              Projectile.method99(Widget.widgets[var26 >> 16], var25, false);
                           }
                           continue;
                        }

                        if(var35 == 1121) {
                           class34.method728(var25.id, var25.index);
                           Client.field432 = var25;
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1122) {
                           --var5;
                           var25.field2834 = class38.field800[var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1123) {
                           --var5;
                           var25.field2824 = class38.field800[var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1124) {
                           --var5;
                           var25.field2830 = class38.field800[var5];
                           class32.method685(var25);
                           continue;
                        }

                        if(var35 == 1125) {
                           --var5;
                           var27 = class38.field800[var5];
                           class85 var71 = (class85)SecondaryBufferProvider.method1646(VertexNormal.method2178(), var27);
                           if(null != var71) {
                              var25.field2806 = var71;
                              class32.method685(var25);
                           }
                           continue;
                        }
                     } else if((var35 < 1200 || var35 >= 1300) && (var35 < 2200 || var35 >= 2300)) {
                        if((var35 < 1300 || var35 >= 1400) && (var35 < 2300 || var35 >= 2400)) {
                           String var37;
                           int[] var40;
                           if(var35 >= 1400 && var35 < 1500 || var35 >= 2400 && var35 < 2500) {
                              if(var35 >= 2000) {
                                 var35 -= 1000;
                                 --var5;
                                 var25 = class92.method2078(class38.field800[var5]);
                              } else {
                                 var25 = var49?class38.field792:class114.field1986;
                              }

                              --var6;
                              var37 = class38.chatboxSegments[var6];
                              var40 = null;
                              if(var37.length() > 0 && var37.charAt(var37.length() - 1) == 89) {
                                 --var5;
                                 var24 = class38.field800[var5];
                                 if(var24 > 0) {
                                    for(var40 = new int[var24]; var24-- > 0; var40[var24] = class38.field800[var5]) {
                                       --var5;
                                    }
                                 }

                                 var37 = var37.substring(0, var37.length() - 1);
                              }

                              Object[] var50 = new Object[var37.length() + 1];

                              for(var19 = var50.length - 1; var19 >= 1; --var19) {
                                 if(var37.charAt(var19 - 1) == 115) {
                                    --var6;
                                    var50[var19] = class38.chatboxSegments[var6];
                                 } else {
                                    --var5;
                                    var50[var19] = new Integer(class38.field800[var5]);
                                 }
                              }

                              --var5;
                              var19 = class38.field800[var5];
                              if(var19 != -1) {
                                 var50[0] = new Integer(var19);
                              } else {
                                 var50 = null;
                              }

                              if(var35 == 1400) {
                                 var25.field2880 = var50;
                              }

                              if(var35 == 1401) {
                                 var25.field2882 = var50;
                              }

                              if(var35 == 1402) {
                                 var25.field2860 = var50;
                              }

                              if(var35 == 1403) {
                                 var25.field2927 = var50;
                              }

                              if(var35 == 1404) {
                                 var25.field2814 = var50;
                              }

                              if(var35 == 1405) {
                                 var25.field2848 = var50;
                              }

                              if(var35 == 1406) {
                                 var25.field2883 = var50;
                              }

                              if(var35 == 1407) {
                                 var25.field2822 = var50;
                                 var25.field2892 = var40;
                              }

                              if(var35 == 1408) {
                                 var25.field2897 = var50;
                              }

                              if(var35 == 1409) {
                                 var25.field2873 = var50;
                              }

                              if(var35 == 1410) {
                                 var25.field2888 = var50;
                              }

                              if(var35 == 1411) {
                                 var25.field2881 = var50;
                              }

                              if(var35 == 1412) {
                                 var25.field2885 = var50;
                              }

                              if(var35 == 1414) {
                                 var25.field2893 = var50;
                                 var25.field2846 = var40;
                              }

                              if(var35 == 1415) {
                                 var25.field2887 = var50;
                                 var25.field2896 = var40;
                              }

                              if(var35 == 1416) {
                                 var25.field2889 = var50;
                              }

                              if(var35 == 1417) {
                                 var25.field2899 = var50;
                              }

                              if(var35 == 1418) {
                                 var25.field2900 = var50;
                              }

                              if(var35 == 1419) {
                                 var25.field2901 = var50;
                              }

                              if(var35 == 1420) {
                                 var25.field2902 = var50;
                              }

                              if(var35 == 1421) {
                                 var25.field2903 = var50;
                              }

                              if(var35 == 1422) {
                                 var25.field2904 = var50;
                              }

                              if(var35 == 1423) {
                                 var25.field2905 = var50;
                              }

                              if(var35 == 1424) {
                                 var25.field2906 = var50;
                              }

                              if(var35 == 1425) {
                                 var25.field2890 = var50;
                              }

                              if(var35 == 1426) {
                                 var25.field2894 = var50;
                              }

                              if(var35 == 1427) {
                                 var25.field2918 = var50;
                              }

                              var25.field2916 = true;
                              continue;
                           }

                           if(var35 < 1600) {
                              var25 = var49?class38.field792:class114.field1986;
                              if(var35 == 1500) {
                                 class38.field800[var5++] = var25.relativeX;
                                 continue;
                              }

                              if(var35 == 1501) {
                                 class38.field800[var5++] = var25.relativeY;
                                 continue;
                              }

                              if(var35 == 1502) {
                                 class38.field800[var5++] = var25.width;
                                 continue;
                              }

                              if(var35 == 1503) {
                                 class38.field800[var5++] = var25.height;
                                 continue;
                              }

                              if(var35 == 1504) {
                                 class38.field800[var5++] = var25.isHidden?1:0;
                                 continue;
                              }

                              if(var35 == 1505) {
                                 class38.field800[var5++] = var25.parentId;
                                 continue;
                              }
                           } else if(var35 < 1700) {
                              var25 = var49?class38.field792:class114.field1986;
                              if(var35 == 1600) {
                                 class38.field800[var5++] = var25.itemId;
                                 continue;
                              }

                              if(var35 == 1601) {
                                 class38.field800[var5++] = var25.scrollY;
                                 continue;
                              }

                              if(var35 == 1602) {
                                 class38.chatboxSegments[var6++] = var25.text;
                                 continue;
                              }

                              if(var35 == 1603) {
                                 class38.field800[var5++] = var25.scrollWidth;
                                 continue;
                              }

                              if(var35 == 1604) {
                                 class38.field800[var5++] = var25.scrollHeight;
                                 continue;
                              }

                              if(var35 == 1605) {
                                 class38.field800[var5++] = var25.field2852;
                                 continue;
                              }

                              if(var35 == 1606) {
                                 class38.field800[var5++] = var25.rotationX;
                                 continue;
                              }

                              if(var35 == 1607) {
                                 class38.field800[var5++] = var25.rotationY;
                                 continue;
                              }

                              if(var35 == 1608) {
                                 class38.field800[var5++] = var25.rotationZ;
                                 continue;
                              }

                              if(var35 == 1609) {
                                 class38.field800[var5++] = var25.opacity;
                                 continue;
                              }

                              if(var35 == 1610) {
                                 class38.field800[var5++] = var25.field2830;
                                 continue;
                              }

                              if(var35 == 1611) {
                                 class38.field800[var5++] = var25.textColor;
                                 continue;
                              }

                              if(var35 == 1612) {
                                 class38.field800[var5++] = var25.field2824;
                                 continue;
                              }

                              if(var35 == 1613) {
                                 class38.field800[var5++] = var25.field2806.vmethod3162();
                                 continue;
                              }
                           } else if(var35 < 1800) {
                              var25 = var49?class38.field792:class114.field1986;
                              if(var35 == 1700) {
                                 class38.field800[var5++] = var25.item;
                                 continue;
                              }

                              if(var35 == 1701) {
                                 if(var25.item != -1) {
                                    class38.field800[var5++] = var25.stackSize;
                                 } else {
                                    class38.field800[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var35 == 1702) {
                                 class38.field800[var5++] = var25.index;
                                 continue;
                              }
                           } else if(var35 < 1900) {
                              var25 = var49?class38.field792:class114.field1986;
                              if(var35 == 1800) {
                                 var16 = class38.field800;
                                 var27 = var5++;
                                 var19 = class11.method138(var25);
                                 var24 = var19 >> 11 & 63;
                                 var16[var27] = var24;
                                 continue;
                              }

                              if(var35 == 1801) {
                                 --var5;
                                 var26 = class38.field800[var5];
                                 --var26;
                                 if(null != var25.actions && var26 < var25.actions.length && null != var25.actions[var26]) {
                                    class38.chatboxSegments[var6++] = var25.actions[var26];
                                    continue;
                                 }

                                 class38.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var35 == 1802) {
                                 if(var25.name == null) {
                                    class38.chatboxSegments[var6++] = "";
                                 } else {
                                    class38.chatboxSegments[var6++] = var25.name;
                                 }
                                 continue;
                              }
                           } else if(var35 >= 1900 && var35 < 2000 || var35 >= 2900 && var35 < 3000) {
                              if(var35 >= 2000) {
                                 var35 -= 1000;
                                 --var5;
                                 var25 = class92.method2078(class38.field800[var5]);
                              } else {
                                 var25 = var49?class38.field792:class114.field1986;
                              }

                              if(var35 == 1927) {
                                 if(class38.field795 >= 10) {
                                    throw new RuntimeException();
                                 }

                                 if(var25.field2918 == null) {
                                    return;
                                 }

                                 class0 var62 = new class0();
                                 var62.field2 = var25;
                                 var62.field5 = var25.field2918;
                                 var62.field13 = 1 + class38.field795;
                                 Client.field467.method3801(var0);
                                 continue;
                              }
                           } else if(var35 < 2600) {
                              --var5;
                              var25 = class92.method2078(class38.field800[var5]);
                              if(var35 == 2500) {
                                 class38.field800[var5++] = var25.relativeX;
                                 continue;
                              }

                              if(var35 == 2501) {
                                 class38.field800[var5++] = var25.relativeY;
                                 continue;
                              }

                              if(var35 == 2502) {
                                 class38.field800[var5++] = var25.width;
                                 continue;
                              }

                              if(var35 == 2503) {
                                 class38.field800[var5++] = var25.height;
                                 continue;
                              }

                              if(var35 == 2504) {
                                 class38.field800[var5++] = var25.isHidden?1:0;
                                 continue;
                              }

                              if(var35 == 2505) {
                                 class38.field800[var5++] = var25.parentId;
                                 continue;
                              }
                           } else if(var35 < 2700) {
                              --var5;
                              var25 = class92.method2078(class38.field800[var5]);
                              if(var35 == 2600) {
                                 class38.field800[var5++] = var25.itemId;
                                 continue;
                              }

                              if(var35 == 2601) {
                                 class38.field800[var5++] = var25.scrollY;
                                 continue;
                              }

                              if(var35 == 2602) {
                                 class38.chatboxSegments[var6++] = var25.text;
                                 continue;
                              }

                              if(var35 == 2603) {
                                 class38.field800[var5++] = var25.scrollWidth;
                                 continue;
                              }

                              if(var35 == 2604) {
                                 class38.field800[var5++] = var25.scrollHeight;
                                 continue;
                              }

                              if(var35 == 2605) {
                                 class38.field800[var5++] = var25.field2852;
                                 continue;
                              }

                              if(var35 == 2606) {
                                 class38.field800[var5++] = var25.rotationX;
                                 continue;
                              }

                              if(var35 == 2607) {
                                 class38.field800[var5++] = var25.rotationY;
                                 continue;
                              }

                              if(var35 == 2608) {
                                 class38.field800[var5++] = var25.rotationZ;
                                 continue;
                              }

                              if(var35 == 2609) {
                                 class38.field800[var5++] = var25.opacity;
                                 continue;
                              }

                              if(var35 == 2610) {
                                 class38.field800[var5++] = var25.field2830;
                                 continue;
                              }

                              if(var35 == 2611) {
                                 class38.field800[var5++] = var25.textColor;
                                 continue;
                              }

                              if(var35 == 2612) {
                                 class38.field800[var5++] = var25.field2824;
                                 continue;
                              }

                              if(var35 == 2613) {
                                 class38.field800[var5++] = var25.field2806.vmethod3162();
                                 continue;
                              }
                           } else if(var35 < 2800) {
                              if(var35 == 2700) {
                                 --var5;
                                 var25 = class92.method2078(class38.field800[var5]);
                                 class38.field800[var5++] = var25.item;
                                 continue;
                              }

                              if(var35 == 2701) {
                                 --var5;
                                 var25 = class92.method2078(class38.field800[var5]);
                                 if(var25.item != -1) {
                                    class38.field800[var5++] = var25.stackSize;
                                 } else {
                                    class38.field800[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var35 == 2702) {
                                 --var5;
                                 var15 = class38.field800[var5];
                                 WidgetNode var36 = (WidgetNode)Client.componentTable.method3775((long)var15);
                                 if(null != var36) {
                                    class38.field800[var5++] = 1;
                                 } else {
                                    class38.field800[var5++] = 0;
                                 }
                                 continue;
                              }

                              if(var35 == 2706) {
                                 class38.field800[var5++] = Client.widgetRoot;
                                 continue;
                              }
                           } else if(var35 < 2900) {
                              --var5;
                              var25 = class92.method2078(class38.field800[var5]);
                              if(var35 == 2800) {
                                 var16 = class38.field800;
                                 var27 = var5++;
                                 var19 = class11.method138(var25);
                                 var24 = var19 >> 11 & 63;
                                 var16[var27] = var24;
                                 continue;
                              }

                              if(var35 == 2801) {
                                 --var5;
                                 var26 = class38.field800[var5];
                                 --var26;
                                 if(null != var25.actions && var26 < var25.actions.length && null != var25.actions[var26]) {
                                    class38.chatboxSegments[var6++] = var25.actions[var26];
                                    continue;
                                 }

                                 class38.chatboxSegments[var6++] = "";
                                 continue;
                              }

                              if(var35 == 2802) {
                                 if(var25.name == null) {
                                    class38.chatboxSegments[var6++] = "";
                                 } else {
                                    class38.chatboxSegments[var6++] = var25.name;
                                 }
                                 continue;
                              }
                           } else if(var35 < 3200) {
                              if(var35 == 3100) {
                                 --var6;
                                 var79 = class38.chatboxSegments[var6];
                                 sendGameMessage(0, "", var79);
                                 continue;
                              }

                              if(var35 == 3101) {
                                 var5 -= 2;
                                 class31.method678(TextureProvider.localPlayer, class38.field800[var5], class38.field800[var5 + 1]);
                                 continue;
                              }

                              if(var35 == 3103) {
                                 class113.method2396();
                                 continue;
                              }

                              if(var35 == 3104) {
                                 --var6;
                                 var79 = class38.chatboxSegments[var6];
                                 var26 = 0;
                                 if(class153.method3142(var79)) {
                                    var26 = class8.method117(var79);
                                 }

                                 Client.field300.method2748(192);
                                 Client.field300.method2642(var26);
                                 continue;
                              }

                              if(var35 == 3105) {
                                 --var6;
                                 var79 = class38.chatboxSegments[var6];
                                 Client.field300.method2748(29);
                                 Client.field300.method2467(var79.length() + 1);
                                 Client.field300.method2472(var79);
                                 continue;
                              }

                              if(var35 == 3106) {
                                 --var6;
                                 var79 = class38.chatboxSegments[var6];
                                 Client.field300.method2748(232);
                                 Client.field300.method2467(var79.length() + 1);
                                 Client.field300.method2472(var79);
                                 continue;
                              }

                              if(var35 == 3107) {
                                 --var5;
                                 var15 = class38.field800[var5];
                                 --var6;
                                 var37 = class38.chatboxSegments[var6];
                                 class12.method159(var15, var37);
                                 continue;
                              }

                              if(var35 == 3108) {
                                 var5 -= 3;
                                 var15 = class38.field800[var5];
                                 var26 = class38.field800[var5 + 1];
                                 var27 = class38.field800[2 + var5];
                                 var42 = class92.method2078(var27);
                                 class5.method52(var42, var15, var26);
                                 continue;
                              }

                              if(var35 == 3109) {
                                 var5 -= 2;
                                 var15 = class38.field800[var5];
                                 var26 = class38.field800[var5 + 1];
                                 var38 = var49?class38.field792:class114.field1986;
                                 class5.method52(var38, var15, var26);
                                 continue;
                              }

                              if(var35 == 3110) {
                                 --var5;
                                 class18.field245 = class38.field800[var5] == 1;
                                 continue;
                              }

                              if(var35 == 3111) {
                                 class38.field800[var5++] = Sequence.field984.field123?1:0;
                                 continue;
                              }

                              if(var35 == 3112) {
                                 --var5;
                                 Sequence.field984.field123 = class38.field800[var5] == 1;
                                 class129.method2815();
                                 continue;
                              }

                              if(var35 == 3113) {
                                 --var6;
                                 var79 = class38.chatboxSegments[var6];
                                 --var5;
                                 var66 = class38.field800[var5] == 1;
                                 class11.method152(var79, var66, false);
                                 continue;
                              }

                              if(var35 == 3115) {
                                 --var5;
                                 var15 = class38.field800[var5];
                                 Client.field300.method2748(246);
                                 Client.field300.method2468(var15);
                                 continue;
                              }

                              if(var35 == 3116) {
                                 --var5;
                                 var15 = class38.field800[var5];
                                 var6 -= 2;
                                 var37 = class38.chatboxSegments[var6];
                                 var17 = class38.chatboxSegments[1 + var6];
                                 if(var37.length() <= 500 && var17.length() <= 500) {
                                    Client.field300.method2748(119);
                                    Client.field300.method2468(1 + class113.method2395(var37) + class113.method2395(var17));
                                    Client.field300.method2472(var37);
                                    Client.field300.method2472(var17);
                                    Client.field300.method2611(var15);
                                 }
                                 continue;
                              }
                           } else if(var35 < 3300) {
                              if(var35 == 3200) {
                                 var5 -= 3;
                                 var15 = class38.field800[var5];
                                 var26 = class38.field800[var5 + 1];
                                 var27 = class38.field800[var5 + 2];
                                 if(Client.field508 != 0 && var26 != 0 && Client.field510 < 50) {
                                    Client.field511[Client.field510] = var15;
                                    Client.field315[Client.field510] = var26;
                                    Client.field482[Client.field510] = var27;
                                    Client.field515[Client.field510] = null;
                                    Client.field514[Client.field510] = 0;
                                    ++Client.field510;
                                 }
                                 continue;
                              }

                              if(var35 == 3201) {
                                 --var5;
                                 class134.method2842(class38.field800[var5]);
                                 continue;
                              }

                              if(var35 == 3202) {
                                 var5 -= 2;
                                 var15 = class38.field800[var5];
                                 int var10000 = class38.field800[var5 + 1];
                                 if(Client.field424 != 0 && var15 != -1) {
                                    class50.method1001(Buffer.field2033, var15, 0, Client.field424, false);
                                    Client.field507 = true;
                                 }
                                 continue;
                              }
                           } else {
                              int var22;
                              if(var35 < 3400) {
                                 if(var35 == 3300) {
                                    class38.field800[var5++] = Client.gameCycle;
                                    continue;
                                 }

                                 if(var35 == 3301) {
                                    var5 -= 2;
                                    var15 = class38.field800[var5];
                                    var26 = class38.field800[1 + var5];
                                    class38.field800[var5++] = class117.method2419(var15, var26);
                                    continue;
                                 }

                                 if(var35 == 3302) {
                                    var5 -= 2;
                                    var15 = class38.field800[var5];
                                    var26 = class38.field800[1 + var5];
                                    class38.field800[var5++] = World.method657(var15, var26);
                                    continue;
                                 }

                                 XItemContainer var29;
                                 if(var35 == 3303) {
                                    var5 -= 2;
                                    var15 = class38.field800[var5];
                                    var26 = class38.field800[1 + var5];
                                    var40 = class38.field800;
                                    var24 = var5++;
                                    var29 = (XItemContainer)XItemContainer.itemContainers.method3775((long)var15);
                                    if(var29 == null) {
                                       var19 = 0;
                                    } else if(var26 == -1) {
                                       var19 = 0;
                                    } else {
                                       var21 = 0;

                                       for(var22 = 0; var22 < var29.stackSizes.length; ++var22) {
                                          if(var29.itemIds[var22] == var26) {
                                             var21 += var29.stackSizes[var22];
                                          }
                                       }

                                       var19 = var21;
                                    }

                                    var40[var24] = var19;
                                    continue;
                                 }

                                 if(var35 == 3304) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    class38.field800[var5++] = class24.method578(var15).field1127;
                                    continue;
                                 }

                                 if(var35 == 3305) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    class38.field800[var5++] = Client.boostedSkillLevels[var15];
                                    continue;
                                 }

                                 if(var35 == 3306) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    class38.field800[var5++] = Client.realSkillLevels[var15];
                                    continue;
                                 }

                                 if(var35 == 3307) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    class38.field800[var5++] = Client.skillExperiences[var15];
                                    continue;
                                 }

                                 if(var35 == 3308) {
                                    var15 = class59.plane;
                                    var26 = class23.baseX + (TextureProvider.localPlayer.x >> 7);
                                    var27 = class8.baseY + (TextureProvider.localPlayer.y >> 7);
                                    class38.field800[var5++] = (var15 << 28) + (var26 << 14) + var27;
                                    continue;
                                 }

                                 if(var35 == 3309) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    class38.field800[var5++] = var15 >> 14 & 16383;
                                    continue;
                                 }

                                 if(var35 == 3310) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    class38.field800[var5++] = var15 >> 28;
                                    continue;
                                 }

                                 if(var35 == 3311) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    class38.field800[var5++] = var15 & 16383;
                                    continue;
                                 }

                                 if(var35 == 3312) {
                                    class38.field800[var5++] = Client.isMembers?1:0;
                                    continue;
                                 }

                                 if(var35 == 3313) {
                                    var5 -= 2;
                                    var15 = '耀' + class38.field800[var5];
                                    var26 = class38.field800[1 + var5];
                                    class38.field800[var5++] = class117.method2419(var15, var26);
                                    continue;
                                 }

                                 if(var35 == 3314) {
                                    var5 -= 2;
                                    var15 = class38.field800[var5] + '耀';
                                    var26 = class38.field800[1 + var5];
                                    class38.field800[var5++] = World.method657(var15, var26);
                                    continue;
                                 }

                                 if(var35 == 3315) {
                                    var5 -= 2;
                                    var15 = '耀' + class38.field800[var5];
                                    var26 = class38.field800[1 + var5];
                                    var40 = class38.field800;
                                    var24 = var5++;
                                    var29 = (XItemContainer)XItemContainer.itemContainers.method3775((long)var15);
                                    if(null == var29) {
                                       var19 = 0;
                                    } else if(var26 == -1) {
                                       var19 = 0;
                                    } else {
                                       var21 = 0;

                                       for(var22 = 0; var22 < var29.stackSizes.length; ++var22) {
                                          if(var29.itemIds[var22] == var26) {
                                             var21 += var29.stackSizes[var22];
                                          }
                                       }

                                       var19 = var21;
                                    }

                                    var40[var24] = var19;
                                    continue;
                                 }

                                 if(var35 == 3316) {
                                    if(Client.field435 >= 2) {
                                       class38.field800[var5++] = Client.field435;
                                    } else {
                                       class38.field800[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var35 == 3317) {
                                    class38.field800[var5++] = Client.field290;
                                    continue;
                                 }

                                 if(var35 == 3318) {
                                    class38.field800[var5++] = Client.world;
                                    continue;
                                 }

                                 if(var35 == 3321) {
                                    class38.field800[var5++] = Client.energy;
                                    continue;
                                 }

                                 if(var35 == 3322) {
                                    class38.field800[var5++] = Client.weight;
                                    continue;
                                 }

                                 if(var35 == 3323) {
                                    if(Client.field437) {
                                       class38.field800[var5++] = 1;
                                    } else {
                                       class38.field800[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var35 == 3324) {
                                    class38.field800[var5++] = Client.flags;
                                    continue;
                                 }
                              } else if(var35 < 3500) {
                                 if(var35 == 3400) {
                                    var5 -= 2;
                                    var15 = class38.field800[var5];
                                    var26 = class38.field800[var5 + 1];
                                    class52 var41 = class138.method2869(var15);
                                    if(var41.field1104 != 115) {
                                       ;
                                    }

                                    for(var24 = 0; var24 < var41.field1117; ++var24) {
                                       if(var41.field1102[var24] == var26) {
                                          class38.chatboxSegments[var6++] = var41.field1110[var24];
                                          var41 = null;
                                          break;
                                       }
                                    }

                                    if(var41 != null) {
                                       class38.chatboxSegments[var6++] = var41.field1105;
                                    }
                                    continue;
                                 }

                                 if(var35 == 3408) {
                                    var5 -= 4;
                                    var15 = class38.field800[var5];
                                    var26 = class38.field800[1 + var5];
                                    var27 = class38.field800[2 + var5];
                                    var24 = class38.field800[var5 + 3];
                                    class52 var28 = class138.method2869(var27);
                                    if(var28.field1107 == var15 && var28.field1104 == var26) {
                                       for(var20 = 0; var20 < var28.field1117; ++var20) {
                                          if(var28.field1102[var20] == var24) {
                                             if(var26 == 115) {
                                                class38.chatboxSegments[var6++] = var28.field1110[var20];
                                             } else {
                                                class38.field800[var5++] = var28.field1109[var20];
                                             }

                                             var28 = null;
                                             break;
                                          }
                                       }

                                       if(null != var28) {
                                          if(var26 == 115) {
                                             class38.chatboxSegments[var6++] = var28.field1105;
                                          } else {
                                             class38.field800[var5++] = var28.field1106;
                                          }
                                       }
                                       continue;
                                    }

                                    if(var26 == 115) {
                                       class38.chatboxSegments[var6++] = "null";
                                    } else {
                                       class38.field800[var5++] = 0;
                                    }
                                    continue;
                                 }
                              } else if(var35 < 3700) {
                                 if(var35 == 3600) {
                                    if(Client.field536 == 0) {
                                       class38.field800[var5++] = -2;
                                    } else if(Client.field536 == 1) {
                                       class38.field800[var5++] = -1;
                                    } else {
                                       class38.field800[var5++] = Client.friendCount;
                                    }
                                    continue;
                                 }

                                 if(var35 == 3601) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    if(Client.field536 == 2 && var15 < Client.friendCount) {
                                       class38.chatboxSegments[var6++] = Client.friends[var15].name;
                                       class38.chatboxSegments[var6++] = Client.friends[var15].previousName;
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var35 == 3602) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    if(Client.field536 == 2 && var15 < Client.friendCount) {
                                       class38.field800[var5++] = Client.friends[var15].world;
                                       continue;
                                    }

                                    class38.field800[var5++] = 0;
                                    continue;
                                 }

                                 if(var35 == 3603) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    if(Client.field536 == 2 && var15 < Client.friendCount) {
                                       class38.field800[var5++] = Client.friends[var15].rank;
                                       continue;
                                    }

                                    class38.field800[var5++] = 0;
                                    continue;
                                 }

                                 if(var35 == 3604) {
                                    --var6;
                                    var79 = class38.chatboxSegments[var6];
                                    --var5;
                                    var26 = class38.field800[var5];
                                    Client.field300.method2748(244);
                                    Client.field300.method2467(class113.method2395(var79) + 1);
                                    Client.field300.method2467(var26);
                                    Client.field300.method2472(var79);
                                    continue;
                                 }

                                 if(var35 == 3605) {
                                    --var6;
                                    var79 = class38.chatboxSegments[var6];
                                    RSCanvas.method2928(var79);
                                    continue;
                                 }

                                 Friend var45;
                                 String var67;
                                 String var70;
                                 if(var35 == 3606) {
                                    --var6;
                                    var79 = class38.chatboxSegments[var6];
                                    if(null == var79) {
                                       continue;
                                    }

                                    var37 = XItemContainer.method178(var79, Client.field518);
                                    if(var37 == null) {
                                       continue;
                                    }

                                    var27 = 0;

                                    while(true) {
                                       if(var27 >= Client.friendCount) {
                                          continue label3538;
                                       }

                                       var45 = Client.friends[var27];
                                       var67 = var45.name;
                                       var70 = XItemContainer.method178(var67, Client.field518);
                                       if(class53.method1045(var79, var37, var67, var70)) {
                                          --Client.friendCount;

                                          for(var21 = var27; var21 < Client.friendCount; ++var21) {
                                             Client.friends[var21] = Client.friends[var21 + 1];
                                          }

                                          Client.field461 = Client.field453;
                                          Client.field300.method2748(196);
                                          Client.field300.method2467(class113.method2395(var79));
                                          Client.field300.method2472(var79);
                                          continue label3538;
                                       }

                                       ++var27;
                                    }
                                 }

                                 Ignore var43;
                                 if(var35 == 3607) {
                                    --var6;
                                    var79 = class38.chatboxSegments[var6];
                                    if(null == var79) {
                                       continue;
                                    }

                                    if((Client.ignoreCount < 100 || Client.field387 == 1) && Client.ignoreCount < 400) {
                                       var37 = XItemContainer.method178(var79, Client.field518);
                                       if(null == var37) {
                                          continue;
                                       }

                                       for(var27 = 0; var27 < Client.ignoreCount; ++var27) {
                                          var43 = Client.ignores[var27];
                                          var67 = XItemContainer.method178(var43.name, Client.field518);
                                          if(null != var67 && var67.equals(var37)) {
                                             sendGameMessage(31, "", var79 + " is already on your ignore list");
                                             continue label3538;
                                          }

                                          if(null != var43.previousName) {
                                             var70 = XItemContainer.method178(var43.previousName, Client.field518);
                                             if(null != var70 && var70.equals(var37)) {
                                                sendGameMessage(31, "", var79 + " is already on your ignore list");
                                                continue label3538;
                                             }
                                          }
                                       }

                                       for(var27 = 0; var27 < Client.friendCount; ++var27) {
                                          var45 = Client.friends[var27];
                                          var67 = XItemContainer.method178(var45.name, Client.field518);
                                          if(var67 != null && var67.equals(var37)) {
                                             sendGameMessage(31, "", "Please remove " + var79 + " from your friend list first");
                                             continue label3538;
                                          }

                                          if(var45.previousName != null) {
                                             var70 = XItemContainer.method178(var45.previousName, Client.field518);
                                             if(null != var70 && var70.equals(var37)) {
                                                sendGameMessage(31, "", "Please remove " + var79 + " from your friend list first");
                                                continue label3538;
                                             }
                                          }
                                       }

                                       if(XItemContainer.method178(TextureProvider.localPlayer.name, Client.field518).equals(var37)) {
                                          sendGameMessage(31, "", "You can\'t add yourself to your own ignore list");
                                       } else {
                                          Client.field300.method2748(143);
                                          Client.field300.method2467(class113.method2395(var79));
                                          Client.field300.method2472(var79);
                                       }
                                       continue;
                                    }

                                    sendGameMessage(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
                                    continue;
                                 }

                                 if(var35 == 3608) {
                                    --var6;
                                    var79 = class38.chatboxSegments[var6];
                                    if(var79 == null) {
                                       continue;
                                    }

                                    var37 = XItemContainer.method178(var79, Client.field518);
                                    if(var37 == null) {
                                       continue;
                                    }

                                    var27 = 0;

                                    while(true) {
                                       if(var27 >= Client.ignoreCount) {
                                          continue label3538;
                                       }

                                       var43 = Client.ignores[var27];
                                       var67 = var43.name;
                                       var70 = XItemContainer.method178(var67, Client.field518);
                                       if(class53.method1045(var79, var37, var67, var70)) {
                                          --Client.ignoreCount;

                                          for(var21 = var27; var21 < Client.ignoreCount; ++var21) {
                                             Client.ignores[var21] = Client.ignores[var21 + 1];
                                          }

                                          Client.field461 = Client.field453;
                                          Client.field300.method2748(127);
                                          Client.field300.method2467(class113.method2395(var79));
                                          Client.field300.method2472(var79);
                                          continue label3538;
                                       }

                                       ++var27;
                                    }
                                 }

                                 if(var35 == 3609) {
                                    --var6;
                                    var79 = class38.chatboxSegments[var6];
                                    class155[] var39 = new class155[]{class155.field2309, class155.field2305, class155.field2307, class155.field2306, class155.field2308};
                                    class155[] var46 = var39;

                                    for(var24 = 0; var24 < var46.length; ++var24) {
                                       class155 var69 = var46[var24];
                                       if(var69.field2304 != -1) {
                                          var22 = var69.field2304;
                                          String var30 = "<img=" + var22 + ">";
                                          if(var79.startsWith(var30)) {
                                             var79 = var79.substring(6 + Integer.toString(var69.field2304).length());
                                             break;
                                          }
                                       }
                                    }

                                    class38.field800[var5++] = ChatMessages.method222(var79, false)?1:0;
                                    continue;
                                 }

                                 if(var35 == 3611) {
                                    if(null != Client.field495) {
                                       class38.chatboxSegments[var6++] = Actor.method781(Client.field495);
                                    } else {
                                       class38.chatboxSegments[var6++] = "";
                                    }
                                    continue;
                                 }

                                 if(var35 == 3612) {
                                    if(Client.field495 != null) {
                                       class38.field800[var5++] = NPC.field764;
                                    } else {
                                       class38.field800[var5++] = 0;
                                    }
                                    continue;
                                 }

                                 if(var35 == 3613) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    if(Client.field495 != null && var15 < NPC.field764) {
                                       class38.chatboxSegments[var6++] = Frames.clanMembers[var15].username;
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var35 == 3614) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    if(null != Client.field495 && var15 < NPC.field764) {
                                       class38.field800[var5++] = Frames.clanMembers[var15].world;
                                       continue;
                                    }

                                    class38.field800[var5++] = 0;
                                    continue;
                                 }

                                 if(var35 == 3615) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    if(Client.field495 != null && var15 < NPC.field764) {
                                       class38.field800[var5++] = Frames.clanMembers[var15].rank;
                                       continue;
                                    }

                                    class38.field800[var5++] = 0;
                                    continue;
                                 }

                                 if(var35 == 3616) {
                                    class38.field800[var5++] = class45.field993;
                                    continue;
                                 }

                                 if(var35 == 3617) {
                                    --var6;
                                    var79 = class38.chatboxSegments[var6];
                                    class62.method1264(var79);
                                    continue;
                                 }

                                 if(var35 == 3618) {
                                    class38.field800[var5++] = class0.field11;
                                    continue;
                                 }

                                 if(var35 == 3619) {
                                    --var6;
                                    var79 = class38.chatboxSegments[var6];
                                    class166.method3218(var79);
                                    continue;
                                 }

                                 if(var35 == 3620) {
                                    Client.field300.method2748(150);
                                    Client.field300.method2467(0);
                                    continue;
                                 }

                                 if(var35 == 3621) {
                                    if(Client.field536 == 0) {
                                       class38.field800[var5++] = -1;
                                    } else {
                                       class38.field800[var5++] = Client.ignoreCount;
                                    }
                                    continue;
                                 }

                                 if(var35 == 3622) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    if(Client.field536 != 0 && var15 < Client.ignoreCount) {
                                       class38.chatboxSegments[var6++] = Client.ignores[var15].name;
                                       class38.chatboxSegments[var6++] = Client.ignores[var15].previousName;
                                       continue;
                                    }

                                    class38.chatboxSegments[var6++] = "";
                                    class38.chatboxSegments[var6++] = "";
                                    continue;
                                 }

                                 if(var35 == 3623) {
                                    label3302: {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       var17 = "<img=0>";
                                       if(!var79.startsWith(var17)) {
                                          var67 = "<img=1>";
                                          if(!var79.startsWith(var67)) {
                                             break label3302;
                                          }
                                       }

                                       var79 = var79.substring(7);
                                    }

                                    class38.field800[var5++] = class38.method764(var79)?1:0;
                                    continue;
                                 }

                                 if(var35 == 3624) {
                                    --var5;
                                    var15 = class38.field800[var5];
                                    if(null != Frames.clanMembers && var15 < NPC.field764 && Frames.clanMembers[var15].username.equalsIgnoreCase(TextureProvider.localPlayer.name)) {
                                       class38.field800[var5++] = 1;
                                       continue;
                                    }

                                    class38.field800[var5++] = 0;
                                    continue;
                                 }

                                 if(var35 == 3625) {
                                    if(Client.field496 != null) {
                                       class38.chatboxSegments[var6++] = Actor.method781(Client.field496);
                                    } else {
                                       class38.chatboxSegments[var6++] = "";
                                    }
                                    continue;
                                 }
                              } else {
                                 long var80;
                                 if(var35 < 4000) {
                                    if(var35 == 3903) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = Client.grandExchangeOffers[var15].method3989();
                                       continue;
                                    }

                                    if(var35 == 3904) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = Client.grandExchangeOffers[var15].itemId;
                                       continue;
                                    }

                                    if(var35 == 3905) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = Client.grandExchangeOffers[var15].price;
                                       continue;
                                    }

                                    if(var35 == 3906) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = Client.grandExchangeOffers[var15].totalQuantity;
                                       continue;
                                    }

                                    if(var35 == 3907) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = Client.grandExchangeOffers[var15].quantitySold;
                                       continue;
                                    }

                                    if(var35 == 3908) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = Client.grandExchangeOffers[var15].spent;
                                       continue;
                                    }

                                    if(var35 == 3910) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var26 = Client.grandExchangeOffers[var15].method3984();
                                       class38.field800[var5++] = var26 == 0?1:0;
                                       continue;
                                    }

                                    if(var35 == 3911) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var26 = Client.grandExchangeOffers[var15].method3984();
                                       class38.field800[var5++] = var26 == 2?1:0;
                                       continue;
                                    }

                                    if(var35 == 3912) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var26 = Client.grandExchangeOffers[var15].method3984();
                                       class38.field800[var5++] = var26 == 5?1:0;
                                       continue;
                                    }

                                    if(var35 == 3913) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var26 = Client.grandExchangeOffers[var15].method3984();
                                       class38.field800[var5++] = var26 == 1?1:0;
                                       continue;
                                    }

                                    boolean var64;
                                    if(var35 == 3914) {
                                       --var5;
                                       var64 = class38.field800[var5] == 1;
                                       if(class117.field2004 != null) {
                                          class117.field2004.method4011(class224.field3228, var64);
                                       }
                                       continue;
                                    }

                                    if(var35 == 3915) {
                                       --var5;
                                       var64 = class38.field800[var5] == 1;
                                       if(class117.field2004 != null) {
                                          class117.field2004.method4011(class224.field3227, var64);
                                       }
                                       continue;
                                    }

                                    if(var35 == 3916) {
                                       var5 -= 2;
                                       var64 = class38.field800[var5] == 1;
                                       var66 = class38.field800[var5 + 1] == 1;
                                       if(class117.field2004 != null) {
                                          class117.field2004.method4011(new class22(var66), var64);
                                       }
                                       continue;
                                    }

                                    if(var35 == 3917) {
                                       --var5;
                                       var64 = class38.field800[var5] == 1;
                                       if(class117.field2004 != null) {
                                          class117.field2004.method4011(class224.field3226, var64);
                                       }
                                       continue;
                                    }

                                    if(var35 == 3918) {
                                       --var5;
                                       var64 = class38.field800[var5] == 1;
                                       if(class117.field2004 != null) {
                                          class117.field2004.method4011(class224.field3225, var64);
                                       }
                                       continue;
                                    }

                                    if(var35 == 3919) {
                                       class38.field800[var5++] = class117.field2004 == null?0:class117.field2004.field3229.size();
                                       continue;
                                    }

                                    class217 var44;
                                    if(var35 == 3920) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var44 = (class217)class117.field2004.field3229.get(var15);
                                       class38.field800[var5++] = var44.field3199;
                                       continue;
                                    }

                                    if(var35 == 3921) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var44 = (class217)class117.field2004.field3229.get(var15);
                                       class38.chatboxSegments[var6++] = var44.method3944();
                                       continue;
                                    }

                                    if(var35 == 3922) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var44 = (class217)class117.field2004.field3229.get(var15);
                                       class38.chatboxSegments[var6++] = var44.method3948();
                                       continue;
                                    }

                                    if(var35 == 3923) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var44 = (class217)class117.field2004.field3229.get(var15);
                                       var80 = class113.method2394() - class33.field735 - var44.field3198;
                                       var19 = (int)(var80 / 3600000L);
                                       var20 = (int)((var80 - (long)(3600000 * var19)) / 60000L);
                                       var21 = (int)((var80 - (long)(var19 * 3600000) - (long)(var20 * '\uea60')) / 1000L);
                                       String var31 = var19 + ":" + var20 / 10 + var20 % 10 + ":" + var21 / 10 + var21 % 10;
                                       class38.chatboxSegments[var6++] = var31;
                                       continue;
                                    }

                                    if(var35 == 3924) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var44 = (class217)class117.field2004.field3229.get(var15);
                                       class38.field800[var5++] = var44.field3202.totalQuantity;
                                       continue;
                                    }

                                    if(var35 == 3925) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var44 = (class217)class117.field2004.field3229.get(var15);
                                       class38.field800[var5++] = var44.field3202.price;
                                       continue;
                                    }

                                    if(var35 == 3926) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var44 = (class217)class117.field2004.field3229.get(var15);
                                       class38.field800[var5++] = var44.field3202.itemId;
                                       continue;
                                    }
                                 } else if(var35 < 4100) {
                                    if(var35 == 4000) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[var5 + 1];
                                       class38.field800[var5++] = var26 + var15;
                                       continue;
                                    }

                                    if(var35 == 4001) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[1 + var5];
                                       class38.field800[var5++] = var15 - var26;
                                       continue;
                                    }

                                    if(var35 == 4002) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[var5 + 1];
                                       class38.field800[var5++] = var26 * var15;
                                       continue;
                                    }

                                    if(var35 == 4003) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[var5 + 1];
                                       class38.field800[var5++] = var15 / var26;
                                       continue;
                                    }

                                    if(var35 == 4004) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = (int)(Math.random() * (double)var15);
                                       continue;
                                    }

                                    if(var35 == 4005) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = (int)(Math.random() * (double)(1 + var15));
                                       continue;
                                    }

                                    if(var35 == 4006) {
                                       var5 -= 5;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[1 + var5];
                                       var27 = class38.field800[var5 + 2];
                                       var24 = class38.field800[var5 + 3];
                                       var19 = class38.field800[4 + var5];
                                       class38.field800[var5++] = (var19 - var27) * (var26 - var15) / (var24 - var27) + var15;
                                       continue;
                                    }

                                    if(var35 == 4007) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[var5 + 1];
                                       class38.field800[var5++] = var26 * var15 / 100 + var15;
                                       continue;
                                    }

                                    if(var35 == 4008) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[var5 + 1];
                                       class38.field800[var5++] = var15 | 1 << var26;
                                       continue;
                                    }

                                    if(var35 == 4009) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[var5 + 1];
                                       class38.field800[var5++] = var15 & -1 - (1 << var26);
                                       continue;
                                    }

                                    if(var35 == 4010) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[1 + var5];
                                       class38.field800[var5++] = (var15 & 1 << var26) != 0?1:0;
                                       continue;
                                    }

                                    if(var35 == 4011) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[var5 + 1];
                                       class38.field800[var5++] = var15 % var26;
                                       continue;
                                    }

                                    if(var35 == 4012) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[1 + var5];
                                       if(var15 == 0) {
                                          class38.field800[var5++] = 0;
                                       } else {
                                          class38.field800[var5++] = (int)Math.pow((double)var15, (double)var26);
                                       }
                                       continue;
                                    }

                                    if(var35 == 4013) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[1 + var5];
                                       if(var15 == 0) {
                                          class38.field800[var5++] = 0;
                                       } else if(var26 == 0) {
                                          class38.field800[var5++] = Integer.MAX_VALUE;
                                       } else {
                                          class38.field800[var5++] = (int)Math.pow((double)var15, 1.0D / (double)var26);
                                       }
                                       continue;
                                    }

                                    if(var35 == 4014) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[1 + var5];
                                       class38.field800[var5++] = var15 & var26;
                                       continue;
                                    }

                                    if(var35 == 4015) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[1 + var5];
                                       class38.field800[var5++] = var15 | var26;
                                       continue;
                                    }

                                    if(var35 == 4018) {
                                       var5 -= 3;
                                       long var81 = (long)class38.field800[var5];
                                       var80 = (long)class38.field800[var5 + 1];
                                       long var54 = (long)class38.field800[2 + var5];
                                       class38.field800[var5++] = (int)(var81 * var54 / var80);
                                       continue;
                                    }
                                 } else if(var35 < 4200) {
                                    if(var35 == 4100) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       --var5;
                                       var26 = class38.field800[var5];
                                       class38.chatboxSegments[var6++] = var79 + var26;
                                       continue;
                                    }

                                    if(var35 == 4101) {
                                       var6 -= 2;
                                       var79 = class38.chatboxSegments[var6];
                                       var37 = class38.chatboxSegments[1 + var6];
                                       class38.chatboxSegments[var6++] = var79 + var37;
                                       continue;
                                    }

                                    if(var35 == 4102) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       --var5;
                                       var26 = class38.field800[var5];
                                       class38.chatboxSegments[var6++] = var79 + RSCanvas.method2929(var26, true);
                                       continue;
                                    }

                                    if(var35 == 4103) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       class38.chatboxSegments[var6++] = var79.toLowerCase();
                                       continue;
                                    }

                                    if(var35 == 4104) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       long var85 = 86400000L * ((long)var15 + 11745L);
                                       class38.field782.setTime(new Date(var85));
                                       var24 = class38.field782.get(5);
                                       var19 = class38.field782.get(2);
                                       var20 = class38.field782.get(1);
                                       class38.chatboxSegments[var6++] = var24 + "-" + class38.field794[var19] + "-" + var20;
                                       continue;
                                    }

                                    if(var35 == 4105) {
                                       var6 -= 2;
                                       var79 = class38.chatboxSegments[var6];
                                       var37 = class38.chatboxSegments[var6 + 1];
                                       if(null != TextureProvider.localPlayer.composition && TextureProvider.localPlayer.composition.isFemale) {
                                          class38.chatboxSegments[var6++] = var37;
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = var79;
                                       continue;
                                    }

                                    if(var35 == 4106) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.chatboxSegments[var6++] = Integer.toString(var15);
                                       continue;
                                    }

                                    if(var35 == 4107) {
                                       var6 -= 2;
                                       int[] var84 = class38.field800;
                                       var26 = var5++;
                                       var24 = class130.method2820(class38.chatboxSegments[var6], class38.chatboxSegments[var6 + 1], Client.field346);
                                       if(var24 > 0) {
                                          var83 = 1;
                                       } else if(var24 < 0) {
                                          var83 = -1;
                                       } else {
                                          var83 = 0;
                                       }

                                       var84[var26] = var83;
                                       continue;
                                    }

                                    class227 var74;
                                    if(var35 == 4108) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var26 = class38.field800[var5];
                                       var27 = class38.field800[var5 + 1];
                                       var48 = Client.field299.method3272(var27, 0);
                                       var74 = new class227(var48);
                                       class38.field800[var5++] = var74.method4071(var79, var26);
                                       continue;
                                    }

                                    if(var35 == 4109) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var26 = class38.field800[var5];
                                       var27 = class38.field800[1 + var5];
                                       var48 = Client.field299.method3272(var27, 0);
                                       var74 = new class227(var48);
                                       class38.field800[var5++] = var74.method4029(var79, var26);
                                       continue;
                                    }

                                    if(var35 == 4110) {
                                       var6 -= 2;
                                       var79 = class38.chatboxSegments[var6];
                                       var37 = class38.chatboxSegments[1 + var6];
                                       --var5;
                                       if(class38.field800[var5] == 1) {
                                          class38.chatboxSegments[var6++] = var79;
                                       } else {
                                          class38.chatboxSegments[var6++] = var37;
                                       }
                                       continue;
                                    }

                                    if(var35 == 4111) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       class38.chatboxSegments[var6++] = class226.method4053(var79);
                                       continue;
                                    }

                                    if(var35 == 4112) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       --var5;
                                       var26 = class38.field800[var5];
                                       class38.chatboxSegments[var6++] = var79 + (char)var26;
                                       continue;
                                    }

                                    char var55;
                                    if(var35 == 4113) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var16 = class38.field800;
                                       var27 = var5++;
                                       var55 = (char)var15;
                                       if(var55 >= 32 && var55 <= 126) {
                                          var65 = true;
                                       } else if(var55 >= 160 && var55 <= 255) {
                                          var65 = true;
                                       } else if(var55 != 8364 && var55 != 338 && var55 != 8212 && var55 != 339 && var55 != 376) {
                                          var65 = false;
                                       } else {
                                          var65 = true;
                                       }

                                       var16[var27] = var65?1:0;
                                       continue;
                                    }

                                    if(var35 == 4114) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = class152.method3136((char)var15)?1:0;
                                       continue;
                                    }

                                    if(var35 == 4115) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var16 = class38.field800;
                                       var27 = var5++;
                                       var55 = (char)var15;
                                       var65 = var55 >= 65 && var55 <= 90 || var55 >= 97 && var55 <= 122;
                                       var16[var27] = var65?1:0;
                                       continue;
                                    }

                                    if(var35 == 4116) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = WallObject.method2077((char)var15)?1:0;
                                       continue;
                                    }

                                    if(var35 == 4117) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       if(var79 != null) {
                                          class38.field800[var5++] = var79.length();
                                       } else {
                                          class38.field800[var5++] = 0;
                                       }
                                       continue;
                                    }

                                    if(var35 == 4118) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var26 = class38.field800[var5];
                                       var27 = class38.field800[1 + var5];
                                       class38.chatboxSegments[var6++] = var79.substring(var26, var27);
                                       continue;
                                    }

                                    if(var35 == 4119) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       StringBuilder var53 = new StringBuilder(var79.length());
                                       var82 = false;

                                       for(var24 = 0; var24 < var79.length(); ++var24) {
                                          var55 = var79.charAt(var24);
                                          if(var55 == 60) {
                                             var82 = true;
                                          } else if(var55 == 62) {
                                             var82 = false;
                                          } else if(!var82) {
                                             var53.append(var55);
                                          }
                                       }

                                       class38.chatboxSegments[var6++] = var53.toString();
                                       continue;
                                    }

                                    if(var35 == 4120) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       --var5;
                                       var26 = class38.field800[var5];
                                       class38.field800[var5++] = var79.indexOf(var26);
                                       continue;
                                    }

                                    if(var35 == 4121) {
                                       var6 -= 2;
                                       var79 = class38.chatboxSegments[var6];
                                       var37 = class38.chatboxSegments[var6 + 1];
                                       --var5;
                                       var27 = class38.field800[var5];
                                       class38.field800[var5++] = var79.indexOf(var37, var27);
                                       continue;
                                    }
                                 } else if(var35 < 4300) {
                                    if(var35 == 4200) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.chatboxSegments[var6++] = class174.getItemDefinition(var15).name;
                                       continue;
                                    }

                                    ItemComposition var47;
                                    if(var35 == 4201) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[1 + var5];
                                       var47 = class174.getItemDefinition(var15);
                                       if(var26 >= 1 && var26 <= 5 && var47.groundActions[var26 - 1] != null) {
                                          class38.chatboxSegments[var6++] = var47.groundActions[var26 - 1];
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var35 == 4202) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[1 + var5];
                                       var47 = class174.getItemDefinition(var15);
                                       if(var26 >= 1 && var26 <= 5 && null != var47.inventoryActions[var26 - 1]) {
                                          class38.chatboxSegments[var6++] = var47.inventoryActions[var26 - 1];
                                          continue;
                                       }

                                       class38.chatboxSegments[var6++] = "";
                                       continue;
                                    }

                                    if(var35 == 4203) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = class174.getItemDefinition(var15).price;
                                       continue;
                                    }

                                    if(var35 == 4204) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = class174.getItemDefinition(var15).isStackable == 1?1:0;
                                       continue;
                                    }

                                    ItemComposition var56;
                                    if(var35 == 4205) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var56 = class174.getItemDefinition(var15);
                                       if(var56.field1181 == -1 && var56.note >= 0) {
                                          class38.field800[var5++] = var56.note;
                                          continue;
                                       }

                                       class38.field800[var5++] = var15;
                                       continue;
                                    }

                                    if(var35 == 4206) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var56 = class174.getItemDefinition(var15);
                                       if(var56.field1181 >= 0 && var56.note >= 0) {
                                          class38.field800[var5++] = var56.note;
                                          continue;
                                       }

                                       class38.field800[var5++] = var15;
                                       continue;
                                    }

                                    if(var35 == 4207) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = class174.getItemDefinition(var15).isMembers?1:0;
                                       continue;
                                    }

                                    if(var35 == 4208) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var56 = class174.getItemDefinition(var15);
                                       if(var56.field1154 == -1 && var56.field1191 >= 0) {
                                          class38.field800[var5++] = var56.field1191;
                                          continue;
                                       }

                                       class38.field800[var5++] = var15;
                                       continue;
                                    }

                                    if(var35 == 4209) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       var56 = class174.getItemDefinition(var15);
                                       if(var56.field1154 >= 0 && var56.field1191 >= 0) {
                                          class38.field800[var5++] = var56.field1191;
                                          continue;
                                       }

                                       class38.field800[var5++] = var15;
                                       continue;
                                    }

                                    if(var35 == 4210) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       --var5;
                                       var26 = class38.field800[var5];
                                       class79.method1680(var79, var26 == 1);
                                       class38.field800[var5++] = class1.field19;
                                       continue;
                                    }

                                    if(var35 == 4211) {
                                       if(null != class14.field197 && XItemContainer.field203 < class1.field19) {
                                          class38.field800[var5++] = class14.field197[++XItemContainer.field203 - 1] & '\uffff';
                                          continue;
                                       }

                                       class38.field800[var5++] = -1;
                                       continue;
                                    }

                                    if(var35 == 4212) {
                                       XItemContainer.field203 = 0;
                                       continue;
                                    }
                                 } else if(var35 < 5100) {
                                    if(var35 == 5000) {
                                       class38.field800[var5++] = Client.field537;
                                       continue;
                                    }

                                    if(var35 == 5001) {
                                       var5 -= 3;
                                       Client.field537 = class38.field800[var5];
                                       var26 = class38.field800[1 + var5];
                                       class133[] var52 = class85.method1888();
                                       var24 = 0;

                                       class133 var86;
                                       while(true) {
                                          if(var24 >= var52.length) {
                                             var86 = null;
                                             break;
                                          }

                                          class133 var76 = var52[var24];
                                          if(var26 == var76.field2098) {
                                             var86 = var76;
                                             break;
                                          }

                                          ++var24;
                                       }

                                       class212.field3169 = var86;
                                       if(class212.field3169 == null) {
                                          class212.field3169 = class133.field2095;
                                       }

                                       Client.field487 = class38.field800[2 + var5];
                                       Client.field300.method2748(134);
                                       Client.field300.method2467(Client.field537);
                                       Client.field300.method2467(class212.field3169.field2098);
                                       Client.field300.method2467(Client.field487);
                                       continue;
                                    }

                                    if(var35 == 5002) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       var5 -= 2;
                                       var26 = class38.field800[var5];
                                       var27 = class38.field800[var5 + 1];
                                       Client.field300.method2748(151);
                                       Client.field300.method2467(class113.method2395(var79) + 2);
                                       Client.field300.method2472(var79);
                                       Client.field300.method2467(var26 - 1);
                                       Client.field300.method2467(var27);
                                       continue;
                                    }

                                    if(var35 == 5003) {
                                       var5 -= 2;
                                       var15 = class38.field800[var5];
                                       var26 = class38.field800[var5 + 1];
                                       MessageNode var51 = class10.method127(var15, var26);
                                       if(null != var51) {
                                          class38.field800[var5++] = var51.id;
                                          class38.field800[var5++] = var51.tick;
                                          class38.chatboxSegments[var6++] = var51.name != null?var51.name:"";
                                          class38.chatboxSegments[var6++] = null != var51.sender?var51.sender:"";
                                          class38.chatboxSegments[var6++] = null != var51.value?var51.value:"";
                                       } else {
                                          class38.field800[var5++] = -1;
                                          class38.field800[var5++] = 0;
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(var35 == 5004) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       MessageNode var61 = (MessageNode)class11.field168.method3792((long)var15);
                                       if(null != var61) {
                                          class38.field800[var5++] = var61.type;
                                          class38.field800[var5++] = var61.tick;
                                          class38.chatboxSegments[var6++] = var61.name != null?var61.name:"";
                                          class38.chatboxSegments[var6++] = var61.sender != null?var61.sender:"";
                                          class38.chatboxSegments[var6++] = var61.value != null?var61.value:"";
                                       } else {
                                          class38.field800[var5++] = -1;
                                          class38.field800[var5++] = 0;
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                          class38.chatboxSegments[var6++] = "";
                                       }
                                       continue;
                                    }

                                    if(var35 == 5005) {
                                       if(null == class212.field3169) {
                                          class38.field800[var5++] = -1;
                                       } else {
                                          class38.field800[var5++] = class212.field3169.field2098;
                                       }
                                       continue;
                                    }

                                    if(var35 == 5008) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       --var5;
                                       var26 = class38.field800[var5];
                                       var17 = var79.toLowerCase();
                                       byte var72 = 0;
                                       if(var17.startsWith("yellow:")) {
                                          var72 = 0;
                                          var79 = var79.substring("yellow:".length());
                                       } else if(var17.startsWith("red:")) {
                                          var72 = 1;
                                          var79 = var79.substring("red:".length());
                                       } else if(var17.startsWith("green:")) {
                                          var72 = 2;
                                          var79 = var79.substring("green:".length());
                                       } else if(var17.startsWith("cyan:")) {
                                          var72 = 3;
                                          var79 = var79.substring("cyan:".length());
                                       } else if(var17.startsWith("purple:")) {
                                          var72 = 4;
                                          var79 = var79.substring("purple:".length());
                                       } else if(var17.startsWith("white:")) {
                                          var72 = 5;
                                          var79 = var79.substring("white:".length());
                                       } else if(var17.startsWith("flash1:")) {
                                          var72 = 6;
                                          var79 = var79.substring("flash1:".length());
                                       } else if(var17.startsWith("flash2:")) {
                                          var72 = 7;
                                          var79 = var79.substring("flash2:".length());
                                       } else if(var17.startsWith("flash3:")) {
                                          var72 = 8;
                                          var79 = var79.substring("flash3:".length());
                                       } else if(var17.startsWith("glow1:")) {
                                          var72 = 9;
                                          var79 = var79.substring("glow1:".length());
                                       } else if(var17.startsWith("glow2:")) {
                                          var72 = 10;
                                          var79 = var79.substring("glow2:".length());
                                       } else if(var17.startsWith("glow3:")) {
                                          var72 = 11;
                                          var79 = var79.substring("glow3:".length());
                                       } else if(Client.field346 != 0) {
                                          if(var17.startsWith("yellow:")) {
                                             var72 = 0;
                                             var79 = var79.substring("yellow:".length());
                                          } else if(var17.startsWith("red:")) {
                                             var72 = 1;
                                             var79 = var79.substring("red:".length());
                                          } else if(var17.startsWith("green:")) {
                                             var72 = 2;
                                             var79 = var79.substring("green:".length());
                                          } else if(var17.startsWith("cyan:")) {
                                             var72 = 3;
                                             var79 = var79.substring("cyan:".length());
                                          } else if(var17.startsWith("purple:")) {
                                             var72 = 4;
                                             var79 = var79.substring("purple:".length());
                                          } else if(var17.startsWith("white:")) {
                                             var72 = 5;
                                             var79 = var79.substring("white:".length());
                                          } else if(var17.startsWith("flash1:")) {
                                             var72 = 6;
                                             var79 = var79.substring("flash1:".length());
                                          } else if(var17.startsWith("flash2:")) {
                                             var72 = 7;
                                             var79 = var79.substring("flash2:".length());
                                          } else if(var17.startsWith("flash3:")) {
                                             var72 = 8;
                                             var79 = var79.substring("flash3:".length());
                                          } else if(var17.startsWith("glow1:")) {
                                             var72 = 9;
                                             var79 = var79.substring("glow1:".length());
                                          } else if(var17.startsWith("glow2:")) {
                                             var72 = 10;
                                             var79 = var79.substring("glow2:".length());
                                          } else if(var17.startsWith("glow3:")) {
                                             var72 = 11;
                                             var79 = var79.substring("glow3:".length());
                                          }
                                       }

                                       var17 = var79.toLowerCase();
                                       byte var59 = 0;
                                       if(var17.startsWith("wave:")) {
                                          var59 = 1;
                                          var79 = var79.substring("wave:".length());
                                       } else if(var17.startsWith("wave2:")) {
                                          var59 = 2;
                                          var79 = var79.substring("wave2:".length());
                                       } else if(var17.startsWith("shake:")) {
                                          var59 = 3;
                                          var79 = var79.substring("shake:".length());
                                       } else if(var17.startsWith("scroll:")) {
                                          var59 = 4;
                                          var79 = var79.substring("scroll:".length());
                                       } else if(var17.startsWith("slide:")) {
                                          var59 = 5;
                                          var79 = var79.substring("slide:".length());
                                       } else if(Client.field346 != 0) {
                                          if(var17.startsWith("wave:")) {
                                             var59 = 1;
                                             var79 = var79.substring("wave:".length());
                                          } else if(var17.startsWith("wave2:")) {
                                             var59 = 2;
                                             var79 = var79.substring("wave2:".length());
                                          } else if(var17.startsWith("shake:")) {
                                             var59 = 3;
                                             var79 = var79.substring("shake:".length());
                                          } else if(var17.startsWith("scroll:")) {
                                             var59 = 4;
                                             var79 = var79.substring("scroll:".length());
                                          } else if(var17.startsWith("slide:")) {
                                             var59 = 5;
                                             var79 = var79.substring("slide:".length());
                                          }
                                       }

                                       Client.field300.method2748(50);
                                       Client.field300.method2467(0);
                                       var20 = Client.field300.offset;
                                       Client.field300.method2467(var26);
                                       Client.field300.method2467(var72);
                                       Client.field300.method2467(var59);
                                       class22.method564(Client.field300, var79);
                                       Client.field300.method2478(Client.field300.offset - var20);
                                       continue;
                                    }

                                    if(var35 == 5009) {
                                       var6 -= 2;
                                       var79 = class38.chatboxSegments[var6];
                                       var37 = class38.chatboxSegments[var6 + 1];
                                       Client.field300.method2748(201);
                                       Client.field300.method2468(0);
                                       var27 = Client.field300.offset;
                                       Client.field300.method2472(var79);
                                       class22.method564(Client.field300, var37);
                                       Client.field300.method2632(Client.field300.offset - var27);
                                       continue;
                                    }

                                    if(var35 == 5015) {
                                       if(null != TextureProvider.localPlayer && null != TextureProvider.localPlayer.name) {
                                          var79 = TextureProvider.localPlayer.name;
                                       } else {
                                          var79 = "";
                                       }

                                       class38.chatboxSegments[var6++] = var79;
                                       continue;
                                    }

                                    if(var35 == 5016) {
                                       class38.field800[var5++] = Client.field487;
                                       continue;
                                    }

                                    if(var35 == 5017) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = XClanMember.method589(var15);
                                       continue;
                                    }

                                    if(var35 == 5018) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = ChatMessages.method195(var15);
                                       continue;
                                    }

                                    if(var35 == 5019) {
                                       --var5;
                                       var15 = class38.field800[var5];
                                       class38.field800[var5++] = class14.method173(var15);
                                       continue;
                                    }

                                    if(var35 == 5020) {
                                       --var6;
                                       var79 = class38.chatboxSegments[var6];
                                       if(var79.equalsIgnoreCase("toggleroof")) {
                                          Sequence.field984.field123 = !Sequence.field984.field123;
                                          class129.method2815();
                                          if(Sequence.field984.field123) {
                                             sendGameMessage(99, "", "Roofs are now all hidden");
                                          } else {
                                             sendGameMessage(99, "", "Roofs will only be removed selectively");
                                          }
                                       }

                                       if(var79.equalsIgnoreCase("displayfps")) {
                                          Client.field282 = !Client.field282;
                                       }

                                       if(Client.field435 >= 2) {
                                          if(var79.equalsIgnoreCase("fpson")) {
                                             Client.field282 = true;
                                          }

                                          if(var79.equalsIgnoreCase("fpsoff")) {
                                             Client.field282 = false;
                                          }

                                          if(var79.equalsIgnoreCase("gc")) {
                                             System.gc();
                                          }

                                          if(var79.equalsIgnoreCase("clientdrop")) {
                                             if(Client.field548 > 0) {
                                                class152.method3138();
                                             } else {
                                                class112.setGameState(40);
                                                class75.field1394 = class32.field695;
                                                class32.field695 = null;
                                             }
                                          }

                                          if(var79.equalsIgnoreCase("errortest") && Client.field267 == 2) {
                                             throw new RuntimeException();
                                          }
                                       }

                                       Client.field300.method2748(34);
                                       Client.field300.method2467(var79.length() + 1);
                                       Client.field300.method2472(var79);
                                       continue;
                                    }

                                    if(var35 == 5021) {
                                       --var6;
                                       Client.field488 = class38.chatboxSegments[var6].toLowerCase().trim();
                                       continue;
                                    }

                                    if(var35 == 5022) {
                                       class38.chatboxSegments[var6++] = Client.field488;
                                       continue;
                                    }
                                 }
                              }
                           }
                        } else {
                           if(var35 >= 2000) {
                              var35 -= 1000;
                              --var5;
                              var25 = class92.method2078(class38.field800[var5]);
                           } else {
                              var25 = var49?class38.field792:class114.field1986;
                           }

                           if(var35 == 1300) {
                              --var5;
                              var26 = class38.field800[var5] - 1;
                              if(var26 >= 0 && var26 <= 9) {
                                 --var6;
                                 var25.method3437(var26, class38.chatboxSegments[var6]);
                                 continue;
                              }

                              --var6;
                              continue;
                           }

                           if(var35 == 1301) {
                              var5 -= 2;
                              var26 = class38.field800[var5];
                              var27 = class38.field800[var5 + 1];
                              var25.parent = class163.method3174(var26, var27);
                              continue;
                           }

                           if(var35 == 1302) {
                              --var5;
                              var25.field2876 = class38.field800[var5] == 1;
                              continue;
                           }

                           if(var35 == 1303) {
                              --var5;
                              var25.field2874 = class38.field800[var5];
                              continue;
                           }

                           if(var35 == 1304) {
                              --var5;
                              var25.field2909 = class38.field800[var5];
                              continue;
                           }

                           if(var35 == 1305) {
                              --var6;
                              var25.name = class38.chatboxSegments[var6];
                              continue;
                           }

                           if(var35 == 1306) {
                              --var6;
                              var25.field2877 = class38.chatboxSegments[var6];
                              continue;
                           }

                           if(var35 == 1307) {
                              var25.actions = null;
                              continue;
                           }
                        }
                     } else {
                        if(var35 >= 2000) {
                           var35 -= 1000;
                           --var5;
                           var25 = class92.method2078(class38.field800[var5]);
                        } else {
                           var25 = var49?class38.field792:class114.field1986;
                        }

                        class32.method685(var25);
                        if(var35 == 1200 || var35 == 1205 || var35 == 1212) {
                           var5 -= 2;
                           var26 = class38.field800[var5];
                           var27 = class38.field800[1 + var5];
                           var25.item = var26;
                           var25.stackSize = var27;
                           ItemComposition var18 = class174.getItemDefinition(var26);
                           var25.rotationX = var18.field1183;
                           var25.rotationZ = var18.field1157;
                           var25.rotationY = var18.field1159;
                           var25.field2787 = var18.field1155;
                           var25.field2847 = var18.field1186;
                           var25.field2852 = var18.field1151;
                           if(var35 == 1205) {
                              var25.field2856 = 0;
                           } else if(var35 == 1212 | var18.isStackable == 1) {
                              var25.field2856 = 1;
                           } else {
                              var25.field2856 = 2;
                           }

                           if(var25.field2853 > 0) {
                              var25.field2852 = var25.field2852 * 32 / var25.field2853;
                           } else if(var25.field2805 > 0) {
                              var25.field2852 = var25.field2852 * 32 / var25.field2805;
                           }
                           continue;
                        }

                        if(var35 == 1201) {
                           var25.modelType = 2;
                           --var5;
                           var25.modelId = class38.field800[var5];
                           continue;
                        }

                        if(var35 == 1202) {
                           var25.modelType = 3;
                           var25.modelId = TextureProvider.localPlayer.composition.method3495();
                           continue;
                        }
                     }
                  }
               }

               if(var35 < 5400) {
                  if(var35 == 5306) {
                     class38.field800[var5++] = class158.method3158();
                     continue;
                  }

                  if(var35 == 5307) {
                     --var5;
                     var15 = class38.field800[var5];
                     if(var15 == 1 || var15 == 2) {
                        class23.method576(var15);
                     }
                     continue;
                  }

                  if(var35 == 5308) {
                     class38.field800[var5++] = Sequence.field984.field125;
                     continue;
                  }

                  if(var35 == 5309) {
                     --var5;
                     var15 = class38.field800[var5];
                     if(var15 == 1 || var15 == 2) {
                        Sequence.field984.field125 = var15;
                        class129.method2815();
                     }
                     continue;
                  }
               }

               if(var35 < 5600) {
                  if(var35 == 5504) {
                     var5 -= 2;
                     var15 = class38.field800[var5];
                     var26 = class38.field800[1 + var5];
                     if(!Client.field516) {
                        Client.field353 = var15;
                        Client.mapAngle = var26;
                     }
                     continue;
                  }

                  if(var35 == 5505) {
                     class38.field800[var5++] = Client.field353;
                     continue;
                  }

                  if(var35 == 5506) {
                     class38.field800[var5++] = Client.mapAngle;
                     continue;
                  }

                  if(var35 == 5530) {
                     --var5;
                     var15 = class38.field800[var5];
                     if(var15 < 0) {
                        var15 = 0;
                     }

                     Client.field359 = var15;
                     continue;
                  }

                  if(var35 == 5531) {
                     class38.field800[var5++] = Client.field359;
                     continue;
                  }
               }

               if(var35 < 5700 && var35 == 5630) {
                  Client.field548 = 250;
               } else {
                  if(var35 < 6300) {
                     if(var35 == 6200) {
                        var5 -= 2;
                        Client.field522 = (short)class38.field800[var5];
                        if(Client.field522 <= 0) {
                           Client.field522 = 256;
                        }

                        Client.field523 = (short)class38.field800[var5 + 1];
                        if(Client.field523 <= 0) {
                           Client.field523 = 205;
                        }
                        continue;
                     }

                     if(var35 == 6201) {
                        var5 -= 2;
                        Client.field524 = (short)class38.field800[var5];
                        if(Client.field524 <= 0) {
                           Client.field524 = 256;
                        }

                        Client.field525 = (short)class38.field800[var5 + 1];
                        if(Client.field525 <= 0) {
                           Client.field525 = 320;
                        }
                        continue;
                     }

                     if(var35 == 6202) {
                        var5 -= 4;
                        Client.field302 = (short)class38.field800[var5];
                        if(Client.field302 <= 0) {
                           Client.field302 = 1;
                        }

                        Client.field520 = (short)class38.field800[1 + var5];
                        if(Client.field520 <= 0) {
                           Client.field520 = 32767;
                        } else if(Client.field520 < Client.field302) {
                           Client.field520 = Client.field302;
                        }

                        Client.field528 = (short)class38.field800[var5 + 2];
                        if(Client.field528 <= 0) {
                           Client.field528 = 1;
                        }

                        Client.field529 = (short)class38.field800[var5 + 3];
                        if(Client.field529 <= 0) {
                           Client.field529 = 32767;
                        } else if(Client.field529 < Client.field528) {
                           Client.field529 = Client.field528;
                        }
                        continue;
                     }

                     if(var35 == 6203) {
                        if(null != Client.field440) {
                           class75.method1585(0, 0, Client.field440.width, Client.field440.height, false);
                           class38.field800[var5++] = Client.camera2;
                           class38.field800[var5++] = Client.camera3;
                        } else {
                           class38.field800[var5++] = -1;
                           class38.field800[var5++] = -1;
                        }
                        continue;
                     }

                     if(var35 == 6204) {
                        class38.field800[var5++] = Client.field524;
                        class38.field800[var5++] = Client.field525;
                        continue;
                     }

                     if(var35 == 6205) {
                        class38.field800[var5++] = Client.field522;
                        class38.field800[var5++] = Client.field523;
                        continue;
                     }
                  }

                  if(var35 < 6600) {
                     if(var35 == 6500) {
                        class38.field800[var5++] = Item.loadWorlds()?1:0;
                        continue;
                     }

                     World var87;
                     if(var35 == 6501) {
                        World.field641 = 0;
                        var87 = Client.method392();
                        if(var87 != null) {
                           class38.field800[var5++] = var87.id;
                           class38.field800[var5++] = var87.mask;
                           class38.chatboxSegments[var6++] = var87.activity;
                           class38.field800[var5++] = var87.location;
                           class38.field800[var5++] = var87.playerCount;
                           class38.chatboxSegments[var6++] = var87.address;
                        } else {
                           class38.field800[var5++] = -1;
                           class38.field800[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field800[var5++] = 0;
                           class38.field800[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var35 == 6502) {
                        var87 = Client.method392();
                        if(var87 != null) {
                           class38.field800[var5++] = var87.id;
                           class38.field800[var5++] = var87.mask;
                           class38.chatboxSegments[var6++] = var87.activity;
                           class38.field800[var5++] = var87.location;
                           class38.field800[var5++] = var87.playerCount;
                           class38.chatboxSegments[var6++] = var87.address;
                        } else {
                           class38.field800[var5++] = -1;
                           class38.field800[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field800[var5++] = 0;
                           class38.field800[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     World var68;
                     if(var35 == 6506) {
                        --var5;
                        var15 = class38.field800[var5];
                        var68 = null;

                        for(var27 = 0; var27 < World.field630; ++var27) {
                           if(var15 == World.worldList[var27].id) {
                              var68 = World.worldList[var27];
                              break;
                           }
                        }

                        if(var68 != null) {
                           class38.field800[var5++] = var68.id;
                           class38.field800[var5++] = var68.mask;
                           class38.chatboxSegments[var6++] = var68.activity;
                           class38.field800[var5++] = var68.location;
                           class38.field800[var5++] = var68.playerCount;
                           class38.chatboxSegments[var6++] = var68.address;
                        } else {
                           class38.field800[var5++] = -1;
                           class38.field800[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                           class38.field800[var5++] = 0;
                           class38.field800[var5++] = 0;
                           class38.chatboxSegments[var6++] = "";
                        }
                        continue;
                     }

                     if(var35 == 6507) {
                        var5 -= 4;
                        var15 = class38.field800[var5];
                        var66 = class38.field800[var5 + 1] == 1;
                        var27 = class38.field800[var5 + 2];
                        var65 = class38.field800[3 + var5] == 1;
                        ItemComposition.method1077(var15, var66, var27, var65);
                        continue;
                     }

                     if(var35 == 6511) {
                        --var5;
                        var15 = class38.field800[var5];
                        if(var15 >= 0 && var15 < World.field630) {
                           var68 = World.worldList[var15];
                           class38.field800[var5++] = var68.id;
                           class38.field800[var5++] = var68.mask;
                           class38.chatboxSegments[var6++] = var68.activity;
                           class38.field800[var5++] = var68.location;
                           class38.field800[var5++] = var68.playerCount;
                           class38.chatboxSegments[var6++] = var68.address;
                           continue;
                        }

                        class38.field800[var5++] = -1;
                        class38.field800[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        class38.field800[var5++] = 0;
                        class38.field800[var5++] = 0;
                        class38.chatboxSegments[var6++] = "";
                        continue;
                     }
                  }

                  throw new IllegalStateException();
               }
            }
         } catch (Exception var34) {
            StringBuilder var33 = new StringBuilder(30);
            var33.append("").append(var4.hash).append(" ");

            for(var13 = class38.field790 - 1; var13 >= 0; --var13) {
               var33.append("").append(class38.field791[var13].field198.hash).append(" ");
            }

            var33.append("").append(var10);
            class144.method2970(var33.toString(), var34);
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1663012813"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class49.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-1360109946"
   )
   static final boolean method37(Widget var0) {
      if(var0.field2911 == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2911.length; ++var1) {
            int var2 = Projectile.method87(var0, var1);
            int var3 = var0.field2912[var1];
            if(var0.field2911[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2911[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2911[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "2082131132"
   )
   static final void method38(class125 var0) {
      for(int var1 = 0; var1 < class34.field750; ++var1) {
         int var2 = class34.field744[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.method2481();
         if((var4 & 16) != 0) {
            var4 += var0.method2481() << 8;
         }

         byte var5 = -1;
         int var6;
         if((var4 & 32) != 0) {
            var6 = var0.method2481();
            byte[] var7 = new byte[var6];
            Buffer var8 = new Buffer(var7);
            var0.method2492(var7, 0, var6);
            class34.field742[var2] = var8;
            var3.method7(var8);
         }

         int var18;
         if((var4 & 128) != 0) {
            var6 = var0.method2668();
            if(var6 == '\uffff') {
               var6 = -1;
            }

            var18 = var0.method2481();
            class31.method678(var3, var6, var18);
         }

         if((var4 & 1) != 0) {
            var3.interacting = var0.method2668();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 2) != 0) {
            var3.overhead = var0.method2503();
            if(var3.overhead.charAt(0) == 126) {
               var3.overhead = var3.overhead.substring(1);
               sendGameMessage(2, var3.name, var3.overhead);
            } else if(var3 == TextureProvider.localPlayer) {
               sendGameMessage(2, var3.name, var3.overhead);
            }

            var3.field815 = false;
            var3.field818 = 0;
            var3.field819 = 0;
            var3.field817 = 150;
         }

         int var10;
         int var11;
         if((var4 & 8) != 0) {
            var6 = var0.method2481();
            int var9;
            int var12;
            int var19;
            if(var6 > 0) {
               for(var18 = 0; var18 < var6; ++var18) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var19 = var0.method2654();
                  if(var19 == 32767) {
                     var19 = var0.method2654();
                     var10 = var0.method2654();
                     var9 = var0.method2654();
                     var11 = var0.method2654();
                  } else if(var19 != 32766) {
                     var10 = var0.method2654();
                  } else {
                     var19 = -1;
                  }

                  var12 = var0.method2654();
                  var3.method770(var19, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var18 = var0.method2481();
            if(var18 > 0) {
               for(var19 = 0; var19 < var18; ++var19) {
                  var9 = var0.method2654();
                  var10 = var0.method2654();
                  if(var10 != 32767) {
                     var11 = var0.method2654();
                     var12 = var0.method2481();
                     int var20 = var10 > 0?var0.method2481():var12;
                     var3.method779(var9, Client.gameCycle, var10, var11, var12, var20);
                  } else {
                     var3.method772(var9);
                  }
               }
            }
         }

         if((var4 & 4) != 0) {
            var3.field850 = var0.method2668();
            if(var3.field855 == 0) {
               var3.field852 = var3.field850;
               var3.field850 = -1;
            }
         }

         if((var4 & 64) != 0) {
            var6 = var0.method2668();
            class155[] var21 = new class155[]{class155.field2309, class155.field2305, class155.field2307, class155.field2306, class155.field2308};
            class155 var22 = (class155)SecondaryBufferProvider.method1646(var21, var0.method2481());
            boolean var24 = var0.method2481() == 1;
            var10 = var0.method2481();
            var11 = var0.offset;
            if(null != var3.name && null != var3.composition) {
               boolean var25 = false;
               if(var22.field2312 && class38.method764(var3.name)) {
                  var25 = true;
               }

               if(!var25 && Client.field426 == 0 && !var3.field50) {
                  class34.field751.offset = 0;
                  var0.method2492(class34.field751.payload, 0, var10);
                  class34.field751.offset = 0;
                  String var13 = class226.method4053(class181.method3473(class162.method3165(class34.field751)));
                  var3.overhead = var13.trim();
                  var3.field818 = var6 >> 8;
                  var3.field819 = var6 & 255;
                  var3.field817 = 150;
                  var3.field815 = var24;
                  var3.inSequence = TextureProvider.localPlayer != var3 && var22.field2312 && Client.field488 != "" && var13.toLowerCase().indexOf(Client.field488) == -1;
                  int var14;
                  if(var22.field2314) {
                     var14 = var24?91:1;
                  } else {
                     var14 = var24?90:2;
                  }

                  if(var22.field2304 != -1) {
                     int var17 = var22.field2304;
                     String var16 = "<img=" + var17 + ">";
                     sendGameMessage(var14, var16 + var3.name, var13);
                  } else {
                     sendGameMessage(var14, var3.name, var13);
                  }
               }
            }

            var0.offset = var10 + var11;
         }

         if((var4 & 512) != 0) {
            var3.graphic = var0.method2668();
            var6 = var0.method2526();
            var3.field839 = var6 >> 16;
            var3.field853 = Client.gameCycle + (var6 & '\uffff');
            var3.field811 = 0;
            var3.field840 = 0;
            if(var3.field853 > Client.gameCycle) {
               var3.field811 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 256) != 0) {
            var3.field843 = var0.method2601();
            var3.field845 = var0.method2601();
            var3.field844 = var0.method2601();
            var3.field846 = var0.method2601();
            var3.field847 = var0.method2668() + Client.gameCycle;
            var3.field848 = var0.method2668() + Client.gameCycle;
            var3.field849 = var0.method2668();
            if(var3.field46) {
               var3.field843 += var3.field53;
               var3.field845 += var3.field51;
               var3.field844 += var3.field53;
               var3.field846 += var3.field51;
               var3.field855 = 0;
            } else {
               var3.field843 += var3.pathX[0];
               var3.field845 += var3.pathY[0];
               var3.field844 += var3.pathX[0];
               var3.field846 += var3.pathY[0];
               var3.field855 = 1;
            }

            var3.field821 = 0;
         }

         if((var4 & 2048) != 0) {
            class34.field741[var2] = var0.method2601();
         }

         if((var4 & 1024) != 0) {
            var5 = var0.method2601();
         }

         if((var4 & 4096) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.actions[var6] = var0.method2503();
            }
         }

         if(var3.field46) {
            if(var5 == 127) {
               var3.method12(var3.field53, var3.field51);
            } else {
               byte var23;
               if(var5 != -1) {
                  var23 = var5;
               } else {
                  var23 = class34.field741[var2];
               }

               var3.method11(var3.field53, var3.field51, var23);
            }
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-161296439"
   )
   static void method39() {
      Client.field300.method2748(207);
      Client.field300.method2467(class158.method3158());
      Client.field300.method2468(class50.field1069);
      Client.field300.method2468(class139.field2143);
   }
}
