import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gz")
public class class202 implements Iterable {
   @ObfuscatedName("f")
   class208 field3103 = new class208();

   public Iterator iterator() {
      return new class205(this);
   }

   public class202() {
      this.field3103.field3116 = this.field3103;
      this.field3103.field3117 = this.field3103;
   }

   @ObfuscatedName("u")
   public class208 method3891() {
      return this.method3897((class208)null);
   }

   @ObfuscatedName("x")
   class208 method3897(class208 var1) {
      class208 var2;
      if(var1 == null) {
         var2 = this.field3103.field3116;
      } else {
         var2 = var1;
      }

      return var2 == this.field3103?null:var2;
   }

   @ObfuscatedName("f")
   public void method3898(class208 var1) {
      if(var1.field3117 != null) {
         var1.method3946();
      }

      var1.field3117 = this.field3103.field3117;
      var1.field3116 = this.field3103;
      var1.field3117.field3116 = var1;
      var1.field3116.field3117 = var1;
   }
}
