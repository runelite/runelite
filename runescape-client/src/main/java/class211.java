import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class211 extends class118 {
   @ObfuscatedName("fm")
   @ObfuscatedGetter(
      intValue = -1934849199
   )
   static int field2628;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   HashTable field2602;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1843408179
   )
   int field2611;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1781149017
   )
   int field2617;
   @ObfuscatedName("z")
   int[] field2603;
   @ObfuscatedName("v")
   int[] field2604;
   @ObfuscatedName("m")
   int[] field2601;
   @ObfuscatedName("b")
   int[] field2621;
   @ObfuscatedName("t")
   int[] field2607;
   @ObfuscatedName("p")
   int[] field2609;
   @ObfuscatedName("r")
   int[] field2615;
   @ObfuscatedName("l")
   int[] field2610;
   @ObfuscatedName("u")
   int[] field2608;
   @ObfuscatedName("q")
   int[] field2612;
   @ObfuscatedName("h")
   int[] field2613;
   @ObfuscatedName("i")
   int[] field2614;
   @ObfuscatedName("o")
   int[] field2606;
   @ObfuscatedName("w")
   int[] field2616;
   @ObfuscatedName("g")
   int[] field2624;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[[Lha;"
   )
   class212[][] field2618;
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "[[Lha;"
   )
   class212[][] field2619;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   class213 field2620;
   @ObfuscatedName("aa")
   boolean field2605;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 375795365
   )
   int field2622;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 812760117
   )
   int field2623;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      longValue = 5908976888062114387L
   )
   long field2600;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      longValue = 5582820523630728683L
   )
   long field2625;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   class215 field2626;

   public class211() {
      this.field2611 = 256;
      this.field2617 = 1000000;
      this.field2603 = new int[16];
      this.field2604 = new int[16];
      this.field2601 = new int[16];
      this.field2621 = new int[16];
      this.field2607 = new int[16];
      this.field2609 = new int[16];
      this.field2615 = new int[16];
      this.field2610 = new int[16];
      this.field2608 = new int[16];
      this.field2612 = new int[16];
      this.field2613 = new int[16];
      this.field2614 = new int[16];
      this.field2606 = new int[16];
      this.field2616 = new int[16];
      this.field2624 = new int[16];
      this.field2618 = new class212[16][128];
      this.field2619 = new class212[16][128];
      this.field2620 = new class213();
      this.field2626 = new class215(this);
      this.field2602 = new HashTable(128);
      this.method3877();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1776307628"
   )
   public synchronized void method3857(int var1) {
      this.field2611 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2094009899"
   )
   int method3903() {
      return this.field2611;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lht;Lid;Lds;II)Z",
      garbageValue = "-632067635"
   )
   public synchronized boolean method3859(Track1 var1, IndexDataBase var2, class111 var3, int var4) {
      var1.method4084();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(class206 var7 = (class206)var1.field2680.method3707(); var7 != null; var7 = (class206)var1.field2680.method3703()) {
         int var8 = (int)var7.hash;
         class214 var9 = (class214)this.field2602.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.method4271(var8);
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

            this.field2602.put(var10, (long)var8);
         }

         if(!var9.method4043(var3, var7.field2579, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4081();
      }

      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "92"
   )
   public synchronized void method3864() {
      for(class214 var1 = (class214)this.field2602.method3707(); var1 != null; var1 = (class214)this.field2602.method3703()) {
         var1.method4048();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-881376199"
   )
   synchronized void method3907() {
      for(class214 var1 = (class214)this.field2602.method3707(); var1 != null; var1 = (class214)this.field2602.method3703()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected synchronized class118 vmethod4054() {
      return this.field2626;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected synchronized class118 vmethod4055() {
      return null;
   }

   @ObfuscatedName("t")
   protected synchronized int vmethod4056() {
      return 0;
   }

   @ObfuscatedName("p")
   protected synchronized void vmethod4057(int[] var1, int var2, int var3) {
      if(this.field2620.method3989()) {
         int var4 = this.field2620.field2652 * this.field2617 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = this.field2600 + (long)var3 * (long)var4;
            if(this.field2625 - var5 >= 0L) {
               this.field2600 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2625 - this.field2600) - 1L) / (long)var4);
            this.field2600 += (long)var4 * (long)var7;
            this.field2626.vmethod4057(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3890();
         } while(this.field2620.method3989());
      }

      this.field2626.vmethod4057(var1, var2, var3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lht;ZI)V",
      garbageValue = "468010485"
   )
   public synchronized void method3892(Track1 var1, boolean var2) {
      this.method3863();
      this.field2620.method3987(var1.field2679);
      this.field2605 = var2;
      this.field2600 = 0L;
      int var3 = this.field2620.method3990();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2620.method3991(var4);
         this.field2620.method3994(var4);
         this.field2620.method4001(var4);
      }

      this.field2622 = this.field2620.method4024();
      this.field2623 = this.field2620.field2655[this.field2622];
      this.field2625 = this.field2620.method3998(this.field2623);
   }

   @ObfuscatedName("l")
   protected synchronized void vmethod4058(int var1) {
      if(this.field2620.method3989()) {
         int var2 = this.field2620.field2652 * this.field2617 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = (long)var2 * (long)var1 + this.field2600;
            if(this.field2625 - var3 >= 0L) {
               this.field2600 = var3;
               break;
            }

            int var5 = (int)((this.field2625 - this.field2600 + (long)var2 - 1L) / (long)var2);
            this.field2600 += (long)var5 * (long)var2;
            this.field2626.vmethod4058(var5);
            var1 -= var5;
            this.method3890();
         } while(this.field2620.method3989());
      }

      this.field2626.vmethod4058(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1034135349"
   )
   public synchronized void method3863() {
      this.field2620.method3988();
      this.method3877();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-30607"
   )
   synchronized boolean method3948() {
      return this.field2620.method3989();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1010823915"
   )
   public synchronized void method3865(int var1, int var2) {
      this.method3955(var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "81890158"
   )
   void method3955(int var1, int var2) {
      this.field2621[var1] = var2;
      this.field2609[var1] = var2 & -128;
      this.method3939(var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-20"
   )
   void method3939(int var1, int var2) {
      if(var2 != this.field2607[var1]) {
         this.field2607[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2619[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1075874937"
   )
   void method3946(int var1, int var2, int var3) {
      this.method3856(var1, var2, 64);
      if((this.field2612[var1] & 2) != 0) {
         for(class212 var4 = (class212)this.field2626.field2676.getTail(); var4 != null; var4 = (class212)this.field2626.field2676.getPrevious()) {
            if(var4.field2647 == var1 && var4.field2648 < 0) {
               this.field2618[var1][var4.field2634] = null;
               this.field2618[var1][var2] = var4;
               int var5 = (var4.field2638 * var4.field2639 >> 12) + var4.field2637;
               var4.field2637 += var2 - var4.field2634 << 8;
               var4.field2638 = var5 - var4.field2637;
               var4.field2639 = 4096;
               var4.field2634 = var2;
               return;
            }
         }
      }

      class214 var9 = (class214)this.field2602.get((long)this.field2607[var1]);
      if(var9 != null) {
         class106 var8 = var9.field2666[var2];
         if(var8 != null) {
            class212 var6 = new class212();
            var6.field2647 = var1;
            var6.field2644 = var9;
            var6.field2630 = var8;
            var6.field2632 = var9.field2670[var2];
            var6.field2633 = var9.field2671[var2];
            var6.field2634 = var2;
            var6.field2635 = var3 * var3 * var9.field2669[var2] * var9.field2668 + 1024 >> 11;
            var6.field2636 = var9.field2665[var2] & 255;
            var6.field2637 = (var2 << 8) - (var9.field2667[var2] & 32767);
            var6.field2643 = 0;
            var6.field2641 = 0;
            var6.field2642 = 0;
            var6.field2648 = -1;
            var6.field2629 = 0;
            if(this.field2606[var1] == 0) {
               var6.field2631 = class116.method2228(var8, this.method3882(var6), this.method3883(var6), this.method3884(var6));
            } else {
               var6.field2631 = class116.method2228(var8, this.method3882(var6), 0, this.method3884(var6));
               this.method3869(var6, var9.field2667[var2] < 0);
            }

            if(var9.field2667[var2] < 0) {
               var6.field2631.method2230(-1);
            }

            if(var6.field2633 >= 0) {
               class212 var7 = this.field2619[var1][var6.field2633];
               if(var7 != null && var7.field2648 < 0) {
                  this.field2618[var1][var7.field2634] = null;
                  var7.field2648 = 0;
               }

               this.field2619[var1][var6.field2633] = var6;
            }

            this.field2626.field2676.addFront(var6);
            this.field2618[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lha;ZB)V",
      garbageValue = "40"
   )
   void method3869(class212 var1, boolean var2) {
      int var3 = var1.field2630.field1527.length;
      int var4;
      if(var2 && var1.field2630.field1530) {
         int var5 = var3 + var3 - var1.field2630.field1529;
         var4 = (int)((long)var5 * (long)this.field2606[var1.field2647] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2631.method2237();
         }
      } else {
         var4 = (int)((long)this.field2606[var1.field2647] * (long)var3 >> 6);
      }

      var1.field2631.method2236(var4);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-529259804"
   )
   void method3856(int var1, int var2, int var3) {
      class212 var4 = this.field2618[var1][var2];
      if(var4 != null) {
         this.field2618[var1][var2] = null;
         if((this.field2612[var1] & 2) != 0) {
            for(class212 var5 = (class212)this.field2626.field2676.getFront(); var5 != null; var5 = (class212)this.field2626.field2676.getNext()) {
               if(var4.field2647 == var5.field2647 && var5.field2648 < 0 && var5 != var4) {
                  var4.field2648 = 0;
                  break;
               }
            }
         } else {
            var4.field2648 = 0;
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-45"
   )
   void method3861(int var1, int var2, int var3) {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2007556468"
   )
   void method3894(int var1, int var2) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1589413565"
   )
   void method3941(int var1, int var2) {
      this.field2615[var1] = var2;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2143302709"
   )
   void method3874(int var1) {
      for(class212 var2 = (class212)this.field2626.field2676.getFront(); var2 != null; var2 = (class212)this.field2626.field2676.getNext()) {
         if(var1 < 0 || var2.field2647 == var1) {
            if(var2.field2631 != null) {
               var2.field2631.method2229(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2631.method2300()) {
                  this.field2626.field2677.method1953(var2.field2631);
               }

               var2.method3981();
            }

            if(var2.field2648 < 0) {
               this.field2618[var2.field2647][var2.field2634] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1900293227"
   )
   void method3956(int var1) {
      if(var1 >= 0) {
         this.field2603[var1] = 12800;
         this.field2604[var1] = 8192;
         this.field2601[var1] = 16383;
         this.field2615[var1] = 8192;
         this.field2610[var1] = 0;
         this.field2608[var1] = 8192;
         this.method3878(var1);
         this.method3879(var1);
         this.field2612[var1] = 0;
         this.field2613[var1] = 32767;
         this.field2614[var1] = 256;
         this.field2606[var1] = 0;
         this.method3881(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3956(var1);
         }

      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-409717"
   )
   void method3876(int var1) {
      for(class212 var2 = (class212)this.field2626.field2676.getFront(); var2 != null; var2 = (class212)this.field2626.field2676.getNext()) {
         if((var1 < 0 || var2.field2647 == var1) && var2.field2648 < 0) {
            this.field2618[var2.field2647][var2.field2634] = null;
            var2.field2648 = 0;
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1389658800"
   )
   void method3877() {
      this.method3874(-1);
      this.method3956(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2607[var1] = this.field2621[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2609[var1] = this.field2621[var1] & -128;
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1538361059"
   )
   void method3878(int var1) {
      if((this.field2612[var1] & 2) != 0) {
         for(class212 var2 = (class212)this.field2626.field2676.getFront(); var2 != null; var2 = (class212)this.field2626.field2676.getNext()) {
            if(var2.field2647 == var1 && this.field2618[var1][var2.field2634] == null && var2.field2648 < 0) {
               var2.field2648 = 0;
            }
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "862635975"
   )
   void method3879(int var1) {
      if((this.field2612[var1] & 4) != 0) {
         for(class212 var2 = (class212)this.field2626.field2676.getFront(); var2 != null; var2 = (class212)this.field2626.field2676.getNext()) {
            if(var2.field2647 == var1) {
               var2.field2649 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-21685"
   )
   void method3880(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3856(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3946(var3, var4, var5);
         } else {
            this.method3856(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3861(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2609[var3] = (var5 << 14) + (this.field2609[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2609[var3] = (var5 << 7) + (this.field2609[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2610[var3] = (var5 << 7) + (this.field2610[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2610[var3] = var5 + (this.field2610[var3] & -128);
         }

         if(var4 == 5) {
            this.field2608[var3] = (var5 << 7) + (this.field2608[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2608[var3] = var5 + (this.field2608[var3] & -128);
         }

         if(var4 == 7) {
            this.field2603[var3] = (var5 << 7) + (this.field2603[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2603[var3] = var5 + (this.field2603[var3] & -128);
         }

         if(var4 == 10) {
            this.field2604[var3] = (var5 << 7) + (this.field2604[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2604[var3] = var5 + (this.field2604[var3] & -128);
         }

         if(var4 == 11) {
            this.field2601[var3] = (var5 << 7) + (this.field2601[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2601[var3] = var5 + (this.field2601[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2612[var3] |= 1;
            } else {
               this.field2612[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2612[var3] |= 2;
            } else {
               this.method3878(var3);
               this.field2612[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2613[var3] = (var5 << 7) + (this.field2613[var3] & 127);
         }

         if(var4 == 98) {
            this.field2613[var3] = (this.field2613[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2613[var3] = (var5 << 7) + (this.field2613[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2613[var3] = (this.field2613[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3874(var3);
         }

         if(var4 == 121) {
            this.method3956(var3);
         }

         if(var4 == 123) {
            this.method3876(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2613[var3];
            if(var6 == 16384) {
               this.field2614[var3] = (var5 << 7) + (this.field2614[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2613[var3];
            if(var6 == 16384) {
               this.field2614[var3] = var5 + (this.field2614[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2606[var3] = (var5 << 7) + (this.field2606[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2606[var3] = var5 + (this.field2606[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2612[var3] |= 4;
            } else {
               this.method3879(var3);
               this.field2612[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3881(var3, (var5 << 7) + (this.field2616[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3881(var3, var5 + (this.field2616[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3939(var3, var4 + this.field2609[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3894(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3941(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3877();
         }
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1510445213"
   )
   void method3881(int var1, int var2) {
      this.field2616[var1] = var2;
      this.field2624[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lha;I)I",
      garbageValue = "2010174489"
   )
   int method3882(class212 var1) {
      int var2 = (var1.field2638 * var1.field2639 >> 12) + var1.field2637;
      var2 += (this.field2615[var1.field2647] - 8192) * this.field2614[var1.field2647] >> 12;
      class209 var3 = var1.field2632;
      int var4;
      if(var3.field2591 > 0 && (var3.field2590 > 0 || this.field2610[var1.field2647] > 0)) {
         var4 = var3.field2590 << 2;
         int var5 = var3.field2586 << 1;
         if(var1.field2645 < var5) {
            var4 = var4 * var1.field2645 / var5;
         }

         var4 += this.field2610[var1.field2647] >> 7;
         double var6 = Math.sin((double)(var1.field2646 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2630.field1531 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lha;I)I",
      garbageValue = "339965860"
   )
   int method3883(class212 var1) {
      class209 var2 = var1.field2632;
      int var3 = this.field2603[var1.field2647] * this.field2601[var1.field2647] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2635 + 16384 >> 15;
      var3 = var3 * this.field2611 + 128 >> 8;
      if(var2.field2593 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field2643 * 1.953125E-5D * (double)var2.field2593) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2588 != null) {
         var4 = var1.field2641;
         var5 = var2.field2588[var1.field2642 + 1];
         if(var1.field2642 < var2.field2588.length - 2) {
            var6 = (var2.field2588[var1.field2642] & 255) << 8;
            var7 = (var2.field2588[var1.field2642 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2588[var1.field2642 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2648 > 0 && var2.field2585 != null) {
         var4 = var1.field2648;
         var5 = var2.field2585[var1.field2629 + 1];
         if(var1.field2629 < var2.field2585.length - 2) {
            var6 = (var2.field2585[var1.field2629] & 255) << 8;
            var7 = (var2.field2585[var1.field2629 + 2] & 255) << 8;
            var5 += (var2.field2585[var1.field2629 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(Lha;I)I",
      garbageValue = "527783538"
   )
   int method3884(class212 var1) {
      int var2 = this.field2604[var1.field2647];
      return var2 < 8192?var2 * var1.field2636 + 32 >> 6:16384 - ((128 - var1.field2636) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2116376092"
   )
   void method3890() {
      int var1 = this.field2622;
      int var2 = this.field2623;

      long var3;
      for(var3 = this.field2625; var2 == this.field2623; var3 = this.field2620.method3998(var2)) {
         while(var2 == this.field2620.field2655[var1]) {
            this.field2620.method3991(var1);
            int var5 = this.field2620.method4015(var1);
            if(var5 == 1) {
               this.field2620.method4010();
               this.field2620.method4001(var1);
               if(this.field2620.method4013()) {
                  if(!this.field2605 || var2 == 0) {
                     this.method3877();
                     this.field2620.method3988();
                     return;
                  }

                  this.field2620.method3999(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3880(var5);
            }

            this.field2620.method3994(var1);
            this.field2620.method4001(var1);
         }

         var1 = this.field2620.method4024();
         var2 = this.field2620.field2655[var1];
      }

      this.field2622 = var1;
      this.field2623 = var2;
      this.field2625 = var3;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(Lha;S)Z",
      garbageValue = "21951"
   )
   boolean method3959(class212 var1) {
      if(var1.field2631 == null) {
         if(var1.field2648 >= 0) {
            var1.unlink();
            if(var1.field2633 > 0 && var1 == this.field2619[var1.field2647][var1.field2633]) {
               this.field2619[var1.field2647][var1.field2633] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(Lha;[IIII)Z",
      garbageValue = "-2134107261"
   )
   boolean method3875(class212 var1, int[] var2, int var3, int var4) {
      var1.field2640 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2648 < 0 || var1.field2631 != null && !var1.field2631.method2244()) {
         int var5 = var1.field2639;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2608[var1.field2647]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2639 = var5;
         }

         var1.field2631.method2242(this.method3882(var1));
         class209 var6 = var1.field2632;
         boolean var7 = false;
         ++var1.field2645;
         var1.field2646 += var6.field2591;
         double var8 = (double)((var1.field2634 - 60 << 8) + (var1.field2639 * var1.field2638 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2593 > 0) {
            if(var6.field2589 > 0) {
               var1.field2643 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2589) + 0.5D);
            } else {
               var1.field2643 += 128;
            }
         }

         if(var6.field2588 != null) {
            if(var6.field2592 > 0) {
               var1.field2641 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2592 * var8) + 0.5D);
            } else {
               var1.field2641 += 128;
            }

            while(var1.field2642 < var6.field2588.length - 2 && var1.field2641 > (var6.field2588[var1.field2642 + 2] & 255) << 8) {
               var1.field2642 += 2;
            }

            if(var6.field2588.length - 2 == var1.field2642 && var6.field2588[var1.field2642 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2648 >= 0 && var6.field2585 != null && (this.field2612[var1.field2647] & 1) == 0 && (var1.field2633 < 0 || var1 != this.field2619[var1.field2647][var1.field2633])) {
            if(var6.field2587 > 0) {
               var1.field2648 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2587 * var8) + 0.5D);
            } else {
               var1.field2648 += 128;
            }

            while(var1.field2629 < var6.field2585.length - 2 && var1.field2648 > (var6.field2585[var1.field2629 + 2] & 255) << 8) {
               var1.field2629 += 2;
            }

            if(var6.field2585.length - 2 == var1.field2629) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2631.method2229(var1.field2640);
            if(var2 != null) {
               var1.field2631.vmethod4057(var2, var3, var4);
            } else {
               var1.field2631.vmethod4058(var4);
            }

            if(var1.field2631.method2300()) {
               this.field2626.field2677.method1953(var1.field2631);
            }

            var1.method3981();
            if(var1.field2648 >= 0) {
               var1.unlink();
               if(var1.field2633 > 0 && var1 == this.field2619[var1.field2647][var1.field2633]) {
                  this.field2619[var1.field2647][var1.field2633] = null;
               }
            }

            return true;
         } else {
            var1.field2631.method2314(var1.field2640, this.method3883(var1), this.method3884(var1));
            return false;
         }
      } else {
         var1.method3981();
         var1.unlink();
         if(var1.field2633 > 0 && var1 == this.field2619[var1.field2647][var1.field2633]) {
            this.field2619[var1.field2647][var1.field2633] = null;
         }

         return true;
      }
   }
}
