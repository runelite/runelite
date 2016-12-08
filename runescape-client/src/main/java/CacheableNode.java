import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dn")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cc")
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("ci")
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("cp")
   public void method2380() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
