import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class101 extends class118 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   Deque field1479;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   Deque field1480;
   @ObfuscatedName("i")
   int field1481;
   @ObfuscatedName("j")
   int field1482;

   public class101() {
      this.field1479 = new Deque();
      this.field1480 = new Deque();
      this.field1481 = 0;
      this.field1482 = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ldq;)V"
   )
   public final synchronized void method1972(class118 var1) {
      this.field1479.addTail(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ldq;)V"
   )
   public final synchronized void method1984(class118 var1) {
      var1.unlink();
   }

   @ObfuscatedName("i")
   void method1974() {
      if(this.field1481 > 0) {
         for(class112 var1 = (class112)this.field1480.getFront(); var1 != null; var1 = (class112)this.field1480.getNext()) {
            var1.field1589 -= this.field1481;
         }

         this.field1482 -= this.field1481;
         this.field1481 = 0;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgh;Ldo;)V"
   )
   void method1975(Node var1, class112 var2) {
      while(this.field1480.head != var1 && ((class112)var1).field1589 <= var2.field1589) {
         var1 = var1.next;
      }

      Deque.method3771(var2, var1);
      this.field1482 = ((class112)this.field1480.head.next).field1589;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ldo;)V"
   )
   void method1976(class112 var1) {
      var1.unlink();
      var1.method2190();
      Node var2 = this.field1480.head.next;
      if(var2 == this.field1480.head) {
         this.field1482 = -1;
      } else {
         this.field1482 = ((class112)var2).field1589;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Ldq;"
   )
   protected class118 vmethod4047() {
      return (class118)this.field1479.getFront();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "()Ldq;"
   )
   protected class118 vmethod4048() {
      return (class118)this.field1479.getNext();
   }

   @ObfuscatedName("l")
   protected int vmethod4068() {
      return 0;
   }

   @ObfuscatedName("b")
   public final synchronized void vmethod4050(int[] var1, int var2, int var3) {
      do {
         if(this.field1482 < 0) {
            this.method1981(var1, var2, var3);
            return;
         }

         if(var3 + this.field1481 < this.field1482) {
            this.field1481 += var3;
            this.method1981(var1, var2, var3);
            return;
         }

         int var4 = this.field1482 - this.field1481;
         this.method1981(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1481 += var4;
         this.method1974();
         class112 var5 = (class112)this.field1480.getFront();
         synchronized(var5) {
            int var7 = var5.method2191();
            if(var7 < 0) {
               var5.field1589 = 0;
               this.method1976(var5);
            } else {
               var5.field1589 = var7;
               this.method1975(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("n")
   void method1981(int[] var1, int var2, int var3) {
      for(class118 var4 = (class118)this.field1479.getFront(); var4 != null; var4 = (class118)this.field1479.getNext()) {
         var4.method2411(var1, var2, var3);
      }

   }

   @ObfuscatedName("c")
   public final synchronized void vmethod4051(int var1) {
      do {
         if(this.field1482 < 0) {
            this.method1983(var1);
            return;
         }

         if(this.field1481 + var1 < this.field1482) {
            this.field1481 += var1;
            this.method1983(var1);
            return;
         }

         int var2 = this.field1482 - this.field1481;
         this.method1983(var2);
         var1 -= var2;
         this.field1481 += var2;
         this.method1974();
         class112 var3 = (class112)this.field1480.getFront();
         synchronized(var3) {
            int var5 = var3.method2191();
            if(var5 < 0) {
               var3.field1589 = 0;
               this.method1976(var3);
            } else {
               var3.field1589 = var5;
               this.method1975(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("a")
   void method1983(int var1) {
      for(class118 var2 = (class118)this.field1479.getFront(); var2 != null; var2 = (class118)this.field1479.getNext()) {
         var2.vmethod4051(var1);
      }

   }
}
