import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
@Implements("Node")
public class Node {
   @ObfuscatedName("ci")
   @Export("hash")
   public long hash;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   @Export("previous")
   Node previous;

   @ObfuscatedName("jk")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("jn")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
