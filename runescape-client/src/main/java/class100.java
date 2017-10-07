import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class100 extends class117 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Deque field1550;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Deque field1548;
   @ObfuscatedName("p")
   int field1547;
   @ObfuscatedName("e")
   int field1549;

   public class100() {
      this.field1550 = new Deque();
      this.field1548 = new Deque();
      this.field1549 = 0;
      this.field1547 = -1;
   }

   @ObfuscatedName("t")
   void method1957(int[] var1, int var2, int var3) {
      for(class117 var4 = (class117)this.field1550.getFront(); var4 != null; var4 = (class117)this.field1550.getNext()) {
         var4.method2374(var1, var2, var3);
      }

   }

   @ObfuscatedName("o")
   void method1959(int var1) {
      for(class117 var2 = (class117)this.field1550.getFront(); var2 != null; var2 = (class117)this.field1550.getNext()) {
         var2.vmethod4023(var1);
      }

   }

   @ObfuscatedName("v")
   public final synchronized void vmethod4004(int[] var1, int var2, int var3) {
      do {
         if(this.field1547 < 0) {
            this.method1957(var1, var2, var3);
            return;
         }

         if(var3 + this.field1549 < this.field1547) {
            this.field1549 += var3;
            this.method1957(var1, var2, var3);
            return;
         }

         int var4 = this.field1547 - this.field1549;
         this.method1957(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1549 += var4;
         this.method1950();
         class111 var5 = (class111)this.field1548.getFront();
         synchronized(var5) {
            int var7 = var5.method2176();
            if(var7 < 0) {
               var5.field1659 = 0;
               this.method1952(var5);
            } else {
               var5.field1659 = var7;
               this.method1951(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("y")
   public final synchronized void vmethod4023(int var1) {
      do {
         if(this.field1547 < 0) {
            this.method1959(var1);
            return;
         }

         if(this.field1549 + var1 < this.field1547) {
            this.field1549 += var1;
            this.method1959(var1);
            return;
         }

         int var2 = this.field1547 - this.field1549;
         this.method1959(var2);
         var1 -= var2;
         this.field1549 += var2;
         this.method1950();
         class111 var3 = (class111)this.field1548.getFront();
         synchronized(var3) {
            int var5 = var3.method2176();
            if(var5 < 0) {
               var3.field1659 = 0;
               this.method1952(var3);
            } else {
               var3.field1659 = var5;
               this.method1951(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected class117 vmethod4002() {
      return (class117)this.field1550.getNext();
   }

   @ObfuscatedName("e")
   void method1950() {
      if(this.field1549 > 0) {
         for(class111 var1 = (class111)this.field1548.getFront(); var1 != null; var1 = (class111)this.field1548.getNext()) {
            var1.field1659 -= this.field1549;
         }

         this.field1547 -= this.field1549;
         this.field1549 = 0;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ldd;)V"
   )
   public final synchronized void method1979(class117 var1) {
      this.field1550.addTail(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected class117 vmethod4025() {
      return (class117)this.field1550.getFront();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ldd;)V"
   )
   public final synchronized void method1949(class117 var1) {
      var1.unlink();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ldc;)V"
   )
   void method1952(class111 var1) {
      var1.unlink();
      var1.method2177();
      Node var2 = this.field1548.head.next;
      if(var2 == this.field1548.head) {
         this.field1547 = -1;
      } else {
         this.field1547 = ((class111)var2).field1659;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgs;Ldc;)V"
   )
   void method1951(Node var1, class111 var2) {
      while(this.field1548.head != var1 && ((class111)var1).field1659 <= var2.field1659) {
         var1 = var1.next;
      }

      Deque.method3704(var2, var1);
      this.field1547 = ((class111)this.field1548.head.next).field1659;
   }

   @ObfuscatedName("g")
   protected int vmethod4007() {
      return 0;
   }
}
