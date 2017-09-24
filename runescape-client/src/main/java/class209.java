import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public class class209 extends class118 {
   @ObfuscatedName("pt")
   @ObfuscatedSignature(
      signature = "Ldi;"
   )
   static class115 field2592;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lcs;"
   )
   class101 field2594;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   class205 field2595;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   Deque field2593;

   @ObfuscatedSignature(
      signature = "(Lgy;)V"
   )
   class209(class205 var1) {
      this.field2593 = new Deque();
      this.field2594 = new class101();
      this.field2595 = var1;
   }

   @ObfuscatedName("k")
   protected void vmethod3936(int[] var1, int var2, int var3) {
      this.field2594.vmethod3936(var1, var2, var3);

      for(class206 var6 = (class206)this.field2593.getFront(); var6 != null; var6 = (class206)this.field2593.getNext()) {
         if(!this.field2595.method3800(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2542) {
                  this.method3938(var6, var1, var4, var5, var4 + var5);
                  var6.field2542 -= var5;
                  break;
               }

               this.method3938(var6, var1, var4, var6.field2542, var5 + var4);
               var4 += var6.field2542;
               var5 -= var6.field2542;
            } while(!this.field2595.method3801(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("d")
   protected void vmethod3937(int var1) {
      this.field2594.vmethod3937(var1);

      for(class206 var3 = (class206)this.field2593.getFront(); var3 != null; var3 = (class206)this.field2593.getNext()) {
         if(!this.field2595.method3800(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2542) {
                  this.method3939(var3, var2);
                  var3.field2542 -= var2;
                  break;
               }

               this.method3939(var3, var3.field2542);
               var2 -= var3.field2542;
            } while(!this.field2595.method3801(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected class118 vmethod3934() {
      class206 var1;
      do {
         var1 = (class206)this.field2593.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2561 == null);

      return var1.field2561;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "752068463"
   )
   void method3939(class206 var1, int var2) {
      if((this.field2595.field2526[var1.field2563] & 4) != 0 && var1.field2560 < 0) {
         int var3 = this.field2595.field2539[var1.field2563] / class73.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2544) / var3;
         var1.field2544 = var3 * var2 + var1.field2544 & 1048575;
         if(var4 <= var2) {
            if(this.field2595.field2529[var1.field2563] == 0) {
               var1.field2561 = class116.method2156(var1.field2550, var1.field2561.method2146(), var1.field2561.method2233(), var1.field2561.method2221());
            } else {
               var1.field2561 = class116.method2156(var1.field2550, var1.field2561.method2146(), 0, var1.field2561.method2221());
               this.field2595.method3814(var1, var1.field2543.field2590[var1.field2547] < 0);
            }

            if(var1.field2543.field2590[var1.field2547] < 0) {
               var1.field2561.method2133(-1);
            }

            var2 = var1.field2544 / var3;
         }
      }

      var1.field2561.vmethod3937(var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgr;[IIIII)V",
      garbageValue = "-2137880424"
   )
   void method3938(class206 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2595.field2526[var1.field2563] & 4) != 0 && var1.field2560 < 0) {
         int var6 = this.field2595.field2539[var1.field2563] / class73.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2544) / var6;
            if(var7 > var4) {
               var1.field2544 += var6 * var4;
               break;
            }

            var1.field2561.vmethod3936(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2544 += var7 * var6 - 1048576;
            int var8 = class73.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class116 var10 = var1.field2561;
            if(this.field2595.field2529[var1.field2563] == 0) {
               var1.field2561 = class116.method2156(var1.field2550, var10.method2146(), var10.method2233(), var10.method2221());
            } else {
               var1.field2561 = class116.method2156(var1.field2550, var10.method2146(), 0, var10.method2221());
               this.field2595.method3814(var1, var1.field2543.field2590[var1.field2547] < 0);
               var1.field2561.method2142(var8, var10.method2233());
            }

            if(var1.field2543.field2590[var1.field2547] < 0) {
               var1.field2561.method2133(-1);
            }

            var10.method2157(var8);
            var10.vmethod3936(var2, var3, var5 - var3);
            if(var10.method2148()) {
               this.field2594.method1915(var10);
            }
         }
      }

      var1.field2561.vmethod3936(var2, var3, var4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected class118 vmethod3943() {
      class206 var1 = (class206)this.field2593.getFront();
      return (class118)(var1 == null?null:(var1.field2561 != null?var1.field2561:this.vmethod3934()));
   }

   @ObfuscatedName("b")
   protected int vmethod3950() {
      return 0;
   }
}
