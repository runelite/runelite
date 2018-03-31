import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public final class class213 {
   @ObfuscatedName("c")
   int field2631;
   @ObfuscatedName("i")
   int field2632;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   IterableHashTable field2633;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   IterableDualNodeQueue field2634;

   public class213(int var1, int var2) {
      this.field2634 = new IterableDualNodeQueue();
      this.field2631 = var1;
      this.field2632 = var1;

      int var3;
      for(var3 = 1; var3 + var3 < var1 && var3 < var2; var3 += var3) {
         ;
      }

      this.field2633 = new IterableHashTable(var3);
   }

   @ObfuscatedName("c")
   public Object method3945(long var1) {
      class224 var3 = (class224)this.field2633.get(var1);
      if(var3 == null) {
         return null;
      } else {
         Object var4 = var3.vmethod4085();
         if(var4 == null) {
            var3.unlink();
            var3.unlinkDual();
            this.field2632 += var3.field2660;
            return null;
         } else {
            if(var3.vmethod4088()) {
               class208 var5 = new class208(var4, var3.field2660);
               this.field2633.put(var5, var3.hash);
               this.field2634.add(var5);
               var5.field2647 = 0L;
               var3.unlink();
               var3.unlinkDual();
            } else {
               this.field2634.add(var3);
               var3.field2647 = 0L;
            }

            return var4;
         }
      }
   }

   @ObfuscatedName("i")
   void method3941(long var1) {
      class224 var3 = (class224)this.field2633.get(var1);
      this.method3940(var3);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lhs;)V"
   )
   void method3940(class224 var1) {
      if(var1 != null) {
         var1.unlink();
         var1.unlinkDual();
         this.field2632 += var1.field2660;
      }

   }

   @ObfuscatedName("j")
   public void method3953(Object var1, long var2) {
      this.method3943(var1, var2, 1);
   }

   @ObfuscatedName("k")
   public void method3943(Object var1, long var2, int var4) {
      if(var4 > this.field2631) {
         throw new IllegalStateException();
      } else {
         this.method3941(var2);
         this.field2632 -= var4;

         while(this.field2632 < 0) {
            class224 var5 = (class224)this.field2634.method4103();
            this.method3940(var5);
         }

         class208 var6 = new class208(var1, var4);
         this.field2633.put(var6, var2);
         this.field2634.add(var6);
         var6.field2647 = 0L;
      }
   }

   @ObfuscatedName("x")
   public void method3944(int var1) {
      for(class224 var2 = (class224)this.field2634.method4100(); var2 != null; var2 = (class224)this.field2634.method4098()) {
         if(var2.vmethod4088()) {
            if(var2.vmethod4085() == null) {
               var2.unlink();
               var2.unlinkDual();
               this.field2632 += var2.field2660;
            }
         } else if(++var2.field2647 > (long)var1) {
            class219 var3 = new class219(var2.vmethod4085(), var2.field2660);
            this.field2633.put(var3, var2.hash);
            Node2LinkedList.method3879(var3, var2);
            var2.unlink();
            var2.unlinkDual();
         }
      }

   }

   @ObfuscatedName("z")
   public void method3954() {
      this.field2634.clear();
      this.field2633.clear();
      this.field2632 = this.field2631;
   }
}
