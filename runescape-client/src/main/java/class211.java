import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class211 {
   @ObfuscatedName("m")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("p")
   public static int[] field2614;
   @ObfuscatedName("e")
   @Export("widgetSettings")
   public static int[] widgetSettings;

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1611798999"
   )
   static void method3817() {
      if(class46.field601 != null) {
         class46.field601.method5168(Player.plane, class19.baseX + (class20.localPlayer.x >> 7), (class20.localPlayer.y >> 7) + class21.baseY, false);
         class46.field601.method5066();
      }

   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "-8310"
   )
   static final void method3820(String var0) {
      if(var0 != null) {
         String var1 = class109.method1965(var0, class33.field482);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = class109.method1965(var4, class33.field482);
               if(class269.method4758(var0, var1, var4, var5)) {
                  --Client.ignoreCount;

                  for(int var6 = var2; var6 < Client.ignoreCount; ++var6) {
                     Client.ignores[var6] = Client.ignores[var6 + 1];
                  }

                  Client.field1099 = Client.field1091;
                  Client.secretPacketBuffer1.putOpcode(163);
                  Client.secretPacketBuffer1.putByte(Friend.method1023(var0));
                  Client.secretPacketBuffer1.method3125(var0);
                  break;
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1430004238"
   )
   static void method3822(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method3425((long)var0);
      if(var1 != null) {
         var1.unlink();
      }

   }

   static {
      field2614 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2614[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }
}
