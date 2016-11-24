import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
public class class37 {
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 447804893
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = 214076307
   )
   static int field787;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1124372438"
   )
   @Export("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new ChatLineBuffer();
         class47.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.method904(var0, var1, var2, var3);
      class47.field925.method2373(var5, (long)var5.id);
      class47.field930.method2521(var5);
      Client.field477 = Client.field470;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "66"
   )
   public static int method765(int var0) {
      class194 var1 = class173.method3303(var0);
      int var2 = var1.field2850;
      int var3 = var1.field2848;
      int var4 = var1.field2852;
      int var5 = class146.field2034[var4 - var3];
      return class146.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1909199262"
   )
   static void method766(Widget var0, int var1, int var2) {
      if(var0.field2074 == 0) {
         var0.relativeX = var0.field2078;
      } else if(var0.field2074 == 1) {
         var0.relativeX = (var1 - var0.width) / 2 + var0.field2078;
      } else if(var0.field2074 == 2) {
         var0.relativeX = var1 - var0.width - var0.field2078;
      } else if(var0.field2074 == 3) {
         var0.relativeX = var0.field2078 * var1 >> 14;
      } else if(var0.field2074 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.field2078 * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.field2078 * var1 >> 14);
      }

      if(var0.field2075 == 0) {
         var0.relativeY = var0.field2087;
      } else if(var0.field2075 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.field2087;
      } else if(var0.field2075 == 2) {
         var0.relativeY = var2 - var0.height - var0.field2087;
      } else if(var0.field2075 == 3) {
         var0.relativeY = var0.field2087 * var2 >> 14;
      } else if(var0.field2075 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.field2087 >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.field2087 >> 14);
      }

      if(Client.field455 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[BLclass116;I)V",
      garbageValue = "2043219344"
   )
   static void method767(int var0, byte[] var1, class116 var2) {
      class180 var3 = new class180();
      var3.field2699 = 0;
      var3.hash = (long)var0;
      var3.field2700 = var1;
      var3.field2701 = var2;
      Deque var4 = class183.field2731;
      synchronized(class183.field2731) {
         class183.field2731.method2454(var3);
      }

      class36.method750();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   static final void method768() {
      int var0 = Client.field351 + class40.localPlayer.x;
      int var1 = Client.field353 + class40.localPlayer.y;
      if(class47.field926 - var0 < -500 || class47.field926 - var0 > 500 || MessageNode.field223 - var1 < -500 || MessageNode.field223 - var1 > 500) {
         class47.field926 = var0;
         MessageNode.field223 = var1;
      }

      if(class47.field926 != var0) {
         class47.field926 += (var0 - class47.field926) / 16;
      }

      if(var1 != MessageNode.field223) {
         MessageNode.field223 += (var1 - MessageNode.field223) / 16;
      }

      int var2;
      int var3;
      if(class115.field1801 == 4 && MessageNode.field229) {
         var2 = class115.field1810 - Client.field376;
         Client.field374 = var2 * 2;
         Client.field376 = var2 != -1 && var2 != 1?(Client.field376 + class115.field1810) / 2:class115.field1810;
         var3 = Client.field375 - class115.field1811;
         Client.field486 = var3 * 2;
         Client.field375 = var3 != -1 && var3 != 1?(Client.field375 + class115.field1811) / 2:class115.field1811;
      } else {
         if(class105.field1709[96]) {
            Client.field486 += (-24 - Client.field486) / 2;
         } else if(class105.field1709[97]) {
            Client.field486 += (24 - Client.field486) / 2;
         } else {
            Client.field486 /= 2;
         }

         if(class105.field1709[98]) {
            Client.field374 += (12 - Client.field374) / 2;
         } else if(class105.field1709[99]) {
            Client.field374 += (-12 - Client.field374) / 2;
         } else {
            Client.field374 /= 2;
         }

         Client.field376 = class115.field1810;
         Client.field375 = class115.field1811;
      }

      Client.mapAngle = Client.mapAngle + Client.field486 / 2 & 2047;
      Client.field534 += Client.field374 / 2;
      if(Client.field534 < 128) {
         Client.field534 = 128;
      }

      if(Client.field534 > 383) {
         Client.field534 = 383;
      }

      var2 = class47.field926 >> 7;
      var3 = MessageNode.field223 >> 7;
      int var4 = class11.method161(class47.field926, MessageNode.field223, class166.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= 4 + var3; ++var7) {
               int var8 = class166.plane;
               if(var8 < 3 && (class11.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class11.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = 192 * var5;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > Client.field380) {
         Client.field380 += (var6 - Client.field380) / 24;
      } else if(var6 < Client.field380) {
         Client.field380 += (var6 - Client.field380) / 80;
      }

   }
}
