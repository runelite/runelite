package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("am")
public class class31 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -462511417
   )
   static int field691 = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -236290671
   )
   static int field692;
   @ObfuscatedName("h")
   static class78 field693;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1274898261
   )
   static int field697;
   @ObfuscatedName("n")
   static int[] field698;
   @ObfuscatedName("y")
   static int[] field699;
   @ObfuscatedName("ay")
   static String field700;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 910301701
   )
   static int field702;
   @ObfuscatedName("x")
   static int[] field703;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 363961971
   )
   static int field704;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1250938601
   )
   static int field705;
   @ObfuscatedName("j")
   static boolean field706;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1482627733
   )
   static int field707;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 274665221
   )
   static int field708;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 994903537
   )
   static int field709;
   @ObfuscatedName("av")
   static String field710;
   @ObfuscatedName("at")
   static String field712;
   @ObfuscatedName("al")
   static String field713;
   @ObfuscatedName("ap")
   static String field714;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 665923999
   )
   static int field715;
   @ObfuscatedName("ag")
   static boolean field716;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1980121451
   )
   static int field717;
   @ObfuscatedName("l")
   static class80 field718;
   @ObfuscatedName("ar")
   static class158 field720;
   @ObfuscatedName("af")
   static boolean field721;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -391977169
   )
   static int field722;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = -1287064113
   )
   static int field724;
   @ObfuscatedName("ac")
   static String field726;

   @ObfuscatedName("t")
   static void method714(int var0) {
      if(var0 != client.field296) {
         if(0 == client.field296) {
            class103.field1760 = null;
            class50.field1084 = null;
            class86.field1512 = null;
         }

         if(var0 == 20 || 40 == var0 || 45 == var0) {
            client.field309 = 0;
            client.field310 = 0;
            client.field307 = 0;
         }

         if(20 != var0 && var0 != 40 && class8.field138 != null) {
            class8.field138.method3022();
            class8.field138 = null;
         }

         if(25 == client.field296) {
            client.field485 = 0;
            client.field330 = 0;
            client.field331 = 1;
            client.field332 = 0;
            client.field333 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(20 == var0) {
               class129.method2866(class17.field244, class48.field1071, class4.field70, true, client.field296 == 11?4:0);
            } else if(var0 == 11) {
               class129.method2866(class17.field244, class48.field1071, class4.field70, false, 4);
            } else if(field706) {
               class218.field3148 = null;
               field718 = null;
               class102.field1749 = null;
               class150.field2240 = null;
               field693 = null;
               class33.field755 = null;
               class162.field2634 = null;
               class35.field777 = null;
               class126.field2035 = null;
               class33.field749 = null;
               class27.field648 = null;
               class101.field1748 = null;
               class155.field2289 = null;
               class10.field159 = null;
               class105.field1841 = null;
               class147.field2210 = null;
               field703 = null;
               field699 = null;
               class139.field2144 = null;
               class176.field2894 = null;
               class86.field1514 = null;
               class165.field2653 = null;
               class51.method1115(2);
               class132.method2893(true);
               field706 = false;
            }
         } else {
            class129.method2866(class17.field244, class48.field1071, class4.field70, true, 0);
         }

         client.field296 = var0;
      }
   }

   static {
      field715 = 202 + field691;
      field698 = new int[256];
      field697 = 0;
      field702 = 0;
      field692 = 0;
      field704 = 0;
      field705 = 0;
      field708 = 0;
      field707 = 10;
      field700 = "";
      field709 = 0;
      field710 = "";
      field714 = "";
      field712 = "";
      field713 = "";
      field726 = "";
      field720 = class158.field2579;
      field716 = true;
      field717 = 0;
      field721 = false;
      field722 = -1;
   }

   @ObfuscatedName("u")
   public static int method734(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var1 + var6);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var3[var6 + var4] = -128;
            } else if(var7 == 8218) {
               var3[var4 + var6] = -126;
            } else if(402 == var7) {
               var3[var6 + var4] = -125;
            } else if(var7 == 8222) {
               var3[var6 + var4] = -124;
            } else if(var7 == 8230) {
               var3[var4 + var6] = -123;
            } else if(8224 == var7) {
               var3[var4 + var6] = -122;
            } else if(var7 == 8225) {
               var3[var6 + var4] = -121;
            } else if(710 == var7) {
               var3[var4 + var6] = -120;
            } else if(8240 == var7) {
               var3[var6 + var4] = -119;
            } else if(var7 == 352) {
               var3[var4 + var6] = -118;
            } else if(var7 == 8249) {
               var3[var4 + var6] = -117;
            } else if(338 == var7) {
               var3[var4 + var6] = -116;
            } else if(var7 == 381) {
               var3[var6 + var4] = -114;
            } else if(var7 == 8216) {
               var3[var4 + var6] = -111;
            } else if(8217 == var7) {
               var3[var6 + var4] = -110;
            } else if(var7 == 8220) {
               var3[var4 + var6] = -109;
            } else if(8221 == var7) {
               var3[var6 + var4] = -108;
            } else if(8226 == var7) {
               var3[var6 + var4] = -107;
            } else if(var7 == 8211) {
               var3[var6 + var4] = -106;
            } else if(8212 == var7) {
               var3[var4 + var6] = -105;
            } else if(var7 == 732) {
               var3[var6 + var4] = -104;
            } else if(var7 == 8482) {
               var3[var6 + var4] = -103;
            } else if(353 == var7) {
               var3[var6 + var4] = -102;
            } else if(8250 == var7) {
               var3[var6 + var4] = -101;
            } else if(var7 == 339) {
               var3[var4 + var6] = -100;
            } else if(var7 == 382) {
               var3[var4 + var6] = -98;
            } else if(var7 == 376) {
               var3[var6 + var4] = -97;
            } else {
               var3[var6 + var4] = 63;
            }
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }

   @ObfuscatedName("av")
   static final void method735(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = client.field528 + (client.field529 - client.field528) * var5 / 100;
      int var7 = 512 * var6 * var3 / (334 * var2);
      int var8;
      int var9;
      short var14;
      if(var7 < client.field534) {
         var14 = client.field534;
         var6 = 334 * var14 * var2 / (512 * var3);
         if(var6 > client.field533) {
            var6 = client.field533;
            var8 = 512 * var3 * var6 / (334 * var14);
            var9 = (var2 - var8) / 2;
            if(var4) {
               class79.method1875();
               class79.method1820(var0, var1, var9, var3, -16777216);
               class79.method1820(var2 + var0 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= var9 * 2;
         }
      } else if(var7 > client.field284) {
         var14 = client.field284;
         var6 = 334 * var2 * var14 / (512 * var3);
         if(var6 < client.field386) {
            var6 = client.field386;
            var8 = var14 * var2 * 334 / (512 * var6);
            var9 = (var3 - var8) / 2;
            if(var4) {
               class79.method1875();
               class79.method1820(var0, var1, var2, var9, -16777216);
               class79.method1820(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (client.field531 - client.field488) * var5 / 100 + client.field488;
      client.field540 = var8 * var6 * var3 / 85504 << 1;
      if(client.field538 != var2 || client.field539 != var3) {
         int[] var15 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 128 + var10 * 32 + 15;
            int var12 = 3 * var11 + 600;
            int var13 = class90.field1571[var11];
            var15[var10] = var12 * var13 >> 16;
         }

         class85.method2030(var15, 500, 800, var2, var3);
      }

      client.field536 = var0;
      client.field435 = var1;
      client.field538 = var2;
      client.field539 = var3;
   }
}
