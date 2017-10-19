import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class174 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -678425525
   )
   static int field2399;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1730540891
   )
   static int field2398;
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lfe;"
   )
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1822949883
   )
   static int field2401;
   @ObfuscatedName("o")
   static byte[][] field2396;
   @ObfuscatedName("g")
   static byte[][] field2397;
   @ObfuscatedName("v")
   static byte[][] field2393;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("indexInterfaces")
   static IndexData indexInterfaces;
   @ObfuscatedName("ar")
   protected static GarbageCollectorMXBean field2394;

   static {
      field2399 = 0;
      field2398 = 0;
      field2401 = 0;
      field2396 = new byte[1000][];
      field2397 = new byte[250][];
      field2393 = new byte[50][];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1548049505"
   )
   @Export("currentTimeMs")
   public static synchronized long currentTimeMs() {
      long var0 = System.currentTimeMillis();
      if(var0 < class175.field2403) {
         class175.field2404 += class175.field2403 - var0;
      }

      class175.field2403 = var0;
      return var0 + class175.field2404;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1358588947"
   )
   static synchronized byte[] method3445(int var0) {
      byte[] var1;
      if(var0 == 100 && field2399 > 0) {
         var1 = field2396[--field2399];
         field2396[field2399] = null;
         return var1;
      } else if(var0 == 5000 && field2398 > 0) {
         var1 = field2397[--field2398];
         field2397[field2398] = null;
         return var1;
      } else if(var0 == 30000 && field2401 > 0) {
         var1 = field2393[--field2401];
         field2393[field2401] = null;
         return var1;
      } else {
         return new byte[var0];
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1718527911"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3223 != 0 && var3 > IndexDataBase.field3223) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 < 0 || IndexDataBase.field3223 != 0 && var6 > IndexDataBase.field3223) {
            throw new RuntimeException();
         } else {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class167.method3161(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIZS)Ljava/lang/String;",
      garbageValue = "-18507"
   )
   static String method3447(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = '+';

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-359418221"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class39.addChatMessage(var0, var1, var2, (String)null);
   }
}
