import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cr")
public class class102 extends class119 {
   @ObfuscatedName("v")
   int field1572;
   @ObfuscatedName("i")
   Deque field1573;
   @ObfuscatedName("e")
   int field1574;
   @ObfuscatedName("c")
   Deque field1575;

   @ObfuscatedName("a")
   public final synchronized void vmethod3862(int var1) {
      do {
         if(this.field1572 < 0) {
            this.method1881(var1);
            return;
         }

         if(this.field1574 + var1 < this.field1572) {
            this.field1574 += var1;
            this.method1881(var1);
            return;
         }

         int var2 = this.field1572 - this.field1574;
         this.method1881(var2);
         var1 -= var2;
         this.field1574 += var2;
         this.method1872();
         class113 var3 = (class113)this.field1575.method3576();
         synchronized(var3) {
            int var5 = var3.method2084(this);
            if(var5 < 0) {
               var3.field1688 = 0;
               this.method1912(var3);
            } else {
               var3.field1688 = var5;
               this.method1873(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("c")
   public final synchronized void method1871(class119 var1) {
      var1.unlink();
   }

   @ObfuscatedName("e")
   void method1872() {
      if(this.field1574 > 0) {
         for(class113 var1 = (class113)this.field1575.method3576(); var1 != null; var1 = (class113)this.field1575.method3578()) {
            var1.field1688 -= this.field1574;
         }

         this.field1572 -= this.field1574;
         this.field1574 = 0;
      }

   }

   @ObfuscatedName("v")
   void method1873(Node var1, class113 var2) {
      while(var1 != this.field1575.head && ((class113)var1).field1688 <= var2.field1688) {
         var1 = var1.next;
      }

      Deque.method3573(var2, var1);
      this.field1572 = ((class113)this.field1575.head.next).field1688;
   }

   @ObfuscatedName("x")
   protected int vmethod3860() {
      return 0;
   }

   @ObfuscatedName("y")
   protected class119 vmethod3858() {
      return (class119)this.field1573.method3576();
   }

   @ObfuscatedName("h")
   protected class119 vmethod3886() {
      return (class119)this.field1573.method3578();
   }

   @ObfuscatedName("f")
   public final synchronized void vmethod3878(int[] var1, int var2, int var3) {
      do {
         if(this.field1572 < 0) {
            this.method1879(var1, var2, var3);
            return;
         }

         if(this.field1574 + var3 < this.field1572) {
            this.field1574 += var3;
            this.method1879(var1, var2, var3);
            return;
         }

         int var4 = this.field1572 - this.field1574;
         this.method1879(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1574 += var4;
         this.method1872();
         class113 var5 = (class113)this.field1575.method3576();
         synchronized(var5) {
            int var7 = var5.method2084(this);
            if(var7 < 0) {
               var5.field1688 = 0;
               this.method1912(var5);
            } else {
               var5.field1688 = var7;
               this.method1873(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("n")
   void method1879(int[] var1, int var2, int var3) {
      for(class119 var4 = (class119)this.field1573.method3576(); var4 != null; var4 = (class119)this.field1573.method3578()) {
         var4.method2277(var1, var2, var3);
      }

   }

   @ObfuscatedName("o")
   void method1881(int var1) {
      for(class119 var2 = (class119)this.field1573.method3576(); var2 != null; var2 = (class119)this.field1573.method3578()) {
         var2.vmethod3862(var1);
      }

   }

   @ObfuscatedName("i")
   public final synchronized void method1884(class119 var1) {
      this.field1573.method3572(var1);
   }

   public class102() {
      this.field1573 = new Deque();
      this.field1575 = new Deque();
      this.field1574 = 0;
      this.field1572 = -1;
   }

   @ObfuscatedName("b")
   void method1912(class113 var1) {
      var1.unlink();
      var1.method2086();
      Node var2 = this.field1575.head.next;
      if(var2 == this.field1575.head) {
         this.field1572 = -1;
      } else {
         this.field1572 = ((class113)var2).field1688;
      }

   }
}
