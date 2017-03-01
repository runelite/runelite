import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("di")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cs")
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("ch")
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("cz")
   public void method2513() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
