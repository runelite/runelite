import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class101 extends class118 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   Deque field1569;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   Deque field1568;
   @ObfuscatedName("r")
   int field1570;
   @ObfuscatedName("a")
   int field1567;

   public class101() {
      this.field1569 = new Deque();
      this.field1568 = new Deque();
      this.field1567 = 0;
      this.field1570 = -1;
   }

   @ObfuscatedName("s")
   void method1888(int[] var1, int var2, int var3) {
      for(class118 var4 = (class118)this.field1569.getFront(); var4 != null; var4 = (class118)this.field1569.getNext()) {
         var4.method2321(var1, var2, var3);
      }

   }

   @ObfuscatedName("l")
   void method1890(int var1) {
      for(class118 var2 = (class118)this.field1569.getFront(); var2 != null; var2 = (class118)this.field1569.getNext()) {
         var2.vmethod3937(var1);
      }

   }

   @ObfuscatedName("k")
   public final synchronized void vmethod3936(int[] var1, int var2, int var3) {
      do {
         if(this.field1570 < 0) {
            this.method1888(var1, var2, var3);
            return;
         }

         if(var3 + this.field1567 < this.field1570) {
            this.field1567 += var3;
            this.method1888(var1, var2, var3);
            return;
         }

         int var4 = this.field1570 - this.field1567;
         this.method1888(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1567 += var4;
         this.method1881();
         class112 var5 = (class112)this.field1568.getFront();
         synchronized(var5) {
            int var7 = var5.method2101();
            if(var7 < 0) {
               var5.field1680 = 0;
               this.method1883(var5);
            } else {
               var5.field1680 = var7;
               this.method1882(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("d")
   public final synchronized void vmethod3937(int var1) {
      do {
         if(this.field1570 < 0) {
            this.method1890(var1);
            return;
         }

         if(this.field1567 + var1 < this.field1570) {
            this.field1567 += var1;
            this.method1890(var1);
            return;
         }

         int var2 = this.field1570 - this.field1567;
         this.method1890(var2);
         var1 -= var2;
         this.field1567 += var2;
         this.method1881();
         class112 var3 = (class112)this.field1568.getFront();
         synchronized(var3) {
            int var5 = var3.method2101();
            if(var5 < 0) {
               var3.field1680 = 0;
               this.method1883(var3);
            } else {
               var3.field1680 = var5;
               this.method1882(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected class118 vmethod3934() {
      return (class118)this.field1569.getNext();
   }

   @ObfuscatedName("a")
   void method1881() {
      if(this.field1567 > 0) {
         for(class112 var1 = (class112)this.field1568.getFront(); var1 != null; var1 = (class112)this.field1568.getNext()) {
            var1.field1680 -= this.field1567;
         }

         this.field1570 -= this.field1567;
         this.field1567 = 0;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lds;)V"
   )
   public final synchronized void method1915(class118 var1) {
      this.field1569.addTail(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "()Lds;"
   )
   protected class118 vmethod3943() {
      return (class118)this.field1569.getFront();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lds;)V"
   )
   public final synchronized void method1880(class118 var1) {
      var1.unlink();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ldn;)V"
   )
   void method1883(class112 var1) {
      var1.unlink();
      var1.method2104();
      Node var2 = this.field1568.head.next;
      if(var2 == this.field1568.head) {
         this.field1570 = -1;
      } else {
         this.field1570 = ((class112)var2).field1680;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgs;Ldn;)V"
   )
   void method1882(Node var1, class112 var2) {
      while(this.field1568.head != var1 && ((class112)var1).field1680 <= var2.field1680) {
         var1 = var1.next;
      }

      Deque.method3691(var2, var1);
      this.field1570 = ((class112)this.field1568.head.next).field1680;
   }

   @ObfuscatedName("b")
   protected int vmethod3950() {
      return 0;
   }
}
