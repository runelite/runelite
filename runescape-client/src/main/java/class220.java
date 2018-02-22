import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class220 implements Iterator {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   IterableDualNodeQueue field2628;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   CacheableNode field2629;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   CacheableNode field2627;

   @ObfuscatedSignature(
      signature = "(Lha;)V"
   )
   class220(IterableDualNodeQueue var1) {
      this.field2627 = null;
      this.field2628 = var1;
      this.field2629 = this.field2628.sentinel.previous;
      this.field2627 = null;
   }

   public boolean hasNext() {
      return this.field2628.sentinel != this.field2629;
   }

   public void remove() {
      this.field2627.unlinkDual();
      this.field2627 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2629;
      if(var1 == this.field2628.sentinel) {
         var1 = null;
         this.field2629 = null;
      } else {
         this.field2629 = var1.previous;
      }

      this.field2627 = var1;
      return var1;
   }
}
