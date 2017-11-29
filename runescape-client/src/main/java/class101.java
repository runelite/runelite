import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class101 extends TaskDataNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Deque field1479;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Deque field1480;
   @ObfuscatedName("k")
   int field1482;
   @ObfuscatedName("z")
   int field1481;

   public class101() {
      this.field1479 = new Deque();
      this.field1480 = new Deque();
      this.field1482 = 0;
      this.field1481 = -1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ldn;)V"
   )
   public final synchronized void method1953(TaskDataNode var1) {
      this.field1479.addTail(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ldn;)V"
   )
   public final synchronized void method1954(TaskDataNode var1) {
      var1.unlink();
   }

   @ObfuscatedName("k")
   void method1955() {
      if(this.field1482 > 0) {
         for(class112 var1 = (class112)this.field1480.getFront(); var1 != null; var1 = (class112)this.field1480.getNext()) {
            var1.field1589 -= this.field1482;
         }

         this.field1481 -= this.field1482;
         this.field1482 = 0;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgf;Ldj;)V"
   )
   void method1958(Node var1, class112 var2) {
      while(this.field1480.head != var1 && ((class112)var1).field1589 <= var2.field1589) {
         var1 = var1.next;
      }

      Deque.method3753(var2, var1);
      this.field1481 = ((class112)this.field1480.head.next).field1589;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ldj;)V"
   )
   void method1957(class112 var1) {
      var1.unlink();
      var1.method2199();
      Node var2 = this.field1480.head.next;
      if(var2 == this.field1480.head) {
         this.field1481 = -1;
      } else {
         this.field1481 = ((class112)var2).field1589;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected TaskDataNode vmethod4054() {
      return (TaskDataNode)this.field1479.getFront();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Ldn;"
   )
   protected TaskDataNode vmethod4055() {
      return (TaskDataNode)this.field1479.getNext();
   }

   @ObfuscatedName("t")
   protected int vmethod4056() {
      return 0;
   }

   @ObfuscatedName("p")
   public final synchronized void vmethod4057(int[] var1, int var2, int var3) {
      do {
         if(this.field1481 < 0) {
            this.method1962(var1, var2, var3);
            return;
         }

         if(var3 + this.field1482 < this.field1481) {
            this.field1482 += var3;
            this.method1962(var1, var2, var3);
            return;
         }

         int var4 = this.field1481 - this.field1482;
         this.method1962(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1482 += var4;
         this.method1955();
         class112 var5 = (class112)this.field1480.getFront();
         synchronized(var5) {
            int var7 = var5.method2200();
            if(var7 < 0) {
               var5.field1589 = 0;
               this.method1957(var5);
            } else {
               var5.field1589 = var7;
               this.method1958(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("r")
   void method1962(int[] var1, int var2, int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1479.getFront(); var4 != null; var4 = (TaskDataNode)this.field1479.getNext()) {
         var4.method2407(var1, var2, var3);
      }

   }

   @ObfuscatedName("l")
   public final synchronized void vmethod4058(int var1) {
      do {
         if(this.field1481 < 0) {
            this.method1964(var1);
            return;
         }

         if(this.field1482 + var1 < this.field1481) {
            this.field1482 += var1;
            this.method1964(var1);
            return;
         }

         int var2 = this.field1481 - this.field1482;
         this.method1964(var2);
         var1 -= var2;
         this.field1482 += var2;
         this.method1955();
         class112 var3 = (class112)this.field1480.getFront();
         synchronized(var3) {
            int var5 = var3.method2200();
            if(var5 < 0) {
               var3.field1589 = 0;
               this.method1957(var3);
            } else {
               var3.field1589 = var5;
               this.method1958(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("u")
   void method1964(int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1479.getFront(); var2 != null; var2 = (TaskDataNode)this.field1479.getNext()) {
         var2.vmethod4058(var1);
      }

   }
}
