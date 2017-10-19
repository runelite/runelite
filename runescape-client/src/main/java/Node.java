import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("Node")
public class Node {
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("previous")
   Node previous;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cw")
   @Export("hash")
   public long hash;

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

   @ObfuscatedName("jp")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
