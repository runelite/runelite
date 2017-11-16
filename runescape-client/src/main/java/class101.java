import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class101 extends class118 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   Deque field1472;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   Deque field1471;
   @ObfuscatedName("r")
   int field1470;
   @ObfuscatedName("g")
   int field1473;

   public class101() {
      this.field1472 = new Deque();
      this.field1471 = new Deque();
      this.field1470 = 0;
      this.field1473 = -1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ldk;)V"
   )
   public final synchronized void method1914(class118 var1) {
      this.field1472.addTail(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ldk;)V"
   )
   public final synchronized void method1880(class118 var1) {
      var1.unlink();
   }

   @ObfuscatedName("r")
   void method1913() {
      if(this.field1470 > 0) {
         for(class112 var1 = (class112)this.field1471.getFront(); var1 != null; var1 = (class112)this.field1471.getNext()) {
            var1.field1584 -= this.field1470;
         }

         this.field1473 -= this.field1470;
         this.field1470 = 0;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgt;Ldr;)V"
   )
   void method1882(Node var1, class112 var2) {
      while(this.field1471.head != var1 && ((class112)var1).field1584 <= var2.field1584) {
         var1 = var1.next;
      }

      Deque.method3676(var2, var1);
      this.field1473 = ((class112)this.field1471.head.next).field1584;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ldr;)V"
   )
   void method1887(class112 var1) {
      var1.unlink();
      var1.method2108();
      Node var2 = this.field1471.head.next;
      if(var2 == this.field1471.head) {
         this.field1473 = -1;
      } else {
         this.field1473 = ((class112)var2).field1584;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected class118 vmethod3931() {
      return (class118)this.field1472.getFront();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected class118 vmethod3946() {
      return (class118)this.field1472.getNext();
   }

   @ObfuscatedName("t")
   protected int vmethod3925() {
      return 0;
   }

   @ObfuscatedName("k")
   public final synchronized void vmethod3926(int[] var1, int var2, int var3) {
      do {
         if(this.field1473 < 0) {
            this.method1886(var1, var2, var3);
            return;
         }

         if(var3 + this.field1470 < this.field1473) {
            this.field1470 += var3;
            this.method1886(var1, var2, var3);
            return;
         }

         int var4 = this.field1473 - this.field1470;
         this.method1886(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1470 += var4;
         this.method1913();
         class112 var5 = (class112)this.field1471.getFront();
         synchronized(var5) {
            int var7 = var5.method2109();
            if(var7 < 0) {
               var5.field1584 = 0;
               this.method1887(var5);
            } else {
               var5.field1584 = var7;
               this.method1882(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("n")
   void method1886(int[] var1, int var2, int var3) {
      for(class118 var4 = (class118)this.field1472.getFront(); var4 != null; var4 = (class118)this.field1472.getNext()) {
         var4.method2296(var1, var2, var3);
      }

   }

   @ObfuscatedName("d")
   public final synchronized void vmethod3927(int var1) {
      do {
         if(this.field1473 < 0) {
            this.method1889(var1);
            return;
         }

         if(this.field1470 + var1 < this.field1473) {
            this.field1470 += var1;
            this.method1889(var1);
            return;
         }

         int var2 = this.field1473 - this.field1470;
         this.method1889(var2);
         var1 -= var2;
         this.field1470 += var2;
         this.method1913();
         class112 var3 = (class112)this.field1471.getFront();
         synchronized(var3) {
            int var5 = var3.method2109();
            if(var5 < 0) {
               var3.field1584 = 0;
               this.method1887(var3);
            } else {
               var3.field1584 = var5;
               this.method1882(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("o")
   void method1889(int var1) {
      for(class118 var2 = (class118)this.field1472.getFront(); var2 != null; var2 = (class118)this.field1472.getNext()) {
         var2.vmethod3927(var1);
      }

   }
}
