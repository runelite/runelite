import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
@Implements("Friend")
public class Friend extends Buddy {
   @ObfuscatedName("l")
   @Export("soundSystemExecutor")
   static ScheduledExecutorService soundSystemExecutor;
   @ObfuscatedName("m")
   boolean field354;
   @ObfuscatedName("f")
   boolean field355;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lkq;I)I",
      garbageValue = "-1559116693"
   )
   @Export("compareToFriend")
   int compareToFriend(Friend other) {
      return super.world == Client.worldId && Client.worldId != other.world ? -1 : (Client.worldId == other.world && super.world != Client.worldId ? 1 : (super.world != 0 && other.world == 0 ? -1 : (other.world != 0 && super.world == 0 ? 1 : (this.field354 && !other.field354 ? -1 : (!this.field354 && other.field354 ? 1 : (this.field355 && !other.field355 ? -1 : (!this.field355 && other.field355 ? 1 : (super.world != 0 ? super.int2 - other.int2 : other.int2 - super.int2))))))));
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljs;I)I",
      garbageValue = "1627362569"
   )
   @Export("compareToUser")
   public int compareToUser(User var1) {
      return this.compareToFriend((Friend)var1);
   }

   public int compareTo(Object var1) {
      return this.compareToFriend((Friend)var1);
   }
}
