import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1041059663
   )
   @Export("forcedPriority")
   public int forcedPriority = 5;
   @ObfuscatedName("d")
   int[] field3037;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -188032487
   )
   @Export("leftHandItem")
   public int leftHandItem = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1021549953
   )
   @Export("priority")
   public int priority = -1;
   @ObfuscatedName("f")
   public static NodeCache field3040 = new NodeCache(100);
   @ObfuscatedName("c")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("u")
   static class182 field3042;
   @ObfuscatedName("x")
   static class182 field3043;
   @ObfuscatedName("a")
   public static NodeCache field3044 = new NodeCache(64);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1753617699
   )
   @Export("frameStep")
   public int frameStep = -1;
   @ObfuscatedName("t")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("m")
   @Export("stretches")
   public boolean stretches = false;
   @ObfuscatedName("l")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("g")
   public int[] field3049;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1591609443
   )
   @Export("rightHandItem")
   public int rightHandItem = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1220351781
   )
   @Export("maxLoops")
   public int maxLoops = 99;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 161781057
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 580349453
   )
   @Export("replyMode")
   public int replyMode = 2;
   @ObfuscatedName("i")
   static class182 field3054;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2127059034"
   )
   void method3750(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedShort();
         this.frameLenghts = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameLenghts[var4] = var1.readUnsignedShort();
         }

         this.frameIDs = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 2) {
         this.frameStep = var1.readUnsignedShort();
      } else if(var2 == 3) {
         var3 = var1.readUnsignedByte();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.readUnsignedByte();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.forcedPriority = var1.readUnsignedByte();
      } else if(var2 == 6) {
         this.leftHandItem = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.rightHandItem = var1.readUnsignedShort();
      } else if(var2 == 8) {
         this.maxLoops = var1.readUnsignedByte();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.readUnsignedByte();
      } else if(var2 == 10) {
         this.priority = var1.readUnsignedByte();
      } else if(var2 == 11) {
         this.replyMode = var1.readUnsignedByte();
      } else if(var2 == 12) {
         var3 = var1.readUnsignedByte();
         this.field3037 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3037[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3037[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3049 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3049[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1637608432"
   )
   void method3751() {
      if(this.precedenceAnimating == -1) {
         if(this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.priority == -1) {
         if(null != this.interleaveLeave) {
            this.priority = 2;
         } else {
            this.priority = 0;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LModel;III)LModel;",
      garbageValue = "2057545288"
   )
   Model method3753(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = XItemContainer.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var4) {
         return var1.method1557(true);
      } else {
         Model var5 = var1.method1557(!var4.method1849(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method1527();
         } else if(var3 == 2) {
            var5.method1516();
         } else if(var3 == 3) {
            var5.method1525();
         }

         var5.method1522(var4, var2);
         if(var3 == 1) {
            var5.method1525();
         } else if(var3 == 2) {
            var5.method1516();
         } else if(var3 == 3) {
            var5.method1527();
         }

         return var5;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "-166653368"
   )
   Model method3754(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = XItemContainer.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method1517(true);
      } else {
         Model var4 = var1.method1517(!var3.method1849(var2));
         var4.method1522(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LModel;ILSequence;II)LModel;",
      garbageValue = "1892038565"
   )
   public Model method3755(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = XItemContainer.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method3764(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = XItemContainer.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(null == var6) {
            var7 = var1.method1557(!var5.method1849(var2));
            var7.method1522(var5, var2);
            return var7;
         } else {
            var7 = var1.method1557(!var5.method1849(var2) & !var6.method1849(var4));
            var7.method1523(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LModel;II)LModel;",
      garbageValue = "1379670188"
   )
   public Model method3756(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = XItemContainer.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(null == var4) {
         return var1.method1557(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(null != this.field3037 && var2 < this.field3037.length) {
            var6 = this.field3037[var2];
            var5 = XItemContainer.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method1557(!var4.method1849(var3) & !var5.method1849(var6));
            var7.method1522(var4, var3);
            var7.method1522(var5, var6);
            return var7;
         } else {
            var7 = var1.method1557(!var4.method1849(var3));
            var7.method1522(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LModel;IB)LModel;",
      garbageValue = "-69"
   )
   public Model method3764(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = XItemContainer.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(null == var3) {
         return var1.method1557(true);
      } else {
         Model var4 = var1.method1557(!var3.method1849(var2));
         var4.method1522(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-599689900"
   )
   void method3776(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3750(var1, var2);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "-29"
   )
   static boolean method3783(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class114.field1775.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class100.method1902(class114.field1778, var2, new Object[]{(new URL(class114.field1778.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class114.field1778.getAppletContext().showDocument(new URL(class114.field1778.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class100.method1901(class114.field1778, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class114.field1778.getAppletContext().showDocument(new URL(class114.field1778.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-1430742667"
   )
   public static void method3784(String var0, String var1, int var2, int var3) throws IOException {
      class104.field1673 = var3;
      Frames.field1561 = var2;

      try {
         class104.field1678 = System.getProperty("os.name");
      } catch (Exception var29) {
         class104.field1678 = "Unknown";
      }

      Ignore.field207 = class104.field1678.toLowerCase();

      try {
         FrameMap.field1465 = System.getProperty("user.home");
         if(null != FrameMap.field1465) {
            FrameMap.field1465 = FrameMap.field1465 + "/";
         }
      } catch (Exception var28) {
         ;
      }

      try {
         if(Ignore.field207.startsWith("win")) {
            if(FrameMap.field1465 == null) {
               FrameMap.field1465 = System.getenv("USERPROFILE");
            }
         } else if(FrameMap.field1465 == null) {
            FrameMap.field1465 = System.getenv("HOME");
         }

         if(null != FrameMap.field1465) {
            FrameMap.field1465 = FrameMap.field1465 + "/";
         }
      } catch (Exception var27) {
         ;
      }

      if(null == FrameMap.field1465) {
         FrameMap.field1465 = "~/";
      }

      Friend.field161 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", FrameMap.field1465, "/tmp/", ""};
      class174.field2621 = new String[]{".jagex_cache_" + Frames.field1561, ".file_store_" + Frames.field1561};
      int var18 = 0;

      label270:
      while(var18 < 4) {
         String var6 = var18 == 0?"":"" + var18;
         class104.field1671 = new File(FrameMap.field1465, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         File var36;
         if(class104.field1671.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class104.field1671, "rw", 10000L);

               Buffer var11;
               int var12;
               for(var11 = new Buffer((int)var10.method1367()); var11.offset < var11.payload.length; var11.offset += var12) {
                  var12 = var10.method1368(var11.payload, var11.offset, var11.payload.length - var11.offset);
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
                  var7 = var11.method2784();
                  if(var13 == 1) {
                     var8 = var11.method2784();
                  }
               } else {
                  var7 = var11.method2949();
                  if(var13 == 1) {
                     var8 = var11.method2949();
                  }
               }

               var10.method1365();
            } catch (IOException var32) {
               var32.printStackTrace();
            }

            if(var7 != null) {
               var36 = new File(var7);
               if(!var36.exists()) {
                  var7 = null;
               }
            }

            if(var7 != null) {
               var36 = new File(var7, "test.dat");
               if(!XGrandExchangeOffer.method63(var36, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var18 == 0) {
            label245:
            for(int var19 = 0; var19 < class174.field2621.length; ++var19) {
               for(int var20 = 0; var20 < Friend.field161.length; ++var20) {
                  File var21 = new File(Friend.field161[var20] + class174.field2621[var19] + File.separatorChar + var0 + File.separatorChar);
                  if(var21.exists() && XGrandExchangeOffer.method63(new File(var21, "test.dat"), true)) {
                     var7 = var21.toString();
                     var9 = true;
                     break label245;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = FrameMap.field1465 + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         if(null != var8) {
            File var35 = new File(var8);
            var36 = new File(var7);

            try {
               File[] var39 = var35.listFiles();
               File[] var22 = var39;

               for(int var14 = 0; var14 < var22.length; ++var14) {
                  File var15 = var22[var14];
                  File var16 = new File(var36, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if(!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var31) {
               var31.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            class41.method770(new File(var7), (File)null);
         }

         File var5 = new File(var7);
         class104.field1672 = var5;
         if(!class104.field1672.exists()) {
            class104.field1672.mkdirs();
         }

         File[] var34 = class104.field1672.listFiles();
         if(null != var34) {
            File[] var37 = var34;

            for(int var23 = 0; var23 < var37.length; ++var23) {
               File var24 = var37[var23];
               if(!XGrandExchangeOffer.method63(var24, false)) {
                  ++var18;
                  continue label270;
               }
            }
         }
         break;
      }

      class72.method1361(class104.field1672);

      try {
         File var4 = new File(FrameMap.field1465, "random.dat");
         int var26;
         if(var4.exists()) {
            class104.field1682 = new class72(new FileOnDisk(var4, "rw", 25L), 24, 0);
         } else {
            label198:
            for(int var25 = 0; var25 < class174.field2621.length; ++var25) {
               for(var26 = 0; var26 < Friend.field161.length; ++var26) {
                  File var38 = new File(Friend.field161[var26] + class174.field2621[var25] + File.separatorChar + "random.dat");
                  if(var38.exists()) {
                     class104.field1682 = new class72(new FileOnDisk(var38, "rw", 25L), 24, 0);
                     break label198;
                  }
               }
            }
         }

         if(null == class104.field1682) {
            RandomAccessFile var33 = new RandomAccessFile(var4, "rw");
            var26 = var33.read();
            var33.seek(0L);
            var33.write(var26);
            var33.seek(0L);
            var33.close();
            class104.field1682 = new class72(new FileOnDisk(var4, "rw", 25L), 24, 0);
         }
      } catch (IOException var30) {
         ;
      }

      class104.field1676 = new class72(new FileOnDisk(Ignore.method188("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class104.field1677 = new class72(new FileOnDisk(Ignore.method188("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      class215.field3160 = new class72[class104.field1673];

      for(var18 = 0; var18 < class104.field1673; ++var18) {
         class215.field3160[var18] = new class72(new FileOnDisk(Ignore.method188("main_file_cache.idx" + var18), "rw", 1048576L), 6000, 0);
      }

   }
}
