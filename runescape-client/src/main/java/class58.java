import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bq")
public class class58 extends class69 {
   @ObfuscatedName("d")
   Deque field1242 = new Deque();
   @ObfuscatedName("v")
   int field1243 = 0;
   @ObfuscatedName("r")
   int field1244 = -1;
   @ObfuscatedName("a")
   Deque field1245 = new Deque();

   @ObfuscatedName("a")
   public final synchronized void method1187(class69 var1) {
      this.field1245.method3877(var1);
   }

   @ObfuscatedName("d")
   public final synchronized void method1188(class69 var1) {
      var1.unlink();
   }

   @ObfuscatedName("r")
   void method1190(Node var1, class64 var2) {
      while(var1 != this.field1242.head && ((class64)var1).field1301 <= var2.field1301) {
         var1 = var1.next;
      }

      Deque.method3851(var2, var1);
      this.field1244 = ((class64)this.field1242.head.next).field1301;
   }

   @ObfuscatedName("n")
   protected class69 vmethod3756() {
      return (class69)this.field1245.method3869();
   }

   @ObfuscatedName("i")
   protected int vmethod3747() {
      return 0;
   }

   @ObfuscatedName("g")
   public final synchronized void vmethod3751(int[] var1, int var2, int var3) {
      do {
         if(this.field1244 < 0) {
            this.method1225(var1, var2, var3);
            return;
         }

         if(this.field1243 + var3 < this.field1244) {
            this.field1243 += var3;
            this.method1225(var1, var2, var3);
            return;
         }

         int var4 = this.field1244 - this.field1243;
         this.method1225(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1243 += var4;
         this.method1227();
         class64 var5 = (class64)this.field1242.method3854();
         synchronized(var5) {
            int var7 = var5.method1327(this);
            if(var7 < 0) {
               var5.field1301 = 0;
               this.method1208(var5);
            } else {
               var5.field1301 = var7;
               this.method1190(var5.next, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("k")
   public final synchronized void vmethod3749(int var1) {
      do {
         if(this.field1244 < 0) {
            this.method1198(var1);
            return;
         }

         if(this.field1243 + var1 < this.field1244) {
            this.field1243 += var1;
            this.method1198(var1);
            return;
         }

         int var2 = this.field1244 - this.field1243;
         this.method1198(var2);
         var1 -= var2;
         this.field1243 += var2;
         this.method1227();
         class64 var3 = (class64)this.field1242.method3854();
         synchronized(var3) {
            int var5 = var3.method1327(this);
            if(var5 < 0) {
               var3.field1301 = 0;
               this.method1208(var3);
            } else {
               var3.field1301 = var5;
               this.method1190(var3.next, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("x")
   void method1198(int var1) {
      for(class69 var2 = (class69)this.field1245.method3854(); var2 != null; var2 = (class69)this.field1245.method3869()) {
         var2.vmethod3749(var1);
      }

   }

   @ObfuscatedName("z")
   void method1208(class64 var1) {
      var1.unlink();
      var1.method1326();
      Node var2 = this.field1242.head.next;
      if(var2 == this.field1242.head) {
         this.field1244 = -1;
      } else {
         this.field1244 = ((class64)var2).field1301;
      }

   }

   @ObfuscatedName("m")
   void method1225(int[] var1, int var2, int var3) {
      for(class69 var4 = (class69)this.field1245.method3854(); var4 != null; var4 = (class69)this.field1245.method3869()) {
         var4.method1522(var1, var2, var3);
      }

   }

   @ObfuscatedName("v")
   void method1227() {
      if(this.field1243 > 0) {
         for(class64 var1 = (class64)this.field1242.method3854(); var1 != null; var1 = (class64)this.field1242.method3869()) {
            var1.field1301 -= this.field1243;
         }

         this.field1244 -= this.field1243;
         this.field1243 = 0;
      }

   }

   @ObfuscatedName("t")
   protected class69 vmethod3745() {
      return (class69)this.field1245.method3854();
   }
}
