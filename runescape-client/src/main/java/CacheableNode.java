import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("next")
   public CacheableNode next;

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
