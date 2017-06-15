import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gh")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("p")
   @Export("sentinel")
   CacheableNode sentinel;

   @ObfuscatedName("e")
   CacheableNode method3371() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method3520();
         return var1;
      }
   }

   @ObfuscatedName("t")
   public CacheableNode method3372() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }

   @ObfuscatedName("m")
   public void method3376(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3520();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   public Node2LinkedList() {
      this.sentinel = new CacheableNode();
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("w")
   void method3383() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.method3520();
      }
   }

   @ObfuscatedName("p")
   public void method3387(CacheableNode var1) {
      if(var1.next != null) {
         var1.method3520();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }
}
