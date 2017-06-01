import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -295989899
   )
   int field1242;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 542417901
   )
   @Export("y")
   int y;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -688401541
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1934612629
   )
   int field1245;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -2014602845
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("az")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 82889385
   )
   int field1248;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1246322129
   )
   int field1249;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1505716013
   )
   int field1250;
   @ObfuscatedName("ak")
   int[] field1251;
   @ObfuscatedName("ay")
   int[] field1252;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -540768639
   )
   int field1253;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1669008265
   )
   int field1254;
   @ObfuscatedName("av")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("ag")
   boolean field1256;
   @ObfuscatedName("cy")
   byte[] field1257;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1647277019
   )
   int field1258;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 2088465165
   )
   int field1259;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 2119899007
   )
   int field1260;
   @ObfuscatedName("aq")
   byte field1261;
   @ObfuscatedName("an")
   boolean field1262;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -569550505
   )
   int field1263;
   @ObfuscatedName("ao")
   int[] field1264;
   @ObfuscatedName("am")
   int[] field1265;
   @ObfuscatedName("be")
   int[] field1266;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1313651803
   )
   int field1267;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 2114425731
   )
   int field1268;
   @ObfuscatedName("bo")
   boolean field1269;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 52031979
   )
   int field1270;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 177387419
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -882685205
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1528703735
   )
   int field1273;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -2043710509
   )
   @Export("x")
   int x;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -155216309
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1121528409
   )
   int field1276;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -401086151
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 836207283
   )
   int field1278;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 750109881
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1496318055
   )
   int field1280;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 258300213
   )
   int field1281;
   @ObfuscatedName("bs")
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 872223593
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1291895329
   )
   int field1284;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -1332111775
   )
   int field1285;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1502594211
   )
   int field1286;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1050678051
   )
   int field1287;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 131280671
   )
   int field1288;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1360219529
   )
   int field1289;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1298421993
   )
   int field1290;
   @ObfuscatedName("rj")
   @ObfuscatedGetter(
      intValue = -374223851
   )
   static int field1291;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -1234689717
   )
   int field1292;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 262447949
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -394587043
   )
   int field1294;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1341434123
   )
   int field1295;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1328021253
   )
   int field1296;
   @ObfuscatedName("ca")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cj")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 917243023
   )
   int field1299;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 710555099
   )
   int field1300;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -1778918375
   )
   int field1301;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1829507743
   )
   int field1302;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2030762499"
   )
   boolean vmethod1691() {
      return false;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-20"
   )
   final void method1514() {
      this.field1263 = 0;
      this.field1301 = 0;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "127"
   )
   final void method1516(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field1264[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class254 var14 = class27.method203(var1);
         var10 = var14.field3425;
         var11 = var14.field3416;
      }

      int var12;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var12 = 0;
         if(var10 == 0) {
            var12 = this.field1264[0];
         } else if(var10 == 1) {
            var12 = this.field1251[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field1264[var13] < var12) {
                  var9 = var13;
                  var12 = this.field1264[var13];
               }
            } else if(var10 == 1 && this.field1251[var13] < var12) {
               var9 = var13;
               var12 = this.field1251[var13];
            }
         }

         if(var10 == 1 && var12 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field1261 = 0;
         }

         for(var12 = 0; var12 < 4; ++var12) {
            byte var15 = this.field1261;
            this.field1261 = (byte)((this.field1261 + 1) % 4);
            if(this.field1264[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1252[var9] = var1;
         this.field1251[var9] = var2;
         this.field1265[var9] = var3;
         this.field1266[var9] = var4;
         this.field1264[var9] = var11 + var5 + var6;
      }
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-1590633579"
   )
   static final String[] method1518(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "163143053"
   )
   final void method1524(int var1) {
      CombatInfo2 var2 = class98.method1830(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method3530(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.method3540()) {
         if(var3.combatInfo2 == var2) {
            var3.unlink();
            return;
         }
      }

   }

   Actor() {
      this.field1262 = false;
      this.field1268 = 1;
      this.idlePoseAnimation = -1;
      this.field1248 = -1;
      this.field1249 = -1;
      this.field1242 = -1;
      this.field1299 = -1;
      this.field1288 = -1;
      this.field1253 = -1;
      this.field1254 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1258 = 100;
      this.field1245 = 0;
      this.field1294 = 0;
      this.field1261 = 0;
      this.field1252 = new int[4];
      this.field1251 = new int[4];
      this.field1264 = new int[4];
      this.field1265 = new int[4];
      this.field1266 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1269 = false;
      this.field1270 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1273 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1260 = 0;
      this.actionAnimationDisable = 0;
      this.field1278 = 0;
      this.graphic = -1;
      this.field1280 = 0;
      this.field1281 = 0;
      this.field1276 = 0;
      this.field1292 = 200;
      this.field1267 = 0;
      this.field1295 = 32;
      this.field1263 = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1257 = new byte[10];
      this.field1300 = 0;
      this.field1301 = 0;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1513996951"
   )
   final void method1529(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = class98.method1830(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field3367;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method3530(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.method3540()) {
         ++var11;
         if(var12.combatInfo2.field3364 == var7.field3364) {
            var12.method1680(var4 + var2, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field3366 <= var7.field3366) {
            var8 = var12;
         }

         if(var12.combatInfo2.field3367 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field3367;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.method3532(var12);
         } else {
            CombatInfoList.method3539(var12, var8);
         }

         var12.method1680(var4 + var2, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1649249267"
   )
   static int method1531(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 100) {
         class83.intStackSize -= 3;
         var3 = class83.intStack[class83.intStackSize];
         var4 = class83.intStack[class83.intStackSize + 1];
         int var5 = class83.intStack[class83.intStackSize + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = WorldMapType3.method199(var3);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class232.field3187 = var12;
               } else {
                  class2.field15 = var12;
               }

               class25.method169(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if(var0 == 101) {
            var9 = var2?class232.field3187:class2.field15;
            Widget var11 = WorldMapType3.method199(var9.id);
            var11.children[var9.index] = null;
            class25.method169(var11);
            return 1;
         } else if(var0 == 102) {
            var9 = WorldMapType3.method199(class83.intStack[--class83.intStackSize]);
            var9.children = null;
            class25.method169(var9);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var9 = WorldMapType3.method199(class83.intStack[--class83.intStackSize]);
               if(var9 != null) {
                  class83.intStack[++class83.intStackSize - 1] = 1;
                  if(var2) {
                     class232.field3187 = var9;
                  } else {
                     class2.field15 = var9;
                  }
               } else {
                  class83.intStack[++class83.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class83.intStackSize -= 2;
            var3 = class83.intStack[class83.intStackSize];
            var4 = class83.intStack[class83.intStackSize + 1];
            Widget var10 = FileOnDisk.method2351(var3, var4);
            if(var10 != null && var4 != -1) {
               class83.intStack[++class83.intStackSize - 1] = 1;
               if(var2) {
                  class232.field3187 = var10;
               } else {
                  class2.field15 = var10;
               }
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "2126882502"
   )
   static final void method1533(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class10.field258.length; ++var2) {
         class10.field258[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class10.field258[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class25.field362[var5] = (class10.field258[var5 - 128] + class10.field258[var5 - 1] + class10.field258[var5 + 1] + class10.field258[var5 + 128]) / 4;
            }
         }

         int[] var8 = class10.field258;
         class10.field258 = class25.field362;
         class25.field362 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + 16 + var0.offsetX;
                  int var6 = var3 + 16 + var0.offsetY;
                  int var7 = (var6 << 7) + var5;
                  class10.field258[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "2067912637"
   )
   static final void method1534(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int[] var7 = Region.method2727(var0, var1, var2);
      int[] var8 = Region.method2727(var3, var4, var5);
      Rasterizer2D.method4936(var7[0], var7[1], var8[0], var8[1], var6);
   }
}
