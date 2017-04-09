import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1874108355
   )
   int field618 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 768382907
   )
   @Export("y")
   int y;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -404712741
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("an")
   boolean field621 = false;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -667835561
   )
   int field622 = 1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 2044933193
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 783134109
   )
   @Export("x")
   int x;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 6123337
   )
   int field625 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 629041725
   )
   int field626 = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1625211019
   )
   int field627 = -1;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 2123306939
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 667900503
   )
   int field629 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1983283825
   )
   int field630 = -1;
   @ObfuscatedName("at")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("ad")
   boolean field632;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -37082651
   )
   int field633 = -1;
   @ObfuscatedName("al")
   byte field634 = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -72994409
   )
   int field635 = 0;
   @ObfuscatedName("bh")
   @Export("combatInfoList")
   CombatInfoList combatInfoList = new CombatInfoList();
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -694981331
   )
   int field637 = 0;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1738887645
   )
   int field638 = 0;
   @ObfuscatedName("ay")
   int[] field639 = new int[4];
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -662115085
   )
   int field640;
   @ObfuscatedName("af")
   int[] field641 = new int[4];
   @ObfuscatedName("bc")
   int[] field642 = new int[4];
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -146764055
   )
   int field643;
   @ObfuscatedName("ac")
   int[] field644 = new int[4];
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1991271291
   )
   int field645 = -1;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -349608319
   )
   int field646 = -1;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 537126733
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("av")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -773282821
   )
   int field649 = 0;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1829271211
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("cr")
   @ObfuscatedGetter(
      intValue = 805903739
   )
   int field651 = 0;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 318968849
   )
   int field652 = 0;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 868728317
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 286000423
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = 1736176485
   )
   int field655 = 0;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -326724549
   )
   int field656 = 100;
   @ObfuscatedName("az")
   int[] field657 = new int[4];
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 631164421
   )
   int field658;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -235410463
   )
   int field659;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 635759957
   )
   int field660;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -274501467
   )
   int field661;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -510926479
   )
   int field662;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 584993237
   )
   int field664;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -632347097
   )
   int field665;
   @ObfuscatedName("cx")
   @ObfuscatedGetter(
      intValue = 476058489
   )
   int field666 = 0;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1347240905
   )
   int field667 = 0;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -1523335481
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = 1173051713
   )
   int field669;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -768538291
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = 704925691
   )
   int field671 = 32;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 806891155
   )
   int field672 = 0;
   @ObfuscatedName("cg")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("ck")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("cn")
   byte[] field675 = new byte[10];
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = 555841677
   )
   int field676 = 200;
   @ObfuscatedName("br")
   boolean field677 = false;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1686070117
   )
   int field678 = 0;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "606159212"
   )
   final void method566() {
      this.field672 = 0;
      this.field655 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1006538820"
   )
   boolean vmethod738() {
      return false;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1412061942"
   )
   final void method569(int var1) {
      CombatInfo2 var2 = (CombatInfo2)CombatInfo2.field2841.get((long)var1);
      CombatInfo2 var3;
      if(var2 != null) {
         var3 = var2;
      } else {
         byte[] var4 = CombatInfo2.field2852.getConfigData(33, var1);
         var2 = new CombatInfo2();
         if(var4 != null) {
            var2.method3572(new Buffer(var4));
         }

         CombatInfo2.field2841.put(var2, (long)var1);
         var3 = var2;
      }

      var2 = var3;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.method2442(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.method2433()) {
         if(var2 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "17"
   )
   final void method570(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var7 = (CombatInfo2)CombatInfo2.field2841.get((long)var1);
      CombatInfo2 var8;
      if(var7 != null) {
         var8 = var7;
      } else {
         byte[] var9 = CombatInfo2.field2852.getConfigData(33, var1);
         var7 = new CombatInfo2();
         if(var9 != null) {
            var7.method3572(new Buffer(var9));
         }

         CombatInfo2.field2841.put(var7, (long)var1);
         var8 = var7;
      }

      var7 = var8;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var8.field2849;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.method2442(); var13 != null; var13 = (CombatInfoListHolder)this.combatInfoList.method2433()) {
         ++var12;
         if(var7.field2845 == var13.combatInfo2.field2845) {
            var13.method720(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field2839 <= var7.field2839) {
            var14 = var13;
         }

         if(var13.combatInfo2.field2849 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field2849;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var7);
         if(var14 == null) {
            this.combatInfoList.method2443(var13);
         } else {
            CombatInfoList.method2432(var13, var14);
         }

         var13.method720(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }
      }

   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-20"
   )
   static void method571(Buffer var0) {
      if(Client.field529 != null) {
         var0.putBytes(Client.field529, 0, Client.field529.length);
      } else {
         byte[] var1 = new byte[24];

         try {
            class104.field1712.method1437(0L);
            class104.field1712.method1415(var1);

            int var2;
            for(var2 = 0; var2 < 24 && var1[var2] == 0; ++var2) {
               ;
            }

            if(var2 >= 24) {
               throw new IOException();
            }
         } catch (Exception var4) {
            for(int var3 = 0; var3 < 24; ++var3) {
               var1[var3] = -1;
            }
         }

         var0.putBytes(var1, 0, var1.length);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LCipherBuffer;IB)V",
      garbageValue = "0"
   )
   static final void method572(CipherBuffer var0, int var1) {
      int var2 = var0.offset;
      class45.field930 = 0;
      class3.method22(var0);
      class31.method662(var0);
      if(var0.offset - var2 != var1) {
         throw new RuntimeException(var0.offset - var2 + " " + var1);
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "623170996"
   )
   static int method573(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class32.field743[--class30.field713];
         var4 = FaceNormal.method1932(var3);
      } else {
         var4 = var2?class154.field2123:class32.field746;
      }

      if(var0 == 1100) {
         class30.field713 -= 2;
         var4.scrollX = class32.field743[class30.field713];
         if(var4.scrollX > var4.scrollWidth - var4.width) {
            var4.scrollX = var4.scrollWidth - var4.width;
         }

         if(var4.scrollX < 0) {
            var4.scrollX = 0;
         }

         var4.scrollY = class32.field743[class30.field713 + 1];
         if(var4.scrollY > var4.scrollHeight - var4.height) {
            var4.scrollY = var4.scrollHeight - var4.height;
         }

         if(var4.scrollY < 0) {
            var4.scrollY = 0;
         }

         class22.method197(var4);
         return 1;
      } else if(var0 == 1101) {
         var4.textColor = class32.field743[--class30.field713];
         class22.method197(var4);
         return 1;
      } else if(var0 == 1102) {
         var4.field2267 = class32.field743[--class30.field713] == 1;
         class22.method197(var4);
         return 1;
      } else if(var0 == 1103) {
         var4.opacity = class32.field743[--class30.field713];
         class22.method197(var4);
         return 1;
      } else if(var0 == 1104) {
         var4.field2218 = class32.field743[--class30.field713];
         class22.method197(var4);
         return 1;
      } else if(var0 == 1105) {
         var4.textureId = class32.field743[--class30.field713];
         class22.method197(var4);
         return 1;
      } else if(var0 == 1106) {
         var4.field2294 = class32.field743[--class30.field713];
         class22.method197(var4);
         return 1;
      } else if(var0 == 1107) {
         var4.field2257 = class32.field743[--class30.field713] == 1;
         class22.method197(var4);
         return 1;
      } else if(var0 == 1108) {
         var4.modelType = 1;
         var4.modelId = class32.field743[--class30.field713];
         class22.method197(var4);
         return 1;
      } else if(var0 == 1109) {
         class30.field713 -= 6;
         var4.field2268 = class32.field743[class30.field713];
         var4.field2269 = class32.field743[class30.field713 + 1];
         var4.rotationX = class32.field743[class30.field713 + 2];
         var4.rotationZ = class32.field743[class30.field713 + 3];
         var4.rotationY = class32.field743[class30.field713 + 4];
         var4.field2320 = class32.field743[class30.field713 + 5];
         class22.method197(var4);
         return 1;
      } else {
         int var5;
         if(var0 == 1110) {
            var5 = class32.field743[--class30.field713];
            if(var5 != var4.field2266) {
               var4.field2266 = var5;
               var4.field2344 = 0;
               var4.field2342 = 0;
               class22.method197(var4);
            }

            return 1;
         } else if(var0 == 1111) {
            var4.field2296 = class32.field743[--class30.field713] == 1;
            class22.method197(var4);
            return 1;
         } else if(var0 == 1112) {
            String var9 = class32.scriptStringStack[--class32.scriptStringStackSize];
            if(!var9.equals(var4.text)) {
               var4.text = var9;
               class22.method197(var4);
            }

            return 1;
         } else if(var0 == 1113) {
            var4.fontId = class32.field743[--class30.field713];
            class22.method197(var4);
            return 1;
         } else if(var0 == 1114) {
            class30.field713 -= 3;
            var4.field2219 = class32.field743[class30.field713];
            var4.field2283 = class32.field743[class30.field713 + 1];
            var4.field2212 = class32.field743[class30.field713 + 2];
            class22.method197(var4);
            return 1;
         } else if(var0 == 1115) {
            var4.field2298 = class32.field743[--class30.field713] == 1;
            class22.method197(var4);
            return 1;
         } else if(var0 == 1116) {
            var4.borderThickness = class32.field743[--class30.field713];
            class22.method197(var4);
            return 1;
         } else if(var0 == 1117) {
            var4.sprite2 = class32.field743[--class30.field713];
            class22.method197(var4);
            return 1;
         } else if(var0 == 1118) {
            var4.flippedVertically = class32.field743[--class30.field713] == 1;
            class22.method197(var4);
            return 1;
         } else if(var0 == 1119) {
            var4.flippedHorizontally = class32.field743[--class30.field713] == 1;
            class22.method197(var4);
            return 1;
         } else if(var0 == 1120) {
            class30.field713 -= 2;
            var4.scrollWidth = class32.field743[class30.field713];
            var4.scrollHeight = class32.field743[class30.field713 + 1];
            class22.method197(var4);
            if(var3 != -1 && var4.type == 0) {
               class2.method16(Widget.widgets[var3 >> 16], var4, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var5 = var4.id;
            int var8 = var4.index;
            Client.secretCipherBuffer1.putOpcode(153);
            Client.secretCipherBuffer1.method2900(var8);
            Client.secretCipherBuffer1.method2908(var5);
            Client.field467 = var4;
            class22.method197(var4);
            return 1;
         } else if(var0 == 1122) {
            var4.field2332 = class32.field743[--class30.field713];
            class22.method197(var4);
            return 1;
         } else if(var0 == 1123) {
            var4.field2245 = class32.field743[--class30.field713];
            class22.method197(var4);
            return 1;
         } else if(var0 == 1124) {
            var4.field2251 = class32.field743[--class30.field713];
            class22.method197(var4);
            return 1;
         } else if(var0 == 1125) {
            var5 = class32.field743[--class30.field713];
            class221[] var6 = new class221[]{class221.field3200, class221.field3201, class221.field3203, class221.field3202, class221.field3206};
            class221 var7 = (class221)Client.method556(var6, var5);
            if(var7 != null) {
               var4.field2249 = var7;
               class22.method197(var4);
            }

            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "600507223"
   )
   final void method585(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field644[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class196 var12 = class114.method2258(var1);
         var10 = var12.field2890;
         var11 = var12.field2881;
      }

      int var14;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var14 = 0;
         if(var10 == 0) {
            var14 = this.field644[0];
         } else if(var10 == 1) {
            var14 = this.field639[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field644[var13] < var14) {
                  var9 = var13;
                  var14 = this.field644[var13];
               }
            } else if(var10 == 1 && this.field639[var13] < var14) {
               var9 = var13;
               var14 = this.field639[var13];
            }
         }

         if(var10 == 1 && var14 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field634 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field634;
            this.field634 = (byte)((this.field634 + 1) % 4);
            if(this.field644[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field657[var9] = var1;
         this.field639[var9] = var2;
         this.field641[var9] = var3;
         this.field642[var9] = var4;
         this.field644[var9] = var11 + var5 + var6;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "654781456"
   )
   public static void method587() {
      if(class185.field2770 != null) {
         class185.field2770.method2113();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2070710820"
   )
   public static void method588(int var0) {
      class115.mouseIdleTicks = var0;
   }
}
