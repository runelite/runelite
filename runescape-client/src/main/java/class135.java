import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eq")
public class class135 implements Iterator {
   @ObfuscatedName("q")
   class136 field1897;
   @ObfuscatedName("d")
   CacheableNode field1898;
   @ObfuscatedName("h")
   CacheableNode field1899 = null;

   public boolean hasNext() {
      return this.field1898 != this.field1897.field1900;
   }

   public void remove() {
      if(this.field1899 == null) {
         throw new IllegalStateException();
      } else {
         this.field1899.method2484();
         this.field1899 = null;
      }
   }

   class135(class136 var1) {
      this.field1897 = var1;
      this.field1898 = this.field1897.field1900.previous;
      this.field1899 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field1898;
      if(var1 == this.field1897.field1900) {
         var1 = null;
         this.field1898 = null;
      } else {
         this.field1898 = var1.previous;
      }

      this.field1899 = var1;
      return var1;
   }
}
