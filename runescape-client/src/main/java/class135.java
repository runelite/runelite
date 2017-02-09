import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ep")
public class class135 implements Iterator {
   @ObfuscatedName("y")
   CacheableNode field1889;
   @ObfuscatedName("k")
   class136 field1890;
   @ObfuscatedName("o")
   CacheableNode field1891 = null;

   public Object next() {
      CacheableNode var1 = this.field1889;
      if(var1 == this.field1890.field1892) {
         var1 = null;
         this.field1889 = null;
      } else {
         this.field1889 = var1.previous;
      }

      this.field1891 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field1889 != this.field1890.field1892;
   }

   public void remove() {
      if(this.field1891 == null) {
         throw new IllegalStateException();
      } else {
         this.field1891.method2411();
         this.field1891 = null;
      }
   }

   class135(class136 var1) {
      this.field1890 = var1;
      this.field1889 = this.field1890.field1892.previous;
      this.field1891 = null;
   }
}
