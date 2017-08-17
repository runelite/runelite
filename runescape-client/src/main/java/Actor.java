import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1530881055
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 748458297
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("cm")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("ac")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("cg")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("an")
   boolean field1221;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1489928029
   )
   int field1246;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 927430567
   )
   int field1277;
   @ObfuscatedName("aq")
   byte field1232;
   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1696735851
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 615455251
   )
   int field1276;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1561483437
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1229979055
   )
   int field1219;
   @ObfuscatedName("ak")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1730629671
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1813977773
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1361194443
   )
   int field1241;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 998655681
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -687919529
   )
   int field1225;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 2130868025
   )
   int field1226;
   @ObfuscatedName("cp")
   byte[] field1251;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -360581127
   )
   int field1218;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1524088875
   )
   @Export("x")
   int x;
   @ObfuscatedName("ai")
   int[] field1238;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -537392499
   )
   int field1228;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1011620345
   )
   int field1229;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 566857091
   )
   @Export("y")
   int y;
   @ObfuscatedName("ay")
   int[] field1272;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -87598283
   )
   int field1222;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -55392365
   )
   int field1231;
   @ObfuscatedName("bk")
   int[] field1252;
   @ObfuscatedName("al")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -263200277
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("ah")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1253987247
   )
   int field1256;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -833365665
   )
   int field1274;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 597594911
   )
   int field1235;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1811265093
   )
   int field1236;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -449810663
   )
   int field1259;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1645647959
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bn")
   boolean field1245;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -471012125
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1414763737
   )
   int field1249;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -157000341
   )
   int field1267;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1291486851
   )
   int field1254;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 978309907
   )
   int field1257;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1375472813
   )
   int field1275;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -1419092019
   )
   int field1247;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 1021523617
   )
   int field1230;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1663130351
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1380931545
   )
   int field1264;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1211719167
   )
   int field1265;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 819078391
   )
   int field1260;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 2128095049
   )
   int field1262;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1222300335
   )
   int field1271;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1588811799
   )
   int field1263;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -800788573
   )
   int field1266;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -747779655
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("am")
   boolean field1273;

   Actor() {
      this.field1221 = false;
      this.field1219 = 1;
      this.idlePoseAnimation = -1;
      this.field1241 = -1;
      this.field1225 = -1;
      this.field1226 = -1;
      this.field1218 = -1;
      this.field1228 = -1;
      this.field1229 = -1;
      this.field1222 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1274 = 100;
      this.field1235 = 0;
      this.field1236 = 0;
      this.field1232 = 0;
      this.field1238 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1272 = new int[4];
      this.field1252 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1245 = false;
      this.field1246 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1249 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1267 = 0;
      this.actionAnimationDisable = 0;
      this.field1254 = 0;
      this.graphic = -1;
      this.field1256 = 0;
      this.field1257 = 0;
      this.field1275 = 0;
      this.field1231 = 200;
      this.field1247 = 0;
      this.field1230 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1251 = new byte[10];
      this.field1276 = 0;
      this.field1277 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1465758862"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "310714099"
   )
   final void method1525() {
      this.queueSize = 0;
      this.field1277 = 0;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1855397038"
   )
   final void method1528(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class255 var12 = BuildType.method4099(var1);
         var10 = var12.field3399;
         var11 = var12.field3410;
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
            this.field1232 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1232;
            this.field1232 = (byte)((this.field1232 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1238[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1272[var9] = var3;
         this.field1252[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "32"
   )
   final void method1530(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3350.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3349.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.method4420(new Buffer(var4));
         }

         CombatInfo2.field3350.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.method3572(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.method3589()) {
         if(var3 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIIIIS)V",
      garbageValue = "256"
   )
   final void method1529(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field3350.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field3349.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.method4420(new Buffer(var9));
         }

         CombatInfo2.field3350.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var7.field3353;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.method3572(); var13 != null; var13 = (CombatInfoListHolder)this.combatInfoList.method3589()) {
         ++var12;
         if(var13.combatInfo2.field3352 == var8.field3352) {
            var13.method1678(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field3348 <= var8.field3348) {
            var14 = var13;
         }

         if(var13.combatInfo2.field3353 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field3353;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var8);
         if(var14 == null) {
            this.combatInfoList.method3569(var13);
         } else {
            CombatInfoList.method3579(var13, var14);
         }

         var13.method1678(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-949325726"
   )
   static final void method1543() {
      Client.secretPacketBuffer1.putOpcode(187);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3558(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3559()) {
         if(var0.owner == 0 || var0.owner == 3) {
            class17.method127(var0, true);
         }
      }

      if(Client.field1090 != null) {
         class90.method1723(Client.field1090);
         Client.field1090 = null;
      }

   }
}
