import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gc")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cl")
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cy")
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("fu")
   public void method3894() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
