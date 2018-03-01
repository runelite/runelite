import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class167 {
   @ObfuscatedName("e")
   public static File field2197;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2143917311
   )
   @Export("idxCount")
   public static int idxCount;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("randomDat")
   public static CacheFile randomDat;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("dat2File")
   public static CacheFile dat2File;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("idx255File")
   public static CacheFile idx255File;
   @ObfuscatedName("v")
   @Export("cacheLocations")
   public static String[] cacheLocations;
   @ObfuscatedName("f")
   public static String[] field2194;
   @ObfuscatedName("j")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   @Export("fonts")
   static Fonts fonts;

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgy;Lhd;I)Lhd;",
      garbageValue = "-943309091"
   )
   @Export("readStringIntParameters")
   static final IterableHashTable readStringIntParameters(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = BoundingBox3DDrawMode.nextPowerOfTwo(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "-2128409760"
   )
   static char method3311(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }
}
