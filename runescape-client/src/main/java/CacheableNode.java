import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gz")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("next")
   public CacheableNode next;
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("previous")
   public CacheableNode previous;

   @ObfuscatedName("db")
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
