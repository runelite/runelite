import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public class class211 extends class118 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   HashTable field2609;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1832209001
   )
   int field2604;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1651417789
   )
   int field2605;
   @ObfuscatedName("j")
   int[] field2606;
   @ObfuscatedName("v")
   int[] field2610;
   @ObfuscatedName("x")
   int[] field2630;
   @ObfuscatedName("e")
   int[] field2621;
   @ObfuscatedName("l")
   int[] field2603;
   @ObfuscatedName("b")
   int[] field2611;
   @ObfuscatedName("n")
   int[] field2612;
   @ObfuscatedName("c")
   int[] field2626;
   @ObfuscatedName("a")
   int[] field2614;
   @ObfuscatedName("g")
   int[] field2616;
   @ObfuscatedName("z")
   int[] field2617;
   @ObfuscatedName("o")
   int[] field2618;
   @ObfuscatedName("d")
   int[] field2619;
   @ObfuscatedName("s")
   int[] field2620;
   @ObfuscatedName("f")
   int[] field2613;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[[Lhg;"
   )
   class212[][] field2622;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "[[Lhg;"
   )
   class212[][] field2631;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   class213 field2624;
   @ObfuscatedName("aq")
   boolean field2625;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 2079596411
   )
   int field2623;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1820804131
   )
   int field2627;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      longValue = 6982407363257959321L
   )
   long field2628;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      longValue = 8819534485524084443L
   )
   long field2629;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   class215 field2608;

   public class211() {
      this.field2604 = 256;
      this.field2605 = 1000000;
      this.field2606 = new int[16];
      this.field2610 = new int[16];
      this.field2630 = new int[16];
      this.field2621 = new int[16];
      this.field2603 = new int[16];
      this.field2611 = new int[16];
      this.field2612 = new int[16];
      this.field2626 = new int[16];
      this.field2614 = new int[16];
      this.field2616 = new int[16];
      this.field2617 = new int[16];
      this.field2618 = new int[16];
      this.field2619 = new int[16];
      this.field2620 = new int[16];
      this.field2613 = new int[16];
      this.field2622 = new class212[16][128];
      this.field2631 = new class212[16][128];
      this.field2624 = new class213();
      this.field2608 = new class215(this);
      this.field2609 = new HashTable(128);
      this.method3874();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1732342400"
   )
   public synchronized void method3854(int var1) {
      this.field2604 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "32"
   )
   int method3855() {
      return this.field2604;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lhv;Lik;Ldn;IB)Z",
      garbageValue = "18"
   )
   public synchronized boolean method3856(Track1 var1, IndexDataBase var2, class111 var3, int var4) {
      var1.method4074();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(class206 var7 = (class206)var1.field2678.method3721(); var7 != null; var7 = (class206)var1.field2678.method3728()) {
         int var8 = (int)var7.hash;
         class214 var9 = (class214)this.field2609.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method4375(var8);
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

            this.field2609.put(var10, (long)var8);
         }

         if(!var9.method4040(var3, var7.field2577, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4073();
      }

      return var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1847423929"
   )
   public synchronized void method3857() {
      for(class214 var1 = (class214)this.field2609.method3721(); var1 != null; var1 = (class214)this.field2609.method3728()) {
         var1.method4042();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1904782561"
   )
   synchronized void method3858() {
      for(class214 var1 = (class214)this.field2609.method3721(); var1 != null; var1 = (class214)this.field2609.method3728()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Ldq;"
   )
   protected synchronized class118 vmethod4047() {
      return this.field2608;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Ldq;"
   )
   protected synchronized class118 vmethod4048() {
      return null;
   }

   @ObfuscatedName("l")
   protected synchronized int vmethod4068() {
      return 0;
   }

   @ObfuscatedName("b")
   protected synchronized void vmethod4050(int[] var1, int var2, int var3) {
      if(this.field2624.method3985()) {
         int var4 = this.field2624.field2654 * this.field2605 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = this.field2628 + (long)var3 * (long)var4;
            if(this.field2629 - var5 >= 0L) {
               this.field2628 = var5;
               break;
            }

            int var7 = (int)((this.field2629 - this.field2628 + (long)var4 - 1L) / (long)var4);
            this.field2628 += (long)var7 * (long)var4;
            this.field2608.vmethod4050(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3887();
         } while(this.field2624.method3985());
      }

      this.field2608.vmethod4050(var1, var2, var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lhv;ZI)V",
      garbageValue = "981450025"
   )
   public synchronized void method3860(Track1 var1, boolean var2) {
      this.method3969();
      this.field2624.method4031(var1.field2679);
      this.field2625 = var2;
      this.field2628 = 0L;
      int var3 = this.field2624.method3986();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2624.method3987(var4);
         this.field2624.method3990(var4);
         this.field2624.method3988(var4);
      }

      this.field2623 = this.field2624.method3995();
      this.field2627 = this.field2624.field2657[this.field2623];
      this.field2629 = this.field2624.method3994(this.field2627);
   }

   @ObfuscatedName("c")
   protected synchronized void vmethod4051(int var1) {
      if(this.field2624.method3985()) {
         int var2 = this.field2624.field2654 * this.field2605 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = this.field2628 + (long)var1 * (long)var2;
            if(this.field2629 - var3 >= 0L) {
               this.field2628 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2629 - this.field2628) - 1L) / (long)var2);
            this.field2628 += (long)var2 * (long)var5;
            this.field2608.vmethod4051(var5);
            var1 -= var5;
            this.method3887();
         } while(this.field2624.method3985());
      }

      this.field2608.vmethod4051(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-517878341"
   )
   public synchronized void method3969() {
      this.field2624.method3984();
      this.method3874();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-8"
   )
   public synchronized boolean method3861() {
      return this.field2624.method3985();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2040203399"
   )
   public synchronized void method3862(int var1, int var2) {
      this.method3863(var1, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1822672849"
   )
   void method3863(int var1, int var2) {
      this.field2621[var1] = var2;
      this.field2611[var1] = var2 & -128;
      this.method3864(var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-57"
   )
   void method3864(int var1, int var2) {
      if(var2 != this.field2603[var1]) {
         this.field2603[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2631[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-191941384"
   )
   void method3865(int var1, int var2, int var3) {
      this.method3878(var1, var2, 64);
      if((this.field2616[var1] & 2) != 0) {
         for(class212 var4 = (class212)this.field2608.field2677.getTail(); var4 != null; var4 = (class212)this.field2608.field2677.getPrevious()) {
            if(var4.field2637 == var1 && var4.field2646 < 0) {
               this.field2622[var1][var4.field2650] = null;
               this.field2622[var1][var2] = var4;
               int var5 = (var4.field2636 * var4.field2641 >> 12) + var4.field2644;
               var4.field2644 += var2 - var4.field2650 << 8;
               var4.field2641 = var5 - var4.field2644;
               var4.field2636 = 4096;
               var4.field2650 = var2;
               return;
            }
         }
      }

      class214 var9 = (class214)this.field2609.get((long)this.field2603[var1]);
      if(var9 != null) {
         class106 var8 = var9.field2672[var2];
         if(var8 != null) {
            class212 var6 = new class212();
            var6.field2637 = var1;
            var6.field2633 = var9;
            var6.field2642 = var8;
            var6.field2635 = var9.field2668[var2];
            var6.field2640 = var9.field2673[var2];
            var6.field2650 = var2;
            var6.field2638 = var3 * var3 * var9.field2670[var2] * var9.field2674 + 1024 >> 11;
            var6.field2639 = var9.field2671[var2] & 255;
            var6.field2644 = (var2 << 8) - (var9.field2669[var2] & 32767);
            var6.field2643 = 0;
            var6.field2649 = 0;
            var6.field2634 = 0;
            var6.field2646 = -1;
            var6.field2647 = 0;
            if(this.field2619[var1] == 0) {
               var6.field2645 = class116.method2330(var8, this.method3908(var6), this.method3927(var6), this.method3881(var6));
            } else {
               var6.field2645 = class116.method2330(var8, this.method3908(var6), 0, this.method3881(var6));
               this.method3866(var6, var9.field2669[var2] < 0);
            }

            if(var9.field2669[var2] < 0) {
               var6.field2645.method2220(-1);
            }

            if(var6.field2640 >= 0) {
               class212 var7 = this.field2631[var1][var6.field2640];
               if(var7 != null && var7.field2646 < 0) {
                  this.field2622[var1][var7.field2650] = null;
                  var7.field2646 = 0;
               }

               this.field2631[var1][var6.field2640] = var6;
            }

            this.field2608.field2677.addFront(var6);
            this.field2622[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lhg;ZI)V",
      garbageValue = "-648307497"
   )
   void method3866(class212 var1, boolean var2) {
      int var3 = var1.field2642.field1527.length;
      int var4;
      if(var2 && var1.field2642.field1531) {
         int var5 = var3 + var3 - var1.field2642.field1529;
         var4 = (int)((long)this.field2619[var1.field2637] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2645.method2227();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2619[var1.field2637] >> 6);
      }

      var1.field2645.method2226(var4);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "638888823"
   )
   void method3878(int var1, int var2, int var3) {
      class212 var4 = this.field2622[var1][var2];
      if(var4 != null) {
         this.field2622[var1][var2] = null;
         if((this.field2616[var1] & 2) != 0) {
            for(class212 var5 = (class212)this.field2608.field2677.getFront(); var5 != null; var5 = (class212)this.field2608.field2677.getNext()) {
               if(var5.field2637 == var4.field2637 && var5.field2646 < 0 && var5 != var4) {
                  var4.field2646 = 0;
                  break;
               }
            }
         } else {
            var4.field2646 = 0;
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "634834961"
   )
   void method3868(int var1, int var2, int var3) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1433375123"
   )
   void method3879(int var1, int var2) {
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1045119088"
   )
   void method3896(int var1, int var2) {
      this.field2612[var1] = var2;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-925679224"
   )
   void method3871(int var1) {
      for(class212 var2 = (class212)this.field2608.field2677.getFront(); var2 != null; var2 = (class212)this.field2608.field2677.getNext()) {
         if(var1 < 0 || var2.field2637 == var1) {
            if(var2.field2645 != null) {
               var2.field2645.method2231(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2645.method2280()) {
                  this.field2608.field2675.method1972(var2.field2645);
               }

               var2.method3980();
            }

            if(var2.field2646 < 0) {
               this.field2622[var2.field2637][var2.field2650] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2030146497"
   )
   void method3906(int var1) {
      if(var1 >= 0) {
         this.field2606[var1] = 12800;
         this.field2610[var1] = 8192;
         this.field2630[var1] = 16383;
         this.field2612[var1] = 8192;
         this.field2626[var1] = 0;
         this.field2614[var1] = 8192;
         this.method3875(var1);
         this.method3876(var1);
         this.field2616[var1] = 0;
         this.field2617[var1] = 32767;
         this.field2618[var1] = 256;
         this.field2619[var1] = 0;
         this.method3886(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3906(var1);
         }

      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1229174847"
   )
   void method3923(int var1) {
      for(class212 var2 = (class212)this.field2608.field2677.getFront(); var2 != null; var2 = (class212)this.field2608.field2677.getNext()) {
         if((var1 < 0 || var2.field2637 == var1) && var2.field2646 < 0) {
            this.field2622[var2.field2637][var2.field2650] = null;
            var2.field2646 = 0;
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-417004551"
   )
   void method3874() {
      this.method3871(-1);
      this.method3906(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2603[var1] = this.field2621[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2611[var1] = this.field2621[var1] & -128;
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2069997905"
   )
   void method3875(int var1) {
      if((this.field2616[var1] & 2) != 0) {
         for(class212 var2 = (class212)this.field2608.field2677.getFront(); var2 != null; var2 = (class212)this.field2608.field2677.getNext()) {
            if(var2.field2637 == var1 && this.field2622[var1][var2.field2650] == null && var2.field2646 < 0) {
               var2.field2646 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-7542"
   )
   void method3876(int var1) {
      if((this.field2616[var1] & 4) != 0) {
         for(class212 var2 = (class212)this.field2608.field2677.getFront(); var2 != null; var2 = (class212)this.field2608.field2677.getNext()) {
            if(var2.field2637 == var1) {
               var2.field2652 = 0;
            }
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1548808979"
   )
   void method3877(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3878(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3865(var3, var4, var5);
         } else {
            this.method3878(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3868(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2611[var3] = (var5 << 14) + (this.field2611[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2611[var3] = (var5 << 7) + (this.field2611[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2626[var3] = (var5 << 7) + (this.field2626[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2626[var3] = var5 + (this.field2626[var3] & -128);
         }

         if(var4 == 5) {
            this.field2614[var3] = (var5 << 7) + (this.field2614[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2614[var3] = var5 + (this.field2614[var3] & -128);
         }

         if(var4 == 7) {
            this.field2606[var3] = (var5 << 7) + (this.field2606[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2606[var3] = var5 + (this.field2606[var3] & -128);
         }

         if(var4 == 10) {
            this.field2610[var3] = (var5 << 7) + (this.field2610[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2610[var3] = var5 + (this.field2610[var3] & -128);
         }

         if(var4 == 11) {
            this.field2630[var3] = (var5 << 7) + (this.field2630[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2630[var3] = var5 + (this.field2630[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2616[var3] |= 1;
            } else {
               this.field2616[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2616[var3] |= 2;
            } else {
               this.method3875(var3);
               this.field2616[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2617[var3] = (var5 << 7) + (this.field2617[var3] & 127);
         }

         if(var4 == 98) {
            this.field2617[var3] = (this.field2617[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2617[var3] = (var5 << 7) + (this.field2617[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2617[var3] = (this.field2617[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3871(var3);
         }

         if(var4 == 121) {
            this.method3906(var3);
         }

         if(var4 == 123) {
            this.method3923(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2617[var3];
            if(var6 == 16384) {
               this.field2618[var3] = (var5 << 7) + (this.field2618[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2617[var3];
            if(var6 == 16384) {
               this.field2618[var3] = var5 + (this.field2618[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2619[var3] = (var5 << 7) + (this.field2619[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2619[var3] = var5 + (this.field2619[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2616[var3] |= 4;
            } else {
               this.method3876(var3);
               this.field2616[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3886(var3, (var5 << 7) + (this.field2620[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3886(var3, var5 + (this.field2620[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3864(var3, var4 + this.field2611[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3879(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3896(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3874();
         }
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1759259639"
   )
   void method3886(int var1, int var2) {
      this.field2620[var1] = var2;
      this.field2613[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lhg;I)I",
      garbageValue = "165468339"
   )
   int method3908(class212 var1) {
      int var2 = (var1.field2641 * var1.field2636 >> 12) + var1.field2644;
      var2 += (this.field2612[var1.field2637] - 8192) * this.field2618[var1.field2637] >> 12;
      class209 var3 = var1.field2635;
      int var4;
      if(var3.field2586 > 0 && (var3.field2588 > 0 || this.field2626[var1.field2637] > 0)) {
         var4 = var3.field2588 << 2;
         int var5 = var3.field2587 << 1;
         if(var1.field2648 < var5) {
            var4 = var4 * var1.field2648 / var5;
         }

         var4 += this.field2626[var1.field2637] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2632 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2642.field1528 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lhg;B)I",
      garbageValue = "1"
   )
   int method3927(class212 var1) {
      class209 var2 = var1.field2635;
      int var3 = this.field2630[var1.field2637] * this.field2606[var1.field2637] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2638 + 16384 >> 15;
      var3 = var3 * this.field2604 + 128 >> 8;
      if(var2.field2584 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2584 * (double)var1.field2643 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2590 != null) {
         var4 = var1.field2649;
         var5 = var2.field2590[var1.field2634 + 1];
         if(var1.field2634 < var2.field2590.length - 2) {
            var6 = (var2.field2590[var1.field2634] & 255) << 8;
            var7 = (var2.field2590[var1.field2634 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2590[var1.field2634 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2646 > 0 && var2.field2583 != null) {
         var4 = var1.field2646;
         var5 = var2.field2583[var1.field2647 + 1];
         if(var1.field2647 < var2.field2583.length - 2) {
            var6 = (var2.field2583[var1.field2647] & 255) << 8;
            var7 = (var2.field2583[var1.field2647 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2583[var1.field2647 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lhg;I)I",
      garbageValue = "-790079647"
   )
   int method3881(class212 var1) {
      int var2 = this.field2610[var1.field2637];
      return var2 < 8192?var2 * var1.field2639 + 32 >> 6:16384 - ((128 - var1.field2639) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "87"
   )
   void method3887() {
      int var1 = this.field2623;
      int var2 = this.field2627;

      long var3;
      for(var3 = this.field2629; var2 == this.field2627; var3 = this.field2624.method3994(var2)) {
         while(var2 == this.field2624.field2657[var1]) {
            this.field2624.method3987(var1);
            int var5 = this.field2624.method4012(var1);
            if(var5 == 1) {
               this.field2624.method3989();
               this.field2624.method3988(var1);
               if(this.field2624.method3996()) {
                  if(!this.field2625 || var2 == 0) {
                     this.method3874();
                     this.field2624.method3984();
                     return;
                  }

                  this.field2624.method3997(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3877(var5);
            }

            this.field2624.method3990(var1);
            this.field2624.method3988(var1);
         }

         var1 = this.field2624.method3995();
         var2 = this.field2624.field2657[var1];
      }

      this.field2623 = var1;
      this.field2627 = var2;
      this.field2629 = var3;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(Lhg;I)Z",
      garbageValue = "1837698989"
   )
   boolean method3962(class212 var1) {
      if(var1.field2645 == null) {
         if(var1.field2646 >= 0) {
            var1.unlink();
            if(var1.field2640 > 0 && var1 == this.field2631[var1.field2637][var1.field2640]) {
               this.field2631[var1.field2637][var1.field2640] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(Lhg;[IIIS)Z",
      garbageValue = "30255"
   )
   boolean method3889(class212 var1, int[] var2, int var3, int var4) {
      var1.field2651 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2646 < 0 || var1.field2645 != null && !var1.field2645.method2212()) {
         int var5 = var1.field2636;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2614[var1.field2637]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2636 = var5;
         }

         var1.field2645.method2242(this.method3908(var1));
         class209 var6 = var1.field2635;
         boolean var7 = false;
         ++var1.field2648;
         var1.field2632 += var6.field2586;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2650 - 60 << 8) + (var1.field2641 * var1.field2636 >> 12));
         if(var6.field2584 > 0) {
            if(var6.field2589 > 0) {
               var1.field2643 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2589) + 0.5D);
            } else {
               var1.field2643 += 128;
            }
         }

         if(var6.field2590 != null) {
            if(var6.field2585 > 0) {
               var1.field2649 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2585) + 0.5D);
            } else {
               var1.field2649 += 128;
            }

            while(var1.field2634 < var6.field2590.length - 2 && var1.field2649 > (var6.field2590[var1.field2634 + 2] & 255) << 8) {
               var1.field2634 += 2;
            }

            if(var6.field2590.length - 2 == var1.field2634 && var6.field2590[var1.field2634 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2646 >= 0 && var6.field2583 != null && (this.field2616[var1.field2637] & 1) == 0 && (var1.field2640 < 0 || var1 != this.field2631[var1.field2637][var1.field2640])) {
            if(var6.field2582 > 0) {
               var1.field2646 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2582) + 0.5D);
            } else {
               var1.field2646 += 128;
            }

            while(var1.field2647 < var6.field2583.length - 2 && var1.field2646 > (var6.field2583[var1.field2647 + 2] & 255) << 8) {
               var1.field2647 += 2;
            }

            if(var6.field2583.length - 2 == var1.field2647) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2645.method2231(var1.field2651);
            if(var2 != null) {
               var1.field2645.vmethod4050(var2, var3, var4);
            } else {
               var1.field2645.vmethod4051(var4);
            }

            if(var1.field2645.method2280()) {
               this.field2608.field2675.method1972(var1.field2645);
            }

            var1.method3980();
            if(var1.field2646 >= 0) {
               var1.unlink();
               if(var1.field2640 > 0 && var1 == this.field2631[var1.field2637][var1.field2640]) {
                  this.field2631[var1.field2637][var1.field2640] = null;
               }
            }

            return true;
         } else {
            var1.field2645.method2327(var1.field2651, this.method3927(var1), this.method3881(var1));
            return false;
         }
      } else {
         var1.method3980();
         var1.unlink();
         if(var1.field2640 > 0 && var1 == this.field2631[var1.field2637][var1.field2640]) {
            this.field2631[var1.field2637][var1.field2640] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2083032661"
   )
   static final void method3979() {
      for(int var0 = 0; var0 < Client.npcIndexesCount; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            ServerPacket.method3181(var2, var2.composition.field3625);
         }
      }

   }
}
