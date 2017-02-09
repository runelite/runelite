import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dz")
@Implements("Node2LinkedList")
public final class Node2LinkedList {
   @ObfuscatedName("k")
   @Export("sentinel")
   CacheableNode sentinel = new CacheableNode();

   @ObfuscatedName("o")
   CacheableNode method2281() {
      CacheableNode var1 = this.sentinel.previous;
      if(var1 == this.sentinel) {
         return null;
      } else {
         var1.method2411();
         return var1;
      }
   }

   @ObfuscatedName("k")
   public void method2282(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2411();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("r")
   public CacheableNode method2283() {
      CacheableNode var1 = this.sentinel.previous;
      return var1 == this.sentinel?null:var1;
   }

   @ObfuscatedName("w")
   void method2286() {
      while(true) {
         CacheableNode var1 = this.sentinel.previous;
         if(var1 == this.sentinel) {
            return;
         }

         var1.method2411();
      }
   }

   public Node2LinkedList() {
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("y")
   public void method2290(CacheableNode var1) {
      if(var1.next != null) {
         var1.method2411();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }
}
