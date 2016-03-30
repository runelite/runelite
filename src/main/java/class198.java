import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gz")
public final class class198 implements Iterable {
   @ObfuscatedName("w")
   int field3104;
   @ObfuscatedName("x")
   class208[] field3105;
   @ObfuscatedName("t")
   class208 field3106;

   @ObfuscatedName("t")
   public void method3821() {
      for(int var1 = 0; var1 < this.field3104; ++var1) {
         class208 var2 = this.field3105[var1];

         while(true) {
            class208 var3 = var2.field3124;
            if(var3 == var2) {
               break;
            }

            var3.method3935();
         }
      }

      this.field3106 = null;
   }

   @ObfuscatedName("x")
   public void method3822(class208 var1, long var2) {
      if(var1.field3125 != null) {
         var1.method3935();
      }

      class208 var4 = this.field3105[(int)(var2 & (long)(this.field3104 - 1))];
      var1.field3125 = var4.field3125;
      var1.field3124 = var4;
      var1.field3125.field3124 = var1;
      var1.field3124.field3125 = var1;
      var1.field3123 = var2;
   }

   public class198(int var1) {
      this.field3104 = var1;
      this.field3105 = new class208[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         class208 var3 = this.field3105[var2] = new class208();
         var3.field3124 = var3;
         var3.field3125 = var3;
      }

   }

   @ObfuscatedName("w")
   public class208 method3823(long var1) {
      class208 var3 = this.field3105[(int)(var1 & (long)(this.field3104 - 1))];

      for(this.field3106 = var3.field3124; this.field3106 != var3; this.field3106 = this.field3106.field3124) {
         if(this.field3106.field3123 == var1) {
            class208 var4 = this.field3106;
            this.field3106 = this.field3106.field3124;
            return var4;
         }
      }

      this.field3106 = null;
      return null;
   }

   public Iterator iterator() {
      return new class194(this);
   }
}
