import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class138 extends class283 {
   @ObfuscatedName("w")
   final boolean field1892;

   public class138(boolean var1) {
      this.field1892 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkd;Lkd;I)I",
      garbageValue = "1131558933"
   )
   int method3153(ChatPlayer var1, ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field1892?var1.getRsName().compareCleanName(var2.getRsName()):var2.getRsName().compareCleanName(var1.getRsName())):this.method5320(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3153((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1910296838"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      Varbit var2 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var7 = Varbit.varbit_ref.getConfigData(14, var0);
         var2 = new Varbit();
         if(var7 != null) {
            var2.decode(new Buffer(var7));
         }

         Varbit.varbits.put(var2, (long)var0);
         var1 = var2;
      }

      int var3 = var1.configId;
      int var4 = var1.leastSignificantBit;
      int var5 = var1.mostSignificantBit;
      int var6 = class225.varpsMasks[var5 - var4];
      return class225.clientVarps[var3] >> var4 & var6;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IZIZB)V",
      garbageValue = "74"
   )
   static void method3160(int var0, boolean var1, int var2, boolean var3) {
      if(class143.worldList != null) {
         TextureProvider.method2598(0, class143.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   static final void method3158(String var0) {
      PacketNode var1 = DecorativeObject.method3115(ClientPacket.field2237, Client.field739.field1250);
      var1.packetBuffer.putByte(Size.getLength(var0));
      var1.packetBuffer.putString(var0);
      Client.field739.method2019(var1);
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(Lhl;IIZI)V",
      garbageValue = "-443558683"
   )
   static void method3155(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.dynamicWidth == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.dynamicWidth == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.dynamicWidth == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.originalHeight;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.originalHeight;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.originalHeight >> 14;
      }

      if(var0.dynamicWidth == 4) {
         var0.width = var0.field2740 * var0.height / var0.field2641;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.width * var0.field2641 / var0.field2740;
      }

      if(var0.contentType == 1337) {
         Client.field776 = var0;
      }

      if(var3 && var0.onResizeListener != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.source = var0;
         var6.params = var0.onResizeListener;
         Client.field755.addFront(var6);
      }

   }
}
