import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 707779323
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -163555927
   )
   @Export("y")
   int y;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1338142859
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("an")
   boolean field628 = false;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1855088477
   )
   int field629 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1189849857
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("cv")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -238844457
   )
   int field632 = -1;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 825703099
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1684788347
   )
   int field634 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1784743253
   )
   int field635 = -1;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -996741195
   )
   int field636 = 0;
   @ObfuscatedName("bd")
   @Export("combatInfoList")
   CombatInfoList combatInfoList = new CombatInfoList();
   @ObfuscatedName("aq")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("aj")
   boolean field639;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -591400881
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -371354329
   )
   int field641 = 100;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 506234759
   )
   int field642 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1765669773
   )
   int field643 = 0;
   @ObfuscatedName("al")
   byte field644 = 0;
   @ObfuscatedName("ag")
   int[] field645 = new int[4];
   @ObfuscatedName("aw")
   int[] field646 = new int[4];
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -950886699
   )
   int field647;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 924343423
   )
   int field648 = 0;
   @ObfuscatedName("bj")
   int[] field649 = new int[4];
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -2070833447
   )
   int field650;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -8174851
   )
   int field651 = -1;
   @ObfuscatedName("bt")
   boolean field652 = false;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -293807913
   )
   int field653 = -1;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = 1111185965
   )
   int field654 = 200;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 2126607241
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1545619827
   )
   int field656 = 0;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 989094723
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1625734795
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 368807559
   )
   int field659 = 0;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -304758915
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("ap")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1462087111
   )
   int field662 = 0;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 387677123
   )
   int field663;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -457826465
   )
   int field664 = 0;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 794874069
   )
   int field665;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1096019097
   )
   int field666;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -528967979
   )
   int field667 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1901657681
   )
   int field668 = -1;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 744645267
   )
   int field669;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 594353015
   )
   int field670;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -1097299269
   )
   int field671;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -150436771
   )
   int field672 = 1;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1807651899
   )
   int field673;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1109152631
   )
   @Export("x")
   int x;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -1133931385
   )
   int field675 = 0;
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -1511981417
   )
   int field676;
   @ObfuscatedName("ad")
   int[] field677 = new int[4];
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 494637525
   )
   int field678 = 32;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 226845805
   )
   int field679 = 0;
   @ObfuscatedName("cf")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("au")
   int[] field681 = new int[4];
   @ObfuscatedName("ce")
   byte[] field682 = new byte[10];
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1079511175
   )
   int field683 = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 446577359
   )
   int field684 = -1;
   @ObfuscatedName("ml")
   static SpritePixels field685;

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-24"
   )
   final void method606(int var1) {
      CombatInfo2 var2 = KitDefinition.method3529(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method2411(); null != var3; var3 = (CombatInfoListHolder)this.combatInfoList.method2423()) {
         if(var3.combatInfo2 == var2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1654647855"
   )
   final void method607(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = KitDefinition.method3529(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field2834;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method2411(); null != var12; var12 = (CombatInfoListHolder)this.combatInfoList.method2423()) {
         ++var11;
         if(var7.field2837 == var12.combatInfo2.field2837) {
            var12.method766(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field2833 <= var7.field2833) {
            var8 = var12;
         }

         if(var12.combatInfo2.field2834 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field2834;
         }
      }

      if(var9 != null || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(var8 == null) {
            this.combatInfoList.method2415(var12);
         } else {
            CombatInfoList.method2409(var12, var8);
         }

         var12.method766(var4 + var2, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-107"
   )
   boolean vmethod782() {
      return false;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1857792161"
   )
   final void method609(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field677[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class196 var14 = class171.method3266(var1);
         var10 = var14.field2885;
         var11 = var14.field2876;
      }

      int var12;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var12 = 0;
         if(var10 == 0) {
            var12 = this.field677[0];
         } else if(var10 == 1) {
            var12 = this.field646[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field677[var13] < var12) {
                  var9 = var13;
                  var12 = this.field677[var13];
               }
            } else if(var10 == 1 && this.field646[var13] < var12) {
               var9 = var13;
               var12 = this.field646[var13];
            }
         }

         if(var10 == 1 && var12 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field644 = 0;
         }

         for(var12 = 0; var12 < 4; ++var12) {
            byte var15 = this.field644;
            this.field644 = (byte)((this.field644 + 1) % 4);
            if(this.field677[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field645[var9] = var1;
         this.field646[var9] = var2;
         this.field681[var9] = var3;
         this.field649[var9] = var4;
         this.field677[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-456597016"
   )
   static SpritePixels method611() {
      SpritePixels var0 = new SpritePixels();
      var0.maxWidth = class203.field3083;
      var0.maxHeight = class225.field3232;
      var0.offsetX = XItemContainer.field147[0];
      var0.offsetY = class203.field3085[0];
      var0.width = class225.field3233[0];
      var0.height = class225.field3231[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = RSCanvas.field1766[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class225.field3237[var2[var3] & 255];
      }

      XItemContainer.field147 = null;
      class203.field3085 = null;
      class225.field3233 = null;
      class225.field3231 = null;
      class225.field3237 = null;
      RSCanvas.field1766 = null;
      return var0;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "113"
   )
   final void method616() {
      this.field679 = 0;
      this.field636 = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1123552301"
   )
   static final int method622(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1 + (var0 & 'ﾀ');
      }
   }
}
