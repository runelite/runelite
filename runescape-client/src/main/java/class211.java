import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class211 implements Iterator {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   IterableDualNodeQueue field2578;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   CacheableNode field2577;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   CacheableNode field2579;

   @ObfuscatedSignature(
      signature = "(Lhc;)V"
   )
   class211(IterableDualNodeQueue var1) {
      this.field2579 = null;
      this.field2578 = var1;
      this.field2577 = this.field2578.sentinel.previous;
      this.field2579 = null;
   }

   public boolean hasNext() {
      return this.field2578.sentinel != this.field2577;
   }

   public void remove() {
      if(this.field2579 == null) {
         throw new IllegalStateException();
      } else {
         this.field2579.unlinkDual();
         this.field2579 = null;
      }
   }

   public Object next() {
      CacheableNode var1 = this.field2577;
      if(var1 == this.field2578.sentinel) {
         var1 = null;
         this.field2577 = null;
      } else {
         this.field2577 = var1.previous;
      }

      this.field2579 = var1;
      return var1;
   }
}
