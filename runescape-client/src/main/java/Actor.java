import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -710532341
   )
   int field603 = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1546511359
   )
   @Export("y")
   int y;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1717436643
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1902616483
   )
   int field606;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 488955595
   )
   int field607 = 1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -2145670947
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("ca")
   byte[] field609 = new byte[10];
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -129998239
   )
   int field610 = -1;
   @ObfuscatedName("ak")
   int[] field611 = new int[4];
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1418300081
   )
   int field612 = -1;
   @ObfuscatedName("ar")
   boolean field613;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -516228895
   )
   int field614 = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -810962445
   )
   int field615 = -1;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1741263383
   )
   int field616;
   @ObfuscatedName("ai")
   byte field617 = 0;
   @ObfuscatedName("az")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1262053175
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 925127981
   )
   int field620 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -694806463
   )
   int field621 = -1;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -110559115
   )
   int field622 = 0;
   @ObfuscatedName("at")
   int[] field623 = new int[4];
   @ObfuscatedName("ah")
   int[] field624 = new int[4];
   @ObfuscatedName("am")
   int[] field625 = new int[4];
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1605911455
   )
   int field626;
   @ObfuscatedName("by")
   int[] field627 = new int[4];
   @ObfuscatedName("bf")
   @Export("combatInfoList")
   CombatInfoList combatInfoList = new CombatInfoList();
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1515231989
   )
   int field629 = 0;
   @ObfuscatedName("bi")
   boolean field630 = false;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -756721395
   )
   int field631 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1380229681
   )
   int field632 = -1;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -527726147
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 105615081
   )
   int field634 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1072839391
   )
   @Export("x")
   int x;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1907073349
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1120372219
   )
   int field637 = 100;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -110439831
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -343103553
   )
   int field639 = 0;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -2142633297
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 363515535
   )
   int field641 = 0;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 797213789
   )
   int field642 = 0;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1220571239
   )
   int field643;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 766106579
   )
   int field644;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1791208759
   )
   int field645;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1434370213
   )
   int field646;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -596027585
   )
   int field647;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 99339719
   )
   int field648 = 0;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -2049877065
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 822935479
   )
   int field650;
   @ObfuscatedName("aj")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -923390979
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1137880121
   )
   int field653 = 200;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 2026939461
   )
   int field654;
   @ObfuscatedName("ae")
   boolean field655 = false;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -1978842257
   )
   int field656 = 32;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = -1736846353
   )
   int field657 = 0;
   @ObfuscatedName("co")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("cm")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -418932425
   )
   int field660 = 0;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1693066375
   )
   int field661 = 0;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1429069799
   )
   int field662 = 0;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-144706417"
   )
   final void method622(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field2836.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field2846.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.method3588(new Buffer(var9));
         }

         CombatInfo2.field2836.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var7.field2841;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.method2453(); null != var13; var13 = (CombatInfoListHolder)this.combatInfoList.method2468()) {
         ++var12;
         if(var13.combatInfo2.field2838 == var8.field2838) {
            var13.method788(var4 + var2, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field2840 <= var8.field2840) {
            var14 = var13;
         }

         if(var13.combatInfo2.field2841 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field2841;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var8);
         if(null == var14) {
            this.combatInfoList.method2455(var13);
         } else {
            CombatInfoList.method2456(var13, var14);
         }

         var13.method788(var4 + var2, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "2017598803"
   )
   final void method624(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field625[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class196 var12 = Script.method971(var1);
         var10 = var12.field2891;
         var11 = var12.field2882;
      }

      int var14;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var14 = 0;
         if(var10 == 0) {
            var14 = this.field625[0];
         } else if(var10 == 1) {
            var14 = this.field624[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field625[var13] < var14) {
                  var9 = var13;
                  var14 = this.field625[var13];
               }
            } else if(var10 == 1 && this.field624[var13] < var14) {
               var9 = var13;
               var14 = this.field624[var13];
            }
         }

         if(var10 == 1 && var14 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field617 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field617;
            this.field617 = (byte)((this.field617 + 1) % 4);
            if(this.field625[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field623[var9] = var1;
         this.field624[var9] = var2;
         this.field611[var9] = var3;
         this.field627[var9] = var4;
         this.field625[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-59"
   )
   final void method626(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field2836.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field2846.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.method3588(new Buffer(var4));
         }

         CombatInfo2.field2836.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.method2453(); null != var5; var5 = (CombatInfoListHolder)this.combatInfoList.method2468()) {
         if(var3 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1216027220"
   )
   static int method627(int var0, Script var1, boolean var2) {
      Widget var3 = ChatLineBuffer.method993(class32.field726[--class32.field735]);
      if(var0 == 2500) {
         class32.field726[++class32.field735 - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class32.field726[++class32.field735 - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class32.field726[++class32.field735 - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class32.field726[++class32.field735 - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class32.field726[++class32.field735 - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class32.field726[++class32.field735 - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "466855216"
   )
   boolean vmethod794() {
      return false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "768"
   )
   public static void method638() {
      try {
         class104.field1699.method1463();

         for(int var0 = 0; var0 < class88.field1547; ++var0) {
            WidgetNode.field182[var0].method1463();
         }

         class104.field1695.method1463();
         class104.field1689.method1463();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-11561"
   )
   final void method639() {
      this.field657 = 0;
      this.field662 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)V",
      garbageValue = "-1041509215"
   )
   public static void method640(class182 var0, class182 var1) {
      CombatInfo2.field2846 = var0;
      CombatInfo2.field2850 = var1;
   }
}
