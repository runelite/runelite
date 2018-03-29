import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("IterableDualNodeQueue")
public class IterableDualNodeQueue implements Iterable {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("sentinel")
   public CacheableNode sentinel;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   CacheableNode field2665;

   public IterableDualNodeQueue() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("c")
   @Export("clear")
   public void clear() {
      while(this.sentinel.previous != this.sentinel) {
         this.sentinel.previous.unlinkDual();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lhv;)V"
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "()Lhv;"
   )
   CacheableNode method4103() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.unlinkDual();
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "()Lhv;"
   )
   CacheableNode method4100() {
      return this.method4101((CacheableNode)null);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lhv;)Lhv;"
   )
   CacheableNode method4101(CacheableNode var1) {
      CacheableNode var2;
      if(var1 == null) {
         var2 = this.sentinel.previous;
      } else {
         var2 = var1;
      }

      if(var2 == this.sentinel) {
         this.field2665 = null;
         return null;
      } else {
         this.field2665 = var2.previous;
         return var2;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "()Lhv;"
   )
   CacheableNode method4098() {
      CacheableNode var1 = this.field2665;
      if(var1 == this.sentinel) {
         this.field2665 = null;
         return null;
      } else {
         this.field2665 = var1.previous;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class226(this);
   }
}
