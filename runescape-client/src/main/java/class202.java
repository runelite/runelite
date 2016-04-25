import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gz")
public class class202 implements Iterable {
   @ObfuscatedName("j")
   class208 field3110 = new class208();

   @ObfuscatedName("j")
   public void method3825(class208 var1) {
      if(var1.field3124 != null) {
         var1.method3883();
      }

      var1.field3124 = this.field3110.field3124;
      var1.field3123 = this.field3110;
      var1.field3124.field3123 = var1;
      var1.field3123.field3124 = var1;
   }

   @ObfuscatedName("h")
   public class208 method3826() {
      return this.method3827((class208)null);
   }

   @ObfuscatedName("m")
   class208 method3827(class208 var1) {
      class208 var2;
      if(var1 == null) {
         var2 = this.field3110.field3123;
      } else {
         var2 = var1;
      }

      return var2 == this.field3110?null:var2;
   }

   public Iterator iterator() {
      return new class205(this);
   }

   public class202() {
      this.field3110.field3123 = this.field3110;
      this.field3110.field3124 = this.field3110;
   }
}
