import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("SoundSystem")
public class SoundSystem implements Runnable {
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -631434243
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lco;"
   )
   @Export("players")
   volatile PcmPlayer[] players;

   SoundSystem() {
      this.players = new PcmPlayer[2];
   }

   @Export("run")
   @ObfuscatedName("run")
   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            PcmPlayer var2 = this.players[var1];
            if(var2 != null) {
               var2.run();
            }
         }
      } catch (Exception var4) {
         NpcDefinition.sendStackTrace((String)null, var4);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Lcg;",
      garbageValue = "1479630296"
   )
   static Script method2451(int var0) {
      Script var1 = (Script)Script.Script_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Formatting.indexCache12.takeRecord(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = Occluder.newScript(var2);
            Script.Script_cached.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
   )
   static void method2456() {
      WorldMapRegion.__av_o.clear();
   }
}
