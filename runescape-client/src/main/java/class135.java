import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ea")
public class class135 implements Iterator {
   @ObfuscatedName("n")
   CacheableNode field1900;
   @ObfuscatedName("x")
   class136 field1901;
   @ObfuscatedName("g")
   CacheableNode field1902 = null;

   class135(class136 var1) {
      this.field1901 = var1;
      this.field1900 = this.field1901.field1903.previous;
      this.field1902 = null;
   }

   public boolean hasNext() {
      return this.field1900 != this.field1901.field1903;
   }

   public void remove() {
      if(this.field1902 == null) {
         throw new IllegalStateException();
      } else {
         this.field1902.method2513();
         this.field1902 = null;
      }
   }

   public Object next() {
      CacheableNode var1 = this.field1900;
      if(var1 == this.field1901.field1903) {
         var1 = null;
         this.field1900 = null;
      } else {
         this.field1900 = var1.previous;
      }

      this.field1902 = var1;
      return var1;
   }
}
