import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("au")
public class class51 extends class68 {
   @ObfuscatedName("a")
   int field966 = -1;
   @ObfuscatedName("x")
   Deque field967 = new Deque();
   @ObfuscatedName("i")
   int field968 = 0;
   @ObfuscatedName("u")
   Deque field969 = new Deque();

   @ObfuscatedName("u")
   public final synchronized void method889(class68 var1) {
      this.field969.method2387(var1);
   }

   @ObfuscatedName("i")
   void method891() {
      if(this.field968 > 0) {
         for(class61 var1 = (class61)this.field967.method2391(); var1 != null; var1 = (class61)this.field967.method2393()) {
            var1.field1084 -= this.field968;
         }

         this.field966 -= this.field968;
         this.field968 = 0;
      }

   }

   @ObfuscatedName("a")
   void method892(Node var1, class61 var2) {
      while(var1 != this.field967.head && ((class61)var1).field1084 <= var2.field1084) {
         var1 = var1.next;
      }

      Deque.method2407(var2, var1);
      this.field966 = ((class61)this.field967.head.next).field1084;
   }

   @ObfuscatedName("c")
   void method893(class61 var1) {
      var1.unlink();
      var1.method1105();
      Node var2 = this.field967.head.next;
      if(var2 == this.field967.head) {
         this.field966 = -1;
      } else {
         this.field966 = ((class61)var2).field1084;
      }

   }

   @ObfuscatedName("g")
   protected class68 vmethod2671() {
      return (class68)this.field969.method2391();
   }

   @ObfuscatedName("q")
   void method898(int[] var1, int var2, int var3) {
      for(class68 var4 = (class68)this.field969.method2391(); var4 != null; var4 = (class68)this.field969.method2393()) {
         var4.method1308(var1, var2, var3);
      }

   }

   @ObfuscatedName("v")
   void method900(int var1) {
      for(class68 var2 = (class68)this.field969.method2391(); var2 != null; var2 = (class68)this.field969.method2393()) {
         var2.vmethod2675(var1);
      }

   }

   @ObfuscatedName("e")
   public final synchronized void vmethod2675(int var1) {
      do {
         if(this.field966 < 0) {
            this.method900(var1);
            return;
         }

         if(this.field968 + var1 < this.field966) {
            this.field968 += var1;
            this.method900(var1);
            return;
         }

         int var2 = this.field966 - this.field968;
         this.method900(var2);
         var1 -= var2;
         this.field968 += var2;
         this.method891();
         class61 var3 = (class61)this.field967.method2391();
         synchronized(var3) {
            int var5 = var3.method1100(this);
            if(var5 < 0) {
               var3.field1084 = 0;
               this.method893(var3);
            } else {
               var3.field1084 = var5;
               this.method892(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("x")
   public final synchronized void method903(class68 var1) {
      var1.unlink();
   }

   @ObfuscatedName("t")
   protected int vmethod2673() {
      return 0;
   }

   @ObfuscatedName("z")
   protected class68 vmethod2672() {
      return (class68)this.field969.method2393();
   }

   @ObfuscatedName("m")
   public final synchronized void vmethod2674(int[] var1, int var2, int var3) {
      do {
         if(this.field966 < 0) {
            this.method898(var1, var2, var3);
            return;
         }

         if(this.field968 + var3 < this.field966) {
            this.field968 += var3;
            this.method898(var1, var2, var3);
            return;
         }

         int var4 = this.field966 - this.field968;
         this.method898(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field968 += var4;
         this.method891();
         class61 var5 = (class61)this.field967.method2391();
         synchronized(var5) {
            int var7 = var5.method1100(this);
            if(var7 < 0) {
               var5.field1084 = 0;
               this.method893(var5);
            } else {
               var5.field1084 = var7;
               this.method892(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }
}
