import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
public class class135 implements Iterator {
   @ObfuscatedName("u")
   CacheableNode field1920 = null;
   @ObfuscatedName("f")
   class136 field1921;
   @ObfuscatedName("i")
   CacheableNode field1922;

   public Object next() {
      CacheableNode var1 = this.field1922;
      if(var1 == this.field1921.field1923) {
         var1 = null;
         this.field1922 = null;
      } else {
         this.field1922 = var1.previous;
      }

      this.field1920 = var1;
      return var1;
   }

   class135(class136 var1) {
      this.field1921 = var1;
      this.field1922 = this.field1921.field1923.previous;
      this.field1920 = null;
   }

   public void remove() {
      if(this.field1920 == null) {
         throw new IllegalStateException();
      } else {
         this.field1920.method2495();
         this.field1920 = null;
      }
   }

   public boolean hasNext() {
      return this.field1922 != this.field1921.field1923;
   }
}
