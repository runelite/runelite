import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1698378283
   )
   int field599 = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1645395183
   )
   @Export("y")
   int y;
   @ObfuscatedName("ao")
   int[] field601 = new int[4];
   @ObfuscatedName("an")
   boolean field602 = false;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1986444703
   )
   int field603 = 1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 265342669
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 278097001
   )
   int field605 = -1;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -846879725
   )
   int field606 = 0;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1153715705
   )
   int field607 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -478559701
   )
   int field608 = -1;
   @ObfuscatedName("cy")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1979147433
   )
   int field610;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -2042771907
   )
   @Export("x")
   int x;
   @ObfuscatedName("ak")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("be")
   boolean field613 = false;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 872650267
   )
   int field614 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -168080989
   )
   int field615 = 100;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -128412133
   )
   int field616 = 32;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1751798315
   )
   int field617 = 0;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1372707817
   )
   int field618;
   @ObfuscatedName("ap")
   int[] field619 = new int[4];
   @ObfuscatedName("as")
   byte field620 = 0;
   @ObfuscatedName("ac")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -641585429
   )
   int field622 = -1;
   @ObfuscatedName("bw")
   int[] field623 = new int[4];
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -960366987
   )
   int field624 = 0;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1582062313
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -2065775401
   )
   int field626 = -1;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1026402753
   )
   int field627 = -1;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 1742602129
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -911051421
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1755256247
   )
   int field630 = 0;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -760185129
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 30192317
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -771085619
   )
   int field633 = 0;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1615962791
   )
   int field634 = 0;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -223029659
   )
   int field635 = 0;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 157505999
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("bv")
   @Export("combatInfoList")
   CombatInfoList combatInfoList = new CombatInfoList();
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1697794305
   )
   int field638 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1511738013
   )
   int field639 = -1;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1052260253
   )
   int field640;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -2044068431
   )
   int field641;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 49898631
   )
   int field642;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1562316355
   )
   int field643;
   @ObfuscatedName("au")
   int[] field644 = new int[4];
   @ObfuscatedName("aq")
   boolean field645;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -780883613
   )
   int field646;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1733858971
   )
   int field647;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1580156917
   )
   int field648;
   @ObfuscatedName("cd")
   @ObfuscatedGetter(
      intValue = 1114983057
   )
   int field649 = 200;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -1836441293
   )
   int field650;
   @ObfuscatedName("ae")
   int[] field651 = new int[4];
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -230708257
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 845495875
   )
   int field653 = 0;
   @ObfuscatedName("cl")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1112863629
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("cp")
   byte[] field656 = new byte[10];
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 1221836093
   )
   int field657 = 0;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = 300613735
   )
   int field658 = 0;
   @ObfuscatedName("dp")
   static int[] field659;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-44356836"
   )
   final void method602() {
      this.field653 = 0;
      this.field658 = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1734693659"
   )
   boolean vmethod718() {
      return false;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "2030213140"
   )
   final void method605(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = class97.method1874(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field2819;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method2358(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.method2360()) {
         ++var11;
         if(var7.field2817 == var12.combatInfo2.field2817) {
            var12.method702(var2 + var4, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field2813 <= var7.field2813) {
            var8 = var12;
         }

         if(var12.combatInfo2.field2819 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field2819;
         }
      }

      if(null != var9 || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(null == var8) {
            this.combatInfoList.method2356(var12);
         } else {
            CombatInfoList.method2357(var12, var8);
         }

         var12.method702(var2 + var4, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "16711680"
   )
   final void method606(int var1) {
      CombatInfo2 var2 = class97.method1874(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method2358(); var3 != null; var3 = (CombatInfoListHolder)this.combatInfoList.method2360()) {
         if(var2 == var3.combatInfo2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIIIIIS)V",
      garbageValue = "228"
   )
   final void method614(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field601[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class196 var12 = class65.method1118(var1);
         var10 = var12.field2867;
         var11 = var12.field2873;
      }

      int var14;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var14 = 0;
         if(var10 == 0) {
            var14 = this.field601[0];
         } else if(var10 == 1) {
            var14 = this.field651[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field601[var13] < var14) {
                  var9 = var13;
                  var14 = this.field601[var13];
               }
            } else if(var10 == 1 && this.field651[var13] < var14) {
               var9 = var13;
               var14 = this.field651[var13];
            }
         }

         if(var10 == 1 && var14 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field620 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field620;
            this.field620 = (byte)((1 + this.field620) % 4);
            if(this.field601[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field619[var9] = var1;
         this.field651[var9] = var2;
         this.field644[var9] = var3;
         this.field623[var9] = var4;
         this.field601[var9] = var11 + var5 + var6;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)LNPCComposition;",
      garbageValue = "-59"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field2988.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3002.method3272(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method3710(new Buffer(var2));
         }

         var1.method3715();
         NPCComposition.field2988.put(var1, (long)var0);
         return var1;
      }
   }
}
