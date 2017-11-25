import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 1642849179
   )
   @Export("modelHeight")
   public int modelHeight;

   protected Renderable() {
      this.modelHeight = 1000;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Leh;",
      garbageValue = "-473112722"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cl")
   @Export("draw")
   void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-9"
   )
   static final void method2993() {
      Client.field916.method1930();
      class235.method4236();
      class14.region.reset();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].reset();
      }

      System.gc();
      class2.method6(2);
      Client.field1090 = -1;
      Client.field1095 = false;
      class66.method1113();
      class12.setGameState(10);
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(Lhx;I)Z",
      garbageValue = "764781075"
   )
   static final boolean method2994(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field1108 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1125.method4126(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1125.method4127(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1125.method4152(false);
         }

         if(var1 == 325) {
            Client.field1125.method4152(true);
         }

         if(var1 == 326) {
            PacketNode var4 = class218.method4105(ClientPacket.field2370, Client.field916.field1470);
            Client.field1125.method4129(var4.packetBuffer);
            Client.field916.method1925(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
