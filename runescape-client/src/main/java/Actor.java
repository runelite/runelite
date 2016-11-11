import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 1352275297
   )
   int field835;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 765189067
   )
   @Export("y")
   int y;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1274109597
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("ak")
   boolean field838 = false;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1778855151
   )
   int field839 = 1;
   @ObfuscatedName("bc")
   int[] field840 = new int[4];
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1077116547
   )
   int field841;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1726979789
   )
   int field842 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1467775769
   )
   int field843 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1253744123
   )
   int field844 = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 602487365
   )
   int field845 = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 932836417
   )
   int field846 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 502669429
   )
   int field847 = 100;
   @ObfuscatedName("av")
   int[] field848 = new int[4];
   @ObfuscatedName("ac")
   boolean field849;
   @ObfuscatedName("cu")
   byte[] field850 = new byte[10];
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 329591327
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -685519891
   )
   int field852 = 0;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 321083343
   )
   @Export("actionFrame")
   int actionFrame = 0;
   @ObfuscatedName("aj")
   byte field854 = 0;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 938943149
   )
   int field855;
   @ObfuscatedName("cs")
   @Export("pathX")
   int[] pathX = new int[10];
   @ObfuscatedName("ch")
   @Export("pathY")
   int[] pathY = new int[10];
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 1480443209
   )
   int field858;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1398086365
   )
   int field859 = -1;
   @ObfuscatedName("bv")
   class205 field860 = new class205();
   @ObfuscatedName("ax")
   @Export("overhead")
   String overhead = null;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -866251429
   )
   int field862 = -1;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 745185163
   )
   int field863 = -1;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1877948175
   )
   @Export("poseAnimation")
   int poseAnimation = -1;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1631609427
   )
   @Export("poseFrame")
   int poseFrame = 0;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -1979333413
   )
   int field866 = 0;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1118550657
   )
   @Export("animation")
   int animation = -1;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -46636307
   )
   @Export("interacting")
   int interacting = -1;
   @ObfuscatedName("at")
   int[] field869 = new int[4];
   @ObfuscatedName("ca")
   @ObfuscatedGetter(
      intValue = -408972209
   )
   int field870 = 200;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1010466073
   )
   int field871 = 0;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 2027185301
   )
   @Export("graphic")
   int graphic = -1;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -593304555
   )
   int field873 = 0;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -659545511
   )
   int field874 = 0;
   @ObfuscatedName("ae")
   int[] field875 = new int[4];
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 45467019
   )
   int field876;
   @ObfuscatedName("az")
   int[] field877 = new int[4];
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1509800963
   )
   @Export("x")
   int x;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -307192295
   )
   int field879;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1485012757
   )
   int field880 = 0;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1153596769
   )
   int field881;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 696927879
   )
   int field882;
   @ObfuscatedName("ai")
   @Export("inSequence")
   boolean inSequence = false;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 985344145
   )
   int field884 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1496289775
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation = -1;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 1688415547
   )
   int field886;
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = 74916785
   )
   int field887 = 0;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = -237953625
   )
   int field888 = 32;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -1124014797
   )
   int field889 = 0;
   @ObfuscatedName("by")
   boolean field890 = false;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -2076762375
   )
   int field891 = 0;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1226870115
   )
   int field892;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -419332043
   )
   int field893 = 0;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1039750665
   )
   int field894 = 0;
   @ObfuscatedName("gu")
   static Widget field895;

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "83"
   )
   final void method782() {
      this.field889 = 0;
      this.field894 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-270112451"
   )
   boolean vmethod783() {
      return false;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-2022208419"
   )
   final void method784(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.field875[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class51 var14 = class180.method3491(var1);
         var10 = var14.field1121;
         var11 = var14.field1112;
      }

      int var12;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var12 = 0;
         if(var10 == 0) {
            var12 = this.field875[0];
         } else if(var10 == 1) {
            var12 = this.field848[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.field875[var13] < var12) {
                  var9 = var13;
                  var12 = this.field875[var13];
               }
            } else if(var10 == 1 && this.field848[var13] < var12) {
               var9 = var13;
               var12 = this.field848[var13];
            }
         }

         if(var10 == 1 && var12 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field854 = 0;
         }

         for(var12 = 0; var12 < 4; ++var12) {
            byte var15 = this.field854;
            this.field854 = (byte)((this.field854 + 1) % 4);
            if(this.field875[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field877[var9] = var1;
         this.field848[var9] = var2;
         this.field869[var9] = var3;
         this.field840[var9] = var4;
         this.field875[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "-2143574503"
   )
   final void method785(int var1, int var2, int var3, int var4, int var5, int var6) {
      class49 var7 = NPC.method762(var1);
      class26 var8 = null;
      class26 var9 = null;
      int var10 = var7.field1084;
      int var11 = 0;

      class26 var12;
      for(var12 = (class26)this.field860.method3881(); var12 != null; var12 = (class26)this.field860.method3883()) {
         ++var11;
         if(var12.field662.field1090 == var7.field1090) {
            var12.method580(var4 + var2, var5, var6, var3);
            return;
         }

         if(var12.field662.field1083 <= var7.field1083) {
            var8 = var12;
         }

         if(var12.field662.field1084 > var10) {
            var9 = var12;
            var10 = var12.field662.field1084;
         }
      }

      if(null != var9 || var11 < 4) {
         var12 = new class26(var7);
         if(null == var8) {
            this.field860.method3899(var12);
         } else {
            class205.method3890(var12, var8);
         }

         var12.method580(var4 + var2, var5, var6, var3);
         if(var11 >= 4) {
            var9.unlink();
         }

      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-314058966"
   )
   final void method786(int var1) {
      class49 var2 = NPC.method762(var1);

      for(class26 var3 = (class26)this.field860.method3881(); null != var3; var3 = (class26)this.field860.method3883()) {
         if(var3.field662 == var2) {
            var3.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-2130459937"
   )
   static char method797(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)LMessageNode;",
      garbageValue = "2035986573"
   )
   static MessageNode method798(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class11.chatLineMap.get(Integer.valueOf(var0));
      return var2.method636(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "-59516733"
   )
   static void method799(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class141.field2184.startsWith("win") && !var3) {
            class33.method712(var0, 0);
            return;
         }

         if(class141.field2184.startsWith("mac")) {
            Projectile.method101(var0, 1, var2);
            return;
         }

         class33.method712(var0, 2);
      } else {
         class33.method712(var0, 3);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LModIcon;B)V",
      garbageValue = "27"
   )
   static final void method800(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < SecondaryBufferProvider.field1434.length; ++var2) {
         SecondaryBufferProvider.field1434[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         SecondaryBufferProvider.field1434[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class79.field1442[var5] = (SecondaryBufferProvider.field1434[var5 - 128] + SecondaryBufferProvider.field1434[var5 - 1] + SecondaryBufferProvider.field1434[var5 + 1] + SecondaryBufferProvider.field1434[var5 + 128]) / 4;
            }
         }

         int[] var8 = SecondaryBufferProvider.field1434;
         SecondaryBufferProvider.field1434 = class79.field1442;
         class79.field1442 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var0.offsetX + 16 + var4;
                  int var6 = 16 + var3 + var0.offsetY;
                  int var7 = var5 + (var6 << 7);
                  SecondaryBufferProvider.field1434[var7] = 0;
               }
            }
         }
      }

   }
}
