import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
public class class234 extends TaskDataNode {
   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "[Lla;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   class230 field2759;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   Deque field2757;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lca;"
   )
   class100 field2756;

   @ObfuscatedSignature(
      signature = "(Lhk;)V"
   )
   class234(class230 var1) {
      this.field2757 = new Deque();
      this.field2756 = new class100();
      this.field2759 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lhb;[IIIII)V",
      garbageValue = "-664225096"
   )
   void method4355(class231 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2759.field2693[var1.field2726] & 4) != 0 && var1.field2711 < 0) {
         int var6 = this.field2759.field2698[var1.field2726] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2731) / var6;
            if(var7 > var4) {
               var1.field2731 += var4 * var6;
               break;
            }

            var1.field2723.vmethod4357(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2731 += var6 * var7 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class115 var10 = var1.field2723;
            if(this.field2759.field2689[var1.field2726] == 0) {
               var1.field2723 = class115.method2317(var1.field2713, var10.method2332(), var10.method2323(), var10.method2324());
            } else {
               var1.field2723 = class115.method2317(var1.field2713, var10.method2332(), 0, var10.method2324());
               this.field2759.method4257(var1, var1.field2727.field2748[var1.field2716] < 0);
               var1.field2723.method2328(var8, var10.method2323());
            }

            if(var1.field2727.field2748[var1.field2716] < 0) {
               var1.field2723.method2383(-1);
            }

            var10.method2330(var8);
            var10.vmethod4357(var2, var3, var5 - var3);
            if(var10.method2334()) {
               this.field2756.method2086(var10);
            }
         }
      }

      var1.field2723.vmethod4357(var2, var3, var4);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhb;II)V",
      garbageValue = "-1993143902"
   )
   void method4360(class231 var1, int var2) {
      if((this.field2759.field2693[var1.field2726] & 4) != 0 && var1.field2711 < 0) {
         int var3 = this.field2759.field2698[var1.field2726] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2731) / var3;
         var1.field2731 = var3 * var2 + var1.field2731 & 1048575;
         if(var4 <= var2) {
            if(this.field2759.field2689[var1.field2726] == 0) {
               var1.field2723 = class115.method2317(var1.field2713, var1.field2723.method2332(), var1.field2723.method2323(), var1.field2723.method2324());
            } else {
               var1.field2723 = class115.method2317(var1.field2713, var1.field2723.method2332(), 0, var1.field2723.method2324());
               this.field2759.method4257(var1, var1.field2727.field2748[var1.field2716] < 0);
            }

            if(var1.field2727.field2748[var1.field2716] < 0) {
               var1.field2723.method2383(-1);
            }

            var2 = var1.field2731 / var3;
         }
      }

      var1.field2723.vmethod4367(var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Ldo;"
   )
   protected TaskDataNode vmethod4354() {
      class231 var1 = (class231)this.field2757.getFront();
      return (TaskDataNode)(var1 == null?null:(var1.field2723 != null?var1.field2723:this.vmethod4356()));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Ldo;"
   )
   protected TaskDataNode vmethod4356() {
      class231 var1;
      do {
         var1 = (class231)this.field2757.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2723 == null);

      return var1.field2723;
   }

   @ObfuscatedName("x")
   protected int vmethod4363() {
      return 0;
   }

   @ObfuscatedName("p")
   protected void vmethod4357(int[] var1, int var2, int var3) {
      this.field2756.vmethod4357(var1, var2, var3);

      for(class231 var6 = (class231)this.field2757.getFront(); var6 != null; var6 = (class231)this.field2757.getNext()) {
         if(!this.field2759.method4200(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2725) {
                  this.method4355(var6, var1, var4, var5, var5 + var4);
                  var6.field2725 -= var5;
                  break;
               }

               this.method4355(var6, var1, var4, var6.field2725, var4 + var5);
               var4 += var6.field2725;
               var5 -= var6.field2725;
            } while(!this.field2759.method4201(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("c")
   protected void vmethod4367(int var1) {
      this.field2756.vmethod4367(var1);

      for(class231 var3 = (class231)this.field2757.getFront(); var3 != null; var3 = (class231)this.field2757.getNext()) {
         if(!this.field2759.method4200(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2725) {
                  this.method4360(var3, var2);
                  var3.field2725 -= var2;
                  break;
               }

               this.method4360(var3, var3.field2725);
               var2 -= var3.field2725;
            } while(!this.field2759.method4201(var3, (int[])null, 0, var2));
         }
      }

   }
}
