import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gv")
public class class200 implements Iterator {
   @ObfuscatedName("m")
   CacheableNode field2498;
   @ObfuscatedName("p")
   class201 field2499;
   @ObfuscatedName("e")
   CacheableNode field2500;

   public void remove() {
      this.field2500.method3520();
      this.field2500 = null;
   }

   public boolean hasNext() {
      return this.field2498 != this.field2499.field2501;
   }

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

   class200(class201 var1) {
      this.field2500 = null;
      this.field2499 = var1;
      this.field2498 = this.field2499.field2501.previous;
      this.field2500 = null;
   }
}
