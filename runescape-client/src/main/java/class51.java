import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("an")
public class class51 extends class68 {
   @ObfuscatedName("r")
   int field975 = -1;
   @ObfuscatedName("y")
   Deque field976 = new Deque();
   @ObfuscatedName("o")
   int field977 = 0;
   @ObfuscatedName("k")
   Deque field978 = new Deque();

   @ObfuscatedName("k")
   public final synchronized void method918(class68 var1) {
      this.field978.method2381(var1);
   }

   @ObfuscatedName("y")
   public final synchronized void method919(class68 var1) {
      var1.unlink();
   }

   @ObfuscatedName("r")
   void method921(Node var1, class62 var2) {
      while(var1 != this.field976.head && ((class62)var1).field1088 <= var2.field1088) {
         var1 = var1.next;
      }

      Deque.method2382(var2, var1);
      this.field975 = ((class62)this.field976.head.next).field1088;
   }

   @ObfuscatedName("w")
   void method922(class62 var1) {
      var1.unlink();
      var1.method1161();
      Node var2 = this.field976.head.next;
      if(var2 == this.field976.head) {
         this.field975 = -1;
      } else {
         this.field975 = ((class62)var2).field1088;
      }

   }

   @ObfuscatedName("j")
   protected class68 vmethod2708() {
      return (class68)this.field978.method2403();
   }

   @ObfuscatedName("c")
   protected class68 vmethod2687() {
      return (class68)this.field978.method2398();
   }

   @ObfuscatedName("g")
   protected int vmethod2688() {
      return 0;
   }

   @ObfuscatedName("o")
   void method926() {
      if(this.field977 > 0) {
         for(class62 var1 = (class62)this.field976.method2403(); var1 != null; var1 = (class62)this.field976.method2398()) {
            var1.field1088 -= this.field977;
         }

         this.field975 -= this.field977;
         this.field977 = 0;
      }

   }

   @ObfuscatedName("h")
   void method929(int var1) {
      for(class68 var2 = (class68)this.field978.method2403(); var2 != null; var2 = (class68)this.field978.method2398()) {
         var2.vmethod2690(var1);
      }

   }

   @ObfuscatedName("i")
   public final synchronized void vmethod2689(int[] var1, int var2, int var3) {
      do {
         if(this.field975 < 0) {
            this.method956(var1, var2, var3);
            return;
         }

         if(this.field977 + var3 < this.field975) {
            this.field977 += var3;
            this.method956(var1, var2, var3);
            return;
         }

         int var4 = this.field975 - this.field977;
         this.method956(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field977 += var4;
         this.method926();
         class62 var5 = (class62)this.field976.method2403();
         synchronized(var5) {
            int var7 = var5.method1162(this);
            if(var7 < 0) {
               var5.field1088 = 0;
               this.method922(var5);
            } else {
               var5.field1088 = var7;
               this.method921(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("a")
   public final synchronized void vmethod2690(int var1) {
      do {
         if(this.field975 < 0) {
            this.method929(var1);
            return;
         }

         if(this.field977 + var1 < this.field975) {
            this.field977 += var1;
            this.method929(var1);
            return;
         }

         int var2 = this.field975 - this.field977;
         this.method929(var2);
         var1 -= var2;
         this.field977 += var2;
         this.method926();
         class62 var3 = (class62)this.field976.method2403();
         synchronized(var3) {
            int var5 = var3.method1162(this);
            if(var5 < 0) {
               var3.field1088 = 0;
               this.method922(var3);
            } else {
               var3.field1088 = var5;
               this.method921(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("v")
   void method956(int[] var1, int var2, int var3) {
      for(class68 var4 = (class68)this.field978.method2403(); var4 != null; var4 = (class68)this.field978.method2398()) {
         var4.method1355(var1, var2, var3);
      }

   }
}
