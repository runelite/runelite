import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class211 implements Iterator {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   IterableDualNodeQueue field2601;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   CacheableNode field2600;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   CacheableNode field2602;

   @ObfuscatedSignature(
      signature = "(Lhk;)V"
   )
   class211(IterableDualNodeQueue var1) {
      this.field2602 = null;
      this.field2601 = var1;
      this.field2600 = this.field2601.sentinel.previous;
      this.field2602 = null;
   }

   public boolean hasNext() {
      return this.field2601.sentinel != this.field2600;
   }

   public void remove() {
      if(this.field2602 == null) {
         throw new IllegalStateException();
      } else {
         this.field2602.unlinkDual();
         this.field2602 = null;
      }
   }

   public Object next() {
      CacheableNode var1 = this.field2600;
      if(var1 == this.field2601.sentinel) {
         var1 = null;
         this.field2600 = null;
      } else {
         this.field2600 = var1.previous;
      }

      this.field2602 = var1;
      return var1;
   }
}
