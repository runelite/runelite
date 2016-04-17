import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public final class class16 extends class208 {
   @ObfuscatedName("nc")
   @ObfuscatedGetter(
      intValue = -1365464699
   )
   static int field236;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1194502417
   )
   int field237;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1037182493
   )
   int field238;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1925044431
   )
   int field239 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 705450447
   )
   int field240;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -754044517
   )
   int field241;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 435792687
   )
   int field242;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1011747959
   )
   int field243;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1874062533
   )
   int field244;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1311839581
   )
   int field245;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 400923955
   )
   int field247 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1426432739
   )
   int field249;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1845305873
   )
   int field250;

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "59"
   )
   static final void method212(int var0, int var1, int var2, int var3) {
      ++client.field399;
      class90.method2164(class33.field783);
      boolean var4 = false;
      int var5;
      int var7;
      if(client.field424 >= 0) {
         var5 = class32.field771;
         int[] var6 = class32.field762;

         for(var7 = 0; var7 < var5; ++var7) {
            if(var6[var7] == client.field424) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class90.method2164(class33.field777);
      }

      class154.method3254(true);
      class90.method2164(var4?class33.field779:class33.field778);
      class154.method3254(false);
      class99.method2288();
      class29.method740();
      class10.method165(var0, var1, var2, var3, true);
      var0 = client.field305;
      var1 = client.field557;
      var2 = client.field558;
      var3 = client.field456;
      class79.method1889(var0, var1, var2 + var0, var3 + var1);
      class91.method2169();
      int var16;
      if(!client.field542) {
         var5 = client.field564;
         if(client.field387 / 256 > var5) {
            var5 = client.field387 / 256;
         }

         if(client.field543[4] && client.field559[4] + 128 > var5) {
            var5 = client.field559[4] + 128;
         }

         var16 = client.field363 + client.field379 & 2047;
         class103.method2376(class148.field2222, class34.method816(class5.field93.field844, class5.field93.field819, class42.field1002) - client.field556, class46.field1069, var5, var16, 3 * var5 + 600);
      }

      if(!client.field542) {
         var5 = class59.method1358();
      } else {
         if(class134.field2078.field147) {
            var16 = class42.field1002;
         } else {
            var7 = class34.method816(class26.field673, class137.field2129, class42.field1002);
            if(var7 - class46.field1070 < 800 && (class5.field82[class42.field1002][class26.field673 >> 7][class137.field2129 >> 7] & 4) != 0) {
               var16 = class42.field1002;
            } else {
               var16 = 3;
            }
         }

         var5 = var16;
      }

      var16 = class26.field673;
      var7 = class46.field1070;
      int var8 = class137.field2129;
      int var9 = class59.field1227;
      int var10 = class113.field1958;

      int var11;
      int var12;
      for(var11 = 0; var11 < 5; ++var11) {
         if(client.field543[var11]) {
            var12 = (int)(Math.random() * (double)(1 + client.field544[var11] * 2) - (double)client.field544[var11] + Math.sin((double)client.field547[var11] * ((double)client.field538[var11] / 100.0D)) * (double)client.field559[var11]);
            if(var11 == 0) {
               class26.field673 += var12;
            }

            if(1 == var11) {
               class46.field1070 += var12;
            }

            if(var11 == 2) {
               class137.field2129 += var12;
            }

            if(var11 == 3) {
               class113.field1958 = class113.field1958 + var12 & 2047;
            }

            if(var11 == 4) {
               class59.field1227 += var12;
               if(class59.field1227 < 128) {
                  class59.field1227 = 128;
               }

               if(class59.field1227 > 383) {
                  class59.field1227 = 383;
               }
            }
         }
      }

      var11 = class140.field2151;
      var12 = class140.field2161;
      if(class140.field2157 != 0) {
         var11 = class140.field2160;
         var12 = class140.field2159;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var3 + var1) {
         class105.field1848 = true;
         class105.field1851 = 0;
         class105.field1794 = var11 - var0;
         class105.field1850 = var12 - var1;
      } else {
         class105.field1848 = false;
         class105.field1851 = 0;
      }

      class41.method935();
      class79.method1929(var0, var1, var2, var3, 0);
      class41.method935();
      int var13 = class91.field1579;
      class91.field1579 = client.field560;
      class30.field717.method2007(class26.field673, class46.field1070, class137.field2129, class59.field1227, class113.field1958, var5);
      class91.field1579 = var13;
      class41.method935();
      class30.field717.method2098();
      class93.method2249(var0, var1, var2, var3);
      class104.method2384(var0, var1);
      ((class95)class91.field1575).method2260(client.field427);
      class19.method258(var0, var1, var2, var3);
      class26.field673 = var16;
      class46.field1070 = var7;
      class137.field2129 = var8;
      class59.field1227 = var9;
      class113.field1958 = var10;
      if(client.field507) {
         byte var15 = 0;
         int var17 = var15 + class171.field2727 + class171.field2719;
         if(0 == var17) {
            client.field507 = false;
         }
      }

      if(client.field507) {
         class79.method1929(var0, var1, var2, var3, 0);
         class25.method682("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "188116765"
   )
   static void method213(class173 var0, int var1, int var2) {
      if(0 == var0.field2763) {
         var0.field2848 = var0.field2753;
      } else if(var0.field2763 == 1) {
         var0.field2848 = (var1 - var0.field2773) / 2 + var0.field2753;
      } else if(2 == var0.field2763) {
         var0.field2848 = var1 - var0.field2773 - var0.field2753;
      } else if(var0.field2763 == 3) {
         var0.field2848 = var0.field2753 * var1 >> 14;
      } else if(var0.field2763 == 4) {
         var0.field2848 = (var0.field2753 * var1 >> 14) + (var1 - var0.field2773) / 2;
      } else {
         var0.field2848 = var1 - var0.field2773 - (var1 * var0.field2753 >> 14);
      }

      if(var0.field2849 == 0) {
         var0.field2772 = var0.field2768;
      } else if(1 == var0.field2849) {
         var0.field2772 = var0.field2768 + (var2 - var0.field2774) / 2;
      } else if(var0.field2849 == 2) {
         var0.field2772 = var2 - var0.field2774 - var0.field2768;
      } else if(var0.field2849 == 3) {
         var0.field2772 = var0.field2768 * var2 >> 14;
      } else if(var0.field2849 == 4) {
         var0.field2772 = (var2 * var0.field2768 >> 14) + (var2 - var0.field2774) / 2;
      } else {
         var0.field2772 = var2 - var0.field2774 - (var0.field2768 * var2 >> 14);
      }

      if(client.field462 && 0 == var0.field2824) {
         if(var0.field2848 < 0) {
            var0.field2848 = 0;
         } else if(var0.field2773 + var0.field2848 > var1) {
            var0.field2848 = var1 - var0.field2773;
         }

         if(var0.field2772 < 0) {
            var0.field2772 = 0;
         } else if(var0.field2774 + var0.field2772 > var2) {
            var0.field2772 = var2 - var0.field2774;
         }
      }

   }

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-29"
   )
   static void method214(int var0) {
      class183.field2972 = new class30();
      class183.field2972.field712 = client.field435[var0];
      class183.field2972.field711 = client.field525[var0];
      class183.field2972.field721 = client.field437[var0];
      class183.field2972.field720 = client.field500[var0];
      class183.field2972.field714 = client.field439[var0];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;Ljava/lang/String;Ljava/lang/String;B)Lclass224;",
      garbageValue = "12"
   )
   public static class224 method215(class167 var0, class167 var1, String var2, String var3) {
      int var4 = var0.method3377(var2);
      int var5 = var0.method3378(var4, var3);
      return class0.method4(var0, var1, var4, var5);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-1839570361"
   )
   public static int method216(int var0, int var1, int var2, int var3, int var4, int var5) {
      if(1 == (var5 & 1)) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return 0 == var2?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }
}
