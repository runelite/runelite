import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bw")
@Implements("FriendLoginUpdate")
public class FriendLoginUpdate extends class207 {
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = 666648109
   )
   static int field786;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -410386081
   )
   int field787;
   @ObfuscatedName("v")
   String field783;
   @ObfuscatedName("y")
   short field785;

   FriendLoginUpdate(String var1, int var2) {
      this.field787 = (int)(class60.currentTimeMs() / 1000L);
      this.field783 = var1;
      this.field785 = (short)var2;
   }
}
