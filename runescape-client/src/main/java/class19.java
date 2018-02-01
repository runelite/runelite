import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("k")
final class class19 implements Comparator {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ln;Ln;I)I",
      garbageValue = "299288533"
   )
   int method155(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.field275 < var2.field275?-1:(var1.field275 == var2.field275?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method155((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "631918715"
   )
   static void method165() {
      class181.method3381(class36.localPlayer, false);
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(ZLgd;I)V",
      garbageValue = "-238178168"
   )
   @Export("xteaChanged")
   static final void xteaChanged(boolean var0, PacketBuffer var1) {
      Client.isDynamicRegion = var0;
      int var2;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      if(!Client.isDynamicRegion) {
         var2 = var1.method3440();
         int var3 = var1.method3442();
         var4 = var1.readUnsignedShort();
         class80.xteaKeys = new int[var4][4];

         for(var5 = 0; var5 < var4; ++var5) {
            for(var6 = 0; var6 < 4; ++var6) {
               class80.xteaKeys[var5][var6] = var1.readInt();
            }
         }

         FileOnDisk.mapRegions = new int[var4];
         SceneTilePaint.landMapFileIds = new int[var4];
         BaseVarType.landRegionFileIds = new int[var4];
         class180.field2437 = new byte[var4][];
         class160.field2132 = new byte[var4][];
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
                  FileOnDisk.mapRegions[var4] = var8;
                  SceneTilePaint.landMapFileIds[var4] = FontName.indexMaps.getFile("m" + var6 + "_" + var7);
                  BaseVarType.landRegionFileIds[var4] = FontName.indexMaps.getFile("l" + var6 + "_" + var7);
                  ++var4;
               }
            }
         }

         class222.method4185(var3, var2, true);
      } else {
         var2 = var1.method3440();
         boolean var15 = var1.method3433() == 1;
         var4 = var1.method3442();
         var5 = var1.readUnsignedShort();
         var1.bitAccess();

         int var9;
         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = var1.getBits(1);
                  if(var9 == 1) {
                     Client.field880[var6][var7][var8] = var1.getBits(26);
                  } else {
                     Client.field880[var6][var7][var8] = -1;
                  }
               }
            }
         }

         var1.byteAccess();
         class80.xteaKeys = new int[var5][4];

         for(var6 = 0; var6 < var5; ++var6) {
            for(var7 = 0; var7 < 4; ++var7) {
               class80.xteaKeys[var6][var7] = var1.readInt();
            }
         }

         FileOnDisk.mapRegions = new int[var5];
         SceneTilePaint.landMapFileIds = new int[var5];
         BaseVarType.landRegionFileIds = new int[var5];
         class180.field2437 = new byte[var5][];
         class160.field2132 = new byte[var5][];
         var5 = 0;

         for(var6 = 0; var6 < 4; ++var6) {
            for(var7 = 0; var7 < 13; ++var7) {
               for(var8 = 0; var8 < 13; ++var8) {
                  var9 = Client.field880[var6][var7][var8];
                  if(var9 != -1) {
                     int var10 = var9 >> 14 & 1023;
                     int var11 = var9 >> 3 & 2047;
                     int var12 = (var10 / 8 << 8) + var11 / 8;

                     int var13;
                     for(var13 = 0; var13 < var5; ++var13) {
                        if(FileOnDisk.mapRegions[var13] == var12) {
                           var12 = -1;
                           break;
                        }
                     }

                     if(var12 != -1) {
                        FileOnDisk.mapRegions[var5] = var12;
                        var13 = var12 >> 8 & 255;
                        int var14 = var12 & 255;
                        SceneTilePaint.landMapFileIds[var5] = FontName.indexMaps.getFile("m" + var13 + "_" + var14);
                        BaseVarType.landRegionFileIds[var5] = FontName.indexMaps.getFile("l" + var13 + "_" + var14);
                        ++var5;
                     }
                  }
               }
            }
         }

         class222.method4185(var2, var4, !var15);
      }

   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1795450732"
   )
   @Export("flush")
   static final void flush(boolean var0) {
      Friend.method5158();
      ++Client.field867.field1438;
      if(Client.field867.field1438 >= 50 || var0) {
         Client.field867.field1438 = 0;
         if(!Client.socketError && Client.field867.getSocket() != null) {
            PacketNode var1 = class35.method501(ClientPacket.field2325, Client.field867.field1439);
            Client.field867.method2021(var1);

            try {
               Client.field867.method2020();
            } catch (IOException var3) {
               Client.socketError = true;
            }
         }

      }
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(Lho;B)Z",
      garbageValue = "19"
   )
   static final boolean method161(Widget var0) {
      if(var0.tableActions == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.tableActions.length; ++var1) {
            int var2 = class215.method4072(var0, var1);
            int var3 = var0.field2852[var1];
            if(var0.tableActions[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.tableActions[var1] == 4) {
               if(var2 == var3) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("kq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1214923327"
   )
   static void method162(String var0) {
      class61.sessionToken = var0;

      try {
         String var1 = class37.clientInstance.getParameter(Parameters.field3807.key);
         String var2 = class37.clientInstance.getParameter(Parameters.field3796.key);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         String var5;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = ScriptVarType.currentTimeMs() + 94608000000L;
            class193.field2532.setTime(new Date(var6));
            int var8 = class193.field2532.get(7);
            int var9 = class193.field2532.get(5);
            int var10 = class193.field2532.get(2);
            int var11 = class193.field2532.get(1);
            int var12 = class193.field2532.get(11);
            int var13 = class193.field2532.get(12);
            int var14 = class193.field2532.get(13);
            var5 = class193.field2533[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class193.field2534[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         Client var16 = class37.clientInstance;
         var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var16).eval(var5);
      } catch (Throwable var15) {
         ;
      }

   }
}
