import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ag")
@Implements("WorldMapManager")
public final class WorldMapManager {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "[Ldk;"
   )
   @Export("idxFiles")
   public static CacheFile[] idxFiles;
   @ObfuscatedName("t")
   @Export("loaded")
   boolean loaded;
   @ObfuscatedName("q")
   @Export("loading")
   boolean loading;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   class45 field541;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   SpritePixels field532;
   @ObfuscatedName("l")
   HashMap field536;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[[Lau;"
   )
   @Export("mapRegions")
   WorldMapRegion[][] mapRegions;
   @ObfuscatedName("e")
   HashMap field534;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Llk;"
   )
   IndexedSprite[] field528;
   @ObfuscatedName("p")
   @Export("mapFonts")
   final HashMap mapFonts;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1212374093
   )
   int field530;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1886213015
   )
   int field538;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -437477295
   )
   int field539;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1641144197
   )
   int field537;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1810530443
   )
   public int field531;

   @ObfuscatedSignature(
      signature = "([Llk;Ljava/util/HashMap;)V"
   )
   public WorldMapManager(IndexedSprite[] var1, HashMap var2) {
      this.loaded = false;
      this.loading = false;
      this.field534 = new HashMap();
      this.field531 = 0;
      this.field528 = var1;
      this.mapFonts = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljava/lang/String;ZI)V",
      garbageValue = "779188808"
   )
   @Export("load")
   public void load(IndexDataBase var1, String var2, boolean var3) {
      if(!this.loading) {
         this.loaded = false;
         this.loading = true;
         System.nanoTime();
         int var4 = var1.getFile(MapCacheArchiveNames.DETAILS.name);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.takeRecordByNames(MapCacheArchiveNames.DETAILS.name, var2));
         Buffer var7 = new Buffer(var1.takeRecordByNames(MapCacheArchiveNames.COMPOSITE_MAP.name, var2));
         Buffer var8 = new Buffer(var1.takeRecordByNames(var2, MapCacheArchiveNames.AREA.name));
         System.nanoTime();
         System.nanoTime();
         this.field541 = new class45();

         try {
            this.field541.method682(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var24) {
            return;
         }

         this.field541.method307();
         this.field541.method308();
         this.field541.method309();
         this.field530 = this.field541.getMinX() * 64;
         this.field538 = this.field541.getMinY() * 64;
         this.field539 = (this.field541.method304() - this.field541.getMinX() + 1) * 64;
         this.field537 = (this.field541.method306() - this.field541.getMinY() + 1) * 64;
         int var18 = this.field541.method304() - this.field541.getMinX() + 1;
         int var10 = this.field541.method306() - this.field541.getMinY() + 1;
         System.nanoTime();
         System.nanoTime();
         WorldMapRegion.field457.method3956();
         WorldMapRegion.field462.method3956();
         this.mapRegions = new WorldMapRegion[var18][var10];
         Iterator var11 = this.field541.field556.iterator();

         int var14;
         int var15;
         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field379;
            var14 = var12.field378;
            var15 = var13 - this.field541.getMinX();
            int var16 = var14 - this.field541.getMinY();
            this.mapRegions[var15][var16] = new WorldMapRegion(var13, var14, this.field541.method302(), this.mapFonts);
            this.mapRegions[var15][var16].method463(var12, this.field541.field554);
         }

         for(int var19 = 0; var19 < var18; ++var19) {
            for(int var20 = 0; var20 < var10; ++var20) {
               if(this.mapRegions[var19][var20] == null) {
                  this.mapRegions[var19][var20] = new WorldMapRegion(this.field541.getMinX() + var19, this.field541.getMinY() + var20, this.field541.method302(), this.mapFonts);
                  this.mapRegions[var19][var20].method451(this.field541.field555, this.field541.field554);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4584(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, var2)) {
            byte[] var27 = var1.takeRecordByNames(MapCacheArchiveNames.COMPOSITE_TEXTURE.name, var2);
            BufferedImage var21 = null;

            SpritePixels var28;
            label49: {
               try {
                  var21 = ImageIO.read(new ByteArrayInputStream(var27));
                  var14 = var21.getWidth();
                  var15 = var21.getHeight();
                  int[] var22 = new int[var15 * var14];
                  PixelGrabber var17 = new PixelGrabber(var21, 0, 0, var14, var15, var22, 0, var14);
                  var17.grabPixels();
                  var28 = new SpritePixels(var22, var14, var15);
                  break label49;
               } catch (IOException var25) {
                  ;
               } catch (InterruptedException var26) {
                  ;
               }

               var28 = new SpritePixels(0, 0);
            }

            this.field532 = var28;
         }

         System.nanoTime();
         var1.method4636();
         var1.reset();
         this.loaded = true;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "34"
   )
   public final void method630() {
      this.field536 = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1013174712"
   )
   @Export("drawMapRegion")
   public final void drawMapRegion(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      WorldMapRectangle var13 = this.getRegionRectForViewport(var1, var2, var3, var4);
      float var14 = this.method607(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      this.field531 = var15;
      if(!this.field534.containsKey(Integer.valueOf(var15))) {
         class47 var16 = new class47(var15);
         var16.method722();
         this.field534.put(Integer.valueOf(var15), var16);
      }

      WorldMapRegion[] var22 = new WorldMapRegion[8];

      int var17;
      int var18;
      for(var17 = var13.worldMapRegionX; var17 < var13.worldMapRegionWidth + var13.worldMapRegionX; ++var17) {
         for(var18 = var13.worldMapRegionY; var18 < var13.worldMapRegionHeight + var13.worldMapRegionY; ++var18) {
            this.method600(var17, var18, var22);
            this.mapRegions[var17][var18].method388(var15, (class47)this.field534.get(Integer.valueOf(var15)), var22, this.field528);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field530 + var1;
      int var19 = var2 + this.field538;

      for(int var20 = var13.worldMapRegionX; var20 < var13.worldMapRegionX + var13.worldMapRegionWidth; ++var20) {
         for(int var21 = var13.worldMapRegionY; var21 < var13.worldMapRegionY + var13.worldMapRegionHeight; ++var21) {
            this.mapRegions[var20][var21].method443(var5 + var17 * (this.mapRegions[var20][var21].field459 * 64 - var18) / 64, var8 - var17 * (this.mapRegions[var20][var21].field460 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "901712788"
   )
   @Export("drawMapIcons")
   public final void drawMapIcons(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      WorldMapRectangle var14 = this.getRegionRectForViewport(var1, var2, var3, var4);
      float var15 = this.method607(var7 - var5, var3 - var1);
      int var16 = (int)(64.0F * var15);
      int var17 = this.field530 + var1;
      int var18 = var2 + this.field538;

      int var19;
      int var20;
      for(var19 = var14.worldMapRegionX; var19 < var14.worldMapRegionX + var14.worldMapRegionWidth; ++var19) {
         for(var20 = var14.worldMapRegionY; var20 < var14.worldMapRegionHeight + var14.worldMapRegionY; ++var20) {
            if(var13) {
               this.mapRegions[var19][var20].method439();
            }

            this.mapRegions[var19][var20].method393(var5 + var16 * (this.mapRegions[var19][var20].field459 * 64 - var17) / 64, var8 - var16 * (this.mapRegions[var19][var20].field460 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.worldMapRegionX; var19 < var14.worldMapRegionX + var14.worldMapRegionWidth; ++var19) {
            for(var20 = var14.worldMapRegionY; var20 < var14.worldMapRegionY + var14.worldMapRegionHeight; ++var20) {
               this.mapRegions[var19][var20].drawFlashingMapIcons(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II[Lau;B)V",
      garbageValue = "1"
   )
   void method600(int var1, int var2, WorldMapRegion[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.mapRegions.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.mapRegions[0].length - 1;
      if(var7) {
         var3[class254.field3326.rsOrdinal()] = null;
      } else {
         var3[class254.field3326.rsOrdinal()] = this.mapRegions[var1][var2 + 1];
      }

      var3[class254.field3320.rsOrdinal()] = !var7 && !var5?this.mapRegions[var1 + 1][var2 + 1]:null;
      var3[class254.field3327.rsOrdinal()] = !var7 && !var4?this.mapRegions[var1 - 1][var2 + 1]:null;
      var3[class254.field3321.rsOrdinal()] = var5?null:this.mapRegions[var1 + 1][var2];
      var3[class254.field3325.rsOrdinal()] = var4?null:this.mapRegions[var1 - 1][var2];
      var3[class254.field3323.rsOrdinal()] = var6?null:this.mapRegions[var1][var2 - 1];
      var3[class254.field3322.rsOrdinal()] = !var6 && !var5?this.mapRegions[var1 + 1][var2 - 1]:null;
      var3[class254.field3319.rsOrdinal()] = !var6 && !var4?this.mapRegions[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "468403314"
   )
   public void method617(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field532 != null) {
         this.field532.method5844(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field536 == null) {
               this.method606();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field536.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  MapIcon var12 = (MapIcon)var11.next();
                  int var13 = var3 * (var12.field510.worldX - this.field530) / this.field539;
                  int var14 = var4 - (var12.field510.worldY - this.field538) * var4 / this.field537;
                  Rasterizer2D.method5720(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "-1222993615"
   )
   public List method615(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.loaded) {
         return var11;
      } else {
         WorldMapRectangle var12 = this.getRegionRectForViewport(var1, var2, var3, var4);
         float var13 = this.method607(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field530 + var1;
         int var16 = var2 + this.field538;

         for(int var17 = var12.worldMapRegionX; var17 < var12.worldMapRegionX + var12.worldMapRegionWidth; ++var17) {
            for(int var18 = var12.worldMapRegionY; var18 < var12.worldMapRegionY + var12.worldMapRegionHeight; ++var18) {
               List var19 = this.mapRegions[var17][var18].method422(var5 + var14 * (this.mapRegions[var17][var18].field459 * 64 - var15) / 64, var8 + var6 - var14 * (this.mapRegions[var17][var18].field460 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)Laj;",
      garbageValue = "1774609620"
   )
   @Export("getRegionRectForViewport")
   WorldMapRectangle getRegionRectForViewport(int var1, int var2, int var3, int var4) {
      WorldMapRectangle var5 = new WorldMapRectangle(this);
      int var6 = this.field530 + var1;
      int var7 = var2 + this.field538;
      int var8 = var3 + this.field530;
      int var9 = var4 + this.field538;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.worldMapRegionWidth = var12 - var10 + 1;
      var5.worldMapRegionHeight = var13 - var11 + 1;
      var5.worldMapRegionX = var10 - this.field541.getMinX();
      var5.worldMapRegionY = var11 - this.field541.getMinY();
      if(var5.worldMapRegionX < 0) {
         var5.worldMapRegionWidth += var5.worldMapRegionX;
         var5.worldMapRegionX = 0;
      }

      if(var5.worldMapRegionX > this.mapRegions.length - var5.worldMapRegionWidth) {
         var5.worldMapRegionWidth = this.mapRegions.length - var5.worldMapRegionX;
      }

      if(var5.worldMapRegionY < 0) {
         var5.worldMapRegionHeight += var5.worldMapRegionY;
         var5.worldMapRegionY = 0;
      }

      if(var5.worldMapRegionY > this.mapRegions[0].length - var5.worldMapRegionHeight) {
         var5.worldMapRegionHeight = this.mapRegions[0].length - var5.worldMapRegionY;
      }

      var5.worldMapRegionWidth = Math.min(var5.worldMapRegionWidth, this.mapRegions.length);
      var5.worldMapRegionHeight = Math.min(var5.worldMapRegionHeight, this.mapRegions[0].length);
      return var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-37"
   )
   public boolean method604() {
      return this.loaded;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "-1838539504"
   )
   public HashMap method597() {
      this.method606();
      return this.field536;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1000904436"
   )
   void method606() {
      if(this.field536 == null) {
         this.field536 = new HashMap();
      }

      this.field536.clear();

      for(int var1 = 0; var1 < this.mapRegions.length; ++var1) {
         for(int var2 = 0; var2 < this.mapRegions[var1].length; ++var2) {
            List var3 = this.mapRegions[var1][var2].method427();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               MapIcon var5 = (MapIcon)var4.next();
               if(!this.field536.containsKey(Integer.valueOf(var5.areaId))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field536.put(Integer.valueOf(var5.areaId), var6);
               } else {
                  List var7 = (List)this.field536.get(Integer.valueOf(var5.areaId));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "1027609179"
   )
   float method607(int var1, int var2) {
      float var3 = (float)var1 / (float)var2;
      if(var3 > 8.0F) {
         return 8.0F;
      } else if(var3 < 1.0F) {
         return 1.0F;
      } else {
         int var4 = Math.round(var3);
         return Math.abs((float)var4 - var3) < 0.05F?(float)var4:var3;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgz;B)V",
      garbageValue = "-27"
   )
   @Export("encodeClassVerifier")
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class326.classInfos.last();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3946);

         for(int var3 = 0; var3 < var1.count; ++var3) {
            if(var1.errorIdentifiers[var3] != 0) {
               var0.putByte(var1.errorIdentifiers[var3]);
            } else {
               try {
                  int var4 = var1.type[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.putByte(0);
                     var0.putInt(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3951[var3]);
                     var0.putByte(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.putByte(0);
                     var0.putInt(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.putByte(0);
                        var0.putInt(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = Reflection.invoke(var25, (Object)null, var7);
                     if(var11 == null) {
                        var0.putByte(0);
                     } else if(var11 instanceof Number) {
                        var0.putByte(1);
                        var0.putLong(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.putByte(2);
                        var0.putString((String)var11);
                     } else {
                        var0.putByte(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.putByte(-10);
               } catch (InvalidClassException var14) {
                  var0.putByte(-11);
               } catch (StreamCorruptedException var15) {
                  var0.putByte(-12);
               } catch (OptionalDataException var16) {
                  var0.putByte(-13);
               } catch (IllegalAccessException var17) {
                  var0.putByte(-14);
               } catch (IllegalArgumentException var18) {
                  var0.putByte(-15);
               } catch (InvocationTargetException var19) {
                  var0.putByte(-16);
               } catch (SecurityException var20) {
                  var0.putByte(-17);
               } catch (IOException var21) {
                  var0.putByte(-18);
               } catch (NullPointerException var22) {
                  var0.putByte(-19);
               } catch (Exception var23) {
                  var0.putByte(-20);
               } catch (Throwable var24) {
                  var0.putByte(-21);
               }
            }
         }

         var0.putCrc(var2);
         var1.unlink();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgz;I)I",
      garbageValue = "-4359117"
   )
   static int method645(PacketBuffer var0) {
      int var1 = var0.getBits(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.getBits(5);
      } else if(var1 == 2) {
         var2 = var0.getBits(8);
      } else {
         var2 = var0.getBits(11);
      }

      return var2;
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1450028285"
   )
   static boolean method643() {
      return Client.field877;
   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      signature = "(Lig;I)Z",
      garbageValue = "1374260283"
   )
   static final boolean method644(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field1036 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1109.method4423(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1109.method4415(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1109.method4414(false);
         }

         if(var1 == 325) {
            Client.field1109.method4414(true);
         }

         if(var1 == 326) {
            PacketNode var4 = class33.method382(ClientPacket.field2387, Client.field1072.field1456);
            Client.field1109.method4417(var4.packetBuffer);
            Client.field1072.method2073(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
