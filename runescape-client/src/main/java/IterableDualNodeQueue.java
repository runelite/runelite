import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
@Implements("IterableDualNodeQueue")
public class IterableDualNodeQueue implements Iterable {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("sentinel")
   public CacheableNode sentinel;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   CacheableNode field2470;

   public IterableDualNodeQueue() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("w")
   @Export("clear")
   public void clear() {
      while(this.sentinel.previous != this.sentinel) {
         this.sentinel.previous.unlinkDual();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgc;)V"
   )
   @Export("add")
   public void add(CacheableNode var1) {
      if(var1.next != null) {
         var1.unlinkDual();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "()Lgc;"
   )
   CacheableNode method4184() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.unlinkDual();
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lgc;"
   )
   CacheableNode method4185() {
      return this.method4186((CacheableNode)null);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgc;)Lgc;"
   )
   CacheableNode method4186(CacheableNode var1) {
      CacheableNode var2;
      if(var1 == null) {
         var2 = this.sentinel.previous;
      } else {
         var2 = var1;
      }

      if(var2 == this.sentinel) {
         this.field2470 = null;
         return null;
      } else {
         this.field2470 = var2.previous;
         return var2;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Lgc;"
   )
   CacheableNode method4187() {
      CacheableNode var1 = this.field2470;
      if(var1 == this.sentinel) {
         this.field2470 = null;
         return null;
      } else {
         this.field2470 = var1.previous;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class214(this);
   }
}
