import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -630487103
   )
   @Export("x")
   int x;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1082089417
   )
   @Export("y")
   int y;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -896308611
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("aq")
   boolean field1147;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 129713491
   )
   int field1148;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -821036515
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -89879373
   )
   int field1150;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1795745857
   )
   int field1171;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1335971575
   )
   int field1152;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -763927279
   )
   int field1153;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1125904545
   )
   int field1154;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1014819965
   )
   int field1155;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 75775955
   )
   int field1166;
   @ObfuscatedName("al")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("aj")
   boolean field1158;
   @ObfuscatedName("ap")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1457563797
   )
   int field1201;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1697466905
   )
   int field1161;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -626601069
   )
   int field1145;
   @ObfuscatedName("ax")
   byte field1192;
   @ObfuscatedName("ai")
   int[] field1163;
   @ObfuscatedName("az")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("aa")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("ad")
   int[] field1167;
   @ObfuscatedName("ba")
   int[] field1168;
   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 578018711
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bc")
   boolean field1187;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 116989285
   )
   int field1172;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 1123634713
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -2127247185
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 1932303597
   )
   int field1175;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1339104125
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1740393707
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1586376785
   )
   int field1144;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 2046521409
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1139456901
   )
   int field1188;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 174243361
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 137162583
   )
   int field1190;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1281462883
   )
   int field1183;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -303369443
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 987995939
   )
   int field1185;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1469523667
   )
   int field1186;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1030370361
   )
   int field1174;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1512304795
   )
   int field1162;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -872037627
   )
   int field1164;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -151758219
   )
   int field1178;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1894751635
   )
   int field1191;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -588049559
   )
   int field1195;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -130988597
   )
   int field1193;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 1233039021
   )
   int field1151;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -975270201
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1325903341
   )
   int field1160;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -1772528509
   )
   int field1197;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1115224275
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("cz")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cy")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cj")
   byte[] field1189;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 2085494403
   )
   int field1202;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 518280521
   )
   int field1203;

   Actor() {
      this.field1147 = false;
      this.field1148 = 1;
      this.idlePoseAnimation = -1;
      this.field1150 = -1;
      this.field1171 = -1;
      this.field1152 = -1;
      this.field1153 = -1;
      this.field1154 = -1;
      this.field1155 = -1;
      this.field1166 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1201 = 100;
      this.field1161 = 0;
      this.field1145 = 0;
      this.field1192 = 0;
      this.field1163 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1167 = new int[4];
      this.field1168 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1187 = false;
      this.field1172 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1175 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1144 = 0;
      this.actionAnimationDisable = 0;
      this.field1188 = 0;
      this.graphic = -1;
      this.field1190 = 0;
      this.field1183 = 0;
      this.field1193 = 0;
      this.field1151 = 200;
      this.field1160 = 0;
      this.field1197 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1189 = new byte[10];
      this.field1202 = 0;
      this.field1203 = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "43"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-88"
   )
   final void method1496() {
      this.queueSize = 0;
      this.field1203 = 0;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "68"
   )
   final void method1501(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class261 var12 = GameEngine.method935(var1);
         var10 = var12.field3479;
         var11 = var12.field3470;
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
            this.field1192 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1192;
            this.field1192 = (byte)((this.field1192 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1163[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1167[var9] = var3;
         this.field1168[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-54756670"
   )
   final void method1511(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = ItemLayer.method2417(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field3416;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method3611(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.method3613()) {
         ++var11;
         if(var12.combatInfo2.field3414 == var7.field3414) {
            var12.method1644(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field3415 <= var7.field3415) {
            var8 = var12;
         }

         if(var12.combatInfo2.field3416 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field3416;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.method3608(var12);
         } else {
            CombatInfoList.method3609(var12, var8);
         }

         var12.method1644(var2 + var4, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1539552640"
   )
   final void method1495(int var1) {
      CombatInfo2 var2 = ItemLayer.method2417(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method3611(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.method3613()) {
         if(var2 == var3.combatInfo2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Ldk;I)V",
      garbageValue = "-2029515345"
   )
   static final void method1498(class118 var0) {
      var0.field1628 = false;
      if(var0.field1630 != null) {
         var0.field1630.field1662 = 0;
      }

      for(class118 var1 = var0.vmethod3931(); var1 != null; var1 = var0.vmethod3946()) {
         method1498(var1);
      }

   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(ZLgd;I)V",
      garbageValue = "-1660681663"
   )
   static final void method1513(boolean var0, PacketBuffer var1) {
      while(true) {
         if(var1.bitsAvail(Client.field905.packetLength) >= 27) {
            int var2 = var1.getBits(15);
            if(var2 != 32767) {
               boolean var3 = false;
               if(Client.cachedNPCs[var2] == null) {
                  Client.cachedNPCs[var2] = new NPC();
                  var3 = true;
               }

               NPC var4 = Client.cachedNPCs[var2];
               Client.npcIndices[++Client.npcIndexesCount - 1] = var2;
               var4.field1193 = Client.gameCycle;
               int var5 = var1.getBits(1);
               if(var5 == 1) {
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               }

               var4.composition = class211.getNpcDefinition(var1.getBits(14));
               int var6 = Client.field865[var1.getBits(3)];
               if(var3) {
                  var4.orientation = var4.angle = var6;
               }

               int var7;
               if(var0) {
                  var7 = var1.getBits(8);
                  if(var7 > 127) {
                     var7 -= 256;
                  }
               } else {
                  var7 = var1.getBits(5);
                  if(var7 > 15) {
                     var7 -= 32;
                  }
               }

               int var8;
               if(var0) {
                  var8 = var1.getBits(8);
                  if(var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = var1.getBits(5);
                  if(var8 > 15) {
                     var8 -= 32;
                  }
               }

               int var9 = var1.getBits(1);
               var4.field1148 = var4.composition.field3606;
               var4.field1197 = var4.composition.field3616;
               if(var4.field1197 == 0) {
                  var4.angle = 0;
               }

               var4.field1152 = var4.composition.field3624;
               var4.field1153 = var4.composition.field3603;
               var4.field1154 = var4.composition.field3614;
               var4.field1155 = var4.composition.field3622;
               var4.idlePoseAnimation = var4.composition.field3609;
               var4.field1150 = var4.composition.field3629;
               var4.field1171 = var4.composition.field3633;
               var4.method1659(class275.localPlayer.pathX[0] + var7, class275.localPlayer.pathY[0] + var8, var9 == 1);
               continue;
            }
         }

         var1.byteAccess();
         return;
      }
   }
}
