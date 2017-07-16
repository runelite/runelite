import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("cj")
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
