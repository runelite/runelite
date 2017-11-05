import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public class class204 extends class117 {
   @ObfuscatedName("bn")
   static String field2525;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   HashTable field2508;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2102268787
   )
   int field2507;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1022456845
   )
   int field2519;
   @ObfuscatedName("g")
   int[] field2509;
   @ObfuscatedName("v")
   int[] field2510;
   @ObfuscatedName("p")
   int[] field2511;
   @ObfuscatedName("e")
   int[] field2512;
   @ObfuscatedName("d")
   int[] field2513;
   @ObfuscatedName("x")
   int[] field2532;
   @ObfuscatedName("z")
   int[] field2515;
   @ObfuscatedName("n")
   int[] field2516;
   @ObfuscatedName("u")
   int[] field2517;
   @ObfuscatedName("y")
   int[] field2518;
   @ObfuscatedName("k")
   int[] field2523;
   @ObfuscatedName("c")
   int[] field2520;
   @ObfuscatedName("r")
   int[] field2521;
   @ObfuscatedName("m")
   int[] field2522;
   @ObfuscatedName("l")
   int[] field2514;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[[Lgu;"
   )
   class205[][] field2533;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "[[Lgu;"
   )
   class205[][] field2524;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   class206 field2526;
   @ObfuscatedName("aa")
   boolean field2506;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1000159841
   )
   int field2527;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1134396309
   )
   int field2529;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = -3596467412462900081L
   )
   long field2530;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      longValue = -5849732347804016439L
   )
   long field2531;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   class208 field2528;

   public class204() {
      this.field2507 = 256;
      this.field2519 = 1000000;
      this.field2509 = new int[16];
      this.field2510 = new int[16];
      this.field2511 = new int[16];
      this.field2512 = new int[16];
      this.field2513 = new int[16];
      this.field2532 = new int[16];
      this.field2515 = new int[16];
      this.field2516 = new int[16];
      this.field2517 = new int[16];
      this.field2518 = new int[16];
      this.field2523 = new int[16];
      this.field2520 = new int[16];
      this.field2521 = new int[16];
      this.field2522 = new int[16];
      this.field2514 = new int[16];
      this.field2533 = new class205[16][128];
      this.field2524 = new class205[16][128];
      this.field2526 = new class206();
      this.field2528 = new class208(this);
      this.field2508 = new HashTable(128);
      this.method3801();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "116"
   )
   public synchronized void method3834(int var1) {
      this.field2507 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "172987506"
   )
   int method3859() {
      return this.field2507;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhm;Lip;Ldt;II)Z",
      garbageValue = "-196634413"
   )
   public synchronized boolean method3783(Track1 var1, IndexDataBase var2, class110 var3, int var4) {
      var1.method3993();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(class199 var7 = (class199)var1.field2587.method3637(); var7 != null; var7 = (class199)var1.field2587.method3638()) {
         int var8 = (int)var7.hash;
         class207 var9 = (class207)this.field2508.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method4230(var8);
            class207 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class207(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field2508.put(var10, (long)var8);
         }

         if(!var9.method3955(var3, var7.field2479, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3994();
      }

      return var5;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-91"
   )
   public synchronized void method3784() {
      for(class207 var1 = (class207)this.field2508.method3637(); var1 != null; var1 = (class207)this.field2508.method3638()) {
         var1.method3956();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1616521554"
   )
   synchronized void method3785() {
      for(class207 var1 = (class207)this.field2508.method3637(); var1 != null; var1 = (class207)this.field2508.method3638()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldm;"
   )
   protected synchronized class117 vmethod3966() {
      return this.field2528;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Ldm;"
   )
   protected synchronized class117 vmethod3967() {
      return null;
   }

   @ObfuscatedName("e")
   protected synchronized int vmethod3974() {
      return 0;
   }

   @ObfuscatedName("d")
   protected synchronized void vmethod3968(int[] var1, int var2, int var3) {
      if(this.field2526.method3911()) {
         int var4 = this.field2526.field2557 * this.field2519 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = (long)var4 * (long)var3 + this.field2530;
            if(this.field2531 - var5 >= 0L) {
               this.field2530 = var5;
               break;
            }

            int var7 = (int)((this.field2531 - this.field2530 + (long)var4 - 1L) / (long)var4);
            this.field2530 += (long)var7 * (long)var4;
            this.field2528.vmethod3968(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3813();
         } while(this.field2526.method3911());
      }

      this.field2528.vmethod3968(var1, var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lhm;ZI)V",
      garbageValue = "701131705"
   )
   public synchronized void method3782(Track1 var1, boolean var2) {
      this.method3787();
      this.field2526.method3909(var1.field2588);
      this.field2506 = var2;
      this.field2530 = 0L;
      int var3 = this.field2526.method3912();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2526.method3913(var4);
         this.field2526.method3916(var4);
         this.field2526.method3907(var4);
      }

      this.field2527 = this.field2526.method3920();
      this.field2529 = this.field2526.field2560[this.field2527];
      this.field2531 = this.field2526.method3919(this.field2529);
   }

   @ObfuscatedName("u")
   protected synchronized void vmethod3981(int var1) {
      if(this.field2526.method3911()) {
         int var2 = this.field2526.field2557 * this.field2519 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = (long)var2 * (long)var1 + this.field2530;
            if(this.field2531 - var3 >= 0L) {
               this.field2530 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2531 - this.field2530) - 1L) / (long)var2);
            this.field2530 += (long)var5 * (long)var2;
            this.field2528.vmethod3981(var5);
            var1 -= var5;
            this.method3813();
         } while(this.field2526.method3911());
      }

      this.field2528.vmethod3981(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "33"
   )
   public synchronized void method3787() {
      this.field2526.method3910();
      this.method3801();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "991689224"
   )
   public synchronized boolean method3877() {
      return this.field2526.method3911();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1527668215"
   )
   public synchronized void method3860(int var1, int var2) {
      this.method3844(var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1492418555"
   )
   void method3844(int var1, int var2) {
      this.field2512[var1] = var2;
      this.field2532[var1] = var2 & -128;
      this.method3791(var1, var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "114"
   )
   void method3791(int var1, int var2) {
      if(var2 != this.field2513[var1]) {
         this.field2513[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2524[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "26"
   )
   void method3792(int var1, int var2, int var3) {
      this.method3889(var1, var2, 64);
      if((this.field2518[var1] & 2) != 0) {
         for(class205 var4 = (class205)this.field2528.field2582.getTail(); var4 != null; var4 = (class205)this.field2528.field2582.getPrevious()) {
            if(var4.field2549 == var1 && var4.field2544 < 0) {
               this.field2533[var1][var4.field2539] = null;
               this.field2533[var1][var2] = var4;
               int var5 = (var4.field2534 * var4.field2542 >> 12) + var4.field2541;
               var4.field2541 += var2 - var4.field2539 << 8;
               var4.field2542 = var5 - var4.field2541;
               var4.field2534 = 4096;
               var4.field2539 = var2;
               return;
            }
         }
      }

      class207 var9 = (class207)this.field2508.get((long)this.field2513[var1]);
      if(var9 != null) {
         class105 var8 = var9.field2571[var2];
         if(var8 != null) {
            class205 var6 = new class205();
            var6.field2549 = var1;
            var6.field2551 = var9;
            var6.field2536 = var8;
            var6.field2537 = var9.field2574[var2];
            var6.field2538 = var9.field2572[var2];
            var6.field2539 = var2;
            var6.field2540 = var3 * var3 * var9.field2573[var2] * var9.field2576 + 1024 >> 11;
            var6.field2543 = var9.field2570[var2] & 255;
            var6.field2541 = (var2 << 8) - (var9.field2575[var2] & 32767);
            var6.field2545 = 0;
            var6.field2546 = 0;
            var6.field2547 = 0;
            var6.field2544 = -1;
            var6.field2548 = 0;
            if(this.field2521[var1] == 0) {
               var6.field2552 = class115.method2173(var8, this.method3805(var6), this.method3885(var6), this.method3807(var6));
            } else {
               var6.field2552 = class115.method2173(var8, this.method3805(var6), 0, this.method3807(var6));
               this.method3793(var6, var9.field2575[var2] < 0);
            }

            if(var9.field2575[var2] < 0) {
               var6.field2552.method2175(-1);
            }

            if(var6.field2538 >= 0) {
               class205 var7 = this.field2524[var1][var6.field2538];
               if(var7 != null && var7.field2544 < 0) {
                  this.field2533[var1][var7.field2539] = null;
                  var7.field2544 = 0;
               }

               this.field2524[var1][var6.field2538] = var6;
            }

            this.field2528.field2582.addFront(var6);
            this.field2533[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgu;ZI)V",
      garbageValue = "-1625191582"
   )
   void method3793(class205 var1, boolean var2) {
      int var3 = var1.field2536.field1600.length;
      int var4;
      if(var2 && var1.field2536.field1603) {
         int var5 = var3 + var3 - var1.field2536.field1599;
         var4 = (int)((long)this.field2521[var1.field2549] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2552.method2251();
         }
      } else {
         var4 = (int)((long)this.field2521[var1.field2549] * (long)var3 >> 6);
      }

      var1.field2552.method2181(var4);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "0"
   )
   void method3889(int var1, int var2, int var3) {
      class205 var4 = this.field2533[var1][var2];
      if(var4 != null) {
         this.field2533[var1][var2] = null;
         if((this.field2518[var1] & 2) != 0) {
            for(class205 var5 = (class205)this.field2528.field2582.getFront(); var5 != null; var5 = (class205)this.field2528.field2582.getNext()) {
               if(var5.field2549 == var4.field2549 && var5.field2544 < 0 && var4 != var5) {
                  var4.field2544 = 0;
                  break;
               }
            }
         } else {
            var4.field2544 = 0;
         }

      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-72"
   )
   void method3795(int var1, int var2, int var3) {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "139516247"
   )
   void method3811(int var1, int var2) {
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "656516911"
   )
   void method3794(int var1, int var2) {
      this.field2515[var1] = var2;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "538498769"
   )
   void method3798(int var1) {
      for(class205 var2 = (class205)this.field2528.field2582.getFront(); var2 != null; var2 = (class205)this.field2528.field2582.getNext()) {
         if(var1 < 0 || var2.field2549 == var1) {
            if(var2.field2552 != null) {
               var2.field2552.method2186(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2552.method2259()) {
                  this.field2528.field2583.method1919(var2.field2552);
               }

               var2.method3903();
            }

            if(var2.field2544 < 0) {
               this.field2533[var2.field2549][var2.field2539] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1154347389"
   )
   void method3799(int var1) {
      if(var1 >= 0) {
         this.field2509[var1] = 12800;
         this.field2510[var1] = 8192;
         this.field2511[var1] = 16383;
         this.field2515[var1] = 8192;
         this.field2516[var1] = 0;
         this.field2517[var1] = 8192;
         this.method3802(var1);
         this.method3803(var1);
         this.field2518[var1] = 0;
         this.field2523[var1] = 32767;
         this.field2520[var1] = 256;
         this.field2521[var1] = 0;
         this.method3780(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3799(var1);
         }

      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "29443"
   )
   void method3800(int var1) {
      for(class205 var2 = (class205)this.field2528.field2582.getFront(); var2 != null; var2 = (class205)this.field2528.field2582.getNext()) {
         if((var1 < 0 || var2.field2549 == var1) && var2.field2544 < 0) {
            this.field2533[var2.field2549][var2.field2539] = null;
            var2.field2544 = 0;
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-24"
   )
   void method3801() {
      this.method3798(-1);
      this.method3799(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2513[var1] = this.field2512[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2532[var1] = this.field2512[var1] & -128;
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-835310820"
   )
   void method3802(int var1) {
      if((this.field2518[var1] & 2) != 0) {
         for(class205 var2 = (class205)this.field2528.field2582.getFront(); var2 != null; var2 = (class205)this.field2528.field2582.getNext()) {
            if(var2.field2549 == var1 && this.field2533[var1][var2.field2539] == null && var2.field2544 < 0) {
               var2.field2544 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1005615803"
   )
   void method3803(int var1) {
      if((this.field2518[var1] & 4) != 0) {
         for(class205 var2 = (class205)this.field2528.field2582.getFront(); var2 != null; var2 = (class205)this.field2528.field2582.getNext()) {
            if(var2.field2549 == var1) {
               var2.field2554 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void method3804(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3889(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3792(var3, var4, var5);
         } else {
            this.method3889(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3795(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2532[var3] = (var5 << 14) + (this.field2532[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2532[var3] = (var5 << 7) + (this.field2532[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2516[var3] = (var5 << 7) + (this.field2516[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2516[var3] = var5 + (this.field2516[var3] & -128);
         }

         if(var4 == 5) {
            this.field2517[var3] = (var5 << 7) + (this.field2517[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2517[var3] = var5 + (this.field2517[var3] & -128);
         }

         if(var4 == 7) {
            this.field2509[var3] = (var5 << 7) + (this.field2509[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2509[var3] = var5 + (this.field2509[var3] & -128);
         }

         if(var4 == 10) {
            this.field2510[var3] = (var5 << 7) + (this.field2510[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2510[var3] = var5 + (this.field2510[var3] & -128);
         }

         if(var4 == 11) {
            this.field2511[var3] = (var5 << 7) + (this.field2511[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2511[var3] = var5 + (this.field2511[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2518[var3] |= 1;
            } else {
               this.field2518[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2518[var3] |= 2;
            } else {
               this.method3802(var3);
               this.field2518[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2523[var3] = (var5 << 7) + (this.field2523[var3] & 127);
         }

         if(var4 == 98) {
            this.field2523[var3] = (this.field2523[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2523[var3] = (var5 << 7) + (this.field2523[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2523[var3] = (this.field2523[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3798(var3);
         }

         if(var4 == 121) {
            this.method3799(var3);
         }

         if(var4 == 123) {
            this.method3800(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2523[var3];
            if(var6 == 16384) {
               this.field2520[var3] = (var5 << 7) + (this.field2520[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2523[var3];
            if(var6 == 16384) {
               this.field2520[var3] = var5 + (this.field2520[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2521[var3] = (var5 << 7) + (this.field2521[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2521[var3] = var5 + (this.field2521[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2518[var3] |= 4;
            } else {
               this.method3803(var3);
               this.field2518[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3780(var3, (var5 << 7) + (this.field2522[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3780(var3, var5 + (this.field2522[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3791(var3, var4 + this.field2532[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3811(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3794(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3801();
         }
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2107173572"
   )
   void method3780(int var1, int var2) {
      this.field2522[var1] = var2;
      this.field2514[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lgu;I)I",
      garbageValue = "-699691281"
   )
   int method3805(class205 var1) {
      int var2 = (var1.field2534 * var1.field2542 >> 12) + var1.field2541;
      var2 += (this.field2515[var1.field2549] - 8192) * this.field2520[var1.field2549] >> 12;
      class202 var3 = var1.field2537;
      int var4;
      if(var3.field2492 > 0 && (var3.field2490 > 0 || this.field2516[var1.field2549] > 0)) {
         var4 = var3.field2490 << 2;
         int var5 = var3.field2493 << 1;
         if(var1.field2550 < var5) {
            var4 = var4 * var1.field2550 / var5;
         }

         var4 += this.field2516[var1.field2549] >> 7;
         double var6 = Math.sin((double)(var1.field2553 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2536.field1602 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lgu;I)I",
      garbageValue = "-1915505874"
   )
   int method3885(class205 var1) {
      class202 var2 = var1.field2537;
      int var3 = this.field2511[var1.field2549] * this.field2509[var1.field2549] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2540 + 16384 >> 15;
      var3 = var3 * this.field2507 + 128 >> 8;
      if(var2.field2486 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2486 * (double)var1.field2545 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2488 != null) {
         var4 = var1.field2546;
         var5 = var2.field2488[var1.field2547 + 1];
         if(var1.field2547 < var2.field2488.length - 2) {
            var6 = (var2.field2488[var1.field2547] & 255) << 8;
            var7 = (var2.field2488[var1.field2547 + 2] & 255) << 8;
            var5 += (var2.field2488[var1.field2547 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2544 > 0 && var2.field2485 != null) {
         var4 = var1.field2544;
         var5 = var2.field2485[var1.field2548 + 1];
         if(var1.field2548 < var2.field2485.length - 2) {
            var6 = (var2.field2485[var1.field2548] & 255) << 8;
            var7 = (var2.field2485[var1.field2548 + 2] & 255) << 8;
            var5 += (var2.field2485[var1.field2548 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lgu;I)I",
      garbageValue = "-694893681"
   )
   int method3807(class205 var1) {
      int var2 = this.field2510[var1.field2549];
      return var2 < 8192?var2 * var1.field2543 + 32 >> 6:16384 - ((128 - var1.field2543) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2112390480"
   )
   void method3813() {
      int var1 = this.field2527;
      int var2 = this.field2529;

      long var3;
      for(var3 = this.field2531; var2 == this.field2529; var3 = this.field2526.method3919(var2)) {
         while(var2 == this.field2526.field2560[var1]) {
            this.field2526.method3913(var1);
            int var5 = this.field2526.method3943(var1);
            if(var5 == 1) {
               this.field2526.method3915();
               this.field2526.method3907(var1);
               if(this.field2526.method3921()) {
                  if(!this.field2506 || var2 == 0) {
                     this.method3801();
                     this.field2526.method3910();
                     return;
                  }

                  this.field2526.method3922(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3804(var5);
            }

            this.field2526.method3916(var1);
            this.field2526.method3907(var1);
         }

         var1 = this.field2526.method3920();
         var2 = this.field2526.field2560[var1];
      }

      this.field2527 = var1;
      this.field2529 = var2;
      this.field2531 = var3;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(Lgu;I)Z",
      garbageValue = "-47332412"
   )
   boolean method3788(class205 var1) {
      if(var1.field2552 == null) {
         if(var1.field2544 >= 0) {
            var1.unlink();
            if(var1.field2538 > 0 && var1 == this.field2524[var1.field2549][var1.field2538]) {
               this.field2524[var1.field2549][var1.field2538] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(Lgu;[IIII)Z",
      garbageValue = "-236670592"
   )
   boolean method3806(class205 var1, int[] var2, int var3, int var4) {
      var1.field2535 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2544 < 0 || var1.field2552 != null && !var1.field2552.method2189()) {
         int var5 = var1.field2534;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2517[var1.field2549]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2534 = var5;
         }

         var1.field2552.method2187(this.method3805(var1));
         class202 var6 = var1.field2537;
         boolean var7 = false;
         ++var1.field2550;
         var1.field2553 += var6.field2492;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2539 - 60 << 8) + (var1.field2534 * var1.field2542 >> 12));
         if(var6.field2486 > 0) {
            if(var6.field2489 > 0) {
               var1.field2545 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2489 * var8) + 0.5D);
            } else {
               var1.field2545 += 128;
            }
         }

         if(var6.field2488 != null) {
            if(var6.field2487 > 0) {
               var1.field2546 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2487) + 0.5D);
            } else {
               var1.field2546 += 128;
            }

            while(var1.field2547 < var6.field2488.length - 2 && var1.field2546 > (var6.field2488[var1.field2547 + 2] & 255) << 8) {
               var1.field2547 += 2;
            }

            if(var6.field2488.length - 2 == var1.field2547 && var6.field2488[var1.field2547 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2544 >= 0 && var6.field2485 != null && (this.field2518[var1.field2549] & 1) == 0 && (var1.field2538 < 0 || var1 != this.field2524[var1.field2549][var1.field2538])) {
            if(var6.field2491 > 0) {
               var1.field2544 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2491) + 0.5D);
            } else {
               var1.field2544 += 128;
            }

            while(var1.field2548 < var6.field2485.length - 2 && var1.field2544 > (var6.field2485[var1.field2548 + 2] & 255) << 8) {
               var1.field2548 += 2;
            }

            if(var6.field2485.length - 2 == var1.field2548) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2552.method2186(var1.field2535);
            if(var2 != null) {
               var1.field2552.vmethod3968(var2, var3, var4);
            } else {
               var1.field2552.vmethod3981(var4);
            }

            if(var1.field2552.method2259()) {
               this.field2528.field2583.method1919(var1.field2552);
            }

            var1.method3903();
            if(var1.field2544 >= 0) {
               var1.unlink();
               if(var1.field2538 > 0 && var1 == this.field2524[var1.field2549][var1.field2538]) {
                  this.field2524[var1.field2549][var1.field2538] = null;
               }
            }

            return true;
         } else {
            var1.field2552.method2185(var1.field2535, this.method3885(var1), this.method3807(var1));
            return false;
         }
      } else {
         var1.method3903();
         var1.unlink();
         if(var1.field2538 > 0 && var1 == this.field2524[var1.field2549][var1.field2538]) {
            this.field2524[var1.field2549][var1.field2538] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgk;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1834082589"
   )
   static String method3902(IterableHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.value;
      }
   }
}
