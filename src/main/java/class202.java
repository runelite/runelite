import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ge")
public class class202 implements Iterable {
   @ObfuscatedName("e")
   class208 field3102 = new class208();

   public class202() {
      this.field3102.field3114 = this.field3102;
      this.field3102.field3116 = this.field3102;
   }

   @ObfuscatedName("e")
   public void method3865(class208 var1) {
      if(var1.field3116 != null) {
         var1.method3913();
      }

      var1.field3116 = this.field3102.field3116;
      var1.field3114 = this.field3102;
      var1.field3116.field3114 = var1;
      var1.field3114.field3116 = var1;
   }

   @ObfuscatedName("w")
   public class208 method3866() {
      return this.method3867((class208)null);
   }

   @ObfuscatedName("f")
   class208 method3867(class208 var1) {
      class208 var2;
      if(var1 == null) {
         var2 = this.field3102.field3114;
      } else {
         var2 = var1;
      }

      return var2 == this.field3102?null:var2;
   }

   public Iterator iterator() {
      return new class205(this);
   }
}
