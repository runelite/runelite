import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public final class class166 extends Buffer {
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -53952561
   )
   protected static int field2322;
   @ObfuscatedName("z")
   static final int[] field2323 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1691987539
   )
   int field2324;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -1313270173
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("g")
   class167 field2326;

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2117476289"
   )
   public void method3232() {
      this.field2324 = super.offset * 8;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "43"
   )
   public void method3233(int[] var1) {
      this.field2326 = new class167(var1);
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "848066910"
   )
   public void method3234(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2326.method3260());
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-907273843"
   )
   public int method3235() {
      return super.payload[++super.offset - 1] - this.field2326.method3260() & 255;
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2097274813"
   )
   public int method3237(int var1) {
      int var2 = this.field2324 >> 3;
      int var3 = 8 - (this.field2324 & 7);
      int var4 = 0;

      for(this.field2324 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2323[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2323[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2323[var1];
      }

      return var4;
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-2"
   )
   public void method3238() {
      super.offset = (7 + this.field2324) / 8;
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1575060681"
   )
   public int method3239(int var1) {
      return var1 * 8 - this.field2324;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class166(int var1) {
      super(var1);
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "2048593088"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1950094154"
   )
   public static int method3254(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "1338221207"
   )
   public static void method3255(String var0, String var1, int var2, int var3) throws IOException {
      class216.field3158 = var3;
      class103.field1671 = var2;

      try {
         class178.field2688 = System.getProperty("os.name");
      } catch (Exception var27) {
         class178.field2688 = "Unknown";
      }

      class26.field591 = class178.field2688.toLowerCase();

      try {
         Ignore.field211 = System.getProperty("user.home");
         if(null != Ignore.field211) {
            Ignore.field211 = Ignore.field211 + "/";
         }
      } catch (Exception var26) {
         ;
      }

      try {
         if(class26.field591.startsWith("win")) {
            if(Ignore.field211 == null) {
               Ignore.field211 = System.getenv("USERPROFILE");
            }
         } else if(Ignore.field211 == null) {
            Ignore.field211 = System.getenv("HOME");
         }

         if(Ignore.field211 != null) {
            Ignore.field211 = Ignore.field211 + "/";
         }
      } catch (Exception var25) {
         ;
      }

      if(Ignore.field211 == null) {
         Ignore.field211 = "~/";
      }

      class104.field1685 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", Ignore.field211, "/tmp/", ""};
      class65.field1105 = new String[]{".jagex_cache_" + class103.field1671, ".file_store_" + class103.field1671};
      int var18 = 0;

      label237:
      while(var18 < 4) {
         String var6 = var18 == 0?"":"" + var18;
         class104.field1679 = new File(Ignore.field211, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         File var32;
         if(class104.field1679.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class104.field1679, "rw", 10000L);

               Buffer var11;
               int var12;
               for(var11 = new Buffer((int)var10.method1439()); var11.offset < var11.payload.length; var11.offset += var12) {
                  var12 = var10.method1444(var11.payload, var11.offset, var11.payload.length - var11.offset);
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
                  var7 = var11.method2999();
                  if(var13 == 1) {
                     var8 = var11.method2999();
                  }
               } else {
                  var7 = var11.method3000();
                  if(var13 == 1) {
                     var8 = var11.method3000();
                  }
               }

               var10.method1442();
            } catch (IOException var29) {
               var29.printStackTrace();
            }

            if(null != var7) {
               var32 = new File(var7);
               if(!var32.exists()) {
                  var7 = null;
               }
            }

            if(null != var7) {
               var32 = new File(var7, "test.dat");
               if(!FaceNormal.method1925(var32, true)) {
                  var7 = null;
               }
            }
         }

         if(null == var7 && var18 == 0) {
            label211:
            for(int var19 = 0; var19 < class65.field1105.length; ++var19) {
               for(int var20 = 0; var20 < class104.field1685.length; ++var20) {
                  File var21 = new File(class104.field1685[var20] + class65.field1105[var19] + File.separatorChar + var0 + File.separatorChar);
                  if(var21.exists() && FaceNormal.method1925(new File(var21, "test.dat"), true)) {
                     var7 = var21.toString();
                     var9 = true;
                     break label211;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = Ignore.field211 + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         if(null != var8) {
            File var31 = new File(var8);
            var32 = new File(var7);

            try {
               File[] var34 = var31.listFiles();
               File[] var22 = var34;

               for(int var14 = 0; var14 < var22.length; ++var14) {
                  File var15 = var22[var14];
                  File var16 = new File(var32, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if(!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var28) {
               var28.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            class38.method770(new File(var7), (File)null);
         }

         File var5 = new File(var7);
         class104.field1676 = var5;
         if(!class104.field1676.exists()) {
            class104.field1676.mkdirs();
         }

         File[] var30 = class104.field1676.listFiles();
         if(null != var30) {
            File[] var33 = var30;

            for(int var23 = 0; var23 < var33.length; ++var23) {
               File var24 = var33[var23];
               if(!FaceNormal.method1925(var24, false)) {
                  ++var18;
                  continue label237;
               }
            }
         }
         break;
      }

      class88.method1907(class104.field1676);
      SecondaryBufferProvider.method4178();
      class104.field1680 = new class72(new FileOnDisk(class157.method2963("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class104.field1687 = new class72(new FileOnDisk(class157.method2963("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      class104.field1688 = new class72[class216.field3158];

      for(var18 = 0; var18 < class216.field3158; ++var18) {
         class104.field1688[var18] = new class72(new FileOnDisk(class157.method2963("main_file_cache.idx" + var18), "rw", 1048576L), 6000, 0);
      }

   }
}
