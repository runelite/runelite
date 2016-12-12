import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("er")
public class class135 implements Iterator {
   @ObfuscatedName("f")
   CacheableNode field1893 = null;
   @ObfuscatedName("i")
   class136 field1894;
   @ObfuscatedName("e")
   CacheableNode field1895;

   public Object next() {
      CacheableNode var1 = this.field1895;
      if(var1 == this.field1894.field1896) {
         var1 = null;
         this.field1895 = null;
      } else {
         this.field1895 = var1.previous;
      }

      this.field1893 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field1895 != this.field1894.field1896;
   }

   public void remove() {
      if(this.field1893 == null) {
         throw new IllegalStateException();
      } else {
         this.field1893.method2388();
         this.field1893 = null;
      }
   }

   class135(class136 var1) {
      this.field1894 = var1;
      this.field1895 = this.field1894.field1896.previous;
      this.field1893 = null;
   }
}
