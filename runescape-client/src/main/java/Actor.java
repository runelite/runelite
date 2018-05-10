import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "[Llc;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1294539883
   )
   @Export("x")
   int x;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1361629179
   )
   @Export("y")
   int y;
   @ObfuscatedName("an")
   boolean field884;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -288583475
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -275943381
   )
   int field885;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1031464143
   )
   int field905;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 999370705
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 625498457
   )
   int field892;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -232489951
   )
   int field889;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -421220145
   )
   int field890;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 60113477
   )
   int field891;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -183823349
   )
   int field882;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -732832623
   )
   int field893;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -640872353
   )
   int field894;
   @ObfuscatedName("ae")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("au")
   boolean field938;
   @ObfuscatedName("av")
   boolean field941;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 525434105
   )
   @Export("overheadTextCyclesRemaining")
   int overheadTextCyclesRemaining;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1175798307
   )
   int field899;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 645731903
   )
   int field887;
   @ObfuscatedName("al")
   byte field902;
   @ObfuscatedName("ak")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("bc")
   @Export("hitsplatValues")
   int[] hitsplatValues;
   @ObfuscatedName("bo")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("bx")
   int[] field906;
   @ObfuscatedName("be")
   int[] field907;
   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -458626459
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bn")
   boolean field910;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1929094879
   )
   int field897;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 2095688717
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1773591931
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 337252777
   )
   @Export("poseFrameCycle")
   int poseFrameCycle;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1957224505
   )
   @Export("animation")
   int animation;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1851810309
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -933080379
   )
   @Export("actionFrameCycle")
   int actionFrameCycle;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1302070535
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1212107921
   )
   int field919;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1070741445
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 382614979
   )
   @Export("spotAnimFrame")
   int spotAnimFrame;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1533049309
   )
   @Export("spotAnimFrameCycle")
   int spotAnimFrameCycle;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1103417953
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -157803181
   )
   int field924;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1145211711
   )
   int field925;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -2052839739
   )
   int field926;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 748233977
   )
   int field927;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -691307947
   )
   int field888;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1947351969
   )
   int field896;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1512320719
   )
   int field901;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 519218903
   )
   int field931;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -818402131
   )
   @Export("npcCycle")
   int npcCycle;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -370023441
   )
   @Export("logicalHeight")
   int logicalHeight;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1225795687
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -742921575
   )
   int field930;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -509064687
   )
   int field929;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 1458096333
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("co")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cj")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cp")
   @Export("pathTraversed")
   byte[] pathTraversed;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 558190371
   )
   int field936;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1506593327
   )
   int field942;

   Actor() {
      this.field884 = false;
      this.field885 = 1;
      this.idlePoseAnimation = -1;
      this.field892 = -1;
      this.field889 = -1;
      this.field890 = -1;
      this.field891 = -1;
      this.field882 = -1;
      this.field893 = -1;
      this.field894 = -1;
      this.overhead = null;
      this.field941 = false;
      this.overheadTextCyclesRemaining = 100;
      this.field899 = 0;
      this.field887 = 0;
      this.field902 = 0;
      this.hitsplatTypes = new int[4];
      this.hitsplatValues = new int[4];
      this.hitsplatCycles = new int[4];
      this.field906 = new int[4];
      this.field907 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field910 = false;
      this.field897 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.poseFrameCycle = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.actionFrameCycle = 0;
      this.actionAnimationDisable = 0;
      this.field919 = 0;
      this.graphic = -1;
      this.spotAnimFrame = 0;
      this.spotAnimFrameCycle = 0;
      this.npcCycle = 0;
      this.logicalHeight = 200;
      this.field930 = 0;
      this.field929 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.pathTraversed = new byte[10];
      this.field936 = 0;
      this.field942 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2053483294"
   )
   final void method1590() {
      this.queueSize = 0;
      this.field942 = 0;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1730469772"
   )
   @Export("applyActorHitsplat")
   @Hook(
      value = "onActorHitsplat",
      end = true
   )
   final void applyActorHitsplat(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.hitsplatCycles[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class267 var12 = class8.method92(var1);
         var10 = var12.field3384;
         var11 = var12.field3375;
      }

      int var14;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var14 = 0;
         if(var10 == 0) {
            var14 = this.hitsplatCycles[0];
         } else if(var10 == 1) {
            var14 = this.hitsplatValues[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.hitsplatCycles[var13] < var14) {
                  var9 = var13;
                  var14 = this.hitsplatCycles[var13];
               }
            } else if(var10 == 1 && this.hitsplatValues[var13] < var14) {
               var9 = var13;
               var14 = this.hitsplatValues[var13];
            }
         }

         if(var10 == 1 && var14 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field902 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field902;
            this.field902 = (byte)((this.field902 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.hitsplatTypes[var9] = var1;
         this.hitsplatValues[var9] = var2;
         this.field906[var9] = var3;
         this.field907[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "705476680"
   )
   @Export("setCombatInfo")
   @Hook("onSetCombatInfo")
   final void setCombatInfo(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = Widget.method4570(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field3327;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.last(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.previous()) {
         ++var11;
         if(var12.combatInfo2.field3325 == var7.field3325) {
            var12.method1815(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field3326 <= var7.field3326) {
            var8 = var12;
         }

         if(var12.combatInfo2.field3327 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field3327;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.addLast(var12);
         } else {
            CombatInfoList.method4089(var12, var8);
         }

         var12.method1815(var2 + var4, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2057048156"
   )
   final void method1579(int var1) {
      CombatInfo2 var2 = Widget.method4570(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.last(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.previous()) {
         if(var2 == var3.combatInfo2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1296539398"
   )
   @Export("drawObject")
   static final void drawObject(int var0, int var1, int var2, int var3, int var4) {
      long var5 = ScriptEvent.region.method2927(var0, var1, var2);
      int var7;
      int var8;
      int var9;
      int var10;
      int var12;
      int var13;
      if(var5 != 0L) {
         var7 = ScriptEvent.region.method2931(var0, var1, var2, var5);
         var8 = var7 >> 6 & 3;
         var9 = var7 & 31;
         var10 = var3;
         if(WorldMapType2.method501(var5)) {
            var10 = var4;
         }

         int[] var11 = class283.minimapSprite.pixels;
         var12 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var13 = class8.method93(var5);
         ObjectComposition var14 = SoundTaskDataProvider.getObjectDefinition(var13);
         if(var14.mapSceneId != -1) {
            IndexedSprite var15 = WorldComparator.mapscene[var14.mapSceneId];
            if(var15 != null) {
               int var16 = (var14.width * 4 - var15.width) / 2;
               int var17 = (var14.length * 4 - var15.height) / 2;
               var15.method5873(var16 + var1 * 4 + 48, var17 + (104 - var2 - var14.length) * 4 + 48);
            }
         } else {
            if(var9 == 0 || var9 == 2) {
               if(var8 == 0) {
                  var11[var12] = var10;
                  var11[var12 + 512] = var10;
                  var11[var12 + 1024] = var10;
                  var11[var12 + 1536] = var10;
               } else if(var8 == 1) {
                  var11[var12] = var10;
                  var11[var12 + 1] = var10;
                  var11[var12 + 2] = var10;
                  var11[var12 + 3] = var10;
               } else if(var8 == 2) {
                  var11[var12 + 3] = var10;
                  var11[var12 + 512 + 3] = var10;
                  var11[var12 + 1024 + 3] = var10;
                  var11[var12 + 1536 + 3] = var10;
               } else if(var8 == 3) {
                  var11[var12 + 1536] = var10;
                  var11[var12 + 1536 + 1] = var10;
                  var11[var12 + 1536 + 2] = var10;
                  var11[var12 + 1536 + 3] = var10;
               }
            }

            if(var9 == 3) {
               if(var8 == 0) {
                  var11[var12] = var10;
               } else if(var8 == 1) {
                  var11[var12 + 3] = var10;
               } else if(var8 == 2) {
                  var11[var12 + 1536 + 3] = var10;
               } else if(var8 == 3) {
                  var11[var12 + 1536] = var10;
               }
            }

            if(var9 == 2) {
               if(var8 == 3) {
                  var11[var12] = var10;
                  var11[var12 + 512] = var10;
                  var11[var12 + 1024] = var10;
                  var11[var12 + 1536] = var10;
               } else if(var8 == 0) {
                  var11[var12] = var10;
                  var11[var12 + 1] = var10;
                  var11[var12 + 2] = var10;
                  var11[var12 + 3] = var10;
               } else if(var8 == 1) {
                  var11[var12 + 3] = var10;
                  var11[var12 + 512 + 3] = var10;
                  var11[var12 + 1024 + 3] = var10;
                  var11[var12 + 1536 + 3] = var10;
               } else if(var8 == 2) {
                  var11[var12 + 1536] = var10;
                  var11[var12 + 1536 + 1] = var10;
                  var11[var12 + 1536 + 2] = var10;
                  var11[var12 + 1536 + 3] = var10;
               }
            }
         }
      }

      var5 = ScriptEvent.region.method3045(var0, var1, var2);
      if(var5 != 0L) {
         var7 = ScriptEvent.region.method2931(var0, var1, var2, var5);
         var8 = var7 >> 6 & 3;
         var9 = var7 & 31;
         var10 = class8.method93(var5);
         ObjectComposition var24 = SoundTaskDataProvider.getObjectDefinition(var10);
         int var19;
         if(var24.mapSceneId != -1) {
            IndexedSprite var18 = WorldComparator.mapscene[var24.mapSceneId];
            if(var18 != null) {
               var13 = (var24.width * 4 - var18.width) / 2;
               var19 = (var24.length * 4 - var18.height) / 2;
               var18.method5873(var1 * 4 + var13 + 48, var19 + (104 - var2 - var24.length) * 4 + 48);
            }
         } else if(var9 == 9) {
            var12 = 15658734;
            if(WorldMapType2.method501(var5)) {
               var12 = 15597568;
            }

            int[] var23 = class283.minimapSprite.pixels;
            var19 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var8 != 0 && var8 != 2) {
               var23[var19] = var12;
               var23[var19 + 1 + 512] = var12;
               var23[var19 + 1024 + 2] = var12;
               var23[var19 + 1536 + 3] = var12;
            } else {
               var23[var19 + 1536] = var12;
               var23[var19 + 1 + 1024] = var12;
               var23[var19 + 512 + 2] = var12;
               var23[var19 + 3] = var12;
            }
         }
      }

      var5 = ScriptEvent.region.method2930(var0, var1, var2);
      if(0L != var5) {
         var7 = class8.method93(var5);
         ObjectComposition var20 = SoundTaskDataProvider.getObjectDefinition(var7);
         if(var20.mapSceneId != -1) {
            IndexedSprite var21 = WorldComparator.mapscene[var20.mapSceneId];
            if(var21 != null) {
               var10 = (var20.width * 4 - var21.width) / 2;
               int var22 = (var20.length * 4 - var21.height) / 2;
               var21.method5873(var10 + var1 * 4 + 48, (104 - var2 - var20.length) * 4 + var22 + 48);
            }
         }
      }

   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-644860759"
   )
   static void method1597() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.menuBooleanArray[0] = false;
      Client.menuOptionCount = 1;
   }
}
