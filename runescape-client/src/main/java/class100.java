import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class100 extends TaskDataNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   Deque field1472;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   Deque field1470;
   @ObfuscatedName("i")
   int field1471;
   @ObfuscatedName("a")
   int field1473;

   public class100() {
      this.field1472 = new Deque();
      this.field1470 = new Deque();
      this.field1471 = 0;
      this.field1473 = -1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ldo;)V"
   )
   public final synchronized void method2086(TaskDataNode var1) {
      this.field1472.addTail(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ldo;)V"
   )
   public final synchronized void method2087(TaskDataNode var1) {
      var1.unlink();
   }

   @ObfuscatedName("i")
   void method2088() {
      if(this.field1471 > 0) {
         for(class112 var1 = (class112)this.field1470.getFront(); var1 != null; var1 = (class112)this.field1470.getNext()) {
            var1.field1582 -= this.field1471;
         }

         this.field1473 -= this.field1471;
         this.field1471 = 0;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lhx;Ldf;)V"
   )
   void method2096(Node var1, class112 var2) {
      while(this.field1470.head != var1 && ((class112)var1).field1582 <= var2.field1582) {
         var1 = var1.next;
      }

      Deque.method4067(var2, var1);
      this.field1473 = ((class112)this.field1470.head.next).field1582;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ldf;)V"
   )
   void method2099(class112 var1) {
      var1.unlink();
      var1.method2299();
      Node var2 = this.field1470.head.next;
      if(var2 == this.field1470.head) {
         this.field1473 = -1;
      } else {
         this.field1473 = ((class112)var2).field1582;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Ldo;"
   )
   protected TaskDataNode vmethod4354() {
      return (TaskDataNode)this.field1472.getFront();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Ldo;"
   )
   protected TaskDataNode vmethod4356() {
      return (TaskDataNode)this.field1472.getNext();
   }

   @ObfuscatedName("x")
   protected int vmethod4363() {
      return 0;
   }

   @ObfuscatedName("p")
   public final synchronized void vmethod4357(int[] var1, int var2, int var3) {
      do {
         if(this.field1473 < 0) {
            this.method2095(var1, var2, var3);
            return;
         }

         if(var3 + this.field1471 < this.field1473) {
            this.field1471 += var3;
            this.method2095(var1, var2, var3);
            return;
         }

         int var4 = this.field1473 - this.field1471;
         this.method2095(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1471 += var4;
         this.method2088();
         class112 var5 = (class112)this.field1470.getFront();
         synchronized(var5) {
            int var7 = var5.method2301();
            if(var7 < 0) {
               var5.field1582 = 0;
               this.method2099(var5);
            } else {
               var5.field1582 = var7;
               this.method2096(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("o")
   void method2095(int[] var1, int var2, int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1472.getFront(); var4 != null; var4 = (TaskDataNode)this.field1472.getNext()) {
         var4.method2473(var1, var2, var3);
      }

   }

   @ObfuscatedName("c")
   public final synchronized void vmethod4367(int var1) {
      do {
         if(this.field1473 < 0) {
            this.method2093(var1);
            return;
         }

         if(this.field1471 + var1 < this.field1473) {
            this.field1471 += var1;
            this.method2093(var1);
            return;
         }

         int var2 = this.field1473 - this.field1471;
         this.method2093(var2);
         var1 -= var2;
         this.field1471 += var2;
         this.method2088();
         class112 var3 = (class112)this.field1470.getFront();
         synchronized(var3) {
            int var5 = var3.method2301();
            if(var5 < 0) {
               var3.field1582 = 0;
               this.method2099(var3);
            } else {
               var3.field1582 = var5;
               this.method2096(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("u")
   void method2093(int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1472.getFront(); var2 != null; var2 = (TaskDataNode)this.field1472.getNext()) {
         var2.vmethod4367(var1);
      }

   }
}
