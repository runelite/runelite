import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ax")
public class class51 extends class68 {
   @ObfuscatedName("q")
   Deque field995 = new Deque();
   @ObfuscatedName("d")
   Deque field996 = new Deque();
   @ObfuscatedName("h")
   int field997 = 0;
   @ObfuscatedName("p")
   int field998 = -1;

   @ObfuscatedName("q")
   public final synchronized void method985(class68 var1) {
      this.field995.method2454(var1);
   }

   @ObfuscatedName("h")
   void method987() {
      if(this.field997 > 0) {
         for(class61 var1 = (class61)this.field996.method2458(); var1 != null; var1 = (class61)this.field996.method2472()) {
            var1.field1103 -= this.field997;
         }

         this.field998 -= this.field997;
         this.field997 = 0;
      }

   }

   @ObfuscatedName("j")
   void method989(class61 var1) {
      var1.unlink();
      var1.method1206();
      Node var2 = this.field996.head.next;
      if(var2 == this.field996.head) {
         this.field998 = -1;
      } else {
         this.field998 = ((class61)var2).field1103;
      }

   }

   @ObfuscatedName("d")
   public final synchronized void method990(class68 var1) {
      var1.unlink();
   }

   @ObfuscatedName("c")
   protected class68 vmethod2717() {
      return (class68)this.field995.method2472();
   }

   @ObfuscatedName("s")
   public final synchronized void vmethod2718(int[] var1, int var2, int var3) {
      do {
         if(this.field998 < 0) {
            this.method994(var1, var2, var3);
            return;
         }

         if(this.field997 + var3 < this.field998) {
            this.field997 += var3;
            this.method994(var1, var2, var3);
            return;
         }

         int var4 = this.field998 - this.field997;
         this.method994(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field997 += var4;
         this.method987();
         class61 var5 = (class61)this.field996.method2458();
         synchronized(var5) {
            int var7 = var5.method1207(this);
            if(var7 < 0) {
               var5.field1103 = 0;
               this.method989(var5);
            } else {
               var5.field1103 = var7;
               this.method998(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("u")
   void method994(int[] var1, int var2, int var3) {
      for(class68 var4 = (class68)this.field995.method2458(); var4 != null; var4 = (class68)this.field995.method2472()) {
         var4.method1402(var1, var2, var3);
      }

   }

   @ObfuscatedName("b")
   public final synchronized void vmethod2719(int var1) {
      do {
         if(this.field998 < 0) {
            this.method996(var1);
            return;
         }

         if(this.field997 + var1 < this.field998) {
            this.field997 += var1;
            this.method996(var1);
            return;
         }

         int var2 = this.field998 - this.field997;
         this.method996(var2);
         var1 -= var2;
         this.field997 += var2;
         this.method987();
         class61 var3 = (class61)this.field996.method2458();
         synchronized(var3) {
            int var5 = var3.method1207(this);
            if(var5 < 0) {
               var3.field1103 = 0;
               this.method989(var3);
            } else {
               var3.field1103 = var5;
               this.method998(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("v")
   void method996(int var1) {
      for(class68 var2 = (class68)this.field995.method2458(); var2 != null; var2 = (class68)this.field995.method2472()) {
         var2.vmethod2719(var1);
      }

   }

   @ObfuscatedName("p")
   void method998(Node var1, class61 var2) {
      while(var1 != this.field996.head && ((class61)var1).field1103 <= var2.field1103) {
         var1 = var1.next;
      }

      Deque.method2455(var2, var1);
      this.field998 = ((class61)this.field996.head.next).field1103;
   }

   @ObfuscatedName("n")
   protected class68 vmethod2734() {
      return (class68)this.field995.method2458();
   }

   @ObfuscatedName("o")
   protected int vmethod2716() {
      return 0;
   }
}
