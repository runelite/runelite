import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class174 {
   @ObfuscatedName("m")
   static byte[][] field2402;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -927023337
   )
   static int field2403;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 230155529
   )
   static int field2404;
   @ObfuscatedName("j")
   static byte[][] field2405;
   @ObfuscatedName("f")
   static byte[][] field2406;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1594219691
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 539241415
   )
   static int field2409;
   @ObfuscatedName("z")
   public static int[] field2410;

   static {
      field2404 = 0;
      field2403 = 0;
      field2409 = 0;
      field2405 = new byte[1000][];
      field2406 = new byte[250][];
      field2402 = new byte[50][];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[Lclass283;",
      garbageValue = "1082451622"
   )
   public static class283[] method3356() {
      return new class283[]{class283.field3766, class283.field3767, class283.field3764, class283.field3765, class283.field3769};
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "82"
   )
   static synchronized byte[] method3357(int var0) {
      byte[] var1;
      if(var0 == 100 && field2404 > 0) {
         var1 = field2405[--field2404];
         field2405[field2404] = null;
         return var1;
      } else if(var0 == 5000 && field2403 > 0) {
         var1 = field2406[--field2403];
         field2406[field2403] = null;
         return var1;
      } else if(var0 == 30000 && field2409 > 0) {
         var1 = field2402[--field2409];
         field2402[field2409] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-64"
   )
   static final void method3358(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class66.field801.field1318 = !class66.field801.field1318;
         WorldMapType3.method232();
         if(class66.field801.field1318) {
            class98.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            class98.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.field928 = !Client.field928;
      }

      if(var0.equalsIgnoreCase("clickbox")) {
         Model.field1944 = !Model.field1944;
         class98.sendGameMessage(99, "", "Clickbox Mode: " + (Model.field1944?"AABB":"Legacy"));
      }

      if(Client.rights >= 2) {
         if(var0.equalsIgnoreCase("aabb")) {
            if(!class7.field231) {
               class7.field231 = true;
               class7.field234 = class11.field266;
               class98.sendGameMessage(99, "", "AABB boxes: All");
            } else if(class11.field266 == class7.field234) {
               class7.field231 = true;
               class7.field234 = class11.field268;
               class98.sendGameMessage(99, "", "AABB boxes: Mouse Over");
            } else {
               class7.field231 = false;
               class98.sendGameMessage(99, "", "AABB boxes: Off");
            }
         }

         if(var0.equalsIgnoreCase("legacyboxes")) {
            class7.field232 = !class7.field232;
            class98.sendGameMessage(99, "", "Show legacy boxes: " + class7.field232);
         }

         if(var0.equalsIgnoreCase("geotests")) {
            class7.field235 = !class7.field235;
            class98.sendGameMessage(99, "", "Show geometry tests: " + class7.field235);
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.field928 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.field928 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            class210.method3941();
         }

         if(var0.equalsIgnoreCase("errortest") && Client.field915 == 2) {
            throw new RuntimeException();
         }
      }

      Client.secretPacketBuffer1.putOpcode(254);
      Client.secretPacketBuffer1.putByte(var0.length() + 1);
      Client.secretPacketBuffer1.method3150(var0);
   }
}
