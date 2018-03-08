import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 2120944323
   )
   @Export("x")
   int x;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 2025105747
   )
   @Export("y")
   int y;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 118621523
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("az")
   boolean field1165;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -193754931
   )
   int field1139;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 649803795
   )
   int field1141;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 932306455
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -809107953
   )
   int field1143;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1031126665
   )
   int field1164;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -360236351
   )
   int field1145;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -105408705
   )
   int field1158;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -22041543
   )
   int field1147;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 774983361
   )
   int field1148;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 707640123
   )
   int field1194;
   @ObfuscatedName("as")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("aw")
   boolean field1151;
   @ObfuscatedName("aq")
   boolean field1152;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1819583597
   )
   @Export("overheadTextCyclesRemaining")
   int overheadTextCyclesRemaining;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -507662229
   )
   int field1149;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -2103853675
   )
   int field1155;
   @ObfuscatedName("ac")
   byte field1156;
   @ObfuscatedName("ad")
   int[] field1157;
   @ObfuscatedName("bg")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("br")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("ba")
   int[] field1160;
   @ObfuscatedName("bk")
   int[] field1161;
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1066605661
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bm")
   boolean field1188;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1719092295
   )
   int field1142;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -311146783
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1048704947
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1170479349
   )
   int field1168;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1975994063
   )
   @Export("animation")
   int animation;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -797403989
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 643850469
   )
   int field1140;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1519238471
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -2035452989
   )
   int field1186;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 297613947
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1946148451
   )
   int field1175;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1476010501
   )
   int field1176;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1543223173
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1519990867
   )
   int field1178;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1291443491
   )
   int field1159;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1553239147
   )
   int field1146;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1697160077
   )
   int field1181;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 583766895
   )
   int field1182;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 412321529
   )
   int field1183;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1630492753
   )
   int field1184;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 110838005
   )
   int field1185;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -113052095
   )
   @Export("npcCycle")
   int npcCycle;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1551526013
   )
   @Export("logicalHeight")
   int logicalHeight;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 639300797
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1561459483
   )
   int field1150;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -416661639
   )
   int field1190;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 1475507379
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("co")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cv")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cd")
   @Export("pathTraversed")
   byte[] pathTraversed;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1833693597
   )
   int field1195;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 1869641657
   )
   int field1196;

   Actor() {
      this.field1165 = false;
      this.field1139 = 1;
      this.idlePoseAnimation = -1;
      this.field1143 = -1;
      this.field1164 = -1;
      this.field1145 = -1;
      this.field1158 = -1;
      this.field1147 = -1;
      this.field1148 = -1;
      this.field1194 = -1;
      this.overhead = null;
      this.field1152 = false;
      this.overheadTextCyclesRemaining = 100;
      this.field1149 = 0;
      this.field1155 = 0;
      this.field1156 = 0;
      this.field1157 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1160 = new int[4];
      this.field1161 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1188 = false;
      this.field1142 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1168 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1140 = 0;
      this.actionAnimationDisable = 0;
      this.field1186 = 0;
      this.graphic = -1;
      this.field1175 = 0;
      this.field1176 = 0;
      this.npcCycle = 0;
      this.logicalHeight = 200;
      this.field1150 = 0;
      this.field1190 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.pathTraversed = new byte[10];
      this.field1195 = 0;
      this.field1196 = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1675922393"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-76"
   )
   final void method1651() {
      this.queueSize = 0;
      this.field1196 = 0;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1183583918"
   )
   final void method1653(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class281 var12 = PendingSpawn.method1649(var1);
         var10 = var12.field3575;
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
            this.field1156 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1156;
            this.field1156 = (byte)((this.field1156 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1157[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1160[var9] = var3;
         this.field1161[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1192596976"
   )
   final void method1654(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field3527.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field3525.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.read(new Buffer(var9));
         }

         CombatInfo2.field3527.put(var8, (long)var1);
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
         if(var13.combatInfo2.field3536 == var8.field3536) {
            var13.method1887(var2 + var4, var5, var6, var3);
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
            CombatInfoList.method3992(var13, var14);
         }

         var13.method1887(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2104031781"
   )
   final void method1655(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3527.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3525.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.read(new Buffer(var4));
         }

         CombatInfo2.field3527.put(var3, (long)var1);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "352402987"
   )
   static final int method1650(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.putByte(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.putInt(var6[0]);
      var4.putInt(var6[1]);
      var4.putLong(var0);
      var4.putLong(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.encryptRsa(class85.field1289, class85.field1290);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3722(var3.nextLong());
      if(Client.field888 != null) {
         var5.putBytes(Client.field888, 0, Client.field888.length);
      } else {
         byte[] var8 = new byte[24];

         try {
            class167.randomDat.seek(0L);
            class167.randomDat.read(var8);

            int var9;
            for(var9 = 0; var9 < 24 && var8[var9] == 0; ++var9) {
               ;
            }

            if(var9 >= 24) {
               throw new IOException();
            }
         } catch (Exception var24) {
            for(int var10 = 0; var10 < 24; ++var10) {
               var8[var10] = -1;
            }
         }

         var5.putBytes(var8, 0, var8.length);
      }

      var5.putLong(var3.nextLong());
      var5.encryptRsa(class85.field1289, class85.field1290);
      var7 = UnitPriceComparator.getLength(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var25 = new Buffer(var7);
      var25.putString(var2);
      var25.offset = var7;
      var25.encryptXtea2(var6);
      Buffer var18 = new Buffer(var4.offset + var5.offset + var25.offset + 5);
      var18.putByte(2);
      var18.putByte(var4.offset);
      var18.putBytes(var4.payload, 0, var4.offset);
      var18.putByte(var5.offset);
      var18.putBytes(var5.payload, 0, var5.offset);
      var18.putShort(var25.offset);
      var18.putBytes(var25.payload, 0, var25.offset);
      String var20 = Client.method1303(var18.payload);

      try {
         URL var11 = new URL(ClanMember.method5226("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class321.method5644(var20) + "&dest=" + class321.method5644("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var18 = new Buffer(new byte[1000]);

         do {
            int var15 = var14.read(var18.payload, var18.offset, 1000 - var18.offset);
            if(var15 == -1) {
               var13.close();
               var14.close();
               String var21 = new String(var18.payload);
               if(var21.startsWith("OFFLINE")) {
                  return 4;
               } else if(var21.startsWith("WRONG")) {
                  return 7;
               } else if(var21.startsWith("RELOAD")) {
                  return 3;
               } else if(var21.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var18.decryptXtea(var6);

                  while(var18.offset > 0 && var18.payload[var18.offset - 1] == 0) {
                     --var18.offset;
                  }

                  var21 = new String(var18.payload, 0, var18.offset);
                  boolean var16;
                  if(var21 == null) {
                     var16 = false;
                  } else {
                     label106: {
                        try {
                           new URL(var21);
                        } catch (MalformedURLException var22) {
                           var16 = false;
                           break label106;
                        }

                        var16 = true;
                     }
                  }

                  if(var16) {
                     MouseInput.method1090(var21, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var18.offset += var15;
         } while(var18.offset < 1000);

         return 5;
      } catch (Throwable var23) {
         var23.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-272660217"
   )
   static int method1667(int var0) {
      MessageNode var1 = (MessageNode)class95.messages.get((long)var0);
      return var1 == null?-1:(var1.previous == class95.field1421.sentinel?-1:((MessageNode)var1.previous).id);
   }
}
