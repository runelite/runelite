import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class200 implements Iterable {
   @ObfuscatedName("e")
   public class204 field3100 = new class204();

   public class200() {
      this.field3100.field3105 = this.field3100;
      this.field3100.field3104 = this.field3100;
   }

   public Iterator iterator() {
      return new class206(this);
   }

   @ObfuscatedName("w")
   public void method3854(class204 var1) {
      if(var1.field3104 != null) {
         var1.method3891();
      }

      var1.field3104 = this.field3100.field3104;
      var1.field3105 = this.field3100;
      var1.field3104.field3105 = var1;
      var1.field3105.field3104 = var1;
   }

   @ObfuscatedName("e")
   public void method3856() {
      while(this.field3100.field3105 != this.field3100) {
         this.field3100.field3105.method3891();
      }

   }
}
