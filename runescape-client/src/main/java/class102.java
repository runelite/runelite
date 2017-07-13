import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ce")
public class class102 extends class119 {
   @ObfuscatedName("a")
   Deque field1558;
   @ObfuscatedName("j")
   Deque field1556;
   @ObfuscatedName("r")
   int field1555;
   @ObfuscatedName("n")
   int field1557;

   public class102() {
      this.field1558 = new Deque();
      this.field1556 = new Deque();
      this.field1557 = 0;
      this.field1555 = -1;
   }

   @ObfuscatedName("p")
   void method1862(int[] var1, int var2, int var3) {
      for(class119 var4 = (class119)this.field1558.getFront(); var4 != null; var4 = (class119)this.field1558.getNext()) {
         var4.method2294(var1, var2, var3);
      }

   }

   @ObfuscatedName("u")
   void method1864(int var1) {
      for(class119 var2 = (class119)this.field1558.getFront(); var2 != null; var2 = (class119)this.field1558.getNext()) {
         var2.vmethod3869(var1);
      }

   }

   @ObfuscatedName("w")
   public final synchronized void vmethod3872(int[] var1, int var2, int var3) {
      do {
         if(this.field1555 < 0) {
            this.method1862(var1, var2, var3);
            return;
         }

         if(var3 + this.field1557 < this.field1555) {
            this.field1557 += var3;
            this.method1862(var1, var2, var3);
            return;
         }

         int var4 = this.field1555 - this.field1557;
         this.method1862(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1557 += var4;
         this.method1855();
         class113 var5 = (class113)this.field1556.getFront();
         synchronized(var5) {
            int var7 = var5.method2083(this);
            if(var7 < 0) {
               var5.field1661 = 0;
               this.method1857(var5);
            } else {
               var5.field1661 = var7;
               this.method1856(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("m")
   public final synchronized void vmethod3869(int var1) {
      do {
         if(this.field1555 < 0) {
            this.method1864(var1);
            return;
         }

         if(this.field1557 + var1 < this.field1555) {
            this.field1557 += var1;
            this.method1864(var1);
            return;
         }

         int var2 = this.field1555 - this.field1557;
         this.method1864(var2);
         var1 -= var2;
         this.field1557 += var2;
         this.method1855();
         class113 var3 = (class113)this.field1556.getFront();
         synchronized(var3) {
            int var5 = var3.method2083(this);
            if(var5 < 0) {
               var3.field1661 = 0;
               this.method1857(var3);
            } else {
               var3.field1661 = var5;
               this.method1856(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("l")
   protected class119 vmethod3882() {
      return (class119)this.field1558.getNext();
   }

   @ObfuscatedName("n")
   void method1855() {
      if(this.field1557 > 0) {
         for(class113 var1 = (class113)this.field1556.getFront(); var1 != null; var1 = (class113)this.field1556.getNext()) {
            var1.field1661 -= this.field1557;
         }

         this.field1555 -= this.field1557;
         this.field1557 = 0;
      }

   }

   @ObfuscatedName("a")
   public final synchronized void method1880(class119 var1) {
      this.field1558.addTail(var1);
   }

   @ObfuscatedName("e")
   protected class119 vmethod3883() {
      return (class119)this.field1558.getFront();
   }

   @ObfuscatedName("j")
   public final synchronized void method1867(class119 var1) {
      var1.unlink();
   }

   @ObfuscatedName("v")
   void method1857(class113 var1) {
      var1.unlink();
      var1.method2082();
      Node var2 = this.field1556.head.next;
      if(var2 == this.field1556.head) {
         this.field1555 = -1;
      } else {
         this.field1555 = ((class113)var2).field1661;
      }

   }

   @ObfuscatedName("r")
   void method1856(Node var1, class113 var2) {
      while(this.field1556.head != var1 && ((class113)var1).field1661 <= var2.field1661) {
         var1 = var1.next;
      }

      Deque.method3598(var2, var1);
      this.field1555 = ((class113)this.field1556.head.next).field1661;
   }

   @ObfuscatedName("s")
   protected int vmethod3871() {
      return 0;
   }
}
