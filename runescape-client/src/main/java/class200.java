import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gq")
public class class200 implements Iterable {
   @ObfuscatedName("b")
   public class204 field3099 = new class204();

   @ObfuscatedName("g")
   public void method3858(class204 var1) {
      if(var1.field3104 != null) {
         var1.method3889();
      }

      var1.field3104 = this.field3099.field3104;
      var1.field3103 = this.field3099;
      var1.field3104.field3103 = var1;
      var1.field3103.field3104 = var1;
   }

   public Iterator iterator() {
      return new class206(this);
   }

   public class200() {
      this.field3099.field3103 = this.field3099;
      this.field3099.field3104 = this.field3099;
   }

   @ObfuscatedName("b")
   public void method3861() {
      while(this.field3099.field3103 != this.field3099) {
         this.field3099.field3103.method3889();
      }

   }
}
