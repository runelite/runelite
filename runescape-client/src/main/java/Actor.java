import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1076215651
   )
   @Export("x")
   int x;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -285612057
   )
   @Export("y")
   int y;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1267509975
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("ad")
   boolean field1152;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -628501263
   )
   int field1153;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -218939717
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 882934373
   )
   int field1156;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 717352753
   )
   int field1173;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1737429079
   )
   int field1168;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 746605211
   )
   int field1158;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1251780415
   )
   int field1175;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1489026081
   )
   int field1160;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 572323557
   )
   int field1161;
   @ObfuscatedName("aa")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("ao")
   boolean field1195;
   @ObfuscatedName("al")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1788934009
   )
   @Export("overheadTextCyclesRemaining")
   int overheadTextCyclesRemaining;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1583470921
   )
   int field1166;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1868301331
   )
   int field1167;
   @ObfuscatedName("au")
   byte field1204;
   @ObfuscatedName("an")
   int[] field1182;
   @ObfuscatedName("ai")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("ap")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("ar")
   int[] field1183;
   @ObfuscatedName("bg")
   int[] field1192;
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -618462711
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("by")
   boolean field1176;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 906074889
   )
   int field1177;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 989775105
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 2087161769
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1191155157
   )
   int field1180;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -263292343
   )
   @Export("animation")
   int animation;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -434008135
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1170039769
   )
   int field1159;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 287469253
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 788748713
   )
   int field1185;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1220883345
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 52213765
   )
   int field1187;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -347537681
   )
   int field1188;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 790102567
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 2066981693
   )
   int field1190;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1719385705
   )
   int field1191;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1214890751
   )
   int field1174;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -1266232999
   )
   int field1193;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 399790373
   )
   int field1206;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -426609727
   )
   int field1200;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 2046398673
   )
   int field1196;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -128131127
   )
   int field1197;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 506649515
   )
   @Export("npcCycle")
   int npcCycle;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 998005777
   )
   int field1199;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -1579612309
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -1566513313
   )
   int field1201;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -451202341
   )
   int field1202;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = -487939213
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("cs")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cb")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cq")
   @Export("pathTraversed")
   byte[] pathTraversed;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -225972443
   )
   int field1207;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -563940271
   )
   int field1208;

   Actor() {
      this.field1152 = false;
      this.field1153 = 1;
      this.idlePoseAnimation = -1;
      this.field1156 = -1;
      this.field1173 = -1;
      this.field1168 = -1;
      this.field1158 = -1;
      this.field1175 = -1;
      this.field1160 = -1;
      this.field1161 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.overheadTextCyclesRemaining = 100;
      this.field1166 = 0;
      this.field1167 = 0;
      this.field1204 = 0;
      this.field1182 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1183 = new int[4];
      this.field1192 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1176 = false;
      this.field1177 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1180 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1159 = 0;
      this.actionAnimationDisable = 0;
      this.field1185 = 0;
      this.graphic = -1;
      this.field1187 = 0;
      this.field1188 = 0;
      this.npcCycle = 0;
      this.field1199 = 200;
      this.field1201 = 0;
      this.field1202 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.pathTraversed = new byte[10];
      this.field1207 = 0;
      this.field1208 = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1401638549"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-487141564"
   )
   final void method1572() {
      this.queueSize = 0;
      this.field1208 = 0;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "2012166848"
   )
   final void method1560(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class265 var12 = PacketNode.method3257(var1);
         var10 = var12.field3512;
         var11 = var12.field3503;
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
            this.field1204 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1204;
            this.field1204 = (byte)((this.field1204 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1182[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1183[var9] = var3;
         this.field1192[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1833975134"
   )
   final void method1556(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field3452.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field3455.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.read(new Buffer(var9));
         }

         CombatInfo2.field3452.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var7.field3454;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.last(); var13 != null; var13 = (CombatInfoListHolder)this.combatInfoList.previous()) {
         ++var12;
         if(var13.combatInfo2.field3456 == var8.field3456) {
            var13.method1696(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field3458 <= var8.field3458) {
            var14 = var13;
         }

         if(var13.combatInfo2.field3454 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field3454;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var8);
         if(var14 == null) {
            this.combatInfoList.addLast(var13);
         } else {
            CombatInfoList.method3766(var13, var14);
         }

         var13.method1696(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-893416181"
   )
   final void method1558(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3452.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3455.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.read(new Buffer(var4));
         }

         CombatInfo2.field3452.put(var3, (long)var1);
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

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "2"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      FontName.method4928();
      ++Client.field915.field1468;
      if(Client.field915.field1468 >= 50 || var0) {
         Client.field915.field1468 = 0;
         if(!Client.socketError && Client.field915.getSocket() != null) {
            PacketNode var1 = class235.method4272(ClientPacket.field2347, Client.field915.field1462);
            Client.field915.method1898(var1);

            try {
               Client.field915.method1900();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }

   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-22848431"
   )
   static String method1573(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(MessageNode.sessionToken != null) {
         var3 = "/p=" + MessageNode.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class19.field312 + var3 + "/";
   }
}
