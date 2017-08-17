import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class103 extends class120 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   Deque field1566;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   Deque field1567;
   @ObfuscatedName("p")
   int field1569;
   @ObfuscatedName("f")
   int field1568;

   public class103() {
      this.field1566 = new Deque();
      this.field1567 = new Deque();
      this.field1568 = 0;
      this.field1569 = -1;
   }

   @ObfuscatedName("b")
   void method1928(int[] var1, int var2, int var3) {
      for(class120 var4 = (class120)this.field1566.getFront(); var4 != null; var4 = (class120)this.field1566.getNext()) {
         var4.method2319(var1, var2, var3);
      }

   }

   @ObfuscatedName("m")
   void method1905(int var1) {
      for(class120 var2 = (class120)this.field1566.getFront(); var2 != null; var2 = (class120)this.field1566.getNext()) {
         var2.vmethod3893(var1);
      }

   }

   @ObfuscatedName("w")
   public final synchronized void vmethod3904(int[] var1, int var2, int var3) {
      do {
         if(this.field1569 < 0) {
            this.method1928(var1, var2, var3);
            return;
         }

         if(var3 + this.field1568 < this.field1569) {
            this.field1568 += var3;
            this.method1928(var1, var2, var3);
            return;
         }

         int var4 = this.field1569 - this.field1568;
         this.method1928(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1568 += var4;
         this.method1896();
         class114 var5 = (class114)this.field1567.getFront();
         synchronized(var5) {
            int var7 = var5.method2122();
            if(var7 < 0) {
               var5.field1680 = 0;
               this.method1926(var5);
            } else {
               var5.field1680 = var7;
               this.method1897(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("o")
   public final synchronized void vmethod3893(int var1) {
      do {
         if(this.field1569 < 0) {
            this.method1905(var1);
            return;
         }

         if(this.field1568 + var1 < this.field1569) {
            this.field1568 += var1;
            this.method1905(var1);
            return;
         }

         int var2 = this.field1569 - this.field1568;
         this.method1905(var2);
         var1 -= var2;
         this.field1568 += var2;
         this.method1896();
         class114 var3 = (class114)this.field1567.getFront();
         synchronized(var3) {
            int var5 = var3.method2122();
            if(var5 < 0) {
               var3.field1680 = 0;
               this.method1926(var3);
            } else {
               var3.field1680 = var5;
               this.method1897(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "()Lda;"
   )
   protected class120 vmethod3888() {
      return (class120)this.field1566.getNext();
   }

   @ObfuscatedName("f")
   void method1896() {
      if(this.field1568 > 0) {
         for(class114 var1 = (class114)this.field1567.getFront(); var1 != null; var1 = (class114)this.field1567.getNext()) {
            var1.field1680 -= this.field1568;
         }

         this.field1569 -= this.field1568;
         this.field1568 = 0;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lda;)V"
   )
   public final synchronized void method1894(class120 var1) {
      this.field1566.addTail(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "()Lda;"
   )
   protected class120 vmethod3894() {
      return (class120)this.field1566.getFront();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lda;)V"
   )
   public final synchronized void method1923(class120 var1) {
      var1.unlink();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ldv;)V"
   )
   void method1926(class114 var1) {
      var1.unlink();
      var1.method2118();
      Node var2 = this.field1567.head.next;
      if(var2 == this.field1567.head) {
         this.field1569 = -1;
      } else {
         this.field1569 = ((class114)var2).field1680;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lga;Ldv;)V"
   )
   void method1897(Node var1, class114 var2) {
      while(this.field1567.head != var1 && ((class114)var1).field1680 <= var2.field1680) {
         var1 = var1.next;
      }

      Deque.method3601(var2, var1);
      this.field1569 = ((class114)this.field1567.head.next).field1680;
   }

   @ObfuscatedName("l")
   protected int vmethod3889() {
      return 0;
   }
}
