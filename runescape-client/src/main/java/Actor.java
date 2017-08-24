import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1683377119
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -2033954535
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("cf")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("ai")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("ca")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("ad")
   boolean field1284;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -146162999
   )
   int field1249;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 886185713
   )
   int field1257;
   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("as")
   byte field1248;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 809800769
   )
   int field1287;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -34855065
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -346108027
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1712642551
   )
   int field1233;
   @ObfuscatedName("ae")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -552446729
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -2095781849
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1361796227
   )
   int field1253;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 122520469
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1226959879
   )
   int field1251;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1818439895
   )
   int field1268;
   @ObfuscatedName("cw")
   byte[] field1286;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -283619599
   )
   int field1238;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 863402815
   )
   @Export("x")
   int x;
   @ObfuscatedName("ap")
   int[] field1236;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -264538697
   )
   int field1288;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1049875595
   )
   int field1230;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1241868663
   )
   @Export("y")
   int y;
   @ObfuscatedName("au")
   int[] field1252;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1838655411
   )
   int field1272;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -2036023117
   )
   int field1279;
   @ObfuscatedName("bp")
   int[] field1278;
   @ObfuscatedName("av")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 110451787
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("aw")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1905625495
   )
   int field1267;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 664487387
   )
   int field1245;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -111267575
   )
   int field1246;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1408317861
   )
   int field1237;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1970648103
   )
   int field1270;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1620498857
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bc")
   boolean field1264;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 869450233
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1252109679
   )
   int field1273;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -85126425
   )
   int field1263;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -100493725
   )
   int field1265;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 54359959
   )
   int field1240;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1271748193
   )
   int field1260;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -289908789
   )
   int field1281;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 894896453
   )
   int field1282;
   @ObfuscatedName("ao")
   boolean field1243;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1812331465
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1076820685
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 14509567
   )
   int field1275;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 746935077
   )
   int field1276;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 228704943
   )
   int field1271;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1298310843
   )
   int field1229;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1911462359
   )
   int field1239;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1226824403
   )
   int field1274;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -780677553
   )
   int field1277;

   Actor() {
      this.field1284 = false;
      this.field1233 = 1;
      this.idlePoseAnimation = -1;
      this.field1253 = -1;
      this.field1251 = -1;
      this.field1268 = -1;
      this.field1238 = -1;
      this.field1288 = -1;
      this.field1230 = -1;
      this.field1272 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1245 = 100;
      this.field1246 = 0;
      this.field1237 = 0;
      this.field1248 = 0;
      this.field1236 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1252 = new int[4];
      this.field1278 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1264 = false;
      this.field1257 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1273 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1263 = 0;
      this.actionAnimationDisable = 0;
      this.field1265 = 0;
      this.graphic = -1;
      this.field1267 = 0;
      this.field1240 = 0;
      this.field1260 = 0;
      this.field1279 = 200;
      this.field1281 = 0;
      this.field1282 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1286 = new byte[10];
      this.field1287 = 0;
      this.field1249 = 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-13887992"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-53"
   )
   final void method1525(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class255 var12 = class61.method1090(var1);
         var10 = var12.field3416;
         var11 = var12.field3420;
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
            this.field1248 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1248;
            this.field1248 = (byte)((this.field1248 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1236[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1252[var9] = var3;
         this.field1278[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "121"
   )
   final void method1527(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3366.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3370.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.method4397(new Buffer(var4));
         }

         CombatInfo2.field3366.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.method3642(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.method3644()) {
         if(var3 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IIIIIIS)V",
      garbageValue = "253"
   )
   final void method1522(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = class245.method4329(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field3368;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method3642(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.method3644()) {
         ++var11;
         if(var12.combatInfo2.field3369 == var7.field3369) {
            var12.method1688(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field3364 <= var7.field3364) {
            var8 = var12;
         }

         if(var12.combatInfo2.field3368 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field3368;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.method3639(var12);
         } else {
            CombatInfoList.method3640(var12, var8);
         }

         var12.method1688(var2 + var4, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1758905730"
   )
   final void method1528() {
      this.queueSize = 0;
      this.field1249 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1786922006"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class73.listFetcher == null) {
            class73.listFetcher = class10.field264.method2955(new URL(class17.field321));
         } else if(class73.listFetcher.method2963()) {
            byte[] var0 = class73.listFetcher.method2959();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            World.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = World.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            class205.method3874(World.worldList, 0, World.worldList.length - 1, World.field1303, World.field1302);
            class73.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class73.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-279130403"
   )
   public static int method1537(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("jf")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "-1148530457"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = Frames.method2925(var0, class8.field243);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(Frames.method2925(Client.friends[var3].name, class8.field243)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(Frames.method2925(Player.localPlayer.name, class8.field243))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILck;ZI)I",
      garbageValue = "2043499727"
   )
   static int method1539(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = GZipDecompressor.method3177(class82.intStack[--Ignore.intStackSize]);
      } else {
         var3 = var2?class31.field452:class23.field366;
      }

      String var4 = class82.scriptStringStack[--class169.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var6 = class82.intStack[--Ignore.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class82.intStack[--Ignore.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var8[var7] = class82.scriptStringStack[--class169.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class82.intStack[--Ignore.intStackSize]);
         }
      }

      var7 = class82.intStack[--Ignore.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2669 = var8;
      } else if(var0 == 1401) {
         var3.field2742 = var8;
      } else if(var0 == 1402) {
         var3.field2711 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2747 = var8;
      } else if(var0 == 1406) {
         var3.field2750 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2701 = var8;
      } else if(var0 == 1410) {
         var3.field2730 = var8;
      } else if(var0 == 1411) {
         var3.field2744 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2749 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2760 = var8;
      } else if(var0 == 1419) {
         var3.field2648 = var8;
      } else if(var0 == 1420) {
         var3.field2762 = var8;
      } else if(var0 == 1421) {
         var3.field2763 = var8;
      } else if(var0 == 1422) {
         var3.field2790 = var8;
      } else if(var0 == 1423) {
         var3.field2765 = var8;
      } else if(var0 == 1424) {
         var3.field2788 = var8;
      } else if(var0 == 1425) {
         var3.field2768 = var8;
      } else if(var0 == 1426) {
         var3.field2737 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2767 = var8;
      }

      var3.field2785 = true;
      return 1;
   }
}
