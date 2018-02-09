import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public class class101 extends TaskDataNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   Deque field1478;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   Deque field1476;
   @ObfuscatedName("m")
   int field1477;
   @ObfuscatedName("h")
   int field1479;

   public class101() {
      this.field1478 = new Deque();
      this.field1476 = new Deque();
      this.field1477 = 0;
      this.field1479 = -1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ldb;)V"
   )
   public final synchronized void method2129(TaskDataNode var1) {
      this.field1478.addTail(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ldb;)V"
   )
   public final synchronized void method2117(TaskDataNode var1) {
      var1.unlink();
   }

   @ObfuscatedName("m")
   void method2118() {
      if(this.field1477 > 0) {
         for(class112 var1 = (class112)this.field1476.getFront(); var1 != null; var1 = (class112)this.field1476.getNext()) {
            var1.field1584 -= this.field1477;
         }

         this.field1479 -= this.field1477;
         this.field1477 = 0;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgf;Ldj;)V"
   )
   void method2133(Node var1, class112 var2) {
      while(this.field1476.head != var1 && ((class112)var1).field1584 <= var2.field1584) {
         var1 = var1.next;
      }

      Deque.method4028(var2, var1);
      this.field1479 = ((class112)this.field1476.head.next).field1584;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ldj;)V"
   )
   void method2120(class112 var1) {
      var1.unlink();
      var1.method2352();
      Node var2 = this.field1476.head.next;
      if(var2 == this.field1476.head) {
         this.field1479 = -1;
      } else {
         this.field1479 = ((class112)var2).field1584;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "()Ldb;"
   )
   protected TaskDataNode vmethod4311() {
      return (TaskDataNode)this.field1478.getFront();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldb;"
   )
   protected TaskDataNode vmethod4312() {
      return (TaskDataNode)this.field1478.getNext();
   }

   @ObfuscatedName("d")
   protected int vmethod4313() {
      return 0;
   }

   @ObfuscatedName("z")
   public final synchronized void vmethod4314(int[] var1, int var2, int var3) {
      do {
         if(this.field1479 < 0) {
            this.method2125(var1, var2, var3);
            return;
         }

         if(var3 + this.field1477 < this.field1479) {
            this.field1477 += var3;
            this.method2125(var1, var2, var3);
            return;
         }

         int var4 = this.field1479 - this.field1477;
         this.method2125(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1477 += var4;
         this.method2118();
         class112 var5 = (class112)this.field1476.getFront();
         synchronized(var5) {
            int var7 = var5.method2353();
            if(var7 < 0) {
               var5.field1584 = 0;
               this.method2120(var5);
            } else {
               var5.field1584 = var7;
               this.method2133(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("k")
   void method2125(int[] var1, int var2, int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1478.getFront(); var4 != null; var4 = (TaskDataNode)this.field1478.getNext()) {
         var4.method2561(var1, var2, var3);
      }

   }

   @ObfuscatedName("c")
   public final synchronized void vmethod4315(int var1) {
      do {
         if(this.field1479 < 0) {
            this.method2124(var1);
            return;
         }

         if(this.field1477 + var1 < this.field1479) {
            this.field1477 += var1;
            this.method2124(var1);
            return;
         }

         int var2 = this.field1479 - this.field1477;
         this.method2124(var2);
         var1 -= var2;
         this.field1477 += var2;
         this.method2118();
         class112 var3 = (class112)this.field1476.getFront();
         synchronized(var3) {
            int var5 = var3.method2353();
            if(var5 < 0) {
               var3.field1584 = 0;
               this.method2120(var3);
            } else {
               var3.field1584 = var5;
               this.method2133(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("o")
   void method2124(int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1478.getFront(); var2 != null; var2 = (TaskDataNode)this.field1478.getNext()) {
         var2.vmethod4315(var1);
      }

   }
}
