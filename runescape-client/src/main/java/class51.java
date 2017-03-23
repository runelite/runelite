import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("af")
public class class51 extends class68 {
   @ObfuscatedName("u")
   int field996 = 0;
   @ObfuscatedName("i")
   Deque field997 = new Deque();
   @ObfuscatedName("f")
   Deque field998 = new Deque();
   @ObfuscatedName("h")
   int field999 = -1;

   @ObfuscatedName("f")
   public final synchronized void method942(class68 var1) {
      this.field998.method2460(var1);
   }

   @ObfuscatedName("i")
   public final synchronized void method943(class68 var1) {
      var1.unlink();
   }

   @ObfuscatedName("r")
   void method945(Node var1, class61 var2) {
      while(var1 != this.field997.head && ((class61)var1).field1111 <= var2.field1111) {
         var1 = var1.next;
      }

      Deque.method2457(var2, var1);
      this.field999 = ((class61)this.field997.head.next).field1111;
   }

   @ObfuscatedName("o")
   void method946(class61 var1) {
      var1.unlink();
      var1.method1184();
      Node var2 = this.field997.head.next;
      if(var2 == this.field997.head) {
         this.field999 = -1;
      } else {
         this.field999 = ((class61)var2).field1111;
      }

   }

   @ObfuscatedName("j")
   void method949(int[] var1, int var2, int var3) {
      for(class68 var4 = (class68)this.field998.method2464(); var4 != null; var4 = (class68)this.field998.method2472()) {
         var4.method1378(var1, var2, var3);
      }

   }

   @ObfuscatedName("n")
   protected class68 vmethod2753() {
      return (class68)this.field998.method2472();
   }

   @ObfuscatedName("s")
   public final synchronized void vmethod2756(int var1) {
      do {
         if(this.field999 < 0) {
            this.method981(var1);
            return;
         }

         if(this.field996 + var1 < this.field999) {
            this.field996 += var1;
            this.method981(var1);
            return;
         }

         int var2 = this.field999 - this.field996;
         this.method981(var2);
         var1 -= var2;
         this.field996 += var2;
         this.method975();
         class61 var3 = (class61)this.field997.method2464();
         synchronized(var3) {
            int var5 = var3.method1183(this);
            if(var5 < 0) {
               var3.field1111 = 0;
               this.method946(var3);
            } else {
               var3.field1111 = var5;
               this.method945(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("w")
   public final synchronized void vmethod2755(int[] var1, int var2, int var3) {
      do {
         if(this.field999 < 0) {
            this.method949(var1, var2, var3);
            return;
         }

         if(this.field996 + var3 < this.field999) {
            this.field996 += var3;
            this.method949(var1, var2, var3);
            return;
         }

         int var4 = this.field999 - this.field996;
         this.method949(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field996 += var4;
         this.method975();
         class61 var5 = (class61)this.field997.method2464();
         synchronized(var5) {
            int var7 = var5.method1183(this);
            if(var7 < 0) {
               var5.field1111 = 0;
               this.method946(var5);
            } else {
               var5.field1111 = var7;
               this.method945(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("l")
   protected class68 vmethod2768() {
      return (class68)this.field998.method2464();
   }

   @ObfuscatedName("u")
   void method975() {
      if(this.field996 > 0) {
         for(class61 var1 = (class61)this.field997.method2464(); var1 != null; var1 = (class61)this.field997.method2472()) {
            var1.field1111 -= this.field996;
         }

         this.field999 -= this.field996;
         this.field996 = 0;
      }

   }

   @ObfuscatedName("q")
   void method981(int var1) {
      for(class68 var2 = (class68)this.field998.method2464(); var2 != null; var2 = (class68)this.field998.method2472()) {
         var2.vmethod2756(var1);
      }

   }

   @ObfuscatedName("m")
   protected int vmethod2766() {
      return 0;
   }
}
