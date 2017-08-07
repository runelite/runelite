import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
public class class103 extends class120 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   Deque field1553;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   Deque field1551;
   @ObfuscatedName("y")
   int field1554;
   @ObfuscatedName("g")
   int field1552;

   public class103() {
      this.field1553 = new Deque();
      this.field1551 = new Deque();
      this.field1552 = 0;
      this.field1554 = -1;
   }

   @ObfuscatedName("u")
   void method1920(int[] var1, int var2, int var3) {
      for(class120 var4 = (class120)this.field1553.getFront(); var4 != null; var4 = (class120)this.field1553.getNext()) {
         var4.method2315(var1, var2, var3);
      }

   }

   @ObfuscatedName("o")
   void method1929(int var1) {
      for(class120 var2 = (class120)this.field1553.getFront(); var2 != null; var2 = (class120)this.field1553.getNext()) {
         var2.vmethod3890(var1);
      }

   }

   @ObfuscatedName("r")
   public final synchronized void vmethod3889(int[] var1, int var2, int var3) {
      do {
         if(this.field1554 < 0) {
            this.method1920(var1, var2, var3);
            return;
         }

         if(var3 + this.field1552 < this.field1554) {
            this.field1552 += var3;
            this.method1920(var1, var2, var3);
            return;
         }

         int var4 = this.field1554 - this.field1552;
         this.method1920(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1552 += var4;
         this.method1915();
         class114 var5 = (class114)this.field1551.getFront();
         synchronized(var5) {
            int var7 = var5.method2121();
            if(var7 < 0) {
               var5.field1660 = 0;
               this.method1913(var5);
            } else {
               var5.field1660 = var7;
               this.method1914(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("d")
   public final synchronized void vmethod3890(int var1) {
      do {
         if(this.field1554 < 0) {
            this.method1929(var1);
            return;
         }

         if(this.field1552 + var1 < this.field1554) {
            this.field1552 += var1;
            this.method1929(var1);
            return;
         }

         int var2 = this.field1554 - this.field1552;
         this.method1929(var2);
         var1 -= var2;
         this.field1552 += var2;
         this.method1915();
         class114 var3 = (class114)this.field1551.getFront();
         synchronized(var3) {
            int var5 = var3.method2121();
            if(var5 < 0) {
               var3.field1660 = 0;
               this.method1913(var3);
            } else {
               var3.field1660 = var5;
               this.method1914(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldl;"
   )
   protected class120 vmethod3908() {
      return (class120)this.field1553.getNext();
   }

   @ObfuscatedName("g")
   void method1915() {
      if(this.field1552 > 0) {
         for(class114 var1 = (class114)this.field1551.getFront(); var1 != null; var1 = (class114)this.field1551.getNext()) {
            var1.field1660 -= this.field1552;
         }

         this.field1554 -= this.field1552;
         this.field1552 = 0;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ldl;)V"
   )
   public final synchronized void method1911(class120 var1) {
      this.field1553.addTail(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "()Ldl;"
   )
   protected class120 vmethod3906() {
      return (class120)this.field1553.getFront();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ldl;)V"
   )
   public final synchronized void method1934(class120 var1) {
      var1.unlink();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ldz;)V"
   )
   void method1913(class114 var1) {
      var1.unlink();
      var1.method2123();
      Node var2 = this.field1551.head.next;
      if(var2 == this.field1551.head) {
         this.field1554 = -1;
      } else {
         this.field1554 = ((class114)var2).field1660;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgx;Ldz;)V"
   )
   void method1914(Node var1, class114 var2) {
      while(this.field1551.head != var1 && ((class114)var1).field1660 <= var2.field1660) {
         var1 = var1.next;
      }

      Deque.method3599(var2, var1);
      this.field1554 = ((class114)this.field1551.head.next).field1660;
   }

   @ObfuscatedName("z")
   protected int vmethod3904() {
      return 0;
   }
}
