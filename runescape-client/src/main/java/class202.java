import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gh")
public class class202 implements Iterable {
   @ObfuscatedName("s")
   class208 field3112 = new class208();

   @ObfuscatedName("s")
   public void method3849(class208 var1) {
      if(var1.field3126 != null) {
         var1.method3898();
      }

      var1.field3126 = this.field3112.field3126;
      var1.field3124 = this.field3112;
      var1.field3126.field3124 = var1;
      var1.field3124.field3126 = var1;
   }

   @ObfuscatedName("p")
   class208 method3851(class208 var1) {
      class208 var2;
      if(var1 == null) {
         var2 = this.field3112.field3124;
      } else {
         var2 = var1;
      }

      return var2 == this.field3112?null:var2;
   }

   public Iterator iterator() {
      return new class205(this);
   }

   @ObfuscatedName("j")
   public class208 method3856() {
      return this.method3851((class208)null);
   }

   public class202() {
      this.field3112.field3124 = this.field3112;
      this.field3112.field3126 = this.field3112;
   }
}
