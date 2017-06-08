import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class220 {
   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1041240999"
   )
   static void method4084(Buffer var0) {
      if(Client.field1108 != null) {
         var0.putBytes(Client.field1108, 0, Client.field1108.length);
      } else {
         byte[] var2 = new byte[24];

         try {
            class155.field2257.method2337(0L);
            class155.field2257.method2347(var2);

            int var3;
            for(var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
               ;
            }

            if(var3 >= 24) {
               throw new IOException();
            }
         } catch (Exception var6) {
            for(int var4 = 0; var4 < 24; ++var4) {
               var2[var4] = -1;
            }
         }

         var0.putBytes(var2, 0, var2.length);
      }
   }

   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "(IZZZI)LIndexData;",
      garbageValue = "218144892"
   )
   static IndexData method4085(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class155.field2254 != null) {
         var4 = new IndexFile(var0, class155.field2254, class29.field432[var0], 1000000);
      }

      return new IndexData(var4, class54.field658, var0, var1, var2, var3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-428290227"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class98.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class98.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method1851(var0, var1, var2, var3);
      class98.field1524.method3494(var5, (long)var5.id);
      class98.field1525.method3680(var5);
      Client.field932 = Client.field1110;
   }
}
