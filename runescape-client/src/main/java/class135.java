import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ej")
public class class135 implements Iterator {
   @ObfuscatedName("i")
   CacheableNode field1883 = null;
   @ObfuscatedName("x")
   CacheableNode field1884;
   @ObfuscatedName("u")
   class136 field1885;

   public Object next() {
      CacheableNode var1 = this.field1884;
      if(var1 == this.field1885.field1886) {
         var1 = null;
         this.field1884 = null;
      } else {
         this.field1884 = var1.previous;
      }

      this.field1883 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field1884 != this.field1885.field1886;
   }

   public void remove() {
      this.field1883.method2413();
      this.field1883 = null;
   }

   class135(class136 var1) {
      this.field1885 = var1;
      this.field1884 = this.field1885.field1886.previous;
      this.field1883 = null;
   }
}
