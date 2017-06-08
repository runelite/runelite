import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("co")
public class class102 extends class119 {
   @ObfuscatedName("n")
   Deque field1564;
   @ObfuscatedName("p")
   Deque field1565;
   @ObfuscatedName("i")
   int field1566;
   @ObfuscatedName("j")
   int field1567;

   @ObfuscatedName("n")
   public final synchronized void method1861(class119 var1) {
      this.field1564.method3603(var1);
   }

   @ObfuscatedName("p")
   public final synchronized void method1862(class119 var1) {
      var1.unlink();
   }

   @ObfuscatedName("i")
   void method1863() {
      if(this.field1566 > 0) {
         for(class113 var1 = (class113)this.field1565.method3622(); var1 != null; var1 = (class113)this.field1565.method3608()) {
            var1.field1679 -= this.field1566;
         }

         this.field1567 -= this.field1566;
         this.field1566 = 0;
      }

   }

   @ObfuscatedName("j")
   void method1864(Node var1, class113 var2) {
      while(var1 != this.field1565.head && ((class113)var1).field1679 <= var2.field1679) {
         var1 = var1.next;
      }

      Deque.method3600(var2, var1);
      this.field1567 = ((class113)this.field1565.head.next).field1679;
   }

   @ObfuscatedName("f")
   void method1865(class113 var1) {
      var1.unlink();
      var1.method2095();
      Node var2 = this.field1565.head.next;
      if(var2 == this.field1565.head) {
         this.field1567 = -1;
      } else {
         this.field1567 = ((class113)var2).field1679;
      }

   }

   @ObfuscatedName("z")
   protected int vmethod3908() {
      return 0;
   }

   @ObfuscatedName("c")
   protected class119 vmethod3907() {
      return (class119)this.field1564.method3608();
   }

   @ObfuscatedName("o")
   void method1869(int var1) {
      for(class119 var2 = (class119)this.field1564.method3622(); var2 != null; var2 = (class119)this.field1564.method3608()) {
         var2.vmethod3910(var1);
      }

   }

   @ObfuscatedName("g")
   void method1870(int[] var1, int var2, int var3) {
      for(class119 var4 = (class119)this.field1564.method3622(); var4 != null; var4 = (class119)this.field1564.method3608()) {
         var4.method2301(var1, var2, var3);
      }

   }

   @ObfuscatedName("e")
   public final synchronized void vmethod3910(int var1) {
      do {
         if(this.field1567 < 0) {
            this.method1869(var1);
            return;
         }

         if(this.field1566 + var1 < this.field1567) {
            this.field1566 += var1;
            this.method1869(var1);
            return;
         }

         int var2 = this.field1567 - this.field1566;
         this.method1869(var2);
         var1 -= var2;
         this.field1566 += var2;
         this.method1863();
         class113 var3 = (class113)this.field1565.method3622();
         synchronized(var3) {
            int var5 = var3.method2100(this);
            if(var5 < 0) {
               var3.field1679 = 0;
               this.method1865(var3);
            } else {
               var3.field1679 = var5;
               this.method1864(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   public class102() {
      this.field1564 = new Deque();
      this.field1565 = new Deque();
      this.field1566 = 0;
      this.field1567 = -1;
   }

   @ObfuscatedName("h")
   public final synchronized void vmethod3909(int[] var1, int var2, int var3) {
      do {
         if(this.field1567 < 0) {
            this.method1870(var1, var2, var3);
            return;
         }

         if(this.field1566 + var3 < this.field1567) {
            this.field1566 += var3;
            this.method1870(var1, var2, var3);
            return;
         }

         int var4 = this.field1567 - this.field1566;
         this.method1870(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1566 += var4;
         this.method1863();
         class113 var5 = (class113)this.field1565.method3622();
         synchronized(var5) {
            int var7 = var5.method2100(this);
            if(var7 < 0) {
               var5.field1679 = 0;
               this.method1865(var5);
            } else {
               var5.field1679 = var7;
               this.method1864(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("m")
   protected class119 vmethod3906() {
      return (class119)this.field1564.method3622();
   }
}
