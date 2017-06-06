import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("o")
   LinkedList field452;
   @ObfuscatedName("c")
   String field453;
   @ObfuscatedName("e")
   String field454;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -753307361
   )
   int field455;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1467293033
   )
   int field456;
   @ObfuscatedName("y")
   Coordinates field457;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1665081655
   )
   int field458;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1853852365
   )
   int field461;
   @ObfuscatedName("a")
   boolean field462;
   @ObfuscatedName("lm")
   @ObfuscatedGetter(
      intValue = -460931201
   )
   static int field463;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -198796183
   )
   static int field464;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1396933553
   )
   int field465;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1682426367
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1436908903
   )
   int field467;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-229524796"
   )
   public static File method265(String var0) {
      if(!class157.field2281) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class157.field2279.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class157.field2278, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class157.field2279.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1062395476"
   )
   public boolean method267(int var1, int var2, int var3) {
      Iterator var4 = this.field452.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod696(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1858205219"
   )
   public static int method268() {
      return class50.keyboardIdleTicks;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "-46"
   )
   public int[] method269(int var1, int var2, int var3) {
      Iterator var4 = this.field452.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod696(var1, var2, var3));

      return var5.vmethod698(var1, var2, var3);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "-1408215767"
   )
   public Coordinates method270(int var1, int var2) {
      Iterator var3 = this.field452.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod707(var1, var2));

      return var4.vmethod699(var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "109"
   )
   void method271() {
      Iterator var1 = this.field452.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod695(this);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)LWorldMapSectionBase;",
      garbageValue = "194379593"
   )
   WorldMapSectionBase method272(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27[] var3 = new class27[]{class27.field402, class27.field394, class27.field405, class27.field395};
      class27 var4 = (class27)Item.method1751(var3, var2);
      Object var5 = null;
      switch(var4.field393) {
      case 0:
         var5 = new WorldMapType0();
         break;
      case 1:
         var5 = new WorldMapType2();
         break;
      case 2:
         var5 = new WorldMapType1();
         break;
      case 3:
         var5 = new WorldMapType3();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var5).vmethod700(var1);
      return (WorldMapSectionBase)var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1188247745"
   )
   public boolean method273() {
      return this.field462;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1930601925"
   )
   public String method274() {
      return this.field453;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-110"
   )
   public String method275() {
      return this.field454;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1677716940"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field453 = var1.readString();
      this.field454 = var1.readString();
      this.field457 = new Coordinates(var1.readInt());
      this.field455 = var1.readInt();
      var1.readUnsignedByte();
      this.field462 = var1.readUnsignedByte() == 1;
      this.field467 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field452 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field452.add(this.method272(var1));
      }

      this.method271();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-774072646"
   )
   public int method277() {
      return this.fileId;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1245014974"
   )
   public int method278() {
      return this.field457.plane;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1940591994"
   )
   public int method279() {
      return this.field465;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method280() {
      return this.field456;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "756301782"
   )
   public int method281() {
      return this.field461;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-657068457"
   )
   public int method282() {
      return this.field457.worldX;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "21"
   )
   public int method284() {
      return this.field457.worldY;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)LCoordinates;",
      garbageValue = "-939839020"
   )
   public Coordinates method285() {
      return new Coordinates(this.field457);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "19"
   )
   public boolean method287(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field458 && var3 <= this.field465) {
         if(var4 >= this.field456 && var4 <= this.field461) {
            Iterator var5 = this.field452.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod707(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "122"
   )
   int method297() {
      return this.field455;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1928854208"
   )
   public int method303() {
      return this.field458;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "1981286304"
   )
   static final int method327(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.putByte(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.putInt(var6[0]);
      var4.putInt(var6[1]);
      var4.putLong(var0);
      var4.putLong(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.putInt(var3.nextInt());
      }

      var4.method3244(class87.field1403, class87.field1400);
      var5.putByte(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.putInt(var3.nextInt());
      }

      var5.putLong(var3.nextLong());
      var5.method3130(var3.nextLong());
      class28.method223(var5);
      var5.putLong(var3.nextLong());
      var5.method3244(class87.field1403, class87.field1400);
      var7 = class5.method11(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.method3150(var2);
      var8.offset = var7;
      var8.encryptXtea2(var6);
      Buffer var9 = new Buffer(var5.offset + var4.offset + 5 + var8.offset);
      var9.putByte(2);
      var9.putByte(var4.offset);
      var9.putBytes(var4.payload, 0, var4.offset);
      var9.putByte(var5.offset);
      var9.putBytes(var5.payload, 0, var5.offset);
      var9.putShort(var8.offset);
      var9.putBytes(var8.payload, 0, var8.offset);
      String var10 = class50.method751(var9.payload);

      try {
         URL var11 = new URL(class60.method1007("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class19.method132(var10) + "&dest=" + class19.method132("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            int var15 = var14.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var15 == -1) {
               var13.close();
               var14.close();
               String var18 = new String(var9.payload);
               if(var18.startsWith("OFFLINE")) {
                  return 4;
               } else if(var18.startsWith("WRONG")) {
                  return 7;
               } else if(var18.startsWith("RELOAD")) {
                  return 3;
               } else if(var18.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.decryptXtea(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var18 = new String(var9.payload, 0, var9.offset);
                  boolean var16;
                  if(var18 == null) {
                     var16 = false;
                  } else {
                     label110: {
                        try {
                           new URL(var18);
                        } catch (MalformedURLException var20) {
                           var16 = false;
                           break label110;
                        }

                        var16 = true;
                     }
                  }

                  if(!var16) {
                     return 5;
                  } else {
                     if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                        try {
                           Desktop.getDesktop().browse(new URI(var18));
                           return 2;
                        } catch (Exception var19) {
                           ;
                        }
                     }

                     if(class56.field690.startsWith("win")) {
                        class40.method534(var18, 0, "openjs");
                     } else if(class56.field690.startsWith("mac")) {
                        class40.method534(var18, 1, "openjs");
                     } else {
                        class40.method534(var18, 2, "openjs");
                     }

                     return 2;
                  }
               }
            }

            var9.offset += var15;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var21) {
         var21.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1200313459"
   )
   public int method333() {
      return this.field467;
   }

   public WorldMapData() {
      this.fileId = -1;
      this.field455 = -1;
      this.field467 = -1;
      this.field457 = null;
      this.field458 = Integer.MAX_VALUE;
      this.field465 = 0;
      this.field456 = Integer.MAX_VALUE;
      this.field461 = 0;
      this.field462 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1108889964"
   )
   static String method337(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
