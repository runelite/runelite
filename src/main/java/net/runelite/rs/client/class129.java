package net.runelite.rs.client;

import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dj")
public class class129 {
   @ObfuscatedName("m")
   public static final class129 field2043 = new class129(1);
   @ObfuscatedName("f")
   public static final class129 field2045 = new class129(2);
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 849242665
   )
   public final int field2046;
   @ObfuscatedName("j")
   public static final class129 field2047 = new class129(0);
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -561140007
   )
   public static int field2048;

   @ObfuscatedName("s")
   public static final class78 method2865(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(-1 == var1) {
         var4 = 0;
      } else if(var4 == 2 && 1 != var1) {
         var4 = 1;
      }

      long var6 = ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var4 << 40) + ((long)var3 << 42);
      class78 var8;
      if(!var5) {
         var8 = (class78)class51.field1095.method3808(var6);
         if(var8 != null) {
            return var8;
         }
      }

      class51 var9 = class10.method158(var0);
      if(var1 > 1 && null != var9.field1127) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1128[var11] && var9.field1128[var11] != 0) {
               var10 = var9.field1127[var11];
            }
         }

         if(-1 != var10) {
            var9 = class10.method158(var10);
         }
      }

      class104 var21 = var9.method1073(1);
      if(null == var21) {
         return null;
      } else {
         class78 var22 = null;
         if(-1 != var9.field1114) {
            var22 = method2865(var9.field1104, 10, 1, 0, 0, true);
            if(null == var22) {
               return null;
            }
         } else if(var9.field1125 != -1) {
            var22 = method2865(var9.field1138, var1, var2, var3, 0, false);
            if(null == var22) {
               return null;
            }
         }

         int[] var12 = class79.field1406;
         int var13 = class79.field1401;
         int var14 = class79.field1404;
         int[] var15 = new int[4];
         class79.method1858(var15);
         var8 = new class78(36, 32);
         class79.method1814(var8.field1394, 36, 32);
         class79.method1848();
         class90.method2103();
         class90.method2106(16, 16);
         class90.field1572 = false;
         int var16 = var9.field1129;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)(1.04D * (double)var16);
         }

         int var17 = class90.field1571[var9.field1105] * var16 >> 16;
         int var18 = var16 * class90.field1573[var9.field1105] >> 16;
         var21.method2334();
         var21.method2379(0, var9.field1103, var9.field1089, var9.field1105, var9.field1139, var17 + var21.field1441 / 2 + var9.field1130, var9.field1130 + var18);
         if(-1 != var9.field1125) {
            var22.method1730(0, 0);
         }

         if(var2 >= 1) {
            var8.method1773(1);
         }

         if(var2 >= 2) {
            var8.method1773(16777215);
         }

         if(var3 != 0) {
            var8.method1790(var3);
         }

         class79.method1814(var8.field1394, 36, 32);
         if(var9.field1114 != -1) {
            var22.method1730(0, 0);
         }

         if(var4 == 1 || var4 == 2 && 1 == var9.field1110) {
            class223 var19 = class51.field1113;
            String var20;
            if(var1 < 100000) {
               var20 = "<col=ffff00>" + var1 + "</col>";
            } else if(var1 < 10000000) {
               var20 = "<col=ffffff>" + var1 / 1000 + "K" + "</col>";
            } else {
               var20 = "<col=00ff80>" + var1 / 1000000 + "M" + "</col>";
            }

            var19.method4074(var20, 0, 9, 16776960, 1);
         }

         if(!var5) {
            class51.field1095.method3805(var8, var6);
         }

         class79.method1814(var12, var13, var14);
         class79.method1828(var15);
         class90.method2103();
         class90.field1572 = true;
         return var8;
      }
   }

   @ObfuscatedName("f")
   static void method2866(Component var0, class166 var1, class166 var2, boolean var3, int var4) {
      if(class31.field706) {
         if(4 == var4) {
            class31.field709 = 4;
         }

      } else {
         class31.field709 = var4;
         class79.method1848();
         byte[] var5 = var1.method3329("title.jpg", "");
         class150.field2240 = new class78(var5, var0);
         class31.field693 = class150.field2240.method1775();
         if((client.field277 & 536870912) != 0) {
            class33.field755 = class0.method4(var2, "logo_deadman_mode", "");
         } else {
            class33.field755 = class0.method4(var2, "logo", "");
         }

         class218.field3148 = class0.method4(var2, "titlebox", "");
         class31.field718 = class0.method4(var2, "titlebutton", "");
         class102.field1749 = class41.method896(var2, "runes", "");
         class162.field2634 = class41.method896(var2, "title_mute", "");
         class35.field777 = class0.method4(var2, "options_radio_buttons,0", "");
         class126.field2035 = class0.method4(var2, "options_radio_buttons,2", "");
         class105.field1841 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class105.field1841[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class105.field1841[64 + var6] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class105.field1841[var6 + 128] = 16776960 + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class105.field1841[var6 + 192] = 16777215;
         }

         class147.field2210 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class147.field2210[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class147.field2210[64 + var6] = '\uff00' + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class147.field2210[128 + var6] = var6 * 262144 + '\uffff';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class147.field2210[var6 + 192] = 16777215;
         }

         class31.field703 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field703[var6] = 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field703[var6 + 64] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field703[var6 + 128] = 16711935 + 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class31.field703[var6 + 192] = 16777215;
         }

         class31.field699 = new int[256];
         class139.field2144 = new int['耀'];
         class176.field2894 = new int['耀'];
         class15.method208((class80)null);
         class86.field1514 = new int['耀'];
         class165.field2653 = new int['耀'];
         if(var3) {
            class31.field713 = "";
            class31.field726 = "";
         }

         class3.field64 = 0;
         class50.field1083 = "";
         class31.field716 = true;
         class31.field721 = false;
         if(!class153.field2277.field135) {
            class167 var9 = class142.field2165;
            int var7 = var9.method3327("scape main");
            int var8 = var9.method3323(var7, "");
            class182.field2940 = 1;
            class188.field3038 = var9;
            class182.field2945 = var7;
            class35.field778 = var8;
            class182.field2942 = 255;
            class158.field2586 = false;
            class173.field2874 = 2;
         } else {
            class51.method1115(2);
         }

         class132.method2893(false);
         class31.field706 = true;
         class31.field691 = (field2048 - client.field511 * 765) / 2;
         class31.field715 = class31.field691 + 202;
         class150.field2240.method1728(class31.field691, 0);
         class31.field693.method1728(class31.field691 + 382, 0);
         class33.field755.method1881(class31.field691 + 382 - class33.field755.field1407 / 2, 18);
      }
   }

   class129(int var1) {
      this.field2046 = var1;
   }

   @ObfuscatedName("bi")
   static final void method2867() {
      client.field320.method2787();
      int var0 = client.field320.method2786(8);
      int var1;
      if(var0 < client.field314) {
         for(var1 = var0; var1 < client.field314; ++var1) {
            client.field401[++client.field413 - 1] = client.field315[var1];
         }
      }

      if(var0 > client.field314) {
         throw new RuntimeException("");
      } else {
         client.field314 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = client.field315[var1];
            class34 var3 = client.field313[var2];
            int var4 = client.field320.method2786(1);
            if(var4 == 0) {
               client.field315[++client.field314 - 1] = var2;
               var3.field799 = client.field286;
            } else {
               int var5 = client.field320.method2786(2);
               if(0 == var5) {
                  client.field315[++client.field314 - 1] = var2;
                  var3.field799 = client.field286;
                  client.field317[++client.field444 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(1 == var5) {
                     client.field315[++client.field314 - 1] = var2;
                     var3.field799 = client.field286;
                     var6 = client.field320.method2786(3);
                     var3.method759(var6, (byte)1);
                     var7 = client.field320.method2786(1);
                     if(1 == var7) {
                        client.field317[++client.field444 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     client.field315[++client.field314 - 1] = var2;
                     var3.field799 = client.field286;
                     var6 = client.field320.method2786(3);
                     var3.method759(var6, (byte)2);
                     var7 = client.field320.method2786(3);
                     var3.method759(var7, (byte)2);
                     int var8 = client.field320.method2786(1);
                     if(1 == var8) {
                        client.field317[++client.field444 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     client.field401[++client.field413 - 1] = var2;
                  }
               }
            }
         }

      }
   }
}
