import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cv")
public class class102 extends class119 {
   @ObfuscatedName("i")
   Deque field1553;
   @ObfuscatedName("u")
   int field1554;
   @ObfuscatedName("h")
   Deque field1555;
   @ObfuscatedName("q")
   int field1556;

   @ObfuscatedName("h")
   public final synchronized void method1910(class119 var1) {
      var1.unlink();
   }

   @ObfuscatedName("u")
   void method1911() {
      if(this.field1554 > 0) {
         for(class113 var1 = (class113)this.field1555.method3660(); var1 != null; var1 = (class113)this.field1555.method3661()) {
            var1.field1661 -= this.field1554;
         }

         this.field1556 -= this.field1554;
         this.field1554 = 0;
      }

   }

   @ObfuscatedName("k")
   public final synchronized void vmethod3969(int var1) {
      do {
         if(this.field1556 < 0) {
            this.method1920(var1);
            return;
         }

         if(this.field1554 + var1 < this.field1556) {
            this.field1554 += var1;
            this.method1920(var1);
            return;
         }

         int var2 = this.field1556 - this.field1554;
         this.method1920(var2);
         var1 -= var2;
         this.field1554 += var2;
         this.method1911();
         class113 var3 = (class113)this.field1555.method3660();
         synchronized(var3) {
            int var5 = var3.method2133(this);
            if(var5 < 0) {
               var3.field1661 = 0;
               this.method1913(var3);
            } else {
               var3.field1661 = var5;
               this.method1940(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("g")
   void method1913(class113 var1) {
      var1.unlink();
      var1.method2132();
      Node var2 = this.field1555.head.next;
      if(var2 == this.field1555.head) {
         this.field1556 = -1;
      } else {
         this.field1556 = ((class113)var2).field1661;
      }

   }

   @ObfuscatedName("t")
   protected class119 vmethod3945() {
      return (class119)this.field1553.method3661();
   }

   @ObfuscatedName("p")
   protected int vmethod3946() {
      return 0;
   }

   @ObfuscatedName("l")
   public final synchronized void vmethod3949(int[] var1, int var2, int var3) {
      do {
         if(this.field1556 < 0) {
            this.method1922(var1, var2, var3);
            return;
         }

         if(this.field1554 + var3 < this.field1556) {
            this.field1554 += var3;
            this.method1922(var1, var2, var3);
            return;
         }

         int var4 = this.field1556 - this.field1554;
         this.method1922(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1554 += var4;
         this.method1911();
         class113 var5 = (class113)this.field1555.method3660();
         synchronized(var5) {
            int var7 = var5.method2133(this);
            if(var7 < 0) {
               var5.field1661 = 0;
               this.method1913(var5);
            } else {
               var5.field1661 = var7;
               this.method1940(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("b")
   void method1920(int var1) {
      for(class119 var2 = (class119)this.field1553.method3660(); var2 != null; var2 = (class119)this.field1553.method3661()) {
         var2.vmethod3969(var1);
      }

   }

   @ObfuscatedName("a")
   void method1922(int[] var1, int var2, int var3) {
      for(class119 var4 = (class119)this.field1553.method3660(); var4 != null; var4 = (class119)this.field1553.method3661()) {
         var4.method2330(var1, var2, var3);
      }

   }

   @ObfuscatedName("i")
   public final synchronized void method1936(class119 var1) {
      this.field1553.method3686(var1);
   }

   @ObfuscatedName("v")
   protected class119 vmethod3944() {
      return (class119)this.field1553.method3660();
   }

   @ObfuscatedName("q")
   void method1940(Node var1, class113 var2) {
      while(var1 != this.field1555.head && ((class113)var1).field1661 <= var2.field1661) {
         var1 = var1.next;
      }

      Deque.method3673(var2, var1);
      this.field1556 = ((class113)this.field1555.head.next).field1661;
   }

   public class102() {
      this.field1553 = new Deque();
      this.field1555 = new Deque();
      this.field1554 = 0;
      this.field1556 = -1;
   }
}
