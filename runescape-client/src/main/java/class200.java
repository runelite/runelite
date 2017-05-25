import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("go")
public class class200 implements Iterator {
   @ObfuscatedName("i")
   class201 field2482;
   @ObfuscatedName("h")
   CacheableNode field2483;
   @ObfuscatedName("u")
   CacheableNode field2484;

   public Object next() {
      CacheableNode var1 = this.field2483;
      if(var1 == this.field2482.field2485) {
         var1 = null;
         this.field2483 = null;
      } else {
         this.field2483 = var1.previous;
      }

      this.field2484 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2483 != this.field2482.field2485;
   }

   public void remove() {
      this.field2484.method3687();
      this.field2484 = null;
   }

   class200(class201 var1) {
      this.field2484 = null;
      this.field2482 = var1;
      this.field2483 = this.field2482.field2485.previous;
      this.field2484 = null;
   }
}
