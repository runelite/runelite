import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("ch")
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("cx")
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("fp")
   public void method3968() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
