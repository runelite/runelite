import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("AudioLinkedDeque")
public class AudioLinkedDeque extends TaskDataNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   Deque field1463;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   Deque field1461;
   @ObfuscatedName("k")
   int field1462;
   @ObfuscatedName("u")
   int field1460;

   public AudioLinkedDeque() {
      this.field1463 = new Deque();
      this.field1461 = new Deque();
      this.field1462 = 0;
      this.field1460 = -1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ldy;)V"
   )
   public final synchronized void method1885(TaskDataNode var1) {
      this.field1463.addTail(var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ldy;)V"
   )
   public final synchronized void method1882(TaskDataNode var1) {
      var1.unlink();
   }

   @ObfuscatedName("e")
   void method1883() {
      if(this.field1462 > 0) {
         for(class113 var1 = (class113)this.field1461.getFront(); var1 != null; var1 = (class113)this.field1461.getNext()) {
            var1.field1563 -= this.field1462;
         }

         this.field1460 -= this.field1462;
         this.field1462 = 0;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgn;Ldk;)V"
   )
   void method1895(Node var1, class113 var2) {
      while(this.field1461.head != var1 && ((class113)var1).field1563 <= var2.field1563) {
         var1 = var1.next;
      }

      Deque.method3748(var2, var1);
      this.field1460 = ((class113)this.field1461.head.next).field1563;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ldk;)V"
   )
   void method1909(class113 var1) {
      var1.unlink();
      var1.method2090();
      Node var2 = this.field1461.head.next;
      if(var2 == this.field1461.head) {
         this.field1460 = -1;
      } else {
         this.field1460 = ((class113)var2).field1563;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldy;"
   )
   protected TaskDataNode vmethod4041() {
      return (TaskDataNode)this.field1463.getFront();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "()Ldy;"
   )
   protected TaskDataNode vmethod4040() {
      return (TaskDataNode)this.field1463.getNext();
   }

   @ObfuscatedName("f")
   protected int vmethod4045() {
      return 0;
   }

   @ObfuscatedName("g")
   public final synchronized void vmethod4062(int[] var1, int var2, int var3) {
      do {
         if(this.field1460 < 0) {
            this.method1887(var1, var2, var3);
            return;
         }

         if(var3 + this.field1462 < this.field1460) {
            this.field1462 += var3;
            this.method1887(var1, var2, var3);
            return;
         }

         int var4 = this.field1460 - this.field1462;
         this.method1887(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1462 += var4;
         this.method1883();
         class113 var5 = (class113)this.field1461.getFront();
         synchronized(var5) {
            int var7 = var5.method2091();
            if(var7 < 0) {
               var5.field1563 = 0;
               this.method1909(var5);
            } else {
               var5.field1563 = var7;
               this.method1895(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("x")
   void method1887(int[] var1, int var2, int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1463.getFront(); var4 != null; var4 = (TaskDataNode)this.field1463.getNext()) {
         var4.method2289(var1, var2, var3);
      }

   }

   @ObfuscatedName("c")
   public final synchronized void vmethod4046(int var1) {
      do {
         if(this.field1460 < 0) {
            this.method1892(var1);
            return;
         }

         if(this.field1462 + var1 < this.field1460) {
            this.field1462 += var1;
            this.method1892(var1);
            return;
         }

         int var2 = this.field1460 - this.field1462;
         this.method1892(var2);
         var1 -= var2;
         this.field1462 += var2;
         this.method1883();
         class113 var3 = (class113)this.field1461.getFront();
         synchronized(var3) {
            int var5 = var3.method2091();
            if(var5 < 0) {
               var3.field1563 = 0;
               this.method1909(var3);
            } else {
               var3.field1563 = var5;
               this.method1895(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("n")
   void method1892(int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1463.getFront(); var2 != null; var2 = (TaskDataNode)this.field1463.getNext()) {
         var2.vmethod4046(var1);
      }

   }
}
