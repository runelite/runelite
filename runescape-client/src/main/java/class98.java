import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class98 {
   @ObfuscatedName("p")
   static final class186 field1524;
   @ObfuscatedName("i")
   static final class201 field1525;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -669042591
   )
   static int field1526;
   @ObfuscatedName("n")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("ii")
   static Widget field1529;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 423325975
   )
   static int field1530;

   static {
      chatLineMap = new HashMap();
      field1524 = new class186(1024);
      field1525 = new class201();
      field1530 = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "2094822467"
   )
   public static final boolean method1813(String var0, String var1, String var2, String var3) {
      return var0 != null && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1183011194"
   )
   static final void method1816() {
      Client.secretPacketBuffer2.method3399();
      int var0 = Client.secretPacketBuffer2.method3400(8);
      int var1;
      if(var0 < Client.field952) {
         for(var1 = var0; var1 < Client.field952; ++var1) {
            Client.field1039[++Client.field950 - 1] = Client.field953[var1];
         }
      }

      if(var0 > Client.field952) {
         throw new RuntimeException("");
      } else {
         Client.field952 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.field953[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.secretPacketBuffer2.method3400(1);
            if(var4 == 0) {
               Client.field953[++Client.field952 - 1] = var2;
               var3.field1261 = Client.gameCycle;
            } else {
               int var5 = Client.secretPacketBuffer2.method3400(2);
               if(var5 == 0) {
                  Client.field953[++Client.field952 - 1] = var2;
                  var3.field1261 = Client.gameCycle;
                  Client.field955[++Client.field954 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.field953[++Client.field952 - 1] = var2;
                     var3.field1261 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.method3400(3);
                     var3.method1666(var6, (byte)1);
                     var7 = Client.secretPacketBuffer2.method3400(1);
                     if(var7 == 1) {
                        Client.field955[++Client.field954 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.field953[++Client.field952 - 1] = var2;
                     var3.field1261 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.method3400(3);
                     var3.method1666(var6, (byte)2);
                     var7 = Client.secretPacketBuffer2.method3400(3);
                     var3.method1666(var7, (byte)2);
                     int var8 = Client.secretPacketBuffer2.method3400(1);
                     if(var8 == 1) {
                        Client.field955[++Client.field954 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field1039[++Client.field950 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-352821018"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class220.addChatMessage(var0, var1, var2, (String)null);
   }
}
