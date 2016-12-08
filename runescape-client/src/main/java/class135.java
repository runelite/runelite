import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eq")
public class class135 implements Iterator {
   @ObfuscatedName("b")
   CacheableNode field1910 = null;
   @ObfuscatedName("o")
   class136 field1911;
   @ObfuscatedName("m")
   CacheableNode field1912;

   class135(class136 var1) {
      this.field1911 = var1;
      this.field1912 = this.field1911.field1913.previous;
      this.field1910 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field1912;
      if(var1 == this.field1911.field1913) {
         var1 = null;
         this.field1912 = null;
      } else {
         this.field1912 = var1.previous;
      }

      this.field1910 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field1912 != this.field1911.field1913;
   }

   public void remove() {
      if(this.field1910 == null) {
         throw new IllegalStateException();
      } else {
         this.field1910.method2380();
         this.field1910 = null;
      }
   }
}
