import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class204 extends class119 {
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 2100412377
   )
   int field2494;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1964459421
   )
   int field2489;
   @ObfuscatedName("z")
   int[] field2482;
   @ObfuscatedName("k")
   int[] field2486;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   XHashTable field2477;
   @ObfuscatedName("x")
   int[] field2478;
   @ObfuscatedName("g")
   int[] field2479;
   @ObfuscatedName("s")
   int[] field2483;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[[Lgz;"
   )
   class205[][] field2496;
   @ObfuscatedName("q")
   int[] field2490;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   class206 field2481;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   class208 field2504;
   @ObfuscatedName("u")
   int[] field2480;
   @ObfuscatedName("m")
   int[] field2493;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1186659739
   )
   int field2501;
   @ObfuscatedName("b")
   int[] field2495;
   @ObfuscatedName("p")
   int[] field2485;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      longValue = -2069096701629662515L
   )
   long field2500;
   @ObfuscatedName("n")
   int[] field2484;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -624122463
   )
   int field2502;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "[[Lgz;"
   )
   class205[][] field2497;
   @ObfuscatedName("am")
   boolean field2499;
   @ObfuscatedName("j")
   int[] field2492;
   @ObfuscatedName("v")
   int[] field2488;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      longValue = -1537700823561036085L
   )
   long field2498;
   @ObfuscatedName("r")
   int[] field2487;
   @ObfuscatedName("f")
   int[] field2491;

   public class204() {
      this.field2489 = 256;
      this.field2502 = 1000000;
      this.field2480 = new int[16];
      this.field2479 = new int[16];
      this.field2493 = new int[16];
      this.field2483 = new int[16];
      this.field2478 = new int[16];
      this.field2485 = new int[16];
      this.field2486 = new int[16];
      this.field2487 = new int[16];
      this.field2488 = new int[16];
      this.field2490 = new int[16];
      this.field2491 = new int[16];
      this.field2492 = new int[16];
      this.field2484 = new int[16];
      this.field2482 = new int[16];
      this.field2495 = new int[16];
      this.field2496 = new class205[16][128];
      this.field2497 = new class205[16][128];
      this.field2481 = new class206();
      this.field2504 = new class208(this);
      this.field2477 = new XHashTable(128);
      this.method3662();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2146611454"
   )
   void method3651(int var1, int var2) {
      this.field2483[var1] = var2;
      this.field2485[var1] = var2 & -128;
      this.method3652(var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "26"
   )
   void method3655(int var1, int var2, int var3) {
      class205 var4 = this.field2496[var1][var2];
      if(var4 != null) {
         this.field2496[var1][var2] = null;
         if((this.field2490[var1] & 2) != 0) {
            for(class205 var5 = (class205)this.field2504.field2555.getFront(); var5 != null; var5 = (class205)this.field2504.field2555.getNext()) {
               if(var5.field2526 == var4.field2526 && var5.field2522 < 0 && var5 != var4) {
                  var4.field2522 = 0;
                  break;
               }
            }
         } else {
            var4.field2522 = 0;
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2059149927"
   )
   void method3659(int var1) {
      for(class205 var2 = (class205)this.field2504.field2555.getFront(); var2 != null; var2 = (class205)this.field2504.field2555.getNext()) {
         if(var1 < 0 || var2.field2526 == var1) {
            if(var2.field2510 != null) {
               var2.field2510.method2068(CombatInfo1.sampleRate / 100);
               if(var2.field2510.method2072()) {
                  this.field2504.field2556.method1808(var2.field2510);
               }

               var2.method3755();
            }

            if(var2.field2522 < 0) {
               this.field2496[var2.field2526][var2.field2513] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "247287340"
   )
   public synchronized void method3648() {
      this.field2481.method3766();
      this.method3662();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "801384574"
   )
   void method3660(int var1) {
      if(var1 >= 0) {
         this.field2480[var1] = 12800;
         this.field2479[var1] = 8192;
         this.field2493[var1] = 16383;
         this.field2486[var1] = 8192;
         this.field2487[var1] = 0;
         this.field2488[var1] = 8192;
         this.method3663(var1);
         this.method3664(var1);
         this.field2490[var1] = 0;
         this.field2491[var1] = 32767;
         this.field2492[var1] = 256;
         this.field2484[var1] = 0;
         this.method3666(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3660(var1);
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2120237789"
   )
   void method3728(int var1, int var2, int var3) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "-6992"
   )
   void method3745(int var1, int var2, int var3) {
      this.method3655(var1, var2, 64);
      if((this.field2490[var1] & 2) != 0) {
         for(class205 var4 = (class205)this.field2504.field2555.getTail(); var4 != null; var4 = (class205)this.field2504.field2555.getPrevious()) {
            if(var4.field2526 == var1 && var4.field2522 < 0) {
               this.field2496[var1][var4.field2513] = null;
               this.field2496[var1][var2] = var4;
               int var5 = (var4.field2518 * var4.field2508 >> 12) + var4.field2516;
               var4.field2516 += var2 - var4.field2513 << 8;
               var4.field2508 = var5 - var4.field2516;
               var4.field2518 = 4096;
               var4.field2513 = var2;
               return;
            }
         }
      }

      class207 var9 = (class207)this.field2477.get((long)this.field2478[var1]);
      if(var9 != null) {
         class107 var8 = var9.field2547[var2];
         if(var8 != null) {
            class205 var6 = new class205();
            var6.field2526 = var1;
            var6.field2509 = var9;
            var6.field2517 = var8;
            var6.field2511 = var9.field2549[var2];
            var6.field2527 = var9.field2550[var2];
            var6.field2513 = var2;
            var6.field2514 = var3 * var3 * var9.field2544[var2] * var9.field2546 + 1024 >> 11;
            var6.field2515 = var9.field2545[var2] & 255;
            var6.field2516 = (var2 << 8) - (var9.field2548[var2] & 32767);
            var6.field2519 = 0;
            var6.field2520 = 0;
            var6.field2521 = 0;
            var6.field2522 = -1;
            var6.field2525 = 0;
            if(this.field2484[var1] == 0) {
               var6.field2510 = class117.method2055(var8, this.method3705(var6), this.method3668(var6), this.method3669(var6));
            } else {
               var6.field2510 = class117.method2055(var8, this.method3705(var6), 0, this.method3669(var6));
               this.method3654(var6, var9.field2548[var2] < 0);
            }

            if(var9.field2548[var2] < 0) {
               var6.field2510.method2057(-1);
            }

            if(var6.field2527 >= 0) {
               class205 var7 = this.field2497[var1][var6.field2527];
               if(var7 != null && var7.field2522 < 0) {
                  this.field2496[var1][var7.field2513] = null;
                  var7.field2522 = 0;
               }

               this.field2497[var1][var6.field2527] = var6;
            }

            this.field2504.field2555.addFront(var6);
            this.field2496[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "875225137"
   )
   void method3662() {
      this.method3659(-1);
      this.method3660(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2478[var1] = this.field2483[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2485[var1] = this.field2483[var1] & -128;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1436552181"
   )
   void method3652(int var1, int var2) {
      if(var2 != this.field2478[var1]) {
         this.field2478[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2497[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("p")
   protected synchronized void vmethod3826(int[] var1, int var2, int var3) {
      if(this.field2481.method3788()) {
         int var4 = this.field2481.field2533 * this.field2502 / CombatInfo1.sampleRate;

         do {
            long var5 = this.field2498 + (long)var4 * (long)var3;
            if(this.field2500 - var5 >= 0L) {
               this.field2498 = var5;
               break;
            }

            int var7 = (int)((this.field2500 - this.field2498 + (long)var4 - 1L) / (long)var4);
            this.field2498 += (long)var4 * (long)var7;
            this.field2504.vmethod3826(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3675();
         } while(this.field2481.method3788());
      }

      this.field2504.vmethod3826(var1, var2, var3);
   }

   @ObfuscatedName("r")
   protected synchronized void vmethod3827(int var1) {
      if(this.field2481.method3788()) {
         int var2 = this.field2481.field2533 * this.field2502 / CombatInfo1.sampleRate;

         do {
            long var3 = this.field2498 + (long)var1 * (long)var2;
            if(this.field2500 - var3 >= 0L) {
               this.field2498 = var3;
               break;
            }

            int var5 = (int)((this.field2500 - this.field2498 + (long)var2 - 1L) / (long)var2);
            this.field2498 += (long)var2 * (long)var5;
            this.field2504.vmethod3827(var5);
            var1 -= var5;
            this.method3675();
         } while(this.field2481.method3788());
      }

      this.field2504.vmethod3827(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "604935281"
   )
   void method3753(int var1, int var2) {
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-164963169"
   )
   void method3700(int var1, int var2) {
      this.field2486[var1] = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected synchronized class119 vmethod3835() {
      return null;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lgz;I)I",
      garbageValue = "-128151989"
   )
   int method3705(class205 var1) {
      int var2 = var1.field2516 + (var1.field2518 * var1.field2508 >> 12);
      var2 += (this.field2486[var1.field2526] - 8192) * this.field2492[var1.field2526] >> 12;
      class202 var3 = var1.field2511;
      int var4;
      if(var3.field2466 > 0 && (var3.field2464 > 0 || this.field2487[var1.field2526] > 0)) {
         var4 = var3.field2464 << 2;
         int var5 = var3.field2465 << 1;
         if(var1.field2524 < var5) {
            var4 = var4 * var1.field2524 / var5;
         }

         var4 += this.field2487[var1.field2526] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2512 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2517.field1579 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)CombatInfo1.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lht;Lip;Ldt;IB)Z",
      garbageValue = "21"
   )
   public synchronized boolean method3644(Track1 var1, IndexDataBase var2, class112 var3, int var4) {
      var1.method3845();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(class199 var7 = (class199)var1.field2563.method3492(); var7 != null; var7 = (class199)var1.field2563.method3493()) {
         int var8 = (int)var7.hash;
         class207 var9 = (class207)this.field2477.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method4014(var8);
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

            this.field2477.put(var10, (long)var8);
         }

         if(!var9.method3815(var3, var7.field2452, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3846();
      }

      return var5;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lgz;I)Z",
      garbageValue = "1559258294"
   )
   boolean method3676(class205 var1) {
      if(var1.field2510 == null) {
         if(var1.field2522 >= 0) {
            var1.unlink();
            if(var1.field2527 > 0 && var1 == this.field2497[var1.field2526][var1.field2527]) {
               this.field2497[var1.field2526][var1.field2527] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "302459700"
   )
   void method3663(int var1) {
      if((this.field2490[var1] & 2) != 0) {
         for(class205 var2 = (class205)this.field2504.field2555.getFront(); var2 != null; var2 = (class205)this.field2504.field2555.getNext()) {
            if(var2.field2526 == var1 && this.field2496[var1][var2.field2513] == null && var2.field2522 < 0) {
               var2.field2522 = 0;
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "743267930"
   )
   public int method3643() {
      return this.field2489;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "61605139"
   )
   void method3664(int var1) {
      if((this.field2490[var1] & 4) != 0) {
         for(class205 var2 = (class205)this.field2504.field2555.getFront(); var2 != null; var2 = (class205)this.field2504.field2555.getNext()) {
            if(var2.field2526 == var1) {
               var2.field2528 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1852525675"
   )
   void method3661(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3655(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3745(var3, var4, var5);
         } else {
            this.method3655(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3728(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2485[var3] = (var5 << 14) + (this.field2485[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2485[var3] = (var5 << 7) + (this.field2485[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2487[var3] = (var5 << 7) + (this.field2487[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2487[var3] = var5 + (this.field2487[var3] & -128);
         }

         if(var4 == 5) {
            this.field2488[var3] = (var5 << 7) + (this.field2488[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2488[var3] = var5 + (this.field2488[var3] & -128);
         }

         if(var4 == 7) {
            this.field2480[var3] = (var5 << 7) + (this.field2480[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2480[var3] = var5 + (this.field2480[var3] & -128);
         }

         if(var4 == 10) {
            this.field2479[var3] = (var5 << 7) + (this.field2479[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2479[var3] = var5 + (this.field2479[var3] & -128);
         }

         if(var4 == 11) {
            this.field2493[var3] = (var5 << 7) + (this.field2493[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2493[var3] = var5 + (this.field2493[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2490[var3] |= 1;
            } else {
               this.field2490[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2490[var3] |= 2;
            } else {
               this.method3663(var3);
               this.field2490[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2491[var3] = (var5 << 7) + (this.field2491[var3] & 127);
         }

         if(var4 == 98) {
            this.field2491[var3] = (this.field2491[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2491[var3] = (var5 << 7) + (this.field2491[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2491[var3] = (this.field2491[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3659(var3);
         }

         if(var4 == 121) {
            this.method3660(var3);
         }

         if(var4 == 123) {
            this.method3667(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2491[var3];
            if(var6 == 16384) {
               this.field2492[var3] = (var5 << 7) + (this.field2492[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2491[var3];
            if(var6 == 16384) {
               this.field2492[var3] = var5 + (this.field2492[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2484[var3] = (var5 << 7) + (this.field2484[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2484[var3] = var5 + (this.field2484[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2490[var3] |= 4;
            } else {
               this.method3664(var3);
               this.field2490[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3666(var3, (var5 << 7) + (this.field2482[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3666(var3, var5 + (this.field2482[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3652(var3, var4 + this.field2485[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3753(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3700(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3662();
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1545458490"
   )
   public synchronized boolean method3649() {
      return this.field2481.method3788();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1144095247"
   )
   public synchronized void method3691() {
      for(class207 var1 = (class207)this.field2477.method3492(); var1 != null; var1 = (class207)this.field2477.method3493()) {
         var1.method3816();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1783042948"
   )
   public synchronized void method3646() {
      for(class207 var1 = (class207)this.field2477.method3492(); var1 != null; var1 = (class207)this.field2477.method3493()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lgz;[IIIB)Z",
      garbageValue = "-29"
   )
   boolean method3677(class205 var1, int[] var2, int var3, int var4) {
      var1.field2523 = CombatInfo1.sampleRate / 100;
      if(var1.field2522 < 0 || var1.field2510 != null && !var1.field2510.method2071()) {
         int var5 = var1.field2518;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2488[var1.field2526] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2518 = var5;
         }

         var1.field2510.method2182(this.method3705(var1));
         class202 var6 = var1.field2511;
         boolean var7 = false;
         ++var1.field2524;
         var1.field2512 += var6.field2466;
         double var8 = (double)((var1.field2508 * var1.field2518 >> 12) + (var1.field2513 - 60 << 8)) * 5.086263020833333E-6D;
         if(var6.field2459 > 0) {
            if(var6.field2462 > 0) {
               var1.field2519 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2462) + 0.5D);
            } else {
               var1.field2519 += 128;
            }
         }

         if(var6.field2467 != null) {
            if(var6.field2460 > 0) {
               var1.field2520 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2460) + 0.5D);
            } else {
               var1.field2520 += 128;
            }

            while(var1.field2521 < var6.field2467.length - 2 && var1.field2520 > (var6.field2467[var1.field2521 + 2] & 255) << 8) {
               var1.field2521 += 2;
            }

            if(var6.field2467.length - 2 == var1.field2521 && var6.field2467[var1.field2521 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2522 >= 0 && var6.field2458 != null && (this.field2490[var1.field2526] & 1) == 0 && (var1.field2527 < 0 || var1 != this.field2497[var1.field2526][var1.field2527])) {
            if(var6.field2461 > 0) {
               var1.field2522 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2461) + 0.5D);
            } else {
               var1.field2522 += 128;
            }

            while(var1.field2525 < var6.field2458.length - 2 && var1.field2522 > (var6.field2458[var1.field2525 + 2] & 255) << 8) {
               var1.field2525 += 2;
            }

            if(var6.field2458.length - 2 == var1.field2525) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2510.method2068(var1.field2523);
            if(var2 != null) {
               var1.field2510.vmethod3826(var2, var3, var4);
            } else {
               var1.field2510.vmethod3827(var4);
            }

            if(var1.field2510.method2072()) {
               this.field2504.field2556.method1808(var1.field2510);
            }

            var1.method3755();
            if(var1.field2522 >= 0) {
               var1.unlink();
               if(var1.field2527 > 0 && var1 == this.field2497[var1.field2526][var1.field2527]) {
                  this.field2497[var1.field2526][var1.field2527] = null;
               }
            }

            return true;
         } else {
            var1.field2510.method2170(var1.field2523, this.method3668(var1), this.method3669(var1));
            return false;
         }
      } else {
         var1.method3755();
         var1.unlink();
         if(var1.field2527 > 0 && var1 == this.field2497[var1.field2526][var1.field2527]) {
            this.field2497[var1.field2526][var1.field2527] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-38561235"
   )
   public synchronized void method3642(int var1) {
      this.field2489 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected synchronized class119 vmethod3823() {
      return this.field2504;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "101"
   )
   void method3666(int var1, int var2) {
      this.field2482[var1] = var2;
      this.field2495[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lht;ZI)V",
      garbageValue = "1068580186"
   )
   public synchronized void method3647(Track1 var1, boolean var2) {
      this.method3648();
      this.field2481.method3764(var1.field2564);
      this.field2499 = var2;
      this.field2498 = 0L;
      int var3 = this.field2481.method3767();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2481.method3798(var4);
         this.field2481.method3771(var4);
         this.field2481.method3763(var4);
      }

      this.field2494 = this.field2481.method3776();
      this.field2501 = this.field2481.field2538[this.field2494];
      this.field2500 = this.field2481.method3775(this.field2501);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1164323725"
   )
   void method3675() {
      int var1 = this.field2494;
      int var2 = this.field2501;

      long var3;
      for(var3 = this.field2500; var2 == this.field2501; var3 = this.field2481.method3775(var2)) {
         while(var2 == this.field2481.field2538[var1]) {
            this.field2481.method3798(var1);
            int var5 = this.field2481.method3772(var1);
            if(var5 == 1) {
               this.field2481.method3770();
               this.field2481.method3763(var1);
               if(this.field2481.method3777()) {
                  if(!this.field2499 || var2 == 0) {
                     this.method3662();
                     this.field2481.method3766();
                     return;
                  }

                  this.field2481.method3778(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3661(var5);
            }

            this.field2481.method3771(var1);
            this.field2481.method3763(var1);
         }

         var1 = this.field2481.method3776();
         var2 = this.field2481.field2538[var1];
      }

      this.field2494 = var1;
      this.field2501 = var2;
      this.field2500 = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgz;ZI)V",
      garbageValue = "-370854875"
   )
   void method3654(class205 var1, boolean var2) {
      int var3 = var1.field2517.field1576.length;
      int var4;
      if(var2 && var1.field2517.field1575) {
         int var5 = var3 + var3 - var1.field2517.field1577;
         var4 = (int)((long)var5 * (long)this.field2484[var1.field2526] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2510.method2064();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2484[var1.field2526] >> 6);
      }

      var1.field2510.method2063(var4);
   }

   @ObfuscatedName("x")
   protected synchronized int vmethod3825() {
      return 0;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lgz;I)I",
      garbageValue = "-80801374"
   )
   int method3668(class205 var1) {
      class202 var2 = var1.field2511;
      int var3 = this.field2493[var1.field2526] * this.field2480[var1.field2526] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2514 + 16384 >> 15;
      var3 = var3 * this.field2489 + 128 >> 8;
      if(var2.field2459 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field2519 * 1.953125E-5D * (double)var2.field2459) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2467 != null) {
         var4 = var1.field2520;
         var5 = var2.field2467[var1.field2521 + 1];
         if(var1.field2521 < var2.field2467.length - 2) {
            var6 = (var2.field2467[var1.field2521] & 255) << 8;
            var7 = (var2.field2467[var1.field2521 + 2] & 255) << 8;
            var5 += (var2.field2467[var1.field2521 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2522 > 0 && var2.field2458 != null) {
         var4 = var1.field2522;
         var5 = var2.field2458[var1.field2525 + 1];
         if(var1.field2525 < var2.field2458.length - 2) {
            var6 = (var2.field2458[var1.field2525] & 255) << 8;
            var7 = (var2.field2458[var1.field2525 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2458[var1.field2525 + 3] - var5) / (var7 - var6);
         }

         var3 = 32 + var3 * var5 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lgz;B)I",
      garbageValue = "94"
   )
   int method3669(class205 var1) {
      int var2 = this.field2479[var1.field2526];
      return var2 < 8192?32 + var2 * var1.field2515 >> 6:16384 - ((128 - var1.field2515) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "37"
   )
   public synchronized void method3650(int var1, int var2) {
      this.method3651(var1, var2);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "23"
   )
   void method3667(int var1) {
      for(class205 var2 = (class205)this.field2504.field2555.getFront(); var2 != null; var2 = (class205)this.field2504.field2555.getNext()) {
         if((var1 < 0 || var2.field2526 == var1) && var2.field2522 < 0) {
            this.field2496[var2.field2526][var2.field2513] = null;
            var2.field2522 = 0;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "42"
   )
   static final void method3645(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class17.method115(var7, var9, var8, var10, -49088);
   }
}
