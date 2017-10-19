import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public class class100 extends class117 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   Deque field1552;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   Deque field1551;
   @ObfuscatedName("g")
   int field1554;
   @ObfuscatedName("o")
   int field1553;

   public class100() {
      this.field1552 = new Deque();
      this.field1551 = new Deque();
      this.field1553 = 0;
      this.field1554 = -1;
   }

   @ObfuscatedName("x")
   void method1954(int[] var1, int var2, int var3) {
      for(class117 var4 = (class117)this.field1552.getFront(); var4 != null; var4 = (class117)this.field1552.getNext()) {
         var4.method2353(var1, var2, var3);
      }

   }

   @ObfuscatedName("i")
   void method1929(int var1) {
      for(class117 var2 = (class117)this.field1552.getFront(); var2 != null; var2 = (class117)this.field1552.getNext()) {
         var2.vmethod3981(var1);
      }

   }

   @ObfuscatedName("d")
   public final synchronized void vmethod3968(int[] var1, int var2, int var3) {
      do {
         if(this.field1554 < 0) {
            this.method1954(var1, var2, var3);
            return;
         }

         if(var3 + this.field1553 < this.field1554) {
            this.field1553 += var3;
            this.method1954(var1, var2, var3);
            return;
         }

         int var4 = this.field1554 - this.field1553;
         this.method1954(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1553 += var4;
         this.method1923();
         class111 var5 = (class111)this.field1551.getFront();
         synchronized(var5) {
            int var7 = var5.method2148();
            if(var7 < 0) {
               var5.field1656 = 0;
               this.method1922(var5);
            } else {
               var5.field1656 = var7;
               this.method1921(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("u")
   public final synchronized void vmethod3981(int var1) {
      do {
         if(this.field1554 < 0) {
            this.method1929(var1);
            return;
         }

         if(this.field1553 + var1 < this.field1554) {
            this.field1553 += var1;
            this.method1929(var1);
            return;
         }

         int var2 = this.field1554 - this.field1553;
         this.method1929(var2);
         var1 -= var2;
         this.field1553 += var2;
         this.method1923();
         class111 var3 = (class111)this.field1551.getFront();
         synchronized(var3) {
            int var5 = var3.method2148();
            if(var5 < 0) {
               var3.field1656 = 0;
               this.method1922(var3);
            } else {
               var3.field1656 = var5;
               this.method1921(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "()Ldm;"
   )
   protected class117 vmethod3967() {
      return (class117)this.field1552.getNext();
   }

   @ObfuscatedName("q")
   void method1923() {
      if(this.field1553 > 0) {
         for(class111 var1 = (class111)this.field1551.getFront(); var1 != null; var1 = (class111)this.field1551.getNext()) {
            var1.field1656 -= this.field1553;
         }

         this.field1554 -= this.field1553;
         this.field1553 = 0;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ldm;)V"
   )
   public final synchronized void method1919(class117 var1) {
      this.field1552.addTail(var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldm;"
   )
   protected class117 vmethod3966() {
      return (class117)this.field1552.getFront();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ldm;)V"
   )
   public final synchronized void method1920(class117 var1) {
      var1.unlink();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ldh;)V"
   )
   void method1922(class111 var1) {
      var1.unlink();
      var1.method2147();
      Node var2 = this.field1551.head.next;
      if(var2 == this.field1551.head) {
         this.field1554 = -1;
      } else {
         this.field1554 = ((class111)var2).field1656;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgd;Ldh;)V"
   )
   void method1921(Node var1, class111 var2) {
      while(this.field1551.head != var1 && ((class111)var1).field1656 <= var2.field1656) {
         var1 = var1.next;
      }

      Deque.method3691(var2, var1);
      this.field1554 = ((class111)this.field1551.head.next).field1656;
   }

   @ObfuscatedName("e")
   protected int vmethod3974() {
      return 0;
   }
}
