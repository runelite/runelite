import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1276067541
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1795514157
   )
   @Export("y")
   int y;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 818193593
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("ap")
   boolean field1211;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1809050447
   )
   int field1212;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 151535433
   )
   int field1213;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -932449539
   )
   int field1214;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -972633169
   )
   int field1215;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1895743921
   )
   int field1216;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -642540453
   )
   int field1217;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1408440325
   )
   int field1218;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -195000335
   )
   int field1219;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -544282603
   )
   int field1220;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1116532499
   )
   int field1221;
   @ObfuscatedName("ag")
   boolean field1222;
   @ObfuscatedName("aq")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("aw")
   byte field1224;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1763748975
   )
   int field1225;
   @ObfuscatedName("bv")
   boolean field1226;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1371898607
   )
   int field1227;
   @ObfuscatedName("au")
   int[] field1228;
   @ObfuscatedName("ah")
   int[] field1229;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 533122345
   )
   int field1230;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1589627481
   )
   int field1231;
   @ObfuscatedName("bg")
   int[] field1232;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1301392751
   )
   @Export("x")
   int x;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -444336115
   )
   int field1234;
   @ObfuscatedName("aj")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 241071951
   )
   int field1236;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -322297645
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1564062981
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -919263399
   )
   int field1239;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -713624827
   )
   int field1240;
   @ObfuscatedName("at")
   int[] field1241;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 355249667
   )
   int field1242;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1219136257
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1516975105
   )
   int field1244;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -1766345997
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bf")
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1799968625
   )
   int field1247;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1557977263
   )
   int field1248;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 271562871
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 2082333415
   )
   int field1250;
   @ObfuscatedName("ad")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1558149635
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -936934647
   )
   int field1253;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 827729633
   )
   int field1254;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1514827185
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 710600389
   )
   int field1256;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1875217325
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 687121581
   )
   int field1258;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1867431301
   )
   int field1259;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -903192889
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1546477155
   )
   int field1261;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -372694883
   )
   int field1262;
   @ObfuscatedName("co")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cz")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cj")
   byte[] field1265;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 761309117
   )
   int field1266;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -731196427
   )
   int field1267;
   @ObfuscatedName("oi")
   static SpritePixels field1268;

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1735613934"
   )
   final void method1441() {
      this.queueSize = 0;
      this.field1267 = 0;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1927545137"
   )
   final void method1443(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class254 var12 = class24.method200(var1);
         var10 = var12.field3435;
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
            var14 = this.field1229[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.hitsplatCycles[var13] < var14) {
                  var9 = var13;
                  var14 = this.hitsplatCycles[var13];
               }
            } else if(var10 == 1 && this.field1229[var13] < var14) {
               var9 = var13;
               var14 = this.field1229[var13];
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
         this.field1228[var9] = var1;
         this.field1229[var9] = var2;
         this.field1241[var9] = var3;
         this.field1232[var9] = var4;
         this.hitsplatCycles[var9] = var11 + var5 + var6;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1911761116"
   )
   final void method1445(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field3377.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field3372.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.method4276(new Buffer(var9));
         }

         CombatInfo2.field3377.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var7.field3376;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.method3457(); var13 != null; var13 = (CombatInfoListHolder)this.combatInfoList.method3448()) {
         ++var12;
         if(var8.field3374 == var13.combatInfo2.field3374) {
            var13.method1568(var4 + var2, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field3375 <= var8.field3375) {
            var14 = var13;
         }

         if(var13.combatInfo2.field3376 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field3376;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var8);
         if(var14 == null) {
            this.combatInfoList.method3442(var13);
         } else {
            CombatInfoList.method3443(var13, var14);
         }

         var13.method1568(var4 + var2, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-577644750"
   )
   final void method1446(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3377.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3372.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.method4276(new Buffer(var4));
         }

         CombatInfo2.field3377.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.method3457(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.method3448()) {
         if(var3 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "2239"
   )
   boolean vmethod1593() {
      return false;
   }

   Actor() {
      this.field1211 = false;
      this.field1212 = 1;
      this.idlePoseAnimation = -1;
      this.field1214 = -1;
      this.field1215 = -1;
      this.field1216 = -1;
      this.field1217 = -1;
      this.field1218 = -1;
      this.field1219 = -1;
      this.field1220 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1234 = 100;
      this.field1225 = 0;
      this.field1262 = 0;
      this.field1224 = 0;
      this.field1228 = new int[4];
      this.field1229 = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1241 = new int[4];
      this.field1232 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1226 = false;
      this.field1236 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1231 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1242 = 0;
      this.actionAnimationDisable = 0;
      this.field1244 = 0;
      this.graphic = -1;
      this.field1221 = 0;
      this.field1247 = 0;
      this.field1240 = 0;
      this.field1258 = 200;
      this.field1230 = 0;
      this.field1227 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1265 = new byte[10];
      this.field1266 = 0;
      this.field1267 = 0;
   }
}
