import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class230 extends TaskDataNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   HashTable field2686;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1139442143
   )
   int field2692;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -428440479
   )
   int field2688;
   @ObfuscatedName("j")
   int[] field2689;
   @ObfuscatedName("k")
   int[] field2690;
   @ObfuscatedName("x")
   int[] field2691;
   @ObfuscatedName("z")
   int[] field2693;
   @ObfuscatedName("p")
   int[] field2712;
   @ObfuscatedName("r")
   int[] field2702;
   @ObfuscatedName("d")
   int[] field2695;
   @ObfuscatedName("a")
   int[] field2696;
   @ObfuscatedName("e")
   int[] field2687;
   @ObfuscatedName("v")
   int[] field2698;
   @ObfuscatedName("n")
   int[] field2704;
   @ObfuscatedName("u")
   int[] field2700;
   @ObfuscatedName("q")
   int[] field2701;
   @ObfuscatedName("g")
   int[] field2699;
   @ObfuscatedName("y")
   int[] field2703;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[[Lhu;"
   )
   class231[][] field2694;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "[[Lhu;"
   )
   class231[][] field2705;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   class232 field2706;
   @ObfuscatedName("al")
   boolean field2707;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 6498057
   )
   int field2708;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -951307553
   )
   int field2709;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      longValue = 6516003723568028665L
   )
   long field2710;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      longValue = -3298518921904319225L
   )
   long field2711;
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   class234 field2697;

   public class230() {
      this.field2692 = 256;
      this.field2688 = 1000000;
      this.field2689 = new int[16];
      this.field2690 = new int[16];
      this.field2691 = new int[16];
      this.field2693 = new int[16];
      this.field2712 = new int[16];
      this.field2702 = new int[16];
      this.field2695 = new int[16];
      this.field2696 = new int[16];
      this.field2687 = new int[16];
      this.field2698 = new int[16];
      this.field2704 = new int[16];
      this.field2700 = new int[16];
      this.field2701 = new int[16];
      this.field2699 = new int[16];
      this.field2703 = new int[16];
      this.field2694 = new class231[16][128];
      this.field2705 = new class231[16][128];
      this.field2706 = new class232();
      this.field2697 = new class234(this);
      this.field2686 = new HashTable(128);
      this.method4191();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "833556516"
   )
   public synchronized void method4144(int var1) {
      this.field2692 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "30593"
   )
   int method4145() {
      return this.field2692;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Liu;Ljm;Ldl;II)Z",
      garbageValue = "1980325708"
   )
   public synchronized boolean method4146(Track1 var1, IndexDataBase var2, class110 var3, int var4) {
      var1.method4370();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2762.first(); var7 != null; var7 = (ByteArrayNode)var1.field2762.next()) {
         int var8 = (int)var7.hash;
         class233 var9 = (class233)this.field2686.get((long)var8);
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

            this.field2686.put(var10, (long)var8);
         }

         if(!var9.method4327(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4361();
      }

      return var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-15"
   )
   public synchronized void method4172() {
      for(class233 var1 = (class233)this.field2686.first(); var1 != null; var1 = (class233)this.field2686.next()) {
         var1.method4328();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2106255181"
   )
   synchronized void method4148() {
      for(class233 var1 = (class233)this.field2686.first(); var1 != null; var1 = (class233)this.field2686.next()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected synchronized TaskDataNode vmethod4336() {
      return this.field2697;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected synchronized TaskDataNode vmethod4337() {
      return null;
   }

   @ObfuscatedName("p")
   protected synchronized int vmethod4338() {
      return 0;
   }

   @ObfuscatedName("w")
   protected synchronized void vmethod4339(int[] var1, int var2, int var3) {
      if(this.field2706.method4266()) {
         int var4 = this.field2706.field2736 * this.field2688 / class317.sampleRate;

         do {
            long var5 = (long)var4 * (long)var3 + this.field2710;
            if(this.field2711 - var5 >= 0L) {
               this.field2710 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2711 - this.field2710) - 1L) / (long)var4);
            this.field2710 += (long)var7 * (long)var4;
            this.field2697.vmethod4339(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method4176();
         } while(this.field2706.method4266());
      }

      this.field2697.vmethod4339(var1, var2, var3);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Liu;ZI)V",
      garbageValue = "-1231786202"
   )
   public synchronized void method4174(Track1 var1, boolean var2) {
      this.method4150();
      this.field2706.method4264(var1.field2761);
      this.field2707 = var2;
      this.field2710 = 0L;
      int var3 = this.field2706.method4278();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2706.method4268(var4);
         this.field2706.method4271(var4);
         this.field2706.method4269(var4);
      }

      this.field2708 = this.field2706.method4267();
      this.field2709 = this.field2706.field2739[this.field2708];
      this.field2711 = this.field2706.method4275(this.field2709);
   }

   @ObfuscatedName("d")
   protected synchronized void vmethod4340(int var1) {
      if(this.field2706.method4266()) {
         int var2 = this.field2706.field2736 * this.field2688 / class317.sampleRate;

         do {
            long var3 = (long)var1 * (long)var2 + this.field2710;
            if(this.field2711 - var3 >= 0L) {
               this.field2710 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2711 - this.field2710) - 1L) / (long)var2);
            this.field2710 += (long)var5 * (long)var2;
            this.field2697.vmethod4340(var5);
            var1 -= var5;
            this.method4176();
         } while(this.field2706.method4266());
      }

      this.field2697.vmethod4340(var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-435025645"
   )
   public synchronized void method4150() {
      this.field2706.method4265();
      this.method4191();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-511562746"
   )
   synchronized boolean method4169() {
      return this.field2706.method4266();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-87673009"
   )
   public synchronized void method4152(int var1, int var2) {
      this.method4237(var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2046720671"
   )
   void method4237(int var1, int var2) {
      this.field2693[var1] = var2;
      this.field2702[var1] = var2 & -128;
      this.method4229(var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-81"
   )
   void method4229(int var1, int var2) {
      if(var2 != this.field2712[var1]) {
         this.field2712[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2705[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-10"
   )
   void method4197(int var1, int var2, int var3) {
      this.method4156(var1, var2, 64);
      if((this.field2698[var1] & 2) != 0) {
         for(class231 var4 = (class231)this.field2697.field2757.getTail(); var4 != null; var4 = (class231)this.field2697.field2757.getPrevious()) {
            if(var4.field2725 == var1 && var4.field2728 < 0) {
               this.field2694[var1][var4.field2719] = null;
               this.field2694[var1][var2] = var4;
               int var5 = (var4.field2723 * var4.field2724 >> 12) + var4.field2722;
               var4.field2722 += var2 - var4.field2719 << 8;
               var4.field2723 = var5 - var4.field2722;
               var4.field2724 = 4096;
               var4.field2719 = var2;
               return;
            }
         }
      }

      class233 var9 = (class233)this.field2686.get((long)this.field2712[var1]);
      if(var9 != null) {
         RawAudioNode var8 = var9.field2751[var2];
         if(var8 != null) {
            class231 var6 = new class231();
            var6.field2725 = var1;
            var6.field2715 = var9;
            var6.field2716 = var8;
            var6.field2717 = var9.field2754[var2];
            var6.field2718 = var9.field2755[var2];
            var6.field2719 = var2;
            var6.field2720 = var3 * var3 * var9.field2750[var2] * var9.field2756 + 1024 >> 11;
            var6.field2721 = var9.field2753[var2] & 255;
            var6.field2722 = (var2 << 8) - (var9.field2752[var2] & 32767);
            var6.field2731 = 0;
            var6.field2726 = 0;
            var6.field2727 = 0;
            var6.field2728 = -1;
            var6.field2729 = 0;
            if(this.field2701[var1] == 0) {
               var6.field2732 = class115.method2446(var8, this.method4168(var6), this.method4194(var6), this.method4170(var6));
            } else {
               var6.field2732 = class115.method2446(var8, this.method4168(var6), 0, this.method4170(var6));
               this.method4219(var6, var9.field2752[var2] < 0);
            }

            if(var9.field2752[var2] < 0) {
               var6.field2732.method2303(-1);
            }

            if(var6.field2718 >= 0) {
               class231 var7 = this.field2705[var1][var6.field2718];
               if(var7 != null && var7.field2728 < 0) {
                  this.field2694[var1][var7.field2719] = null;
                  var7.field2728 = 0;
               }

               this.field2705[var1][var6.field2718] = var6;
            }

            this.field2697.field2757.addFront(var6);
            this.field2694[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lhu;ZI)V",
      garbageValue = "-1765722956"
   )
   void method4219(class231 var1, boolean var2) {
      int var3 = var1.field2716.audioBuffer.length;
      int var4;
      if(var2 && var1.field2716.field1539) {
         int var5 = var3 + var3 - var1.field2716.startPosition;
         var4 = (int)((long)var5 * (long)this.field2701[var1.field2725] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2732.method2310();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2701[var1.field2725] >> 6);
      }

      var1.field2732.method2323(var4);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "1"
   )
   void method4156(int var1, int var2, int var3) {
      class231 var4 = this.field2694[var1][var2];
      if(var4 != null) {
         this.field2694[var1][var2] = null;
         if((this.field2698[var1] & 2) != 0) {
            for(class231 var5 = (class231)this.field2697.field2757.getFront(); var5 != null; var5 = (class231)this.field2697.field2757.getNext()) {
               if(var5.field2725 == var4.field2725 && var5.field2728 < 0 && var5 != var4) {
                  var4.field2728 = 0;
                  break;
               }
            }
         } else {
            var4.field2728 = 0;
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-2053494938"
   )
   void method4154(int var1, int var2, int var3) {
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1309201412"
   )
   void method4158(int var1, int var2) {
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-888245021"
   )
   void method4159(int var1, int var2) {
      this.field2695[var1] = var2;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-121"
   )
   void method4160(int var1) {
      for(class231 var2 = (class231)this.field2697.field2757.getFront(); var2 != null; var2 = (class231)this.field2697.field2757.getNext()) {
         if(var1 < 0 || var2.field2725 == var1) {
            if(var2.field2732 != null) {
               var2.field2732.method2314(class317.sampleRate / 100);
               if(var2.field2732.method2318()) {
                  this.field2697.field2760.method2085(var2.field2732);
               }

               var2.method4259();
            }

            if(var2.field2728 < 0) {
               this.field2694[var2.field2725][var2.field2719] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "28"
   )
   void method4245(int var1) {
      if(var1 >= 0) {
         this.field2689[var1] = 12800;
         this.field2690[var1] = 8192;
         this.field2691[var1] = 16383;
         this.field2695[var1] = 8192;
         this.field2696[var1] = 0;
         this.field2687[var1] = 8192;
         this.method4164(var1);
         this.method4165(var1);
         this.field2698[var1] = 0;
         this.field2704[var1] = 32767;
         this.field2700[var1] = 256;
         this.field2701[var1] = 0;
         this.method4167(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method4245(var1);
         }

      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1927531403"
   )
   void method4162(int var1) {
      for(class231 var2 = (class231)this.field2697.field2757.getFront(); var2 != null; var2 = (class231)this.field2697.field2757.getNext()) {
         if((var1 < 0 || var2.field2725 == var1) && var2.field2728 < 0) {
            this.field2694[var2.field2725][var2.field2719] = null;
            var2.field2728 = 0;
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1023223227"
   )
   void method4191() {
      this.method4160(-1);
      this.method4245(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2712[var1] = this.field2693[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2702[var1] = this.field2693[var1] & -128;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "42"
   )
   void method4164(int var1) {
      if((this.field2698[var1] & 2) != 0) {
         for(class231 var2 = (class231)this.field2697.field2757.getFront(); var2 != null; var2 = (class231)this.field2697.field2757.getNext()) {
            if(var2.field2725 == var1 && this.field2694[var1][var2.field2719] == null && var2.field2728 < 0) {
               var2.field2728 = 0;
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1846926532"
   )
   void method4165(int var1) {
      if((this.field2698[var1] & 4) != 0) {
         for(class231 var2 = (class231)this.field2697.field2757.getFront(); var2 != null; var2 = (class231)this.field2697.field2757.getNext()) {
            if(var2.field2725 == var1) {
               var2.field2734 = 0;
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-471781276"
   )
   void method4230(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4156(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method4197(var3, var4, var5);
         } else {
            this.method4156(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method4154(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2702[var3] = (var5 << 14) + (this.field2702[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2702[var3] = (var5 << 7) + (this.field2702[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2696[var3] = (var5 << 7) + (this.field2696[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2696[var3] = var5 + (this.field2696[var3] & -128);
         }

         if(var4 == 5) {
            this.field2687[var3] = (var5 << 7) + (this.field2687[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2687[var3] = var5 + (this.field2687[var3] & -128);
         }

         if(var4 == 7) {
            this.field2689[var3] = (var5 << 7) + (this.field2689[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2689[var3] = var5 + (this.field2689[var3] & -128);
         }

         if(var4 == 10) {
            this.field2690[var3] = (var5 << 7) + (this.field2690[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2690[var3] = var5 + (this.field2690[var3] & -128);
         }

         if(var4 == 11) {
            this.field2691[var3] = (var5 << 7) + (this.field2691[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2691[var3] = var5 + (this.field2691[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2698[var3] |= 1;
            } else {
               this.field2698[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2698[var3] |= 2;
            } else {
               this.method4164(var3);
               this.field2698[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2704[var3] = (var5 << 7) + (this.field2704[var3] & 127);
         }

         if(var4 == 98) {
            this.field2704[var3] = (this.field2704[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2704[var3] = (var5 << 7) + (this.field2704[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2704[var3] = (this.field2704[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method4160(var3);
         }

         if(var4 == 121) {
            this.method4245(var3);
         }

         if(var4 == 123) {
            this.method4162(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2704[var3];
            if(var6 == 16384) {
               this.field2700[var3] = (var5 << 7) + (this.field2700[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2704[var3];
            if(var6 == 16384) {
               this.field2700[var3] = var5 + (this.field2700[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2701[var3] = (var5 << 7) + (this.field2701[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2701[var3] = var5 + (this.field2701[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2698[var3] |= 4;
            } else {
               this.method4165(var3);
               this.field2698[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method4167(var3, (var5 << 7) + (this.field2699[var3] & -16257));
         }

         if(var4 == 49) {
            this.method4167(var3, var5 + (this.field2699[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4229(var3, var4 + this.field2702[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method4158(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method4159(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method4191();
         }
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "634074011"
   )
   void method4167(int var1, int var2) {
      this.field2699[var1] = var2;
      this.field2703[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lhu;S)I",
      garbageValue = "-22501"
   )
   int method4168(class231 var1) {
      int var2 = (var1.field2723 * var1.field2724 >> 12) + var1.field2722;
      var2 += (this.field2695[var1.field2725] - 8192) * this.field2700[var1.field2725] >> 12;
      class228 var3 = var1.field2717;
      int var4;
      if(var3.field2667 > 0 && (var3.field2673 > 0 || this.field2696[var1.field2725] > 0)) {
         var4 = var3.field2673 << 2;
         int var5 = var3.field2671 << 1;
         if(var1.field2733 < var5) {
            var4 = var4 * var1.field2733 / var5;
         }

         var4 += this.field2696[var1.field2725] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2730 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2716.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)class317.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lhu;I)I",
      garbageValue = "1053159091"
   )
   int method4194(class231 var1) {
      class228 var2 = var1.field2717;
      int var3 = this.field2691[var1.field2725] * this.field2689[var1.field2725] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2720 + 16384 >> 15;
      var3 = var3 * this.field2692 + 128 >> 8;
      if(var2.field2669 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2669 * 1.953125E-5D * (double)var1.field2731) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2674 != null) {
         var4 = var1.field2726;
         var5 = var2.field2674[var1.field2727 + 1];
         if(var1.field2727 < var2.field2674.length - 2) {
            var6 = (var2.field2674[var1.field2727] & 255) << 8;
            var7 = (var2.field2674[var1.field2727 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2674[var1.field2727 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2728 > 0 && var2.field2668 != null) {
         var4 = var1.field2728;
         var5 = var2.field2668[var1.field2729 + 1];
         if(var1.field2729 < var2.field2668.length - 2) {
            var6 = (var2.field2668[var1.field2729] & 255) << 8;
            var7 = (var2.field2668[var1.field2729 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2668[var1.field2729 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lhu;I)I",
      garbageValue = "-2089465605"
   )
   int method4170(class231 var1) {
      int var2 = this.field2690[var1.field2725];
      return var2 < 8192?var2 * var1.field2721 + 32 >> 6:16384 - ((128 - var1.field2721) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1177668007"
   )
   void method4176() {
      int var1 = this.field2708;
      int var2 = this.field2709;

      long var3;
      for(var3 = this.field2711; var2 == this.field2709; var3 = this.field2706.method4275(var2)) {
         while(var2 == this.field2706.field2739[var1]) {
            this.field2706.method4268(var1);
            int var5 = this.field2706.method4293(var1);
            if(var5 == 1) {
               this.field2706.method4270();
               this.field2706.method4269(var1);
               if(this.field2706.method4277()) {
                  if(!this.field2707 || var2 == 0) {
                     this.method4191();
                     this.field2706.method4265();
                     return;
                  }

                  this.field2706.method4280(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method4230(var5);
            }

            this.field2706.method4271(var1);
            this.field2706.method4269(var1);
         }

         var1 = this.field2706.method4267();
         var2 = this.field2706.field2739[var1];
      }

      this.field2708 = var1;
      this.field2709 = var2;
      this.field2711 = var3;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(Lhu;I)Z",
      garbageValue = "1772765434"
   )
   boolean method4177(class231 var1) {
      if(var1.field2732 == null) {
         if(var1.field2728 >= 0) {
            var1.unlink();
            if(var1.field2718 > 0 && var1 == this.field2705[var1.field2725][var1.field2718]) {
               this.field2705[var1.field2725][var1.field2718] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(Lhu;[IIII)Z",
      garbageValue = "-1984198763"
   )
   boolean method4199(class231 var1, int[] var2, int var3, int var4) {
      var1.field2714 = class317.sampleRate / 100;
      if(var1.field2728 < 0 || var1.field2732 != null && !var1.field2732.method2317()) {
         int var5 = var1.field2724;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2687[var1.field2725]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2724 = var5;
         }

         var1.field2732.method2315(this.method4168(var1));
         class228 var6 = var1.field2717;
         boolean var7 = false;
         ++var1.field2733;
         var1.field2730 += var6.field2667;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2719 - 60 << 8) + (var1.field2724 * var1.field2723 >> 12));
         if(var6.field2669 > 0) {
            if(var6.field2672 > 0) {
               var1.field2731 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2672 * var8) + 0.5D);
            } else {
               var1.field2731 += 128;
            }
         }

         if(var6.field2674 != null) {
            if(var6.field2670 > 0) {
               var1.field2726 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2670 * var8) + 0.5D);
            } else {
               var1.field2726 += 128;
            }

            while(var1.field2727 < var6.field2674.length - 2 && var1.field2726 > (var6.field2674[var1.field2727 + 2] & 255) << 8) {
               var1.field2727 += 2;
            }

            if(var6.field2674.length - 2 == var1.field2727 && var6.field2674[var1.field2727 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2728 >= 0 && var6.field2668 != null && (this.field2698[var1.field2725] & 1) == 0 && (var1.field2718 < 0 || var1 != this.field2705[var1.field2725][var1.field2718])) {
            if(var6.field2675 > 0) {
               var1.field2728 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2675 * var8) + 0.5D);
            } else {
               var1.field2728 += 128;
            }

            while(var1.field2729 < var6.field2668.length - 2 && var1.field2728 > (var6.field2668[var1.field2729 + 2] & 255) << 8) {
               var1.field2729 += 2;
            }

            if(var6.field2668.length - 2 == var1.field2729) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2732.method2314(var1.field2714);
            if(var2 != null) {
               var1.field2732.vmethod4339(var2, var3, var4);
            } else {
               var1.field2732.vmethod4340(var4);
            }

            if(var1.field2732.method2318()) {
               this.field2697.field2760.method2085(var1.field2732);
            }

            var1.method4259();
            if(var1.field2728 >= 0) {
               var1.unlink();
               if(var1.field2718 > 0 && var1 == this.field2705[var1.field2725][var1.field2718]) {
                  this.field2705[var1.field2725][var1.field2718] = null;
               }
            }

            return true;
         } else {
            var1.field2732.method2313(var1.field2714, this.method4194(var1), this.method4170(var1));
            return false;
         }
      } else {
         var1.method4259();
         var1.unlink();
         if(var1.field2718 > 0 && var1 == this.field2705[var1.field2725][var1.field2718]) {
            this.field2705[var1.field2725][var1.field2718] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lee;",
      garbageValue = "-2075247307"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         IndexDataBase var3 = Sequence.skel_ref;
         IndexDataBase var4 = Sequence.skin_ref;
         boolean var5 = true;
         int[] var6 = var3.getChilds(var0);

         for(int var7 = 0; var7 < var6.length; ++var7) {
            byte[] var8 = var3.getChild(var0, var6[var7]);
            if(var8 == null) {
               var5 = false;
            } else {
               int var9 = (var8[0] & 255) << 8 | var8[1] & 255;
               byte[] var10 = var4.getChild(var9, 0);
               if(var10 == null) {
                  var5 = false;
               }
            }
         }

         Frames var2;
         if(!var5) {
            var2 = null;
         } else {
            try {
               var2 = new Frames(var3, var4, var0, false);
            } catch (Exception var12) {
               var2 = null;
            }
         }

         if(var2 != null) {
            Sequence.skeletons.put(var2, (long)var0);
         }

         return var2;
      }
   }
}
