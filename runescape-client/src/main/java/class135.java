import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eg")
public class class135 implements Iterator {
   @ObfuscatedName("x")
   CacheableNode field1899 = null;
   @ObfuscatedName("p")
   class136 field1900;
   @ObfuscatedName("g")
   CacheableNode field1901;

   public Object next() {
      CacheableNode var1 = this.field1901;
      if(var1 == this.field1900.field1902) {
         var1 = null;
         this.field1901 = null;
      } else {
         this.field1901 = var1.previous;
      }

      this.field1899 = var1;
      return var1;
   }

   public void remove() {
      this.field1899.method2440();
      this.field1899 = null;
   }

   class135(class136 var1) {
      this.field1900 = var1;
      this.field1901 = this.field1900.field1902.previous;
      this.field1899 = null;
   }

   public boolean hasNext() {
      return this.field1901 != this.field1900.field1902;
   }
}
