import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("np")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field279;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1977298317
   )
   @Export("world")
   public final int world;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -8721894303144802993L
   )
   public final long field273;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lf;"
   )
   @Export("grandExchangeOffer")
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("z")
   @Export("string1")
   String string1;
   @ObfuscatedName("v")
   @Export("string2")
   String string2;

   @ObfuscatedSignature(
      signature = "(Lfr;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.string1 = var1.readString();
      this.string2 = var1.readString();
      this.world = var1.readUnsignedShort();
      this.field273 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method111(2);
      this.grandExchangeOffer.method112(var2);
      this.grandExchangeOffer.price = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.quantitySold = 0;
      this.grandExchangeOffer.spent = 0;
      this.grandExchangeOffer.itemId = var3;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "75"
   )
   public String method93() {
      return this.string1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2114621168"
   )
   public String method94() {
      return this.string2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lbx;I)V",
      garbageValue = "1721301385"
   )
   public static void method95(ScriptEvent var0) {
      GZipDecompressor.method3234(var0, 200000);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "423664114"
   )
   public static void method89(String var0, String var1, int var2, int var3) throws IOException {
      class156.idxCount = var3;
      DynamicObject.field1459 = var2;

      try {
         Item.osName = System.getProperty("os.name");
      } catch (Exception var29) {
         Item.osName = "Unknown";
      }

      class45.osNameLC = Item.osName.toLowerCase();

      try {
         Enum.userHome = System.getProperty("user.home");
         if(Enum.userHome != null) {
            Enum.userHome = Enum.userHome + "/";
         }
      } catch (Exception var28) {
         ;
      }

      try {
         if(class45.osNameLC.startsWith("win")) {
            if(Enum.userHome == null) {
               Enum.userHome = System.getenv("USERPROFILE");
            }
         } else if(Enum.userHome == null) {
            Enum.userHome = System.getenv("HOME");
         }

         if(Enum.userHome != null) {
            Enum.userHome = Enum.userHome + "/";
         }
      } catch (Exception var27) {
         ;
      }

      if(Enum.userHome == null) {
         Enum.userHome = "~/";
      }

      ContextMenuRow.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", Enum.userHome, "/tmp/", ""};
      class18.field309 = new String[]{".jagex_cache_" + DynamicObject.field1459, ".file_store_" + DynamicObject.field1459};
      int var4 = 0;

      label259:
      while(var4 < 4) {
         String var6 = var4 == 0?"":"" + var4;
         class46.jagexClDat = new File(Enum.userHome, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         Buffer var11;
         File var34;
         if(class46.jagexClDat.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class46.jagexClDat, "rw", 10000L);

               int var12;
               for(var11 = new Buffer((int)var10.length()); var11.offset < var11.payload.length; var11.offset += var12) {
                  var12 = var10.read(var11.payload, var11.offset, var11.payload.length - var11.offset);
                  if(var12 == -1) {
                     throw new IOException();
                  }
               }

               var11.offset = 0;
               var12 = var11.readUnsignedByte();
               if(var12 < 1 || var12 > 3) {
                  throw new IOException("" + var12);
               }

               int var13 = 0;
               if(var12 > 1) {
                  var13 = var11.readUnsignedByte();
               }

               if(var12 <= 2) {
                  var7 = var11.getJagString();
                  if(var13 == 1) {
                     var8 = var11.getJagString();
                  }
               } else {
                  var7 = var11.getCESU8();
                  if(var13 == 1) {
                     var8 = var11.getCESU8();
                  }
               }

               var10.close();
            } catch (IOException var31) {
               var31.printStackTrace();
            }

            if(var7 != null) {
               var34 = new File(var7);
               if(!var34.exists()) {
                  var7 = null;
               }
            }

            if(var7 != null) {
               var34 = new File(var7, "test.dat");
               if(!class115.method2216(var34, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var4 == 0) {
            label234:
            for(int var19 = 0; var19 < class18.field309.length; ++var19) {
               for(int var20 = 0; var20 < ContextMenuRow.cacheLocations.length; ++var20) {
                  File var21 = new File(ContextMenuRow.cacheLocations[var20] + class18.field309[var19] + File.separatorChar + var0 + File.separatorChar);
                  if(var21.exists() && class115.method2216(new File(var21, "test.dat"), true)) {
                     var7 = var21.toString();
                     var9 = true;
                     break label234;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = Enum.userHome + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         File var33;
         if(var8 != null) {
            var33 = new File(var8);
            var34 = new File(var7);

            try {
               File[] var36 = var33.listFiles();
               File[] var22 = var36;

               for(int var14 = 0; var14 < var22.length; ++var14) {
                  File var15 = var22[var14];
                  File var16 = new File(var34, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if(!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var30) {
               var30.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            var33 = new File(var7);
            var11 = null;

            try {
               FileOnDisk var37 = new FileOnDisk(class46.jagexClDat, "rw", 10000L);
               Buffer var38 = new Buffer(500);
               var38.putByte(3);
               var38.putByte(var11 != null?1:0);
               var38.putCESU8(var33.getPath());
               if(var11 != null) {
                  var38.putCESU8("");
               }

               var37.write(var38.payload, 0, var38.offset);
               var37.close();
            } catch (IOException var26) {
               var26.printStackTrace();
            }
         }

         File var23 = new File(var7);
         WidgetNode.field793 = var23;
         if(!WidgetNode.field793.exists()) {
            WidgetNode.field793.mkdirs();
         }

         File[] var32 = WidgetNode.field793.listFiles();
         if(var32 != null) {
            File[] var35 = var32;

            for(int var24 = 0; var24 < var35.length; ++var24) {
               File var25 = var35[var24];
               if(!class115.method2216(var25, false)) {
                  ++var4;
                  continue label259;
               }
            }
         }
         break;
      }

      File var18 = WidgetNode.field793;
      class158.field2163 = var18;
      if(!class158.field2163.exists()) {
         throw new RuntimeException("");
      } else {
         class158.field2162 = true;
         BoundingBox2D.method40();
         class156.dat2File = new CacheFile(new FileOnDisk(class1.method2("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
         class156.idx255File = new CacheFile(new FileOnDisk(class1.method2("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
         ItemContainer.idxFiles = new CacheFile[class156.idxCount];

         for(int var5 = 0; var5 < class156.idxCount; ++var5) {
            ItemContainer.idxFiles[var5] = new CacheFile(new FileOnDisk(class1.method2("main_file_cache.idx" + var5), "rw", 1048576L), 6000, 0);
         }

      }
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1964452391"
   )
   static final void method88(int var0, int var1) {
      if(ISAACCipher.loadWidget(var0)) {
         GrandExchangeOffer.method130(class11.widgets[var0], var1);
      }
   }
}
