import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cv")
public class class102 extends class119 {
   @ObfuscatedName("m")
   Deque field1556;
   @ObfuscatedName("e")
   int field1557;
   @ObfuscatedName("p")
   Deque field1558;
   @ObfuscatedName("t")
   int field1559;

   public class102() {
      this.field1558 = new Deque();
      this.field1556 = new Deque();
      this.field1557 = 0;
      this.field1559 = -1;
   }

   @ObfuscatedName("m")
   public final synchronized void method1780(class119 var1) {
      var1.unlink();
   }

   @ObfuscatedName("e")
   void method1781() {
      if(this.field1557 > 0) {
         for(class113 var1 = (class113)this.field1556.method3487(); var1 != null; var1 = (class113)this.field1556.method3512()) {
            var1.field1671 -= this.field1557;
         }

         this.field1559 -= this.field1557;
         this.field1557 = 0;
      }

   }

   @ObfuscatedName("t")
   void method1782(Node var1, class113 var2) {
      while(var1 != this.field1556.head && ((class113)var1).field1671 <= var2.field1671) {
         var1 = var1.next;
      }

      Deque.method3518(var2, var1);
      this.field1559 = ((class113)this.field1556.head.next).field1671;
   }

   @ObfuscatedName("w")
   void method1783(class113 var1) {
      var1.unlink();
      var1.method2014();
      Node var2 = this.field1556.head.next;
      if(var2 == this.field1556.head) {
         this.field1559 = -1;
      } else {
         this.field1559 = ((class113)var2).field1671;
      }

   }

   @ObfuscatedName("z")
   protected class119 vmethod3771() {
      return (class119)this.field1558.method3487();
   }

   @ObfuscatedName("j")
   protected class119 vmethod3780() {
      return (class119)this.field1558.method3512();
   }

   @ObfuscatedName("c")
   protected int vmethod3772() {
      return 0;
   }

   @ObfuscatedName("o")
   public final synchronized void vmethod3775(int[] var1, int var2, int var3) {
      do {
         if(this.field1559 < 0) {
            this.method1788(var1, var2, var3);
            return;
         }

         if(this.field1557 + var3 < this.field1559) {
            this.field1557 += var3;
            this.method1788(var1, var2, var3);
            return;
         }

         int var4 = this.field1559 - this.field1557;
         this.method1788(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1557 += var4;
         this.method1781();
         class113 var5 = (class113)this.field1556.method3487();
         synchronized(var5) {
            int var7 = var5.method2008(this);
            if(var7 < 0) {
               var5.field1671 = 0;
               this.method1783(var5);
            } else {
               var5.field1671 = var7;
               this.method1782(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("q")
   void method1788(int[] var1, int var2, int var3) {
      for(class119 var4 = (class119)this.field1558.method3487(); var4 != null; var4 = (class119)this.field1558.method3512()) {
         var4.method2204(var1, var2, var3);
      }

   }

   @ObfuscatedName("n")
   public final synchronized void vmethod3773(int var1) {
      do {
         if(this.field1559 < 0) {
            this.method1790(var1);
            return;
         }

         if(this.field1557 + var1 < this.field1559) {
            this.field1557 += var1;
            this.method1790(var1);
            return;
         }

         int var2 = this.field1559 - this.field1557;
         this.method1790(var2);
         var1 -= var2;
         this.field1557 += var2;
         this.method1781();
         class113 var3 = (class113)this.field1556.method3487();
         synchronized(var3) {
            int var5 = var3.method2008(this);
            if(var5 < 0) {
               var3.field1671 = 0;
               this.method1783(var3);
            } else {
               var3.field1671 = var5;
               this.method1782(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("a")
   void method1790(int var1) {
      for(class119 var2 = (class119)this.field1558.method3487(); var2 != null; var2 = (class119)this.field1558.method3512()) {
         var2.vmethod3773(var1);
      }

   }

   @ObfuscatedName("p")
   public final synchronized void method1806(class119 var1) {
      this.field1558.method3501(var1);
   }
}
