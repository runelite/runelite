import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ba")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -769054461
   )
   @Export("x")
   int x;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1116788229
   )
   @Export("y")
   int y;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 135285983
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("ah")
   boolean field1159;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1173246315
   )
   int field1172;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1409714879
   )
   int field1161;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -755612717
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -632448693
   )
   int field1163;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -829512987
   )
   int field1164;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -801553363
   )
   int field1165;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1325838745
   )
   int field1209;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -934672543
   )
   int field1167;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 92194687
   )
   int field1177;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1205917773
   )
   int field1169;
   @ObfuscatedName("au")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("ar")
   boolean field1168;
   @ObfuscatedName("an")
   boolean field1157;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1122083869
   )
   @Export("overheadTextCyclesRemaining")
   int overheadTextCyclesRemaining;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 399997079
   )
   int field1174;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 2057911213
   )
   int field1175;
   @ObfuscatedName("aj")
   byte field1176;
   @ObfuscatedName("ay")
   int[] field1180;
   @ObfuscatedName("bm")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("bx")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("bl")
   int[] field1183;
   @ObfuscatedName("bf")
   int[] field1181;
   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 857382859
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bu")
   boolean field1156;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -18175961
   )
   int field1185;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1054311497
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1195204295
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -965662805
   )
   @Export("poseFrameCycle")
   int poseFrameCycle;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1498911453
   )
   @Export("animation")
   int animation;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 557034421
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 2146750481
   )
   @Export("actionFrameCycle")
   int actionFrameCycle;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -241491583
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1219352001
   )
   int field1193;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1728289279
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1791187899
   )
   @Export("spotAnimFrame")
   int spotAnimFrame;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1790377669
   )
   @Export("spotAnimFrameCycle")
   int spotAnimFrameCycle;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -775753729
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -198375057
   )
   int field1198;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -344367893
   )
   int field1203;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 2067505127
   )
   int field1200;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -75603817
   )
   int field1199;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -2010246257
   )
   int field1202;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 271693367
   )
   int field1166;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 919593021
   )
   int field1204;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -54273033
   )
   int field1171;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 687025847
   )
   @Export("npcCycle")
   int npcCycle;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -857275293
   )
   @Export("logicalHeight")
   int logicalHeight;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 142971775
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -740551005
   )
   int field1184;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -603160961
   )
   int field1205;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -1572892415
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("cu")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cm")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cw")
   @Export("pathTraversed")
   byte[] pathTraversed;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 1132756827
   )
   int field1158;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 1799130381
   )
   int field1216;

   Actor() {
      this.field1159 = false;
      this.field1172 = 1;
      this.idlePoseAnimation = -1;
      this.field1163 = -1;
      this.field1164 = -1;
      this.field1165 = -1;
      this.field1209 = -1;
      this.field1167 = -1;
      this.field1177 = -1;
      this.field1169 = -1;
      this.overhead = null;
      this.field1157 = false;
      this.overheadTextCyclesRemaining = 100;
      this.field1174 = 0;
      this.field1175 = 0;
      this.field1176 = 0;
      this.field1180 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1183 = new int[4];
      this.field1181 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1156 = false;
      this.field1185 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.poseFrameCycle = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.actionFrameCycle = 0;
      this.actionAnimationDisable = 0;
      this.field1193 = 0;
      this.graphic = -1;
      this.spotAnimFrame = 0;
      this.spotAnimFrameCycle = 0;
      this.npcCycle = 0;
      this.logicalHeight = 200;
      this.field1184 = 0;
      this.field1205 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.pathTraversed = new byte[10];
      this.field1158 = 0;
      this.field1216 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1204510929"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-784523598"
   )
   final void method1655() {
      this.queueSize = 0;
      this.field1216 = 0;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1600365055"
   )
   final void method1657(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class281 var12 = Huffman.method3457(var1);
         var10 = var12.field3588;
         var11 = var12.field3575;
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
            this.field1176 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1176;
            this.field1176 = (byte)((this.field1176 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1180[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1183[var9] = var3;
         this.field1181[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-32"
   )
   @Export("setCombatInfo")
   @Hook("onSetCombatInfo")
   final void setCombatInfo(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field3524.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field3532.getConfigData(33, var1);
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
         if(var13.combatInfo2.field3526 == var8.field3526) {
            var13.method1859(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field3536 <= var8.field3536) {
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
            CombatInfoList.method3987(var13, var14);
         }

         var13.method1859(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-33"
   )
   final void method1659(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3524.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3532.getConfigData(33, var1);
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "2"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }
}
