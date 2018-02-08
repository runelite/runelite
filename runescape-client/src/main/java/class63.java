import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class63 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   final IndexData field742;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -384268341
   )
   final int field741;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -621481079
   )
   int field743;

   @ObfuscatedSignature(
      signature = "(Lij;Ljava/lang/String;)V"
   )
   class63(IndexData var1, String var2) {
      this.field743 = 0;
      this.field742 = var1;
      this.field741 = var1.size();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1024711495"
   )
   boolean method1034() {
      this.field743 = 0;

      for(int var1 = 0; var1 < this.field741; ++var1) {
         if(!this.field742.method4608(var1) || this.field742.method4607(var1)) {
            ++this.field743;
         }
      }

      return this.field743 >= this.field741;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "1390544966"
   )
   static File method1035(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class157.jagexClDat = new File(TotalQuantityComparator.userHome, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var22;
      if(class157.jagexClDat.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class157.jagexClDat, "rw", 10000L);

            Buffer var8;
            int var9;
            for(var8 = new Buffer((int)var7.length()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.read(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.getJagString();
               if(var10 == 1) {
                  var5 = var8.getJagString();
               }
            } else {
               var4 = var8.getCESU8();
               if(var10 == 1) {
                  var5 = var8.getCESU8();
               }
            }

            var7.close();
         } catch (IOException var20) {
            var20.printStackTrace();
         }

         if(var4 != null) {
            var22 = new File(var4);
            if(!var22.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var22 = new File(var4, "test.dat");
            if(!Size.method183(var22, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label122:
         for(int var15 = 0; var15 < class84.field1281.length; ++var15) {
            for(int var16 = 0; var16 < class279.cacheLocations.length; ++var16) {
               File var17 = new File(class279.cacheLocations[var16] + class84.field1281[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && Size.method183(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label122;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = TotalQuantityComparator.userHome + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(var5 != null) {
         File var21 = new File(var5);
         var22 = new File(var4);

         try {
            File[] var23 = var21.listFiles();
            File[] var18 = var23;

            for(int var11 = 0; var11 < var18.length; ++var11) {
               File var12 = var18[var11];
               File var13 = new File(var22, var12.getName());
               boolean var14 = var12.renameTo(var13);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var19) {
            var19.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         ContextMenuRow.method1875(new File(var4), (File)null);
      }

      return new File(var4);
   }
}
