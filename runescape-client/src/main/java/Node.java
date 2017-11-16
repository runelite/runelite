import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
@Implements("Node")
public class Node {
   @ObfuscatedName("cn")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lgt;"
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

   @ObfuscatedName("ji")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
