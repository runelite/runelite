import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ak")
public class class51 extends class68 {
   @ObfuscatedName("n")
   Deque field985 = new Deque();
   @ObfuscatedName("x")
   Deque field986 = new Deque();
   @ObfuscatedName("g")
   int field987 = 0;
   @ObfuscatedName("v")
   int field988 = -1;

   @ObfuscatedName("n")
   public final synchronized void method1000(class68 var1) {
      var1.unlink();
   }

   @ObfuscatedName("v")
   void method1002(Node var1, class61 var2) {
      while(var1 != this.field985.head && ((class61)var1).field1098 <= var2.field1098) {
         var1 = var1.next;
      }

      Deque.method2487(var2, var1);
      this.field988 = ((class61)this.field985.head.next).field1098;
   }

   @ObfuscatedName("y")
   void method1003(class61 var1) {
      var1.unlink();
      var1.method1231();
      Node var2 = this.field985.head.next;
      if(var2 == this.field985.head) {
         this.field988 = -1;
      } else {
         this.field988 = ((class61)var2).field1098;
      }

   }

   @ObfuscatedName("p")
   protected class68 vmethod2765() {
      return (class68)this.field986.method2503();
   }

   @ObfuscatedName("j")
   protected class68 vmethod2775() {
      return (class68)this.field986.method2492();
   }

   @ObfuscatedName("s")
   protected int vmethod2767() {
      return 0;
   }

   @ObfuscatedName("k")
   public final synchronized void vmethod2780(int[] var1, int var2, int var3) {
      do {
         if(this.field988 < 0) {
            this.method1008(var1, var2, var3);
            return;
         }

         if(this.field987 + var3 < this.field988) {
            this.field987 += var3;
            this.method1008(var1, var2, var3);
            return;
         }

         int var4 = this.field988 - this.field987;
         this.method1008(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field987 += var4;
         this.method1017();
         class61 var5 = (class61)this.field985.method2503();
         synchronized(var5) {
            int var7 = var5.method1232(this);
            if(var7 < 0) {
               var5.field1098 = 0;
               this.method1003(var5);
            } else {
               var5.field1098 = var7;
               this.method1002(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("f")
   void method1008(int[] var1, int var2, int var3) {
      for(class68 var4 = (class68)this.field986.method2503(); var4 != null; var4 = (class68)this.field986.method2492()) {
         var4.method1446(var1, var2, var3);
      }

   }

   @ObfuscatedName("o")
   public final synchronized void vmethod2769(int var1) {
      do {
         if(this.field988 < 0) {
            this.method1012(var1);
            return;
         }

         if(this.field987 + var1 < this.field988) {
            this.field987 += var1;
            this.method1012(var1);
            return;
         }

         int var2 = this.field988 - this.field987;
         this.method1012(var2);
         var1 -= var2;
         this.field987 += var2;
         this.method1017();
         class61 var3 = (class61)this.field985.method2503();
         synchronized(var3) {
            int var5 = var3.method1232(this);
            if(var5 < 0) {
               var3.field1098 = 0;
               this.method1003(var3);
            } else {
               var3.field1098 = var5;
               this.method1002(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("q")
   void method1012(int var1) {
      for(class68 var2 = (class68)this.field986.method2503(); var2 != null; var2 = (class68)this.field986.method2492()) {
         var2.vmethod2769(var1);
      }

   }

   @ObfuscatedName("g")
   void method1017() {
      if(this.field987 > 0) {
         for(class61 var1 = (class61)this.field985.method2503(); var1 != null; var1 = (class61)this.field985.method2492()) {
            var1.field1098 -= this.field987;
         }

         this.field988 -= this.field987;
         this.field987 = 0;
      }

   }

   @ObfuscatedName("x")
   public final synchronized void method1024(class68 var1) {
      this.field986.method2500(var1);
   }
}
