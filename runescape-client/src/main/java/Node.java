import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ew")
@Implements("Node")
public class Node {
   @ObfuscatedName("cl")
   @Export("next")
   public Node next;
   @ObfuscatedName("cg")
   @Export("previous")
   Node previous;
   @ObfuscatedName("cy")
   @Export("hash")
   public long hash;

   @ObfuscatedName("iy")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("it")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
