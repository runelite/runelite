import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class219 extends TaskDataNode {
   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   static SpritePixels[] field2709;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   class215 field2714;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   Deque field2712;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lca;"
   )
   class101 field2711;

   @ObfuscatedSignature(
      signature = "(Lhu;)V"
   )
   class219(class215 var1) {
      this.field2712 = new Deque();
      this.field2711 = new class101();
      this.field2714 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lhb;[IIIII)V",
      garbageValue = "1277447148"
   )
   void method4101(class216 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2714.field2650[var1.field2666] & 4) != 0 && var1.field2667 < 0) {
         int var6 = this.field2714.field2653[var1.field2666] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2685) / var6;
            if(var7 > var4) {
               var1.field2685 += var4 * var6;
               break;
            }

            var1.field2673.vmethod4099(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2685 += var6 * var7 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class116 var10 = var1.field2673;
            if(this.field2714.field2651[var1.field2666] == 0) {
               var1.field2673 = class116.method2301(var1.field2669, var10.method2195(), var10.method2191(), var10.method2182());
            } else {
               var1.field2673 = class116.method2301(var1.field2669, var10.method2195(), 0, var10.method2182());
               this.field2714.method4014(var1, var1.field2679.field2703[var1.field2670] < 0);
               var1.field2673.method2186(var8, var10.method2191());
            }

            if(var1.field2679.field2703[var1.field2670] < 0) {
               var1.field2673.method2177(-1);
            }

            var10.method2188(var8);
            var10.vmethod4099(var2, var3, var5 - var3);
            if(var10.method2189()) {
               this.field2711.method1938(var10);
            }
         }
      }

      var1.field2673.vmethod4099(var2, var3, var4);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lhb;II)V",
      garbageValue = "68144990"
   )
   void method4102(class216 var1, int var2) {
      if((this.field2714.field2650[var1.field2666] & 4) != 0 && var1.field2667 < 0) {
         int var3 = this.field2714.field2653[var1.field2666] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2685) / var3;
         var1.field2685 = var3 * var2 + var1.field2685 & 1048575;
         if(var4 <= var2) {
            if(this.field2714.field2651[var1.field2666] == 0) {
               var1.field2673 = class116.method2301(var1.field2669, var1.field2673.method2195(), var1.field2673.method2191(), var1.field2673.method2182());
            } else {
               var1.field2673 = class116.method2301(var1.field2669, var1.field2673.method2195(), 0, var1.field2673.method2182());
               this.field2714.method4014(var1, var1.field2679.field2703[var1.field2670] < 0);
            }

            if(var1.field2679.field2703[var1.field2670] < 0) {
               var1.field2673.method2177(-1);
            }

            var2 = var1.field2685 / var3;
         }
      }

      var1.field2673.vmethod4100(var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected TaskDataNode vmethod4096() {
      class216 var1 = (class216)this.field2712.getFront();
      return (TaskDataNode)(var1 == null?null:(var1.field2673 != null?var1.field2673:this.vmethod4097()));
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected TaskDataNode vmethod4097() {
      class216 var1;
      do {
         var1 = (class216)this.field2712.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2673 == null);

      return var1.field2673;
   }

   @ObfuscatedName("b")
   protected int vmethod4109() {
      return 0;
   }

   @ObfuscatedName("e")
   protected void vmethod4099(int[] var1, int var2, int var3) {
      this.field2711.vmethod4099(var1, var2, var3);

      for(class216 var6 = (class216)this.field2712.getFront(); var6 != null; var6 = (class216)this.field2712.getNext()) {
         if(!this.field2714.method3932(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2678) {
                  this.method4101(var6, var1, var4, var5, var4 + var5);
                  var6.field2678 -= var5;
                  break;
               }

               this.method4101(var6, var1, var4, var6.field2678, var4 + var5);
               var4 += var6.field2678;
               var5 -= var6.field2678;
            } while(!this.field2714.method3933(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("u")
   protected void vmethod4100(int var1) {
      this.field2711.vmethod4100(var1);

      for(class216 var3 = (class216)this.field2712.getFront(); var3 != null; var3 = (class216)this.field2712.getNext()) {
         if(!this.field2714.method3932(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2678) {
                  this.method4102(var3, var2);
                  var3.field2678 -= var2;
                  break;
               }

               this.method4102(var3, var3.field2678);
               var2 -= var3.field2678;
            } while(!this.field2714.method3933(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZZI)Lkm;",
      garbageValue = "-1850194782"
   )
   static IndexedSprite method4129(boolean var0, boolean var1) {
      return var0?(var1?class91.field1342:class2.field11):(var1?DynamicObject.field1442:MouseRecorder.field812);
   }
}
