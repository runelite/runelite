import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("UrlRequest")
public class UrlRequest {
   @ObfuscatedName("s")
   @Export("url")
   final URL url;
   @ObfuscatedName("g")
   @Export("isDone0")
   volatile boolean isDone0;
   @ObfuscatedName("m")
   @Export("response0")
   volatile byte[] response0;

   UrlRequest(URL var1) {
      this.url = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "86"
   )
   @Export("isDone")
   public boolean isDone() {
      return this.isDone0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "456570946"
   )
   @Export("getResponse")
   public byte[] getResponse() {
      return this.response0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-948779522"
   )
   public static final boolean method3163(char var0) {
      return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "566201522"
   )
   static int method3155(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class80.intStackSize -= 2;
         Client.field1082 = (short)class80.intStack[class80.intStackSize];
         if(Client.field1082 <= 0) {
            Client.field1082 = 256;
         }

         Client.field1075 = (short)class80.intStack[class80.intStackSize + 1];
         if(Client.field1075 <= 0) {
            Client.field1075 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class80.intStackSize -= 2;
         Client.field1076 = (short)class80.intStack[class80.intStackSize];
         if(Client.field1076 <= 0) {
            Client.field1076 = 256;
         }

         Client.field962 = (short)class80.intStack[class80.intStackSize + 1];
         if(Client.field962 <= 0) {
            Client.field962 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class80.intStackSize -= 4;
         Client.field1078 = (short)class80.intStack[class80.intStackSize];
         if(Client.field1078 <= 0) {
            Client.field1078 = 1;
         }

         Client.field938 = (short)class80.intStack[class80.intStackSize + 1];
         if(Client.field938 <= 0) {
            Client.field938 = 32767;
         } else if(Client.field938 < Client.field1078) {
            Client.field938 = Client.field1078;
         }

         Client.field982 = (short)class80.intStack[class80.intStackSize + 2];
         if(Client.field982 <= 0) {
            Client.field982 = 1;
         }

         Client.field1081 = (short)class80.intStack[class80.intStackSize + 3];
         if(Client.field1081 <= 0) {
            Client.field1081 = 32767;
         } else if(Client.field1081 < Client.field982) {
            Client.field1081 = Client.field982;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field1003 != null) {
            BoundingBox2D.method38(0, 0, Client.field1003.width, Client.field1003.height, false);
            class80.intStack[++class80.intStackSize - 1] = Client.viewportWidth;
            class80.intStack[++class80.intStackSize - 1] = Client.viewportHeight;
         } else {
            class80.intStack[++class80.intStackSize - 1] = -1;
            class80.intStack[++class80.intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class80.intStack[++class80.intStackSize - 1] = Client.field1076;
         class80.intStack[++class80.intStackSize - 1] = Client.field962;
         return 1;
      } else if(var0 == 6205) {
         class80.intStack[++class80.intStackSize - 1] = Client.field1082;
         class80.intStack[++class80.intStackSize - 1] = Client.field1075;
         return 1;
      } else {
         return 2;
      }
   }
}
