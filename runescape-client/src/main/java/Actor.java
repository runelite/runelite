import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("aj")
   byte field1226;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1375003315
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1799797169
   )
   int field1228;
   @ObfuscatedName("aw")
   boolean field1229;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1828520945
   )
   int field1230;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 35737547
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1348383223
   )
   int field1232;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 2127075335
   )
   @Export("x")
   int x;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -950710971
   )
   int field1234;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1993979927
   )
   int field1235;
   @ObfuscatedName("bd")
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1783860477
   )
   int field1237;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -947662343
   )
   int field1238;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -502813559
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("ax")
   boolean field1240;
   @ObfuscatedName("av")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 1118273727
   )
   int field1242;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 379091037
   )
   int field1243;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 940911895
   )
   int field1244;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -932591645
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("ay")
   int[] field1246;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -837979601
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 977257801
   )
   int field1248;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 626198391
   )
   int field1249;
   @ObfuscatedName("bv")
   int[] field1250;
   @ObfuscatedName("ap")
   int[] field1251;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1342685745
   )
   int field1252;
   @ObfuscatedName("bj")
   boolean field1253;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1811660985
   )
   int field1254;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -788419731
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 375741857
   )
   int field1256;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 2125398063
   )
   int field1257;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1484707389
   )
   int field1258;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -652684785
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 672205923
   )
   int field1260;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1620159525
   )
   int field1261;
   @ObfuscatedName("az")
   int[] field1262;
   @ObfuscatedName("ai")
   int[] field1263;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1054771075
   )
   int field1264;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 62613715
   )
   int field1265;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -147730497
   )
   int field1266;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 296001645
   )
   int field1268;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1752485511
   )
   int field1269;
   @ObfuscatedName("ac")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1897097759
   )
   int field1271;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1727206931
   )
   int field1272;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1427572371
   )
   int field1273;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -950426645
   )
   int field1274;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -92309293
   )
   @Export("y")
   int y;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 242281039
   )
   int field1276;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 374473281
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 163659999
   )
   int field1278;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1122442775
   )
   int field1279;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 1688003673
   )
   int field1280;
   @ObfuscatedName("cv")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cl")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cb")
   byte[] field1283;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1463269021
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 217674109
   )
   int field1285;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -2141611265
   )
   int field1286;

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1910724522"
   )
   final void method1492() {
      this.field1280 = 0;
      this.field1285 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-41"
   )
   boolean vmethod1669() {
      return false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1548910908"
   )
   static int method1494(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
         var4 = class83.intStack[--class165.intStackSize];
         class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var19;
         if(var0 == 4101) {
            ISAACCipher.scriptStringStackSize -= 2;
            var3 = class83.scriptStringStack[ISAACCipher.scriptStringStackSize];
            var19 = class83.scriptStringStack[ISAACCipher.scriptStringStackSize + 1];
            class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3 + var19;
            return 1;
         } else if(var0 == 4102) {
            var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
            var4 = class83.intStack[--class165.intStackSize];
            class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3 + class8.method52(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
            class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var10;
            int var21;
            if(var0 == 4104) {
               var10 = class83.intStack[--class165.intStackSize];
               long var11 = 86400000L * (11745L + (long)var10);
               class83.field1340.setTime(new Date(var11));
               var21 = class83.field1340.get(5);
               int var17 = class83.field1340.get(2);
               int var8 = class83.field1340.get(1);
               class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var21 + "-" + class83.field1351[var17] + "-" + var8;
               return 1;
            } else if(var0 == 4105) {
               ISAACCipher.scriptStringStackSize -= 2;
               var3 = class83.scriptStringStack[ISAACCipher.scriptStringStackSize];
               var19 = class83.scriptStringStack[ISAACCipher.scriptStringStackSize + 1];
               if(class168.localPlayer.composition != null && class168.localPlayer.composition.isFemale) {
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var19;
               } else {
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4106) {
               var10 = class83.intStack[--class165.intStackSize];
               class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = Integer.toString(var10);
               return 1;
            } else if(var0 == 4107) {
               ISAACCipher.scriptStringStackSize -= 2;
               int[] var16 = class83.intStack;
               var4 = ++class165.intStackSize - 1;
               var21 = GameEngine.method965(class83.scriptStringStack[ISAACCipher.scriptStringStackSize], class83.scriptStringStack[ISAACCipher.scriptStringStackSize + 1], Client.field919);
               byte var18;
               if(var21 > 0) {
                  var18 = 1;
               } else if(var21 < 0) {
                  var18 = -1;
               } else {
                  var18 = 0;
               }

               var16[var4] = var18;
               return 1;
            } else {
               int var5;
               byte[] var6;
               Font var14;
               if(var0 == 4108) {
                  var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                  class165.intStackSize -= 2;
                  var4 = class83.intStack[class165.intStackSize];
                  var5 = class83.intStack[class165.intStackSize + 1];
                  var6 = class233.field3207.getConfigData(var5, 0);
                  var14 = new Font(var6);
                  class83.intStack[++class165.intStackSize - 1] = var14.method4783(var3, var4);
                  return 1;
               } else if(var0 == 4109) {
                  var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                  class165.intStackSize -= 2;
                  var4 = class83.intStack[class165.intStackSize];
                  var5 = class83.intStack[class165.intStackSize + 1];
                  var6 = class233.field3207.getConfigData(var5, 0);
                  var14 = new Font(var6);
                  class83.intStack[++class165.intStackSize - 1] = var14.method4794(var3, var4);
                  return 1;
               } else if(var0 == 4110) {
                  ISAACCipher.scriptStringStackSize -= 2;
                  var3 = class83.scriptStringStack[ISAACCipher.scriptStringStackSize];
                  var19 = class83.scriptStringStack[ISAACCipher.scriptStringStackSize + 1];
                  if(class83.intStack[--class165.intStackSize] == 1) {
                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3;
                  } else {
                     class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var19;
                  }

                  return 1;
               } else if(var0 == 4111) {
                  var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = FontTypeFace.method4815(var3);
                  return 1;
               } else if(var0 == 4112) {
                  var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                  var4 = class83.intStack[--class165.intStackSize];
                  class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3 + (char)var4;
                  return 1;
               } else {
                  char var7;
                  int[] var9;
                  boolean var13;
                  if(var0 == 4113) {
                     var10 = class83.intStack[--class165.intStackSize];
                     var9 = class83.intStack;
                     var5 = ++class165.intStackSize - 1;
                     var7 = (char)var10;
                     if(var7 >= 32 && var7 <= 126) {
                        var13 = true;
                     } else if(var7 >= 160 && var7 <= 255) {
                        var13 = true;
                     } else if(var7 != 8364 && var7 != 338 && var7 != 8212 && var7 != 339 && var7 != 376) {
                        var13 = false;
                     } else {
                        var13 = true;
                     }

                     var9[var5] = var13?1:0;
                     return 1;
                  } else if(var0 == 4114) {
                     var10 = class83.intStack[--class165.intStackSize];
                     var9 = class83.intStack;
                     var5 = ++class165.intStackSize - 1;
                     var7 = (char)var10;
                     var13 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                     var9[var5] = var13?1:0;
                     return 1;
                  } else if(var0 == 4115) {
                     var10 = class83.intStack[--class165.intStackSize];
                     var9 = class83.intStack;
                     var5 = ++class165.intStackSize - 1;
                     var7 = (char)var10;
                     var13 = var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                     var9[var5] = var13?1:0;
                     return 1;
                  } else if(var0 != 4116) {
                     if(var0 == 4117) {
                        var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                        if(var3 != null) {
                           class83.intStack[++class165.intStackSize - 1] = var3.length();
                        } else {
                           class83.intStack[++class165.intStackSize - 1] = 0;
                        }

                        return 1;
                     } else if(var0 == 4118) {
                        var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                        class165.intStackSize -= 2;
                        var4 = class83.intStack[class165.intStackSize];
                        var5 = class83.intStack[class165.intStackSize + 1];
                        class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3.substring(var4, var5);
                        return 1;
                     } else if(var0 == 4119) {
                        var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                        StringBuilder var20 = new StringBuilder(var3.length());
                        boolean var15 = false;

                        for(var21 = 0; var21 < var3.length(); ++var21) {
                           var7 = var3.charAt(var21);
                           if(var7 == 60) {
                              var15 = true;
                           } else if(var7 == 62) {
                              var15 = false;
                           } else if(!var15) {
                              var20.append(var7);
                           }
                        }

                        class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var20.toString();
                        return 1;
                     } else if(var0 == 4120) {
                        var3 = class83.scriptStringStack[--ISAACCipher.scriptStringStackSize];
                        var4 = class83.intStack[--class165.intStackSize];
                        class83.intStack[++class165.intStackSize - 1] = var3.indexOf(var4);
                        return 1;
                     } else if(var0 == 4121) {
                        ISAACCipher.scriptStringStackSize -= 2;
                        var3 = class83.scriptStringStack[ISAACCipher.scriptStringStackSize];
                        var19 = class83.scriptStringStack[ISAACCipher.scriptStringStackSize + 1];
                        var5 = class83.intStack[--class165.intStackSize];
                        class83.intStack[++class165.intStackSize - 1] = var3.indexOf(var19, var5);
                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     var10 = class83.intStack[--class165.intStackSize];
                     var9 = class83.intStack;
                     var5 = ++class165.intStackSize - 1;
                     var7 = (char)var10;
                     var13 = var7 >= 48 && var7 <= 57;
                     var9[var5] = var13?1:0;
                     return 1;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "782832527"
   )
   final void method1495(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = class22.method189(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field3369;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method3571(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.method3573()) {
         ++var11;
         if(var12.combatInfo2.field3367 == var7.field3367) {
            var12.method1658(var4 + var2, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field3368 <= var7.field3368) {
            var8 = var12;
         }

         if(var12.combatInfo2.field3369 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field3369;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.method3576(var12);
         } else {
            CombatInfoList.method3585(var12, var8);
         }

         var12.method1658(var4 + var2, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIIIIIS)V",
      garbageValue = "-22313"
   )
   final void method1502(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field1263[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class254 var14 = class270.method4936(var1);
         var10 = var14.field3435;
         var11 = var14.field3426;
      }

      int var12;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var12 = 0;
         if(var10 == 0) {
            var12 = this.field1263[0];
         } else if(var10 == 1) {
            var12 = this.field1251[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field1263[var13] < var12) {
                  var9 = var13;
                  var12 = this.field1263[var13];
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
            this.field1226 = 0;
         }

         for(var12 = 0; var12 < 4; ++var12) {
            byte var15 = this.field1226;
            this.field1226 = (byte)((this.field1226 + 1) % 4);
            if(this.field1263[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1246[var9] = var1;
         this.field1251[var9] = var2;
         this.field1262[var9] = var3;
         this.field1250[var9] = var4;
         this.field1263[var9] = var6 + var5 + var11;
      }
   }

   Actor() {
      this.field1229 = false;
      this.field1230 = 1;
      this.idlePoseAnimation = -1;
      this.field1232 = -1;
      this.field1248 = -1;
      this.field1234 = -1;
      this.field1235 = -1;
      this.field1265 = -1;
      this.field1237 = -1;
      this.field1238 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1266 = 100;
      this.field1243 = 0;
      this.field1244 = 0;
      this.field1226 = 0;
      this.field1246 = new int[4];
      this.field1251 = new int[4];
      this.field1263 = new int[4];
      this.field1262 = new int[4];
      this.field1250 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1253 = false;
      this.field1254 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1257 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1260 = 0;
      this.actionAnimationDisable = 0;
      this.field1228 = 0;
      this.graphic = -1;
      this.field1264 = 0;
      this.field1249 = 0;
      this.field1261 = 0;
      this.field1276 = 200;
      this.field1278 = 0;
      this.field1242 = 32;
      this.field1280 = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1283 = new byte[10];
      this.field1258 = 0;
      this.field1285 = 0;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1734844755"
   )
   final void method1506(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3365.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3373.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.method4414(new Buffer(var4));
         }

         CombatInfo2.field3365.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.method3571(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.method3573()) {
         if(var3 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1424183202"
   )
   static void method1510(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method3545((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method3546(var4, (long)var0);
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

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16711680"
   )
   static final void method1511() {
      int var0 = class8.menuX;
      int var1 = class157.menuY;
      int var2 = class31.menuWidth;
      int var3 = class6.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method5040(var0, var1, var2, var3, var4);
      Rasterizer2D.method5040(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.method4976(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class241.field3288.method4785("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class59.field729;
      int var6 = class59.field715;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         var8 = var1 + 31 + (Client.menuOptionCount - 1 - var7) * 15;
         var9 = 16777215;
         if(var5 > var0 && var5 < var2 + var0 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         class241.field3288.method4785(class87.method1682(var7), var0 + 3, var8, var9, 0);
      }

      var7 = class8.menuX;
      var8 = class157.menuY;
      var9 = class31.menuWidth;
      int var10 = class6.menuHeight;

      for(int var11 = 0; var11 < Client.field1119; ++var11) {
         if(Client.widgetPositionX[var11] + Client.widgetBoundsWidth[var11] > var7 && Client.widgetPositionX[var11] < var9 + var7 && Client.widgetPositionY[var11] + Client.widgetBoundsHeight[var11] > var8 && Client.widgetPositionY[var11] < var10 + var8) {
            Client.field1122[var11] = true;
         }
      }

   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1706828676"
   )
   static void method1512() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
