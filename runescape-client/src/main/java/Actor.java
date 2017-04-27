import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("br")
   @Export("combatInfoList")
   CombatInfoList combatInfoList = new CombatInfoList();
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -632795927
   )
   @Export("y")
   int y;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1489747195
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("ao")
   boolean field602 = false;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -355597227
   )
   int field603 = 1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1628907207
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1604310759
   )
   int field605 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1330572147
   )
   int field606 = -1;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = -1976737573
   )
   int field607 = 200;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1017483217
   )
   int field608 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1797003589
   )
   int field609 = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -738983125
   )
   int field610 = -1;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -2075891583
   )
   int field611 = 0;
   @ObfuscatedName("af")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("ar")
   boolean field613;
   @ObfuscatedName("bo")
   boolean field614 = false;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1958157383
   )
   int field615 = 100;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1456845945
   )
   int field616 = 0;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1175048581
   )
   int field617 = 0;
   @ObfuscatedName("cz")
   byte[] field618 = new byte[10];
   @ObfuscatedName("do")
   @ObfuscatedGetter(
      intValue = 1718199385
   )
   static int field619;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -842546905
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("ap")
   int[] field621 = new int[4];
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 972843559
   )
   int field622;
   @ObfuscatedName("bu")
   int[] field623 = new int[4];
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1124737597
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 281152715
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -348776435
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation = -1;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 773678597
   )
   int field627 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1122551925
   )
   @Export("x")
   int x;
   @ObfuscatedName("ah")
   int[] field629 = new int[4];
   @ObfuscatedName("at")
   int[] field630 = new int[4];
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -1394395393
   )
   int field631 = 0;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1547841037
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 394699855
   )
   int field633 = 0;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 938964803
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -749589597
   )
   int field635 = 0;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 490100521
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1641983223
   )
   int field637 = 0;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -202657155
   )
   int field638;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 2132796277
   )
   int field639;
   @ObfuscatedName("al")
   byte field640 = 0;
   @ObfuscatedName("dj")
   static int[] field641;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1271066811
   )
   int field642;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1438819805
   )
   int field643;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1716571955
   )
   int field644;
   @ObfuscatedName("au")
   int[] field645 = new int[4];
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1594072169
   )
   int field646;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -444920235
   )
   int field647;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1634923397
   )
   int field648 = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -714122217
   )
   int field649 = -1;
   @ObfuscatedName("cb")
   @ObfuscatedGetter(
      intValue = -229937773
   )
   int field650;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -1078967527
   )
   int field651 = 0;
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -1288950623
   )
   int field652 = 32;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1828014039
   )
   int field653 = 0;
   @ObfuscatedName("ab")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("cu")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("pq")
   static Preferences field656;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -39531263
   )
   int field657 = 0;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = 1480656479
   )
   int field658 = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -745378733
   )
   int field659 = -1;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 786667301
   )
   int field660;
   @ObfuscatedName("cj")
   @Export("pathX")
   int[] pathX = new int[10];

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1961877372"
   )
   final void method580(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field2848.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field2852.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.method3551(new Buffer(var9));
         }

         CombatInfo2.field2848.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var7.field2853;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.method2790(); var13 != null; var13 = (CombatInfoListHolder)this.combatInfoList.method2791()) {
         ++var12;
         if(var8.field2856 == var13.combatInfo2.field2856) {
            var13.method722(var4 + var2, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field2851 <= var8.field2851) {
            var14 = var13;
         }

         if(var13.combatInfo2.field2853 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field2853;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var8);
         if(var14 == null) {
            this.combatInfoList.method2788(var13);
         } else {
            CombatInfoList.method2789(var13, var14);
         }

         var13.method722(var4 + var2, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "225621132"
   )
   boolean vmethod737() {
      return false;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-111"
   )
   final void method583(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field621[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class201 var14 = IndexData.method3381(var1);
         var10 = var14.field2915;
         var11 = var14.field2906;
      }

      int var12;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var12 = 0;
         if(var10 == 0) {
            var12 = this.field621[0];
         } else if(var10 == 1) {
            var12 = this.field629[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field621[var13] < var12) {
                  var9 = var13;
                  var12 = this.field621[var13];
               }
            } else if(var10 == 1 && this.field629[var13] < var12) {
               var9 = var13;
               var12 = this.field629[var13];
            }
         }

         if(var10 == 1 && var12 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field640 = 0;
         }

         for(var12 = 0; var12 < 4; ++var12) {
            byte var15 = this.field640;
            this.field640 = (byte)((this.field640 + 1) % 4);
            if(this.field621[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field630[var9] = var1;
         this.field629[var9] = var2;
         this.field645[var9] = var3;
         this.field623[var9] = var4;
         this.field621[var9] = var11 + var5 + var6;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-802495890"
   )
   final void method584() {
      this.field653 = 0;
      this.field658 = 0;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1568869684"
   )
   final void method587(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field2848.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field2852.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.method3551(new Buffer(var4));
         }

         CombatInfo2.field2848.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.method2790(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.method2791()) {
         if(var5.combatInfo2 == var3) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-55889495"
   )
   static int method592(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2773((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-605471780"
   )
   static void method593() {
      Client.secretCipherBuffer1.putOpcode(111);
      CipherBuffer var0 = Client.secretCipherBuffer1;
      int var1 = Client.isResized?2:1;
      var0.putByte(var1);
      Client.secretCipherBuffer1.putShort(class187.field2760);
      Client.secretCipherBuffer1.putShort(IndexDataBase.field2726);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-151492828"
   )
   public static void method594(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            Widget.field2197.method3320(var0);
            if(class133.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < class133.widgets[var0].length; ++var2) {
                  if(class133.widgets[var0][var2] != null) {
                     if(class133.widgets[var0][var2].type != 2) {
                        class133.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  class133.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "1311903767"
   )
   public static int method595(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var5 != var9 / var1) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
