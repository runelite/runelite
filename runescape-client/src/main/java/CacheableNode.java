import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("df")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cy")
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cz")
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("cc")
   public void method2476() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
