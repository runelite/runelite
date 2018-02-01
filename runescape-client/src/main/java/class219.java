import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public class class219 extends TaskDataNode {
   @ObfuscatedName("m")
   static byte[][][] field2675;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -642168337
   )
   static int field2680;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   class215 field2677;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   Deque field2676;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   class99 field2679;

   @ObfuscatedSignature(
      signature = "(Lhq;)V"
   )
   class219(class215 var1) {
      this.field2676 = new Deque();
      this.field2679 = new class99();
      this.field2677 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lhz;[IIIIB)V",
      garbageValue = "66"
   )
   void method4142(class216 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2677.field2601[var1.field2648] & 4) != 0 && var1.field2631 < 0) {
         int var6 = this.field2677.field2620[var1.field2648] / class20.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2646) / var6;
            if(var7 > var4) {
               var1.field2646 += var6 * var4;
               break;
            }

            var1.field2649.vmethod4145(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2646 += var7 * var6 - 1048576;
            int var8 = class20.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class114 var10 = var1.field2649;
            if(this.field2677.field2618[var1.field2648] == 0) {
               var1.field2649 = class114.method2420(var1.field2633, var10.method2301(), var10.method2414(), var10.method2293());
            } else {
               var1.field2649 = class114.method2420(var1.field2633, var10.method2301(), 0, var10.method2293());
               this.field2677.method4001(var1, var1.field2651.field2674[var1.field2636] < 0);
               var1.field2649.method2297(var8, var10.method2414());
            }

            if(var1.field2651.field2674[var1.field2636] < 0) {
               var1.field2649.method2288(-1);
            }

            var10.method2299(var8);
            var10.vmethod4145(var2, var3, var5 - var3);
            if(var10.method2303()) {
               this.field2679.method2080(var10);
            }
         }
      }

      var1.field2649.vmethod4145(var2, var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lhz;II)V",
      garbageValue = "-555618007"
   )
   void method4146(class216 var1, int var2) {
      if((this.field2677.field2601[var1.field2648] & 4) != 0 && var1.field2631 < 0) {
         int var3 = this.field2677.field2620[var1.field2648] / class20.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2646) / var3;
         var1.field2646 = var3 * var2 + var1.field2646 & 1048575;
         if(var4 <= var2) {
            if(this.field2677.field2618[var1.field2648] == 0) {
               var1.field2649 = class114.method2420(var1.field2633, var1.field2649.method2301(), var1.field2649.method2414(), var1.field2649.method2293());
            } else {
               var1.field2649 = class114.method2420(var1.field2633, var1.field2649.method2301(), 0, var1.field2649.method2293());
               this.field2677.method4001(var1, var1.field2651.field2674[var1.field2636] < 0);
            }

            if(var1.field2651.field2674[var1.field2636] < 0) {
               var1.field2649.method2288(-1);
            }

            var2 = var1.field2646 / var3;
         }
      }

      var1.field2649.vmethod4144(var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Ldj;"
   )
   protected TaskDataNode vmethod4155() {
      class216 var1 = (class216)this.field2676.getFront();
      return (TaskDataNode)(var1 == null?null:(var1.field2649 != null?var1.field2649:this.vmethod4141()));
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldj;"
   )
   protected TaskDataNode vmethod4141() {
      class216 var1;
      do {
         var1 = (class216)this.field2676.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2649 == null);

      return var1.field2649;
   }

   @ObfuscatedName("r")
   protected int vmethod4158() {
      return 0;
   }

   @ObfuscatedName("m")
   protected void vmethod4145(int[] var1, int var2, int var3) {
      this.field2679.vmethod4145(var1, var2, var3);

      for(class216 var6 = (class216)this.field2676.getFront(); var6 != null; var6 = (class216)this.field2676.getNext()) {
         if(!this.field2677.method3990(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2650) {
                  this.method4142(var6, var1, var4, var5, var4 + var5);
                  var6.field2650 -= var5;
                  break;
               }

               this.method4142(var6, var1, var4, var6.field2650, var5 + var4);
               var4 += var6.field2650;
               var5 -= var6.field2650;
            } while(!this.field2677.method4050(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("o")
   protected void vmethod4144(int var1) {
      this.field2679.vmethod4144(var1);

      for(class216 var3 = (class216)this.field2676.getFront(); var3 != null; var3 = (class216)this.field2676.getNext()) {
         if(!this.field2677.method3990(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2650) {
                  this.method4146(var3, var2);
                  var3.field2650 -= var2;
                  break;
               }

               this.method4146(var3, var3.field2650);
               var2 -= var3.field2650;
            } while(!this.field2677.method4050(var3, (int[])null, 0, var2));
         }
      }

   }
}
