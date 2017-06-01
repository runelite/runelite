import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gh")
public class class200 implements Iterator {
   @ObfuscatedName("c")
   CacheableNode field2496;
   @ObfuscatedName("i")
   class201 field2497;
   @ObfuscatedName("e")
   CacheableNode field2498;

   public void remove() {
      if(this.field2498 == null) {
         throw new IllegalStateException();
      } else {
         this.field2498.method3600();
         this.field2498 = null;
      }
   }

   public boolean hasNext() {
      return this.field2496 != this.field2497.field2499;
   }

   class200(class201 var1) {
      this.field2498 = null;
      this.field2497 = var1;
      this.field2496 = this.field2497.field2499.previous;
      this.field2498 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2496;
      if(var1 == this.field2497.field2499) {
         var1 = null;
         this.field2496 = null;
      } else {
         this.field2496 = var1.previous;
      }

      this.field2498 = var1;
      return var1;
   }
}
