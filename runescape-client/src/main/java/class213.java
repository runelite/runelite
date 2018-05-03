import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public final class class213 {
   @ObfuscatedName("g")
   int field2647;
   @ObfuscatedName("e")
   int field2649;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   IterableHashTable field2646;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   IterableDualNodeQueue field2648;

   public class213(int var1, int var2) {
      this.field2648 = new IterableDualNodeQueue();
      this.field2647 = var1;
      this.field2649 = var1;

      int var3;
      for(var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
         ;
      }

      this.field2646 = new IterableHashTable(var3);
   }

   @ObfuscatedName("g")
   public Object method4019(long var1) {
      class224 var3 = (class224)this.field2646.get(var1);
      if(var3 == null) {
         return null;
      } else {
         Object var4 = var3.vmethod4179();
         if(var4 == null) {
            var3.unlink();
            var3.unlinkDual();
            this.field2649 += var3.field2675;
            return null;
         } else {
            if(var3.vmethod4180()) {
               class208 var5 = new class208(var4, var3.field2675);
               this.field2646.put(var5, var3.hash);
               this.field2648.add(var5);
               var5.field2662 = 0L;
               var3.unlink();
               var3.unlinkDual();
            } else {
               this.field2648.add(var3);
               var3.field2662 = 0L;
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("e")
   void method4020(long var1) {
      class224 var3 = (class224)this.field2646.get(var1);
      this.method4021(var3);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lhz;)V"
   )
   void method4021(class224 var1) {
      if(var1 != null) {
         var1.unlink();
         var1.unlinkDual();
         this.field2649 += var1.field2675;
      }

   }

   @ObfuscatedName("z")
   public void method4025(Object var1, long var2) {
      this.method4018(var1, var2, 1);
   }

   @ObfuscatedName("n")
   public void method4018(Object var1, long var2, int var4) {
      if(var4 > this.field2647) {
         throw new IllegalStateException();
      } else {
         this.method4020(var2);
         this.field2649 -= var4;

         while(this.field2649 < 0) {
            class224 var5 = (class224)this.field2648.method4192();
            this.method4021(var5);
         }

         class208 var6 = new class208(var1, var4);
         this.field2646.put(var6, var2);
         this.field2648.add(var6);
         var6.field2662 = 0L;
      }
   }

   @ObfuscatedName("l")
   public void method4023(int var1) {
      for(class224 var2 = (class224)this.field2648.method4193(); var2 != null; var2 = (class224)this.field2648.method4198()) {
         if(var2.vmethod4180()) {
            if(var2.vmethod4179() == null) {
               var2.unlink();
               var2.unlinkDual();
               this.field2649 += var2.field2675;
            }
         } else if(++var2.field2662 > (long)var1) {
            class219 var3 = new class219(var2.vmethod4179(), var2.field2675);
            this.field2646.put(var3, var2.hash);
            Node2LinkedList.method3961(var3, var2);
            var2.unlink();
            var2.unlinkDual();
         }
      }

   }

   @ObfuscatedName("s")
   public void method4030() {
      this.field2648.clear();
      this.field2646.clear();
      this.field2649 = this.field2647;
   }
}
