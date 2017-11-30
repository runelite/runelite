import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("qr")
   static short[] field1182;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1951012149
   )
   @Export("x")
   int x;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -959431109
   )
   @Export("y")
   int y;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1662683967
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("as")
   boolean field1170;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -424594419
   )
   int field1126;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 135804315
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1827081249
   )
   int field1128;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1519268271
   )
   int field1176;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 342402717
   )
   int field1139;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1580296243
   )
   int field1131;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1249214737
   )
   int field1132;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2106773839
   )
   int field1123;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -367549997
   )
   int field1130;
   @ObfuscatedName("ai")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("af")
   boolean field1122;
   @ObfuscatedName("ah")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1918381959
   )
   @Export("overheadTextCyclesRemaining")
   int overheadTextCyclesRemaining;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 2012219815
   )
   int field1179;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1171071091
   )
   int field1140;
   @ObfuscatedName("aa")
   byte field1141;
   @ObfuscatedName("aj")
   int[] field1158;
   @ObfuscatedName("ao")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("ar")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("au")
   int[] field1161;
   @ObfuscatedName("bb")
   int[] field1146;
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -156297857
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bn")
   boolean field1149;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -734073771
   )
   int field1150;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -647845853
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1237351081
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -577565143
   )
   int field1153;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1823864565
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 944368229
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -841824793
   )
   int field1156;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1371068499
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 675260881
   )
   int field1124;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -1732957069
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1182962539
   )
   int field1160;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1648924149
   )
   int field1143;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 844238417
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1098486957
   )
   int field1163;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1036377899
   )
   int field1164;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1604377541
   )
   int field1165;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -654337759
   )
   int field1166;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1135345413
   )
   int field1125;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 546434635
   )
   int field1138;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1450727455
   )
   int field1169;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -2098084895
   )
   int field1133;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1830190809
   )
   @Export("npcCycle")
   int npcCycle;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -1048565403
   )
   int field1136;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -878372439
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 49694645
   )
   int field1174;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 1585038085
   )
   int field1175;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -979915637
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("cj")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cq")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("ci")
   @Export("pathTraversed")
   byte[] pathTraversed;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -313594865
   )
   int field1180;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 522336083
   )
   int field1155;

   Actor() {
      this.field1170 = false;
      this.field1126 = 1;
      this.idlePoseAnimation = -1;
      this.field1128 = -1;
      this.field1176 = -1;
      this.field1139 = -1;
      this.field1131 = -1;
      this.field1132 = -1;
      this.field1123 = -1;
      this.field1130 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.overheadTextCyclesRemaining = 100;
      this.field1179 = 0;
      this.field1140 = 0;
      this.field1141 = 0;
      this.field1158 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1161 = new int[4];
      this.field1146 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1149 = false;
      this.field1150 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1153 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1156 = 0;
      this.actionAnimationDisable = 0;
      this.field1124 = 0;
      this.graphic = -1;
      this.field1160 = 0;
      this.field1143 = 0;
      this.npcCycle = 0;
      this.field1136 = 200;
      this.field1174 = 0;
      this.field1175 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.pathTraversed = new byte[10];
      this.field1180 = 0;
      this.field1155 = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "591771192"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1386463969"
   )
   final void method1464() {
      this.queueSize = 0;
      this.field1155 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "34"
   )
   final void method1463(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class265 var12 = IndexData.method4378(var1);
         var10 = var12.field3503;
         var11 = var12.field3500;
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
            this.field1141 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1141;
            this.field1141 = (byte)((this.field1141 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1158[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1161[var9] = var3;
         this.field1146[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "2124740055"
   )
   final void method1467(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = GZipDecompressor.method3201(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field3448;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.last(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.previous()) {
         ++var11;
         if(var12.combatInfo2.field3455 == var7.field3455) {
            var12.method1620(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field3447 <= var7.field3447) {
            var8 = var12;
         }

         if(var12.combatInfo2.field3448 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field3448;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.addLast(var12);
         } else {
            CombatInfoList.method3717(var12, var8);
         }

         var12.method1620(var2 + var4, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "534290638"
   )
   final void method1468(int var1) {
      CombatInfo2 var2 = GZipDecompressor.method3201(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.last(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.previous()) {
         if(var2 == var3.combatInfo2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;Lib;I)V",
      garbageValue = "-531735453"
   )
   public static void method1466(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.SpotAnimationDefinition_indexCache = var0;
      Spotanim.SpotAnimationDefinition_modelIndexCache = var1;
   }
}
