import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = -683555093
   )
   static int field1198;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1375470861
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -524156841
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("cg")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("ab")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("ch")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 124095517
   )
   int field1209;
   @ObfuscatedName("ag")
   boolean field1192;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1379995129
   )
   int field1248;
   @ObfuscatedName("ap")
   byte field1189;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 717720209
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1652423013
   )
   int field1247;
   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1309330379
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -907038979
   )
   int field1216;
   @ObfuscatedName("al")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1732909041
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -805060093
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 820645543
   )
   int field1195;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -818341107
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1880826869
   )
   int field1196;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -914218059
   )
   int field1197;
   @ObfuscatedName("ct")
   byte[] field1246;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1820350671
   )
   int field1205;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 252003539
   )
   @Export("x")
   int x;
   @ObfuscatedName("aw")
   int[] field1202;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1202316209
   )
   int field1249;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 382477721
   )
   int field1200;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1230219673
   )
   @Export("y")
   int y;
   @ObfuscatedName("aj")
   int[] field1212;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1762648631
   )
   int field1217;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 1379369277
   )
   int field1239;
   @ObfuscatedName("bz")
   int[] field1237;
   @ObfuscatedName("aq")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -2142054645
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("an")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -939987337
   )
   int field1227;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1967970627
   )
   int field1213;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -237369839
   )
   int field1206;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 810587401
   )
   int field1211;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -766215433
   )
   int field1230;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -948038945
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bq")
   boolean field1219;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -1375211551
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1285710067
   )
   int field1220;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1262480935
   )
   int field1223;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1275116641
   )
   int field1218;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 682580059
   )
   int field1228;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 493665955
   )
   int field1238;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -68829221
   )
   int field1241;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -345638833
   )
   int field1242;
   @ObfuscatedName("ay")
   boolean field1203;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 464036523
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -456180427
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -214156823
   )
   int field1235;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1306765923
   )
   int field1207;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 127493517
   )
   int field1204;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1259375431
   )
   int field1233;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 602200643
   )
   int field1232;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1579291465
   )
   int field1201;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1590036539
   )
   int field1208;

   Actor() {
      this.field1192 = false;
      this.field1216 = 1;
      this.idlePoseAnimation = -1;
      this.field1195 = -1;
      this.field1196 = -1;
      this.field1197 = -1;
      this.field1205 = -1;
      this.field1249 = -1;
      this.field1200 = -1;
      this.field1217 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1213 = 100;
      this.field1206 = 0;
      this.field1211 = 0;
      this.field1189 = 0;
      this.field1202 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1212 = new int[4];
      this.field1237 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1219 = false;
      this.field1209 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1220 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1223 = 0;
      this.actionAnimationDisable = 0;
      this.field1218 = 0;
      this.graphic = -1;
      this.field1227 = 0;
      this.field1228 = 0;
      this.field1238 = 0;
      this.field1239 = 200;
      this.field1241 = 0;
      this.field1242 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1246 = new byte[10];
      this.field1247 = 0;
      this.field1248 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "2"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-3"
   )
   final void method1548(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class254 var12 = FileSystem.method4110(var1);
         var10 = var12.field3411;
         var11 = var12.field3413;
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
            this.field1189 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1189;
            this.field1189 = (byte)((this.field1189 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1202[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1212[var9] = var3;
         this.field1237[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1087282105"
   )
   final void method1539(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3346.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3356.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.method4365(new Buffer(var4));
         }

         CombatInfo2.field3346.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.method3581(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.method3576()) {
         if(var3 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-879771527"
   )
   final void method1537(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field3346.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field3356.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.method4365(new Buffer(var9));
         }

         CombatInfo2.field3346.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var7.field3348;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.method3581(); var13 != null; var13 = (CombatInfoListHolder)this.combatInfoList.method3576()) {
         ++var12;
         if(var13.combatInfo2.field3351 == var8.field3351) {
            var13.method1688(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field3347 <= var8.field3347) {
            var14 = var13;
         }

         if(var13.combatInfo2.field3348 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field3348;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var8);
         if(var14 == null) {
            this.combatInfoList.method3590(var13);
         } else {
            CombatInfoList.method3579(var13, var14);
         }

         var13.method1688(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-8"
   )
   final void method1534() {
      this.queueSize = 0;
      this.field1248 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Liw;",
      garbageValue = "-1120752491"
   )
   public static Varbit method1533(int var0) {
      Varbit var1 = (Varbit)Varbit.varbits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Varbit.varbit_ref.getConfigData(14, var0);
         var1 = new Varbit();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Varbit.varbits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-623370330"
   )
   public static int method1542(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-595233450"
   )
   static final void method1553(int var0, int var1, int var2, int var3, int var4) {
      class7.field224.method3577(new class8(var0, var1, var2, var3, var4));
   }
}
