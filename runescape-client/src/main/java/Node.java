import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
@Implements("Node")
public class Node {
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("previous")
   Node previous;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cn")
   @Export("hash")
   public long hash;

   @ObfuscatedName("io")
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
