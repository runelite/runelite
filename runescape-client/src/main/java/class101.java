import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class101 extends TaskDataNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   Deque field1473;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   Deque field1474;
   @ObfuscatedName("y")
   int field1476;
   @ObfuscatedName("r")
   int field1475;

   public class101() {
      this.field1473 = new Deque();
      this.field1474 = new Deque();
      this.field1476 = 0;
      this.field1475 = -1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ldk;)V"
   )
   public final synchronized void method1938(TaskDataNode var1) {
      this.field1473.addTail(var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ldk;)V"
   )
   public final synchronized void method1924(TaskDataNode var1) {
      var1.unlink();
   }

   @ObfuscatedName("y")
   void method1925() {
      if(this.field1476 > 0) {
         for(class113 var1 = (class113)this.field1474.getFront(); var1 != null; var1 = (class113)this.field1474.getNext()) {
            var1.field1583 -= this.field1476;
         }

         this.field1475 -= this.field1476;
         this.field1476 = 0;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgw;Lda;)V"
   )
   void method1954(Node var1, class113 var2) {
      while(this.field1474.head != var1 && ((class113)var1).field1583 <= var2.field1583) {
         var1 = var1.next;
      }

      Deque.method3810(var2, var1);
      this.field1475 = ((class113)this.field1474.head.next).field1583;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lda;)V"
   )
   void method1927(class113 var1) {
      var1.unlink();
      var1.method2150();
      Node var2 = this.field1474.head.next;
      if(var2 == this.field1474.head) {
         this.field1475 = -1;
      } else {
         this.field1475 = ((class113)var2).field1583;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected TaskDataNode vmethod4096() {
      return (TaskDataNode)this.field1473.getFront();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected TaskDataNode vmethod4097() {
      return (TaskDataNode)this.field1473.getNext();
   }

   @ObfuscatedName("b")
   protected int vmethod4109() {
      return 0;
   }

   @ObfuscatedName("e")
   public final synchronized void vmethod4099(int[] var1, int var2, int var3) {
      do {
         if(this.field1475 < 0) {
            this.method1932(var1, var2, var3);
            return;
         }

         if(var3 + this.field1476 < this.field1475) {
            this.field1476 += var3;
            this.method1932(var1, var2, var3);
            return;
         }

         int var4 = this.field1475 - this.field1476;
         this.method1932(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1476 += var4;
         this.method1925();
         class113 var5 = (class113)this.field1474.getFront();
         synchronized(var5) {
            int var7 = var5.method2155();
            if(var7 < 0) {
               var5.field1583 = 0;
               this.method1927(var5);
            } else {
               var5.field1583 = var7;
               this.method1954(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("f")
   void method1932(int[] var1, int var2, int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1473.getFront(); var4 != null; var4 = (TaskDataNode)this.field1473.getNext()) {
         var4.method2356(var1, var2, var3);
      }

   }

   @ObfuscatedName("u")
   public final synchronized void vmethod4100(int var1) {
      do {
         if(this.field1475 < 0) {
            this.method1934(var1);
            return;
         }

         if(this.field1476 + var1 < this.field1475) {
            this.field1476 += var1;
            this.method1934(var1);
            return;
         }

         int var2 = this.field1475 - this.field1476;
         this.method1934(var2);
         var1 -= var2;
         this.field1476 += var2;
         this.method1925();
         class113 var3 = (class113)this.field1474.getFront();
         synchronized(var3) {
            int var5 = var3.method2155();
            if(var5 < 0) {
               var3.field1583 = 0;
               this.method1927(var3);
            } else {
               var3.field1583 = var5;
               this.method1954(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("t")
   void method1934(int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1473.getFront(); var2 != null; var2 = (TaskDataNode)this.field1473.getNext()) {
         var2.vmethod4100(var1);
      }

   }
}
