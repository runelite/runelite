import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gp")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cy")
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("ct")
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("ck")
   public void method3520() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }

   }
}
