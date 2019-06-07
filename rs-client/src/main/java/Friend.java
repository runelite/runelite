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
   @Export("__m")
   boolean __m;
   @ObfuscatedName("f")
   @Export("__f")
   boolean __f;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lkq;I)I",
      garbageValue = "-1559116693"
   )
   @Export("compareTo00")
   int compareTo00(Friend var1) {
      return super.world0 == Client.worldId && Client.worldId != var1.world0?-1:(Client.worldId == var1.world0 && super.world0 != Client.worldId?1:(super.world0 != 0 && var1.world0 == 0?-1:(var1.world0 != 0 && super.world0 == 0?1:(this.__m && !var1.__m?-1:(!this.__m && var1.__m?1:(this.__f && !var1.__f?-1:(!this.__f && var1.__f?1:(super.world0 != 0?super.int2 - var1.int2:var1.int2 - super.int2))))))));
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljs;I)I",
      garbageValue = "1627362569"
   )
   public int compareTo0(User var1) {
      return this.compareTo00((Friend)var1);
   }

   @ObfuscatedName("compareTo")
   public int compareTo(Object var1) {
      return this.compareTo00((Friend)var1);
   }
}
