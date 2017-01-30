import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("d")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1327191055
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1316448377
   )
   @Export("y")
   int y;
   @ObfuscatedName("q")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 677454735
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("k")
   @Export("top")
   Renderable top;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 857599865
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1017830469
   )
   @Export("height")
   int height;
   @ObfuscatedName("dz")
   @Export("mapRegions")
   static int[] mapRegions;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "13"
   )
   public static void method1455(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class225.field3217 = var1.readUnsignedShort();
      class225.field3216 = new int[class225.field3217];
      class225.field3215 = new int[class225.field3217];
      class22.field231 = new int[class225.field3217];
      class225.field3218 = new int[class225.field3217];
      class48.field949 = new byte[class225.field3217][];
      var1.offset = var0.length - 7 - class225.field3217 * 8;
      class225.field3214 = var1.readUnsignedShort();
      NPC.field761 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class225.field3217; ++var3) {
         class225.field3216[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3217; ++var3) {
         class225.field3215[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3217; ++var3) {
         class22.field231[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3217; ++var3) {
         class225.field3218[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class225.field3217 * 8 - (var2 - 1) * 3;
      class183.field2719 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class183.field2719[var3] = var1.read24BitInt();
         if(class183.field2719[var3] == 0) {
            class183.field2719[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class225.field3217; ++var3) {
         int var4 = class22.field231[var3];
         int var5 = class225.field3218[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class48.field949[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILclass116;Lclass184;I)V",
      garbageValue = "1283734077"
   )
   static void method1456(int var0, class116 var1, class184 var2) {
      byte[] var3 = null;
      Deque var4 = class183.field2727;
      synchronized(class183.field2727) {
         for(class180 var5 = (class180)class183.field2727.method2412(); null != var5; var5 = (class180)class183.field2727.method2426()) {
            if(var5.hash == (long)var0 && var5.field2690 == var1 && var5.field2691 == 0) {
               var3 = var5.field2693;
               break;
            }
         }
      }

      if(null != var3) {
         var2.method3366(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method2240(var0);
         var2.method3366(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-1516161179"
   )
   public static byte method1457(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }
}
