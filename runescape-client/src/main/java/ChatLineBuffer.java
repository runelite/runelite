import java.awt.Canvas;
import java.awt.Container;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("y")
   @Export("lines")
   MessageNode[] lines = new MessageNode[100];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 207726779
   )
   @Export("length")
   int length;
   @ObfuscatedName("b")
   public static String field968;
   @ObfuscatedName("au")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("qg")
   static java.awt.Font field970;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -819217459
   )
   public static int field971;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "-54979029"
   )
   MessageNode method904(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(null == var5) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.method2411();
         var5.method220(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)LMessageNode;",
      garbageValue = "8"
   )
   MessageNode method905(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1620359135"
   )
   int method906() {
      return this.length;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-60020707"
   )
   static void method912() {
      Client var0 = Client.field277;
      synchronized(Client.field277) {
         Container var1 = Client.field277.method2170();
         if(null != var1) {
            class9.field84 = Math.max(var1.getSize().width, RSCanvas.field1755);
            class60.field1084 = Math.max(var1.getSize().height, RSCanvas.field1759);
            if(var1 == Tile.field1351) {
               Insets var2 = Tile.field1351.getInsets();
               class9.field84 -= var2.right + var2.left;
               class60.field1084 -= var2.top + var2.bottom;
            }

            if(class9.field84 <= 0) {
               class9.field84 = 1;
            }

            if(class60.field1084 <= 0) {
               class60.field1084 = 1;
            }

            int var12 = Client.isResized?2:1;
            if(var12 == 1) {
               XItemContainer.field123 = Client.field537;
               class143.field1999 = Client.field493;
            } else {
               XItemContainer.field123 = Math.min(class9.field84, 7680);
               class143.field1999 = Math.min(class60.field1084, 2160);
            }

            GameEngine.field1774 = (class9.field84 - XItemContainer.field123) / 2;
            GameEngine.field1775 = 0;
            class32.canvas.setSize(XItemContainer.field123, class143.field1999);
            int var4 = XItemContainer.field123;
            int var5 = class143.field1999;
            Canvas var6 = class32.canvas;

            Object var3;
            try {
               MainBufferProvider var7 = new MainBufferProvider();
               var7.init(var4, var5, var6);
               var3 = var7;
            } catch (Throwable var16) {
               SecondaryBufferProvider var8 = new SecondaryBufferProvider();
               var8.init(var4, var5, var6);
               var3 = var8;
            }

            class13.bufferProvider = (BufferProvider)var3;
            if(Tile.field1351 == var1) {
               Insets var18 = Tile.field1351.getInsets();
               class32.canvas.setLocation(var18.left + GameEngine.field1774, GameEngine.field1775 + var18.top);
            } else {
               class32.canvas.setLocation(GameEngine.field1774, GameEngine.field1775);
            }

            int var13 = XItemContainer.field123;
            int var14 = class143.field1999;
            if(class9.field84 < var13) {
               var13 = class9.field84;
            }

            if(class60.field1084 < var14) {
               var14 = class60.field1084;
            }

            if(null != class85.field1456) {
               try {
                  Client var9 = Client.field277;
                  int var10 = Client.isResized?2:1;
                  class100.method1930(var9, "resize", new Object[]{Integer.valueOf(var10)});
               } catch (Throwable var15) {
                  ;
               }
            }

            if(Client.widgetRoot != -1) {
               class8.method117(true);
            }

            ChatMessages.method844();
         }
      }
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "47"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0) {
      Client.isDynamicRegion = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!Client.isDynamicRegion) {
         var1 = Client.field323.method2962();
         var2 = Client.field323.method2962();
         var3 = Client.field323.readUnsignedShort();
         class88.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class88.xteaKeys[var4][var5] = Client.field323.method3062();
            }
         }

         class20.mapRegions = new int[var3];
         class9.field85 = new int[var3];
         VertexNormal.field1423 = new int[var3];
         class162.field2283 = new byte[var3][];
         ItemLayer.field1220 = new byte[var3][];
         boolean var13 = false;
         if((var1 / 8 == 48 || var1 / 8 == 49) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || var6 != 49 && var6 != 149 && var6 != 147 && var5 != 50 && (var5 != 49 || var6 != 47)) {
                  class20.mapRegions[var3] = var7;
                  class9.field85[var3] = class37.field786.method3284("m" + var5 + "_" + var6);
                  VertexNormal.field1423[var3] = class37.field786.method3284("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class16.method199(var1, var2);
      } else {
         var1 = Client.field323.method2962();
         var2 = Client.field323.method2962();
         var3 = Client.field323.readUnsignedShort();
         Client.field323.method3175();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field323.method3176(1);
                  if(var7 == 1) {
                     Client.field340[var4][var5][var6] = Client.field323.method3176(26);
                  } else {
                     Client.field340[var4][var5][var6] = -1;
                  }
               }
            }
         }

         Client.field323.method3177();
         class88.xteaKeys = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class88.xteaKeys[var4][var5] = Client.field323.method3062();
            }
         }

         class20.mapRegions = new int[var3];
         class9.field85 = new int[var3];
         VertexNormal.field1423 = new int[var3];
         class162.field2283 = new byte[var3][];
         ItemLayer.field1220 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = Client.field340[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = (var8 / 8 << 8) + var9 / 8;

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(class20.mapRegions[var11] == var10) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(var10 != -1) {
                        class20.mapRegions[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class9.field85[var3] = class37.field786.method3284("m" + var11 + "_" + var12);
                        VertexNormal.field1423[var3] = class37.field786.method3284("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class16.method199(var2, var1);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;S)V",
      garbageValue = "2636"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      DecorativeObject.addChatMessage(var0, var1, var2, (String)null);
   }
}
