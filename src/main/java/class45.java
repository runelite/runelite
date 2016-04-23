import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class45 extends class204 {
   @ObfuscatedName("h")
   static class193 field1023 = new class193(64);
   @ObfuscatedName("m")
   public boolean field1024 = false;
   @ObfuscatedName("j")
   public static class167 field1028;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass119;B)V",
      garbageValue = "12"
   )
   void method936(class119 var1) {
      while(true) {
         int var2 = var1.method2500();
         if(0 == var2) {
            return;
         }

         this.method940(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2089088352"
   )
   static int method938(int var0) {
      class27 var1 = (class27)class11.field178.get(Integer.valueOf(var0));
      return null == var1?0:var1.method636();
   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(Lclass173;II)Ljava/lang/String;",
      garbageValue = "860141939"
   )
   static String method939(class173 var0, int var1) {
      int var3 = class144.method3075(var0);
      boolean var2 = 0 != (var3 >> 1 + var1 & 1);
      return !var2 && var0.field2844 == null?null:(var0.field2818 != null && var0.field2818.length > var1 && var0.field2818[var1] != null && var0.field2818[var1].trim().length() != 0?var0.field2818[var1]:null);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "0"
   )
   void method940(class119 var1, int var2) {
      if(var2 == 2) {
         this.field1024 = true;
      }

   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(Lclass173;II)I",
      garbageValue = "-1552250463"
   )
   static final int method945(class173 var0, int var1) {
      if(null != var0.field2856 && var1 < var0.field2856.length) {
         try {
            int[] var2 = var0.field2856[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(0 == var6) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = client.field419[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = client.field411[var2[var4++]];
               }

               if(3 == var6) {
                  var7 = client.field412[var2[var4++]];
               }

               int var9;
               class173 var10;
               int var11;
               int var12;
               if(4 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class141.method2959(var9);
                  var11 = var2[var4++];
                  if(-1 != var11 && (!class89.method2081(var11).field1108 || client.field279)) {
                     for(var12 = 0; var12 < var10.field2862.length; ++var12) {
                        if(var11 + 1 == var10.field2862[var12]) {
                           var7 += var10.field2863[var12];
                        }
                     }
                  }
               }

               if(5 == var6) {
                  var7 = class176.field2900[var2[var4++]];
               }

               if(6 == var6) {
                  var7 = class155.field2279[client.field411[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class176.field2900[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class47.field1053.field41;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class155.field2278[var9]) {
                        var7 += client.field411[var9];
                     }
                  }
               }

               if(10 == var6) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class141.method2959(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class89.method2081(var11).field1108 || client.field279)) {
                     for(var12 = 0; var12 < var10.field2862.length; ++var12) {
                        if(var10.field2862[var12] == 1 + var11) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = client.field438;
               }

               if(12 == var6) {
                  var7 = client.field413;
               }

               if(13 == var6) {
                  var9 = class176.field2900[var2[var4++]];
                  int var14 = var2[var4++];
                  var7 = (var9 & 1 << var14) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class59.method1263(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(16 == var6) {
                  var8 = 2;
               }

               if(17 == var6) {
                  var8 = 3;
               }

               if(18 == var6) {
                  var7 = class187.field3014 + (class47.field1053.field816 >> 7);
               }

               if(var6 == 19) {
                  var7 = (class47.field1053.field840 >> 7) + class0.field12;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(0 == var8) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(1 == var5) {
                     var3 -= var7;
                  }

                  if(2 == var5 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var13) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-566055971"
   )
   static void method946() {
      class227 var0 = null;

      try {
         var0 = class106.method2367("", class75.field1360.field2273, true);
         class119 var1 = class4.field75.method110();
         var0.method4097(var1.field1973, 0, var1.field1971);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method4088();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CB)B",
      garbageValue = "-72"
   )
   public static byte method947(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(8222 == var0) {
         var1 = -124;
      } else if(8230 == var0) {
         var1 = -123;
      } else if(8224 == var0) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(710 == var0) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(8217 == var0) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(8482 == var0) {
         var1 = -103;
      } else if(353 == var0) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(382 == var0) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass167;Lclass167;ZII)V",
      garbageValue = "1"
   )
   static void method948(Component var0, class167 var1, class167 var2, boolean var3, int var4) {
      if(!class31.field699) {
         class31.field712 = var4;
         class79.method1781();
         byte[] var5 = var1.method3234("title.jpg", "");
         class186.field3010 = new class78(var5, var0);
         class31.field700 = class186.field3010.method1747();
         if(0 != (client.field492 & 536870912)) {
            class31.field701 = class102.method2275(var2, "logo_deadman_mode", "");
         } else {
            class31.field701 = class102.method2275(var2, "logo", "");
         }

         class31.field731 = class102.method2275(var2, "titlebox", "");
         class31.field705 = class102.method2275(var2, "titlebutton", "");
         class31.field697 = class34.method722(var2, "runes", "");
         class138.field2111 = class34.method722(var2, "title_mute", "");
         class77.field1379 = class102.method2275(var2, "options_radio_buttons,0", "");
         class1.field21 = class102.method2275(var2, "options_radio_buttons,2", "");
         class27.field647 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class27.field647[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class27.field647[var6 + 64] = 1024 * var6 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class27.field647[128 + var6] = 4 * var6 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class27.field647[192 + var6] = 16777215;
         }

         class214.field3157 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class214.field3157[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class214.field3157[64 + var6] = '\uff00' + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class214.field3157[var6 + 128] = '\uffff' + 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class214.field3157[192 + var6] = 16777215;
         }

         class82.field1412 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class82.field1412[var6] = 4 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class82.field1412[64 + var6] = var6 * 262144 + 255;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class82.field1412[128 + var6] = 1024 * var6 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class82.field1412[var6 + 192] = 16777215;
         }

         class35.field769 = new int[256];
         class56.field1165 = new int['耀'];
         class9.field152 = new int['耀'];
         class8.method111((class80)null);
         class5.field86 = new int['耀'];
         class176.field2907 = new int['耀'];
         class31.field698 = "";
         class31.field710 = "";
         class31.field720 = 0;
         class101.field1739 = "";
         class31.field721 = true;
         class31.field726 = false;
         if(!class4.field75.field143) {
            class77.method1686(2, class135.field2069, "scape main", "", 255, false);
         } else {
            class183.field2959 = 1;
            class76.field1370 = null;
            class183.field2960 = -1;
            class183.field2961 = -1;
            class183.field2957 = 0;
            class183.field2964 = false;
            class183.field2963 = 2;
         }

         class5.method69(false);
         class31.field699 = true;
         class31.field696 = (class5.field102 - client.field488) / 2;
         class31.field702 = 202 + class31.field696;
         class186.field3010.method1698(class31.field696, 0);
         class31.field700.method1698(class31.field696 + 382, 0);
         class31.field701.method1867(382 + class31.field696 - class31.field701.field1403 / 2, 18);
      }
   }
}
