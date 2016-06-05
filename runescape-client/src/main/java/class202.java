import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gb")
public class class202 implements Iterable {
   @ObfuscatedName("t")
   class208 field3112 = new class208();

   @ObfuscatedName("t")
   public void method3815(class208 var1) {
      if(var1.field3124 != null) {
         var1.method3870();
      }

      var1.field3124 = this.field3112.field3124;
      var1.field3126 = this.field3112;
      var1.field3124.field3126 = var1;
      var1.field3126.field3124 = var1;
   }

   public Iterator iterator() {
      return new class205(this);
   }

   @ObfuscatedName("i")
   public class208 method3819() {
      return this.method3822((class208)null);
   }

   public class202() {
      this.field3112.field3126 = this.field3112;
      this.field3112.field3124 = this.field3112;
   }

   @ObfuscatedName("g")
   class208 method3822(class208 var1) {
      class208 var2;
      if(var1 == null) {
         var2 = this.field3112.field3126;
      } else {
         var2 = var1;
      }

      return var2 == this.field3112?null:var2;
   }
}
