import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gf")
@Implements("Node")
public class Node {
   @ObfuscatedName("cc")
   @Export("hash")
   public long hash;
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Lgf;"
   )
   @Export("previous")
   Node previous;

   @ObfuscatedName("ju")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("jp")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
