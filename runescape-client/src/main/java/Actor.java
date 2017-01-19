import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -80730017
   )
   int field604;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -49214681
   )
   @Export("y")
   int y;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -129322873
   )
   int field606;
   @ObfuscatedName("ao")
   boolean field607 = false;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -662079305
   )
   @Export("x")
   int x;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 177033487
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1821954201
   )
   int field610 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1406775261
   )
   int field611 = -1;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 364995881
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -179847847
   )
   int field613 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -118500105
   )
   int field614 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1535340987
   )
   int field615 = -1;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 2147431701
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("aq")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("au")
   int[] field618 = new int[4];
   @ObfuscatedName("aj")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 442849611
   )
   int field620;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 872315091
   )
   int field621 = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -145593377
   )
   int field622 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 708214139
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("ct")
   byte[] field624 = new byte[10];
   @ObfuscatedName("af")
   boolean field625;
   @ObfuscatedName("ag")
   int[] field626 = new int[4];
   @ObfuscatedName("ab")
   int[] field627 = new int[4];
   @ObfuscatedName("bt")
   int[] field628 = new int[4];
   @ObfuscatedName("bw")
   @Export("combatInfoList")
   CombatInfoList combatInfoList = new CombatInfoList();
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1389342441
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1214243675
   )
   int field631;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1759790215
   )
   int field632 = -1;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -740543801
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 397572991
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -955068291
   )
   int field635 = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 308700503
   )
   int field636 = -1;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 139841169
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -848071421
   )
   int field638 = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1790377189
   )
   int field639 = -1;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -842258469
   )
   int field640 = 0;
   @ObfuscatedName("ak")
   int[] field641 = new int[4];
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1439552987
   )
   int field642 = 0;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -873253981
   )
   int field643 = 0;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -208614923
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -972260481
   )
   int field645 = 1;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 1234199651
   )
   int field646 = 32;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 113746911
   )
   int field647 = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -590427281
   )
   int field649 = 100;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1395436217
   )
   int field650;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 588339079
   )
   int field651;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -747701053
   )
   int field652;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 604758859
   )
   int field653 = 0;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -2035163595
   )
   int field654 = 200;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = 2099887415
   )
   int field655;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = 1639128735
   )
   int field656 = 0;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1757859929
   )
   int field657;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -2042499655
   )
   int field658 = 0;
   @ObfuscatedName("am")
   byte field659 = 0;
   @ObfuscatedName("ch")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -420179931
   )
   int field661;
   @ObfuscatedName("ca")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -2026259805
   )
   int field663 = 0;
   @ObfuscatedName("bs")
   boolean field664 = false;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "102"
   )
   static String method574(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-390429301"
   )
   final void method575() {
      this.field658 = 0;
      this.field663 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1377545017"
   )
   boolean vmethod699() {
      return false;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-1975016088"
   )
   final void method577(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field626[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class196 var14 = class97.method1871(var1);
         var10 = var14.field2891;
         var11 = var14.field2882;
      }

      int var12;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var12 = 0;
         if(var10 == 0) {
            var12 = this.field626[0];
         } else if(var10 == 1) {
            var12 = this.field618[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field626[var13] < var12) {
                  var9 = var13;
                  var12 = this.field626[var13];
               }
            } else if(var10 == 1 && this.field618[var13] < var12) {
               var9 = var13;
               var12 = this.field618[var13];
            }
         }

         if(var10 == 1 && var12 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field659 = 0;
         }

         for(var12 = 0; var12 < 4; ++var12) {
            byte var15 = this.field659;
            this.field659 = (byte)((this.field659 + 1) % 4);
            if(this.field626[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field641[var9] = var1;
         this.field618[var9] = var2;
         this.field627[var9] = var3;
         this.field628[var9] = var4;
         this.field626[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-77"
   )
   final void method578(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = class157.method2951(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field2836;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method2295(); null != var12; var12 = (CombatInfoListHolder)this.combatInfoList.method2291()) {
         ++var11;
         if(var7.field2838 == var12.combatInfo2.field2838) {
            var12.method679(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field2840 <= var7.field2840) {
            var8 = var12;
         }

         if(var12.combatInfo2.field2836 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field2836;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.method2304(var12);
         } else {
            CombatInfoList.method2294(var12, var8);
         }

         var12.method679(var2 + var4, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2115250218"
   )
   static final int method579(int var0, int var1) {
      int var2 = 57 * var1 + var0;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   final void method580(int var1) {
      CombatInfo2 var2 = class157.method2951(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method2295(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.method2291()) {
         if(var2 == var3.combatInfo2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BB)LFont;",
      garbageValue = "-25"
   )
   static Font method591(byte[] var0) {
      if(var0 == null) {
         return null;
      } else {
         Font var1 = new Font(var0, class181.field2710, class225.field3220, class119.field1865, class109.field1742, class225.field3217, class44.field888);
         class30.method648();
         return var1;
      }
   }
}
