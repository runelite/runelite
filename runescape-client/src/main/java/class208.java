import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class208 extends class121 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   class104 field2569;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   class204 field2571;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Deque field2568;

   @ObfuscatedSignature(
      signature = "(Lgn;)V"
   )
   class208(class204 var1) {
      this.field2568 = new Deque();
      this.field2569 = new class104();
      this.field2571 = var1;
   }

   @ObfuscatedName("i")
   protected void vmethod3897(int[] var1, int var2, int var3) {
      this.field2569.vmethod3897(var1, var2, var3);

      for(class205 var6 = (class205)this.field2568.getFront(); var6 != null; var6 = (class205)this.field2568.getNext()) {
         if(!this.field2571.method3829(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2522) {
                  this.method3911(var6, var1, var4, var5, var5 + var4);
                  var6.field2522 -= var5;
                  break;
               }

               this.method3911(var6, var1, var4, var6.field2522, var5 + var4);
               var4 += var6.field2522;
               var5 -= var6.field2522;
            } while(!this.field2571.method3739(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("g")
   protected void vmethod3898(int var1) {
      this.field2569.vmethod3898(var1);

      for(class205 var3 = (class205)this.field2568.getFront(); var3 != null; var3 = (class205)this.field2568.getNext()) {
         if(!this.field2571.method3829(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2522) {
                  this.method3909(var3, var2);
                  var3.field2522 -= var2;
                  break;
               }

               this.method3909(var3, var3.field2522);
               var2 -= var3.field2522;
            } while(!this.field2571.method3739(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected class121 vmethod3895() {
      class205 var1;
      do {
         var1 = (class205)this.field2568.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2532 == null);

      return var1.field2532;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgd;II)V",
      garbageValue = "-130408319"
   )
   void method3909(class205 var1, int var2) {
      if((this.field2571.field2513[var1.field2533] & 4) != 0 && var1.field2528 < 0) {
         int var3 = this.field2571.field2501[var1.field2533] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2527) / var3;
         var1.field2527 = var3 * var2 + var1.field2527 & 1048575;
         if(var4 <= var2) {
            if(this.field2571.field2499[var1.field2533] == 0) {
               var1.field2532 = class119.method2196(var1.field2516, var1.field2532.method2211(), var1.field2532.method2193(), var1.field2532.method2265());
            } else {
               var1.field2532 = class119.method2196(var1.field2516, var1.field2532.method2211(), 0, var1.field2532.method2265());
               this.field2571.method3721(var1, var1.field2515.field2553[var1.field2519] < 0);
            }

            if(var1.field2515.field2553[var1.field2519] < 0) {
               var1.field2532.method2198(-1);
            }

            var2 = var1.field2527 / var3;
         }
      }

      var1.field2532.vmethod3898(var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgd;[IIIII)V",
      garbageValue = "-246127742"
   )
   void method3911(class205 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2571.field2513[var1.field2533] & 4) != 0 && var1.field2528 < 0) {
         int var6 = this.field2571.field2501[var1.field2533] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2527) / var6;
            if(var7 > var4) {
               var1.field2527 += var6 * var4;
               break;
            }

            var1.field2532.vmethod3897(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2527 += var6 * var7 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class119 var10 = var1.field2532;
            if(this.field2571.field2499[var1.field2533] == 0) {
               var1.field2532 = class119.method2196(var1.field2516, var10.method2211(), var10.method2193(), var10.method2265());
            } else {
               var1.field2532 = class119.method2196(var1.field2516, var10.method2211(), 0, var10.method2265());
               this.field2571.method3721(var1, var1.field2515.field2553[var1.field2519] < 0);
               var1.field2532.method2201(var8, var10.method2193());
            }

            if(var1.field2515.field2553[var1.field2519] < 0) {
               var1.field2532.method2198(-1);
            }

            var10.method2237(var8);
            var10.vmethod3897(var2, var3, var5 - var3);
            if(var10.method2213()) {
               this.field2569.method1937(var10);
            }
         }
      }

      var1.field2532.vmethod3897(var2, var3, var4);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected class121 vmethod3913() {
      class205 var1 = (class205)this.field2568.getFront();
      return (class121)(var1 == null?null:(var1.field2532 != null?var1.field2532:this.vmethod3895()));
   }

   @ObfuscatedName("t")
   protected int vmethod3916() {
      return 0;
   }
}
