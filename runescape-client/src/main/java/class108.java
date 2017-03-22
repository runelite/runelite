import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
public class class108 {
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 6748151
   )
   public static int field1748;
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = 1410384925
   )
   @Export("cameraYaw")
   static int cameraYaw;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass187;",
      garbageValue = "-484601743"
   )
   public static class187 method2103(int var0) {
      class187 var1 = (class187)class187.field2771.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class187.field2770.getConfigData(16, var0);
         var1 = new class187();
         if(var2 != null) {
            var1.method3453(new Buffer(var2));
         }

         class187.field2771.put(var1, (long)var0);
         return var1;
      }
   }

   class108() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "870149933"
   )
   static final void method2104() {
      Client.field309.putOpcode(66);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2391(); var0 != null; var0 = (WidgetNode)Client.componentTable.method2392()) {
         if(var0.field212 == 0 || var0.field212 == 3) {
            XGrandExchangeOffer.method65(var0, true);
         }
      }

      if(null != Client.field477) {
         class2.method36(Client.field477);
         Client.field477 = null;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "613267658"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(null == World.worldServersDownload) {
            World.worldServersDownload = new class26(class72.field1193, new URL(class3.field33));
         } else {
            byte[] var0 = World.worldServersDownload.method601();
            if(null != var0) {
               Buffer var1 = new Buffer(var0);
               World.field697 = var1.readUnsignedShort();
               World.worldList = new World[World.field697];

               World var3;
               for(int var2 = 0; var2 < World.field697; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.readInt();
                  var3.address = var1.readString();
                  var3.activity = var1.readString();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class115.method2274(World.worldList, 0, World.worldList.length - 1, World.field694, World.field708);
               World.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         World.worldServersDownload = null;
      }

      return false;
   }
}
