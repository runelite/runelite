import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class201 implements Iterator {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   class202 field2468;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   CacheableNode field2469;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   CacheableNode field2467;

   @ObfuscatedSignature(
      signature = "(Lgj;)V"
   )
   class201(class202 var1) {
      this.field2467 = null;
      this.field2468 = var1;
      this.field2469 = this.field2468.field2470.previous;
      this.field2467 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2469;
      if(var1 == this.field2468.field2470) {
         var1 = null;
         this.field2469 = null;
      } else {
         this.field2469 = var1.previous;
      }

      this.field2467 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2468.field2470 != this.field2469;
   }

   public void remove() {
      if(this.field2467 == null) {
         throw new IllegalStateException();
      } else {
         this.field2467.unlinkDual();
         this.field2467 = null;
      }
   }
}
