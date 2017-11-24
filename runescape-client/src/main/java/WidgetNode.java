import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("v")
   static File field793;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 581620979
   )
   static int field789;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 942543977
   )
   @Export("id")
   int id;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1625024993
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("k")
   boolean field791;

   WidgetNode() {
      this.field791 = false;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILce;ZI)I",
      garbageValue = "1945161634"
   )
   static int method1114(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class13.intStackSize -= 2;
         Client.field1106 = (short)class82.intStack[class13.intStackSize];
         if(Client.field1106 <= 0) {
            Client.field1106 = 256;
         }

         Client.field1107 = (short)class82.intStack[class13.intStackSize + 1];
         if(Client.field1107 <= 0) {
            Client.field1107 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class13.intStackSize -= 2;
         Client.field1036 = (short)class82.intStack[class13.intStackSize];
         if(Client.field1036 <= 0) {
            Client.field1036 = 256;
         }

         Client.field1109 = (short)class82.intStack[class13.intStackSize + 1];
         if(Client.field1109 <= 0) {
            Client.field1109 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class13.intStackSize -= 4;
         Client.field926 = (short)class82.intStack[class13.intStackSize];
         if(Client.field926 <= 0) {
            Client.field926 = 1;
         }

         Client.field1111 = (short)class82.intStack[class13.intStackSize + 1];
         if(Client.field1111 <= 0) {
            Client.field1111 = 32767;
         } else if(Client.field1111 < Client.field926) {
            Client.field1111 = Client.field926;
         }

         Client.field1112 = (short)class82.intStack[class13.intStackSize + 2];
         if(Client.field1112 <= 0) {
            Client.field1112 = 1;
         }

         Client.field1061 = (short)class82.intStack[class13.intStackSize + 3];
         if(Client.field1061 <= 0) {
            Client.field1061 = 32767;
         } else if(Client.field1061 < Client.field1112) {
            Client.field1061 = Client.field1112;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field1026 != null) {
            class82.method1692(0, 0, Client.field1026.width, Client.field1026.height, false);
            class82.intStack[++class13.intStackSize - 1] = Client.viewportHeight;
            class82.intStack[++class13.intStackSize - 1] = Client.viewportWidth;
         } else {
            class82.intStack[++class13.intStackSize - 1] = -1;
            class82.intStack[++class13.intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class82.intStack[++class13.intStackSize - 1] = Client.field1036;
         class82.intStack[++class13.intStackSize - 1] = Client.field1109;
         return 1;
      } else if(var0 == 6205) {
         class82.intStack[++class13.intStackSize - 1] = Client.field1106;
         class82.intStack[++class13.intStackSize - 1] = Client.field1107;
         return 1;
      } else {
         return 2;
      }
   }
}
