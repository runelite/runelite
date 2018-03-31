import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -894772563
   )
   @Export("x")
   int x;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1684394433
   )
   @Export("y")
   int y;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 316543435
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("as")
   boolean field1181;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 35693955
   )
   int field1153;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -995819749
   )
   int field1154;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1545883651
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1497745629
   )
   int field1195;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1831858249
   )
   int field1157;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -2083201547
   )
   int field1158;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1577193745
   )
   int field1172;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 553308407
   )
   int field1160;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1204845101
   )
   int field1161;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -150089885
   )
   int field1162;
   @ObfuscatedName("ay")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("ad")
   boolean field1167;
   @ObfuscatedName("at")
   boolean field1179;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1101422759
   )
   @Export("overheadTextCyclesRemaining")
   int overheadTextCyclesRemaining;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 624807391
   )
   int field1207;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1727320469
   )
   int field1168;
   @ObfuscatedName("au")
   byte field1169;
   @ObfuscatedName("an")
   int[] field1170;
   @ObfuscatedName("bv")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("bw")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("bj")
   int[] field1150;
   @ObfuscatedName("ba")
   int[] field1174;
   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 17675511
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bh")
   boolean field1177;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 585193291
   )
   int field1165;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -865838849
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 742068837
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -58321547
   )
   @Export("poseFrameCycle")
   int poseFrameCycle;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1243839969
   )
   @Export("animation")
   int animation;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -11015395
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1866414785
   )
   @Export("actionFrameCycle")
   int actionFrameCycle;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -409835841
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 952377461
   )
   int field1186;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1743712713
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1440662483
   )
   @Export("spotAnimFrame")
   int spotAnimFrame;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 570715383
   )
   @Export("spotAnimFrameCycle")
   int spotAnimFrameCycle;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 539257231
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -409872095
   )
   int field1191;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -92257683
   )
   int field1192;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -634332443
   )
   int field1193;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -704597565
   )
   int field1202;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1031459545
   )
   int field1178;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 689607609
   )
   int field1196;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 1993899653
   )
   int field1197;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = 729096549
   )
   int field1198;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 646546065
   )
   @Export("npcCycle")
   int npcCycle;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = 1038072977
   )
   @Export("logicalHeight")
   int logicalHeight;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1736719235
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -507931907
   )
   int field1149;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -542049515
   )
   int field1203;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 454379183
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("cm")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cc")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("cg")
   @Export("pathTraversed")
   byte[] pathTraversed;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -262787313
   )
   int field1208;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = -290604787
   )
   int field1194;

   Actor() {
      this.field1181 = false;
      this.field1153 = 1;
      this.idlePoseAnimation = -1;
      this.field1195 = -1;
      this.field1157 = -1;
      this.field1158 = -1;
      this.field1172 = -1;
      this.field1160 = -1;
      this.field1161 = -1;
      this.field1162 = -1;
      this.overhead = null;
      this.field1179 = false;
      this.overheadTextCyclesRemaining = 100;
      this.field1207 = 0;
      this.field1168 = 0;
      this.field1169 = 0;
      this.field1170 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1150 = new int[4];
      this.field1174 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1177 = false;
      this.field1165 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.poseFrameCycle = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.actionFrameCycle = 0;
      this.actionAnimationDisable = 0;
      this.field1186 = 0;
      this.graphic = -1;
      this.spotAnimFrame = 0;
      this.spotAnimFrameCycle = 0;
      this.npcCycle = 0;
      this.logicalHeight = 200;
      this.field1149 = 0;
      this.field1203 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.pathTraversed = new byte[10];
      this.field1208 = 0;
      this.field1194 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1859897197"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-200057315"
   )
   final void method1589() {
      this.queueSize = 0;
      this.field1194 = 0;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "53"
   )
   final void method1586(int var1, int var2, int var3, int var4, int var5, int var6) {
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
         class281 var12 = BoundingBox2D.method49(var1);
         var10 = var12.field3581;
         var11 = var12.field3572;
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
            this.field1169 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1169;
            this.field1169 = (byte)((this.field1169 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1170[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1150[var9] = var3;
         this.field1174[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "45"
   )
   @Export("setCombatInfo")
   @Hook("onSetCombatInfo")
   final void setCombatInfo(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = class158.method3188(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field3521;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.last(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.previous()) {
         ++var11;
         if(var12.combatInfo2.field3529 == var7.field3529) {
            var12.method1818(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field3520 <= var7.field3520) {
            var8 = var12;
         }

         if(var12.combatInfo2.field3521 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field3521;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.addLast(var12);
         } else {
            CombatInfoList.method3986(var12, var8);
         }

         var12.method1818(var2 + var4, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1264970380"
   )
   final void method1588(int var1) {
      CombatInfo2 var2 = class158.method3188(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.last(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.previous()) {
         if(var2 == var3.combatInfo2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIILez;[Lfk;I)V",
      garbageValue = "185881938"
   )
   static final void method1587(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.getUSmart();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.getUSmart();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var11 + var1;
            int var17 = var10 + var2;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class62.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class234.addObject(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "1823450353"
   )
   static int method1601(int var0, Script var1, boolean var2) {
      if(var0 == 6500) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = class265.loadWorlds()?1:0;
         return 1;
      } else {
         World var4;
         if(var0 == 6501) {
            World.field1223 = 0;
            if(World.field1223 < World.worldCount) {
               var4 = FaceNormal.worldList[++World.field1223 - 1];
            } else {
               var4 = null;
            }

            if(var4 != null) {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var4.id;
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var4.mask;
               class81.scriptStringStack[++World.scriptStringStackSize - 1] = var4.activity;
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var4.location;
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var4.playerCount;
               class81.scriptStringStack[++World.scriptStringStackSize - 1] = var4.address;
            } else {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
               class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
               class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
               class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
               class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
               class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 6502) {
            World var3;
            if(World.field1223 < World.worldCount) {
               var3 = FaceNormal.worldList[++World.field1223 - 1];
            } else {
               var3 = null;
            }

            if(var3 != null) {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.id;
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.mask;
               class81.scriptStringStack[++World.scriptStringStackSize - 1] = var3.activity;
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.location;
               class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.playerCount;
               class81.scriptStringStack[++World.scriptStringStackSize - 1] = var3.address;
            } else {
               class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
               class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
               class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
               class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
               class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
               class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else {
            int var5;
            int var7;
            if(var0 == 6506) {
               var7 = class81.intStack[--SceneTilePaint.intStackSize];
               var4 = null;

               for(var5 = 0; var5 < World.worldCount; ++var5) {
                  if(var7 == FaceNormal.worldList[var5].id) {
                     var4 = FaceNormal.worldList[var5];
                     break;
                  }
               }

               if(var4 != null) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var4.id;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var4.mask;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var4.activity;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var4.location;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var4.playerCount;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var4.address;
               } else {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 6507) {
               SceneTilePaint.intStackSize -= 4;
               var7 = class81.intStack[SceneTilePaint.intStackSize];
               boolean var10 = class81.intStack[SceneTilePaint.intStackSize + 1] == 1;
               var5 = class81.intStack[SceneTilePaint.intStackSize + 2];
               boolean var6 = class81.intStack[SceneTilePaint.intStackSize + 3] == 1;
               class25.method201(var7, var10, var5, var6);
               return 1;
            } else if(var0 != 6511) {
               if(var0 == 6512) {
                  Client.field1094 = class81.intStack[--SceneTilePaint.intStackSize] == 1;
                  return 1;
               } else {
                  int var8;
                  class278 var9;
                  if(var0 == 6513) {
                     SceneTilePaint.intStackSize -= 2;
                     var7 = class81.intStack[SceneTilePaint.intStackSize];
                     var8 = class81.intStack[SceneTilePaint.intStackSize + 1];
                     var9 = Client.method1577(var8);
                     if(var9.method4907()) {
                        class81.scriptStringStack[++World.scriptStringStackSize - 1] = ScriptEvent.getNpcDefinition(var7).method5130(var8, var9.field3546);
                     } else {
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = ScriptEvent.getNpcDefinition(var7).method5129(var8, var9.field3543);
                     }

                     return 1;
                  } else if(var0 == 6514) {
                     SceneTilePaint.intStackSize -= 2;
                     var7 = class81.intStack[SceneTilePaint.intStackSize];
                     var8 = class81.intStack[SceneTilePaint.intStackSize + 1];
                     var9 = Client.method1577(var8);
                     if(var9.method4907()) {
                        class81.scriptStringStack[++World.scriptStringStackSize - 1] = FileRequest.getObjectDefinition(var7).method5010(var8, var9.field3546);
                     } else {
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = FileRequest.getObjectDefinition(var7).method5009(var8, var9.field3543);
                     }

                     return 1;
                  } else if(var0 == 6515) {
                     SceneTilePaint.intStackSize -= 2;
                     var7 = class81.intStack[SceneTilePaint.intStackSize];
                     var8 = class81.intStack[SceneTilePaint.intStackSize + 1];
                     var9 = Client.method1577(var8);
                     if(var9.method4907()) {
                        class81.scriptStringStack[++World.scriptStringStackSize - 1] = GameObject.getItemDefinition(var7).method5068(var8, var9.field3546);
                     } else {
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = GameObject.getItemDefinition(var7).method5067(var8, var9.field3543);
                     }

                     return 1;
                  } else if(var0 == 6516) {
                     SceneTilePaint.intStackSize -= 2;
                     var7 = class81.intStack[SceneTilePaint.intStackSize];
                     var8 = class81.intStack[SceneTilePaint.intStackSize + 1];
                     var9 = Client.method1577(var8);
                     if(var9.method4907()) {
                        class81.scriptStringStack[++World.scriptStringStackSize - 1] = Item.method1926(var7).method4928(var8, var9.field3546);
                     } else {
                        class81.intStack[++SceneTilePaint.intStackSize - 1] = Item.method1926(var7).method4927(var8, var9.field3543);
                     }

                     return 1;
                  } else if(var0 == 6518) {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                     return 1;
                  } else {
                     return var0 == 6520?1:(var0 == 6521?1:2);
                  }
               }
            } else {
               var7 = class81.intStack[--SceneTilePaint.intStackSize];
               if(var7 >= 0 && var7 < World.worldCount) {
                  var4 = FaceNormal.worldList[var7];
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var4.id;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var4.mask;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var4.activity;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var4.location;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var4.playerCount;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var4.address;
               } else {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
               }

               return 1;
            }
         }
      }
   }
}
