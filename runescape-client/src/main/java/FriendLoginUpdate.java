import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends Link {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("__kn_x")
   static UrlRequest __kn_x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1390885889
   )
   @Export("time")
   public int time;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("username")
   public Username username;
   @ObfuscatedName("o")
   @Export("world")
   public short world;

   @ObfuscatedSignature(
      signature = "(Lkp;I)V"
   )
   FriendLoginUpdate(Username var1, int var2) {
      this.time = (int)(class203.currentTimeMs() / 1000L);
      this.username = var1;
      this.world = (short)var2;
   }
}
