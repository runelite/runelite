import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
@Implements("Node")
public class Node {
   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("previous")
   Node previous;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cy")
   @Export("hash")
   public long hash;

   @ObfuscatedName("is")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("ii")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
