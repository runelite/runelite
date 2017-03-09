import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dp")
@Implements("Node")
public class Node {
   @ObfuscatedName("cl")
   @Export("previous")
   Node previous;
   @ObfuscatedName("cn")
   @Export("next")
   public Node next;
   @ObfuscatedName("cx")
   @Export("hash")
   public long hash;

   @ObfuscatedName("ek")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("eg")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
