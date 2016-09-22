import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hn")
public class class209 implements Iterator {
   @ObfuscatedName("a")
   class203 field3164;
   @ObfuscatedName("d")
   CacheableNode field3165;
   @ObfuscatedName("v")
   CacheableNode field3166 = null;

   public boolean hasNext() {
      return this.field3165 != this.field3164.field3154;
   }

   public Object next() {
      CacheableNode var1 = this.field3165;
      if(var1 == this.field3164.field3154) {
         var1 = null;
         this.field3165 = null;
      } else {
         this.field3165 = var1.previous;
      }

      this.field3166 = var1;
      return var1;
   }

   class209(class203 var1) {
      this.field3164 = var1;
      this.field3165 = this.field3164.field3154.previous;
      this.field3166 = null;
   }

   public void remove() {
      this.field3166.method3938();
      this.field3166 = null;
   }
}
