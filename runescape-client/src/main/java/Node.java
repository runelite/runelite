import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
@Implements("Node")
public class Node {
   @ObfuscatedName("ce")
   @Export("hash")
   public long hash;
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   @Export("next")
   public Node next;
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Lhx;"
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

   @ObfuscatedName("kg")
   @Export("linked")
   public boolean linked() {
      return this.previous != null;
   }
}
