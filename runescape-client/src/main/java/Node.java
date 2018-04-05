import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("Node")
public class Node {
   @ObfuscatedName("cc")
   @Export("hash")
   public long hash;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("previous")
   Node previous;

   @ObfuscatedName("jm")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("jq")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
