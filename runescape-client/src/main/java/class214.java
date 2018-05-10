import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class214 implements Iterator {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   IterableDualNodeQueue field2468;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   CacheableNode field2467;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   CacheableNode field2469;

   @ObfuscatedSignature(
      signature = "(Lhq;)V"
   )
   class214(IterableDualNodeQueue var1) {
      this.field2469 = null;
      this.field2468 = var1;
      this.field2467 = this.field2468.sentinel.previous;
      this.field2469 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2467;
      if(var1 == this.field2468.sentinel) {
         var1 = null;
         this.field2467 = null;
      } else {
         this.field2467 = var1.previous;
      }

      this.field2469 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2468.sentinel != this.field2467;
   }

   public void remove() {
      if(this.field2469 == null) {
         throw new IllegalStateException();
      } else {
         this.field2469.unlinkDual();
         this.field2469 = null;
      }
   }
}
