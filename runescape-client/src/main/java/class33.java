import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public class class33 {
   @ObfuscatedName("j")
   static int[] field701;
   @ObfuscatedName("p")
   static ModIcon[] field702;
   @ObfuscatedName("as")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("f")
   static ModIcon field704;
   @ObfuscatedName("k")
   static ModIcon[] field705;
   @ObfuscatedName("au")
   @Export("username")
   static String username;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1115335631
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("q")
   static int[] field708;
   @ObfuscatedName("ab")
   static String field709;
   @ObfuscatedName("e")
   static int[] field710;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1039836871
   )
   static int field711;
   @ObfuscatedName("av")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 252692961
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -444768139
   )
   static int field714;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -708023777
   )
   static int field715 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -26177175
   )
   static int field716;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 2134448971
   )
   static int field717;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -578281867
   )
   static int field718;
   @ObfuscatedName("an")
   static String field719;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -502218367
   )
   static int field720;
   @ObfuscatedName("t")
   static ModIcon field721;
   @ObfuscatedName("ao")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ap")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("g")
   static SpritePixels field725;
   @ObfuscatedName("ad")
   static String field726;
   @ObfuscatedName("i")
   static int[] field727;
   @ObfuscatedName("ay")
   static boolean field728;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 727461779
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -318592467
   )
   static int field733;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -698085363
   )
   static int field734;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      longValue = 3827201585998614189L
   )
   static long field735;
   @ObfuscatedName("aj")
   static class162 field736;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass125;IB)V",
      garbageValue = "119"
   )
   static void method689(class125 var0, int var1) {
      boolean var2 = var0.method2762(1) == 1;
      if(var2) {
         class34.field744[++class34.field750 - 1] = var1;
      }

      int var3 = var0.method2762(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field46 = false;
         } else if(var1 == Client.localInteractingIndex) {
            throw new RuntimeException();
         } else {
            class34.field747[var1] = (var4.pathX[0] + class23.baseX >> 6 << 14) + (var4.field47 << 28) + (class8.baseY + var4.pathY[0] >> 6);
            if(var4.field850 != -1) {
               class34.field748[var1] = var4.field850;
            } else {
               class34.field748[var1] = var4.field852;
            }

            class34.field755[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.method2762(1) != 0) {
               class16.method186(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2762(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(var1 != Client.localInteractingIndex || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field46 = true;
                  var4.field53 = var6;
                  var4.field51 = var7;
               } else {
                  var4.field46 = false;
                  var4.method11(var6, var7, class34.field741[var1]);
               }
            } else {
               var4.method12(var6, var7);
               var4.field46 = false;
            }

         } else if(var3 == 2) {
            var5 = var0.method2762(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method12(var6, var7);
               var4.field46 = false;
            } else if(var2) {
               var4.field46 = true;
               var4.field53 = var6;
               var4.field51 = var7;
            } else {
               var4.field46 = false;
               var4.method11(var6, var7, class34.field741[var1]);
            }

         } else {
            var5 = var0.method2762(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2762(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var4.pathY[0] + var9;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field46 = true;
                     var4.field53 = var10;
                     var4.field51 = var11;
                  } else {
                     var4.field46 = false;
                     var4.method11(var10, var11, class34.field741[var1]);
                  }
               } else {
                  var4.method12(var10, var11);
                  var4.field46 = false;
               }

               var4.field47 = (byte)(var7 + var4.field47 & 3);
               if(Client.localInteractingIndex == var1) {
                  class59.plane = var4.field47;
               }

            } else {
               var6 = var0.method2762(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (class23.baseX + var4.pathX[0] + var8 & 16383) - class23.baseX;
               var11 = (class8.baseY + var4.pathY[0] + var9 & 16383) - class8.baseY;
               if(var1 == Client.localInteractingIndex && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method12(var10, var11);
                  var4.field46 = false;
               } else if(var2) {
                  var4.field46 = true;
                  var4.field53 = var10;
                  var4.field51 = var11;
               } else {
                  var4.field46 = false;
                  var4.method11(var10, var11, class34.field741[var1]);
               }

               var4.field47 = (byte)(var7 + var4.field47 & 3);
               if(var1 == Client.localInteractingIndex) {
                  class59.plane = var4.field47;
               }

            }
         }
      }
   }

   static {
      loginWindowX = field715 + 202;
      field708 = new int[256];
      field720 = 0;
      field711 = 0;
      field714 = 0;
      field717 = 0;
      field716 = 0;
      field733 = 0;
      field718 = 10;
      field719 = "";
      loginIndex = 0;
      field709 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field726 = "";
      field736 = class162.field2643;
      field728 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field734 = -1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;I)V",
      garbageValue = "-289647879"
   )
   public static void method710(class170 var0, class170 var1) {
      class45.field989 = var0;
      class181.field2955 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-93"
   )
   public static int method712(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }
}
