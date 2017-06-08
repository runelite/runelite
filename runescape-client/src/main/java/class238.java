import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
public class class238 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1663152583
   )
   public static int field3251;
   @ObfuscatedName("z")
   public static Node2LinkedList field3253;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1030349915
   )
   public static int field3254;
   @ObfuscatedName("j")
   public static XHashTable field3255;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1372436279
   )
   public static int field3256;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 5954416699756557341L
   )
   public static long field3257;
   @ObfuscatedName("h")
   public static XHashTable field3258;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1941854847
   )
   public static int field3259;
   @ObfuscatedName("e")
   public static XHashTable field3260;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1489624781
   )
   public static int field3261;
   @ObfuscatedName("y")
   public static Buffer field3262;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -917690895
   )
   public static int field3263;
   @ObfuscatedName("v")
   public static CRC32 field3264;
   @ObfuscatedName("w")
   public static IndexData[] field3265;
   @ObfuscatedName("l")
   public static byte field3266;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1270136891
   )
   public static int field3267;
   @ObfuscatedName("m")
   public static XHashTable field3268;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 674484397
   )
   public static int field3271;
   @ObfuscatedName("n")
   public static RSSocket field3272;

   static {
      field3251 = 0;
      field3255 = new XHashTable(4096);
      field3254 = 0;
      field3268 = new XHashTable(32);
      field3256 = 0;
      field3253 = new Node2LinkedList();
      field3258 = new XHashTable(4096);
      field3259 = 0;
      field3260 = new XHashTable(4096);
      field3261 = 0;
      field3262 = new Buffer(8);
      field3263 = 0;
      field3264 = new CRC32();
      field3265 = new IndexData[256];
      field3266 = 0;
      field3267 = 0;
      field3271 = 0;
   }

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "447447119"
   )
   static final void method4283() {
      int var0 = Client.field1171 + class168.localPlayer.x;
      int var1 = Client.field980 + class168.localPlayer.y;
      if(class27.field404 - var0 < -500 || class27.field404 - var0 > 500 || class155.field2258 - var1 < -500 || class155.field2258 - var1 > 500) {
         class27.field404 = var0;
         class155.field2258 = var1;
      }

      if(class27.field404 != var0) {
         class27.field404 += (var0 - class27.field404) / 16;
      }

      if(var1 != class155.field2258) {
         class155.field2258 += (var1 - class155.field2258) / 16;
      }

      int var2;
      int var3;
      if(class59.field716 == 4 && ItemLayer.field1798) {
         var2 = class59.field715 - Client.field1003;
         Client.field1001 = var2 * 2;
         Client.field1003 = var2 != -1 && var2 != 1?(class59.field715 + Client.field1003) / 2:class59.field715;
         var3 = Client.field1002 - class59.field729;
         Client.field1000 = var3 * 2;
         Client.field1002 = var3 != -1 && var3 != 1?(Client.field1002 + class59.field729) / 2:class59.field729;
      } else {
         if(class50.field624[96]) {
            Client.field1000 += (-24 - Client.field1000) / 2;
         } else if(class50.field624[97]) {
            Client.field1000 += (24 - Client.field1000) / 2;
         } else {
            Client.field1000 /= 2;
         }

         if(class50.field624[98]) {
            Client.field1001 += (12 - Client.field1001) / 2;
         } else if(class50.field624[99]) {
            Client.field1001 += (-12 - Client.field1001) / 2;
         } else {
            Client.field1001 /= 2;
         }

         Client.field1003 = class59.field715;
         Client.field1002 = class59.field729;
      }

      Client.mapAngle = Client.field1000 / 2 + Client.mapAngle & 2047;
      Client.field1107 += Client.field1001 / 2;
      if(Client.field1107 < 128) {
         Client.field1107 = 128;
      }

      if(Client.field1107 > 383) {
         Client.field1107 = 383;
      }

      var2 = class27.field404 >> 7;
      var3 = class155.field2258 >> 7;
      int var4 = class181.method3424(class27.field404, class155.field2258, class92.plane);
      int var5 = 0;
      int var6;
      if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
         for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
            for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
               int var8 = class92.plane;
               if(var8 < 3 && (class61.tileSettings[1][var6][var7] & 2) == 2) {
                  ++var8;
               }

               int var9 = var4 - class61.tileHeights[var8][var6][var7];
               if(var9 > var5) {
                  var5 = var9;
               }
            }
         }
      }

      var6 = var5 * 192;
      if(var6 > 98048) {
         var6 = 98048;
      }

      if(var6 < '耀') {
         var6 = '耀';
      }

      if(var6 > Client.field1007) {
         Client.field1007 += (var6 - Client.field1007) / 24;
      } else if(var6 < Client.field1007) {
         Client.field1007 += (var6 - Client.field1007) / 80;
      }

   }
}
