import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
@Implements("IterableDualNodeQueue")
public class IterableDualNodeQueue implements Iterable {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   @Export("sentinel")
   public CacheableNode sentinel;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   CacheableNode field2675;

   public IterableDualNodeQueue() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("d")
   @Export("clear")
   public void clear() {
      while(this.sentinel.previous != this.sentinel) {
         this.sentinel.previous.unlinkDual();
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lhu;)V"
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "()Lhu;"
   )
   CacheableNode method4216() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.unlinkDual();
         return var1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "()Lhu;"
   )
   CacheableNode method4222() {
      return this.method4220((CacheableNode)null);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lhu;)Lhu;"
   )
   CacheableNode method4220(CacheableNode var1) {
      CacheableNode var2;
      if(var1 == null) {
         var2 = this.sentinel.previous;
      } else {
         var2 = var1;
      }

      if(var2 == this.sentinel) {
         this.field2675 = null;
         return null;
      } else {
         this.field2675 = var2.previous;
         return var2;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "()Lhu;"
   )
   CacheableNode method4219() {
      CacheableNode var1 = this.field2675;
      if(var1 == this.sentinel) {
         this.field2675 = null;
         return null;
      } else {
         this.field2675 = var1.previous;
         return var1;
      }
   }

   public Iterator iterator() {
      return new class226(this);
   }
}
