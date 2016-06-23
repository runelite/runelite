import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bx")
public class class55 extends class66 {
   @ObfuscatedName("f")
   class199 field1182 = new class199();
   @ObfuscatedName("u")
   class199 field1183 = new class199();
   @ObfuscatedName("x")
   int field1184 = 0;
   @ObfuscatedName("b")
   int field1185 = -1;

   @ObfuscatedName("u")
   public final synchronized void method1200(class66 var1) {
      var1.method3946();
   }

   @ObfuscatedName("x")
   void method1201() {
      if(this.field1184 > 0) {
         for(class61 var1 = (class61)this.field1183.method3852(); var1 != null; var1 = (class61)this.field1183.method3857()) {
            var1.field1245 -= this.field1184;
         }

         this.field1185 -= this.field1184;
         this.field1184 = 0;
      }

   }

   @ObfuscatedName("b")
   void method1202(class208 var1, class61 var2) {
      while(var1 != this.field1183.field3100 && ((class61)var1).field1245 <= var2.field1245) {
         var1 = var1.field3116;
      }

      class199.method3872(var2, var1);
      this.field1185 = ((class61)this.field1183.field3100.field3116).field1245;
   }

   @ObfuscatedName("d")
   protected class66 vmethod3760() {
      return (class66)this.field1182.method3852();
   }

   @ObfuscatedName("n")
   protected class66 vmethod3752() {
      return (class66)this.field1182.method3857();
   }

   @ObfuscatedName("l")
   void method1206(class61 var1) {
      var1.method3946();
      var1.method1336();
      class208 var2 = this.field1183.field3100.field3116;
      if(var2 == this.field1183.field3100) {
         this.field1185 = -1;
      } else {
         this.field1185 = ((class61)var2).field1245;
      }

   }

   @ObfuscatedName("s")
   void method1207(int[] var1, int var2, int var3) {
      for(class66 var4 = (class66)this.field1182.method3852(); var4 != null; var4 = (class66)this.field1182.method3857()) {
         var4.method1523(var1, var2, var3);
      }

   }

   @ObfuscatedName("r")
   public final synchronized void vmethod3755(int var1) {
      do {
         if(this.field1185 < 0) {
            this.method1209(var1);
            return;
         }

         if(this.field1184 + var1 < this.field1185) {
            this.field1184 += var1;
            this.method1209(var1);
            return;
         }

         int var2 = this.field1185 - this.field1184;
         this.method1209(var2);
         var1 -= var2;
         this.field1184 += var2;
         this.method1201();
         class61 var3 = (class61)this.field1183.method3852();
         synchronized(var3) {
            int var5 = var3.method1339(this);
            if(var5 < 0) {
               var3.field1245 = 0;
               this.method1206(var3);
            } else {
               var3.field1245 = var5;
               this.method1202(var3.field3116, var3);
            }
         }
      } while(var1 != 0);

   }

   @ObfuscatedName("k")
   void method1209(int var1) {
      for(class66 var2 = (class66)this.field1182.method3852(); var2 != null; var2 = (class66)this.field1182.method3857()) {
         var2.vmethod3755(var1);
      }

   }

   @ObfuscatedName("g")
   public final synchronized void vmethod3764(int[] var1, int var2, int var3) {
      do {
         if(this.field1185 < 0) {
            this.method1207(var1, var2, var3);
            return;
         }

         if(this.field1184 + var3 < this.field1185) {
            this.field1184 += var3;
            this.method1207(var1, var2, var3);
            return;
         }

         int var4 = this.field1185 - this.field1184;
         this.method1207(var1, var2, var4);
         var2 += var4;
         var3 -= var4;
         this.field1184 += var4;
         this.method1201();
         class61 var5 = (class61)this.field1183.method3852();
         synchronized(var5) {
            int var7 = var5.method1339(this);
            if(var7 < 0) {
               var5.field1245 = 0;
               this.method1206(var5);
            } else {
               var5.field1245 = var7;
               this.method1202(var5.field3116, var5);
            }
         }
      } while(var3 != 0);

   }

   @ObfuscatedName("m")
   protected int vmethod3753() {
      return 0;
   }

   @ObfuscatedName("f")
   public final synchronized void method1229(class66 var1) {
      this.field1182.method3851(var1);
   }
}
