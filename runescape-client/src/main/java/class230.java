import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class230 extends CacheableNode {
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = 1352067349
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 821556905
   )
   public final int field2732;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1453549347
   )
   public final int field2730;
   @ObfuscatedName("o")
   public final int[] field2731;
   @ObfuscatedName("p")
   public final int[] field2733;

   class230(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2732 = var1;
      this.field2730 = var2;
      this.field2731 = var3;
      this.field2733 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2023244014"
   )
   public boolean method4362(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2733.length) {
         int var3 = this.field2733[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2731[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "18"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class258.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class258.NetCache_socket.vmethod3323(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class258.NetCache_socket.vmethod3317();
            } catch (Exception var3) {
               ;
            }

            ++class258.field3374;
            class258.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Lji;",
      garbageValue = "-31"
   )
   public static class263 method4363(int var0) {
      class263 var1 = (class263)class263.field3411.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class263.field3412.getConfigData(19, var0);
         var1 = new class263();
         if(var2 != null) {
            var1.method4765(new Buffer(var2));
         }

         class263.field3411.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(Lim;I)I",
      garbageValue = "1188663159"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.value:var0.config;
   }
}
