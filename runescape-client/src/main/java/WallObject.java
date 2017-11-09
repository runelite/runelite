import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static IndexedSprite field2046;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1535456141
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1968311613
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1274477607
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1005037401
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1716887917
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1895147301
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 145128305
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1084725809"
   )
   @Export("getColTags")
   static String getColTags(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(IZZZB)Liy;",
      garbageValue = "-82"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class156.field2162 != null) {
         var4 = new IndexFile(var0, class156.field2162, class156.field2156[var0], 1000000);
      }

      return new IndexData(var4, MilliTimer.field2125, var0, var1, var2, var3);
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(ZLgi;B)V",
      garbageValue = "94"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0, PacketBuffer var1) {
      Client.isDynamicRegion = var0;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(!Client.isDynamicRegion) {
         int var2 = var1.method3322();
         var3 = var1.readUnsignedShortOb1();
         var4 = var1.readUnsignedShort();
         class21.field335 = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class21.field335[var5][var6] = var1.readInt();
            }
         }

         Script.field1444 = new int[var4];
         Varbit.field3438 = new int[var4];
         Varbit.field3439 = new int[var4];
         class148.field2107 = new byte[var4][];
         class36.field482 = new byte[var4][];
         boolean var16 = false;
         if((var3 / 8 == 48 || var3 / 8 == 49) && var2 / 8 == 48) {
            var16 = true;
         }

         if(var3 / 8 == 48 && var2 / 8 == 148) {
            var16 = true;
         }

         var4 = 0;

         for(var6 = (var3 - 6) / 8; var6 <= (var3 + 6) / 8; ++var6) {
            for(var7 = (var2 - 6) / 8; var7 <= (var2 + 6) / 8; ++var7) {
               var8 = var7 + (var6 << 8);
               if(!var16 || var7 != 49 && var7 != 149 && var7 != 147 && var6 != 50 && (var6 != 49 || var7 != 47)) {
                  Script.field1444[var4] = var8;
                  Varbit.field3438[var4] = class56.indexMaps.getFile("m" + var6 + "_" + var7);
                  Varbit.field3439[var4] = class56.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         class1.method1(var3, var2, true);
      } else {
         boolean var15 = var1.method3313() == 1;
         var3 = var1.method3322();
         var4 = var1.method3324();
         var5 = var1.readUnsignedShort();
         var1.bitAccess();

         int var9;
         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = var1.getBits(1);
                  if(var9 == 1) {
                     Client.field884[var6][var7][var8] = var1.getBits(26);
                  } else {
                     Client.field884[var6][var7][var8] = -1;
                  }
               }
            }
         }

         var1.byteAccess();
         class21.field335 = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               class21.field335[var6][var7] = var1.readInt();
            }
         }

         Script.field1444 = new int[var5];
         Varbit.field3438 = new int[var5];
         Varbit.field3439 = new int[var5];
         class148.field2107 = new byte[var5][];
         class36.field482 = new byte[var5][];
         var5 = 0;

         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = Client.field884[var6][var7][var8];
                  if(var9 != -1) {
                     int var10 = var9 >> 14 & 1023;
                     int var11 = var9 >> 3 & 2047;
                     int var12 = (var10 / 8 << 8) + var11 / 8;

                     int var13;
                     for(var13 = 0; var13 < var5; ++var13) {
                        if(Script.field1444[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        Script.field1444[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        Varbit.field3438[var5] = class56.indexMaps.getFile("m" + var13 + "_" + var14);
                        Varbit.field3439[var5] = class56.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         class1.method1(var4, var3, !var15);
      }

   }
}
