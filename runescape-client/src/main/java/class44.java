import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class44 extends WorldMapData {
   @ObfuscatedName("h")
   @Export("cacheLocations")
   public static String[] cacheLocations;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1611182313
   )
   static int field561;
   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;
   @ObfuscatedName("y")
   HashSet field554;
   @ObfuscatedName("w")
   HashSet field558;
   @ObfuscatedName("k")
   List field556;

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(Lfv;Lfv;Lfv;IZI)V",
      garbageValue = "-1992840451"
   )
   void method680(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field554 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method178(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field554.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field558 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class45 var9 = new class45();

         try {
            var9.method694(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field558.add(var9);
      }

      this.method681(var2, var5);
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(Lfv;ZB)V",
      garbageValue = "116"
   )
   void method681(Buffer var1, boolean var2) {
      this.field556 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3301();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field556.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method689() {
      class61.field726 = null;
      class285.field3790 = null;
      class61.field727 = null;
      class37.field490 = null;
      ItemLayer.field1710 = null;
      class61.field738 = null;
      class218.field2686 = null;
      class61.field729 = null;
      RSCanvas.field632 = null;
      Preferences.field1227 = null;
      FloorUnderlayDefinition.field3399 = null;
      class61.field728 = null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1357681587"
   )
   public static void method679() {
      try {
         File var0 = new File(class115.userHome, "random.dat");
         int var2;
         if(var0.exists()) {
            class156.field2160 = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label37:
            for(int var4 = 0; var4 < class156.field2164.length; ++var4) {
               for(var2 = 0; var2 < cacheLocations.length; ++var2) {
                  File var3 = new File(cacheLocations[var2] + class156.field2164[var4] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class156.field2160 = new CacheFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label37;
                  }
               }
            }
         }

         if(class156.field2160 == null) {
            RandomAccessFile var1 = new RandomAccessFile(var0, "rw");
            var2 = var1.read();
            var1.seek(0L);
            var1.write(var2);
            var1.seek(0L);
            var1.close();
            class156.field2160 = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)Z",
      garbageValue = "-21"
   )
   static final boolean method688(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = class133.field1912 + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = class133.field1912 - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = class133.field1914 + var6;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = class133.field1914 - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgi;ILbq;II)V",
      garbageValue = "2079034960"
   )
   static final void method690(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 512) != 0) {
         var2.graphic = var0.method3322();
         var5 = var0.method3331();
         var2.field1184 = var5 >> 16;
         var2.graphicsDelay = (var5 & 65535) + Client.gameCycle;
         var2.field1181 = 0;
         var2.field1182 = 0;
         if(var2.graphicsDelay > Client.gameCycle) {
            var2.field1181 = -1;
         }

         if(var2.graphic == 65535) {
            var2.graphic = -1;
         }
      }

      if((var3 & 2048) != 0) {
         class94.field1411[var1] = var0.method3318();
      }

      if((var3 & 8) != 0) {
         var2.overhead = var0.readString();
         if(var2.overhead.charAt(0) == '~') {
            var2.overhead = var2.overhead.substring(1);
            class96.sendGameMessage(2, var2.name, var2.overhead);
         } else if(var2 == class48.localPlayer) {
            class96.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field1147 = false;
         var2.field1160 = 0;
         var2.field1188 = 0;
         var2.field1148 = 150;
      }

      int var6;
      int var8;
      int var9;
      int var12;
      if((var3 & 64) != 0) {
         var5 = var0.method3313();
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
               var2.method1617(var7, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var6 = var0.method3314();
         if(var6 > 0) {
            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var0.getUSmart();
               var9 = var0.getUSmart();
               if(var9 != 32767) {
                  var10 = var0.getUSmart();
                  var11 = var0.method3407();
                  var12 = var9 > 0?var0.method3407():var11;
                  var2.method1618(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method1619(var8);
               }
            }
         }
      }

      if((var3 & 256) != 0) {
         var4 = var0.readByte();
      }

      if((var3 & 4) != 0) {
         var5 = var0.readUnsignedShort();
         Permission var16 = (Permission)class47.forOrdinal(class15.method112(), var0.method3313());
         boolean var20 = var0.method3407() == 1;
         var8 = var0.readUnsignedByte();
         var9 = var0.offset;
         if(var2.name != null && var2.composition != null) {
            boolean var21 = false;
            if(var16.field3235 && Tile.isIgnored(var2.name)) {
               var21 = true;
            }

            if(!var21 && Client.field968 == 0 && !var2.hidden) {
               class94.field1414.offset = 0;
               var0.method3460(class94.field1414.payload, 0, var8);
               class94.field1414.offset = 0;
               String var17 = FontTypeFace.appendTags(ObjectComposition.method4745(IndexFile.method3133(class94.field1414)));
               var2.overhead = var17.trim();
               var2.field1160 = var5 >> 8;
               var2.field1188 = var5 & 255;
               var2.field1148 = 150;
               var2.field1147 = var20;
               var2.inSequence = var2 != class48.localPlayer && var16.field3235 && "" != Client.field1014 && var17.toLowerCase().indexOf(Client.field1014) == -1;
               if(var16.field3239) {
                  var12 = var20?91:1;
               } else {
                  var12 = var20?90:2;
               }

               if(var16.field3240 != -1) {
                  int var15 = var16.field3240;
                  String var14 = "<img=" + var15 + ">";
                  class96.sendGameMessage(var12, var14 + var2.name, var17);
               } else {
                  class96.sendGameMessage(var12, var2.name, var17);
               }
            }
         }

         var0.offset = var9 + var8;
      }

      if((var3 & 128) != 0) {
         var2.interacting = var0.method3322();
         if(var2.interacting == 65535) {
            var2.interacting = -1;
         }
      }

      if((var3 & 16) != 0) {
         var5 = var0.method3313();
         byte[] var22 = new byte[var5];
         Buffer var18 = new Buffer(var22);
         var0.method3334(var22, 0, var5);
         class94.field1404[var1] = var18;
         var2.decodeApperance(var18);
      }

      if((var3 & 4096) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readString();
         }
      }

      if((var3 & 32) != 0) {
         var5 = var0.readUnsignedShortOb1();
         if(var5 == 65535) {
            var5 = -1;
         }

         var6 = var0.method3313();
         class34.method503(var2, var5, var6);
      }

      if((var3 & 1024) != 0) {
         var2.field1185 = var0.method3318();
         var2.field1159 = var0.method3318();
         var2.field1143 = var0.method3318();
         var2.field1199 = var0.method3318();
         var2.field1164 = var0.readUnsignedShortOb1() + Client.gameCycle;
         var2.field1177 = var0.method3322() + Client.gameCycle;
         var2.field1191 = var0.readUnsignedShortOb1();
         if(var2.field854) {
            var2.field1185 += var2.field855;
            var2.field1159 += var2.field858;
            var2.field1143 += var2.field855;
            var2.field1199 += var2.field858;
            var2.queueSize = 0;
         } else {
            var2.field1185 += var2.pathX[0];
            var2.field1159 += var2.pathY[0];
            var2.field1143 += var2.pathX[0];
            var2.field1199 += var2.pathY[0];
            var2.queueSize = 1;
         }

         var2.field1186 = 0;
      }

      if((var3 & 2) != 0) {
         var2.field1202 = var0.readUnsignedShortOb1();
         if(var2.queueSize == 0) {
            var2.orientation = var2.field1202;
            var2.field1202 = -1;
         }
      }

      if(var2.field854) {
         if(var4 == 127) {
            var2.method1191(var2.field855, var2.field858);
         } else {
            byte var19;
            if(var4 != -1) {
               var19 = var4;
            } else {
               var19 = class94.field1411[var1];
            }

            var2.method1190(var2.field855, var2.field858, var19);
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "581355636"
   )
   static final int method691(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1902888996"
   )
   static final void method685(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method4831()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1201 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1049[var4][var5] == Client.field953) {
                     continue;
                  }

                  Client.field1049[var4][var5] = Client.field953;
               }

               if(!var2.composition.field3614) {
                  var3 -= Integer.MIN_VALUE;
               }

               class56.region.method2920(Ignore.plane, var2.x, var2.y, class70.getTileHeight(var2.field1201 * 64 - 64 + var2.x, var2.field1201 * 64 - 64 + var2.y, Ignore.plane), var2.field1201 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1146);
            }
         }
      }

   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "(Lhk;IIII)V",
      garbageValue = "-1713706334"
   )
   static final void method692(Widget var0, int var1, int var2, int var3) {
      class217 var4 = var0.method4183(false);
      if(var4 != null) {
         if(Client.field1085 < 3) {
            class3.compass.method5289(var1, var2, var4.field2683, var4.field2680, 25, 25, Client.mapAngle, 256, var4.field2681, var4.field2682);
         } else {
            Rasterizer2D.method5165(var1, var2, 0, var4.field2681, var4.field2682);
         }

      }
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-800060248"
   )
   public static boolean method687() {
      return Client.rights >= 2;
   }
}
