import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1927117373
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1112423957
   )
   @Export("y")
   int y;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1311199177
   )
   int field600 = -1;
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = -39586339
   )
   int field601 = 200;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 919486261
   )
   int field602;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -1999116499
   )
   int field603 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1056857821
   )
   int field604 = -1;
   @ObfuscatedName("an")
   boolean field605 = false;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 638136657
   )
   int field606;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = -1292690321
   )
   int field607 = 0;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -2088597215
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 737701277
   )
   int field609 = -1;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1967734433
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("bh")
   @Export("combatInfoList")
   CombatInfoList combatInfoList = new CombatInfoList();
   @ObfuscatedName("al")
   boolean field612;
   @ObfuscatedName("as")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 540465913
   )
   int field614 = 100;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1570163457
   )
   int field615 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1114310467
   )
   int field616 = 0;
   @ObfuscatedName("ah")
   byte field617 = 0;
   @ObfuscatedName("ac")
   int[] field618 = new int[4];
   @ObfuscatedName("ae")
   int[] field619 = new int[4];
   @ObfuscatedName("au")
   int[] field620 = new int[4];
   @ObfuscatedName("ag")
   int[] field621 = new int[4];
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1374485313
   )
   int field622 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1073870575
   )
   int field623 = -1;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1021538271
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("ba")
   boolean field625 = false;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1178772567
   )
   int field626 = -1;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -983634081
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 426356463
   )
   @Export("x")
   int x;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1561458409
   )
   int field629 = 0;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1538979747
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("cd")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1874419173
   )
   int field632 = 0;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1798238149
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -1545116625
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 1340797579
   )
   int field635 = 0;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1867209183
   )
   int field636 = 0;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 1300972331
   )
   int field637 = 0;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -824197217
   )
   int field638;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 2077424055
   )
   int field639;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 667715451
   )
   int field640 = 1;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1475270417
   )
   int field641;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -173333729
   )
   int field642;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1600894707
   )
   int field643;
   @ObfuscatedName("bq")
   int[] field644 = new int[4];
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 997166753
   )
   int field645;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1617725647
   )
   int field646 = -1;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -319264303
   )
   int field647 = 0;
   @ObfuscatedName("ab")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = 212188103
   )
   int field649;
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = 440768395
   )
   int field650 = 0;
   @ObfuscatedName("co")
   @ObfuscatedGetter(
      intValue = -1481163711
   )
   int field651 = 32;
   @ObfuscatedName("ch")
   @ObfuscatedGetter(
      intValue = 1356330761
   )
   int field652 = 0;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -674491199
   )
   int field653;
   @ObfuscatedName("ci")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("ck")
   byte[] field655 = new byte[10];
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1956365735
   )
   int field656 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -749854733
   )
   @Export("angle")
   int angle;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "337300030"
   )
   static void method562(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class104.field1669, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.method2932(3);
         var3.method2932(null != var1?1:0);
         var3.method2752(var0.getPath());
         if(var1 != null) {
            var3.method2752("");
         }

         var2.method1388(var3.payload, 0, var3.offset);
         var2.method1389();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1060306260"
   )
   boolean vmethod679() {
      return false;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-84"
   )
   final void method565(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field620[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class196 var14 = class119.method2256(var1);
         var10 = var14.field2889;
         var11 = var14.field2875;
      }

      int var12;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var12 = 0;
         if(var10 == 0) {
            var12 = this.field620[0];
         } else if(var10 == 1) {
            var12 = this.field619[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field620[var13] < var12) {
                  var9 = var13;
                  var12 = this.field620[var13];
               }
            } else if(var10 == 1 && this.field619[var13] < var12) {
               var9 = var13;
               var12 = this.field619[var13];
            }
         }

         if(var10 == 1 && var12 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field617 = 0;
         }

         for(var12 = 0; var12 < 4; ++var12) {
            byte var15 = this.field617;
            this.field617 = (byte)((this.field617 + 1) % 4);
            if(this.field620[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field618[var9] = var1;
         this.field619[var9] = var2;
         this.field621[var9] = var3;
         this.field644[var9] = var4;
         this.field620[var9] = var6 + var11 + var5;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-92"
   )
   final void method566(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = Friend.method168(var1);
      CombatInfoListHolder var8 = null;
      CombatInfoListHolder var9 = null;
      int var10 = var7.field2839;
      int var11 = 0;

      CombatInfoListHolder var12;
      for(var12 = (CombatInfoListHolder)this.combatInfoList.method2326(); var12 != null; var12 = (CombatInfoListHolder)this.combatInfoList.method2327()) {
         ++var11;
         if(var7.field2834 == var12.combatInfo2.field2834) {
            var12.method666(var4 + var2, var5, var6, var3);
            return;
         }

         if(var12.combatInfo2.field2844 <= var7.field2844) {
            var8 = var12;
         }

         if(var12.combatInfo2.field2839 > var10) {
            var9 = var12;
            var10 = var12.combatInfo2.field2839;
         }
      }

      if(null != var9 || var11 < 4) {
         var12 = new CombatInfoListHolder(var7);
         if(null == var8) {
            this.combatInfoList.method2329(var12);
         } else {
            CombatInfoList.method2332(var12, var8);
         }

         var12.method666(var2 + var4, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1629961829"
   )
   final void method567(int var1) {
      CombatInfo2 var2 = Friend.method168(var1);

      for(CombatInfoListHolder var3 = (CombatInfoListHolder)this.combatInfoList.method2326(); null != var3; var3 = (CombatInfoListHolder)this.combatInfoList.method2327()) {
         if(var3.combatInfo2 == var2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "-62"
   )
   static final void method573(Actor var0) {
      if(Client.gameCycle == var0.field645 || var0.animation == -1 || var0.actionAnimationDisable != 0 || var0.field632 + 1 > GameEngine.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field645 - var0.field602;
         int var2 = Client.gameCycle - var0.field602;
         int var3 = var0.field606 * 128 + var0.field640 * 64;
         int var4 = var0.field640 * 64 + var0.field642 * 128;
         int var5 = var0.field640 * 64 + var0.field641 * 128;
         int var6 = var0.field643 * 128 + var0.field640 * 64;
         var0.x = ((var1 - var2) * var3 + var2 * var5) / var1;
         var0.y = ((var1 - var2) * var4 + var6 * var2) / var1;
      }

      var0.field603 = 0;
      var0.field649 = var0.field653;
      var0.angle = var0.field649;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2121874665"
   )
   final void method580() {
      this.field652 = 0;
      this.field607 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass228;B)I",
      garbageValue = "-67"
   )
   static final int method585(class228 var0) {
      if(null == var0) {
         return 12;
      } else {
         switch(var0.field3229) {
         case 7:
            return 20;
         default:
            return 12;
         }
      }
   }
}
