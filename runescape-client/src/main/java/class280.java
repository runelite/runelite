import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
public class class280 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static CombatInfoList field3753;
   @ObfuscatedName("s")
   static ScheduledExecutorService field3754;

   static {
      field3753 = new CombatInfoList();
   }
}
