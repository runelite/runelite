import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("ep")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("f")
   Component field2186;
   @ObfuscatedName("c")
   static class215 field2188;

   public final void paint(Graphics var1) {
      this.field2186.paint(var1);
   }

   RSCanvas(Component var1) {
      this.field2186 = var1;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2082176540"
   )
   static final void method2965(boolean var0) {
      Client.field496 = 0;
      Client.field323 = 0;
      class77.method1657();
      class43.method866(var0);
      class48.method969();

      int var1;
      for(var1 = 0; var1 < Client.field496; ++var1) {
         int var2 = Client.field406[var1];
         if(Client.cachedNPCs[var2].field865 != Client.gameCycle) {
            Client.cachedNPCs[var2].composition = null;
            Client.cachedNPCs[var2] = null;
         }
      }

      if(Client.field328 != Client.field327.offset) {
         throw new RuntimeException(Client.field327.offset + "," + Client.field328);
      } else {
         for(var1 = 0; var1 < Client.field321; ++var1) {
            if(null == Client.cachedNPCs[Client.field405[var1]]) {
               throw new RuntimeException(var1 + "," + Client.field321);
            }
         }

      }
   }

   public final void update(Graphics var1) {
      this.field2186.update(var1);
   }
}
