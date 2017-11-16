import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
public class class211 extends class118 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   HashTable field2595;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 188247677
   )
   int field2613;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1515685455
   )
   int field2605;
   @ObfuscatedName("g")
   int[] field2598;
   @ObfuscatedName("x")
   int[] field2599;
   @ObfuscatedName("f")
   int[] field2601;
   @ObfuscatedName("u")
   int[] field2600;
   @ObfuscatedName("t")
   int[] field2602;
   @ObfuscatedName("k")
   int[] field2603;
   @ObfuscatedName("n")
   int[] field2604;
   @ObfuscatedName("d")
   int[] field2607;
   @ObfuscatedName("o")
   int[] field2606;
   @ObfuscatedName("p")
   int[] field2609;
   @ObfuscatedName("i")
   int[] field2610;
   @ObfuscatedName("l")
   int[] field2611;
   @ObfuscatedName("z")
   int[] field2612;
   @ObfuscatedName("e")
   int[] field2597;
   @ObfuscatedName("v")
   int[] field2614;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[[Lhp;"
   )
   class212[][] field2596;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "[[Lhp;"
   )
   class212[][] field2616;
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   class213 field2617;
   @ObfuscatedName("ae")
   boolean field2618;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 577084393
   )
   int field2619;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1948062759
   )
   int field2615;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      longValue = 5476773848421409937L
   )
   long field2621;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      longValue = 2216478418600872353L
   )
   long field2622;
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   class215 field2623;

   public class211() {
      this.field2613 = 256;
      this.field2605 = 1000000;
      this.field2598 = new int[16];
      this.field2599 = new int[16];
      this.field2601 = new int[16];
      this.field2600 = new int[16];
      this.field2602 = new int[16];
      this.field2603 = new int[16];
      this.field2604 = new int[16];
      this.field2607 = new int[16];
      this.field2606 = new int[16];
      this.field2609 = new int[16];
      this.field2610 = new int[16];
      this.field2611 = new int[16];
      this.field2612 = new int[16];
      this.field2597 = new int[16];
      this.field2614 = new int[16];
      this.field2596 = new class212[16][128];
      this.field2616 = new class212[16][128];
      this.field2617 = new class213();
      this.field2623 = new class215(this);
      this.field2595 = new HashTable(128);
      this.method3759();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public synchronized void method3845(int var1) {
      this.field2613 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1412358541"
   )
   int method3740() {
      return this.field2613;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lhg;Lij;Ldg;II)Z",
      garbageValue = "399175160"
   )
   public synchronized boolean method3741(Track1 var1, IndexDataBase var2, class111 var3, int var4) {
      var1.method3948();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(class206 var7 = (class206)var1.field2671.method3592(); var7 != null; var7 = (class206)var1.field2671.method3593()) {
         int var8 = (int)var7.hash;
         class214 var9 = (class214)this.field2595.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method4114(var8);
            class214 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class214(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field2595.put(var10, (long)var8);
         }

         if(!var9.method3913(var3, var7.field2570, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method3949();
      }

      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1311028193"
   )
   public synchronized void method3742() {
      for(class214 var1 = (class214)this.field2595.method3592(); var1 != null; var1 = (class214)this.field2595.method3593()) {
         var1.method3912();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-891786010"
   )
   synchronized void method3802() {
      for(class214 var1 = (class214)this.field2595.method3592(); var1 != null; var1 = (class214)this.field2595.method3593()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected synchronized class118 vmethod3931() {
      return this.field2623;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected synchronized class118 vmethod3946() {
      return null;
   }

   @ObfuscatedName("t")
   protected synchronized int vmethod3925() {
      return 0;
   }

   @ObfuscatedName("k")
   protected synchronized void vmethod3926(int[] var1, int var2, int var3) {
      if(this.field2617.method3864()) {
         int var4 = this.field2617.field2646 * this.field2605 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = (long)var3 * (long)var4 + this.field2621;
            if(this.field2622 - var5 >= 0L) {
               this.field2621 = var5;
               break;
            }

            int var7 = (int)((this.field2622 - this.field2621 + (long)var4 - 1L) / (long)var4);
            this.field2621 += (long)var4 * (long)var7;
            this.field2623.vmethod3926(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3772();
         } while(this.field2617.method3864());
      }

      this.field2623.vmethod3926(var1, var2, var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lhg;ZI)V",
      garbageValue = "-2058678153"
   )
   public synchronized void method3763(Track1 var1, boolean var2) {
      this.method3771();
      this.field2617.method3862(var1.field2670);
      this.field2618 = var2;
      this.field2621 = 0L;
      int var3 = this.field2617.method3865();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2617.method3866(var4);
         this.field2617.method3883(var4);
         this.field2617.method3867(var4);
      }

      this.field2619 = this.field2617.method3874();
      this.field2615 = this.field2617.field2654[this.field2619];
      this.field2622 = this.field2617.method3877(this.field2615);
   }

   @ObfuscatedName("d")
   protected synchronized void vmethod3927(int var1) {
      if(this.field2617.method3864()) {
         int var2 = this.field2617.field2646 * this.field2605 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = this.field2621 + (long)var2 * (long)var1;
            if(this.field2622 - var3 >= 0L) {
               this.field2621 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2622 - this.field2621) - 1L) / (long)var2);
            this.field2621 += (long)var5 * (long)var2;
            this.field2623.vmethod3927(var5);
            var1 -= var5;
            this.method3772();
         } while(this.field2617.method3864());
      }

      this.field2623.vmethod3927(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1150169587"
   )
   public synchronized void method3771() {
      this.field2617.method3873();
      this.method3759();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-99"
   )
   synchronized boolean method3819() {
      return this.field2617.method3864();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-111"
   )
   public synchronized void method3747(int var1, int var2) {
      this.method3801(var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2018022214"
   )
   void method3801(int var1, int var2) {
      this.field2600[var1] = var2;
      this.field2603[var1] = var2 & -128;
      this.method3749(var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-1"
   )
   void method3749(int var1, int var2) {
      if(var2 != this.field2602[var1]) {
         this.field2602[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2616[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-596030363"
   )
   void method3750(int var1, int var2, int var3) {
      this.method3752(var1, var2, 64);
      if((this.field2609[var1] & 2) != 0) {
         for(class212 var4 = (class212)this.field2623.field2668.getTail(); var4 != null; var4 = (class212)this.field2623.field2668.getPrevious()) {
            if(var4.field2624 == var1 && var4.field2640 < 0) {
               this.field2596[var1][var4.field2629] = null;
               this.field2596[var1][var2] = var4;
               int var5 = (var4.field2634 * var4.field2635 >> 12) + var4.field2639;
               var4.field2639 += var2 - var4.field2629 << 8;
               var4.field2635 = var5 - var4.field2639;
               var4.field2634 = 4096;
               var4.field2629 = var2;
               return;
            }
         }
      }

      class214 var9 = (class214)this.field2595.get((long)this.field2602[var1]);
      if(var9 != null) {
         class106 var8 = var9.field2660[var2];
         if(var8 != null) {
            class212 var6 = new class212();
            var6.field2624 = var1;
            var6.field2625 = var9;
            var6.field2626 = var8;
            var6.field2627 = var9.field2664[var2];
            var6.field2628 = var9.field2665[var2];
            var6.field2629 = var2;
            var6.field2643 = var3 * var3 * var9.field2662[var2] * var9.field2659 + 1024 >> 11;
            var6.field2631 = var9.field2663[var2] & 255;
            var6.field2639 = (var2 << 8) - (var9.field2661[var2] & 32767);
            var6.field2630 = 0;
            var6.field2636 = 0;
            var6.field2637 = 0;
            var6.field2640 = -1;
            var6.field2633 = 0;
            if(this.field2612[var1] == 0) {
               var6.field2642 = class116.method2132(var8, this.method3804(var6), this.method3745(var6), this.method3766(var6));
            } else {
               var6.field2642 = class116.method2132(var8, this.method3804(var6), 0, this.method3766(var6));
               this.method3751(var6, var9.field2661[var2] < 0);
            }

            if(var9.field2661[var2] < 0) {
               var6.field2642.method2191(-1);
            }

            if(var6.field2628 >= 0) {
               class212 var7 = this.field2616[var1][var6.field2628];
               if(var7 != null && var7.field2640 < 0) {
                  this.field2596[var1][var7.field2629] = null;
                  var7.field2640 = 0;
               }

               this.field2616[var1][var6.field2628] = var6;
            }

            this.field2623.field2668.addFront(var6);
            this.field2596[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lhp;ZB)V",
      garbageValue = "-85"
   )
   void method3751(class212 var1, boolean var2) {
      int var3 = var1.field2626.field1519.length;
      int var4;
      if(var2 && var1.field2626.field1518) {
         int var5 = var3 + var3 - var1.field2626.field1520;
         var4 = (int)((long)var5 * (long)this.field2612[var1.field2624] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2642.method2175();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2612[var1.field2624] >> 6);
      }

      var1.field2642.method2140(var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2134971189"
   )
   void method3752(int var1, int var2, int var3) {
      class212 var4 = this.field2596[var1][var2];
      if(var4 != null) {
         this.field2596[var1][var2] = null;
         if((this.field2609[var1] & 2) != 0) {
            for(class212 var5 = (class212)this.field2623.field2668.getFront(); var5 != null; var5 = (class212)this.field2623.field2668.getNext()) {
               if(var4.field2624 == var5.field2624 && var5.field2640 < 0 && var4 != var5) {
                  var4.field2640 = 0;
                  break;
               }
            }
         } else {
            var4.field2640 = 0;
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1081065507"
   )
   void method3831(int var1, int var2, int var3) {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2098426907"
   )
   void method3754(int var1, int var2) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "8821"
   )
   void method3755(int var1, int var2) {
      this.field2604[var1] = var2;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1721328714"
   )
   void method3756(int var1) {
      for(class212 var2 = (class212)this.field2623.field2668.getFront(); var2 != null; var2 = (class212)this.field2623.field2668.getNext()) {
         if(var1 < 0 || var2.field2624 == var1) {
            if(var2.field2642 != null) {
               var2.field2642.method2170(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2642.method2180()) {
                  this.field2623.field2667.method1914(var2.field2642);
               }

               var2.method3858();
            }

            if(var2.field2640 < 0) {
               this.field2596[var2.field2624][var2.field2629] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "101"
   )
   void method3757(int var1) {
      if(var1 >= 0) {
         this.field2598[var1] = 12800;
         this.field2599[var1] = 8192;
         this.field2601[var1] = 16383;
         this.field2604[var1] = 8192;
         this.field2607[var1] = 0;
         this.field2606[var1] = 8192;
         this.method3760(var1);
         this.method3761(var1);
         this.field2609[var1] = 0;
         this.field2610[var1] = 32767;
         this.field2611[var1] = 256;
         this.field2612[var1] = 0;
         this.method3830(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3757(var1);
         }

      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1186597793"
   )
   void method3744(int var1) {
      for(class212 var2 = (class212)this.field2623.field2668.getFront(); var2 != null; var2 = (class212)this.field2623.field2668.getNext()) {
         if((var1 < 0 || var2.field2624 == var1) && var2.field2640 < 0) {
            this.field2596[var2.field2624][var2.field2629] = null;
            var2.field2640 = 0;
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-845892527"
   )
   void method3759() {
      this.method3756(-1);
      this.method3757(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2602[var1] = this.field2600[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2603[var1] = this.field2600[var1] & -128;
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1270630487"
   )
   void method3760(int var1) {
      if((this.field2609[var1] & 2) != 0) {
         for(class212 var2 = (class212)this.field2623.field2668.getFront(); var2 != null; var2 = (class212)this.field2623.field2668.getNext()) {
            if(var2.field2624 == var1 && this.field2596[var1][var2.field2629] == null && var2.field2640 < 0) {
               var2.field2640 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "564240677"
   )
   void method3761(int var1) {
      if((this.field2609[var1] & 4) != 0) {
         for(class212 var2 = (class212)this.field2623.field2668.getFront(); var2 != null; var2 = (class212)this.field2623.field2668.getNext()) {
            if(var2.field2624 == var1) {
               var2.field2644 = 0;
            }
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-21664"
   )
   void method3762(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3752(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3750(var3, var4, var5);
         } else {
            this.method3752(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3831(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2603[var3] = (var5 << 14) + (this.field2603[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2603[var3] = (var5 << 7) + (this.field2603[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2607[var3] = (var5 << 7) + (this.field2607[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2607[var3] = var5 + (this.field2607[var3] & -128);
         }

         if(var4 == 5) {
            this.field2606[var3] = (var5 << 7) + (this.field2606[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2606[var3] = var5 + (this.field2606[var3] & -128);
         }

         if(var4 == 7) {
            this.field2598[var3] = (var5 << 7) + (this.field2598[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2598[var3] = var5 + (this.field2598[var3] & -128);
         }

         if(var4 == 10) {
            this.field2599[var3] = (var5 << 7) + (this.field2599[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2599[var3] = var5 + (this.field2599[var3] & -128);
         }

         if(var4 == 11) {
            this.field2601[var3] = (var5 << 7) + (this.field2601[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2601[var3] = var5 + (this.field2601[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2609[var3] |= 1;
            } else {
               this.field2609[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2609[var3] |= 2;
            } else {
               this.method3760(var3);
               this.field2609[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2610[var3] = (var5 << 7) + (this.field2610[var3] & 127);
         }

         if(var4 == 98) {
            this.field2610[var3] = (this.field2610[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2610[var3] = (var5 << 7) + (this.field2610[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2610[var3] = (this.field2610[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3756(var3);
         }

         if(var4 == 121) {
            this.method3757(var3);
         }

         if(var4 == 123) {
            this.method3744(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2610[var3];
            if(var6 == 16384) {
               this.field2611[var3] = (var5 << 7) + (this.field2611[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2610[var3];
            if(var6 == 16384) {
               this.field2611[var3] = var5 + (this.field2611[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2612[var3] = (var5 << 7) + (this.field2612[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2612[var3] = var5 + (this.field2612[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2609[var3] |= 4;
            } else {
               this.method3761(var3);
               this.field2609[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3830(var3, (var5 << 7) + (this.field2597[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3830(var3, var5 + (this.field2597[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3749(var3, var4 + this.field2603[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3754(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3755(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3759();
         }
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1037095203"
   )
   void method3830(int var1, int var2) {
      this.field2597[var1] = var2;
      this.field2614[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lhp;B)I",
      garbageValue = "17"
   )
   int method3804(class212 var1) {
      int var2 = (var1.field2634 * var1.field2635 >> 12) + var1.field2639;
      var2 += (this.field2604[var1.field2624] - 8192) * this.field2611[var1.field2624] >> 12;
      class209 var3 = var1.field2627;
      int var4;
      if(var3.field2582 > 0 && (var3.field2581 > 0 || this.field2607[var1.field2624] > 0)) {
         var4 = var3.field2581 << 2;
         int var5 = var3.field2584 << 1;
         if(var1.field2632 < var5) {
            var4 = var4 * var1.field2632 / var5;
         }

         var4 += this.field2607[var1.field2624] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2641 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2626.field1522 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lhp;I)I",
      garbageValue = "2143377866"
   )
   int method3745(class212 var1) {
      class209 var2 = var1.field2627;
      int var3 = this.field2598[var1.field2624] * this.field2601[var1.field2624] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2643 + 16384 >> 15;
      var3 = var3 * this.field2613 + 128 >> 8;
      if(var2.field2577 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field2630 * (double)var2.field2577) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2576 != null) {
         var4 = var1.field2636;
         var5 = var2.field2576[var1.field2637 + 1];
         if(var1.field2637 < var2.field2576.length - 2) {
            var6 = (var2.field2576[var1.field2637] & 255) << 8;
            var7 = (var2.field2576[var1.field2637 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2576[var1.field2637 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2640 > 0 && var2.field2579 != null) {
         var4 = var1.field2640;
         var5 = var2.field2579[var1.field2633 + 1];
         if(var1.field2633 < var2.field2579.length - 2) {
            var6 = (var2.field2579[var1.field2633] & 255) << 8;
            var7 = (var2.field2579[var1.field2633 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2579[var1.field2633 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lhp;I)I",
      garbageValue = "324318040"
   )
   int method3766(class212 var1) {
      int var2 = this.field2599[var1.field2624];
      return var2 < 8192?var2 * var1.field2631 + 32 >> 6:16384 - ((128 - var1.field2631) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1434196629"
   )
   void method3772() {
      int var1 = this.field2619;
      int var2 = this.field2615;

      long var3;
      for(var3 = this.field2622; var2 == this.field2615; var3 = this.field2617.method3877(var2)) {
         while(var2 == this.field2617.field2654[var1]) {
            this.field2617.method3866(var1);
            int var5 = this.field2617.method3861(var1);
            if(var5 == 1) {
               this.field2617.method3892();
               this.field2617.method3867(var1);
               if(this.field2617.method3875()) {
                  if(!this.field2618 || var2 == 0) {
                     this.method3759();
                     this.field2617.method3873();
                     return;
                  }

                  this.field2617.method3876(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3762(var5);
            }

            this.field2617.method3883(var1);
            this.field2617.method3867(var1);
         }

         var1 = this.field2617.method3874();
         var2 = this.field2617.field2654[var1];
      }

      this.field2619 = var1;
      this.field2615 = var2;
      this.field2622 = var3;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lhp;B)Z",
      garbageValue = "1"
   )
   boolean method3773(class212 var1) {
      if(var1.field2642 == null) {
         if(var1.field2640 >= 0) {
            var1.unlink();
            if(var1.field2628 > 0 && var1 == this.field2616[var1.field2624][var1.field2628]) {
               this.field2616[var1.field2624][var1.field2628] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lhp;[IIIB)Z",
      garbageValue = "-89"
   )
   boolean method3774(class212 var1, int[] var2, int var3, int var4) {
      var1.field2638 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2640 < 0 || var1.field2642 != null && !var1.field2642.method2150()) {
         int var5 = var1.field2634;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2606[var1.field2624]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2634 = var5;
         }

         var1.field2642.method2127(this.method3804(var1));
         class209 var6 = var1.field2627;
         boolean var7 = false;
         ++var1.field2632;
         var1.field2641 += var6.field2582;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2629 - 60 << 8) + (var1.field2635 * var1.field2634 >> 12));
         if(var6.field2577 > 0) {
            if(var6.field2578 > 0) {
               var1.field2630 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2578 * var8) + 0.5D);
            } else {
               var1.field2630 += 128;
            }
         }

         if(var6.field2576 != null) {
            if(var6.field2575 > 0) {
               var1.field2636 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2575 * var8) + 0.5D);
            } else {
               var1.field2636 += 128;
            }

            while(var1.field2637 < var6.field2576.length - 2 && var1.field2636 > (var6.field2576[var1.field2637 + 2] & 255) << 8) {
               var1.field2637 += 2;
            }

            if(var6.field2576.length - 2 == var1.field2637 && var6.field2576[var1.field2637 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2640 >= 0 && var6.field2579 != null && (this.field2609[var1.field2624] & 1) == 0 && (var1.field2628 < 0 || var1 != this.field2616[var1.field2624][var1.field2628])) {
            if(var6.field2583 > 0) {
               var1.field2640 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2583) + 0.5D);
            } else {
               var1.field2640 += 128;
            }

            while(var1.field2633 < var6.field2579.length - 2 && var1.field2640 > (var6.field2579[var1.field2633 + 2] & 255) << 8) {
               var1.field2633 += 2;
            }

            if(var6.field2579.length - 2 == var1.field2633) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2642.method2170(var1.field2638);
            if(var2 != null) {
               var1.field2642.vmethod3926(var2, var3, var4);
            } else {
               var1.field2642.vmethod3927(var4);
            }

            if(var1.field2642.method2180()) {
               this.field2623.field2667.method1914(var1.field2642);
            }

            var1.method3858();
            if(var1.field2640 >= 0) {
               var1.unlink();
               if(var1.field2628 > 0 && var1 == this.field2616[var1.field2624][var1.field2628]) {
                  this.field2616[var1.field2624][var1.field2628] = null;
               }
            }

            return true;
         } else {
            var1.field2642.method2144(var1.field2638, this.method3745(var1), this.method3766(var1));
            return false;
         }
      } else {
         var1.method3858();
         var1.unlink();
         if(var1.field2628 > 0 && var1 == this.field2616[var1.field2624][var1.field2628]) {
            this.field2616[var1.field2624][var1.field2628] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lev;II)V",
      garbageValue = "-2071174745"
   )
   public static final void method3854(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.field1838; ++var2) {
         if(var0.field1844[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.field1877[var3];
            int var7 = Model.field1877[var4];
            int var8 = Model.field1877[var5];
            Tile.method2504(Model.field1872[var3], Model.field1872[var4], Model.field1872[var5], var6, var7, var8, var1);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Ljc;",
      garbageValue = "-14"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3610.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1387424622"
   )
   static int method3849(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }
}
