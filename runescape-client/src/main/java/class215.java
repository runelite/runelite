import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
public class class215 extends TaskDataNode {
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   HashTable field2649;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1070983221
   )
   int field2637;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1505480423
   )
   int field2654;
   @ObfuscatedName("r")
   int[] field2648;
   @ObfuscatedName("h")
   int[] field2640;
   @ObfuscatedName("d")
   int[] field2641;
   @ObfuscatedName("s")
   int[] field2642;
   @ObfuscatedName("b")
   int[] field2643;
   @ObfuscatedName("e")
   int[] field2644;
   @ObfuscatedName("f")
   int[] field2645;
   @ObfuscatedName("z")
   int[] field2646;
   @ObfuscatedName("u")
   int[] field2662;
   @ObfuscatedName("x")
   int[] field2650;
   @ObfuscatedName("l")
   int[] field2647;
   @ObfuscatedName("j")
   int[] field2636;
   @ObfuscatedName("g")
   int[] field2651;
   @ObfuscatedName("c")
   int[] field2652;
   @ObfuscatedName("k")
   int[] field2653;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[[Lhb;"
   )
   class216[][] field2656;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "[[Lhb;"
   )
   class216[][] field2655;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   class217 field2660;
   @ObfuscatedName("at")
   boolean field2639;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1097778579
   )
   int field2658;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1927045843
   )
   int field2659;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      longValue = 7524767342315154389L
   )
   long field2664;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      longValue = -3419464246929080417L
   )
   long field2661;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   class219 field2657;

   public class215() {
      this.field2637 = 256;
      this.field2654 = 1000000;
      this.field2648 = new int[16];
      this.field2640 = new int[16];
      this.field2641 = new int[16];
      this.field2642 = new int[16];
      this.field2643 = new int[16];
      this.field2644 = new int[16];
      this.field2645 = new int[16];
      this.field2646 = new int[16];
      this.field2662 = new int[16];
      this.field2650 = new int[16];
      this.field2647 = new int[16];
      this.field2636 = new int[16];
      this.field2651 = new int[16];
      this.field2652 = new int[16];
      this.field2653 = new int[16];
      this.field2656 = new class216[16][128];
      this.field2655 = new class216[16][128];
      this.field2660 = new class217();
      this.field2657 = new class219(this);
      this.field2649 = new HashTable(128);
      this.method3918();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-3"
   )
   public synchronized void method3898(int var1) {
      this.field2637 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-748431343"
   )
   int method4004() {
      return this.field2637;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lhf;Lil;Lde;II)Z",
      garbageValue = "-120460157"
   )
   synchronized boolean method4003(Track1 var1, IndexDataBase var2, class111 var3, int var4) {
      var1.method4131();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2715.first(); var7 != null; var7 = (ByteArrayNode)var1.field2715.next()) {
         int var8 = (int)var7.hash;
         class218 var9 = (class218)this.field2649.get((long)var8);
         if(var9 == null) {
            var9 = class46.method690(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2649.put(var9, (long)var8);
         }

         if(!var9.method4094(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4130();
      }

      return var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   synchronized void method3901() {
      for(class218 var1 = (class218)this.field2649.first(); var1 != null; var1 = (class218)this.field2649.next()) {
         var1.method4084();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1051098840"
   )
   synchronized void method3902() {
      for(class218 var1 = (class218)this.field2649.first(); var1 != null; var1 = (class218)this.field2649.next()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected synchronized TaskDataNode vmethod4096() {
      return this.field2657;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected synchronized TaskDataNode vmethod4097() {
      return null;
   }

   @ObfuscatedName("b")
   protected synchronized int vmethod4109() {
      return 0;
   }

   @ObfuscatedName("e")
   protected synchronized void vmethod4099(int[] var1, int var2, int var3) {
      if(this.field2660.method4033()) {
         int var4 = this.field2660.field2688 * this.field2654 / AbstractSoundSystem.sampleRate;

         do {
            long var5 = (long)var3 * (long)var4 + this.field2664;
            if(this.field2661 - var5 >= 0L) {
               this.field2664 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2661 - this.field2664) - 1L) / (long)var4);
            this.field2664 += (long)var4 * (long)var7;
            this.field2657.vmethod4099(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3931();
         } while(this.field2660.method4033());
      }

      this.field2657.vmethod4099(var1, var2, var3);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lhf;ZI)V",
      garbageValue = "-28076369"
   )
   synchronized void method3903(Track1 var1, boolean var2) {
      this.method3904();
      this.field2660.method4031(var1.field2716);
      this.field2639 = var2;
      this.field2664 = 0L;
      int var3 = this.field2660.method4034();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2660.method4054(var4);
         this.field2660.method4038(var4);
         this.field2660.method4036(var4);
      }

      this.field2658 = this.field2660.method4061();
      this.field2659 = this.field2660.field2691[this.field2658];
      this.field2661 = this.field2660.method4042(this.field2659);
   }

   @ObfuscatedName("u")
   protected synchronized void vmethod4100(int var1) {
      if(this.field2660.method4033()) {
         int var2 = this.field2660.field2688 * this.field2654 / AbstractSoundSystem.sampleRate;

         do {
            long var3 = (long)var2 * (long)var1 + this.field2664;
            if(this.field2661 - var3 >= 0L) {
               this.field2664 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2661 - this.field2664) - 1L) / (long)var2);
            this.field2664 += (long)var5 * (long)var2;
            this.field2657.vmethod4100(var5);
            var1 -= var5;
            this.method3931();
         } while(this.field2660.method4033());
      }

      this.field2657.vmethod4100(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "14762"
   )
   public synchronized void method3904() {
      this.field2660.method4032();
      this.method3918();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1814057004"
   )
   public synchronized boolean method3905() {
      return this.field2660.method4033();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1377241364"
   )
   public synchronized void method3906(int var1, int var2) {
      this.method3907(var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-914362766"
   )
   void method3907(int var1, int var2) {
      this.field2642[var1] = var2;
      this.field2644[var1] = var2 & -128;
      this.method3908(var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "9267"
   )
   void method3908(int var1, int var2) {
      if(var2 != this.field2643[var1]) {
         this.field2643[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2655[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1534767648"
   )
   void method3909(int var1, int var2, int var3) {
      this.method3911(var1, var2, 64);
      if((this.field2650[var1] & 2) != 0) {
         for(class216 var4 = (class216)this.field2657.field2712.getTail(); var4 != null; var4 = (class216)this.field2657.field2712.getPrevious()) {
            if(var4.field2666 == var1 && var4.field2667 < 0) {
               this.field2656[var1][var4.field2670] = null;
               this.field2656[var1][var2] = var4;
               int var5 = (var4.field2674 * var4.field2683 >> 12) + var4.field2671;
               var4.field2671 += var2 - var4.field2670 << 8;
               var4.field2674 = var5 - var4.field2671;
               var4.field2683 = 4096;
               var4.field2670 = var2;
               return;
            }
         }
      }

      class218 var9 = (class218)this.field2649.get((long)this.field2643[var1]);
      if(var9 != null) {
         class106 var8 = var9.field2707[var2];
         if(var8 != null) {
            class216 var6 = new class216();
            var6.field2666 = var1;
            var6.field2679 = var9;
            var6.field2669 = var8;
            var6.field2668 = var9.field2708[var2];
            var6.field2665 = var9.field2706[var2];
            var6.field2670 = var2;
            var6.field2684 = var3 * var3 * var9.field2704[var2] * var9.field2702 + 1024 >> 11;
            var6.field2672 = var9.field2705[var2] & 255;
            var6.field2671 = (var2 << 8) - (var9.field2703[var2] & 32767);
            var6.field2676 = 0;
            var6.field2677 = 0;
            var6.field2680 = 0;
            var6.field2667 = -1;
            var6.field2675 = 0;
            if(this.field2651[var1] == 0) {
               var6.field2673 = class116.method2301(var8, this.method3923(var6), this.method4001(var6), this.method3925(var6));
            } else {
               var6.field2673 = class116.method2301(var8, this.method3923(var6), 0, this.method3925(var6));
               this.method4014(var6, var9.field2703[var2] < 0);
            }

            if(var9.field2703[var2] < 0) {
               var6.field2673.method2177(-1);
            }

            if(var6.field2665 >= 0) {
               class216 var7 = this.field2655[var1][var6.field2665];
               if(var7 != null && var7.field2667 < 0) {
                  this.field2656[var1][var7.field2670] = null;
                  var7.field2667 = 0;
               }

               this.field2655[var1][var6.field2665] = var6;
            }

            this.field2657.field2712.addFront(var6);
            this.field2656[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lhb;ZI)V",
      garbageValue = "1483674486"
   )
   void method4014(class216 var1, boolean var2) {
      int var3 = var1.field2669.field1522.length;
      int var4;
      if(var2 && var1.field2669.field1525) {
         int var5 = var3 + var3 - var1.field2669.field1521;
         var4 = (int)((long)var5 * (long)this.field2651[var1.field2666] >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2673.method2184();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2651[var1.field2666] >> 6);
      }

      var1.field2673.method2248(var4);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "3"
   )
   void method3911(int var1, int var2, int var3) {
      class216 var4 = this.field2656[var1][var2];
      if(var4 != null) {
         this.field2656[var1][var2] = null;
         if((this.field2650[var1] & 2) != 0) {
            for(class216 var5 = (class216)this.field2657.field2712.getFront(); var5 != null; var5 = (class216)this.field2657.field2712.getNext()) {
               if(var4.field2666 == var5.field2666 && var5.field2667 < 0 && var5 != var4) {
                  var4.field2667 = 0;
                  break;
               }
            }
         } else {
            var4.field2667 = 0;
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1980205512"
   )
   void method3912(int var1, int var2, int var3) {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   void method3928(int var1, int var2) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1617861720"
   )
   void method3999(int var1, int var2) {
      this.field2645[var1] = var2;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "134536633"
   )
   void method3915(int var1) {
      for(class216 var2 = (class216)this.field2657.field2712.getFront(); var2 != null; var2 = (class216)this.field2657.field2712.getNext()) {
         if(var1 < 0 || var2.field2666 == var1) {
            if(var2.field2673 != null) {
               var2.field2673.method2188(AbstractSoundSystem.sampleRate / 100);
               if(var2.field2673.method2189()) {
                  this.field2657.field2711.method1938(var2.field2673);
               }

               var2.method4027();
            }

            if(var2.field2667 < 0) {
               this.field2656[var2.field2666][var2.field2670] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-81"
   )
   void method3950(int var1) {
      if(var1 >= 0) {
         this.field2648[var1] = 12800;
         this.field2640[var1] = 8192;
         this.field2641[var1] = 16383;
         this.field2645[var1] = 8192;
         this.field2646[var1] = 0;
         this.field2662[var1] = 8192;
         this.method3919(var1);
         this.method3920(var1);
         this.field2650[var1] = 0;
         this.field2647[var1] = 32767;
         this.field2636[var1] = 256;
         this.field2651[var1] = 0;
         this.method3922(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3950(var1);
         }

      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2109756807"
   )
   void method3917(int var1) {
      for(class216 var2 = (class216)this.field2657.field2712.getFront(); var2 != null; var2 = (class216)this.field2657.field2712.getNext()) {
         if((var1 < 0 || var2.field2666 == var1) && var2.field2667 < 0) {
            this.field2656[var2.field2666][var2.field2670] = null;
            var2.field2667 = 0;
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method3918() {
      this.method3915(-1);
      this.method3950(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2643[var1] = this.field2642[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2644[var1] = this.field2642[var1] & -128;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-35"
   )
   void method3919(int var1) {
      if((this.field2650[var1] & 2) != 0) {
         for(class216 var2 = (class216)this.field2657.field2712.getFront(); var2 != null; var2 = (class216)this.field2657.field2712.getNext()) {
            if(var2.field2666 == var1 && this.field2656[var1][var2.field2670] == null && var2.field2667 < 0) {
               var2.field2667 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-126"
   )
   void method3920(int var1) {
      if((this.field2650[var1] & 4) != 0) {
         for(class216 var2 = (class216)this.field2657.field2712.getFront(); var2 != null; var2 = (class216)this.field2657.field2712.getNext()) {
            if(var2.field2666 == var1) {
               var2.field2685 = 0;
            }
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "35"
   )
   void method3921(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3911(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3909(var3, var4, var5);
         } else {
            this.method3911(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3912(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2644[var3] = (var5 << 14) + (this.field2644[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2644[var3] = (var5 << 7) + (this.field2644[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2646[var3] = (var5 << 7) + (this.field2646[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2646[var3] = var5 + (this.field2646[var3] & -128);
         }

         if(var4 == 5) {
            this.field2662[var3] = (var5 << 7) + (this.field2662[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2662[var3] = var5 + (this.field2662[var3] & -128);
         }

         if(var4 == 7) {
            this.field2648[var3] = (var5 << 7) + (this.field2648[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2648[var3] = var5 + (this.field2648[var3] & -128);
         }

         if(var4 == 10) {
            this.field2640[var3] = (var5 << 7) + (this.field2640[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2640[var3] = var5 + (this.field2640[var3] & -128);
         }

         if(var4 == 11) {
            this.field2641[var3] = (var5 << 7) + (this.field2641[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2641[var3] = var5 + (this.field2641[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2650[var3] |= 1;
            } else {
               this.field2650[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2650[var3] |= 2;
            } else {
               this.method3919(var3);
               this.field2650[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2647[var3] = (var5 << 7) + (this.field2647[var3] & 127);
         }

         if(var4 == 98) {
            this.field2647[var3] = (this.field2647[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2647[var3] = (var5 << 7) + (this.field2647[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2647[var3] = (this.field2647[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3915(var3);
         }

         if(var4 == 121) {
            this.method3950(var3);
         }

         if(var4 == 123) {
            this.method3917(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2647[var3];
            if(var6 == 16384) {
               this.field2636[var3] = (var5 << 7) + (this.field2636[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2647[var3];
            if(var6 == 16384) {
               this.field2636[var3] = var5 + (this.field2636[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2651[var3] = (var5 << 7) + (this.field2651[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2651[var3] = var5 + (this.field2651[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2650[var3] |= 4;
            } else {
               this.method3920(var3);
               this.field2650[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3922(var3, (var5 << 7) + (this.field2652[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3922(var3, var5 + (this.field2652[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3908(var3, var4 + this.field2644[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3928(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3999(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3918();
         }
      }
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-787281062"
   )
   void method3922(int var1, int var2) {
      this.field2652[var1] = var2;
      this.field2653[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(Lhb;B)I",
      garbageValue = "0"
   )
   int method3923(class216 var1) {
      int var2 = (var1.field2674 * var1.field2683 >> 12) + var1.field2671;
      var2 += (this.field2645[var1.field2666] - 8192) * this.field2636[var1.field2666] >> 12;
      class213 var3 = var1.field2668;
      int var4;
      if(var3.field2618 > 0 && (var3.field2622 > 0 || this.field2646[var1.field2666] > 0)) {
         var4 = var3.field2622 << 2;
         int var5 = var3.field2619 << 1;
         if(var1.field2681 < var5) {
            var4 = var4 * var1.field2681 / var5;
         }

         var4 += this.field2646[var1.field2666] >> 7;
         double var6 = Math.sin((double)(var1.field2682 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2669.field1523 * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)AbstractSoundSystem.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(Lhb;B)I",
      garbageValue = "0"
   )
   int method4001(class216 var1) {
      class213 var2 = var1.field2668;
      int var3 = this.field2648[var1.field2666] * this.field2641[var1.field2666] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2684 + 16384 >> 15;
      var3 = var3 * this.field2637 + 128 >> 8;
      if(var2.field2620 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2620 * 1.953125E-5D * (double)var1.field2676) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2621 != null) {
         var4 = var1.field2677;
         var5 = var2.field2621[var1.field2680 + 1];
         if(var1.field2680 < var2.field2621.length - 2) {
            var6 = (var2.field2621[var1.field2680] & 255) << 8;
            var7 = (var2.field2621[var1.field2680 + 2] & 255) << 8;
            var5 += (var2.field2621[var1.field2680 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if(var1.field2667 > 0 && var2.field2617 != null) {
         var4 = var1.field2667;
         var5 = var2.field2617[var1.field2675 + 1];
         if(var1.field2675 < var2.field2617.length - 2) {
            var6 = (var2.field2617[var1.field2675] & 255) << 8;
            var7 = (var2.field2617[var1.field2675 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2617[var1.field2675 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(Lhb;I)I",
      garbageValue = "2072781157"
   )
   int method3925(class216 var1) {
      int var2 = this.field2640[var1.field2666];
      return var2 < 8192?var2 * var1.field2672 + 32 >> 6:16384 - ((128 - var1.field2672) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1862579810"
   )
   void method3931() {
      int var1 = this.field2658;
      int var2 = this.field2659;

      long var3;
      for(var3 = this.field2661; var2 == this.field2659; var3 = this.field2660.method4042(var2)) {
         while(var2 == this.field2660.field2691[var1]) {
            this.field2660.method4054(var1);
            int var5 = this.field2660.method4039(var1);
            if(var5 == 1) {
               this.field2660.method4040();
               this.field2660.method4036(var1);
               if(this.field2660.method4044()) {
                  if(!this.field2639 || var2 == 0) {
                     this.method3918();
                     this.field2660.method4032();
                     return;
                  }

                  this.field2660.method4045(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3921(var5);
            }

            this.field2660.method4038(var1);
            this.field2660.method4036(var1);
         }

         var1 = this.field2660.method4061();
         var2 = this.field2660.field2691[var1];
      }

      this.field2658 = var1;
      this.field2659 = var2;
      this.field2661 = var3;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(Lhb;I)Z",
      garbageValue = "1582817316"
   )
   boolean method3932(class216 var1) {
      if(var1.field2673 == null) {
         if(var1.field2667 >= 0) {
            var1.unlink();
            if(var1.field2665 > 0 && var1 == this.field2655[var1.field2666][var1.field2665]) {
               this.field2655[var1.field2666][var1.field2665] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(Lhb;[IIII)Z",
      garbageValue = "-909933119"
   )
   boolean method3933(class216 var1, int[] var2, int var3, int var4) {
      var1.field2678 = AbstractSoundSystem.sampleRate / 100;
      if(var1.field2667 < 0 || var1.field2673 != null && !var1.field2673.method2172()) {
         int var5 = var1.field2683;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2662[var1.field2666]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2683 = var5;
         }

         var1.field2673.method2201(this.method3923(var1));
         class213 var6 = var1.field2668;
         boolean var7 = false;
         ++var1.field2681;
         var1.field2682 += var6.field2618;
         double var8 = (double)((var1.field2670 - 60 << 8) + (var1.field2683 * var1.field2674 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2620 > 0) {
            if(var6.field2623 > 0) {
               var1.field2676 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2623) + 0.5D);
            } else {
               var1.field2676 += 128;
            }
         }

         if(var6.field2621 != null) {
            if(var6.field2616 > 0) {
               var1.field2677 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2616 * var8) + 0.5D);
            } else {
               var1.field2677 += 128;
            }

            while(var1.field2680 < var6.field2621.length - 2 && var1.field2677 > (var6.field2621[var1.field2680 + 2] & 255) << 8) {
               var1.field2680 += 2;
            }

            if(var6.field2621.length - 2 == var1.field2680 && var6.field2621[var1.field2680 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2667 >= 0 && var6.field2617 != null && (this.field2650[var1.field2666] & 1) == 0 && (var1.field2665 < 0 || var1 != this.field2655[var1.field2666][var1.field2665])) {
            if(var6.field2624 > 0) {
               var1.field2667 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2624 * var8) + 0.5D);
            } else {
               var1.field2667 += 128;
            }

            while(var1.field2675 < var6.field2617.length - 2 && var1.field2667 > (var6.field2617[var1.field2675 + 2] & 255) << 8) {
               var1.field2675 += 2;
            }

            if(var6.field2617.length - 2 == var1.field2675) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2673.method2188(var1.field2678);
            if(var2 != null) {
               var1.field2673.vmethod4099(var2, var3, var4);
            } else {
               var1.field2673.vmethod4100(var4);
            }

            if(var1.field2673.method2189()) {
               this.field2657.field2711.method1938(var1.field2673);
            }

            var1.method4027();
            if(var1.field2667 >= 0) {
               var1.unlink();
               if(var1.field2665 > 0 && var1 == this.field2655[var1.field2666][var1.field2665]) {
                  this.field2655[var1.field2666][var1.field2665] = null;
               }
            }

            return true;
         } else {
            var1.field2673.method2272(var1.field2678, this.method4001(var1), this.method3925(var1));
            return false;
         }
      } else {
         var1.method4027();
         var1.unlink();
         if(var1.field2665 > 0 && var1 == this.field2655[var1.field2666][var1.field2665]) {
            this.field2655[var1.field2666][var1.field2665] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;Lil;IZI)Lek;",
      garbageValue = "-491240983"
   )
   public static Frames method4021(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.getChilds(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.getChild(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if(var3) {
               var9 = var1.getChild(0, var8);
            } else {
               var9 = var1.getChild(var8, 0);
            }

            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "10"
   )
   public static String method4025(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = 65533;
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = 65533;
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else if(var7 < 240) {
            if(var5 + 1 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else if(var7 < 248) {
            if(var5 + 2 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[var5 + 2] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = 65533;
               } else {
                  var8 = 65533;
               }
            } else {
               var8 = 65533;
            }
         } else {
            var8 = 65533;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-814744535"
   )
   public static boolean method4023(char var0) {
      return var0 >= '0' && var0 <= '9';
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(Lbm;II)V",
      garbageValue = "-307548522"
   )
   static final void method4018(Actor var0, int var1) {
      Sequence var2;
      int var11;
      if(var0.field1200 > Client.gameCycle) {
         class43.method605(var0);
      } else if(var0.field1196 >= Client.gameCycle) {
         class249.method4460(var0);
      } else {
         var0.poseAnimation = var0.idlePoseAnimation;
         if(var0.queueSize == 0) {
            var0.field1207 = 0;
         } else {
            label413: {
               if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
                  var2 = class45.getAnimation(var0.animation);
                  if(var0.field1208 > 0 && var2.precedenceAnimating == 0) {
                     ++var0.field1207;
                     break label413;
                  }

                  if(var0.field1208 <= 0 && var2.priority == 0) {
                     ++var0.field1207;
                     break label413;
                  }
               }

               var11 = var0.x;
               int var12 = var0.y;
               int var4 = var0.pathX[var0.queueSize - 1] * 128 + var0.field1153 * 64;
               int var5 = var0.pathY[var0.queueSize - 1] * 128 + var0.field1153 * 64;
               if(var11 < var4) {
                  if(var12 < var5) {
                     var0.orientation = 1280;
                  } else if(var12 > var5) {
                     var0.orientation = 1792;
                  } else {
                     var0.orientation = 1536;
                  }
               } else if(var11 > var4) {
                  if(var12 < var5) {
                     var0.orientation = 768;
                  } else if(var12 > var5) {
                     var0.orientation = 256;
                  } else {
                     var0.orientation = 512;
                  }
               } else if(var12 < var5) {
                  var0.orientation = 1024;
               } else if(var12 > var5) {
                  var0.orientation = 0;
               }

               byte var6 = var0.pathTraversed[var0.queueSize - 1];
               if(var4 - var11 <= 256 && var4 - var11 >= -256 && var5 - var12 <= 256 && var5 - var12 >= -256) {
                  int var7 = var0.orientation - var0.angle & 2047;
                  if(var7 > 1024) {
                     var7 -= 2048;
                  }

                  int var8 = var0.field1158;
                  if(var7 >= -256 && var7 <= 256) {
                     var8 = var0.field1168;
                  } else if(var7 >= 256 && var7 < 768) {
                     var8 = var0.field1160;
                  } else if(var7 >= -768 && var7 <= -256) {
                     var8 = var0.field1175;
                  }

                  if(var8 == -1) {
                     var8 = var0.field1168;
                  }

                  var0.poseAnimation = var8;
                  int var9 = 4;
                  boolean var10 = true;
                  if(var0 instanceof NPC) {
                     var10 = ((NPC)var0).composition.isClickable;
                  }

                  if(var10) {
                     if(var0.orientation != var0.angle && var0.interacting == -1 && var0.field1202 != 0) {
                        var9 = 2;
                     }

                     if(var0.queueSize > 2) {
                        var9 = 6;
                     }

                     if(var0.queueSize > 3) {
                        var9 = 8;
                     }

                     if(var0.field1207 > 0 && var0.queueSize > 1) {
                        var9 = 8;
                        --var0.field1207;
                     }
                  } else {
                     if(var0.queueSize > 1) {
                        var9 = 6;
                     }

                     if(var0.queueSize > 2) {
                        var9 = 8;
                     }

                     if(var0.field1207 > 0 && var0.queueSize > 1) {
                        var9 = 8;
                        --var0.field1207;
                     }
                  }

                  if(var6 == 2) {
                     var9 <<= 1;
                  }

                  if(var9 >= 8 && var0.field1168 == var0.poseAnimation && var0.field1161 != -1) {
                     var0.poseAnimation = var0.field1161;
                  }

                  if(var11 != var4 || var5 != var12) {
                     if(var11 < var4) {
                        var0.x += var9;
                        if(var0.x > var4) {
                           var0.x = var4;
                        }
                     } else if(var11 > var4) {
                        var0.x -= var9;
                        if(var0.x < var4) {
                           var0.x = var4;
                        }
                     }

                     if(var12 < var5) {
                        var0.y += var9;
                        if(var0.y > var5) {
                           var0.y = var5;
                        }
                     } else if(var12 > var5) {
                        var0.y -= var9;
                        if(var0.y < var5) {
                           var0.y = var5;
                        }
                     }
                  }

                  if(var4 == var0.x && var5 == var0.y) {
                     --var0.queueSize;
                     if(var0.field1208 > 0) {
                        --var0.field1208;
                     }
                  }
               } else {
                  var0.x = var4;
                  var0.y = var5;
                  --var0.queueSize;
                  if(var0.field1208 > 0) {
                     --var0.field1208;
                  }
               }
            }
         }
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1200 = 0;
         var0.field1196 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1153 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1153 * 64;
         var0.method1572();
      }

      if(GrandExchangeOffer.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1200 = 0;
         var0.field1196 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1153 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1153 * 64;
         var0.method1572();
      }

      KeyFocusListener.method754(var0);
      var0.field1152 = false;
      if(var0.poseAnimation != -1) {
         var2 = class45.getAnimation(var0.poseAnimation);
         if(var2 != null && var2.frameIDs != null) {
            ++var0.field1180;
            if(var0.poseFrame < var2.frameIDs.length && var0.field1180 > var2.frameLenghts[var0.poseFrame]) {
               var0.field1180 = 1;
               ++var0.poseFrame;
               class167.method3229(var2, var0.poseFrame, var0.x, var0.y);
            }

            if(var0.poseFrame >= var2.frameIDs.length) {
               var0.field1180 = 0;
               var0.poseFrame = 0;
               class167.method3229(var2, var0.poseFrame, var0.x, var0.y);
            }
         } else {
            var0.poseAnimation = -1;
         }
      }

      if(var0.graphic != -1 && Client.gameCycle >= var0.graphicsDelay) {
         if(var0.field1187 < 0) {
            var0.field1187 = 0;
         }

         var11 = NPCComposition.getSpotAnimType(var0.graphic).field3419;
         if(var11 != -1) {
            Sequence var3 = class45.getAnimation(var11);
            if(var3 != null && var3.frameIDs != null) {
               ++var0.field1188;
               if(var0.field1187 < var3.frameIDs.length && var0.field1188 > var3.frameLenghts[var0.field1187]) {
                  var0.field1188 = 1;
                  ++var0.field1187;
                  class167.method3229(var3, var0.field1187, var0.x, var0.y);
               }

               if(var0.field1187 >= var3.frameIDs.length && (var0.field1187 < 0 || var0.field1187 >= var3.frameIDs.length)) {
                  var0.graphic = -1;
               }
            } else {
               var0.graphic = -1;
            }
         } else {
            var0.graphic = -1;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable <= 1) {
         var2 = class45.getAnimation(var0.animation);
         if(var2.precedenceAnimating == 1 && var0.field1208 > 0 && var0.field1200 <= Client.gameCycle && var0.field1196 < Client.gameCycle) {
            var0.actionAnimationDisable = 1;
            return;
         }
      }

      if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
         var2 = class45.getAnimation(var0.animation);
         if(var2 != null && var2.frameIDs != null) {
            ++var0.field1159;
            if(var0.actionFrame < var2.frameIDs.length && var0.field1159 > var2.frameLenghts[var0.actionFrame]) {
               var0.field1159 = 1;
               ++var0.actionFrame;
               class167.method3229(var2, var0.actionFrame, var0.x, var0.y);
            }

            if(var0.actionFrame >= var2.frameIDs.length) {
               var0.actionFrame -= var2.frameStep;
               ++var0.field1185;
               if(var0.field1185 >= var2.maxLoops) {
                  var0.animation = -1;
               } else if(var0.actionFrame >= 0 && var0.actionFrame < var2.frameIDs.length) {
                  class167.method3229(var2, var0.actionFrame, var0.x, var0.y);
               } else {
                  var0.animation = -1;
               }
            }

            var0.field1152 = var2.stretches;
         } else {
            var0.animation = -1;
         }
      }

      if(var0.actionAnimationDisable > 0) {
         --var0.actionAnimationDisable;
      }

   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1610653518"
   )
   static void method4022() {
      if(TextureProvider.renderOverview != null) {
         TextureProvider.renderOverview.method5597(class7.plane, (GrandExchangeOffer.localPlayer.x >> 7) + class175.baseX, (GrandExchangeOffer.localPlayer.y >> 7) + GraphicsObject.baseY, false);
         TextureProvider.renderOverview.method5447();
      }

   }
}
