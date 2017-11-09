import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class215 extends class118 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   class211 field2676;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   Deque field2677;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lcm;"
   )
   class101 field2675;

   @ObfuscatedSignature(
      signature = "(Lhp;)V"
   )
   class215(class211 var1) {
      this.field2677 = new Deque();
      this.field2675 = new class101();
      this.field2676 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lhg;[IIIIB)V",
      garbageValue = "1"
   )
   void method4046(class212 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2676.field2616[var1.field2637] & 4) != 0 && var1.field2646 < 0) {
         int var6 = this.field2676.field2613[var1.field2637] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2652) / var6;
            if(var7 > var4) {
               var1.field2652 += var4 * var6;
               break;
            }

            var1.field2645.vmethod4050(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2652 += var6 * var7 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class116 var10 = var1.field2645;
            if(this.field2676.field2619[var1.field2637] == 0) {
               var1.field2645 = class116.method2330(var1.field2642, var10.method2233(), var10.method2229(), var10.method2225());
            } else {
               var1.field2645 = class116.method2330(var1.field2642, var10.method2233(), 0, var10.method2225());
               this.field2676.method3866(var1, var1.field2633.field2669[var1.field2650] < 0);
               var1.field2645.method2331(var8, var10.method2229());
            }

            if(var1.field2633.field2669[var1.field2650] < 0) {
               var1.field2645.method2220(-1);
            }

            var10.method2231(var8);
            var10.vmethod4050(var2, var3, var5 - var3);
            if(var10.method2280()) {
               this.field2675.method1972(var10);
            }
         }
      }

      var1.field2645.vmethod4050(var2, var3, var4);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lhg;II)V",
      garbageValue = "-1243227289"
   )
   void method4069(class212 var1, int var2) {
      if((this.field2676.field2616[var1.field2637] & 4) != 0 && var1.field2646 < 0) {
         int var3 = this.field2676.field2613[var1.field2637] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2652) / var3;
         var1.field2652 = var3 * var2 + var1.field2652 & 1048575;
         if(var4 <= var2) {
            if(this.field2676.field2619[var1.field2637] == 0) {
               var1.field2645 = class116.method2330(var1.field2642, var1.field2645.method2233(), var1.field2645.method2229(), var1.field2645.method2225());
            } else {
               var1.field2645 = class116.method2330(var1.field2642, var1.field2645.method2233(), 0, var1.field2645.method2225());
               this.field2676.method3866(var1, var1.field2633.field2669[var1.field2650] < 0);
            }

            if(var1.field2633.field2669[var1.field2650] < 0) {
               var1.field2645.method2220(-1);
            }

            var2 = var1.field2652 / var3;
         }
      }

      var1.field2645.vmethod4051(var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Ldq;"
   )
   protected class118 vmethod4047() {
      class212 var1 = (class212)this.field2677.getFront();
      return (class118)(var1 == null?null:(var1.field2645 != null?var1.field2645:this.vmethod4048()));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Ldq;"
   )
   protected class118 vmethod4048() {
      class212 var1;
      do {
         var1 = (class212)this.field2677.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2645 == null);

      return var1.field2645;
   }

   @ObfuscatedName("l")
   protected int vmethod4068() {
      return 0;
   }

   @ObfuscatedName("b")
   protected void vmethod4050(int[] var1, int var2, int var3) {
      this.field2675.vmethod4050(var1, var2, var3);

      for(class212 var6 = (class212)this.field2677.getFront(); var6 != null; var6 = (class212)this.field2677.getNext()) {
         if(!this.field2676.method3962(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2651) {
                  this.method4046(var6, var1, var4, var5, var5 + var4);
                  var6.field2651 -= var5;
                  break;
               }

               this.method4046(var6, var1, var4, var6.field2651, var4 + var5);
               var4 += var6.field2651;
               var5 -= var6.field2651;
            } while(!this.field2676.method3889(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("c")
   protected void vmethod4051(int var1) {
      this.field2675.vmethod4051(var1);

      for(class212 var3 = (class212)this.field2677.getFront(); var3 != null; var3 = (class212)this.field2677.getNext()) {
         if(!this.field2676.method3962(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2651) {
                  this.method4069(var3, var2);
                  var3.field2651 -= var2;
                  break;
               }

               this.method4069(var3, var3.field2651);
               var2 -= var3.field2651;
            } while(!this.field2676.method3889(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1214692350"
   )
   public static int method4071(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILcw;ZS)I",
      garbageValue = "-14592"
   )
   static int method4055(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = PendingSpawn.method1612(class82.intStack[--class56.intStackSize]);
      } else {
         var3 = var2?class285.field3789:Friend.field768;
      }

      if(var0 == 1927) {
         if(class82.field1263 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2835 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.field791 = var3.field2835;
            var4.field784 = class82.field1263 + 1;
            Client.field1048.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }
}
