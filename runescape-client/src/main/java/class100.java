import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class100 extends TaskDataNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   Deque field1473;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhn;"
   )
   Deque field1471;
   @ObfuscatedName("b")
   int field1472;
   @ObfuscatedName("z")
   int field1470;

   public class100() {
      this.field1473 = new Deque();
      this.field1471 = new Deque();
      this.field1472 = 0;
      this.field1470 = -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ldh;)V"
   )
   public final synchronized void method2166(TaskDataNode var1) {
      this.field1473.addTail(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ldh;)V"
   )
   public final synchronized void method2167(TaskDataNode var1) {
      var1.unlink();
   }

   @ObfuscatedName("b")
   void method2181() {
      if(this.field1472 > 0) {
         for(class112 var1 = (class112)this.field1471.getFront(); var1 != null; var1 = (class112)this.field1471.getNext()) {
            var1.field1577 -= this.field1472;
         }

         this.field1470 -= this.field1472;
         this.field1472 = 0;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lht;Lds;)V"
   )
   void method2169(Node var1, class112 var2) {
      while(this.field1471.head != var1 && ((class112)var1).field1577 <= var2.field1577) {
         var1 = var1.next;
      }

      Deque.method4108(var2, var1);
      this.field1470 = ((class112)this.field1471.head.next).field1577;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lds;)V"
   )
   void method2170(class112 var1) {
      var1.unlink();
      var1.method2376();
      Node var2 = this.field1471.head.next;
      if(var2 == this.field1471.head) {
         this.field1470 = -1;
      } else {
         this.field1470 = ((class112)var2).field1577;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldh;"
   )
   protected TaskDataNode vmethod4437() {
      return (TaskDataNode)this.field1473.getFront();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldh;"
   )
   protected TaskDataNode vmethod4424() {
      return (TaskDataNode)this.field1473.getNext();
   }

   @ObfuscatedName("y")
   protected int vmethod4425() {
      return 0;
   }

   @ObfuscatedName("c")
   public final synchronized void vmethod4441(int[] var1, int var2, int var3) {
      do {
         if(this.field1470 < 0) {
            this.method2206(var1, var2, var3);
            return;
         }

         if(var3 + this.field1472 < this.field1470) {
            this.field1472 += var3;
            this.method2206(var1, var2, var3);
            return;
         }

         int var4 = this.field1470 - this.field1472;
         this.method2206(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1472 += var4;
         this.method2181();
         class112 var5 = (class112)this.field1471.getFront();
         synchronized(var5) {
            int var7 = var5.method2378();
            if(var7 < 0) {
               var5.field1577 = 0;
               this.method2170(var5);
            } else {
               var5.field1577 = var7;
               this.method2169(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("o")
   void method2206(int[] var1, int var2, int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1473.getFront(); var4 != null; var4 = (TaskDataNode)this.field1473.getNext()) {
         var4.method2573(var1, var2, var3);
      }

   }

   @ObfuscatedName("d")
   public final synchronized void vmethod4426(int var1) {
      do {
         if(this.field1470 < 0) {
            this.method2177(var1);
            return;
         }

         if(this.field1472 + var1 < this.field1470) {
            this.field1472 += var1;
            this.method2177(var1);
            return;
         }

         int var2 = this.field1470 - this.field1472;
         this.method2177(var2);
         var1 -= var2;
         this.field1472 += var2;
         this.method2181();
         class112 var3 = (class112)this.field1471.getFront();
         synchronized(var3) {
            int var5 = var3.method2378();
            if(var5 < 0) {
               var3.field1577 = 0;
               this.method2170(var3);
            } else {
               var3.field1577 = var5;
               this.method2169(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("r")
   void method2177(int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1473.getFront(); var2 != null; var2 = (TaskDataNode)this.field1473.getNext()) {
         var2.vmethod4426(var1);
      }

   }
}
