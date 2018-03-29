import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class100 extends TaskDataNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   Deque field1487;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   Deque field1490;
   @ObfuscatedName("o")
   int field1489;
   @ObfuscatedName("j")
   int field1488;

   public class100() {
      this.field1487 = new Deque();
      this.field1490 = new Deque();
      this.field1489 = 0;
      this.field1488 = -1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ldd;)V"
   )
   public final synchronized void method2085(TaskDataNode var1) {
      this.field1487.addTail(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ldd;)V"
   )
   public final synchronized void method2062(TaskDataNode var1) {
      var1.unlink();
   }

   @ObfuscatedName("o")
   void method2061() {
      if(this.field1489 > 0) {
         for(class112 var1 = (class112)this.field1490.getFront(); var1 != null; var1 = (class112)this.field1490.getNext()) {
            var1.field1594 -= this.field1489;
         }

         this.field1488 -= this.field1489;
         this.field1489 = 0;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lhg;Ldv;)V"
   )
   void method2058(Node var1, class112 var2) {
      while(this.field1490.head != var1 && ((class112)var1).field1594 <= var2.field1594) {
         var1 = var1.next;
      }

      Deque.method4045(var2, var1);
      this.field1488 = ((class112)this.field1490.head.next).field1594;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ldv;)V"
   )
   void method2063(class112 var1) {
      var1.unlink();
      var1.method2275();
      Node var2 = this.field1490.head.next;
      if(var2 == this.field1490.head) {
         this.field1488 = -1;
      } else {
         this.field1488 = ((class112)var2).field1594;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected TaskDataNode vmethod4336() {
      return (TaskDataNode)this.field1487.getFront();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected TaskDataNode vmethod4337() {
      return (TaskDataNode)this.field1487.getNext();
   }

   @ObfuscatedName("p")
   protected int vmethod4338() {
      return 0;
   }

   @ObfuscatedName("w")
   public final synchronized void vmethod4339(int[] var1, int var2, int var3) {
      do {
         if(this.field1488 < 0) {
            this.method2068(var1, var2, var3);
            return;
         }

         if(var3 + this.field1489 < this.field1488) {
            this.field1489 += var3;
            this.method2068(var1, var2, var3);
            return;
         }

         int var4 = this.field1488 - this.field1489;
         this.method2068(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1489 += var4;
         this.method2061();
         class112 var5 = (class112)this.field1490.getFront();
         synchronized(var5) {
            int var7 = var5.method2281();
            if(var7 < 0) {
               var5.field1594 = 0;
               this.method2063(var5);
            } else {
               var5.field1594 = var7;
               this.method2058(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("r")
   void method2068(int[] var1, int var2, int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1487.getFront(); var4 != null; var4 = (TaskDataNode)this.field1487.getNext()) {
         var4.method2487(var1, var2, var3);
      }

   }

   @ObfuscatedName("d")
   public final synchronized void vmethod4340(int var1) {
      do {
         if(this.field1488 < 0) {
            this.method2070(var1);
            return;
         }

         if(this.field1489 + var1 < this.field1488) {
            this.field1489 += var1;
            this.method2070(var1);
            return;
         }

         int var2 = this.field1488 - this.field1489;
         this.method2070(var2);
         var1 -= var2;
         this.field1489 += var2;
         this.method2061();
         class112 var3 = (class112)this.field1490.getFront();
         synchronized(var3) {
            int var5 = var3.method2281();
            if(var5 < 0) {
               var3.field1594 = 0;
               this.method2063(var3);
            } else {
               var3.field1594 = var5;
               this.method2058(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("a")
   void method2070(int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1487.getFront(); var2 != null; var2 = (TaskDataNode)this.field1487.getNext()) {
         var2.vmethod4340(var1);
      }

   }
}
