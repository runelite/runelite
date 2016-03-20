import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gb")
public final class class192 {
   @ObfuscatedName("a")
   class203 field3073 = new class203();
   @ObfuscatedName("r")
   int field3074;
   @ObfuscatedName("y")
   class202 field3075 = new class202();
   @ObfuscatedName("s")
   class195 field3076;
   @ObfuscatedName("f")
   int field3077;

   @ObfuscatedName("a")
   public class203 method3792(long var1) {
      class203 var3 = (class203)this.field3076.method3824(var1);
      if(var3 != null) {
         this.field3075.method3908(var3);
      }

      return var3;
   }

   @ObfuscatedName("r")
   public void method3793(long var1) {
      class203 var3 = (class203)this.field3076.method3824(var1);
      if(var3 != null) {
         var3.method3946();
         var3.method3920();
         ++this.field3077;
      }

   }

   @ObfuscatedName("f")
   public void method3794(class203 var1, long var2) {
      if(this.field3077 == 0) {
         class203 var4 = this.field3075.method3910();
         var4.method3946();
         var4.method3920();
         if(var4 == this.field3073) {
            var4 = this.field3075.method3910();
            var4.method3946();
            var4.method3920();
         }
      } else {
         --this.field3077;
      }

      this.field3076.method3831(var1, var2);
      this.field3075.method3908(var1);
   }

   @ObfuscatedName("s")
   public void method3800() {
      this.field3075.method3917();
      this.field3076.method3823();
      this.field3073 = new class203();
      this.field3077 = this.field3074;
   }

   public class192(int var1) {
      this.field3074 = var1;
      this.field3077 = var1;

      int var2;
      for(var2 = 1; var2 + var2 < var1; var2 += var2) {
         ;
      }

      this.field3076 = new class195(var2);
   }
}
