import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public class class88 extends TaskDataNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   Deque field1255;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   Deque field1256;
   @ObfuscatedName("b")
   int field1257;
   @ObfuscatedName("f")
   int field1258;

   public class88() {
      this.field1255 = new Deque();
      this.field1256 = new Deque();
      this.field1257 = 0;
      this.field1258 = -1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ldu;)V"
   )
   public final synchronized void method2049(TaskDataNode var1) {
      this.field1255.addTail(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ldu;)V"
   )
   public final synchronized void method2050(TaskDataNode var1) {
      var1.unlink();
   }

   @ObfuscatedName("q")
   void method2078() {
      if(this.field1257 > 0) {
         for(class100 var1 = (class100)this.field1256.getFront(); var1 != null; var1 = (class100)this.field1256.getNext()) {
            var1.field1364 -= this.field1257;
         }

         this.field1258 -= this.field1257;
         this.field1257 = 0;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgl;Lcr;)V"
   )
   void method2052(Node var1, class100 var2) {
      while(this.field1256.head != var1 && ((class100)var1).field1364 <= var2.field1364) {
         var1 = var1.next;
      }

      Deque.method4132(var2, var1);
      this.field1258 = ((class100)this.field1256.head.next).field1364;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lcr;)V"
   )
   void method2053(class100 var1) {
      var1.unlink();
      var1.method2291();
      Node var2 = this.field1256.head.next;
      if(var2 == this.field1256.head) {
         this.field1258 = -1;
      } else {
         this.field1258 = ((class100)var2).field1364;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Ldu;"
   )
   protected TaskDataNode vmethod4421() {
      return (TaskDataNode)this.field1255.getFront();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "()Ldu;"
   )
   protected TaskDataNode vmethod4422() {
      return (TaskDataNode)this.field1255.getNext();
   }

   @ObfuscatedName("d")
   protected int vmethod4423() {
      return 0;
   }

   @ObfuscatedName("s")
   public final synchronized void vmethod4424(int[] var1, int var2, int var3) {
      do {
         if(this.field1258 < 0) {
            this.method2057(var1, var2, var3);
            return;
         }

         if(var3 + this.field1257 < this.field1258) {
            this.field1257 += var3;
            this.method2057(var1, var2, var3);
            return;
         }

         int var4 = this.field1258 - this.field1257;
         this.method2057(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1257 += var4;
         this.method2078();
         class100 var5 = (class100)this.field1256.getFront();
         synchronized(var5) {
            int var7 = var5.method2298();
            if(var7 < 0) {
               var5.field1364 = 0;
               this.method2053(var5);
            } else {
               var5.field1364 = var7;
               this.method2052(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("p")
   void method2057(int[] var1, int var2, int var3) {
      for(TaskDataNode var4 = (TaskDataNode)this.field1255.getFront(); var4 != null; var4 = (TaskDataNode)this.field1255.getNext()) {
         var4.method2488(var1, var2, var3);
      }

   }

   @ObfuscatedName("g")
   public final synchronized void vmethod4425(int var1) {
      do {
         if(this.field1258 < 0) {
            this.method2059(var1);
            return;
         }

         if(this.field1257 + var1 < this.field1258) {
            this.field1257 += var1;
            this.method2059(var1);
            return;
         }

         int var2 = this.field1258 - this.field1257;
         this.method2059(var2);
         var1 -= var2;
         this.field1257 += var2;
         this.method2078();
         class100 var3 = (class100)this.field1256.getFront();
         synchronized(var3) {
            int var5 = var3.method2298();
            if(var5 < 0) {
               var3.field1364 = 0;
               this.method2053(var3);
            } else {
               var3.field1364 = var5;
               this.method2052(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("y")
   void method2059(int var1) {
      for(TaskDataNode var2 = (TaskDataNode)this.field1255.getFront(); var2 != null; var2 = (TaskDataNode)this.field1255.getNext()) {
         var2.vmethod4425(var1);
      }

   }
}
