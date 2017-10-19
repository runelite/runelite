import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class208 extends class117 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lcy;"
   )
   class100 field2583;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   class204 field2584;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   Deque field2582;

   @ObfuscatedSignature(
      signature = "(Lgy;)V"
   )
   class208(class204 var1) {
      this.field2582 = new Deque();
      this.field2583 = new class100();
      this.field2584 = var1;
   }

   @ObfuscatedName("d")
   protected void vmethod3968(int[] var1, int var2, int var3) {
      this.field2583.vmethod3968(var1, var2, var3);

      for(class205 var6 = (class205)this.field2582.getFront(); var6 != null; var6 = (class205)this.field2582.getNext()) {
         if(!this.field2584.method3788(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2535) {
                  this.method3970(var6, var1, var4, var5, var5 + var4);
                  var6.field2535 -= var5;
                  break;
               }

               this.method3970(var6, var1, var4, var6.field2535, var4 + var5);
               var4 += var6.field2535;
               var5 -= var6.field2535;
            } while(!this.field2584.method3806(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("u")
   protected void vmethod3981(int var1) {
      this.field2583.vmethod3981(var1);

      for(class205 var3 = (class205)this.field2582.getFront(); var3 != null; var3 = (class205)this.field2582.getNext()) {
         if(!this.field2584.method3788(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2535) {
                  this.method3971(var3, var2);
                  var3.field2535 -= var2;
                  break;
               }

               this.method3971(var3, var3.field2535);
               var2 -= var3.field2535;
            } while(!this.field2584.method3806(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Ldm;"
   )
   protected class117 vmethod3967() {
      class205 var1;
      do {
         var1 = (class205)this.field2582.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2552 == null);

      return var1.field2552;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgu;II)V",
      garbageValue = "-1081713329"
   )
   void method3971(class205 var1, int var2) {
      if((this.field2584.field2518[var1.field2549] & 4) != 0 && var1.field2544 < 0) {
         int var3 = this.field2584.field2514[var1.field2549] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2554) / var3;
         var1.field2554 = var3 * var2 + var1.field2554 & 1048575;
         if(var4 <= var2) {
            if(this.field2584.field2521[var1.field2549] == 0) {
               var1.field2552 = class115.method2173(var1.field2536, var1.field2552.method2188(), var1.field2552.method2299(), var1.field2552.method2244());
            } else {
               var1.field2552 = class115.method2173(var1.field2536, var1.field2552.method2188(), 0, var1.field2552.method2244());
               this.field2584.method3793(var1, var1.field2551.field2575[var1.field2539] < 0);
            }

            if(var1.field2551.field2575[var1.field2539] < 0) {
               var1.field2552.method2175(-1);
            }

            var2 = var1.field2554 / var3;
         }
      }

      var1.field2552.vmethod3981(var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgu;[IIIIB)V",
      garbageValue = "-75"
   )
   void method3970(class205 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2584.field2518[var1.field2549] & 4) != 0 && var1.field2544 < 0) {
         int var6 = this.field2584.field2514[var1.field2549] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2554) / var6;
            if(var7 > var4) {
               var1.field2554 += var4 * var6;
               break;
            }

            var1.field2552.vmethod3968(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2554 += var6 * var7 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class115 var10 = var1.field2552;
            if(this.field2584.field2521[var1.field2549] == 0) {
               var1.field2552 = class115.method2173(var1.field2536, var10.method2188(), var10.method2299(), var10.method2244());
            } else {
               var1.field2552 = class115.method2173(var1.field2536, var10.method2188(), 0, var10.method2244());
               this.field2584.method3793(var1, var1.field2551.field2575[var1.field2539] < 0);
               var1.field2552.method2184(var8, var10.method2299());
            }

            if(var1.field2551.field2575[var1.field2539] < 0) {
               var1.field2552.method2175(-1);
            }

            var10.method2186(var8);
            var10.vmethod3968(var2, var3, var5 - var3);
            if(var10.method2259()) {
               this.field2583.method1919(var10);
            }
         }
      }

      var1.field2552.vmethod3968(var2, var3, var4);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldm;"
   )
   protected class117 vmethod3966() {
      class205 var1 = (class205)this.field2582.getFront();
      return (class117)(var1 == null?null:(var1.field2552 != null?var1.field2552:this.vmethod3967()));
   }

   @ObfuscatedName("e")
   protected int vmethod3974() {
      return 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-800805675"
   )
   public static void method3989() {
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "13"
   )
   static void method3976(int var0) {
      if(var0 != -1) {
         if(WorldMapData.loadWidget(var0)) {
            Widget[] var1 = class215.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2723 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.field849 = var3.field2723;
                  Actor.method1541(var4, 2000000);
               }
            }

         }
      }
   }
}
