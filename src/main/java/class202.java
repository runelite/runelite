import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
public class class202 implements Iterable {
   @ObfuscatedName("a")
   class208 field3111 = new class208();

   @ObfuscatedName("w")
   public class208 method3950() {
      return this.method3952((class208)null);
   }

   @ObfuscatedName("d")
   class208 method3952(class208 var1) {
      class208 var2;
      if(var1 == null) {
         var2 = this.field3111.field3124;
      } else {
         var2 = var1;
      }

      return var2 == this.field3111?null:var2;
   }

   public Iterator iterator() {
      return new class205(this);
   }

   public class202() {
      this.field3111.field3124 = this.field3111;
      this.field3111.field3123 = this.field3111;
   }

   @ObfuscatedName("a")
   public void method3956(class208 var1) {
      if(var1.field3123 != null) {
         var1.method3998();
      }

      var1.field3123 = this.field3111.field3123;
      var1.field3124 = this.field3111;
      var1.field3123.field3124 = var1;
      var1.field3124.field3123 = var1;
   }
}
