import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class100 extends TaskDataNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   Deque field1483;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   Deque field1484;
   @ObfuscatedName("n")
   int field1485;
   @ObfuscatedName("r")
   int field1486;

   public class100() {
      this.field1483 = new Deque();
      this.field1484 = new Deque();
      this.field1485 = 0;
      this.field1486 = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ldt;)V"
   )
   public final synchronized void method2103(TaskDataNode var1) {
      this.field1483.addTail(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ldt;)V"
   )
   public final synchronized void method2129(TaskDataNode var1) {
      var1.unlink();
   }

   @ObfuscatedName("n")
   void method2136() {
      if(this.field1485 > 0) {
         for(class112 var1 = (class112)this.field1484.getFront(); var1 != null; var1 = (class112)this.field1484.getNext()) {
            var1.field1595 -= this.field1485;
         }

         this.field1486 -= this.field1485;
         this.field1485 = 0;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lho;Ldm;)V"
   )
   void method2106(Node var1, class112 var2) {
      while(this.field1484.head != var1 && ((class112)var1).field1595 <= var2.field1595) {
         var1 = var1.next;
      }

      Deque.method4129(var2, var1);
      this.field1486 = ((class112)this.field1484.head.next).field1595;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ldm;)V"
   )
   void method2142(class112 var1) {
      var1.unlink();
      var1.method2335();
      Node var2 = this.field1484.head.next;
      if(var2 == this.field1484.head) {
         this.field1486 = -1;
      } else {
         this.field1486 = ((class112)var2).field1595;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "()Ldt;"
   )
   protected TaskDataNode vmethod4438() {
      return (TaskDataNode)this.field1483.getFront();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Ldt;"
   )
   protected TaskDataNode vmethod4433() {
      return (TaskDataNode)this.field1483.getNext();
   }

   @ObfuscatedName("s")
   protected int vmethod4443() {
      return 0;
   }

   @ObfuscatedName("x")
   public final synchronized void vmethod4435(int[] var1, int var2, int var3) {
      do {
         if(this.field1486 < 0) {
            this.method2112(var1, var2, var3);
            return;
         }

         if(var3 + this.field1485 < this.field1486) {
            this.field1485 += var3;
            this.method2112(var1, var2, var3);
            return;
         }

         int var4 = this.field1486 - this.field1485;
         this.method2112(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1485 += var4;
         this.method2136();
         class112 var5 = (class112)this.field1484.getFront();
         synchronized(var5) {
            int var7 = var5.method2341();
            if(var7 < 0) {
               var5.field1595 = 0;
               this.method2142(var5);
            } else {
               var5.field1595 = var7;
               this.method2106(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("h")
   void method2112(int[] var1, int var2, int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1483.getFront(); var4 != null; var4 = (TaskDataNode)this.field1483.getNext()) {
         var4.method2551(var1, var2, var3);
      }

   }

   @ObfuscatedName("t")
   public final synchronized void vmethod4436(int var1) {
      do {
         if(this.field1486 < 0) {
            this.method2114(var1);
            return;
         }

         if(this.field1485 + var1 < this.field1486) {
            this.field1485 += var1;
            this.method2114(var1);
            return;
         }

         int var2 = this.field1486 - this.field1485;
         this.method2114(var2);
         var1 -= var2;
         this.field1485 += var2;
         this.method2136();
         class112 var3 = (class112)this.field1484.getFront();
         synchronized(var3) {
            int var5 = var3.method2341();
            if(var5 < 0) {
               var3.field1595 = 0;
               this.method2142(var3);
            } else {
               var3.field1595 = var5;
               this.method2106(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("i")
   void method2114(int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1483.getFront(); var2 != null; var2 = (TaskDataNode)this.field1483.getNext()) {
         var2.vmethod4436(var1);
      }

   }
}
