import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("IterableDualNodeQueue")
public class IterableDualNodeQueue implements Iterable {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   @Export("sentinel")
   public CacheableNode sentinel;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   CacheableNode field2658;

   public IterableDualNodeQueue() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("t")
   @Export("clear")
   public void clear() {
      while(this.sentinel.previous != this.sentinel) {
         this.sentinel.previous.unlinkDual();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lhh;)V"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "()Lhh;"
   )
   CacheableNode method4120() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.unlinkDual();
         return var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "()Lhh;"
   )
   CacheableNode method4121() {
      return this.method4122((CacheableNode)null);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lhh;)Lhh;"
   )
   CacheableNode method4122(CacheableNode var1) {
      CacheableNode var2;
      if(var1 == null) {
         var2 = this.sentinel.previous;
      } else {
         var2 = var1;
      }

      if(var2 == this.sentinel) {
         this.field2658 = null;
         return null;
      } else {
         this.field2658 = var2.previous;
         return var2;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "()Lhh;"
   )
   CacheableNode method4138() {
      CacheableNode var1 = this.field2658;
      if(var1 == this.sentinel) {
         this.field2658 = null;
         return null;
      } else {
         this.field2658 = var1.previous;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class226(this);
   }
}
