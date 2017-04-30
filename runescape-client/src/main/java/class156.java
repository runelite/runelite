import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fx")
public class class156 implements Iterator {
   @ObfuscatedName("n")
   CacheableNode field2048;
   @ObfuscatedName("d")
   class157 field2049;
   @ObfuscatedName("c")
   CacheableNode field2050;

   public Object next() {
      CacheableNode var1 = this.field2050;
      if(var1 == this.field2049.field2051) {
         var1 = null;
         this.field2050 = null;
      } else {
         this.field2050 = var1.previous;
      }

      this.field2048 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2050 != this.field2049.field2051;
   }

   public void remove() {
      if(this.field2048 == null) {
         throw new IllegalStateException();
      } else {
         this.field2048.method2851();
         this.field2048 = null;
      }
   }

   class156(class157 var1) {
      this.field2048 = null;
      this.field2049 = var1;
      this.field2050 = this.field2049.field2051.previous;
      this.field2048 = null;
   }
}
