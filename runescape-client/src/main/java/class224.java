import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class224 extends TaskDataNode {
   @ObfuscatedName("os")
   @ObfuscatedGetter(
      intValue = -725864659
   )
   static int field2650;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   HashTable field2674;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 408611103
   )
   int field2651;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -28969421
   )
   int field2652;
   @ObfuscatedName("p")
   int[] field2653;
   @ObfuscatedName("a")
   int[] field2654;
   @ObfuscatedName("h")
   int[] field2670;
   @ObfuscatedName("l")
   int[] field2656;
   @ObfuscatedName("y")
   int[] field2657;
   @ObfuscatedName("g")
   int[] field2658;
   @ObfuscatedName("c")
   int[] field2659;
   @ObfuscatedName("u")
   int[] field2660;
   @ObfuscatedName("r")
   int[] field2672;
   @ObfuscatedName("w")
   int[] field2661;
   @ObfuscatedName("j")
   int[] field2664;
   @ObfuscatedName("z")
   int[] field2679;
   @ObfuscatedName("e")
   int[] field2666;
   @ObfuscatedName("k")
   int[] field2667;
   @ObfuscatedName("n")
   int[] field2668;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "[[Lhs;"
   )
   class225[][] field2669;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "[[Lhs;"
   )
   class225[][] field2673;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "Lhm;"
   )
   class226 field2671;
   @ObfuscatedName("am")
   boolean field2680;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -340161053
   )
   int field2655;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1947532023
   )
   int field2665;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      longValue = -2495579868467598863L
   )
   long field2675;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      longValue = -6201558568232203981L
   )
   long field2676;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   class228 field2677;

   public class224() {
      this.field2651 = 256;
      this.field2652 = 1000000;
      this.field2653 = new int[16];
      this.field2654 = new int[16];
      this.field2670 = new int[16];
      this.field2656 = new int[16];
      this.field2657 = new int[16];
      this.field2658 = new int[16];
      this.field2659 = new int[16];
      this.field2660 = new int[16];
      this.field2672 = new int[16];
      this.field2661 = new int[16];
      this.field2664 = new int[16];
      this.field2679 = new int[16];
      this.field2666 = new int[16];
      this.field2667 = new int[16];
      this.field2668 = new int[16];
      this.field2669 = new class225[16][128];
      this.field2673 = new class225[16][128];
      this.field2671 = new class226();
      this.field2677 = new class228(this);
      this.field2674 = new HashTable(128);
      this.method4154();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-855687935"
   )
   public synchronized void method4134(int var1) {
      this.field2651 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2036264523"
   )
   int method4135() {
      return this.field2651;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lhv;Lie;Ldo;II)Z",
      garbageValue = "1995957279"
   )
   synchronized boolean method4136(Track1 var1, IndexDataBase var2, class109 var3, int var4) {
      var1.method4348();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2729.first(); var7 != null; var7 = (ByteArrayNode)var1.field2729.next()) {
         int var8 = (int)var7.hash;
         class227 var9 = (class227)this.field2674.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.takeRecordFlat(var8);
            class227 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class227(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field2674.put(var10, (long)var8);
         }

         if(!var9.method4322(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4349();
      }

      return var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   synchronized void method4238() {
      for(class227 var1 = (class227)this.field2674.first(); var1 != null; var1 = (class227)this.field2674.next()) {
         var1.method4317();
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-115"
   )
   synchronized void method4138() {
      for(class227 var1 = (class227)this.field2674.first(); var1 != null; var1 = (class227)this.field2674.next()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected synchronized TaskDataNode vmethod4324() {
      return this.field2677;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected synchronized TaskDataNode vmethod4323() {
      return null;
   }

   @ObfuscatedName("y")
   protected synchronized int vmethod4326() {
      return 0;
   }

   @ObfuscatedName("g")
   protected synchronized void vmethod4344(int[] var1, int var2, int var3) {
      if(this.field2671.method4265()) {
         int var4 = this.field2671.field2709 * this.field2652 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = (long)var4 * (long)var3 + this.field2675;
            if(this.field2676 - var5 >= 0L) {
               this.field2675 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2676 - this.field2675) - 1L) / (long)var4);
            this.field2675 += (long)var4 * (long)var7;
            this.field2677.vmethod4344(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method4216();
         } while(this.field2671.method4265());
      }

      this.field2677.vmethod4344(var1, var2, var3);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lhv;ZI)V",
      garbageValue = "-1109495854"
   )
   synchronized void method4210(Track1 var1, boolean var2) {
      this.method4140();
      this.field2671.method4301(var1.field2728);
      this.field2680 = var2;
      this.field2675 = 0L;
      int var3 = this.field2671.method4266();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2671.method4312(var4);
         this.field2671.method4270(var4);
         this.field2671.method4310(var4);
      }

      this.field2655 = this.field2671.method4275();
      this.field2665 = this.field2671.field2706[this.field2655];
      this.field2676 = this.field2671.method4278(this.field2665);
   }

   @ObfuscatedName("u")
   protected synchronized void vmethod4328(int var1) {
      if(this.field2671.method4265()) {
         int var2 = this.field2671.field2709 * this.field2652 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = this.field2675 + (long)var1 * (long)var2;
            if(this.field2676 - var3 >= 0L) {
               this.field2675 = var3;
               break;
            }

            int var5 = (int)((this.field2676 - this.field2675 + (long)var2 - 1L) / (long)var2);
            this.field2675 += (long)var2 * (long)var5;
            this.field2677.vmethod4328(var5);
            var1 -= var5;
            this.method4216();
         } while(this.field2671.method4265());
      }

      this.field2677.vmethod4328(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1634642819"
   )
   public synchronized void method4140() {
      this.field2671.method4264();
      this.method4154();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "2502"
   )
   public synchronized boolean method4180() {
      return this.field2671.method4265();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "50"
   )
   public synchronized void method4142(int var1, int var2) {
      this.method4143(var1, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "66"
   )
   void method4143(int var1, int var2) {
      this.field2656[var1] = var2;
      this.field2658[var1] = var2 & -128;
      this.method4144(var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1603045319"
   )
   void method4144(int var1, int var2) {
      if(var2 != this.field2657[var1]) {
         this.field2657[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2673[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-860594263"
   )
   void method4145(int var1, int var2, int var3) {
      this.method4133(var1, var2, 64);
      if((this.field2661[var1] & 2) != 0) {
         for(class225 var4 = (class225)this.field2677.field2725.getTail(); var4 != null; var4 = (class225)this.field2677.field2725.getPrevious()) {
            if(var4.field2694 == var1 && var4.field2695 < 0) {
               this.field2669[var1][var4.field2686] = null;
               this.field2669[var1][var2] = var4;
               int var5 = (var4.field2691 * var4.field2684 >> 12) + var4.field2687;
               var4.field2687 += var2 - var4.field2686 << 8;
               var4.field2684 = var5 - var4.field2687;
               var4.field2691 = 4096;
               var4.field2686 = var2;
               return;
            }
         }
      }

      class227 var9 = (class227)this.field2674.get((long)this.field2657[var1]);
      if(var9 != null) {
         RawAudioNode var8 = var9.field2717[var2];
         if(var8 != null) {
            class225 var6 = new class225();
            var6.field2694 = var1;
            var6.field2682 = var9;
            var6.field2683 = var8;
            var6.field2689 = var9.field2721[var2];
            var6.field2685 = var9.field2723[var2];
            var6.field2686 = var2;
            var6.field2681 = var3 * var3 * var9.field2719[var2] * var9.field2716 + 1024 >> 11;
            var6.field2688 = var9.field2722[var2] & 255;
            var6.field2687 = (var2 << 8) - (var9.field2718[var2] & 32767);
            var6.field2692 = 0;
            var6.field2693 = 0;
            var6.field2700 = 0;
            var6.field2695 = -1;
            var6.field2696 = 0;
            if(this.field2666[var1] == 0) {
               var6.field2699 = class114.method2316(var8, this.method4159(var6), this.method4160(var6), this.method4161(var6));
            } else {
               var6.field2699 = class114.method2316(var8, this.method4159(var6), 0, this.method4161(var6));
               this.method4146(var6, var9.field2718[var2] < 0);
            }

            if(var9.field2718[var2] < 0) {
               var6.field2699.method2318(-1);
            }

            if(var6.field2685 >= 0) {
               class225 var7 = this.field2673[var1][var6.field2685];
               if(var7 != null && var7.field2695 < 0) {
                  this.field2669[var1][var7.field2686] = null;
                  var7.field2695 = 0;
               }

               this.field2673[var1][var6.field2685] = var6;
            }

            this.field2677.field2725.addFront(var6);
            this.field2669[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lhs;ZB)V",
      garbageValue = "-86"
   )
   void method4146(class225 var1, boolean var2) {
      int var3 = var1.field2683.audioBuffer.length;
      int var4;
      if(var2 && var1.field2683.field1497) {
         int var5 = var3 + var3 - var1.field2683.startPosition;
         var4 = (int)((long)var5 * (long)this.field2666[var1.field2694] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2699.method2324();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2666[var1.field2694] >> 6);
      }

      var1.field2699.method2349(var4);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-138291747"
   )
   void method4133(int var1, int var2, int var3) {
      class225 var4 = this.field2669[var1][var2];
      if(var4 != null) {
         this.field2669[var1][var2] = null;
         if((this.field2661[var1] & 2) != 0) {
            for(class225 var5 = (class225)this.field2677.field2725.getFront(); var5 != null; var5 = (class225)this.field2677.field2725.getNext()) {
               if(var5.field2694 == var4.field2694 && var5.field2695 < 0 && var5 != var4) {
                  var4.field2695 = 0;
                  break;
               }
            }
         } else {
            var4.field2695 = 0;
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "9"
   )
   void method4148(int var1, int var2, int var3) {
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1788346079"
   )
   void method4149(int var1, int var2) {
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "58"
   )
   void method4230(int var1, int var2) {
      this.field2659[var1] = var2;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-472599875"
   )
   void method4151(int var1) {
      for(class225 var2 = (class225)this.field2677.field2725.getFront(); var2 != null; var2 = (class225)this.field2677.field2725.getNext()) {
         if(var1 < 0 || var2.field2694 == var1) {
            if(var2.field2699 != null) {
               var2.field2699.method2329(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2699.method2333()) {
                  this.field2677.field2726.method2064(var2.field2699);
               }

               var2.method4257();
            }

            if(var2.field2695 < 0) {
               this.field2669[var2.field2694][var2.field2686] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "65"
   )
   void method4152(int var1) {
      if(var1 >= 0) {
         this.field2653[var1] = 12800;
         this.field2654[var1] = 8192;
         this.field2670[var1] = 16383;
         this.field2659[var1] = 8192;
         this.field2660[var1] = 0;
         this.field2672[var1] = 8192;
         this.method4242(var1);
         this.method4156(var1);
         this.field2661[var1] = 0;
         this.field2664[var1] = 32767;
         this.field2679[var1] = 256;
         this.field2666[var1] = 0;
         this.method4158(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method4152(var1);
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-15"
   )
   void method4224(int var1) {
      for(class225 var2 = (class225)this.field2677.field2725.getFront(); var2 != null; var2 = (class225)this.field2677.field2725.getNext()) {
         if((var1 < 0 || var2.field2694 == var1) && var2.field2695 < 0) {
            this.field2669[var2.field2694][var2.field2686] = null;
            var2.field2695 = 0;
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1885914111"
   )
   void method4154() {
      this.method4151(-1);
      this.method4152(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2657[var1] = this.field2656[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2658[var1] = this.field2656[var1] & -128;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "52668198"
   )
   void method4242(int var1) {
      if((this.field2661[var1] & 2) != 0) {
         for(class225 var2 = (class225)this.field2677.field2725.getFront(); var2 != null; var2 = (class225)this.field2677.field2725.getNext()) {
            if(var2.field2694 == var1 && this.field2669[var1][var2.field2686] == null && var2.field2695 < 0) {
               var2.field2695 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "10259"
   )
   void method4156(int var1) {
      if((this.field2661[var1] & 4) != 0) {
         for(class225 var2 = (class225)this.field2677.field2725.getFront(); var2 != null; var2 = (class225)this.field2677.field2725.getNext()) {
            if(var2.field2694 == var1) {
               var2.field2701 = 0;
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2082067234"
   )
   void method4181(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4133(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method4145(var3, var4, var5);
         } else {
            this.method4133(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4148(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2658[var3] = (var5 << 14) + (this.field2658[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2658[var3] = (var5 << 7) + (this.field2658[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2660[var3] = (var5 << 7) + (this.field2660[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2660[var3] = var5 + (this.field2660[var3] & -128);
         }

         if(var4 == 5) {
            this.field2672[var3] = (var5 << 7) + (this.field2672[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2672[var3] = var5 + (this.field2672[var3] & -128);
         }

         if(var4 == 7) {
            this.field2653[var3] = (var5 << 7) + (this.field2653[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2653[var3] = var5 + (this.field2653[var3] & -128);
         }

         if(var4 == 10) {
            this.field2654[var3] = (var5 << 7) + (this.field2654[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2654[var3] = var5 + (this.field2654[var3] & -128);
         }

         if(var4 == 11) {
            this.field2670[var3] = (var5 << 7) + (this.field2670[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2670[var3] = var5 + (this.field2670[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2661[var3] |= 1;
            } else {
               this.field2661[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2661[var3] |= 2;
            } else {
               this.method4242(var3);
               this.field2661[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2664[var3] = (var5 << 7) + (this.field2664[var3] & 127);
         }

         if(var4 == 98) {
            this.field2664[var3] = (this.field2664[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2664[var3] = (var5 << 7) + (this.field2664[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2664[var3] = (this.field2664[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method4151(var3);
         }

         if(var4 == 121) {
            this.method4152(var3);
         }

         if(var4 == 123) {
            this.method4224(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2664[var3];
            if(var6 == 16384) {
               this.field2679[var3] = (var5 << 7) + (this.field2679[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2664[var3];
            if(var6 == 16384) {
               this.field2679[var3] = var5 + (this.field2679[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2666[var3] = (var5 << 7) + (this.field2666[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2666[var3] = var5 + (this.field2666[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2661[var3] |= 4;
            } else {
               this.method4156(var3);
               this.field2661[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method4158(var3, (var5 << 7) + (this.field2667[var3] & -16257));
         }

         if(var4 == 49) {
            this.method4158(var3, var5 + (this.field2667[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4144(var3, var4 + this.field2658[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4149(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method4230(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method4154();
         }
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1158205535"
   )
   void method4158(int var1, int var2) {
      this.field2667[var1] = var2;
      this.field2668[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lhs;I)I",
      garbageValue = "-598836056"
   )
   int method4159(class225 var1) {
      int var2 = (var1.field2691 * var1.field2684 >> 12) + var1.field2687;
      var2 += (this.field2659[var1.field2694] - 8192) * this.field2679[var1.field2694] >> 12;
      class222 var3 = var1.field2689;
      int var4;
      if(var3.field2640 > 0 && (var3.field2637 > 0 || this.field2660[var1.field2694] > 0)) {
         var4 = var3.field2637 << 2;
         int var5 = var3.field2639 << 1;
         if(var1.field2697 < var5) {
            var4 = var4 * var1.field2697 / var5;
         }

         var4 += this.field2660[var1.field2694] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2690 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2683.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(Lhs;I)I",
      garbageValue = "1309713980"
   )
   int method4160(class225 var1) {
      class222 var2 = var1.field2689;
      int var3 = this.field2670[var1.field2694] * this.field2653[var1.field2694] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2681 + 16384 >> 15;
      var3 = var3 * this.field2651 + 128 >> 8;
      if(var2.field2633 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2633 * 1.953125E-5D * (double)var1.field2692) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2631 != null) {
         var4 = var1.field2693;
         var5 = var2.field2631[var1.field2700 + 1];
         if(var1.field2700 < var2.field2631.length - 2) {
            var6 = (var2.field2631[var1.field2700] & 255) << 8;
            var7 = (var2.field2631[var1.field2700 + 2] & 255) << 8;
            var5 += (var2.field2631[var1.field2700 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2695 > 0 && var2.field2635 != null) {
         var4 = var1.field2695;
         var5 = var2.field2635[var1.field2696 + 1];
         if(var1.field2696 < var2.field2635.length - 2) {
            var6 = (var2.field2635[var1.field2696] & 255) << 8;
            var7 = (var2.field2635[var1.field2696 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2635[var1.field2696 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(Lhs;I)I",
      garbageValue = "276235759"
   )
   int method4161(class225 var1) {
      int var2 = this.field2654[var1.field2694];
      return var2 < 8192?var2 * var1.field2688 + 32 >> 6:16384 - ((128 - var1.field2688) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1430612568"
   )
   void method4216() {
      int var1 = this.field2655;
      int var2 = this.field2665;

      long var3;
      for(var3 = this.field2676; var2 == this.field2665; var3 = this.field2671.method4278(var2)) {
         while(var2 == this.field2671.field2706[var1]) {
            this.field2671.method4312(var1);
            int var5 = this.field2671.method4271(var1);
            if(var5 == 1) {
               this.field2671.method4267();
               this.field2671.method4310(var1);
               if(this.field2671.method4277()) {
                  if(!this.field2680 || var2 == 0) {
                     this.method4154();
                     this.field2671.method4264();
                     return;
                  }

                  this.field2671.method4293(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method4181(var5);
            }

            this.field2671.method4270(var1);
            this.field2671.method4310(var1);
         }

         var1 = this.field2671.method4275();
         var2 = this.field2671.field2706[var1];
      }

      this.field2655 = var1;
      this.field2665 = var2;
      this.field2676 = var3;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(Lhs;I)Z",
      garbageValue = "-101342980"
   )
   boolean method4168(class225 var1) {
      if(var1.field2699 == null) {
         if(var1.field2695 >= 0) {
            var1.unlink();
            if(var1.field2685 > 0 && var1 == this.field2673[var1.field2694][var1.field2685]) {
               this.field2673[var1.field2694][var1.field2685] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(Lhs;[IIII)Z",
      garbageValue = "-2013216488"
   )
   boolean method4185(class225 var1, int[] var2, int var3, int var4) {
      var1.field2698 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2695 < 0 || var1.field2699 != null && !var1.field2699.method2332()) {
         int var5 = var1.field2691;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2672[var1.field2694]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2691 = var5;
         }

         var1.field2699.method2457(this.method4159(var1));
         class222 var6 = var1.field2689;
         boolean var7 = false;
         ++var1.field2697;
         var1.field2690 += var6.field2640;
         double var8 = (double)((var1.field2686 - 60 << 8) + (var1.field2684 * var1.field2691 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2633 > 0) {
            if(var6.field2636 > 0) {
               var1.field2692 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2636) + 0.5D);
            } else {
               var1.field2692 += 128;
            }
         }

         if(var6.field2631 != null) {
            if(var6.field2642 > 0) {
               var1.field2693 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2642) + 0.5D);
            } else {
               var1.field2693 += 128;
            }

            while(var1.field2700 < var6.field2631.length - 2 && var1.field2693 > (var6.field2631[var1.field2700 + 2] & 255) << 8) {
               var1.field2700 += 2;
            }

            if(var6.field2631.length - 2 == var1.field2700 && var6.field2631[var1.field2700 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2695 >= 0 && var6.field2635 != null && (this.field2661[var1.field2694] & 1) == 0 && (var1.field2685 < 0 || var1 != this.field2673[var1.field2694][var1.field2685])) {
            if(var6.field2638 > 0) {
               var1.field2695 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2638) + 0.5D);
            } else {
               var1.field2695 += 128;
            }

            while(var1.field2696 < var6.field2635.length - 2 && var1.field2695 > (var6.field2635[var1.field2696 + 2] & 255) << 8) {
               var1.field2696 += 2;
            }

            if(var6.field2635.length - 2 == var1.field2696) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2699.method2329(var1.field2698);
            if(var2 != null) {
               var1.field2699.vmethod4344(var2, var3, var4);
            } else {
               var1.field2699.vmethod4328(var4);
            }

            if(var1.field2699.method2333()) {
               this.field2677.field2726.method2064(var1.field2699);
            }

            var1.method4257();
            if(var1.field2695 >= 0) {
               var1.unlink();
               if(var1.field2685 > 0 && var1 == this.field2673[var1.field2694][var1.field2685]) {
                  this.field2673[var1.field2694][var1.field2685] = null;
               }
            }

            return true;
         } else {
            var1.field2699.method2328(var1.field2698, this.method4160(var1), this.method4161(var1));
            return false;
         }
      } else {
         var1.method4257();
         var1.unlink();
         if(var1.field2685 > 0 && var1 == this.field2673[var1.field2694][var1.field2685]) {
            this.field2673[var1.field2694][var1.field2685] = null;
         }

         return true;
      }
   }
}
