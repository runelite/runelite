import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
public class class86 {
   @ObfuscatedName("v")
   static final BigInteger field1304;
   @ObfuscatedName("x")
   static final BigInteger field1299;

   static {
      field1304 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1299 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lid;",
      garbageValue = "1884593103"
   )
   static BuildType[] method1792() {
      return new BuildType[]{BuildType.RC, BuildType.WIP, BuildType.BUILD_LIVE, BuildType.LIVE};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;II)Ljava/io/File;",
      garbageValue = "578782654"
   )
   public static File method1785(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      WidgetNode.field781 = new File(class115.userHome, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      File var22;
      if(WidgetNode.field781.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(WidgetNode.field781, "rw", 10000L);

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
            if(!WorldMapType3.method231(var22, true)) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label124:
         for(int var15 = 0; var15 < class156.field2164.length; ++var15) {
            for(int var16 = 0; var16 < class44.cacheLocations.length; ++var16) {
               File var17 = new File(class44.cacheLocations[var16] + class156.field2164[var15] + File.separatorChar + var0 + File.separatorChar);
               if(var17.exists() && WorldMapType3.method231(new File(var17, "test.dat"), true)) {
                  var4 = var17.toString();
                  var6 = true;
                  break label124;
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class115.userHome + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
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
         class14.method86(new File(var4), (File)null);
      }

      return new File(var4);
   }
}
