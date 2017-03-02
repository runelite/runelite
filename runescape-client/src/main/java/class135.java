import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eb")
public class class135 implements Iterator {
   @ObfuscatedName("i")
   CacheableNode field1893 = null;
   @ObfuscatedName("l")
   CacheableNode field1894;
   @ObfuscatedName("b")
   class136 field1895;

   public Object next() {
      CacheableNode var1 = this.field1894;
      if(var1 == this.field1895.field1896) {
         var1 = null;
         this.field1894 = null;
      } else {
         this.field1894 = var1.previous;
      }

      this.field1893 = var1;
      return var1;
   }

   public void remove() {
      if(this.field1893 == null) {
         throw new IllegalStateException();
      } else {
         this.field1893.method2497();
         this.field1893 = null;
      }
   }

   public boolean hasNext() {
      return this.field1894 != this.field1895.field1896;
   }

   class135(class136 var1) {
      this.field1895 = var1;
      this.field1894 = this.field1895.field1896.previous;
      this.field1893 = null;
   }
}
