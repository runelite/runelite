import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("fs")
   @ObfuscatedGetter(
      intValue = 622695767
   )
   static int field1270;
   @ObfuscatedName("cx")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 754507457
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 721660763
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("ay")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("ad")
   boolean field1210;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -615829939
   )
   int field1235;
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 204563847
   )
   int field1241;
   @ObfuscatedName("cs")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("ac")
   byte field1226;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -221381609
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 975225371
   )
   int field1251;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 539417939
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1706556815
   )
   int field1211;
   @ObfuscatedName("al")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -62671115
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1077966759
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1661603963
   )
   int field1266;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -798005453
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1580142335
   )
   int field1213;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1582726851
   )
   int field1215;
   @ObfuscatedName("cb")
   byte[] field1264;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -985697271
   )
   int field1260;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 318627133
   )
   @Export("x")
   int x;
   @ObfuscatedName("au")
   int[] field1245;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 79598465
   )
   int field1217;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1642552543
   )
   int field1218;
   @ObfuscatedName("ak")
   int[] field1230;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1002863149
   )
   int field1219;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -555219103
   )
   int field1257;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1038414011
   )
   @Export("y")
   int y;
   @ObfuscatedName("bj")
   int[] field1231;
   @ObfuscatedName("aa")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1052609577
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("ap")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1965827709
   )
   int field1249;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 898598985
   )
   int field1223;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1619778527
   )
   int field1224;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 2088009471
   )
   int field1225;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1475516029
   )
   int field1214;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1752718487
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bc")
   boolean field1234;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 578096291
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1845115089
   )
   int field1238;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1195814135
   )
   int field1207;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 6606045
   )
   int field1243;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1500141671
   )
   int field1246;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1575120789
   )
   int field1256;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1887070429
   )
   int field1252;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1652269847
   )
   int field1265;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1061721401
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1523537519
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 110324479
   )
   int field1255;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -51201879
   )
   int field1254;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 632533099
   )
   int field1236;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1863147533
   )
   int field1229;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 860119813
   )
   int field1250;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -302487669
   )
   int field1216;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 244687197
   )
   int field1261;
   @ObfuscatedName("aj")
   boolean field1221;

   Actor() {
      this.field1210 = false;
      this.field1211 = 1;
      this.idlePoseAnimation = -1;
      this.field1266 = -1;
      this.field1213 = -1;
      this.field1215 = -1;
      this.field1260 = -1;
      this.field1217 = -1;
      this.field1218 = -1;
      this.field1219 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1223 = 100;
      this.field1224 = 0;
      this.field1225 = 0;
      this.field1226 = 0;
      this.field1245 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1230 = new int[4];
      this.field1231 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1234 = false;
      this.field1235 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1238 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1207 = 0;
      this.actionAnimationDisable = 0;
      this.field1243 = 0;
      this.graphic = -1;
      this.field1249 = 0;
      this.field1246 = 0;
      this.field1256 = 0;
      this.field1257 = 200;
      this.field1252 = 0;
      this.field1265 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1264 = new byte[10];
      this.field1251 = 0;
      this.field1241 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1832994201"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "63"
   )
   final void method1590(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class254 var12 = class93.method1843(var1);
         var10 = var12.field3435;
         var11 = var12.field3422;
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
            this.field1226 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1226;
            this.field1226 = (byte)((this.field1226 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1245[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1230[var9] = var3;
         this.field1231[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "434695251"
   )
   final void method1591(int var1) {
      CombatInfo2 var2 = class12.method72(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method3664(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.method3665()) {
         if(var2 == var3.combatInfo2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1731078773"
   )
   final void method1588() {
      this.queueSize = 0;
      this.field1241 = 0;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "16"
   )
   final void method1600(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = class12.method72(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field3369;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method3664(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.method3665()) {
         ++var11;
         if(var12.combatInfo2.field3364 == var7.field3364) {
            var12.method1737(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field3360 <= var7.field3360) {
            var8 = var12;
         }

         if(var12.combatInfo2.field3369 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field3369;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.method3661(var12);
         } else {
            CombatInfoList.method3662(var12, var8);
         }

         var12.method1737(var2 + var4, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1057931337"
   )
   public static void method1605() {
      class287.field3807 = null;
      World.offsetsY = null;
      class236.field3238 = null;
      FileSystem.field3207 = null;
      class181.field2456 = null;
      class208.spritePixels = null;
   }
}
