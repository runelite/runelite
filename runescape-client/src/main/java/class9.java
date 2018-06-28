import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class9 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   static IndexDataBase field63;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1670366999
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "[Llh;"
   )
   @Export("slStarSprites")
   static IndexedSprite[] slStarSprites;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "2014433733"
   )
   static final void method95(String var0, int var1) {
      PacketNode var2 = DecorativeObject.method3115(ClientPacket.field2207, Client.field739.field1250);
      var2.packetBuffer.putByte(Size.getLength(var0) + 1);
      var2.packetBuffer.method3594(var1);
      var2.packetBuffer.putString(var0);
      Client.field739.method2019(var2);
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "([Lhl;IIIZB)V",
      garbageValue = "5"
   )
   static void method100(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class138.method3155(var6, var2, var3, var4);
            class45.method820(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class45.method818(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(Lhl;I)Z",
      garbageValue = "945191862"
   )
   static final boolean method96(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class11.method114(var0, var1);
            int var3 = var0.field2738[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2011031140"
   )
   static final void method99() {
      PacketNode var0 = DecorativeObject.method3115(ClientPacket.field2186, Client.field739.field1250);
      Client.field739.method2019(var0);

      for(WidgetNode var1 = (WidgetNode)Client.componentTable.first(); var1 != null; var1 = (WidgetNode)Client.componentTable.next()) {
         if(var1.owner == 0 || var1.owner == 3) {
            class21.closeWidget(var1, true);
         }
      }

      if(Client.field756 != null) {
         DState.method3548(Client.field756);
         Client.field756 = null;
      }

   }

   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1426585201"
   )
   static String method97(String var0) {
      Permission[] var1 = class274.method5249();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         Permission var3 = var1[var2];
         if(var3.field3142 != -1 && var0.startsWith(MapIconReference.method687(var3.field3142))) {
            var0 = var0.substring(6 + Integer.toString(var3.field3142).length());
            break;
         }
      }

      return var0;
   }
}
