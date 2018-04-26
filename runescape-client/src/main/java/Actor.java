import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 30047471
   )
   @Export("x")
   int x;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -77409687
   )
   @Export("y")
   int y;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1658606017
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("as")
   boolean field1142;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -989785133
   )
   int field1143;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 816627419
   )
   int field1144;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1981936111
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1052848365
   )
   int field1189;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 88993289
   )
   int field1157;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1323571001
   )
   int field1148;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 665041961
   )
   int field1149;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -874453623
   )
   int field1150;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 32250037
   )
   int field1180;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -2089123259
   )
   int field1152;
   @ObfuscatedName("au")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("ap")
   boolean field1191;
   @ObfuscatedName("at")
   boolean field1155;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1528007977
   )
   @Export("overheadTextCyclesRemaining")
   int overheadTextCyclesRemaining;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 625718251
   )
   int field1159;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1318557809
   )
   int field1158;
   @ObfuscatedName("ar")
   byte field1146;
   @ObfuscatedName("aq")
   int[] field1160;
   @ObfuscatedName("bq")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("bi")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("bo")
   int[] field1163;
   @ObfuscatedName("bj")
   int[] field1164;
   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -125583463
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bh")
   boolean field1167;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1290248237
   )
   int field1168;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 473347341
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1438019073
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 654410315
   )
   @Export("poseFrameCycle")
   int poseFrameCycle;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1107306173
   )
   @Export("animation")
   int animation;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 181977263
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1434908907
   )
   @Export("actionFrameCycle")
   int actionFrameCycle;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1970826413
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -641142315
   )
   int field1176;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -366728317
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 472165065
   )
   @Export("spotAnimFrame")
   int spotAnimFrame;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 2005861713
   )
   @Export("spotAnimFrameCycle")
   int spotAnimFrameCycle;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1339539415
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -844652271
   )
   int field1187;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -398752123
   )
   int field1182;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 482798777
   )
   int field1174;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 2051193611
   )
   int field1184;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -113389347
   )
   int field1185;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -466285689
   )
   int field1186;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 1243544389
   )
   int field1139;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -262029265
   )
   int field1188;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 405649371
   )
   @Export("npcCycle")
   int npcCycle;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -1158014437
   )
   @Export("logicalHeight")
   int logicalHeight;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 161562051
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 655517349
   )
   int field1177;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 70060761
   )
   int field1193;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -1315702887
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("ck")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cm")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cg")
   @Export("pathTraversed")
   byte[] pathTraversed;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -1502621989
   )
   int field1192;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -122683551
   )
   int field1178;

   Actor() {
      this.field1142 = false;
      this.field1143 = 1;
      this.idlePoseAnimation = -1;
      this.field1189 = -1;
      this.field1157 = -1;
      this.field1148 = -1;
      this.field1149 = -1;
      this.field1150 = -1;
      this.field1180 = -1;
      this.field1152 = -1;
      this.overhead = null;
      this.field1155 = false;
      this.overheadTextCyclesRemaining = 100;
      this.field1159 = 0;
      this.field1158 = 0;
      this.field1146 = 0;
      this.field1160 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1163 = new int[4];
      this.field1164 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1167 = false;
      this.field1168 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.poseFrameCycle = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.actionFrameCycle = 0;
      this.actionAnimationDisable = 0;
      this.field1176 = 0;
      this.graphic = -1;
      this.spotAnimFrame = 0;
      this.spotAnimFrameCycle = 0;
      this.npcCycle = 0;
      this.logicalHeight = 200;
      this.field1177 = 0;
      this.field1193 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.pathTraversed = new byte[10];
      this.field1192 = 0;
      this.field1178 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "14"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2130353256"
   )
   final void method1707() {
      this.queueSize = 0;
      this.field1178 = 0;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "410924527"
   )
   final void method1703(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class281 var12 = FileRequest.method4638(var1);
         var10 = var12.field3585;
         var11 = var12.field3580;
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
            this.field1146 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1146;
            this.field1146 = (byte)((this.field1146 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1160[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1163[var9] = var3;
         this.field1164[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1520736182"
   )
   @Export("setCombatInfo")
   @Hook("onSetCombatInfo")
   final void setCombatInfo(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field3524.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field3526.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.read(new Buffer(var9));
         }

         CombatInfo2.field3524.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var7.field3529;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.last(); var13 != null; var13 = (CombatInfoListHolder)this.combatInfoList.previous()) {
         ++var12;
         if(var13.combatInfo2.field3535 == var8.field3535) {
            var13.method1923(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field3528 <= var8.field3528) {
            var14 = var13;
         }

         if(var13.combatInfo2.field3529 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field3529;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var8);
         if(var14 == null) {
            this.combatInfoList.addLast(var13);
         } else {
            CombatInfoList.method4064(var13, var14);
         }

         var13.method1923(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1793361015"
   )
   final void method1704(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3524.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3526.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.read(new Buffer(var4));
         }

         CombatInfo2.field3524.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.last(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.previous()) {
         if(var3 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }
}
