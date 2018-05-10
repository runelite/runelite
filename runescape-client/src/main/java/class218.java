import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class218 extends TaskDataNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   HashTable field2514;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1364864855
   )
   int field2492;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 993609467
   )
   int field2513;
   @ObfuscatedName("f")
   int[] field2491;
   @ObfuscatedName("n")
   int[] field2495;
   @ObfuscatedName("h")
   int[] field2496;
   @ObfuscatedName("x")
   int[] field2497;
   @ObfuscatedName("j")
   int[] field2493;
   @ObfuscatedName("a")
   int[] field2499;
   @ObfuscatedName("l")
   int[] field2500;
   @ObfuscatedName("d")
   int[] field2501;
   @ObfuscatedName("s")
   int[] field2502;
   @ObfuscatedName("u")
   int[] field2503;
   @ObfuscatedName("i")
   int[] field2504;
   @ObfuscatedName("z")
   int[] field2505;
   @ObfuscatedName("k")
   int[] field2506;
   @ObfuscatedName("r")
   int[] field2515;
   @ObfuscatedName("v")
   int[] field2516;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[[Lhy;"
   )
   class219[][] field2509;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "[[Lhy;"
   )
   class219[][] field2510;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   class220 field2511;
   @ObfuscatedName("ad")
   boolean field2512;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -413335001
   )
   int field2508;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 2013215883
   )
   int field2494;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      longValue = -7606394306527963775L
   )
   long field2498;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      longValue = 4636939215515381777L
   )
   long field2507;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   class222 field2517;

   public class218() {
      this.field2492 = 256;
      this.field2513 = 1000000;
      this.field2491 = new int[16];
      this.field2495 = new int[16];
      this.field2496 = new int[16];
      this.field2497 = new int[16];
      this.field2493 = new int[16];
      this.field2499 = new int[16];
      this.field2500 = new int[16];
      this.field2501 = new int[16];
      this.field2502 = new int[16];
      this.field2503 = new int[16];
      this.field2504 = new int[16];
      this.field2505 = new int[16];
      this.field2506 = new int[16];
      this.field2515 = new int[16];
      this.field2516 = new int[16];
      this.field2509 = new class219[16][128];
      this.field2510 = new class219[16][128];
      this.field2511 = new class220();
      this.field2517 = new class222(this);
      this.field2514 = new HashTable(128);
      this.method4256();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-49"
   )
   synchronized void method4302(int var1) {
      this.field2492 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   int method4228() {
      return this.field2492;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhc;Liv;Lcv;II)Z",
      garbageValue = "-2125947681"
   )
   synchronized boolean method4229(Track1 var1, IndexDataBase var2, class98 var3, int var4) {
      var1.method4450();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2568.first(); var7 != null; var7 = (ByteArrayNode)var1.field2568.next()) {
         int var8 = (int)var7.hash;
         class221 var9 = (class221)this.field2514.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.takeRecordFlat(var8);
            class221 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class221(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field2514.put(var10, (long)var8);
         }

         if(!var9.method4414(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4449();
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2072036076"
   )
   synchronized void method4230() {
      for(class221 var1 = (class221)this.field2514.first(); var1 != null; var1 = (class221)this.field2514.next()) {
         var1.method4417();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-298801511"
   )
   synchronized void method4231() {
      for(class221 var1 = (class221)this.field2514.first(); var1 != null; var1 = (class221)this.field2514.next()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Ldu;"
   )
   protected synchronized TaskDataNode vmethod4421() {
      return this.field2517;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldu;"
   )
   protected synchronized TaskDataNode vmethod4422() {
      return null;
   }

   @ObfuscatedName("d")
   protected synchronized int vmethod4423() {
      return 0;
   }

   @ObfuscatedName("s")
   protected synchronized void vmethod4424(int[] var1, int var2, int var3) {
      if(this.field2511.method4406()) {
         int var4 = this.field2511.field2540 * this.field2513 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = (long)var3 * (long)var4 + this.field2498;
            if(this.field2507 - var5 >= 0L) {
               this.field2498 = var5;
               break;
            }

            int var7 = (int)((this.field2507 - this.field2498 + (long)var4 - 1L) / (long)var4);
            this.field2498 += (long)var7 * (long)var4;
            this.field2517.vmethod4424(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method4271();
         } while(this.field2511.method4406());
      }

      this.field2517.vmethod4424(var1, var2, var3);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lhc;ZB)V",
      garbageValue = "-55"
   )
   synchronized void method4327(Track1 var1, boolean var2) {
      this.method4236();
      this.field2511.method4364(var1.field2569);
      this.field2512 = var2;
      this.field2498 = 0L;
      int var3 = this.field2511.method4367();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2511.method4411(var4);
         this.field2511.method4371(var4);
         this.field2511.method4402(var4);
      }

      this.field2508 = this.field2511.method4409();
      this.field2494 = this.field2511.field2541[this.field2508];
      this.field2507 = this.field2511.method4375(this.field2494);
   }

   @ObfuscatedName("g")
   protected synchronized void vmethod4425(int var1) {
      if(this.field2511.method4406()) {
         int var2 = this.field2511.field2540 * this.field2513 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = (long)var1 * (long)var2 + this.field2498;
            if(this.field2507 - var3 >= 0L) {
               this.field2498 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2507 - this.field2498) - 1L) / (long)var2);
            this.field2498 += (long)var2 * (long)var5;
            this.field2517.vmethod4425(var5);
            var1 -= var5;
            this.method4271();
         } while(this.field2511.method4406());
      }

      this.field2517.vmethod4425(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1884156370"
   )
   synchronized void method4236() {
      this.field2511.method4365();
      this.method4256();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1021502996"
   )
   synchronized boolean method4354() {
      return this.field2511.method4406();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   public synchronized void method4235(int var1, int var2) {
      this.method4232(var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-59"
   )
   void method4232(int var1, int var2) {
      this.field2497[var1] = var2;
      this.field2499[var1] = var2 & -128;
      this.method4237(var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1343284791"
   )
   void method4237(int var1, int var2) {
      if(var2 != this.field2493[var1]) {
         this.field2493[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2510[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2013290531"
   )
   void method4238(int var1, int var2, int var3) {
      this.method4284(var1, var2, 64);
      if((this.field2503[var1] & 2) != 0) {
         for(class219 var4 = (class219)this.field2517.field2565.getTail(); var4 != null; var4 = (class219)this.field2517.field2565.getPrevious()) {
            if(var4.field2518 == var1 && var4.field2532 < 0) {
               this.field2509[var1][var4.field2523] = null;
               this.field2509[var1][var2] = var4;
               int var5 = (var4.field2528 * var4.field2521 >> 12) + var4.field2526;
               var4.field2526 += var2 - var4.field2523 << 8;
               var4.field2521 = var5 - var4.field2526;
               var4.field2528 = 4096;
               var4.field2523 = var2;
               return;
            }
         }
      }

      class221 var9 = (class221)this.field2514.get((long)this.field2493[var1]);
      if(var9 != null) {
         RawAudioNode var8 = var9.field2553[var2];
         if(var8 != null) {
            class219 var6 = new class219();
            var6.field2518 = var1;
            var6.field2519 = var9;
            var6.field2524 = var8;
            var6.field2533 = var9.field2557[var2];
            var6.field2522 = var9.field2560[var2];
            var6.field2523 = var2;
            var6.field2535 = var3 * var3 * var9.field2556[var2] * var9.field2561 + 1024 >> 11;
            var6.field2525 = var9.field2554[var2] & 255;
            var6.field2526 = (var2 << 8) - (var9.field2555[var2] & 32767);
            var6.field2529 = 0;
            var6.field2530 = 0;
            var6.field2531 = 0;
            var6.field2532 = -1;
            var6.field2527 = 0;
            if(this.field2506[var1] == 0) {
               var6.field2536 = class103.method2316(var8, this.method4298(var6), this.method4252(var6), this.method4322(var6));
            } else {
               var6.field2536 = class103.method2316(var8, this.method4298(var6), 0, this.method4322(var6));
               this.method4239(var6, var9.field2555[var2] < 0);
            }

            if(var9.field2555[var2] < 0) {
               var6.field2536.method2318(-1);
            }

            if(var6.field2522 >= 0) {
               class219 var7 = this.field2510[var1][var6.field2522];
               if(var7 != null && var7.field2532 < 0) {
                  this.field2509[var1][var7.field2523] = null;
                  var7.field2532 = 0;
               }

               this.field2510[var1][var6.field2522] = var6;
            }

            this.field2517.field2565.addFront(var6);
            this.field2509[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lhy;ZI)V",
      garbageValue = "-2146885421"
   )
   void method4239(class219 var1, boolean var2) {
      int var3 = var1.field2524.audioBuffer.length;
      int var4;
      if(var2 && var1.field2524.field1304) {
         int var5 = var3 + var3 - var1.field2524.startPosition;
         var4 = (int)((long)var5 * (long)this.field2506[var1.field2518] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2536.method2325();
         }
      } else {
         var4 = (int)((long)this.field2506[var1.field2518] * (long)var3 >> 6);
      }

      var1.field2536.method2324(var4);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIS)V",
      garbageValue = "2456"
   )
   void method4284(int var1, int var2, int var3) {
      class219 var4 = this.field2509[var1][var2];
      if(var4 != null) {
         this.field2509[var1][var2] = null;
         if((this.field2503[var1] & 2) != 0) {
            for(class219 var5 = (class219)this.field2517.field2565.getFront(); var5 != null; var5 = (class219)this.field2517.field2565.getNext()) {
               if(var4.field2518 == var5.field2518 && var5.field2532 < 0 && var4 != var5) {
                  var4.field2532 = 0;
                  break;
               }
            }
         } else {
            var4.field2532 = 0;
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "386419046"
   )
   void method4241(int var1, int var2, int var3) {
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "2"
   )
   void method4242(int var1, int var2) {
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-91"
   )
   void method4338(int var1, int var2) {
      this.field2500[var1] = var2;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-19"
   )
   void method4244(int var1) {
      for(class219 var2 = (class219)this.field2517.field2565.getFront(); var2 != null; var2 = (class219)this.field2517.field2565.getNext()) {
         if(var1 < 0 || var2.field2518 == var1) {
            if(var2.field2536 != null) {
               var2.field2536.method2329(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2536.method2333()) {
                  this.field2517.field2564.method2049(var2.field2536);
               }

               var2.method4360();
            }

            if(var2.field2532 < 0) {
               this.field2509[var2.field2518][var2.field2523] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1100296102"
   )
   void method4332(int var1) {
      if(var1 >= 0) {
         this.field2491[var1] = 12800;
         this.field2495[var1] = 8192;
         this.field2496[var1] = 16383;
         this.field2500[var1] = 8192;
         this.field2501[var1] = 0;
         this.field2502[var1] = 8192;
         this.method4247(var1);
         this.method4273(var1);
         this.field2503[var1] = 0;
         this.field2504[var1] = 32767;
         this.field2505[var1] = 256;
         this.field2506[var1] = 0;
         this.method4250(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method4332(var1);
         }

      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "376562190"
   )
   void method4246(int var1) {
      for(class219 var2 = (class219)this.field2517.field2565.getFront(); var2 != null; var2 = (class219)this.field2517.field2565.getNext()) {
         if((var1 < 0 || var2.field2518 == var1) && var2.field2532 < 0) {
            this.field2509[var2.field2518][var2.field2523] = null;
            var2.field2532 = 0;
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1483125627"
   )
   void method4256() {
      this.method4244(-1);
      this.method4332(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2493[var1] = this.field2497[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2499[var1] = this.field2497[var1] & -128;
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-721452522"
   )
   void method4247(int var1) {
      if((this.field2503[var1] & 2) != 0) {
         for(class219 var2 = (class219)this.field2517.field2565.getFront(); var2 != null; var2 = (class219)this.field2517.field2565.getNext()) {
            if(var2.field2518 == var1 && this.field2509[var1][var2.field2523] == null && var2.field2532 < 0) {
               var2.field2532 = 0;
            }
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-841280125"
   )
   void method4273(int var1) {
      if((this.field2503[var1] & 4) != 0) {
         for(class219 var2 = (class219)this.field2517.field2565.getFront(); var2 != null; var2 = (class219)this.field2517.field2565.getNext()) {
            if(var2.field2518 == var1) {
               var2.field2538 = 0;
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-941611256"
   )
   void method4308(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4284(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method4238(var3, var4, var5);
         } else {
            this.method4284(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4241(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2499[var3] = (var5 << 14) + (this.field2499[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2499[var3] = (var5 << 7) + (this.field2499[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2501[var3] = (var5 << 7) + (this.field2501[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2501[var3] = var5 + (this.field2501[var3] & -128);
         }

         if(var4 == 5) {
            this.field2502[var3] = (var5 << 7) + (this.field2502[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2502[var3] = var5 + (this.field2502[var3] & -128);
         }

         if(var4 == 7) {
            this.field2491[var3] = (var5 << 7) + (this.field2491[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2491[var3] = var5 + (this.field2491[var3] & -128);
         }

         if(var4 == 10) {
            this.field2495[var3] = (var5 << 7) + (this.field2495[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2495[var3] = var5 + (this.field2495[var3] & -128);
         }

         if(var4 == 11) {
            this.field2496[var3] = (var5 << 7) + (this.field2496[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2496[var3] = var5 + (this.field2496[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2503[var3] |= 1;
            } else {
               this.field2503[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2503[var3] |= 2;
            } else {
               this.method4247(var3);
               this.field2503[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2504[var3] = (var5 << 7) + (this.field2504[var3] & 127);
         }

         if(var4 == 98) {
            this.field2504[var3] = (this.field2504[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2504[var3] = (var5 << 7) + (this.field2504[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2504[var3] = (this.field2504[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method4244(var3);
         }

         if(var4 == 121) {
            this.method4332(var3);
         }

         if(var4 == 123) {
            this.method4246(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2504[var3];
            if(var6 == 16384) {
               this.field2505[var3] = (var5 << 7) + (this.field2505[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2504[var3];
            if(var6 == 16384) {
               this.field2505[var3] = var5 + (this.field2505[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2506[var3] = (var5 << 7) + (this.field2506[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2506[var3] = var5 + (this.field2506[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2503[var3] |= 4;
            } else {
               this.method4273(var3);
               this.field2503[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method4250(var3, (var5 << 7) + (this.field2515[var3] & -16257));
         }

         if(var4 == 49) {
            this.method4250(var3, var5 + (this.field2515[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4237(var3, var4 + this.field2499[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4242(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method4338(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method4256();
         }
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-101"
   )
   void method4250(int var1, int var2) {
      this.field2515[var1] = var2;
      this.field2516[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lhy;I)I",
      garbageValue = "1978216592"
   )
   int method4298(class219 var1) {
      int var2 = (var1.field2521 * var1.field2528 >> 12) + var1.field2526;
      var2 += (this.field2500[var1.field2518] - 8192) * this.field2505[var1.field2518] >> 12;
      class216 var3 = var1.field2533;
      int var4;
      if(var3.field2479 > 0 && (var3.field2472 > 0 || this.field2501[var1.field2518] > 0)) {
         var4 = var3.field2472 << 2;
         int var5 = var3.field2480 << 1;
         if(var1.field2534 < var5) {
            var4 = var4 * var1.field2534 / var5;
         }

         var4 += this.field2501[var1.field2518] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2520 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2524.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lhy;I)I",
      garbageValue = "-1793853707"
   )
   int method4252(class219 var1) {
      class216 var2 = var1.field2533;
      int var3 = this.field2496[var1.field2518] * this.field2491[var1.field2518] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2535 + 16384 >> 15;
      var3 = var3 * this.field2492 + 128 >> 8;
      if(var2.field2474 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field2529 * 1.953125E-5D * (double)var2.field2474) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2478 != null) {
         var4 = var1.field2530;
         var5 = var2.field2478[var1.field2531 + 1];
         if(var1.field2531 < var2.field2478.length - 2) {
            var6 = (var2.field2478[var1.field2531] & 255) << 8;
            var7 = (var2.field2478[var1.field2531 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2478[var1.field2531 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2532 > 0 && var2.field2473 != null) {
         var4 = var1.field2532;
         var5 = var2.field2473[var1.field2527 + 1];
         if(var1.field2527 < var2.field2473.length - 2) {
            var6 = (var2.field2473[var1.field2527] & 255) << 8;
            var7 = (var2.field2473[var1.field2527 + 2] & 255) << 8;
            var5 += (var2.field2473[var1.field2527 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(Lhy;I)I",
      garbageValue = "188281095"
   )
   int method4322(class219 var1) {
      int var2 = this.field2495[var1.field2518];
      return var2 < 8192?var2 * var1.field2525 + 32 >> 6:16384 - ((128 - var1.field2525) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2019196517"
   )
   void method4271() {
      int var1 = this.field2508;
      int var2 = this.field2494;

      long var3;
      for(var3 = this.field2507; var2 == this.field2494; var3 = this.field2511.method4375(var2)) {
         while(var2 == this.field2511.field2541[var1]) {
            this.field2511.method4411(var1);
            int var5 = this.field2511.method4372(var1);
            if(var5 == 1) {
               this.field2511.method4370();
               this.field2511.method4402(var1);
               if(this.field2511.method4390()) {
                  if(!this.field2512 || var2 == 0) {
                     this.method4256();
                     this.field2511.method4365();
                     return;
                  }

                  this.field2511.method4378(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method4308(var5);
            }

            this.field2511.method4371(var1);
            this.field2511.method4402(var1);
         }

         var1 = this.field2511.method4409();
         var2 = this.field2511.field2541[var1];
      }

      this.field2508 = var1;
      this.field2494 = var2;
      this.field2507 = var3;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(Lhy;I)Z",
      garbageValue = "-1558187938"
   )
   boolean method4260(class219 var1) {
      if(var1.field2536 == null) {
         if(var1.field2532 >= 0) {
            var1.unlink();
            if(var1.field2522 > 0 && var1 == this.field2510[var1.field2518][var1.field2522]) {
               this.field2510[var1.field2518][var1.field2522] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(Lhy;[IIII)Z",
      garbageValue = "-190901882"
   )
   boolean method4234(class219 var1, int[] var2, int var3, int var4) {
      var1.field2537 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2532 < 0 || var1.field2536 != null && !var1.field2536.method2441()) {
         int var5 = var1.field2528;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2502[var1.field2518] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2528 = var5;
         }

         var1.field2536.method2330(this.method4298(var1));
         class216 var6 = var1.field2533;
         boolean var7 = false;
         ++var1.field2534;
         var1.field2520 += var6.field2479;
         double var8 = (double)((var1.field2523 - 60 << 8) + (var1.field2528 * var1.field2521 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2474 > 0) {
            if(var6.field2476 > 0) {
               var1.field2529 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2476 * var8) + 0.5D);
            } else {
               var1.field2529 += 128;
            }
         }

         if(var6.field2478 != null) {
            if(var6.field2475 > 0) {
               var1.field2530 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2475) + 0.5D);
            } else {
               var1.field2530 += 128;
            }

            while(var1.field2531 < var6.field2478.length - 2 && var1.field2530 > (var6.field2478[var1.field2531 + 2] & 255) << 8) {
               var1.field2531 += 2;
            }

            if(var6.field2478.length - 2 == var1.field2531 && var6.field2478[var1.field2531 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2532 >= 0 && var6.field2473 != null && (this.field2503[var1.field2518] & 1) == 0 && (var1.field2522 < 0 || var1 != this.field2510[var1.field2518][var1.field2522])) {
            if(var6.field2481 > 0) {
               var1.field2532 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2481) + 0.5D);
            } else {
               var1.field2532 += 128;
            }

            while(var1.field2527 < var6.field2473.length - 2 && var1.field2532 > (var6.field2473[var1.field2527 + 2] & 255) << 8) {
               var1.field2527 += 2;
            }

            if(var6.field2473.length - 2 == var1.field2527) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2536.method2329(var1.field2537);
            if(var2 != null) {
               var1.field2536.vmethod4424(var2, var3, var4);
            } else {
               var1.field2536.vmethod4425(var4);
            }

            if(var1.field2536.method2333()) {
               this.field2517.field2564.method2049(var1.field2536);
            }

            var1.method4360();
            if(var1.field2532 >= 0) {
               var1.unlink();
               if(var1.field2522 > 0 && var1 == this.field2510[var1.field2518][var1.field2522]) {
                  this.field2510[var1.field2518][var1.field2522] = null;
               }
            }

            return true;
         } else {
            var1.field2536.method2328(var1.field2537, this.method4252(var1), this.method4322(var1));
            return false;
         }
      } else {
         var1.method4360();
         var1.unlink();
         if(var1.field2522 > 0 && var1 == this.field2510[var1.field2518][var1.field2522]) {
            this.field2510[var1.field2518][var1.field2522] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1914009644"
   )
   static final void method4359(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(GameCanvas.loadWidget(var0)) {
         class25.field226 = null;
         WorldMapType3.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class25.field226 != null) {
            WorldMapType3.gameDraw(class25.field226, -1412584499, var1, var2, var3, var4, class184.field2378, WorldMapManager.field268, var7);
            class25.field226 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field795[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field795[var8] = true;
            }
         }

      }
   }
}
