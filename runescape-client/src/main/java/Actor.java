import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1778826247
   )
   @Export("x")
   int x;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1515985559
   )
   @Export("y")
   int y;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -395704265
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("as")
   boolean field1146;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -447585633
   )
   int field1201;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1463613351
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1226464351
   )
   int field1149;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 2036020061
   )
   int field1150;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -290940151
   )
   int field1151;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -434021365
   )
   int field1152;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1220647051
   )
   int field1153;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -770434237
   )
   int field1154;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -809543743
   )
   int field1155;
   @ObfuscatedName("az")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("aw")
   boolean field1147;
   @ObfuscatedName("au")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -507754877
   )
   int field1148;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 2042985965
   )
   int field1160;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 855377763
   )
   int field1188;
   @ObfuscatedName("aa")
   byte field1162;
   @ObfuscatedName("ad")
   int[] field1169;
   @ObfuscatedName("aj")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("ae")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("ar")
   int[] field1166;
   @ObfuscatedName("bu")
   int[] field1167;
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -35436119
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bl")
   boolean field1170;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1723463319
   )
   int field1202;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1357178093
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1611073013
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1931069929
   )
   int field1193;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1927744373
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1834122795
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -266327201
   )
   int field1179;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -45394519
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -157954321
   )
   int field1163;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1820349561
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1935068401
   )
   int field1181;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1452517237
   )
   int field1182;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1441542933
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -778415425
   )
   int field1184;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 408203791
   )
   int field1185;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -823681747
   )
   int field1143;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -911879023
   )
   int field1159;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 914995117
   )
   int field1199;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -194756483
   )
   int field1164;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -74687783
   )
   int field1177;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1629985293
   )
   int field1191;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -677712789
   )
   int field1192;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -12444289
   )
   int field1161;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -115664019
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -225281611
   )
   int field1195;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 323319001
   )
   int field1196;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -572918095
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("cc")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cy")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cp")
   byte[] field1189;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 779879485
   )
   int field1157;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 36901973
   )
   int field1186;

   Actor() {
      this.field1146 = false;
      this.field1201 = 1;
      this.idlePoseAnimation = -1;
      this.field1149 = -1;
      this.field1150 = -1;
      this.field1151 = -1;
      this.field1152 = -1;
      this.field1153 = -1;
      this.field1154 = -1;
      this.field1155 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1148 = 100;
      this.field1160 = 0;
      this.field1188 = 0;
      this.field1162 = 0;
      this.field1169 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1166 = new int[4];
      this.field1167 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1170 = false;
      this.field1202 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1193 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1179 = 0;
      this.actionAnimationDisable = 0;
      this.field1163 = 0;
      this.graphic = -1;
      this.field1181 = 0;
      this.field1182 = 0;
      this.field1192 = 0;
      this.field1161 = 200;
      this.field1195 = 0;
      this.field1196 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1189 = new byte[10];
      this.field1157 = 0;
      this.field1186 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "762696752"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-886930827"
   )
   final void method1622() {
      this.queueSize = 0;
      this.field1186 = 0;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1962900050"
   )
   final void method1617(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class261 var12 = class10.method55(var1);
         var10 = var12.field3481;
         var11 = var12.field3472;
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
            this.field1162 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1162;
            this.field1162 = (byte)((this.field1162 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1169[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1166[var9] = var3;
         this.field1167[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1389002933"
   )
   final void method1618(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field3416.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field3420.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.method4572(new Buffer(var9));
         }

         CombatInfo2.field3416.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var7.field3425;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.method3741(); var13 != null; var13 = (CombatInfoListHolder)this.combatInfoList.method3743()) {
         ++var12;
         if(var13.combatInfo2.field3419 == var8.field3419) {
            var13.method1756(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field3422 <= var8.field3422) {
            var14 = var13;
         }

         if(var13.combatInfo2.field3425 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field3425;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var8);
         if(var14 == null) {
            this.combatInfoList.method3740(var13);
         } else {
            CombatInfoList.method3738(var13, var14);
         }

         var13.method1756(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1461998392"
   )
   final void method1619(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3416.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3420.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.method4572(new Buffer(var4));
         }

         CombatInfo2.field3416.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.method3741(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.method3743()) {
         if(var3 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfo;Lga;B)Lfg;",
      garbageValue = "1"
   )
   public static class170 method1628(ClientPacket var0, ISAACCipher var1) {
      class170 var2 = class11.method60();
      var2.field2424 = var0;
      var2.field2427 = var0.packetLength;
      if(var2.field2427 == -1) {
         var2.field2423 = new PacketBuffer(260);
      } else if(var2.field2427 == -2) {
         var2.field2423 = new PacketBuffer(10000);
      } else if(var2.field2427 <= 18) {
         var2.field2423 = new PacketBuffer(20);
      } else if(var2.field2427 <= 98) {
         var2.field2423 = new PacketBuffer(100);
      } else {
         var2.field2423 = new PacketBuffer(260);
      }

      var2.field2423.method3568(var1);
      var2.field2423.putOpcode(var2.field2424.packetId);
      var2.field2426 = 0;
      return var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1498333382"
   )
   public static boolean method1629(char var0) {
      return var0 >= '0' && var0 <= '9';
   }
}
