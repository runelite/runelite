import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class99 extends TaskDataNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   Deque field1453;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   Deque field1452;
   @ObfuscatedName("s")
   int field1454;
   @ObfuscatedName("j")
   int field1451;

   public class99() {
      this.field1453 = new Deque();
      this.field1452 = new Deque();
      this.field1454 = 0;
      this.field1451 = -1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ldj;)V"
   )
   public final synchronized void method2080(TaskDataNode var1) {
      this.field1453.addTail(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ldj;)V"
   )
   public final synchronized void method2082(TaskDataNode var1) {
      var1.unlink();
   }

   @ObfuscatedName("w")
   void method2044() {
      if(this.field1454 > 0) {
         for(class111 var1 = (class111)this.field1452.getFront(); var1 != null; var1 = (class111)this.field1452.getNext()) {
            var1.field1555 -= this.field1454;
         }

         this.field1451 -= this.field1454;
         this.field1454 = 0;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgw;Ldi;)V"
   )
   void method2048(Node var1, class111 var2) {
      while(this.field1452.head != var1 && ((class111)var1).field1555 <= var2.field1555) {
         var1 = var1.next;
      }

      Deque.method3858(var2, var1);
      this.field1451 = ((class111)this.field1452.head.next).field1555;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ldi;)V"
   )
   void method2079(class111 var1) {
      var1.unlink();
      var1.method2260();
      Node var2 = this.field1452.head.next;
      if(var2 == this.field1452.head) {
         this.field1451 = -1;
      } else {
         this.field1451 = ((class111)var2).field1555;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Ldj;"
   )
   protected TaskDataNode vmethod4155() {
      return (TaskDataNode)this.field1453.getFront();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldj;"
   )
   protected TaskDataNode vmethod4141() {
      return (TaskDataNode)this.field1453.getNext();
   }

   @ObfuscatedName("r")
   protected int vmethod4158() {
      return 0;
   }

   @ObfuscatedName("m")
   public final synchronized void vmethod4145(int[] var1, int var2, int var3) {
      do {
         if(this.field1451 < 0) {
            this.method2054(var1, var2, var3);
            return;
         }

         if(var3 + this.field1454 < this.field1451) {
            this.field1454 += var3;
            this.method2054(var1, var2, var3);
            return;
         }

         int var4 = this.field1451 - this.field1454;
         this.method2054(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1454 += var4;
         this.method2044();
         class111 var5 = (class111)this.field1452.getFront();
         synchronized(var5) {
            int var7 = var5.method2261();
            if(var7 < 0) {
               var5.field1555 = 0;
               this.method2079(var5);
            } else {
               var5.field1555 = var7;
               this.method2048(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("h")
   void method2054(int[] var1, int var2, int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1453.getFront(); var4 != null; var4 = (TaskDataNode)this.field1453.getNext()) {
         var4.method2451(var1, var2, var3);
      }

   }

   @ObfuscatedName("o")
   public final synchronized void vmethod4144(int var1) {
      do {
         if(this.field1451 < 0) {
            this.method2049(var1);
            return;
         }

         if(this.field1454 + var1 < this.field1451) {
            this.field1454 += var1;
            this.method2049(var1);
            return;
         }

         int var2 = this.field1451 - this.field1454;
         this.method2049(var2);
         var1 -= var2;
         this.field1454 += var2;
         this.method2044();
         class111 var3 = (class111)this.field1452.getFront();
         synchronized(var3) {
            int var5 = var3.method2261();
            if(var5 < 0) {
               var3.field1555 = 0;
               this.method2079(var3);
            } else {
               var3.field1555 = var5;
               this.method2048(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("x")
   void method2049(int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1453.getFront(); var2 != null; var2 = (TaskDataNode)this.field1453.getNext()) {
         var2.vmethod4144(var1);
      }

   }
}
