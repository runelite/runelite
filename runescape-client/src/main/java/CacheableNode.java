import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("cn")
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
