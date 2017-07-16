import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("e")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -750542463
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1994664169
   )
   @Export("rgb")
   int rgb;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 794606609
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1165042523
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1529833647
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -718405985
   )
   @Export("texture")
   int texture;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "-487322870"
   )
   static int method2662(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         WorldMapType2.intStackSize -= 2;
         Client.field1007 = (short)class83.intStack[WorldMapType2.intStackSize];
         if(Client.field1007 <= 0) {
            Client.field1007 = 256;
         }

         Client.field1159 = (short)class83.intStack[WorldMapType2.intStackSize + 1];
         if(Client.field1159 <= 0) {
            Client.field1159 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         WorldMapType2.intStackSize -= 2;
         Client.field1160 = (short)class83.intStack[WorldMapType2.intStackSize];
         if(Client.field1160 <= 0) {
            Client.field1160 = 256;
         }

         Client.field1161 = (short)class83.intStack[WorldMapType2.intStackSize + 1];
         if(Client.field1161 <= 0) {
            Client.field1161 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         WorldMapType2.intStackSize -= 4;
         Client.field1162 = (short)class83.intStack[WorldMapType2.intStackSize];
         if(Client.field1162 <= 0) {
            Client.field1162 = 1;
         }

         Client.field1127 = (short)class83.intStack[WorldMapType2.intStackSize + 1];
         if(Client.field1127 <= 0) {
            Client.field1127 = 32767;
         } else if(Client.field1127 < Client.field1162) {
            Client.field1127 = Client.field1162;
         }

         Client.field1164 = (short)class83.intStack[WorldMapType2.intStackSize + 2];
         if(Client.field1164 <= 0) {
            Client.field1164 = 1;
         }

         Client.field1165 = (short)class83.intStack[WorldMapType2.intStackSize + 3];
         if(Client.field1165 <= 0) {
            Client.field1165 = 32767;
         } else if(Client.field1165 < Client.field1164) {
            Client.field1165 = Client.field1164;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field1078 != null) {
            class25.method175(0, 0, Client.field1078.width, Client.field1078.height, false);
            class83.intStack[++WorldMapType2.intStackSize - 1] = Client.viewportHeight;
            class83.intStack[++WorldMapType2.intStackSize - 1] = Client.viewportWidth;
         } else {
            class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
            class83.intStack[++WorldMapType2.intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.field1160;
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.field1161;
         return 1;
      } else if(var0 == 6205) {
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.field1007;
         class83.intStack[++WorldMapType2.intStackSize - 1] = Client.field1159;
         return 1;
      } else {
         return 2;
      }
   }
}
