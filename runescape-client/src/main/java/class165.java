import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class165 {
   @ObfuscatedName("r")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "424733630"
   )
   public static int method3159(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lii;Ljava/lang/String;Ljava/lang/String;B)Lkd;",
      garbageValue = "-100"
   )
   public static SpritePixels method3157(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class255.method4507(var0, var3, var4);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1487479936"
   )
   public static void method3158() {
      class225.field2856.method3772();
      class204.field2507 = 1;
      class204.field2508 = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;I)Ljava/lang/String;",
      garbageValue = "808495181"
   )
   public static String method3151(Buffer var0) {
      String var1;
      try {
         int var2 = var0.getUSmart();
         if(var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class266.field3656.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = Varbit.getString(var3, 0, var2);
         var1 = var4;
      } catch (Exception var6) {
         var1 = "Cabbage";
      }

      return var1;
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(Lhx;I)Z",
      garbageValue = "1284862312"
   )
   static final boolean method3153(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field1058 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1078.method4005(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1078.method3997(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1078.method4004(false);
         }

         if(var1 == 325) {
            Client.field1078.method4004(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(71);
            Client.field1078.method3996(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }
}
