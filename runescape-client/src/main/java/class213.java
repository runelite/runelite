import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public final class class213 {
   @ObfuscatedName("t")
   int field2625;
   @ObfuscatedName("q")
   int field2624;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   IterableHashTable field2626;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   IterableDualNodeQueue field2627;

   public class213(int var1, int var2) {
      this.field2627 = new IterableDualNodeQueue();
      this.field2625 = var1;
      this.field2624 = var1;

      int var3;
      for(var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
         ;
      }

      this.field2626 = new IterableHashTable(var3);
   }

   @ObfuscatedName("t")
   public Object method3951(long var1) {
      class224 var3 = (class224)this.field2626.get(var1);
      if(var3 == null) {
         return null;
      } else {
         Object var4 = var3.vmethod4105();
         if(var4 == null) {
            var3.unlink();
            var3.unlinkDual();
            this.field2624 += var3.field2653;
            return null;
         } else {
            if(var3.vmethod4106()) {
               class208 var5 = new class208(var4, var3.field2653);
               this.field2626.put(var5, var3.hash);
               this.field2627.add(var5);
               var5.field2641 = 0L;
               var3.unlink();
               var3.unlinkDual();
            } else {
               this.field2627.add(var3);
               var3.field2641 = 0L;
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("q")
   void method3952(long var1) {
      class224 var3 = (class224)this.field2626.get(var1);
      this.method3953(var3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lhs;)V"
   )
   void method3953(class224 var1) {
      if(var1 != null) {
         var1.unlink();
         var1.unlinkDual();
         this.field2624 += var1.field2653;
      }

   }

   @ObfuscatedName("a")
   public void method3967(Object var1, long var2) {
      this.method3954(var1, var2, 1);
   }

   @ObfuscatedName("l")
   public void method3954(Object var1, long var2, int var4) {
      if(var4 > this.field2625) {
         throw new IllegalStateException();
      } else {
         this.method3952(var2);
         this.field2624 -= var4;

         while(this.field2624 < 0) {
            class224 var5 = (class224)this.field2627.method4120();
            this.method3953(var5);
         }

         class208 var6 = new class208(var1, var4);
         this.field2626.put(var6, var2);
         this.field2627.add(var6);
         var6.field2641 = 0L;
      }
   }

   @ObfuscatedName("b")
   public void method3950(int var1) {
      for(class224 var2 = (class224)this.field2627.method4121(); var2 != null; var2 = (class224)this.field2627.method4138()) {
         if(var2.vmethod4106()) {
            if(var2.vmethod4105() == null) {
               var2.unlink();
               var2.unlinkDual();
               this.field2624 += var2.field2653;
            }
         } else if(++var2.field2641 > (long)var1) {
            class219 var3 = new class219(var2.vmethod4105(), var2.field2653);
            this.field2626.put(var3, var2.hash);
            Node2LinkedList.method3888(var3, var2);
            var2.unlink();
            var2.unlinkDual();
         }
      }

   }

   @ObfuscatedName("e")
   public void method3956() {
      this.field2627.clear();
      this.field2626.clear();
      this.field2624 = this.field2625;
   }
}
