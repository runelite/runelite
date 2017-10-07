import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("hx")
public class class211 {
   @ObfuscatedName("d")
   static int[] field2619;
   @ObfuscatedName("k")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("e")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("gz")
   @ObfuscatedGetter(
      intValue = -570981729
   )
   @Export("cameraX")
   static int cameraX;

   static {
      field2619 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2619[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("d")
   public static final void method4044(long var0) {
      if(var0 > 0L) {
         if(var0 % 10L == 0L) {
            class47.method717(var0 - 1L);
            class47.method717(1L);
         } else {
            class47.method717(var0);
         }

      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2118650960"
   )
   public static void method4048() {
      if(class238.field3265 != null) {
         class238.field3265.close();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Lhz;",
      garbageValue = "2103670516"
   )
   public static BuildType[] method4047() {
      return new BuildType[]{BuildType.BUILD_LIVE, BuildType.LIVE, BuildType.WIP, BuildType.RC};
   }

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2034522301"
   )
   static final void method4049(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class23.preferences.hideRoofs = !class23.preferences.hideRoofs;
         class10.method58();
         if(class23.preferences.hideRoofs) {
            MessageNode.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            MessageNode.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if(Client.rights >= 2) {
         if(var0.equalsIgnoreCase("aabb")) {
            if(!class7.field243) {
               class7.field243 = true;
               class7.field244 = class11.field270;
            } else if(class7.field244 == class11.field270) {
               class7.field243 = true;
               class7.field244 = class11.field272;
            } else {
               class7.field243 = false;
            }
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            IndexFile.method3106();
         }

         if(var0.equalsIgnoreCase("errortest") && Client.socketType == 2) {
            throw new RuntimeException();
         }
      }

      Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_COMMAND);
      Client.secretPacketBuffer1.putByte(var0.length() + 1);
      Client.secretPacketBuffer1.putString(var0);
   }
}
