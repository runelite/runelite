import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
public class class58 extends class69 {
   @ObfuscatedName("k")
   Deque field1229 = new Deque();
   @ObfuscatedName("q")
   Deque field1230 = new Deque();
   @ObfuscatedName("f")
   int field1231 = 0;
   @ObfuscatedName("c")
   int field1232 = -1;

   @ObfuscatedName("h")
   void method1175(int[] var1, int var2, int var3) {
      for(class69 var4 = (class69)this.field1229.method3864(); var4 != null; var4 = (class69)this.field1229.method3851()) {
         var4.method1532(var1, var2, var3);
      }

   }

   @ObfuscatedName("k")
   public final synchronized void method1176(class69 var1) {
      this.field1229.method3845(var1);
   }

   @ObfuscatedName("q")
   public final synchronized void method1177(class69 var1) {
      var1.unlink();
   }

   @ObfuscatedName("f")
   void method1178() {
      if(this.field1231 > 0) {
         for(class64 var1 = (class64)this.field1230.method3864(); var1 != null; var1 = (class64)this.field1230.method3851()) {
            var1.field1288 -= this.field1231;
         }

         this.field1232 -= this.field1231;
         this.field1231 = 0;
      }

   }

   @ObfuscatedName("c")
   void method1179(Node var1, class64 var2) {
      while(var1 != this.field1230.head && ((class64)var1).field1288 <= var2.field1288) {
         var1 = var1.next;
      }

      Deque.method3854(var2, var1);
      this.field1232 = ((class64)this.field1230.head.next).field1288;
   }

   @ObfuscatedName("v")
   void method1180(class64 var1) {
      var1.unlink();
      var1.method1316();
      Node var2 = this.field1230.head.next;
      if(var2 == this.field1230.head) {
         this.field1232 = -1;
      } else {
         this.field1232 = ((class64)var2).field1288;
      }

   }

   @ObfuscatedName("m")
   protected class69 vmethod3755() {
      return (class69)this.field1229.method3851();
   }

   @ObfuscatedName("y")
   protected int vmethod3758() {
      return 0;
   }

   @ObfuscatedName("u")
   public final synchronized void vmethod3766(int[] var1, int var2, int var3) {
      do {
         if(this.field1232 < 0) {
            this.method1175(var1, var2, var3);
            return;
         }

         if(this.field1231 + var3 < this.field1232) {
            this.field1231 += var3;
            this.method1175(var1, var2, var3);
            return;
         }

         int var4 = this.field1232 - this.field1231;
         this.method1175(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1231 += var4;
         this.method1178();
         class64 var5 = (class64)this.field1230.method3864();
         synchronized(var5) {
            int var7 = var5.method1317(this);
            if(var7 < 0) {
               var5.field1288 = 0;
               this.method1180(var5);
            } else {
               var5.field1288 = var7;
               this.method1179(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("j")
   protected class69 vmethod3751() {
      return (class69)this.field1229.method3864();
   }

   @ObfuscatedName("l")
   public final synchronized void vmethod3754(int var1) {
      do {
         if(this.field1232 < 0) {
            this.method1205(var1);
            return;
         }

         if(this.field1231 + var1 < this.field1232) {
            this.field1231 += var1;
            this.method1205(var1);
            return;
         }

         int var2 = this.field1232 - this.field1231;
         this.method1205(var2);
         var1 -= var2;
         this.field1231 += var2;
         this.method1178();
         class64 var3 = (class64)this.field1230.method3864();
         synchronized(var3) {
            int var5 = var3.method1317(this);
            if(var5 < 0) {
               var3.field1288 = 0;
               this.method1180(var3);
            } else {
               var3.field1288 = var5;
               this.method1179(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("b")
   void method1205(int var1) {
      for(class69 var2 = (class69)this.field1229.method3864(); var2 != null; var2 = (class69)this.field1229.method3851()) {
         var2.vmethod3754(var1);
      }

   }
}
