import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dt")
@Implements("Node")
public class Node {
   @ObfuscatedName("ca")
   @Export("previous")
   Node previous;
   @ObfuscatedName("cp")
   @Export("hash")
   public long hash;
   @ObfuscatedName("ch")
   @Export("next")
   public Node next;

   @ObfuscatedName("fu")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("fb")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
