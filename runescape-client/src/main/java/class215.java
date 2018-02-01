import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class215 extends TaskDataNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   HashTable field2619;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1193401003
   )
   int field2617;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 577310371
   )
   int field2603;
   @ObfuscatedName("j")
   int[] field2604;
   @ObfuscatedName("a")
   int[] field2610;
   @ObfuscatedName("t")
   int[] field2611;
   @ObfuscatedName("r")
   int[] field2607;
   @ObfuscatedName("m")
   int[] field2602;
   @ObfuscatedName("h")
   int[] field2609;
   @ObfuscatedName("o")
   int[] field2630;
   @ObfuscatedName("x")
   int[] field2605;
   @ObfuscatedName("q")
   int[] field2612;
   @ObfuscatedName("k")
   int[] field2601;
   @ObfuscatedName("e")
   int[] field2616;
   @ObfuscatedName("u")
   int[] field2628;
   @ObfuscatedName("g")
   int[] field2618;
   @ObfuscatedName("z")
   int[] field2606;
   @ObfuscatedName("b")
   int[] field2620;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[[Lhz;"
   )
   class216[][] field2621;
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "[[Lhz;"
   )
   class216[][] field2622;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   class217 field2623;
   @ObfuscatedName("ao")
   boolean field2624;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -434346371
   )
   int field2625;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -916671551
   )
   int field2626;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = -3883831430306790315L
   )
   long field2627;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      longValue = 5018769056305603257L
   )
   long field2608;
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   class219 field2629;

   public class215() {
      this.field2617 = 256;
      this.field2603 = 1000000;
      this.field2604 = new int[16];
      this.field2610 = new int[16];
      this.field2611 = new int[16];
      this.field2607 = new int[16];
      this.field2602 = new int[16];
      this.field2609 = new int[16];
      this.field2630 = new int[16];
      this.field2605 = new int[16];
      this.field2612 = new int[16];
      this.field2601 = new int[16];
      this.field2616 = new int[16];
      this.field2628 = new int[16];
      this.field2618 = new int[16];
      this.field2606 = new int[16];
      this.field2620 = new int[16];
      this.field2621 = new class216[16][128];
      this.field2622 = new class216[16][128];
      this.field2623 = new class217();
      this.field2629 = new class219(this);
      this.field2619 = new HashTable(128);
      this.method3976();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1409450427"
   )
   public synchronized void method3956(int var1) {
      this.field2617 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2123598917"
   )
   int method3957() {
      return this.field2617;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lhk;Lik;Lde;II)Z",
      garbageValue = "1328595697"
   )
   public synchronized boolean method4057(Track1 var1, IndexDataBase var2, class109 var3, int var4) {
      var1.method4163();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2682.first(); var7 != null; var7 = (ByteArrayNode)var1.field2682.next()) {
         int var8 = (int)var7.hash;
         class218 var9 = (class218)this.field2619.get((long)var8);
         if(var9 == null) {
            var9 = NetWriter.method2043(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2619.put(var9, (long)var8);
         }

         if(!var9.method4131(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4164();
      }

      return var5;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "25"
   )
   public synchronized void method4044() {
      for(class218 var1 = (class218)this.field2619.first(); var1 != null; var1 = (class218)this.field2619.next()) {
         var1.method4132();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-446911650"
   )
   synchronized void method4009() {
      for(class218 var1 = (class218)this.field2619.first(); var1 != null; var1 = (class218)this.field2619.next()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Ldj;"
   )
   protected synchronized TaskDataNode vmethod4155() {
      return this.field2629;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldj;"
   )
   protected synchronized TaskDataNode vmethod4141() {
      return null;
   }

   @ObfuscatedName("r")
   protected synchronized int vmethod4158() {
      return 0;
   }

   @ObfuscatedName("m")
   protected synchronized void vmethod4145(int[] var1, int var2, int var3) {
      if(this.field2623.method4082()) {
         int var4 = this.field2623.field2653 * this.field2603 / class20.sampleRate;

         do {
            long var5 = this.field2627 + (long)var4 * (long)var3;
            if(this.field2608 - var5 >= 0L) {
               this.field2627 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2608 - this.field2627) - 1L) / (long)var4);
            this.field2627 += (long)var4 * (long)var7;
            this.field2629.vmethod4145(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3989();
         } while(this.field2623.method4082());
      }

      this.field2629.vmethod4145(var1, var2, var3);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lhk;ZB)V",
      garbageValue = "1"
   )
   public synchronized void method3961(Track1 var1, boolean var2) {
      this.method3962();
      this.field2623.method4095(var1.field2681);
      this.field2624 = var2;
      this.field2627 = 0L;
      int var3 = this.field2623.method4083();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2623.method4084(var4);
         this.field2623.method4087(var4);
         this.field2623.method4085(var4);
      }

      this.field2625 = this.field2623.method4091();
      this.field2626 = this.field2623.field2656[this.field2625];
      this.field2608 = this.field2623.method4096(this.field2626);
   }

   @ObfuscatedName("o")
   protected synchronized void vmethod4144(int var1) {
      if(this.field2623.method4082()) {
         int var2 = this.field2623.field2653 * this.field2603 / class20.sampleRate;

         do {
            long var3 = (long)var2 * (long)var1 + this.field2627;
            if(this.field2608 - var3 >= 0L) {
               this.field2627 = var3;
               break;
            }

            int var5 = (int)((this.field2608 - this.field2627 + (long)var2 - 1L) / (long)var2);
            this.field2627 += (long)var5 * (long)var2;
            this.field2629.vmethod4144(var5);
            var1 -= var5;
            this.method3989();
         } while(this.field2623.method4082());
      }

      this.field2629.vmethod4144(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-407815746"
   )
   public synchronized void method3962() {
      this.field2623.method4081();
      this.method3976();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "549309857"
   )
   synchronized boolean method3963() {
      return this.field2623.method4082();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "190088429"
   )
   public synchronized void method3964(int var1, int var2) {
      this.method3965(var1, var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1815083083"
   )
   void method3965(int var1, int var2) {
      this.field2607[var1] = var2;
      this.field2609[var1] = var2 & -128;
      this.method3955(var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "18"
   )
   void method3955(int var1, int var2) {
      if(var2 != this.field2602[var1]) {
         this.field2602[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2622[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1750325725"
   )
   void method3959(int var1, int var2, int var3) {
      this.method3969(var1, var2, 64);
      if((this.field2601[var1] & 2) != 0) {
         for(class216 var4 = (class216)this.field2629.field2676.getTail(); var4 != null; var4 = (class216)this.field2629.field2676.getPrevious()) {
            if(var4.field2648 == var1 && var4.field2631 < 0) {
               this.field2621[var1][var4.field2636] = null;
               this.field2621[var1][var2] = var4;
               int var5 = (var4.field2641 * var4.field2640 >> 12) + var4.field2639;
               var4.field2639 += var2 - var4.field2636 << 8;
               var4.field2640 = var5 - var4.field2639;
               var4.field2641 = 4096;
               var4.field2636 = var2;
               return;
            }
         }
      }

      class218 var9 = (class218)this.field2619.get((long)this.field2602[var1]);
      if(var9 != null) {
         RawAudioNode var8 = var9.field2669[var2];
         if(var8 != null) {
            class216 var6 = new class216();
            var6.field2648 = var1;
            var6.field2651 = var9;
            var6.field2633 = var8;
            var6.field2634 = var9.field2671[var2];
            var6.field2635 = var9.field2672[var2];
            var6.field2636 = var2;
            var6.field2637 = var3 * var3 * var9.field2666[var2] * var9.field2668 + 1024 >> 11;
            var6.field2638 = var9.field2670[var2] & 255;
            var6.field2639 = (var2 << 8) - (var9.field2674[var2] & 32767);
            var6.field2642 = 0;
            var6.field2643 = 0;
            var6.field2644 = 0;
            var6.field2631 = -1;
            var6.field2632 = 0;
            if(this.field2618[var1] == 0) {
               var6.field2649 = class114.method2420(var8, this.method3981(var6), this.method3982(var6), this.method3983(var6));
            } else {
               var6.field2649 = class114.method2420(var8, this.method3981(var6), 0, this.method3983(var6));
               this.method4001(var6, var9.field2674[var2] < 0);
            }

            if(var9.field2674[var2] < 0) {
               var6.field2649.method2288(-1);
            }

            if(var6.field2635 >= 0) {
               class216 var7 = this.field2622[var1][var6.field2635];
               if(var7 != null && var7.field2631 < 0) {
                  this.field2621[var1][var7.field2636] = null;
                  var7.field2631 = 0;
               }

               this.field2622[var1][var6.field2635] = var6;
            }

            this.field2629.field2676.addFront(var6);
            this.field2621[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lhz;ZI)V",
      garbageValue = "-191982531"
   )
   void method4001(class216 var1, boolean var2) {
      int var3 = var1.field2633.audioBuffer.length;
      int var4;
      if(var2 && var1.field2633.field1503) {
         int var5 = var3 + var3 - var1.field2633.startPosition;
         var4 = (int)((long)var5 * (long)this.field2618[var1.field2648] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2649.method2295();
         }
      } else {
         var4 = (int)((long)this.field2618[var1.field2648] * (long)var3 >> 6);
      }

      var1.field2649.method2294(var4);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "748111938"
   )
   void method3969(int var1, int var2, int var3) {
      class216 var4 = this.field2621[var1][var2];
      if(var4 != null) {
         this.field2621[var1][var2] = null;
         if((this.field2601[var1] & 2) != 0) {
            for(class216 var5 = (class216)this.field2629.field2676.getFront(); var5 != null; var5 = (class216)this.field2629.field2676.getNext()) {
               if(var4.field2648 == var5.field2648 && var5.field2631 < 0 && var4 != var5) {
                  var4.field2631 = 0;
                  break;
               }
            }
         } else {
            var4.field2631 = 0;
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "61"
   )
   void method4067(int var1, int var2, int var3) {
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1348564694"
   )
   void method3971(int var1, int var2) {
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "996880025"
   )
   void method3966(int var1, int var2) {
      this.field2630[var1] = var2;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-61"
   )
   void method3991(int var1) {
      for(class216 var2 = (class216)this.field2629.field2676.getFront(); var2 != null; var2 = (class216)this.field2629.field2676.getNext()) {
         if(var1 < 0 || var2.field2648 == var1) {
            if(var2.field2649 != null) {
               var2.field2649.method2299(class20.sampleRate / 100);
               if(var2.field2649.method2303()) {
                  this.field2629.field2679.method2080(var2.field2649);
               }

               var2.method4073();
            }

            if(var2.field2631 < 0) {
               this.field2621[var2.field2648][var2.field2636] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1504006688"
   )
   void method4060(int var1) {
      if(var1 >= 0) {
         this.field2604[var1] = 12800;
         this.field2610[var1] = 8192;
         this.field2611[var1] = 16383;
         this.field2630[var1] = 8192;
         this.field2605[var1] = 0;
         this.field2612[var1] = 8192;
         this.method4028(var1);
         this.method3978(var1);
         this.field2601[var1] = 0;
         this.field2616[var1] = 32767;
         this.field2628[var1] = 256;
         this.field2618[var1] = 0;
         this.method3980(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method4060(var1);
         }

      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "112"
   )
   void method4004(int var1) {
      for(class216 var2 = (class216)this.field2629.field2676.getFront(); var2 != null; var2 = (class216)this.field2629.field2676.getNext()) {
         if((var1 < 0 || var2.field2648 == var1) && var2.field2631 < 0) {
            this.field2621[var2.field2648][var2.field2636] = null;
            var2.field2631 = 0;
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1657274884"
   )
   void method3976() {
      this.method3991(-1);
      this.method4060(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2602[var1] = this.field2607[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2609[var1] = this.field2607[var1] & -128;
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-884427574"
   )
   void method4028(int var1) {
      if((this.field2601[var1] & 2) != 0) {
         for(class216 var2 = (class216)this.field2629.field2676.getFront(); var2 != null; var2 = (class216)this.field2629.field2676.getNext()) {
            if(var2.field2648 == var1 && this.field2621[var1][var2.field2636] == null && var2.field2631 < 0) {
               var2.field2631 = 0;
            }
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-579335852"
   )
   void method3978(int var1) {
      if((this.field2601[var1] & 4) != 0) {
         for(class216 var2 = (class216)this.field2629.field2676.getFront(); var2 != null; var2 = (class216)this.field2629.field2676.getNext()) {
            if(var2.field2648 == var1) {
               var2.field2646 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2141507575"
   )
   void method3979(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3969(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3959(var3, var4, var5);
         } else {
            this.method3969(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4067(var3, var4, var5);
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
            this.field2605[var3] = (var5 << 7) + (this.field2605[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2605[var3] = var5 + (this.field2605[var3] & -128);
         }

         if(var4 == 5) {
            this.field2612[var3] = (var5 << 7) + (this.field2612[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2612[var3] = var5 + (this.field2612[var3] & -128);
         }

         if(var4 == 7) {
            this.field2604[var3] = (var5 << 7) + (this.field2604[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2604[var3] = var5 + (this.field2604[var3] & -128);
         }

         if(var4 == 10) {
            this.field2610[var3] = (var5 << 7) + (this.field2610[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2610[var3] = var5 + (this.field2610[var3] & -128);
         }

         if(var4 == 11) {
            this.field2611[var3] = (var5 << 7) + (this.field2611[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2611[var3] = var5 + (this.field2611[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2601[var3] |= 1;
            } else {
               this.field2601[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2601[var3] |= 2;
            } else {
               this.method4028(var3);
               this.field2601[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2616[var3] = (var5 << 7) + (this.field2616[var3] & 127);
         }

         if(var4 == 98) {
            this.field2616[var3] = (this.field2616[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2616[var3] = (var5 << 7) + (this.field2616[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2616[var3] = (this.field2616[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3991(var3);
         }

         if(var4 == 121) {
            this.method4060(var3);
         }

         if(var4 == 123) {
            this.method4004(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2616[var3];
            if(var6 == 16384) {
               this.field2628[var3] = (var5 << 7) + (this.field2628[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2616[var3];
            if(var6 == 16384) {
               this.field2628[var3] = var5 + (this.field2628[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2618[var3] = (var5 << 7) + (this.field2618[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2618[var3] = var5 + (this.field2618[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2601[var3] |= 4;
            } else {
               this.method3978(var3);
               this.field2601[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3980(var3, (var5 << 7) + (this.field2606[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3980(var3, var5 + (this.field2606[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3955(var3, var4 + this.field2609[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3971(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3966(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3976();
         }
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1444696609"
   )
   void method3980(int var1, int var2) {
      this.field2606[var1] = var2;
      this.field2620[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lhz;I)I",
      garbageValue = "-1075416351"
   )
   int method3981(class216 var1) {
      int var2 = (var1.field2640 * var1.field2641 >> 12) + var1.field2639;
      var2 += (this.field2630[var1.field2648] - 8192) * this.field2628[var1.field2648] >> 12;
      class213 var3 = var1.field2634;
      int var4;
      if(var3.field2588 > 0 && (var3.field2589 > 0 || this.field2605[var1.field2648] > 0)) {
         var4 = var3.field2589 << 2;
         int var5 = var3.field2581 << 1;
         if(var1.field2647 < var5) {
            var4 = var4 * var1.field2647 / var5;
         }

         var4 += this.field2605[var1.field2648] >> 7;
         double var6 = Math.sin((double)(var1.field2645 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2633.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class20.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lhz;I)I",
      garbageValue = "-515834050"
   )
   int method3982(class216 var1) {
      class213 var2 = var1.field2634;
      int var3 = this.field2604[var1.field2648] * this.field2611[var1.field2648] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2637 + 16384 >> 15;
      var3 = var3 * this.field2617 + 128 >> 8;
      if(var2.field2587 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2587 * 1.953125E-5D * (double)var1.field2642) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2585 != null) {
         var4 = var1.field2643;
         var5 = var2.field2585[var1.field2644 + 1];
         if(var1.field2644 < var2.field2585.length - 2) {
            var6 = (var2.field2585[var1.field2644] & 255) << 8;
            var7 = (var2.field2585[var1.field2644 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2585[var1.field2644 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2631 > 0 && var2.field2582 != null) {
         var4 = var1.field2631;
         var5 = var2.field2582[var1.field2632 + 1];
         if(var1.field2632 < var2.field2582.length - 2) {
            var6 = (var2.field2582[var1.field2632] & 255) << 8;
            var7 = (var2.field2582[var1.field2632 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2582[var1.field2632 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lhz;B)I",
      garbageValue = "70"
   )
   int method3983(class216 var1) {
      int var2 = this.field2610[var1.field2648];
      return var2 < 8192?var2 * var1.field2638 + 32 >> 6:16384 - ((128 - var1.field2638) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-57"
   )
   void method3989() {
      int var1 = this.field2625;
      int var2 = this.field2626;

      long var3;
      for(var3 = this.field2608; var2 == this.field2626; var3 = this.field2623.method4096(var2)) {
         while(var2 == this.field2623.field2656[var1]) {
            this.field2623.method4084(var1);
            int var5 = this.field2623.method4088(var1);
            if(var5 == 1) {
               this.field2623.method4122();
               this.field2623.method4085(var1);
               if(this.field2623.method4092()) {
                  if(!this.field2624 || var2 == 0) {
                     this.method3976();
                     this.field2623.method4081();
                     return;
                  }

                  this.field2623.method4126(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3979(var5);
            }

            this.field2623.method4087(var1);
            this.field2623.method4085(var1);
         }

         var1 = this.field2623.method4091();
         var2 = this.field2623.field2656[var1];
      }

      this.field2625 = var1;
      this.field2626 = var2;
      this.field2608 = var3;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lhz;B)Z",
      garbageValue = "-104"
   )
   boolean method3990(class216 var1) {
      if(var1.field2649 == null) {
         if(var1.field2631 >= 0) {
            var1.unlink();
            if(var1.field2635 > 0 && var1 == this.field2622[var1.field2648][var1.field2635]) {
               this.field2622[var1.field2648][var1.field2635] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lhz;[IIII)Z",
      garbageValue = "486839546"
   )
   boolean method4050(class216 var1, int[] var2, int var3, int var4) {
      var1.field2650 = class20.sampleRate / 100;
      if(var1.field2631 < 0 || var1.field2649 != null && !var1.field2649.method2302()) {
         int var5 = var1.field2641;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2612[var1.field2648] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2641 = var5;
         }

         var1.field2649.method2300(this.method3981(var1));
         class213 var6 = var1.field2634;
         boolean var7 = false;
         ++var1.field2647;
         var1.field2645 += var6.field2588;
         double var8 = (double)((var1.field2636 - 60 << 8) + (var1.field2641 * var1.field2640 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2587 > 0) {
            if(var6.field2586 > 0) {
               var1.field2642 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2586 * var8) + 0.5D);
            } else {
               var1.field2642 += 128;
            }
         }

         if(var6.field2585 != null) {
            if(var6.field2584 > 0) {
               var1.field2643 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2584) + 0.5D);
            } else {
               var1.field2643 += 128;
            }

            while(var1.field2644 < var6.field2585.length - 2 && var1.field2643 > (var6.field2585[var1.field2644 + 2] & 255) << 8) {
               var1.field2644 += 2;
            }

            if(var6.field2585.length - 2 == var1.field2644 && var6.field2585[var1.field2644 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2631 >= 0 && var6.field2582 != null && (this.field2601[var1.field2648] & 1) == 0 && (var1.field2635 < 0 || var1 != this.field2622[var1.field2648][var1.field2635])) {
            if(var6.field2583 > 0) {
               var1.field2631 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2583 * var8) + 0.5D);
            } else {
               var1.field2631 += 128;
            }

            while(var1.field2632 < var6.field2582.length - 2 && var1.field2631 > (var6.field2582[var1.field2632 + 2] & 255) << 8) {
               var1.field2632 += 2;
            }

            if(var6.field2582.length - 2 == var1.field2632) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2649.method2299(var1.field2650);
            if(var2 != null) {
               var1.field2649.vmethod4145(var2, var3, var4);
            } else {
               var1.field2649.vmethod4144(var4);
            }

            if(var1.field2649.method2303()) {
               this.field2629.field2679.method2080(var1.field2649);
            }

            var1.method4073();
            if(var1.field2631 >= 0) {
               var1.unlink();
               if(var1.field2635 > 0 && var1 == this.field2622[var1.field2648][var1.field2635]) {
                  this.field2622[var1.field2648][var1.field2635] = null;
               }
            }

            return true;
         } else {
            var1.field2649.method2292(var1.field2650, this.method3982(var1), this.method3983(var1));
            return false;
         }
      } else {
         var1.method4073();
         var1.unlink();
         if(var1.field2635 > 0 && var1 == this.field2622[var1.field2648][var1.field2635]) {
            this.field2622[var1.field2648][var1.field2635] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(Lho;II)I",
      garbageValue = "-1237696179"
   )
   static final int method4072(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class35.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!CombatInfo1.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class222.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class233.field2920[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class222.widgetSettings[var2[var4++]] * 100 / 46875;
               }

               if(var6 == 8) {
                  var7 = class36.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class233.field2919[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = class35.getWidget(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!CombatInfo1.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class222.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = LoginPacket.getVarbit(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = (class36.localPlayer.x >> 7) + WorldMapType1.baseX;
               }

               if(var6 == 19) {
                  var7 = (class36.localPlayer.y >> 7) + class85.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
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
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }
}
