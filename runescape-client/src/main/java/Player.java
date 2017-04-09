import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1668488153
   )
   int field255;
   @ObfuscatedName("i")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("p")
   @Export("model")
   Model model;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 153289477
   )
   @Export("overheadIcon")
   int overheadIcon = -1;
   @ObfuscatedName("c")
   boolean field259;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 827713609
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -24883195
   )
   int field261;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -499893015
   )
   int field262;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 29116993
   )
   int field263;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -482101331
   )
   int field264;
   @ObfuscatedName("b")
   boolean field265;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -89161053
   )
   int field266;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1314368013
   )
   int field267;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1173996191
   )
   int field268;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1435253843
   )
   int field269;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 261143079
   )
   int field270;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -472236533
   )
   int field271;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1175372849
   )
   int field272;
   @ObfuscatedName("x")
   boolean field273;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -751368409
   )
   @Export("skullIcon")
   int skullIcon = -1;
   @ObfuscatedName("o")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1805848485
   )
   int field276;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -488432547
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("f")
   @Export("name")
   String name;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1938161267
   )
   @Export("team")
   int team;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2010249769
   )
   int field280;
   @ObfuscatedName("cw")
   static Font field282;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "211343709"
   )
   final void method206(Buffer var1) {
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
               int var8 = class196.getItemDefinition(var4[var7] - 512).field2998;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var5 = 0; var5 < 5; ++var5) {
         var6 = var1.readUnsignedByte();
         if(var6 < 0 || var6 >= PlayerComposition.field2191[var5].length) {
            var6 = 0;
         }

         var9[var5] = var6;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field633 = var1.readUnsignedShort();
      if(super.field633 == '\uffff') {
         super.field633 = -1;
      }

      super.field625 = super.field633;
      super.field626 = var1.readUnsignedShort();
      if(super.field626 == '\uffff') {
         super.field626 = -1;
      }

      super.field627 = var1.readUnsignedShort();
      if(super.field627 == '\uffff') {
         super.field627 = -1;
      }

      super.field645 = var1.readUnsignedShort();
      if(super.field645 == '\uffff') {
         super.field645 = -1;
      }

      super.field629 = var1.readUnsignedShort();
      if(super.field629 == '\uffff') {
         super.field629 = -1;
      }

      super.field630 = var1.readUnsignedShort();
      if(super.field630 == '\uffff') {
         super.field630 = -1;
      }

      this.name = var1.readString();
      if(Projectile.localPlayer == this) {
         class101.field1675 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field261 = var1.readUnsignedShort();
      this.field265 = var1.readUnsignedByte() == 1;
      if(Client.field580 == 0 && Client.field470 >= 2) {
         this.field265 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3231(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "62"
   )
   int method207() {
      return this.composition != null && this.composition.field2187 != -1?class15.getNpcDefinition(this.composition.field2187).field3011:1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?Friend.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field273 && (super.idlePoseAnimation != super.poseAnimation || var1 == null)?Friend.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3206(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1643();
            super.field676 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field273 && super.graphic != -1 && super.field678 != -1) {
               var4 = class145.method2800(super.graphic).method3517(super.field678);
               if(var4 != null) {
                  var4.method1597(0, -super.field659, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field273 && this.model != null) {
               if(Client.gameCycle >= this.field264) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field264) {
                  var4 = this.model;
                  var4.method1597(this.field280 - super.x, this.field268 - this.field262, this.field267 - super.y);
                  if(super.field669 == 512) {
                     var4.method1656();
                     var4.method1656();
                     var4.method1656();
                  } else if(super.field669 == 1024) {
                     var4.method1656();
                     var4.method1656();
                  } else if(super.field669 == 1536) {
                     var4.method1656();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field669 == 512) {
                     var4.method1656();
                  } else if(super.field669 == 1024) {
                     var4.method1656();
                     var4.method1656();
                  } else if(super.field669 == 1536) {
                     var4.method1656();
                     var4.method1656();
                     var4.method1656();
                  }

                  var4.method1597(super.x - this.field280, this.field262 - this.field268, super.y - this.field267);
               }
            }

            var3.field1409 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1332600795"
   )
   final void method209(int var1, int var2, byte var3) {
      if(super.animation != -1 && Friend.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field646 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               class47.method920(this, var1, var2, (byte)2);
            }

            this.method211(var1, var2, var3);
         } else {
            this.method216(var1, var2);
         }
      } else {
         this.method216(var1, var2);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "-1"
   )
   final void method211(int var1, int var2, byte var3) {
      if(super.field672 < 9) {
         ++super.field672;
      }

      for(int var4 = super.field672; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field675[var4] = super.field675[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field675[0] = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1006538820"
   )
   final boolean vmethod738() {
      return this.composition != null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1787928484"
   )
   void method216(int var1, int var2) {
      super.field672 = 0;
      super.field655 = 0;
      super.field651 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method207();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field261 = 0;
      this.totalLevel = 0;
      this.field264 = 0;
      this.field273 = false;
      this.team = 0;
      this.field265 = false;
      this.field259 = false;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1958202158"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class216.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(CIB)I",
      garbageValue = "12"
   )
   static int method227(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "477944846"
   )
   static final void method233(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               Ignore.field219[0][var5][var4] = 127;
               if(var5 == var0 && var5 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1506446579"
   )
   static int method235(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = FaceNormal.method1932(class32.field743[--class30.field713]);
      } else {
         var3 = var2?class154.field2123:class32.field746;
      }

      String var4 = class32.scriptStringStack[--class32.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var6 = class32.field743[--class30.field713];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class32.field743[--class30.field713]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var8[var7] = class32.scriptStringStack[--class32.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class32.field743[--class30.field713]);
         }
      }

      var7 = class32.field743[--class30.field713];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2337 = var8;
      } else if(var0 == 1401) {
         var3.field2304 = var8;
      } else if(var0 == 1402) {
         var3.field2303 = var8;
      } else if(var0 == 1403) {
         var3.field2300 = var8;
      } else if(var0 == 1404) {
         var3.field2248 = var8;
      } else if(var0 == 1405) {
         var3.field2308 = var8;
      } else if(var0 == 1406) {
         var3.field2311 = var8;
      } else if(var0 == 1407) {
         var3.field2312 = var8;
         var3.field2313 = var5;
      } else if(var0 == 1408) {
         var3.field2318 = var8;
      } else if(var0 == 1409) {
         var3.field2319 = var8;
      } else if(var0 == 1410) {
         var3.field2310 = var8;
      } else if(var0 == 1411) {
         var3.field2287 = var8;
      } else if(var0 == 1412) {
         var3.field2306 = var8;
      } else if(var0 == 1414) {
         var3.field2314 = var8;
         var3.field2315 = var5;
      } else if(var0 == 1415) {
         var3.field2316 = var8;
         var3.field2282 = var5;
      } else if(var0 == 1416) {
         var3.field2350 = var8;
      } else if(var0 == 1417) {
         var3.field2262 = var8;
      } else if(var0 == 1418) {
         var3.field2321 = var8;
      } else if(var0 == 1419) {
         var3.field2322 = var8;
      } else if(var0 == 1420) {
         var3.field2290 = var8;
      } else if(var0 == 1421) {
         var3.field2324 = var8;
      } else if(var0 == 1422) {
         var3.field2284 = var8;
      } else if(var0 == 1423) {
         var3.field2326 = var8;
      } else if(var0 == 1424) {
         var3.field2234 = var8;
      } else if(var0 == 1425) {
         var3.field2329 = var8;
      } else if(var0 == 1426) {
         var3.field2330 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2341 = var8;
      }

      var3.field2299 = true;
      return 1;
   }
}
