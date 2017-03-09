import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ef")
public class class135 implements Iterator {
   @ObfuscatedName("c")
   CacheableNode field1899 = null;
   @ObfuscatedName("j")
   CacheableNode field1900;
   @ObfuscatedName("x")
   class136 field1901;

   public Object next() {
      CacheableNode var1 = this.field1900;
      if(var1 == this.field1901.field1902) {
         var1 = null;
         this.field1900 = null;
      } else {
         this.field1900 = var1.previous;
      }

      this.field1899 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field1900 != this.field1901.field1902;
   }

   public void remove() {
      if(this.field1899 == null) {
         throw new IllegalStateException();
      } else {
         this.field1899.method2476();
         this.field1899 = null;
      }
   }

   class135(class136 var1) {
      this.field1901 = var1;
      this.field1900 = this.field1901.field1902.previous;
      this.field1899 = null;
   }
}
