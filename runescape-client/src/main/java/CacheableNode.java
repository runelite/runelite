import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("CacheableNode")
public class CacheableNode extends Node {
   @ObfuscatedName("cb")
   long field2647;
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("previous")
   public CacheableNode previous;
   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "Lhv;"
   )
   @Export("next")
   public CacheableNode next;

   @ObfuscatedName("co")
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
