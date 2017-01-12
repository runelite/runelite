import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dg")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("u")
   @Export("sentinel")
   CacheableNode sentinel = new CacheableNode();

   @ObfuscatedName("a")
   public CacheableNode method2281() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }

   public Node2LinkedList() {
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("i")
   CacheableNode method2283() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method2413();
         return var1;
      }
   }

   @ObfuscatedName("x")
   public void method2285(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2413();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("u")
   public void method2292(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2413();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("c")
   void method2296() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.method2413();
      }
   }
}
