import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("cx")
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
