import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public class class102 extends class119 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   Deque field1529;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lge;"
   )
   Deque field1528;
   @ObfuscatedName("u")
   int field1530;
   @ObfuscatedName("i")
   int field1527;

   public class102() {
      this.field1529 = new Deque();
      this.field1528 = new Deque();
      this.field1527 = 0;
      this.field1530 = -1;
   }

   @ObfuscatedName("k")
   void method1838(int[] var1, int var2, int var3) {
      for(class119 var4 = (class119)this.field1529.getFront(); var4 != null; var4 = (class119)this.field1529.getNext()) {
         var4.method2232(var1, var2, var3);
      }

   }

   @ObfuscatedName("w")
   void method1819(int var1) {
      for(class119 var2 = (class119)this.field1529.getFront(); var2 != null; var2 = (class119)this.field1529.getNext()) {
         var2.vmethod3827(var1);
      }

   }

   @ObfuscatedName("p")
   public final synchronized void vmethod3826(int[] var1, int var2, int var3) {
      do {
         if(this.field1530 < 0) {
            this.method1838(var1, var2, var3);
            return;
         }

         if(var3 + this.field1527 < this.field1530) {
            this.field1527 += var3;
            this.method1838(var1, var2, var3);
            return;
         }

         int var4 = this.field1530 - this.field1527;
         this.method1838(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1527 += var4;
         this.method1807();
         class113 var5 = (class113)this.field1528.getFront();
         synchronized(var5) {
            int var7 = var5.method2035();
            if(var7 < 0) {
               var5.field1635 = 0;
               this.method1812(var5);
            } else {
               var5.field1635 = var7;
               this.method1824(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("r")
   public final synchronized void vmethod3827(int var1) {
      do {
         if(this.field1530 < 0) {
            this.method1819(var1);
            return;
         }

         if(this.field1527 + var1 < this.field1530) {
            this.field1527 += var1;
            this.method1819(var1);
            return;
         }

         int var2 = this.field1530 - this.field1527;
         this.method1819(var2);
         var1 -= var2;
         this.field1527 += var2;
         this.method1807();
         class113 var3 = (class113)this.field1528.getFront();
         synchronized(var3) {
            int var5 = var3.method2035();
            if(var5 < 0) {
               var3.field1635 = 0;
               this.method1812(var3);
            } else {
               var3.field1635 = var5;
               this.method1824(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected class119 vmethod3835() {
      return (class119)this.field1529.getNext();
   }

   @ObfuscatedName("i")
   void method1807() {
      if(this.field1527 > 0) {
         for(class113 var1 = (class113)this.field1528.getFront(); var1 != null; var1 = (class113)this.field1528.getNext()) {
            var1.field1635 -= this.field1527;
         }

         this.field1530 -= this.field1527;
         this.field1527 = 0;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ldk;)V"
   )
   public final synchronized void method1808(class119 var1) {
      this.field1529.addTail(var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldk;"
   )
   protected class119 vmethod3823() {
      return (class119)this.field1529.getFront();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ldo;)V"
   )
   void method1812(class113 var1) {
      var1.unlink();
      var1.method2034();
      Node var2 = this.field1528.head.next;
      if(var2 == this.field1528.head) {
         this.field1530 = -1;
      } else {
         this.field1530 = ((class113)var2).field1635;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ldk;)V"
   )
   public final synchronized void method1809(class119 var1) {
      var1.unlink();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgh;Ldo;)V"
   )
   void method1824(Node var1, class113 var2) {
      while(this.field1528.head != var1 && ((class113)var1).field1635 <= var2.field1635) {
         var1 = var1.next;
      }

      Deque.method3544(var2, var1);
      this.field1530 = ((class113)this.field1528.head.next).field1635;
   }

   @ObfuscatedName("x")
   protected int vmethod3825() {
      return 0;
   }
}
