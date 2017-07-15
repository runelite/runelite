import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("mo")
   static class156 field1274;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 873343703
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -2041620275
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("cu")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("ac")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("cy")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -803461459
   )
   int field1242;
   @ObfuscatedName("ap")
   boolean field1217;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -807360359
   )
   int field1273;
   @ObfuscatedName("an")
   byte field1233;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1603615229
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -55252229
   )
   int field1272;
   @ObfuscatedName("bi")
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1915867089
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -385902441
   )
   int field1218;
   @ObfuscatedName("ao")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 22377069
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1128972655
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -2130068501
   )
   int field1220;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1746811053
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1376783755
   )
   int field1244;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1518264441
   )
   int field1251;
   @ObfuscatedName("ck")
   byte[] field1239;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -829936813
   )
   int field1223;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1788873965
   )
   @Export("x")
   int x;
   @ObfuscatedName("ay")
   int[] field1234;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 338246343
   )
   int field1224;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 136274357
   )
   int field1225;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 989311819
   )
   @Export("y")
   int y;
   @ObfuscatedName("af")
   int[] field1237;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1891802685
   )
   int field1221;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -376120593
   )
   int field1235;
   @ObfuscatedName("bp")
   int[] field1238;
   @ObfuscatedName("az")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1949670241
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("av")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 102541571
   )
   int field1250;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -2113569253
   )
   int field1230;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1250067745
   )
   int field1231;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -448267447
   )
   int field1241;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 750881445
   )
   int field1255;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1948315109
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bd")
   boolean field1271;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1593554263
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -8678101
   )
   int field1245;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -377352125
   )
   int field1248;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -348053999
   )
   int field1259;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1419504763
   )
   int field1253;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1429215075
   )
   int field1263;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 268617215
   )
   int field1266;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 499338047
   )
   int field1267;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -715742041
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 1092566373
   )
   int field1260;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -10908031
   )
   int field1261;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 2101542269
   )
   int field1256;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -748919293
   )
   int field1258;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1016234695
   )
   int field1257;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 959554293
   )
   int field1222;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1672950389
   )
   int field1262;
   @ObfuscatedName("as")
   boolean field1228;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1767555021
   )
   @Export("graphicsDelay")
   int graphicsDelay;

   Actor() {
      this.field1217 = false;
      this.field1218 = 1;
      this.idlePoseAnimation = -1;
      this.field1220 = -1;
      this.field1244 = -1;
      this.field1251 = -1;
      this.field1223 = -1;
      this.field1224 = -1;
      this.field1225 = -1;
      this.field1221 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1230 = 100;
      this.field1231 = 0;
      this.field1241 = 0;
      this.field1233 = 0;
      this.field1234 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1237 = new int[4];
      this.field1238 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1271 = false;
      this.field1242 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1245 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1248 = 0;
      this.actionAnimationDisable = 0;
      this.field1259 = 0;
      this.graphic = -1;
      this.field1250 = 0;
      this.field1253 = 0;
      this.field1263 = 0;
      this.field1235 = 200;
      this.field1266 = 0;
      this.field1267 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1239 = new byte[10];
      this.field1272 = 0;
      this.field1273 = 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-42"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-17"
   )
   final void method1489(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class254 var12 = class21.method154(var1);
         var10 = var12.field3413;
         var11 = var12.field3418;
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
            this.field1233 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1233;
            this.field1233 = (byte)((this.field1233 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1234[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1237[var9] = var3;
         this.field1238[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   final void method1491(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3364.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3373.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.method4352(new Buffer(var4));
         }

         CombatInfo2.field3364.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.method3558(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.method3560()) {
         if(var3 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1467650946"
   )
   final void method1487() {
      this.queueSize = 0;
      this.field1273 = 0;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "2073547468"
   )
   final void method1490(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field3364.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field3373.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.method4352(new Buffer(var9));
         }

         CombatInfo2.field3364.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var7.field3369;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.method3558(); var13 != null; var13 = (CombatInfoListHolder)this.combatInfoList.method3560()) {
         ++var12;
         if(var13.combatInfo2.field3366 == var8.field3366) {
            var13.method1652(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field3368 <= var8.field3368) {
            var14 = var13;
         }

         if(var13.combatInfo2.field3369 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field3369;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var8);
         if(var14 == null) {
            this.combatInfoList.method3555(var13);
         } else {
            CombatInfoList.method3556(var13, var14);
         }

         var13.method1652(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class238.field3264 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class238.field3264.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class238.field3264.close();
            } catch (Exception var3) {
               ;
            }

            ++class238.field3252;
            class238.field3264 = null;
         }

      }
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1879562306"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class61.tileHeights[var5][var3][var4] * (128 - var6) + var6 * class61.tileHeights[var5][1 + var3][var4] >> 7;
         int var9 = class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) + var6 * class61.tileHeights[var5][var3 + 1][var4 + 1] >> 7;
         return var9 * var7 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
