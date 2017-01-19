import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1707590741
   )
   int field256;
   @ObfuscatedName("t")
   boolean field257;
   @ObfuscatedName("s")
   @Export("name")
   String name;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -651626551
   )
   @Export("overheadIcon")
   int overheadIcon = -1;
   @ObfuscatedName("g")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2057673081
   )
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1047377481
   )
   int field262;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 218407491
   )
   int field263;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -906234091
   )
   @Export("totalLevel")
   int totalLevel;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1236833145
   )
   int field265;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1715923037
   )
   @Export("team")
   int team;
   @ObfuscatedName("nh")
   static class65 field267;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1668597347
   )
   int field268;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1135877373
   )
   int field269;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1684823341
   )
   int field270;
   @ObfuscatedName("c")
   @Export("composition")
   PlayerComposition composition;
   @ObfuscatedName("w")
   @Export("model")
   Model model;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2127730237
   )
   int field273;
   @ObfuscatedName("e")
   boolean field274;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -486638625
   )
   int field275;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 536004323
   )
   int field276;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1348592367
   )
   int field277;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1133100133
   )
   int field278;
   @ObfuscatedName("l")
   boolean field279;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1176342123
   )
   int field280;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1554418031
   )
   int field281;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1112149043
   )
   @Export("skullIcon")
   int skullIcon = -1;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIBB)V",
      garbageValue = "51"
   )
   final void method193(int var1, int var2, byte var3) {
      if(super.field658 < 9) {
         ++super.field658;
      }

      for(int var4 = super.field658; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.field624[var4] = super.field624[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.field624[0] = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2062912069"
   )
   protected final Model getModel() {
      if(this.composition == null) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?class110.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation != -1 && !this.field274 && (super.poseAnimation != super.idlePoseAnimation || null == var1)?class110.getAnimation(super.poseAnimation):null;
         Model var3 = this.composition.method3046(var1, super.actionFrame, var2, super.poseFrame);
         if(var3 == null) {
            return null;
         } else {
            var3.method1518();
            super.field654 = var3.modelHeight;
            Model var4;
            Model[] var5;
            if(!this.field274 && super.graphic != -1 && super.field642 != -1) {
               var4 = class48.method844(super.graphic).method3353(super.field642);
               if(var4 != null) {
                  var4.method1517(0, -super.field631, 0);
                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(!this.field274 && this.model != null) {
               if(Client.gameCycle >= this.field265) {
                  this.model = null;
               }

               if(Client.gameCycle >= this.totalLevel && Client.gameCycle < this.field265) {
                  var4 = this.model;
                  var4.method1517(this.field256 - super.x, this.field276 - this.field270, this.field268 - super.y);
                  if(super.field655 == 512) {
                     var4.method1589();
                     var4.method1589();
                     var4.method1589();
                  } else if(super.field655 == 1024) {
                     var4.method1589();
                     var4.method1589();
                  } else if(super.field655 == 1536) {
                     var4.method1589();
                  }

                  var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
                  if(super.field655 == 512) {
                     var4.method1589();
                  } else if(super.field655 == 1024) {
                     var4.method1589();
                     var4.method1589();
                  } else if(super.field655 == 1536) {
                     var4.method1589();
                     var4.method1589();
                     var4.method1589();
                  }

                  var4.method1517(super.x - this.field256, this.field270 - this.field276, super.y - this.field268);
               }
            }

            var3.field1382 = true;
            return var3;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   int method195() {
      return null != this.composition && this.composition.field2180 != -1?Buffer.getNpcDefinition(this.composition.field2180).field3010:1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIBI)V",
      garbageValue = "-1799905885"
   )
   final void method197(int var1, int var2, byte var3) {
      if(super.animation != -1 && class110.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      super.field632 = -1;
      if(var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if(super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if(var3 == 2) {
               Player var4 = this;
               int var5 = super.pathX[0];
               int var6 = super.pathY[0];
               int var7 = this.method195();
               if(var5 >= var7 && var5 < 104 - var7 && var6 >= var7 && var6 < 104 - var7 && var1 >= var7 && var1 < 104 - var7 && var2 >= var7 && var2 < 104 - var7) {
                  int var10 = this.method195();
                  Client.field498.field1862 = var1;
                  Client.field498.field1864 = var2;
                  Client.field498.field1857 = 1;
                  Client.field498.field1860 = 1;
                  class22 var11 = Client.field498;
                  int var12 = class107.method1981(var5, var6, var10, var11, Client.collisionMaps[this.field277], true, Client.field572, Client.field573);
                  if(var12 >= 1) {
                     for(int var13 = 0; var13 < var12 - 1; ++var13) {
                        var4.method193(Client.field572[var13], Client.field573[var13], (byte)2);
                     }
                  }
               }
            }

            this.method193(var1, var2, var3);
         } else {
            this.method198(var1, var2);
         }
      } else {
         this.method198(var1, var2);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "118"
   )
   void method198(int var1, int var2) {
      super.field658 = 0;
      super.field663 = 0;
      super.field647 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.method195();
      super.x = 64 * var3 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1377545017"
   )
   final boolean vmethod699() {
      return null != this.composition;
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "-93"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Player var8;
      if(var2 == 50) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field336.method2963(25);
            Client.field336.method2733(class105.field1709[82]?1:0);
            Client.field336.method2756(var3);
         }
      }

      if(var2 == 1) {
         Client.field540 = var6;
         Client.field486 = var7;
         Client.field390 = 2;
         Client.field401 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field336.method2963(52);
         Client.field336.method2709(class39.field800);
         Client.field336.method2755(var0 + class22.baseX);
         Client.field336.method2754(var1 + class103.baseY);
         Client.field336.method2709(var3 >> 14 & 32767);
         Client.field336.method2844(class105.field1709[82]?1:0);
         Client.field336.method2766(class107.field1734);
         Client.field336.method2755(ItemLayer.field1216);
      }

      if(var2 == 42) {
         Client.field336.method2963(196);
         Client.field336.method2755(var3);
         Client.field336.method2754(var0);
         Client.field336.method2766(var1);
         Client.field444 = 0;
         class170.field2345 = class108.method1988(var1);
         Client.field405 = var0;
      }

      if(var2 == 4) {
         Client.field540 = var6;
         Client.field486 = var7;
         Client.field390 = 2;
         Client.field401 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field336.method2963(204);
         Client.field336.method2709(var0 + class22.baseX);
         Client.field336.method2754(var1 + class103.baseY);
         Client.field336.method2709(var3 >> 14 & 32767);
         Client.field336.method2708(class105.field1709[82]?1:0);
      }

      if(var2 == 26) {
         class88.method1820();
      }

      if(var2 == 1004) {
         Client.field540 = var6;
         Client.field486 = var7;
         Client.field390 = 2;
         Client.field401 = 0;
         Client.field336.method2963(173);
         Client.field336.method2754(var3);
      }

      if(var2 == 14) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field336.method2963(165);
            Client.field336.method2709(class39.field800);
            Client.field336.method2709(ItemLayer.field1216);
            Client.field336.method2709(var3);
            Client.field336.method2766(class107.field1734);
            Client.field336.method2844(class105.field1709[82]?1:0);
         }
      }

      if(var2 == 48) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field336.method2963(119);
            Client.field336.method2708(class105.field1709[82]?1:0);
            Client.field336.method2755(var3);
         }
      }

      if(var2 == 1001) {
         Client.field540 = var6;
         Client.field486 = var7;
         Client.field390 = 2;
         Client.field401 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field336.method2963(186);
         Client.field336.method2756(class22.baseX + var0);
         Client.field336.method2754(class103.baseY + var1);
         Client.field336.method2844(class105.field1709[82]?1:0);
         Client.field336.method2756(var3 >> 14 & 32767);
      }

      if(var2 == 51) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field336.method2963(150);
            Client.field336.method2833(class105.field1709[82]?1:0);
            Client.field336.method2754(var3);
         }
      }

      NPC var15;
      if(var2 == 12) {
         var15 = Client.cachedNPCs[var3];
         if(var15 != null) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field336.method2963(49);
            Client.field336.method2833(class105.field1709[82]?1:0);
            Client.field336.method2755(var3);
         }
      }

      if(var2 == 6) {
         Client.field540 = var6;
         Client.field486 = var7;
         Client.field390 = 2;
         Client.field401 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field336.method2963(215);
         Client.field336.method2755(class103.baseY + var1);
         Client.field336.method2756(var0 + class22.baseX);
         Client.field336.method2708(class105.field1709[82]?1:0);
         Client.field336.method2755(var3 >> 14 & 32767);
      }

      if(var2 == 44) {
         var8 = Client.cachedPlayers[var3];
         if(null != var8) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field336.method2963(252);
            Client.field336.method2844(class105.field1709[82]?1:0);
            Client.field336.method2755(var3);
         }
      }

      Widget var17;
      if(var2 == 1005) {
         var17 = class108.method1988(var1);
         if(var17 != null && var17.itemQuantities[var0] >= 100000) {
            method220(27, "", var17.itemQuantities[var0] + " x " + NPC.getItemDefinition(var3).name);
         } else {
            Client.field336.method2963(173);
            Client.field336.method2754(var3);
         }

         Client.field444 = 0;
         class170.field2345 = class108.method1988(var1);
         Client.field405 = var0;
      }

      if(var2 == 20) {
         Client.field540 = var6;
         Client.field486 = var7;
         Client.field390 = 2;
         Client.field401 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field336.method2963(207);
         Client.field336.method2755(var0 + class22.baseX);
         Client.field336.method2708(class105.field1709[82]?1:0);
         Client.field336.method2709(class103.baseY + var1);
         Client.field336.method2709(var3);
      }

      if(var2 == 36) {
         Client.field336.method2963(146);
         Client.field336.method2764(var1);
         Client.field336.method2754(var3);
         Client.field336.method2756(var0);
         Client.field444 = 0;
         class170.field2345 = class108.method1988(var1);
         Client.field405 = var0;
      }

      if(var2 == 32) {
         Client.field336.method2963(167);
         Client.field336.method2755(var0);
         Client.field336.method2754(Client.field447);
         Client.field336.method2766(class3.field43);
         Client.field336.method2772(var1);
         Client.field336.method2754(var3);
         Client.field444 = 0;
         class170.field2345 = class108.method1988(var1);
         Client.field405 = var0;
      }

      if(var2 == 10) {
         var15 = Client.cachedNPCs[var3];
         if(null != var15) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field336.method2963(136);
            Client.field336.method2733(class105.field1709[82]?1:0);
            Client.field336.method2755(var3);
         }
      }

      if(var2 == 8) {
         var15 = Client.cachedNPCs[var3];
         if(null != var15) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field336.method2963(193);
            Client.field336.method2754(Client.field447);
            Client.field336.method2772(class3.field43);
            Client.field336.method2733(class105.field1709[82]?1:0);
            Client.field336.method2754(var3);
         }
      }

      if(var2 == 40) {
         Client.field336.method2963(159);
         Client.field336.method2711(var1);
         Client.field336.method2754(var0);
         Client.field336.method2756(var3);
         Client.field444 = 0;
         class170.field2345 = class108.method1988(var1);
         Client.field405 = var0;
      }

      if(var2 == 37) {
         Client.field336.method2963(172);
         Client.field336.method2756(var0);
         Client.field336.method2711(var1);
         Client.field336.method2754(var3);
         Client.field444 = 0;
         class170.field2345 = class108.method1988(var1);
         Client.field405 = var0;
      }

      if(var2 == 17) {
         Client.field540 = var6;
         Client.field486 = var7;
         Client.field390 = 2;
         Client.field401 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field336.method2963(43);
         Client.field336.method2709(Client.field447);
         Client.field336.method2764(class3.field43);
         Client.field336.method2754(var3);
         Client.field336.method2708(class105.field1709[82]?1:0);
         Client.field336.method2709(var1 + class103.baseY);
         Client.field336.method2755(var0 + class22.baseX);
      }

      if(var2 == 43) {
         Client.field336.method2963(236);
         Client.field336.method2711(var1);
         Client.field336.method2709(var3);
         Client.field336.method2709(var0);
         Client.field444 = 0;
         class170.field2345 = class108.method1988(var1);
         Client.field405 = var0;
      }

      if(var2 == 1002) {
         Client.field540 = var6;
         Client.field486 = var7;
         Client.field390 = 2;
         Client.field401 = 0;
         Client.field336.method2963(85);
         Client.field336.method2755(var3 >> 14 & 32767);
      }

      if(var2 == 3) {
         Client.field540 = var6;
         Client.field486 = var7;
         Client.field390 = 2;
         Client.field401 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field336.method2963(218);
         Client.field336.method2756(var1 + class103.baseY);
         Client.field336.method2708(class105.field1709[82]?1:0);
         Client.field336.method2709(class22.baseX + var0);
         Client.field336.method2755(var3 >> 14 & 32767);
      }

      if(var2 == 58) {
         var17 = class112.method2038(var1, var0);
         if(null != var17) {
            Client.field336.method2963(233);
            Client.field336.method2709(Client.field447);
            Client.field336.method2772(class3.field43);
            Client.field336.method2754(var0);
            Client.field336.method2709(Client.field448);
            Client.field336.method2756(var17.item);
            Client.field336.method2711(var1);
         }
      }

      if(var2 == 19) {
         Client.field540 = var6;
         Client.field486 = var7;
         Client.field390 = 2;
         Client.field401 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field336.method2963(171);
         Client.field336.method2754(var1 + class103.baseY);
         Client.field336.method2733(class105.field1709[82]?1:0);
         Client.field336.method2754(class22.baseX + var0);
         Client.field336.method2754(var3);
      }

      if(var2 == 39) {
         Client.field336.method2963(74);
         Client.field336.method2709(var3);
         Client.field336.method2709(var0);
         Client.field336.method2772(var1);
         Client.field444 = 0;
         class170.field2345 = class108.method1988(var1);
         Client.field405 = var0;
      }

      if(var2 == 57 || var2 == 1007) {
         var17 = class112.method2038(var1, var0);
         if(null != var17) {
            WallObject.method1834(var3, var1, var0, var17.item, var5);
         }
      }

      if(var2 == 38) {
         class6.method77();
         var17 = class108.method1988(var1);
         Client.field412 = 1;
         ItemLayer.field1216 = var0;
         class107.field1734 = var1;
         class39.field800 = var3;
         class204.method3671(var17);
         Client.field322 = Actor.method574(16748608) + NPC.getItemDefinition(var3).name + Actor.method574(16777215);
         if(null == Client.field322) {
            Client.field322 = "null";
         }

      } else {
         if(var2 == 23) {
            class0.region.method1695(class118.plane, var0, var1);
         }

         if(var2 == 21) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field336.method2963(209);
            Client.field336.method2844(class105.field1709[82]?1:0);
            Client.field336.method2755(var3);
            Client.field336.method2709(class103.baseY + var1);
            Client.field336.method2755(var0 + class22.baseX);
         }

         if(var2 == 15) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field540 = var6;
               Client.field486 = var7;
               Client.field390 = 2;
               Client.field401 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field336.method2963(53);
               Client.field336.method2708(class105.field1709[82]?1:0);
               Client.field336.method2754(Client.field447);
               Client.field336.method2711(class3.field43);
               Client.field336.method2755(var3);
            }
         }

         if(var2 == 13) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.field540 = var6;
               Client.field486 = var7;
               Client.field390 = 2;
               Client.field401 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field336.method2963(133);
               Client.field336.method2844(class105.field1709[82]?1:0);
               Client.field336.method2754(var3);
            }
         }

         if(var2 == 30 && null == Client.field455) {
            Client.field336.method2963(115);
            Client.field336.method2764(var1);
            Client.field336.method2709(var0);
            Client.field455 = class112.method2038(var1, var0);
            class204.method3671(Client.field455);
         }

         if(var2 == 11) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.field540 = var6;
               Client.field486 = var7;
               Client.field390 = 2;
               Client.field401 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field336.method2963(127);
               Client.field336.method2754(var3);
               Client.field336.method2733(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 46) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field540 = var6;
               Client.field486 = var7;
               Client.field390 = 2;
               Client.field401 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field336.method2963(23);
               Client.field336.method2754(var3);
               Client.field336.method2708(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 31) {
            Client.field336.method2963(58);
            Client.field336.method2764(var1);
            Client.field336.method2756(ItemLayer.field1216);
            Client.field336.method2772(class107.field1734);
            Client.field336.method2756(var0);
            Client.field336.method2755(class39.field800);
            Client.field336.method2756(var3);
            Client.field444 = 0;
            class170.field2345 = class108.method1988(var1);
            Client.field405 = var0;
         }

         if(var2 == 33) {
            Client.field336.method2963(163);
            Client.field336.method2711(var1);
            Client.field336.method2755(var0);
            Client.field336.method2755(var3);
            Client.field444 = 0;
            class170.field2345 = class108.method1988(var1);
            Client.field405 = var0;
         }

         int var9;
         if(var2 == 29) {
            Client.field336.method2963(205);
            Client.field336.method2711(var1);
            var17 = class108.method1988(var1);
            if(var17.dynamicValues != null && var17.dynamicValues[0][0] == 5) {
               var9 = var17.dynamicValues[0][1];
               if(class165.widgetSettings[var9] != var17.field2310[0]) {
                  class165.widgetSettings[var9] = var17.field2310[0];
                  class2.method26(var9);
               }
            }
         }

         if(var2 == 35) {
            Client.field336.method2963(98);
            Client.field336.method2754(var3);
            Client.field336.method2754(var0);
            Client.field336.method2711(var1);
            Client.field444 = 0;
            class170.field2345 = class108.method1988(var1);
            Client.field405 = var0;
         }

         if(var2 == 45) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field540 = var6;
               Client.field486 = var7;
               Client.field390 = 2;
               Client.field401 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field336.method2963(199);
               Client.field336.method2709(var3);
               Client.field336.method2733(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 16) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field336.method2963(22);
            Client.field336.method2709(class39.field800);
            Client.field336.method2709(var0 + class22.baseX);
            Client.field336.method2754(var3);
            Client.field336.method2764(class107.field1734);
            Client.field336.method2833(class105.field1709[82]?1:0);
            Client.field336.method2755(class103.baseY + var1);
            Client.field336.method2709(ItemLayer.field1216);
         }

         if(var2 == 2) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field336.method2963(185);
            Client.field336.method2709(Client.field447);
            Client.field336.method2833(class105.field1709[82]?1:0);
            Client.field336.method2772(class3.field43);
            Client.field336.method2756(var3 >> 14 & 32767);
            Client.field336.method2754(var0 + class22.baseX);
            Client.field336.method2754(class103.baseY + var1);
         }

         if(var2 == 9) {
            var15 = Client.cachedNPCs[var3];
            if(var15 != null) {
               Client.field540 = var6;
               Client.field486 = var7;
               Client.field390 = 2;
               Client.field401 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field336.method2963(87);
               Client.field336.method2708(class105.field1709[82]?1:0);
               Client.field336.method2754(var3);
            }
         }

         if(var2 == 22) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field336.method2963(230);
            Client.field336.method2754(class22.baseX + var0);
            Client.field336.method2755(var3);
            Client.field336.method2756(class103.baseY + var1);
            Client.field336.method2844(class105.field1709[82]?1:0);
         }

         if(var2 == 47) {
            var8 = Client.cachedPlayers[var3];
            if(null != var8) {
               Client.field540 = var6;
               Client.field486 = var7;
               Client.field390 = 2;
               Client.field401 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field336.method2963(190);
               Client.field336.method2754(var3);
               Client.field336.method2833(class105.field1709[82]?1:0);
            }
         }

         if(var2 == 1003) {
            Client.field540 = var6;
            Client.field486 = var7;
            Client.field390 = 2;
            Client.field401 = 0;
            var15 = Client.cachedNPCs[var3];
            if(null != var15) {
               NPCComposition var13 = var15.composition;
               if(null != var13.configs) {
                  var13 = var13.method3576();
               }

               if(var13 != null) {
                  Client.field336.method2963(2);
                  Client.field336.method2755(var13.id);
               }
            }
         }

         if(var2 == 34) {
            Client.field336.method2963(29);
            Client.field336.method2756(var0);
            Client.field336.method2766(var1);
            Client.field336.method2754(var3);
            Client.field444 = 0;
            class170.field2345 = class108.method1988(var1);
            Client.field405 = var0;
         }

         if(var2 == 24) {
            var17 = class108.method1988(var1);
            boolean var16 = true;
            if(var17.contentType > 0) {
               var16 = XClanMember.method224(var17);
            }

            if(var16) {
               Client.field336.method2963(205);
               Client.field336.method2711(var1);
            }
         }

         if(var2 == 49) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field540 = var6;
               Client.field486 = var7;
               Client.field390 = 2;
               Client.field401 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field336.method2963(219);
               Client.field336.method2708(class105.field1709[82]?1:0);
               Client.field336.method2754(var3);
            }
         }

         if(var2 != 25) {
            if(var2 == 18) {
               Client.field540 = var6;
               Client.field486 = var7;
               Client.field390 = 2;
               Client.field401 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field336.method2963(86);
               Client.field336.method2733(class105.field1709[82]?1:0);
               Client.field336.method2756(var1 + class103.baseY);
               Client.field336.method2756(var0 + class22.baseX);
               Client.field336.method2754(var3);
            }

            if(var2 == 7) {
               var15 = Client.cachedNPCs[var3];
               if(var15 != null) {
                  Client.field540 = var6;
                  Client.field486 = var7;
                  Client.field390 = 2;
                  Client.field401 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field336.method2963(156);
                  Client.field336.method2844(class105.field1709[82]?1:0);
                  Client.field336.method2764(class107.field1734);
                  Client.field336.method2755(ItemLayer.field1216);
                  Client.field336.method2755(class39.field800);
                  Client.field336.method2754(var3);
               }
            }

            if(var2 == 5) {
               Client.field540 = var6;
               Client.field486 = var7;
               Client.field390 = 2;
               Client.field401 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field336.method2963(66);
               Client.field336.method2833(class105.field1709[82]?1:0);
               Client.field336.method2709(var3 >> 14 & 32767);
               Client.field336.method2709(var0 + class22.baseX);
               Client.field336.method2709(var1 + class103.baseY);
            }

            if(var2 == 41) {
               Client.field336.method2963(240);
               Client.field336.method2766(var1);
               Client.field336.method2755(var3);
               Client.field336.method2754(var0);
               Client.field444 = 0;
               class170.field2345 = class108.method1988(var1);
               Client.field405 = var0;
            }

            if(var2 == 28) {
               Client.field336.method2963(205);
               Client.field336.method2711(var1);
               var17 = class108.method1988(var1);
               if(null != var17.dynamicValues && var17.dynamicValues[0][0] == 5) {
                  var9 = var17.dynamicValues[0][1];
                  class165.widgetSettings[var9] = 1 - class165.widgetSettings[var9];
                  class2.method26(var9);
               }
            }

            if(Client.field412 != 0) {
               Client.field412 = 0;
               class204.method3671(class108.method1988(class107.field1734));
            }

            if(Client.field446) {
               class6.method77();
            }

            if(null != class170.field2345 && Client.field444 == 0) {
               class204.method3671(class170.field2345);
            }

         } else {
            var17 = class112.method2038(var1, var0);
            if(var17 != null) {
               if(Client.field446) {
                  Widget var19 = class112.method2038(class3.field43, Client.field447);
                  if(null != var19 && null != var19.field2301) {
                     class18 var14 = new class18();
                     var14.field204 = var19;
                     var14.field205 = var19.field2301;
                     CombatInfo1.method594(var14);
                  }

                  Client.field446 = false;
                  class204.method3671(var19);
               }

               var9 = class94.method1857(class170.method3147(var17));
               int var10 = var17.item;
               Widget var11 = class112.method2038(var1, var0);
               if(null != var11 && var11.field2300 != null) {
                  class18 var12 = new class18();
                  var12.field204 = var11;
                  var12.field205 = var11.field2300;
                  CombatInfo1.method594(var12);
               }

               Client.field448 = var10;
               Client.field446 = true;
               class3.field43 = var1;
               Client.field447 = var0;
               NPC.field760 = var9;
               class204.method3671(var11);
               Client.field412 = 0;
               String var18;
               if(class94.method1857(class170.method3147(var17)) == 0) {
                  var18 = null;
               } else if(var17.field2323 != null && var17.field2323.trim().length() != 0) {
                  var18 = var17.field2323;
               } else {
                  var18 = null;
               }

               Client.field449 = var18;
               if(null == Client.field449) {
                  Client.field449 = "Null";
               }

               if(var17.hasScript) {
                  Client.field450 = var17.name + Actor.method574(16777215);
               } else {
                  Client.field450 = Actor.method574('\uff00') + var17.field2325 + Actor.method574(16777215);
               }
            }

         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "32"
   )
   final void method212(Buffer var1) {
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
               int var8 = NPC.getItemDefinition(var4[var5] - 512).team;
               if(var8 != 0) {
                  this.team = var8;
               }
            }
         }
      }

      int[] var9 = new int[5];

      for(var6 = 0; var6 < 5; ++var6) {
         var7 = var1.readUnsignedByte();
         if(var7 < 0 || var7 >= class116.field1816[var6].length) {
            var7 = 0;
         }

         var9[var6] = var7;
      }

      super.idlePoseAnimation = var1.readUnsignedShort();
      if(super.idlePoseAnimation == '\uffff') {
         super.idlePoseAnimation = -1;
      }

      super.field610 = var1.readUnsignedShort();
      if(super.field610 == '\uffff') {
         super.field610 = -1;
      }

      super.field611 = super.field610;
      super.field636 = var1.readUnsignedShort();
      if(super.field636 == '\uffff') {
         super.field636 = -1;
      }

      super.field613 = var1.readUnsignedShort();
      if(super.field613 == '\uffff') {
         super.field613 = -1;
      }

      super.field614 = var1.readUnsignedShort();
      if(super.field614 == '\uffff') {
         super.field614 = -1;
      }

      super.field615 = var1.readUnsignedShort();
      if(super.field615 == '\uffff') {
         super.field615 = -1;
      }

      super.field639 = var1.readUnsignedShort();
      if(super.field639 == '\uffff') {
         super.field639 = -1;
      }

      this.name = var1.method2911();
      if(XItemContainer.localPlayer == this) {
         class101.field1657 = this.name;
      }

      this.combatLevel = var1.readUnsignedByte();
      this.field262 = var1.readUnsignedShort();
      this.field257 = var1.readUnsignedByte() == 1;
      if(Client.field297 == 0 && Client.field458 >= 2) {
         this.field257 = false;
      }

      if(this.composition == null) {
         this.composition = new PlayerComposition();
      }

      this.composition.method3040(var4, var9, var2 == 1, var3);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2003956546"
   )
   static int method219() {
      return ++class47.field921 - 1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-965254444"
   )
   static void method220(int var0, String var1, String var2) {
      class202.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "2105647448"
   )
   static final void method221(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field578 == 0) {
         var1 = class0.region.method1684(var0.field584, var0.field579, var0.field583);
      }

      if(var0.field578 == 1) {
         var1 = class0.region.method1685(var0.field584, var0.field579, var0.field583);
      }

      if(var0.field578 == 2) {
         var1 = class0.region.method1686(var0.field584, var0.field579, var0.field583);
      }

      if(var0.field578 == 3) {
         var1 = class0.region.method1668(var0.field584, var0.field579, var0.field583);
      }

      if(var1 != 0) {
         int var5 = class0.region.method1730(var0.field584, var0.field579, var0.field583, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field580 = var2;
      var0.field591 = var3;
      var0.field582 = var4;
   }

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.field262 = 0;
      this.totalLevel = 0;
      this.field265 = 0;
      this.field274 = false;
      this.team = 0;
      this.field257 = false;
      this.field279 = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "1788391807"
   )
   public static File method222(String var0) {
      if(!class107.field1731) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class107.field1730.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class107.field1729, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class107.field1730.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(null != var3) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }
}
