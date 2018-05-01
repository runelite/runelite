import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public class class234 extends TaskDataNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   class230 field2775;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   Deque field2774;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lct;"
   )
   class100 field2776;

   @ObfuscatedSignature(
      signature = "(Lhe;)V"
   )
   class234(class230 var1) {
      this.field2774 = new Deque();
      this.field2776 = new class100();
      this.field2775 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lha;[IIIII)V",
      garbageValue = "2091387721"
   )
   void method4428(class231 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2775.field2711[var1.field2735] & 4) != 0 && var1.field2741 < 0) {
         int var6 = this.field2775.field2708[var1.field2735] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2743) / var6;
            if(var7 > var4) {
               var1.field2743 += var4 * var6;
               break;
            }

            var1.field2747.vmethod4441(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2743 += var7 * var6 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class115 var10 = var1.field2747;
            if(this.field2775.field2716[var1.field2735] == 0) {
               var1.field2747 = class115.method2476(var1.field2731, var10.method2414(), var10.method2405(), var10.method2406());
            } else {
               var1.field2747 = class115.method2476(var1.field2731, var10.method2414(), 0, var10.method2406());
               this.field2775.method4290(var1, var1.field2730.field2771[var1.field2734] < 0);
               var1.field2747.method2410(var8, var10.method2405());
            }

            if(var1.field2730.field2771[var1.field2734] < 0) {
               var1.field2747.method2401(-1);
            }

            var10.method2412(var8);
            var10.vmethod4441(var2, var3, var5 - var3);
            if(var10.method2423()) {
               this.field2776.method2166(var10);
            }
         }
      }

      var1.field2747.vmethod4441(var2, var3, var4);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lha;IS)V",
      garbageValue = "-16664"
   )
   void method4429(class231 var1, int var2) {
      if((this.field2775.field2711[var1.field2735] & 4) != 0 && var1.field2741 < 0) {
         int var3 = this.field2775.field2708[var1.field2735] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2743) / var3;
         var1.field2743 = var3 * var2 + var1.field2743 & 1048575;
         if(var4 <= var2) {
            if(this.field2775.field2716[var1.field2735] == 0) {
               var1.field2747 = class115.method2476(var1.field2731, var1.field2747.method2414(), var1.field2747.method2405(), var1.field2747.method2406());
            } else {
               var1.field2747 = class115.method2476(var1.field2731, var1.field2747.method2414(), 0, var1.field2747.method2406());
               this.field2775.method4290(var1, var1.field2730.field2771[var1.field2734] < 0);
            }

            if(var1.field2730.field2771[var1.field2734] < 0) {
               var1.field2747.method2401(-1);
            }

            var2 = var1.field2743 / var3;
         }
      }

      var1.field2747.vmethod4426(var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldh;"
   )
   protected TaskDataNode vmethod4437() {
      class231 var1 = (class231)this.field2774.getFront();
      return (TaskDataNode)(var1 == null?null:(var1.field2747 != null?var1.field2747:this.vmethod4424()));
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldh;"
   )
   protected TaskDataNode vmethod4424() {
      class231 var1;
      do {
         var1 = (class231)this.field2774.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2747 == null);

      return var1.field2747;
   }

   @ObfuscatedName("y")
   protected int vmethod4425() {
      return 0;
   }

   @ObfuscatedName("c")
   protected void vmethod4441(int[] var1, int var2, int var3) {
      this.field2776.vmethod4441(var1, var2, var3);

      for(class231 var6 = (class231)this.field2774.getFront(); var6 != null; var6 = (class231)this.field2774.getNext()) {
         if(!this.field2775.method4269(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2748) {
                  this.method4428(var6, var1, var4, var5, var5 + var4);
                  var6.field2748 -= var5;
                  break;
               }

               this.method4428(var6, var1, var4, var6.field2748, var5 + var4);
               var4 += var6.field2748;
               var5 -= var6.field2748;
            } while(!this.field2775.method4330(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("d")
   protected void vmethod4426(int var1) {
      this.field2776.vmethod4426(var1);

      for(class231 var3 = (class231)this.field2774.getFront(); var3 != null; var3 = (class231)this.field2774.getNext()) {
         if(!this.field2775.method4269(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2748) {
                  this.method4429(var3, var2);
                  var3.field2748 -= var2;
                  break;
               }

               this.method4429(var3, var3.field2748);
               var2 -= var3.field2748;
            } while(!this.field2775.method4330(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-823660780"
   )
   static void method4452(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }
}
