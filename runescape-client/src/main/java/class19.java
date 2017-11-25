import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
final class class19 implements Comparator {
   @ObfuscatedName("di")
   @Export("host")
   static String host;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ly;Ly;I)I",
      garbageValue = "-605006531"
   )
   int method158(class14 var1, class14 var2) {
      return var1.field273 < var2.field273?-1:(var2.field273 == var1.field273?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method158((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "-1508624859"
   )
   static int method162(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class82.intStack[--class13.intStackSize];
         var4 = class87.method1762(var3);
      } else {
         var4 = var2?class54.field636:class82.field1265;
      }

      if(var0 == 1000) {
         class13.intStackSize -= 4;
         var4.originalX = class82.intStack[class13.intStackSize];
         var4.originalY = class82.intStack[class13.intStackSize + 1];
         var4.field2788 = class82.intStack[class13.intStackSize + 2];
         var4.field2730 = class82.intStack[class13.intStackSize + 3];
         class40.method556(var4);
         class287.clientInstance.method1213(var4);
         if(var3 != -1 && var4.type == 0) {
            NPCComposition.method4864(class11.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class13.intStackSize -= 4;
         var4.originalWidth = class82.intStack[class13.intStackSize];
         var4.field2736 = class82.intStack[class13.intStackSize + 1];
         var4.field2731 = class82.intStack[class13.intStackSize + 2];
         var4.buttonType = class82.intStack[class13.intStackSize + 3];
         class40.method556(var4);
         class287.clientInstance.method1213(var4);
         if(var3 != -1 && var4.type == 0) {
            NPCComposition.method4864(class11.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class82.intStack[--class13.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class40.method556(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = class82.intStack[--class13.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2826 = class82.intStack[--class13.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1561945710"
   )
   static final String method159(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + ISAACCipher.getColTags(65408) + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + ISAACCipher.getColTags(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + ISAACCipher.getColTags(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "620481250"
   )
   static final void method168() {
      PacketNode var0 = class218.method4105(ClientPacket.field2315, Client.field916.field1470);
      var0.packetBuffer.putByte(0);
      Client.field916.method1925(var0);
   }
}
