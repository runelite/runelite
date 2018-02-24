import java.io.File;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public final class class29 {
   @ObfuscatedName("a")
   public static File field387;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1431190667
   )
   int field391;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 249268257
   )
   int field390;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1698213149
   )
   int field389;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1204053455
   )
   int field388;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lag;"
   )
   final WorldMapManager this$0;

   @ObfuscatedSignature(
      signature = "(Lag;)V"
   )
   class29(WorldMapManager var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;I)V",
      garbageValue = "336003518"
   )
   public static void method269(IndexDataBase var0) {
      class271.field3476 = var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1918960041"
   )
   static final void method273() {
      if(!class131.Viewport_false0) {
         int var0 = Region.pitchSin;
         int var1 = Region.pitchCos;
         int var2 = Region.yawSin;
         int var3 = Region.yawCos;
         byte var4 = 50;
         short var5 = 3500;
         int var6 = (class131.Viewport_mouseX - Graphics3D.centerX) * var4 / Graphics3D.Rasterizer3D_zoom;
         int var7 = (class131.Viewport_mouseY - Graphics3D.centerY) * var4 / Graphics3D.Rasterizer3D_zoom;
         int var8 = (class131.Viewport_mouseX - Graphics3D.centerX) * var5 / Graphics3D.Rasterizer3D_zoom;
         int var9 = (class131.Viewport_mouseY - Graphics3D.centerY) * var5 / Graphics3D.Rasterizer3D_zoom;
         int var10 = Graphics3D.method2874(var7, var4, var1, var0);
         int var11 = Graphics3D.method2828(var7, var4, var1, var0);
         var7 = var10;
         var10 = Graphics3D.method2874(var9, var5, var1, var0);
         int var12 = Graphics3D.method2828(var9, var5, var1, var0);
         var9 = var10;
         var10 = Graphics3D.method2825(var6, var11, var3, var2);
         var11 = Graphics3D.method2873(var6, var11, var3, var2);
         var6 = var10;
         var10 = Graphics3D.method2825(var8, var12, var3, var2);
         var12 = Graphics3D.method2873(var8, var12, var3, var2);
         class177.field2251 = (var6 + var10) / 2;
         class153.field2091 = (var9 + var7) / 2;
         UnitPriceComparator.field294 = (var11 + var12) / 2;
         class131.field1875 = (var10 - var6) / 2;
         SoundTaskDataProvider.field599 = (var9 - var7) / 2;
         class131.field1872 = (var12 - var11) / 2;
         OwnWorldComparator.field813 = Math.abs(class131.field1875);
         class18.field300 = Math.abs(SoundTaskDataProvider.field599);
         GrandExchangeEvent.field274 = Math.abs(class131.field1872);
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "172004586"
   )
   protected static int method272() {
      int var0 = 0;
      if(class33.field430 == null || !class33.field430.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if(var2.isValid()) {
                  class33.field430 = var2;
                  GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                  GameEngine.garbageCollectorLastCollectionTime = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if(class33.field430 != null) {
         long var9 = class188.currentTimeMs();
         long var3 = class33.field430.getCollectionTime();
         if(-1L != GameEngine.garbageCollectorLastCollectionTime) {
            long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
            long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
            if(0L != var7) {
               var0 = (int)(100L * var5 / var7);
            }
         }

         GameEngine.garbageCollectorLastCollectionTime = var3;
         GameEngine.garbageCollectorLastCheckTimeMs = var9;
      }

      return var0;
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1545575090"
   )
   static final void method270() {
      Client.myPlayerIndex = 0;
      int var0 = (OwnWorldComparator.localPlayer.x >> 7) + ScriptState.baseX;
      int var1 = (OwnWorldComparator.localPlayer.y >> 7) + WorldMapType1.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.myPlayerIndex = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.myPlayerIndex = 1;
      }

      if(Client.myPlayerIndex == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.myPlayerIndex = 0;
      }

   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(Lim;I)Z",
      garbageValue = "-720001973"
   )
   static final boolean method271(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field864 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1068.method4393(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1068.method4401(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1068.method4414(false);
         }

         if(var1 == 325) {
            Client.field1068.method4414(true);
         }

         if(var1 == 326) {
            PacketNode var4 = class61.method1076(ClientPacket.field2398, Client.field863.field1434);
            Client.field1068.method4396(var4.packetBuffer);
            Client.field863.method2039(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
