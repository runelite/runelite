import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public class class92 {
   @ObfuscatedName("o")
   static byte[] field1372;
   @ObfuscatedName("p")
   static byte[] field1378;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Lgn;"
   )
   static Buffer[] field1374;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2069777345
   )
   @Export("playerIndexesCount")
   static int playerIndexesCount;
   @ObfuscatedName("l")
   @Export("playerIndices")
   static int[] playerIndices;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -779761021
   )
   static int field1377;
   @ObfuscatedName("g")
   static int[] field1383;
   @ObfuscatedName("c")
   @Export("Players_regions")
   static int[] Players_regions;
   @ObfuscatedName("u")
   @Export("Players_orientations")
   static int[] Players_orientations;
   @ObfuscatedName("r")
   @Export("Players_targetIndices")
   static int[] Players_targetIndices;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -951802553
   )
   static int field1382;
   @ObfuscatedName("v")
   static int[] field1370;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   static Buffer field1384;

   static {
      field1372 = new byte[2048];
      field1378 = new byte[2048];
      field1374 = new Buffer[2048];
      playerIndexesCount = 0;
      playerIndices = new int[2048];
      field1377 = 0;
      field1383 = new int[2048];
      Players_regions = new int[2048];
      Players_orientations = new int[2048];
      Players_targetIndices = new int[2048];
      field1382 = 0;
      field1370 = new int[2048];
      field1384 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BS)Ljava/lang/String;",
      garbageValue = "13023"
   )
   public static String method1936(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class303.field3799[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class303.field3799[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class303.field3799[(var6 & 15) << 2 | var7 >>> 6]).append(class303.field3799[var7 & 63]);
            } else {
               var3.append(class303.field3799[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class303.field3799[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lbs;Lbs;IZB)I",
      garbageValue = "-115"
   )
   static int method1926(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1663()?(var1.method1663()?0:1):(var1.method1663()?-1:0)):(var2 == 5?(var0.method1675()?(var1.method1675()?0:1):(var1.method1675()?-1:0)):(var2 == 6?(var0.method1645()?(var1.method1645()?0:1):(var1.method1645()?-1:0)):(var2 == 7?(var0.method1643()?(var1.method1643()?0:1):(var1.method1643()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "([Lim;IIIZI)V",
      garbageValue = "-1693396739"
   )
   static void method1939(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class227.method4318(var6, var2, var3, var4);
            WorldComparator.method55(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               GrandExchangeOffer.method119(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(Lim;IIII)V",
      garbageValue = "1782643369"
   )
   static final void method1940(Widget var0, int var1, int var2, int var3) {
      class230 var4 = var0.method4429(false);
      if(var4 != null) {
         if(Client.field834 < 3) {
            UnitPriceComparator.compass.method5821(var1, var2, var4.field2732, var4.field2730, 25, 25, Client.mapAngle, 256, var4.field2733, var4.field2731);
         } else {
            Rasterizer2D.method5689(var1, var2, 0, var4.field2733, var4.field2731);
         }

      }
   }
}
