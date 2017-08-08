import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("oq")
   @ObfuscatedSignature(
      signature = "Ldw;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1385202237
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("cu")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -1259619637
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("aj")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("cj")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 818241665
   )
   int field1205;
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("ao")
   boolean field1208;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 620063943
   )
   int field1264;
   @ObfuscatedName("ai")
   byte field1224;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -1514239131
   )
   int field1263;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -1433917181
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 477560909
   )
   int field1254;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -967413631
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("ar")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1212636231
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1811432949
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -737064629
   )
   int field1227;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1697482817
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1189629849
   )
   int field1212;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1484888527
   )
   int field1241;
   @ObfuscatedName("cl")
   byte[] field1262;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1116056997
   )
   int field1214;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1049232225
   )
   @Export("x")
   int x;
   @ObfuscatedName("an")
   int[] field1225;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1795301063
   )
   int field1249;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -2059305021
   )
   int field1211;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1238910647
   )
   @Export("y")
   int y;
   @ObfuscatedName("aa")
   int[] field1215;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1357922353
   )
   int field1256;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1420875825
   )
   int field1255;
   @ObfuscatedName("bn")
   int[] field1243;
   @ObfuscatedName("at")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 179394683
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("am")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1679683691
   )
   int field1209;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -942140779
   )
   int field1221;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1647380157
   )
   int field1222;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1535093425
   )
   int field1223;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1885512869
   )
   int field1265;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1647863415
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("ba")
   boolean field1242;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1090619129
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1785650393
   )
   int field1236;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 699322343
   )
   int field1239;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -489865257
   )
   int field1246;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 2083368521
   )
   int field1244;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -398281357
   )
   int field1245;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1694958175
   )
   int field1257;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -190239419
   )
   int field1229;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1536013601
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("af")
   boolean field1219;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1168870763
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -524584577
   )
   int field1238;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1094875551
   )
   int field1252;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -404660689
   )
   int field1247;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1632731483
   )
   int field1251;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 306667053
   )
   int field1248;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 830061191
   )
   int field1228;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 175010221
   )
   int field1253;

   Actor() {
      this.field1208 = false;
      this.field1254 = 1;
      this.idlePoseAnimation = -1;
      this.field1227 = -1;
      this.field1212 = -1;
      this.field1241 = -1;
      this.field1214 = -1;
      this.field1249 = -1;
      this.field1211 = -1;
      this.field1256 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1221 = 100;
      this.field1222 = 0;
      this.field1223 = 0;
      this.field1224 = 0;
      this.field1225 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1215 = new int[4];
      this.field1243 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1242 = false;
      this.field1205 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1236 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1239 = 0;
      this.actionAnimationDisable = 0;
      this.field1246 = 0;
      this.graphic = -1;
      this.field1209 = 0;
      this.field1244 = 0;
      this.field1245 = 0;
      this.field1255 = 200;
      this.field1257 = 0;
      this.field1229 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1262 = new byte[10];
      this.field1263 = 0;
      this.field1264 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2046618582"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-14"
   )
   final void method1526(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class255 var12 = CombatInfo1.method1547(var1);
         var10 = var12.field3402;
         var11 = var12.field3404;
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
            var14 = this.hitsplatTypes[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.hitsplatCycles[var13] < var14) {
                  var9 = var13;
                  var14 = this.hitsplatCycles[var13];
               }
            } else if(var10 == 1 && this.hitsplatTypes[var13] < var14) {
               var9 = var13;
               var14 = this.hitsplatTypes[var13];
            }
         }

         if(var10 == 1 && var14 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field1224 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1224;
            this.field1224 = (byte)((this.field1224 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1225[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1215[var9] = var3;
         this.field1243[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "926595464"
   )
   final void method1530(int var1) {
      CombatInfo2 var2 = class175.method3381(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method3567(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.method3569()) {
         if(var2 == var3.combatInfo2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-974039070"
   )
   final void method1529(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = class175.method3381(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field3360;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method3567(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.method3569()) {
         ++var11;
         if(var12.combatInfo2.field3356 == var7.field3356) {
            var12.method1695(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field3359 <= var7.field3359) {
            var8 = var12;
         }

         if(var12.combatInfo2.field3360 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field3360;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.method3564(var12);
         } else {
            CombatInfoList.method3576(var12, var8);
         }

         var12.method1695(var2 + var4, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-193242182"
   )
   final void method1532() {
      this.queueSize = 0;
      this.field1264 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lir;",
      garbageValue = "1276553241"
   )
   public static class244 method1545(int var0) {
      class244 var1 = (class244)class244.field3305.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class244.field3301.getConfigData(19, var0);
         var1 = new class244();
         if(var2 != null) {
            var1.method4312(new Buffer(var2));
         }

         class244.field3305.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-1250410773"
   )
   static void method1544(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = class51.worldList[var6];
         class51.worldList[var6] = class51.worldList[var1];
         class51.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(CacheFile.method2372(class51.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = class51.worldList[var9];
               class51.worldList[var9] = class51.worldList[var7];
               class51.worldList[var7++] = var10;
            }
         }

         class51.worldList[var1] = class51.worldList[var7];
         class51.worldList[var7] = var8;
         method1544(var0, var7 - 1, var2, var3, var4, var5);
         method1544(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
