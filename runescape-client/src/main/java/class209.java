import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hg")
public class class209 implements Iterator {
   @ObfuscatedName("r")
   CacheableNode field3167;
   @ObfuscatedName("x")
   class203 field3168;
   @ObfuscatedName("j")
   CacheableNode field3169 = null;

   public Object next() {
      CacheableNode var1 = this.field3167;
      if(var1 == this.field3168.field3157) {
         var1 = null;
         this.field3167 = null;
      } else {
         this.field3167 = var1.previous;
      }

      this.field3169 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field3167 != this.field3168.field3157;
   }

   class209(class203 var1) {
      this.field3168 = var1;
      this.field3167 = this.field3168.field3157.previous;
      this.field3169 = null;
   }

   public void remove() {
      this.field3169.method3925();
      this.field3169 = null;
   }
}
