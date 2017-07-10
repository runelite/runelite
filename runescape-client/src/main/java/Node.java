import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gm")
@Implements("Node")
public class Node {
   @ObfuscatedName("cf")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cc")
   @Export("next")
   public Node next;
   @ObfuscatedName("cp")
   @Export("previous")
   Node previous;

   @ObfuscatedName("ip")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("ir")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
