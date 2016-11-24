import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ao")
public class class51 extends class68 {
   @ObfuscatedName("h")
   int field965 = -1;
   @ObfuscatedName("d")
   Deque field966 = new Deque();
   @ObfuscatedName("m")
   int field967 = 0;
   @ObfuscatedName("n")
   Deque field968 = new Deque();

   @ObfuscatedName("n")
   public final synchronized void method914(class68 var1) {
      this.field968.method2455(var1);
   }

   @ObfuscatedName("d")
   public final synchronized void method915(class68 var1) {
      var1.unlink();
   }

   @ObfuscatedName("m")
   void method916() {
      if(this.field967 > 0) {
         for(class62 var1 = (class62)this.field966.method2466(); var1 != null; var1 = (class62)this.field966.method2461()) {
            var1.field1078 -= this.field967;
         }

         this.field965 -= this.field967;
         this.field967 = 0;
      }

   }

   @ObfuscatedName("h")
   void method917(Node var1, class62 var2) {
      while(var1 != this.field966.head && ((class62)var1).field1078 <= var2.field1078) {
         var1 = var1.next;
      }

      Deque.method2456(var2, var1);
      this.field965 = ((class62)this.field966.head.next).field1078;
   }

   @ObfuscatedName("r")
   protected class68 vmethod2748() {
      return (class68)this.field968.method2466();
   }

   @ObfuscatedName("z")
   protected int vmethod2751() {
      return 0;
   }

   @ObfuscatedName("l")
   void method922(int[] var1, int var2, int var3) {
      for(class68 var4 = (class68)this.field968.method2466(); var4 != null; var4 = (class68)this.field968.method2461()) {
         var4.method1374(var1, var2, var3);
      }

   }

   @ObfuscatedName("w")
   void method923(class62 var1) {
      var1.unlink();
      var1.method1143();
      Node var2 = this.field966.head.next;
      if(var2 == this.field966.head) {
         this.field965 = -1;
      } else {
         this.field965 = ((class62)var2).field1078;
      }

   }

   @ObfuscatedName("e")
   void method924(int var1) {
      for(class68 var2 = (class68)this.field968.method2466(); var2 != null; var2 = (class68)this.field968.method2461()) {
         var2.vmethod2752(var1);
      }

   }

   @ObfuscatedName("y")
   public final synchronized void vmethod2752(int var1) {
      do {
         if(this.field965 < 0) {
            this.method924(var1);
            return;
         }

         if(this.field967 + var1 < this.field965) {
            this.field967 += var1;
            this.method924(var1);
            return;
         }

         int var2 = this.field965 - this.field967;
         this.method924(var2);
         var1 -= var2;
         this.field967 += var2;
         this.method916();
         class62 var3 = (class62)this.field966.method2466();
         synchronized(var3) {
            int var5 = var3.method1144(this);
            if(var5 < 0) {
               var3.field1078 = 0;
               this.method923(var3);
            } else {
               var3.field1078 = var5;
               this.method917(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("q")
   public final synchronized void vmethod2764(int[] var1, int var2, int var3) {
      do {
         if(this.field965 < 0) {
            this.method922(var1, var2, var3);
            return;
         }

         if(this.field967 + var3 < this.field965) {
            this.field967 += var3;
            this.method922(var1, var2, var3);
            return;
         }

         int var4 = this.field965 - this.field967;
         this.method922(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field967 += var4;
         this.method916();
         class62 var5 = (class62)this.field966.method2466();
         synchronized(var5) {
            int var7 = var5.method1144(this);
            if(var7 < 0) {
               var5.field1078 = 0;
               this.method923(var5);
            } else {
               var5.field1078 = var7;
               this.method917(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("c")
   protected class68 vmethod2750() {
      return (class68)this.field968.method2461();
   }
}
