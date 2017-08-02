import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("Actor")
public abstract class Actor extends Renderable {
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -422491165
   )
   @Export("animation")
   @Hook("animationChanged")
   int animation;
   @ObfuscatedName("cq")
   @Export("pathX")
   int[] pathX;
   @ObfuscatedName("cy")
   @ObfuscatedGetter(
      intValue = -603773931
   )
   @Export("queueSize")
   int queueSize;
   @ObfuscatedName("ay")
   @Export("hitsplatCycles")
   int[] hitsplatCycles;
   @ObfuscatedName("cp")
   @Export("pathY")
   int[] pathY;
   @ObfuscatedName("av")
   boolean field1233;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 474603821
   )
   int field1237;
   @ObfuscatedName("ct")
   @ObfuscatedGetter(
      intValue = -431527927
   )
   int field1219;
   @ObfuscatedName("as")
   byte field1228;
   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("combatInfoList")
   CombatInfoList combatInfoList;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -2043719813
   )
   @Export("actionAnimationDisable")
   int actionAnimationDisable;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 1257404475
   )
   int field1267;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1719954681
   )
   @Export("poseAnimation")
   int poseAnimation;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1211826283
   )
   int field1213;
   @ObfuscatedName("az")
   @Export("hitsplatTypes")
   int[] hitsplatTypes;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 917294969
   )
   @Export("idlePoseAnimation")
   int idlePoseAnimation;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -874067597
   )
   @Export("actionFrame")
   int actionFrame;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -832709661
   )
   int field1215;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -542460393
   )
   @Export("poseFrame")
   int poseFrame;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 721617255
   )
   int field1216;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 988883679
   )
   int field1217;
   @ObfuscatedName("ck")
   byte[] field1266;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1150015827
   )
   int field1264;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1831915263
   )
   @Export("x")
   int x;
   @ObfuscatedName("au")
   int[] field1229;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -767451587
   )
   int field1244;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1283242151
   )
   int field1220;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 142279777
   )
   @Export("y")
   int y;
   @ObfuscatedName("ao")
   int[] field1261;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 255625899
   )
   int field1221;
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 870449561
   )
   int field1259;
   @ObfuscatedName("bz")
   int[] field1269;
   @ObfuscatedName("ac")
   @Export("overhead")
   String overhead;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 1847154205
   )
   @Export("graphic")
   int graphic;
   @ObfuscatedName("ah")
   @Export("inSequence")
   boolean inSequence;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 400670803
   )
   int field1247;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 620164563
   )
   int field1225;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 56146109
   )
   int field1226;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 541408365
   )
   int field1227;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 104651299
   )
   int field1250;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -467490783
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("bh")
   boolean field1249;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -759060373
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1916894997
   )
   int field1240;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 1030610461
   )
   int field1243;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1611436345
   )
   int field1245;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 800622225
   )
   int field1248;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 542206833
   )
   int field1258;
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -1409090203
   )
   int field1260;
   @ObfuscatedName("cc")
   @ObfuscatedGetter(
      intValue = -767959395
   )
   int field1232;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -2106220153
   )
   @Export("angle")
   int angle;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1899189459
   )
   @Export("graphicsDelay")
   int graphicsDelay;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 102992109
   )
   int field1255;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -578424087
   )
   int field1268;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -356726807
   )
   int field1236;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 61748419
   )
   int field1253;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = -716082787
   )
   int field1265;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 585667763
   )
   int field1254;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1539698365
   )
   int field1257;
   @ObfuscatedName("ae")
   boolean field1223;

   Actor() {
      this.field1233 = false;
      this.field1213 = 1;
      this.idlePoseAnimation = -1;
      this.field1215 = -1;
      this.field1216 = -1;
      this.field1217 = -1;
      this.field1264 = -1;
      this.field1244 = -1;
      this.field1220 = -1;
      this.field1221 = -1;
      this.overhead = null;
      this.inSequence = false;
      this.field1225 = 100;
      this.field1226 = 0;
      this.field1227 = 0;
      this.field1228 = 0;
      this.field1229 = new int[4];
      this.hitsplatTypes = new int[4];
      this.hitsplatCycles = new int[4];
      this.field1261 = new int[4];
      this.field1269 = new int[4];
      this.combatInfoList = new CombatInfoList();
      this.interacting = -1;
      this.field1249 = false;
      this.field1237 = -1;
      this.poseAnimation = -1;
      this.poseFrame = 0;
      this.field1240 = 0;
      this.animation = -1;
      this.actionFrame = 0;
      this.field1243 = 0;
      this.actionAnimationDisable = 0;
      this.field1245 = 0;
      this.graphic = -1;
      this.field1247 = 0;
      this.field1248 = 0;
      this.field1258 = 0;
      this.field1259 = 200;
      this.field1260 = 0;
      this.field1232 = 32;
      this.queueSize = 0;
      this.pathX = new int[10];
      this.pathY = new int[10];
      this.field1266 = new byte[10];
      this.field1267 = 0;
      this.field1219 = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "307360793"
   )
   @Export("hasConfig")
   boolean hasConfig() {
      return false;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "-108"
   )
   final void method1487(int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = true;
      boolean var8 = true;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         if(this.hitsplatCycles[var9] > var5) {
            var7 = false;
         } else {
            var8 = false;
         }
      }

      var9 = -1;
      int var10 = -1;
      int var11 = 0;
      if(var1 >= 0) {
         class254 var12 = DState.method3078(var1);
         var10 = var12.field3387;
         var11 = var12.field3396;
      }

      int var14;
      if(var8) {
         if(var10 == -1) {
            return;
         }

         var9 = 0;
         var14 = 0;
         if(var10 == 0) {
            var14 = this.hitsplatCycles[0];
         } else if(var10 == 1) {
            var14 = this.hitsplatTypes[0];
         }

         for(int var13 = 1; var13 < 4; ++var13) {
            if(var10 == 0) {
               if(this.hitsplatCycles[var13] < var14) {
                  var9 = var13;
                  var14 = this.hitsplatCycles[var13];
               }
            } else if(var10 == 1 && this.hitsplatTypes[var13] < var14) {
               var9 = var13;
               var14 = this.hitsplatTypes[var13];
            }
         }

         if(var10 == 1 && var14 >= var2) {
            return;
         }
      } else {
         if(var7) {
            this.field1228 = 0;
         }

         for(var14 = 0; var14 < 4; ++var14) {
            byte var15 = this.field1228;
            this.field1228 = (byte)((this.field1228 + 1) % 4);
            if(this.hitsplatCycles[var15] <= var5) {
               var9 = var15;
               break;
            }
         }
      }

      if(var9 >= 0) {
         this.field1229[var9] = var1;
         this.hitsplatTypes[var9] = var2;
         this.field1261[var9] = var3;
         this.field1269[var9] = var4;
         this.hitsplatCycles[var9] = var5 + var11 + var6;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1203600074"
   )
   final void method1478(int var1) {
      CombatInfo2 var3 = (CombatInfo2)CombatInfo2.field3340.get((long)var1);
      CombatInfo2 var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var4 = CombatInfo2.field3336.getConfigData(33, var1);
         var3 = new CombatInfo2();
         if(var4 != null) {
            var3.method4279(new Buffer(var4));
         }

         CombatInfo2.field3340.put(var3, (long)var1);
         var2 = var3;
      }

      var3 = var2;

      for(CombatInfoListHolder var5 = (CombatInfoListHolder)this.combatInfoList.method3513(); var5 != null; var5 = (CombatInfoListHolder)this.combatInfoList.method3527()) {
         if(var3 == var5.combatInfo2) {
            var5.unlink();
            return;
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIIIII)V",
      garbageValue = "1611343475"
   )
   final void method1477(int var1, int var2, int var3, int var4, int var5, int var6) {
      CombatInfo2 var8 = (CombatInfo2)CombatInfo2.field3340.get((long)var1);
      CombatInfo2 var7;
      if(var8 != null) {
         var7 = var8;
      } else {
         byte[] var9 = CombatInfo2.field3336.getConfigData(33, var1);
         var8 = new CombatInfo2();
         if(var9 != null) {
            var8.method4279(new Buffer(var9));
         }

         CombatInfo2.field3340.put(var8, (long)var1);
         var7 = var8;
      }

      var8 = var7;
      CombatInfoListHolder var14 = null;
      CombatInfoListHolder var10 = null;
      int var11 = var7.field3339;
      int var12 = 0;

      CombatInfoListHolder var13;
      for(var13 = (CombatInfoListHolder)this.combatInfoList.method3513(); var13 != null; var13 = (CombatInfoListHolder)this.combatInfoList.method3527()) {
         ++var12;
         if(var13.combatInfo2.field3345 == var8.field3345) {
            var13.method1621(var2 + var4, var5, var6, var3);
            return;
         }

         if(var13.combatInfo2.field3341 <= var8.field3341) {
            var14 = var13;
         }

         if(var13.combatInfo2.field3339 > var11) {
            var10 = var13;
            var11 = var13.combatInfo2.field3339;
         }
      }

      if(var10 != null || var12 < 4) {
         var13 = new CombatInfoListHolder(var8);
         if(var14 == null) {
            this.combatInfoList.method3523(var13);
         } else {
            CombatInfoList.method3511(var13, var14);
         }

         var13.method1621(var2 + var4, var5, var6, var3);
         if(var12 >= 4) {
            var10.unlink();
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1621960927"
   )
   final void method1474() {
      this.queueSize = 0;
      this.field1219 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "125"
   )
   public static void method1480() {
      Overlay.overlays.reset();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-2043274382"
   )
   public static void method1497(String var0, String var1, int var2, int var3) throws IOException {
      class7.field223 = var3;
      class155.field2209 = var2;

      try {
         class25.osName = System.getProperty("os.name");
      } catch (Exception var30) {
         class25.osName = "Unknown";
      }

      class155.osNameLC = class25.osName.toLowerCase();

      try {
         class64.userHome = System.getProperty("user.home");
         if(class64.userHome != null) {
            class64.userHome = class64.userHome + "/";
         }
      } catch (Exception var29) {
         ;
      }

      try {
         if(class155.osNameLC.startsWith("win")) {
            if(class64.userHome == null) {
               class64.userHome = System.getenv("USERPROFILE");
            }
         } else if(class64.userHome == null) {
            class64.userHome = System.getenv("HOME");
         }

         if(class64.userHome != null) {
            class64.userHome = class64.userHome + "/";
         }
      } catch (Exception var28) {
         ;
      }

      if(class64.userHome == null) {
         class64.userHome = "~/";
      }

      class91.cacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class64.userHome, "/tmp/", ""};
      class155.field2210 = new String[]{".jagex_cache_" + class155.field2209, ".file_store_" + class155.field2209};
      int var4 = 0;

      label292:
      while(var4 < 4) {
         String var6 = var4 == 0?"":"" + var4;
         class155.field2204 = new File(class64.userHome, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         Buffer var11;
         File var37;
         if(class155.field2204.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class155.field2204, "rw", 10000L);

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
            } catch (IOException var33) {
               var33.printStackTrace();
            }

            if(var7 != null) {
               var37 = new File(var7);
               if(!var37.exists()) {
                  var7 = null;
               }
            }

            if(var7 != null) {
               var37 = new File(var7, "test.dat");
               if(!WorldListFetcher.method1466(var37, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var4 == 0) {
            label266:
            for(int var18 = 0; var18 < class155.field2210.length; ++var18) {
               for(int var19 = 0; var19 < class91.cacheLocations.length; ++var19) {
                  File var20 = new File(class91.cacheLocations[var19] + class155.field2210[var18] + File.separatorChar + var0 + File.separatorChar);
                  if(var20.exists() && WorldListFetcher.method1466(new File(var20, "test.dat"), true)) {
                     var7 = var20.toString();
                     var9 = true;
                     break label266;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = class64.userHome + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         File var36;
         if(var8 != null) {
            var36 = new File(var8);
            var37 = new File(var7);

            try {
               File[] var40 = var36.listFiles();
               File[] var21 = var40;

               for(int var14 = 0; var14 < var21.length; ++var14) {
                  File var15 = var21[var14];
                  File var16 = new File(var37, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if(!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var32) {
               var32.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            var36 = new File(var7);
            var11 = null;

            try {
               FileOnDisk var41 = new FileOnDisk(class155.field2204, "rw", 10000L);
               Buffer var42 = new Buffer(500);
               var42.putByte(3);
               var42.putByte(var11 != null?1:0);
               var42.putCESU8(var36.getPath());
               if(var11 != null) {
                  var42.putCESU8("");
               }

               var41.write(var42.payload, 0, var42.offset);
               var41.close();
            } catch (IOException var27) {
               var27.printStackTrace();
            }
         }

         File var5 = new File(var7);
         class268.field3656 = var5;
         if(!class268.field3656.exists()) {
            class268.field3656.mkdirs();
         }

         File[] var35 = class268.field3656.listFiles();
         if(var35 != null) {
            File[] var38 = var35;

            for(int var22 = 0; var22 < var38.length; ++var22) {
               File var23 = var38[var22];
               if(!WorldListFetcher.method1466(var23, false)) {
                  ++var4;
                  continue label292;
               }
            }
         }
         break;
      }

      DynamicObject.method1790(class268.field3656);

      try {
         File var24 = new File(class64.userHome, "random.dat");
         int var25;
         if(var24.exists()) {
            class155.field2207 = new CacheFile(new FileOnDisk(var24, "rw", 25L), 24, 0);
         } else {
            label219:
            for(int var26 = 0; var26 < class155.field2210.length; ++var26) {
               for(var25 = 0; var25 < class91.cacheLocations.length; ++var25) {
                  File var39 = new File(class91.cacheLocations[var25] + class155.field2210[var26] + File.separatorChar + "random.dat");
                  if(var39.exists()) {
                     class155.field2207 = new CacheFile(new FileOnDisk(var39, "rw", 25L), 24, 0);
                     break label219;
                  }
               }
            }
         }

         if(class155.field2207 == null) {
            RandomAccessFile var34 = new RandomAccessFile(var24, "rw");
            var25 = var34.read();
            var34.seek(0L);
            var34.write(var25);
            var34.seek(0L);
            var34.close();
            class155.field2207 = new CacheFile(new FileOnDisk(var24, "rw", 25L), 24, 0);
         }
      } catch (IOException var31) {
         ;
      }

      class155.field2211 = new CacheFile(new FileOnDisk(class35.method482("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
      class155.field2203 = new CacheFile(new FileOnDisk(class35.method482("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
      Signlink.field2199 = new CacheFile[class7.field223];

      for(var4 = 0; var4 < class7.field223; ++var4) {
         Signlink.field2199[var4] = new CacheFile(new FileOnDisk(class35.method482("main_file_cache.idx" + var4), "rw", 1048576L), 6000, 0);
      }

   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "16"
   )
   static final void method1496(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class19.region.method2760(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class19.region.method2715(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class43.field576.image;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class169.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = DynamicObject.field1519[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method4941(var15 + 48 + var1 * 4, 48 + (104 - var2 - var13.sizeY) * 4 + var16);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class19.region.method2645(var0, var1, var2);
      if(var5 != 0) {
         var6 = class19.region.method2715(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class169.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = DynamicObject.field1519[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.sizeX * 4 - var17.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var17.height) / 2;
               var17.method4941(var1 * 4 + 48 + var12, (104 - var2 - var23.sizeY) * 4 + 48 + var18);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class43.field576.image;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 512 + 1] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1024 + 1] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = class19.region.method2646(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = class169.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = DynamicObject.field1519[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.sizeX * 4 - var20.originalWidth) / 2;
               int var21 = (var19.sizeY * 4 - var20.height) / 2;
               var20.method4941(var9 + var1 * 4 + 48, (104 - var2 - var19.sizeY) * 4 + 48 + var21);
            }
         }
      }

   }
}
