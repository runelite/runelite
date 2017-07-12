import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gd")
public class class200 implements Iterator {
   @ObfuscatedName("i")
   class201 field2489;
   @ObfuscatedName("w")
   CacheableNode field2490;
   @ObfuscatedName("a")
   CacheableNode field2491;

   class200(class201 var1) {
      this.field2491 = null;
      this.field2489 = var1;
      this.field2490 = this.field2489.field2492.previous;
      this.field2491 = null;
   }

   public void remove() {
      if(this.field2491 == null) {
         throw new IllegalStateException();
      } else {
         this.field2491.unlinkDual();
         this.field2491 = null;
      }
   }

   public Object next() {
      CacheableNode var1 = this.field2490;
      if(this.field2489.field2492 == var1) {
         var1 = null;
         this.field2490 = null;
      } else {
         this.field2490 = var1.previous;
      }

      this.field2491 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2490 != this.field2489.field2492;
   }
}
