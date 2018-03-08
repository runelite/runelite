import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class230 extends TaskDataNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   HashTable field2695;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -743208837
   )
   int field2681;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1386925527
   )
   int field2690;
   @ObfuscatedName("a")
   int[] field2683;
   @ObfuscatedName("l")
   int[] field2684;
   @ObfuscatedName("b")
   int[] field2685;
   @ObfuscatedName("e")
   int[] field2706;
   @ObfuscatedName("x")
   int[] field2687;
   @ObfuscatedName("p")
   int[] field2688;
   @ObfuscatedName("g")
   int[] field2680;
   @ObfuscatedName("n")
   int[] field2705;
   @ObfuscatedName("o")
   int[] field2691;
   @ObfuscatedName("s")
   int[] field2693;
   @ObfuscatedName("d")
   int[] field2694;
   @ObfuscatedName("f")
   int[] field2709;
   @ObfuscatedName("r")
   int[] field2689;
   @ObfuscatedName("y")
   int[] field2697;
   @ObfuscatedName("h")
   int[] field2698;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[[Lhb;"
   )
   class231[][] field2699;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "[[Lhb;"
   )
   class231[][] field2696;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   class232 field2701;
   @ObfuscatedName("av")
   boolean field2702;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -949765147
   )
   int field2703;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 2108809611
   )
   int field2704;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      longValue = -3537994052145510567L
   )
   long field2700;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = -7389307468009275513L
   )
   long field2686;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   class234 field2707;

   public class230() {
      this.field2681 = 256;
      this.field2690 = 1000000;
      this.field2683 = new int[16];
      this.field2684 = new int[16];
      this.field2685 = new int[16];
      this.field2706 = new int[16];
      this.field2687 = new int[16];
      this.field2688 = new int[16];
      this.field2680 = new int[16];
      this.field2705 = new int[16];
      this.field2691 = new int[16];
      this.field2693 = new int[16];
      this.field2694 = new int[16];
      this.field2709 = new int[16];
      this.field2689 = new int[16];
      this.field2697 = new int[16];
      this.field2698 = new int[16];
      this.field2699 = new class231[16][128];
      this.field2696 = new class231[16][128];
      this.field2701 = new class232();
      this.field2707 = new class234(this);
      this.field2695 = new HashTable(128);
      this.method4186();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1470490137"
   )
   synchronized void method4220(int var1) {
      this.field2681 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1462474621"
   )
   int method4198() {
      return this.field2681;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lix;Ljc;Ldc;IB)Z",
      garbageValue = "46"
   )
   synchronized boolean method4286(Track1 var1, IndexDataBase var2, class110 var3, int var4) {
      var1.method4377();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2763.first(); var7 != null; var7 = (ByteArrayNode)var1.field2763.next()) {
         int var8 = (int)var7.hash;
         class233 var9 = (class233)this.field2695.get((long)var8);
         if(var9 == null) {
            var9 = Script.method2048(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2695.put(var9, (long)var8);
         }

         if(!var9.method4345(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4380();
      }

      return var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2114020249"
   )
   synchronized void method4169() {
      for(class233 var1 = (class233)this.field2695.first(); var1 != null; var1 = (class233)this.field2695.next()) {
         var1.method4346();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1271938155"
   )
   synchronized void method4238() {
      for(class233 var1 = (class233)this.field2695.first(); var1 != null; var1 = (class233)this.field2695.next()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Ldo;"
   )
   protected synchronized TaskDataNode vmethod4354() {
      return this.field2707;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Ldo;"
   )
   protected synchronized TaskDataNode vmethod4356() {
      return null;
   }

   @ObfuscatedName("x")
   protected synchronized int vmethod4363() {
      return 0;
   }

   @ObfuscatedName("p")
   protected synchronized void vmethod4357(int[] var1, int var2, int var3) {
      if(this.field2701.method4296()) {
         int var4 = this.field2701.field2734 * this.field2690 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = this.field2700 + (long)var3 * (long)var4;
            if(this.field2686 - var5 >= 0L) {
               this.field2700 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2686 - this.field2700) - 1L) / (long)var4);
            this.field2700 += (long)var4 * (long)var7;
            this.field2707.vmethod4357(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method4199();
         } while(this.field2701.method4296());
      }

      this.field2707.vmethod4357(var1, var2, var3);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lix;ZI)V",
      garbageValue = "-86231336"
   )
   synchronized void method4171(Track1 var1, boolean var2) {
      this.method4172();
      this.field2701.method4294(var1.field2762);
      this.field2702 = var2;
      this.field2700 = 0L;
      int var3 = this.field2701.method4324();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2701.method4298(var4);
         this.field2701.method4301(var4);
         this.field2701.method4297(var4);
      }

      this.field2703 = this.field2701.method4304();
      this.field2704 = this.field2701.field2736[this.field2703];
      this.field2686 = this.field2701.method4315(this.field2704);
   }

   @ObfuscatedName("c")
   protected synchronized void vmethod4367(int var1) {
      if(this.field2701.method4296()) {
         int var2 = this.field2701.field2734 * this.field2690 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = this.field2700 + (long)var2 * (long)var1;
            if(this.field2686 - var3 >= 0L) {
               this.field2700 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2686 - this.field2700) - 1L) / (long)var2);
            this.field2700 += (long)var5 * (long)var2;
            this.field2707.vmethod4367(var5);
            var1 -= var5;
            this.method4199();
         } while(this.field2701.method4296());
      }

      this.field2707.vmethod4367(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   synchronized void method4172() {
      this.field2701.method4306();
      this.method4186();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1293309584"
   )
   public synchronized boolean method4209() {
      return this.field2701.method4296();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "649575920"
   )
   public synchronized void method4174(int var1, int var2) {
      this.method4175(var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "107"
   )
   void method4175(int var1, int var2) {
      this.field2706[var1] = var2;
      this.field2688[var1] = var2 & -128;
      this.method4176(var1, var2);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1684654063"
   )
   void method4176(int var1, int var2) {
      if(var2 != this.field2687[var1]) {
         this.field2687[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2696[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-106"
   )
   void method4269(int var1, int var2, int var3) {
      this.method4173(var1, var2, 64);
      if((this.field2693[var1] & 2) != 0) {
         for(class231 var4 = (class231)this.field2707.field2757.getTail(); var4 != null; var4 = (class231)this.field2707.field2757.getPrevious()) {
            if(var4.field2726 == var1 && var4.field2711 < 0) {
               this.field2699[var1][var4.field2716] = null;
               this.field2699[var1][var2] = var4;
               int var5 = (var4.field2721 * var4.field2720 >> 12) + var4.field2712;
               var4.field2712 += var2 - var4.field2716 << 8;
               var4.field2720 = var5 - var4.field2712;
               var4.field2721 = 4096;
               var4.field2716 = var2;
               return;
            }
         }
      }

      class233 var9 = (class233)this.field2695.get((long)this.field2687[var1]);
      if(var9 != null) {
         RawAudioNode var8 = var9.field2747[var2];
         if(var8 != null) {
            class231 var6 = new class231();
            var6.field2726 = var1;
            var6.field2727 = var9;
            var6.field2713 = var8;
            var6.field2714 = var9.field2751[var2];
            var6.field2715 = var9.field2746[var2];
            var6.field2716 = var2;
            var6.field2717 = var3 * var3 * var9.field2749[var2] * var9.field2753 + 1024 >> 11;
            var6.field2718 = var9.field2750[var2] & 255;
            var6.field2712 = (var2 << 8) - (var9.field2748[var2] & 32767);
            var6.field2722 = 0;
            var6.field2719 = 0;
            var6.field2730 = 0;
            var6.field2711 = -1;
            var6.field2729 = 0;
            if(this.field2689[var1] == 0) {
               var6.field2723 = class115.method2317(var8, this.method4250(var6), this.method4167(var6), this.method4193(var6));
            } else {
               var6.field2723 = class115.method2317(var8, this.method4250(var6), 0, this.method4193(var6));
               this.method4257(var6, var9.field2748[var2] < 0);
            }

            if(var9.field2748[var2] < 0) {
               var6.field2723.method2383(-1);
            }

            if(var6.field2715 >= 0) {
               class231 var7 = this.field2696[var1][var6.field2715];
               if(var7 != null && var7.field2711 < 0) {
                  this.field2699[var1][var7.field2716] = null;
                  var7.field2711 = 0;
               }

               this.field2696[var1][var6.field2715] = var6;
            }

            this.field2707.field2757.addFront(var6);
            this.field2699[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lhb;ZB)V",
      garbageValue = "1"
   )
   void method4257(class231 var1, boolean var2) {
      int var3 = var1.field2713.audioBuffer.length;
      int var4;
      if(var2 && var1.field2713.field1522) {
         int var5 = var3 + var3 - var1.field2713.startPosition;
         var4 = (int)((long)this.field2689[var1.field2726] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2723.method2326();
         }
      } else {
         var4 = (int)((long)this.field2689[var1.field2726] * (long)var3 >> 6);
      }

      var1.field2723.method2325(var4);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2105762356"
   )
   void method4173(int var1, int var2, int var3) {
      class231 var4 = this.field2699[var1][var2];
      if(var4 != null) {
         this.field2699[var1][var2] = null;
         if((this.field2693[var1] & 2) != 0) {
            for(class231 var5 = (class231)this.field2707.field2757.getFront(); var5 != null; var5 = (class231)this.field2707.field2757.getNext()) {
               if(var4.field2726 == var5.field2726 && var5.field2711 < 0 && var5 != var4) {
                  var4.field2711 = 0;
                  break;
               }
            }
         } else {
            var4.field2711 = 0;
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1207765251"
   )
   void method4180(int var1, int var2, int var3) {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1495487649"
   )
   void method4178(int var1, int var2) {
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "583668773"
   )
   void method4182(int var1, int var2) {
      this.field2680[var1] = var2;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void method4183(int var1) {
      for(class231 var2 = (class231)this.field2707.field2757.getFront(); var2 != null; var2 = (class231)this.field2707.field2757.getNext()) {
         if(var1 < 0 || var2.field2726 == var1) {
            if(var2.field2723 != null) {
               var2.field2723.method2330(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2723.method2334()) {
                  this.field2707.field2756.method2086(var2.field2723);
               }

               var2.method4292();
            }

            if(var2.field2711 < 0) {
               this.field2699[var2.field2726][var2.field2716] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1834610097"
   )
   void method4184(int var1) {
      if(var1 >= 0) {
         this.field2683[var1] = 12800;
         this.field2684[var1] = 8192;
         this.field2685[var1] = 16383;
         this.field2680[var1] = 8192;
         this.field2705[var1] = 0;
         this.field2691[var1] = 8192;
         this.method4187(var1);
         this.method4188(var1);
         this.field2693[var1] = 0;
         this.field2694[var1] = 32767;
         this.field2709[var1] = 256;
         this.field2689[var1] = 0;
         this.method4190(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method4184(var1);
         }

      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1791512343"
   )
   void method4278(int var1) {
      for(class231 var2 = (class231)this.field2707.field2757.getFront(); var2 != null; var2 = (class231)this.field2707.field2757.getNext()) {
         if((var1 < 0 || var2.field2726 == var1) && var2.field2711 < 0) {
            this.field2699[var2.field2726][var2.field2716] = null;
            var2.field2711 = 0;
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   void method4186() {
      this.method4183(-1);
      this.method4184(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2687[var1] = this.field2706[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2688[var1] = this.field2706[var1] & -128;
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-952967759"
   )
   void method4187(int var1) {
      if((this.field2693[var1] & 2) != 0) {
         for(class231 var2 = (class231)this.field2707.field2757.getFront(); var2 != null; var2 = (class231)this.field2707.field2757.getNext()) {
            if(var2.field2726 == var1 && this.field2699[var1][var2.field2716] == null && var2.field2711 < 0) {
               var2.field2711 = 0;
            }
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-853596457"
   )
   void method4188(int var1) {
      if((this.field2693[var1] & 4) != 0) {
         for(class231 var2 = (class231)this.field2707.field2757.getFront(); var2 != null; var2 = (class231)this.field2707.field2757.getNext()) {
            if(var2.field2726 == var1) {
               var2.field2731 = 0;
            }
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1110723164"
   )
   void method4189(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4173(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method4269(var3, var4, var5);
         } else {
            this.method4173(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4180(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2688[var3] = (var5 << 14) + (this.field2688[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2688[var3] = (var5 << 7) + (this.field2688[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2705[var3] = (var5 << 7) + (this.field2705[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2705[var3] = var5 + (this.field2705[var3] & -128);
         }

         if(var4 == 5) {
            this.field2691[var3] = (var5 << 7) + (this.field2691[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2691[var3] = var5 + (this.field2691[var3] & -128);
         }

         if(var4 == 7) {
            this.field2683[var3] = (var5 << 7) + (this.field2683[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2683[var3] = var5 + (this.field2683[var3] & -128);
         }

         if(var4 == 10) {
            this.field2684[var3] = (var5 << 7) + (this.field2684[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2684[var3] = var5 + (this.field2684[var3] & -128);
         }

         if(var4 == 11) {
            this.field2685[var3] = (var5 << 7) + (this.field2685[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2685[var3] = var5 + (this.field2685[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2693[var3] |= 1;
            } else {
               this.field2693[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2693[var3] |= 2;
            } else {
               this.method4187(var3);
               this.field2693[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2694[var3] = (var5 << 7) + (this.field2694[var3] & 127);
         }

         if(var4 == 98) {
            this.field2694[var3] = (this.field2694[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2694[var3] = (var5 << 7) + (this.field2694[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2694[var3] = (this.field2694[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method4183(var3);
         }

         if(var4 == 121) {
            this.method4184(var3);
         }

         if(var4 == 123) {
            this.method4278(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2694[var3];
            if(var6 == 16384) {
               this.field2709[var3] = (var5 << 7) + (this.field2709[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2694[var3];
            if(var6 == 16384) {
               this.field2709[var3] = var5 + (this.field2709[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2689[var3] = (var5 << 7) + (this.field2689[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2689[var3] = var5 + (this.field2689[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2693[var3] |= 4;
            } else {
               this.method4188(var3);
               this.field2693[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method4190(var3, (var5 << 7) + (this.field2697[var3] & -16257));
         }

         if(var4 == 49) {
            this.method4190(var3, var5 + (this.field2697[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4176(var3, var4 + this.field2688[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4178(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method4182(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method4186();
         }
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "983663485"
   )
   void method4190(int var1, int var2) {
      this.field2697[var1] = var2;
      this.field2698[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lhb;B)I",
      garbageValue = "47"
   )
   int method4250(class231 var1) {
      int var2 = (var1.field2721 * var1.field2720 >> 12) + var1.field2712;
      var2 += (this.field2680[var1.field2726] - 8192) * this.field2709[var1.field2726] >> 12;
      class228 var3 = var1.field2714;
      int var4;
      if(var3.field2665 > 0 && (var3.field2660 > 0 || this.field2705[var1.field2726] > 0)) {
         var4 = var3.field2660 << 2;
         int var5 = var3.field2663 << 1;
         if(var1.field2724 < var5) {
            var4 = var4 * var1.field2724 / var5;
         }

         var4 += this.field2705[var1.field2726] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2728 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.field2713.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lhb;B)I",
      garbageValue = "-128"
   )
   int method4167(class231 var1) {
      class228 var2 = var1.field2714;
      int var3 = this.field2685[var1.field2726] * this.field2683[var1.field2726] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2717 + 16384 >> 15;
      var3 = var3 * this.field2681 + 128 >> 8;
      if(var2.field2662 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field2722 * 1.953125E-5D * (double)var2.field2662) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2671 != null) {
         var4 = var1.field2719;
         var5 = var2.field2671[var1.field2730 + 1];
         if(var1.field2730 < var2.field2671.length - 2) {
            var6 = (var2.field2671[var1.field2730] & 255) << 8;
            var7 = (var2.field2671[var1.field2730 + 2] & 255) << 8;
            var5 += (var2.field2671[var1.field2730 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2711 > 0 && var2.field2661 != null) {
         var4 = var1.field2711;
         var5 = var2.field2661[var1.field2729 + 1];
         if(var1.field2729 < var2.field2661.length - 2) {
            var6 = (var2.field2661[var1.field2729] & 255) << 8;
            var7 = (var2.field2661[var1.field2729 + 2] & 255) << 8;
            var5 += (var2.field2661[var1.field2729 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lhb;I)I",
      garbageValue = "316889420"
   )
   int method4193(class231 var1) {
      int var2 = this.field2684[var1.field2726];
      return var2 < 8192?var2 * var1.field2718 + 32 >> 6:16384 - ((128 - var1.field2718) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1837152418"
   )
   void method4199() {
      int var1 = this.field2703;
      int var2 = this.field2704;

      long var3;
      for(var3 = this.field2686; var2 == this.field2704; var3 = this.field2701.method4315(var2)) {
         while(var2 == this.field2701.field2736[var1]) {
            this.field2701.method4298(var1);
            int var5 = this.field2701.method4341(var1);
            if(var5 == 1) {
               this.field2701.method4300();
               this.field2701.method4297(var1);
               if(this.field2701.method4307()) {
                  if(!this.field2702 || var2 == 0) {
                     this.method4186();
                     this.field2701.method4306();
                     return;
                  }

                  this.field2701.method4308(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method4189(var5);
            }

            this.field2701.method4301(var1);
            this.field2701.method4297(var1);
         }

         var1 = this.field2701.method4304();
         var2 = this.field2701.field2736[var1];
      }

      this.field2703 = var1;
      this.field2704 = var2;
      this.field2686 = var3;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(Lhb;B)Z",
      garbageValue = "74"
   )
   boolean method4200(class231 var1) {
      if(var1.field2723 == null) {
         if(var1.field2711 >= 0) {
            var1.unlink();
            if(var1.field2715 > 0 && var1 == this.field2696[var1.field2726][var1.field2715]) {
               this.field2696[var1.field2726][var1.field2715] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(Lhb;[IIII)Z",
      garbageValue = "-491162613"
   )
   boolean method4201(class231 var1, int[] var2, int var3, int var4) {
      var1.field2725 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2711 < 0 || var1.field2723 != null && !var1.field2723.method2392()) {
         int var5 = var1.field2721;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2691[var1.field2726] * 4.921259842519685E-4D) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2721 = var5;
         }

         var1.field2723.method2427(this.method4250(var1));
         class228 var6 = var1.field2714;
         boolean var7 = false;
         ++var1.field2724;
         var1.field2728 += var6.field2665;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2716 - 60 << 8) + (var1.field2721 * var1.field2720 >> 12));
         if(var6.field2662 > 0) {
            if(var6.field2666 > 0) {
               var1.field2722 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2666 * var8) + 0.5D);
            } else {
               var1.field2722 += 128;
            }
         }

         if(var6.field2671 != null) {
            if(var6.field2667 > 0) {
               var1.field2719 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2667 * var8) + 0.5D);
            } else {
               var1.field2719 += 128;
            }

            while(var1.field2730 < var6.field2671.length - 2 && var1.field2719 > (var6.field2671[var1.field2730 + 2] & 255) << 8) {
               var1.field2730 += 2;
            }

            if(var6.field2671.length - 2 == var1.field2730 && var6.field2671[var1.field2730 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2711 >= 0 && var6.field2661 != null && (this.field2693[var1.field2726] & 1) == 0 && (var1.field2715 < 0 || var1 != this.field2696[var1.field2726][var1.field2715])) {
            if(var6.field2664 > 0) {
               var1.field2711 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2664) + 0.5D);
            } else {
               var1.field2711 += 128;
            }

            while(var1.field2729 < var6.field2661.length - 2 && var1.field2711 > (var6.field2661[var1.field2729 + 2] & 255) << 8) {
               var1.field2729 += 2;
            }

            if(var6.field2661.length - 2 == var1.field2729) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2723.method2330(var1.field2725);
            if(var2 != null) {
               var1.field2723.vmethod4357(var2, var3, var4);
            } else {
               var1.field2723.vmethod4367(var4);
            }

            if(var1.field2723.method2334()) {
               this.field2707.field2756.method2086(var1.field2723);
            }

            var1.method4292();
            if(var1.field2711 >= 0) {
               var1.unlink();
               if(var1.field2715 > 0 && var1 == this.field2696[var1.field2726][var1.field2715]) {
                  this.field2696[var1.field2726][var1.field2715] = null;
               }
            }

            return true;
         } else {
            var1.field2723.method2329(var1.field2725, this.method4167(var1), this.method4193(var1));
            return false;
         }
      } else {
         var1.method4292();
         var1.unlink();
         if(var1.field2715 > 0 && var1 == this.field2696[var1.field2726][var1.field2715]) {
            this.field2696[var1.field2726][var1.field2715] = null;
         }

         return true;
      }
   }
}
