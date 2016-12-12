import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ag")
public class class51 extends class68 {
   @ObfuscatedName("k")
   int field974 = -1;
   @ObfuscatedName("e")
   Deque field975 = new Deque();
   @ObfuscatedName("i")
   Deque field976 = new Deque();
   @ObfuscatedName("f")
   int field977 = 0;

   @ObfuscatedName("k")
   void method881(Node var1, class61 var2) {
      while(var1 != this.field975.head && ((class61)var1).field1087 <= var2.field1087) {
         var1 = var1.next;
      }

      Deque.method2356(var2, var1);
      this.field974 = ((class61)this.field975.head.next).field1087;
   }

   @ObfuscatedName("i")
   public final synchronized void method882(class68 var1) {
      this.field976.method2355(var1);
   }

   @ObfuscatedName("f")
   void method884() {
      if(this.field977 > 0) {
         for(class61 var1 = (class61)this.field975.method2359(); var1 != null; var1 = (class61)this.field975.method2361()) {
            var1.field1087 -= this.field977;
         }

         this.field974 -= this.field977;
         this.field977 = 0;
      }

   }

   @ObfuscatedName("q")
   protected class68 vmethod2666() {
      return (class68)this.field976.method2359();
   }

   @ObfuscatedName("a")
   void method886(class61 var1) {
      var1.unlink();
      var1.method1127();
      Node var2 = this.field975.head.next;
      if(var2 == this.field975.head) {
         this.field974 = -1;
      } else {
         this.field974 = ((class61)var2).field1087;
      }

   }

   @ObfuscatedName("w")
   protected class68 vmethod2658() {
      return (class68)this.field976.method2361();
   }

   @ObfuscatedName("v")
   protected int vmethod2649() {
      return 0;
   }

   @ObfuscatedName("h")
   public final synchronized void vmethod2665(int[] var1, int var2, int var3) {
      do {
         if(this.field974 < 0) {
            this.method891(var1, var2, var3);
            return;
         }

         if(this.field977 + var3 < this.field974) {
            this.field977 += var3;
            this.method891(var1, var2, var3);
            return;
         }

         int var4 = this.field974 - this.field977;
         this.method891(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field977 += var4;
         this.method884();
         class61 var5 = (class61)this.field975.method2359();
         synchronized(var5) {
            int var7 = var5.method1125(this);
            if(var7 < 0) {
               var5.field1087 = 0;
               this.method886(var5);
            } else {
               var5.field1087 = var7;
               this.method881(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("p")
   void method891(int[] var1, int var2, int var3) {
      for(class68 var4 = (class68)this.field976.method2359(); var4 != null; var4 = (class68)this.field976.method2361()) {
         var4.method1323(var1, var2, var3);
      }

   }

   @ObfuscatedName("l")
   public final synchronized void vmethod2651(int var1) {
      do {
         if(this.field974 < 0) {
            this.method893(var1);
            return;
         }

         if(this.field977 + var1 < this.field974) {
            this.field977 += var1;
            this.method893(var1);
            return;
         }

         int var2 = this.field974 - this.field977;
         this.method893(var2);
         var1 -= var2;
         this.field977 += var2;
         this.method884();
         class61 var3 = (class61)this.field975.method2359();
         synchronized(var3) {
            int var5 = var3.method1125(this);
            if(var5 < 0) {
               var3.field1087 = 0;
               this.method886(var3);
            } else {
               var3.field1087 = var5;
               this.method881(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("c")
   void method893(int var1) {
      for(class68 var2 = (class68)this.field976.method2359(); var2 != null; var2 = (class68)this.field976.method2361()) {
         var2.vmethod2651(var1);
      }

   }

   @ObfuscatedName("e")
   public final synchronized void method911(class68 var1) {
      var1.unlink();
   }
}
