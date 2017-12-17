import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class215 extends TaskDataNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   HashTable field2641;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -346022579
   )
   int field2630;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1992514429
   )
   int field2655;
   @ObfuscatedName("u")
   int[] field2632;
   @ObfuscatedName("z")
   int[] field2633;
   @ObfuscatedName("t")
   int[] field2629;
   @ObfuscatedName("f")
   int[] field2650;
   @ObfuscatedName("g")
   int[] field2636;
   @ObfuscatedName("j")
   int[] field2637;
   @ObfuscatedName("x")
   int[] field2635;
   @ObfuscatedName("c")
   int[] field2639;
   @ObfuscatedName("s")
   int[] field2640;
   @ObfuscatedName("m")
   int[] field2642;
   @ObfuscatedName("q")
   int[] field2643;
   @ObfuscatedName("b")
   int[] field2644;
   @ObfuscatedName("h")
   int[] field2631;
   @ObfuscatedName("d")
   int[] field2646;
   @ObfuscatedName("v")
   int[] field2634;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[[Lhq;"
   )
   class216[][] field2648;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "[[Lhq;"
   )
   class216[][] field2656;
   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   class217 field2649;
   @ObfuscatedName("ag")
   boolean field2651;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1002412837
   )
   int field2652;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1441251243
   )
   int field2653;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      longValue = 2699146099623132769L
   )
   long field2654;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      longValue = 8451289892649138827L
   )
   long field2638;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   class219 field2647;

   public class215() {
      this.field2630 = 256;
      this.field2655 = 1000000;
      this.field2632 = new int[16];
      this.field2633 = new int[16];
      this.field2629 = new int[16];
      this.field2650 = new int[16];
      this.field2636 = new int[16];
      this.field2637 = new int[16];
      this.field2635 = new int[16];
      this.field2639 = new int[16];
      this.field2640 = new int[16];
      this.field2642 = new int[16];
      this.field2643 = new int[16];
      this.field2644 = new int[16];
      this.field2631 = new int[16];
      this.field2646 = new int[16];
      this.field2634 = new int[16];
      this.field2648 = new class216[16][128];
      this.field2656 = new class216[16][128];
      this.field2649 = new class217();
      this.field2647 = new class219(this);
      this.field2641 = new HashTable(128);
      this.method3862();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-892978955"
   )
   public synchronized void method3843(int var1) {
      this.field2630 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "220374716"
   )
   public int method3844() {
      return this.field2630;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lhl;Lib;Lde;II)Z",
      garbageValue = "-303186494"
   )
   synchronized boolean method3845(Track1 var1, IndexDataBase var2, class111 var3, int var4) {
      var1.method4063();
      boolean var5 = true;
      int[] var6 = null;
      if(var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.field2713.first(); var7 != null; var7 = (ByteArrayNode)var1.field2713.next()) {
         int var8 = (int)var7.hash;
         class218 var9 = (class218)this.field2641.get((long)var8);
         if(var9 == null) {
            var9 = NPCComposition.method4770(var2, var8);
            if(var9 == null) {
               var5 = false;
               continue;
            }

            this.field2641.put(var9, (long)var8);
         }

         if(!var9.method4030(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if(var5) {
         var1.method4064();
      }

      return var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-742703781"
   )
   synchronized void method3846() {
      for(class218 var1 = (class218)this.field2641.first(); var1 != null; var1 = (class218)this.field2641.next()) {
         var1.method4033();
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1349815352"
   )
   public synchronized void method3847() {
      for(class218 var1 = (class218)this.field2641.first(); var1 != null; var1 = (class218)this.field2641.next()) {
         var1.unlink();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldy;"
   )
   protected synchronized TaskDataNode vmethod4041() {
      return this.field2647;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldy;"
   )
   protected synchronized TaskDataNode vmethod4040() {
      return null;
   }

   @ObfuscatedName("f")
   protected synchronized int vmethod4045() {
      return 0;
   }

   @ObfuscatedName("g")
   protected synchronized void vmethod4062(int[] var1, int var2, int var3) {
      if(this.field2649.method3979()) {
         int var4 = this.field2649.field2682 * this.field2655 / ScriptState.sampleRate;

         do {
            long var5 = (long)var3 * (long)var4 + this.field2654;
            if(this.field2638 - var5 >= 0L) {
               this.field2654 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2638 - this.field2654) - 1L) / (long)var4);
            this.field2654 += (long)var7 * (long)var4;
            this.field2647.vmethod4062(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method3875();
         } while(this.field2649.method3979());
      }

      this.field2647.vmethod4062(var1, var2, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lhl;ZB)V",
      garbageValue = "-67"
   )
   synchronized void method3848(Track1 var1, boolean var2) {
      this.method3849();
      this.field2649.method3977(var1.field2712);
      this.field2651 = var2;
      this.field2654 = 0L;
      int var3 = this.field2649.method4010();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2649.method4013(var4);
         this.field2649.method4019(var4);
         this.field2649.method4022(var4);
      }

      this.field2652 = this.field2649.method3993();
      this.field2653 = this.field2649.field2685[this.field2652];
      this.field2638 = this.field2649.method3988(this.field2653);
   }

   @ObfuscatedName("c")
   protected synchronized void vmethod4046(int var1) {
      if(this.field2649.method3979()) {
         int var2 = this.field2649.field2682 * this.field2655 / ScriptState.sampleRate;

         do {
            long var3 = (long)var1 * (long)var2 + this.field2654;
            if(this.field2638 - var3 >= 0L) {
               this.field2654 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2638 - this.field2654) - 1L) / (long)var2);
            this.field2654 += (long)var2 * (long)var5;
            this.field2647.vmethod4046(var5);
            var1 -= var5;
            this.method3875();
         } while(this.field2649.method3979());
      }

      this.field2647.vmethod4046(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "76"
   )
   public synchronized void method3849() {
      this.field2649.method3978();
      this.method3862();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1821199567"
   )
   public synchronized boolean method3903() {
      return this.field2649.method3979();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "525480955"
   )
   public synchronized void method3851(int var1, int var2) {
      this.method3914(var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1657206951"
   )
   void method3914(int var1, int var2) {
      this.field2650[var1] = var2;
      this.field2637[var1] = var2 & -128;
      this.method3957(var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1139156526"
   )
   void method3957(int var1, int var2) {
      if(var2 != this.field2636[var1]) {
         this.field2636[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2656[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-78"
   )
   void method3854(int var1, int var2, int var3) {
      this.method3939(var1, var2, 64);
      if((this.field2642[var1] & 2) != 0) {
         for(class216 var4 = (class216)this.field2647.field2708.getTail(); var4 != null; var4 = (class216)this.field2647.field2708.getPrevious()) {
            if(var4.field2661 == var1 && var4.field2672 < 0) {
               this.field2648[var1][var4.field2663] = null;
               this.field2648[var1][var2] = var4;
               int var5 = (var4.field2668 * var4.field2664 >> 12) + var4.field2660;
               var4.field2660 += var2 - var4.field2663 << 8;
               var4.field2664 = var5 - var4.field2660;
               var4.field2668 = 4096;
               var4.field2663 = var2;
               return;
            }
         }
      }

      class218 var9 = (class218)this.field2641.get((long)this.field2636[var1]);
      if(var9 != null) {
         class106 var8 = var9.field2700[var2];
         if(var8 != null) {
            class216 var6 = new class216();
            var6.field2661 = var1;
            var6.field2659 = var9;
            var6.field2676 = var8;
            var6.field2675 = var9.field2702[var2];
            var6.field2662 = var9.field2695[var2];
            var6.field2663 = var2;
            var6.field2667 = var3 * var3 * var9.field2698[var2] * var9.field2701 + 1024 >> 11;
            var6.field2665 = var9.field2699[var2] & 255;
            var6.field2660 = (var2 << 8) - (var9.field2697[var2] & 32767);
            var6.field2669 = 0;
            var6.field2673 = 0;
            var6.field2671 = 0;
            var6.field2672 = -1;
            var6.field2666 = 0;
            if(this.field2631[var1] == 0) {
               var6.field2670 = class116.method2112(var8, this.method3867(var6), this.method3868(var6), this.method3894(var6));
            } else {
               var6.field2670 = class116.method2112(var8, this.method3867(var6), 0, this.method3894(var6));
               this.method3855(var6, var9.field2697[var2] < 0);
            }

            if(var9.field2697[var2] < 0) {
               var6.field2670.method2114(-1);
            }

            if(var6.field2662 >= 0) {
               class216 var7 = this.field2656[var1][var6.field2662];
               if(var7 != null && var7.field2672 < 0) {
                  this.field2648[var1][var7.field2663] = null;
                  var7.field2672 = 0;
               }

               this.field2656[var1][var6.field2662] = var6;
            }

            this.field2647.field2708.addFront(var6);
            this.field2648[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lhq;ZI)V",
      garbageValue = "1138729793"
   )
   void method3855(class216 var1, boolean var2) {
      int var3 = var1.field2676.field1509.length;
      int var4;
      if(var2 && var1.field2676.field1512) {
         int var5 = var3 + var3 - var1.field2676.field1510;
         var4 = (int)((long)this.field2631[var1.field2661] * (long)var5 >> 6);
         var3 <<= 8;
         if(var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.field2670.method2234();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2631[var1.field2661] >> 6);
      }

      var1.field2670.method2218(var4);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1048832544"
   )
   void method3939(int var1, int var2, int var3) {
      class216 var4 = this.field2648[var1][var2];
      if(var4 != null) {
         this.field2648[var1][var2] = null;
         if((this.field2642[var1] & 2) != 0) {
            for(class216 var5 = (class216)this.field2647.field2708.getFront(); var5 != null; var5 = (class216)this.field2647.field2708.getNext()) {
               if(var5.field2661 == var4.field2661 && var5.field2672 < 0 && var4 != var5) {
                  var4.field2672 = 0;
                  break;
               }
            }
         } else {
            var4.field2672 = 0;
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1920047375"
   )
   void method3857(int var1, int var2, int var3) {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   void method3858(int var1, int var2) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-30898"
   )
   void method3859(int var1, int var2) {
      this.field2635[var1] = var2;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1120467178"
   )
   void method3860(int var1) {
      for(class216 var2 = (class216)this.field2647.field2708.getFront(); var2 != null; var2 = (class216)this.field2647.field2708.getNext()) {
         if(var1 < 0 || var2.field2661 == var1) {
            if(var2.field2670 != null) {
               var2.field2670.method2169(ScriptState.sampleRate / 100);
               if(var2.field2670.method2129()) {
                  this.field2647.field2710.method1885(var2.field2670);
               }

               var2.method3973();
            }

            if(var2.field2672 < 0) {
               this.field2648[var2.field2661][var2.field2663] = null;
            }

            var2.unlink();
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "77"
   )
   void method3879(int var1) {
      if(var1 >= 0) {
         this.field2632[var1] = 12800;
         this.field2633[var1] = 8192;
         this.field2629[var1] = 16383;
         this.field2635[var1] = 8192;
         this.field2639[var1] = 0;
         this.field2640[var1] = 8192;
         this.method3961(var1);
         this.method3864(var1);
         this.field2642[var1] = 0;
         this.field2643[var1] = 32767;
         this.field2644[var1] = 256;
         this.field2631[var1] = 0;
         this.method3866(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method3879(var1);
         }

      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1691218259"
   )
   void method3965(int var1) {
      for(class216 var2 = (class216)this.field2647.field2708.getFront(); var2 != null; var2 = (class216)this.field2647.field2708.getNext()) {
         if((var1 < 0 || var2.field2661 == var1) && var2.field2672 < 0) {
            this.field2648[var2.field2661][var2.field2663] = null;
            var2.field2672 = 0;
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1769306399"
   )
   void method3862() {
      this.method3860(-1);
      this.method3879(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2636[var1] = this.field2650[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2637[var1] = this.field2650[var1] & -128;
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   void method3961(int var1) {
      if((this.field2642[var1] & 2) != 0) {
         for(class216 var2 = (class216)this.field2647.field2708.getFront(); var2 != null; var2 = (class216)this.field2647.field2708.getNext()) {
            if(var2.field2661 == var1 && this.field2648[var1][var2.field2663] == null && var2.field2672 < 0) {
               var2.field2672 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2055034965"
   )
   void method3864(int var1) {
      if((this.field2642[var1] & 4) != 0) {
         for(class216 var2 = (class216)this.field2647.field2708.getFront(); var2 != null; var2 = (class216)this.field2647.field2708.getNext()) {
            if(var2.field2661 == var1) {
               var2.field2678 = 0;
            }
         }
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1968632351"
   )
   void method3865(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if(var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3939(var3, var4, var5);
      } else if(var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var5 > 0) {
            this.method3854(var3, var4, var5);
         } else {
            this.method3939(var3, var4, 64);
         }

      } else if(var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method3857(var3, var4, var5);
      } else if(var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if(var4 == 0) {
            this.field2637[var3] = (var5 << 14) + (this.field2637[var3] & -2080769);
         }

         if(var4 == 32) {
            this.field2637[var3] = (var5 << 7) + (this.field2637[var3] & -16257);
         }

         if(var4 == 1) {
            this.field2639[var3] = (var5 << 7) + (this.field2639[var3] & -16257);
         }

         if(var4 == 33) {
            this.field2639[var3] = var5 + (this.field2639[var3] & -128);
         }

         if(var4 == 5) {
            this.field2640[var3] = (var5 << 7) + (this.field2640[var3] & -16257);
         }

         if(var4 == 37) {
            this.field2640[var3] = var5 + (this.field2640[var3] & -128);
         }

         if(var4 == 7) {
            this.field2632[var3] = (var5 << 7) + (this.field2632[var3] & -16257);
         }

         if(var4 == 39) {
            this.field2632[var3] = var5 + (this.field2632[var3] & -128);
         }

         if(var4 == 10) {
            this.field2633[var3] = (var5 << 7) + (this.field2633[var3] & -16257);
         }

         if(var4 == 42) {
            this.field2633[var3] = var5 + (this.field2633[var3] & -128);
         }

         if(var4 == 11) {
            this.field2629[var3] = (var5 << 7) + (this.field2629[var3] & -16257);
         }

         if(var4 == 43) {
            this.field2629[var3] = var5 + (this.field2629[var3] & -128);
         }

         if(var4 == 64) {
            if(var5 >= 64) {
               this.field2642[var3] |= 1;
            } else {
               this.field2642[var3] &= -2;
            }
         }

         if(var4 == 65) {
            if(var5 >= 64) {
               this.field2642[var3] |= 2;
            } else {
               this.method3961(var3);
               this.field2642[var3] &= -3;
            }
         }

         if(var4 == 99) {
            this.field2643[var3] = (var5 << 7) + (this.field2643[var3] & 127);
         }

         if(var4 == 98) {
            this.field2643[var3] = (this.field2643[var3] & 16256) + var5;
         }

         if(var4 == 101) {
            this.field2643[var3] = (var5 << 7) + (this.field2643[var3] & 127) + 16384;
         }

         if(var4 == 100) {
            this.field2643[var3] = (this.field2643[var3] & 16256) + var5 + 16384;
         }

         if(var4 == 120) {
            this.method3860(var3);
         }

         if(var4 == 121) {
            this.method3879(var3);
         }

         if(var4 == 123) {
            this.method3965(var3);
         }

         int var6;
         if(var4 == 6) {
            var6 = this.field2643[var3];
            if(var6 == 16384) {
               this.field2644[var3] = (var5 << 7) + (this.field2644[var3] & -16257);
            }
         }

         if(var4 == 38) {
            var6 = this.field2643[var3];
            if(var6 == 16384) {
               this.field2644[var3] = var5 + (this.field2644[var3] & -128);
            }
         }

         if(var4 == 16) {
            this.field2631[var3] = (var5 << 7) + (this.field2631[var3] & -16257);
         }

         if(var4 == 48) {
            this.field2631[var3] = var5 + (this.field2631[var3] & -128);
         }

         if(var4 == 81) {
            if(var5 >= 64) {
               this.field2642[var3] |= 4;
            } else {
               this.method3864(var3);
               this.field2642[var3] &= -5;
            }
         }

         if(var4 == 17) {
            this.method3866(var3, (var5 << 7) + (this.field2646[var3] & -16257));
         }

         if(var4 == 49) {
            this.method3866(var3, var5 + (this.field2646[var3] & -128));
         }

      } else if(var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3957(var3, var4 + this.field2637[var3]);
      } else if(var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method3858(var3, var4);
      } else if(var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method3859(var3, var4);
      } else {
         var2 = var1 & 255;
         if(var2 == 255) {
            this.method3862();
         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-706655376"
   )
   void method3866(int var1, int var2) {
      this.field2646[var1] = var2;
      this.field2634[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lhq;I)I",
      garbageValue = "194164029"
   )
   int method3867(class216 var1) {
      int var2 = (var1.field2664 * var1.field2668 >> 12) + var1.field2660;
      var2 += (this.field2635[var1.field2661] - 8192) * this.field2644[var1.field2661] >> 12;
      class213 var3 = var1.field2675;
      int var4;
      if(var3.field2616 > 0 && (var3.field2619 > 0 || this.field2639[var1.field2661] > 0)) {
         var4 = var3.field2619 << 2;
         int var5 = var3.field2617 << 1;
         if(var1.field2674 < var5) {
            var4 = var4 * var1.field2674 / var5;
         }

         var4 += this.field2639[var1.field2661] >> 7;
         double var6 = Math.sin((double)(var1.field2658 & 511) * 0.01227184630308513D);
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.field2676.field1511 * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)ScriptState.sampleRate + 0.5D);
      return var4 < 1?1:var4;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lhq;S)I",
      garbageValue = "-4612"
   )
   int method3868(class216 var1) {
      class213 var2 = var1.field2675;
      int var3 = this.field2629[var1.field2661] * this.field2632[var1.field2661] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2667 + 16384 >> 15;
      var3 = var3 * this.field2630 + 128 >> 8;
      if(var2.field2609 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2609 * 1.953125E-5D * (double)var1.field2669) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if(var2.field2614 != null) {
         var4 = var1.field2673;
         var5 = var2.field2614[var1.field2671 + 1];
         if(var1.field2671 < var2.field2614.length - 2) {
            var6 = (var2.field2614[var1.field2671] & 255) << 8;
            var7 = (var2.field2614[var1.field2671 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2614[var1.field2671 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if(var1.field2672 > 0 && var2.field2610 != null) {
         var4 = var1.field2672;
         var5 = var2.field2610[var1.field2666 + 1];
         if(var1.field2666 < var2.field2610.length - 2) {
            var6 = (var2.field2610[var1.field2666] & 255) << 8;
            var7 = (var2.field2610[var1.field2666 + 2] & 255) << 8;
            var5 += (var2.field2610[var1.field2666 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lhq;I)I",
      garbageValue = "1928898877"
   )
   int method3894(class216 var1) {
      int var2 = this.field2633[var1.field2661];
      return var2 < 8192?var2 * var1.field2665 + 32 >> 6:16384 - ((128 - var1.field2665) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1478898294"
   )
   void method3875() {
      int var1 = this.field2652;
      int var2 = this.field2653;

      long var3;
      for(var3 = this.field2638; var2 == this.field2653; var3 = this.field2649.method3988(var2)) {
         while(var2 == this.field2649.field2685[var1]) {
            this.field2649.method4013(var1);
            int var5 = this.field2649.method4016(var1);
            if(var5 == 1) {
               this.field2649.method3983();
               this.field2649.method4022(var1);
               if(this.field2649.method3987()) {
                  if(!this.field2651 || var2 == 0) {
                     this.method3862();
                     this.field2649.method3978();
                     return;
                  }

                  this.field2649.method3991(var3);
               }
               break;
            }

            if((var5 & 128) != 0) {
               this.method3865(var5);
            }

            this.field2649.method4019(var1);
            this.field2649.method4022(var1);
         }

         var1 = this.field2649.method3993();
         var2 = this.field2649.field2685[var1];
      }

      this.field2652 = var1;
      this.field2653 = var2;
      this.field2638 = var3;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lhq;I)Z",
      garbageValue = "-1941934368"
   )
   boolean method3953(class216 var1) {
      if(var1.field2670 == null) {
         if(var1.field2672 >= 0) {
            var1.unlink();
            if(var1.field2662 > 0 && var1 == this.field2656[var1.field2661][var1.field2662]) {
               this.field2656[var1.field2661][var1.field2662] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lhq;[IIII)Z",
      garbageValue = "-1866216510"
   )
   boolean method3877(class216 var1, int[] var2, int var3, int var4) {
      var1.field2677 = ScriptState.sampleRate / 100;
      if(var1.field2672 < 0 || var1.field2670 != null && !var1.field2670.method2194()) {
         int var5 = var1.field2668;
         if(var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2640[var1.field2661]) + 0.5D);
            if(var5 < 0) {
               var5 = 0;
            }

            var1.field2668 = var5;
         }

         var1.field2670.method2207(this.method3867(var1));
         class213 var6 = var1.field2675;
         boolean var7 = false;
         ++var1.field2674;
         var1.field2658 += var6.field2616;
         double var8 = (double)((var1.field2663 - 60 << 8) + (var1.field2664 * var1.field2668 >> 12)) * 5.086263020833333E-6D;
         if(var6.field2609 > 0) {
            if(var6.field2615 > 0) {
               var1.field2669 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2615) + 0.5D);
            } else {
               var1.field2669 += 128;
            }
         }

         if(var6.field2614 != null) {
            if(var6.field2612 > 0) {
               var1.field2673 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2612 * var8) + 0.5D);
            } else {
               var1.field2673 += 128;
            }

            while(var1.field2671 < var6.field2614.length - 2 && var1.field2673 > (var6.field2614[var1.field2671 + 2] & 255) << 8) {
               var1.field2671 += 2;
            }

            if(var6.field2614.length - 2 == var1.field2671 && var6.field2614[var1.field2671 + 1] == 0) {
               var7 = true;
            }
         }

         if(var1.field2672 >= 0 && var6.field2610 != null && (this.field2642[var1.field2661] & 1) == 0 && (var1.field2662 < 0 || var1 != this.field2656[var1.field2661][var1.field2662])) {
            if(var6.field2613 > 0) {
               var1.field2672 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2613 * var8) + 0.5D);
            } else {
               var1.field2672 += 128;
            }

            while(var1.field2666 < var6.field2610.length - 2 && var1.field2672 > (var6.field2610[var1.field2666 + 2] & 255) << 8) {
               var1.field2666 += 2;
            }

            if(var6.field2610.length - 2 == var1.field2666) {
               var7 = true;
            }
         }

         if(var7) {
            var1.field2670.method2169(var1.field2677);
            if(var2 != null) {
               var1.field2670.vmethod4062(var2, var3, var4);
            } else {
               var1.field2670.vmethod4046(var4);
            }

            if(var1.field2670.method2129()) {
               this.field2647.field2710.method1885(var1.field2670);
            }

            var1.method3973();
            if(var1.field2672 >= 0) {
               var1.unlink();
               if(var1.field2662 > 0 && var1 == this.field2656[var1.field2661][var1.field2662]) {
                  this.field2656[var1.field2661][var1.field2662] = null;
               }
            }

            return true;
         } else {
            var1.field2670.method2124(var1.field2677, this.method3868(var1), this.method3894(var1));
            return false;
         }
      } else {
         var1.method3973();
         var1.unlink();
         if(var1.field2662 > 0 && var1 == this.field2656[var1.field2661][var1.field2662]) {
            this.field2656[var1.field2661][var1.field2662] = null;
         }

         return true;
      }
   }
}
