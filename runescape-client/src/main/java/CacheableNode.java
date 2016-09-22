import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gb")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("ct")
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cn")
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("fe")
   public void method3938() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
