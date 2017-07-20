import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("Node")
public class Node {
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("previous")
   Node previous;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cb")
   @Export("hash")
   public long hash;

   @ObfuscatedName("it")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("ic")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
