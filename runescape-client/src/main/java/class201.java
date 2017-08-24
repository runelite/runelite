import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class201 implements Iterator {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   class202 field2491;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   CacheableNode field2490;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   CacheableNode field2489;

   @ObfuscatedSignature(
      signature = "(Lgj;)V"
   )
   class201(class202 var1) {
      this.field2489 = null;
      this.field2491 = var1;
      this.field2490 = this.field2491.field2492.previous;
      this.field2489 = null;
   }

   public Object next() {
      CacheableNode var1 = this.field2490;
      if(var1 == this.field2491.field2492) {
         var1 = null;
         this.field2490 = null;
      } else {
         this.field2490 = var1.previous;
      }

      this.field2489 = var1;
      return var1;
   }

   public boolean hasNext() {
      return this.field2491.field2492 != this.field2490;
   }

   public void remove() {
      this.field2489.unlinkDual();
      this.field2489 = null;
   }
}
