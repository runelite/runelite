import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
public class class280 {
   @ObfuscatedName("p")
   public static CombatInfoList field3749;
   @ObfuscatedName("m")
   static IndexDataBase field3751;

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-126"
   )
   static final void method4814() {
      Client.field1025 = 0;
      int var0 = (class20.localPlayer.x >> 7) + class19.baseX;
      int var1 = (class20.localPlayer.y >> 7) + class21.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field1025 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field1025 = 1;
      }

      if(Client.field1025 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field1025 = 0;
      }

   }

   static {
      field3749 = new CombatInfoList();
   }
}
