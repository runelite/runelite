import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eb")
public class class135 implements Iterator {
   @ObfuscatedName("n")
   class136 field1894;
   @ObfuscatedName("d")
   CacheableNode field1895;
   @ObfuscatedName("m")
   CacheableNode field1896 = null;

   public void remove() {
      if(this.field1896 == null) {
         throw new IllegalStateException();
      } else {
         this.field1896.method2483();
         this.field1896 = null;
      }
   }

   public Object next() {
      CacheableNode var1 = this.field1895;
      if(var1 == this.field1894.field1897) {
         var1 = null;
         this.field1895 = null;
      } else {
         this.field1895 = var1.previous;
      }

      this.field1896 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field1895 != this.field1894.field1897;
   }

   class135(class136 var1) {
      this.field1894 = var1;
      this.field1895 = this.field1894.field1897.previous;
      this.field1896 = null;
   }
}
