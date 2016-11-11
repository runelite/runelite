import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hy")
public class class209 implements Iterator {
   @ObfuscatedName("h")
   CacheableNode field3168;
   @ObfuscatedName("i")
   class203 field3169;
   @ObfuscatedName("e")
   CacheableNode field3170 = null;

   class209(class203 var1) {
      this.field3169 = var1;
      this.field3168 = this.field3169.field3158.previous;
      this.field3170 = null;
   }

   public void remove() {
      if(this.field3170 == null) {
         throw new IllegalStateException();
      } else {
         this.field3170.method3924();
         this.field3170 = null;
      }
   }

   public boolean hasNext() {
      return this.field3168 != this.field3169.field3158;
   }

   public Object next() {
      CacheableNode var1 = this.field3168;
      if(var1 == this.field3169.field3158) {
         var1 = null;
         this.field3168 = null;
      } else {
         this.field3168 = var1.previous;
      }

      this.field3170 = var1;
      return var1;
   }
}
