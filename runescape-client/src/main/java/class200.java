import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
public class class200 implements Iterator {
   @ObfuscatedName("p")
   CacheableNode field2498;
   @ObfuscatedName("n")
   class201 field2499;
   @ObfuscatedName("i")
   CacheableNode field2500;

   public Object next() {
      CacheableNode var1 = this.field2498;
      if(var1 == this.field2499.field2501) {
         var1 = null;
         this.field2498 = null;
      } else {
         this.field2498 = var1.previous;
      }

      this.field2500 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2498 != this.field2499.field2501;
   }

   class200(class201 var1) {
      this.field2500 = null;
      this.field2499 = var1;
      this.field2498 = this.field2499.field2501.previous;
      this.field2500 = null;
   }

   public void remove() {
      if(this.field2500 == null) {
         throw new IllegalStateException();
      } else {
         this.field2500.method3641();
         this.field2500 = null;
      }
   }
}
