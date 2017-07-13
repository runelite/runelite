import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("SoundTask")
public class SoundTask implements Runnable {
   @ObfuscatedName("a")
   @Export("systems")
   volatile AbstractSoundSystem[] systems;

   SoundTask() {
      this.systems = new AbstractSoundSystem[2];
   }

   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            AbstractSoundSystem var2 = this.systems[var1];
            if(var2 != null) {
               var2.method1985();
            }
         }
      } catch (Exception var4) {
         class54.method800((String)null, var4);
      }

   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-1676634311"
   )
   static final boolean method2059(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field958 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1177.method3935(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1177.method3939(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1177.method3951(false);
         }

         if(var1 == 325) {
            Client.field1177.method3951(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(60);
            Client.field1177.method3938(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }
}
