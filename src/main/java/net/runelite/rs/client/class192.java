package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
public final class class192 {
   @ObfuscatedName("f")
   class202 field3074 = new class202();
   @ObfuscatedName("j")
   class203 field3075 = new class203();
   @ObfuscatedName("l")
   int field3076;
   @ObfuscatedName("i")
   class195 field3077;
   @ObfuscatedName("a")
   int field3078;

   @ObfuscatedName("j")
   public class203 method3711(long var1) {
      class203 var3 = (class203)this.field3077.method3744(var1);
      if(var3 != null) {
         this.field3074.method3814(var3);
      }

      return var3;
   }

   @ObfuscatedName("l")
   public void method3712(long var1) {
      class203 var3 = (class203)this.field3077.method3744(var1);
      if(var3 != null) {
         var3.method3853();
         var3.method3835();
         ++this.field3078;
      }

   }

   @ObfuscatedName("a")
   public void method3713(class203 var1, long var2) {
      if(this.field3078 == 0) {
         class203 var4 = this.field3074.method3816();
         var4.method3853();
         var4.method3835();
         if(var4 == this.field3075) {
            var4 = this.field3074.method3816();
            var4.method3853();
            var4.method3835();
         }
      } else {
         --this.field3078;
      }

      this.field3077.method3746(var1, var2);
      this.field3074.method3814(var1);
   }

   public class192(int var1) {
      this.field3076 = var1;
      this.field3078 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3077 = new class195(var2);
   }

   @ObfuscatedName("i")
   public void method3720() {
      this.field3074.method3824();
      this.field3077.method3743();
      this.field3075 = new class203();
      this.field3078 = this.field3076;
   }
}
