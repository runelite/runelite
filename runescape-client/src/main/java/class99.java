import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class99 extends TaskDataNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   Deque field1445;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   Deque field1446;
   @ObfuscatedName("o")
   int field1447;
   @ObfuscatedName("p")
   int field1448;

   public class99() {
      this.field1445 = new Deque();
      this.field1446 = new Deque();
      this.field1447 = 0;
      this.field1448 = -1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ldn;)V"
   )
   public final synchronized void method2064(TaskDataNode var1) {
      this.field1445.addTail(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ldn;)V"
   )
   public final synchronized void method2069(TaskDataNode var1) {
      var1.unlink();
   }

   @ObfuscatedName("o")
   void method2066() {
      if(this.field1447 > 0) {
         for(class111 var1 = (class111)this.field1446.getFront(); var1 != null; var1 = (class111)this.field1446.getNext()) {
            var1.field1555 -= this.field1447;
         }

         this.field1448 -= this.field1447;
         this.field1447 = 0;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lhe;Ldq;)V"
   )
   void method2067(Node var1, class111 var2) {
      while(this.field1446.head != var1 && ((class111)var1).field1555 <= var2.field1555) {
         var1 = var1.next;
      }

      Deque.method4048(var2, var1);
      this.field1448 = ((class111)this.field1446.head.next).field1555;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ldq;)V"
   )
   void method2079(class111 var1) {
      var1.unlink();
      var1.method2286();
      Node var2 = this.field1446.head.next;
      if(var2 == this.field1446.head) {
         this.field1448 = -1;
      } else {
         this.field1448 = ((class111)var2).field1555;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected TaskDataNode vmethod4324() {
      return (TaskDataNode)this.field1445.getFront();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected TaskDataNode vmethod4323() {
      return (TaskDataNode)this.field1445.getNext();
   }

   @ObfuscatedName("y")
   protected int vmethod4326() {
      return 0;
   }

   @ObfuscatedName("g")
   public final synchronized void vmethod4344(int[] var1, int var2, int var3) {
      do {
         if(this.field1448 < 0) {
            this.method2073(var1, var2, var3);
            return;
         }

         if(var3 + this.field1447 < this.field1448) {
            this.field1447 += var3;
            this.method2073(var1, var2, var3);
            return;
         }

         int var4 = this.field1448 - this.field1447;
         this.method2073(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1447 += var4;
         this.method2066();
         class111 var5 = (class111)this.field1446.getFront();
         synchronized(var5) {
            int var7 = var5.method2285();
            if(var7 < 0) {
               var5.field1555 = 0;
               this.method2079(var5);
            } else {
               var5.field1555 = var7;
               this.method2067(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("c")
   void method2073(int[] var1, int var2, int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1445.getFront(); var4 != null; var4 = (TaskDataNode)this.field1445.getNext()) {
         var4.method2484(var1, var2, var3);
      }

   }

   @ObfuscatedName("u")
   public final synchronized void vmethod4328(int var1) {
      do {
         if(this.field1448 < 0) {
            this.method2075(var1);
            return;
         }

         if(this.field1447 + var1 < this.field1448) {
            this.field1447 += var1;
            this.method2075(var1);
            return;
         }

         int var2 = this.field1448 - this.field1447;
         this.method2075(var2);
         var1 -= var2;
         this.field1447 += var2;
         this.method2066();
         class111 var3 = (class111)this.field1446.getFront();
         synchronized(var3) {
            int var5 = var3.method2285();
            if(var5 < 0) {
               var3.field1555 = 0;
               this.method2079(var3);
            } else {
               var3.field1555 = var5;
               this.method2067(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("t")
   void method2075(int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1445.getFront(); var2 != null; var2 = (TaskDataNode)this.field1445.getNext()) {
         var2.vmethod4328(var1);
      }

   }
}
