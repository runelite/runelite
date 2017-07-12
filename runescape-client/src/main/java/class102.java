import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cs")
public class class102 extends class119 {
   @ObfuscatedName("i")
   Deque field1581;
   @ObfuscatedName("s")
   int field1582;
   @ObfuscatedName("t")
   int field1583;
   @ObfuscatedName("a")
   Deque field1584;

   public class102() {
      this.field1581 = new Deque();
      this.field1584 = new Deque();
      this.field1583 = 0;
      this.field1582 = -1;
   }

   @ObfuscatedName("w")
   public final synchronized void method1887(class119 var1) {
      var1.unlink();
   }

   @ObfuscatedName("a")
   void method1888() {
      if(this.field1583 > 0) {
         for(class113 var1 = (class113)this.field1584.getFront(); var1 != null; var1 = (class113)this.field1584.getNext()) {
            var1.field1683 -= this.field1583;
         }

         this.field1582 -= this.field1583;
         this.field1583 = 0;
      }

   }

   @ObfuscatedName("t")
   void method1889(Node var1, class113 var2) {
      while(this.field1584.head != var1 && ((class113)var1).field1683 <= var2.field1683) {
         var1 = var1.next;
      }

      Deque.method3581(var2, var1);
      this.field1582 = ((class113)this.field1584.head.next).field1683;
   }

   @ObfuscatedName("i")
   public final synchronized void method1890(class119 var1) {
      this.field1581.addTail(var1);
   }

   @ObfuscatedName("r")
   protected class119 vmethod3864() {
      return (class119)this.field1581.getFront();
   }

   @ObfuscatedName("s")
   void method1892(class113 var1) {
      var1.unlink();
      var1.method2099();
      Node var2 = this.field1584.head.next;
      if(var2 == this.field1584.head) {
         this.field1582 = -1;
      } else {
         this.field1582 = ((class113)var2).field1683;
      }

   }

   @ObfuscatedName("j")
   public final synchronized void vmethod3889(int[] var1, int var2, int var3) {
      do {
         if(this.field1582 < 0) {
            this.method1902(var1, var2, var3);
            return;
         }

         if(var3 + this.field1583 < this.field1582) {
            this.field1583 += var3;
            this.method1902(var1, var2, var3);
            return;
         }

         int var4 = this.field1582 - this.field1583;
         this.method1902(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1583 += var4;
         this.method1888();
         class113 var5 = (class113)this.field1584.getFront();
         synchronized(var5) {
            int var7 = var5.method2098(this);
            if(var7 < 0) {
               var5.field1683 = 0;
               this.method1892(var5);
            } else {
               var5.field1683 = var7;
               this.method1889(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("e")
   public final synchronized void vmethod3885(int var1) {
      do {
         if(this.field1582 < 0) {
            this.method1897(var1);
            return;
         }

         if(this.field1583 + var1 < this.field1582) {
            this.field1583 += var1;
            this.method1897(var1);
            return;
         }

         int var2 = this.field1582 - this.field1583;
         this.method1897(var2);
         var1 -= var2;
         this.field1583 += var2;
         this.method1888();
         class113 var3 = (class113)this.field1584.getFront();
         synchronized(var3) {
            int var5 = var3.method2098(this);
            if(var5 < 0) {
               var3.field1683 = 0;
               this.method1892(var3);
            } else {
               var3.field1683 = var5;
               this.method1889(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("o")
   void method1897(int var1) {
      for(class119 var2 = (class119)this.field1581.getFront(); var2 != null; var2 = (class119)this.field1581.getNext()) {
         var2.vmethod3885(var1);
      }

   }

   @ObfuscatedName("v")
   protected class119 vmethod3865() {
      return (class119)this.field1581.getNext();
   }

   @ObfuscatedName("k")
   void method1902(int[] var1, int var2, int var3) {
      for(class119 var4 = (class119)this.field1581.getFront(); var4 != null; var4 = (class119)this.field1581.getNext()) {
         var4.method2295(var1, var2, var3);
      }

   }

   @ObfuscatedName("y")
   protected int vmethod3888() {
      return 0;
   }
}
