import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public class class104 extends class121 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Deque field1551;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   Deque field1550;
   @ObfuscatedName("y")
   int field1552;
   @ObfuscatedName("x")
   int field1549;

   public class104() {
      this.field1551 = new Deque();
      this.field1550 = new Deque();
      this.field1549 = 0;
      this.field1552 = -1;
   }

   @ObfuscatedName("r")
   void method1946(int[] var1, int var2, int var3) {
      for(class121 var4 = (class121)this.field1551.getFront(); var4 != null; var4 = (class121)this.field1551.getNext()) {
         var4.method2356(var1, var2, var3);
      }

   }

   @ObfuscatedName("s")
   void method1952(int var1) {
      for(class121 var2 = (class121)this.field1551.getFront(); var2 != null; var2 = (class121)this.field1551.getNext()) {
         var2.vmethod3898(var1);
      }

   }

   @ObfuscatedName("i")
   public final synchronized void vmethod3897(int[] var1, int var2, int var3) {
      do {
         if(this.field1552 < 0) {
            this.method1946(var1, var2, var3);
            return;
         }

         if(var3 + this.field1549 < this.field1552) {
            this.field1549 += var3;
            this.method1946(var1, var2, var3);
            return;
         }

         int var4 = this.field1552 - this.field1549;
         this.method1946(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1549 += var4;
         this.method1939();
         class115 var5 = (class115)this.field1550.getFront();
         synchronized(var5) {
            int var7 = var5.method2169();
            if(var7 < 0) {
               var5.field1662 = 0;
               this.method1963(var5);
            } else {
               var5.field1662 = var7;
               this.method1940(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("g")
   public final synchronized void vmethod3898(int var1) {
      do {
         if(this.field1552 < 0) {
            this.method1952(var1);
            return;
         }

         if(this.field1549 + var1 < this.field1552) {
            this.field1549 += var1;
            this.method1952(var1);
            return;
         }

         int var2 = this.field1552 - this.field1549;
         this.method1952(var2);
         var1 -= var2;
         this.field1549 += var2;
         this.method1939();
         class115 var3 = (class115)this.field1550.getFront();
         synchronized(var3) {
            int var5 = var3.method2169();
            if(var5 < 0) {
               var3.field1662 = 0;
               this.method1963(var3);
            } else {
               var3.field1662 = var5;
               this.method1940(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected class121 vmethod3895() {
      return (class121)this.field1551.getNext();
   }

   @ObfuscatedName("x")
   void method1939() {
      if(this.field1549 > 0) {
         for(class115 var1 = (class115)this.field1550.getFront(); var1 != null; var1 = (class115)this.field1550.getNext()) {
            var1.field1662 -= this.field1549;
         }

         this.field1552 -= this.field1549;
         this.field1549 = 0;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ldz;)V"
   )
   public final synchronized void method1937(class121 var1) {
      this.field1551.addTail(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "()Ldz;"
   )
   protected class121 vmethod3913() {
      return (class121)this.field1551.getFront();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ldo;)V"
   )
   void method1963(class115 var1) {
      var1.unlink();
      var1.method2171();
      Node var2 = this.field1550.head.next;
      if(var2 == this.field1550.head) {
         this.field1552 = -1;
      } else {
         this.field1552 = ((class115)var2).field1662;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ldz;)V"
   )
   public final synchronized void method1938(class121 var1) {
      var1.unlink();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgm;Ldo;)V"
   )
   void method1940(Node var1, class115 var2) {
      while(this.field1550.head != var1 && ((class115)var1).field1662 <= var2.field1662) {
         var1 = var1.next;
      }

      Deque.method3619(var2, var1);
      this.field1552 = ((class115)this.field1550.head.next).field1662;
   }

   @ObfuscatedName("t")
   protected int vmethod3916() {
      return 0;
   }
}
