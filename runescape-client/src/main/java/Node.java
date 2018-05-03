import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
@Implements("Node")
public class Node {
   @ObfuscatedName("cd")
   @Export("hash")
   public long hash;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   @Export("previous")
   Node previous;

   @ObfuscatedName("jn")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("jv")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
