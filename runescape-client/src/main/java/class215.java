import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class215 extends TaskDataNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   HashTable field2622;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1042055865
   )
   int field2639;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1670702647
   )
   int field2640;
   @ObfuscatedName("h")
   int[] field2644;
   @ObfuscatedName("i")
   int[] field2625;
   @ObfuscatedName("t")
   int[] field2626;
   @ObfuscatedName("d")
   int[] field2621;
   @ObfuscatedName("z")
   int[] field2635;
   @ObfuscatedName("k")
   int[] field2629;
   @ObfuscatedName("c")
   int[] field2630;
   @ObfuscatedName("o")
   int[] field2631;
   @ObfuscatedName("l")
   int[] field2632;
   @ObfuscatedName("p")
   int[] field2627;
   @ObfuscatedName("y")
   int[] field2634;
   @ObfuscatedName("n")
   int[] field2623;
   @ObfuscatedName("j")
   int[] field2636;
   @ObfuscatedName("e")
   int[] field2646;
   @ObfuscatedName("v")
   int[] field2638;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[[Lhh;"
   )
   class216[][] field2624;
   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "[[Lhh;"
   )
   class216[][] field2628;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   class217 field2641;
   @ObfuscatedName("aq")
   boolean field2642;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 866377693
   )
   int field2643;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -583391317
   )
   int field2637;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      longValue = 8750402661479826289L
   )
   long field2645;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      longValue = -8673673369270073419L
   )
   long field2633;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   class219 field2647;

   public class215() {
      this.field2639 = 256;
      this.field2640 = 1000000;
      this.field2644 = new int[16];
      this.field2625 = new int[16];
      this.field2626 = new int[16];
      this.field2621 = new int[16];
      this.field2635 = new int[16];
      this.field2629 = new int[16];
      this.field2630 = new int[16];
      this.field2631 = new int[16];
      this.field2632 = new int[16];
      this.field2627 = new int[16];
      this.field2634 = new int[16];
      this.field2623 = new int[16];
      this.field2636 = new int[16];
      this.field2646 = new int[16];
      this.field2638 = new int[16];
      this.field2624 = new class216[16][128];
      this.field2628 = new class216[16][128];
      this.field2641 = new class217();
      this.field2647 = new class219(this);
      this.field2622 = new HashTable(128);
      this.method4182();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-53"
   )
   public synchronized void method4133(int var1) {
      this.field2639 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1482400240"
   )
   int method4227() {
      return this.field2639;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lhu;Lir;Ldh;II)Z",
      garbageValue = "769549581"
   )
   public synchronized boolean method4135(Track1 var1, IndexDataBase var2, class111 var3, int var4) {
      var1.method4335();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2701.first(); var7 != null; var7 = (ByteArrayNode)var1.field2701.next()) {
         int var8 = (int)var7.hash;
         class218 var9 = (class218)this.field2622.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.takeRecordFlat(var8);
            class218 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class218(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field2622.put(var10, (long)var8);
         }

         if(!var9.method4308(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4337();
      }

      return var5;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2144723870"
   )
   public synchronized void method4184() {
      for(class218 var1 = (class218)this.field2622.first(); var1 != null; var1 = (class218)this.field2622.next()) {
         var1.method4300();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-112"
   )
   synchronized void method4137() {
      for(class218 var1 = (class218)this.field2622.first(); var1 != null; var1 = (class218)this.field2622.next()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "()Ldb;"
   )
   protected synchronized TaskDataNode vmethod4311() {
      return this.field2647;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldb;"
   )
   protected synchronized TaskDataNode vmethod4312() {
      return null;
   }

   @ObfuscatedName("d")
   protected synchronized int vmethod4313() {
      return 0;
   }

   @ObfuscatedName("z")
   protected synchronized void vmethod4314(int[] var1, int var2, int var3) {
      if(this.field2641.method4278()) {
         int var4 = this.field2641.field2683 * this.field2640 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = this.field2645 + (long)var4 * (long)var3;
            if(this.field2633 - var5 >= 0L) {
               this.field2645 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2633 - this.field2645) - 1L) / (long)var4);
            this.field2645 += (long)var4 * (long)var7;
            this.field2647.vmethod4314(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method4154();
         } while(this.field2641.method4278());
      }

      this.field2647.vmethod4314(var1, var2, var3);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lhu;ZI)V",
      garbageValue = "857050580"
   )
   public synchronized void method4138(Track1 var1, boolean var2) {
      this.method4139();
      this.field2641.method4271(var1.field2700);
      this.field2642 = var2;
      this.field2645 = 0L;
      int var3 = this.field2641.method4256();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2641.method4295(var4);
         this.field2641.method4260(var4);
         this.field2641.method4258(var4);
      }

      this.field2643 = this.field2641.method4265();
      this.field2637 = this.field2641.field2674[this.field2643];
      this.field2633 = this.field2641.method4264(this.field2637);
   }

   @ObfuscatedName("c")
   protected synchronized void vmethod4315(int var1) {
      if(this.field2641.method4278()) {
         int var2 = this.field2641.field2683 * this.field2640 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = (long)var2 * (long)var1 + this.field2645;
            if(this.field2633 - var3 >= 0L) {
               this.field2645 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2633 - this.field2645) - 1L) / (long)var2);
            this.field2645 += (long)var5 * (long)var2;
            this.field2647.vmethod4315(var5);
            var1 -= var5;
            this.method4154();
         } while(this.field2641.method4278());
      }

      this.field2647.vmethod4315(var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-79009562"
   )
   public synchronized void method4139() {
      this.field2641.method4254();
      this.method4182();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1812854870"
   )
   public synchronized boolean method4221() {
      return this.field2641.method4278();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-382862837"
   )
   public synchronized void method4141(int var1, int var2) {
      this.method4142(var1, var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "802073141"
   )
   void method4142(int var1, int var2) {
      this.field2621[var1] = var2;
      this.field2629[var1] = var2 & -128;
      this.method4169(var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2118683211"
   )
   void method4169(int var1, int var2) {
      if(var2 != this.field2635[var1]) {
         this.field2635[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2628[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1774636241"
   )
   void method4143(int var1, int var2, int var3) {
      this.method4145(var1, var2, 64);
      if((this.field2627[var1] & 2) != 0) {
         for(class216 var4 = (class216)this.field2647.field2696.getTail(); var4 != null; var4 = (class216)this.field2647.field2696.getPrevious()) {
            if(var4.field2649 == var1 && var4.field2662 < 0) {
               this.field2624[var1][var4.field2653] = null;
               this.field2624[var1][var2] = var4;
               int var5 = (var4.field2657 * var4.field2648 >> 12) + var4.field2656;
               var4.field2656 += var2 - var4.field2653 << 8;
               var4.field2657 = var5 - var4.field2656;
               var4.field2648 = 4096;
               var4.field2653 = var2;
               return;
            }
         }
      }

      class218 var9 = (class218)this.field2622.get((long)this.field2635[var1]);
      if(var9 != null) {
         RawAudioNode var8 = var9.field2684[var2];
         if(var8 != null) {
            class216 var6 = new class216();
            var6.field2649 = var1;
            var6.field2655 = var9;
            var6.field2659 = var8;
            var6.field2650 = var9.field2689[var2];
            var6.field2652 = var9.field2690[var2];
            var6.field2653 = var2;
            var6.field2654 = var3 * var3 * var9.field2687[var2] * var9.field2685 + 1024 >> 11;
            var6.field2651 = var9.field2688[var2] & 255;
            var6.field2656 = (var2 << 8) - (var9.field2686[var2] & 32767);
            var6.field2666 = 0;
            var6.field2660 = 0;
            var6.field2661 = 0;
            var6.field2662 = -1;
            var6.field2658 = 0;
            if(this.field2636[var1] == 0) {
               var6.field2667 = class116.method2385(var8, this.method4209(var6), this.method4186(var6), this.method4136(var6));
            } else {
               var6.field2667 = class116.method2385(var8, this.method4209(var6), 0, this.method4136(var6));
               this.method4144(var6, var9.field2686[var2] < 0);
            }

            if(var9.field2686[var2] < 0) {
               var6.field2667.method2387(-1);
            }

            if(var6.field2652 >= 0) {
               class216 var7 = this.field2628[var1][var6.field2652];
               if(var7 != null && var7.field2662 < 0) {
                  this.field2624[var1][var7.field2653] = null;
                  var7.field2662 = 0;
               }

               this.field2628[var1][var6.field2652] = var6;
            }

            this.field2647.field2696.addFront(var6);
            this.field2624[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lhh;ZB)V",
      garbageValue = "5"
   )
   void method4144(class216 var1, boolean var2) {
      int var3 = var1.field2659.audioBuffer.length;
      int var4;
      if(var2 && var1.field2659.field1528) {
         int var5 = var3 + var3 - var1.field2659.startPosition;
         var4 = (int)((long)this.field2636[var1.field2649] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2667.method2520();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2636[var1.field2649] >> 6);
      }

      var1.field2667.method2393(var4);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1004218695"
   )
   void method4145(int var1, int var2, int var3) {
      class216 var4 = this.field2624[var1][var2];
      if(var4 != null) {
         this.field2624[var1][var2] = null;
         if((this.field2627[var1] & 2) != 0) {
            for(class216 var5 = (class216)this.field2647.field2696.getFront(); var5 != null; var5 = (class216)this.field2647.field2696.getNext()) {
               if(var5.field2649 == var4.field2649 && var5.field2662 < 0 && var4 != var5) {
                  var4.field2662 = 0;
                  break;
               }
            }
         } else {
            var4.field2662 = 0;
         }

      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "90"
   )
   void method4175(int var1, int var2, int var3) {
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-678028034"
   )
   void method4147(int var1, int var2) {
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "128"
   )
   void method4151(int var1, int var2) {
      this.field2630[var1] = var2;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1101725457"
   )
   void method4149(int var1) {
      for(class216 var2 = (class216)this.field2647.field2696.getFront(); var2 != null; var2 = (class216)this.field2647.field2696.getNext()) {
         if(var1 < 0 || var2.field2649 == var1) {
            if(var2.field2667 != null) {
               var2.field2667.method2493(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2667.method2539()) {
                  this.field2647.field2695.method2129(var2.field2667);
               }

               var2.method4251();
            }

            if(var2.field2662 < 0) {
               this.field2624[var2.field2649][var2.field2653] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1454765952"
   )
   void method4150(int var1) {
      if(var1 >= 0) {
         this.field2644[var1] = 12800;
         this.field2625[var1] = 8192;
         this.field2626[var1] = 16383;
         this.field2630[var1] = 8192;
         this.field2631[var1] = 0;
         this.field2632[var1] = 8192;
         this.method4153(var1);
         this.method4171(var1);
         this.field2627[var1] = 0;
         this.field2634[var1] = 32767;
         this.field2623[var1] = 256;
         this.field2636[var1] = 0;
         this.method4156(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method4150(var1);
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1726993207"
   )
   void method4146(int var1) {
      for(class216 var2 = (class216)this.field2647.field2696.getFront(); var2 != null; var2 = (class216)this.field2647.field2696.getNext()) {
         if((var1 < 0 || var2.field2649 == var1) && var2.field2662 < 0) {
            this.field2624[var2.field2649][var2.field2653] = null;
            var2.field2662 = 0;
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-428188419"
   )
   void method4182() {
      this.method4149(-1);
      this.method4150(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2635[var1] = this.field2621[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2629[var1] = this.field2621[var1] & -128;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "478707627"
   )
   void method4153(int var1) {
      if((this.field2627[var1] & 2) != 0) {
         for(class216 var2 = (class216)this.field2647.field2696.getFront(); var2 != null; var2 = (class216)this.field2647.field2696.getNext()) {
            if(var2.field2649 == var1 && this.field2624[var1][var2.field2653] == null && var2.field2662 < 0) {
               var2.field2662 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "44"
   )
   void method4171(int var1) {
      if((this.field2627[var1] & 4) != 0) {
         for(class216 var2 = (class216)this.field2647.field2696.getFront(); var2 != null; var2 = (class216)this.field2647.field2696.getNext()) {
            if(var2.field2649 == var1) {
               var2.field2668 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-72"
   )
   void method4155(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4145(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method4143(var3, var4, var5);
         } else {
            this.method4145(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4175(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2629[var3] = (var5 << 14) + (this.field2629[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2629[var3] = (var5 << 7) + (this.field2629[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2631[var3] = (var5 << 7) + (this.field2631[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2631[var3] = var5 + (this.field2631[var3] & -128);
         }

         if(var4 == 5) {
            this.field2632[var3] = (var5 << 7) + (this.field2632[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2632[var3] = var5 + (this.field2632[var3] & -128);
         }

         if(var4 == 7) {
            this.field2644[var3] = (var5 << 7) + (this.field2644[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2644[var3] = var5 + (this.field2644[var3] & -128);
         }

         if(var4 == 10) {
            this.field2625[var3] = (var5 << 7) + (this.field2625[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2625[var3] = var5 + (this.field2625[var3] & -128);
         }

         if(var4 == 11) {
            this.field2626[var3] = (var5 << 7) + (this.field2626[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2626[var3] = var5 + (this.field2626[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2627[var3] |= 1;
            } else {
               this.field2627[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2627[var3] |= 2;
            } else {
               this.method4153(var3);
               this.field2627[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2634[var3] = (var5 << 7) + (this.field2634[var3] & 127);
         }

         if(var4 == 98) {
            this.field2634[var3] = (this.field2634[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2634[var3] = (var5 << 7) + (this.field2634[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2634[var3] = (this.field2634[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method4149(var3);
         }

         if(var4 == 121) {
            this.method4150(var3);
         }

         if(var4 == 123) {
            this.method4146(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2634[var3];
            if(var6 == 16384) {
               this.field2623[var3] = (var5 << 7) + (this.field2623[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2634[var3];
            if(var6 == 16384) {
               this.field2623[var3] = var5 + (this.field2623[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2636[var3] = (var5 << 7) + (this.field2636[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2636[var3] = var5 + (this.field2636[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2627[var3] |= 4;
            } else {
               this.method4171(var3);
               this.field2627[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method4156(var3, (var5 << 7) + (this.field2646[var3] & -16257));
         }

         if(var4 == 49) {
            this.method4156(var3, var5 + (this.field2646[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4169(var3, var4 + this.field2629[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4147(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method4151(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method4182();
         }
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "78"
   )
   void method4156(int var1, int var2) {
      this.field2646[var1] = var2;
      this.field2638[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lhh;I)I",
      garbageValue = "2013230477"
   )
   int method4209(class216 var1) {
      int var2 = (var1.field2648 * var1.field2657 >> 12) + var1.field2656;
      var2 += (this.field2630[var1.field2649] - 8192) * this.field2623[var1.field2649] >> 12;
      class213 var3 = var1.field2650;
      int var4;
      if(var3.field2611 > 0 && (var3.field2610 > 0 || this.field2631[var1.field2649] > 0)) {
         var4 = var3.field2610 << 2;
         int var5 = var3.field2612 << 1;
         if(var1.field2664 < var5) {
            var4 = var4 * var1.field2664 / var5;
         }

         var4 += this.field2631[var1.field2649] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2665 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2659.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lhh;I)I",
      garbageValue = "-596853393"
   )
   int method4186(class216 var1) {
      class213 var2 = var1.field2650;
      int var3 = this.field2644[var1.field2649] * this.field2626[var1.field2649] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2654 + 16384 >> 15;
      var3 = var3 * this.field2639 + 128 >> 8;
      if(var2.field2606 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2606 * (double)var1.field2666 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2605 != null) {
         var4 = var1.field2660;
         var5 = var2.field2605[var1.field2661 + 1];
         if(var1.field2661 < var2.field2605.length - 2) {
            var6 = (var2.field2605[var1.field2661] & 255) << 8;
            var7 = (var2.field2605[var1.field2661 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2605[var1.field2661 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2662 > 0 && var2.field2608 != null) {
         var4 = var1.field2662;
         var5 = var2.field2608[var1.field2658 + 1];
         if(var1.field2658 < var2.field2608.length - 2) {
            var6 = (var2.field2608[var1.field2658] & 255) << 8;
            var7 = (var2.field2608[var1.field2658 + 2] & 255) << 8;
            var5 += (var2.field2608[var1.field2658 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lhh;B)I",
      garbageValue = "1"
   )
   int method4136(class216 var1) {
      int var2 = this.field2625[var1.field2649];
      return var2 < 8192?var2 * var1.field2651 + 32 >> 6:16384 - ((128 - var1.field2651) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1006996486"
   )
   void method4154() {
      int var1 = this.field2643;
      int var2 = this.field2637;

      long var3;
      for(var3 = this.field2633; var2 == this.field2637; var3 = this.field2641.method4264(var2)) {
         while(var2 == this.field2641.field2674[var1]) {
            this.field2641.method4295(var1);
            int var5 = this.field2641.method4252(var1);
            if(var5 == 1) {
               this.field2641.method4266();
               this.field2641.method4258(var1);
               if(this.field2641.method4267()) {
                  if(!this.field2642 || var2 == 0) {
                     this.method4182();
                     this.field2641.method4254();
                     return;
                  }

                  this.field2641.method4255(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method4155(var5);
            }

            this.field2641.method4260(var1);
            this.field2641.method4258(var1);
         }

         var1 = this.field2641.method4265();
         var2 = this.field2641.field2674[var1];
      }

      this.field2643 = var1;
      this.field2637 = var2;
      this.field2633 = var3;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(Lhh;S)Z",
      garbageValue = "10417"
   )
   boolean method4166(class216 var1) {
      if(var1.field2667 == null) {
         if(var1.field2662 >= 0) {
            var1.unlink();
            if(var1.field2652 > 0 && var1 == this.field2628[var1.field2649][var1.field2652]) {
               this.field2628[var1.field2649][var1.field2652] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(Lhh;[IIII)Z",
      garbageValue = "1400316611"
   )
   boolean method4167(class216 var1, int[] var2, int var3, int var4) {
      var1.field2669 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2662 < 0 || var1.field2667 != null && !var1.field2667.method2402()) {
         int var5 = var1.field2648;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2632[var1.field2649]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2648 = var5;
         }

         var1.field2667.method2523(this.method4209(var1));
         class213 var6 = var1.field2650;
         boolean var7 = false;
         ++var1.field2664;
         var1.field2665 += var6.field2611;
         double var8 = (double)((var1.field2653 - 60 << 8) + (var1.field2657 * var1.field2648 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2606 > 0) {
            if(var6.field2609 > 0) {
               var1.field2666 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2609) + 0.5D);
            } else {
               var1.field2666 += 128;
            }
         }

         if(var6.field2605 != null) {
            if(var6.field2607 > 0) {
               var1.field2660 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2607 * var8) + 0.5D);
            } else {
               var1.field2660 += 128;
            }

            while(var1.field2661 < var6.field2605.length - 2 && var1.field2660 > (var6.field2605[var1.field2661 + 2] & 255) << 8) {
               var1.field2661 += 2;
            }

            if(var6.field2605.length - 2 == var1.field2661 && var6.field2605[var1.field2661 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2662 >= 0 && var6.field2608 != null && (this.field2627[var1.field2649] & 1) == 0 && (var1.field2652 < 0 || var1 != this.field2628[var1.field2649][var1.field2652])) {
            if(var6.field2604 > 0) {
               var1.field2662 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2604 * var8) + 0.5D);
            } else {
               var1.field2662 += 128;
            }

            while(var1.field2658 < var6.field2608.length - 2 && var1.field2662 > (var6.field2608[var1.field2658 + 2] & 255) << 8) {
               var1.field2658 += 2;
            }

            if(var6.field2608.length - 2 == var1.field2658) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2667.method2493(var1.field2669);
            if(var2 != null) {
               var1.field2667.vmethod4314(var2, var3, var4);
            } else {
               var1.field2667.vmethod4315(var4);
            }

            if(var1.field2667.method2539()) {
               this.field2647.field2695.method2129(var1.field2667);
            }

            var1.method4251();
            if(var1.field2662 >= 0) {
               var1.unlink();
               if(var1.field2652 > 0 && var1 == this.field2628[var1.field2649][var1.field2652]) {
                  this.field2628[var1.field2649][var1.field2652] = null;
               }
            }

            return true;
         } else {
            var1.field2667.method2444(var1.field2669, this.method4186(var1), this.method4136(var1));
            return false;
         }
      } else {
         var1.method4251();
         var1.unlink();
         if(var1.field2652 > 0 && var1 == this.field2628[var1.field2649][var1.field2652]) {
            this.field2628[var1.field2649][var1.field2652] = null;
         }

         return true;
      }
   }
}
