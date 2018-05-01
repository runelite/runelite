import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
final class class19 implements Comparator {
   @ObfuscatedName("ry")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   public static class265 field326;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = 1750551169
   )
   static int field325;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -915815443
   )
   @Export("canvasHeight")
   public static int canvasHeight;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lp;Lp;I)I",
      garbageValue = "-1537427"
   )
   int method153(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.field287 < var2.field287?-1:(var1.field287 == var2.field287?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method153((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-866068244"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class264.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class264.NetCache_socket.vmethod3411(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class264.NetCache_socket.vmethod3404();
            } catch (Exception var3) {
               ;
            }

            ++class264.field3415;
            class264.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-2091086778"
   )
   static String method162() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class95.messages.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }
}
