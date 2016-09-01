import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cl")
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("ct")
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("fn")
   public void method3925() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
