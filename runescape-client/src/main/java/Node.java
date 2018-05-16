import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("Node")
public class Node {
   @ObfuscatedName("cb")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("previous")
   Node previous;

   @ObfuscatedName("kc")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("kz")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
