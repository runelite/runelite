import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("as")
public class class51 extends class68 {
   @ObfuscatedName("q")
   int field975 = -1;
   @ObfuscatedName("p")
   Deque field976 = new Deque();
   @ObfuscatedName("x")
   int field977 = 0;
   @ObfuscatedName("g")
   Deque field978 = new Deque();

   @ObfuscatedName("p")
   public final synchronized void method898(class68 var1) {
      this.field976.method2408(var1);
   }

   @ObfuscatedName("g")
   public final synchronized void method899(class68 var1) {
      var1.unlink();
   }

   @ObfuscatedName("x")
   void method900() {
      if(this.field977 > 0) {
         for(class61 var1 = (class61)this.field978.method2412(); var1 != null; var1 = (class61)this.field978.method2426()) {
            var1.field1090 -= this.field977;
         }

         this.field975 -= this.field977;
         this.field977 = 0;
      }

   }

   @ObfuscatedName("q")
   void method901(Node var1, class61 var2) {
      while(var1 != this.field978.head && ((class61)var1).field1090 <= var2.field1090) {
         var1 = var1.next;
      }

      Deque.method2409(var2, var1);
      this.field975 = ((class61)this.field978.head.next).field1090;
   }

   @ObfuscatedName("d")
   void method902(class61 var1) {
      var1.unlink();
      var1.method1124();
      Node var2 = this.field978.head.next;
      if(var2 == this.field978.head) {
         this.field975 = -1;
      } else {
         this.field975 = ((class61)var2).field1090;
      }

   }

   @ObfuscatedName("k")
   protected class68 vmethod2701() {
      return (class68)this.field976.method2412();
   }

   @ObfuscatedName("j")
   protected class68 vmethod2702() {
      return (class68)this.field976.method2426();
   }

   @ObfuscatedName("s")
   protected int vmethod2703() {
      return 0;
   }

   @ObfuscatedName("o")
   public final synchronized void vmethod2704(int[] var1, int var2, int var3) {
      do {
         if(this.field975 < 0) {
            this.method907(var1, var2, var3);
            return;
         }

         if(this.field977 + var3 < this.field975) {
            this.field977 += var3;
            this.method907(var1, var2, var3);
            return;
         }

         int var4 = this.field975 - this.field977;
         this.method907(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field977 += var4;
         this.method900();
         class61 var5 = (class61)this.field978.method2412();
         synchronized(var5) {
            int var7 = var5.method1125(this);
            if(var7 < 0) {
               var5.field1090 = 0;
               this.method902(var5);
            } else {
               var5.field1090 = var7;
               this.method901(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("a")
   void method907(int[] var1, int var2, int var3) {
      for(class68 var4 = (class68)this.field976.method2412(); var4 != null; var4 = (class68)this.field976.method2426()) {
         var4.method1330(var1, var2, var3);
      }

   }

   @ObfuscatedName("u")
   void method909(int var1) {
      for(class68 var2 = (class68)this.field976.method2412(); var2 != null; var2 = (class68)this.field976.method2426()) {
         var2.vmethod2705(var1);
      }

   }

   @ObfuscatedName("c")
   public final synchronized void vmethod2705(int var1) {
      do {
         if(this.field975 < 0) {
            this.method909(var1);
            return;
         }

         if(this.field977 + var1 < this.field975) {
            this.field977 += var1;
            this.method909(var1);
            return;
         }

         int var2 = this.field975 - this.field977;
         this.method909(var2);
         var1 -= var2;
         this.field977 += var2;
         this.method900();
         class61 var3 = (class61)this.field978.method2412();
         synchronized(var3) {
            int var5 = var3.method1125(this);
            if(var5 < 0) {
               var3.field1090 = 0;
               this.method902(var3);
            } else {
               var3.field1090 = var5;
               this.method901(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }
}
