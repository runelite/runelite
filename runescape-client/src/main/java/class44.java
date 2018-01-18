import java.awt.Component;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class44 extends WorldMapData {
   @ObfuscatedName("lf")
   @ObfuscatedGetter(
      intValue = -1597278257
   )
   static int field555;
   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("indexStore255")
   static IndexFile indexStore255;
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;
   @ObfuscatedName("p")
   HashSet field558;
   @ObfuscatedName("w")
   HashSet field553;
   @ObfuscatedName("t")
   List field554;

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(Lgv;Lgv;Lgv;IZI)V",
      garbageValue = "-822892110"
   )
   void method616(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field558 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method154(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field558.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field553 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method628(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field553.add(var9);
      }

      this.method617(var2, var5);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(Lgv;ZB)V",
      garbageValue = "-93"
   )
   void method617(Buffer var1, boolean var2) {
      this.field554 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3514();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field554.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1085350288"
   )
   static void method625(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.MouseHandler_currentButton = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "1"
   )
   static String method619() {
      String var0;
      if(class222.preferences.hideUsername) {
         String var2 = class91.username;
         int var4 = var2.length();
         char[] var5 = new char[var4];

         for(int var6 = 0; var6 < var4; ++var6) {
            var5[var6] = '*';
         }

         String var3 = new String(var5);
         var0 = var3;
      } else {
         var0 = class91.username;
      }

      return var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILcv;ZB)I",
      garbageValue = "-1"
   )
   static int method624(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class82.intStack[--class82.intStackSize];
         var3 = UrlRequester.getWidget(var4);
      } else {
         var3 = var2?class82.field1267:CombatInfo1.field1216;
      }

      if(var0 == 1100) {
         class82.intStackSize -= 2;
         var3.scrollX = class82.intStack[class82.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class82.intStack[class82.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class28.method220(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class82.intStack[--class82.intStackSize];
         class28.method220(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.filled = class82.intStack[--class82.intStackSize] == 1;
         class28.method220(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class82.intStack[--class82.intStackSize];
         class28.method220(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.lineWidth = class82.intStack[--class82.intStackSize];
         class28.method220(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class82.intStack[--class82.intStackSize];
         class28.method220(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.textureId = class82.intStack[--class82.intStackSize];
         class28.method220(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.spriteTiling = class82.intStack[--class82.intStackSize] == 1;
         class28.method220(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class82.intStack[--class82.intStackSize];
         class28.method220(var3);
         return 1;
      } else if(var0 == 1109) {
         class82.intStackSize -= 6;
         var3.field2868 = class82.intStack[class82.intStackSize];
         var3.field2812 = class82.intStack[class82.intStackSize + 1];
         var3.rotationX = class82.intStack[class82.intStackSize + 2];
         var3.rotationZ = class82.intStack[class82.intStackSize + 3];
         var3.rotationY = class82.intStack[class82.intStackSize + 4];
         var3.modelZoom = class82.intStack[class82.intStackSize + 5];
         class28.method220(var3);
         return 1;
      } else {
         int var10;
         if(var0 == 1110) {
            var10 = class82.intStack[--class82.intStackSize];
            if(var10 != var3.field2749) {
               var3.field2749 = var10;
               var3.field2884 = 0;
               var3.field2885 = 0;
               class28.method220(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2857 = class82.intStack[--class82.intStackSize] == 1;
            class28.method220(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class82.scriptStringStack[--FileOnDisk.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               class28.method220(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class82.intStack[--class82.intStackSize];
            class28.method220(var3);
            return 1;
         } else if(var0 == 1114) {
            class82.intStackSize -= 3;
            var3.field2825 = class82.intStack[class82.intStackSize];
            var3.field2761 = class82.intStack[class82.intStackSize + 1];
            var3.field2835 = class82.intStack[class82.intStackSize + 2];
            class28.method220(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.textShadowed = class82.intStack[--class82.intStackSize] == 1;
            class28.method220(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class82.intStack[--class82.intStackSize];
            class28.method220(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class82.intStack[--class82.intStackSize];
            class28.method220(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class82.intStack[--class82.intStackSize] == 1;
            class28.method220(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class82.intStack[--class82.intStackSize] == 1;
            class28.method220(var3);
            return 1;
         } else if(var0 == 1120) {
            class82.intStackSize -= 2;
            var3.scrollWidth = class82.intStack[class82.intStackSize];
            var3.scrollHeight = class82.intStack[class82.intStackSize + 1];
            class28.method220(var3);
            if(var4 != -1 && var3.type == 0) {
               class160.method3094(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            var10 = var3.id;
            int var6 = var3.index;
            PacketNode var11 = class235.method4272(ClientPacket.field2354, Client.field915.field1462);
            var11.packetBuffer.writeIntLE(var6);
            var11.packetBuffer.writeShortLE(var10);
            Client.field915.method1898(var11);
            Client.field1019 = var3;
            class28.method220(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2798 = class82.intStack[--class82.intStackSize];
            class28.method220(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2788 = class82.intStack[--class82.intStackSize];
            class28.method220(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2896 = class82.intStack[--class82.intStackSize];
            class28.method220(var3);
            return 1;
         } else if(var0 == 1125) {
            var10 = class82.intStack[--class82.intStackSize];
            class296[] var9 = new class296[]{class296.field3844, class296.field3841, class296.field3845, class296.field3842, class296.field3846};
            class296 var7 = (class296)class34.forOrdinal(var9, var10);
            if(var7 != null) {
               var3.field2792 = var7;
               class28.method220(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class82.intStack[--class82.intStackSize] == 1;
            var3.field2796 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1047772262"
   )
   static void method615(boolean var0) {
      class91.loginMessage1 = "";
      class91.loginMessage2 = "Enter your username/email & password.";
      class91.loginMessage3 = "";
      class91.loginIndex = 2;
      if(var0) {
         class91.password = "";
      }

      CombatInfoListHolder.method1704();
      class48.method713();
   }
}
