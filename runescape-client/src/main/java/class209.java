import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class209 extends class120 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lcf;"
   )
   class103 field2573;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   class205 field2574;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   Deque field2572;

   @ObfuscatedSignature(
      signature = "(Lgl;)V"
   )
   class209(class205 var1) {
      this.field2572 = new Deque();
      this.field2573 = new class103();
      this.field2574 = var1;
   }

   @ObfuscatedName("r")
   protected void vmethod3889(int[] var1, int var2, int var3) {
      this.field2573.vmethod3889(var1, var2, var3);

      for(class206 var6 = (class206)this.field2572.getFront(); var6 != null; var6 = (class206)this.field2572.getNext()) {
         if(!this.field2574.method3751(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2545) {
                  this.method3891(var6, var1, var4, var5, var4 + var5);
                  var6.field2545 -= var5;
                  break;
               }

               this.method3891(var6, var1, var4, var6.field2545, var4 + var5);
               var4 += var6.field2545;
               var5 -= var6.field2545;
            } while(!this.field2574.method3736(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("d")
   protected void vmethod3890(int var1) {
      this.field2573.vmethod3890(var1);

      for(class206 var3 = (class206)this.field2572.getFront(); var3 != null; var3 = (class206)this.field2572.getNext()) {
         if(!this.field2574.method3751(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2545) {
                  this.method3892(var3, var2);
                  var3.field2545 -= var2;
                  break;
               }

               this.method3892(var3, var3.field2545);
               var2 -= var3.field2545;
            } while(!this.field2574.method3736(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldl;"
   )
   protected class120 vmethod3908() {
      class206 var1;
      do {
         var1 = (class206)this.field2572.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2544 == null);

      return var1.field2544;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "2107744224"
   )
   void method3892(class206 var1, int var2) {
      if((this.field2574.field2525[var1.field2528] & 4) != 0 && var1.field2532 < 0) {
         int var3 = this.field2574.field2508[var1.field2528] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2546) / var3;
         var1.field2546 = var1.field2546 + var3 * var2 & 1048575;
         if(var4 <= var2) {
            if(this.field2574.field2510[var1.field2528] == 0) {
               var1.field2544 = class118.method2224(var1.field2535, var1.field2544.method2289(), var1.field2544.method2278(), var1.field2544.method2192());
            } else {
               var1.field2544 = class118.method2224(var1.field2535, var1.field2544.method2289(), 0, var1.field2544.method2192());
               this.field2574.method3713(var1, var1.field2527.field2563[var1.field2530] < 0);
            }

            if(var1.field2527.field2563[var1.field2530] < 0) {
               var1.field2544.method2286(-1);
            }

            var2 = var1.field2546 / var3;
         }
      }

      var1.field2544.vmethod3890(var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgn;[IIIIB)V",
      garbageValue = "-124"
   )
   void method3891(class206 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2574.field2525[var1.field2528] & 4) != 0 && var1.field2532 < 0) {
         int var6 = this.field2574.field2508[var1.field2528] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2546) / var6;
            if(var7 > var4) {
               var1.field2546 += var6 * var4;
               break;
            }

            var1.field2544.vmethod3889(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2546 += var6 * var7 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class118 var10 = var1.field2544;
            if(this.field2574.field2510[var1.field2528] == 0) {
               var1.field2544 = class118.method2224(var1.field2535, var10.method2289(), var10.method2278(), var10.method2192());
            } else {
               var1.field2544 = class118.method2224(var1.field2535, var10.method2289(), 0, var10.method2192());
               this.field2574.method3713(var1, var1.field2527.field2563[var1.field2530] < 0);
               var1.field2544.method2159(var8, var10.method2278());
            }

            if(var1.field2527.field2563[var1.field2530] < 0) {
               var1.field2544.method2286(-1);
            }

            var10.method2161(var8);
            var10.vmethod3889(var2, var3, var5 - var3);
            if(var10.method2165()) {
               this.field2573.method1911(var10);
            }
         }
      }

      var1.field2544.vmethod3889(var2, var3, var4);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Ldl;"
   )
   protected class120 vmethod3906() {
      class206 var1 = (class206)this.field2572.getFront();
      return (class120)(var1 == null?null:(var1.field2544 != null?var1.field2544:this.vmethod3908()));
   }

   @ObfuscatedName("z")
   protected int vmethod3904() {
      return 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2066385733"
   )
   public static int method3887(int var0) {
      Varbit var2 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = Varbit.varbit_ref.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.decode(new Buffer(var7));
         }

         Varbit.varbits.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class212.field2583[var5 - var4];
      return class212.widgetSettings[var3] >> var4 & var6;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)[Lkn;",
      garbageValue = "382114276"
   )
   static SpritePixels[] method3909() {
      SpritePixels[] var0 = new SpritePixels[class182.field2420];

      for(int var1 = 0; var1 < class182.field2420; ++var1) {
         SpritePixels var2 = var0[var1] = new SpritePixels();
         var2.maxWidth = class287.field3775;
         var2.maxHeight = class287.field3776;
         var2.offsetX = class287.field3779[var1];
         var2.offsetY = class277.offsetsY[var1];
         var2.width = class287.field3778[var1];
         var2.height = class277.field3719[var1];
         int var3 = var2.height * var2.width;
         byte[] var4 = class287.spritePixels[var1];
         var2.image = new int[var3];

         for(int var5 = 0; var5 < var3; ++var5) {
            var2.image[var5] = class287.field3777[var4[var5] & 255];
         }
      }

      class262.method4747();
      return var0;
   }
}
