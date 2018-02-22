import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class228 extends TaskDataNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   class224 field2724;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   Deque field2725;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   class99 field2726;

   @ObfuscatedSignature(
      signature = "(Lho;)V"
   )
   class228(class224 var1) {
      this.field2725 = new Deque();
      this.field2726 = new class99();
      this.field2724 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lhs;[IIIII)V",
      garbageValue = "-1731410848"
   )
   void method4329(class225 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2724.field2661[var1.field2694] & 4) != 0 && var1.field2695 < 0) {
         int var6 = this.field2724.field2668[var1.field2694] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2701) / var6;
            if(var7 > var4) {
               var1.field2701 += var4 * var6;
               break;
            }

            var1.field2699.vmethod4344(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2701 += var7 * var6 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class114 var10 = var1.field2699;
            if(this.field2724.field2666[var1.field2694] == 0) {
               var1.field2699 = class114.method2316(var1.field2683, var10.method2331(), var10.method2322(), var10.method2323());
            } else {
               var1.field2699 = class114.method2316(var1.field2683, var10.method2331(), 0, var10.method2323());
               this.field2724.method4146(var1, var1.field2682.field2718[var1.field2686] < 0);
               var1.field2699.method2454(var8, var10.method2322());
            }

            if(var1.field2682.field2718[var1.field2686] < 0) {
               var1.field2699.method2318(-1);
            }

            var10.method2329(var8);
            var10.vmethod4344(var2, var3, var5 - var3);
            if(var10.method2333()) {
               this.field2726.method2064(var10);
            }
         }
      }

      var1.field2699.vmethod4344(var2, var3, var4);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhs;II)V",
      garbageValue = "1276860061"
   )
   void method4330(class225 var1, int var2) {
      if((this.field2724.field2661[var1.field2694] & 4) != 0 && var1.field2695 < 0) {
         int var3 = this.field2724.field2668[var1.field2694] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2701) / var3;
         var1.field2701 = var3 * var2 + var1.field2701 & 1048575;
         if(var4 <= var2) {
            if(this.field2724.field2666[var1.field2694] == 0) {
               var1.field2699 = class114.method2316(var1.field2683, var1.field2699.method2331(), var1.field2699.method2322(), var1.field2699.method2323());
            } else {
               var1.field2699 = class114.method2316(var1.field2683, var1.field2699.method2331(), 0, var1.field2699.method2323());
               this.field2724.method4146(var1, var1.field2682.field2718[var1.field2686] < 0);
            }

            if(var1.field2682.field2718[var1.field2686] < 0) {
               var1.field2699.method2318(-1);
            }

            var2 = var1.field2701 / var3;
         }
      }

      var1.field2699.vmethod4328(var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected TaskDataNode vmethod4324() {
      class225 var1 = (class225)this.field2725.getFront();
      return (TaskDataNode)(var1 == null?null:(var1.field2699 != null?var1.field2699:this.vmethod4323()));
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected TaskDataNode vmethod4323() {
      class225 var1;
      do {
         var1 = (class225)this.field2725.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2699 == null);

      return var1.field2699;
   }

   @ObfuscatedName("y")
   protected int vmethod4326() {
      return 0;
   }

   @ObfuscatedName("g")
   protected void vmethod4344(int[] var1, int var2, int var3) {
      this.field2726.vmethod4344(var1, var2, var3);

      for(class225 var6 = (class225)this.field2725.getFront(); var6 != null; var6 = (class225)this.field2725.getNext()) {
         if(!this.field2724.method4168(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2698) {
                  this.method4329(var6, var1, var4, var5, var5 + var4);
                  var6.field2698 -= var5;
                  break;
               }

               this.method4329(var6, var1, var4, var6.field2698, var4 + var5);
               var4 += var6.field2698;
               var5 -= var6.field2698;
            } while(!this.field2724.method4185(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("u")
   protected void vmethod4328(int var1) {
      this.field2726.vmethod4328(var1);

      for(class225 var3 = (class225)this.field2725.getFront(); var3 != null; var3 = (class225)this.field2725.getNext()) {
         if(!this.field2724.method4168(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2698) {
                  this.method4330(var3, var2);
                  var3.field2698 -= var2;
                  break;
               }

               this.method4330(var3, var3.field2698);
               var2 -= var3.field2698;
            } while(!this.field2724.method4185(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-651552696"
   )
   static int method4346(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class168.currentRequest != null && class168.currentRequest.hash == var2?VertexNormal.NetCache_responseArchiveBuffer.offset * 99 / (VertexNormal.NetCache_responseArchiveBuffer.payload.length - class168.currentRequest.padding) + 1:0;
   }
}
