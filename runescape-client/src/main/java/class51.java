import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ad")
public class class51 extends class68 {
   @ObfuscatedName("g")
   int field973 = -1;
   @ObfuscatedName("m")
   Deque field974 = new Deque();
   @ObfuscatedName("o")
   Deque field975 = new Deque();
   @ObfuscatedName("b")
   int field976 = 0;

   @ObfuscatedName("o")
   public final synchronized void method898(class68 var1) {
      this.field975.method2345(var1);
   }

   @ObfuscatedName("f")
   void method899(int var1) {
      for(class68 var2 = (class68)this.field975.method2349(); var2 != null; var2 = (class68)this.field975.method2351()) {
         var2.vmethod2629(var1);
      }

   }

   @ObfuscatedName("c")
   protected class68 vmethod2625() {
      return (class68)this.field975.method2349();
   }

   @ObfuscatedName("u")
   protected class68 vmethod2626() {
      return (class68)this.field975.method2351();
   }

   @ObfuscatedName("k")
   protected int vmethod2624() {
      return 0;
   }

   @ObfuscatedName("z")
   public final synchronized void vmethod2628(int[] var1, int var2, int var3) {
      do {
         if(this.field973 < 0) {
            this.method906(var1, var2, var3);
            return;
         }

         if(this.field976 + var3 < this.field973) {
            this.field976 += var3;
            this.method906(var1, var2, var3);
            return;
         }

         int var4 = this.field973 - this.field976;
         this.method906(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field976 += var4;
         this.method926();
         class61 var5 = (class61)this.field974.method2349();
         synchronized(var5) {
            int var7 = var5.method1139(this);
            if(var7 < 0) {
               var5.field1086 = 0;
               this.method927(var5);
            } else {
               var5.field1086 = var7;
               this.method921(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("y")
   void method906(int[] var1, int var2, int var3) {
      for(class68 var4 = (class68)this.field975.method2349(); var4 != null; var4 = (class68)this.field975.method2351()) {
         var4.method1327(var1, var2, var3);
      }

   }

   @ObfuscatedName("j")
   public final synchronized void vmethod2629(int var1) {
      do {
         if(this.field973 < 0) {
            this.method899(var1);
            return;
         }

         if(this.field976 + var1 < this.field973) {
            this.field976 += var1;
            this.method899(var1);
            return;
         }

         int var2 = this.field973 - this.field976;
         this.method899(var2);
         var1 -= var2;
         this.field976 += var2;
         this.method926();
         class61 var3 = (class61)this.field974.method2349();
         synchronized(var3) {
            int var5 = var3.method1139(this);
            if(var5 < 0) {
               var3.field1086 = 0;
               this.method927(var3);
            } else {
               var3.field1086 = var5;
               this.method921(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("g")
   void method921(Node var1, class61 var2) {
      while(var1 != this.field974.head && ((class61)var1).field1086 <= var2.field1086) {
         var1 = var1.next;
      }

      Deque.method2346(var2, var1);
      this.field973 = ((class61)this.field974.head.next).field1086;
   }

   @ObfuscatedName("m")
   public final synchronized void method923(class68 var1) {
      var1.unlink();
   }

   @ObfuscatedName("b")
   void method926() {
      if(this.field976 > 0) {
         for(class61 var1 = (class61)this.field974.method2349(); var1 != null; var1 = (class61)this.field974.method2351()) {
            var1.field1086 -= this.field976;
         }

         this.field973 -= this.field976;
         this.field976 = 0;
      }

   }

   @ObfuscatedName("l")
   void method927(class61 var1) {
      var1.unlink();
      var1.method1136();
      Node var2 = this.field974.head.next;
      if(var2 == this.field974.head) {
         this.field973 = -1;
      } else {
         this.field973 = ((class61)var2).field1086;
      }

   }
}
