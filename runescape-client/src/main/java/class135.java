import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("en")
public class class135 implements Iterator {
   @ObfuscatedName("f")
   CacheableNode field1903 = null;
   @ObfuscatedName("s")
   class136 field1904;
   @ObfuscatedName("c")
   CacheableNode field1905;

   class135(class136 var1) {
      this.field1904 = var1;
      this.field1905 = this.field1904.field1906.previous;
      this.field1903 = null;
   }

   public boolean hasNext() {
      return this.field1905 != this.field1904.field1906;
   }

   public void remove() {
      if(this.field1903 == null) {
         throw new IllegalStateException();
      } else {
         this.field1903.method2361();
         this.field1903 = null;
      }
   }

   public Object next() {
      CacheableNode var1 = this.field1905;
      if(var1 == this.field1904.field1906) {
         var1 = null;
         this.field1905 = null;
      } else {
         this.field1905 = var1.previous;
      }

      this.field1903 = var1;
      return var1;
   }
}
