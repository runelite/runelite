import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   public static IndexDataBase field3438;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("inventoryCache")
   public static NodeCache inventoryCache;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -689507525
   )
   @Export("size")
   public int size;

   static {
      inventoryCache = new NodeCache(64);
   }

   public InvType() {
      this.size = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "1651384576"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4731(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "236529801"
   )
   void method4731(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IB)Ljava/io/File;",
      garbageValue = "16"
   )
   public static File method4737(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class167.jagexClDat = new File(class22.userHome, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      int var11;
      File var26;
      if(class167.jagexClDat.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class167.jagexClDat, "rw", 10000L);

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
         } catch (IOException var24) {
            var24.printStackTrace();
         }

         if(var4 != null) {
            var26 = new File(var4);
            if(!var26.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var26 = new File(var4, "test.dat");

            boolean var27;
            try {
               RandomAccessFile var15 = new RandomAccessFile(var26, "rw");
               var11 = var15.read();
               var15.seek(0L);
               var15.write(var11);
               var15.seek(0L);
               var15.close();
               var26.delete();
               var27 = true;
            } catch (Exception var22) {
               var27 = false;
            }

            if(!var27) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label137:
         for(int var16 = 0; var16 < class167.field2214.length; ++var16) {
            for(int var17 = 0; var17 < class27.cacheLocations.length; ++var17) {
               File var18 = new File(class27.cacheLocations[var17] + class167.field2214[var16] + File.separatorChar + var0 + File.separatorChar);
               if(var18.exists()) {
                  File var19 = new File(var18, "test.dat");

                  boolean var28;
                  try {
                     RandomAccessFile var12 = new RandomAccessFile(var19, "rw");
                     int var13 = var12.read();
                     var12.seek(0L);
                     var12.write(var13);
                     var12.seek(0L);
                     var12.close();
                     var19.delete();
                     var28 = true;
                  } catch (Exception var21) {
                     var28 = false;
                  }

                  if(var28) {
                     var4 = var18.toString();
                     var6 = true;
                     break label137;
                  }
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class22.userHome + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(var5 != null) {
         File var25 = new File(var5);
         var26 = new File(var4);

         try {
            File[] var31 = var25.listFiles();
            File[] var30 = var31;

            for(var11 = 0; var11 < var30.length; ++var11) {
               File var29 = var30[var11];
               File var20 = new File(var26, var29.getName());
               boolean var14 = var29.renameTo(var20);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var23) {
            var23.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         ObjectComposition.method5052(new File(var4), (File)null);
      }

      return new File(var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "-376170637"
   )
   public static int method4738(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgf;ILbx;II)V",
      garbageValue = "-2123634847"
   )
   static final void method4730(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 256) != 0) {
         var2.graphic = var0.method3716();
         var5 = var0.method3564();
         var2.field1191 = var5 >> 16;
         var2.graphicsDelay = (var5 & 65535) + Client.gameCycle;
         var2.spotAnimFrame = 0;
         var2.spotAnimFrameCycle = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.spotAnimFrame = -1;
         }

         if(var2.graphic == 65535) {
            var2.graphic = -1;
         }
      }

      if((var3 & 2048) != 0) {
         class93.field1409[var1] = var0.readByte();
      }

      if((var3 & 4096) != 0) {
         var2.field1192 = var0.readByte();
         var2.field1202 = var0.method3551();
         var2.field1193 = var0.readByte();
         var2.field1178 = var0.method3550();
         var2.field1196 = var0.method3513() + Client.gameCycle;
         var2.field1197 = var0.method3716() + Client.gameCycle;
         var2.field1198 = var0.method3716();
         if(var2.field837) {
            var2.field1192 += var2.field847;
            var2.field1202 += var2.field846;
            var2.field1193 += var2.field847;
            var2.field1178 += var2.field846;
            var2.queueSize = 0;
         } else {
            var2.field1192 += var2.pathX[0];
            var2.field1202 += var2.pathY[0];
            var2.field1193 += var2.pathX[0];
            var2.field1178 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1194 = 0;
      }

      if((var3 & 1) != 0) {
         var2.interacting = var0.readUnsignedShort();
         if(var2.interacting == 65535) {
            var2.interacting = -1;
         }
      }

      int var6;
      int var8;
      int var9;
      if((var3 & 16) != 0) {
         var5 = var0.method3673();
         int var7;
         int var10;
         int var11;
         if(var5 > 0) {
            for(var6 = 0; var6 < var5; ++var6) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var7 = var0.getUSmart();
               if(var7 == 32767) {
                  var7 = var0.getUSmart();
                  var9 = var0.getUSmart();
                  var8 = var0.getUSmart();
                  var10 = var0.getUSmart();
               } else if(var7 != 32766) {
                  var9 = var0.getUSmart();
               } else {
                  var7 = -1;
               }

               var11 = var0.getUSmart();
               var2.method1586(var7, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var6 = var0.method3673();
         if(var6 > 0) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var10 = var0.getUSmart();
                  var11 = var0.method3673();
                  int var12 = var9 > 0?var0.method3548():var11;
                  var2.setCombatInfo(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method1588(var8);
               }
            }
         }
      }

      if((var3 & 512) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if((var3 & 1024) != 0) {
         var4 = var0.method3551();
      }

      if((var3 & 128) != 0) {
         var5 = var0.readUnsignedShortOb1();
         if(var5 == 65535) {
            var5 = -1;
         }

         var6 = var0.readUnsignedByte();
         FontName.method5496(var2, var5, var6);
      }

      if((var3 & 2) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == '~') {
            var2.overhead = var2.overhead.substring(1);
            class189.sendGameMessage(2, var2.name.getName(), var2.overhead);
         } else if(var2 == WorldComparator.localPlayer) {
            class189.sendGameMessage(2, var2.name.getName(), var2.overhead);
         }

         var2.field1167 = false;
         var2.field1207 = 0;
         var2.field1168 = 0;
         var2.overheadTextCyclesRemaining = 150;
      }

      if((var3 & 4) != 0) {
         var2.field1165 = var0.readUnsignedShortOb1();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1165;
            var2.field1165 = -1;
         }
      }

      if((var3 & 64) != 0) {
         var5 = var0.method3716();
         Permission var15 = (Permission)class44.forOrdinal(class3.method6(), var0.method3548());
         boolean var20 = var0.readUnsignedByte() == 1;
         var8 = var0.method3548();
         var9 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var21 = false;
            if(var15.field3327 && RunException.friendManager.method1695(var2.name)) {
               var21 = true;
            }

            if(!var21 && Client.myPlayerIndex == 0 && !var2.hidden) {
               class93.field1423.offset = 0;
               var0.method3559(class93.field1423.payload, 0, var8);
               class93.field1423.offset = 0;
               Buffer var17 = class93.field1423;
               String var18 = BaseVarType.method13(var17, 32767);
               String var13 = FontTypeFace.appendTags(Item.method1925(var18));
               var2.overhead = var13.trim();
               var2.field1207 = var5 >> 8;
               var2.field1168 = var5 & 255;
               var2.overheadTextCyclesRemaining = 150;
               var2.field1167 = var20;
               var2.field1179 = var2 != WorldComparator.localPlayer && var15.field3327 && "" != Client.field869 && var13.toLowerCase().indexOf(Client.field869) == -1;
               int var14;
               if(var15.field3335) {
                  var14 = var20?91:1;
               } else {
                  var14 = var20?90:2;
               }

               if(var15.field3334 != -1) {
                  class189.sendGameMessage(var14, class22.method186(var15.field3334) + var2.name.getName(), var13);
               } else {
                  class189.sendGameMessage(var14, var2.name.getName(), var13);
               }
            }
         }

         var0.offset = var8 + var9;
      }

      if((var3 & 8) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var22 = new byte[var5];
         Buffer var16 = new Buffer(var22);
         var0.method3559(var22, 0, var5);
         class93.field1413[var1] = var16;
         var2.decodeApperance(var16);
      }

      if(var2.field837) {
         if(var4 == 127) {
            var2.method1159(var2.field847, var2.field846);
         } else {
            byte var19;
            if(var4 != -1) {
               var19 = var4;
            } else {
               var19 = class93.field1409[var1];
            }

            var2.method1149(var2.field847, var2.field846, var19);
         }
      }

   }
}
