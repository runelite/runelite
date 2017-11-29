import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class215 extends TaskDataNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   class211 field2678;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Deque field2676;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lcu;"
   )
   class101 field2677;

   @ObfuscatedSignature(
      signature = "(Lhf;)V"
   )
   class215(class211 var1) {
      this.field2676 = new Deque();
      this.field2677 = new class101();
      this.field2678 = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lha;[IIIIB)V",
      garbageValue = "8"
   )
   void method4067(class212 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2678.field2612[var1.field2647] & 4) != 0 && var1.field2648 < 0) {
         int var6 = this.field2678.field2624[var1.field2647] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2649) / var6;
            if(var7 > var4) {
               var1.field2649 += var6 * var4;
               break;
            }

            var1.field2631.vmethod4057(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2649 += var6 * var7 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class116 var10 = var1.field2631;
            if(this.field2678.field2606[var1.field2647] == 0) {
               var1.field2631 = class116.method2228(var1.field2630, var10.method2284(), var10.method2234(), var10.method2235());
            } else {
               var1.field2631 = class116.method2228(var1.field2630, var10.method2284(), 0, var10.method2235());
               this.field2678.method3869(var1, var1.field2644.field2667[var1.field2634] < 0);
               var1.field2631.method2239(var8, var10.method2234());
            }

            if(var1.field2644.field2667[var1.field2634] < 0) {
               var1.field2631.method2230(-1);
            }

            var10.method2229(var8);
            var10.vmethod4057(var2, var3, var5 - var3);
            if(var10.method2300()) {
               this.field2677.method1953(var10);
            }
         }
      }

      var1.field2631.vmethod4057(var2, var3, var4);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lha;IS)V",
      garbageValue = "248"
   )
   void method4060(class212 var1, int var2) {
      if((this.field2678.field2612[var1.field2647] & 4) != 0 && var1.field2648 < 0) {
         int var3 = this.field2678.field2624[var1.field2647] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2649) / var3;
         var1.field2649 = var3 * var2 + var1.field2649 & 1048575;
         if(var4 <= var2) {
            if(this.field2678.field2606[var1.field2647] == 0) {
               var1.field2631 = class116.method2228(var1.field2630, var1.field2631.method2284(), var1.field2631.method2234(), var1.field2631.method2235());
            } else {
               var1.field2631 = class116.method2228(var1.field2630, var1.field2631.method2284(), 0, var1.field2631.method2235());
               this.field2678.method3869(var1, var1.field2644.field2667[var1.field2634] < 0);
            }

            if(var1.field2644.field2667[var1.field2634] < 0) {
               var1.field2631.method2230(-1);
            }

            var2 = var1.field2649 / var3;
         }
      }

      var1.field2631.vmethod4058(var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected TaskDataNode vmethod4054() {
      class212 var1 = (class212)this.field2676.getFront();
      return (TaskDataNode)(var1 == null?null:(var1.field2631 != null?var1.field2631:this.vmethod4055()));
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected TaskDataNode vmethod4055() {
      class212 var1;
      do {
         var1 = (class212)this.field2676.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2631 == null);

      return var1.field2631;
   }

   @ObfuscatedName("t")
   protected int vmethod4056() {
      return 0;
   }

   @ObfuscatedName("p")
   protected void vmethod4057(int[] var1, int var2, int var3) {
      this.field2677.vmethod4057(var1, var2, var3);

      for(class212 var6 = (class212)this.field2676.getFront(); var6 != null; var6 = (class212)this.field2676.getNext()) {
         if(!this.field2678.method3959(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2640) {
                  this.method4067(var6, var1, var4, var5, var4 + var5);
                  var6.field2640 -= var5;
                  break;
               }

               this.method4067(var6, var1, var4, var6.field2640, var5 + var4);
               var4 += var6.field2640;
               var5 -= var6.field2640;
            } while(!this.field2678.method3875(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("l")
   protected void vmethod4058(int var1) {
      this.field2677.vmethod4058(var1);

      for(class212 var3 = (class212)this.field2676.getFront(); var3 != null; var3 = (class212)this.field2676.getNext()) {
         if(!this.field2678.method3959(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2640) {
                  this.method4060(var3, var2);
                  var3.field2640 -= var2;
                  break;
               }

               this.method4060(var3, var3.field2640);
               var2 -= var3.field2640;
            } while(!this.field2678.method3875(var3, (int[])null, 0, var2));
         }
      }

   }
}
