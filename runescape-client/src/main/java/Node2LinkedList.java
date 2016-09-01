import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gs")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("x")
   @Export("sentinel")
   CacheableNode sentinel = new CacheableNode();

   public Node2LinkedList() {
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("i")
   void method3906() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.method3925();
      }
   }

   @ObfuscatedName("z")
   public CacheableNode method3908() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }

   @ObfuscatedName("r")
   public void method3918(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3925();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("x")
   public void method3920(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3925();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("j")
   CacheableNode method3924() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method3925();
         return var1;
      }
   }
}
