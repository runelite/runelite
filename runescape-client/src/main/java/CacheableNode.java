import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("ci")
   @Export("unlinkDual")
   public void unlinkDual() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
