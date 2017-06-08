import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public final class class146 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1153417145
   )
   int field2156;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1054549451
   )
   int field2157;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 252213477
   )
   int field2158;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 325348005
   )
   int field2160;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -3004967
   )
   int field2161;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1942771277
   )
   int field2162;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 714088169
   )
   int field2163;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1103669271
   )
   int field2164;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2025980573
   )
   int field2165;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1176581307
   )
   int field2166;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1222942257
   )
   int field2167;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 411402173
   )
   int field2168;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -901019287
   )
   int field2169;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 866927477
   )
   int field2170;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1471191747
   )
   int field2171;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1957865771
   )
   int field2172;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1661969217
   )
   int field2173;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1980441179
   )
   int field2174;

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1405018494"
   )
   static final void method2900(boolean var0) {
      class24.method202();
      ++Client.field962;
      if(Client.field962 >= 50 || var0) {
         Client.field962 = 0;
         if(!Client.field967 && class8.rssocket != null) {
            Client.secretPacketBuffer1.putOpcode(36);

            try {
               class8.rssocket.queueForWrite(Client.secretPacketBuffer1.payload, 0, Client.secretPacketBuffer1.offset);
               Client.secretPacketBuffer1.offset = 0;
            } catch (IOException var2) {
               Client.field967 = true;
            }
         }

      }
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1116256939"
   )
   static final void method2901() {
      for(int var0 = 0; var0 < Client.field1077; ++var0) {
         --Client.field1049[var0];
         if(Client.field1049[var0] >= -10) {
            SoundEffect var10 = Client.field1162[var0];
            if(var10 == null) {
               Object var10000 = null;
               var10 = SoundEffect.method1922(RSCanvas.field655, Client.field1158[var0], 0);
               if(var10 == null) {
                  continue;
               }

               Client.field1049[var0] += var10.method1921();
               Client.field1162[var0] = var10;
            }

            if(Client.field1049[var0] < 0) {
               int var2;
               if(Client.field1101[var0] != 0) {
                  int var3 = (Client.field1101[var0] & 255) * 128;
                  int var9 = Client.field1101[var0] >> 16 & 255;
                  int var5 = var9 * 128 + 64 - class168.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field1101[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - class168.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.field1049[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field1005 / var3;
               } else {
                  var2 = Client.field1155;
               }

               if(var2 > 0) {
                  class107 var11 = var10.method1920().method1958(class165.field2334);
                  class117 var4 = class117.method2162(var11, 100, var2);
                  var4.method2124(Client.field1159[var0] - 1);
                  WorldMapType0.field613.method1861(var4);
               }

               Client.field1049[var0] = -100;
            }
         } else {
            --Client.field1077;

            for(int var1 = var0; var1 < Client.field1077; ++var1) {
               Client.field1158[var1] = Client.field1158[var1 + 1];
               Client.field1162[var1] = Client.field1162[var1 + 1];
               Client.field1159[var1] = Client.field1159[var1 + 1];
               Client.field1049[var1] = Client.field1049[var1 + 1];
               Client.field1101[var1] = Client.field1101[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field1154 && !class44.method616()) {
         if(Client.field1030 != 0 && Client.field1153 != -1) {
            class182.method3430(class54.indexTrack1, Client.field1153, 0, Client.field1030, false);
         }

         Client.field1154 = false;
      }

   }

   @ObfuscatedName("i")
   public static String method2902(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class268.field3683[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
