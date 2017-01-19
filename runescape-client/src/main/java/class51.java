import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ab")
public class class51 extends class68 {
   @ObfuscatedName("h")
   int field971 = -1;
   @ObfuscatedName("c")
   Deque field972 = new Deque();
   @ObfuscatedName("f")
   int field973 = 0;
   @ObfuscatedName("s")
   Deque field974 = new Deque();

   @ObfuscatedName("s")
   public final synchronized void method868(class68 var1) {
      this.field974.method2326(var1);
   }

   @ObfuscatedName("c")
   public final synchronized void method869(class68 var1) {
      var1.unlink();
   }

   @ObfuscatedName("f")
   void method870() {
      if(this.field973 > 0) {
         for(class61 var1 = (class61)this.field972.method2330(); var1 != null; var1 = (class61)this.field972.method2346()) {
            var1.field1087 -= this.field973;
         }

         this.field971 -= this.field973;
         this.field973 = 0;
      }

   }

   @ObfuscatedName("g")
   void method871(Node var1, class61 var2) {
      while(var1 != this.field972.head && ((class61)var1).field1087 <= var2.field1087) {
         var1 = var1.next;
      }

      Deque.method2327(var2, var1);
      this.field971 = ((class61)this.field972.head.next).field1087;
   }

   @ObfuscatedName("u")
   protected class68 vmethod2611() {
      return (class68)this.field974.method2330();
   }

   @ObfuscatedName("j")
   void method873(int var1) {
      for(class68 var2 = (class68)this.field974.method2330(); var2 != null; var2 = (class68)this.field974.method2346()) {
         var2.vmethod2615(var1);
      }

   }

   @ObfuscatedName("b")
   protected class68 vmethod2612() {
      return (class68)this.field974.method2346();
   }

   @ObfuscatedName("x")
   protected int vmethod2632() {
      return 0;
   }

   @ObfuscatedName("m")
   public final synchronized void vmethod2615(int var1) {
      do {
         if(this.field971 < 0) {
            this.method873(var1);
            return;
         }

         if(this.field973 + var1 < this.field971) {
            this.field973 += var1;
            this.method873(var1);
            return;
         }

         int var2 = this.field971 - this.field973;
         this.method873(var2);
         var1 -= var2;
         this.field973 += var2;
         this.method870();
         class61 var3 = (class61)this.field972.method2330();
         synchronized(var3) {
            int var5 = var3.method1095(this);
            if(var5 < 0) {
               var3.field1087 = 0;
               this.method886(var3);
            } else {
               var3.field1087 = var5;
               this.method871(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("n")
   void method879(int[] var1, int var2, int var3) {
      for(class68 var4 = (class68)this.field974.method2330(); var4 != null; var4 = (class68)this.field974.method2346()) {
         var4.method1315(var1, var2, var3);
      }

   }

   @ObfuscatedName("k")
   void method886(class61 var1) {
      var1.unlink();
      var1.method1094();
      Node var2 = this.field972.head.next;
      if(var2 == this.field972.head) {
         this.field971 = -1;
      } else {
         this.field971 = ((class61)var2).field1087;
      }

   }

   @ObfuscatedName("r")
   public final synchronized void vmethod2614(int[] var1, int var2, int var3) {
      do {
         if(this.field971 < 0) {
            this.method879(var1, var2, var3);
            return;
         }

         if(this.field973 + var3 < this.field971) {
            this.field973 += var3;
            this.method879(var1, var2, var3);
            return;
         }

         int var4 = this.field971 - this.field973;
         this.method879(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field973 += var4;
         this.method870();
         class61 var5 = (class61)this.field972.method2330();
         synchronized(var5) {
            int var7 = var5.method1095(this);
            if(var7 < 0) {
               var5.field1087 = 0;
               this.method886(var5);
            } else {
               var5.field1087 = var7;
               this.method871(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }
}
