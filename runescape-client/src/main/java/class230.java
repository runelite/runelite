import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public class class230 extends TaskDataNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   HashTable field2707;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 946544537
   )
   int field2712;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 885018607
   )
   int field2697;
   @ObfuscatedName("r")
   int[] field2698;
   @ObfuscatedName("e")
   int[] field2723;
   @ObfuscatedName("y")
   int[] field2700;
   @ObfuscatedName("k")
   int[] field2701;
   @ObfuscatedName("s")
   int[] field2696;
   @ObfuscatedName("p")
   int[] field2703;
   @ObfuscatedName("x")
   int[] field2699;
   @ObfuscatedName("m")
   int[] field2713;
   @ObfuscatedName("h")
   int[] field2706;
   @ObfuscatedName("c")
   int[] field2709;
   @ObfuscatedName("j")
   int[] field2710;
   @ObfuscatedName("l")
   int[] field2711;
   @ObfuscatedName("g")
   int[] field2704;
   @ObfuscatedName("w")
   int[] field2705;
   @ObfuscatedName("o")
   int[] field2714;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[[Lhk;"
   )
   class231[][] field2695;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "[[Lhk;"
   )
   class231[][] field2716;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   class232 field2717;
   @ObfuscatedName("ac")
   boolean field2718;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 2050333693
   )
   int field2719;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1983462149
   )
   int field2720;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      longValue = 6705960745548887497L
   )
   long field2721;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      longValue = 4656247056401664281L
   )
   long field2722;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   class234 field2702;

   public class230() {
      this.field2712 = 256;
      this.field2697 = 1000000;
      this.field2698 = new int[16];
      this.field2723 = new int[16];
      this.field2700 = new int[16];
      this.field2701 = new int[16];
      this.field2696 = new int[16];
      this.field2703 = new int[16];
      this.field2699 = new int[16];
      this.field2713 = new int[16];
      this.field2706 = new int[16];
      this.field2709 = new int[16];
      this.field2710 = new int[16];
      this.field2711 = new int[16];
      this.field2704 = new int[16];
      this.field2705 = new int[16];
      this.field2714 = new int[16];
      this.field2695 = new class231[16][128];
      this.field2716 = new class231[16][128];
      this.field2717 = new class232();
      this.field2702 = new class234(this);
      this.field2707 = new HashTable(128);
      this.method4349();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "123"
   )
   synchronized void method4305(int var1) {
      this.field2712 = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1099020868"
   )
   int method4287() {
      return this.field2712;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lip;Ljk;Ldc;II)Z",
      garbageValue = "-754234504"
   )
   synchronized boolean method4317(Track1 var1, IndexDataBase var2, class110 var3, int var4) {
      var1.method4467();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2773.first(); var7 != null; var7 = (ByteArrayNode)var1.field2773.next()) {
         int var8 = (int)var7.hash;
         class233 var9 = (class233)this.field2707.get((long)var8);
         if(var9 == null) {
            byte[] var11 = var2.takeRecordFlat(var8);
            class233 var10;
            if(var11 == null) {
               var10 = null;
            } else {
               var10 = new class233(var11);
            }

            var9 = var10;
            if(var10 == null) {
               var5 = false;
               continue;
            }

            this.field2707.put(var10, (long)var8);
         }

         if(!var9.method4426(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4464();
      }

      return var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1754390497"
   )
   synchronized void method4255() {
      for(class233 var1 = (class233)this.field2707.first(); var1 != null; var1 = (class233)this.field2707.next()) {
         var1.method4427();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "13589"
   )
   synchronized void method4257() {
      for(class233 var1 = (class233)this.field2707.first(); var1 != null; var1 = (class233)this.field2707.next()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "()Ldt;"
   )
   protected synchronized TaskDataNode vmethod4438() {
      return this.field2702;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Ldt;"
   )
   protected synchronized TaskDataNode vmethod4433() {
      return null;
   }

   @ObfuscatedName("s")
   protected synchronized int vmethod4443() {
      return 0;
   }

   @ObfuscatedName("x")
   protected synchronized void vmethod4435(int[] var1, int var2, int var3) {
      if(this.field2717.method4376()) {
         int var4 = this.field2717.field2745 * this.field2697 / KeyFocusListener.sampleRate;

         do {
            long var5 = (long)var3 * (long)var4 + this.field2721;
            if(this.field2722 - var5 >= 0L) {
               this.field2721 = var5;
               break;
            }

            int var7 = (int)((this.field2722 - this.field2721 + (long)var4 - 1L) / (long)var4);
            this.field2721 += (long)var4 * (long)var7;
            this.field2702.vmethod4435(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method4286();
         } while(this.field2717.method4376());
      }

      this.field2702.vmethod4435(var1, var2, var3);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lip;ZB)V",
      garbageValue = "-60"
   )
   synchronized void method4258(Track1 var1, boolean var2) {
      this.method4259();
      this.field2717.method4374(var1.field2774);
      this.field2718 = var2;
      this.field2721 = 0L;
      int var3 = this.field2717.method4377();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2717.method4378(var4);
         this.field2717.method4399(var4);
         this.field2717.method4379(var4);
      }

      this.field2719 = this.field2717.method4386();
      this.field2720 = this.field2717.field2749[this.field2719];
      this.field2722 = this.field2717.method4385(this.field2720);
   }

   @ObfuscatedName("t")
   protected synchronized void vmethod4436(int var1) {
      if(this.field2717.method4376()) {
         int var2 = this.field2717.field2745 * this.field2697 / KeyFocusListener.sampleRate;

         do {
            long var3 = this.field2721 + (long)var2 * (long)var1;
            if(this.field2722 - var3 >= 0L) {
               this.field2721 = var3;
               break;
            }

            int var5 = (int)((this.field2722 - this.field2721 + (long)var2 - 1L) / (long)var2);
            this.field2721 += (long)var5 * (long)var2;
            this.field2702.vmethod4436(var5);
            var1 -= var5;
            this.method4286();
         } while(this.field2717.method4376());
      }

      this.field2702.vmethod4436(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1868757463"
   )
   synchronized void method4259() {
      this.field2717.method4375();
      this.method4349();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "6"
   )
   public synchronized boolean method4266() {
      return this.field2717.method4376();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "61"
   )
   public synchronized void method4261(int var1, int var2) {
      this.method4262(var1, var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1968023686"
   )
   void method4262(int var1, int var2) {
      this.field2701[var1] = var2;
      this.field2703[var1] = var2 & -128;
      this.method4263(var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1441964248"
   )
   void method4263(int var1, int var2) {
      if(var2 != this.field2696[var1]) {
         this.field2696[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2716[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-299527655"
   )
   void method4359(int var1, int var2, int var3) {
      this.method4337(var1, var2, 64);
      if((this.field2709[var1] & 2) != 0) {
         for(class231 var4 = (class231)this.field2702.field2771.getTail(); var4 != null; var4 = (class231)this.field2702.field2771.getPrevious()) {
            if(var4.field2734 == var1 && var4.field2738 < 0) {
               this.field2695[var1][var4.field2729] = null;
               this.field2695[var1][var2] = var4;
               int var5 = (var4.field2727 * var4.field2726 >> 12) + var4.field2732;
               var4.field2732 += var2 - var4.field2729 << 8;
               var4.field2727 = var5 - var4.field2732;
               var4.field2726 = 4096;
               var4.field2729 = var2;
               return;
            }
         }
      }

      class233 var9 = (class233)this.field2707.get((long)this.field2696[var1]);
      if(var9 != null) {
         RawAudioNode var8 = var9.field2760[var2];
         if(var8 != null) {
            class231 var6 = new class231();
            var6.field2734 = var1;
            var6.field2733 = var9;
            var6.field2725 = var8;
            var6.field2724 = var9.field2764[var2];
            var6.field2728 = var9.field2767[var2];
            var6.field2729 = var2;
            var6.field2735 = var3 * var3 * var9.field2762[var2] * var9.field2765 + 1024 >> 11;
            var6.field2731 = var9.field2763[var2] & 255;
            var6.field2732 = (var2 << 8) - (var9.field2761[var2] & 32767);
            var6.field2730 = 0;
            var6.field2736 = 0;
            var6.field2737 = 0;
            var6.field2738 = -1;
            var6.field2739 = 0;
            if(this.field2704[var1] == 0) {
               var6.field2742 = class115.method2465(var8, this.method4278(var6), this.method4279(var6), this.method4361(var6));
            } else {
               var6.field2742 = class115.method2465(var8, this.method4278(var6), 0, this.method4361(var6));
               this.method4283(var6, var9.field2761[var2] < 0);
            }

            if(var9.field2761[var2] < 0) {
               var6.field2742.method2366(-1);
            }

            if(var6.field2728 >= 0) {
               class231 var7 = this.field2716[var1][var6.field2728];
               if(var7 != null && var7.field2738 < 0) {
                  this.field2695[var1][var7.field2729] = null;
                  var7.field2738 = 0;
               }

               this.field2716[var1][var6.field2728] = var6;
            }

            this.field2702.field2771.addFront(var6);
            this.field2695[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lhk;ZI)V",
      garbageValue = "1770306359"
   )
   void method4283(class231 var1, boolean var2) {
      int var3 = var1.field2725.audioBuffer.length;
      int var4;
      if(var2 && var1.field2725.field1535) {
         int var5 = var3 + var3 - var1.field2725.startPosition;
         var4 = (int)((long)var5 * (long)this.field2704[var1.field2734] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2742.method2411();
         }
      } else {
         var4 = (int)((long)this.field2704[var1.field2734] * (long)var3 >> 6);
      }

      var1.field2742.method2482(var4);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1511100455"
   )
   void method4337(int var1, int var2, int var3) {
      class231 var4 = this.field2695[var1][var2];
      if(var4 != null) {
         this.field2695[var1][var2] = null;
         if((this.field2709[var1] & 2) != 0) {
            for(class231 var5 = (class231)this.field2702.field2771.getFront(); var5 != null; var5 = (class231)this.field2702.field2771.getNext()) {
               if(var4.field2734 == var5.field2734 && var5.field2738 < 0 && var4 != var5) {
                  var4.field2738 = 0;
                  break;
               }
            }
         } else {
            var4.field2738 = 0;
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "556208615"
   )
   void method4350(int var1, int var2, int var3) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-911443503"
   )
   void method4268(int var1, int var2) {
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "886572564"
   )
   void method4269(int var1, int var2) {
      this.field2699[var1] = var2;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-678193963"
   )
   void method4270(int var1) {
      for(class231 var2 = (class231)this.field2702.field2771.getFront(); var2 != null; var2 = (class231)this.field2702.field2771.getNext()) {
         if(var1 < 0 || var2.field2734 == var1) {
            if(var2.field2742 != null) {
               var2.field2742.method2421(KeyFocusListener.sampleRate / 100);
               if(var2.field2742.method2381()) {
                  this.field2702.field2772.method2103(var2.field2742);
               }

               var2.method4371();
            }

            if(var2.field2738 < 0) {
               this.field2695[var2.field2734][var2.field2729] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "98"
   )
   void method4271(int var1) {
      if(var1 >= 0) {
         this.field2698[var1] = 12800;
         this.field2723[var1] = 8192;
         this.field2700[var1] = 16383;
         this.field2699[var1] = 8192;
         this.field2713[var1] = 0;
         this.field2706[var1] = 8192;
         this.method4274(var1);
         this.method4275(var1);
         this.field2709[var1] = 0;
         this.field2710[var1] = 32767;
         this.field2711[var1] = 256;
         this.field2704[var1] = 0;
         this.method4328(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method4271(var1);
         }

      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   void method4272(int var1) {
      for(class231 var2 = (class231)this.field2702.field2771.getFront(); var2 != null; var2 = (class231)this.field2702.field2771.getNext()) {
         if((var1 < 0 || var2.field2734 == var1) && var2.field2738 < 0) {
            this.field2695[var2.field2734][var2.field2729] = null;
            var2.field2738 = 0;
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-698561920"
   )
   void method4349() {
      this.method4270(-1);
      this.method4271(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2696[var1] = this.field2701[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2703[var1] = this.field2701[var1] & -128;
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2012825898"
   )
   void method4274(int var1) {
      if((this.field2709[var1] & 2) != 0) {
         for(class231 var2 = (class231)this.field2702.field2771.getFront(); var2 != null; var2 = (class231)this.field2702.field2771.getNext()) {
            if(var2.field2734 == var1 && this.field2695[var1][var2.field2729] == null && var2.field2738 < 0) {
               var2.field2738 = 0;
            }
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-130876506"
   )
   void method4275(int var1) {
      if((this.field2709[var1] & 4) != 0) {
         for(class231 var2 = (class231)this.field2702.field2771.getFront(); var2 != null; var2 = (class231)this.field2702.field2771.getNext()) {
            if(var2.field2734 == var1) {
               var2.field2744 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-112"
   )
   void method4267(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4337(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method4359(var3, var4, var5);
         } else {
            this.method4337(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4350(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2703[var3] = (var5 << 14) + (this.field2703[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2703[var3] = (var5 << 7) + (this.field2703[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2713[var3] = (var5 << 7) + (this.field2713[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2713[var3] = var5 + (this.field2713[var3] & -128);
         }

         if(var4 == 5) {
            this.field2706[var3] = (var5 << 7) + (this.field2706[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2706[var3] = var5 + (this.field2706[var3] & -128);
         }

         if(var4 == 7) {
            this.field2698[var3] = (var5 << 7) + (this.field2698[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2698[var3] = var5 + (this.field2698[var3] & -128);
         }

         if(var4 == 10) {
            this.field2723[var3] = (var5 << 7) + (this.field2723[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2723[var3] = var5 + (this.field2723[var3] & -128);
         }

         if(var4 == 11) {
            this.field2700[var3] = (var5 << 7) + (this.field2700[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2700[var3] = var5 + (this.field2700[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2709[var3] |= 1;
            } else {
               this.field2709[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2709[var3] |= 2;
            } else {
               this.method4274(var3);
               this.field2709[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2710[var3] = (var5 << 7) + (this.field2710[var3] & 127);
         }

         if(var4 == 98) {
            this.field2710[var3] = (this.field2710[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2710[var3] = (var5 << 7) + (this.field2710[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2710[var3] = (this.field2710[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method4270(var3);
         }

         if(var4 == 121) {
            this.method4271(var3);
         }

         if(var4 == 123) {
            this.method4272(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2710[var3];
            if(var6 == 16384) {
               this.field2711[var3] = (var5 << 7) + (this.field2711[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2710[var3];
            if(var6 == 16384) {
               this.field2711[var3] = var5 + (this.field2711[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2704[var3] = (var5 << 7) + (this.field2704[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2704[var3] = var5 + (this.field2704[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2709[var3] |= 4;
            } else {
               this.method4275(var3);
               this.field2709[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method4328(var3, (var5 << 7) + (this.field2705[var3] & -16257));
         }

         if(var4 == 49) {
            this.method4328(var3, var5 + (this.field2705[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4263(var3, var4 + this.field2703[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4268(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method4269(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method4349();
         }
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "223671907"
   )
   void method4328(int var1, int var2) {
      this.field2705[var1] = var2;
      this.field2714[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lhk;I)I",
      garbageValue = "-2145933113"
   )
   int method4278(class231 var1) {
      int var2 = (var1.field2727 * var1.field2726 >> 12) + var1.field2732;
      var2 += (this.field2699[var1.field2734] - 8192) * this.field2711[var1.field2734] >> 12;
      class228 var3 = var1.field2724;
      int var4;
      if(var3.field2684 > 0 && (var3.field2680 > 0 || this.field2713[var1.field2734] > 0)) {
         var4 = var3.field2680 << 2;
         int var5 = var3.field2683 << 1;
         if(var1.field2740 < var5) {
            var4 = var4 * var1.field2740 / var5;
         }

         var4 += this.field2713[var1.field2734] >> 7;
         double var6 = Math.sin((double)(var1.field2741 & 511) * 0.01227184630308513D);
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2725.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)KeyFocusListener.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(Lhk;I)I",
      garbageValue = "457405921"
   )
   int method4279(class231 var1) {
      class228 var2 = var1.field2724;
      int var3 = this.field2698[var1.field2734] * this.field2700[var1.field2734] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2735 + 16384 >> 15;
      var3 = var3 * this.field2712 + 128 >> 8;
      if(var2.field2686 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2686 * 1.953125E-5D * (double)var1.field2730) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2679 != null) {
         var4 = var1.field2736;
         var5 = var2.field2679[var1.field2737 + 1];
         if(var1.field2737 < var2.field2679.length - 2) {
            var6 = (var2.field2679[var1.field2737] & 255) << 8;
            var7 = (var2.field2679[var1.field2737 + 2] & 255) << 8;
            var5 += (var2.field2679[var1.field2737 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2738 > 0 && var2.field2678 != null) {
         var4 = var1.field2738;
         var5 = var2.field2678[var1.field2739 + 1];
         if(var1.field2739 < var2.field2678.length - 2) {
            var6 = (var2.field2678[var1.field2739] & 255) << 8;
            var7 = (var2.field2678[var1.field2739 + 2] & 255) << 8;
            var5 += (var2.field2678[var1.field2739 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(Lhk;I)I",
      garbageValue = "-181156706"
   )
   int method4361(class231 var1) {
      int var2 = this.field2723[var1.field2734];
      return var2 < 8192?var2 * var1.field2731 + 32 >> 6:16384 - ((128 - var1.field2731) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-22"
   )
   void method4286() {
      int var1 = this.field2719;
      int var2 = this.field2720;

      long var3;
      for(var3 = this.field2722; var2 == this.field2720; var3 = this.field2717.method4385(var2)) {
         while(var2 == this.field2717.field2749[var1]) {
            this.field2717.method4378(var1);
            int var5 = this.field2717.method4382(var1);
            if(var5 == 1) {
               this.field2717.method4380();
               this.field2717.method4379(var1);
               if(this.field2717.method4387()) {
                  if(!this.field2718 || var2 == 0) {
                     this.method4349();
                     this.field2717.method4375();
                     return;
                  }

                  this.field2717.method4403(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method4267(var5);
            }

            this.field2717.method4399(var1);
            this.field2717.method4379(var1);
         }

         var1 = this.field2717.method4386();
         var2 = this.field2717.field2749[var1];
      }

      this.field2719 = var1;
      this.field2720 = var2;
      this.field2722 = var3;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(Lhk;I)Z",
      garbageValue = "1567799740"
   )
   boolean method4340(class231 var1) {
      if(var1.field2742 == null) {
         if(var1.field2738 >= 0) {
            var1.unlink();
            if(var1.field2728 > 0 && var1 == this.field2716[var1.field2734][var1.field2728]) {
               this.field2716[var1.field2734][var1.field2728] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(Lhk;[IIII)Z",
      garbageValue = "110718670"
   )
   boolean method4332(class231 var1, int[] var2, int var3, int var4) {
      var1.field2743 = KeyFocusListener.sampleRate / 100;
      if(var1.field2738 < 0 || var1.field2742 != null && !var1.field2742.method2459()) {
         int var5 = var1.field2726;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2706[var1.field2734]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2726 = var5;
         }

         var1.field2742.method2378(this.method4278(var1));
         class228 var6 = var1.field2724;
         boolean var7 = false;
         ++var1.field2740;
         var1.field2741 += var6.field2684;
         double var8 = (double)((var1.field2729 - 60 << 8) + (var1.field2727 * var1.field2726 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2686 > 0) {
            if(var6.field2682 > 0) {
               var1.field2730 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2682) + 0.5D);
            } else {
               var1.field2730 += 128;
            }
         }

         if(var6.field2679 != null) {
            if(var6.field2677 > 0) {
               var1.field2736 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2677 * var8) + 0.5D);
            } else {
               var1.field2736 += 128;
            }

            while(var1.field2737 < var6.field2679.length - 2 && var1.field2736 > (var6.field2679[var1.field2737 + 2] & 255) << 8) {
               var1.field2737 += 2;
            }

            if(var6.field2679.length - 2 == var1.field2737 && var6.field2679[var1.field2737 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2738 >= 0 && var6.field2678 != null && (this.field2709[var1.field2734] & 1) == 0 && (var1.field2728 < 0 || var1 != this.field2716[var1.field2734][var1.field2728])) {
            if(var6.field2681 > 0) {
               var1.field2738 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2681) + 0.5D);
            } else {
               var1.field2738 += 128;
            }

            while(var1.field2739 < var6.field2678.length - 2 && var1.field2738 > (var6.field2678[var1.field2739 + 2] & 255) << 8) {
               var1.field2739 += 2;
            }

            if(var6.field2678.length - 2 == var1.field2739) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2742.method2421(var1.field2743);
            if(var2 != null) {
               var1.field2742.vmethod4435(var2, var3, var4);
            } else {
               var1.field2742.vmethod4436(var4);
            }

            if(var1.field2742.method2381()) {
               this.field2702.field2772.method2103(var1.field2742);
            }

            var1.method4371();
            if(var1.field2738 >= 0) {
               var1.unlink();
               if(var1.field2728 > 0 && var1 == this.field2716[var1.field2734][var1.field2728]) {
                  this.field2716[var1.field2734][var1.field2728] = null;
               }
            }

            return true;
         } else {
            var1.field2742.method2376(var1.field2743, this.method4279(var1), this.method4361(var1));
            return false;
         }
      } else {
         var1.method4371();
         var1.unlink();
         if(var1.field2728 > 0 && var1 == this.field2716[var1.field2734][var1.field2728]) {
            this.field2716[var1.field2734][var1.field2728] = null;
         }

         return true;
      }
   }
}
