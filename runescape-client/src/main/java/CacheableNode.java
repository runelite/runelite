import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ev")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cn")
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("ce")
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("cs")
   public void method2851() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
