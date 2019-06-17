import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
@Implements("Node")
public class Node {
   @ObfuscatedName("cl")
   @Export("key")
   public long key;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("previous")
   public Node previous;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   @Export("next")
   public Node next;

   @ObfuscatedName("es")
   @Export("remove")
   public void remove() {
      if(this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }

   }

   @ObfuscatedName("eg")
   @Export("hasNext")
   public boolean hasNext() {
      return this.next != null;
   }
}
