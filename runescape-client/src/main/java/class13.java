import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class13 implements Runnable {
   @ObfuscatedName("d")
   int[] field191 = new int[500];
   @ObfuscatedName("j")
   Object field192 = new Object();
   @ObfuscatedName("s")
   boolean field193 = true;
   @ObfuscatedName("x")
   int[] field194 = new int[500];
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1301559147
   )
   int field195 = 0;

   public void run() {
      for(; this.field193; class116.method2448(50L)) {
         Object var1 = this.field192;
         Object var2 = this.field192;
         synchronized(this.field192) {
            if(this.field195 < 500) {
               this.field194[this.field195] = class140.field2162;
               this.field191[this.field195] = class140.field2163;
               ++this.field195;
            }
         }
      }

   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;B)V",
      garbageValue = "48"
   )
   static final void method164(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      if(null != var4) {
         int var6 = client.field410 + client.field364 & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class91.field1596[var6];
            int var9 = class91.field1597[var6];
            var8 = var8 * 256 / (256 + client.field353);
            var9 = 256 * var9 / (client.field353 + 256);
            int var10 = var8 * var3 + var2 * var9 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method1686(var10 + var5.field2914 / 2 - var4.field1416 / 2, var5.field2909 / 2 - var11 - var4.field1412 / 2, var0, var1, var5.field2914, var5.field2909, var5.field2911, var5.field2910);
            } else {
               var4.method1676(var10 + var0 + var5.field2914 / 2 - var4.field1416 / 2, var5.field2909 / 2 + var1 - var11 - var4.field1412 / 2);
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass42;IIIB)V",
      garbageValue = "69"
   )
   static void method166(class42 var0, int var1, int var2, int var3) {
      if(client.field521 < 50 && client.field520 != 0 && null != var0.field989 && var1 < var0.field989.length) {
         int var4 = var0.field989[var1];
         if(var4 != 0) {
            int var5 = var4 >> 8;
            int var6 = var4 >> 4 & 7;
            int var7 = var4 & 15;
            client.field537[client.field521] = var5;
            client.field523[client.field521] = var6;
            client.field524[client.field521] = 0;
            client.field526[client.field521] = null;
            int var8 = (var2 - 64) / 128;
            int var9 = (var3 - 64) / 128;
            client.field407[client.field521] = (var8 << 16) + (var9 << 8) + var7;
            ++client.field521;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass44;",
      garbageValue = "1214886182"
   )
   @Export("getKitDefinition")
   public static class44 method168(int var0) {
      class44 var1 = (class44)class44.field1025.method3743((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class44.field1034.method3239(3, var0);
         var1 = new class44();
         if(null != var2) {
            var1.method896(new class119(var2));
         }

         class44.field1025.method3745(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass167;Ljava/lang/String;Ljava/lang/String;B)[Lclass80;",
      garbageValue = "0"
   )
   public static class80[] method170(class167 var0, String var1, String var2) {
      int var3 = var0.method3253(var1);
      int var4 = var0.method3254(var3, var2);
      return class104.method2279(var0, var3, var4);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIS)V",
      garbageValue = "2527"
   )
   @Export("menuAction")
   static final void method171(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 41) {
         client.field322.method2737(54);
         client.field322.method2531(var1);
         client.field322.method2525(var3);
         client.field322.method2661(var0);
         client.field391 = 0;
         class19.field274 = class29.method645(var1);
         client.field406 = var0;
      }

      class173 var8;
      if(var2 == 24) {
         var8 = class29.method645(var1);
         boolean var9 = true;
         if(var8.field2887 > 0) {
            var9 = class43.method891(var8);
         }

         if(var9) {
            client.field322.method2737(69);
            client.field322.method2480(var1);
         }
      }

      int var11;
      if(var2 == 25) {
         var8 = class45.method932(var1, var0);
         if(null != var8) {
            class22.method571();
            int var14 = class48.method962(var8);
            int var10 = var14 >> 11 & 63;
            class41.method835(var1, var0, var10, var8.field2885);
            client.field430 = 0;
            var11 = class48.method962(var8);
            int var12 = var11 >> 11 & 63;
            String var13;
            if(0 == var12) {
               var13 = null;
            } else if(null != var8.field2844 && var8.field2844.trim().length() != 0) {
               var13 = var8.field2844;
            } else {
               var13 = null;
            }

            client.field435 = var13;
            if(client.field435 == null) {
               client.field435 = "Null";
            }

            if(var8.field2764) {
               client.field436 = var8.field2789 + class12.method163(16777215);
            } else {
               client.field436 = class12.method163('\uff00') + var8.field2881 + class12.method163(16777215);
            }
         }
      } else {
         class34 var15;
         if(10 == var2) {
            var15 = client.field515[var3];
            if(var15 != null) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(190);
               client.field322.method2590(class137.field2120[82]?1:0);
               client.field322.method2557(var3);
            }
         }

         if(var2 == 30 && null == client.field441) {
            class5.method55(var1, var0);
            client.field441 = class45.method932(var1, var0);
            class34.method701(client.field441);
         }

         class2 var16;
         if(var2 == 47) {
            var16 = client.field491[var3];
            if(null != var16) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(128);
               client.field322.method2661(var3);
               client.field322.method2681(class137.field2120[82]?1:0);
            }
         }

         if(var2 == 6) {
            client.field387 = var6;
            client.field539 = var7;
            client.field390 = 2;
            client.field389 = 0;
            client.field512 = var0;
            client.field513 = var1;
            client.field322.method2737(35);
            client.field322.method2557(class22.field594 + var0);
            client.field322.method2525(var3 >> 14 & 32767);
            client.field322.method2557(var1 + class114.field1981);
            client.field322.method2477(class137.field2120[82]?1:0);
         }

         if(var2 == 1004) {
            client.field387 = var6;
            client.field539 = var7;
            client.field390 = 2;
            client.field389 = 0;
            client.field322.method2737(70);
            client.field322.method2624(var3);
         }

         if(var2 == 15) {
            var16 = client.field491[var3];
            if(null != var16) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(243);
               client.field322.method2477(class137.field2120[82]?1:0);
               client.field322.method2661(client.field307);
               client.field322.method2624(var3);
               client.field322.method2494(class159.field2613);
            }
         }

         if(var2 == 31) {
            client.field322.method2737(78);
            client.field322.method2531(class209.field3127);
            client.field322.method2557(class162.field2657);
            client.field322.method2494(var1);
            client.field322.method2557(class25.field640);
            client.field322.method2525(var3);
            client.field322.method2624(var0);
            client.field391 = 0;
            class19.field274 = class29.method645(var1);
            client.field406 = var0;
         }

         if(58 == var2) {
            var8 = class45.method932(var1, var0);
            if(null != var8) {
               client.field322.method2737(216);
               client.field322.method2531(var1);
               client.field322.method2661(var8.field2885);
               client.field322.method2624(var0);
               client.field322.method2531(class159.field2613);
               client.field322.method2525(client.field434);
               client.field322.method2525(client.field307);
            }
         }

         if(1 == var2) {
            client.field387 = var6;
            client.field539 = var7;
            client.field390 = 2;
            client.field389 = 0;
            client.field512 = var0;
            client.field513 = var1;
            client.field322.method2737(244);
            client.field322.method2557(var0 + class22.field594);
            client.field322.method2661(var3 >> 14 & 32767);
            client.field322.method2531(class209.field3127);
            client.field322.method2557(class25.field640);
            client.field322.method2525(class162.field2657);
            client.field322.method2590(class137.field2120[82]?1:0);
            client.field322.method2557(var1 + class114.field1981);
         }

         if(28 == var2) {
            client.field322.method2737(69);
            client.field322.method2480(var1);
            var8 = class29.method645(var1);
            if(var8.field2809 != null && var8.field2809[0][0] == 5) {
               var11 = var8.field2809[0][1];
               class176.field2920[var11] = 1 - class176.field2920[var11];
               class52.method1069(var11);
            }
         }

         if(18 == var2) {
            client.field387 = var6;
            client.field539 = var7;
            client.field390 = 2;
            client.field389 = 0;
            client.field512 = var0;
            client.field513 = var1;
            client.field322.method2737(143);
            client.field322.method2624(class114.field1981 + var1);
            client.field322.method2661(var3);
            client.field322.method2590(class137.field2120[82]?1:0);
            client.field322.method2661(var0 + class22.field594);
         }

         if(var2 == 34) {
            client.field322.method2737(12);
            client.field322.method2661(var0);
            client.field322.method2531(var1);
            client.field322.method2661(var3);
            client.field391 = 0;
            class19.field274 = class29.method645(var1);
            client.field406 = var0;
         }

         if(var2 == 50) {
            var16 = client.field491[var3];
            if(var16 != null) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(52);
               client.field322.method2525(var3);
               client.field322.method2516(class137.field2120[82]?1:0);
            }
         }

         if(20 == var2) {
            client.field387 = var6;
            client.field539 = var7;
            client.field390 = 2;
            client.field389 = 0;
            client.field512 = var0;
            client.field513 = var1;
            client.field322.method2737(103);
            client.field322.method2557(var3);
            client.field322.method2661(class22.field594 + var0);
            client.field322.method2557(class114.field1981 + var1);
            client.field322.method2477(class137.field2120[82]?1:0);
         }

         if(42 == var2) {
            client.field322.method2737(253);
            client.field322.method2587(var1);
            client.field322.method2525(var0);
            client.field322.method2661(var3);
            client.field391 = 0;
            class19.field274 = class29.method645(var1);
            client.field406 = var0;
         }

         if(var2 == 44) {
            var16 = client.field491[var3];
            if(var16 != null) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(89);
               client.field322.method2590(class137.field2120[82]?1:0);
               client.field322.method2525(var3);
            }
         }

         if(1003 == var2) {
            client.field387 = var6;
            client.field539 = var7;
            client.field390 = 2;
            client.field389 = 0;
            var15 = client.field515[var3];
            if(null != var15) {
               class39 var17 = var15.field782;
               if(null != var17.field921) {
                  var17 = var17.method740();
               }

               if(null != var17) {
                  client.field322.method2737(177);
                  client.field322.method2557(var17.field886);
               }
            }
         }

         if(var2 == 4) {
            client.field387 = var6;
            client.field539 = var7;
            client.field390 = 2;
            client.field389 = 0;
            client.field512 = var0;
            client.field513 = var1;
            client.field322.method2737(150);
            client.field322.method2624(class22.field594 + var0);
            client.field322.method2477(class137.field2120[82]?1:0);
            client.field322.method2624(var3 >> 14 & 32767);
            client.field322.method2624(class114.field1981 + var1);
         }

         if(var2 == 33) {
            client.field322.method2737(235);
            client.field322.method2557(var0);
            client.field322.method2525(var3);
            client.field322.method2480(var1);
            client.field391 = 0;
            class19.field274 = class29.method645(var1);
            client.field406 = var0;
         }

         if(3 == var2) {
            client.field387 = var6;
            client.field539 = var7;
            client.field390 = 2;
            client.field389 = 0;
            client.field512 = var0;
            client.field513 = var1;
            client.field322.method2737(241);
            client.field322.method2557(var3 >> 14 & 32767);
            client.field322.method2661(class114.field1981 + var1);
            client.field322.method2681(class137.field2120[82]?1:0);
            client.field322.method2525(class22.field594 + var0);
         }

         if(var2 == 22) {
            client.field387 = var6;
            client.field539 = var7;
            client.field390 = 2;
            client.field389 = 0;
            client.field512 = var0;
            client.field513 = var1;
            client.field322.method2737(40);
            client.field322.method2624(class22.field594 + var0);
            client.field322.method2681(class137.field2120[82]?1:0);
            client.field322.method2525(class114.field1981 + var1);
            client.field322.method2624(var3);
         }

         if(var2 == 39) {
            client.field322.method2737(247);
            client.field322.method2587(var1);
            client.field322.method2661(var3);
            client.field322.method2624(var0);
            client.field391 = 0;
            class19.field274 = class29.method645(var1);
            client.field406 = var0;
         }

         if(var2 == 48) {
            var16 = client.field491[var3];
            if(var16 != null) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(3);
               client.field322.method2516(class137.field2120[82]?1:0);
               client.field322.method2661(var3);
            }
         }

         if(var2 == 40) {
            client.field322.method2737(13);
            client.field322.method2494(var1);
            client.field322.method2525(var0);
            client.field322.method2624(var3);
            client.field391 = 0;
            class19.field274 = class29.method645(var1);
            client.field406 = var0;
         }

         if(32 == var2) {
            client.field322.method2737(170);
            client.field322.method2525(var3);
            client.field322.method2557(client.field307);
            client.field322.method2661(var0);
            client.field322.method2587(var1);
            client.field322.method2531(class159.field2613);
            client.field391 = 0;
            class19.field274 = class29.method645(var1);
            client.field406 = var0;
         }

         if(51 == var2) {
            var16 = client.field491[var3];
            if(var16 != null) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(222);
               client.field322.method2557(var3);
               client.field322.method2590(class137.field2120[82]?1:0);
            }
         }

         if(11 == var2) {
            var15 = client.field515[var3];
            if(var15 != null) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(199);
               client.field322.method2516(class137.field2120[82]?1:0);
               client.field322.method2624(var3);
            }
         }

         if(var2 == 8) {
            var15 = client.field515[var3];
            if(null != var15) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(226);
               client.field322.method2590(class137.field2120[82]?1:0);
               client.field322.method2557(client.field307);
               client.field322.method2557(var3);
               client.field322.method2531(class159.field2613);
            }
         }

         if(var2 == 36) {
            client.field322.method2737(20);
            client.field322.method2494(var1);
            client.field322.method2525(var3);
            client.field322.method2557(var0);
            client.field391 = 0;
            class19.field274 = class29.method645(var1);
            client.field406 = var0;
         }

         if(7 == var2) {
            var15 = client.field515[var3];
            if(null != var15) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(38);
               client.field322.method2525(class25.field640);
               client.field322.method2516(class137.field2120[82]?1:0);
               client.field322.method2624(class162.field2657);
               client.field322.method2624(var3);
               client.field322.method2480(class209.field3127);
            }
         }

         if(var2 == 46) {
            var16 = client.field491[var3];
            if(var16 != null) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(248);
               client.field322.method2661(var3);
               client.field322.method2516(class137.field2120[82]?1:0);
            }
         }

         if(17 == var2) {
            client.field387 = var6;
            client.field539 = var7;
            client.field390 = 2;
            client.field389 = 0;
            client.field512 = var0;
            client.field513 = var1;
            client.field322.method2737(118);
            client.field322.method2624(class114.field1981 + var1);
            client.field322.method2525(var0 + class22.field594);
            client.field322.method2494(class159.field2613);
            client.field322.method2624(var3);
            client.field322.method2590(class137.field2120[82]?1:0);
            client.field322.method2661(client.field307);
         }

         if(var2 == 9) {
            var15 = client.field515[var3];
            if(var15 != null) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(41);
               client.field322.method2525(var3);
               client.field322.method2516(class137.field2120[82]?1:0);
            }
         }

         if(var2 == 21) {
            client.field387 = var6;
            client.field539 = var7;
            client.field390 = 2;
            client.field389 = 0;
            client.field512 = var0;
            client.field513 = var1;
            client.field322.method2737(44);
            client.field322.method2661(var3);
            client.field322.method2624(var1 + class114.field1981);
            client.field322.method2681(class137.field2120[82]?1:0);
            client.field322.method2557(class22.field594 + var0);
         }

         if(38 == var2) {
            class22.method571();
            var8 = class29.method645(var1);
            client.field430 = 1;
            class162.field2657 = var0;
            class209.field3127 = var1;
            class25.field640 = var3;
            class34.method701(var8);
            client.field431 = class12.method163(16748608) + class9.method128(var3).field1128 + class12.method163(16777215);
            if(client.field431 == null) {
               client.field431 = "null";
            }
         } else {
            if(var2 == 43) {
               client.field322.method2737(187);
               client.field322.method2557(var3);
               client.field322.method2525(var0);
               client.field322.method2480(var1);
               client.field391 = 0;
               class19.field274 = class29.method645(var1);
               client.field406 = var0;
            }

            if(16 == var2) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(1);
               client.field322.method2531(class209.field3127);
               client.field322.method2661(class22.field594 + var0);
               client.field322.method2624(var3);
               client.field322.method2681(class137.field2120[82]?1:0);
               client.field322.method2661(class25.field640);
               client.field322.method2624(class114.field1981 + var1);
               client.field322.method2624(class162.field2657);
            }

            if(var2 == 13) {
               var15 = client.field515[var3];
               if(null != var15) {
                  client.field387 = var6;
                  client.field539 = var7;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field512 = var0;
                  client.field513 = var1;
                  client.field322.method2737(59);
                  client.field322.method2557(var3);
                  client.field322.method2590(class137.field2120[82]?1:0);
               }
            }

            if(14 == var2) {
               var16 = client.field491[var3];
               if(var16 != null) {
                  client.field387 = var6;
                  client.field539 = var7;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field512 = var0;
                  client.field513 = var1;
                  client.field322.method2737(138);
                  client.field322.method2587(class209.field3127);
                  client.field322.method2557(class162.field2657);
                  client.field322.method2525(var3);
                  client.field322.method2590(class137.field2120[82]?1:0);
                  client.field322.method2661(class25.field640);
               }
            }

            if(var2 == 57 || var2 == 1007) {
               var8 = class45.method932(var1, var0);
               if(var8 != null) {
                  var11 = var8.field2885;
                  class173 var18 = class45.method932(var1, var0);
                  if(var18 != null) {
                     if(null != var18.field2865) {
                        class0 var20 = new class0();
                        var20.field8 = var18;
                        var20.field5 = var3;
                        var20.field9 = var5;
                        var20.field12 = var18.field2865;
                        class16.method197(var20);
                     }

                     boolean var21 = true;
                     if(var18.field2887 > 0) {
                        var21 = class43.method891(var18);
                     }

                     if(var21 && class6.method97(class48.method962(var18), var3 - 1)) {
                        if(1 == var3) {
                           client.field322.method2737(147);
                           client.field322.method2480(var1);
                           client.field322.method2661(var0);
                           client.field322.method2661(var11);
                        }

                        if(2 == var3) {
                           client.field322.method2737(163);
                           client.field322.method2480(var1);
                           client.field322.method2661(var0);
                           client.field322.method2661(var11);
                        }

                        if(var3 == 3) {
                           client.field322.method2737(10);
                           client.field322.method2480(var1);
                           client.field322.method2661(var0);
                           client.field322.method2661(var11);
                        }

                        if(4 == var3) {
                           client.field322.method2737(202);
                           client.field322.method2480(var1);
                           client.field322.method2661(var0);
                           client.field322.method2661(var11);
                        }

                        if(5 == var3) {
                           client.field322.method2737(204);
                           client.field322.method2480(var1);
                           client.field322.method2661(var0);
                           client.field322.method2661(var11);
                        }

                        if(var3 == 6) {
                           client.field322.method2737(94);
                           client.field322.method2480(var1);
                           client.field322.method2661(var0);
                           client.field322.method2661(var11);
                        }

                        if(7 == var3) {
                           client.field322.method2737(129);
                           client.field322.method2480(var1);
                           client.field322.method2661(var0);
                           client.field322.method2661(var11);
                        }

                        if(var3 == 8) {
                           client.field322.method2737(139);
                           client.field322.method2480(var1);
                           client.field322.method2661(var0);
                           client.field322.method2661(var11);
                        }

                        if(9 == var3) {
                           client.field322.method2737(135);
                           client.field322.method2480(var1);
                           client.field322.method2661(var0);
                           client.field322.method2661(var11);
                        }

                        if(var3 == 10) {
                           client.field322.method2737(62);
                           client.field322.method2480(var1);
                           client.field322.method2661(var0);
                           client.field322.method2661(var11);
                        }
                     }
                  }
               }
            }

            if(23 == var2) {
               client.field339.method1932(class21.field581, var0, var1);
            }

            if(19 == var2) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(195);
               client.field322.method2477(class137.field2120[82]?1:0);
               client.field322.method2525(var1 + class114.field1981);
               client.field322.method2525(var3);
               client.field322.method2557(var0 + class22.field594);
            }

            if(49 == var2) {
               var16 = client.field491[var3];
               if(null != var16) {
                  client.field387 = var6;
                  client.field539 = var7;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field512 = var0;
                  client.field513 = var1;
                  client.field322.method2737(134);
                  client.field322.method2477(class137.field2120[82]?1:0);
                  client.field322.method2557(var3);
               }
            }

            if(45 == var2) {
               var16 = client.field491[var3];
               if(var16 != null) {
                  client.field387 = var6;
                  client.field539 = var7;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field512 = var0;
                  client.field513 = var1;
                  client.field322.method2737(176);
                  client.field322.method2624(var3);
                  client.field322.method2590(class137.field2120[82]?1:0);
               }
            }

            if(35 == var2) {
               client.field322.method2737(154);
               client.field322.method2525(var0);
               client.field322.method2480(var1);
               client.field322.method2661(var3);
               client.field391 = 0;
               class19.field274 = class29.method645(var1);
               client.field406 = var0;
            }

            if(2 == var2) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(144);
               client.field322.method2516(class137.field2120[82]?1:0);
               client.field322.method2661(client.field307);
               client.field322.method2525(var3 >> 14 & 32767);
               client.field322.method2480(class159.field2613);
               client.field322.method2525(var1 + class114.field1981);
               client.field322.method2624(var0 + class22.field594);
            }

            if(37 == var2) {
               client.field322.method2737(127);
               client.field322.method2661(var3);
               client.field322.method2494(var1);
               client.field322.method2525(var0);
               client.field391 = 0;
               class19.field274 = class29.method645(var1);
               client.field406 = var0;
            }

            if(var2 == 29) {
               client.field322.method2737(69);
               client.field322.method2480(var1);
               var8 = class29.method645(var1);
               if(null != var8.field2809 && 5 == var8.field2809[0][0]) {
                  var11 = var8.field2809[0][1];
                  if(var8.field2879[0] != class176.field2920[var11]) {
                     class176.field2920[var11] = var8.field2879[0];
                     class52.method1069(var11);
                  }
               }
            }

            if(var2 == 26) {
               client.field322.method2737(224);
               class3 var19 = (class3)client.field308.method3780();

               while(true) {
                  if(null == var19) {
                     if(client.field441 != null) {
                        class34.method701(client.field441);
                        client.field441 = null;
                     }
                     break;
                  }

                  if(var19.field62 == 0 || var19.field62 == 3) {
                     class38.method737(var19, true);
                  }

                  var19 = (class3)client.field308.method3781();
               }
            }

            if(12 == var2) {
               var15 = client.field515[var3];
               if(null != var15) {
                  client.field387 = var6;
                  client.field539 = var7;
                  client.field390 = 2;
                  client.field389 = 0;
                  client.field512 = var0;
                  client.field513 = var1;
                  client.field322.method2737(77);
                  client.field322.method2624(var3);
                  client.field322.method2477(class137.field2120[82]?1:0);
               }
            }

            if(var2 == 1001) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(67);
               client.field322.method2477(class137.field2120[82]?1:0);
               client.field322.method2557(var1 + class114.field1981);
               client.field322.method2557(class22.field594 + var0);
               client.field322.method2557(var3 >> 14 & 32767);
            }

            if(var2 == 1005) {
               var8 = class29.method645(var1);
               if(var8 != null && var8.field2884[var0] >= 100000) {
                  class125.method2783(27, "", var8.field2884[var0] + " x " + class9.method128(var3).field1128);
               } else {
                  client.field322.method2737(70);
                  client.field322.method2624(var3);
               }

               client.field391 = 0;
               class19.field274 = class29.method645(var1);
               client.field406 = var0;
            }

            if(var2 == 1002) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field322.method2737(45);
               client.field322.method2624(var3 >> 14 & 32767);
            }

            if(5 == var2) {
               client.field387 = var6;
               client.field539 = var7;
               client.field390 = 2;
               client.field389 = 0;
               client.field512 = var0;
               client.field513 = var1;
               client.field322.method2737(8);
               client.field322.method2557(var1 + class114.field1981);
               client.field322.method2590(class137.field2120[82]?1:0);
               client.field322.method2624(var0 + class22.field594);
               client.field322.method2525(var3 >> 14 & 32767);
            }

            if(client.field430 != 0) {
               client.field430 = 0;
               class34.method701(class29.method645(class209.field3127));
            }

            if(client.field432) {
               class22.method571();
            }

            if(class19.field274 != null && 0 == client.field391) {
               class34.method701(class19.field274);
            }
         }
      }

   }
}
