import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("db")
@Implements("Node")
public class Node {
   @ObfuscatedName("cy")
   @Export("next")
   public Node next;
   @ObfuscatedName("cs")
   @Export("previous")
   Node previous;
   @ObfuscatedName("ch")
   @Export("hash")
   public long hash;

   @ObfuscatedName("fp")
   @Export("unlink")
   public void unlink() {
      if(this.previous != null) {
         this.previous.next = this.next;
         this.next.previous = this.previous;
         this.next = null;
         this.previous = null;
      }
   }

   @ObfuscatedName("fd")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
