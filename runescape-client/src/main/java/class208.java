import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class208 extends class119 {
   @ObfuscatedName("r")
   static ModIcon field2595;
   @ObfuscatedName("gm")
   static ModIcon[] field2592;
   @ObfuscatedName("n")
   class102 field2591;
   @ObfuscatedName("a")
   class204 field2594;
   @ObfuscatedName("j")
   Deque field2590;

   class208(class204 var1) {
      this.field2590 = new Deque();
      this.field2591 = new class102();
      this.field2594 = var1;
   }

   @ObfuscatedName("w")
   protected void vmethod3872(int[] var1, int var2, int var3) {
      this.field2591.vmethod3872(var1, var2, var3);

      for(class205 var6 = (class205)this.field2590.getFront(); var6 != null; var6 = (class205)this.field2590.getNext()) {
         if(!this.field2594.method3731(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2560) {
                  this.method3874(var6, var1, var4, var5, var5 + var4);
                  var6.field2560 -= var5;
                  break;
               }

               this.method3874(var6, var1, var4, var6.field2560, var4 + var5);
               var4 += var6.field2560;
               var5 -= var6.field2560;
            } while(!this.field2594.method3780(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("m")
   protected void vmethod3869(int var1) {
      this.field2591.vmethod3869(var1);

      for(class205 var3 = (class205)this.field2590.getFront(); var3 != null; var3 = (class205)this.field2590.getNext()) {
         if(!this.field2594.method3731(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2560) {
                  this.method3889(var3, var2);
                  var3.field2560 -= var2;
                  break;
               }

               this.method3889(var3, var3.field2560);
               var2 -= var3.field2560;
            } while(!this.field2594.method3780(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("l")
   protected class119 vmethod3882() {
      class205 var1;
      do {
         var1 = (class205)this.field2590.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2557 == null);

      return var1.field2557;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass205;II)V",
      garbageValue = "2012250581"
   )
   void method3889(class205 var1, int var2) {
      if((this.field2594.field2526[var1.field2545] & 4) != 0 && var1.field2551 < 0) {
         int var3 = this.field2594.field2531[var1.field2545] / ChatLineBuffer.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2561) / var3;
         var1.field2561 = var3 * var2 + var1.field2561 & 1048575;
         if(var4 <= var2) {
            if(this.field2594.field2516[var1.field2545] == 0) {
               var1.field2557 = class117.method2178(var1.field2543, var1.field2557.method2129(), var1.field2557.method2116(), var1.field2557.method2135());
            } else {
               var1.field2557 = class117.method2178(var1.field2543, var1.field2557.method2129(), 0, var1.field2557.method2135());
               this.field2594.method3709(var1, var1.field2542.field2580[var1.field2546] < 0);
            }

            if(var1.field2542.field2580[var1.field2546] < 0) {
               var1.field2557.method2212(-1);
            }

            var2 = var1.field2561 / var3;
         }
      }

      var1.field2557.vmethod3869(var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass205;[IIIIB)V",
      garbageValue = "114"
   )
   void method3874(class205 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2594.field2526[var1.field2545] & 4) != 0 && var1.field2551 < 0) {
         int var6 = this.field2594.field2531[var1.field2545] / ChatLineBuffer.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2561) / var6;
            if(var7 > var4) {
               var1.field2561 += var6 * var4;
               break;
            }

            var1.field2557.vmethod3872(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2561 += var7 * var6 - 1048576;
            int var8 = ChatLineBuffer.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class117 var10 = var1.field2557;
            if(this.field2594.field2516[var1.field2545] == 0) {
               var1.field2557 = class117.method2178(var1.field2543, var10.method2129(), var10.method2116(), var10.method2135());
            } else {
               var1.field2557 = class117.method2178(var1.field2543, var10.method2129(), 0, var10.method2135());
               this.field2594.method3709(var1, var1.field2542.field2580[var1.field2546] < 0);
               var1.field2557.method2110(var8, var10.method2116());
            }

            if(var1.field2542.field2580[var1.field2546] < 0) {
               var1.field2557.method2212(-1);
            }

            var10.method2123(var8);
            var10.vmethod3872(var2, var3, var5 - var3);
            if(var10.method2127()) {
               this.field2591.method1880(var10);
            }
         }
      }

      var1.field2557.vmethod3872(var2, var3, var4);
   }

   @ObfuscatedName("e")
   protected class119 vmethod3883() {
      class205 var1 = (class205)this.field2590.getFront();
      return (class119)(var1 == null?null:(var1.field2557 != null?var1.field2557:this.vmethod3882()));
   }

   @ObfuscatedName("s")
   protected int vmethod3871() {
      return 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "54"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class157.method2970(var0.charAt(var3));
      }

      return var2;
   }
}
