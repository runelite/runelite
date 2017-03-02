import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("aq")
public class class51 extends class68 {
   @ObfuscatedName("t")
   int field960 = -1;
   @ObfuscatedName("l")
   Deque field961 = new Deque();
   @ObfuscatedName("i")
   int field962 = 0;
   @ObfuscatedName("b")
   Deque field963 = new Deque();

   @ObfuscatedName("b")
   public final synchronized void method993(class68 var1) {
      this.field963.method2470(var1);
   }

   @ObfuscatedName("l")
   public final synchronized void method994(class68 var1) {
      var1.unlink();
   }

   @ObfuscatedName("i")
   void method995() {
      if(this.field962 > 0) {
         for(class61 var1 = (class61)this.field961.method2472(); var1 != null; var1 = (class61)this.field961.method2479()) {
            var1.field1071 -= this.field962;
         }

         this.field960 -= this.field962;
         this.field962 = 0;
      }

   }

   @ObfuscatedName("t")
   void method997(Node var1, class61 var2) {
      while(var1 != this.field961.head && ((class61)var1).field1071 <= var2.field1071) {
         var1 = var1.next;
      }

      Deque.method2469(var2, var1);
      this.field960 = ((class61)this.field961.head.next).field1071;
   }

   @ObfuscatedName("z")
   protected class68 vmethod2746() {
      return (class68)this.field963.method2479();
   }

   @ObfuscatedName("p")
   protected int vmethod2763() {
      return 0;
   }

   @ObfuscatedName("o")
   void method1002(int[] var1, int var2, int var3) {
      for(class68 var4 = (class68)this.field963.method2472(); var4 != null; var4 = (class68)this.field963.method2479()) {
         var4.method1401(var1, var2, var3);
      }

   }

   @ObfuscatedName("y")
   public final synchronized void vmethod2748(int var1) {
      do {
         if(this.field960 < 0) {
            this.method1026(var1);
            return;
         }

         if(this.field962 + var1 < this.field960) {
            this.field962 += var1;
            this.method1026(var1);
            return;
         }

         int var2 = this.field960 - this.field962;
         this.method1026(var2);
         var1 -= var2;
         this.field962 += var2;
         this.method995();
         class61 var3 = (class61)this.field961.method2472();
         synchronized(var3) {
            int var5 = var3.method1211(this);
            if(var5 < 0) {
               var3.field1071 = 0;
               this.method1021(var3);
            } else {
               var3.field1071 = var5;
               this.method997(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("s")
   public final synchronized void vmethod2747(int[] var1, int var2, int var3) {
      do {
         if(this.field960 < 0) {
            this.method1002(var1, var2, var3);
            return;
         }

         if(this.field962 + var3 < this.field960) {
            this.field962 += var3;
            this.method1002(var1, var2, var3);
            return;
         }

         int var4 = this.field960 - this.field962;
         this.method1002(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field962 += var4;
         this.method995();
         class61 var5 = (class61)this.field961.method2472();
         synchronized(var5) {
            int var7 = var5.method1211(this);
            if(var7 < 0) {
               var5.field1071 = 0;
               this.method1021(var5);
            } else {
               var5.field1071 = var7;
               this.method997(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("k")
   void method1021(class61 var1) {
      var1.unlink();
      var1.method1209();
      Node var2 = this.field961.head.next;
      if(var2 == this.field961.head) {
         this.field960 = -1;
      } else {
         this.field960 = ((class61)var2).field1071;
      }

   }

   @ObfuscatedName("x")
   protected class68 vmethod2744() {
      return (class68)this.field963.method2472();
   }

   @ObfuscatedName("w")
   void method1026(int var1) {
      for(class68 var2 = (class68)this.field963.method2472(); var2 != null; var2 = (class68)this.field963.method2479()) {
         var2.vmethod2748(var1);
      }

   }
}
