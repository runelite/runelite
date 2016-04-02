import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
public class class206 implements Iterator {
   @ObfuscatedName("w")
   class204 field3109;
   @ObfuscatedName("e")
   class200 field3110;
   @ObfuscatedName("f")
   class204 field3111 = null;

   public Object next() {
      class204 var1 = this.field3109;
      if(var1 == this.field3110.field3100) {
         var1 = null;
         this.field3109 = null;
      } else {
         this.field3109 = var1.field3105;
      }

      this.field3111 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3109 != this.field3110.field3100;
   }

   public void remove() {
      if(this.field3111 == null) {
         throw new IllegalStateException();
      } else {
         this.field3111.method3891();
         this.field3111 = null;
      }
   }

   class206(class200 var1) {
      this.field3110 = var1;
      this.field3109 = this.field3110.field3100.field3105;
      this.field3111 = null;
   }
}
