import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("by")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("mf")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   static class156 field1244;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = -1181605459
   )
   static int field1271;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -100322069
   )
   @Export("x")
   int x;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 636976329
   )
   @Export("y")
   int y;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -101118633
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("aw")
   boolean field1212;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 977148931
   )
   int field1221;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 623136565
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 524384735
   )
   int field1253;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 532632909
   )
   int field1227;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 2026090569
   )
   int field1217;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1247921017
   )
   int field1218;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1977224375
   )
   int field1219;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -353855427
   )
   int field1220;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 195030001
   )
   int field1216;
   @ObfuscatedName("aj")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("ac")
   boolean field1223;
   @ObfuscatedName("ad")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -551806835
   )
   int field1225;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 866807943
   )
   int field1226;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1117302239
   )
   int field1247;
   @ObfuscatedName("ag")
   byte field1237;
   @ObfuscatedName("ai")
   int[] field1229;
   @ObfuscatedName("au")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("an")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("as")
   int[] field1259;
   @ObfuscatedName("br")
   int[] field1233;
   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1118222207
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bw")
   boolean field1236;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 852751501
   )
   int field1249;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 630481825
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1793681781
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1676440587
   )
   int field1234;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1192012635
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -208253575
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 249492975
   )
   int field1243;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1966438689
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 609655443
   )
   int field1245;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 175590879
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1746762359
   )
   int field1215;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -306745851
   )
   int field1248;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 289219923
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 197572127
   )
   int field1250;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1318886509
   )
   int field1251;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1880728747
   )
   int field1252;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 766606737
   )
   int field1211;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 568947231
   )
   int field1254;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1501310535
   )
   int field1240;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 1026737183
   )
   int field1256;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1901114523
   )
   int field1257;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -522737929
   )
   int field1255;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = 771232947
   )
   int field1228;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 1664866577
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1298718245
   )
   int field1261;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -1174432143
   )
   int field1262;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -461728553
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("cg")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cm")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cr")
   byte[] field1258;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 250182789
   )
   int field1267;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1482592595
   )
   int field1213;

   Actor() {
      this.field1212 = false;
      this.field1221 = 1;
      this.idlePoseAnimation = -1;
      this.field1253 = -1;
      this.field1227 = -1;
      this.field1217 = -1;
      this.field1218 = -1;
      this.field1219 = -1;
      this.field1220 = -1;
      this.field1216 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1225 = 100;
      this.field1226 = 0;
      this.field1247 = 0;
      this.field1237 = 0;
      this.field1229 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1259 = new int[4];
      this.field1233 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1236 = false;
      this.field1249 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1234 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1243 = 0;
      this.actionAnimationDisable = 0;
      this.field1245 = 0;
      this.graphic = -1;
      this.field1215 = 0;
      this.field1248 = 0;
      this.field1255 = 0;
      this.field1228 = 200;
      this.field1261 = 0;
      this.field1262 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1258 = new byte[10];
      this.field1267 = 0;
      this.field1213 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "246459077"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "18"
   )
   final void method1525() {
      this.queueSize = 0;
      this.field1213 = 0;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "16"
   )
   final void method1528(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class254 var12 = class205.method3904(var1);
         var10 = var12.field3428;
         var11 = var12.field3419;
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
            this.field1237 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1237;
            this.field1237 = (byte)((this.field1237 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1229[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1259[var9] = var3;
         this.field1233[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1625717914"
   )
   final void method1529(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = FileSystem.method4185(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field3365;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method3655(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.method3677()) {
         ++var11;
         if(var12.combatInfo2.field3362 == var7.field3362) {
            var12.method1680(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field3361 <= var7.field3361) {
            var8 = var12;
         }

         if(var12.combatInfo2.field3365 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field3365;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.method3652(var12);
         } else {
            CombatInfoList.method3680(var12, var8);
         }

         var12.method1680(var2 + var4, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1819660831"
   )
   final void method1531(int var1) {
      CombatInfo2 var2 = FileSystem.method4185(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method3655(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.method3677()) {
         if(var2 == var3.combatInfo2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1639342819"
   )
   static final void method1540(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class7.field248[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lbl;II)V",
      garbageValue = "1486311750"
   )
   static void method1541(ScriptEvent var0, int var1) {
      Object[] var2 = var0.field849;
      Script var3;
      int var27;
      if(class20.method156(var0.field844)) {
         class232.field3194 = (class47)var2[0];
         Area var4 = Area.field3285[class232.field3194.field615];
         var3 = class89.method1731(var0.field844, var4.field3287, var4.field3304);
      } else {
         var27 = ((Integer)var2[0]).intValue();
         var3 = IndexFile.method3057(var27);
      }

      if(var3 != null) {
         class278.intStackSize = 0;
         class266.scriptStringStackSize = 0;
         var27 = -1;
         int[] var5 = var3.instructions;
         int[] var6 = var3.intOperands;
         byte var7 = -1;
         class81.scriptStackCount = 0;

         int var10;
         try {
            class81.scriptLocalInts = new int[var3.localIntCount];
            int var8 = 0;
            class217.scriptLocalStrings = new String[var3.localStringCount];
            int var9 = 0;

            int var11;
            String var28;
            for(var10 = 1; var10 < var2.length; ++var10) {
               if(var2[var10] instanceof Integer) {
                  var11 = ((Integer)var2[var10]).intValue();
                  if(var11 == -2147483647) {
                     var11 = var0.field847;
                  }

                  if(var11 == -2147483646) {
                     var11 = var0.field848;
                  }

                  if(var11 == -2147483645) {
                     var11 = var0.widget != null?var0.widget.id:-1;
                  }

                  if(var11 == -2147483644) {
                     var11 = var0.field851;
                  }

                  if(var11 == -2147483643) {
                     var11 = var0.widget != null?var0.widget.index:-1;
                  }

                  if(var11 == -2147483642) {
                     var11 = var0.field855 != null?var0.field855.id:-1;
                  }

                  if(var11 == -2147483641) {
                     var11 = var0.field855 != null?var0.field855.index:-1;
                  }

                  if(var11 == -2147483640) {
                     var11 = var0.field845;
                  }

                  if(var11 == -2147483639) {
                     var11 = var0.field852;
                  }

                  class81.scriptLocalInts[var8++] = var11;
               } else if(var2[var10] instanceof String) {
                  var28 = (String)var2[var10];
                  if(var28.equals("event_opbase")) {
                     var28 = var0.field853;
                  }

                  class217.scriptLocalStrings[var9++] = var28;
               }
            }

            var10 = 0;
            class81.field1337 = var0.field854;

            while(true) {
               while(true) {
                  while(true) {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          while(true) {
                                             while(true) {
                                                while(true) {
                                                   while(true) {
                                                      while(true) {
                                                         while(true) {
                                                            while(true) {
                                                               while(true) {
                                                                  while(true) {
                                                                     while(true) {
                                                                        while(true) {
                                                                           while(true) {
                                                                              while(true) {
                                                                                 while(true) {
                                                                                    while(true) {
                                                                                       label2072:
                                                                                       while(true) {
                                                                                          ++var10;
                                                                                          if(var10 > var1) {
                                                                                             throw new RuntimeException();
                                                                                          }

                                                                                          ++var27;
                                                                                          int var45 = var5[var27];
                                                                                          int var12;
                                                                                          int var31;
                                                                                          if(var45 < 100) {
                                                                                             if(var45 != 0) {
                                                                                                if(var45 != 1) {
                                                                                                   if(var45 != 2) {
                                                                                                      if(var45 != 3) {
                                                                                                         if(var45 != 6) {
                                                                                                            if(var45 != 7) {
                                                                                                               if(var45 != 8) {
                                                                                                                  if(var45 != 9) {
                                                                                                                     if(var45 != 10) {
                                                                                                                        if(var45 != 21) {
                                                                                                                           if(var45 != 25) {
                                                                                                                              if(var45 != 27) {
                                                                                                                                 if(var45 != 31) {
                                                                                                                                    if(var45 != 32) {
                                                                                                                                       if(var45 != 33) {
                                                                                                                                          if(var45 != 34) {
                                                                                                                                             if(var45 != 35) {
                                                                                                                                                if(var45 != 36) {
                                                                                                                                                   if(var45 != 37) {
                                                                                                                                                      if(var45 != 38) {
                                                                                                                                                         if(var45 != 39) {
                                                                                                                                                            if(var45 != 40) {
                                                                                                                                                               if(var45 != 42) {
                                                                                                                                                                  if(var45 != 43) {
                                                                                                                                                                     if(var45 == 44) {
                                                                                                                                                                        var11 = var6[var27] >> 16;
                                                                                                                                                                        var12 = var6[var27] & 65535;
                                                                                                                                                                        int var82 = class81.intStack[--class278.intStackSize];
                                                                                                                                                                        if(var82 >= 0 && var82 <= 5000) {
                                                                                                                                                                           class81.field1329[var11] = var82;
                                                                                                                                                                           byte var60 = -1;
                                                                                                                                                                           if(var12 == 105) {
                                                                                                                                                                              var60 = 0;
                                                                                                                                                                           }

                                                                                                                                                                           var31 = 0;

                                                                                                                                                                           while(true) {
                                                                                                                                                                              if(var31 >= var82) {
                                                                                                                                                                                 continue label2072;
                                                                                                                                                                              }

                                                                                                                                                                              class81.SHAPE_VERTICES[var11][var31] = var60;
                                                                                                                                                                              ++var31;
                                                                                                                                                                           }
                                                                                                                                                                        }

                                                                                                                                                                        throw new RuntimeException();
                                                                                                                                                                     } else if(var45 == 45) {
                                                                                                                                                                        var11 = var6[var27];
                                                                                                                                                                        var12 = class81.intStack[--class278.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class81.field1329[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.intStack[++class278.intStackSize - 1] = class81.SHAPE_VERTICES[var11][var12];
                                                                                                                                                                     } else if(var45 == 46) {
                                                                                                                                                                        var11 = var6[var27];
                                                                                                                                                                        class278.intStackSize -= 2;
                                                                                                                                                                        var12 = class81.intStack[class278.intStackSize];
                                                                                                                                                                        if(var12 < 0 || var12 >= class81.field1329[var11]) {
                                                                                                                                                                           throw new RuntimeException();
                                                                                                                                                                        }

                                                                                                                                                                        class81.SHAPE_VERTICES[var11][var12] = class81.intStack[class278.intStackSize + 1];
                                                                                                                                                                     } else if(var45 == 47) {
                                                                                                                                                                        var28 = class24.chatMessages.getVarcString(var6[var27]);
                                                                                                                                                                        if(var28 == null) {
                                                                                                                                                                           var28 = "null";
                                                                                                                                                                        }

                                                                                                                                                                        class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var28;
                                                                                                                                                                     } else if(var45 == 48) {
                                                                                                                                                                        class24.chatMessages.putVarcString(var6[var27], class81.scriptStringStack[--class266.scriptStringStackSize]);
                                                                                                                                                                     } else {
                                                                                                                                                                        if(var45 != 60) {
                                                                                                                                                                           throw new IllegalStateException();
                                                                                                                                                                        }

                                                                                                                                                                        IterableHashTable var63 = var3.switches[var6[var27]];
                                                                                                                                                                        IntegerNode var66 = (IntegerNode)var63.get((long)class81.intStack[--class278.intStackSize]);
                                                                                                                                                                        if(var66 != null) {
                                                                                                                                                                           var27 += var66.value;
                                                                                                                                                                        }
                                                                                                                                                                     }
                                                                                                                                                                  } else {
                                                                                                                                                                     class24.chatMessages.putVarc(var6[var27], class81.intStack[--class278.intStackSize]);
                                                                                                                                                                  }
                                                                                                                                                               } else {
                                                                                                                                                                  class81.intStack[++class278.intStackSize - 1] = class24.chatMessages.getVarc(var6[var27]);
                                                                                                                                                               }
                                                                                                                                                            } else {
                                                                                                                                                               var11 = var6[var27];
                                                                                                                                                               Script var65 = IndexFile.method3057(var11);
                                                                                                                                                               int[] var33 = new int[var65.localIntCount];
                                                                                                                                                               String[] var81 = new String[var65.localStringCount];

                                                                                                                                                               for(var31 = 0; var31 < var65.intStackCount; ++var31) {
                                                                                                                                                                  var33[var31] = class81.intStack[var31 + (class278.intStackSize - var65.intStackCount)];
                                                                                                                                                               }

                                                                                                                                                               for(var31 = 0; var31 < var65.stringStackCount; ++var31) {
                                                                                                                                                                  var81[var31] = class81.scriptStringStack[var31 + (class266.scriptStringStackSize - var65.stringStackCount)];
                                                                                                                                                               }

                                                                                                                                                               class278.intStackSize -= var65.intStackCount;
                                                                                                                                                               class266.scriptStringStackSize -= var65.stringStackCount;
                                                                                                                                                               ScriptState var55 = new ScriptState();
                                                                                                                                                               var55.invokedFromScript = var3;
                                                                                                                                                               var55.invokedFromPc = var27;
                                                                                                                                                               var55.savedLocalInts = class81.scriptLocalInts;
                                                                                                                                                               var55.savedLocalStrings = class217.scriptLocalStrings;
                                                                                                                                                               class81.scriptStack[++class81.scriptStackCount - 1] = var55;
                                                                                                                                                               var3 = var65;
                                                                                                                                                               var5 = var65.instructions;
                                                                                                                                                               var6 = var65.intOperands;
                                                                                                                                                               var27 = -1;
                                                                                                                                                               class81.scriptLocalInts = var33;
                                                                                                                                                               class217.scriptLocalStrings = var81;
                                                                                                                                                            }
                                                                                                                                                         } else {
                                                                                                                                                            --class266.scriptStringStackSize;
                                                                                                                                                         }
                                                                                                                                                      } else {
                                                                                                                                                         --class278.intStackSize;
                                                                                                                                                      }
                                                                                                                                                   } else {
                                                                                                                                                      var11 = var6[var27];
                                                                                                                                                      class266.scriptStringStackSize -= var11;
                                                                                                                                                      String var32 = class22.method164(class81.scriptStringStack, class266.scriptStringStackSize, var11);
                                                                                                                                                      class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var32;
                                                                                                                                                   }
                                                                                                                                                } else {
                                                                                                                                                   class217.scriptLocalStrings[var6[var27]] = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                                                                }
                                                                                                                                             } else {
                                                                                                                                                class81.scriptStringStack[++class266.scriptStringStackSize - 1] = class217.scriptLocalStrings[var6[var27]];
                                                                                                                                             }
                                                                                                                                          } else {
                                                                                                                                             class81.scriptLocalInts[var6[var27]] = class81.intStack[--class278.intStackSize];
                                                                                                                                          }
                                                                                                                                       } else {
                                                                                                                                          class81.intStack[++class278.intStackSize - 1] = class81.scriptLocalInts[var6[var27]];
                                                                                                                                       }
                                                                                                                                    } else {
                                                                                                                                       class278.intStackSize -= 2;
                                                                                                                                       if(class81.intStack[class278.intStackSize] >= class81.intStack[class278.intStackSize + 1]) {
                                                                                                                                          var27 += var6[var27];
                                                                                                                                       }
                                                                                                                                    }
                                                                                                                                 } else {
                                                                                                                                    class278.intStackSize -= 2;
                                                                                                                                    if(class81.intStack[class278.intStackSize] <= class81.intStack[class278.intStackSize + 1]) {
                                                                                                                                       var27 += var6[var27];
                                                                                                                                    }
                                                                                                                                 }
                                                                                                                              } else {
                                                                                                                                 var11 = var6[var27];
                                                                                                                                 class114.method2167(var11, class81.intStack[--class278.intStackSize]);
                                                                                                                              }
                                                                                                                           } else {
                                                                                                                              var11 = var6[var27];
                                                                                                                              class81.intStack[++class278.intStackSize - 1] = class89.method1732(var11);
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           if(class81.scriptStackCount == 0) {
                                                                                                                              return;
                                                                                                                           }

                                                                                                                           ScriptState var61 = class81.scriptStack[--class81.scriptStackCount];
                                                                                                                           var3 = var61.invokedFromScript;
                                                                                                                           var5 = var3.instructions;
                                                                                                                           var6 = var3.intOperands;
                                                                                                                           var27 = var61.invokedFromPc;
                                                                                                                           class81.scriptLocalInts = var61.savedLocalInts;
                                                                                                                           class217.scriptLocalStrings = var61.savedLocalStrings;
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        class278.intStackSize -= 2;
                                                                                                                        if(class81.intStack[class278.intStackSize] > class81.intStack[class278.intStackSize + 1]) {
                                                                                                                           var27 += var6[var27];
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     class278.intStackSize -= 2;
                                                                                                                     if(class81.intStack[class278.intStackSize] < class81.intStack[class278.intStackSize + 1]) {
                                                                                                                        var27 += var6[var27];
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  class278.intStackSize -= 2;
                                                                                                                  if(class81.intStack[class278.intStackSize] == class81.intStack[class278.intStackSize + 1]) {
                                                                                                                     var27 += var6[var27];
                                                                                                                  }
                                                                                                               }
                                                                                                            } else {
                                                                                                               class278.intStackSize -= 2;
                                                                                                               if(class81.intStack[class278.intStackSize] != class81.intStack[class278.intStackSize + 1]) {
                                                                                                                  var27 += var6[var27];
                                                                                                               }
                                                                                                            }
                                                                                                         } else {
                                                                                                            var27 += var6[var27];
                                                                                                         }
                                                                                                      } else {
                                                                                                         class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var3.stringOperands[var27];
                                                                                                      }
                                                                                                   } else {
                                                                                                      var11 = var6[var27];
                                                                                                      class211.widgetSettings[var11] = class81.intStack[--class278.intStackSize];
                                                                                                      class45.method630(var11);
                                                                                                   }
                                                                                                } else {
                                                                                                   var11 = var6[var27];
                                                                                                   class81.intStack[++class278.intStackSize - 1] = class211.widgetSettings[var11];
                                                                                                }
                                                                                             } else {
                                                                                                class81.intStack[++class278.intStackSize - 1] = var6[var27];
                                                                                             }
                                                                                          } else {
                                                                                             boolean var48;
                                                                                             if(var3.intOperands[var27] == 1) {
                                                                                                var48 = true;
                                                                                             } else {
                                                                                                var48 = false;
                                                                                             }

                                                                                             if(var45 < 1000) {
                                                                                                var12 = Huffman.method3151(var45, var3, var48);
                                                                                             } else if(var45 < 1100) {
                                                                                                var12 = class36.method482(var45, var3, var48);
                                                                                             } else if(var45 < 1200) {
                                                                                                var12 = class12.method69(var45, var3, var48);
                                                                                             } else if(var45 < 1300) {
                                                                                                var12 = class15.method95(var45, var3, var48);
                                                                                             } else if(var45 < 1400) {
                                                                                                var12 = class86.method1718(var45, var3, var48);
                                                                                             } else if(var45 < 1500) {
                                                                                                var12 = ScriptState.method1067(var45, var3, var48);
                                                                                             } else if(var45 < 1600) {
                                                                                                var12 = GroundObject.method2541(var45, var3, var48);
                                                                                             } else if(var45 < 1700) {
                                                                                                var12 = Item.method1795(var45, var3, var48);
                                                                                             } else {
                                                                                                byte var13;
                                                                                                Widget var17;
                                                                                                if(var45 < 1800) {
                                                                                                   var17 = var48?class251.field3392:class164.field2314;
                                                                                                   if(var45 == 1700) {
                                                                                                      class81.intStack[++class278.intStackSize - 1] = var17.itemId;
                                                                                                      var13 = 1;
                                                                                                   } else if(var45 == 1701) {
                                                                                                      if(var17.itemId != -1) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var17.itemQuantity;
                                                                                                      } else {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                      }

                                                                                                      var13 = 1;
                                                                                                   } else if(var45 == 1702) {
                                                                                                      class81.intStack[++class278.intStackSize - 1] = var17.index;
                                                                                                      var13 = 1;
                                                                                                   } else {
                                                                                                      var13 = 2;
                                                                                                   }

                                                                                                   var12 = var13;
                                                                                                } else {
                                                                                                   int[] var15;
                                                                                                   int var16;
                                                                                                   int var18;
                                                                                                   Widget var29;
                                                                                                   int var30;
                                                                                                   if(var45 < 1900) {
                                                                                                      var29 = var48?class251.field3392:class164.field2314;
                                                                                                      if(var45 == 1800) {
                                                                                                         var15 = class81.intStack;
                                                                                                         var16 = ++class278.intStackSize - 1;
                                                                                                         var18 = class25.getWidgetConfig(var29);
                                                                                                         var30 = var18 >> 11 & 63;
                                                                                                         var15[var16] = var30;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 != 1801) {
                                                                                                         if(var45 == 1802) {
                                                                                                            if(var29.name == null) {
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                            } else {
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var29.name;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else {
                                                                                                            var13 = 2;
                                                                                                         }
                                                                                                      } else {
                                                                                                         var31 = class81.intStack[--class278.intStackSize];
                                                                                                         --var31;
                                                                                                         if(var29.actions != null && var31 < var29.actions.length && var29.actions[var31] != null) {
                                                                                                            class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var29.actions[var31];
                                                                                                         } else {
                                                                                                            class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                         }

                                                                                                         var13 = 1;
                                                                                                      }

                                                                                                      var12 = var13;
                                                                                                   } else if(var45 < 2000) {
                                                                                                      var12 = Ignore.method1101(var45, var3, var48);
                                                                                                   } else if(var45 < 2100) {
                                                                                                      var12 = class36.method482(var45, var3, var48);
                                                                                                   } else if(var45 < 2200) {
                                                                                                      var12 = class12.method69(var45, var3, var48);
                                                                                                   } else if(var45 < 2300) {
                                                                                                      var12 = class15.method95(var45, var3, var48);
                                                                                                   } else if(var45 < 2400) {
                                                                                                      var12 = class86.method1718(var45, var3, var48);
                                                                                                   } else if(var45 < 2500) {
                                                                                                      var12 = ScriptState.method1067(var45, var3, var48);
                                                                                                   } else if(var45 < 2600) {
                                                                                                      var12 = ItemLayer.method2452(var45, var3, var48);
                                                                                                   } else if(var45 < 2700) {
                                                                                                      var29 = ItemLayer.method2454(class81.intStack[--class278.intStackSize]);
                                                                                                      if(var45 == 2600) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.scrollX;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2601) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.scrollY;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2602) {
                                                                                                         class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var29.text;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2603) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.scrollWidth;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2604) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.scrollHeight;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2605) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.modelZoom;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2606) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.rotationX;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2607) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.rotationY;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2608) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.rotationZ;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2609) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.opacity;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2610) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.field2674;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2611) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.textColor;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2612) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.field2668;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 == 2613) {
                                                                                                         class81.intStack[++class278.intStackSize - 1] = var29.field2672.rsOrdinal();
                                                                                                         var13 = 1;
                                                                                                      } else {
                                                                                                         var13 = 2;
                                                                                                      }

                                                                                                      var12 = var13;
                                                                                                   } else if(var45 < 2800) {
                                                                                                      var12 = class61.method1064(var45, var3, var48);
                                                                                                   } else if(var45 < 2900) {
                                                                                                      var29 = ItemLayer.method2454(class81.intStack[--class278.intStackSize]);
                                                                                                      if(var45 == 2800) {
                                                                                                         var15 = class81.intStack;
                                                                                                         var16 = ++class278.intStackSize - 1;
                                                                                                         var18 = class25.getWidgetConfig(var29);
                                                                                                         var30 = var18 >> 11 & 63;
                                                                                                         var15[var16] = var30;
                                                                                                         var13 = 1;
                                                                                                      } else if(var45 != 2801) {
                                                                                                         if(var45 == 2802) {
                                                                                                            if(var29.name == null) {
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                            } else {
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var29.name;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else {
                                                                                                            var13 = 2;
                                                                                                         }
                                                                                                      } else {
                                                                                                         var31 = class81.intStack[--class278.intStackSize];
                                                                                                         --var31;
                                                                                                         if(var29.actions != null && var31 < var29.actions.length && var29.actions[var31] != null) {
                                                                                                            class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var29.actions[var31];
                                                                                                         } else {
                                                                                                            class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                         }

                                                                                                         var13 = 1;
                                                                                                      }

                                                                                                      var12 = var13;
                                                                                                   } else if(var45 < 3000) {
                                                                                                      var12 = Ignore.method1101(var45, var3, var48);
                                                                                                   } else {
                                                                                                      int var14;
                                                                                                      int var19;
                                                                                                      int var20;
                                                                                                      int var21;
                                                                                                      int var22;
                                                                                                      char var23;
                                                                                                      String var46;
                                                                                                      int[] var49;
                                                                                                      int var59;
                                                                                                      String var62;
                                                                                                      boolean var64;
                                                                                                      boolean var67;
                                                                                                      String var70;
                                                                                                      if(var45 < 3200) {
                                                                                                         if(var45 == 3100) {
                                                                                                            var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                            class174.sendGameMessage(0, "", var62);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3101) {
                                                                                                            class278.intStackSize -= 2;
                                                                                                            ScriptVarType.method28(class66.localPlayer, class81.intStack[class278.intStackSize], class81.intStack[class278.intStackSize + 1]);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3103) {
                                                                                                            CollisionData.method3106();
                                                                                                            var13 = 1;
                                                                                                         } else {
                                                                                                            boolean var53;
                                                                                                            if(var45 == 3104) {
                                                                                                               var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                               var31 = 0;
                                                                                                               var53 = false;
                                                                                                               boolean var57 = false;
                                                                                                               var20 = 0;
                                                                                                               var21 = var62.length();
                                                                                                               var22 = 0;

                                                                                                               while(true) {
                                                                                                                  if(var22 >= var21) {
                                                                                                                     var64 = var57;
                                                                                                                     break;
                                                                                                                  }

                                                                                                                  label2429: {
                                                                                                                     var23 = var62.charAt(var22);
                                                                                                                     if(var22 == 0) {
                                                                                                                        if(var23 == '-') {
                                                                                                                           var53 = true;
                                                                                                                           break label2429;
                                                                                                                        }

                                                                                                                        if(var23 == '+') {
                                                                                                                           break label2429;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     if(var23 >= '0' && var23 <= '9') {
                                                                                                                        var59 = var23 - '0';
                                                                                                                     } else if(var23 >= 'A' && var23 <= 'Z') {
                                                                                                                        var59 = var23 - '7';
                                                                                                                     } else {
                                                                                                                        if(var23 < 'a' || var23 > 'z') {
                                                                                                                           var64 = false;
                                                                                                                           break;
                                                                                                                        }

                                                                                                                        var59 = var23 - 'W';
                                                                                                                     }

                                                                                                                     if(var59 >= 10) {
                                                                                                                        var64 = false;
                                                                                                                        break;
                                                                                                                     }

                                                                                                                     if(var53) {
                                                                                                                        var59 = -var59;
                                                                                                                     }

                                                                                                                     int var24 = var20 * 10 + var59;
                                                                                                                     if(var20 != var24 / 10) {
                                                                                                                        var64 = false;
                                                                                                                        break;
                                                                                                                     }

                                                                                                                     var20 = var24;
                                                                                                                     var57 = true;
                                                                                                                  }

                                                                                                                  ++var22;
                                                                                                               }

                                                                                                               if(var64) {
                                                                                                                  var30 = MilliTimer.parseInt(var62, 10, true);
                                                                                                                  var31 = var30;
                                                                                                               }

                                                                                                               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_NUMERIC_INPUT);
                                                                                                               if(Client.RUNELITE_PACKET) {
                                                                                                                  Client.secretPacketBuffer1.runeliteWriteInt(var31);
                                                                                                               } else {
                                                                                                                  Client.secretPacketBuffer1.putInt(var31);
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 3105) {
                                                                                                               var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_219);
                                                                                                               Client.secretPacketBuffer1.putByte(var62.length() + 1);
                                                                                                               Client.secretPacketBuffer1.putString(var62);
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 3106) {
                                                                                                               var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_190);
                                                                                                               Client.secretPacketBuffer1.putByte(var62.length() + 1);
                                                                                                               Client.secretPacketBuffer1.putString(var62);
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 != 3107) {
                                                                                                               if(var45 == 3108) {
                                                                                                                  class278.intStackSize -= 3;
                                                                                                                  var14 = class81.intStack[class278.intStackSize];
                                                                                                                  var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                                  var16 = class81.intStack[class278.intStackSize + 2];
                                                                                                                  var17 = ItemLayer.method2454(var16);
                                                                                                                  class85.method1713(var17, var14, var31);
                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 3109) {
                                                                                                                  class278.intStackSize -= 2;
                                                                                                                  var14 = class81.intStack[class278.intStackSize];
                                                                                                                  var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                                  Widget var35 = var48?class251.field3392:class164.field2314;
                                                                                                                  class85.method1713(var35, var14, var31);
                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 3110) {
                                                                                                                  class7.field244 = class81.intStack[--class278.intStackSize] == 1;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 3111) {
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = class70.preferences.hideRoofs?1:0;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 3112) {
                                                                                                                  class70.preferences.hideRoofs = class81.intStack[--class278.intStackSize] == 1;
                                                                                                                  WorldMapType3.method215();
                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 3113) {
                                                                                                                  var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                                  var67 = class81.intStack[--class278.intStackSize] == 1;
                                                                                                                  class155.method2999(var62, var67, false);
                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 3115) {
                                                                                                                  var14 = class81.intStack[--class278.intStackSize];
                                                                                                                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_PRICE);
                                                                                                                  if(Client.RUNELITE_PACKET) {
                                                                                                                     Client.secretPacketBuffer1.runeliteWriteInt(var14);
                                                                                                                  } else {
                                                                                                                     Client.secretPacketBuffer1.putShort(var14);
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 3116) {
                                                                                                                  var14 = class81.intStack[--class278.intStackSize];
                                                                                                                  class266.scriptStringStackSize -= 2;
                                                                                                                  var46 = class81.scriptStringStack[class266.scriptStringStackSize];
                                                                                                                  var70 = class81.scriptStringStack[class266.scriptStringStackSize + 1];
                                                                                                                  if(var46.length() > 500) {
                                                                                                                     var13 = 1;
                                                                                                                  } else if(var70.length() > 500) {
                                                                                                                     var13 = 1;
                                                                                                                  } else {
                                                                                                                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_224);
                                                                                                                     Client.secretPacketBuffer1.putShort(1 + class86.getLength(var46) + class86.getLength(var70));
                                                                                                                     Client.secretPacketBuffer1.putString(var70);
                                                                                                                     Client.secretPacketBuffer1.method3246(var14);
                                                                                                                     Client.secretPacketBuffer1.putString(var46);
                                                                                                                     var13 = 1;
                                                                                                                  }
                                                                                                               } else if(var45 == 3117) {
                                                                                                                  Client.field961 = class81.intStack[--class278.intStackSize] == 1;
                                                                                                                  var13 = 1;
                                                                                                               } else {
                                                                                                                  var13 = 2;
                                                                                                               }
                                                                                                            } else {
                                                                                                               var14 = class81.intStack[--class278.intStackSize];
                                                                                                               var46 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                               var16 = class94.playerIndexesCount;
                                                                                                               var49 = class94.playerIndices;
                                                                                                               var53 = false;

                                                                                                               for(var19 = 0; var19 < var16; ++var19) {
                                                                                                                  Player var34 = Client.cachedPlayers[var49[var19]];
                                                                                                                  if(var34 != null && var34 != class66.localPlayer && var34.name != null && var34.name.equalsIgnoreCase(var46)) {
                                                                                                                     if(var14 == 1) {
                                                                                                                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_159);
                                                                                                                        if(Client.RUNELITE_PACKET) {
                                                                                                                           Client.secretPacketBuffer1.runeliteWriteInt(var49[var19]);
                                                                                                                           Client.secretPacketBuffer1.runeliteWriteInt(0);
                                                                                                                        } else {
                                                                                                                           Client.secretPacketBuffer1.method3254(var49[var19]);
                                                                                                                           Client.secretPacketBuffer1.method3246(0);
                                                                                                                        }
                                                                                                                     } else if(var14 == 4) {
                                                                                                                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_TRADE_PLAYER);
                                                                                                                        if(Client.RUNELITE_PACKET) {
                                                                                                                           Client.secretPacketBuffer1.runeliteWriteInt(var49[var19]);
                                                                                                                           Client.secretPacketBuffer1.runeliteWriteInt(0);
                                                                                                                        } else {
                                                                                                                           Client.secretPacketBuffer1.putShort(var49[var19]);
                                                                                                                           Client.secretPacketBuffer1.putLEInt(0);
                                                                                                                        }
                                                                                                                     } else if(var14 == 6) {
                                                                                                                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_80);
                                                                                                                        if(Client.RUNELITE_PACKET) {
                                                                                                                           Client.secretPacketBuffer1.runeliteWriteInt(0);
                                                                                                                           Client.secretPacketBuffer1.runeliteWriteInt(var49[var19]);
                                                                                                                        } else {
                                                                                                                           Client.secretPacketBuffer1.putByte(0);
                                                                                                                           Client.secretPacketBuffer1.putShortLE(var49[var19]);
                                                                                                                        }
                                                                                                                     } else if(var14 == 7) {
                                                                                                                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_203);
                                                                                                                        if(Client.RUNELITE_PACKET) {
                                                                                                                           Client.secretPacketBuffer1.runeliteWriteInt(0);
                                                                                                                           Client.secretPacketBuffer1.runeliteWriteInt(var49[var19]);
                                                                                                                        } else {
                                                                                                                           Client.secretPacketBuffer1.putByte(0);
                                                                                                                           Client.secretPacketBuffer1.method3254(var49[var19]);
                                                                                                                        }
                                                                                                                     }

                                                                                                                     var53 = true;
                                                                                                                     break;
                                                                                                                  }
                                                                                                               }

                                                                                                               if(!var53) {
                                                                                                                  class174.sendGameMessage(4, "", "Unable to find " + var46);
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            }
                                                                                                         }

                                                                                                         var12 = var13;
                                                                                                      } else if(var45 < 3300) {
                                                                                                         var12 = class24.method184(var45, var3, var48);
                                                                                                      } else if(var45 < 3400) {
                                                                                                         if(var45 == 3300) {
                                                                                                            class81.intStack[++class278.intStackSize - 1] = Client.gameCycle;
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3301) {
                                                                                                            class278.intStackSize -= 2;
                                                                                                            var14 = class81.intStack[class278.intStackSize];
                                                                                                            var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                            class81.intStack[++class278.intStackSize - 1] = class261.method4820(var14, var31);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3302) {
                                                                                                            class278.intStackSize -= 2;
                                                                                                            var14 = class81.intStack[class278.intStackSize];
                                                                                                            var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                            class81.intStack[++class278.intStackSize - 1] = DynamicObject.method1899(var14, var31);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3303) {
                                                                                                            class278.intStackSize -= 2;
                                                                                                            var14 = class81.intStack[class278.intStackSize];
                                                                                                            var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                            class81.intStack[++class278.intStackSize - 1] = Permission.method4170(var14, var31);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3304) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            var15 = class81.intStack;
                                                                                                            var16 = ++class278.intStackSize - 1;
                                                                                                            InvType var36 = (InvType)InvType.inventoryCache.get((long)var14);
                                                                                                            InvType var51;
                                                                                                            if(var36 != null) {
                                                                                                               var51 = var36;
                                                                                                            } else {
                                                                                                               byte[] var77 = InvType.field3276.getConfigData(5, var14);
                                                                                                               var36 = new InvType();
                                                                                                               if(var77 != null) {
                                                                                                                  var36.decode(new Buffer(var77));
                                                                                                               }

                                                                                                               InvType.inventoryCache.put(var36, (long)var14);
                                                                                                               var51 = var36;
                                                                                                            }

                                                                                                            var15[var16] = var51.size;
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3305) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            class81.intStack[++class278.intStackSize - 1] = Client.boostedSkillLevels[var14];
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3306) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            class81.intStack[++class278.intStackSize - 1] = Client.realSkillLevels[var14];
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3307) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            class81.intStack[++class278.intStackSize - 1] = Client.skillExperiences[var14];
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3308) {
                                                                                                            var14 = class46.plane;
                                                                                                            var31 = (class66.localPlayer.x >> 7) + class22.baseX;
                                                                                                            var16 = (class66.localPlayer.y >> 7) + class273.baseY;
                                                                                                            class81.intStack[++class278.intStackSize - 1] = (var31 << 14) + var16 + (var14 << 28);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3309) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            class81.intStack[++class278.intStackSize - 1] = var14 >> 14 & 16383;
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3310) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            class81.intStack[++class278.intStackSize - 1] = var14 >> 28;
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3311) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            class81.intStack[++class278.intStackSize - 1] = var14 & 16383;
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3312) {
                                                                                                            class81.intStack[++class278.intStackSize - 1] = Client.isMembers?1:0;
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 != 3313) {
                                                                                                            if(var45 == 3314) {
                                                                                                               class278.intStackSize -= 2;
                                                                                                               var14 = class81.intStack[class278.intStackSize] + 32768;
                                                                                                               var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                               class81.intStack[++class278.intStackSize - 1] = DynamicObject.method1899(var14, var31);
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 3315) {
                                                                                                               class278.intStackSize -= 2;
                                                                                                               var14 = class81.intStack[class278.intStackSize] + 32768;
                                                                                                               var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Permission.method4170(var14, var31);
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 3316) {
                                                                                                               if(Client.rights >= 2) {
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = Client.rights;
                                                                                                               } else {
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 3317) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.field1030;
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 3318) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.world;
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 3321) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.energy;
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 3322) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.weight;
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 3323) {
                                                                                                               if(Client.field1083) {
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = 1;
                                                                                                               } else {
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 3324) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.flags;
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 3325) {
                                                                                                               class278.intStackSize -= 4;
                                                                                                               var14 = class81.intStack[class278.intStackSize];
                                                                                                               var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                               var16 = class81.intStack[class278.intStackSize + 2];
                                                                                                               var30 = class81.intStack[class278.intStackSize + 3];
                                                                                                               var14 += var31 << 14;
                                                                                                               var14 += var16 << 28;
                                                                                                               var14 += var30;
                                                                                                               class81.intStack[++class278.intStackSize - 1] = var14;
                                                                                                               var13 = 1;
                                                                                                            } else {
                                                                                                               var13 = 2;
                                                                                                            }
                                                                                                         } else {
                                                                                                            class278.intStackSize -= 2;
                                                                                                            var14 = class81.intStack[class278.intStackSize] + 32768;
                                                                                                            var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                            int[] var72 = class81.intStack;
                                                                                                            var30 = ++class278.intStackSize - 1;
                                                                                                            ItemContainer var37 = (ItemContainer)ItemContainer.itemContainers.get((long)var14);
                                                                                                            if(var37 == null) {
                                                                                                               var18 = -1;
                                                                                                            } else if(var31 >= 0 && var31 < var37.itemIds.length) {
                                                                                                               var18 = var37.itemIds[var31];
                                                                                                            } else {
                                                                                                               var18 = -1;
                                                                                                            }

                                                                                                            var72[var30] = var18;
                                                                                                            var13 = 1;
                                                                                                         }

                                                                                                         var12 = var13;
                                                                                                      } else if(var45 < 3500) {
                                                                                                         var12 = class37.method491(var45, var3, var48);
                                                                                                      } else if(var45 < 3700) {
                                                                                                         if(var45 == 3600) {
                                                                                                            if(Client.field1180 == 0) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = -2;
                                                                                                            } else if(Client.field1180 == 1) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = -1;
                                                                                                            } else {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.friendCount;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3601) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            if(Client.field1180 == 2 && var14 < Client.friendCount) {
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = Client.friends[var14].name;
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = Client.friends[var14].previousName;
                                                                                                            } else {
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3602) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            if(Client.field1180 == 2 && var14 < Client.friendCount) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.friends[var14].world;
                                                                                                            } else {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3603) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            if(Client.field1180 == 2 && var14 < Client.friendCount) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.friends[var14].rank;
                                                                                                            } else {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3604) {
                                                                                                            var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                            var31 = class81.intStack[--class278.intStackSize];
                                                                                                            Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_146);
                                                                                                            Client.secretPacketBuffer1.putByte(class86.getLength(var62) + 1);
                                                                                                            Client.secretPacketBuffer1.method3225(var31);
                                                                                                            Client.secretPacketBuffer1.putString(var62);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3605) {
                                                                                                            var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                            class182.method3531(var62);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3606) {
                                                                                                            var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                            ItemContainer.method1078(var62);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3607) {
                                                                                                            var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                            class252.method4533(var62, false);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3608) {
                                                                                                            var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                            GrandExchangeOffer.method114(var62);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3609) {
                                                                                                            var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                            Permission[] var47 = new Permission[]{Permission.field3171, Permission.field3170, Permission.field3174, Permission.field3178, Permission.field3173, Permission.field3177};
                                                                                                            Permission[] var73 = var47;

                                                                                                            for(var30 = 0; var30 < var73.length; ++var30) {
                                                                                                               Permission var74 = var73[var30];
                                                                                                               if(var74.field3176 != -1 && var62.startsWith(AbstractByteBuffer.method3475(var74.field3176))) {
                                                                                                                  var62 = var62.substring(6 + Integer.toString(var74.field3176).length());
                                                                                                                  break;
                                                                                                               }
                                                                                                            }

                                                                                                            class81.intStack[++class278.intStackSize - 1] = class90.isFriended(var62, false)?1:0;
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3611) {
                                                                                                            if(Client.clanChatOwner != null) {
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = class86.method1719(Client.clanChatOwner);
                                                                                                            } else {
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3612) {
                                                                                                            if(Client.clanChatOwner != null) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = class2.clanChatCount;
                                                                                                            } else {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3613) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            if(Client.clanChatOwner != null && var14 < class2.clanChatCount) {
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = GraphicsObject.clanMembers[var14].username;
                                                                                                            } else {
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3614) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            if(Client.clanChatOwner != null && var14 < class2.clanChatCount) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = GraphicsObject.clanMembers[var14].world;
                                                                                                            } else {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3615) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            if(Client.clanChatOwner != null && var14 < class2.clanChatCount) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = GraphicsObject.clanMembers[var14].rank;
                                                                                                            } else {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3616) {
                                                                                                            class81.intStack[++class278.intStackSize - 1] = WallObject.field2109;
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3617) {
                                                                                                            var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                            RSSocket.method3056(var62);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3618) {
                                                                                                            class81.intStack[++class278.intStackSize - 1] = InvType.clanChatRank;
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3619) {
                                                                                                            var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                            Preferences.method1592(var62);
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3620) {
                                                                                                            Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_JOIN_CLANCHAT);
                                                                                                            if(Client.RUNELITE_PACKET) {
                                                                                                               Client.secretPacketBuffer1.runeliteWriteInt(0);
                                                                                                            } else {
                                                                                                               Client.secretPacketBuffer1.putByte(0);
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3621) {
                                                                                                            if(Client.field1180 == 0) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = -1;
                                                                                                            } else {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.ignoreCount;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3622) {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            if(Client.field1180 != 0 && var14 < Client.ignoreCount) {
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = Client.ignores[var14].name;
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = Client.ignores[var14].previousName;
                                                                                                            } else {
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         } else if(var45 == 3623) {
                                                                                                            var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                            if(var62.startsWith(AbstractByteBuffer.method3475(0)) || var62.startsWith(AbstractByteBuffer.method3475(1))) {
                                                                                                               var62 = var62.substring(7);
                                                                                                            }

                                                                                                            class81.intStack[++class278.intStackSize - 1] = class66.isIgnored(var62)?1:0;
                                                                                                            var13 = 1;
                                                                                                         } else if(var45 != 3624) {
                                                                                                            if(var45 == 3625) {
                                                                                                               if(Client.clanChatName != null) {
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = class86.method1719(Client.clanChatName);
                                                                                                               } else {
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else {
                                                                                                               var13 = 2;
                                                                                                            }
                                                                                                         } else {
                                                                                                            var14 = class81.intStack[--class278.intStackSize];
                                                                                                            if(GraphicsObject.clanMembers != null && var14 < class2.clanChatCount && GraphicsObject.clanMembers[var14].username.equalsIgnoreCase(class66.localPlayer.name)) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = 1;
                                                                                                            } else {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                            }

                                                                                                            var13 = 1;
                                                                                                         }

                                                                                                         var12 = var13;
                                                                                                      } else if(var45 < 4000) {
                                                                                                         var12 = FaceNormal.method2902(var45, var3, var48);
                                                                                                      } else if(var45 < 4100) {
                                                                                                         var12 = class37.method493(var45, var3, var48);
                                                                                                      } else if(var45 < 4200) {
                                                                                                         var12 = class56.method815(var45, var3, var48);
                                                                                                      } else if(var45 < 4300) {
                                                                                                         var12 = ItemContainer.method1080(var45, var3, var48);
                                                                                                      } else {
                                                                                                         byte[] var41;
                                                                                                         if(var45 < 5100) {
                                                                                                            if(var45 == 5000) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.field1088;
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 5001) {
                                                                                                               class278.intStackSize -= 3;
                                                                                                               Client.field1088 = class81.intStack[class278.intStackSize];
                                                                                                               class244.field3317 = ItemLayer.method2453(class81.intStack[class278.intStackSize + 1]);
                                                                                                               if(class244.field3317 == null) {
                                                                                                                  class244.field3317 = class277.field3744;
                                                                                                               }

                                                                                                               Client.field1071 = class81.intStack[class278.intStackSize + 2];
                                                                                                               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CHATFILTER_UPDATE);
                                                                                                               if(Client.RUNELITE_PACKET) {
                                                                                                                  Client.secretPacketBuffer1.runeliteWriteInt(Client.field1088);
                                                                                                                  Client.secretPacketBuffer1.runeliteWriteInt(class244.field3317.field3743);
                                                                                                                  Client.secretPacketBuffer1.runeliteWriteInt(Client.field1071);
                                                                                                               } else {
                                                                                                                  Client.secretPacketBuffer1.putByte(Client.field1088);
                                                                                                                  Client.secretPacketBuffer1.putByte(class244.field3317.field3743);
                                                                                                                  Client.secretPacketBuffer1.putByte(Client.field1071);
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 5002) {
                                                                                                               var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                               class278.intStackSize -= 2;
                                                                                                               var31 = class81.intStack[class278.intStackSize];
                                                                                                               var16 = class81.intStack[class278.intStackSize + 1];
                                                                                                               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_REPORTED_PLAYER);
                                                                                                               Client.secretPacketBuffer1.putByte(class86.getLength(var62) + 2);
                                                                                                               Client.secretPacketBuffer1.putString(var62);
                                                                                                               Client.secretPacketBuffer1.putByte(var31 - 1);
                                                                                                               Client.secretPacketBuffer1.putByte(var16);
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 5003) {
                                                                                                               class278.intStackSize -= 2;
                                                                                                               var14 = class81.intStack[class278.intStackSize];
                                                                                                               var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                               MessageNode var75 = class162.method3123(var14, var31);
                                                                                                               if(var75 != null) {
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = var75.id;
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = var75.tick;
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var75.name != null?var75.name:"";
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var75.sender != null?var75.sender:"";
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var75.value != null?var75.value:"";
                                                                                                               } else {
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = -1;
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 5004) {
                                                                                                               var14 = class81.intStack[--class278.intStackSize];
                                                                                                               MessageNode var50 = (MessageNode)class96.field1516.get((long)var14);
                                                                                                               if(var50 != null) {
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = var50.type;
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = var50.tick;
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var50.name != null?var50.name:"";
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var50.sender != null?var50.sender:"";
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var50.value != null?var50.value:"";
                                                                                                               } else {
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = -1;
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 5005) {
                                                                                                               if(class244.field3317 == null) {
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = -1;
                                                                                                               } else {
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = class244.field3317.field3743;
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 5008) {
                                                                                                               var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                               var31 = class81.intStack[--class278.intStackSize];
                                                                                                               var70 = var62.toLowerCase();
                                                                                                               byte var71 = 0;
                                                                                                               if(var70.startsWith("yellow:")) {
                                                                                                                  var71 = 0;
                                                                                                                  var62 = var62.substring("yellow:".length());
                                                                                                               } else if(var70.startsWith("red:")) {
                                                                                                                  var71 = 1;
                                                                                                                  var62 = var62.substring("red:".length());
                                                                                                               } else if(var70.startsWith("green:")) {
                                                                                                                  var71 = 2;
                                                                                                                  var62 = var62.substring("green:".length());
                                                                                                               } else if(var70.startsWith("cyan:")) {
                                                                                                                  var71 = 3;
                                                                                                                  var62 = var62.substring("cyan:".length());
                                                                                                               } else if(var70.startsWith("purple:")) {
                                                                                                                  var71 = 4;
                                                                                                                  var62 = var62.substring("purple:".length());
                                                                                                               } else if(var70.startsWith("white:")) {
                                                                                                                  var71 = 5;
                                                                                                                  var62 = var62.substring("white:".length());
                                                                                                               } else if(var70.startsWith("flash1:")) {
                                                                                                                  var71 = 6;
                                                                                                                  var62 = var62.substring("flash1:".length());
                                                                                                               } else if(var70.startsWith("flash2:")) {
                                                                                                                  var71 = 7;
                                                                                                                  var62 = var62.substring("flash2:".length());
                                                                                                               } else if(var70.startsWith("flash3:")) {
                                                                                                                  var71 = 8;
                                                                                                                  var62 = var62.substring("flash3:".length());
                                                                                                               } else if(var70.startsWith("glow1:")) {
                                                                                                                  var71 = 9;
                                                                                                                  var62 = var62.substring("glow1:".length());
                                                                                                               } else if(var70.startsWith("glow2:")) {
                                                                                                                  var71 = 10;
                                                                                                                  var62 = var62.substring("glow2:".length());
                                                                                                               } else if(var70.startsWith("glow3:")) {
                                                                                                                  var71 = 11;
                                                                                                                  var62 = var62.substring("glow3:".length());
                                                                                                               } else if(Client.languageId != 0) {
                                                                                                                  if(var70.startsWith("yellow:")) {
                                                                                                                     var71 = 0;
                                                                                                                     var62 = var62.substring("yellow:".length());
                                                                                                                  } else if(var70.startsWith("red:")) {
                                                                                                                     var71 = 1;
                                                                                                                     var62 = var62.substring("red:".length());
                                                                                                                  } else if(var70.startsWith("green:")) {
                                                                                                                     var71 = 2;
                                                                                                                     var62 = var62.substring("green:".length());
                                                                                                                  } else if(var70.startsWith("cyan:")) {
                                                                                                                     var71 = 3;
                                                                                                                     var62 = var62.substring("cyan:".length());
                                                                                                                  } else if(var70.startsWith("purple:")) {
                                                                                                                     var71 = 4;
                                                                                                                     var62 = var62.substring("purple:".length());
                                                                                                                  } else if(var70.startsWith("white:")) {
                                                                                                                     var71 = 5;
                                                                                                                     var62 = var62.substring("white:".length());
                                                                                                                  } else if(var70.startsWith("flash1:")) {
                                                                                                                     var71 = 6;
                                                                                                                     var62 = var62.substring("flash1:".length());
                                                                                                                  } else if(var70.startsWith("flash2:")) {
                                                                                                                     var71 = 7;
                                                                                                                     var62 = var62.substring("flash2:".length());
                                                                                                                  } else if(var70.startsWith("flash3:")) {
                                                                                                                     var71 = 8;
                                                                                                                     var62 = var62.substring("flash3:".length());
                                                                                                                  } else if(var70.startsWith("glow1:")) {
                                                                                                                     var71 = 9;
                                                                                                                     var62 = var62.substring("glow1:".length());
                                                                                                                  } else if(var70.startsWith("glow2:")) {
                                                                                                                     var71 = 10;
                                                                                                                     var62 = var62.substring("glow2:".length());
                                                                                                                  } else if(var70.startsWith("glow3:")) {
                                                                                                                     var71 = 11;
                                                                                                                     var62 = var62.substring("glow3:".length());
                                                                                                                  }
                                                                                                               }

                                                                                                               var70 = var62.toLowerCase();
                                                                                                               byte var58 = 0;
                                                                                                               if(var70.startsWith("wave:")) {
                                                                                                                  var58 = 1;
                                                                                                                  var62 = var62.substring("wave:".length());
                                                                                                               } else if(var70.startsWith("wave2:")) {
                                                                                                                  var58 = 2;
                                                                                                                  var62 = var62.substring("wave2:".length());
                                                                                                               } else if(var70.startsWith("shake:")) {
                                                                                                                  var58 = 3;
                                                                                                                  var62 = var62.substring("shake:".length());
                                                                                                               } else if(var70.startsWith("scroll:")) {
                                                                                                                  var58 = 4;
                                                                                                                  var62 = var62.substring("scroll:".length());
                                                                                                               } else if(var70.startsWith("slide:")) {
                                                                                                                  var58 = 5;
                                                                                                                  var62 = var62.substring("slide:".length());
                                                                                                               } else if(Client.languageId != 0) {
                                                                                                                  if(var70.startsWith("wave:")) {
                                                                                                                     var58 = 1;
                                                                                                                     var62 = var62.substring("wave:".length());
                                                                                                                  } else if(var70.startsWith("wave2:")) {
                                                                                                                     var58 = 2;
                                                                                                                     var62 = var62.substring("wave2:".length());
                                                                                                                  } else if(var70.startsWith("shake:")) {
                                                                                                                     var58 = 3;
                                                                                                                     var62 = var62.substring("shake:".length());
                                                                                                                  } else if(var70.startsWith("scroll:")) {
                                                                                                                     var58 = 4;
                                                                                                                     var62 = var62.substring("scroll:".length());
                                                                                                                  } else if(var70.startsWith("slide:")) {
                                                                                                                     var58 = 5;
                                                                                                                     var62 = var62.substring("slide:".length());
                                                                                                                  }
                                                                                                               }

                                                                                                               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CHATBOX_INPUT);
                                                                                                               if(Client.RUNELITE_PACKET) {
                                                                                                                  Client.secretPacketBuffer1.runeliteWriteInt(0);
                                                                                                               } else {
                                                                                                                  Client.secretPacketBuffer1.putByte(0);
                                                                                                               }

                                                                                                               var19 = Client.secretPacketBuffer1.offset;
                                                                                                               Client.secretPacketBuffer1.putByte(var31);
                                                                                                               Client.secretPacketBuffer1.putByte(var71);
                                                                                                               Client.secretPacketBuffer1.putByte(var58);
                                                                                                               PacketBuffer var68 = Client.secretPacketBuffer1;
                                                                                                               var21 = var68.offset;
                                                                                                               var59 = var62.length();
                                                                                                               byte[] var38 = new byte[var59];
                                                                                                               int var25 = 0;

                                                                                                               while(true) {
                                                                                                                  if(var25 >= var59) {
                                                                                                                     var68.putShortSmart(var38.length);
                                                                                                                     var68.offset += class265.field3661.compress(var38, 0, var38.length, var68.payload, var68.offset);
                                                                                                                     Client.secretPacketBuffer1.putLength(Client.secretPacketBuffer1.offset - var19);
                                                                                                                     var13 = 1;
                                                                                                                     break;
                                                                                                                  }

                                                                                                                  char var26 = var62.charAt(var25);
                                                                                                                  if(var26 > 0 && var26 < 128 || var26 >= 160 && var26 <= 255) {
                                                                                                                     var38[var25] = (byte)var26;
                                                                                                                  } else if(var26 == 8364) {
                                                                                                                     var38[var25] = -128;
                                                                                                                  } else if(var26 == 8218) {
                                                                                                                     var38[var25] = -126;
                                                                                                                  } else if(var26 == 402) {
                                                                                                                     var38[var25] = -125;
                                                                                                                  } else if(var26 == 8222) {
                                                                                                                     var38[var25] = -124;
                                                                                                                  } else if(var26 == 8230) {
                                                                                                                     var38[var25] = -123;
                                                                                                                  } else if(var26 == 8224) {
                                                                                                                     var38[var25] = -122;
                                                                                                                  } else if(var26 == 8225) {
                                                                                                                     var38[var25] = -121;
                                                                                                                  } else if(var26 == 710) {
                                                                                                                     var38[var25] = -120;
                                                                                                                  } else if(var26 == 8240) {
                                                                                                                     var38[var25] = -119;
                                                                                                                  } else if(var26 == 352) {
                                                                                                                     var38[var25] = -118;
                                                                                                                  } else if(var26 == 8249) {
                                                                                                                     var38[var25] = -117;
                                                                                                                  } else if(var26 == 338) {
                                                                                                                     var38[var25] = -116;
                                                                                                                  } else if(var26 == 381) {
                                                                                                                     var38[var25] = -114;
                                                                                                                  } else if(var26 == 8216) {
                                                                                                                     var38[var25] = -111;
                                                                                                                  } else if(var26 == 8217) {
                                                                                                                     var38[var25] = -110;
                                                                                                                  } else if(var26 == 8220) {
                                                                                                                     var38[var25] = -109;
                                                                                                                  } else if(var26 == 8221) {
                                                                                                                     var38[var25] = -108;
                                                                                                                  } else if(var26 == 8226) {
                                                                                                                     var38[var25] = -107;
                                                                                                                  } else if(var26 == 8211) {
                                                                                                                     var38[var25] = -106;
                                                                                                                  } else if(var26 == 8212) {
                                                                                                                     var38[var25] = -105;
                                                                                                                  } else if(var26 == 732) {
                                                                                                                     var38[var25] = -104;
                                                                                                                  } else if(var26 == 8482) {
                                                                                                                     var38[var25] = -103;
                                                                                                                  } else if(var26 == 353) {
                                                                                                                     var38[var25] = -102;
                                                                                                                  } else if(var26 == 8250) {
                                                                                                                     var38[var25] = -101;
                                                                                                                  } else if(var26 == 339) {
                                                                                                                     var38[var25] = -100;
                                                                                                                  } else if(var26 == 382) {
                                                                                                                     var38[var25] = -98;
                                                                                                                  } else if(var26 == 376) {
                                                                                                                     var38[var25] = -97;
                                                                                                                  } else {
                                                                                                                     var38[var25] = 63;
                                                                                                                  }

                                                                                                                  ++var25;
                                                                                                               }
                                                                                                            } else if(var45 == 5009) {
                                                                                                               class266.scriptStringStackSize -= 2;
                                                                                                               var62 = class81.scriptStringStack[class266.scriptStringStackSize];
                                                                                                               var46 = class81.scriptStringStack[class266.scriptStringStackSize + 1];
                                                                                                               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_PRIVMSG);
                                                                                                               if(Client.RUNELITE_PACKET) {
                                                                                                                  Client.secretPacketBuffer1.runeliteWriteInt(0);
                                                                                                               } else {
                                                                                                                  Client.secretPacketBuffer1.putShort(0);
                                                                                                               }

                                                                                                               var16 = Client.secretPacketBuffer1.offset;
                                                                                                               Client.secretPacketBuffer1.putString(var62);
                                                                                                               PacketBuffer var54 = Client.secretPacketBuffer1;
                                                                                                               var18 = var54.offset;
                                                                                                               var20 = var46.length();
                                                                                                               var41 = new byte[var20];
                                                                                                               var22 = 0;

                                                                                                               while(true) {
                                                                                                                  if(var22 >= var20) {
                                                                                                                     var54.putShortSmart(var41.length);
                                                                                                                     var54.offset += class265.field3661.compress(var41, 0, var41.length, var54.payload, var54.offset);
                                                                                                                     Client.secretPacketBuffer1.putShortLength(Client.secretPacketBuffer1.offset - var16);
                                                                                                                     var13 = 1;
                                                                                                                     break;
                                                                                                                  }

                                                                                                                  var23 = var46.charAt(var22);
                                                                                                                  if((var23 <= 0 || var23 >= 128) && (var23 < 160 || var23 > 255)) {
                                                                                                                     if(var23 == 8364) {
                                                                                                                        var41[var22] = -128;
                                                                                                                     } else if(var23 == 8218) {
                                                                                                                        var41[var22] = -126;
                                                                                                                     } else if(var23 == 402) {
                                                                                                                        var41[var22] = -125;
                                                                                                                     } else if(var23 == 8222) {
                                                                                                                        var41[var22] = -124;
                                                                                                                     } else if(var23 == 8230) {
                                                                                                                        var41[var22] = -123;
                                                                                                                     } else if(var23 == 8224) {
                                                                                                                        var41[var22] = -122;
                                                                                                                     } else if(var23 == 8225) {
                                                                                                                        var41[var22] = -121;
                                                                                                                     } else if(var23 == 710) {
                                                                                                                        var41[var22] = -120;
                                                                                                                     } else if(var23 == 8240) {
                                                                                                                        var41[var22] = -119;
                                                                                                                     } else if(var23 == 352) {
                                                                                                                        var41[var22] = -118;
                                                                                                                     } else if(var23 == 8249) {
                                                                                                                        var41[var22] = -117;
                                                                                                                     } else if(var23 == 338) {
                                                                                                                        var41[var22] = -116;
                                                                                                                     } else if(var23 == 381) {
                                                                                                                        var41[var22] = -114;
                                                                                                                     } else if(var23 == 8216) {
                                                                                                                        var41[var22] = -111;
                                                                                                                     } else if(var23 == 8217) {
                                                                                                                        var41[var22] = -110;
                                                                                                                     } else if(var23 == 8220) {
                                                                                                                        var41[var22] = -109;
                                                                                                                     } else if(var23 == 8221) {
                                                                                                                        var41[var22] = -108;
                                                                                                                     } else if(var23 == 8226) {
                                                                                                                        var41[var22] = -107;
                                                                                                                     } else if(var23 == 8211) {
                                                                                                                        var41[var22] = -106;
                                                                                                                     } else if(var23 == 8212) {
                                                                                                                        var41[var22] = -105;
                                                                                                                     } else if(var23 == 732) {
                                                                                                                        var41[var22] = -104;
                                                                                                                     } else if(var23 == 8482) {
                                                                                                                        var41[var22] = -103;
                                                                                                                     } else if(var23 == 353) {
                                                                                                                        var41[var22] = -102;
                                                                                                                     } else if(var23 == 8250) {
                                                                                                                        var41[var22] = -101;
                                                                                                                     } else if(var23 == 339) {
                                                                                                                        var41[var22] = -100;
                                                                                                                     } else if(var23 == 382) {
                                                                                                                        var41[var22] = -98;
                                                                                                                     } else if(var23 == 376) {
                                                                                                                        var41[var22] = -97;
                                                                                                                     } else {
                                                                                                                        var41[var22] = 63;
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     var41[var22] = (byte)var23;
                                                                                                                  }

                                                                                                                  ++var22;
                                                                                                               }
                                                                                                            } else if(var45 != 5015) {
                                                                                                               if(var45 == 5016) {
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = Client.field1071;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 5017) {
                                                                                                                  var14 = class81.intStack[--class278.intStackSize];
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = class20.method155(var14);
                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 5018) {
                                                                                                                  var14 = class81.intStack[--class278.intStackSize];
                                                                                                                  class81.intStack[++class278.intStackSize - 1] = Script.method1898(var14);
                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 5019) {
                                                                                                                  var14 = class81.intStack[--class278.intStackSize];
                                                                                                                  var15 = class81.intStack;
                                                                                                                  var16 = ++class278.intStackSize - 1;
                                                                                                                  MessageNode var76 = (MessageNode)class96.field1516.get((long)var14);
                                                                                                                  if(var76 == null) {
                                                                                                                     var30 = -1;
                                                                                                                  } else if(var76.next == class96.field1517.field2483) {
                                                                                                                     var30 = -1;
                                                                                                                  } else {
                                                                                                                     var30 = ((MessageNode)var76.next).id;
                                                                                                                  }

                                                                                                                  var15[var16] = var30;
                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 5020) {
                                                                                                                  var62 = class81.scriptStringStack[--class266.scriptStringStackSize];
                                                                                                                  CacheFile.method2399(var62);
                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 5021) {
                                                                                                                  Client.field990 = class81.scriptStringStack[--class266.scriptStringStackSize].toLowerCase().trim();
                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 5022) {
                                                                                                                  class81.scriptStringStack[++class266.scriptStringStackSize - 1] = Client.field990;
                                                                                                                  var13 = 1;
                                                                                                               } else {
                                                                                                                  var13 = 2;
                                                                                                               }
                                                                                                            } else {
                                                                                                               if(class66.localPlayer != null && class66.localPlayer.name != null) {
                                                                                                                  var62 = class66.localPlayer.name;
                                                                                                               } else {
                                                                                                                  var62 = "";
                                                                                                               }

                                                                                                               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var62;
                                                                                                               var13 = 1;
                                                                                                            }

                                                                                                            var12 = var13;
                                                                                                         } else if(var45 < 5400) {
                                                                                                            var12 = WallObject.method2900(var45, var3, var48);
                                                                                                         } else if(var45 < 5600) {
                                                                                                            if(var45 == 5504) {
                                                                                                               class278.intStackSize -= 2;
                                                                                                               var30 = class81.intStack[class278.intStackSize];
                                                                                                               var18 = class81.intStack[class278.intStackSize + 1];
                                                                                                               if(!Client.field1160) {
                                                                                                                  Client.field997 = var30;
                                                                                                                  Client.mapAngle = var18;
                                                                                                               }

                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 5505) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.field997;
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 5506) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.mapAngle;
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 5530) {
                                                                                                               var30 = class81.intStack[--class278.intStackSize];
                                                                                                               if(var30 < 0) {
                                                                                                                  var30 = 0;
                                                                                                               }

                                                                                                               Client.field1069 = var30;
                                                                                                               var13 = 1;
                                                                                                            } else if(var45 == 5531) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = Client.field1069;
                                                                                                               var13 = 1;
                                                                                                            } else {
                                                                                                               var13 = 2;
                                                                                                            }

                                                                                                            var12 = var13;
                                                                                                         } else if(var45 < 5700) {
                                                                                                            var12 = ContextMenuRow.method1720(var45, var3, var48);
                                                                                                         } else if(var45 < 6300) {
                                                                                                            var12 = class89.method1733(var45, var3, var48);
                                                                                                         } else if(var45 < 6600) {
                                                                                                            if(var45 == 6500) {
                                                                                                               class81.intStack[++class278.intStackSize - 1] = class70.loadWorlds()?1:0;
                                                                                                               var13 = 1;
                                                                                                            } else {
                                                                                                               World var80;
                                                                                                               if(var45 == 6501) {
                                                                                                                  var80 = ItemLayer.method2451();
                                                                                                                  if(var80 != null) {
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = var80.id;
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = var80.mask;
                                                                                                                     class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var80.activity;
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = var80.location;
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = var80.playerCount;
                                                                                                                     class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var80.address;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = -1;
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                     class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                     class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else if(var45 == 6502) {
                                                                                                                  if(World.field1283 < World.worldCount) {
                                                                                                                     var80 = class266.worldList[++World.field1283 - 1];
                                                                                                                  } else {
                                                                                                                     var80 = null;
                                                                                                                  }

                                                                                                                  if(var80 != null) {
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = var80.id;
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = var80.mask;
                                                                                                                     class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var80.activity;
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = var80.location;
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = var80.playerCount;
                                                                                                                     class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var80.address;
                                                                                                                  } else {
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = -1;
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                     class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                     class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                     class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                                  }

                                                                                                                  var13 = 1;
                                                                                                               } else {
                                                                                                                  World var52;
                                                                                                                  if(var45 == 6506) {
                                                                                                                     var14 = class81.intStack[--class278.intStackSize];
                                                                                                                     var52 = null;

                                                                                                                     for(var16 = 0; var16 < World.worldCount; ++var16) {
                                                                                                                        if(var14 == class266.worldList[var16].id) {
                                                                                                                           var52 = class266.worldList[var16];
                                                                                                                           break;
                                                                                                                        }
                                                                                                                     }

                                                                                                                     if(var52 != null) {
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = var52.id;
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = var52.mask;
                                                                                                                        class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var52.activity;
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = var52.location;
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = var52.playerCount;
                                                                                                                        class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var52.address;
                                                                                                                     } else {
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = -1;
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                        class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                        class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var45 == 6507) {
                                                                                                                     class278.intStackSize -= 4;
                                                                                                                     var14 = class81.intStack[class278.intStackSize];
                                                                                                                     var67 = class81.intStack[class278.intStackSize + 1] == 1;
                                                                                                                     var16 = class81.intStack[class278.intStackSize + 2];
                                                                                                                     var64 = class81.intStack[class278.intStackSize + 3] == 1;
                                                                                                                     if(class266.worldList != null) {
                                                                                                                        class5.method15(0, class266.worldList.length - 1, var14, var67, var16, var64);
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  } else if(var45 != 6511) {
                                                                                                                     if(var45 == 6512) {
                                                                                                                        Client.field1174 = class81.intStack[--class278.intStackSize] == 1;
                                                                                                                        var13 = 1;
                                                                                                                     } else {
                                                                                                                        class251 var78;
                                                                                                                        if(var45 == 6513) {
                                                                                                                           class278.intStackSize -= 2;
                                                                                                                           var14 = class81.intStack[class278.intStackSize];
                                                                                                                           var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                                           var78 = class182.method3532(var31);
                                                                                                                           if(var78.method4510()) {
                                                                                                                              class81.scriptStringStack[++class266.scriptStringStackSize - 1] = class17.getNpcDefinition(var14).method4751(var31, var78.field3388);
                                                                                                                           } else {
                                                                                                                              class81.intStack[++class278.intStackSize - 1] = class17.getNpcDefinition(var14).method4732(var31, var78.field3386);
                                                                                                                           }

                                                                                                                           var13 = 1;
                                                                                                                        } else if(var45 == 6514) {
                                                                                                                           class278.intStackSize -= 2;
                                                                                                                           var14 = class81.intStack[class278.intStackSize];
                                                                                                                           var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                                           var78 = class182.method3532(var31);
                                                                                                                           if(var78.method4510()) {
                                                                                                                              class81.scriptStringStack[++class266.scriptStringStackSize - 1] = CollisionData.getObjectDefinition(var14).method4624(var31, var78.field3388);
                                                                                                                           } else {
                                                                                                                              class81.intStack[++class278.intStackSize - 1] = CollisionData.getObjectDefinition(var14).method4625(var31, var78.field3386);
                                                                                                                           }

                                                                                                                           var13 = 1;
                                                                                                                        } else if(var45 == 6515) {
                                                                                                                           class278.intStackSize -= 2;
                                                                                                                           var14 = class81.intStack[class278.intStackSize];
                                                                                                                           var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                                           var78 = class182.method3532(var31);
                                                                                                                           if(var78.method4510()) {
                                                                                                                              class81.scriptStringStack[++class266.scriptStringStackSize - 1] = FaceNormal.getItemDefinition(var14).method4668(var31, var78.field3388);
                                                                                                                           } else {
                                                                                                                              class81.intStack[++class278.intStackSize - 1] = FaceNormal.getItemDefinition(var14).method4667(var31, var78.field3386);
                                                                                                                           }

                                                                                                                           var13 = 1;
                                                                                                                        } else if(var45 == 6516) {
                                                                                                                           class278.intStackSize -= 2;
                                                                                                                           var14 = class81.intStack[class278.intStackSize];
                                                                                                                           var31 = class81.intStack[class278.intStackSize + 1];
                                                                                                                           var78 = class182.method3532(var31);
                                                                                                                           class252 var69;
                                                                                                                           class252 var79;
                                                                                                                           if(var78.method4510()) {
                                                                                                                              String[] var56 = class81.scriptStringStack;
                                                                                                                              var18 = ++class266.scriptStringStackSize - 1;
                                                                                                                              var69 = (class252)class252.field3394.get((long)var14);
                                                                                                                              if(var69 != null) {
                                                                                                                                 var79 = var69;
                                                                                                                              } else {
                                                                                                                                 var41 = class252.field3397.getConfigData(34, var14);
                                                                                                                                 var69 = new class252();
                                                                                                                                 if(var41 != null) {
                                                                                                                                    var69.method4539(new Buffer(var41));
                                                                                                                                 }

                                                                                                                                 var69.method4532();
                                                                                                                                 class252.field3394.put(var69, (long)var14);
                                                                                                                                 var79 = var69;
                                                                                                                              }

                                                                                                                              var56[var18] = var79.method4535(var31, var78.field3388);
                                                                                                                           } else {
                                                                                                                              var49 = class81.intStack;
                                                                                                                              var18 = ++class278.intStackSize - 1;
                                                                                                                              var69 = (class252)class252.field3394.get((long)var14);
                                                                                                                              if(var69 != null) {
                                                                                                                                 var79 = var69;
                                                                                                                              } else {
                                                                                                                                 var41 = class252.field3397.getConfigData(34, var14);
                                                                                                                                 var69 = new class252();
                                                                                                                                 if(var41 != null) {
                                                                                                                                    var69.method4539(new Buffer(var41));
                                                                                                                                 }

                                                                                                                                 var69.method4532();
                                                                                                                                 class252.field3394.put(var69, (long)var14);
                                                                                                                                 var79 = var69;
                                                                                                                              }

                                                                                                                              var49[var18] = var79.method4536(var31, var78.field3386);
                                                                                                                           }

                                                                                                                           var13 = 1;
                                                                                                                        } else if(var45 == 6518) {
                                                                                                                           class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                           var13 = 1;
                                                                                                                        } else if(var45 == 6520) {
                                                                                                                           var13 = 1;
                                                                                                                        } else if(var45 == 6521) {
                                                                                                                           var13 = 1;
                                                                                                                        } else {
                                                                                                                           var13 = 2;
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     var14 = class81.intStack[--class278.intStackSize];
                                                                                                                     if(var14 >= 0 && var14 < World.worldCount) {
                                                                                                                        var52 = class266.worldList[var14];
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = var52.id;
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = var52.mask;
                                                                                                                        class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var52.activity;
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = var52.location;
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = var52.playerCount;
                                                                                                                        class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var52.address;
                                                                                                                     } else {
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = -1;
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                        class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                        class81.intStack[++class278.intStackSize - 1] = 0;
                                                                                                                        class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
                                                                                                                     }

                                                                                                                     var13 = 1;
                                                                                                                  }
                                                                                                               }
                                                                                                            }

                                                                                                            var12 = var13;
                                                                                                         } else if(var45 < 6700) {
                                                                                                            var12 = class8.method41(var45, var3, var48);
                                                                                                         } else {
                                                                                                            var12 = 2;
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }

                                                                                             switch(var12) {
                                                                                             case 0:
                                                                                                return;
                                                                                             case 1:
                                                                                             default:
                                                                                                break;
                                                                                             case 2:
                                                                                                throw new IllegalStateException();
                                                                                             }
                                                                                          }
                                                                                       }
                                                                                    }
                                                                                 }
                                                                              }
                                                                           }
                                                                        }
                                                                     }
                                                                  }
                                                               }
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         } catch (Exception var44) {
            StringBuilder var43 = new StringBuilder(30);
            var43.append("").append(var3.hash).append(" ");

            for(var10 = class81.scriptStackCount - 1; var10 >= 0; --var10) {
               var43.append("").append(class81.scriptStack[var10].invokedFromScript.hash).append(" ");
            }

            var43.append("").append(var7);
            class46.method680(var43.toString(), var44);
         }
      }
   }
}
